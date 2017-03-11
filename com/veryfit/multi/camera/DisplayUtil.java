package com.veryfit.multi.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class DisplayUtil
{
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static Point getScreenMetrics(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return new Point(paramContext.widthPixels, paramContext.heightPixels);
  }
  
  public static float getScreenRate(Context paramContext)
  {
    paramContext = getScreenMetrics(paramContext);
    return paramContext.y / paramContext.x;
  }
  
  public static float getScreenRawHeight(Activity paramActivity)
  {
    float f1 = 0.0F;
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    paramActivity = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { paramActivity });
      int i = paramActivity.heightPixels;
      f1 = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f2;
        localException.printStackTrace();
      }
    }
    f2 = f1;
    if (f1 == 0.0F) {
      f2 = paramActivity.heightPixels;
    }
    return f2;
  }
  
  public static boolean hasShowVirtualKey()
  {
    boolean bool1 = KeyCharacterMap.deviceHasKey(4);
    boolean bool2 = KeyCharacterMap.deviceHasKey(3);
    return (!bool1) || (!bool2);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\DisplayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */