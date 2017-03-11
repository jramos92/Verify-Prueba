package com.veryfit.multi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PointLineView
  extends HorzionScroll
{
  private final int VISIBLE_COUNT = 7;
  private float bigRadius;
  private int color = -1092544;
  private LinkedList<Integer> datas;
  private int h;
  private int lineWidth = 3;
  private onDateScrolling linstener;
  private Paint paint;
  private float pointDis;
  private int pointIndex;
  private float radius;
  private int selectIndex;
  private int w;
  private float yAxisLength;
  private float yScale;
  private float yZero;
  
  public PointLineView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PointLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public PointLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawCenter(Canvas paramCanvas)
  {
    this.paint.setStyle(Paint.Style.FILL);
    float f3 = this.w / 2 + getScrollX();
    float f4 = ((Integer)this.datas.get(this.selectIndex)).intValue();
    float f2 = this.yZero - this.yScale * f4;
    float f1 = f2;
    if (this.selectIndex < this.datas.size() - 1) {
      f1 = f2 - (f4 - ((Integer)this.datas.get(this.selectIndex + 1)).intValue()) * this.yScale / -this.pointDis * (getRealScroll(-getScrollX()) % this.pointDis);
    }
    paramCanvas.drawCircle(f3, f1, this.radius, this.paint);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(f3, f1, this.bigRadius, this.paint);
    this.paint.setAlpha(125);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setTextAlign(Paint.Align.CENTER);
    f1 = this.bigRadius;
    f2 = this.yZero;
    f4 = this.yAxisLength;
    float f5 = this.bigRadius;
    float f6 = this.bigRadius;
    float f7 = this.yZero;
    paramCanvas.drawRect(f3 - f1, f2 - f4 - f5, f3 + f6, this.bigRadius + f7, this.paint);
  }
  
  private void drawPoints(Canvas paramCanvas)
  {
    this.paint.setAlpha(255);
    this.paint.setStyle(Paint.Style.STROKE);
    ArrayList localArrayList = getVisiblePoints();
    int i = 0;
    if (i >= localArrayList.size()) {
      return;
    }
    paramCanvas.save();
    float f1 = this.yZero;
    float f2 = ((Integer)this.datas.get(this.pointIndex + i)).intValue();
    float f3 = this.yScale;
    paramCanvas.translate(this.w / 2 - this.pointDis * (this.pointIndex + i), f1 - f2 * f3);
    paramCanvas.drawCircle(0.0F, 0.0F, this.radius, this.paint);
    if (this.pointIndex + i < this.datas.size() - 1)
    {
      f1 = (((Integer)this.datas.get(this.pointIndex + i)).intValue() - ((Integer)this.datas.get(this.pointIndex + i + 1)).intValue()) * this.yScale;
      paramCanvas.rotate((float)(57.29577951308232D * Math.atan2(f1, -this.pointDis)));
      f1 = (float)Math.sqrt(f1 * f1 + this.pointDis * this.pointDis);
      if (getScrollX() % this.pointDis != 0.0F) {
        break label355;
      }
      if (this.selectIndex != this.pointIndex + i) {
        break label293;
      }
      paramCanvas.drawLine(this.bigRadius, 0.0F, f1 - this.radius, 0.0F, this.paint);
    }
    for (;;)
    {
      paramCanvas.restore();
      i += 1;
      break;
      label293:
      if (this.selectIndex - 1 == this.pointIndex + i)
      {
        paramCanvas.drawLine(this.radius, 0.0F, f1 - this.bigRadius, 0.0F, this.paint);
      }
      else
      {
        paramCanvas.drawLine(this.radius, 0.0F, f1 - this.radius, 0.0F, this.paint);
        continue;
        label355:
        paramCanvas.drawLine(this.radius, 0.0F, f1 - this.radius, 0.0F, this.paint);
      }
    }
  }
  
  private ArrayList<Integer> getVisiblePoints()
  {
    ArrayList localArrayList = new ArrayList();
    this.pointIndex = ((int)((-getScrollX() - this.w / 2) / this.pointDis));
    this.pointIndex = Math.max(0, Math.min(this.pointIndex, this.datas.size()));
    int j = Math.min(this.pointIndex + 7 + 2, this.datas.size());
    int i = this.pointIndex;
    for (;;)
    {
      if (i >= j) {
        return localArrayList;
      }
      localArrayList.add((Integer)this.datas.get(i));
      i += 1;
    }
  }
  
  private void init()
  {
    this.paint = new Paint(1);
    this.paint.setColor(this.color);
    this.paint.setStyle(Paint.Style.STROKE);
    setWillNotDraw(false);
  }
  
  private void setYscale()
  {
    float f = 0.1F;
    int i = 0;
    for (;;)
    {
      if (i >= this.datas.size())
      {
        this.yScale = (this.yAxisLength / f);
        return;
      }
      f = Math.max(f, ((Integer)this.datas.get(i)).intValue());
      i += 1;
    }
  }
  
  protected void endScorll()
  {
    super.endScorll();
    if (getRealScroll(-getScrollX()) % (int)this.pointDis > this.pointDis * 0.5F) {}
    for (int i = this.selectIndex + 1;; i = this.selectIndex)
    {
      scrollTo((int)(-i * this.pointDis), 0);
      return;
    }
  }
  
  protected int getRealScroll(int paramInt)
  {
    return Math.min((int)((this.datas.size() - 1) * this.pointDis), Math.max(0, paramInt));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.linstener != null) {
      this.linstener.onScrolling(this.selectIndex);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.paint.setStrokeWidth(1.0F);
    paramCanvas.drawLine(getScrollX(), this.yZero - this.yAxisLength - this.bigRadius, this.w + getScrollX(), this.yZero - this.yAxisLength - this.bigRadius, this.paint);
    float f1 = getScrollX();
    float f2 = this.yZero;
    float f3 = this.bigRadius;
    float f4 = this.w + getScrollX();
    float f5 = this.yZero;
    paramCanvas.drawLine(f1, f3 + f2, f4, this.bigRadius + f5, this.paint);
    this.paint.setStrokeWidth(this.lineWidth);
    drawPoints(paramCanvas);
    drawCenter(paramCanvas);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.selectIndex = (getRealScroll(-paramInt1) / (int)this.pointDis);
    if (this.linstener != null) {
      this.linstener.onScrolling(this.selectIndex);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    this.h = paramInt2;
    this.pointDis = (paramInt1 / 7);
    this.radius = (this.pointDis / 5.0F);
    this.bigRadius = (this.radius * 1.3F);
    this.yZero = (paramInt2 - 1 - this.bigRadius);
    this.yAxisLength = (this.yZero - 1.0F - this.bigRadius);
    setYscale();
    if (this.selectIndex != 0) {
      scrollTo((int)(-this.selectIndex * this.pointDis), 0);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.selectIndex = paramInt;
    scrollTo((int)(-paramInt * this.pointDis), 0);
    if (this.linstener != null) {
      this.linstener.onScrolling(this.selectIndex);
    }
  }
  
  public void setDatas(List<Integer> paramList)
  {
    this.datas = ((LinkedList)paramList);
    setYscale();
    invalidate();
  }
  
  public void setDateScrollingLinstener(onDateScrolling paramonDateScrolling)
  {
    this.linstener = paramonDateScrolling;
  }
  
  public void setGraphColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public static abstract interface onDateScrolling
  {
    public abstract void onScrolling(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\PointLineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */