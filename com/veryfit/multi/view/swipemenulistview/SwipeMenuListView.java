package com.veryfit.multi.view.swipemenulistview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SwipeMenuListView
  extends ListView
{
  private static final int TOUCH_STATE_NONE = 0;
  private static final int TOUCH_STATE_X = 1;
  private static final int TOUCH_STATE_Y = 2;
  private int MAX_X = 3;
  private int MAX_Y = 5;
  private Interpolator mCloseInterpolator;
  private float mDownX;
  private float mDownY;
  private SwipeMenuCreator mMenuCreator;
  private OnMenuItemClickListener mOnMenuItemClickListener;
  private OnSwipeListener mOnSwipeListener;
  private Interpolator mOpenInterpolator;
  private int mTouchPosition;
  private int mTouchState;
  private SwipeMenuLayout mTouchView;
  
  public SwipeMenuListView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SwipeMenuListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int dp2px(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getContext().getResources().getDisplayMetrics());
  }
  
  private void init()
  {
    this.MAX_X = dp2px(this.MAX_X);
    this.MAX_Y = dp2px(this.MAX_Y);
    this.mTouchState = 0;
  }
  
  public Interpolator getCloseInterpolator()
  {
    return this.mCloseInterpolator;
  }
  
  public Interpolator getOpenInterpolator()
  {
    return this.mOpenInterpolator;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) && (this.mTouchView == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    MotionEventCompat.getActionMasked(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        int i = this.mTouchPosition;
        this.mDownX = paramMotionEvent.getX();
        this.mDownY = paramMotionEvent.getY();
        this.mTouchState = 0;
        this.mTouchPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if ((this.mTouchPosition == i) && (this.mTouchView != null) && (this.mTouchView.isOpen()))
        {
          this.mTouchState = 1;
          this.mTouchView.onSwipe(paramMotionEvent);
          return true;
        }
        View localView = getChildAt(this.mTouchPosition - getFirstVisiblePosition());
        if ((this.mTouchView != null) && (this.mTouchView.isOpen()))
        {
          this.mTouchView.smoothCloseMenu();
          this.mTouchView = null;
          paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
          paramMotionEvent.setAction(3);
          onTouchEvent(paramMotionEvent);
          return true;
        }
        if ((localView instanceof SwipeMenuLayout)) {
          this.mTouchView = ((SwipeMenuLayout)localView);
        }
        if (this.mTouchView != null)
        {
          this.mTouchView.onSwipe(paramMotionEvent);
          continue;
          float f1 = Math.abs(paramMotionEvent.getY() - this.mDownY);
          float f2 = Math.abs(paramMotionEvent.getX() - this.mDownX);
          if (this.mTouchState == 1)
          {
            if (this.mTouchView != null) {
              this.mTouchView.onSwipe(paramMotionEvent);
            }
            getSelector().setState(new int[1]);
            paramMotionEvent.setAction(3);
            super.onTouchEvent(paramMotionEvent);
            return true;
          }
          if (this.mTouchState == 0) {
            if (Math.abs(f1) > this.MAX_Y)
            {
              this.mTouchState = 2;
            }
            else if (f2 > this.MAX_X)
            {
              this.mTouchState = 1;
              if (this.mOnSwipeListener != null) {
                this.mOnSwipeListener.onSwipeStart(this.mTouchPosition);
              }
            }
          }
        }
      }
    } while (this.mTouchState != 1);
    if (this.mTouchView != null)
    {
      this.mTouchView.onSwipe(paramMotionEvent);
      if (!this.mTouchView.isOpen())
      {
        this.mTouchPosition = -1;
        this.mTouchView = null;
      }
    }
    if (this.mOnSwipeListener != null) {
      this.mOnSwipeListener.onSwipeEnd(this.mTouchPosition);
    }
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(new SwipeMenuAdapter(getContext(), paramListAdapter)
    {
      public void createMenu(SwipeMenu paramAnonymousSwipeMenu)
      {
        if (SwipeMenuListView.this.mMenuCreator != null) {
          SwipeMenuListView.this.mMenuCreator.create(paramAnonymousSwipeMenu);
        }
      }
      
      public void onItemClick(SwipeMenuView paramAnonymousSwipeMenuView, SwipeMenu paramAnonymousSwipeMenu, int paramAnonymousInt)
      {
        boolean bool = false;
        if (SwipeMenuListView.this.mOnMenuItemClickListener != null) {
          bool = SwipeMenuListView.this.mOnMenuItemClickListener.onMenuItemClick(paramAnonymousSwipeMenuView.getPosition(), paramAnonymousSwipeMenu, paramAnonymousInt);
        }
        if ((SwipeMenuListView.this.mTouchView != null) && (!bool)) {
          SwipeMenuListView.this.mTouchView.smoothCloseMenu();
        }
      }
    });
  }
  
  public void setCloseInterpolator(Interpolator paramInterpolator)
  {
    this.mCloseInterpolator = paramInterpolator;
  }
  
  public void setMenuCreator(SwipeMenuCreator paramSwipeMenuCreator)
  {
    this.mMenuCreator = paramSwipeMenuCreator;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOnSwipeListener(OnSwipeListener paramOnSwipeListener)
  {
    this.mOnSwipeListener = paramOnSwipeListener;
  }
  
  public void setOpenInterpolator(Interpolator paramInterpolator)
  {
    this.mOpenInterpolator = paramInterpolator;
  }
  
  public void smoothOpenMenu(int paramInt)
  {
    if ((paramInt >= getFirstVisiblePosition()) && (paramInt <= getLastVisiblePosition()))
    {
      View localView = getChildAt(paramInt - getFirstVisiblePosition());
      if ((localView instanceof SwipeMenuLayout))
      {
        this.mTouchPosition = paramInt;
        if ((this.mTouchView != null) && (this.mTouchView.isOpen())) {
          this.mTouchView.smoothCloseMenu();
        }
        this.mTouchView = ((SwipeMenuLayout)localView);
        this.mTouchView.smoothOpenMenu();
      }
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(int paramInt1, SwipeMenu paramSwipeMenu, int paramInt2);
  }
  
  public static abstract interface OnSwipeListener
  {
    public abstract void onSwipeEnd(int paramInt);
    
    public abstract void onSwipeStart(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\swipemenulistview\SwipeMenuListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */