package com.veryfit.multi.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Window;
import com.project.library.util.DebugLog;
import java.lang.reflect.Method;

public class ScreenUtils
{
  public static boolean checkDeviceHasNavigationBar(Activity paramActivity)
  {
    boolean bool1 = false;
    paramActivity = paramActivity.getResources();
    int i = paramActivity.getIdentifier("config_showNavigationBar", "bool", "android");
    if (i > 0) {
      bool1 = paramActivity.getBoolean(i);
    }
    try
    {
      paramActivity = Class.forName("android.os.SystemProperties");
      paramActivity = (String)paramActivity.getMethod("get", new Class[] { String.class }).invoke(paramActivity, new Object[] { "qemu.hw.mainkeys" });
      if ("1".equals(paramActivity)) {
        return false;
      }
      boolean bool2 = "0".equals(paramActivity);
      if (bool2) {
        return true;
      }
    }
    catch (Exception paramActivity) {}
    return bool1;
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    if (checkDeviceHasNavigationBar(paramActivity))
    {
      paramActivity = paramActivity.getResources();
      int i = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("navigation_bar_height", "dimen", "android"));
      DebugLog.e("虚拟按键高度：" + i);
      return i;
    }
    return 0;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Resources paramResources)
  {
    int i = 0;
    int j = paramResources.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static boolean isNavigationBar(Activity paramActivity)
  {
    if (getNavigationBarHeight(paramActivity) == 0)
    {
      DebugLog.e("支持沉浸式状态栏");
      return true;
    }
    DebugLog.e("不支持沉浸式状态栏");
    return false;
  }
  
  public static void setImmersiveStatusBar(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramActivity.getWindow().addFlags(67108864);
      paramActivity.getWindow().addFlags(134217728);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ScreenUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */