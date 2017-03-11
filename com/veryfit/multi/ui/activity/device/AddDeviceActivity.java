package com.veryfit.multi.ui.activity.device;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.project.library.core.CoreServiceProxy;
import com.veryfit.multi.ui.fragment.firstbound.AddDeviceFragment;
import com.veryfit.multi.ui.fragment.firstbound.AddDeviceFragment.OnFinishListener;
import com.veryfit.multi.util.ScreenUtil;

public class AddDeviceActivity
  extends FragmentActivity
  implements AddDeviceFragment.OnFinishListener
{
  private AddDeviceFragment mAddDeviceFragment;
  
  private void close()
  {
    Object localObject = getSupportFragmentManager().beginTransaction();
    if (this.mAddDeviceFragment != null)
    {
      this.mAddDeviceFragment.close();
      ((FragmentTransaction)localObject).remove(this.mAddDeviceFragment);
      this.mAddDeviceFragment = null;
    }
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    localObject = CoreServiceProxy.getInstance();
    if ((((CoreServiceProxy)localObject).isAvailable()) && (!((CoreServiceProxy)localObject).isDeviceConnected())) {
      ((CoreServiceProxy)localObject).disconnect();
    }
  }
  
  private void showAddDeviceFragment()
  {
    if (this.mAddDeviceFragment == null)
    {
      this.mAddDeviceFragment = new AddDeviceFragment();
      this.mAddDeviceFragment.setOnFinishListener(this);
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.add(2131230736, this.mAddDeviceFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void OnFinish()
  {
    close();
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903042);
    super.onCreate(paramBundle);
    showAddDeviceFragment();
  }
  
  protected void onDestroy()
  {
    close();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      close();
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void setNavigationBar()
  {
    ScreenUtil.setNavigationBar(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\AddDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */