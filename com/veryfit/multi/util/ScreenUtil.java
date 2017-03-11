package com.veryfit.multi.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.project.library.util.DebugLog;
import java.lang.reflect.Method;

public class ScreenUtil
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
  
  public static boolean getAndroidVersionThanKitkat()
  {
    return Build.VERSION.SDK_INT >= 19;
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
  
  public static void setImmersiveStatusBar(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(67108864);
  }
  
  public static void setImmersiveStatusBar(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  public static void setLoginNavigationBar(Activity paramActivity)
  {
    setImmersiveStatusBar(paramActivity);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0);
    if ((localViewGroup.getChildAt(0) instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)localViewGroup.getChildAt(0);
      localViewGroup.setFitsSystemWindows(true);
      localViewGroup.setClipToPadding(true);
      DebugLog.d("viewGroup=LinearLayout is " + (localViewGroup instanceof LinearLayout) + ",viewGroup=LinearLayout is " + (localViewGroup instanceof FrameLayout));
      localViewGroup.setLayoutParams(new LinearLayout.LayoutParams((int)paramActivity.getResources().getDimension(2131165197), (int)(getStatusBarHeight(paramActivity.getResources()) + paramActivity.getResources().getDimension(2131165197))));
    }
  }
  
  public static void setNavigationBar(Activity paramActivity)
  {
    setImmersiveStatusBar(paramActivity);
    ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0);
    ViewGroup localViewGroup1;
    Object localObject;
    if ((localViewGroup2.getChildAt(0) instanceof ViewGroup))
    {
      localViewGroup1 = (ViewGroup)localViewGroup2.getChildAt(0);
      localViewGroup1.setFitsSystemWindows(true);
      localViewGroup1.setClipToPadding(true);
      DebugLog.d("viewGroup=LinearLayout is " + (localViewGroup1 instanceof LinearLayout) + ",viewGroup=LinearLayout is " + (localViewGroup1 instanceof FrameLayout));
      localObject = null;
      if (!(localViewGroup2 instanceof LinearLayout)) {
        break label132;
      }
      paramActivity = new LinearLayout.LayoutParams(-1, (int)(getStatusBarHeight(paramActivity.getResources()) + paramActivity.getResources().getDimension(2131165197)));
    }
    for (;;)
    {
      localViewGroup1.setLayoutParams(paramActivity);
      return;
      label132:
      if ((localViewGroup2 instanceof RelativeLayout))
      {
        paramActivity = new RelativeLayout.LayoutParams(-1, (int)(getStatusBarHeight(paramActivity.getResources()) + paramActivity.getResources().getDimension(2131165197)));
      }
      else
      {
        boolean bool = localViewGroup2 instanceof FrameLayout;
        paramActivity = (Activity)localObject;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\ScreenUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */