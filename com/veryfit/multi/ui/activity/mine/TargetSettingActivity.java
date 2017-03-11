package com.veryfit.multi.ui.activity.mine;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.Goal;
import com.project.library.device.cmd.settings.MultiTarget;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.BaseNotifyBleActivity;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.RulerView;
import java.util.Arrays;
import java.util.Calendar;

public class TargetSettingActivity
  extends BaseNotifyBleActivity
  implements View.OnClickListener
{
  private int[] goal;
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private RulerView ruler_sleep;
  private RulerView ruler_sport;
  private TextView tv_cancel;
  private TextView tv_sure;
  
  private void sendData(int[] paramArrayOfInt)
  {
    MultiTarget localMultiTarget = new MultiTarget();
    localMultiTarget.sportType = 0;
    localMultiTarget.sportTarget = paramArrayOfInt[0];
    localMultiTarget.sleepFlag = 0;
    localMultiTarget.sleepHour = (paramArrayOfInt[1] / 60);
    localMultiTarget.sleepMinute = (paramArrayOfInt[1] % 60);
    this.mCore.addListener(this.mAppListener);
    if (writeData(SettingsCmd.getInstance().getMultiTargetSettingsCmd(localMultiTarget)))
    {
      showProgress();
      return;
    }
    onDataSendFailed();
  }
  
  protected void initData()
  {
    super.initData();
    this.goal = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    this.ruler_sport.setData(this.goal[0]);
    this.ruler_sleep.setData(this.goal[1]);
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.tv_sure.setOnClickListener(this);
    this.tv_cancel.setOnClickListener(this);
  }
  
  protected void initFirst()
  {
    super.initFirst();
  }
  
  protected void initView()
  {
    super.initView();
    ScreenUtil.setNavigationBar(this);
    this.tv_cancel = ((TextView)findViewById(2131230729));
    this.tv_sure = ((TextView)findViewById(2131230737));
    this.ruler_sleep = ((RulerView)findViewById(2131230913));
    this.ruler_sport = ((RulerView)findViewById(2131230912));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903073);
    super.onCreate(paramBundle);
  }
  
  protected void onDataSendFailed()
  {
    Util.showToast(this, 2131296398, 0);
    showSureBtn();
  }
  
  protected void onSettingsSuccess()
  {
    showSureBtn();
    AppSharedPreferences.getInstance().setFlagGoalChange(false);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.ruler_sport.getCenterData();
    arrayOfInt[1] = this.ruler_sleep.getCenterData();
    TempUtil.saveGoal(new Goal[] { new Goal(arrayOfInt[0], 0), new Goal(arrayOfInt[1], 1) });
    finish();
  }
  
  protected void onThemeChanged() {}
  
  protected void saveDate()
  {
    if (this.mCore.isDeviceConnected())
    {
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = this.ruler_sport.getCenterData();
      arrayOfInt[1] = this.ruler_sleep.getCenterData();
      if (Arrays.equals(arrayOfInt, this.goal))
      {
        finish();
        return;
      }
      AppSharedPreferences.getInstance().setFlagGoalChange(true);
      sendData(arrayOfInt);
      return;
    }
    Util.showToast(this, 2131296616, 0);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\TargetSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */