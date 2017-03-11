package com.veryfit.multi.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.veryfit.multi.ui.fragment.firstbound.OnPagerChangedListener;
import com.veryfit.multi.ui.fragment.firstbound.PersonBirthdayFragment;
import com.veryfit.multi.ui.fragment.firstbound.PersonHeightFragment;
import com.veryfit.multi.ui.fragment.firstbound.PersonSexFragment;
import com.veryfit.multi.ui.fragment.firstbound.PersonTargetFragment;
import com.veryfit.multi.ui.fragment.firstbound.PersonWeightFragment;
import java.util.ArrayList;
import java.util.List;

public class PersonInfoPagerAdapter
  extends FragmentPagerAdapter
{
  private List<Fragment> fgs = new ArrayList();
  
  public PersonInfoPagerAdapter(FragmentManager paramFragmentManager, OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramFragmentManager);
    this.fgs.add(new PersonSexFragment(paramOnPagerChangedListener));
    this.fgs.add(new PersonHeightFragment(paramOnPagerChangedListener));
    this.fgs.add(new PersonWeightFragment(paramOnPagerChangedListener));
    this.fgs.add(new PersonBirthdayFragment(paramOnPagerChangedListener));
    this.fgs.add(new PersonTargetFragment(paramOnPagerChangedListener));
  }
  
  public int getCount()
  {
    return this.fgs.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.fgs.get(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\adapter\PersonInfoPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */