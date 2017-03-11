package com.veryfit.multi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.project.library.util.DebugLog;

public class HorzionScroll
  extends View
{
  protected int drawCount;
  protected Runnable goOnDraw = new Runnable()
  {
    private int REDRAW_COUNT = 20;
    
    public void run()
    {
      if ((HorzionScroll.this.drawCount < this.REDRAW_COUNT) && (Math.abs(HorzionScroll.this.mVelocity) > 5000))
      {
        int i = (int)(HorzionScroll.this.mVelocity * 1.0F / this.REDRAW_COUNT * (this.REDRAW_COUNT - HorzionScroll.this.drawCount + 0.5D) * 0.1D / (HorzionScroll.this.drawCount * 5));
        HorzionScroll.this.scrollBy(-i, 0);
        HorzionScroll localHorzionScroll = HorzionScroll.this;
        localHorzionScroll.drawCount += 1;
        HorzionScroll.this.postDelayed(HorzionScroll.this.goOnDraw, 500 / this.REDRAW_COUNT);
        return;
      }
      HorzionScroll.this.endScorll();
    }
  };
  protected int mVelocity;
  protected float pre;
  protected float start;
  protected VelocityTracker velocityTracker;
  
  public HorzionScroll(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorzionScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HorzionScroll(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void endScorll()
  {
    recycleVelocityTracker();
    getParent().requestDisallowInterceptTouchEvent(false);
  }
  
  protected void initOrResetVelocityTracker()
  {
    if (this.velocityTracker == null)
    {
      this.velocityTracker = VelocityTracker.obtain();
      return;
    }
    this.velocityTracker.clear();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      getParent().requestDisallowInterceptTouchEvent(true);
      removeCallbacks(this.goOnDraw);
      this.drawCount = 1;
      initOrResetVelocityTracker();
      this.velocityTracker.addMovement(paramMotionEvent);
      this.start = paramMotionEvent.getRawX();
      this.pre = this.start;
      return true;
    case 2: 
      this.velocityTracker.addMovement(paramMotionEvent);
      scrollBy((int)(this.pre - paramMotionEvent.getRawX() - 0.5D), 0);
      this.pre = paramMotionEvent.getRawX();
      return true;
    case 1: 
      this.velocityTracker.addMovement(paramMotionEvent);
      this.velocityTracker.computeCurrentVelocity(1000, ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity());
      this.mVelocity = ((int)this.velocityTracker.getXVelocity());
      postDelayed(this.goOnDraw, 50L);
      return true;
    }
    DebugLog.e("cancle");
    endScorll();
    return true;
  }
  
  protected void recycleVelocityTracker()
  {
    if (this.velocityTracker != null)
    {
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\HorzionScroll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */