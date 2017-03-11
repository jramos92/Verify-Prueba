package com.veryfit.multi.ui.fragment.firstbound;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.BindUnbindCmd;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.settings.AntilostInfos;
import com.project.library.device.cmd.settings.MultiTarget;
import com.project.library.device.cmd.settings.Sedentariness;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.device.cmd.settings.Userinfos;
import com.project.library.entity.BleDevice;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.BleScanTool.ScanDeviceListener;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.FirstStartActivity;
import com.veryfit.multi.ui.adapter.DeviceAdapter;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.DialogUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AddDeviceFragment
  extends BaseFragment
  implements View.OnClickListener
{
  public static final UUID RX_SERVICE_UUID = UUID.fromString("00000af0-0000-1000-8000-00805f9b34fb");
  private DeviceAdapter adapter;
  private Dialog bleEnabledialog;
  private Button btn_bound;
  private Button btn_refresh;
  private Dialog dialog;
  private Dialog dialogCircle = null;
  private FrameLayout fl_notice;
  private boolean isBindSuccess = false;
  private boolean isCancelUpgrade = false;
  private boolean isPrepared = false;
  private boolean isRestartOrUpgrade = false;
  private LinearLayout ll_refresh;
  private ListView lv_devices;
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      AddDeviceFragment.this.mCore.writeForce(BindUnbindCmd.getInstance().getBindCmd());
    }
    
    public void onBLEConnecting() {}
    
    public void onBLEDisConnected(String paramAnonymousString) {}
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 18)
      {
        AddDeviceFragment.this.showCircleDialog();
        AddDeviceFragment.this.isBindSuccess = true;
        AddDeviceFragment.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
      }
    }
    
    public void onBlueToothError(int paramAnonymousInt)
    {
      if (paramAnonymousInt == -66)
      {
        AddDeviceFragment.this.fl_notice.setVisibility(0);
        AddDeviceFragment.this.scanTitle.setVisibility(0);
        AddDeviceFragment.this.startScanDevice();
      }
    }
    
    public void onCoreServiceConnected()
    {
      AddDeviceFragment.this.startScanDevice();
    }
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 2) {
        AddDeviceFragment.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
      }
      if (paramAnonymousByte == 1)
      {
        if (AddDeviceFragment.this.isRestartOrUpgrade)
        {
          DebugLog.i(">>获取设备信息成功,需要初始化设置值，正在发送个人信息设置");
          AddDeviceFragment.this.sendUnitSet();
        }
      }
      else {
        return;
      }
      AddDeviceFragment.this.onBindFinish(true);
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        if (AddDeviceFragment.this.isRestartOrUpgrade)
        {
          switch (paramAnonymousByte)
          {
          default: 
            return;
          case 1: 
            DebugLog.i(">>时间设置成功,获取设备信息");
            AddDeviceFragment.this.setUserInfo();
            return;
          case 2: 
            DebugLog.i(">>闹钟设置成功");
            AddDeviceFragment.this.onReciveSettingAlarm();
            return;
          case 32: 
            DebugLog.i(">>久坐设置成功");
            AddDeviceFragment.this.onReviceSettingRemindSport();
            return;
          case 33: 
            DebugLog.i(">>防丢设置成功");
            AddDeviceFragment.this.onReciveLost();
            return;
          case 16: 
            DebugLog.i(">>用户信息设置成功");
            AddDeviceFragment.this.onReciveUserInfo();
            return;
          case 3: 
            DebugLog.i(">>运动目标设置成功");
            AddDeviceFragment.this.onReciveMultiTarget();
            return;
          case 17: 
            DebugLog.i(">>单位设置成功");
            AddDeviceFragment.this.onRecivesendUnit();
            return;
          }
          DebugLog.i(">>寻找手机设置成功");
          AddDeviceFragment.this.onReciveFindPhone();
          return;
        }
        switch (paramAnonymousByte)
        {
        default: 
          return;
        case 1: 
          DebugLog.i(">>时间设置成功");
          AddDeviceFragment.this.setUserInfo();
          return;
        case 39: 
          DebugLog.e(">>一键还原默认设置成功");
          AddDeviceFragment.this.onReceiveOneKeyCmd();
          return;
        case 17: 
          DebugLog.i(">>单位设置成功");
          AddDeviceFragment.this.onRecivesendUnit();
          return;
        case 16: 
          DebugLog.i(">>用户信息设置成功");
          AddDeviceFragment.this.onReciveUserInfo();
          return;
        }
        DebugLog.i(">>运动目标设置成功");
        AddDeviceFragment.this.settingsSuccess();
        return;
      }
      DebugLog.e("设置失败： " + paramAnonymousByte);
    }
  };
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private String mDeviceAddr = "";
  private ArrayList<BleDevice> mDeviceList = new ArrayList();
  private FindPhoneRunnable mFindPhoneRunnable = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      AddDeviceFragment.this.pb.setVisibility(4);
      AddDeviceFragment.this.scanTitle.setText(2131296448);
      AddDeviceFragment.this.reRefresh.setVisibility(0);
    }
  };
  private OnFinishListener mOnFinishListener = null;
  private View mRootView = null;
  private BleScanTool.ScanDeviceListener mScanDeviceListener = new BleScanTool.ScanDeviceListener()
  {
    public void onFind(BleDevice paramAnonymousBleDevice)
    {
      AddDeviceFragment.this.showList(paramAnonymousBleDevice);
    }
    
    public void onFinish()
    {
      AddDeviceFragment.this.showNoDeviceFound();
    }
  };
  private SettingTimeoutRunnable mSettingTimeoutRunnable = null;
  private AdapterView.OnItemClickListener onDeviceChoice = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (!AddDeviceFragment.this.adapter.binding)
      {
        AddDeviceFragment.this.adapter.checkDevice = ((BleDevice)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt));
        AddDeviceFragment.this.btn_bound.setVisibility(0);
        AddDeviceFragment.this.adapter.notifyDataSetChanged();
      }
    }
  };
  private ProgressBar pb;
  private ImageView reRefresh;
  private BleScanTool sTool = BleScanTool.getInstance();
  private TextView scanTitle;
  
  private void bindSuccess()
  {
    this.mAppSharedPreferences.setLiftWristSwitch(true);
    sendOneKeyRestoreCmd();
  }
  
  private boolean checkBluethoothConection()
  {
    boolean bool = this.sTool.isBluetoothOpen();
    if (!bool)
    {
      this.fl_notice.setVisibility(4);
      this.scanTitle.setVisibility(4);
      showBleEnableDialog(getActivity());
    }
    return bool;
  }
  
  private void closeCircleDialog()
  {
    if (this.dialogCircle != null) {
      this.dialogCircle.dismiss();
    }
    if (this.mSettingTimeoutRunnable != null) {
      this.mHandler.removeCallbacks(this.mSettingTimeoutRunnable);
    }
  }
  
  private void initTimeMode()
  {
    String str = Settings.System.getString(getActivity().getContentResolver(), "time_12_24");
    if ("24".equals(str)) {
      AppSharedPreferences.getInstance().setTimeMode(true);
    }
    while (!"12".equals(str)) {
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
  }
  
  private boolean isOneKeyRestore()
  {
    return (LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x20) >> 5 == 1;
  }
  
  private void onBindFinish(final boolean paramBoolean)
  {
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        AddDeviceFragment.this.btn_refresh.setEnabled(true);
        AddDeviceFragment.this.btn_bound.setEnabled(true);
        AddDeviceFragment.this.adapter.binding = false;
        AddDeviceFragment.this.adapter.notifyDataSetChanged();
        if (paramBoolean) {
          AddDeviceFragment.this.bindSuccess();
        }
      }
    });
  }
  
  private void onReceiveOneKeyCmd()
  {
    sendUnitSet();
  }
  
  private void onReciveSettingAlarm()
  {
    if (this.mAlarmList.size() > 0) {
      this.mAlarmList.poll();
    }
    AlarmNotify localAlarmNotify = (AlarmNotify)this.mAlarmList.peek();
    if (localAlarmNotify == null)
    {
      DebugLog.d(">>闹钟发送完毕,发送防丢");
      sendLost();
    }
    while (localAlarmNotify == null) {
      return;
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd(localAlarmNotify));
  }
  
  private void scanDevice(boolean paramBoolean)
  {
    this.sTool.scanLeDeviceByService(paramBoolean, RX_SERVICE_UUID);
  }
  
  private void sendAlarms()
  {
    this.mAlarmList.clear();
    Iterator localIterator = TempUtil.getAlarms().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!this.mAlarmList.isEmpty()) {
          break;
        }
        DebugLog.d(">>闹钟发送完毕,发送防丢");
        sendLost();
        return;
      }
      AlarmNotify localAlarmNotify = (AlarmNotify)localIterator.next();
      this.mAlarmList.add(localAlarmNotify);
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd((AlarmNotify)this.mAlarmList.peek()));
  }
  
  private void sendFindPhone()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x8) >> 3 == 1)
    {
      boolean bool = this.mAppSharedPreferences.getDeviceFoundPhoneSwitch();
      if (bool)
      {
        if ((!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool))) && (!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool)))) {
          this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool));
        }
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(bool);
        this.mFindPhoneRunnable = new FindPhoneRunnable();
        this.mHandler.postDelayed(this.mFindPhoneRunnable, 3000L);
        return;
      }
      DebugLog.d(">>寻找手机发送成功，发送完毕");
      settingsSuccess();
      return;
    }
    DebugLog.d(">>不支持寻找手机，发送完毕");
    settingsSuccess();
  }
  
  private void sendLost()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() >> 1 & 0x1) == 1)
    {
      if (1 == AppSharedPreferences.getInstance().getAntilost())
      {
        localAntilostInfos = new AntilostInfos();
        localAntilostInfos.mode = 1;
        this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
        return;
      }
      AntilostInfos localAntilostInfos = new AntilostInfos();
      localAntilostInfos.mode = 0;
      this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
      return;
    }
    DebugLog.d(">>不支持防丢，发送久坐");
    sendRemindSport();
  }
  
  private void sendOneKeyRestoreCmd()
  {
    if (isOneKeyRestore())
    {
      this.mCore.write(SettingsCmd.getInstance().getOneKeyRestoreCmd());
      return;
    }
    DebugLog.e(">>不支持一键还原默认设置，设置单位");
    this.isRestartOrUpgrade = true;
    sendUnitSet();
  }
  
  private void sendRemindSport()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x1) == 1)
    {
      Sedentariness localSedentariness = new Sedentariness();
      AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
      localSedentariness.repetitions = localAppSharedPreferences.getDeviceRemindSportRepetitions();
      localSedentariness.startHour = localAppSharedPreferences.getDeviceRemindSportStartHour();
      localSedentariness.startMinute = localAppSharedPreferences.getDeviceRemindSportStartMin();
      localSedentariness.endHour = localAppSharedPreferences.getDeviceRemindSportEndHour();
      localSedentariness.endMinute = localAppSharedPreferences.getDeviceRemindSportEndMin();
      localSedentariness.interval = localAppSharedPreferences.getDeviceRemindSportInterval();
      this.mCore.write(SettingsCmd.getInstance().getSedentarinessSettingsCmd(localSedentariness));
      return;
    }
    DebugLog.d(">>不支持久坐，发送寻找手机");
    sendFindPhone();
  }
  
  private void sendUnitSet()
  {
    int i = 1;
    initTimeMode();
    DebugLog.i(">>设置单位");
    Units localUnits = new Units();
    localUnits.setMode(AppSharedPreferences.getInstance().getUnitType());
    String str = getResources().getConfiguration().locale.toString();
    if (str.contains("zh"))
    {
      localUnits.language = 1;
      if (!this.mAppSharedPreferences.getUserSex()) {
        break label134;
      }
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.415D));
      label86:
      if (!AppSharedPreferences.getInstance().is24TimeMode()) {
        break label154;
      }
    }
    for (;;)
    {
      localUnits.timeMode = i;
      this.mCore.write(SettingsCmd.getInstance().getUnitSettingsCmd(localUnits));
      return;
      if (!str.contains("en")) {
        break;
      }
      localUnits.language = 2;
      break;
      label134:
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.413D));
      break label86;
      label154:
      i = 2;
    }
  }
  
  private void setNavigationBar()
  {
    if (getActivity() != null) {
      ScreenUtil.setImmersiveStatusBar(getActivity(), ScreenUtil.getAndroidVersionThanKitkat());
    }
  }
  
  private void settingsSuccess()
  {
    if (this.dialogCircle != null) {
      this.dialogCircle.dismiss();
    }
    if (this.isRestartOrUpgrade) {
      this.isRestartOrUpgrade = false;
    }
    AppSharedPreferences.getInstance().setBindDeviceAddr(this.mDeviceAddr);
    if ((this.adapter.checkDevice != null) && (!TextUtils.isEmpty(this.adapter.checkDevice.mDeviceName)))
    {
      String str = this.adapter.checkDevice.mDeviceName;
      Log.e("debug", "mDeviceAddr----" + this.mDeviceAddr);
      AppSharedPreferences.getInstance().setBindDeviceName(str);
    }
    if (AppSharedPreferences.getInstance().isFirstStartApp()) {
      ((FirstStartActivity)getActivity()).jumpToSettings();
    }
    while (this.mOnFinishListener == null) {
      return;
    }
    getActivity().setResult(1);
    this.mOnFinishListener.OnFinish();
  }
  
  private void showBoundBleDialog(final int paramInt, final String paramString1, final String paramString2)
  {
    if (this.dialog != null) {}
    while (this.adapter.getCount() > 1) {
      return;
    }
    this.dialog = new Dialog(getActivity(), 2131427337);
    this.dialog.setContentView(2130903078);
    this.dialog.getWindow().setGravity(17);
    this.dialog.setCancelable(false);
    Button localButton1 = (Button)this.dialog.findViewById(2131230925);
    Button localButton2 = (Button)this.dialog.findViewById(2131230926);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AddDeviceFragment.this.dialog.dismiss();
        AddDeviceFragment.this.dialog = null;
        AddDeviceFragment.this.isCancelUpgrade = true;
        AddDeviceFragment.this.startScanDevice();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AddDeviceFragment.this.getActivity() != null) {
          AddDeviceFragment.this.getActivity().runOnUiThread(new Runnable()
          {
            public void run()
            {
              Intent localIntent = new Intent(AddDeviceFragment.this.getActivity(), DfuActivity.class);
              Bundle localBundle = new Bundle();
              localBundle.putInt("deviceId", this.val$deviceId);
              localBundle.putString("deviceAddr", this.val$macAddress);
              localBundle.putString("deviceName", this.val$deviceName);
              localIntent.putExtras(localBundle);
              AddDeviceFragment.this.startActivityForResult(localIntent, 100);
              AddDeviceFragment.this.dialog.dismiss();
              AddDeviceFragment.this.dialog = null;
            }
          });
        }
      }
    });
    this.dialog.show();
  }
  
  private void showCircleDialog()
  {
    if (this.dialogCircle == null)
    {
      this.dialogCircle = DialogUtil.showCircleProgressDialog(getActivity(), 2131296603, true);
      this.mSettingTimeoutRunnable = new SettingTimeoutRunnable();
      this.mHandler.postDelayed(this.mSettingTimeoutRunnable, 60000L);
    }
  }
  
  private void showList(final BleDevice paramBleDevice)
  {
    if ((paramBleDevice.mId == 10) && (paramBleDevice.mIs == 240) && (paramBleDevice.mLen == 13) && (!this.isCancelUpgrade))
    {
      this.sTool.scanLeDevice(false);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AddDeviceFragment.this.mDeviceList.clear();
          AddDeviceFragment.this.mDeviceList.add(paramBleDevice);
          AddDeviceFragment.this.adapter.notifyDataSetChanged();
          AddDeviceFragment.this.showBoundBleDialog(paramBleDevice.mDeviceId, paramBleDevice.mDeviceAddress, paramBleDevice.mDeviceName);
        }
      });
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        AddDeviceFragment.this.mDeviceList.add(paramBleDevice);
        Collections.sort(AddDeviceFragment.this.mDeviceList);
        DebugLog.d("size = " + AddDeviceFragment.this.mDeviceList.size());
        AddDeviceFragment.this.adapter.notifyDataSetChanged();
        AddDeviceFragment.this.lv_devices.setVisibility(0);
        AddDeviceFragment.this.ll_refresh.setVisibility(8);
      }
    });
  }
  
  private void showNoDeviceFound()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (AddDeviceFragment.this.mDeviceList.size() == 0)
        {
          AddDeviceFragment.this.pb.setVisibility(4);
          AddDeviceFragment.this.scanTitle.setText(2131296448);
          AddDeviceFragment.this.reRefresh.setVisibility(0);
        }
        AddDeviceFragment.this.btn_refresh.setEnabled(true);
      }
    });
  }
  
  private void showStartScaning()
  {
    this.lv_devices.setVisibility(8);
    this.ll_refresh.setVisibility(0);
    this.pb.setVisibility(0);
    this.scanTitle.setText(2131296450);
    this.reRefresh.setVisibility(8);
    this.btn_refresh.setEnabled(true);
    this.btn_bound.setVisibility(8);
  }
  
  public void close()
  {
    this.mCore.removeListener(this.mAppListener);
    this.sTool.removeScanDeviceListener(this.mScanDeviceListener);
    if (this.sTool.isScanning()) {
      scanDevice(false);
    }
  }
  
  public void initView()
  {
    this.pb = ((ProgressBar)this.mRootView.findViewById(2131230878));
    this.reRefresh = ((ImageView)this.mRootView.findViewById(2131230879));
    this.ll_refresh = ((LinearLayout)this.mRootView.findViewById(2131230875));
    this.scanTitle = ((TextView)this.mRootView.findViewById(2131230876));
    this.lv_devices = ((ListView)this.mRootView.findViewById(2131230880));
    this.btn_refresh = ((Button)this.mRootView.findViewById(2131230881));
    this.btn_bound = ((Button)this.mRootView.findViewById(2131230882));
    this.fl_notice = ((FrameLayout)this.mRootView.findViewById(2131230877));
    this.adapter = new DeviceAdapter(this.mDeviceList, getActivity());
    this.lv_devices.setAdapter(this.adapter);
    this.lv_devices.setOnItemClickListener(this.onDeviceChoice);
    this.btn_bound.setVisibility(4);
    this.btn_bound.setOnClickListener(this);
    this.btn_refresh.setOnClickListener(this);
    this.fl_notice.setOnClickListener(this);
    this.mCore.addListener(this.mAppListener);
    this.sTool.addScanDeviceListener(this.mScanDeviceListener);
    startScanDevice();
  }
  
  protected void lazyLoad()
  {
    if (!this.isPrepared) {
      return;
    }
    setNavigationBar();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == 101)) {
      startScanDevice();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230878: 
    case 2131230879: 
    case 2131230880: 
    default: 
      return;
    case 2131230881: 
      startScanDevice();
      return;
    case 2131230882: 
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          AddDeviceFragment.this.isBindSuccess = false;
          AddDeviceFragment.this.adapter.binding = true;
          AddDeviceFragment.this.adapter.notifyDataSetChanged();
          AddDeviceFragment.this.scanDevice(false);
          AddDeviceFragment.this.btn_refresh.setEnabled(false);
          AddDeviceFragment.this.btn_bound.setEnabled(false);
          AddDeviceFragment.this.mCore.connect(AddDeviceFragment.this.adapter.checkDevice.mDeviceAddress);
          AddDeviceFragment.this.mDeviceAddr = AddDeviceFragment.this.adapter.checkDevice.mDeviceAddress;
          DebugLog.e("设备名字：" + AddDeviceFragment.this.adapter.checkDevice.mDeviceName);
          AddDeviceFragment.this.mHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              DebugLog.e("连接超时");
              if (!AddDeviceFragment.this.isBindSuccess)
              {
                AddDeviceFragment.this.mCore.disconnect();
                AddDeviceFragment.this.adapter.checkDevice = null;
                AddDeviceFragment.this.adapter.binding = false;
                AddDeviceFragment.this.adapter.notifyDataSetChanged();
                AddDeviceFragment.this.btn_refresh.setEnabled(true);
                AddDeviceFragment.this.btn_bound.setEnabled(true);
                AddDeviceFragment.this.btn_refresh.setVisibility(0);
                AddDeviceFragment.this.btn_bound.setVisibility(8);
              }
            }
          }, 60000L);
        }
      });
      return;
    }
    startScanDevice();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mRootView != null)
    {
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
    }
    for (;;)
    {
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903069, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onDestroy()
  {
    this.mCore.removeListener(this.mAppListener);
    super.onDestroy();
  }
  
  public void onDeviceNeedInit()
  {
    this.isRestartOrUpgrade = true;
    if (this.mCore.isDeviceConnected())
    {
      sendGetDeviceFun();
      return;
    }
    this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  protected void onReciveFindPhone()
  {
    if (this.mFindPhoneRunnable != null) {
      this.mHandler.removeCallbacks(this.mFindPhoneRunnable);
    }
    DebugLog.d(">>寻找手机发送成功，发送完毕");
    settingsSuccess();
  }
  
  protected void onReciveLost()
  {
    DebugLog.d(">>防丢发送成功，发送久坐");
    sendRemindSport();
  }
  
  protected void onReciveMultiTarget()
  {
    DebugLog.i(">>设置运动目标信息成功，设置闹钟");
    sendAlarms();
  }
  
  protected void onReciveUserInfo()
  {
    DebugLog.i(">>设置用户信息成功，设置运动目标信息");
    setMultiTarget();
  }
  
  protected void onRecivesendUnit()
  {
    DebugLog.i(">>设置单位成功，设置时间、。");
    this.mCore.write(SettingsCmd.getInstance().getTimeSettingsCmd());
  }
  
  protected void onReviceSettingRemindSport()
  {
    DebugLog.d(">>久坐发送成功，发送寻找手机");
    sendFindPhone();
  }
  
  public void onThemeChanged() {}
  
  protected void sendGetDeviceFun()
  {
    if (LibSharedPreferences.getInstance().getDeviceFunMain() == -1)
    {
      DebugLog.d(">>获取功能表");
      this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
      return;
    }
    DebugLog.d(">>功能表已获取，获取设备信息");
    this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
  }
  
  public void setMultiTarget()
  {
    int[] arrayOfInt = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    MultiTarget localMultiTarget = new MultiTarget();
    localMultiTarget.sportType = 0;
    localMultiTarget.sportTarget = arrayOfInt[0];
    localMultiTarget.sleepFlag = 0;
    localMultiTarget.sleepHour = (arrayOfInt[1] / 60);
    localMultiTarget.sleepMinute = (arrayOfInt[1] % 60);
    this.mCore.writeForce(SettingsCmd.getInstance().getMultiTargetSettingsCmd(localMultiTarget));
  }
  
  public void setOnFinishListener(OnFinishListener paramOnFinishListener)
  {
    this.mOnFinishListener = paramOnFinishListener;
  }
  
  protected void setUserInfo()
  {
    Userinfos localUserinfos = new Userinfos();
    localUserinfos.height = this.mAppSharedPreferences.getUserHeight();
    localUserinfos.weight = this.mAppSharedPreferences.getUserWeight();
    if (this.mAppSharedPreferences.getUserSex()) {}
    for (int i = 0;; i = 1)
    {
      localUserinfos.gender = i;
      localUserinfos.year = this.mAppSharedPreferences.getUserBirthdayYear();
      localUserinfos.month = this.mAppSharedPreferences.getUserBirthdayMonth();
      localUserinfos.day = this.mAppSharedPreferences.getUserBirthdayDay();
      this.mCore.write(SettingsCmd.getInstance().getUserinfosSettingsCmd(localUserinfos));
      return;
    }
  }
  
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
        AddDeviceFragment.this.bleEnabledialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AddDeviceFragment.this.bleEnabledialog.dismiss();
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
  
  public void startScanDevice()
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (!AddDeviceFragment.this.checkBluethoothConection()) {}
        do
        {
          return;
          AddDeviceFragment.this.mDeviceList.clear();
          AddDeviceFragment.this.adapter.notifyDataSetChanged();
          AddDeviceFragment.this.scanDevice(false);
        } while (AddDeviceFragment.this.sTool.isScanning());
        AddDeviceFragment.this.showStartScaning();
        AddDeviceFragment.this.adapter.checkDevice = null;
        AddDeviceFragment.this.scanDevice(true);
      }
    });
  }
  
  class FindPhoneRunnable
    implements Runnable
  {
    FindPhoneRunnable() {}
    
    public void run()
    {
      AddDeviceFragment.this.settingsSuccess();
    }
  }
  
  public static abstract interface OnFinishListener
  {
    public abstract void OnFinish();
  }
  
  class SettingTimeoutRunnable
    implements Runnable
  {
    SettingTimeoutRunnable() {}
    
    public void run()
    {
      AddDeviceFragment.this.closeCircleDialog();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\AddDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */