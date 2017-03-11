package com.veryfit.multi.view.swipemenulistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

public class SwipeMenuAdapter
  implements WrapperListAdapter, SwipeMenuView.OnSwipeItemClickListener
{
  private ListAdapter mAdapter;
  private Context mContext;
  private SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener;
  
  public SwipeMenuAdapter(Context paramContext, ListAdapter paramListAdapter)
  {
    this.mAdapter = paramListAdapter;
    this.mContext = paramContext;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.mAdapter.areAllItemsEnabled();
  }
  
  public void createMenu(SwipeMenu paramSwipeMenu)
  {
    SwipeMenuItem localSwipeMenuItem = new SwipeMenuItem(this.mContext);
    localSwipeMenuItem.setTitle("Item 1");
    localSwipeMenuItem.setBackground(new ColorDrawable(-7829368));
    localSwipeMenuItem.setWidth(300);
    paramSwipeMenu.addMenuItem(localSwipeMenuItem);
    localSwipeMenuItem = new SwipeMenuItem(this.mContext);
    localSwipeMenuItem.setTitle("Item 2");
    localSwipeMenuItem.setBackground(new ColorDrawable(-65536));
    localSwipeMenuItem.setWidth(300);
    paramSwipeMenu.addMenuItem(localSwipeMenuItem);
  }
  
  public int getCount()
  {
    return this.mAdapter.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.mAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.mAdapter.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.mAdapter.getView(paramInt, paramView, paramViewGroup);
      Object localObject = new SwipeMenu(this.mContext);
      ((SwipeMenu)localObject).setViewType(this.mAdapter.getItemViewType(paramInt));
      createMenu((SwipeMenu)localObject);
      localObject = new SwipeMenuView((SwipeMenu)localObject, (SwipeMenuListView)paramViewGroup);
      ((SwipeMenuView)localObject).setOnSwipeItemClickListener(this);
      paramViewGroup = (SwipeMenuListView)paramViewGroup;
      paramView = new SwipeMenuLayout(paramView, (SwipeMenuView)localObject, paramViewGroup.getCloseInterpolator(), paramViewGroup.getOpenInterpolator());
      paramView.setPosition(paramInt);
      return paramView;
    }
    paramView = (SwipeMenuLayout)paramView;
    paramView.closeMenu();
    paramView.setPosition(paramInt);
    this.mAdapter.getView(paramInt, paramView.getContentView(), paramViewGroup);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.mAdapter.getViewTypeCount();
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.mAdapter;
  }
  
  public boolean hasStableIds()
  {
    return this.mAdapter.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.mAdapter.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.mAdapter.isEnabled(paramInt);
  }
  
  public void onItemClick(SwipeMenuView paramSwipeMenuView, SwipeMenu paramSwipeMenu, int paramInt)
  {
    if (this.onMenuItemClickListener != null) {
      this.onMenuItemClickListener.onMenuItemClick(paramSwipeMenuView.getPosition(), paramSwipeMenu, paramInt);
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mAdapter.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void setOnMenuItemClickListener(SwipeMenuListView.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.onMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\swipemenulistview\SwipeMenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */