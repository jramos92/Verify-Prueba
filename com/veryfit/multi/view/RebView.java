package com.veryfit.multi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.View;
import com.veryfit.multi.util.ViewUtil;

public class RebView
  extends View
{
  public static final float BOTTOM_LINES_VERTICAL_PADDING_SCALE = 0.1F;
  public static final float BOTTOM_LINES_WIDTH_SCALE = 0.02F;
  public static final float PADDING_SCALE = 0.01F;
  public static final float VERTICAL_LINES_WIDTH_SCALE = 0.025F;
  private float centerTextY;
  private int dataSize = 3;
  public Data[] datas = { new Data("0.00公里", "累计距离"), new Data("0.0小时", "累计时间"), new Data("0.00卡路里", "累计消耗") };
  private int h;
  private Paint linePanit;
  private float lineWidth;
  private float tWidth;
  private Paint textPanit;
  private float textSize;
  private int w;
  
  public RebView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.textPanit = new Paint();
    this.textPanit.setAntiAlias(true);
    this.textPanit.setColor(-1);
    this.textPanit.setTextAlign(Paint.Align.CENTER);
    this.linePanit = new Paint();
    this.linePanit.setAntiAlias(true);
    this.linePanit.setColor(-1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f2 = this.w * 0.01F;
    float f1 = this.h * 0.89F;
    float f3 = this.w;
    this.linePanit.setStrokeWidth(this.lineWidth);
    paramCanvas.drawLine(f2, f1, f3 - f2, f1, this.linePanit);
    int i;
    if (this.datas != null)
    {
      i = 0;
      if (i < this.dataSize) {}
    }
    else
    {
      this.linePanit.setStrokeWidth(this.lineWidth * 0.8F);
      i = 0;
    }
    for (;;)
    {
      if (i >= this.dataSize - 1)
      {
        return;
        this.textPanit.setTextSize(this.textSize);
        f2 = this.tWidth / 2.0F + this.w * 0.01F + (this.tWidth + this.w * 0.025F) * i;
        float f4 = ViewUtil.getTextHeight(this.textPanit);
        f3 = this.centerTextY;
        f4 /= 2.0F;
        float f5 = (this.textPanit.ascent() + this.textPanit.descent()) / 2.0F;
        paramCanvas.drawText(this.datas[i].value, f2, f3 - f4 - f5, this.textPanit);
        this.textPanit.setTextSize(this.textSize * 0.8F);
        f3 = this.centerTextY;
        f4 = ViewUtil.getTextHeight(this.textPanit);
        f5 = (this.textPanit.ascent() + this.textPanit.descent()) / 2.0F;
        paramCanvas.drawText(this.datas[i].title, f2, f3 + f4 * 1.0F + f5, this.textPanit);
        i += 1;
        break;
      }
      f2 = this.w * 0.01F + this.tWidth + this.w * 0.025F / 2.0F + (this.tWidth + this.w * 0.025F) * i;
      paramCanvas.drawLine(f2, this.h * 0.1F, f2, f1 - this.h * 0.1F - 0.01F, this.textPanit);
      i += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = paramInt1;
    this.h = paramInt2;
    this.textSize = (paramInt2 * 0.25F);
    this.tWidth = ((paramInt1 * 0.98F - paramInt1 * 0.025F * (this.dataSize - 1)) / this.dataSize);
    this.centerTextY = (paramInt2 * 0.93F / 2.0F);
    this.lineWidth = (paramInt2 * 0.02F);
  }
  
  public void setData(Data... paramVarArgs)
  {
    this.datas = paramVarArgs;
    invalidate();
  }
  
  public static class Data
  {
    public String title;
    public String value;
    
    public Data(String paramString1, String paramString2)
    {
      this.title = paramString2;
      this.value = paramString1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\RebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */