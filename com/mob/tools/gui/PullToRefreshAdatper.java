package com.mob.tools.gui;

import android.content.Context;
import android.view.View;

public abstract class PullToRefreshAdatper
{
  private Context context;
  private PullToRefreshView parent;
  
  public PullToRefreshAdatper(PullToRefreshView paramPullToRefreshView)
  {
    this.context = paramPullToRefreshView.getContext();
    this.parent = paramPullToRefreshView;
  }
  
  public abstract Scrollable getBodyView();
  
  public Context getContext()
  {
    return this.context;
  }
  
  public abstract View getHeaderView();
  
  protected PullToRefreshView getParent()
  {
    return this.parent;
  }
  
  public abstract boolean isPullReady();
  
  public void notifyDataSetChanged()
  {
    this.parent.stopPulling();
  }
  
  public abstract void onPullDown(int paramInt);
  
  public abstract void onRequest();
  
  public void onReversed() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\PullToRefreshAdatper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */