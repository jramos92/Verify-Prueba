package com.veryfit.multi.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class NetUtils
{
  private NetUtils()
  {
    throw new UnsupportedOperationException("cannot be instantiated");
  }
  
  public static boolean isConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()) && (paramContext.getState() == NetworkInfo.State.CONNECTED)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    while (paramContext.getActiveNetworkInfo().getType() != 1) {
      return false;
    }
    return true;
  }
  
  public static void openSetting(Activity paramActivity)
  {
    Intent localIntent = new Intent("/");
    localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.WirelessSettings"));
    localIntent.setAction("android.intent.action.VIEW");
    paramActivity.startActivityForResult(localIntent, 0);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\NetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */