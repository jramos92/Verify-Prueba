package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class MobViewPager
  extends ViewGroup
{
  private static final int SNAP_VELOCITY = 500;
  private static final int TOUCH_STATE_REST = 0;
  private static final int TOUCH_STATE_SCROLLING = 1;
  private ViewPagerAdapter adapter;
  private View currentPage;
  private int currentScreen;
  private float lastMotionX;
  private float lastMotionY;
  private int mMaximumVelocity;
  private VelocityTracker mVelocityTracker;
  private View nextPage;
  private View previousPage;
  private int screenCount;
  private Scroller scroller;
  private int touchSlop;
  private int touchState = 0;
  
  public MobViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MobViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void handleInterceptMove(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = (int)Math.abs(f1 - this.lastMotionX);
    int j = (int)Math.abs(f2 - this.lastMotionY);
    if (i > this.touchSlop)
    {
      i = 1;
      if (j <= this.touchSlop) {
        break label90;
      }
    }
    label90:
    for (j = 1;; j = 0)
    {
      if (((i != 0) || (j != 0)) && (i != 0))
      {
        this.touchState = 1;
        this.lastMotionX = f1;
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void handleScrollMove(MotionEvent paramMotionEvent)
  {
    if (this.adapter == null) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          float f = paramMotionEvent.getX();
          i = (int)(this.lastMotionX - f);
          this.lastMotionX = f;
          if (i >= 0) {
            break;
          }
        } while (getScrollX() <= 0);
        scrollBy(Math.max(-getScrollX(), i), 0);
        return;
      } while ((i <= 0) || (getChildCount() == 0));
      j = getChildAt(getChildCount() - 1).getRight() - getScrollX() - getWidth();
    } while (j <= 0);
    scrollBy(Math.min(j, i), 0);
  }
  
  private void init(Context paramContext)
  {
    this.scroller = new Scroller(getContext(), new Interpolator()
    {
      float[] values = { 0.0F, 0.0157073F, 0.0314108F, 0.0471065F, 0.0627905F, 0.0784591F, 0.0941083F, 0.109734F, 0.125333F, 0.140901F, 0.156434F, 0.171929F, 0.187381F, 0.202787F, 0.218143F, 0.233445F, 0.24869F, 0.263873F, 0.278991F, 0.29404F, 0.309017F, 0.323917F, 0.338738F, 0.353475F, 0.368125F, 0.382683F, 0.397148F, 0.411514F, 0.425779F, 0.439939F, 0.45399F, 0.46793F, 0.481754F, 0.495459F, 0.509041F, 0.522499F, 0.535827F, 0.549023F, 0.562083F, 0.575005F, 0.587785F, 0.60042F, 0.612907F, 0.625243F, 0.637424F, 0.649448F, 0.661312F, 0.673013F, 0.684547F, 0.695913F, 0.707107F, 0.718126F, 0.728969F, 0.739631F, 0.750111F, 0.760406F, 0.770513F, 0.78043F, 0.790155F, 0.799685F, 0.809017F, 0.81815F, 0.827081F, 0.835807F, 0.844328F, 0.85264F, 0.860742F, 0.868632F, 0.876307F, 0.883766F, 0.891007F, 0.898028F, 0.904827F, 0.911403F, 0.917755F, 0.92388F, 0.929776F, 0.935444F, 0.940881F, 0.946085F, 0.951057F, 0.955793F, 0.960294F, 0.964557F, 0.968583F, 0.97237F, 0.975917F, 0.979223F, 0.982287F, 0.985109F, 0.987688F, 0.990024F, 0.992115F, 0.993961F, 0.995562F, 0.996917F, 0.998027F, 0.99889F, 0.999507F, 0.999877F, 1.0F };
      
      public float getInterpolation(float paramAnonymousFloat)
      {
        int i = (int)(100.0F * paramAnonymousFloat);
        return this.values[i];
      }
    });
    paramContext = ViewConfiguration.get(paramContext);
    this.touchSlop = paramContext.getScaledTouchSlop();
    this.mMaximumVelocity = paramContext.getScaledMaximumFlingVelocity();
  }
  
  private void onScreenChange(int paramInt)
  {
    if (this.adapter != null)
    {
      int i;
      int j;
      View localView;
      if (this.currentScreen > paramInt)
      {
        i = 0;
        if (i < this.currentScreen - paramInt)
        {
          j = paramInt + i + 1;
          localView = this.previousPage;
          this.previousPage = this.currentPage;
          this.currentPage = this.nextPage;
          if (getChildCount() >= 3) {
            removeViewAt(0);
          }
          if (j < this.screenCount - 1)
          {
            this.nextPage = this.adapter.getView(j + 1, localView, this);
            addView(this.nextPage);
          }
          for (;;)
          {
            i += 1;
            break;
            this.nextPage = localView;
          }
        }
      }
      else
      {
        i = 0;
        if (i < paramInt - this.currentScreen)
        {
          j = paramInt - i - 1;
          localView = this.nextPage;
          this.nextPage = this.currentPage;
          this.currentPage = this.previousPage;
          if (getChildCount() >= 3) {
            removeViewAt(2);
          }
          if (j > 0)
          {
            this.previousPage = this.adapter.getView(j - 1, localView, this);
            addView(this.previousPage, 0);
          }
          for (;;)
          {
            i += 1;
            break;
            this.previousPage = localView;
          }
        }
      }
      this.adapter.onScreenChange(this.currentScreen, paramInt);
    }
  }
  
  public void computeScroll()
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    int k;
    do
    {
      return;
      if (this.scroller.computeScrollOffset())
      {
        scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
        postInvalidate();
        return;
      }
      k = this.currentScreen;
      int m = this.scroller.getCurrX();
      int n = getWidth();
      int j = m / n;
      int i = j;
      if (m % n > n / 2) {
        i = j + 1;
      }
      this.currentScreen = Math.max(0, Math.min(i, this.screenCount - 1));
    } while (k == this.currentScreen);
    onScreenChange(k);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    long l;
    do
    {
      return;
      l = getDrawingTime();
      if (this.currentScreen > 0) {
        drawChild(paramCanvas, this.previousPage, l);
      }
      drawChild(paramCanvas, this.currentPage, l);
    } while (this.currentScreen >= this.screenCount - 1);
    drawChild(paramCanvas, this.nextPage, l);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (this.adapter == null) {
      return super.dispatchUnhandledMove(paramView, paramInt);
    }
    if (paramInt == 17)
    {
      if (this.currentScreen > 0)
      {
        scrollToScreen(this.currentScreen - 1, false);
        return true;
      }
    }
    else if ((paramInt == 66) && (this.currentScreen < this.screenCount - 1))
    {
      scrollToScreen(this.currentScreen + 1, false);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.currentScreen;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.touchState != 0)) {}
    for (;;)
    {
      return true;
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      switch (i)
      {
      }
      while (this.touchState == 0)
      {
        return false;
        handleInterceptMove(paramMotionEvent);
        continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.lastMotionX = f1;
        this.lastMotionY = f2;
        if (this.scroller.isFinished()) {}
        for (i = 0;; i = 1)
        {
          this.touchState = i;
          break;
        }
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        this.touchState = 0;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    do
    {
      return;
      paramInt1 = paramInt3 - paramInt1;
      paramInt2 = paramInt4 - paramInt2;
      paramInt3 = this.currentScreen * paramInt1;
      if (this.currentScreen > 0) {
        this.previousPage.layout(paramInt3 - paramInt1, 0, paramInt3, paramInt2);
      }
      this.currentPage.layout(paramInt3, 0, paramInt3 + paramInt1, paramInt2);
    } while (this.currentScreen >= this.screenCount - 1);
    this.nextPage.layout(paramInt3 + paramInt1, 0, paramInt3 + paramInt1 + paramInt1, paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.adapter == null) || (this.screenCount <= 0)) {}
    for (;;)
    {
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = getMeasuredHeight();
      paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      int i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        getChildAt(paramInt1).measure(paramInt2, i);
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.adapter == null) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if (this.touchState != 0)
      {
        if (!this.scroller.isFinished()) {
          this.scroller.abortAnimation();
        }
        this.lastMotionX = f;
        continue;
        if (this.touchState == 1)
        {
          handleScrollMove(paramMotionEvent);
        }
        else if ((onInterceptTouchEvent(paramMotionEvent)) && (this.touchState == 1))
        {
          handleScrollMove(paramMotionEvent);
          continue;
          if (this.touchState == 1)
          {
            paramMotionEvent = this.mVelocityTracker;
            paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
            i = (int)paramMotionEvent.getXVelocity();
            if ((i <= 500) || (this.currentScreen <= 0)) {
              break label229;
            }
            scrollToScreen(this.currentScreen - 1, false);
          }
          for (;;)
          {
            if (this.mVelocityTracker != null)
            {
              this.mVelocityTracker.recycle();
              this.mVelocityTracker = null;
            }
            this.touchState = 0;
            break;
            label229:
            if ((i < 65036) && (this.currentScreen < this.screenCount - 1))
            {
              scrollToScreen(this.currentScreen + 1, false);
            }
            else
            {
              i = getWidth();
              scrollToScreen((getScrollX() + i / 2) / i, false);
            }
          }
          this.touchState = 0;
        }
      }
    }
  }
  
  public void scrollLeft(boolean paramBoolean)
  {
    if (this.currentScreen > 0) {
      scrollToScreen(this.currentScreen - 1, paramBoolean);
    }
  }
  
  public void scrollRight(boolean paramBoolean)
  {
    if (this.currentScreen < this.screenCount - 1) {
      scrollToScreen(this.currentScreen + 1, paramBoolean);
    }
  }
  
  public void scrollToScreen(int paramInt, boolean paramBoolean)
  {
    if ((this.currentPage != null) && (getFocusedChild() == this.currentPage)) {
      this.currentPage.clearFocus();
    }
    int i = paramInt * getWidth() - getScrollX();
    this.scroller.abortAnimation();
    Scroller localScroller = this.scroller;
    int j = getScrollX();
    if (paramBoolean) {}
    for (paramInt = 0;; paramInt = Math.abs(i) / 2)
    {
      localScroller.startScroll(j, 0, i, 0, paramInt);
      invalidate();
      return;
    }
  }
  
  public void setAdapter(ViewPagerAdapter paramViewPagerAdapter)
  {
    if (this.adapter != null) {
      this.adapter.setMobViewPager(null);
    }
    this.adapter = paramViewPagerAdapter;
    if (this.adapter != null) {
      this.adapter.setMobViewPager(this);
    }
    if (paramViewPagerAdapter == null)
    {
      this.currentScreen = 0;
      removeAllViews();
    }
    do
    {
      return;
      this.screenCount = paramViewPagerAdapter.getCount();
      if (this.screenCount <= 0)
      {
        this.currentScreen = 0;
        removeAllViews();
        return;
      }
      if (this.screenCount <= this.currentScreen)
      {
        scrollToScreen(this.screenCount - 1, true);
        return;
      }
      removeAllViews();
      if (this.currentScreen > 0)
      {
        this.previousPage = paramViewPagerAdapter.getView(this.currentScreen - 1, this.previousPage, this);
        addView(this.previousPage);
      }
      this.currentPage = paramViewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
      addView(this.currentPage);
    } while (this.currentScreen >= this.screenCount - 1);
    this.nextPage = paramViewPagerAdapter.getView(this.currentScreen + 1, this.nextPage, this);
    addView(this.nextPage);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\MobViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */