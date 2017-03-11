package com.veryfit.multi.ui.activity.device;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.RelativeLayout;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.database.AlarmNotifyDao;
import com.project.library.database.DaoSession;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.BaseNotifyBleActivity;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.view.group.ItemAlarmSet;

public class AlarmSetActivity
  extends BaseNotifyBleActivity
{
  private AlarmNotify alarm;
  private boolean is24;
  private RelativeLayout mAlarmSetRl;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte) {}
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean) {}
  };
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private ItemAlarmSet name;
  private ItemAlarmSet remind;
  private ItemAlarmSet repeat;
  private ItemAlarmSet time;
  
  private void saveData()
  {
    this.alarm.setAlarmType(((Integer)this.remind.getValue()[0]).intValue());
    this.alarm.setAlarmRepetitions(((Integer)this.repeat.getValue()[0]).intValue());
    this.alarm.setAlarmHour(((Integer)this.time.getValue()[0]).intValue());
    this.alarm.setAlarmMinute(((Integer)this.time.getValue()[1]).intValue());
    DBTool.getInstance().getDaoSession().getAlarmNotifyDao().update(this.alarm);
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd(this.alarm));
    DebugLog.d(this.alarm.toString());
  }
  
  protected void initView()
  {
    this.remind = ((ItemAlarmSet)findViewById(2131230742));
    this.repeat = ((ItemAlarmSet)findViewById(2131230743));
    this.time = ((ItemAlarmSet)findViewById(2131230744));
    this.name = ((ItemAlarmSet)findViewById(2131230745));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230741: 
      finish();
      return;
    }
    saveData();
    paramView = new Intent();
    paramView.putExtra("alarm", this.alarm);
    setResult(1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ScreenUtil.setImmersiveStatusBar(this, ScreenUtil.getAndroidVersionThanKitkat());
    setContentView(2130903044);
    this.alarm = ((AlarmNotify)getIntent().getParcelableExtra("alarm"));
    initView();
    if ("24".equals(Settings.System.getString(getContentResolver(), "time_12_24")))
    {
      this.is24 = true;
      AppSharedPreferences.getInstance().setTimeMode(true);
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
    this.is24 = false;
  }
  
  protected void onDataSendFailed() {}
  
  protected void onPause()
  {
    super.onPause();
    this.alarm.setAlarmHour(((Integer)this.time.getValue()[0]).intValue());
    DebugLog.d("hour = " + (Integer)this.time.getValue()[0]);
    this.alarm.setAlarmMinute(((Integer)this.time.getValue()[1]).intValue());
  }
  
  protected void onResume()
  {
    super.onResume();
    this.remind.setStubType(1, new Object[] { Integer.valueOf(this.alarm.getAlarmType()) });
    this.repeat.setStubType(2, new Object[] { Integer.valueOf(this.alarm.getAlarmRepetitions()) });
    this.time.setStubType(3, new Object[] { Integer.valueOf(this.alarm.getAlarmHour()), Integer.valueOf(this.alarm.getAlarmMinute()) });
    this.name.setStubType(4, new Object[] { getResources().getStringArray(2131361795)[this.alarm.getAlarmType()] });
    DebugLog.d("hour = " + (Integer)this.time.getValue()[0]);
    this.time.showTime12(Integer.valueOf(this.alarm.getAlarmHour()), Integer.valueOf(this.alarm.getAlarmMinute()), this.is24);
  }
  
  protected void onSettingsSuccess() {}
  
  protected void onThemeChanged() {}
  
  protected void saveDate() {}
  
  protected void setNavigationBar() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\AlarmSetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */