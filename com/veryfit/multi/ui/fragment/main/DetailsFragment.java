package com.veryfit.multi.ui.fragment.main;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.base.BaseFragment;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.DataShowView;
import com.veryfit.multi.view.DataShowView.DataModel;
import com.veryfit.multi.view.DetailChart.PageData;
import com.veryfit.multi.view.DetailViewPager;
import com.veryfit.multi.view.DetailViewPager.PageListener;
import java.util.Calendar;
import java.util.concurrent.CopyOnWriteArrayList;

public class DetailsFragment
  extends BaseFragment
  implements DetailViewPager.PageListener
{
  private int DAY_LABLE_COLOR;
  private String[] MONTH_LABELS;
  private String[] NIGHT_LABELS;
  private int NIGHT_LABLE_COLOR;
  private String[] WEEK_LABELS;
  private String[] YEAR_LABELS;
  private int chartType;
  private RadioGroup chartTypeGroup;
  private int dataIndex;
  private DataShowView dataView0;
  private DataShowView dataView1;
  private boolean isPrepared = false;
  private String[] lables;
  private Handler mLoadDataHandler = new Handler();
  private HandlerThread mLoadDataThread = null;
  private View mRootView = null;
  private RadioGroup.OnCheckedChangeListener onChartTypeChange = new RadioGroup.OnCheckedChangeListener()
  {
    public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        DetailsFragment.this.updateLables();
        DetailsFragment.this.updateData();
        return;
      case 2131230970: 
        if (DetailsFragment.this.chartType == 1) {
          paramAnonymousRadioGroup = DetailsFragment.this;
        }
        for (paramAnonymousRadioGroup.dataIndex *= 4;; paramAnonymousRadioGroup.dataIndex *= 54)
        {
          DetailsFragment.this.chartType = 0;
          break;
          paramAnonymousRadioGroup = DetailsFragment.this;
        }
      case 2131230971: 
        if (DetailsFragment.this.chartType == 0) {
          paramAnonymousRadioGroup = DetailsFragment.this;
        }
        for (paramAnonymousRadioGroup.dataIndex /= 4;; paramAnonymousRadioGroup.dataIndex *= 12)
        {
          DetailsFragment.this.chartType = 1;
          break;
          paramAnonymousRadioGroup = DetailsFragment.this;
        }
      }
      if (DetailsFragment.this.chartType == 0) {
        paramAnonymousRadioGroup = DetailsFragment.this;
      }
      for (paramAnonymousRadioGroup.dataIndex /= 54;; paramAnonymousRadioGroup.dataIndex /= 12)
      {
        DetailsFragment.this.chartType = 2;
        break;
        paramAnonymousRadioGroup = DetailsFragment.this;
      }
    }
  };
  private RadioGroup.OnCheckedChangeListener onPageChange = new RadioGroup.OnCheckedChangeListener()
  {
    public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      }
      for (;;)
      {
        DetailsFragment.this.updateLables();
        DetailsFragment.this.updateData();
        return;
        DetailsFragment.this.pageType = 0;
        DetailsFragment.this.mRootView.setBackgroundResource(2130837511);
        DetailsFragment.this.dataView0.setUnitColor(DetailsFragment.this.DAY_LABLE_COLOR);
        DetailsFragment.this.dataView1.setUnitColor(DetailsFragment.this.DAY_LABLE_COLOR);
        continue;
        DetailsFragment.this.dataView0.setUnitColor(DetailsFragment.this.NIGHT_LABLE_COLOR);
        DetailsFragment.this.dataView1.setUnitColor(DetailsFragment.this.NIGHT_LABLE_COLOR);
        DetailsFragment.this.pageType = 1;
        DetailsFragment.this.mRootView.setBackgroundResource(2130837512);
      }
    }
  };
  private int pageIndex;
  private int pageType;
  private RadioGroup pageTypeGroup;
  private DetailViewPager pager;
  private CopyOnWriteArrayList<DetailChart.PageData> sleepMonthData;
  private CopyOnWriteArrayList<DetailChart.PageData> sleepWeekData;
  private CopyOnWriteArrayList<DetailChart.PageData> sleepYearData;
  private CopyOnWriteArrayList<DetailChart.PageData> sportMonthData;
  private CopyOnWriteArrayList<DetailChart.PageData> sportWeekData;
  private CopyOnWriteArrayList<DetailChart.PageData> sportYearData;
  
  private void initView()
  {
    this.pager = ((DetailViewPager)this.mRootView.findViewById(2131230973));
    this.chartTypeGroup = ((RadioGroup)this.mRootView.findViewById(2131230969));
    this.pageTypeGroup = ((RadioGroup)this.mRootView.findViewById(2131230974));
    this.dataView0 = ((DataShowView)this.mRootView.findViewById(2131230978));
    this.dataView1 = ((DataShowView)this.mRootView.findViewById(2131230979));
    this.chartTypeGroup.setOnCheckedChangeListener(this.onChartTypeChange);
    this.pageTypeGroup.setOnCheckedChangeListener(this.onPageChange);
    this.pager.setListener(this);
    DataShowView.DataModel localDataModel1 = new DataShowView.DataModel("", "");
    DataShowView.DataModel localDataModel2 = new DataShowView.DataModel("", "");
    DataShowView.DataModel localDataModel3 = new DataShowView.DataModel("", "");
    this.dataView0.initDatas(new DataShowView.DataModel[] { localDataModel1, localDataModel2, localDataModel3 });
    localDataModel1 = new DataShowView.DataModel("", "");
    localDataModel2 = new DataShowView.DataModel("", "");
    localDataModel3 = new DataShowView.DataModel("", "");
    this.dataView1.initDatas(new DataShowView.DataModel[] { localDataModel1, localDataModel2, localDataModel3 });
    this.WEEK_LABELS = getResources().getStringArray(2131361797);
    this.MONTH_LABELS = getResources().getStringArray(2131361798);
    this.YEAR_LABELS = getResources().getStringArray(2131361799);
    this.NIGHT_LABELS = getResources().getStringArray(2131361800);
    this.lables = this.WEEK_LABELS;
    this.DAY_LABLE_COLOR = getResources().getColor(2131099648);
    this.NIGHT_LABLE_COLOR = getResources().getColor(2131099649);
    loadData(false);
  }
  
  private void loadData(final boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.sportWeekData = TempUtil.getPageDatas(0, 0, 0);
      this.pager.setDatas(this.sportWeekData, 0);
    }
    this.mLoadDataHandler.post(new Runnable()
    {
      public void run()
      {
        if (paramBoolean) {
          DetailsFragment.this.sportWeekData = TempUtil.getPageDatas(0, 0, 0);
        }
        DetailsFragment.this.sportMonthData = TempUtil.getPageDatas(1, 0, 0);
        DetailsFragment.this.sportYearData = TempUtil.getPageDatas(2, 0, 0);
        DebugLog.d("size = " + DetailsFragment.this.sportYearData.size());
        DetailsFragment.this.sleepWeekData = TempUtil.getPageDatas(0, 1, 0);
        DetailsFragment.this.sleepMonthData = TempUtil.getPageDatas(1, 1, 0);
        DetailsFragment.this.sleepYearData = TempUtil.getPageDatas(2, 1, 0);
        DetailsFragment.this.dataIndex = 0;
        DetailsFragment.this.updateData();
        DetailsFragment.this.loadMoreData(paramBoolean);
      }
    });
  }
  
  private void loadMoreData(final boolean paramBoolean)
  {
    this.mLoadDataHandler.post(new Runnable()
    {
      public void run()
      {
        DetailsFragment.this.sportWeekData.addAll(TempUtil.getPageMoreDatas(0, 0, 0, 4));
        DetailsFragment.this.sportMonthData.addAll(TempUtil.getPageMoreDatas(1, 0, 0, 4));
        DetailsFragment.this.sportYearData.addAll(TempUtil.getPageMoreDatas(2, 0, 0, 4));
        DetailsFragment.this.sleepWeekData.addAll(TempUtil.getPageMoreDatas(0, 1, 0, 4));
        DetailsFragment.this.sleepMonthData.addAll(TempUtil.getPageMoreDatas(1, 1, 0, 4));
        DetailsFragment.this.sleepYearData.addAll(TempUtil.getPageMoreDatas(2, 1, 0, 4));
        DetailsFragment.this.updateData();
        if (!paramBoolean)
        {
          DetailsFragment.this.sportWeekData.addAll(TempUtil.getPageLeftDatas(0, 0, 4));
          DetailsFragment.this.sportMonthData.addAll(TempUtil.getPageLeftDatas(1, 0, 4));
          DetailsFragment.this.sportYearData.addAll(TempUtil.getPageLeftDatas(2, 0, 4));
          DetailsFragment.this.sleepWeekData.addAll(TempUtil.getPageLeftDatas(0, 1, 4));
          DetailsFragment.this.sleepMonthData.addAll(TempUtil.getPageLeftDatas(1, 1, 4));
          DetailsFragment.this.sleepYearData.addAll(TempUtil.getPageLeftDatas(2, 1, 4));
        }
        DetailsFragment.this.updateData();
      }
    });
  }
  
  private void updateData()
  {
    if (this.pageType == 0)
    {
      switch (this.chartType)
      {
      default: 
        return;
      case 0: 
        this.pager.setDatas(this.sportWeekData, this.dataIndex, this.chartType);
        return;
      case 1: 
        this.pager.setDatas(this.sportMonthData, this.dataIndex, this.chartType);
        return;
      }
      this.pager.setDatas(this.sportYearData, this.dataIndex, this.chartType);
      return;
    }
    switch (this.chartType)
    {
    default: 
      return;
    case 0: 
      this.pager.setDatas(this.sleepWeekData, this.dataIndex, this.chartType);
      return;
    case 1: 
      this.pager.setDatas(this.sleepMonthData, this.dataIndex, this.chartType);
      return;
    }
    this.pager.setDatas(this.sleepYearData, this.dataIndex, this.chartType);
  }
  
  private void updateFirstDataGoal(CopyOnWriteArrayList<DetailChart.PageData> paramCopyOnWriteArrayList, int[] paramArrayOfInt, int paramInt)
  {
    paramCopyOnWriteArrayList = (DetailChart.PageData)paramCopyOnWriteArrayList.get(0);
    paramCopyOnWriteArrayList.goal = paramArrayOfInt[paramInt];
    paramCopyOnWriteArrayList.goalString = TempUtil.getGoalString(getResources(), paramCopyOnWriteArrayList.goal, paramInt);
  }
  
  private void updateLables()
  {
    if (this.pageType == 1)
    {
      this.lables = this.NIGHT_LABELS;
      return;
    }
    switch (this.chartType)
    {
    default: 
      return;
    case 0: 
      this.lables = this.WEEK_LABELS;
      return;
    case 1: 
      this.lables = this.MONTH_LABELS;
      return;
    }
    this.lables = this.YEAR_LABELS;
  }
  
  protected void lazyLoad()
  {
    if ((!this.isPrepared) || (!getUserVisibleHint())) {}
    do
    {
      return;
      if (LibSharedPreferences.getInstance().getUnits())
      {
        loadData(true);
        LibSharedPreferences.getInstance().setUnits(false);
      }
    } while (this.sleepYearData == null);
    int[] arrayOfInt = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    updateFirstDataGoal(this.sportWeekData, arrayOfInt, 0);
    updateFirstDataGoal(this.sportMonthData, arrayOfInt, 0);
    updateFirstDataGoal(this.sportYearData, arrayOfInt, 0);
    updateFirstDataGoal(this.sleepWeekData, arrayOfInt, 1);
    updateFirstDataGoal(this.sleepMonthData, arrayOfInt, 1);
    updateFirstDataGoal(this.sleepYearData, arrayOfInt, 1);
    updateData();
  }
  
  public void needMore(int paramInt) {}
  
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
      this.mRootView = paramLayoutInflater.inflate(2130903094, paramViewGroup, false);
      initView();
      this.isPrepared = true;
      lazyLoad();
    }
  }
  
  public void onPageSelected(DetailChart.PageData paramPageData, int paramInt)
  {
    this.dataIndex = paramInt;
    DebugLog.d("dataIndex = " + this.dataIndex);
    paramInt = 0;
    if (paramInt >= 6) {
      return;
    }
    if (paramInt < 3) {
      this.dataView0.updateData(paramInt, this.lables[paramInt], paramPageData.dataShow0[paramInt]);
    }
    for (;;)
    {
      paramInt += 1;
      break;
      this.dataView1.updateData(paramInt % 3, this.lables[paramInt], paramPageData.dataShow0[paramInt]);
    }
  }
  
  public void onThemeChanged()
  {
    DebugLog.e("详情收到主题切换的通知");
  }
  
  public void updateHealthData()
  {
    DebugLog.e("详情界面收到数据更新的通知");
    loadData(true);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\main\DetailsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */