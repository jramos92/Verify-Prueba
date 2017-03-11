package com.veryfit.multi.photowall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class ZoomImageView
  extends View
{
  public static final int STATUS_INIT = 1;
  public static final int STATUS_MOVE = 4;
  public static final int STATUS_ZOOM_IN = 3;
  public static final int STATUS_ZOOM_OUT = 2;
  private float centerPointX;
  private float centerPointY;
  private float currentBitmapHeight;
  private float currentBitmapWidth;
  private int currentStatus = 1;
  private int height;
  private float initRatio;
  private double lastFingerDis;
  private float lastXMove = -1.0F;
  private float lastYMove = -1.0F;
  private Matrix matrix = new Matrix();
  private float movedDistanceX;
  private float movedDistanceY;
  private float scaledRatio;
  private Bitmap sourceBitmap;
  private float totalRatio;
  private float totalTranslateX;
  private float totalTranslateY;
  private int width;
  
  public ZoomImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void centerPointBetweenFingers(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    this.centerPointX = ((f1 + f3) / 2.0F);
    this.centerPointY = ((f2 + f4) / 2.0F);
  }
  
  private double distanceBetweenFingers(MotionEvent paramMotionEvent)
  {
    float f1 = Math.abs(paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
    float f2 = Math.abs(paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private void initBitmap(Canvas paramCanvas)
  {
    int i;
    int j;
    float f1;
    float f2;
    if (this.sourceBitmap != null)
    {
      this.matrix.reset();
      i = this.sourceBitmap.getWidth();
      j = this.sourceBitmap.getHeight();
      if ((i <= this.width) && (j <= this.height)) {
        break label230;
      }
      if (i - this.width <= j - this.height) {
        break label166;
      }
      f1 = this.width / (i * 1.0F);
      this.matrix.postScale(f1, f1);
      f2 = (this.height - j * f1) / 2.0F;
      this.matrix.postTranslate(0.0F, f2);
      this.totalTranslateY = f2;
      this.initRatio = f1;
      this.totalRatio = f1;
      this.currentBitmapWidth = (i * this.initRatio);
    }
    for (this.currentBitmapHeight = (j * this.initRatio);; this.currentBitmapHeight = j)
    {
      paramCanvas.drawBitmap(this.sourceBitmap, this.matrix, null);
      return;
      label166:
      f1 = this.height / (j * 1.0F);
      this.matrix.postScale(f1, f1);
      f2 = (this.width - i * f1) / 2.0F;
      this.matrix.postTranslate(f2, 0.0F);
      this.totalTranslateX = f2;
      this.initRatio = f1;
      this.totalRatio = f1;
      break;
      label230:
      f1 = (this.width - this.sourceBitmap.getWidth()) / 2.0F;
      f2 = (this.height - this.sourceBitmap.getHeight()) / 2.0F;
      this.matrix.postTranslate(f1, f2);
      this.totalTranslateX = f1;
      this.totalTranslateY = f2;
      this.initRatio = 1.0F;
      this.totalRatio = 1.0F;
      this.currentBitmapWidth = i;
    }
  }
  
  private void move(Canvas paramCanvas)
  {
    this.matrix.reset();
    float f1 = this.totalTranslateX + this.movedDistanceX;
    float f2 = this.totalTranslateY + this.movedDistanceY;
    this.matrix.postScale(this.totalRatio, this.totalRatio);
    this.matrix.postTranslate(f1, f2);
    this.totalTranslateX = f1;
    this.totalTranslateY = f2;
    paramCanvas.drawBitmap(this.sourceBitmap, this.matrix, null);
  }
  
  private void zoom(Canvas paramCanvas)
  {
    this.matrix.reset();
    this.matrix.postScale(this.totalRatio, this.totalRatio);
    float f4 = this.sourceBitmap.getWidth() * this.totalRatio;
    float f5 = this.sourceBitmap.getHeight() * this.totalRatio;
    float f1;
    float f2;
    if (this.currentBitmapWidth < this.width)
    {
      f1 = (this.width - f4) / 2.0F;
      if (this.currentBitmapHeight >= this.height) {
        break label207;
      }
      f2 = (this.height - f5) / 2.0F;
    }
    for (;;)
    {
      this.matrix.postTranslate(f1, f2);
      this.totalTranslateX = f1;
      this.totalTranslateY = f2;
      this.currentBitmapWidth = f4;
      this.currentBitmapHeight = f5;
      paramCanvas.drawBitmap(this.sourceBitmap, this.matrix, null);
      return;
      f2 = this.totalTranslateX * this.scaledRatio + this.centerPointX * (1.0F - this.scaledRatio);
      if (f2 > 0.0F)
      {
        f1 = 0.0F;
        break;
      }
      f1 = f2;
      if (this.width - f2 <= f4) {
        break;
      }
      f1 = this.width - f4;
      break;
      label207:
      float f3 = this.totalTranslateY * this.scaledRatio + this.centerPointY * (1.0F - this.scaledRatio);
      if (f3 > 0.0F)
      {
        f2 = 0.0F;
      }
      else
      {
        f2 = f3;
        if (this.height - f3 > f5) {
          f2 = this.height - f5;
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    switch (this.currentStatus)
    {
    }
    for (;;)
    {
      if (this.sourceBitmap != null) {
        paramCanvas.drawBitmap(this.sourceBitmap, this.matrix, null);
      }
      return;
      zoom(paramCanvas);
      return;
      move(paramCanvas);
      return;
      initBitmap(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.width = getWidth();
      this.height = getHeight();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.initRatio == this.totalRatio) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
    case 5: 
    case 2: 
    case 3: 
    case 6: 
      label264:
      label432:
      do
      {
        double d;
        do
        {
          do
          {
            do
            {
              return true;
              getParent().requestDisallowInterceptTouchEvent(true);
              break;
            } while (paramMotionEvent.getPointerCount() != 2);
            this.lastFingerDis = distanceBetweenFingers(paramMotionEvent);
            return true;
            if (paramMotionEvent.getPointerCount() == 1)
            {
              float f1 = paramMotionEvent.getX();
              float f2 = paramMotionEvent.getY();
              if ((this.lastXMove == -1.0F) && (this.lastYMove == -1.0F))
              {
                this.lastXMove = f1;
                this.lastYMove = f2;
              }
              this.currentStatus = 4;
              this.movedDistanceX = (f1 - this.lastXMove);
              this.movedDistanceY = (f2 - this.lastYMove);
              if (this.totalTranslateX + this.movedDistanceX > 0.0F)
              {
                this.movedDistanceX = 0.0F;
                if (this.totalTranslateY + this.movedDistanceY <= 0.0F) {
                  break label264;
                }
                this.movedDistanceY = 0.0F;
              }
              for (;;)
              {
                invalidate();
                this.lastXMove = f1;
                this.lastYMove = f2;
                return true;
                if (this.width - (this.totalTranslateX + this.movedDistanceX) <= this.currentBitmapWidth) {
                  break;
                }
                this.movedDistanceX = 0.0F;
                break;
                if (this.height - (this.totalTranslateY + this.movedDistanceY) > this.currentBitmapHeight) {
                  this.movedDistanceY = 0.0F;
                }
              }
            }
          } while (paramMotionEvent.getPointerCount() != 2);
          centerPointBetweenFingers(paramMotionEvent);
          d = distanceBetweenFingers(paramMotionEvent);
          if (d <= this.lastFingerDis) {
            break label432;
          }
          this.currentStatus = 2;
        } while (((this.currentStatus != 2) || (this.totalRatio >= this.initRatio * 4.0F)) && ((this.currentStatus != 3) || (this.totalRatio <= this.initRatio)));
        this.scaledRatio = ((float)(d / this.lastFingerDis));
        this.totalRatio *= this.scaledRatio;
        if (this.totalRatio > this.initRatio * 4.0F) {
          this.totalRatio = (this.initRatio * 4.0F);
        }
        for (;;)
        {
          invalidate();
          this.lastFingerDis = d;
          return true;
          this.currentStatus = 3;
          break;
          if (this.totalRatio < this.initRatio) {
            this.totalRatio = this.initRatio;
          }
        }
      } while (paramMotionEvent.getPointerCount() != 2);
      this.lastXMove = -1.0F;
      this.lastYMove = -1.0F;
      return true;
    }
    this.lastXMove = -1.0F;
    this.lastYMove = -1.0F;
    return true;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.sourceBitmap = paramBitmap;
    invalidate();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\photowall\ZoomImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */