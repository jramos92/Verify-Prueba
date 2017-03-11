package com.veryfit.multi.ui.fragment.firstbound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import com.veryfit.multi.share.AppSharedPreferences;

public class PersonSexFragment
  extends PersonBaseFragment
{
  private boolean isPrepared = false;
  private View mRootView = null;
  private Button next;
  private RadioGroup radioGroup;
  
  public PersonSexFragment() {}
  
  public PersonSexFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramOnPagerChangedListener);
  }
  
  public void initView()
  {
    this.next = ((Button)this.mRootView.findViewById(2131231025));
    this.radioGroup = ((RadioGroup)this.mRootView.findViewById(2131231022));
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = AppSharedPreferences.getInstance();
        if (PersonSexFragment.this.radioGroup.getCheckedRadioButtonId() == 2131231023) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setUserSex(bool);
          PersonSexFragment.this.setPagerIndex(1);
          return;
        }
      }
    });
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    RadioGroup localRadioGroup = this.radioGroup;
    if (AppSharedPreferences.getInstance().getUserSex()) {}
    for (int i = 2131231023;; i = 2131231024)
    {
      localRadioGroup.check(i);
      return;
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
      this.mRootView = paramLayoutInflater.inflate(2130903101, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonSexFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */