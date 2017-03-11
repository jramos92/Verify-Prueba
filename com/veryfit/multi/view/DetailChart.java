package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.NinePatchDrawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.util.ViewUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DetailChart
  extends View
{
  public static final int POPUP_CENTER = 0;
  public static final int POPUP_LEFT = 1;
  public static final int POPUP_RIGHT = -1;
  private Bitmap cup;
  Rect goalRect = new Rect();
  private int gridColor;
  private Paint gridPaint;
  private int h;
  private Rect labelRect;
  private Paint linePaint;
  private int maxValue;
  private int padding;
  private PageData pageData;
  private Path path;
  private float pointDis;
  private int pointRadius;
  private NinePatchDrawable popup;
  private NinePatchDrawable popupLeft;
  private Rect popupPadding;
  private Rect popupRect;
  private NinePatchDrawable popupRight;
  private int selectPointIndex = 5;
  private int textColor;
  private TextPaint textPaint;
  private int textSize;
  private int type;
  private StaticLayout valueLayout;
  private int w = -1;
  private int xOffset;
  private float yOffset;
  private float yScale;
  private float yh;
  private float[] ys = new float[5];
  
  public DetailChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DetailChart);
    this.pointRadius = paramContext.getDimensionPixelSize(6, 8);
    this.xOffset = paramContext.getDimensionPixelSize(3, 40);
    this.textSize = paramContext.getDimensionPixelSize(0, 24);
    this.textColor = paramContext.getColor(1, -1);
    this.gridColor = paramContext.getColor(4, 587202559);
    this.padding = paramContext.getDimensionPixelSize(5, 15);
    float f = paramContext.getDimension(2, 2.0F);
    paramContext.recycle();
    this.cup = BitmapFactory.decodeResource(getResources(), 2130837530);
    this.popupLeft = ((NinePatchDrawable)getResources().getDrawable(2130837656));
    this.popupRight = ((NinePatchDrawable)getResources().getDrawable(2130837661));
    this.popup = ((NinePatchDrawable)getResources().getDrawable(2130837655));
    this.linePaint = new Paint(1);
    this.linePaint.setStrokeWidth(f);
    this.gridPaint = new Paint(1);
    this.gridPaint.setColor(this.gridColor);
    this.textPaint = new TextPaint(1);
    this.textPaint.setTextSize(this.textSize);
    this.textPaint.setColor(this.textColor);
    this.textPaint.setTextAlign(Paint.Align.CENTER);
    this.path = new Path();
    this.labelRect = new Rect();
    this.popupRect = new Rect();
    this.popupPadding = new Rect();
  }
  
  private void calculate()
  {
    initPageData();
    calculateY();
    initYScale();
    updateGradients();
  }
  
  private int calculatePopup()
  {
    this.popup.getPadding(this.popupPadding);
    this.popupRect.top = (-(this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height()));
    this.popupRect.bottom = 0;
    this.popupRect.left = (this.labelRect.left - this.popupPadding.left);
    this.popupRect.right = (this.labelRect.right + this.popupPadding.right);
    if (this.xOffset + this.selectPointIndex * this.pointDis + this.popupRect.right > this.w)
    {
      this.popupRight.getPadding(this.popupPadding);
      this.popupRect.top = (-(this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height()));
      this.popupRect.bottom = 0;
      this.popupRect.left = (-(this.popupPadding.left + this.popupPadding.right + this.labelRect.width()));
      this.popupRect.right = 0;
      return -1;
    }
    if ((Math.abs(this.popupRect.left) > this.xOffset + this.selectPointIndex * this.pointDis) && (this.yh > this.ys[3] - this.pageData.goal * this.yScale * 0.75F) && (this.yh > this.ys[3] - this.pageData.goal * this.yScale))
    {
      this.popupLeft.getPadding(this.popupPadding);
      this.popupRect.top = (-(this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height()));
      this.popupRect.bottom = 0;
      this.popupRect.left = 0;
      this.popupRect.right = (this.popupPadding.left + this.popupPadding.right + this.labelRect.width());
      return 1;
    }
    if ((this.selectPointIndex <= 1) && (this.yh < this.ys[3] - this.pageData.goal * this.yScale * 0.75F) && (this.yh > this.ys[3] - this.pageData.goal * this.yScale))
    {
      this.popupLeft.getPadding(this.popupPadding);
      this.popupRect.top = (this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height());
      this.popupRect.bottom = ((this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height()) * 2);
      this.popupRect.left = 0;
      this.popupRect.right = (this.popupPadding.left + this.popupPadding.right + this.labelRect.width());
      return 1;
    }
    return 0;
  }
  
  private void calculateValueRect(DetailChart.PageData.LineData.PointModel paramPointModel)
  {
    this.textPaint.setTextAlign(Paint.Align.CENTER);
    int i = (int)(ViewUtil.getTextRectWidth(this.textPaint, paramPointModel.getMaxLengthLabel()) * 1.2F);
    this.valueLayout = new StaticLayout(paramPointModel.getPopupStr(), this.textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.2F, 0.0F, false);
    this.labelRect.top = (-this.valueLayout.getHeight());
    this.labelRect.bottom = 0;
    this.labelRect.left = (-i / 2);
    this.labelRect.right = (i / 2);
  }
  
  private void calculateY()
  {
    float f = ViewUtil.getTextHeight(this.textPaint);
    this.yOffset = ((this.textPaint.ascent() + this.textPaint.descent()) / 2.0F);
    this.ys[0] = (getPaddingTop() + f + this.yOffset);
    this.ys[1] = (this.ys[0] + this.padding + f + this.yOffset);
    if (this.pageData != null)
    {
      calculateValueRect(initPointFeature());
      calculatePopup();
    }
    this.ys[2] = (this.ys[1] + this.padding + this.popupRect.height() + 4.5F * this.pointRadius);
    this.ys[3] = (this.h - f - this.padding - getPaddingBottom());
    this.ys[4] = (this.ys[3] + this.padding + f + this.yOffset);
  }
  
  private void drawFoucsPoint(Canvas paramCanvas, float paramFloat1, float paramFloat2, DetailChart.PageData.LineData.PointModel paramPointModel)
  {
    this.linePaint.setColor(this.pageData.lines[0].color);
    this.linePaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(paramFloat1, paramFloat2, this.pointRadius * 2.5F, this.linePaint);
    this.linePaint.setStyle(Paint.Style.FILL);
    calculateValueRect(paramPointModel);
    int n = calculatePopup();
    int m = 0;
    int k = 0;
    Object localObject = this.popup;
    paramPointModel = (DetailChart.PageData.LineData.PointModel)localObject;
    int i = m;
    int j = k;
    float f2;
    float f1;
    switch (n)
    {
    default: 
      j = k;
      i = m;
      paramPointModel = (DetailChart.PageData.LineData.PointModel)localObject;
    case 0: 
      f2 = this.pointRadius * 4.5F;
      localObject = new Rect(this.popupRect);
      ((Rect)localObject).offset((int)paramFloat1, (int)(paramFloat2 - f2));
      f1 = f2;
      if (this.goalRect.intersect((Rect)localObject))
      {
        if ((((Rect)localObject).bottom >= this.goalRect.bottom) && (((Rect)localObject).top >= this.goalRect.top)) {
          f1 = ((Rect)localObject).bottom + f2 - this.goalRect.bottom + this.goalRect.height();
        }
      }
      else
      {
        label247:
        paramCanvas.save();
        if ((!this.pageData.goalString.contains(getResources().getString(2131296411))) || (this.yh >= this.ys[3] - this.pageData.goal * this.yScale * 0.75F) || (this.yh <= this.ys[3] - this.pageData.goal * this.yScale)) {
          break label527;
        }
        paramCanvas.translate(i + paramFloat1, paramFloat2 - f1 - this.popupPadding.bottom - this.labelRect.height() + j);
      }
      break;
    }
    for (;;)
    {
      this.valueLayout.draw(paramCanvas);
      paramCanvas.restore();
      this.popupRect.offset((int)paramFloat1, (int)(paramFloat2 - f1));
      paramPointModel.setBounds(this.popupRect);
      paramPointModel.draw(paramCanvas);
      return;
      i = this.labelRect.width() / 2 * n + this.popupPadding.left;
      j = (this.popupPadding.bottom + this.popupPadding.top + this.labelRect.height()) * 2;
      paramPointModel = this.popupLeft;
      break;
      i = this.labelRect.width() / 2 * n - this.popupPadding.right;
      paramPointModel = this.popupRight;
      j = k;
      break;
      f1 = ((Rect)localObject).bottom + f2 - this.goalRect.top;
      break label247;
      label527:
      paramCanvas.translate(i + paramFloat1, paramFloat2 - f1 - this.popupPadding.bottom - this.labelRect.height());
    }
  }
  
  private void drawGoal(Canvas paramCanvas)
  {
    float f1 = this.padding;
    float f2 = this.ys[3] - this.pageData.goal * this.yScale;
    this.textPaint.setPathEffect(new DashPathEffect(new float[] { 5.0F, 5.0F, 5.0F, 5.0F }, 1.0F));
    this.textPaint.setStyle(Paint.Style.STROKE);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.xOffset, f2);
    ((Path)localObject).rLineTo(this.w - this.xOffset * 2, 0.0F);
    paramCanvas.drawPath((Path)localObject, this.textPaint);
    this.textPaint.setPathEffect(null);
    this.textPaint.setStyle(Paint.Style.FILL);
    f2 -= this.cup.getHeight() + this.padding;
    paramCanvas.drawBitmap(this.cup, f1, f2, null);
    this.textPaint.setTextAlign(Paint.Align.LEFT);
    f1 += this.cup.getWidth() + this.padding;
    f2 += this.cup.getHeight() / 2 - (this.textPaint.ascent() + this.textPaint.descent()) / 2.0F;
    localObject = new Rect();
    this.textPaint.getTextBounds(this.pageData.goalString, 0, this.pageData.goalString.length(), (Rect)localObject);
    this.goalRect.set((int)f1, (int)(f2 - ((Rect)localObject).height()), (int)(((Rect)localObject).width() + f1), (int)f2);
    paramCanvas.drawText(this.pageData.goalString, f1, f2, this.textPaint);
  }
  
  private void drawLines(Canvas paramCanvas)
  {
    float f7 = (this.textPaint.ascent() + this.textPaint.descent()) / 2.0F;
    float f4 = this.w - this.padding;
    float f8 = this.pointRadius;
    float f2 = 0.0F;
    float f3 = 0.0F;
    Object localObject1 = null;
    int i = 0;
    DetailChart.PageData.LineData localLineData;
    int j;
    for (;;)
    {
      if (i >= this.pageData.lines.length)
      {
        if (this.type != 2) {
          drawGoal(paramCanvas);
        }
        DebugLog.d("type = " + this.type);
        drawFoucsPoint(paramCanvas, f2, f3, (DetailChart.PageData.LineData.PointModel)localObject1);
        return;
      }
      localLineData = this.pageData.lines[i];
      this.linePaint.setColor(localLineData.color);
      this.linePaint.setStyle(Paint.Style.FILL);
      float f1 = f4;
      if (this.pageData.lines.length > 1)
      {
        this.textPaint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(localLineData.name, f4, this.ys[1], this.textPaint);
        f1 = f4 - (this.pointRadius + f8 + ViewUtil.getTextRectWidth(this.textPaint, localLineData.name));
        paramCanvas.drawCircle(f1, this.ys[1] + f7, this.pointRadius, this.linePaint);
        f1 -= this.pointRadius + 2.0F * f8;
      }
      int k = localLineData.datas.size();
      this.path.reset();
      j = 0;
      f4 = f2;
      if (j < k) {
        break;
      }
      this.linePaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.path, this.linePaint);
      this.path.lineTo(this.w - this.xOffset, this.ys[3]);
      this.path.lineTo(this.xOffset, this.ys[3]);
      this.linePaint.setAlpha(100);
      this.linePaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.linePaint.setShader(localLineData.gradient);
      paramCanvas.drawPath(this.path, this.linePaint);
      this.linePaint.setShader(null);
      this.linePaint.setAlpha(255);
      i += 1;
      f2 = f4;
      f4 = f1;
    }
    DetailChart.PageData.LineData.PointModel localPointModel = (DetailChart.PageData.LineData.PointModel)localLineData.datas.get(j);
    float f6 = this.xOffset + j * localLineData.width;
    this.yh = (this.ys[3] - localPointModel.data * this.yScale);
    if (j == 0) {
      this.path.moveTo(f6, this.yh);
    }
    for (;;)
    {
      paramCanvas.drawCircle(f6, this.yh, this.pointRadius, this.linePaint);
      paramCanvas.drawLine(f6, this.ys[2], f6, this.ys[3], this.gridPaint);
      Object localObject2 = localObject1;
      float f5 = f4;
      f2 = f3;
      if (i == 0)
      {
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        paramCanvas.drawText(localPointModel.dataName, f6, this.ys[4], this.textPaint);
        localObject2 = localObject1;
        f5 = f4;
        f2 = f3;
        if (this.selectPointIndex == j)
        {
          f5 = f6;
          f2 = this.yh;
          localObject2 = localPointModel;
        }
      }
      j += 1;
      localObject1 = localObject2;
      f4 = f5;
      f3 = f2;
      break;
      this.path.lineTo(f6, this.yh);
    }
  }
  
  private void drawPageData(Canvas paramCanvas)
  {
    this.textPaint.setTextAlign(Paint.Align.CENTER);
    paramCanvas.drawText(this.pageData.tittle, this.w / 2, this.ys[0], this.textPaint);
    drawLines(paramCanvas);
  }
  
  private void initPageData()
  {
    if (this.pageData != null)
    {
      this.pageData.initData(this.w - this.xOffset * 2);
      this.pointDis = this.pageData.lines[0].width;
      initPointFeature();
    }
  }
  
  private DetailChart.PageData.LineData.PointModel initPointFeature()
  {
    int[][] arrayOfInt = this.pageData.getMaxDataIndexOfLine();
    DetailChart.PageData.LineData.PointModel localPointModel = (DetailChart.PageData.LineData.PointModel)this.pageData.lines[arrayOfInt[0][0]].datas.get(arrayOfInt[0][1]);
    this.selectPointIndex = arrayOfInt[0][1];
    this.maxValue = localPointModel.data;
    return localPointModel;
  }
  
  private void initYScale()
  {
    if (this.type == 2) {}
    for (float f1 = 0.0F;; f1 = this.pageData.goal * 1.2F)
    {
      float f2 = f1;
      if (this.pageData != null) {
        f2 = Math.max(f1, this.maxValue);
      }
      Log.e("View", "maxValue = " + f2);
      this.yScale = ((this.ys[3] - this.ys[2]) / f2);
      return;
    }
  }
  
  private void selectPoint(float paramFloat)
  {
    int i = (int)(paramFloat - this.xOffset - this.pointDis / 2.0F);
    if (i < 0) {}
    for (i = 0;; i = i / (int)this.pointDis + 1)
    {
      this.selectPointIndex = i;
      this.selectPointIndex = Math.min(this.selectPointIndex, this.pageData.lines[0].datas.size() - 1);
      calculateValueRect((DetailChart.PageData.LineData.PointModel)this.pageData.lines[0].datas.get(this.selectPointIndex));
      calculatePopup();
      invalidate();
      return;
    }
  }
  
  private void updateGradients()
  {
    if ((this.ys[2] == 0.0F) && (this.ys[3] == 0.0F)) {}
    for (;;)
    {
      return;
      DetailChart.PageData.LineData[] arrayOfLineData = this.pageData.lines;
      int j = arrayOfLineData.length;
      int i = 0;
      while (i < j)
      {
        DetailChart.PageData.LineData localLineData = arrayOfLineData[i];
        int k = localLineData.color;
        localLineData.gradient = new LinearGradient(0.0F, this.ys[2], 0.0F, this.ys[3], localLineData.color, k & 0x88FFFFFF, Shader.TileMode.CLAMP);
        i += 1;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawLine(this.xOffset, this.ys[3], this.w - this.xOffset, this.ys[3], this.gridPaint);
    drawPageData(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    this.h = paramInt2;
    calculate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      selectPoint(paramMotionEvent.getX());
    }
  }
  
  public void setPageData(PageData paramPageData, int paramInt)
  {
    this.type = paramInt;
    this.pageData = paramPageData;
    if (this.w != -1)
    {
      calculate();
      invalidate();
    }
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static class PageData
  {
    public String[] dataShow0 = new String[6];
    public int goal;
    public String goalString;
    public LineData[] lines;
    public String tittle;
    
    public int getMaxData()
    {
      int i = 0;
      int k = 0;
      LineData[] arrayOfLineData;
      int m;
      int j;
      if (this.lines != null)
      {
        arrayOfLineData = this.lines;
        m = arrayOfLineData.length;
        j = 0;
        i = k;
      }
      for (;;)
      {
        if (j >= m) {
          return i;
        }
        i = Math.max(i, arrayOfLineData[j].getMaxData());
        j += 1;
      }
    }
    
    public int[][] getMaxDataIndexOfLine()
    {
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 2 });
      int m = 0;
      int j = Integer.MAX_VALUE;
      int i;
      if (this.lines != null)
      {
        i = 0;
        if (i < this.lines.length) {}
      }
      else
      {
        return arrayOfInt;
      }
      LineData localLineData = this.lines[i];
      int i2 = localLineData.datas.size();
      int k = 0;
      for (;;)
      {
        if (k >= i2)
        {
          i += 1;
          break;
        }
        DetailChart.PageData.LineData.PointModel localPointModel = (DetailChart.PageData.LineData.PointModel)localLineData.datas.get(k);
        int n = m;
        if (localPointModel.data > m)
        {
          n = localPointModel.data;
          arrayOfInt[0][0] = i;
          arrayOfInt[0][1] = k;
        }
        int i1 = j;
        if (localPointModel.data < j)
        {
          i1 = localPointModel.data;
          arrayOfInt[1][0] = i;
          arrayOfInt[1][1] = k;
        }
        k += 1;
        m = n;
        j = i1;
      }
    }
    
    public void initData(int paramInt)
    {
      LineData[] arrayOfLineData;
      int j;
      int i;
      if (this.lines != null)
      {
        arrayOfLineData = this.lines;
        j = arrayOfLineData.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= j) {
          return;
        }
        LineData localLineData = arrayOfLineData[i];
        localLineData.width = (paramInt * 1.0F / (localLineData.datas.size() - 1));
        i += 1;
      }
    }
    
    public String toString()
    {
      return "PageData [tittle=" + this.tittle + ", lines=" + Arrays.toString(this.lines) + ", goalString=" + this.goalString + ", goal=" + this.goal + ", dataShow0=" + Arrays.toString(this.dataShow0) + "]";
    }
    
    public static class LineData
    {
      public int color;
      public ArrayList<PointModel> datas;
      public LinearGradient gradient;
      public String name;
      public float width;
      
      public int getMaxData()
      {
        int i = 0;
        int j = 0;
        Iterator localIterator;
        if (this.datas != null) {
          localIterator = this.datas.iterator();
        }
        for (i = j;; i = Math.max(((PointModel)localIterator.next()).data, i)) {
          if (!localIterator.hasNext()) {
            return i;
          }
        }
      }
      
      public static class PointModel
      {
        public int data;
        public String[] dataLabel;
        public String dataName = "";
        
        public String getMaxLengthLabel()
        {
          return Util.getMaxLenthString(this.dataLabel);
        }
        
        public String getPopupStr()
        {
          if (this.dataLabel != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            int i = 0;
            for (;;)
            {
              if (i >= this.dataLabel.length) {
                return localStringBuilder.toString();
              }
              localStringBuilder.append(this.dataLabel[i]);
              if (i != this.dataLabel.length - 1) {
                localStringBuilder.append("\n");
              }
              i += 1;
            }
          }
          return null;
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\DetailChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */