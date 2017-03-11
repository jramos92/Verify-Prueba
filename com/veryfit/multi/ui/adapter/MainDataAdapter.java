package com.veryfit.multi.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.veryfit.multi.ui.fragment.SleepFragment;
import com.veryfit.multi.ui.fragment.SportFragment;
import java.util.ArrayList;
import java.util.List;

public class MainDataAdapter
  extends FragmentPagerAdapter
{
  private List<Fragment> frags = new ArrayList();
  
  public MainDataAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.frags.add(new SportFragment());
    this.frags.add(new SleepFragment());
  }
  
  public int getCount()
  {
    return this.frags.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.frags.get(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\adapter\MainDataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */