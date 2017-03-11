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
import com.veryfit.multi.view.RulerView;

public class PersonWeightFragment
  extends PersonBaseFragment
  implements View.OnClickListener
{
  private static final int MIN_KG = 25;
  private static final int MIN_LB = 55;
  private boolean isPrepared = false;
  private View mRootView = null;
  private Button next;
  private Button previous;
  private RulerView ruler_weight;
  private int unitType;
  private int weight = -1;
  
  public PersonWeightFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramOnPagerChangedListener);
  }
  
  private void switchUnitType()
  {
    if (this.weight == -1) {
      this.weight = AppSharedPreferences.getInstance().getUserWeight();
    }
    DebugLog.d("weight = " + this.weight);
    if (this.unitType == 1)
    {
      this.ruler_weight.initData("kg", "", 205, 25, 10, 5);
      this.ruler_weight.setData(this.weight);
    }
    while (this.unitType != 2) {
      return;
    }
    this.ruler_weight.initData("lb", "", 455, 55, 10, 5);
    DebugLog.d("weight lb= " + UnitFormat.kg2lb(this.weight));
    this.ruler_weight.setData(UnitFormat.kg2lb(this.weight));
  }
  
  public void initView()
  {
    this.next = ((Button)this.mRootView.findViewById(2131231030));
    this.previous = ((Button)this.mRootView.findViewById(2131231029));
    this.ruler_weight = ((RulerView)this.mRootView.findViewById(2131231028));
    this.ruler_weight.setData(60);
    this.next.setOnClickListener(this);
    this.previous.setOnClickListener(this);
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    this.unitType = AppSharedPreferences.getInstance().getUnitType();
    switchUnitType();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231029) {
      setPagerIndex(1);
    }
    int i;
    if (paramView.getId() == 2131231030)
    {
      i = this.ruler_weight.getCenterData();
      DebugLog.d("data***" + i);
      if (this.unitType != 1) {
        break label76;
      }
      this.weight = i;
      AppSharedPreferences.getInstance().setUserWeight(i);
    }
    for (;;)
    {
      setPagerIndex(3);
      return;
      label76:
      if (this.unitType == 2)
      {
        i = UnitFormat.lb2kg(i);
        DebugLog.d("kg***" + i);
        this.weight = i;
        AppSharedPreferences.getInstance().setUserWeight(i);
      }
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
      this.mRootView = paramLayoutInflater.inflate(2130903103, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonWeightFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */