package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zznk
{
  private static int zzarj = -1;
  
  public static boolean zzau(Context paramContext)
  {
    return zzax(paramContext) == 3;
  }
  
  private static int zzav(Context paramContext)
  {
    return zzaw(paramContext) % 1000 / 100 + 5;
  }
  
  private static int zzaw(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("Fitness", "Could not find package info for Google Play Services");
    }
    return -1;
  }
  
  public static int zzax(Context paramContext)
  {
    if (zzarj == -1) {
      switch (zzav(paramContext))
      {
      case 9: 
      case 11: 
      case 12: 
      default: 
        if (!zzay(paramContext)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 2)
    {
      zzarj = i;
      for (;;)
      {
        return zzarj;
        zzarj = 3;
        continue;
        zzarj = 0;
      }
    }
  }
  
  private static boolean zzay(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType() != 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zznk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */