package com.veryfit.multi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.veryfit.multi.R.styleable;

@SuppressLint({"ClickableViewAccessibility"})
public class RulerView
  extends View
{
  private static final float LINE_SCALE_FOR_HIGHT = 0.25F;
  private static final int LINE_WIDTH = 2;
  private static final float LONG_LINE_SCALE = 1.0F;
  private static final float MEDIUM_LINE_SCALE = 0.7F;
  private static final float SHORT_LINE_SCALE = 0.4F;
  private int centerData;
  private String content;
  private int defaultOffset;
  private int defaultRulerData = 0;
  private int defaultRulerScrollX = 0;
  protected int drawCount;
  private Runnable endDraw = new Runnable()
  {
    private int MAX_REDRAW_COUNT = 8;
    
    public void run()
    {
      if ((RulerView.this.drawCount < this.MAX_REDRAW_COUNT) && (Math.abs(RulerView.this.mVelocity) > 5000))
      {
        int i = (int)(RulerView.this.mVelocity * 0.05D / this.MAX_REDRAW_COUNT * (this.MAX_REDRAW_COUNT - RulerView.this.drawCount + 0.5D));
        RulerView.this.scrollBy(-i, 0);
        RulerView localRulerView = RulerView.this;
        localRulerView.drawCount += 1;
        RulerView.this.postDelayed(RulerView.this.endDraw, RulerView.this.drawCount * 10 + 20);
        return;
      }
      RulerView.this.endScroll();
    }
  };
  private int h;
  private int halfScreenLines;
  private boolean isCalculateFinish = false;
  private float lineScale;
  private OnDataSelectedListener listener;
  private float longLineLength;
  private int mArrowLineColor = 10867784;
  private int mScaleLineColor = -1;
  protected int mVelocity;
  private int maxData = 1000;
  private int maxLineNum;
  private int maxOffset;
  private int maxScreenLineNum;
  private int minData = 0;
  private Paint paint;
  private float pre;
  private int smallStepWidth;
  private int spaceWidth;
  private float startX;
  private int stepData = 10;
  private int stepLineNum;
  private float textSize;
  private String title;
  private String unit = "";
  private String unitBig = "";
  private int vHight;
  private int vWidth;
  private VelocityTracker velocityTracker;
  private int w;
  
  public RulerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RulerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RulerView);
    this.mScaleLineColor = paramContext.getColor(1, -1);
    this.mArrowLineColor = paramContext.getColor(0, 10867784);
    this.maxData = paramContext.getInteger(2, 100);
    this.minData = paramContext.getInteger(3, 0);
    this.stepData = paramContext.getInteger(4, 10);
    this.halfScreenLines = paramContext.getInteger(6, 20);
    this.stepLineNum = paramContext.getInt(5, 5);
    this.unit = paramContext.getString(7);
    this.unitBig = paramContext.getString(8);
    this.title = paramContext.getString(9);
    if ((this.unit == null) || (this.unit.equals(""))) {
      this.unit = "";
    }
    if ((this.unitBig == null) || (this.unitBig.equals(""))) {
      this.unitBig = "";
    }
    if ((this.title == null) || (this.title.equals(""))) {
      this.title = "";
    }
    paramContext.recycle();
    init();
  }
  
  public RulerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawShader(Canvas paramCanvas)
  {
    int i = computeHorizontalScrollOffset();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    float f1 = j / 2 + i;
    float f2 = this.vWidth + i + k / 2 + j;
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new LinearGradient(f1, 0.0F, f2, 0.0F, new int[] { -14211289, -1725487321, 271001383, -1725487321, -14211289 }, new float[] { 0.0F, 0.3F, 0.5F, 0.7F, 1.0F }, (Shader.TileMode)localObject);
    this.paint.setShader((Shader)localObject);
    paramCanvas.drawRect(i, this.vHight - this.longLineLength * 1.5F, getWidth() + i, this.vHight, this.paint);
    this.paint.setShader(null);
  }
  
  private void drawTitle(Canvas paramCanvas)
  {
    int i = getWidth() / 2 - 1 + getScrollX();
    int j = (int)(this.vHight - this.longLineLength * 1.8F);
    this.paint.setColor(this.mArrowLineColor);
    paramCanvas.drawLine(i, this.vHight, i, j, this.paint);
    float f1 = this.longLineLength * 0.08F;
    Object localObject = new Path();
    ((Path)localObject).moveTo(i, j);
    ((Path)localObject).lineTo(i + f1, j);
    ((Path)localObject).lineTo(i, j - 1.5F * f1);
    ((Path)localObject).lineTo(i - f1, j);
    ((Path)localObject).close();
    paramCanvas.drawPath((Path)localObject, this.paint);
    f1 = this.textSize * 1.4F;
    float f2 = this.textSize * 2.2F;
    j = (int)(j - this.longLineLength * 0.4F);
    if ((!this.unit.equals("")) && (!this.unitBig.equals("")))
    {
      int k = this.centerData / this.stepData;
      int m = this.centerData % this.stepData;
      float f3 = this.longLineLength * 0.1F;
      this.content = (k + this.unitBig + m + this.unit);
      this.paint.setTextSize(f2);
      localObject = String.format("%02d", new Object[] { Integer.valueOf(k) });
      String str = String.format("%02d", new Object[] { Integer.valueOf(m) });
      this.paint.setTextSize(f2);
      float f4 = getTextRectWidth(this.paint, (String)localObject);
      float f5 = getTextRectWidth(this.paint, str);
      this.paint.setTextSize(f1);
      float f6 = getTextRectWidth(this.paint, this.unitBig);
      float f7 = (f4 + f3 + f6 + f3 + f5 + f3 + getTextRectWidth(this.paint, this.unit)) / 2.0F;
      this.paint.setTextAlign(Paint.Align.LEFT);
      this.paint.setTextSize(f2);
      paramCanvas.drawText((String)localObject, i - f7, j, this.paint);
      paramCanvas.drawText(str, i - f7 + f4 + f3 + f6 + f3, j, this.paint);
      this.paint.setTextSize(f1);
      paramCanvas.drawText(this.unitBig, i - f7 + f4 + f3, j, this.paint);
      paramCanvas.drawText(this.unit, i - f7 + f4 + f3 + f6 + f3 + f5 + f3, j, this.paint);
      if (!this.title.equals(""))
      {
        this.paint.setTextAlign(Paint.Align.CENTER);
        j = (int)(j - getTextHeight(this.paint) * 1.3F);
        this.paint.setTextSize(f1);
        this.content = this.title;
        paramCanvas.drawText(this.content, i, j, this.paint);
      }
    }
    do
    {
      return;
      if (((!this.unit.equals("")) && (this.unitBig.equals(""))) || ((this.unit.equals("")) && (!this.unitBig.equals(""))))
      {
        if (!this.unit.equals("")) {}
        for (this.content = this.unit;; this.content = this.unitBig)
        {
          this.paint.setTextSize(f1);
          paramCanvas.drawText(this.content, i, j, this.paint);
          j = (int)(j - getTextHeight(this.paint));
          this.paint.setTextSize(f2);
          this.content = this.centerData;
          paramCanvas.drawText(this.content, i, j, this.paint);
          if (this.title.equals("")) {
            break;
          }
          j = (int)(j - getTextHeight(this.paint));
          this.paint.setTextSize(f1);
          this.content = this.title;
          paramCanvas.drawText(this.content, i, j, this.paint);
          return;
        }
      }
      this.paint.setTextSize(f2);
      this.content = this.centerData;
      paramCanvas.drawText(this.content, i, j, this.paint);
    } while (this.title.equals(""));
    j = (int)(j - getTextHeight(this.paint));
    this.paint.setTextSize(f1);
    this.content = this.title;
    paramCanvas.drawText(this.content, i, j, this.paint);
  }
  
  public static float getTextHeight(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return paramPaint.bottom - paramPaint.top;
  }
  
  public static float getTextRectWidth(Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.width();
  }
  
  public void calulateData()
  {
    this.vWidth = (this.w - getPaddingLeft() - getPaddingRight());
    this.vHight = (this.h - getPaddingBottom() - getPaddingTop());
    this.longLineLength = (this.vHight * 0.25F);
    this.maxLineNum = ((this.maxData - this.minData) / this.stepData * (this.stepLineNum * 2) + 1);
    this.maxScreenLineNum = (this.halfScreenLines * 2 + 1);
    this.spaceWidth = ((this.vWidth - this.maxScreenLineNum * 2) / (this.maxScreenLineNum - 1));
    this.smallStepWidth = (this.spaceWidth + 2);
    this.defaultOffset = (this.w / 2 - 1);
    this.maxOffset = ((this.maxLineNum - 1) * this.smallStepWidth);
    this.textSize = (this.longLineLength * 0.2F);
    this.isCalculateFinish = true;
    this.centerData = this.minData;
    setData(this.defaultRulerData);
  }
  
  public void drawLines(Canvas paramCanvas)
  {
    int m = getScrollX();
    if (this.defaultOffset > m) {}
    int k;
    for (int i = 0;; i = (m - this.defaultOffset) / this.smallStepWidth + 1)
    {
      k = Math.max(this.maxScreenLineNum + i, this.maxLineNum);
      int j = k;
      if (k >= this.maxLineNum) {
        j = this.maxLineNum;
      }
      paramCanvas.save();
      k = this.defaultOffset - m;
      paramCanvas.translate(k, 0.0F);
      this.lineScale = 1.0F;
      if (i < j) {
        break;
      }
      paramCanvas.restore();
      return;
    }
    int n = this.smallStepWidth * i + m;
    int i1 = k + this.smallStepWidth * i;
    label157:
    String str;
    if ((i1 < getPaddingLeft()) || (i1 > getWidth() - getPaddingRight()))
    {
      this.paint.setColor(0);
      str = getText(i);
      if (i % this.stepLineNum != 0) {
        break label350;
      }
      if (i % (this.stepLineNum * 2) == 0) {
        break label287;
      }
      this.lineScale = 0.7F;
    }
    for (;;)
    {
      i1 = Integer.valueOf(str).intValue();
      if ((!"lb".equals(this.unit)) || (i1 <= 451)) {
        paramCanvas.drawLine(n, this.vHight, n, this.vHight - this.longLineLength * this.lineScale, this.paint);
      }
      i += 1;
      break;
      this.paint.setColor(this.mScaleLineColor);
      this.paint.setTextSize(this.textSize);
      break label157;
      label287:
      this.lineScale = 1.0F;
      if ((!"lb".equals(this.unit)) || (!String.valueOf(this.maxData).equals(str)))
      {
        paramCanvas.drawText(str, n, this.vHight - this.longLineLength * 1.1F, this.paint);
        continue;
        label350:
        this.lineScale = 0.4F;
      }
    }
  }
  
  public void endScroll()
  {
    int j = getScrollX();
    int i = j % this.smallStepWidth;
    label52:
    int k;
    if (i > this.smallStepWidth * 0.5F)
    {
      i = this.smallStepWidth - i;
      j += i;
      if (!"lb".equals(this.unit)) {
        break label119;
      }
      i = 4;
      k = (this.maxData - this.minData) / this.stepData * this.stepLineNum * 2 * this.smallStepWidth - this.smallStepWidth * i;
      if (j >= 0) {
        break label124;
      }
      i = 0;
    }
    for (;;)
    {
      scrollTo(i, 0);
      releaseVelocityTracker();
      getParent().requestDisallowInterceptTouchEvent(false);
      return;
      i = -i;
      break;
      label119:
      i = 0;
      break label52;
      label124:
      i = j;
      if (j >= k) {
        i = k;
      }
    }
  }
  
  public int getCenterData()
  {
    return this.centerData;
  }
  
  public int getDataByOffsetX(int paramInt)
  {
    return paramInt / this.smallStepWidth * (this.stepData / (this.stepLineNum * 2)) + this.minData;
  }
  
  public int getRealOffset(int paramInt)
  {
    return Math.min(this.maxOffset, Math.max(0, paramInt));
  }
  
  public String getText(int paramInt)
  {
    if ((!this.unitBig.equals("")) && (!this.unit.equals(""))) {
      return (this.stepData / (this.stepLineNum * 2) * paramInt + this.minData) / this.stepData;
    }
    return this.stepData / (this.stepLineNum * 2) * paramInt + this.minData;
  }
  
  public void init()
  {
    this.paint = new Paint(1);
    this.paint.setStrokeWidth(2.0F);
    this.paint.setTextAlign(Paint.Align.CENTER);
  }
  
  public void initData(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.maxData = paramInt1;
    this.minData = paramInt2;
    this.stepData = paramInt3;
    this.stepLineNum = paramInt4;
    this.unit = paramString1;
    this.unitBig = paramString2;
    calulateData();
    invalidate();
  }
  
  public void initOrResetVelocityTracker(MotionEvent paramMotionEvent)
  {
    if (this.velocityTracker == null)
    {
      this.velocityTracker = VelocityTracker.obtain();
      this.velocityTracker.addMovement(paramMotionEvent);
      return;
    }
    this.velocityTracker.clear();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawLines(paramCanvas);
    drawTitle(paramCanvas);
    drawShader(paramCanvas);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.centerData = getDataByOffsetX(getRealOffset(getScrollX()));
    if (this.listener != null) {
      this.listener.OnDataSelected(this.centerData);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("ywx", "onSizeChanged(" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + ")");
    Log.d("ywx", "pLeft:" + getPaddingLeft() + " pRight:" + getPaddingRight() + " pBottom:" + getPaddingBottom() + " pTop:" + getPaddingTop());
    Log.d("ywx", "getWidth:" + getWidth() + " getHeight:" + getHeight());
    this.w = paramInt1;
    this.h = paramInt2;
    calulateData();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      removeCallbacks(this.endDraw);
      initOrResetVelocityTracker(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      this.startX = paramMotionEvent.getRawX();
      this.pre = this.startX;
      this.drawCount = 1;
      return true;
    case 2: 
      this.velocityTracker.addMovement(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      scrollBy((int)(this.pre - paramMotionEvent.getRawX()), 0);
      this.pre = paramMotionEvent.getRawX();
      return true;
    case 1: 
      this.velocityTracker.addMovement(paramMotionEvent);
      this.velocityTracker.computeCurrentVelocity(1000, ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity());
      this.mVelocity = ((int)this.velocityTracker.getXVelocity());
      postDelayed(this.endDraw, 50L);
      return true;
    }
    endScroll();
    return true;
  }
  
  public void releaseVelocityTracker()
  {
    if (this.velocityTracker != null)
    {
      this.velocityTracker.clear();
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
  
  public void setData(int paramInt)
  {
    this.defaultRulerData = paramInt;
    this.centerData = paramInt;
    int i = this.defaultRulerData - this.minData;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    paramInt /= this.stepData / (this.stepLineNum * 2);
    this.defaultRulerScrollX = (this.smallStepWidth * paramInt);
    if (this.isCalculateFinish) {
      scrollTo(this.defaultRulerScrollX, 0);
    }
    postDelayed(this.endDraw, 50L);
    invalidate();
  }
  
  public void setListener(OnDataSelectedListener paramOnDataSelectedListener)
  {
    this.listener = paramOnDataSelectedListener;
  }
  
  public void setOffset(int paramInt)
  {
    this.defaultRulerData = paramInt;
    if (this.isCalculateFinish)
    {
      this.defaultRulerScrollX = (this.smallStepWidth * paramInt);
      scrollTo(this.defaultRulerScrollX, 0);
    }
  }
  
  public static abstract interface OnDataSelectedListener
  {
    public abstract void OnDataSelected(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\RulerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */