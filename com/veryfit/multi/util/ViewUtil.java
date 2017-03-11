package com.veryfit.multi.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.DisplayMetrics;

public class ViewUtil
{
  public static Bitmap blur(Bitmap paramBitmap, Context paramContext)
  {
    Object localObject = RenderScript.create(paramContext);
    paramContext = Allocation.createFromBitmap((RenderScript)localObject, paramBitmap);
    localObject = ScriptIntrinsicBlur.create((RenderScript)localObject, paramContext.getElement());
    ((ScriptIntrinsicBlur)localObject).setInput(paramContext);
    ((ScriptIntrinsicBlur)localObject).setRadius(25.0F);
    ((ScriptIntrinsicBlur)localObject).forEach(paramContext);
    paramContext.copyTo(paramBitmap);
    return paramBitmap;
  }
  
  public static int getColorBetweenAB(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    float f1 = (((paramInt2 & 0xFF0000) >> 16) - ((paramInt1 & 0xFF0000) >> 16)) / paramFloat;
    float f2 = paramInt3;
    float f3 = (paramInt1 & 0xFF0000) >> 16;
    float f4 = ((paramInt2 & 0xFF00) - (paramInt1 & 0xFF00) >> 8) / paramFloat;
    float f5 = paramInt3;
    float f6 = (paramInt1 & 0xFF00) >> 8;
    paramFloat = ((paramInt2 & 0xFF) - (paramInt1 & 0xFF)) / paramFloat;
    float f7 = paramInt3;
    float f8 = paramInt1 & 0xFF;
    return Color.rgb((int)(f1 * f2 + f3), (int)(f4 * f5 + f6), (int)(paramFloat * f7 + f8));
  }
  
  public static float getTextHeight(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return paramPaint.bottom - paramPaint.top;
  }
  
  public static float getTextRectHeight(Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  public static float getTextRectWidth(Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return paramPaint.measureText(paramString);
  }
  
  public static float px2Dp(int paramInt, Context paramContext)
  {
    return paramInt * paramContext.getResources().getDisplayMetrics().density;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ViewUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */