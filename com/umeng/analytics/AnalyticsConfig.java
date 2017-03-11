package com.umeng.analytics;

import android.content.Context;
import u.aly.bq;

public class AnalyticsConfig
{
  public static boolean ACTIVITY_DURATION_OPEN;
  public static boolean CATCH_EXCEPTION = true;
  public static boolean COMPRESS_DATA;
  public static boolean ENABLE_MEMORY_BUFFER;
  public static String GPU_RENDERER;
  public static String GPU_VENDER;
  private static String a = null;
  private static String b = null;
  private static double[] c;
  public static long kContinueSessionMillis = 30000L;
  public static int mVerticalType;
  public static String mWrapperType = null;
  public static String mWrapperVersion = null;
  public static boolean sEncrypt;
  public static int sLatentWindow;
  
  static
  {
    GPU_VENDER = "";
    GPU_RENDERER = "";
    sEncrypt = false;
    c = null;
    ACTIVITY_DURATION_OPEN = true;
    COMPRESS_DATA = true;
    ENABLE_MEMORY_BUFFER = true;
  }
  
  public static void enableEncrypt(boolean paramBoolean)
  {
    sEncrypt = paramBoolean;
  }
  
  public static String getAppkey(Context paramContext)
  {
    if (a == null) {
      a = bq.o(paramContext);
    }
    return a;
  }
  
  public static String getChannel(Context paramContext)
  {
    if (b == null) {
      b = bq.t(paramContext);
    }
    return b;
  }
  
  public static double[] getLocation()
  {
    return c;
  }
  
  public static String getSDKVersion()
  {
    if (mVerticalType == 1) {
      return "5.5.3.0";
    }
    return "5.5.3";
  }
  
  public static void setAppkey(String paramString)
  {
    a = paramString;
  }
  
  public static void setChannel(String paramString)
  {
    b = paramString;
  }
  
  public static void setLatencyWindow(long paramLong)
  {
    sLatentWindow = (int)paramLong * 1000;
  }
  
  public static void setLocation(double paramDouble1, double paramDouble2)
  {
    if (c == null) {
      c = new double[2];
    }
    c[0] = paramDouble1;
    c[1] = paramDouble2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\umeng\analytics\AnalyticsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */