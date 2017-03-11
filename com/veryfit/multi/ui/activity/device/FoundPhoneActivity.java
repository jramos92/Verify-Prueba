package com.veryfit.multi.ui.activity.device;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.view.group.ItemLableValue;
import com.veryfit.multi.view.group.ItemToggleLayout;
import com.veryfit.multi.view.group.ItemToggleLayout.OnToggleListener;

public class FoundPhoneActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final int requestCode = 1;
  private ImageView bar_left;
  private ItemLableValue ringtone;
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  private ItemToggleLayout toggle_bell_vibrate;
  private ItemToggleLayout toggle_found_phone;
  private ItemToggleLayout toggle_mute_vibrate;
  
  protected void initView()
  {
    this.bar_left = ((ImageView)findViewById(2131230729));
    this.bar_left.setOnClickListener(this);
    this.toggle_found_phone = ((ItemToggleLayout)findViewById(2131230770));
    this.toggle_mute_vibrate = ((ItemToggleLayout)findViewById(2131230771));
    this.toggle_bell_vibrate = ((ItemToggleLayout)findViewById(2131230772));
    this.ringtone = ((ItemLableValue)findViewById(2131230773));
    this.ringtone.setOnClickListener(this);
    this.toggle_found_phone.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
    {
      public void onToggle(boolean paramAnonymousBoolean)
      {
        FoundPhoneActivity.this.share.setDeviceFoundPhoneSwitch(paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          FoundPhoneActivity.this.toggle_mute_vibrate.setOpen(true);
          FoundPhoneActivity.this.share.setDeviceMuteVibrateSwitch(true);
          return;
        }
        FoundPhoneActivity.this.toggle_mute_vibrate.setOpen(false);
        FoundPhoneActivity.this.toggle_bell_vibrate.setOpen(false);
        FoundPhoneActivity.this.share.setDeviceMuteVibrateSwitch(false);
        FoundPhoneActivity.this.share.setDeviceBellVibrateSwitch(false);
      }
    });
    this.toggle_mute_vibrate.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
    {
      public void onToggle(boolean paramAnonymousBoolean)
      {
        FoundPhoneActivity.this.share.setDeviceMuteVibrateSwitch(paramAnonymousBoolean);
      }
    });
    this.toggle_bell_vibrate.setOnToggleListener(new ItemToggleLayout.OnToggleListener()
    {
      public void onToggle(boolean paramAnonymousBoolean)
      {
        FoundPhoneActivity.this.share.setDeviceBellVibrateSwitch(paramAnonymousBoolean);
      }
    });
    this.toggle_found_phone.setOpen(this.share.getDeviceFoundPhoneSwitch());
    this.toggle_mute_vibrate.setOpen(this.share.getDeviceMuteVibrateSwitch());
    this.toggle_bell_vibrate.setOpen(this.share.getDeviceBellVibrateSwitch());
    if (TextUtils.isEmpty(this.share.getRingtoneName())) {
      this.ringtone.setValue(getResources().getString(2131296645));
    }
    for (;;)
    {
      super.initView();
      return;
      this.ringtone.setValue(this.share.getRingtoneName());
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1 == paramInt1)
    {
      if (TextUtils.isEmpty(this.share.getRingtoneName())) {
        this.ringtone.setValue(getResources().getString(2131296645));
      }
    }
    else {
      return;
    }
    this.ringtone.setValue(this.share.getRingtoneName());
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
    startActivityForResult(new Intent(this, RingtoneActivity.class), 1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903051);
    super.onCreate(paramBundle);
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\FoundPhoneActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */