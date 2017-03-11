package com.veryfit.multi.ui.activity.device;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.cmd.WareUpdateCmd;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
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
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.service.AntilostService;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.HttpUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.vo.json.DeviceUpdateInfo;
import com.veryfit.multi.vo.json.DeviceUpdateList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import no.nordicsemi.android.dfu.DfuService;

public class DeviceUpdateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final UUID DFU_SERVICE_UUID = new UUID(23296205844446L, 1523193452336828707L);
  private static final int REUPDATEE_MAX_COUNT = 7;
  public static final UUID RX_SERVICE_UUID = UUID.fromString("00000af0-0000-1000-8000-00805f9b34fb");
  private static final int UPDATE_CMD_FAILED = 11;
  private static final int UPDATE_CMD_RESULT = 10;
  private static final int UPDATE_FAILED = 12;
  private static int mProcess;
  private static boolean updating;
  private CheckBox autoOta;
  private Dialog bleEnabledialog;
  private int count;
  private TextView currentVersion;
  private int device_id;
  private int device_version;
  private Dialog dialogCircle = null;
  private int failed_code;
  private int failed_count;
  private int failed_reason;
  private String filePath;
  private final UpdateHandler handler = new UpdateHandler(this);
  private boolean isAllowBack = true;
  private boolean isFirmwareUpgrade = false;
  private boolean isRestartOrUpgrade = false;
  private boolean isUpdateSuccess = false;
  private ImageView iv_Left;
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      DeviceUpdateActivity.d("onBLEConnected isRestartOrUpgrade:" + DeviceUpdateActivity.this.isRestartOrUpgrade + ",BuildConfig.DEBUG:" + false);
      if (DeviceUpdateActivity.this.isRestartOrUpgrade)
      {
        DeviceUpdateActivity.this.sendGetDeviceFun();
        return;
      }
      DeviceUpdateActivity.this.sendUpdateCmd();
    }
    
    public void onBLEDisConnected(String paramAnonymousString)
    {
      DeviceUpdateActivity.d("onBLEDisConnected");
      DeviceUpdateActivity.this.progressBar.setProgress(0);
      if (DeviceUpdateActivity.this.isFirmwareUpgrade)
      {
        DeviceUpdateActivity.d("onBLEDisConnected....update faild");
        DeviceUpdateActivity.this.updateFaild();
        DeviceUpdateActivity.this.progressView.setText(2131296493);
      }
      DeviceUpdateActivity.this.update.setEnabled(true);
    }
    
    public void onBlueToothError(int paramAnonymousInt)
    {
      DeviceUpdateActivity.d("onBlueToothError--->arg0:" + paramAnonymousInt);
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte)
    {
      DeviceUpdateActivity.d("onDataSendTimeOut");
      if (DeviceBaseCommand.getCmdId(paramAnonymousArrayOfByte) == 1) {
        DeviceUpdateActivity.this.handler.sendEmptyMessage(11);
      }
    }
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 2) {
        DeviceUpdateActivity.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
      }
      if (paramAnonymousByte == 1)
      {
        DebugLog.i(">>获取设备信息成功,需要初始化设置值，正在发送个人信息设置");
        DeviceUpdateActivity.this.sendUnitSet();
      }
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (DeviceUpdateActivity.this.isRestartOrUpgrade) {
        if (paramAnonymousBoolean) {
          switch (paramAnonymousByte)
          {
          }
        }
      }
      while ((!paramAnonymousBoolean) || (paramAnonymousByte != 1))
      {
        return;
        DebugLog.i(">>时间设置成功,获取设备信息");
        DeviceUpdateActivity.this.setUserInfo();
        return;
        DebugLog.i(">>闹钟设置成功");
        DeviceUpdateActivity.this.onReciveSettingAlarm();
        return;
        DebugLog.i(">>久坐设置成功");
        DeviceUpdateActivity.this.onReviceSettingRemindSport();
        return;
        DebugLog.i(">>防丢设置成功");
        DeviceUpdateActivity.this.onReciveLost();
        return;
        DebugLog.i(">>用户信息设置成功");
        DeviceUpdateActivity.this.onReciveUserInfo();
        return;
        DebugLog.i(">>运动目标设置成功");
        DeviceUpdateActivity.this.onReciveMultiTarget();
        return;
        DebugLog.i(">>单位设置成功");
        DeviceUpdateActivity.this.onRecivesendUnit();
        return;
        DebugLog.i(">>寻找手机设置成功");
        DeviceUpdateActivity.this.onReciveFindPhone();
        return;
        DebugLog.e("设置失败： " + paramAnonymousByte);
        return;
      }
      DeviceUpdateActivity.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
    }
    
    public void onSyncData(int paramAnonymousInt)
    {
      DebugLog.d("正在同步数据" + paramAnonymousInt + "%");
      DeviceUpdateActivity localDeviceUpdateActivity = DeviceUpdateActivity.this;
      localDeviceUpdateActivity.mSyncTem += 1;
      DeviceUpdateActivity.mProcess = paramAnonymousInt;
      DeviceUpdateActivity.this.progressView.setText(DeviceUpdateActivity.this.getString(2131296569, new Object[] { DeviceUpdateActivity.mProcess + "%" }));
      DeviceUpdateActivity.this.progressBar.setProgress(DeviceUpdateActivity.mProcess);
      if ((paramAnonymousInt == 100) || (DeviceUpdateActivity.this.mSyncTem > 1))
      {
        AppSharedPreferences.getInstance().setDeviceSyncEndTime(Calendar.getInstance());
        DebugLog.d("正在同步数据，已完成100%");
        DeviceUpdateActivity.this.sendUpdateCmd();
      }
    }
    
    public void onWareUpdate(byte paramAnonymousByte)
    {
      DeviceUpdateActivity.d("onWareUpdate");
      DeviceUpdateActivity.this.handler.sendMessage(DeviceUpdateActivity.this.handler.obtainMessage(10, Byte.valueOf(paramAnonymousByte)));
    }
  };
  private AppSharedPreferences mAppSharePreFerences = AppSharedPreferences.getInstance();
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private final BroadcastReceiver mDfuUpdateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = paramAnonymousIntent.getAction();
      DebugLog.d("*****" + paramAnonymousContext);
      if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS".equals(paramAnonymousContext))
      {
        LibSharedPreferences.getInstance().setIsFirwareUpgrade(true);
        DeviceUpdateActivity.this.isFirmwareUpgrade = true;
        int i = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
        int j = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int k = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        DeviceUpdateActivity.d("currentPart:" + j + ",totalParts:" + k + ",progress:" + i);
        DeviceUpdateActivity.this.updateProgressBar(i, j, k, false, false);
      }
      do
      {
        do
        {
          return;
          if (!"no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR".equals(paramAnonymousContext)) {
            break;
          }
        } while (DeviceUpdateActivity.this.isUpdateSuccess);
        DeviceUpdateActivity.this.showUpdateFaildTip(paramAnonymousIntent);
        DeviceUpdateActivity.this.updateFaild();
        return;
      } while ((!"com.veryfit.multi.ACTION_SINGLE_BANK_WARE_UPDATE".equals(paramAnonymousContext)) || (DeviceUpdateActivity.this.isUpdateSuccess));
      DeviceUpdateActivity.this.updateFaild();
    }
  };
  private FindPhoneRunnable mFindPhoneRunnable = null;
  private BleScanTool.ScanDeviceListener mScanDeviceListener = new BleScanTool.ScanDeviceListener()
  {
    private void close()
    {
      if (DeviceUpdateActivity.this.sTool.isScanning()) {
        DeviceUpdateActivity.this.sTool.scanLeDeviceDFU(false);
      }
    }
    
    public void onFind(BleDevice paramAnonymousBleDevice)
    {
      DeviceUpdateActivity.d("onFind....device.mDeviceAddress:" + paramAnonymousBleDevice.mDeviceAddress);
      String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
      DebugLog.d("onFind----->addr:" + AppSharedPreferences.getInstance().getBindDeviceAddr());
      if ((paramAnonymousBleDevice.mId == 10) && (paramAnonymousBleDevice.mIs == 240) && (paramAnonymousBleDevice.mLen == 13) && (!TextUtils.isEmpty(str)) && (paramAnonymousBleDevice.mDeviceAddress.equals(str)))
      {
        DebugLog.d("-----------------------扫描成功 -----------------------");
        DeviceUpdateActivity.this.startDfuService();
        close();
      }
    }
    
    public void onFinish()
    {
      DebugLog.d("onFinish----->startDfuService");
      DeviceUpdateActivity.this.startDfuService();
    }
  };
  private SettingTimeoutRunnable mSettingTimeoutRunnable = null;
  private int mSyncTem = 0;
  private TextView newVersion;
  private ProgressBar progressBar;
  private TextView progressView;
  private BleScanTool sTool = BleScanTool.getInstance();
  private Timer timerListenerBlueeth;
  private Button update;
  private int updateCount = 1;
  private TextView updateDetail;
  private DeviceUpdateInfo updateInfo;
  
  private void closeCircleDialog()
  {
    if (this.dialogCircle != null) {
      this.dialogCircle.dismiss();
    }
    if (this.mSettingTimeoutRunnable != null) {
      this.handler.removeCallbacks(this.mSettingTimeoutRunnable);
    }
  }
  
  private static void d(String paramString)
  {
    Log.d("DeviceUpdateActivity", "----------->" + paramString);
  }
  
  private void downFile()
  {
    File localFile = new File(Constant.FILE_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!TextUtils.isEmpty(this.filePath))
    {
      if (!new File(this.filePath).exists()) {
        new Thread()
        {
          public void run()
          {
            HttpUtil.downLoad(DeviceUpdateActivity.this.handler, DeviceUpdateActivity.this.filePath, DeviceUpdateActivity.this.updateInfo.file);
          }
        }.start();
      }
    }
    else {
      return;
    }
    startSync();
  }
  
  private void getDeviceUpdateInfo()
  {
    d("mAppSharePreFerences.getBindDeviceAddr():" + this.mAppSharePreFerences.getBindDeviceAddr());
    d("HttpUtil.isNetworkConnected(DeviceUpdateActivity.this):" + HttpUtil.isNetworkConnected(this));
    if ((HttpUtil.isNetworkConnected(this)) && (!this.mAppSharePreFerences.getBindDeviceAddr().equals("")))
    {
      new Thread()
      {
        public void run()
        {
          String str = HttpUtil.get("http://www.youduoyun.com/apps/firmwares/firmware.json", null);
          localObject1 = "";
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
                break label147;
              }
              DeviceUpdateActivity.this.updateInfo = ((DeviceUpdateList)localObject1).getMyDevice(LibSharedPreferences.getInstance().getDeviceId());
              if (DeviceUpdateActivity.this.updateInfo == null) {
                break label147;
              }
              DeviceUpdateActivity.this.device_id = DeviceUpdateActivity.this.updateInfo.device_id;
              DeviceUpdateActivity.this.device_version = DeviceUpdateActivity.this.updateInfo.version;
              DeviceUpdateActivity.this.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  DeviceUpdateActivity.this.filePath = (Constant.FILE_PATH + "update_" + LibSharedPreferences.getInstance().getDeviceId() + "_" + DeviceUpdateActivity.this.updateInfo.version + ".zip");
                  DeviceUpdateActivity.this.currentVersion.setText(LibSharedPreferences.getInstance().getDeviceFirmwareVersion());
                  DeviceUpdateActivity.this.newVersion.setText(DeviceUpdateActivity.this.updateInfo.version);
                  TextView localTextView = DeviceUpdateActivity.this.updateDetail;
                  DeviceUpdateActivity localDeviceUpdateActivity = DeviceUpdateActivity.this;
                  if (DeviceUpdateActivity.this.getResources().getConfiguration().locale.toString().contains("zh")) {}
                  for (String str = DeviceUpdateActivity.this.updateInfo.info_ch;; str = DeviceUpdateActivity.this.updateInfo.info_en)
                  {
                    localTextView.setText(localDeviceUpdateActivity.getString(2131296484, new Object[] { str }));
                    return;
                  }
                }
              });
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
            }
          }
          DebugLog.d(str);
          if (str == null) {}
        }
      }.start();
      return;
    }
    Toast.makeText(this, getResources().getString(2131296402), 0).show();
  }
  
  private void initTimeMode()
  {
    String str = Settings.System.getString(getContentResolver(), "time_12_24");
    if ("24".equals(str)) {
      AppSharedPreferences.getInstance().setTimeMode(true);
    }
    while (!"12".equals(str)) {
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
  }
  
  private void judgeService()
  {
    d("judgeService");
    if (!BleScanTool.getInstance().isBluetoothOpen())
    {
      d("isBluetoothOpen false");
      showBleEnableDialog();
    }
    do
    {
      return;
      d("scanLeDeviceByService true");
      this.sTool.scanLeDeviceDFU(false);
    } while (this.sTool.isScanning());
    this.sTool.scanLeDeviceDFU(true);
    this.sTool.scanLeDeviceByService(true, DFU_SERVICE_UUID);
  }
  
  private IntentFilter makeDfuUpdateIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
    localIntentFilter.addAction("com.veryfit.multi.ACTION_SINGLE_BANK_WARE_UPDATE");
    return localIntentFilter;
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
  
  private void saveUpdateFiledLog()
  {
    int i = AppSharedPreferences.getInstance().getUpdateFaild() + 1;
    AppSharedPreferences.getInstance().setUpdateFaild(i);
    HttpUtil.postUpdateNote(this, this.device_id, this.device_version, i, this.failed_code, this.failed_reason);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("*********updateFaildLog************");
    localStringBuffer.append("\n");
    localStringBuffer.append("device_id:" + this.device_id);
    localStringBuffer.append("\n");
    localStringBuffer.append("device_version:" + this.device_version);
    localStringBuffer.append("\n");
    localStringBuffer.append("updateFaild:" + i);
    localStringBuffer.append("\n");
    localStringBuffer.append("failed_code:" + this.failed_code);
    localStringBuffer.append("\n");
    localStringBuffer.append("failed_reason:" + this.failed_reason);
    localStringBuffer.append("\n");
    localStringBuffer.append("app_version:" + HttpUtil.getAppVersion(this));
    localStringBuffer.append("\n");
    localStringBuffer.append("phone_system:" + Build.MODEL);
    localStringBuffer.append("\n");
    localStringBuffer.append("phone_system_version:" + Build.VERSION.RELEASE);
    localStringBuffer.append("\n");
    localStringBuffer.append("**************************************");
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(new File(Constant.LOG_PATH, "updateFaild.txt"), true));
      localBufferedWriter.write(localStringBuffer.toString());
      localBufferedWriter.flush();
      localBufferedWriter.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
      boolean bool = this.mAppSharePreFerences.getDeviceFoundPhoneSwitch();
      if (bool)
      {
        if ((!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool))) && (!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool)))) {
          this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool));
        }
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(bool);
        this.mFindPhoneRunnable = new FindPhoneRunnable();
        this.handler.postDelayed(this.mFindPhoneRunnable, 3000L);
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
      if (!this.mAppSharePreFerences.getUserSex()) {
        break label134;
      }
      localUnits.stride = ((int)(this.mAppSharePreFerences.getUserHeight() * 0.415D));
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
      localUnits.stride = ((int)(this.mAppSharePreFerences.getUserHeight() * 0.413D));
      break label86;
      label154:
      i = 2;
    }
  }
  
  private void sendUpdateCmd()
  {
    d("sendUpdateCmd");
    if (this.mCore.isDeviceConnected())
    {
      if (this.mCore.writeForce(WareUpdateCmd.getInstance().getWareUpdateCmd()))
      {
        d("sendUpdateCmd success");
        this.progressView.setText(2131296487);
        this.progressBar.setProgress(0);
        stopService(new Intent(this, AntilostService.class));
      }
      return;
    }
    this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
    this.update.setEnabled(true);
    updating = false;
  }
  
  private void settingsSuccess()
  {
    closeCircleDialog();
    if (this.isRestartOrUpgrade) {
      this.isRestartOrUpgrade = false;
    }
    setResult(1);
    finish();
  }
  
  private void showCircleDialog()
  {
    if (this.dialogCircle == null)
    {
      this.dialogCircle = DialogUtil.showCircleProgressDialog(this, 2131296605, true);
      this.mSettingTimeoutRunnable = new SettingTimeoutRunnable();
      this.handler.postDelayed(this.mSettingTimeoutRunnable, 40000L);
    }
  }
  
  private void showUpdateFaildTip(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", -1);
    int j = paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", -1);
    DebugLog.d("*****EXTRA_DATA:" + paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", -1));
    DebugLog.d("*****EXTRA_ERROR_TYPE:" + paramIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", -1));
    DebugLog.d("*****EXTRA_DEVICE_ADDRESS:" + paramIntent.getStringExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS"));
    this.failed_code = j;
    this.failed_reason = i;
    d("showUpdateFaildTip  data:" + i);
  }
  
  private void startDfuService()
  {
    if (this.isUpdateSuccess) {
      return;
    }
    this.isFirmwareUpgrade = true;
    Intent localIntent = new Intent(this, DfuService.class);
    String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
    if (TextUtils.isEmpty(str))
    {
      DebugLog.e("设备都没有，不升级");
      return;
    }
    DebugLog.e("开始升级 addr:" + str + ",filePath:" + this.filePath + ",");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", "DfuTarg");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", this.filePath);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
    startService(localIntent);
  }
  
  private void startSync()
  {
    byte b = 0;
    d("BleScanTool.getInstance().isBluetoothOpen():" + BleScanTool.getInstance().isBluetoothOpen());
    if (!BleScanTool.getInstance().isBluetoothOpen())
    {
      d("isBluetoothOpen false");
      showBleEnableDialog();
      return;
    }
    d("isFirmwareUpgrade:" + this.isFirmwareUpgrade);
    d("mCore.isDeviceConnected():" + this.mCore.isDeviceConnected());
    if (!this.isFirmwareUpgrade)
    {
      if (this.mCore.isDeviceConnected())
      {
        LibSharedPreferences.getInstance().setSyncData(true);
        if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {
          b = 1;
        }
        this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
        return;
      }
      DebugLog.d("设备未连接");
      this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
      this.progressView.setText(2131296616);
      this.progressBar.setProgress(0);
      this.update.setEnabled(true);
      updating = false;
      return;
    }
    startWareUpdateService();
  }
  
  private void startWareUpdateService()
  {
    if (!BleScanTool.getInstance().isBluetoothOpen())
    {
      this.update.setEnabled(true);
      this.progressView.setText(2131296574);
      return;
    }
    startDfuService();
  }
  
  private void toast(String paramString)
  {
    Toast.makeText(this, paramString, 0).show();
  }
  
  private void updateFaild()
  {
    byte b = 0;
    if (this.isUpdateSuccess) {}
    do
    {
      return;
      d("升级失败次数:" + this.updateCount);
      this.updateCount += 1;
      this.progressBar.setProgress(0);
      this.progressView.setText(2131296488);
      if (this.updateCount <= 7) {
        break;
      }
      this.progressView.setText(2131296493);
      this.update.setEnabled(true);
    } while (this.failed_reason == 4106);
    toast("升级失败");
    saveUpdateFiledLog();
    return;
    if (this.updateCount > 5) {
      no.nordicsemi.android.dfu.DfuBaseService.mBuffer = new byte[12];
    }
    if (this.failed_reason == 4102)
    {
      if (this.mCore.isDeviceConnected())
      {
        LibSharedPreferences.getInstance().setSyncData(true);
        if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {
          b = 1;
        }
        this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
        return;
      }
      DebugLog.d("设备未连接");
      this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
      return;
    }
    judgeService();
  }
  
  private void updateProgressBar(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    default: 
      if (!paramBoolean1)
      {
        this.update.setEnabled(false);
        this.progressView.setText(getString(2131296486, new Object[] { Integer.valueOf(paramInt1) }));
        this.progressBar.setProgress(paramInt1);
      }
    case -7: 
    case -4: 
    case -3: 
    case -1: 
    case -2: 
    case -5: 
      do
      {
        return;
        this.progressView.setText(2131296488);
        this.handler.removeMessages(12);
        return;
        this.progressView.setText(2131296487);
        this.progressBar.setProgress(0);
        return;
        d("PROGRESS_DISCONNECTING isUpdateSuccess:" + this.isUpdateSuccess);
      } while (this.isUpdateSuccess);
      this.progressView.setText(2131296489);
      this.progressBar.setProgress(0);
      return;
    }
    updateSuccess();
  }
  
  private void updateSuccess()
  {
    this.isUpdateSuccess = true;
    d("PROGRESS_COMPLETED ");
    stopService(new Intent(this, DfuService.class));
    Object localObject = getSharedPreferences("veryfit_multi_app", 0);
    int i = ((SharedPreferences)localObject).getInt("ota_repeat_count", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("ota_repeat_count", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    HttpUtil.postUpdateNote(getApplicationContext(), this.device_id, this.device_version, this.updateCount, 0, 0);
    this.handler.removeMessages(12);
    updating = false;
    this.isFirmwareUpgrade = false;
    this.progressView.setText(2131296490);
    this.progressBar.setProgress(100);
    boolean bool = this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
    d("连接设备,,,con:" + bool);
    if (this.autoOta.isChecked())
    {
      localObject = this.autoOta;
      i = this.count + 1;
      this.count = i;
      ((CheckBox)localObject).setText(getString(2131296496, new Object[] { Integer.valueOf(i) }));
    }
    do
    {
      return;
      new File(this.filePath).delete();
      LibSharedPreferences.getInstance().setIsFirwareUpgrade(false);
      LibSharedPreferences.getInstance().setDeviceFirmwareVersion(this.updateInfo.version);
      showCircleDialog();
      onDeviceNeedInit();
    } while (AppSharedPreferences.getInstance().getAntilost() != 1);
    startService(new Intent(this, AntilostService.class));
  }
  
  protected void initData()
  {
    super.initData();
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.update.setOnClickListener(this);
  }
  
  protected void initView()
  {
    super.initView();
    this.iv_Left = ((ImageView)findViewById(2131230729));
    String str;
    if (!this.isAllowBack)
    {
      this.iv_Left.setEnabled(false);
      this.update = ((Button)findViewById(2131230755));
      this.progressView = ((TextView)findViewById(2131230757));
      this.progressBar = ((ProgressBar)findViewById(2131230756));
      this.currentVersion = ((TextView)findViewById(2131230749));
      this.newVersion = ((TextView)findViewById(2131230751));
      this.updateDetail = ((TextView)findViewById(2131230752));
      if (this.updateInfo == null) {
        break label403;
      }
      this.filePath = (Constant.FILE_PATH + "update_" + LibSharedPreferences.getInstance().getDeviceId() + "_" + this.updateInfo.version + ".zip");
      this.currentVersion.setText(LibSharedPreferences.getInstance().getDeviceFirmwareVersion());
      this.newVersion.setText(this.updateInfo.version);
      TextView localTextView = this.updateDetail;
      if (!getResources().getConfiguration().locale.toString().contains("zh")) {
        break label392;
      }
      str = this.updateInfo.info_ch;
      label269:
      localTextView.setText(getString(2131296484, new Object[] { str }));
      this.device_id = this.updateInfo.device_id;
      this.device_version = this.updateInfo.version;
    }
    for (;;)
    {
      this.autoOta = ((CheckBox)findViewById(2131230753));
      this.autoOta.setText(getString(2131296496, new Object[] { Integer.valueOf(this.count) }));
      this.autoOta.setChecked(AppSharedPreferences.getInstance().getDeviceUpdateAuto());
      this.autoOta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppSharedPreferences.getInstance().setDeviceUpdateAuto(paramAnonymousBoolean);
        }
      });
      return;
      this.iv_Left.setEnabled(true);
      break;
      label392:
      str = this.updateInfo.info_en;
      break label269;
      label403:
      getDeviceUpdateInfo();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      updating = true;
      this.update.setEnabled(false);
      this.isUpdateSuccess = false;
      this.updateCount = 1;
      this.progressBar.setProgress(0);
      this.isFirmwareUpgrade = true;
      downFile();
      return;
    } while (this.isFirmwareUpgrade);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903046);
    this.updateInfo = ((DeviceUpdateInfo)getIntent().getSerializableExtra("updateInfo"));
    this.sTool.addScanDeviceListener(this.mScanDeviceListener);
    this.isAllowBack = getIntent().getBooleanExtra("isAllowBack", true);
    super.onCreate(paramBundle);
    this.mCore.addListener(this.mAppListener);
    int i = this.mAppSharePreFerences.getDeviceUpdatePress();
    if (i > 0)
    {
      this.update.setEnabled(true);
      updating = false;
    }
    DebugLog.e("刷新进度-------" + i);
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mDfuUpdateReceiver, makeDfuUpdateIntentFilter());
    if (LibSharedPreferences.getInstance().isFirwareUpgrade()) {
      this.isFirmwareUpgrade = true;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuUpdateReceiver);
    this.mCore.removeListener(this.mAppListener);
    this.sTool.removeScanDeviceListener(this.mScanDeviceListener);
    DebugLog.e("关闭升级模式。。");
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
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (!this.isAllowBack) {
        return false;
      }
      if (!this.isFirmwareUpgrade) {
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    if (mProcess < 100) {
      this.mAppSharePreFerences.setDeviceUpdatePress(mProcess);
    }
    super.onPause();
  }
  
  protected void onReciveFindPhone()
  {
    if (this.mFindPhoneRunnable != null) {
      this.handler.removeCallbacks(this.mFindPhoneRunnable);
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
  
  protected void onThemeChanged() {}
  
  protected void sendGetDeviceFun()
  {
    if (LibSharedPreferences.getInstance().getDeviceFunMain() == -1)
    {
      DebugLog.d(">>获取功能表");
      this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
    }
    do
    {
      return;
      DebugLog.d(">>功能表已获取，获取设备信息");
    } while ((this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1))) || (this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1))) || (this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1))) || (LibSharedPreferences.getInstance().isFirwareUpgrade()));
    settingsSuccess();
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
  
  protected void setUserInfo()
  {
    Userinfos localUserinfos = new Userinfos();
    localUserinfos.height = this.mAppSharePreFerences.getUserHeight();
    localUserinfos.weight = this.mAppSharePreFerences.getUserWeight();
    if (this.mAppSharePreFerences.getUserSex()) {}
    for (int i = 0;; i = 1)
    {
      localUserinfos.gender = i;
      localUserinfos.year = this.mAppSharePreFerences.getUserBirthdayYear();
      localUserinfos.month = this.mAppSharePreFerences.getUserBirthdayMonth();
      localUserinfos.day = this.mAppSharePreFerences.getUserBirthdayDay();
      this.mCore.write(SettingsCmd.getInstance().getUserinfosSettingsCmd(localUserinfos));
      return;
    }
  }
  
  public void showBleEnableDialog()
  {
    if (this.bleEnabledialog == null)
    {
      this.bleEnabledialog = new Dialog(this, 2131427337);
      this.bleEnabledialog.setContentView(2130903079);
      this.bleEnabledialog.getWindow().setGravity(17);
      this.bleEnabledialog.setCancelable(false);
    }
    if (this.bleEnabledialog.isShowing()) {
      return;
    }
    Button localButton1 = (Button)this.bleEnabledialog.findViewById(2131230927);
    Button localButton2 = (Button)this.bleEnabledialog.findViewById(2131230928);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DeviceUpdateActivity.this.progressView.setText("");
        DeviceUpdateActivity.this.progressBar.setProgress(0);
        DeviceUpdateActivity.this.update.setEnabled(true);
        DeviceUpdateActivity.this.bleEnabledialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new OpenBluetoothListener(null));
    this.bleEnabledialog.show();
  }
  
  private class BlueToothTask
    extends TimerTask
  {
    private BlueToothTask() {}
    
    public void run()
    {
      if (BleScanTool.getInstance().isBluetoothOpen())
      {
        DeviceUpdateActivity.d("BlueToothTask bluetooth is open");
        DeviceUpdateActivity.this.timerListenerBlueeth.cancel();
        DeviceUpdateActivity.this.timerListenerBlueeth = null;
        DeviceUpdateActivity.this.judgeService();
      }
    }
  }
  
  class FindPhoneRunnable
    implements Runnable
  {
    FindPhoneRunnable() {}
    
    public void run()
    {
      DeviceUpdateActivity.this.settingsSuccess();
    }
  }
  
  private class OpenBluetoothListener
    implements View.OnClickListener
  {
    private OpenBluetoothListener() {}
    
    public void onClick(View paramView)
    {
      DeviceUpdateActivity.this.bleEnabledialog.dismiss();
      paramView = BluetoothAdapter.getDefaultAdapter();
      if ((paramView != null) && (paramView.enable()))
      {
        DeviceUpdateActivity.d("onClick BleScanTool.getInstance().isBluetoothOpen():" + BleScanTool.getInstance().isBluetoothOpen());
        DeviceUpdateActivity.this.timerListenerBlueeth = new Timer();
        paramView = new DeviceUpdateActivity.BlueToothTask(DeviceUpdateActivity.this, null);
        DeviceUpdateActivity.this.timerListenerBlueeth.schedule(paramView, 0L, 100L);
        DeviceUpdateActivity.this.updateCount = 1;
        return;
      }
      Toast.makeText(DeviceUpdateActivity.this, 2131296523, 1).show();
    }
  }
  
  class SettingTimeoutRunnable
    implements Runnable
  {
    SettingTimeoutRunnable() {}
    
    public void run()
    {
      DeviceUpdateActivity.this.settingsSuccess();
    }
  }
  
  private static class UpdateHandler
    extends Handler
  {
    WeakReference<DeviceUpdateActivity> weak;
    
    public UpdateHandler(DeviceUpdateActivity paramDeviceUpdateActivity)
    {
      this.weak = new WeakReference(paramDeviceUpdateActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      DeviceUpdateActivity localDeviceUpdateActivity = (DeviceUpdateActivity)this.weak.get();
      if (localDeviceUpdateActivity == null) {}
      do
      {
        int i;
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            i = ((Integer)paramMessage.obj).intValue();
            DeviceUpdateActivity.mProcess = i;
          }
        } while (i != 100);
        localDeviceUpdateActivity.startSync();
        return;
        localDeviceUpdateActivity.update.setEnabled(true);
        DeviceUpdateActivity.updating = false;
        Toast.makeText(localDeviceUpdateActivity, 2131296402, 0).show();
        return;
        DeviceUpdateActivity.updating = false;
        return;
        DeviceUpdateActivity.d("handleMessage UPDATE_FAILED");
        localDeviceUpdateActivity.stopService(new Intent(localDeviceUpdateActivity, DfuService.class));
        new File(localDeviceUpdateActivity.filePath).delete();
        localDeviceUpdateActivity.update.setEnabled(true);
        DeviceUpdateActivity.updating = false;
        localDeviceUpdateActivity.progressBar.setProgress(0);
        localDeviceUpdateActivity.progressView.setText(2131296493);
      } while (AppSharedPreferences.getInstance().getAntilost() != 1);
      localDeviceUpdateActivity.startService(new Intent(localDeviceUpdateActivity, AntilostService.class));
      return;
      switch (((Byte)paramMessage.obj).byteValue())
      {
      default: 
        return;
      case 0: 
        DebugLog.e("准备升级喽");
        localDeviceUpdateActivity.update.setEnabled(false);
        localDeviceUpdateActivity.startWareUpdateService();
        return;
      case 1: 
        localDeviceUpdateActivity.progressView.setText(2131296491);
        localDeviceUpdateActivity.update.setEnabled(true);
        DeviceUpdateActivity.updating = false;
        return;
      }
      localDeviceUpdateActivity.progressView.setText(2131296492);
      localDeviceUpdateActivity.update.setEnabled(true);
      DeviceUpdateActivity.updating = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\DeviceUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */