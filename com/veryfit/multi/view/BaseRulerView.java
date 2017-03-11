package com.veryfit.multi.view;

import android.content.Context;
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
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.project.library.util.DebugLog;
import com.veryfit.multi.util.ViewUtil;
import java.util.Arrays;

public class BaseRulerView
  extends HorizonRulerView
{
  private int defaultRulerData;
  private int defaultRulerScrollX;
  private Runnable goOnDraw = new Runnable()
  {
    private int MAX_REDRAW_COUNT = 10;
    
    public void run()
    {
      if ((BaseRulerView.this.drawCount < this.MAX_REDRAW_COUNT) && (Math.abs(BaseRulerView.this.mVelocity) > 5000))
      {
        int i = (int)(BaseRulerView.this.mVelocity * 0.05D / this.MAX_REDRAW_COUNT * (this.MAX_REDRAW_COUNT - BaseRulerView.this.drawCount + 0.5D));
        BaseRulerView.this.scrollBy(0, -i);
        BaseRulerView localBaseRulerView = BaseRulerView.this;
        localBaseRulerView.drawCount += 1;
        BaseRulerView.this.postDelayed(BaseRulerView.this.goOnDraw, 200 / this.MAX_REDRAW_COUNT);
        return;
      }
      BaseRulerView.this.endScorll();
    }
  };
  private boolean isCalculateFinish = false;
  
  public BaseRulerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public BaseRulerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BaseRulerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawLabel(Canvas paramCanvas)
  {
    this.paint.setColor(this.mLightColor);
    this.paint.setTextAlign(Paint.Align.CENTER);
    int i = this.defaultOffset + getScrollY();
    float f1 = this.w - this.mLineLength * 1.8F;
    paramCanvas.drawLine(f1, i, this.w, i, this.paint);
    float f2 = this.mLineLength * 0.1F;
    Path localPath = new Path();
    localPath.moveTo(f1, i + f2);
    localPath.lineTo(f1 - 1.8F * f2, i);
    localPath.lineTo(f1, i - f2);
    localPath.close();
    paramCanvas.drawPath(localPath, this.paint);
    float f3 = f1 - this.mLineLength * 0.3F;
    float f4 = this.textSize * 1.8F;
    f1 = this.textSize * 1.3F;
    f2 = this.mLineLength * 0.1F;
    if (this.mUnits.length == 1)
    {
      this.paint.setTextSize(f1);
      f5 = ViewUtil.getTextRectWidth(this.paint, this.title);
      f6 = ViewUtil.getTextRectWidth(this.paint, this.mUnits[0]);
      this.paint.setTextSize(f4);
      f3 -= Math.max(f6, Math.max(f5, ViewUtil.getTextRectWidth(this.paint, this.data[0] + this.data[1]))) / 2.0F;
      i = (int)(i - (this.paint.ascent() + this.paint.descent()) / 2.0F);
      paramCanvas.drawText(this.data[0] + this.data[1], f3, i, this.paint);
      f4 = ViewUtil.getTextHeight(this.paint);
      this.paint.setTextSize(f1);
      paramCanvas.drawText(this.mUnits[0], f3, i + f4 / 2.0F + f2, this.paint);
      paramCanvas.drawText(this.title, f3, i - f4 / 2.0F - f2 + (this.paint.ascent() + this.paint.descent()), this.paint);
    }
    while (this.mUnits.length != 2) {
      return;
    }
    this.paint.setTextSize(f4);
    float f5 = ViewUtil.getTextRectWidth(this.paint, this.data[0]);
    float f6 = ViewUtil.getTextRectWidth(this.paint, this.data[1]);
    this.paint.setTextSize(f1);
    float f7 = ViewUtil.getTextRectWidth(this.paint, this.mUnits[0]);
    float f8 = f5 + f2 + f7 + f2 + f6 + f2 + ViewUtil.getTextRectWidth(this.paint, this.mUnits[1]);
    this.paint.setTextAlign(Paint.Align.LEFT);
    this.paint.setTextSize(f4);
    i = (int)(i - (this.paint.descent() + this.paint.ascent()) / 2.0F);
    paramCanvas.drawText(this.data[0], f3 - f8, i, this.paint);
    paramCanvas.drawText(this.data[1], f3 - f8 + f5 + f2 + f7 + f2, i, this.paint);
    this.paint.setTextSize(f1);
    paramCanvas.drawText(this.mUnits[0], f3 - f8 + f5 + f2, i, this.paint);
    paramCanvas.drawText(this.mUnits[1], f3 - f8 + f5 + f2 + f7 + f2 + f6 + f2, i, this.paint);
    this.paint.setTextAlign(Paint.Align.CENTER);
    this.paint.setTextSize(f4);
    i = (int)(i - ViewUtil.getTextHeight(this.paint));
    this.paint.setTextSize(f1);
    paramCanvas.drawText(this.title, f3 - f8 / 2.0F, i, this.paint);
  }
  
  private void drawShadow(Canvas paramCanvas)
  {
    int i = getScrollY();
    this.paint.setShader(new LinearGradient(0.0F, i, 0.0F, getHeight() / 3 + i, this.mShadowColor, 0, Shader.TileMode.CLAMP));
    paramCanvas.drawRect(0.0F, i, getWidth(), getHeight() / 3 + i, this.paint);
    this.paint.setShader(new LinearGradient(0.0F, getHeight() / 3 * 2 + i, 0.0F, getHeight() + i, 0, this.mShadowColor, Shader.TileMode.CLAMP));
    paramCanvas.drawRect(0.0F, getHeight() / 3 * 2 + i, getWidth(), getHeight() + i, this.paint);
    this.paint.setShader(null);
  }
  
  private void drawTickMark(Canvas paramCanvas)
  {
    int m = this.mDevideCount;
    int k = getScrollY();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.defaultOffset - k);
    this.paint.setColor(this.mRulerColor);
    this.paint.setTextSize(this.textSize);
    this.paint.setTextAlign(Paint.Align.RIGHT);
    float f2 = -(this.paint.ascent() + this.paint.descent()) / 2.0F;
    int i;
    if (-k < this.defaultOffset)
    {
      i = 0;
      if (this.mUnits.length != 1) {
        break label161;
      }
    }
    label161:
    for (int j = 0;; j = 2)
    {
      m = Math.min(m * 2 * 4 + 1 + i, this.maxLineCount);
      if (i < m + j) {
        break label167;
      }
      paramCanvas.restore();
      return;
      i = (-k - this.defaultOffset) / this.tickMarkStep + 2;
      break;
    }
    label167:
    int n = -i * this.tickMarkStep + k;
    float f1;
    if (i % this.mDevideCount == 0) {
      if (i / this.mDevideCount % 2 == 0)
      {
        f1 = 1.0F;
        paramCanvas.drawText(getDataByOffset(-n + k)[0], this.w - this.mLineLength * 1.1F, n + f2, this.paint);
      }
    }
    for (;;)
    {
      paramCanvas.drawLine(this.w, n, this.w - this.mLineLength * f1, n, this.paint);
      i += 1;
      break;
      f1 = 0.6F;
      continue;
      f1 = 0.4F;
    }
  }
  
  private void endScorll()
  {
    int j = getScrollY();
    int i = Math.abs(j % this.tickMarkStep);
    if (i > this.tickMarkStep * 0.5F) {}
    for (i = this.tickMarkStep - i;; i = -i)
    {
      scrollTo(0, getRealScroll(j - i));
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
  }
  
  public void calulateData()
  {
    this.mSpaceSize = ((this.h - (this.mDevideCount * 2 * 4 + 1) * this.LINE_WIDTH) / (this.mDevideCount * 2 * 4 - 1));
    this.mLineLength = (this.w * 0.25F);
    this.defaultOffset = (this.h / 2 - this.LINE_WIDTH / 2);
    this.tickMarkStep = (this.mSpaceSize + this.LINE_WIDTH);
    this.maxLineCount = ((this.mMaxData - this.mMinData) / this.mDataStep * this.mDevideCount * 2 + 1);
    this.textSize = (this.mLineLength * 0.15F);
    this.paint.setTextSize(this.textSize);
    this.data = getDataByOffset(-getRealScroll(getScrollY()));
    Log.d("View", "calulateData  data = " + Arrays.toString(this.data));
  }
  
  public int[] getData()
  {
    DebugLog.d("sss" + Arrays.toString(this.data));
    return this.data;
  }
  
  protected int getRealScroll(int paramInt)
  {
    if (this.mUnits.length == 1) {}
    for (int i = 0;; i = 2) {
      return Math.max(-(((this.mMaxData - this.mMinData) / this.mDataStep * this.mDevideCount * 2 + i) * this.tickMarkStep), Math.min(0, paramInt));
    }
  }
  
  public int getUnitSize()
  {
    return this.mUnits.length;
  }
  
  public void initData(String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mUnits = paramArrayOfString;
    this.mMaxData = paramInt1;
    this.mMinData = paramInt2;
    this.mDevideCount = paramInt3;
    this.mDataStep = paramInt4;
    this.tickMarkDataStep = paramInt5;
    calulateData();
    invalidate();
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
    this.data = getDataByOffset(-getRealScroll(getScrollY()));
    Log.d("View", "data = " + Arrays.toString(this.data));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.w = (paramInt1 - getPaddingLeft() - getPaddingRight());
    this.h = (paramInt2 - getPaddingBottom() - getPaddingTop());
    calulateData();
    this.isCalculateFinish = true;
    setData(this.defaultRulerData);
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
      this.start = paramMotionEvent.getRawY();
      this.pre = this.start;
      return true;
    case 2: 
      this.velocityTracker.addMovement(paramMotionEvent);
      if (Math.abs(this.start - paramMotionEvent.getRawY()) > 100.0F) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      scrollBy(0, (int)(this.pre - paramMotionEvent.getRawY()));
      this.pre = paramMotionEvent.getRawY();
      return true;
    case 1: 
      this.velocityTracker.addMovement(paramMotionEvent);
      this.velocityTracker.computeCurrentVelocity(1000, ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity());
      this.mVelocity = ((int)this.velocityTracker.getYVelocity());
      postDelayed(this.goOnDraw, 50L);
      return true;
    }
    endScorll();
    return true;
  }
  
  public void setData(int paramInt)
  {
    this.defaultRulerData = paramInt;
    if (this.isCalculateFinish)
    {
      this.defaultRulerScrollX = (this.tickMarkStep * paramInt);
      scrollTo(0, -this.defaultRulerScrollX);
    }
    postDelayed(this.goOnDraw, 50L);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\BaseRulerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */