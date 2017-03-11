package com.veryfit.multi.ui.activity.device;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.project.library.share.LibSharedPreferences;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.view.group.ItemToggleLayout;

public class IntelligentRemindActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView bar_left;
  private String mToggleType = null;
  private LinearLayout progress;
  private AppSharedPreferences share;
  private TextView tittle_right;
  private ItemToggleLayout toggle_facebook;
  private ItemToggleLayout toggle_instagram;
  private ItemToggleLayout toggle_linkedin;
  private ItemToggleLayout toggle_messenger;
  private ItemToggleLayout toggle_qq;
  private ItemToggleLayout toggle_twitter;
  private ItemToggleLayout toggle_wechat;
  private ItemToggleLayout toggle_whatsapp;
  
  private void SaveInfo()
  {
    this.mToggleType = "";
    if (this.toggle_facebook.isOpen()) {
      this.mToggleType += "1,";
    }
    if (this.toggle_wechat.isOpen()) {
      this.mToggleType += "2,";
    }
    if (this.toggle_qq.isOpen()) {
      this.mToggleType += "3,";
    }
    if (this.toggle_twitter.isOpen()) {
      this.mToggleType += "4,";
    }
    if (this.toggle_whatsapp.isOpen()) {
      this.mToggleType += "5,";
    }
    if (this.toggle_instagram.isOpen()) {
      this.mToggleType += "6,";
    }
    if (this.toggle_linkedin.isOpen()) {
      this.mToggleType += "7,";
    }
    if (this.toggle_messenger.isOpen()) {
      this.mToggleType += "8,";
    }
    this.share.setIntelligentRemindSwitch(this.mToggleType);
  }
  
  private void hideProgress()
  {
    finish();
  }
  
  private void initInfo()
  {
    String str = this.share.getIntelligentRemindSwitch();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (str.contains("1")) {
        this.toggle_facebook.setOpen(true);
      }
      if (str.contains("2")) {
        this.toggle_wechat.setOpen(true);
      }
      if (str.contains("3")) {
        this.toggle_qq.setOpen(true);
      }
      if (str.contains("4")) {
        this.toggle_twitter.setOpen(true);
      }
      if (str.contains("5")) {
        this.toggle_whatsapp.setOpen(true);
      }
      if (str.contains("6")) {
        this.toggle_instagram.setOpen(true);
      }
      if (str.contains("7")) {
        this.toggle_linkedin.setOpen(true);
      }
    } while (!str.contains("8"));
    this.toggle_messenger.setOpen(true);
  }
  
  private void initViews()
  {
    int j = 0;
    this.share = AppSharedPreferences.getInstance();
    this.bar_left = ((TextView)findViewById(2131230729));
    this.tittle_right = ((TextView)findViewById(2131230737));
    this.bar_left.setOnClickListener(this);
    this.tittle_right.setOnClickListener(this);
    this.progress = ((LinearLayout)findViewById(2131230738));
    this.toggle_facebook = ((ItemToggleLayout)findViewById(2131230795));
    this.toggle_wechat = ((ItemToggleLayout)findViewById(2131230796));
    this.toggle_qq = ((ItemToggleLayout)findViewById(2131230797));
    this.toggle_twitter = ((ItemToggleLayout)findViewById(2131230798));
    this.toggle_whatsapp = ((ItemToggleLayout)findViewById(2131230799));
    this.toggle_instagram = ((ItemToggleLayout)findViewById(2131230801));
    this.toggle_linkedin = ((ItemToggleLayout)findViewById(2131230800));
    this.toggle_messenger = ((ItemToggleLayout)findViewById(2131230802));
    int k = LibSharedPreferences.getInstance().getDeviceFunMsgNotify();
    ItemToggleLayout localItemToggleLayout = this.toggle_qq;
    if ((k & 0x4) >> 2 == 1)
    {
      i = 0;
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_wechat;
      if ((k & 0x8) >> 3 != 1) {
        break label391;
      }
      i = 0;
      label216:
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_facebook;
      if ((k & 0x20) >> 5 != 1) {
        break label397;
      }
      i = 0;
      label240:
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_twitter;
      if ((k & 0x40) >> 6 != 1) {
        break label403;
      }
      i = 0;
      label265:
      localItemToggleLayout.setVisibility(i);
      k = LibSharedPreferences.getInstance().getDeviceFunMsgNotify2();
      localItemToggleLayout = this.toggle_whatsapp;
      if ((k & 0x1) != 1) {
        break label409;
      }
      i = 0;
      label293:
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_messenger;
      if ((k & 0x2) >> 1 != 1) {
        break label415;
      }
      i = 0;
      label316:
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_instagram;
      if ((k & 0x4) >> 2 != 1) {
        break label421;
      }
      i = 0;
      label339:
      localItemToggleLayout.setVisibility(i);
      localItemToggleLayout = this.toggle_linkedin;
      if ((k & 0x8) >> 3 != 1) {
        break label427;
      }
    }
    label391:
    label397:
    label403:
    label409:
    label415:
    label421:
    label427:
    for (int i = j;; i = 8)
    {
      localItemToggleLayout.setVisibility(i);
      initInfo();
      if (!isNotificationEnabled()) {
        startNotification();
      }
      return;
      i = 8;
      break;
      i = 8;
      break label216;
      i = 8;
      break label240;
      i = 8;
      break label265;
      i = 8;
      break label293;
      i = 8;
      break label316;
      i = 8;
      break label339;
    }
  }
  
  private boolean isNotificationEnabled()
  {
    String str = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(getPackageName() + "/" + getPackageName() + ".service.IntelligentNotificationService");
    }
    return false;
  }
  
  private void showProgress()
  {
    this.progress.setVisibility(0);
    this.tittle_right.setVisibility(8);
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
    if (isNotificationEnabled())
    {
      showProgress();
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          IntelligentRemindActivity.this.SaveInfo();
          IntelligentRemindActivity.this.hideProgress();
        }
      }, 1000L);
      return;
    }
    startNotification();
  }
  
  @SuppressLint({"InlinedApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ScreenUtil.setImmersiveStatusBar(this, ScreenUtil.getAndroidVersionThanKitkat());
    setContentView(2130903055);
    initViews();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onThemeChanged() {}
  
  protected void setNavigationBar() {}
  
  public void startNotification()
  {
    startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\IntelligentRemindActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */