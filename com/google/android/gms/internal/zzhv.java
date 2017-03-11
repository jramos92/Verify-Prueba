package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzhv
{
  final String zzHP;
  long zzId = -1L;
  long zzIe = -1L;
  int zzIf = -1;
  int zzIg = 0;
  int zzIh = 0;
  private final Object zzpd = new Object();
  
  public zzhv(String paramString)
  {
    this.zzHP = paramString;
  }
  
  public static boolean zzF(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
        return true;
      }
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzb.zzaH("Fail to fetch AdActivity theme");
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public void zzb(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    synchronized (this.zzpd)
    {
      if (this.zzIe == -1L)
      {
        this.zzIe = paramLong;
        this.zzId = this.zzIe;
        if ((paramAdRequestParcel.extras == null) || (paramAdRequestParcel.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.zzId = paramLong;
      }
    }
    this.zzIf += 1;
  }
  
  public Bundle zze(Context paramContext, String paramString)
  {
    synchronized (this.zzpd)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.zzHP);
      localBundle.putLong("basets", this.zzIe);
      localBundle.putLong("currts", this.zzId);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.zzIf);
      localBundle.putInt("pclick", this.zzIg);
      localBundle.putInt("pimp", this.zzIh);
      localBundle.putBoolean("support_transparent_background", zzF(paramContext));
      return localBundle;
    }
  }
  
  public void zzgf()
  {
    synchronized (this.zzpd)
    {
      this.zzIh += 1;
      return;
    }
  }
  
  public void zzgg()
  {
    synchronized (this.zzpd)
    {
      this.zzIg += 1;
      return;
    }
  }
  
  public long zzgx()
  {
    return this.zzIe;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */