package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzag;
import com.google.android.gms.measurement.internal.zzc;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzp.zza;
import com.google.android.gms.measurement.internal.zzu;
import com.google.android.gms.measurement.internal.zzv;
import com.google.android.gms.measurement.internal.zzw;

public final class AppMeasurementService
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
    boolean bool = zzag.zza(paramContext, AppMeasurementService.class);
    zzLj = Boolean.valueOf(bool);
    return bool;
  }
  
  private void zzhH()
  {
    try
    {
      synchronized (AppMeasurementReceiver.zzpy)
      {
        PowerManager.WakeLock localWakeLock = AppMeasurementReceiver.zzaKH;
        if ((localWakeLock != null) && (localWakeLock.isHeld())) {
          localWakeLock.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private zzp zzyd()
  {
    return zzv.zzaL(this).zzyd();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzyd().zzzK().zzec("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzw(zzv.zzaL(this));
    }
    zzyd().zzzL().zzj("onBind received unknown action", paramIntent);
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzv localzzv = zzv.zzaL(this);
    zzp localzzp = localzzv.zzyd();
    if (localzzv.zzzt().zzjA())
    {
      localzzp.zzzQ().zzec("Device AppMeasurementService is starting up");
      return;
    }
    localzzp.zzzQ().zzec("Local AppMeasurementService is starting up");
  }
  
  public void onDestroy()
  {
    zzv localzzv = zzv.zzaL(this);
    zzp localzzp = localzzv.zzyd();
    if (localzzv.zzzt().zzjA()) {
      localzzp.zzzQ().zzec("Device AppMeasurementService is shutting down");
    }
    for (;;)
    {
      super.onDestroy();
      return;
      localzzp.zzzQ().zzec("Local AppMeasurementService is shutting down");
    }
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzyd().zzzK().zzec("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzyd().zzzQ().zzj("onRebind called. action", paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzhH();
    final zzv localzzv = zzv.zzaL(this);
    final zzp localzzp = localzzv.zzyd();
    paramIntent = paramIntent.getAction();
    if (localzzv.zzzt().zzjA()) {
      localzzp.zzzQ().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
    for (;;)
    {
      if ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent)) {
        localzzv.zzzr().zzh(new Runnable()
        {
          public void run()
          {
            localzzv.zzAk();
            AppMeasurementService.zza(AppMeasurementService.this).post(new Runnable()
            {
              public void run()
              {
                if (AppMeasurementService.this.stopSelfResult(AppMeasurementService.1.this.zzLk))
                {
                  if (AppMeasurementService.1.this.zzaKI.zzzt().zzjA()) {
                    AppMeasurementService.1.this.zzaKJ.zzzQ().zzec("Device AppMeasurementService processed last upload request");
                  }
                }
                else {
                  return;
                }
                AppMeasurementService.1.this.zzaKJ.zzzQ().zzec("Local AppMeasurementService processed last upload request");
              }
            });
          }
        });
      }
      return 2;
      localzzp.zzzQ().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzyd().zzzK().zzec("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzyd().zzzQ().zzj("onUnbind called for intent. action", paramIntent);
    return true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */