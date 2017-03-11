package com.veryfit.multi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.project.library.util.DebugLog;
import com.veryfit.multi.ui.adapter.CirclePagerAdapter;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class DetailViewPager
  extends ViewPager
{
  private CirclePagerAdapter adapter = new CirclePagerAdapter(this.adapterView);
  private ArrayList<DetailChart> adapterView = new ArrayList();
  private ArrayList<DetailChart> cache = new ArrayList();
  private CopyOnWriteArrayList<DetailChart.PageData> datas;
  private PageListener listener;
  
  public DetailViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setAdapter(this.adapter);
    createViewToCache(3);
    setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt) {}
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        if (DetailViewPager.this.listener != null)
        {
          paramAnonymousInt = DetailViewPager.this.datas.size() - 1 - paramAnonymousInt;
          DetailViewPager.this.listener.onPageSelected((DetailChart.PageData)DetailViewPager.this.datas.get(paramAnonymousInt), paramAnonymousInt);
        }
      }
    });
  }
  
  private void createViewToCache(int paramInt)
  {
    long l;
    LayoutInflater localLayoutInflater;
    int i;
    if (paramInt > 0)
    {
      l = System.currentTimeMillis();
      localLayoutInflater = LayoutInflater.from(getContext());
      i = 0;
    }
    for (;;)
    {
      if (i >= paramInt)
      {
        DebugLog.d("extra = " + paramInt + "*****" + (System.currentTimeMillis() - l));
        return;
      }
      this.cache.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
      i += 1;
    }
  }
  
  private void pushData2View(CopyOnWriteArrayList<DetailChart.PageData> paramCopyOnWriteArrayList, int paramInt)
  {
    int i;
    if ((paramCopyOnWriteArrayList != null) && (paramCopyOnWriteArrayList.size() != this.adapterView.size()))
    {
      this.adapterView.clear();
      createViewToCache(paramCopyOnWriteArrayList.size() - this.cache.size());
      i = 0;
      if (i >= paramCopyOnWriteArrayList.size()) {
        this.adapter.setAdapterView(this.adapterView);
      }
    }
    for (;;)
    {
      return;
      DetailChart localDetailChart = (DetailChart)this.cache.get(i);
      localDetailChart.setPageData((DetailChart.PageData)paramCopyOnWriteArrayList.get(paramCopyOnWriteArrayList.size() - 1 - i), paramInt);
      this.adapterView.add(localDetailChart);
      i += 1;
      break;
      i = 0;
      while (i < paramCopyOnWriteArrayList.size())
      {
        ((DetailChart)this.adapterView.get(i)).setPageData((DetailChart.PageData)paramCopyOnWriteArrayList.get(paramCopyOnWriteArrayList.size() - 1 - i), paramInt);
        i += 1;
      }
    }
  }
  
  public void setDatas(CopyOnWriteArrayList<DetailChart.PageData> paramCopyOnWriteArrayList, int paramInt)
  {
    setDatas(paramCopyOnWriteArrayList, 0, paramInt);
  }
  
  public void setDatas(CopyOnWriteArrayList<DetailChart.PageData> paramCopyOnWriteArrayList, int paramInt1, int paramInt2)
  {
    this.datas = paramCopyOnWriteArrayList;
    pushData2View(paramCopyOnWriteArrayList, paramInt2);
    this.adapter.notifyDataSetChanged();
    setCurrentItem(paramCopyOnWriteArrayList.size() - 1 - paramInt1, false);
    if (this.listener != null)
    {
      paramInt1 = Math.max(0, Math.min(paramInt1, paramCopyOnWriteArrayList.size() - 1));
      this.listener.onPageSelected((DetailChart.PageData)paramCopyOnWriteArrayList.get(paramInt1), paramInt1);
    }
  }
  
  public void setListener(PageListener paramPageListener)
  {
    this.listener = paramPageListener;
  }
  
  public static abstract interface PageListener
  {
    public abstract void needMore(int paramInt);
    
    public abstract void onPageSelected(DetailChart.PageData paramPageData, int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\DetailViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */