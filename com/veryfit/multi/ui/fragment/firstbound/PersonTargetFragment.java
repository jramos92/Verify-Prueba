package com.veryfit.multi.ui.fragment.firstbound;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.project.library.database.Goal;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.ui.activity.FirstStartActivity;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.RulerView;
import com.veryfit.multi.view.RulerView.OnDataSelectedListener;
import java.util.Calendar;

public class PersonTargetFragment
  extends PersonBaseFragment
  implements View.OnClickListener
{
  private int data_sleep = -1;
  private int data_sport = -1;
  private boolean isPrepared = false;
  private View mRootView = null;
  private Button next;
  private Button previous;
  private Resources res;
  private RulerView ruler_sleep;
  private RulerView ruler_sport;
  
  public PersonTargetFragment() {}
  
  public PersonTargetFragment(OnPagerChangedListener paramOnPagerChangedListener)
  {
    super(paramOnPagerChangedListener);
  }
  
  public void initEvent()
  {
    this.next.setOnClickListener(this);
    this.previous.setOnClickListener(this);
    this.ruler_sleep.setListener(new RulerView.OnDataSelectedListener()
    {
      public void OnDataSelected(int paramAnonymousInt)
      {
        PersonTargetFragment.this.data_sleep = paramAnonymousInt;
      }
    });
    this.ruler_sport.setListener(new RulerView.OnDataSelectedListener()
    {
      public void OnDataSelected(int paramAnonymousInt)
      {
        PersonTargetFragment.this.data_sport = paramAnonymousInt;
      }
    });
  }
  
  public void initView()
  {
    this.next = ((Button)this.mRootView.findViewById(2131231027));
    this.previous = ((Button)this.mRootView.findViewById(2131231026));
    this.ruler_sleep = ((RulerView)this.mRootView.findViewById(2131230913));
    this.ruler_sport = ((RulerView)this.mRootView.findViewById(2131230912));
    this.ruler_sleep.initData(this.res.getString(2131296463), this.res.getString(2131296464), 1440, 300, 60, 3);
    this.ruler_sport.initData(getResources().getString(2131296411), "", 50000, 1000, 1000, 5);
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {
      return;
    }
    if (this.data_sleep == -1)
    {
      int[] arrayOfInt = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
      this.data_sleep = arrayOfInt[1];
      this.data_sport = arrayOfInt[0];
    }
    this.ruler_sleep.setData(this.data_sleep);
    this.ruler_sport.setData(this.data_sport);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231026) {
      setPagerIndex(3);
    }
    this.data_sport = this.ruler_sport.getCenterData();
    this.data_sleep = this.ruler_sleep.getCenterData();
    if (paramView.getId() == 2131231027)
    {
      TempUtil.saveGoal(new Goal[] { new Goal(this.data_sport, 0), new Goal(this.data_sleep, 1) });
      DebugLog.e(" 睡眠目标:" + this.ruler_sleep.getCenterData() / 60 + ":" + this.ruler_sleep.getCenterData() % 60 + "运动目标:" + this.ruler_sport.getCenterData() + "步");
      ((FirstStartActivity)getActivity()).jumpToNext();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.res = getActivity().getResources();
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
      this.mRootView = paramLayoutInflater.inflate(2130903102, paramViewGroup, false);
      initView();
      initEvent();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\firstbound\PersonTargetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */