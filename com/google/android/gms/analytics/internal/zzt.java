package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.zzg;

abstract class zzt
{
  private static volatile Handler zzNX;
  private final zzf zzME;
  private volatile long zzNY;
  private boolean zzNZ;
  private final Runnable zzx;
  
  zzt(zzf paramzzf)
  {
    zzx.zzw(paramzzf);
    this.zzME = paramzzf;
    this.zzx = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zzt.zza(zzt.this).zziw().zzg(this);
        }
        boolean bool;
        do
        {
          return;
          bool = zzt.this.zzbp();
          zzt.zza(zzt.this, 0L);
        } while ((!bool) || (zzt.zzb(zzt.this)));
        zzt.this.run();
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
        zzNX = new Handler(this.zzME.getContext().getMainLooper());
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
  
  public long zzkh()
  {
    if (this.zzNY == 0L) {
      return 0L;
    }
    return Math.abs(this.zzME.zzit().currentTimeMillis() - this.zzNY);
  }
  
  public void zzt(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.zzNY = this.zzME.zzit().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzx, paramLong)) {
        this.zzME.zziu().zze("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public void zzu(long paramLong)
  {
    long l = 0L;
    if (!zzbp()) {
      return;
    }
    if (paramLong < 0L)
    {
      cancel();
      return;
    }
    paramLong -= Math.abs(this.zzME.zzit().currentTimeMillis() - this.zzNY);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      getHandler().removeCallbacks(this.zzx);
      if (getHandler().postDelayed(this.zzx, paramLong)) {
        break;
      }
      this.zzME.zziu().zze("Failed to adjust delayed post. time", Long.valueOf(paramLong));
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */