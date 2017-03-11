package com.veryfit.multi.ui.activity.device;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.settings.Sedentariness;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.BaseNotifyBleActivity;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.view.group.ItemLableValue;
import com.veryfit.multi.view.group.ItemToggleLayout;
import com.veryfit.multi.view.group.ItemToggleLayout.OnToggleListener;
import com.veryfit.multi.view.group.WeekDayCheck;
import com.veryfit.multi.view.wheel.ArrayWheelAdapter;
import com.veryfit.multi.view.wheel.NumericWheelAdapter;
import com.veryfit.multi.view.wheel.WheelView;

public class RemindSportSetActivity
  extends BaseNotifyBleActivity
{
  private static final int MAX_INTERVAL = 180;
  private static final int MIN_INTERVAL = 15;
  private WeekDayCheck dayCheck;
  private ItemLableValue endView;
  private TextView intervalValueView;
  private SeekBar intervalView;
  private boolean is24 = true;
  private View line;
  private Sedentariness sedentariness = new Sedentariness();
  private SeekBar.OnSeekBarChangeListener seeklistener = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      RemindSportSetActivity.this.sedentariness.interval = (paramAnonymousInt + 15);
      RemindSportSetActivity.this.setIntervalValue();
    }
    
    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
  };
  private AppSharedPreferences share;
  private ItemLableValue startView;
  private ItemToggleLayout toggle;
  private RelativeLayout tv_min_max;
  
  private void createDialog(final boolean paramBoolean)
  {
    final Dialog localDialog = new Dialog(this, 2131427345);
    localDialog.setContentView(2130903089);
    localDialog.getWindow().setGravity(80);
    localDialog.getWindow().getAttributes().width = getWindowManager().getDefaultDisplay().getWidth();
    final WheelView localWheelView1 = (WheelView)localDialog.findViewById(2131230963);
    final String[] arrayOfString = getResources().getStringArray(2131361796);
    final WheelView localWheelView2;
    label117:
    label129:
    label136:
    final WheelView localWheelView3;
    if (this.is24)
    {
      localWheelView1.setVisibility(8);
      localWheelView2 = (WheelView)localDialog.findViewById(2131230964);
      if (!this.is24) {
        break label326;
      }
      localWheelView2.setAdapter(new NumericWheelAdapter(0, 23));
      if (!paramBoolean) {
        break label344;
      }
      i = this.sedentariness.startHour;
      if (!this.is24) {
        break label355;
      }
      localWheelView2.setCurrentItem(i);
      localWheelView3 = (WheelView)localDialog.findViewById(2131230965);
      localWheelView3.setAdapter(new NumericWheelAdapter(0, 59));
      if (!paramBoolean) {
        break label365;
      }
    }
    label326:
    label344:
    label355:
    label365:
    for (int i = this.sedentariness.startMinute;; i = this.sedentariness.endMinute)
    {
      localWheelView3.setCurrentItem(i);
      localDialog.findViewById(2131230936).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDialog.dismiss();
        }
      });
      localDialog.findViewById(2131230937).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          boolean bool2 = true;
          boolean bool1 = true;
          int j = localWheelView2.getCurrentItem();
          int i = localWheelView3.getCurrentItem();
          if (RemindSportSetActivity.this.is24)
          {
            if (paramBoolean)
            {
              RemindSportSetActivity.this.startView.setValue(Util.formatTime(j, i));
              RemindSportSetActivity.this.sedentariness.startHour = j;
              RemindSportSetActivity.this.sedentariness.startMinute = i;
            }
            for (;;)
            {
              localDialog.dismiss();
              return;
              RemindSportSetActivity.this.endView.setValue(Util.formatTime(j, i));
              RemindSportSetActivity.this.sedentariness.endHour = j;
              RemindSportSetActivity.this.sedentariness.endMinute = i;
            }
          }
          paramAnonymousView = arrayOfString[localWheelView1.getCurrentItem()];
          j += 1;
          if (paramBoolean)
          {
            RemindSportSetActivity.this.startView.setValue(paramAnonymousView + " " + Util.formatTime(j, i));
            paramAnonymousView = RemindSportSetActivity.this.sedentariness;
            if (localWheelView1.getCurrentItem() == 0) {}
            for (;;)
            {
              paramAnonymousView.startHour = Util.format12To24(j, bool1);
              RemindSportSetActivity.this.sedentariness.startMinute = i;
              break;
              bool1 = false;
            }
          }
          RemindSportSetActivity.this.endView.setValue(paramAnonymousView + " " + Util.formatTime(j, i));
          paramAnonymousView = RemindSportSetActivity.this.sedentariness;
          if (localWheelView1.getCurrentItem() == 0) {}
          for (bool1 = bool2;; bool1 = false)
          {
            paramAnonymousView.endHour = Util.format12To24(j, bool1);
            RemindSportSetActivity.this.sedentariness.endMinute = i;
            break;
          }
        }
      });
      localDialog.show();
      return;
      localWheelView1.setAdapter(new ArrayWheelAdapter(arrayOfString, 30));
      if (paramBoolean)
      {
        if (Util.isAM(this.sedentariness.startHour)) {}
        for (i = 0;; i = 1)
        {
          localWheelView1.setCurrentItem(i);
          localWheelView1.setCyclic(false);
          localWheelView1.setVisibility(0);
          break;
        }
      }
      if (Util.isAM(this.sedentariness.endHour)) {}
      for (i = 0;; i = 1)
      {
        localWheelView1.setCurrentItem(i);
        break;
      }
      localWheelView2.setAdapter(new NumericWheelAdapter(1, 12));
      break label117;
      i = this.sedentariness.endHour;
      break label129;
      i = Util.format24To12(i) - 1;
      break label136;
    }
  }
  
  private boolean dataHasChange()
  {
    boolean bool = false;
    this.sedentariness.repetitions = this.dayCheck.getRepetition();
    Sedentariness localSedentariness;
    if (this.toggle.isOpen()) {
      localSedentariness = this.sedentariness;
    }
    for (localSedentariness.repetitions |= 0x1;; localSedentariness.repetitions &= 0xFFFFFFFE)
    {
      if (this.share.getDeviceRemindSportRepetitions() != this.sedentariness.repetitions)
      {
        this.share.setDeviceRemindSportRepetitions(this.sedentariness.repetitions);
        bool = true;
      }
      if (this.share.getDeviceRemindSportStartHour() != this.sedentariness.startHour)
      {
        this.share.setDeviceRemindSportStartHour(this.sedentariness.startHour);
        bool = true;
      }
      if (this.share.getDeviceRemindSportStartMin() != this.sedentariness.startMinute)
      {
        this.share.setDeviceRemindSportStartMin(this.sedentariness.startMinute);
        bool = true;
      }
      if (this.share.getDeviceRemindSportEndHour() != this.sedentariness.endHour)
      {
        this.share.setDeviceRemindSportEndHour(this.sedentariness.endHour);
        bool = true;
      }
      if (this.share.getDeviceRemindSportEndMin() != this.sedentariness.endMinute)
      {
        this.share.setDeviceRemindSportEndMin(this.sedentariness.endMinute);
        bool = true;
      }
      if (this.share.getDeviceRemindSportInterval() != this.sedentariness.interval)
      {
        this.share.setDeviceRemindSportInterval(this.sedentariness.interval);
        bool = true;
      }
      if (bool) {
        this.share.setFlagDeviceRemindSportChange(bool);
      }
      return bool;
      localSedentariness = this.sedentariness;
    }
  }
  
  private void initview()
  {
    int j = 0;
    this.tv_min_max = ((RelativeLayout)findViewById(2131230854));
    this.dayCheck = ((WeekDayCheck)findViewById(2131230871));
    this.dayCheck.initAndSetDefault(this.sedentariness.repetitions);
    this.toggle = ((ItemToggleLayout)findViewById(2131230865));
    Object localObject = this.toggle;
    if ((this.sedentariness.repetitions & 0x1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((ItemToggleLayout)localObject).setOpen(bool);
      this.startView = ((ItemLableValue)findViewById(2131230869));
      localObject = getResources().getStringArray(2131361796);
      if (!this.is24) {
        break;
      }
      this.startView.setValue(Util.formatTime(this.sedentariness.startHour, this.sedentariness.startMinute));
      this.endView = ((ItemLableValue)findViewById(2131230870));
      if (!this.is24) {
        break label392;
      }
      this.endView.setValue(Util.formatTime(this.sedentariness.endHour, this.sedentariness.endMinute));
      this.intervalView = ((SeekBar)findViewById(2131230867));
      this.intervalView.setMax(165);
      this.intervalView.setProgress(this.sedentariness.interval - 15);
      this.intervalView.setOnSeekBarChangeListener(this.seeklistener);
      this.line = findViewById(2131230868);
      this.intervalValueView = ((TextView)findViewById(2131230866));
      setIntervalValue();
      this.toggle.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
      {
        public void onToggle(boolean paramAnonymousBoolean)
        {
          RemindSportSetActivity.this.setVisible(paramAnonymousBoolean);
        }
      });
      setVisible(this.toggle.isOpen());
      return;
    }
    if (Util.isAM(this.sedentariness.startHour)) {}
    for (int i = 0;; i = 1)
    {
      String str = new StringBuilder(String.valueOf(localObject[i])).append(" ").toString() + Util.formatTime(Util.format24To12(this.sedentariness.startHour), this.sedentariness.startMinute);
      this.startView.setValue(str);
      break;
    }
    label392:
    if (Util.isAM(this.sedentariness.endHour)) {}
    for (i = j;; i = 1)
    {
      localObject = new StringBuilder(String.valueOf(localObject[i])).append(" ").toString() + Util.formatTime(Util.format24To12(this.sedentariness.endHour), this.sedentariness.endMinute);
      this.endView.setValue((String)localObject);
      break;
    }
  }
  
  private void loadData()
  {
    this.share = AppSharedPreferences.getInstance();
    this.sedentariness.repetitions = this.share.getDeviceRemindSportRepetitions();
    this.sedentariness.startHour = this.share.getDeviceRemindSportStartHour();
    this.sedentariness.startMinute = this.share.getDeviceRemindSportStartMin();
    this.sedentariness.endHour = this.share.getDeviceRemindSportEndHour();
    this.sedentariness.endMinute = this.share.getDeviceRemindSportEndMin();
    this.sedentariness.interval = this.share.getDeviceRemindSportInterval();
    if ("24".equals(Settings.System.getString(getContentResolver(), "time_12_24"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.is24 = bool;
      return;
    }
  }
  
  private void setIntervalValue()
  {
    String str = getResources().getString(2131296562, new Object[] { Integer.valueOf(this.sedentariness.interval) });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(this.sedentariness.interval);
    int j = i + this.sedentariness.interval.length();
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131099648)), i, j, 33);
    localSpannableString.setSpan(new RelativeSizeSpan(2.0F), i, j, 33);
    this.intervalValueView.setText(localSpannableString);
  }
  
  public void onClick(View paramView)
  {
    DebugLog.d("OnClick");
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230869: 
      createDialog(true);
      return;
    case 2131230870: 
      createDialog(false);
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903067);
    super.onCreate(paramBundle);
    loadData();
    initview();
  }
  
  protected void onDataSendFailed()
  {
    showSureBtn();
    this.mCore.removeListener(this.mAppListener);
  }
  
  protected void onSettingsSuccess()
  {
    this.mCore.removeListener(this.mAppListener);
    this.sendingData = false;
    finish();
  }
  
  protected void onThemeChanged() {}
  
  protected void saveDate()
  {
    if (dataHasChange())
    {
      showProgress();
      this.mCore.addListener(this.mAppListener);
      this.sendingData = writeData(SettingsCmd.getInstance().getSedentarinessSettingsCmd(this.sedentariness));
      if (!this.sendingData)
      {
        Toast.makeText(this, 2131296398, 0).show();
        this.mCore.removeListener(this.mAppListener);
        showSureBtn();
      }
      return;
    }
    finish();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.startView.setVisibility(0);
      this.endView.setVisibility(0);
      this.dayCheck.setVisibility(0);
      this.intervalView.setVisibility(0);
      this.intervalValueView.setVisibility(0);
      this.line.setVisibility(0);
      this.tv_min_max.setVisibility(0);
      return;
    }
    this.startView.setVisibility(4);
    this.endView.setVisibility(4);
    this.dayCheck.setVisibility(4);
    this.intervalView.setVisibility(4);
    this.intervalValueView.setVisibility(4);
    this.line.setVisibility(4);
    this.tv_min_max.setVisibility(4);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\RemindSportSetActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */