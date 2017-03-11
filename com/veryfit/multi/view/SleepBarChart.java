package com.veryfit.multi.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.util.ViewUtil;
import com.veryfit.multi.vo.SleepData;
import com.veryfit.multi.vo.SleepItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SleepBarChart
  extends View
{
  private boolean anim = true;
  private ArrayList<Bar> bars = new ArrayList();
  private int[] colors = { -1, -1996488705, -16776961 };
  private List<SleepItem> datas;
  private int endTime;
  private int h;
  private boolean is24 = AppSharedPreferences.getInstance().is24TimeMode();
  private Paint paint;
  private float progress = 1.0F;
  private float scale;
  private int startTime;
  private int textColor = -1;
  private String tittle;
  private float tittleBottom;
  private float tittleTextSize;
  private Drawable topDrawable;
  private int total_mins;
  private int w;
  private float xAxisLength;
  private float xLabelTextSize = 26.0F;
  private float xZero;
  private float yZero;
  
  public SleepBarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SleepBarChart);
    paramAttributeSet = getResources();
    this.colors[0] = paramContext.getColor(2, paramAttributeSet.getColor(2131099663));
    this.colors[1] = paramContext.getColor(1, paramAttributeSet.getColor(2131099664));
    this.colors[2] = paramContext.getColor(3, paramAttributeSet.getColor(2131099665));
    this.textColor = paramContext.getColor(0, paramAttributeSet.getColor(2131099649));
    this.tittleTextSize = paramContext.getDimension(4, 32.0F);
    this.xLabelTextSize = paramContext.getDimension(4, 26.0F);
    paramContext.recycle();
    this.topDrawable = paramAttributeSet.getDrawable(2130837698);
    this.paint = new Paint(1);
    this.paint.setTextAlign(Paint.Align.CENTER);
  }
  
  private void drawBars(Canvas paramCanvas)
  {
    float f1 = this.xZero;
    float f2 = this.tittleBottom;
    Iterator localIterator = this.bars.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Bar localBar = (Bar)localIterator.next();
      this.paint.setColor(localBar.color);
      paramCanvas.drawRect(f1, f2 + 20.0F, f1 + localBar.width, this.yZero, this.paint);
      f1 += localBar.width;
    }
  }
  
  private void drawNoData(Canvas paramCanvas)
  {
    float f2 = this.xAxisLength / 8.0F;
    float f1 = this.xZero;
    float f3 = this.tittleBottom + 20.0F;
    this.paint.setAlpha(50);
    int i = 0;
    for (;;)
    {
      if (i >= 9)
      {
        this.paint.setAlpha(255);
        this.paint.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(getContext().getString(2131296401), this.w / 2, (this.h - f3) / 2.0F + f3, this.paint);
        return;
      }
      paramCanvas.drawLine(f1, this.yZero, f1, f3, this.paint);
      f1 += f2;
      i += 1;
    }
  }
  
  private void drawText(Canvas paramCanvas)
  {
    this.paint.setColor(this.textColor);
    this.paint.setTextSize(this.xLabelTextSize);
    float f2 = this.h - getPaddingBottom() + (this.paint.ascent() + this.paint.descent()) / 2.0F;
    paramCanvas.drawText(Util.timeFormatter(this.startTime, this.is24), this.xZero, f2, this.paint);
    paramCanvas.drawText(Util.timeFormatter(this.endTime, this.is24), this.xZero + this.xAxisLength, f2, this.paint);
    float f3 = ViewUtil.getTextRectWidth(this.paint, Util.timeFormatter(this.startTime, this.is24));
    float f1 = this.xZero;
    int k = (this.total_mins / 60 / 10 + 1) * 60;
    int i = this.startTime - this.startTime % k + k;
    if ((i - this.startTime) * this.scale > f3 / 2.0F + 20.0F) {}
    for (;;)
    {
      Log.d("View", "step = " + k + "***point = " + i);
      f1 += (i - this.startTime) * this.scale;
      if (f1 < this.xZero + this.xAxisLength - f3 / 2.0F - 20.0F) {
        break;
      }
      return;
      i += k;
    }
    if (i >= 1440) {}
    for (int j = 1440;; j = 0)
    {
      i -= j;
      DebugLog.i("point = " + i);
      paramCanvas.drawText(Util.getHourAndMin(i, this.is24)[0], f1, f2, this.paint);
      i += k;
      f1 += k * this.scale;
      break;
    }
  }
  
  private void drawTittle(Canvas paramCanvas)
  {
    this.paint.setTextSize(this.tittleTextSize);
    this.paint.setColor(this.textColor);
    paramCanvas.drawText(this.tittle, this.w / 2, this.tittleBottom + (this.paint.ascent() + this.paint.descent()) / 2.0F, this.paint);
    this.topDrawable.draw(paramCanvas);
  }
  
  private void initBars()
  {
    this.scale = (this.xAxisLength / this.total_mins);
    this.bars.clear();
    Iterator localIterator = this.datas.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Bar localBar = new Bar((SleepItem)localIterator.next());
      this.bars.add(localBar);
    }
  }
  
  public int[] getBarColors()
  {
    return this.colors;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if (this.anim) {
      paramCanvas.clipRect(this.w / 2 * (1.0F - this.progress), 0.0F, this.w / 2 * (this.progress + 1.0F), this.h);
    }
    drawTittle(paramCanvas);
    if ((this.bars.size() == 0) || (this.total_mins == 0)) {
      drawNoData(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      drawBars(paramCanvas);
      drawText(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = paramInt2;
    this.w = paramInt1;
    this.paint.setTextSize(this.xLabelTextSize);
    float f = ViewUtil.getTextRectWidth(this.paint, Util.timeFormatter(this.startTime, this.is24));
    this.xZero = (getPaddingLeft() + f / 2.0F);
    this.xAxisLength = (paramInt1 - getPaddingRight() - f / 2.0F - this.xZero);
    f = ViewUtil.getTextHeight(this.paint);
    this.yZero = (paramInt2 - getPaddingBottom() - f - 5);
    this.topDrawable.setBounds(paramInt1 / 2 - this.topDrawable.getIntrinsicWidth() / 2, getPaddingTop(), paramInt1 / 2 + this.topDrawable.getIntrinsicWidth() / 2, this.topDrawable.getIntrinsicHeight() + getPaddingTop());
    this.paint.setTextSize(this.tittleTextSize);
    this.tittleBottom = (this.topDrawable.getBounds().bottom + ViewUtil.getTextHeight(this.paint) + 20.0F);
    initBars();
  }
  
  public void setData(SleepData paramSleepData)
  {
    this.startTime = paramSleepData.getStartTimeMins();
    this.endTime = paramSleepData.getEndTimeMins();
    this.total_mins = paramSleepData.getDurationMins();
    this.tittle = (paramSleepData.getDuration()[0] + getResources().getString(2131296414) + paramSleepData.getDuration()[1] + getResources().getString(2131296415));
    this.datas = paramSleepData.getItems();
    initBars();
    invalidate();
  }
  
  public void setProgress(float paramFloat)
  {
    this.progress = paramFloat;
    invalidate();
  }
  
  public void startCloseAnim(Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "progress", new float[] { 1.0F, 0.0F }).setDuration(800L);
    if (paramAnimatorListener != null) {
      localObjectAnimator.addListener(paramAnimatorListener);
    }
    localObjectAnimator.start();
    this.anim = true;
  }
  
  public void startOpenAnim(Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "progress", new float[] { 0.0F, 1.0F }).setDuration(800L);
    localObjectAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        SleepBarChart.this.anim = false;
        SleepBarChart.this.invalidate();
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SleepBarChart.this.anim = false;
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    if (paramAnimatorListener != null) {
      localObjectAnimator.addListener(paramAnimatorListener);
    }
    localObjectAnimator.start();
    this.anim = true;
  }
  
  private class Bar
  {
    public int color;
    public float width;
    
    public Bar(SleepItem paramSleepItem)
    {
      int j = 0;
      int i = j;
      if (paramSleepItem.state > 0)
      {
        i = j;
        if (paramSleepItem.state < SleepBarChart.this.colors.length) {
          i = paramSleepItem.state;
        }
      }
      this.color = SleepBarChart.this.colors[i];
      this.width = (SleepBarChart.this.scale * paramSleepItem.time);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\SleepBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */