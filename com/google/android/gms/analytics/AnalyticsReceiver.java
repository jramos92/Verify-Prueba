package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

public final class AnalyticsReceiver
  extends BroadcastReceiver
{
  static zzqy zzLh;
  static Boolean zzLi;
  static Object zzpy = new Object();
  
  public static boolean zzV(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzLi != null) {
      return zzLi.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, AnalyticsReceiver.class, false);
    zzLi = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzf.zzX(paramContext);
    localzzaf = ((zzf)localObject).zziu();
    ??? = ???.getAction();
    if (((zzf)localObject).zziv().zzjA()) {
      localzzaf.zza("Device AnalyticsReceiver got", ???);
    }
    for (;;)
    {
      boolean bool;
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(???))
      {
        bool = AnalyticsService.zzW(paramContext);
        localObject = new Intent(paramContext, AnalyticsService.class);
        ((Intent)localObject).setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      }
      synchronized (zzpy)
      {
        paramContext.startService((Intent)localObject);
        if (!bool)
        {
          return;
          localzzaf.zza("Local AnalyticsReceiver got", ???);
          continue;
        }
        try
        {
          if (zzLh == null)
          {
            zzLh = new zzqy(paramContext, 1, "Analytics WakeLock");
            zzLh.setReferenceCounted(false);
          }
          zzLh.acquire(1000L);
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            localzzaf.zzbd("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
          }
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\AnalyticsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */