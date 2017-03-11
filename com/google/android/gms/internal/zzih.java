package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzgr
public class zzih
{
  private static zzl zzIZ;
  public static final zza<Void> zzJa = new zza()
  {
    public Void zzgL()
    {
      return null;
    }
    
    public Void zzi(InputStream paramAnonymousInputStream)
    {
      return null;
    }
  };
  private static final Object zzpy = new Object();
  
  public zzih(Context paramContext)
  {
    zzIZ = zzP(paramContext);
  }
  
  private static zzl zzP(Context paramContext)
  {
    synchronized (zzpy)
    {
      if (zzIZ == null) {
        zzIZ = zzac.zza(paramContext.getApplicationContext());
      }
      paramContext = zzIZ;
      return paramContext;
    }
  }
  
  public <T> zziq<T> zza(String paramString, zza<T> paramzza)
  {
    zzc localzzc = new zzc(null);
    zzIZ.zze(new zzb(paramString, paramzza, localzzc));
    return localzzc;
  }
  
  public zziq<String> zza(final String paramString, final Map<String, String> paramMap)
  {
    final zzc localzzc = new zzc(null);
    paramString = new zzab(paramString, localzzc, new zzm.zza()
    {
      public void zze(zzr paramAnonymouszzr)
      {
        zzb.zzaH("Failed to load URL: " + paramString + "\n" + paramAnonymouszzr.toString());
        localzzc.zzb(null);
      }
    })
    {
      public Map<String, String> getHeaders()
        throws zza
      {
        if (paramMap == null) {
          return super.getHeaders();
        }
        return paramMap;
      }
    };
    zzIZ.zze(paramString);
    return localzzc;
  }
  
  public static abstract interface zza<T>
  {
    public abstract T zzfF();
    
    public abstract T zzh(InputStream paramInputStream);
  }
  
  private static class zzb<T>
    extends zzk<InputStream>
  {
    private final zzih.zza<T> zzJe;
    private final zzm.zzb<T> zzaG;
    
    public zzb(String paramString, final zzih.zza<T> paramzza, zzm.zzb<T> paramzzb)
    {
      super(paramString, new zzm.zza()
      {
        public void zze(zzr paramAnonymouszzr)
        {
          zzih.zzb.this.zzb(paramzza.zzfF());
        }
      });
      this.zzJe = paramzza;
      this.zzaG = paramzzb;
    }
    
    protected zzm<InputStream> zza(zzi paramzzi)
    {
      return zzm.zza(new ByteArrayInputStream(paramzzi.data), zzx.zzb(paramzzi));
    }
    
    protected void zzj(InputStream paramInputStream)
    {
      this.zzaG.zzb(this.zzJe.zzh(paramInputStream));
    }
  }
  
  private class zzc<T>
    extends zzin<T>
    implements zzm.zzb<T>
  {
    private zzc() {}
    
    public void zzb(T paramT)
    {
      super.zzf(paramT);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */