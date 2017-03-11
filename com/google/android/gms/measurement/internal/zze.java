package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

abstract class zze
{
  private static volatile Handler zzNX;
  private volatile long zzNY;
  private final zzv zzaKG;
  private boolean zzaLX;
  private final Runnable zzx;
  
  zze(zzv paramzzv)
  {
    zzx.zzw(paramzzv);
    this.zzaKG = paramzzv;
    this.zzaLX = true;
    this.zzx = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zze.zza(zze.this).zzzr().zzh(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zze.this.zzbp();
          zze.zza(zze.this, 0L);
        } while ((!bool) || (!zze.zzb(zze.this)));
        zze.this.run();
      }
    };
  }
  
  private Handler getHandler()
  {
    if (zzNX != null) {
      return zzNX;
    }
    try
    {
      if (zzNX == null) {
        zzNX = new Handler(this.zzaKG.getContext().getMainLooper());
      }
      Handler localHandler = zzNX;
      return localHandler;
    }
    finally {}
  }
  
  public void cancel()
  {
    this.zzNY = 0L;
    getHandler().removeCallbacks(this.zzx);
  }
  
  public abstract void run();
  
  public boolean zzbp()
  {
    return this.zzNY != 0L;
  }
  
  public void zzt(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzNY = this.zzaKG.zzit().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzx, paramLong)) {
        this.zzaKG.zzyd().zzzK().zzj("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */