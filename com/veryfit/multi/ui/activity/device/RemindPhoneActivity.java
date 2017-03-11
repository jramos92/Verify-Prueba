package com.veryfit.multi.ui.activity.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.view.group.ItemToggleLayout;
import com.veryfit.multi.view.group.ItemToggleLayout.OnToggleListener;

public class RemindPhoneActivity
  extends BaseActivity
{
  private static final int MAX_DELAY = 30;
  private static final int MIN_DELAY = 3;
  private int delay;
  private SeekBar delayBar;
  private TextView delayValue;
  private boolean isOpen;
  private SeekBar.OnSeekBarChangeListener seekChange = new SeekBar.OnSeekBarChangeListener()
  {
    public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      RemindPhoneActivity.this.setDelayValue(paramAnonymousInt + 3);
    }
    
    public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    
    public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
  };
  private ItemToggleLayout toggle;
  private RelativeLayout tv_min_max;
  
  private boolean dataHasChange()
  {
    if ((this.toggle.isOpen() == this.isOpen) && (this.delay == this.delayBar.getProgress() + 3)) {}
    for (boolean bool = false;; bool = true)
    {
      this.delay = (this.delayBar.getProgress() + 3);
      return bool;
    }
  }
  
  private void loadData()
  {
    AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
    this.delay = localAppSharedPreferences.getDeviceRemindPhoneDelay();
    this.isOpen = localAppSharedPreferences.getDeviceRemindPhoneSwitch();
  }
  
  private void setDelayValue(int paramInt)
  {
    String str = getResources().getString(2131296526, new Object[] { Integer.valueOf(paramInt) });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(paramInt);
    paramInt = i + paramInt.length();
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131099648)), i, paramInt, 33);
    localSpannableString.setSpan(new RelativeSizeSpan(2.0F), i, paramInt, 33);
    this.delayValue.setText(localSpannableString);
  }
  
  protected void initView()
  {
    this.tv_min_max = ((RelativeLayout)findViewById(2131230854));
    this.delayValue = ((TextView)findViewById(2131230852));
    setDelayValue(this.delay);
    this.delayBar = ((SeekBar)findViewById(2131230853));
    this.delayBar.setMax(27);
    this.delayBar.setProgress(this.delay - 3);
    this.delayBar.setOnSeekBarChangeListener(this.seekChange);
    this.toggle = ((ItemToggleLayout)findViewById(2131230851));
    this.toggle.setOpen(this.isOpen);
    this.toggle.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
    {
      public void onToggle(boolean paramAnonymousBoolean)
      {
        RemindPhoneActivity.this.setVisible(paramAnonymousBoolean);
      }
    });
    setVisible(this.toggle.isOpen());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230729: 
      finish();
      return;
    }
    if (dataHasChange())
    {
      AppSharedPreferences.getInstance().setDeviceRemindPhoneSwitch(this.toggle.isOpen());
      AppSharedPreferences.getInstance().setDeviceRemindPhoneDelay(this.delay);
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903062);
    loadData();
    initView();
    super.onCreate(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onThemeChanged() {}
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.delayBar.setVisibility(0);
      this.delayValue.setVisibility(0);
      this.tv_min_max.setVisibility(0);
      return;
    }
    this.delayBar.setVisibility(4);
    this.delayValue.setVisibility(4);
    this.tv_min_max.setVisibility(4);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\RemindPhoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */