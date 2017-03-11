package com.veryfit.multi.ui.fragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.project.library.util.DebugLog;
import com.veryfit.multi.VeryFitApplication;
import com.veryfit.multi.ui.fragment.inter.NotifyParentFragment;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.DataNightShowView;
import com.veryfit.multi.view.DataNightShowView.DataModeNight;
import com.veryfit.multi.view.PointLineView.onDateScrolling;
import com.veryfit.multi.view.SleepBarChart;
import com.veryfit.multi.view.SleepPieView;
import com.veryfit.multi.view.group.PointLineParent;
import com.veryfit.multi.vo.SleepData;
import java.util.Calendar;

public class SleepFragment
  extends MainPageChildFragment
  implements View.OnClickListener, PointLineView.onDateScrolling
{
  private SleepBarChart barChart;
  private boolean isPrepared = false;
  private PointLineParent lineParent;
  private View mRootView = null;
  private SleepPieView pieView;
  private DataNightShowView showView;
  private SleepData sleepData;
  private View.OnTouchListener touch = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((SleepFragment.this.isLinePointChartShow()) && ((SleepFragment.this.lineParent.getLeft() > paramAnonymousMotionEvent.getX()) || (SleepFragment.this.lineParent.getRight() < paramAnonymousMotionEvent.getX()) || (SleepFragment.this.lineParent.getTop() > paramAnonymousMotionEvent.getY()) || (SleepFragment.this.lineParent.getBottom() < paramAnonymousMotionEvent.getY())))
      {
        SleepFragment.this.lineParent.toggle(VeryFitApplication.dateOffset);
        return true;
      }
      return false;
    }
  };
  
  private void initView()
  {
    this.pieView = ((SleepPieView)this.mRootView.findViewById(2131230884));
    this.pieView.setOnClickListener(this);
    this.barChart = ((SleepBarChart)this.mRootView.findViewById(2131231049));
    this.barChart.setOnClickListener(this);
    if (ScreenUtil.getAndroidVersionThanKitkat()) {}
    for (this.lineParent = ((PointLineParent)this.mRootView.findViewById(2131231051));; this.lineParent = ((PointLineParent)this.mRootView.findViewById(2131231050)))
    {
      this.lineParent.getGoToTheDayView().setOnClickListener(this);
      this.lineParent.setOnDateScrollingLinstener(this);
      this.lineParent.setType(1);
      this.showView = ((DataNightShowView)this.mRootView.findViewById(2131231052));
      Object localObject = this.barChart.getBarColors();
      DataNightShowView.DataModeNight localDataModeNight1 = new DataNightShowView.DataModeNight(localObject[2], "", getResources().getString(2131296581));
      DataNightShowView.DataModeNight localDataModeNight2 = new DataNightShowView.DataModeNight(localObject[1], "", getResources().getString(2131296582));
      localObject = new DataNightShowView.DataModeNight(localObject[0], "", getResources().getString(2131296583));
      this.showView.initDatas(new DataNightShowView.DataModeNight[] { localDataModeNight1, localDataModeNight2, localObject });
      return;
    }
  }
  
  private void setSLeepData2Page()
  {
    this.pieView.setDatas(this.sleepData);
    this.barChart.setData(this.sleepData);
    this.showView.updateData(0, this.sleepData.deepTotal, null);
    this.showView.updateData(1, this.sleepData.lightTotal, null);
    this.showView.updateData(2, this.sleepData.awakeTotal, null);
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public boolean isLinePointChartShow()
  {
    return this.lineParent.getVisibility() == 0;
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {}
    do
    {
      return;
      this.lineParent.setDatas(TempUtil.getTotalSleep(0));
      this.sleepData = TempUtil.getSleepByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
      setSLeepData2Page();
    } while (this.notifyParent == null);
    this.notifyParent.notifyParentReloadMyDate(this.lineParent.getShowingOffset(), isLinePointChartShow());
  }
  
  public void onClick(final View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968589);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          SleepFragment.this.pieView.setEnabled(true);
          SleepFragment.this.barChart.setEnabled(true);
          SleepFragment.this.pieView.setVisibility(8);
          SleepFragment.this.barChart.startOpenAnim(null);
          SleepFragment.this.barChart.setVisibility(0);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          SleepFragment.this.pieView.setEnabled(false);
          SleepFragment.this.barChart.setEnabled(false);
        }
      });
      paramView.startAnimation(localAnimation);
      return;
      this.barChart.startCloseAnim(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          paramView.setVisibility(8);
          SleepFragment.this.pieView.setVisibility(0);
        }
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          SleepFragment.this.pieView.setEnabled(true);
          SleepFragment.this.barChart.setEnabled(true);
          paramAnonymousAnimator = AnimationUtils.loadAnimation(SleepFragment.this.getActivity(), 2130968590);
          SleepFragment.this.pieView.startAnimation(paramAnonymousAnimator);
          paramView.setVisibility(8);
          SleepFragment.this.pieView.setVisibility(0);
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          SleepFragment.this.pieView.setEnabled(false);
          SleepFragment.this.barChart.setEnabled(false);
        }
      });
      return;
      this.sleepData = TempUtil.getSleepByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
      setSLeepData2Page();
      this.notifyParent.onClickGoToTheDay(this.lineParent.getShowingOffset());
      paramView = Calendar.getInstance();
      paramView.add(5, -this.lineParent.getShowingOffset());
      VeryFitApplication.getInstance();
      VeryFitApplication.date = paramView.get(1) * 10000 + (paramView.get(2) + 1) * 100 + paramView.get(5);
      this.lineParent.toggle(VeryFitApplication.dateOffset);
    } while (this.notifyParent == null);
    this.notifyParent.notifyParentReloadMyDate(this.lineParent.getShowingOffset(), isLinePointChartShow());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
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
      this.mRootView = paramLayoutInflater.inflate(2130903105, paramViewGroup, false);
      initView();
      this.mRootView.setOnTouchListener(this.touch);
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onDateClick(int paramInt)
  {
    this.lineParent.toggle(paramInt);
  }
  
  public void onHealthDataChanged()
  {
    DebugLog.e("新数据收到，睡眠界面。");
    if ((TempUtil.getTotalSleep(0) != null) && (this.lineParent != null))
    {
      this.lineParent.setDatas(TempUtil.getTotalSleep(0));
      this.lineParent.setShowingOffset(0);
      VeryFitApplication.date = -1L;
      this.sleepData = TempUtil.getSleepByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
      setSLeepData2Page();
      this.notifyParent.onClickGoToTheDay(this.lineParent.getShowingOffset());
    }
  }
  
  public void onReloadData(int paramInt)
  {
    this.sleepData = TempUtil.getSleepByDate(Calendar.getInstance(), paramInt);
    setSLeepData2Page();
  }
  
  public void onScrolling(int paramInt)
  {
    if (this.notifyParent != null) {
      this.notifyParent.onDateScrolling(paramInt);
    }
  }
  
  public void onThemeChanged()
  {
    DebugLog.e("主页收到主题切换的通知");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\SleepFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */