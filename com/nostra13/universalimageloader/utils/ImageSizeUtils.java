package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

public final class ImageSizeUtils
{
  public static int computeImageSampleSize(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int j = paramImageSize1.getWidth();
    int i = paramImageSize1.getHeight();
    int i2 = paramImageSize2.getWidth();
    int i3 = paramImageSize2.getHeight();
    int n = 1;
    int i1 = 1;
    int k = 1;
    int m = j / i2;
    int i4 = i / i3;
    switch (paramViewScaleType)
    {
    default: 
      i = k;
    }
    for (;;)
    {
      j = i;
      if (i < 1) {
        j = 1;
      }
      return j;
      if (paramBoolean)
      {
        m = j;
        k = i;
        j = n;
        for (;;)
        {
          if (m / 2 < i2)
          {
            i = j;
            if (k / 2 < i3) {
              break;
            }
          }
          m /= 2;
          k /= 2;
          j *= 2;
        }
      }
      i = Math.max(m, i4);
      continue;
      if (paramBoolean)
      {
        m = j;
        k = i;
        j = i1;
        for (;;)
        {
          i = j;
          if (m / 2 < i2) {
            break;
          }
          i = j;
          if (k / 2 < i3) {
            break;
          }
          m /= 2;
          k /= 2;
          j *= 2;
        }
      }
      i = Math.min(m, i4);
    }
  }
  
  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int k = paramImageSize1.getWidth();
    int m = paramImageSize1.getHeight();
    int j = paramImageSize2.getWidth();
    int i = paramImageSize2.getHeight();
    float f1 = k / j;
    float f2 = m / i;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2))) {
      i = (int)(m / f1);
    }
    for (;;)
    {
      f2 = 1.0F;
      if ((paramBoolean) || (j >= k) || (i >= m))
      {
        f1 = f2;
        if (paramBoolean)
        {
          f1 = f2;
          if (j != k)
          {
            f1 = f2;
            if (i == m) {}
          }
        }
      }
      else
      {
        f1 = j / k;
      }
      return f1;
      j = (int)(k / f2);
    }
  }
  
  public static ImageSize defineTargetSizeForView(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    int k = 0;
    DisplayMetrics localDisplayMetrics = paramImageView.getContext().getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    int j;
    if (localLayoutParams.width == -2)
    {
      j = 0;
      i = j;
      if (j <= 0) {
        i = localLayoutParams.width;
      }
      j = i;
      if (i <= 0) {
        j = getImageViewFieldValue(paramImageView, "mMaxWidth");
      }
      i = j;
      if (j <= 0) {
        i = paramInt1;
      }
      j = i;
      if (i <= 0) {
        j = localDisplayMetrics.widthPixels;
      }
      if (localLayoutParams.height != -2) {
        break label165;
      }
    }
    label165:
    for (int i = k;; i = paramImageView.getHeight())
    {
      paramInt1 = i;
      if (i <= 0) {
        paramInt1 = localLayoutParams.height;
      }
      i = paramInt1;
      if (paramInt1 <= 0) {
        i = getImageViewFieldValue(paramImageView, "mMaxHeight");
      }
      paramInt1 = i;
      if (i <= 0) {
        paramInt1 = paramInt2;
      }
      paramInt2 = paramInt1;
      if (paramInt1 <= 0) {
        paramInt2 = localDisplayMetrics.heightPixels;
      }
      return new ImageSize(j, paramInt2);
      j = paramImageView.getWidth();
      break;
    }
  }
  
  private static int getImageViewFieldValue(Object paramObject, String paramString)
  {
    int j = 0;
    try
    {
      paramString = ImageView.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      int k = ((Integer)paramString.get(paramObject)).intValue();
      int i = j;
      if (k > 0)
      {
        i = j;
        if (k < Integer.MAX_VALUE) {
          i = k;
        }
      }
      return i;
    }
    catch (Exception paramObject)
    {
      L.e((Throwable)paramObject);
    }
    return 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\utils\ImageSizeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */