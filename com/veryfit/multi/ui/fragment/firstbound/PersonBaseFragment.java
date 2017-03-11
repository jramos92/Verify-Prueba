package com.veryfit.multi.ui.fragment.firstbound;

import com.veryfit.multi.base.BaseFragment;

public abstract class PersonBaseFragment
  extends BaseFragment
{
  protected OnPagerChangedListener mOnPagerChangedListener = null;
  
  public PersonBaseFragment() {}
  
  public PersonBaseFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    this.mOnPagerChangedListener = paramOnPagerChangedListener;
  }
  
  public void setPagerIndex(int paramInt)
  {
    if (this.mOnPagerChangedListener != null) {
      this.mOnPagerChangedListener.setPagerIndex(paramInt);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */