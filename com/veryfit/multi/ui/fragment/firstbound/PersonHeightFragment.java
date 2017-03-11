package com.veryfit.multi.ui.fragment.firstbound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.UnitFormat;
import com.veryfit.multi.view.BaseRulerView;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnHeightFormatSelectListener;

public class PersonHeightFragment
  extends PersonBaseFragment
{
  private static final int MIN_CM = 30;
  private static final int MIN_INCH = 1;
  private boolean haveShowed = false;
  private int height = -1;
  private boolean isPrepared = false;
  private View mRootView = null;
  private Button next;
  private Button previous;
  public BaseRulerView ruler_height;
  private int unitType;
  
  public PersonHeightFragment() {}
  
  public PersonHeightFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramOnPagerChangedListener);
  }
  
  private void switchUnitType()
  {
    if (this.height == -1) {
      this.height = AppSharedPreferences.getInstance().getUserHeight();
    }
    DebugLog.d("height = " + this.height + "***sex = " + AppSharedPreferences.getInstance().getUserSex());
    if (this.unitType == 1)
    {
      this.ruler_height.initData(new String[] { "cm" }, 250, 30, 5, 10, 1);
      this.ruler_height.setData(this.height - 30);
    }
    while (this.unitType != 2) {
      return;
    }
    this.ruler_height.initData(new String[] { "'", "\"" }, 8, 1, 6, 1, 1);
    DebugLog.d("height inch= " + UnitFormat.cm2inchs(this.height));
    this.ruler_height.setData(UnitFormat.cm2inchs(this.height) - 12);
  }
  
  public void initEvent()
  {
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = PersonHeightFragment.this.ruler_height.getData();
        int i;
        if (PersonHeightFragment.this.unitType == 1)
        {
          i = paramAnonymousView[0] + paramAnonymousView[1];
          PersonHeightFragment.this.height = i;
          AppSharedPreferences.getInstance().setUserHeight(i);
        }
        for (;;)
        {
          PersonHeightFragment.this.setPagerIndex(2);
          return;
          if (PersonHeightFragment.this.unitType == 2)
          {
            i = UnitFormat.inch2cm(paramAnonymousView);
            DebugLog.d("***" + i);
            PersonHeightFragment.this.height = i;
            AppSharedPreferences.getInstance().setUserHeight(i);
          }
        }
      }
    });
    this.previous.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PersonHeightFragment.this.setPagerIndex(0);
      }
    });
  }
  
  public void initView()
  {
    this.next = ((Button)this.mRootView.findViewById(2131231021));
    this.previous = ((Button)this.mRootView.findViewById(2131231020));
    this.ruler_height = ((BaseRulerView)this.mRootView.findViewById(2131231019));
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    if (!this.haveShowed)
    {
      this.haveShowed = true;
      DialogUtil.showHeightFormatDialog(getActivity(), new DialogUtil.OnHeightFormatSelectListener()
      {
        public void onHeightFormat(int paramAnonymousInt)
        {
          PersonHeightFragment.this.unitType = paramAnonymousInt;
          AppSharedPreferences.getInstance().setUnitType(paramAnonymousInt);
          PersonHeightFragment.this.switchUnitType();
        }
      });
    }
    this.unitType = AppSharedPreferences.getInstance().getUnitType();
    switchUnitType();
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
      this.mRootView = paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
      initView();
      initEvent();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonHeightFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */