package com.veryfit.multi.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class TextSizeUtil
{
  public static int getPPI(Context paramContext)
  {
    Activity localActivity = (Activity)paramContext;
    Point localPoint = new Point();
    localActivity.getWindowManager().getDefaultDisplay().getRealSize(localPoint);
    paramContext = paramContext.getResources().getDisplayMetrics();
    double d = Math.sqrt(Math.pow(localPoint.x / paramContext.xdpi, 2.0D) + Math.pow(localPoint.y / paramContext.ydpi, 2.0D));
    int i = localPoint.x;
    int j = localPoint.y;
    return (int)(Math.sqrt(Math.pow(i, 2.0D) + Math.pow(j, 2.0D)) / d);
  }
  
  public static int getTextSize(Context paramContext, int paramInt)
  {
    getPPI(paramContext);
    return 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\TextSizeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */