package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;

public class MyTextView
  extends TextView
{
  private int bottomLineColor;
  private boolean hasBottomLine;
  private boolean hasTopLine;
  private String lable;
  private TextView lableView;
  private Paint paint;
  private int topLineColor;
  
  public MyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.lableView = ((TextView)View.inflate(paramContext, 2130903117, null).findViewById(2131230764));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MyItemTextView);
    int i = paramContext.getColor(4, -1);
    this.hasTopLine = paramContext.getBoolean(0, false);
    this.hasBottomLine = paramContext.getBoolean(3, true);
    this.lable = paramContext.getString(5);
    if (this.hasTopLine)
    {
      this.topLineColor = paramContext.getColor(2, getResources().getColor(2131099656));
      initTopDraw();
    }
    if (this.hasBottomLine)
    {
      this.bottomLineColor = paramContext.getColor(3, getResources().getColor(2131099656));
      initBottomDraw();
    }
    paramContext.recycle();
    if (i != 0) {
      this.lableView.setTextColor(i);
    }
    this.lableView.setText(this.lable);
    setClickable(true);
    setGravity(17);
  }
  
  private void initBottomDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.bottomLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  private void initTopDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.topLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.hasBottomLine) {
      paramCanvas.drawLine(0.0F, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), this.paint);
    }
    if (this.hasTopLine) {
      paramCanvas.drawLine(0.0F, 0.0F, getMeasuredWidth(), 0.0F, this.paint);
    }
  }
  
  public void setLabelText(int paramInt)
  {
    this.lableView.setText(paramInt);
  }
  
  public void setLabelText(String paramString)
  {
    this.lableView.setText(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\MyTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */