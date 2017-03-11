package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;

public class ValueStateTextView
  extends TextView
{
  private static final int[] OPEN_STATE_SET = { 2130771981 };
  private Drawable d;
  private boolean isOpen = false;
  
  public ValueStateTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ValueStateTextView);
    this.d = paramContext.getDrawable(0);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.d != null) && (this.d.isStateful())) {
      this.d.setState(getDrawableState());
    }
    invalidate();
  }
  
  public boolean isOpen()
  {
    return this.isOpen;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isOpen()) {
      mergeDrawableStates(arrayOfInt, OPEN_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d != null)
    {
      int i = getHeight();
      int j = i / 2 - 3;
      int k = Math.min(j, getHeight());
      this.d.setBounds(j / 2 - k / 2, i / 2 - k / 2, j / 2 + k / 2, i / 2 + k / 2);
      this.d.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
    refreshDrawableState();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\ValueStateTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */