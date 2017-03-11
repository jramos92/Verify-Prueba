package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.project.library.database.HeartRate;
import java.util.ArrayList;
import java.util.List;

public class LineChartView
  extends View
{
  private int bgColor = -11447983;
  private int[] colors;
  private int lineChartPaddingRight = 10;
  private int lineChartStartX = 30;
  private int lineChartStartY = 0;
  private List<HeartRate> points;
  private int[] scaleX;
  private int[] scaleY;
  float touchX;
  float touchY;
  float xSpan;
  float ySpan;
  
  public LineChartView(Context paramContext)
  {
    super(paramContext);
    int[] arrayOfInt = new int[5];
    arrayOfInt[1] = 60;
    arrayOfInt[2] = 120;
    arrayOfInt[3] = 180;
    arrayOfInt[4] = 220;
    this.scaleY = arrayOfInt;
    this.colors = new int[] { -12933088, -14834720, -12933088, -293088, -202948, -293088 };
    arrayOfInt = new int[3];
    arrayOfInt[1] = 12;
    arrayOfInt[2] = 24;
    this.scaleX = arrayOfInt;
    this.touchX = -1.0F;
    this.touchY = -1.0F;
    this.points = new ArrayList();
    init(paramContext, null);
  }
  
  public LineChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = new int[5];
    arrayOfInt[1] = 60;
    arrayOfInt[2] = 120;
    arrayOfInt[3] = 180;
    arrayOfInt[4] = 220;
    this.scaleY = arrayOfInt;
    this.colors = new int[] { -12933088, -14834720, -12933088, -293088, -202948, -293088 };
    arrayOfInt = new int[3];
    arrayOfInt[1] = 12;
    arrayOfInt[2] = 24;
    this.scaleX = arrayOfInt;
    this.touchX = -1.0F;
    this.touchY = -1.0F;
    this.points = new ArrayList();
    init(paramContext, paramAttributeSet);
  }
  
  private int dp2px(int paramInt)
  {
    float f = getContext().getResources().getDisplayMetrics().density;
    return (int)(paramInt * f + 0.5F);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet) {}
  
  private float minutToX(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 / 1440 + dp2px(this.lineChartStartX);
  }
  
  private int sp2px(int paramInt)
  {
    float f = getContext().getResources().getDisplayMetrics().scaledDensity;
    return (int)(paramInt * f + 0.5F);
  }
  
  private int xToMinute(float paramFloat, int paramInt)
  {
    return (int)((paramFloat - dp2px(this.lineChartStartX)) * 60.0F * 24.0F / paramInt);
  }
  
  public void SetInfo(List<HeartRate> paramList)
  {
    int i;
    if (paramList.size() != 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramList.size())
      {
        invalidate();
        return;
      }
      if (((HeartRate)paramList.get(i)).getMinute() <= 1440) {
        this.points.add((HeartRate)paramList.get(i));
      }
      i += 1;
    }
  }
  
  public void SetInfo(int[] paramArrayOfInt, List<HeartRate> paramList)
  {
    this.scaleY = paramArrayOfInt;
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size())
      {
        invalidate();
        return;
      }
      if (((HeartRate)paramList.get(i)).getMinute() <= 1440) {
        this.points.add((HeartRate)paramList.get(i));
      }
      i += 1;
    }
  }
  
  public void SetInfo(int[] paramArrayOfInt1, int[] paramArrayOfInt2, List<HeartRate> paramList)
  {
    this.scaleX = paramArrayOfInt1;
    this.scaleY = paramArrayOfInt2;
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size())
      {
        invalidate();
        return;
      }
      if (((HeartRate)paramList.get(i)).getMinute() <= 1440) {
        this.points.add((HeartRate)paramList.get(i));
      }
      i += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    this.lineChartStartY = (getHeight() - dp2px(3));
    int i1 = getWidth() - dp2px(this.lineChartPaddingRight + this.lineChartStartX);
    int i = getHeight();
    int m = dp2px(6);
    localPaint.setColor(this.bgColor);
    localPaint.setTextSize(24.0F);
    paramCanvas.drawRect(dp2px(this.lineChartStartX), dp2px(3), getWidth() - dp2px(this.lineChartPaddingRight), getHeight() - dp2px(3), localPaint);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    localPaint.setColor(-1);
    paramCanvas.drawLine(dp2px(this.lineChartStartX), this.lineChartStartY, dp2px(this.lineChartStartX), 0.0F, localPaint);
    int j = this.scaleX.length;
    int k = this.scaleY.length;
    this.xSpan = (i1 / (j - 1));
    this.ySpan = ((float)((i - m) * 1.0D / (this.scaleY[(k - 1)] - this.scaleY[0])));
    i = 0;
    if (i >= j)
    {
      i = 0;
      if (i < k - 1) {
        break label1013;
      }
      localPaint.setColor(-65536);
      localPaint.setStrokeWidth(4.0F);
      i = 0;
      if (i < this.points.size() - 1) {
        break label1241;
      }
      m = -1;
      if (this.points.size() != 1) {
        break label2080;
      }
      this.touchX = minutToX(((HeartRate)this.points.get(0)).getMinute(), i1);
      this.touchY = ((HeartRate)this.points.get(0)).getRate();
      i = 0;
    }
    for (;;)
    {
      if (this.points.size() >= 1)
      {
        localPaint.setColor(-1);
        localPaint.setStrokeWidth(1.0F);
        paramCanvas.drawLine(this.touchX, this.lineChartStartY, this.touchX, 0.0F, localPaint);
        localPaint = new Paint();
        localPaint.setColor(-1);
        localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        localPaint.setTextSize(24.0F);
        String str1 = (int)this.touchY + getContext().getString(2131296656);
        String str2 = String.format("%02d", new Object[] { Integer.valueOf(((HeartRate)this.points.get(i)).getMinute() / 60) }) + ":" + String.format("%02d", new Object[] { Integer.valueOf(((HeartRate)this.points.get(i)).getMinute() % 60) });
        f4 = localPaint.measureText(str1);
        f3 = localPaint.measureText(str2);
        f1 = this.touchX;
        f1 = dp2px(5);
        f2 = this.touchX + dp2px(5);
        f1 = this.touchX + dp2px(5);
        if (this.touchX + dp2px(10) + f4 > getWidth())
        {
          f2 = this.touchX - dp2px(5) - f4;
          f1 = this.touchX - dp2px(5) - f3;
        }
        if (this.touchX + dp2px(10) + f3 > getWidth())
        {
          f2 = this.touchX - dp2px(5) - f4;
          f1 = this.touchX - dp2px(5) - f3;
        }
        paramCanvas.drawText(str2, f1, this.lineChartStartY - (this.touchY - this.scaleY[0]) * this.ySpan + dp2px(11), localPaint);
        paramCanvas.drawCircle(this.touchX, this.lineChartStartY - (this.touchY - this.scaleY[0]) * this.ySpan, 5.0F, localPaint);
        paramCanvas.drawText(str1, f2, this.lineChartStartY - (this.touchY - this.scaleY[0]) * this.ySpan, localPaint);
      }
      return;
      if (i == 0) {
        paramCanvas.drawText(this.scaleX[i], dp2px(this.lineChartStartX + 6) + this.xSpan * i, this.lineChartStartY - 10, localPaint);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == j - 1) {
          paramCanvas.drawText(this.scaleX[i], dp2px(this.lineChartStartX - 13) + this.xSpan * i, this.lineChartStartY - 10, localPaint);
        } else {
          paramCanvas.drawText(this.scaleX[i], dp2px(this.lineChartStartX) + this.xSpan * i, this.lineChartStartY - 10, localPaint);
        }
      }
      label1013:
      if (i != 0)
      {
        f1 = dp2px(this.lineChartStartX - 25);
        f2 = this.lineChartStartY;
        f3 = this.scaleY[i] - this.scaleY[0];
        f4 = this.ySpan;
        paramCanvas.drawText(this.scaleY[i], f1, f2 - f3 * f4, localPaint);
        f1 = i1 / 40;
        j = 0;
      }
      float f5;
      for (;;)
      {
        if (j > 41)
        {
          i += 1;
          break;
        }
        f2 = dp2px(this.lineChartStartX - 5);
        f3 = j;
        f4 = dp2px(this.lineChartStartX - 5) + dp2px(5);
        f5 = j;
        paramCanvas.drawLine(f2 + f3 * f1, this.lineChartStartY - (this.scaleY[i] - this.scaleY[0]) * this.ySpan, f4 + f5 * f1, this.lineChartStartY - (this.scaleY[i] - this.scaleY[0]) * this.ySpan, localPaint);
        j += 1;
      }
      label1241:
      float f4 = ((HeartRate)this.points.get(i)).getMinute();
      float f3 = ((HeartRate)this.points.get(i + 1)).getMinute();
      float f2 = ((HeartRate)this.points.get(i)).getRate();
      float f1 = ((HeartRate)this.points.get(i + 1)).getRate();
      float f6;
      float f7;
      float f8;
      if (i < this.points.size() - 4)
      {
        f5 = ((HeartRate)this.points.get(i)).getRate();
        f6 = ((HeartRate)this.points.get(i + 1)).getRate();
        f7 = ((HeartRate)this.points.get(i + 2)).getRate();
        f8 = ((HeartRate)this.points.get(i + 3)).getRate();
        float f9 = ((HeartRate)this.points.get(i + 4)).getRate();
        if ((f5 == f6) && (f5 == f7) && (f5 == f8) && (f5 == f9)) {
          j = i + 4;
        }
      }
      do
      {
        i = j + 1;
        break;
        k = 1;
        j = i;
      } while (k >= this.scaleY.length);
      if ((f2 <= this.scaleY[k]) && (f1 >= this.scaleY[k]))
      {
        f7 = this.scaleY[k];
        f5 = (f7 - f2) * (f3 - f4) / (f1 - f2) + f4;
        localPaint.setColor(this.colors[k]);
        paramCanvas.drawLine(dp2px(this.lineChartStartX) + i1 * f4 / 1440.0F, this.lineChartStartY - (f2 - this.scaleY[0]) * this.ySpan, dp2px(this.lineChartStartX) + i1 * f5 / 1440.0F, this.lineChartStartY - (f7 - this.scaleY[0]) * this.ySpan, localPaint);
        f8 = f1;
        f6 = f3;
      }
      for (;;)
      {
        k += 1;
        f4 = f5;
        f3 = f6;
        f2 = f7;
        f1 = f8;
        break;
        if ((f2 > this.scaleY[k]) && (f1 < this.scaleY[k]))
        {
          f8 = this.scaleY[k];
          f6 = (f2 - f8) * (f3 - f4) / (f2 - f1) + f4;
          localPaint.setColor(this.colors[k]);
          paramCanvas.drawLine(dp2px(this.lineChartStartX) + i1 * f3 / 1440.0F, this.lineChartStartY - (f1 - this.scaleY[0]) * this.ySpan, dp2px(this.lineChartStartX) + i1 * f6 / 1440.0F, this.lineChartStartY - (f8 - this.scaleY[0]) * this.ySpan, localPaint);
          f5 = f4;
          f7 = f2;
        }
        else
        {
          f5 = f4;
          f6 = f3;
          f7 = f2;
          f8 = f1;
          if (f2 <= this.scaleY[k])
          {
            f5 = f4;
            f6 = f3;
            f7 = f2;
            f8 = f1;
            if (f1 <= this.scaleY[k])
            {
              f5 = f4;
              f6 = f3;
              f7 = f2;
              f8 = f1;
              if (f2 >= this.scaleY[(k - 1)])
              {
                f5 = f4;
                f6 = f3;
                f7 = f2;
                f8 = f1;
                if (f1 >= this.scaleY[(k - 1)])
                {
                  localPaint.setColor(this.colors[k]);
                  paramCanvas.drawLine(dp2px(this.lineChartStartX) + i1 * f4 / 1440.0F, this.lineChartStartY - (f2 - this.scaleY[0]) * this.ySpan, dp2px(this.lineChartStartX) + i1 * f3 / 1440.0F, this.lineChartStartY - (f1 - this.scaleY[0]) * this.ySpan, localPaint);
                  f5 = f4;
                  f6 = f3;
                  f7 = f2;
                  f8 = f1;
                }
              }
            }
          }
        }
      }
      label2080:
      i = m;
      if (this.points.size() > 1)
      {
        if (this.touchX != -1.0F)
        {
          int n = xToMinute(this.touchX, i1);
          if (n >= 0) {
            if (((HeartRate)this.points.get(0)).getMinute() >= n)
            {
              j = ((HeartRate)this.points.get(0)).getMinute();
              this.touchY = ((HeartRate)this.points.get(0)).getRate();
              i = 0;
            }
          }
          for (;;)
          {
            this.touchX = minutToX(j, i1);
            break;
            if (((HeartRate)this.points.get(this.points.size() - 1)).getMinute() <= n)
            {
              j = ((HeartRate)this.points.get(this.points.size() - 1)).getMinute();
              this.touchY = ((HeartRate)this.points.get(this.points.size() - 1)).getRate();
              i = this.points.size() - 1;
            }
            else
            {
              k = 0;
              for (;;)
              {
                i = m;
                j = n;
                if (k >= this.points.size() - 1) {
                  break;
                }
                if ((((HeartRate)this.points.get(k)).getMinute() <= n) && (((HeartRate)this.points.get(k + 1)).getMinute() >= n))
                {
                  if (Math.abs(((HeartRate)this.points.get(k)).getMinute() - n) < Math.abs(((HeartRate)this.points.get(k + 1)).getMinute() - n))
                  {
                    j = ((HeartRate)this.points.get(k)).getMinute();
                    this.touchY = ((HeartRate)this.points.get(k)).getRate();
                    i = k;
                    break;
                  }
                  j = ((HeartRate)this.points.get(k + 1)).getMinute();
                  this.touchY = ((HeartRate)this.points.get(k + 1)).getRate();
                  i = k + 1;
                  break;
                }
                k += 1;
              }
              j = ((HeartRate)this.points.get(0)).getMinute();
              this.touchY = ((HeartRate)this.points.get(0)).getRate();
              i = 0;
            }
          }
        }
        this.touchX = minutToX(((HeartRate)this.points.get(this.points.size() - 1)).getMinute(), i1);
        this.touchY = ((HeartRate)this.points.get(this.points.size() - 1)).getRate();
        i = this.points.size() - 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.touchX = paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    invalidate();
    return true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\LineChartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */