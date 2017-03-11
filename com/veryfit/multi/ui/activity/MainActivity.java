package com.veryfit.multi.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender.SendIntentException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
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
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.HeartRate;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
import com.project.library.entity.BleDevice;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.BleScanTool.ScanDeviceListener;
import com.project.library.util.DebugLog;
import com.veryfit.multi.VeryFitApplication;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.model.BtSportDataDay;
import com.veryfit.multi.model.BtSportDataItem;
import com.veryfit.multi.service.AntilostService;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.OnThemeChangedListener;
import com.veryfit.multi.ui.activity.device.DeviceUpdateActivity;
import com.veryfit.multi.ui.fragment.OnHealthDataChangedListener;
import com.veryfit.multi.ui.fragment.main.DetailsFragment;
import com.veryfit.multi.ui.fragment.main.DeviceFragment;
import com.veryfit.multi.ui.fragment.main.MainPageFragment;
import com.veryfit.multi.ui.fragment.main.UserFragment;
import com.veryfit.multi.util.HttpUtil;
import com.veryfit.multi.util.NetUtils;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.CustomRadioGroup;
import com.veryfit.multi.view.CustomRadioGroup.OnCheckedChangeListener;
import com.veryfit.multi.vo.json.DeviceUpdateInfo;
import com.veryfit.multi.vo.json.DeviceUpdateList;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity
  extends BaseActivity
  implements CustomRadioGroup.OnCheckedChangeListener, OnHealthDataChangedListener
{
  private static final String AUTH_PENDING = "auth_state_pending";
  private static final int MAIN_UPDATE_DEVICE = 3;
  private static final int REQUEST_OAUTH = 1;
  private static final String TAG = "MainActivity";
  private static Timer mTimer = null;
  private boolean authInProgress = false;
  private float avgRate;
  private Dialog bleEnabledialog;
  DataSet calorieDataSet;
  private GoogleApiClient client = null;
  private Dialog dialog;
  DataSet distanceDataSet;
  private long dt;
  DataSet heightDataSet;
  private Intent intent;
  private boolean isComing = true;
  private boolean isFristMain;
  private boolean isNeedSyce = false;
  private boolean isSyce;
  private List<BtSportDataItem> mAllData = new ArrayList();
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected() {}
    
    public void onBlueToothError(int paramAnonymousInt)
    {
      if (paramAnonymousInt != -66) {}
    }
    
    public void onSyncData(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 100)
      {
        MainActivity.this.isNeedSyce = false;
        MainActivity.this.setTimer();
        if (MainActivity.this.intent == null)
        {
          MainActivity.this.intent = new Intent();
          MainActivity.this.intent.setAction("SYCN_SUCCESS_ACTION");
          Log.d("MainActivity", "广播发送成功");
          MainActivity.this.sendBroadcast(MainActivity.this.intent);
          MainActivity.this.intent = null;
        }
      }
    }
  };
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private LinearLayout mContainer;
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private DetailsFragment mDetailsFragment = null;
  private DeviceFragment mDeviceFragment = null;
  public BaseFragment mLastFragment;
  public MainPageFragment mMainPageFragment = null;
  private BroadcastReceiver mReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("SYCN_SUCCESS_ACTION"))
      {
        Log.d("MainActivity", "收到广播");
        if ((MainActivity.this.client != null) && (MainActivity.this.client.isConnected()) && (MainActivity.this.share.getGoogleFit() != 0)) {}
      }
      else
      {
        return;
      }
      MainActivity.this.saveData();
    }
  };
  private BleScanTool.ScanDeviceListener mScanDeviceListener = new BleScanTool.ScanDeviceListener()
  {
    private void close()
    {
      MainActivity.this.sTool.removeScanDeviceListener(MainActivity.this.mScanDeviceListener);
      if (MainActivity.this.sTool.isScanning()) {
        MainActivity.this.sTool.scanLeDeviceDFU(false);
      }
    }
    
    public void onFind(BleDevice paramAnonymousBleDevice)
    {
      String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
      DebugLog.d("onFind----->addr:" + AppSharedPreferences.getInstance().getBindDeviceAddr());
      if ((paramAnonymousBleDevice.mId == 10) && (paramAnonymousBleDevice.mIs == 240) && (paramAnonymousBleDevice.mLen == 13) && (!TextUtils.isEmpty(str)) && (paramAnonymousBleDevice.mDeviceAddress.equals(str)) && (MainActivity.this.mCore.isDeviceConnected()))
      {
        close();
        DebugLog.d("-----------------------发现升级设备，进入升级界面-----------------------");
        MainActivity.this.toUpgrade();
      }
    }
    
    public void onFinish()
    {
      close();
      DebugLog.d("onFinish----->addr:" + AppSharedPreferences.getInstance().getBindDeviceAddr());
      if ((LibSharedPreferences.getInstance().isFirwareUpgrade()) && (MainActivity.this.mCore.isDeviceConnected())) {
        MainActivity.this.toUpgrade();
      }
    }
  };
  public CustomRadioGroup mTabGroup = null;
  private CopyOnWriteArrayList<OnThemeChangedListener> mThemeChangedListeners = new CopyOnWriteArrayList();
  private UserFragment mUserFragment = null;
  private ViewStub mViewStub = null;
  DataSet rateDataSet;
  private BleScanTool sTool = BleScanTool.getInstance();
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  DataSet stepDataSet;
  private TimerTask task = null;
  private DeviceUpdateInfo updateInfo;
  DataSet weightDataSet;
  
  private void addThemeChangedListener(OnThemeChangedListener paramOnThemeChangedListener)
  {
    if ((paramOnThemeChangedListener != null) && (!this.mThemeChangedListeners.contains(paramOnThemeChangedListener))) {
      this.mThemeChangedListeners.add(paramOnThemeChangedListener);
    }
  }
  
  private void buildFitnessClient()
  {
    this.client = new GoogleApiClient.Builder(this).addApi(Fitness.SENSORS_API).addApi(Fitness.CONFIG_API).addApi(Fitness.RECORDING_API).addApi(Fitness.HISTORY_API).addScope(new Scope("https://www.googleapis.com/auth/fitness.activity.write")).addScope(new Scope("https://www.googleapis.com/auth/fitness.body.write")).addScope(new Scope("https://www.googleapis.com/auth/fitness.location.write")).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        Log.i("MainActivity", "Connected!!!");
        MainActivity.this.subscriptionData();
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 2) {
          Log.i("MainActivity", "Connection lost.  Cause: Network Lost.");
        }
        while (paramAnonymousInt != 1) {
          return;
        }
        Log.i("MainActivity", "Connection lost.  Reason: Service Disconnected");
      }
    }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        Log.i("MainActivity", "Connection failed. Cause: " + paramAnonymousConnectionResult.toString());
        if (!paramAnonymousConnectionResult.hasResolution()) {}
        while (MainActivity.this.authInProgress) {
          return;
        }
        try
        {
          Log.i("MainActivity", "Attempting to resolve failed connection");
          MainActivity.this.authInProgress = true;
          paramAnonymousConnectionResult.startResolutionForResult(MainActivity.this, 1);
          return;
        }
        catch (IntentSender.SendIntentException paramAnonymousConnectionResult)
        {
          Log.e("MainActivity", "Exception while starting resolution activity", paramAnonymousConnectionResult);
        }
      }
    }).build();
    this.client.connect();
  }
  
  public static void cancelTimer()
  {
    if (mTimer != null)
    {
      mTimer.cancel();
      mTimer = null;
      DebugLog.d("-------------关闭实时心率-------------");
    }
  }
  
  private DataSet createDataForRequest(DataType paramDataType, int paramInt, Object paramObject, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    DataSet localDataSet = DataSet.create(new DataSource.Builder().setAppPackageName(this).setDataType(paramDataType).setType(paramInt).build());
    paramDataType = localDataSet.createDataPoint().setTimeInterval(paramLong1, paramLong2, paramTimeUnit);
    if ((paramObject instanceof Integer)) {}
    for (paramDataType = paramDataType.setIntValues(new int[] { ((Integer)paramObject).intValue() });; paramDataType = paramDataType.setFloatValues(new float[] { ((Float)paramObject).floatValue() }))
    {
      localDataSet.add(paramDataType);
      return localDataSet;
    }
  }
  
  private void firwareUpgrade()
  {
    this.sTool.scanLeDeviceDFU(false);
    if (!this.sTool.isScanning()) {
      this.sTool.scanLeDeviceDFU(true);
    }
  }
  
  private void getDeviceUpdateInfo()
  {
    if ((HttpUtil.isNetworkConnected(this)) && (!this.mAppSharedPreferences.getBindDeviceAddr().equals("")))
    {
      new Thread()
      {
        public void run()
        {
          String str = HttpUtil.get("http://www.youduoyun.com/apps/firmwares/firmware.json", null);
          Object localObject1 = "";
          try
          {
            localObject3 = URLDecoder.decode(str, "UTF-8");
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            try
            {
              Object localObject3 = new TypeToken() {}.getType();
              localObject1 = (DeviceUpdateList)new Gson().fromJson((String)localObject1, (Type)localObject3);
              if ((localObject1 == null) || (((DeviceUpdateList)localObject1).firmwareInfo.isEmpty())) {
                break label132;
              }
              MainActivity.this.updateInfo = ((DeviceUpdateList)localObject1).getMyDevice(LibSharedPreferences.getInstance().getDeviceId());
              if (MainActivity.this.updateInfo == null) {
                break label132;
              }
              if (MainActivity.this.updateInfo.version <= LibSharedPreferences.getInstance().getDeviceFirmwareVersion()) {
                break label151;
              }
              MainActivity.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  if (MainActivity.class != null) {
                    MainActivity.this.showUpdateDialog(MainActivity.this);
                  }
                }
              });
              label132:
              return;
              localException2 = localException2;
              localException2.printStackTrace();
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                localException1.printStackTrace();
                Object localObject2 = null;
              }
              label151:
              MainActivity.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  MainActivity.this.synce();
                }
              });
            }
          }
          DebugLog.d(str);
          if (str != null) {}
        }
      }.start();
      return;
    }
    synce();
  }
  
  private long getNowTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int j = localCalendar.get(12);
    int i;
    if ((j >= 0) && (j < 15)) {
      i = 0;
    }
    for (;;)
    {
      localCalendar.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), localCalendar.get(11), i, 0);
      return localCalendar.getTimeInMillis();
      if ((j >= 15) && (j < 30))
      {
        i = 15;
      }
      else if ((j >= 30) && (j < 45))
      {
        i = 30;
      }
      else
      {
        i = j;
        if (j >= 45) {
          i = 45;
        }
      }
    }
  }
  
  private void initLoadingView(final Bundle paramBundle)
  {
    this.isComing = false;
    this.mViewStub = ((ViewStub)findViewById(2131230828));
    this.mViewStub.inflate();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        MainActivity.this.mViewStub.setVisibility(8);
        MainActivity.this.mViewStub = null;
        MainActivity.this.initMainView(paramBundle);
      }
    }, 3000L);
  }
  
  private void initMainView(Bundle paramBundle)
  {
    this.mViewStub = ((ViewStub)findViewById(2131230829));
    this.mContainer = ((LinearLayout)this.mViewStub.inflate());
    this.mCore.addListener(this.mAppListener);
    this.mTabGroup = ((CustomRadioGroup)this.mContainer.findViewById(2131231103));
    this.mTabGroup.setOnCheckedChangeListener(this);
    this.mTabGroup.check(2131231104);
    if (paramBundle != null) {
      this.mLastFragment = ((BaseFragment)getSupportFragmentManager().getFragment(paramBundle, "mLastFragment"));
    }
    if (LibSharedPreferences.getInstance().isFirwareUpgrade()) {
      firwareUpgrade();
    }
    for (;;)
    {
      this.isComing = true;
      return;
      if (AppSharedPreferences.getInstance().getFirstupdateApp()) {
        getDeviceUpdateInfo();
      }
      if ((this.mCore.isAvailable()) && (!this.mCore.isDeviceConnected()) && (this.mCore.initBLE((byte)0)))
      {
        paramBundle = AppSharedPreferences.getInstance().getBindDeviceAddr();
        if (!TextUtils.isEmpty(paramBundle))
        {
          Log.e("debug", "蓝牙测试555555N_。。。" + paramBundle);
          this.mCore.connect(paramBundle);
        }
      }
      if (AppSharedPreferences.getInstance().isFirstStartApp())
      {
        this.mAppSharedPreferences.setFirstStartApp(false);
        this.mAppSharedPreferences.setFirstUpdateApp(false);
      }
    }
  }
  
  private boolean isOpenConnect()
  {
    int i = Calendar.getInstance().get(12);
    return (i >= i) && (i <= i + 2);
  }
  
  private void onSendRealTime()
  {
    if ((this.mAppSharedPreferences.getIsRealTime()) && (!this.isNeedSyce))
    {
      Log.e("debug", "是否正在同步数据:" + LibSharedPreferences.getInstance().isSyncData());
      if ((this.mCore.isDeviceConnected()) && (!LibSharedPreferences.getInstance().isSyncData()) && (LibSharedPreferences.getInstance().getDeviceHeartRate())) {
        this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)-96));
      }
    }
  }
  
  private void saveData()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date());
    long l4 = getNowTime();
    this.dt = (localCalendar1.get(1) * 10000 + (localCalendar1.get(2) + 1) * 100 + localCalendar1.get(5));
    VeryFitApplication.getInstance();
    if (VeryFitApplication.date != -1L)
    {
      VeryFitApplication.getInstance();
      this.dt = VeryFitApplication.date;
    }
    long l1 = 0L;
    int n = 0;
    int i1 = 0;
    float f10 = 0.0F;
    float f9 = 0.0F;
    float f8 = 0.0F;
    float f7 = 0.0F;
    int m = 0;
    float f5 = 0.0F;
    float f6 = 0.0F;
    int i2 = 0;
    int k = 0;
    float f11 = 0.0F;
    float f2 = 0.0F;
    float f12 = 0.0F;
    float f1 = 0.0F;
    long l3 = AppSharedPreferences.getInstance().getSyncSuccessTime();
    List localList = TempUtil.getSportDataItemList(0L);
    int i = 0;
    float f3;
    float f4;
    int j;
    label205:
    int i3;
    label263:
    long l2;
    if (i >= localList.size())
    {
      f3 = f12;
      f4 = f11;
      j = i2;
      if (this.mAllData != null)
      {
        f3 = f12;
        f4 = f11;
        j = i2;
        if (this.mAllData.size() > 0)
        {
          j = 0;
          i = k;
          if (j < this.mAllData.size()) {
            break label716;
          }
          j = i;
          f4 = f2;
          f3 = f1;
        }
      }
      i2 = AppSharedPreferences.getInstance().getLastStepCount();
      i3 = AppSharedPreferences.getInstance().getLastStepItem();
      f11 = AppSharedPreferences.getInstance().getLastStepDistance();
      f12 = AppSharedPreferences.getInstance().getLastStepCal();
      i = 0;
      if (i < localList.size()) {
        break label789;
      }
      k = i1;
      f4 = f9;
      f3 = f7;
      if ((l1 > 0L) && (l1 < l4) && (l4 - l3 >= 1799563L))
      {
        this.stepDataSet = createDataForRequest(DataType.TYPE_STEP_COUNT_DELTA, 0, Integer.valueOf(k), l1, l4, TimeUnit.MILLISECONDS);
        this.distanceDataSet = createDataForRequest(DataType.TYPE_DISTANCE_DELTA, 0, Float.valueOf(f4), l1, l4, TimeUnit.MILLISECONDS);
        f1 = this.share.getUserHeight();
        this.heightDataSet = createDataForRequest(DataType.TYPE_HEIGHT, 0, Float.valueOf(f1 / 100.0F), l1, l4, TimeUnit.MILLISECONDS);
        f1 = this.share.getUserWeight();
        this.weightDataSet = createDataForRequest(DataType.TYPE_WEIGHT, 0, Float.valueOf(f1), l1, l4, TimeUnit.MILLISECONDS);
        localList = TempUtil.getHeartRate(this.dt);
        l3 = 0L;
        j = 0;
        l2 = l3;
        i = j;
        if (localList != null)
        {
          l2 = l3;
          i = j;
          if (localList.size() > 0)
          {
            k = ((HeartRate)localList.get(0)).getMinute();
            l2 = ((HeartRate)localList.get(0)).getDate();
            j = 0;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= localList.size())
      {
        this.avgRate = (j / localList.size());
        i = k;
        localCalendar1.set((int)(l2 / 10000L), (int)(l2 % 10000L / 100L) - 1, (int)(l2 % 10000L % 100L), i / 60, i % 60);
        l2 = localCalendar1.getTimeInMillis();
        this.rateDataSet = createDataForRequest(DataType.TYPE_HEART_RATE_BPM, 0, Float.valueOf(this.avgRate), l2, l4, TimeUnit.MILLISECONDS);
        this.calorieDataSet = createDataForRequest(DataType.TYPE_CALORIES_EXPENDED, 0, Float.valueOf(1000.0F * f3), l1, l4, TimeUnit.MILLISECONDS);
        new AsyncTask()
        {
          protected Void doInBackground(Void... paramAnonymousVarArgs)
          {
            paramAnonymousVarArgs = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.stepDataSet).await(1L, TimeUnit.MINUTES);
            Status localStatus1 = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.distanceDataSet).await(1L, TimeUnit.MINUTES);
            Status localStatus2 = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.heightDataSet).await(1L, TimeUnit.MINUTES);
            Status localStatus3 = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.weightDataSet).await(1L, TimeUnit.MINUTES);
            if (MainActivity.this.avgRate > 0.0F) {
              localStatus4 = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.rateDataSet).await(1L, TimeUnit.MINUTES);
            }
            Status localStatus4 = (Status)Fitness.HistoryApi.insertData(MainActivity.this.client, MainActivity.this.calorieDataSet).await(1L, TimeUnit.MINUTES);
            if ((!paramAnonymousVarArgs.isSuccess()) || (!localStatus1.isSuccess()) || (!localStatus3.isSuccess()) || (!localStatus4.isSuccess()) || (!localStatus2.isSuccess())) {
              return null;
            }
            Log.d("MainActivity", "插入数据成功");
            Log.i("MainActivity", "Data insert was successful!");
            long l = MainActivity.this.getNowTime();
            AppSharedPreferences.getInstance().setSyncSuccessTime(l);
            return null;
          }
          
          protected void onPostExecute(Void paramAnonymousVoid) {}
        }.execute(new Void[0]);
        return;
        if (((BtSportDataItem)localList.get(i)).getStepCount() > 0) {
          this.mAllData.add((BtSportDataItem)localList.get(i));
        }
        i += 1;
        break;
        label716:
        i += ((BtSportDataItem)this.mAllData.get(j)).getStepCount();
        f2 += ((BtSportDataItem)this.mAllData.get(j)).getDistance();
        f1 += ((BtSportDataItem)this.mAllData.get(j)).getCalory();
        j += 1;
        break label205;
        label789:
        l1 = ((BtSportDataItem)localList.get(i)).getDate();
        k = ((BtSportDataItem)localList.get(i)).getHour();
        int i4 = ((BtSportDataItem)localList.get(i)).getMinute();
        int i5 = (int)(l1 / 10000L);
        int i6 = (int)(l1 % 10000L / 100L);
        int i7 = (int)(l1 % 10000L % 100L);
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.set(i5, i6 - 1, i7, k, i4, 0);
        l2 = localCalendar2.getTimeInMillis();
        f1 = f6;
        k = m;
        f2 = f5;
        if (i3 == i)
        {
          f1 = f6;
          k = m;
          f2 = f5;
          if (((BtSportDataItem)localList.get(i)).getStepCount() > i2)
          {
            k = ((BtSportDataItem)localList.get(i)).getStepCount() - i2;
            f2 = ((BtSportDataItem)localList.get(i)).getDistance() - f11;
            f1 = ((BtSportDataItem)localList.get(i)).getCalory() - f12;
          }
        }
        if ((((BtSportDataItem)localList.get(i)).getStepCount() > 0) && (l2 >= l3) && (i > i3))
        {
          m = n;
          f6 = f10;
          f5 = f8;
          for (;;)
          {
            if (i >= localList.size())
            {
              k = m + k;
              f6 += f2;
              f5 += f1;
              localList = TempUtil.getSportDataDayList(0L);
              m = ((BtSportDataDay)localList.get(0)).getTotalstepCount();
              f8 = ((BtSportDataDay)localList.get(0)).getTotalDistance();
              f7 = ((BtSportDataDay)localList.get(0)).getTotalCalory();
              f2 = f5;
              f1 = f6;
              i = k;
              if (m > j)
              {
                i = k + m - j;
                f1 = f6 + f8 - f4;
                f2 = f5 + f7 - f3;
              }
              AppSharedPreferences.getInstance().setLastStepCount(((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getStepCount());
              AppSharedPreferences.getInstance().setLastStepDistance(((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getDistance());
              AppSharedPreferences.getInstance().setLastStepCal(((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getCalory());
              localList = TempUtil.getId(((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getStepCount(), ((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getDistance(), ((BtSportDataItem)this.mAllData.get(this.mAllData.size() - 1)).getCalory());
              k = -1;
              j = k;
              if (localList != null)
              {
                j = k;
                if (localList.size() > 0) {
                  j = ((Integer)localList.get(localList.size() - 1)).intValue();
                }
              }
              l1 = l2;
              f3 = f2;
              f4 = f1;
              k = i;
              if (j < 0) {
                break;
              }
              AppSharedPreferences.getInstance().setLastStepItem(j - 1);
              l1 = l2;
              f3 = f2;
              f4 = f1;
              k = i;
              break;
            }
            i2 = ((BtSportDataItem)localList.get(i)).getStepCount();
            n = ((BtSportDataItem)localList.get(i)).getDistance();
            i1 = ((BtSportDataItem)localList.get(i)).getCalory();
            m += i2;
            f6 += n;
            f5 += i1;
            i += 1;
          }
        }
        i += 1;
        l1 = l2;
        f6 = f1;
        m = k;
        f5 = f2;
        break label263;
      }
      j += ((HeartRate)localList.get(i)).getRate();
      i += 1;
    }
  }
  
  private void setTimer()
  {
    if (LibSharedPreferences.getInstance().getDeviceHeartRate())
    {
      if (mTimer == null) {
        mTimer = new Timer();
      }
      this.task = new TimerTask()
      {
        public void run()
        {
          MainActivity.this.onSendRealTime();
        }
      };
      mTimer.schedule(this.task, 1000L, 1000L);
    }
  }
  
  private void subscribe(DataType paramDataType)
  {
    Fitness.RecordingApi.subscribe(this.client, paramDataType).setResultCallback(new ResultCallback()
    {
      public void onResult(Status paramAnonymousStatus)
      {
        if (paramAnonymousStatus.isSuccess())
        {
          if (paramAnonymousStatus.getStatusCode() == 60535)
          {
            Log.i("MainActivity", "Existing subscription for activity detected.");
            return;
          }
          Log.i("MainActivity", "rate1 Successfully subscribed!");
          return;
        }
        Log.i("MainActivity", "rate There was a problem subscribing.");
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
  
  private void synce()
  {
    LibSharedPreferences.getInstance().setSyncData(true);
    if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {}
    for (byte b = 1;; b = 0)
    {
      if (this.mCore != null)
      {
        AppSharedPreferences.getInstance().setLastSyncTime(System.currentTimeMillis());
        this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
      }
      return;
    }
  }
  
  private void toUpgrade()
  {
    startActivityForResult(new Intent(this, DeviceUpdateActivity.class), 3);
  }
  
  public void OnHealthDataChanged()
  {
    if (this.mDetailsFragment != null) {
      this.mDetailsFragment.updateHealthData();
    }
  }
  
  public void OnHealthDataChangedX()
  {
    if (this.mMainPageFragment != null) {
      this.mMainPageFragment.onHealthDataChanged();
    }
  }
  
  public void changeFragment(FragmentActivity paramFragmentActivity, BaseFragment paramBaseFragment, String paramString)
  {
    if ((paramBaseFragment == null) || (this.mLastFragment == paramBaseFragment)) {}
    do
    {
      return;
      paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
      if ((this.mLastFragment != null) && (this.mLastFragment != paramBaseFragment)) {
        paramFragmentActivity.detach(this.mLastFragment);
      }
      if (!paramBaseFragment.isAdded()) {
        paramFragmentActivity.add(2131231102, paramBaseFragment, paramString);
      }
      if (paramBaseFragment.isDetached()) {
        paramFragmentActivity.attach(paramBaseFragment);
      }
      this.mLastFragment = paramBaseFragment;
      addThemeChangedListener(paramBaseFragment);
    } while (isFinishing());
    paramFragmentActivity.commitAllowingStateLoss();
  }
  
  public boolean isHealthDataSyncing()
  {
    if (this.mMainPageFragment != null) {
      return this.mMainPageFragment.isHealthDataSyncing();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 3) && (paramInt2 != 0))
    {
      this.mAppSharedPreferences.setFirstUpdateApp(false);
      onDeviceNeedInit();
    }
  }
  
  public void onCheckedChanged(CustomRadioGroup paramCustomRadioGroup, int paramInt)
  {
    if (this != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 2131231104: 
      if (this.mMainPageFragment == null)
      {
        this.mMainPageFragment = new MainPageFragment();
        this.mMainPageFragment.setOnHealthDataChanged(this);
      }
      this.isSyce = true;
      this.mAppSharedPreferences.setIsRealTime(true);
      setTimer();
      changeFragment(this, this.mMainPageFragment, null);
      return;
    case 2131231105: 
      if (this.mDetailsFragment == null) {
        this.mDetailsFragment = new DetailsFragment();
      }
      this.isSyce = false;
      this.mAppSharedPreferences.setIsRealTime(false);
      cancelTimer();
      changeFragment(this, this.mDetailsFragment, null);
      this.intent = null;
      return;
    case 2131231106: 
      if (this.mDeviceFragment == null) {
        this.mDeviceFragment = new DeviceFragment();
      }
      this.isSyce = false;
      this.mAppSharedPreferences.setIsRealTime(false);
      cancelTimer();
      changeFragment(this, this.mDeviceFragment, null);
      this.intent = null;
      return;
    }
    if (this.mUserFragment == null) {
      this.mUserFragment = new UserFragment();
    }
    this.isSyce = false;
    this.mAppSharedPreferences.setIsRealTime(false);
    cancelTimer();
    changeFragment(this, this.mUserFragment, null);
    this.intent = null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(67108864);
    setContentView(2130903058);
    this.sTool.addScanDeviceListener(this.mScanDeviceListener);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SYCN_SUCCESS_ACTION");
    registerReceiver(this.mReceiver, localIntentFilter);
    if (paramBundle != null) {
      this.authInProgress = paramBundle.getBoolean("auth_state_pending");
    }
    this.isFristMain = true;
    initLoadingView(paramBundle);
    if (AppSharedPreferences.getInstance().getAntilost() == 1) {
      startService(new Intent(this, AntilostService.class));
    }
  }
  
  protected void onDestroy()
  {
    this.isFristMain = false;
    if (this.mTabGroup != null) {
      this.mTabGroup = null;
    }
    if (this.dialog != null) {
      this.dialog.dismiss();
    }
    if (LibSharedPreferences.getInstance().isSyncData()) {
      LibSharedPreferences.getInstance().setSyncData(false);
    }
    super.onDestroy();
    unregisterReceiver(this.mReceiver);
  }
  
  public void onDeviceNeedInit()
  {
    synce();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.isComing) {
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getString("id");
        if (paramIntent != null)
        {
          if (!paramIntent.equals("1")) {
            break label46;
          }
          showBleEnableDialog(this);
        }
      }
    }
    return;
    label46:
    paramIntent.equals("2");
  }
  
  protected void onPause()
  {
    this.mCore.removeListener(this.mAppListener);
    super.onPause();
    this.mAppSharedPreferences.setIsRealTime(false);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null) {
      this.mLastFragment = ((BaseFragment)getSupportFragmentManager().getFragment(paramBundle, "mLastFragment"));
    }
  }
  
  protected void onResume()
  {
    this.mCore.addListener(this.mAppListener);
    super.onResume();
    if ((this.share.getGoogleFit() == 1) && (this.client == null) && (NetUtils.isConnected(this)) && ((this.client == null) || (this.client.isConnected()) || (this.client.isConnecting()))) {
      buildFitnessClient();
    }
    if (this.isSyce) {
      this.mAppSharedPreferences.setIsRealTime(true);
    }
    if ((this.isSyce) && (mTimer == null)) {
      setTimer();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if ((paramBundle != null) && (this.mLastFragment != null) && (this.mLastFragment.isAdded())) {
      getSupportFragmentManager().putFragment(paramBundle, "mLastFragment", this.mLastFragment);
    }
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("auth_state_pending", this.authInProgress);
  }
  
  protected void onStart()
  {
    super.onStart();
    if ((this.client != null) && (this.share.getGoogleFit() == 1)) {
      this.client.connect();
    }
  }
  
  protected void onThemeChanged()
  {
    DebugLog.e("主题切换广播收到了...Main");
    Iterator localIterator = this.mThemeChangedListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((OnThemeChangedListener)localIterator.next()).onThemeChanged();
    }
  }
  
  protected void setNavigationBar() {}
  
  public void showBleEnableDialog(final Context paramContext)
  {
    if (this.bleEnabledialog == null)
    {
      this.bleEnabledialog = new Dialog(paramContext, 2131427337);
      this.bleEnabledialog.setContentView(2130903079);
      this.bleEnabledialog.getWindow().setGravity(17);
      this.bleEnabledialog.setCancelable(false);
    }
    if (this.bleEnabledialog.isShowing()) {
      return;
    }
    Button localButton1 = (Button)this.bleEnabledialog.findViewById(2131230927);
    Button localButton2 = (Button)this.bleEnabledialog.findViewById(2131230928);
    final BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.bleEnabledialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MainActivity.this.bleEnabledialog.dismiss();
        if (localBluetoothAdapter == null) {
          Toast.makeText(paramContext, 2131296523, 1).show();
        }
        while (localBluetoothAdapter.isEnabled()) {
          return;
        }
        localBluetoothAdapter.enable();
      }
    });
    this.bleEnabledialog.show();
  }
  
  public void showUpdateDialog(Activity paramActivity)
  {
    this.dialog = new Dialog(paramActivity, 2131427337);
    this.dialog.setContentView(2130903091);
    this.dialog.getWindow().setGravity(17);
    this.dialog.setCancelable(false);
    this.dialog.findViewById(2131230934).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MainActivity.this, DeviceUpdateActivity.class);
        paramAnonymousView.putExtra("updateInfo", MainActivity.this.updateInfo);
        paramAnonymousView.putExtra("isAllowBack", false);
        MainActivity.this.startActivityForResult(paramAnonymousView, 3);
        MainActivity.this.dialog.dismiss();
      }
    });
    this.dialog.show();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */