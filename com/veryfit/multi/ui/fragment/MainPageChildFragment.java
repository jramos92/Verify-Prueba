package com.veryfit.multi.ui.fragment;

import android.view.View;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.ui.fragment.inter.NotifyChildFragment;
import com.veryfit.multi.ui.fragment.inter.NotifyParentFragment;

public abstract class MainPageChildFragment
  extends BaseFragment
  implements NotifyChildFragment
{
  protected NotifyParentFragment notifyParent;
  
  public abstract View getRootView();
  
  public abstract void onHealthDataChanged();
  
  public void setNotifyParentFragment(NotifyParentFragment paramNotifyParentFragment)
  {
    this.notifyParent = paramNotifyParentFragment;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\MainPageChildFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */