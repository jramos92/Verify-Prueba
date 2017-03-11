package com.veryfit.multi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import com.veryfit.multi.ui.adapter.CirclePagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircleViewPager
  extends ViewPager
{
  public static final int MOVE_TO_LEFT = 0;
  public static final int MOVE_TO_ROGHT = 1;
  public static final int UNMOVE = 2;
  private ArrayList<DetailChart.PageData> dataList = new ArrayList();
  private DetailChart.PageData[] datas = new DetailChart.PageData[3];
  private int direction;
  private int indexOffset;
  private List<DetailChart> listViews = new ArrayList();
  private PageListener onPageMoveListener;
  private int pageIndex;
  private boolean smoothScroll = true;
  private int state;
  
  public CircleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    this.listViews.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
    this.listViews.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
    this.listViews.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
    this.listViews.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
    this.listViews.add((DetailChart)localLayoutInflater.inflate(2130903076, null));
    setAdapter(new CirclePagerAdapter(this.listViews));
    setCurrentItem(4);
    setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      private int lastPosition = 4;
      
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          Log.v("View", "currentItem = " + CircleViewPager.this.getCurrentItem());
          if (CircleViewPager.this.indexOffset != 0) {
            break label67;
          }
          CircleViewPager.this.setCurrentItem(4, false);
        }
        for (;;)
        {
          CircleViewPager.this.update();
          CircleViewPager.this.state = paramAnonymousInt;
          return;
          label67:
          if (CircleViewPager.this.indexOffset == CircleViewPager.this.dataList.size() - 1) {
            CircleViewPager.this.setCurrentItem(0, false);
          } else if (CircleViewPager.this.getCurrentItem() == 0) {
            CircleViewPager.this.setCurrentItem(3, false);
          } else if (CircleViewPager.this.getCurrentItem() == 4) {
            CircleViewPager.this.setCurrentItem(1, false);
          }
        }
      }
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        int i = 1;
        Log.v("View", "****lastPosition = " + this.lastPosition + "**position = " + paramAnonymousInt + "***indexOffset = " + CircleViewPager.this.indexOffset);
        if (((this.lastPosition != 0) || (paramAnonymousInt != 3)) && ((this.lastPosition != 4) || (paramAnonymousInt != 1)) && ((paramAnonymousInt != 0) || (CircleViewPager.this.indexOffset != CircleViewPager.this.dataList.size() - 1)) && ((paramAnonymousInt != 4) || (CircleViewPager.this.indexOffset != 0)))
        {
          if (this.lastPosition != 0) {
            break label148;
          }
          localCircleViewPager = CircleViewPager.this;
        }
        for (localCircleViewPager.indexOffset -= 1;; localCircleViewPager.indexOffset += 1)
        {
          this.lastPosition = paramAnonymousInt;
          return;
          label148:
          if (this.lastPosition != 4) {
            break;
          }
          localCircleViewPager = CircleViewPager.this;
        }
        CircleViewPager localCircleViewPager = CircleViewPager.this;
        int j = localCircleViewPager.indexOffset;
        if (this.lastPosition > paramAnonymousInt) {}
        for (;;)
        {
          localCircleViewPager.indexOffset = (i + j);
          break;
          i = -1;
        }
      }
    });
  }
  
  private void update()
  {
    if (this.onPageMoveListener != null) {
      this.onPageMoveListener.onPageSelected((DetailChart.PageData)this.dataList.get(this.indexOffset));
    }
    Log.v("View", "indexOffset = " + this.indexOffset);
    int i = getCurrentItem();
    ((DetailChart)this.listViews.get(i)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset), 1);
    if (i == 4) {
      ((DetailChart)this.listViews.get(i - 1)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset + 1), 1);
    }
    do
    {
      return;
      if (i == 0)
      {
        ((DetailChart)this.listViews.get(i + 1)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset - 1), 1);
        return;
      }
      ((DetailChart)this.listViews.get(i - 1)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset + 1), 1);
      ((DetailChart)this.listViews.get(i + 1)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset - 1), 1);
      if (i == 1) {
        ((DetailChart)this.listViews.get(3)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset + 1), 1);
      }
      if (i == 3) {
        ((DetailChart)this.listViews.get(1)).setPageData((DetailChart.PageData)this.dataList.get(this.indexOffset + 1), 1);
      }
    } while ((this.indexOffset != this.dataList.size() - 2) || (this.onPageMoveListener == null));
    this.onPageMoveListener.needMore(this.pageIndex + 1);
  }
  
  public void addData(ArrayList<DetailChart.PageData> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext())
      {
        this.pageIndex += 1;
        return;
      }
      DetailChart.PageData localPageData = (DetailChart.PageData)paramArrayList.next();
      this.dataList.add(localPageData);
    }
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (paramInt < getCurrentItem()) {}
    for (this.direction = 0;; this.direction = 1)
    {
      this.smoothScroll = true;
      super.setCurrentItem(paramInt);
      return;
    }
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if (paramInt < getCurrentItem()) {}
    for (this.direction = 0;; this.direction = 1)
    {
      this.smoothScroll = paramBoolean;
      super.setCurrentItem(paramInt, paramBoolean);
      return;
    }
  }
  
  public void setData(ArrayList<DetailChart.PageData> paramArrayList)
  {
    this.dataList = paramArrayList;
    update();
  }
  
  public void setDatas(DetailChart.PageData[] paramArrayOfPageData)
  {
    this.datas = paramArrayOfPageData;
    update();
  }
  
  public void setOnPageMoveListener(PageListener paramPageListener)
  {
    this.onPageMoveListener = paramPageListener;
  }
  
  public static abstract interface PageListener
  {
    public abstract void needMore(int paramInt);
    
    public abstract void onPageSelected(DetailChart.PageData paramPageData);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\CircleViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */