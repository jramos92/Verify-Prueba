package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

public class zzad
  extends zzy
{
  private boolean zzOc;
  private final AlarmManager zzOd = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzad(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  private PendingIntent zzkm()
  {
    Intent localIntent = new Intent(getContext(), AppMeasurementReceiver.class);
    localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zziE();
    this.zzOc = false;
    this.zzOd.cancel(zzkm());
  }
  
  protected void zzhR()
  {
    this.zzOd.cancel(zzkm());
  }
  
  public void zzt(long paramLong)
  {
    zziE();
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      zzx.zza(AppMeasurementReceiver.zzV(getContext()), "Receiver not registered/enabled");
      zzx.zza(AppMeasurementService.zzW(getContext()), "Service not registered/enabled");
      cancel();
      long l = zzit().elapsedRealtime();
      this.zzOc = true;
      this.zzOd.setInexactRepeating(2, l + paramLong, 86400000L, zzkm());
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */