package com.veryfit.multi.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.umeng.analytics.MobclickAgent;
import com.veryfit.multi.ui.OnThemeChangedListener;

public abstract class BaseFragment
  extends Fragment
  implements OnThemeChangedListener
{
  protected boolean isVisible;
  
  protected abstract void lazyLoad();
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onInVisible() {}
  
  public void onPause()
  {
    super.onPause();
    MobclickAgent.onPageEnd("MainScreen");
    onInVisible();
  }
  
  public void onResume()
  {
    super.onResume();
    MobclickAgent.onPageStart("MainScreen");
    onVisible();
  }
  
  public void onVisible()
  {
    lazyLoad();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (getUserVisibleHint())
    {
      this.isVisible = true;
      onVisible();
      return;
    }
    this.isVisible = false;
    onInVisible();
  }
  
  public void showToastLong(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 1).show();
  }
  
  public void showToastShort(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\base\BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */