package com.veryfit.multi.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.util.ViewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SportBarChart
  extends View
{
  private static final int TITTLE_SPACE = 30;
  final int ANIM2PROGRESS_MAX = 30;
  private ObjectAnimator anim1;
  private int anim1Progress;
  private ObjectAnimator anim2;
  private int anim2Progress;
  private ObjectAnimator anim3;
  private boolean animing1 = true;
  private boolean animing2;
  private boolean animing3;
  private int barColor;
  private Paint barPaint;
  private float barWid;
  private int countPerHour;
  private ArrayList<Integer> datas;
  private boolean initDraw;
  private boolean isDouble;
  private int maxData;
  private int middleIndex;
  private int textColor;
  private int textPadding;
  private Paint textPaint;
  private float textSize;
  private float tittleBaseLineY;
  private String tittleString = "--";
  private Drawable topDrawable;
  private float totalWid;
  private int w;
  private float xOffset;
  private float yAxisLength;
  private float yScale;
  private int[] yVelocitys;
  private float yZero;
  
  public SportBarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SportBarChart);
    this.textSize = paramContext.getDimension(0, 28.0F);
    this.textColor = paramContext.getColor(1, -1);
    this.barColor = paramContext.getColor(2, -1092544);
    this.topDrawable = paramContext.getDrawable(3);
    paramContext.recycle();
    init();
  }
  
  private void calculateX(int paramInt)
  {
    if ((this.datas != null) && (this.datas.size() != 0))
    {
      if (this.xOffset == 0.0F) {
        this.xOffset = ViewUtil.getTextRectWidth(this.textPaint, "24");
      }
      this.totalWid = ((paramInt - getPaddingLeft() - getPaddingRight() - this.xOffset * 2.0F) / this.datas.size());
      this.barWid = (this.totalWid * 0.5F);
    }
  }
  
  private void calculateY(int paramInt)
  {
    float f1 = ViewUtil.getTextHeight(this.textPaint);
    int j = getPaddingTop();
    int i = j;
    if (this.topDrawable != null) {
      i = j + this.topDrawable.getIntrinsicHeight();
    }
    float f2 = i + f1;
    this.tittleBaseLineY = ((this.textPaint.ascent() + this.textPaint.descent()) / 2.0F + f2);
    this.yZero = (paramInt - f1 - this.textPadding - getPaddingBottom() - this.barWid);
    this.yAxisLength = (this.yZero - f2 - 30.0F);
  }
  
  private void drawAnim1(Canvas paramCanvas)
  {
    int j = this.middleIndex;
    int m = this.anim1Progress;
    int i = this.middleIndex;
    int k = this.anim1Progress;
    j = Math.max(0, j - m);
    k = Math.min(i + k, this.datas.size() - 1);
    i = j;
    for (;;)
    {
      if (i > k)
      {
        if ((j == 0) && (k == this.datas.size() - 1))
        {
          this.animing1 = false;
          this.anim1.cancel();
          startAnim2();
        }
        return;
      }
      float f = i * this.totalWid + this.barWid / 2.0F + this.xOffset;
      paramCanvas.drawLine(f, this.barWid, f, 0.0F, this.barPaint);
      i += 1;
    }
  }
  
  private void drawAnim2(Canvas paramCanvas)
  {
    this.barPaint.setStrokeWidth(this.barWid);
    this.barPaint.setColor(this.barColor);
    if (this.yVelocitys == null) {
      initYvelocity();
    }
    int j = 1;
    int m = this.middleIndex;
    int n = this.anim2Progress;
    int i = this.middleIndex;
    int k = this.anim2Progress;
    m = Math.max(0, m - n);
    n = Math.min(i + k, this.datas.size() - 1);
    k = m;
    if (k > n)
    {
      k = 0;
      i = this.datas.size() - 1;
    }
    for (;;)
    {
      if ((k >= m) && (i <= n))
      {
        if ((m == 0) && (n == this.datas.size() - 1))
        {
          if (j == 0) {
            break label400;
          }
          this.anim2Progress = 0;
          this.animing2 = false;
          this.anim2.cancel();
          if ((this.datas != null) && (this.maxData != 0)) {
            break label395;
          }
          invalidate();
        }
        return;
        f1 = Math.min(this.yVelocitys[k] * 0.2F * (this.anim2Progress - Math.abs(k - this.middleIndex)) + this.barWid, this.yZero);
        i = j;
        if (j != 0) {
          if (f1 != this.yZero) {
            break label302;
          }
        }
        label302:
        for (i = 1;; i = 0)
        {
          f2 = k * this.totalWid + this.barWid / 2.0F + this.xOffset;
          paramCanvas.drawLine(f2, f1 - this.barWid, f2, f1, this.barPaint);
          k += 1;
          j = i;
          break;
        }
      }
      float f1 = k * this.totalWid + this.barWid / 2.0F + this.xOffset;
      float f2 = i * this.totalWid + this.barWid / 2.0F + this.xOffset;
      paramCanvas.drawLine(f1, this.barWid, f1, 0.0F, this.barPaint);
      paramCanvas.drawLine(f2, this.barWid, f2, 0.0F, this.barPaint);
      k += 1;
      i -= 1;
    }
    label395:
    startAnim3();
    return;
    label400:
    this.anim2Progress = 100000;
    invalidate();
  }
  
  private void drawBars(Canvas paramCanvas)
  {
    this.barPaint.setColor(this.barColor);
    int i = 0;
    for (;;)
    {
      if (i >= this.datas.size()) {
        return;
      }
      float f = i * this.totalWid + this.barWid / 2.0F + this.xOffset;
      paramCanvas.drawLine(f, this.yZero - ((Integer)this.datas.get(i)).intValue() * this.yScale, f, this.yZero, this.barPaint);
      paramCanvas.drawLine(f, this.yZero, f, this.yZero + this.barWid, this.barPaint);
      i += 1;
    }
  }
  
  private void drawNoData(Canvas paramCanvas)
  {
    float f2 = (this.w - getPaddingLeft() - getPaddingRight() - this.xOffset * 2.0F) / 8.0F;
    float f1 = this.xOffset + getPaddingLeft();
    this.textPaint.setAlpha(50);
    int i = 0;
    for (;;)
    {
      if (i >= 9)
      {
        this.textPaint.setAlpha(255);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(getContext().getString(2131296401), this.w / 2, this.yZero - this.yAxisLength / 2.0F, this.textPaint);
        return;
      }
      paramCanvas.drawLine(f1, this.yZero, f1, this.yZero - this.yAxisLength, this.textPaint);
      f1 += f2;
      i += 1;
    }
  }
  
  private void drawText(Canvas paramCanvas)
  {
    this.textPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(this.tittleString, this.w / 2, this.tittleBaseLineY, this.textPaint);
    if (this.topDrawable != null)
    {
      i = this.topDrawable.getIntrinsicWidth() / 2;
      int j = getPaddingTop();
      int k = this.topDrawable.getIntrinsicHeight();
      this.topDrawable.setBounds(this.w / 2 - i, j, this.w / 2 + i, j + k);
      this.topDrawable.draw(paramCanvas);
    }
    this.textPaint.setTextAlign(Paint.Align.RIGHT);
    float f2 = this.totalWid;
    float f3 = this.countPerHour;
    float f1 = getPaddingLeft() + this.xOffset;
    float f4 = getMeasuredHeight() - getPaddingBottom();
    float f5 = (this.textPaint.ascent() + this.textPaint.descent()) / 2.0F;
    int i = 0;
    for (;;)
    {
      if (i >= 13) {
        return;
      }
      paramCanvas.drawText(i * 2, f1, f4 + f5, this.textPaint);
      f1 += f2 * f3 * 2.0F;
      i += 1;
    }
  }
  
  private void drawYValue(Canvas paramCanvas)
  {
    this.textPaint.setTextAlign(Paint.Align.LEFT);
    paramCanvas.drawText("0", this.xOffset, this.yZero, this.textPaint);
    paramCanvas.drawLine(0.0F, this.yZero, this.w, this.yZero, this.textPaint);
    paramCanvas.drawText(String.format("%.0f", new Object[] { Float.valueOf(this.maxData / 2.0F) }), this.xOffset, this.yZero - this.maxData * this.yScale / 2.0F, this.textPaint);
    paramCanvas.drawLine(0.0F, this.yZero - this.maxData * this.yScale / 2.0F, this.w, this.yZero - this.maxData * this.yScale / 2.0F, this.textPaint);
    paramCanvas.drawText(this.maxData, this.xOffset, this.yZero - this.maxData * this.yScale, this.textPaint);
    paramCanvas.drawLine(0.0F, this.yZero - this.maxData * this.yScale, this.w, this.yZero - this.maxData * this.yScale, this.textPaint);
  }
  
  private void init()
  {
    this.barPaint = new Paint(1);
    this.barPaint.setColor(this.barColor);
    this.textPaint = new Paint(1);
    this.textPaint.setColor(this.textColor);
    this.textPaint.setTextSize(this.textSize);
  }
  
  private void initYscale()
  {
    Iterator localIterator;
    if (this.datas != null)
    {
      this.maxData = 0;
      localIterator = this.datas.iterator();
      if (localIterator.hasNext()) {
        break label47;
      }
      if (this.maxData != 0) {
        break label75;
      }
    }
    label47:
    label75:
    for (float f = this.yAxisLength;; f = this.yAxisLength / this.maxData)
    {
      this.yScale = f;
      return;
      Integer localInteger = (Integer)localIterator.next();
      this.maxData = Math.max(this.maxData, localInteger.intValue());
      break;
    }
  }
  
  private void initYvelocity()
  {
    this.yVelocitys = new int[this.datas.size()];
    Random localRandom = new Random();
    int i = 0;
    for (;;)
    {
      if (i >= this.yVelocitys.length) {
        return;
      }
      while (this.yVelocitys[i] < 6) {
        this.yVelocitys[i] = localRandom.nextInt(15);
      }
      this.yVelocitys[i] = ((int)(this.yZero / this.yVelocitys[i]));
      i += 1;
    }
  }
  
  private void startAnim3()
  {
    DebugLog.d("yScale = " + this.yScale + " ****" + this.yAxisLength + "****" + this.maxData);
    this.anim3 = ObjectAnimator.ofFloat(this, "yScale", new float[] { 0.0F, this.yScale }).setDuration(500L);
    this.anim3.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.initDraw)
    {
      this.initDraw = true;
      startAnim1();
      return;
    }
    if (this.animing1)
    {
      drawAnim1(paramCanvas);
      return;
    }
    if (this.animing2)
    {
      drawAnim2(paramCanvas);
      return;
    }
    if ((this.datas == null) || (this.maxData == 0)) {
      drawNoData(paramCanvas);
    }
    for (;;)
    {
      drawText(paramCanvas);
      return;
      drawBars(paramCanvas);
      drawYValue(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    calculateX(paramInt1);
    calculateY(paramInt2);
    initYscale();
    this.barPaint.setStrokeWidth(this.barWid);
  }
  
  public void setAnim1Progress(int paramInt)
  {
    this.anim1Progress = paramInt;
    invalidate();
  }
  
  public void setAnim2Progress(int paramInt)
  {
    this.anim2Progress = paramInt;
    invalidate();
  }
  
  public void setDatas(ArrayList<Integer> paramArrayList)
  {
    int i = 1;
    this.datas = paramArrayList;
    this.countPerHour = (paramArrayList.size() / 24);
    boolean bool;
    int j;
    if (paramArrayList.size() % 2 == 0)
    {
      bool = true;
      this.isDouble = bool;
      j = paramArrayList.size() / 2;
      if (!this.isDouble) {
        break label77;
      }
    }
    for (;;)
    {
      this.middleIndex = (j - i);
      initYscale();
      this.initDraw = false;
      invalidate();
      return;
      bool = false;
      break;
      label77:
      i = 0;
    }
  }
  
  public void setTittleString(String paramString)
  {
    this.tittleString = paramString;
  }
  
  public void setYScale(float paramFloat)
  {
    this.yScale = paramFloat;
    invalidate();
  }
  
  public void startAnim1()
  {
    this.animing1 = true;
    this.anim1 = ObjectAnimator.ofInt(this, "anim1Progress", new int[] { 0, this.datas.size() / 2 + 1 }).setDuration(500L);
    this.anim1.start();
  }
  
  public void startAnim2()
  {
    this.animing2 = true;
    this.anim2 = ObjectAnimator.ofInt(this, "anim2Progress", new int[] { 1, (int)(this.datas.size() / 2 + 90.0F) }).setDuration(2000L);
    this.anim2.start();
  }
  
  public void startAnimSet()
  {
    setVisibility(0);
    this.initDraw = false;
    invalidate();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\SportBarChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */