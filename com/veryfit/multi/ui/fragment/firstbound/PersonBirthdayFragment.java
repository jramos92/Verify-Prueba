package com.veryfit.multi.ui.fragment.firstbound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.view.RulerView;

public class PersonBirthdayFragment
  extends PersonBaseFragment
  implements View.OnClickListener
{
  private boolean isPrepared = false;
  private View mRootView = null;
  private Button next;
  private Button previous;
  private RulerView ruler_birthday;
  private int year = -1;
  
  public PersonBirthdayFragment() {}
  
  public PersonBirthdayFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramOnPagerChangedListener);
  }
  
  public void initView()
  {
    this.next = ((Button)this.mRootView.findViewById(2131231018));
    this.previous = ((Button)this.mRootView.findViewById(2131231017));
    this.ruler_birthday = ((RulerView)this.mRootView.findViewById(2131231016));
    this.next.setOnClickListener(this);
    this.previous.setOnClickListener(this);
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    if (this.year == -1) {
      this.year = AppSharedPreferences.getInstance().getUserBirthdayYear();
    }
    this.ruler_birthday.setData(this.year);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231017) {
      setPagerIndex(2);
    }
    if (paramView.getId() == 2131231018)
    {
      this.year = this.ruler_birthday.getCenterData();
      AppSharedPreferences.getInstance().setUserBirthdayYear(this.year);
      setPagerIndex(4);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mRootView != null)
    {
      paramLayoutInflater = (ViewGroup)this.mRootView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.mRootView);
      }
    }
    for (;;)
    {
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903099, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonBirthdayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */