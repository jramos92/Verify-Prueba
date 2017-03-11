package com.veryfit.multi.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import com.project.library.core.CoreServiceProxy;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.camera.DisplayUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.fragment.firstbound.AddDeviceFragment;
import com.veryfit.multi.ui.fragment.firstbound.PersonInfoFragment;

public class FirstStartActivity
  extends FragmentActivity
{
  private AddDeviceFragment mAddDeviceFragment = null;
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private BaseFragment mLastFragment;
  private PersonInfoFragment mPersonInfoFragment = null;
  
  private void changeFragment(FragmentActivity paramFragmentActivity, BaseFragment paramBaseFragment, String paramString)
  {
    if ((paramBaseFragment == null) || (this.mLastFragment == paramBaseFragment)) {
      return;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    if ((this.mLastFragment != null) && (this.mLastFragment != paramBaseFragment)) {
      paramFragmentActivity.detach(this.mLastFragment);
    }
    if (!paramBaseFragment.isAdded()) {
      paramFragmentActivity.add(2131230761, paramBaseFragment, paramString);
    }
    if (paramBaseFragment.isDetached()) {
      paramFragmentActivity.attach(paramBaseFragment);
    }
    this.mLastFragment = paramBaseFragment;
    paramFragmentActivity.commitAllowingStateLoss();
  }
  
  private void init(Bundle paramBundle)
  {
    setContentView(2130903049);
    if (paramBundle != null) {
      this.mLastFragment = ((BaseFragment)getSupportFragmentManager().getFragment(paramBundle, "mLastFragment"));
    }
    showAddDeviceFragment();
  }
  
  private void initSafeMode()
  {
    String str = Build.MANUFACTURER;
    Log.v("phone", str);
    if ((Build.VERSION.SDK_INT == 18) || ((Build.VERSION.SDK_INT == 19) && (str.equalsIgnoreCase("HUAWEI")))) {
      AppSharedPreferences.getInstance().setSyncHealdataMode(true);
    }
  }
  
  private void removeFragments()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.mAddDeviceFragment != null)
    {
      this.mAddDeviceFragment.close();
      localFragmentTransaction.remove(this.mAddDeviceFragment);
      this.mAddDeviceFragment = null;
    }
    if (this.mPersonInfoFragment != null)
    {
      this.mPersonInfoFragment.close();
      localFragmentTransaction.remove(this.mPersonInfoFragment);
      this.mPersonInfoFragment = null;
    }
    localFragmentTransaction.commitAllowingStateLoss();
    this.mLastFragment = null;
  }
  
  private void showAddDeviceFragment()
  {
    if (this.mAddDeviceFragment == null) {
      this.mAddDeviceFragment = new AddDeviceFragment();
    }
    changeFragment(this, this.mAddDeviceFragment, null);
  }
  
  private void showPersonInfoFragment()
  {
    if (this.mPersonInfoFragment == null) {
      this.mPersonInfoFragment = new PersonInfoFragment();
    }
    changeFragment(this, this.mPersonInfoFragment, null);
  }
  
  public void jumpToNext()
  {
    removeFragments();
    startActivity(new Intent(this, MainActivity.class));
    finish();
  }
  
  public void jumpToSettings()
  {
    showPersonInfoFragment();
    this.mAppSharedPreferences.setFirstUpdateApp(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    MobclickAgent.updateOnlineConfig(this);
    AnalyticsConfig.enableEncrypt(true);
    initSafeMode();
    this.mAppSharedPreferences.setScreenRawHeight(DisplayUtil.getScreenRawHeight(this));
    if (this.mAppSharedPreferences.isFirstStartApp())
    {
      init(paramBundle);
      return;
    }
    jumpToNext();
  }
  
  protected void onDestroy()
  {
    removeFragments();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      removeFragments();
      CoreServiceProxy.fini();
      finish();
      Process.killProcess(Process.myPid());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\FirstStartActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */