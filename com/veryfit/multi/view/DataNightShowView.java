package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.util.ViewUtil;
import java.util.Locale;

public class DataNightShowView
  extends View
{
  private int bgColor;
  private boolean centerY;
  private DataModeNight[] datas = new DataModeNight[0];
  private Paint symbolPaint;
  private float symbolSize = 20.0F;
  private float unitBaseLine;
  private float unitCenterLine;
  private Paint unitPaint;
  private float valueBaseLine;
  private Paint valuePaint;
  private float w;
  private float xStep;
  
  public DataNightShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DataShowView);
    int i = paramContext.getColor(0, getResources().getColor(2131099649));
    int j = paramContext.getColor(2, i);
    paramContext.getDimension(3, 28.0F);
    float f = paramContext.getDimension(4, 28.0F);
    this.bgColor = paramContext.getColor(1, getResources().getColor(2131099661));
    this.centerY = paramContext.getBoolean(5, false);
    paramContext.recycle();
    this.valuePaint = new Paint(1);
    this.valuePaint.setTextAlign(Paint.Align.CENTER);
    this.valuePaint.setTextSize(40.0F);
    this.valuePaint.setColor(i);
    this.unitPaint = new Paint(1);
    this.unitPaint.setTextSize(f);
    this.unitPaint.setTextAlign(Paint.Align.CENTER);
    this.unitPaint.setColor(j);
    this.symbolPaint = new Paint(1);
  }
  
  private void calculateX()
  {
    if (this.datas != null) {
      this.xStep = (this.w / this.datas.length);
    }
  }
  
  private void calculateY(int paramInt)
  {
    if (this.centerY)
    {
      f2 = ViewUtil.getTextHeight(this.unitPaint);
      f1 = ViewUtil.getTextHeight(this.valuePaint);
      f2 = f2 + 20.0F + f1;
      this.unitBaseLine = (paramInt - (paramInt - f2) / 2.0F + (this.unitPaint.ascent() + this.unitPaint.descent()) / 2.0F);
      this.valueBaseLine = ((paramInt - f2) / 2.0F + f1 + (this.valuePaint.ascent() + this.valuePaint.descent()) / 2.0F);
      return;
    }
    float f1 = ViewUtil.getTextHeight(this.valuePaint) + getPaddingTop();
    this.valueBaseLine = ((this.valuePaint.ascent() + this.valuePaint.descent()) / 2.0F + f1);
    f1 += getPaddingTop() * 15.0F / 62.0F;
    float f2 = f1 + ViewUtil.getTextHeight(this.unitPaint);
    this.unitCenterLine = ((f2 - f1) / 2.0F + f1);
    this.unitBaseLine = ((this.unitPaint.ascent() + this.unitPaint.descent()) / 2.0F + f2);
  }
  
  public void initDatas(DataModeNight... paramVarArgs)
  {
    this.datas = paramVarArgs;
    calculateX();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(this.bgColor);
    int i = 0;
    if (i >= this.datas.length) {
      return;
    }
    Object localObject = this.datas[i];
    float f1 = this.xStep * (i + 0.5F);
    ((DataModeNight)localObject).value = TextUtils.ellipsize(((DataModeNight)localObject).value, new TextPaint(this.valuePaint), 230.0F, TextUtils.TruncateAt.END).toString();
    if (TextUtils.isEmpty(((DataModeNight)localObject).value))
    {
      paramCanvas.drawText(0 + getResources().getString(2131296414) + 0 + getResources().getString(2131296415), f1, this.valueBaseLine, this.valuePaint);
      label148:
      if (((DataModeNight)localObject).symbolColor != 0) {
        break label259;
      }
      paramCanvas.drawText(((DataModeNight)localObject).unit, f1, this.unitBaseLine, this.unitPaint);
    }
    for (;;)
    {
      i += 1;
      break;
      int j = Integer.parseInt(((DataModeNight)localObject).value);
      paramCanvas.drawText(j / 60 + getResources().getString(2131296414) + j % 60 + getResources().getString(2131296415), f1, this.valueBaseLine, this.valuePaint);
      break label148;
      label259:
      f1 += 4.0F + this.symbolSize / 2.0F;
      String str2 = ((DataModeNight)localObject).unit;
      if (str2.length() >= 15)
      {
        String str1 = str2.substring(0, 13);
        str2 = str2.substring(13, str2.length());
        paramCanvas.drawText(str1, f1, this.unitBaseLine, this.unitPaint);
        if (str2.length() >= 15)
        {
          str1 = str2.substring(0, 13);
          str2 = str2.substring(13, str2.length());
          paramCanvas.drawText(str1, f1, this.unitBaseLine + this.symbolSize + 8.0F, this.unitPaint);
          paramCanvas.drawText(str2, f1, this.unitBaseLine + 2.0F * (this.symbolSize + 8.0F), this.unitPaint);
        }
      }
      for (;;)
      {
        f1 -= ViewUtil.getTextRectWidth(this.unitPaint, ((DataModeNight)localObject).unit) / 2.0F;
        this.symbolPaint.setColor(((DataModeNight)localObject).symbolColor);
        localObject = getResources().getConfiguration().locale.getCountry();
        if ((!((String)localObject).equals("RU")) && (!((String)localObject).equals("PT")) && (!((String)localObject).equals("IT"))) {
          break label618;
        }
        f1 = i * this.w / 3.0F;
        f2 = this.unitCenterLine;
        f3 = this.symbolSize / 2.0F;
        f4 = i * this.w / 3.0F;
        f5 = this.symbolSize;
        float f6 = this.unitCenterLine;
        paramCanvas.drawRect(f1 + 20.0F, f2 - f3, f5 + (20.0F + f4), this.symbolSize / 2.0F + f6, this.symbolPaint);
        break;
        paramCanvas.drawText(str2, f1, this.unitBaseLine + this.symbolSize + 8.0F, this.unitPaint);
        continue;
        paramCanvas.drawText(str2, f1, this.unitBaseLine, this.unitPaint);
      }
      label618:
      float f2 = this.symbolSize;
      float f3 = this.unitCenterLine;
      float f4 = this.symbolSize / 2.0F;
      float f5 = this.unitCenterLine;
      paramCanvas.drawRect(f1 - 8.0F - f2, f3 - f4, f1 - 8.0F, this.symbolSize / 2.0F + f5, this.symbolPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    calculateY(paramInt2);
    calculateX();
  }
  
  public void setUnitColor(int paramInt)
  {
    this.unitPaint.setColor(paramInt);
  }
  
  public void setValueTypeface(Typeface paramTypeface)
  {
    this.valuePaint.setTypeface(paramTypeface);
  }
  
  public void updateData(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      this.datas[paramInt].value = paramString1;
    }
    if (paramString2 != null) {
      this.datas[paramInt].unit = paramString2;
    }
    invalidate();
  }
  
  public static class DataModeNight
  {
    public int symbolColor = 0;
    public String unit;
    public String value;
    
    public DataModeNight() {}
    
    public DataModeNight(int paramInt, String paramString1, String paramString2)
    {
      this.symbolColor = paramInt;
      this.value = paramString1;
      this.unit = paramString2;
    }
    
    public DataModeNight(String paramString1, String paramString2)
    {
      this.value = paramString1;
      this.unit = paramString2;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\DataNightShowView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */