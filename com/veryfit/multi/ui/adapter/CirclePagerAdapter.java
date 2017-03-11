package com.veryfit.multi.ui.adapter;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.veryfit.multi.view.DetailChart;
import java.util.ArrayList;
import java.util.List;

public class CirclePagerAdapter
  extends PagerAdapter
{
  private List<DetailChart> views = new ArrayList();
  
  public CirclePagerAdapter(List<DetailChart> paramList)
  {
    this.views.addAll(paramList);
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
  }
  
  public void finishUpdate(View paramView) {}
  
  public int getCount()
  {
    return this.views.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = (View)this.views.get(paramInt);
    ((ViewPager)paramView).addView(localView, 0);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setAdapterView(ArrayList<DetailChart> paramArrayList)
  {
    this.views.clear();
    this.views.addAll(paramArrayList);
  }
  
  public void startUpdate(View paramView) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\adapter\CirclePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */