package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.veryfit.multi.util.ViewUtil;

public class HorizonRulerView
  extends View
{
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;
  protected int LINE_WIDTH = 2;
  protected int[] data;
  protected int defaultOffset;
  protected int drawCount;
  private Runnable goOnDraw = new Runnable()
  {
    private int MAX_REDRAW_COUNT = 10;
    
    public void run()
    {
      if ((HorizonRulerView.this.drawCount < this.MAX_REDRAW_COUNT) && (Math.abs(HorizonRulerView.this.mVelocity) > 5000))
      {
        int i = (int)(HorizonRulerView.this.mVelocity * 0.05D / this.MAX_REDRAW_COUNT * (this.MAX_REDRAW_COUNT - HorizonRulerView.this.drawCount + 0.5D));
        HorizonRulerView.this.scrollBy(-i, 0);
        HorizonRulerView localHorizonRulerView = HorizonRulerView.this;
        localHorizonRulerView.drawCount += 1;
        HorizonRulerView.this.postDelayed(HorizonRulerView.this.goOnDraw, 20L);
        return;
      }
      HorizonRulerView.this.endScorll();
    }
  };
  protected int h;
  protected int mDataStep = 10;
  protected int mDevideCount = 5;
  protected int mLightColor = -6040761;
  protected float mLineLength;
  protected int mMaxData = 255;
  protected int mMinData = 30;
  protected int mRulerColor = -1;
  protected int mShadowColor = -14211289;
  protected int mSpaceSize;
  protected String[] mUnits = { "m", "cm" };
  protected int mVelocity;
  protected int maxLineCount;
  protected Paint paint;
  protected float pre;
  protected float start;
  protected float textSize;
  protected int tickMarkDataStep = 1;
  protected int tickMarkStep;
  protected String title;
  protected VelocityTracker velocityTracker;
  protected int w;
  
  public HorizonRulerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public HorizonRulerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public HorizonRulerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawLabel(Canvas paramCanvas)
  {
    this.paint.setColor(this.mLightColor);
    int i = getWidth() / 2 - this.LINE_WIDTH / 2 + getScrollX();
    float f1 = this.h - this.mLineLength * 1.8F;
    paramCanvas.drawLine(i, this.h, i, f1, this.paint);
    float f2 = this.mLineLength * 0.1F;
    Path localPath = new Path();
    localPath.moveTo(i + f2, f1);
    localPath.lineTo(i, f1 - 1.8F * f2);
    localPath.lineTo(i - f2, f1);
    localPath.close();
    paramCanvas.drawPath(localPath, this.paint);
    f2 = f1 - this.mLineLength * 0.3F;
    float f3 = this.textSize * 2.0F;
    f1 = this.textSize * 1.5F;
    if (this.mUnits.length == 1)
    {
      this.paint.setTextSize(f1);
      paramCanvas.drawText(this.mUnits[0], i, f2, this.paint);
      f2 -= ViewUtil.getTextHeight(this.paint);
      this.paint.setTextSize(f3);
      paramCanvas.drawText(this.data[0] + this.data[1], i, f2, this.paint);
      f3 = ViewUtil.getTextHeight(this.paint);
      this.paint.setTextSize(f1);
      paramCanvas.drawText(this.title, i, f2 - f3, this.paint);
    }
    while (this.mUnits.length != 2) {
      return;
    }
    float f4 = this.mLineLength * 0.1F;
    this.paint.setTextSize(f3);
    float f5 = ViewUtil.getTextRectWidth(this.paint, this.data[0]);
    float f6 = ViewUtil.getTextRectWidth(this.paint, this.data[1]);
    this.paint.setTextSize(f1);
    float f7 = ViewUtil.getTextRectWidth(this.paint, this.mUnits[0]);
    float f8 = f5 + f4 + f7 + f4 + f6 + f4 + ViewUtil.getTextRectWidth(this.paint, this.mUnits[1]);
    this.paint.setTextAlign(Paint.Align.LEFT);
    this.paint.setTextSize(f3);
    paramCanvas.drawText(this.data[0], i - f8 / 2.0F, f2, this.paint);
    paramCanvas.drawText(this.data[1], i - f8 / 2.0F + f5 + f4 + f7 + f4, f2, this.paint);
    this.paint.setTextSize(f1);
    paramCanvas.drawText(this.mUnits[0], i - f8 / 2.0F + f5 + f4, f2, this.paint);
    paramCanvas.drawText(this.mUnits[1], i - f8 / 2.0F + f5 + f4 + f7 + f4 + f6 + f4, f2, this.paint);
    this.paint.setTextAlign(Paint.Align.CENTER);
    this.paint.setTextSize(f3);
    f3 = ViewUtil.getTextHeight(this.paint);
    this.paint.setTextSize(f1);
    paramCanvas.drawText(this.title, i, f2 - f3, this.paint);
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    int i = computeHorizontalScrollOffset();
    this.paint.setShader(new LinearGradient(i, 0.0F, getWidth() / 3 + i, 0.0F, this.mShadowColor, 0, Shader.TileMode.CLAMP));
    paramCanvas.drawRect(i, 0.0F, getWidth() / 3 + i, getHeight(), this.paint);
    this.paint.setShader(new LinearGradient(getWidth() / 3 * 2 + i, 0.0F, getWidth() + i, 0.0F, 0, this.mShadowColor, Shader.TileMode.CLAMP));
    paramCanvas.drawRect(getWidth() / 3 * 2 + i, 0.0F, getWidth() + i, getHeight(), this.paint);
    this.paint.setShader(null);
  }
  
  private void drawTickMark(Canvas paramCanvas)
  {
    Log.d("---", "--------------------------");
    int k = this.mDevideCount;
    int j = getScrollX();
    paramCanvas.save();
    paramCanvas.translate(this.defaultOffset - j, 0.0F);
    paramCanvas.clipRect(getPaddingLeft() - this.defaultOffset + j, 0, this.w + getPaddingLeft() - this.defaultOffset + j, getMeasuredHeight());
    Log.d("ywx", "defaultOffset:" + this.defaultOffset);
    this.paint.setColor(this.mRulerColor);
    this.paint.setTextSize(this.textSize);
    if (j < this.defaultOffset) {}
    for (int i = 0;; i = (j - this.defaultOffset) / this.tickMarkStep + 1)
    {
      k = Math.min(k * 2 * 4 + 1 + i, this.maxLineCount);
      Log.d("drawTickMark", "scrollX:" + j + " +lines:" + j / this.tickMarkStep);
      Log.d("drawTickMark", "i:" + i + " lineCount:" + k + " maxLineCount:" + this.maxLineCount);
      if (i < k) {
        break;
      }
      paramCanvas.restore();
      return;
    }
    int m = this.tickMarkStep * i + j;
    float f;
    if (i % this.mDevideCount == 0) {
      if (i / this.mDevideCount % 2 == 0)
      {
        f = 1.0F;
        paramCanvas.drawText(getDataByOffset(m - j)[0], m, this.h - this.mLineLength * 1.1F, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.drawLine(m, this.h, m, this.h - this.mLineLength * f, this.paint);
      Log.d("drawTickMark", "line(" + m + "," + this.h + ")-(" + m + "," + (this.h - this.mLineLength * f) + ")");
      i += 1;
      break;
      f = 0.6F;
      continue;
      f = 0.4F;
    }
  }
  
  private void endScorll()
  {
    int j = getScrollX();
    int i = j % this.tickMarkStep;
    if (i > this.tickMarkStep * 0.5F) {}
    for (i = this.tickMarkStep - i;; i = -i)
    {
      scrollTo(getRealScroll(j + i), 0);
      recycleVelocityTracker();
      getParent().requestDisallowInterceptTouchEvent(false);
      return;
    }
  }
  
  private void init()
  {
    this.paint = new Paint(1);
    this.paint.setTextAlign(Paint.Align.CENTER);
    this.paint.setStrokeWidth(this.LINE_WIDTH);
    this.title = getResources().getString(2131296476);
  }
  
  protected int[] getDataByOffset(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = (paramInt / (this.mDevideCount * 2 * this.tickMarkStep) * this.mDataStep + this.mMinData);
    arrayOfInt[1] = (paramInt % (this.mDevideCount * 2 * this.tickMarkStep) / this.tickMarkStep);
    arrayOfInt[1] *= this.tickMarkDataStep;
    return arrayOfInt;
  }
  
  protected int getRealScroll(int paramInt)
  {
    return Math.min((this.mMaxData - this.mMinData) / this.mDataStep * this.mDevideCount * 2 * this.tickMarkStep, Math.max(0, paramInt));
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    drawTickMark(paramCanvas);
    drawShadow(paramCanvas);
    drawLabel(paramCanvas);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.data = getDataByOffset(getRealScroll(getScrollX()));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = (paramInt1 - getPaddingLeft() - getPaddingRight());
    this.h = (paramInt2 - getPaddingBottom() - getPaddingTop());
    Log.d("ywx", "onSizeChanged(" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + ")");
    Log.d("ywx", "pl:" + getPaddingLeft() + " pr:" + getPaddingRight() + " pb:" + getPaddingBottom() + " pt:" + getPaddingTop());
    this.mSpaceSize = ((this.w - (this.mDevideCount * 2 * 4 + 1) * this.LINE_WIDTH) / (this.mDevideCount * 2 * 4 - 1));
    this.mLineLength = (this.h * 0.28F);
    this.defaultOffset = (paramInt1 / 2 - this.LINE_WIDTH / 2);
    this.tickMarkStep = (this.mSpaceSize + this.LINE_WIDTH);
    this.maxLineCount = ((this.mMaxData - this.mMinData) / this.mDataStep * this.mDevideCount * 2 + 1);
    this.textSize = (this.mLineLength * 0.2F);
    this.data = getDataByOffset(getRealScroll(getScrollX()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      removeCallbacks(this.goOnDraw);
      this.drawCount = 1;
      initOrResetVelocityTracker();
      this.velocityTracker.addMovement(paramMotionEvent);
      this.start = paramMotionEvent.getRawX();
      this.pre = this.start;
      return true;
    case 2: 
      this.velocityTracker.addMovement(paramMotionEvent);
      if (Math.abs(this.start - paramMotionEvent.getRawX()) > 100.0F) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      scrollBy((int)(this.pre - paramMotionEvent.getRawX()), 0);
      this.pre = paramMotionEvent.getRawX();
      return true;
    case 1: 
      this.velocityTracker.addMovement(paramMotionEvent);
      this.velocityTracker.computeCurrentVelocity(1000, ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity());
      this.mVelocity = ((int)this.velocityTracker.getXVelocity());
      postDelayed(this.goOnDraw, 50L);
      return true;
    }
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\HorizonRulerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */