package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm
  implements zzp.zze
{
  private boolean mClosed;
  private final Context mContext;
  private final String zzaVQ;
  private String zzaWn;
  private zzbf<zzaf.zzj> zzaYk;
  private zzs zzaYl;
  private final ScheduledExecutorService zzaYn;
  private final zza zzaYo;
  private ScheduledFuture<?> zzaYp;
  
  public zzcm(Context paramContext, String paramString, zzs paramzzs)
  {
    this(paramContext, paramString, paramzzs, null, null);
  }
  
  zzcm(Context paramContext, String paramString, zzs paramzzs, zzb paramzzb, zza paramzza)
  {
    this.zzaYl = paramzzs;
    this.mContext = paramContext;
    this.zzaVQ = paramString;
    paramContext = paramzzb;
    if (paramzzb == null) {
      paramContext = new zzb()
      {
        public ScheduledExecutorService zzDt()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.zzaYn = paramContext.zzDt();
    if (paramzza == null)
    {
      this.zzaYo = new zza()
      {
        public zzcl zza(zzs paramAnonymouszzs)
        {
          return new zzcl(zzcm.zza(zzcm.this), zzcm.zzb(zzcm.this), paramAnonymouszzs);
        }
      };
      return;
    }
    this.zzaYo = paramzza;
  }
  
  private void zzDs()
  {
    try
    {
      if (this.mClosed) {
        throw new IllegalStateException("called method after closed");
      }
    }
    finally {}
  }
  
  private zzcl zzeX(String paramString)
  {
    zzcl localzzcl = this.zzaYo.zza(this.zzaYl);
    localzzcl.zza(this.zzaYk);
    localzzcl.zzeH(this.zzaWn);
    localzzcl.zzeW(paramString);
    return localzzcl;
  }
  
  public void release()
  {
    try
    {
      zzDs();
      if (this.zzaYp != null) {
        this.zzaYp.cancel(false);
      }
      this.zzaYn.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void zza(zzbf<zzaf.zzj> paramzzbf)
  {
    try
    {
      zzDs();
      this.zzaYk = paramzzbf;
      return;
    }
    finally
    {
      paramzzbf = finally;
      throw paramzzbf;
    }
  }
  
  public void zzeH(String paramString)
  {
    try
    {
      zzDs();
      this.zzaWn = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void zzf(long paramLong, String paramString)
  {
    try
    {
      zzbg.v("loadAfterDelay: containerId=" + this.zzaVQ + " delay=" + paramLong);
      zzDs();
      if (this.zzaYk == null) {
        throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
      }
    }
    finally {}
    if (this.zzaYp != null) {
      this.zzaYp.cancel(false);
    }
    this.zzaYp = this.zzaYn.schedule(zzeX(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  static abstract interface zza
  {
    public abstract zzcl zza(zzs paramzzs);
  }
  
  static abstract interface zzb
  {
    public abstract ScheduledExecutorService zzDt();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */