package com.veryfit.multi.ui.fragment.firstbound;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.ui.adapter.PersonInfoPagerAdapter;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.view.CirclePageIndicator;
import com.veryfit.multi.view.NoScrollViewPager;

public class PersonInfoFragment
  extends BaseFragment
  implements OnPagerChangedListener
{
  private boolean isPrepared = false;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected() {}
    
    public void onBLEConnecting() {}
    
    public void onBLEDisConnected(String paramAnonymousString) {}
    
    public void onBlueToothError(int paramAnonymousInt) {}
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        switch (paramAnonymousByte)
        {
        }
      }
    }
  };
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private View mRootView = null;
  private PersonInfoPagerAdapter pagerAdapter;
  private CirclePageIndicator pagerIndicator;
  private RelativeLayout person_bar;
  private TextView title;
  private NoScrollViewPager viewPager;
  
  private void setNavigationBar()
  {
    if ((getActivity() != null) || (ScreenUtil.getAndroidVersionThanKitkat()))
    {
      ((LinearLayout)this.mRootView.findViewById(2131230832)).setPadding(0, ScreenUtil.getStatusBarHeight(getResources()), 0, 0);
      ScreenUtil.setImmersiveStatusBar(getActivity());
    }
  }
  
  public void close()
  {
    this.mCore.removeListener(this.mAppListener);
  }
  
  public void initView()
  {
    this.person_bar = ((RelativeLayout)this.mRootView.findViewById(2131230833));
    this.title = ((TextView)this.mRootView.findViewById(2131230730));
    this.viewPager = ((NoScrollViewPager)this.mRootView.findViewById(2131230834));
    this.pagerIndicator = ((CirclePageIndicator)this.mRootView.findViewById(2131230835));
    this.pagerAdapter = new PersonInfoPagerAdapter(getActivity().getSupportFragmentManager(), this);
    this.viewPager.setNoScroll(true);
    this.viewPager.setAdapter(this.pagerAdapter);
    this.pagerIndicator.setViewPager(this.viewPager);
    this.pagerIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        Log.d("viewPager", "--onPageScrolled  arg0：" + paramAnonymousInt1 + "  arg2:" + paramAnonymousInt2);
      }
      
      public void onPageSelected(int paramAnonymousInt)
      {
        Log.d("viewPager", "--onPageSelected  arg0：" + paramAnonymousInt);
        if (paramAnonymousInt == 4)
        {
          PersonInfoFragment.this.title.setText(2131296462);
          return;
        }
        PersonInfoFragment.this.title.setText(2131296453);
      }
    });
  }
  
  protected void lazyLoad()
  {
    if (!this.isPrepared) {
      return;
    }
    this.mCore.addListener(this.mAppListener);
    setNavigationBar();
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
      this.mRootView = paramLayoutInflater.inflate(2130903060, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
  
  public void setPagerIndex(int paramInt)
  {
    if (this.viewPager != null) {
      this.viewPager.setCurrentItem(paramInt);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */