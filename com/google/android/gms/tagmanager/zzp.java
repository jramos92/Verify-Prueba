package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzqz.zza;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrb.zzc;

public class zzp
  extends zzlc<ContainerHolder>
{
  private final Context mContext;
  private final String zzaVQ;
  private long zzaVV;
  private final TagManager zzaWc;
  private final zzd zzaWf;
  private final zzcd zzaWg;
  private final int zzaWh;
  private zzf zzaWi;
  private zzra zzaWj;
  private volatile zzo zzaWk;
  private volatile boolean zzaWl;
  private zzaf.zzj zzaWm;
  private String zzaWn;
  private zze zzaWo;
  private zza zzaWp;
  private final Looper zzaaO;
  private final zzmn zzpW;
  
  zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzf paramzzf, zze paramzze, zzra paramzzra, zzmn paramzzmn, zzcd paramzzcd) {}
  
  public zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzs paramzzs)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new zzcn(paramContext, paramString), new zzcm(paramContext, paramString, paramzzs), new zzra(paramContext), zzmp.zzqt(), new zzbe(30, 900000L, 5000L, "refreshing", zzmp.zzqt()));
    this.zzaWj.zzfm(paramzzs.zzCE());
  }
  
  private boolean zzCB()
  {
    zzcb localzzcb = zzcb.zzDm();
    return ((localzzcb.zzDn() == zzcb.zza.zzaXZ) || (localzzcb.zzDn() == zzcb.zza.zzaYa)) && (this.zzaVQ.equals(localzzcb.getContainerId()));
  }
  
  /* Error */
  private void zzU(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/google/android/gms/tagmanager/zzp:zzaWo	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   6: ifnonnull +11 -> 17
    //   9: ldc -63
    //   11: invokestatic 198	com/google/android/gms/tagmanager/zzbg:zzaH	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 87	com/google/android/gms/tagmanager/zzp:zzaWo	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   21: lload_1
    //   22: aload_0
    //   23: getfield 101	com/google/android/gms/tagmanager/zzp:zzaWm	Lcom/google/android/gms/internal/zzaf$zzj;
    //   26: getfield 201	com/google/android/gms/internal/zzaf$zzj:zziS	Ljava/lang/String;
    //   29: invokeinterface 204 4 0
    //   34: goto -20 -> 14
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzp
    //   0	42	1	paramLong	long
    //   37	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	37	finally
    //   17	34	37	finally
  }
  
  private void zza(zzaf.zzj paramzzj)
  {
    try
    {
      if (this.zzaWi != null)
      {
        zzqz.zza localzza = new zzqz.zza();
        localzza.zzbai = this.zzaVV;
        localzza.zziR = new zzaf.zzf();
        localzza.zzbaj = paramzzj;
        this.zzaWi.zzb(localzza);
      }
      return;
    }
    finally
    {
      paramzzj = finally;
      throw paramzzj;
    }
  }
  
  private void zza(zzaf.zzj paramzzj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.zzaWl;
        if (paramBoolean) {
          return;
        }
        if ((isReady()) && (this.zzaWk == null)) {}
        this.zzaWm = paramzzj;
        this.zzaVV = paramLong;
        zzU(Math.max(0L, Math.min(43200000L, this.zzaVV + 43200000L - this.zzpW.currentTimeMillis())));
        paramzzj = new Container(this.mContext, this.zzaWc.getDataLayer(), this.zzaVQ, paramLong, paramzzj);
        if (this.zzaWk == null)
        {
          this.zzaWk = new zzo(this.zzaWc, this.zzaaO, paramzzj, this.zzaWf);
          if ((!isReady()) && (this.zzaWp.zzb(paramzzj))) {
            zzb(this.zzaWk);
          }
        }
        else
        {
          this.zzaWk.zza(paramzzj);
        }
      }
      finally {}
    }
  }
  
  private void zzar(final boolean paramBoolean)
  {
    this.zzaWi.zza(new zzb(null));
    this.zzaWo.zza(new zzc(null));
    zzrb.zzc localzzc = this.zzaWi.zzjs(this.zzaWh);
    if (localzzc != null) {
      this.zzaWk = new zzo(this.zzaWc, this.zzaaO, new Container(this.mContext, this.zzaWc.getDataLayer(), this.zzaVQ, 0L, localzzc), this.zzaWf);
    }
    this.zzaWp = new zza()
    {
      public boolean zzb(Container paramAnonymousContainer)
      {
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + 43200000L < zzp.zzc(zzp.this).currentTimeMillis()) {}
        }
        while (!paramAnonymousContainer.isDefault())
        {
          return true;
          return false;
        }
        return false;
      }
    };
    if (zzCB())
    {
      this.zzaWo.zzf(0L, "");
      return;
    }
    this.zzaWi.zzCD();
  }
  
  public void zzCA()
  {
    zzar(true);
  }
  
  String zzCv()
  {
    try
    {
      String str = this.zzaWn;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzCy()
  {
    Object localObject = this.zzaWi.zzjs(this.zzaWh);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.zzaWc.getDataLayer(), this.zzaVQ, 0L, (zzrb.zzc)localObject);
      zzb(new zzo(this.zzaWc, this.zzaaO, (Container)localObject, new zzo.zza()
      {
        public String zzCv()
        {
          return zzp.this.zzCv();
        }
        
        public void zzCx()
        {
          zzbg.zzaH("Refresh ignored: container loaded as default only.");
        }
        
        public void zzeE(String paramAnonymousString)
        {
          zzp.this.zzeE(paramAnonymousString);
        }
      }));
    }
    for (;;)
    {
      this.zzaWo = null;
      this.zzaWi = null;
      return;
      zzbg.e("Default was requested, but no default container was found");
      zzb(zzbf(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void zzCz()
  {
    zzar(false);
  }
  
  protected ContainerHolder zzbf(Status paramStatus)
  {
    if (this.zzaWk != null) {
      return this.zzaWk;
    }
    if (paramStatus == Status.zzabe) {
      zzbg.e("timer expired: setting result to failure");
    }
    return new zzo(paramStatus);
  }
  
  void zzeE(String paramString)
  {
    try
    {
      this.zzaWn = paramString;
      if (this.zzaWo != null) {
        this.zzaWo.zzeH(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract boolean zzb(Container paramContainer);
  }
  
  private class zzb
    implements zzbf<zzqz.zza>
  {
    private zzb() {}
    
    public void zzCC() {}
    
    public void zza(zzqz.zza paramzza)
    {
      zzaf.zzj localzzj;
      if (paramzza.zzbaj != null) {
        localzzj = paramzza.zzbaj;
      }
      for (;;)
      {
        zzp.zza(zzp.this, localzzj, paramzza.zzbai, true);
        return;
        zzaf.zzf localzzf = paramzza.zziR;
        localzzj = new zzaf.zzj();
        localzzj.zziR = localzzf;
        localzzj.zziQ = null;
        localzzj.zziS = localzzf.version;
      }
    }
    
    public void zza(zzbf.zza paramzza)
    {
      if (!zzp.zzd(zzp.this)) {
        zzp.zza(zzp.this, 0L);
      }
    }
  }
  
  private class zzc
    implements zzbf<zzaf.zzj>
  {
    private zzc() {}
    
    public void zzCC() {}
    
    public void zza(zzbf.zza arg1)
    {
      synchronized (zzp.this)
      {
        if (!zzp.this.isReady())
        {
          if (zzp.zzb(zzp.this) != null) {
            zzp.this.zzb(zzp.zzb(zzp.this));
          }
        }
        else
        {
          zzp.zza(zzp.this, 3600000L);
          return;
        }
        zzp.this.zzb(zzp.this.zzbf(Status.zzabe));
      }
    }
    
    public void zzb(zzaf.zzj paramzzj)
    {
      synchronized (zzp.this)
      {
        if (paramzzj.zziR == null)
        {
          if (zzp.zze(zzp.this).zziR == null)
          {
            zzbg.e("Current resource is null; network resource is also null");
            zzp.zza(zzp.this, 3600000L);
            return;
          }
          paramzzj.zziR = zzp.zze(zzp.this).zziR;
        }
        zzp.zza(zzp.this, paramzzj, zzp.zzc(zzp.this).currentTimeMillis(), false);
        zzbg.v("setting refresh time to current time: " + zzp.zzf(zzp.this));
        if (!zzp.zzg(zzp.this)) {
          zzp.zza(zzp.this, paramzzj);
        }
        return;
      }
    }
  }
  
  private class zzd
    implements zzo.zza
  {
    private zzd() {}
    
    public String zzCv()
    {
      return zzp.this.zzCv();
    }
    
    public void zzCx()
    {
      if (zzp.zza(zzp.this).zzkF()) {
        zzp.zza(zzp.this, 0L);
      }
    }
    
    public void zzeE(String paramString)
    {
      zzp.this.zzeE(paramString);
    }
  }
  
  static abstract interface zze
    extends Releasable
  {
    public abstract void zza(zzbf<zzaf.zzj> paramzzbf);
    
    public abstract void zzeH(String paramString);
    
    public abstract void zzf(long paramLong, String paramString);
  }
  
  static abstract interface zzf
    extends Releasable
  {
    public abstract void zzCD();
    
    public abstract void zza(zzbf<zzqz.zza> paramzzbf);
    
    public abstract void zzb(zzqz.zza paramzza);
    
    public abstract zzrb.zzc zzjs(int paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */