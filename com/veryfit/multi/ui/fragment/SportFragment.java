package com.veryfit.multi.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.veryfit.multi.VeryFitApplication;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.ui.activity.device.HeartRateActivity;
import com.veryfit.multi.ui.fragment.inter.NotifyParentFragment;
import com.veryfit.multi.util.ScreenUtil;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.UnitFormat;
import com.veryfit.multi.view.DataSportShowView;
import com.veryfit.multi.view.DataSportShowView.DataModeSport;
import com.veryfit.multi.view.PointLineView.onDateScrolling;
import com.veryfit.multi.view.SportBarChart;
import com.veryfit.multi.view.SportPieView;
import com.veryfit.multi.view.group.PointLineParent;
import com.veryfit.multi.vo.SportData;
import java.util.Calendar;

public class SportFragment
  extends MainPageChildFragment
  implements View.OnClickListener, PointLineView.onDateScrolling
{
  private SportBarChart barChart;
  private int goal = 10000;
  private RelativeLayout heartRateLayout;
  private ImageButton imBtn_heartRate;
  private boolean isPrepared = false;
  private PointLineParent lineParent;
  private CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private APPCoreServiceListener mCoreServiceListener = new APPCoreServiceListener()
  {
    public void onGetInfo(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == -96) {
        SportFragment.this.mHandle.post(new Runnable()
        {
          public void run()
          {
            int i = LibSharedPreferences.getInstance().getHeartRate();
            Log.e("debug", "实时数据接收成功" + i);
            Object localObject;
            long l;
            if (i == 0)
            {
              SportFragment.this.mIv_HeartRate.setText("   ---");
              localObject = Calendar.getInstance();
              l = ((Calendar)localObject).get(1) * 10000 + (((Calendar)localObject).get(2) + 1) * 100 + ((Calendar)localObject).get(5);
              i = LibSharedPreferences.getInstance().getRealStep();
              Log.e("debug", "step:" + i);
              if (i != 0) {
                break label398;
              }
              if (SportFragment.this.sportData == null) {
                break label380;
              }
              SportFragment.this.pieView.setSteps(SportFragment.this.sportData.steps, false);
            }
            for (;;)
            {
              VeryFitApplication.getInstance();
              if (VeryFitApplication.date != -1L)
              {
                VeryFitApplication.getInstance();
                if (VeryFitApplication.date != l) {}
              }
              else
              {
                localObject = VeryFitApplication.getInstance().getString(2131296412);
                float f2 = (float)(LibSharedPreferences.getInstance().getRealDistances() * 0.001D);
                float f1 = f2;
                if (AppSharedPreferences.getInstance().getUnitType() == 2)
                {
                  localObject = VeryFitApplication.getInstance().getString(2131296421);
                  f1 = UnitFormat.km2mile(f2);
                }
                Log.e("debug", "distance:" + f1);
                String str = String.format("%.3f", new Object[] { Float.valueOf(f1) });
                SportFragment.this.showView.updateData(0, str.substring(0, str.length() - 1), (String)localObject);
                i = LibSharedPreferences.getInstance().getRealCalories();
                SportFragment.this.showView.updateData(1, i, null);
              }
              return;
              if (i <= 0) {
                break;
              }
              SportFragment.this.mIv_HeartRate.setText(i + " bpm");
              break;
              label380:
              SportFragment.this.pieView.setSteps(i, false);
              continue;
              label398:
              VeryFitApplication.getInstance();
              if (VeryFitApplication.date != -1L)
              {
                VeryFitApplication.getInstance();
                if (VeryFitApplication.date != l) {}
              }
              else
              {
                SportFragment.this.pieView.setSteps(i, false);
              }
            }
          }
        });
      }
    }
  };
  private Handler mHandle = new Handler();
  private TextView mIv_HeartRate;
  private View mRootView = null;
  private SportPieView pieView;
  private DataSportShowView showView;
  private SportData sportData;
  private View.OnTouchListener touch = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((SportFragment.this.isLinePointChartShow()) && ((SportFragment.this.lineParent.getLeft() > paramAnonymousMotionEvent.getX()) || (SportFragment.this.lineParent.getRight() < paramAnonymousMotionEvent.getX()) || (SportFragment.this.lineParent.getTop() > paramAnonymousMotionEvent.getY()) || (SportFragment.this.lineParent.getBottom() < paramAnonymousMotionEvent.getY())))
      {
        SportFragment.this.lineParent.toggle(VeryFitApplication.dateOffset);
        return true;
      }
      return false;
    }
  };
  
  private Bundle getContext()
  {
    return null;
  }
  
  private void initView()
  {
    this.pieView = ((SportPieView)this.mRootView.findViewById(2131230884));
    this.pieView.setOnClickListener(this);
    this.barChart = ((SportBarChart)this.mRootView.findViewById(2131231056));
    this.barChart.setOnClickListener(this);
    if (ScreenUtil.getAndroidVersionThanKitkat())
    {
      this.lineParent = ((PointLineParent)this.mRootView.findViewById(2131231051));
      this.lineParent.getGoToTheDayView().setOnClickListener(this);
      this.lineParent.setOnDateScrollingLinstener(this);
      this.lineParent.setType(0);
      this.imBtn_heartRate = ((ImageButton)this.mRootView.findViewById(2131231055));
      this.imBtn_heartRate.setOnClickListener(this);
      this.mIv_HeartRate = ((TextView)this.mRootView.findViewById(2131231054));
      this.heartRateLayout = ((RelativeLayout)this.mRootView.findViewById(2131231053));
      if (!LibSharedPreferences.getInstance().getDeviceHeartRate()) {
        break label292;
      }
      this.heartRateLayout.setVisibility(0);
    }
    for (;;)
    {
      this.showView = ((DataSportShowView)this.mRootView.findViewById(2131231057));
      DataSportShowView.DataModeSport localDataModeSport1 = new DataSportShowView.DataModeSport("", getResources().getString(2131296412));
      if (AppSharedPreferences.getInstance().getUnitType() == 2) {
        localDataModeSport1 = new DataSportShowView.DataModeSport("", getResources().getString(2131296421));
      }
      DataSportShowView.DataModeSport localDataModeSport2 = new DataSportShowView.DataModeSport("", getResources().getString(2131296413));
      this.showView.initDatas(new DataSportShowView.DataModeSport[] { localDataModeSport1, localDataModeSport2 });
      return;
      this.lineParent = ((PointLineParent)this.mRootView.findViewById(2131231050));
      break;
      label292:
      this.heartRateLayout.setVisibility(8);
    }
  }
  
  private void setSportData2Page()
  {
    int i = LibSharedPreferences.getInstance().getRealStep();
    Object localObject = Calendar.getInstance();
    long l = ((Calendar)localObject).get(1) * 10000 + (((Calendar)localObject).get(2) + 1) * 100 + ((Calendar)localObject).get(5);
    if (i > this.sportData.steps)
    {
      VeryFitApplication.getInstance();
      if (VeryFitApplication.date != -1L)
      {
        VeryFitApplication.getInstance();
        if (VeryFitApplication.date != -1L)
        {
          VeryFitApplication.getInstance();
          if (VeryFitApplication.date != l) {}
        }
      }
      else
      {
        showData(i);
        return;
      }
    }
    this.pieView.setGoal(this.goal);
    this.pieView.setSteps(this.sportData.steps, true);
    this.barChart.setDatas(this.sportData.details);
    this.barChart.setTittleString(this.sportData.steps + " / " + this.goal);
    localObject = VeryFitApplication.getInstance().getString(2131296412);
    float f = this.sportData.distance;
    if (AppSharedPreferences.getInstance().getUnitType() == 2)
    {
      localObject = VeryFitApplication.getInstance().getString(2131296421);
      f = UnitFormat.km2mile(f);
      this.showView.updateData(0, f, (String)localObject);
    }
    for (;;)
    {
      this.showView.updateData(1, this.sportData.calorie, null);
      return;
      String str = String.format("%.3f", new Object[] { Float.valueOf(f) });
      this.showView.updateData(0, str.substring(0, str.length() - 1), (String)localObject);
    }
  }
  
  private void showData(int paramInt)
  {
    this.pieView.setGoal(this.goal);
    Object localObject = Calendar.getInstance();
    long l = ((Calendar)localObject).get(1) * 10000 + (((Calendar)localObject).get(2) + 1) * 100 + ((Calendar)localObject).get(5);
    Log.e("debug", "step:" + paramInt);
    if (paramInt == 0)
    {
      this.pieView.setSteps(this.sportData.steps, false);
      this.barChart.setDatas(this.sportData.details);
      this.barChart.setTittleString(this.sportData.steps + " / " + this.goal);
    }
    for (;;)
    {
      VeryFitApplication.getInstance();
      if (VeryFitApplication.date != -1L)
      {
        VeryFitApplication.getInstance();
        if (VeryFitApplication.date != l) {}
      }
      else
      {
        localObject = VeryFitApplication.getInstance().getString(2131296412);
        float f2 = (float)(LibSharedPreferences.getInstance().getRealDistances() * 0.001D);
        float f1 = f2;
        if (AppSharedPreferences.getInstance().getUnitType() == 2)
        {
          localObject = VeryFitApplication.getInstance().getString(2131296421);
          f1 = UnitFormat.km2mile(f2);
        }
        Log.e("debug", "distance:" + f1);
        String str = String.format("%.3f", new Object[] { Float.valueOf(f1) });
        this.showView.updateData(0, str.substring(0, str.length() - 1), (String)localObject);
        paramInt = LibSharedPreferences.getInstance().getRealCalories();
        this.showView.updateData(1, paramInt, null);
      }
      return;
      VeryFitApplication.getInstance();
      if (VeryFitApplication.date != -1L)
      {
        VeryFitApplication.getInstance();
        if (VeryFitApplication.date != l) {}
      }
      else
      {
        this.pieView.setSteps(paramInt, false);
        this.barChart.setDatas(this.sportData.details);
        this.barChart.setTittleString(this.sportData.steps + " / " + this.goal);
        continue;
      }
      this.pieView.setSteps(this.sportData.steps, false);
      this.barChart.setDatas(this.sportData.details);
      this.barChart.setTittleString(this.sportData.steps + " / " + this.goal);
    }
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
      this.lineParent.setDatas(TempUtil.getDayTotalSteps(0));
      this.sportData = TempUtil.getSprotByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
      this.goal = TempUtil.getGoal(com.project.library.util.LongDateUtil.Calendar2LongDate(this.sportData.date))[0];
      setSportData2Page();
      if (this.notifyParent != null) {
        this.notifyParent.notifyParentReloadMyDate(this.lineParent.getShowingOffset(), isLinePointChartShow());
      }
    } while (this.barChart.getVisibility() == 0);
    if (LibSharedPreferences.getInstance().getDeviceHeartRate())
    {
      this.heartRateLayout.setVisibility(0);
      return;
    }
    this.heartRateLayout.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131230884: 
    case 2131231056: 
    case 2131231090: 
      do
      {
        do
        {
          return;
          Animation localAnimation = AnimationUtils.loadAnimation(getActivity(), 2130968576);
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              SportFragment.this.barChart.startAnimSet();
              SportFragment.this.pieView.setEnabled(true);
              SportFragment.this.pieView.setVisibility(8);
              SportFragment.this.heartRateLayout.setVisibility(8);
            }
            
            public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public void onAnimationStart(Animation paramAnonymousAnimation)
            {
              SportFragment.this.pieView.setEnabled(false);
            }
          });
          paramView.startAnimation(localAnimation);
          return;
          paramView.setVisibility(8);
          this.pieView.setVisibility(0);
          this.pieView.startAnim(-1);
        } while (!LibSharedPreferences.getInstance().getDeviceHeartRate());
        this.heartRateLayout.setVisibility(0);
        return;
        this.sportData = TempUtil.getSprotByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
        this.goal = TempUtil.getGoal(com.project.library.util.LongDateUtil.Calendar2LongDate(this.sportData.date))[0];
        setSportData2Page();
        this.notifyParent.onClickGoToTheDay(this.lineParent.getShowingOffset());
        paramView = Calendar.getInstance();
        paramView.add(5, -this.lineParent.getShowingOffset());
        VeryFitApplication.getInstance();
        VeryFitApplication.date = paramView.get(1) * 10000 + (paramView.get(2) + 1) * 100 + paramView.get(5);
        this.lineParent.toggle(VeryFitApplication.dateOffset);
      } while (this.notifyParent == null);
      this.notifyParent.notifyParentReloadMyDate(this.lineParent.getShowingOffset(), isLinePointChartShow());
      return;
    }
    startActivity(new Intent(getActivity(), HeartRateActivity.class));
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
      if (this.notifyParent != null) {
        this.notifyParent.onRootViewCreate(this.mRootView);
      }
      return this.mRootView;
      this.mRootView = paramLayoutInflater.inflate(2130903106, paramViewGroup, false);
      initView();
      this.mRootView.setOnTouchListener(this.touch);
      this.isPrepared = true;
      lazyLoad();
      this.mCore.addListener(this.mCoreServiceListener);
    }
  }
  
  public void onDateClick(int paramInt)
  {
    this.lineParent.toggle(paramInt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCore.removeListener(this.mCoreServiceListener);
  }
  
  public void onHealthDataChanged()
  {
    DebugLog.e("新数据收到，运动界面。");
    if ((TempUtil.getDayTotalSteps(0) != null) && (this.lineParent != null))
    {
      this.lineParent.setDatas(TempUtil.getDayTotalSteps(0));
      this.lineParent.setShowingOffset(0);
      VeryFitApplication.date = -1L;
      this.sportData = TempUtil.getSprotByDate(Calendar.getInstance(), this.lineParent.getShowingOffset());
      this.goal = TempUtil.getGoal(com.project.library.util.LongDateUtil.Calendar2LongDate(this.sportData.date))[0];
      setSportData2Page();
      this.notifyParent.onClickGoToTheDay(this.lineParent.getShowingOffset());
    }
  }
  
  public void onReloadData(int paramInt)
  {
    this.sportData = TempUtil.getSprotByDate(Calendar.getInstance(), paramInt);
    this.goal = TempUtil.getGoal(com.project.library.util.LongDateUtil.Calendar2LongDate(this.sportData.date))[0];
    setSportData2Page();
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\SportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */