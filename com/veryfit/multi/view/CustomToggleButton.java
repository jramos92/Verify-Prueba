package com.veryfit.multi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import com.project.library.util.DebugLog;

public class CustomToggleButton
  extends View
  implements View.OnTouchListener
{
  private float currentX;
  private float dis;
  private boolean isSlipping = false;
  private boolean isSwitchOn = false;
  private Rect off_Rect;
  private OnSwitchListener onSwitchListener;
  private Rect on_Rect;
  Paint paint = new Paint();
  private float previousX;
  private Bitmap slip_Btn;
  private Bitmap switch_off_Bkg;
  private Bitmap switch_on_Bkg;
  
  public CustomToggleButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CustomToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setOnTouchListener(this);
    setImageResource(2130837722, 2130837721, 2130837723);
  }
  
  public boolean getSwitchState()
  {
    return this.isSwitchOn;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1;
    label98:
    float f2;
    if (this.isSlipping) {
      if (this.currentX > this.switch_on_Bkg.getWidth())
      {
        f1 = this.switch_on_Bkg.getWidth() - this.slip_Btn.getWidth();
        if ((!this.isSlipping) || (this.currentX >= this.switch_on_Bkg.getWidth() / 2)) {
          break label154;
        }
        paramCanvas.drawBitmap(this.switch_off_Bkg, 0.0F, (getMeasuredHeight() - this.switch_off_Bkg.getHeight()) / 2, this.paint);
        if (f1 >= 0.0F) {
          break label272;
        }
        f2 = 0.0F;
      }
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.slip_Btn, f2, (getMeasuredHeight() - this.slip_Btn.getHeight()) / 2, this.paint);
      return;
      f1 = this.currentX - this.slip_Btn.getWidth() / 2;
      break;
      label154:
      paramCanvas.drawBitmap(this.switch_on_Bkg, 0.0F, (getMeasuredHeight() - this.switch_off_Bkg.getHeight()) / 2, this.paint);
      break label98;
      if (this.isSwitchOn)
      {
        f1 = this.on_Rect.left;
        paramCanvas.drawBitmap(this.switch_on_Bkg, 0.0F, (getMeasuredHeight() - this.switch_off_Bkg.getHeight()) / 2, this.paint);
        break label98;
      }
      f1 = this.off_Rect.left;
      paramCanvas.drawBitmap(this.switch_off_Bkg, 0.0F, (getMeasuredHeight() - this.switch_off_Bkg.getHeight()) / 2, this.paint);
      break label98;
      label272:
      f2 = f1;
      if (f1 > this.switch_on_Bkg.getWidth() - this.slip_Btn.getWidth()) {
        f2 = this.switch_on_Bkg.getWidth() - this.slip_Btn.getWidth();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    }
    for (;;)
    {
      setMeasuredDimension(this.switch_on_Bkg.getWidth(), paramInt1);
      return;
      paramInt1 = this.switch_on_Bkg.getHeight() + getPaddingBottom() + getPaddingTop();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool2 = this.isSwitchOn;
    bool2 = this.isSwitchOn;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
    case 0: 
      for (;;)
      {
        invalidate();
        bool1 = true;
        do
        {
          return bool1;
          this.dis = (paramMotionEvent.getX() - this.previousX);
          this.currentX = paramMotionEvent.getX();
          break;
        } while (paramMotionEvent.getX() > this.switch_on_Bkg.getWidth());
        this.dis = 0.0F;
        this.isSlipping = true;
        this.previousX = paramMotionEvent.getX();
        this.currentX = this.previousX;
      }
    case 1: 
      this.isSlipping = false;
      if (this.dis > this.switch_on_Bkg.getWidth() / 2)
      {
        bool1 = true;
        label150:
        DebugLog.d("eventAction = " + paramMotionEvent.getAction() + "***x = " + paramMotionEvent.getX() + "***limit = " + this.switch_on_Bkg.getWidth());
        DebugLog.d("eventAction = " + paramMotionEvent.getAction() + "***tempState = " + bool1 + "***isSwitchOn = " + this.isSwitchOn + "***dis = " + this.dis);
        if (paramMotionEvent.getX() < this.switch_on_Bkg.getWidth() / 2) {
          break label312;
        }
      }
      label312:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.onSwitchListener != null) && (bool1 != this.isSwitchOn)) {
          this.onSwitchListener.onSwitched(bool1);
        }
        this.isSwitchOn = bool1;
        break;
        bool1 = false;
        break label150;
      }
    }
    this.isSlipping = false;
    if (this.currentX >= this.switch_on_Bkg.getWidth() / 2) {}
    for (bool1 = true;; bool1 = false)
    {
      DebugLog.d("eventAction = " + paramMotionEvent.getAction() + "***tempState = " + bool1 + "***isSwitchOn = " + this.isSwitchOn + "***dis = " + this.dis);
      if ((this.onSwitchListener != null) && (bool1 != this.isSwitchOn)) {
        this.onSwitchListener.onSwitched(bool1);
      }
      this.isSwitchOn = bool1;
      break;
    }
  }
  
  public void setImageResource(int paramInt1, int paramInt2, int paramInt3)
  {
    this.switch_on_Bkg = BitmapFactory.decodeResource(getResources(), paramInt1);
    this.switch_off_Bkg = BitmapFactory.decodeResource(getResources(), paramInt2);
    this.slip_Btn = BitmapFactory.decodeResource(getResources(), paramInt3);
    this.on_Rect = new Rect(this.switch_off_Bkg.getWidth() - this.slip_Btn.getWidth(), 0, this.switch_off_Bkg.getWidth(), this.slip_Btn.getHeight());
    this.off_Rect = new Rect(0, 0, this.slip_Btn.getWidth(), this.slip_Btn.getHeight());
  }
  
  public void setOnSwitchListener(OnSwitchListener paramOnSwitchListener)
  {
    this.onSwitchListener = paramOnSwitchListener;
  }
  
  public void setSwitchState(boolean paramBoolean)
  {
    this.isSwitchOn = paramBoolean;
    invalidate();
  }
  
  protected void updateSwitchState(boolean paramBoolean)
  {
    this.isSwitchOn = paramBoolean;
    invalidate();
  }
  
  public static abstract interface OnSwitchListener
  {
    public abstract void onSwitched(boolean paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\CustomToggleButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */