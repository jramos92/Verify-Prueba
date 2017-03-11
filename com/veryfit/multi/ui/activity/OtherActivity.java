package com.veryfit.multi.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.BindUnbindCmd;
import com.project.library.device.cmd.DeviceRestartCmd;
import com.project.library.device.cmd.WareUpdateCmd;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
import com.project.library.device.cmd.health.HealthSyncSuccess;
import com.project.library.device.cmd.notify.IncomingCall;
import com.project.library.device.cmd.notify.NotifyCmd;
import com.project.library.device.cmd.settings.MultiTarget;
import com.project.library.device.cmd.settings.Sedentariness;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.device.cmd.settings.Userinfos;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import java.io.PrintStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import no.nordicsemi.android.dfu.DfuService;

public class OtherActivity
  extends BaseActivity
{
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEDisConnected(String paramAnonymousString)
    {
      OtherActivity.this.mCore.removeListener(this);
      OtherActivity.this.finish();
    }
    
    public void onBindUnbind(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 18) {
        DebugLog.e("绑定成功");
      }
      while (paramAnonymousByte != 20) {
        return;
      }
      DebugLog.e("解绑成功");
      OtherActivity.this.mCore.removeListener(this);
      OtherActivity.this.finish();
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte) {}
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        DebugLog.e("设置成功： " + paramAnonymousByte);
        AlarmNotify localAlarmNotify;
        if (paramAnonymousByte == 2)
        {
          OtherActivity.this.mAlarmList.poll();
          localAlarmNotify = (AlarmNotify)OtherActivity.this.mAlarmList.peek();
          if (localAlarmNotify == null) {
            DebugLog.e("全部闹钟设置成功。");
          }
        }
        else
        {
          return;
        }
        OtherActivity.this.mCore.writeForce(SettingsCmd.getInstance().getAlarmClockSettingsCmd(localAlarmNotify));
        return;
      }
      DebugLog.e("设置失败： " + paramAnonymousByte);
    }
    
    public void onSyncData(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 100)
      {
        DebugLog.d("APP收到同步数据结束");
        OtherActivity.this.textId1.setText("同步数据结束。。。");
        return;
      }
      OtherActivity.this.textId1.setText("正在同步数据，已完成" + paramAnonymousInt + "%");
    }
    
    public void onWareUpdate(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 0)
      {
        DebugLog.e("准备升级喽");
        OtherActivity.this.startWareUpdateService();
      }
    }
  };
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private final BroadcastReceiver mDfuUpdateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS".equals(paramAnonymousIntent.getAction()))
      {
        int i = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
        int j = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int k = paramAnonymousIntent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        OtherActivity.this.updateProgressBar(i, j, k, false, false);
      }
    }
  };
  Button syncDataMode;
  TextView textId1;
  
  private void connect()
  {
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
        if (TextUtils.isEmpty(str))
        {
          DebugLog.e("设备都没有，连接");
          return;
        }
        OtherActivity.this.mCore.connect(str);
      }
    }, 2000L);
  }
  
  private byte getSafeMode()
  {
    if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {
      return 1;
    }
    return 0;
  }
  
  private static IntentFilter makeDfuUpdateIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
    localIntentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
    return localIntentFilter;
  }
  
  private void showInitData()
  {
    showSafeMode(AppSharedPreferences.getInstance().getSyncHealdataMode());
  }
  
  private void showSafeMode(boolean paramBoolean)
  {
    Button localButton = this.syncDataMode;
    if (paramBoolean) {}
    for (String str = "现在为安全模式";; str = "现在为非安全模式")
    {
      localButton.setText(str);
      return;
    }
  }
  
  private void startWareUpdateService()
  {
    Intent localIntent = new Intent(this, DfuService.class);
    String str = AppSharedPreferences.getInstance().getBindDeviceAddr();
    if (TextUtils.isEmpty(str))
    {
      DebugLog.e("设备都没有，不升级");
      return;
    }
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", "DfuTarg");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", Constant.APP_ROOT_PATH + "/veryfit2.zip");
    localIntent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
    startService(localIntent);
  }
  
  private void updateProgressBar(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    default: 
      if (!paramBoolean1) {
        this.textId1.setText(paramInt1 + "%");
      }
    case -7: 
    case -5: 
    case -4: 
    case -3: 
    case -2: 
    case -1: 
      return;
    }
    this.textId1.setText("升级完成。。");
    connect();
  }
  
  public void Bind(View paramView)
  {
    this.mCore.writeForce(BindUnbindCmd.getInstance().getBindCmd());
  }
  
  public void UnitSettings(View paramView)
  {
    paramView = new Units();
    paramView.dist = 1;
    paramView.weight = 1;
    paramView.temp = 1;
    paramView.stride = 1;
    this.mCore.writeForce(SettingsCmd.getInstance().getUnitSettingsCmd(paramView));
  }
  
  public void UserInfosSettings(View paramView)
  {
    paramView = new Userinfos();
    paramView.height = 200;
    paramView.weight = 100;
    paramView.gender = 0;
    paramView.year = 2000;
    paramView.month = 10;
    paramView.day = 10;
    this.mCore.writeForce(SettingsCmd.getInstance().getUserinfosSettingsCmd(paramView));
  }
  
  public void alarmSettings(View paramView)
  {
    int i;
    if (this.mAlarmList.isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i > 5)
      {
        this.mCore.writeForce(SettingsCmd.getInstance().getAlarmClockSettingsCmd((AlarmNotify)this.mAlarmList.peek()));
        return;
      }
      paramView = new AlarmNotify();
      paramView.setAlarmId(i);
      paramView.setAlarmStatus(85);
      paramView.setAlarmType(2);
      paramView.setAlarmHour(12);
      paramView.setAlarmMinute(0);
      paramView.setAlarmRepetitions(1);
      paramView.setAlarmSnoozeDuration(0);
      this.mAlarmList.add(paramView);
      i += 1;
    }
  }
  
  public void closeSync(View paramView)
  {
    this.mCore.writeForce(HealthSyncSuccess.getInstance().getHealthSyncSuccessCmd((byte)1, getSafeMode()));
  }
  
  public void deviceRestart(View paramView)
  {
    this.mCore.writeForce(DeviceRestartCmd.getInstance().getDeviceRestartCmd());
  }
  
  public void getDeviceInfosBasic(View paramView)
  {
    this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
  }
  
  public void getDeviceInfosBattery(View paramView)
  {
    this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)5));
  }
  
  public void getDeviceInfosFunction(View paramView)
  {
    this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
  }
  
  public void getDeviceInfosMac(View paramView)
  {
    this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)4));
  }
  
  public void getDeviceInfosTime(View paramView)
  {
    this.mCore.write(GetInfoCmd.getInstance().getGetInfoCmd((byte)3));
  }
  
  public void incomingCallNotify(View paramView)
  {
    paramView = new IncomingCall();
    this.mCore.writeForce(NotifyCmd.getInstance().getIncomingCallCmd(paramView));
  }
  
  public void incomingCallStatusNotify(View paramView)
  {
    this.mCore.writeForce(NotifyCmd.getInstance().getIncomingCallStatusCmd((byte)1));
  }
  
  public void incomingMessageNotify(View paramView) {}
  
  public void multiTargetSettings(View paramView)
  {
    paramView = new MultiTarget();
    paramView.sportType = 0;
    paramView.sportTarget = 10000;
    paramView.sleepFlag = 0;
    paramView.sleepHour = 8;
    paramView.sleepMinute = 30;
    this.mCore.writeForce(SettingsCmd.getInstance().getMultiTargetSettingsCmd(paramView));
  }
  
  public void onConnect(View paramView)
  {
    connect();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903059);
    this.textId1 = ((TextView)findViewById(2131230830));
    this.syncDataMode = ((Button)findViewById(2131230831));
    this.mCore.addListener(this.mAppListener);
    showInitData();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.mCore.removeListener(this.mAppListener);
      setResult(-1);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuUpdateReceiver);
  }
  
  protected void onResume()
  {
    super.onResume();
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mDfuUpdateReceiver, makeDfuUpdateIntentFilter());
  }
  
  protected void onThemeChanged() {}
  
  public void openSync(View paramView)
  {
    LibSharedPreferences.getInstance().setSyncData(false);
    this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, getSafeMode()));
  }
  
  public void sedentarinessSettings(View paramView)
  {
    paramView = new Sedentariness();
    paramView.startHour = 10;
    paramView.startMinute = 10;
    paramView.endHour = 20;
    paramView.endMinute = 20;
    paramView.interval = 30;
    paramView.repetitions = 8;
    this.mCore.writeForce(SettingsCmd.getInstance().getSedentarinessSettingsCmd(paramView));
  }
  
  public void syncData(View paramView)
  {
    this.textId1.setText("开始同步数据");
    LibSharedPreferences.getInstance().setSyncData(true);
    this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, getSafeMode()));
  }
  
  public void syncDataMode(View paramView)
  {
    boolean bool2 = false;
    boolean bool3 = AppSharedPreferences.getInstance().getSyncHealdataMode();
    paramView = AppSharedPreferences.getInstance();
    if (bool3)
    {
      bool1 = false;
      paramView.setSyncHealdataMode(bool1);
      if (!bool3) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      showSafeMode(bool1);
      return;
      bool1 = true;
      break;
    }
  }
  
  public void timeSettings(View paramView)
  {
    this.mCore.write(SettingsCmd.getInstance().getTimeSettingsCmd());
  }
  
  public void unBind(View paramView)
  {
    this.mCore.writeForce(BindUnbindCmd.getInstance().getUnbindCmd());
  }
  
  public void wareUpdate(View paramView)
  {
    System.out.println("固件升级");
    this.mCore.write(WareUpdateCmd.getInstance().getWareUpdateCmd());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\OtherActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */