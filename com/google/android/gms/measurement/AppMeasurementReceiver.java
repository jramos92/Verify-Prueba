package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;
import com.google.android.gms.measurement.internal.zzv;

public final class AppMeasurementReceiver
  extends BroadcastReceiver
{
  static Boolean zzLi;
  static PowerManager.WakeLock zzaKH;
  static final Object zzpy = new Object();
  
  public static boolean zzV(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzLi != null) {
      return zzLi.booleanValue();
    }
    boolean bool = zzag.zza(paramContext, AppMeasurementReceiver.class, false);
    zzLi = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzv.zzaL(paramContext);
    localzzp = ((zzv)localObject).zzyd();
    ??? = ???.getAction();
    if (((zzv)localObject).zzzt().zzjA()) {
      localzzp.zzzQ().zzj("Device AppMeasurementReceiver got", ???);
    }
    for (;;)
    {
      boolean bool;
      if ("com.google.android.gms.measurement.UPLOAD".equals(???))
      {
        bool = AppMeasurementService.zzW(paramContext);
        localObject = new Intent(paramContext, AppMeasurementService.class);
        ((Intent)localObject).setAction("com.google.android.gms.measurement.UPLOAD");
      }
      synchronized (zzpy)
      {
        paramContext.startService((Intent)localObject);
        if (!bool)
        {
          return;
          localzzp.zzzQ().zzj("Local AppMeasurementReceiver got", ???);
          continue;
        }
        try
        {
          paramContext = (PowerManager)paramContext.getSystemService("power");
          if (zzaKH == null)
          {
            zzaKH = paramContext.newWakeLock(1, "AppMeasurement WakeLock");
            zzaKH.setReferenceCounted(false);
          }
          zzaKH.acquire(1000L);
        }
        catch (SecurityException paramContext)
        {
          for (;;)
          {
            localzzp.zzzL().zzec("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
          }
        }
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */