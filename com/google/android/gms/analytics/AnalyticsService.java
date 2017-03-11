package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

public final class AnalyticsService
  extends Service
{
  private static Boolean zzLj;
  private final Handler mHandler = new Handler();
  
  public static boolean zzW(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzLj != null) {
      return zzLj.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, AnalyticsService.class);
    zzLj = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzhH()
  {
    try
    {
      synchronized (AnalyticsReceiver.zzpy)
      {
        zzqy localzzqy = AnalyticsReceiver.zzLh;
        if ((localzzqy != null) && (localzzqy.isHeld())) {
          localzzqy.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzf localzzf = zzf.zzX(this);
    zzaf localzzaf = localzzf.zziu();
    if (localzzf.zziv().zzjA())
    {
      localzzaf.zzba("Device AnalyticsService is starting up");
      return;
    }
    localzzaf.zzba("Local AnalyticsService is starting up");
  }
  
  public void onDestroy()
  {
    zzf localzzf = zzf.zzX(this);
    zzaf localzzaf = localzzf.zziu();
    if (localzzf.zziv().zzjA()) {
      localzzaf.zzba("Device AnalyticsService is shutting down");
    }
    for (;;)
    {
      super.onDestroy();
      return;
      localzzaf.zzba("Local AnalyticsService is shutting down");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzhH();
    final zzf localzzf = zzf.zzX(this);
    final zzaf localzzaf = localzzf.zziu();
    paramIntent = paramIntent.getAction();
    if (localzzf.zziv().zzjA()) {
      localzzaf.zza("Device AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
    for (;;)
    {
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent)) {
        localzzf.zzhP().zza(new zzw()
        {
          public void zzc(Throwable paramAnonymousThrowable)
          {
            AnalyticsService.zza(AnalyticsService.this).post(new Runnable()
            {
              public void run()
              {
                if (AnalyticsService.this.stopSelfResult(AnalyticsService.1.this.zzLk))
                {
                  if (AnalyticsService.1.this.zzLl.zziv().zzjA()) {
                    AnalyticsService.1.this.zzLm.zzba("Device AnalyticsService processed last dispatch request");
                  }
                }
                else {
                  return;
                }
                AnalyticsService.1.this.zzLm.zzba("Local AnalyticsService processed last dispatch request");
              }
            });
          }
        });
      }
      return 2;
      localzzaf.zza("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\AnalyticsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */