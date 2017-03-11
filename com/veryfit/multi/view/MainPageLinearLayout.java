package com.veryfit.multi.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.project.library.util.DebugLog;
import com.veryfit.multi.view.group.FreshView;

public class MainPageLinearLayout
  extends LinearLayout
{
  private static final int DURATION = 500;
  private static final int MIN_SCROLL = 100;
  private int freshHeight;
  private FreshView freshView;
  private boolean isIntercept;
  private float startY;
  
  public MainPageLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void onStartUpdate() {}
  
  public int getFreshViewHeight()
  {
    if (this.freshHeight == 0) {
      this.freshHeight = this.freshView.getMeasuredHeight();
    }
    return this.freshHeight;
  }
  
  public void init()
  {
    this.freshView = ((FreshView)findViewById(2131231000));
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        MainPageLinearLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
        MainPageLinearLayout.this.setPaddingTop(-MainPageLinearLayout.this.getFreshViewHeight());
        return false;
      }
    });
  }
  
  public void onFinishUpdate()
  {
    ObjectAnimator.ofInt(this, "paddingTop", new int[] { 0, -getFreshViewHeight() }).setDuration(500L).start();
    this.freshView.setState(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    DebugLog.d("isIntercept = " + this.isIntercept + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return this.isIntercept;
      if ((paramMotionEvent.getY() - this.startY > 100.0F) && (getPaddingTop() == -getFreshViewHeight()))
      {
        this.isIntercept = true;
        continue;
        this.startY = paramMotionEvent.getY();
        this.isIntercept = false;
        continue;
        this.startY = 0.0F;
        this.isIntercept = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (this.freshView.getState() == 3) {
      return false;
    }
    int i = getPaddingTop();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      setPaddingTop(Math.max(-getFreshViewHeight(), Math.min(0, (int)(paramMotionEvent.getY() - this.startY) - getFreshViewHeight())));
      if (i < 0)
      {
        this.freshView.setState(1);
      }
      else if (i == 0)
      {
        this.freshView.setState(2);
        continue;
        if ((i < 0) && (i > -getFreshViewHeight()))
        {
          ObjectAnimator.ofInt(this, "paddingTop", new int[] { i, -getFreshViewHeight() }).setDuration((500.0F / getFreshViewHeight() * -i)).start();
        }
        else if (i == 0)
        {
          this.freshView.setState(3);
          onStartUpdate();
          postDelayed(new Runnable()
          {
            public void run()
            {
              MainPageLinearLayout.this.onFinishUpdate();
            }
          }, 2000L);
        }
      }
    }
  }
  
  public void setPaddingTop(int paramInt)
  {
    setPadding(getPaddingRight(), paramInt, getPaddingRight(), getPaddingBottom());
    invalidate();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\MainPageLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */