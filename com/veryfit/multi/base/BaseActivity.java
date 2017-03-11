package com.veryfit.multi.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.project.library.util.BleScanTool;
import com.project.library.util.DebugLog;
import com.umeng.analytics.MobclickAgent;
import com.veryfit.multi.util.ScreenUtil;

public abstract class BaseActivity
  extends FragmentActivity
{
  private BroadcastReceiver mBaseReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.veryfit.multi.action_theme_changed")) {
        BaseActivity.this.onThemeChanged();
      }
    }
  };
  
  protected void initData() {}
  
  protected void initEvent() {}
  
  protected void initFirst() {}
  
  protected void initView() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DebugLog.d("create activity : " + getClass().getSimpleName());
    if (!BleScanTool.getInstance().isBluetoothOpen()) {
      DebugLog.d(getClass().getSimpleName() + "plz open bluethooth");
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.veryfit.multi.action_theme_changed");
    registerReceiver(this.mBaseReceiver, paramBundle);
    initFirst();
    initView();
    initEvent();
    initData();
    if (ScreenUtil.getAndroidVersionThanKitkat()) {
      setNavigationBar();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.mBaseReceiver);
    this.mBaseReceiver = null;
    recreate();
  }
  
  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }
  
  protected abstract void onThemeChanged();
  
  protected void release() {}
  
  protected void setNavigationBar()
  {
    ScreenUtil.setNavigationBar(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\base\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */