package com.veryfit.multi.ui.fragment.main;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.Goal;
import com.project.library.device.cmd.health.HealthDataDetailsCache;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.camera.GsonUtil;
import com.veryfit.multi.model.Bracelet;
import com.veryfit.multi.model.BraceletData;
import com.veryfit.multi.model.BtData;
import com.veryfit.multi.model.BtPara;
import com.veryfit.multi.model.BtTarget;
import com.veryfit.multi.model.Device;
import com.veryfit.multi.net.AVolleyResponse;
import com.veryfit.multi.net.ErrorCodeMap;
import com.veryfit.multi.net.GsonRequest;
import com.veryfit.multi.net.ResponseEntity;
import com.veryfit.multi.net.VolleyUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.LoginActivity;
import com.veryfit.multi.ui.activity.MainActivity;
import com.veryfit.multi.ui.activity.mine.SysSettingsActivity;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.DipAndPxTrans;
import com.veryfit.multi.util.NetUtils;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.CircleImageView;
import com.veryfit.multi.view.CustomRadioGroup;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnDialogClickListener;
import com.veryfit.multi.view.group.ItemToggleLayout;
import com.veryfit.multi.view.group.ItemToggleLayout.OnToggleListener;
import com.veryfit.multi.view.group.MyItemLabelValue;
import com.veryfit.multi.vo.UserInfo;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class UserFragment
  extends BaseFragment
  implements View.OnClickListener, ItemToggleLayout.OnToggleListener
{
  private static final String AUTH_PENDING = "auth_state_pending";
  private static final int REQUEST_OAUTH = 1;
  private static final String TAG = "UserFragment";
  private boolean authInProgress = false;
  DataSet calorieDataSet;
  private HealthDataDetailsCache detailCache = HealthDataDetailsCache.getInstance();
  private Dialog dialog;
  DataSet distanceDataSet;
  private GsonRequest<ResponseEntity> downloadRequest;
  DataSet heightDataSet;
  private UserInfo info = new UserInfo();
  private boolean isPrepared = false;
  private CircleImageView iv_header;
  private ImageView iv_mine_header;
  private MainActivity mActivity;
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  public GoogleApiClient mClient = null;
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private ItemToggleLayout mGooglefit;
  private ProgressDialog mProgress;
  private View mRootView = null;
  private GsonRequest<ResponseEntity> personInforequest;
  private String photoFile;
  private PopupWindow popupDown;
  private PopupWindow popupMenu;
  private PopupWindow popupWindow;
  DataSet rateDataSet;
  private Resources res;
  private RelativeLayout rl_mine;
  private GsonRequest<ResponseEntity> sendBtDatarequest;
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  DataSet stepDataSet;
  private MyItemLabelValue sysRestart;
  private TextView tv_data_backup;
  private TextView tv_exit_login;
  private TextView tv_immediate_databackup;
  private TextView tv_userName;
  DataSet weightDataSet;
  
  private void backupData()
  {
    if (!this.mCore.isDeviceConnected())
    {
      Util.showToast(getActivity(), 2131296616, 0);
      return;
    }
    if (this.mActivity.isHealthDataSyncing())
    {
      Util.showToast(getActivity(), 2131296676, 0);
      return;
    }
    LibSharedPreferences.getInstance().setSyncData(false);
    DebugLog.e("=====开始上传个人资料及目标===");
    showProgress(this.res.getString(2131296721));
    final long l = System.currentTimeMillis();
    this.personInforequest = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/bracelet/insertBraceletData", "URL_INSERT_BRACELET", ResponseEntity.class, GsonUtil.obj2JsonString(getBraceletData()), new AVolleyResponse(getActivity())
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        UserFragment.this.hideProgress();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.personInforequest.getErrorCode());
        }
        Toast.makeText(UserFragment.this.getActivity(), paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        if (UserFragment.this.personInforequest.getState() != 0)
        {
          UserFragment.this.hideProgress();
          Toast.makeText(UserFragment.this.getActivity(), ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.personInforequest.getErrorCode()), 0).show();
          return;
        }
        final long l = System.currentTimeMillis();
        DebugLog.e("个人资料及目标数据上传成功, 所花时间：" + (l - l));
        DebugLog.e("=====开始上传手环数据===");
        UserFragment.this.sendBtDatarequest = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/bracelet/insertData", "URL_SYNC_INSERTDATA", ResponseEntity.class, GsonUtil.obj2JsonString(UserFragment.this.getBtData()), new AVolleyResponse(UserFragment.this.getActivity())
        {
          public void onError(VolleyError paramAnonymous2VolleyError, String paramAnonymous2String)
          {
            UserFragment.this.hideProgress();
            paramAnonymous2VolleyError = paramAnonymous2String;
            if (paramAnonymous2String == null) {
              paramAnonymous2VolleyError = ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.sendBtDatarequest.getErrorCode());
            }
            Toast.makeText(UserFragment.this.getActivity(), paramAnonymous2VolleyError, 0).show();
          }
          
          public void onSuccess(ResponseEntity paramAnonymous2ResponseEntity)
          {
            UserFragment.this.hideProgress();
            if (UserFragment.this.sendBtDatarequest.getState() != 0)
            {
              Toast.makeText(UserFragment.this.getActivity(), ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.sendBtDatarequest.getErrorCode()), 0).show();
              return;
            }
            long l = System.currentTimeMillis();
            DebugLog.e("手环数据上传成功, 所花时间：" + (l - l));
            DebugLog.e("数据备份所花总时间：" + (l - this.val$startTime));
            Toast.makeText(UserFragment.this.getActivity(), UserFragment.this.res.getString(2131296733), 0).show();
            UserFragment.this.mAppSharedPreferences.setDataBackupTime(Util.getStrCurrDateWithSign(Calendar.getInstance()));
            UserFragment.this.initPreDataTime();
          }
        });
      }
    });
  }
  
  private void buildFitnessClient()
  {
    this.mClient = new GoogleApiClient.Builder(getActivity()).addApi(Fitness.SENSORS_API).addApi(Fitness.CONFIG_API).addApi(Fitness.RECORDING_API).addApi(Fitness.HISTORY_API).addScope(new Scope("https://www.googleapis.com/auth/fitness.activity.write")).addScope(new Scope("https://www.googleapis.com/auth/fitness.body.write")).addScope(new Scope("https://www.googleapis.com/auth/fitness.location.write")).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        Log.i("UserFragment", "Connected!!!");
        UserFragment.this.subscriptionData();
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 2) {
          Log.i("UserFragment", "Connection lost.  Cause: Network Lost.");
        }
        while (paramAnonymousInt != 1) {
          return;
        }
        Log.i("UserFragment", "Connection lost.  Reason: Service Disconnected");
      }
    }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        Log.i("UserFragment", "Connection failed. Cause: " + paramAnonymousConnectionResult.toString());
        if (!paramAnonymousConnectionResult.hasResolution()) {}
        while (UserFragment.this.authInProgress) {
          return;
        }
        try
        {
          Log.i("UserFragment", "Attempting to resolve failed connection");
          UserFragment.this.authInProgress = true;
          paramAnonymousConnectionResult.startResolutionForResult(UserFragment.this.getActivity(), 1);
          return;
        }
        catch (IntentSender.SendIntentException paramAnonymousConnectionResult)
        {
          Log.e("UserFragment", "Exception while starting resolution activity", paramAnonymousConnectionResult);
        }
      }
    }).build();
    this.mClient.connect();
  }
  
  private void clearDetailCache()
  {
    this.detailCache.getSportMap().clear();
    this.detailCache.getSleepMap().clear();
    this.detailCache.getRateMap().clear();
    long l = LongDateUtil.Calendar2LongDate(Calendar.getInstance());
    this.detailCache.setMinDate(l);
  }
  
  private void dismissPopupDownMenu()
  {
    if ((this.popupDown != null) && (this.popupDown.isShowing())) {
      this.popupDown.dismiss();
    }
  }
  
  private void dismissPopupMenu()
  {
    if ((this.popupMenu != null) && (this.popupMenu.isShowing())) {
      this.popupMenu.dismiss();
    }
  }
  
  private void downloadData()
  {
    if (!this.mCore.isDeviceConnected())
    {
      Util.showToast(getActivity(), 2131296616, 0);
      return;
    }
    if (this.mActivity.isHealthDataSyncing())
    {
      Util.showToast(getActivity(), 2131296676, 0);
      return;
    }
    LibSharedPreferences.getInstance().setSyncData(false);
    final long l = System.currentTimeMillis();
    DebugLog.e("=====开始下载手环数据===");
    showProgress(this.res.getString(2131296722));
    BtPara localBtPara = new BtPara();
    localBtPara.setMac(this.mAppSharedPreferences.getBindDeviceAddr());
    localBtPara.setUserName(this.mAppSharedPreferences.getLoginName());
    localBtPara.setEndDate(Long.valueOf(Util.getLongCurrDate()));
    this.downloadRequest = VolleyUtil.getInstance().loadPostGson("http://192.168.2.29:8081/ido/bracelet/getData", "URL_SYNC_GETDATA", ResponseEntity.class, GsonUtil.obj2JsonString(localBtPara), new AVolleyResponse(getActivity())
    {
      public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString)
      {
        UserFragment.this.hideProgress();
        paramAnonymousVolleyError = paramAnonymousString;
        if (paramAnonymousString == null) {
          paramAnonymousVolleyError = ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.downloadRequest.getErrorCode());
        }
        Toast.makeText(UserFragment.this.getActivity(), paramAnonymousVolleyError, 0).show();
      }
      
      public void onSuccess(ResponseEntity paramAnonymousResponseEntity)
      {
        if (UserFragment.this.downloadRequest.getState() != 0)
        {
          UserFragment.this.hideProgress();
          Toast.makeText(UserFragment.this.getActivity(), ErrorCodeMap.getErrorMsg(UserFragment.this.mActivity, UserFragment.this.downloadRequest.getErrorCode()), 0).show();
          return;
        }
        long l = System.currentTimeMillis();
        DebugLog.e("下载手环数据成功, 所花时间：" + (l - l));
        UserFragment.this.insertDataToDB(GsonUtil.obj2JsonString(paramAnonymousResponseEntity.getData()));
        UserFragment.this.detailCache.loadData();
        UserFragment.this.mActivity.OnHealthDataChangedX();
        UserFragment.this.hideProgress();
        Toast.makeText(UserFragment.this.getActivity(), UserFragment.this.res.getString(2131296732), 0).show();
      }
    });
  }
  
  private SpannableString getBoldValue(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = paramString.indexOf("\n");
    localSpannableString.setSpan(new StyleSpan(1), 0, i, 33);
    return localSpannableString;
  }
  
  private BraceletData getBraceletData()
  {
    Device localDevice = new Device();
    localDevice.setDtype(Integer.valueOf(0));
    localDevice.setMac(this.mAppSharedPreferences.getBindDeviceAddr());
    Bracelet localBracelet = new Bracelet();
    localBracelet.setWearerName(this.info.name);
    localBracelet.setBirthday(this.info.year + "-" + this.info.month + "-" + this.info.day);
    localBracelet.setSex(this.info.gender);
    localBracelet.setHeight(this.info.height);
    localBracelet.setWeight(this.info.weight);
    localBracelet.setMac(this.mAppSharedPreferences.getBindDeviceAddr());
    List localList = TempUtil.getGoalData(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    int i = 0;
    int j = localList.size();
    if (i >= j)
    {
      localObject = new BraceletData();
      ((BraceletData)localObject).setUserName(this.mAppSharedPreferences.getLoginName());
      ((BraceletData)localObject).setMac(this.mAppSharedPreferences.getBindDeviceAddr());
      ((BraceletData)localObject).setDevice(localDevice);
      ((BraceletData)localObject).setBracelet(localBracelet);
      ((BraceletData)localObject).setTargetList(localArrayList);
      return (BraceletData)localObject;
    }
    Goal localGoal = (Goal)localList.get(i);
    if (i % 2 == 0)
    {
      localObject = new BtTarget();
      ((BtTarget)localObject).setUserName(this.mAppSharedPreferences.getLoginName());
      ((BtTarget)localObject).setMac(this.mAppSharedPreferences.getBindDeviceAddr());
      ((BtTarget)localObject).setTdate(localGoal.getDate());
      ((BtTarget)localObject).setSleepTarget(localGoal.getGoal());
    }
    for (;;)
    {
      i += 1;
      break;
      ((BtTarget)localObject).setMoveTarget(localGoal.getGoal());
      localArrayList.add(localObject);
    }
  }
  
  private BtData getBtData()
  {
    BtData localBtData = new BtData();
    localBtData.setUserName(this.mAppSharedPreferences.getLoginName());
    localBtData.setMac(this.mAppSharedPreferences.getBindDeviceAddr());
    long l2 = Util.getLongDelayDate(-1);
    String str = this.mAppSharedPreferences.getDataBackupTime();
    long l1 = l2;
    if (!TextUtils.isEmpty(str))
    {
      str = Util.getApartDate(str, -1);
      l1 = l2;
      if (str != null) {
        l1 = Long.parseLong(str.replaceAll("-", ""));
      }
    }
    l2 = System.currentTimeMillis();
    localBtData.setBtSportDataDayList(TempUtil.getSportDataDayList(l1));
    localBtData.setBtSportDataItemList(TempUtil.getSportDataItemList(l1));
    localBtData.setBtSleepDataDayList(TempUtil.getSleepDataDayList(l1));
    localBtData.setBtSleepDataItemList(TempUtil.getSleepDataItemList(l1));
    localBtData.setBtHeartRateList(TempUtil.getHeartRateList(l1));
    localBtData.setBtHeartRateThresholdList(TempUtil.getHeartRateThresholdList(l1));
    localBtData.setBtHealthDataMaxList(TempUtil.getHealthDataMaxList());
    l1 = System.currentTimeMillis();
    DebugLog.e("获取数据库中所有手环数据所花时间：" + (l1 - l2));
    return localBtData;
  }
  
  private void getPopupWindow()
  {
    if (this.popupWindow != null)
    {
      this.popupWindow.dismiss();
      return;
    }
    initPopuptWindow();
  }
  
  private SpannableString getSizeValue(String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramString);
    int i = paramString.indexOf("\n");
    localSpannableString.setSpan(new RelativeSizeSpan(0.7F), i, paramString.length(), 33);
    return localSpannableString;
  }
  
  private void hideProgress()
  {
    if (this.mProgress != null)
    {
      this.mProgress.dismiss();
      this.mProgress = null;
    }
  }
  
  private void initDownPopupMenu()
  {
    View localView = View.inflate(getActivity(), 2130903120, null);
    localView.findViewById(2131231091).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserFragment.this.mAppSharedPreferences.setDeleteBtData(false);
        UserFragment.this.dismissPopupDownMenu();
        UserFragment.this.downloadData();
      }
    });
    localView.findViewById(2131231092).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserFragment.this.mAppSharedPreferences.setDeleteBtData(false);
        UserFragment.this.dismissPopupDownMenu();
      }
    });
    this.popupDown = new PopupWindow(localView, -1, -2, true);
    this.popupDown.setBackgroundDrawable(new ColorDrawable(0));
    this.popupDown.setAnimationStyle(2131427340);
    this.popupDown.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        UserFragment.this.backgroundAlpha(1.0F);
      }
    });
    this.popupDown.setOutsideTouchable(false);
    this.popupDown.update();
  }
  
  private void initPopupMenu()
  {
    View localView = View.inflate(getActivity(), 2130903121, null);
    localView.findViewById(2131231093).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserFragment.this.dismissPopupMenu();
        UserFragment.this.backupData();
      }
    });
    localView.findViewById(2131231094).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserFragment.this.dismissPopupMenu();
        if (!UserFragment.this.mCore.isDeviceConnected())
        {
          Util.showToast(UserFragment.this.getActivity(), 2131296616, 0);
          return;
        }
        if (UserFragment.this.mActivity.isHealthDataSyncing())
        {
          Util.showToast(UserFragment.this.getActivity(), 2131296676, 0);
          return;
        }
        UserFragment.this.mAppSharedPreferences.exitLogin();
        UserFragment.this.resetBackupLayout();
        UserFragment.this.clearDetailCache();
        UserFragment.this.mActivity.OnHealthDataChangedX();
      }
    });
    localView.findViewById(2131230862).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UserFragment.this.dismissPopupMenu();
      }
    });
    this.popupMenu = new PopupWindow(localView, -1, -2, true);
    this.popupMenu.setBackgroundDrawable(new ColorDrawable(0));
    this.popupMenu.setAnimationStyle(2131427340);
    this.popupMenu.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        UserFragment.this.backgroundAlpha(1.0F);
      }
    });
    this.popupMenu.setOutsideTouchable(false);
    this.popupMenu.update();
  }
  
  private void initPopuptWindow()
  {
    View localView = getActivity().getLayoutInflater().inflate(2130903115, null);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    this.iv_mine_header = ((ImageView)localView.findViewById(2131231081));
    Bitmap localBitmap = BitmapFactory.decodeFile(Constant.PIC_PATH + DialogUtil.photoPath);
    if (localBitmap != null) {
      this.iv_mine_header.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      this.popupWindow = new PopupWindow(localView, -1, -1);
      this.popupWindow.setFocusable(true);
      this.popupWindow.setAnimationStyle(2131427338);
      localView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((UserFragment.this.popupWindow != null) && (UserFragment.this.popupWindow.isShowing()))
          {
            UserFragment.this.popupWindow.dismiss();
            UserFragment.this.popupWindow = null;
          }
          return false;
        }
      });
      localView.setOnKeyListener(new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramAnonymousInt == 4)
          {
            UserFragment.this.popupWindow.dismiss();
            UserFragment.this.popupWindow = null;
            return true;
          }
          return false;
        }
      });
      return;
      this.iv_mine_header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
    }
  }
  
  private void initPreDataTime()
  {
    String str = this.res.getString(2131296681, new Object[] { this.mAppSharedPreferences.getDataBackupTime() });
    this.tv_immediate_databackup.setText(getSizeValue(str));
  }
  
  private void initView()
  {
    this.rl_mine = ((RelativeLayout)this.mRootView.findViewById(2131231006));
    this.iv_header = ((CircleImageView)this.mRootView.findViewById(2131230731));
    this.tv_userName = ((TextView)this.mRootView.findViewById(2131230836));
    this.tv_data_backup = ((TextView)this.mRootView.findViewById(2131231013));
    this.tv_immediate_databackup = ((TextView)this.mRootView.findViewById(2131231014));
    this.tv_exit_login = ((TextView)this.mRootView.findViewById(2131231015));
    this.mGooglefit = ((ItemToggleLayout)this.mRootView.findViewById(2131231011));
    this.mGooglefit.setOnToggleListener(this);
    if (this.share.getGoogleFit() == 1)
    {
      if (NetUtils.isConnected(getActivity())) {
        buildFitnessClient();
      }
      this.mGooglefit.setOpen(true);
    }
    for (;;)
    {
      this.iv_header.setOnClickListener(this);
      this.tv_data_backup.setOnClickListener(this);
      this.tv_immediate_databackup.setOnClickListener(this);
      this.tv_exit_login.setOnClickListener(this);
      this.sysRestart = ((MyItemLabelValue)this.mRootView.findViewById(2131231010));
      this.sysRestart.setOnClickListener(this);
      return;
      this.mGooglefit.setOpen(false);
    }
  }
  
  private void insertDataToDB(String paramString)
  {
    JsonElement localJsonElement = new JsonParser().parse(paramString);
    paramString = new BtData();
    if (!localJsonElement.isJsonNull()) {
      paramString = (BtData)this.downloadRequest.getGson().fromJson(localJsonElement, BtData.class);
    }
    long l1 = System.currentTimeMillis();
    TempUtil.insertHealthDataMax(paramString.getBtHealthDataMaxList());
    TempUtil.insertHeartRate(paramString.getBtHeartRateList());
    TempUtil.insertHeartRateThreshold(paramString.getBtHeartRateThresholdList());
    TempUtil.insertSleepDataDay(paramString.getBtSleepDataDayList());
    TempUtil.insertSleepDataItem(paramString.getBtSleepDataItemList());
    TempUtil.insertSportDataDay(paramString.getBtSportDataDayList());
    TempUtil.insertSportDataItem(paramString.getBtSportDataItemList());
    long l2 = System.currentTimeMillis();
    DebugLog.e("手环数据插入成功, 所花时间：" + (l2 - l1));
  }
  
  private void resetBackupLayout()
  {
    if (!this.mAppSharedPreferences.isLogined())
    {
      this.tv_data_backup.setVisibility(0);
      this.tv_immediate_databackup.setVisibility(8);
      this.tv_exit_login.setVisibility(8);
      return;
    }
    this.tv_data_backup.setVisibility(8);
    this.tv_immediate_databackup.setVisibility(0);
    this.tv_exit_login.setVisibility(0);
    initPreDataTime();
  }
  
  private void setGoogleFitToggle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mGooglefit.showProgressBar();
      this.share.setGoogleFit(1);
      buildFitnessClient();
      subscriptionData();
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Thread.sleep(1000L);
            UserFragment.this.getActivity().runOnUiThread(new Runnable()
            {
              public void run()
              {
                UserFragment.this.mGooglefit.cancelProgressBar();
              }
            });
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }).start();
      return;
    }
    this.mGooglefit.showProgressBar();
    this.share.setGoogleFit(0);
    if ((this.mClient != null) && (this.mClient.isConnected())) {
      unsubscribeData();
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(1000L);
          UserFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              UserFragment.this.mGooglefit.cancelProgressBar();
            }
          });
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }).start();
  }
  
  private void showDialog()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      return;
    }
    String str = getActivity().getResources().getString(2131296684);
    this.dialog = DialogUtil.showSugestDialog(getActivity(), getBoldValue(str), new DialogUtil.OnDialogClickListener()
    {
      public void onDialogCancel() {}
      
      public void onDialogShare()
      {
        UserFragment.this.startActivity(new Intent(UserFragment.this.getActivity(), LoginActivity.class));
      }
    });
  }
  
  private void showPopupDownMenu()
  {
    if ((this.popupDown != null) && (this.popupDown.isShowing()))
    {
      this.popupDown.dismiss();
      return;
    }
    this.popupDown.showAtLocation(this.rl_mine, 81, 0, DipAndPxTrans.dip2px(getActivity(), 10.0F));
    backgroundAlpha(0.5F);
  }
  
  private void showPopupMenu()
  {
    if ((this.popupMenu != null) && (this.popupMenu.isShowing()))
    {
      this.popupMenu.dismiss();
      return;
    }
    this.popupMenu.showAtLocation(this.rl_mine, 81, 0, DipAndPxTrans.dip2px(getActivity(), 10.0F));
    backgroundAlpha(0.5F);
  }
  
  private void showProgress(String paramString)
  {
    if (this.mProgress == null)
    {
      this.mProgress = new ProgressDialog(getActivity());
      this.mProgress.setProgressStyle(0);
      this.mProgress.setIndeterminate(true);
      this.mProgress.setCancelable(false);
    }
    this.mProgress.setMessage(paramString);
    this.mProgress.show();
  }
  
  private void subscribe(DataType paramDataType)
  {
    Fitness.RecordingApi.subscribe(this.mClient, paramDataType).setResultCallback(new ResultCallback()
    {
      public void onResult(Status paramAnonymousStatus)
      {
        if (paramAnonymousStatus.isSuccess())
        {
          if (paramAnonymousStatus.getStatusCode() == 60535)
          {
            Log.i("UserFragment", "Existing subscription for activity detected.");
            return;
          }
          Log.i("UserFragment", "rate1 Successfully subscribed!");
          return;
        }
        Log.i("UserFragment", "rate There was a problem subscribing.");
      }
    });
  }
  
  private void subscriptionData()
  {
    subscribe(DataType.TYPE_STEP_COUNT_DELTA);
    subscribe(DataType.TYPE_DISTANCE_DELTA);
    subscribe(DataType.TYPE_HEIGHT);
    subscribe(DataType.TYPE_WEIGHT);
    subscribe(DataType.TYPE_HEART_RATE_BPM);
    subscribe(DataType.TYPE_CALORIES_EXPENDED);
  }
  
  private void unsubscribe(DataType paramDataType)
  {
    Fitness.RecordingApi.unsubscribe(this.mClient, paramDataType).setResultCallback(new ResultCallback()
    {
      public void onResult(Status paramAnonymousStatus)
      {
        if (paramAnonymousStatus.isSuccess())
        {
          Log.i("UserFragment", "Successfully unsubscribed for data type: ");
          return;
        }
        Log.i("UserFragment", "Failed to unsubscribe for data type");
      }
    });
  }
  
  private void unsubscribeData()
  {
    unsubscribe(DataType.TYPE_STEP_COUNT_DELTA);
    unsubscribe(DataType.TYPE_DISTANCE_DELTA);
    unsubscribe(DataType.TYPE_HEIGHT);
    unsubscribe(DataType.TYPE_WEIGHT);
    unsubscribe(DataType.TYPE_HEART_RATE_BPM);
    unsubscribe(DataType.TYPE_CALORIES_EXPENDED);
  }
  
  public void backgroundAlpha(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getActivity().getWindow().setAttributes(localLayoutParams);
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    this.info.init();
    this.tv_userName.setText(this.info.name);
    if (!new File(Constant.PIC_PATH + DialogUtil.photoPath).exists())
    {
      this.iv_header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
      return;
    }
    Bitmap localBitmap = BitmapFactory.decodeFile(Constant.PIC_PATH + DialogUtil.photoPath);
    if (localBitmap != null)
    {
      this.iv_header.setImageBitmap(localBitmap);
      return;
    }
    this.iv_header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 123) {
        System.out.println("1111111111111");
      }
      paramIntent = DialogUtil.chooseFace(paramInt1, paramInt2, paramIntent, getActivity(), this);
      if (paramIntent != null)
      {
        this.photoFile = (Constant.PIC_PATH + DialogUtil.photoPath);
        this.iv_header.setImageBitmap(paramIntent);
      }
    }
    if (paramInt2 == 1)
    {
      ((MainActivity)getActivity()).onDeviceNeedInit();
      ((MainActivity)getActivity()).mTabGroup.check(2131231104);
      ((MainActivity)getActivity()).onCheckedChanged(((MainActivity)getActivity()).mTabGroup, 2131231104);
    }
    if (paramInt1 == 1)
    {
      this.authInProgress = false;
      if ((paramInt2 == -1) && (!this.mClient.isConnecting()) && (!this.mClient.isConnected())) {
        this.mClient.connect();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230731: 
      getPopupWindow();
      this.popupWindow.showAtLocation(paramView, 119, 0, 0);
      return;
    case 2131231013: 
      showDialog();
      return;
    case 2131231014: 
      backupData();
      return;
    case 2131231015: 
      if (this.popupMenu == null) {
        initPopupMenu();
      }
      showPopupMenu();
      return;
    }
    startActivityForResult(new Intent(getActivity(), SysSettingsActivity.class), 1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mActivity = ((MainActivity)getActivity());
    this.res = getActivity().getResources();
    if (this.mRootView != null)
    {
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
    }
    for (;;)
    {
      if (paramBundle != null) {
        this.authInProgress = paramBundle.getBoolean("auth_state_pending");
      }
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903098, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onDestroy()
  {
    if (this.popupWindow != null) {
      this.popupWindow.dismiss();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    dismissPopupMenu();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.info.init();
    this.tv_userName.setText(this.info.name);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("auth_state_pending", this.authInProgress);
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.mClient != null) && (this.share.getGoogleFit() == 1)) {
      this.mClient.connect();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mClient != null) {
      this.mClient.disconnect();
    }
  }
  
  public void onThemeChanged()
  {
    DebugLog.e("我的收到主题切换的通知");
  }
  
  public void onToggle(boolean paramBoolean)
  {
    setGoogleFitToggle(paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\main\UserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */