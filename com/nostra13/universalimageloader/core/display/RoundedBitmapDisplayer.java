package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.nostra13.universalimageloader.utils.L;

public class RoundedBitmapDisplayer
  implements BitmapDisplayer
{
  private final int roundPixels;
  
  public RoundedBitmapDisplayer(int paramInt)
  {
    this.roundPixels = paramInt;
  }
  
  private static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    paramRect2 = new RectF(paramRect2);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(paramRect2, paramInt1, paramInt1, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, paramRect1, paramRect2, localPaint);
    return localBitmap;
  }
  
  public static Bitmap roundCorners(Bitmap paramBitmap, ImageView paramImageView, int paramInt)
  {
    int m = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int i = paramImageView.getWidth();
    int n = paramImageView.getHeight();
    int j = i;
    if (i <= 0) {
      j = m;
    }
    i = n;
    if (n <= 0) {
      i = k;
    }
    Rect localRect;
    switch (paramImageView.getScaleType())
    {
    case ???: 
    case ???: 
    case ???: 
    default: 
      if (j / i > m / k)
      {
        n = (int)(m / (k / i));
        j = i;
        i = n;
        paramImageView = new Rect(0, 0, m, k);
        localRect = new Rect(0, 0, i, j);
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramImageView = getRoundedCornerBitmap(paramBitmap, paramInt, paramImageView, localRect, i, j);
        return paramImageView;
      }
      catch (OutOfMemoryError paramImageView)
      {
        int i1;
        int i2;
        int i3;
        L.e(paramImageView, "Can't create bitmap with rounded corners. Not enough memory.", new Object[0]);
      }
      if (j / i > m / k)
      {
        n = Math.min(i, k);
        i1 = (int)(m / (k / n));
        i2 = (j - i1) / 2;
        i3 = (i - n) / 2;
        paramImageView = new Rect(0, 0, m, k);
        localRect = new Rect(i2, i3, i2 + i1, i3 + n);
        k = i;
        i = j;
        j = k;
      }
      else
      {
        i1 = Math.min(j, m);
        n = (int)(k / (m / i1));
        continue;
        i = j;
        j = (int)(k / (m / j));
        break;
        if (j / i > m / k)
        {
          i1 = m;
          n = (int)(i * (m / j));
          i2 = 0;
          i3 = (k - n) / 2;
          j = Math.min(j, m);
          k = Math.min(i, k);
          paramImageView = new Rect(i2, i3, i2 + i1, i3 + n);
          localRect = new Rect(0, 0, j, k);
          i = j;
          j = k;
        }
        else
        {
          i1 = (int)(j * (k / i));
          n = k;
          i2 = (m - i1) / 2;
          i3 = 0;
          continue;
          n = i;
          paramImageView = new Rect(0, 0, m, k);
          localRect = new Rect(0, 0, j, n);
          i = j;
          j = n;
          continue;
          j = Math.min(j, m);
          n = Math.min(i, k);
          i = (m - j) / 2;
          k = (k - n) / 2;
          paramImageView = new Rect(i, k, i + j, k + n);
          localRect = new Rect(0, 0, j, n);
          i = j;
          j = n;
        }
      }
    }
    return paramBitmap;
  }
  
  public Bitmap display(Bitmap paramBitmap, ImageView paramImageView)
  {
    paramBitmap = roundCorners(paramBitmap, paramImageView, this.roundPixels);
    paramImageView.setImageBitmap(paramBitmap);
    return paramBitmap;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\display\RoundedBitmapDisplayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */