package com.veryfit.multi.camera;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils
{
  private static float screenDensity;
  private static int screenH;
  private static int screenW;
  
  public static int dp2px(float paramFloat)
  {
    return (int)(getScreenDensity() * paramFloat + 0.5F);
  }
  
  public static float getScreenDensity()
  {
    return screenDensity;
  }
  
  public static int getScreenH()
  {
    return screenH;
  }
  
  public static int getScreenW()
  {
    return screenW;
  }
  
  public static void initScreen(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    screenW = localDisplayMetrics.widthPixels;
    screenH = localDisplayMetrics.heightPixels;
    screenDensity = localDisplayMetrics.density;
  }
  
  public static int px2dp(float paramFloat)
  {
    return (int)(paramFloat / getScreenDensity() + 0.5F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\ScreenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */