package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

public abstract class ViewPagerAdapter
{
  private MobViewPager parent;
  
  public abstract int getCount();
  
  public abstract View getView(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public void invalidate()
  {
    if (this.parent != null) {
      this.parent.setAdapter(this);
    }
  }
  
  public void onScreenChange(int paramInt1, int paramInt2) {}
  
  final void setMobViewPager(MobViewPager paramMobViewPager)
  {
    this.parent = paramMobViewPager;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\ViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */