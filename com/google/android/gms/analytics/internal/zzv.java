package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

public class zzv
  extends zzd
{
  private boolean zzOb;
  private boolean zzOc;
  private AlarmManager zzOd = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzv(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private PendingIntent zzkm()
  {
    Intent localIntent = new Intent(getContext(), AnalyticsReceiver.class);
    localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zziE();
    this.zzOc = false;
    this.zzOd.cancel(zzkm());
  }
  
  public boolean zzbp()
  {
    return this.zzOc;
  }
  
  protected void zzhR()
  {
    try
    {
      this.zzOd.cancel(zzkm());
      if (zziv().zzjJ() > 0L)
      {
        ActivityInfo localActivityInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), AnalyticsReceiver.class), 2);
        if ((localActivityInfo != null) && (localActivityInfo.enabled))
        {
          zzba("Receiver registered. Using alarm for local dispatch.");
          this.zzOb = true;
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
  }
  
  public boolean zzkk()
  {
    return this.zzOb;
  }
  
  public void zzkl()
  {
    zziE();
    zzx.zza(zzkk(), "Receiver not registered");
    long l1 = zziv().zzjJ();
    if (l1 > 0L)
    {
      cancel();
      long l2 = zzit().elapsedRealtime();
      this.zzOc = true;
      this.zzOd.setInexactRepeating(2, l2 + l1, 0L, zzkm());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */