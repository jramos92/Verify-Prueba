package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

public class zzg
{
  private final Context zzMX;
  private final Context zzqZ;
  
  public zzg(Context paramContext)
  {
    zzx.zzw(paramContext);
    paramContext = paramContext.getApplicationContext();
    zzx.zzb(paramContext, "Application context can't be null");
    this.zzqZ = paramContext;
    this.zzMX = paramContext;
  }
  
  public Context getApplicationContext()
  {
    return this.zzqZ;
  }
  
  protected com.google.android.gms.measurement.zzg zzY(Context paramContext)
  {
    return com.google.android.gms.measurement.zzg.zzaJ(paramContext);
  }
  
  protected zzu zza(zzf paramzzf)
  {
    return new zzu(paramzzf);
  }
  
  protected zzk zzb(zzf paramzzf)
  {
    return new zzk(paramzzf);
  }
  
  protected zza zzc(zzf paramzzf)
  {
    return new zza(paramzzf);
  }
  
  protected zzn zzd(zzf paramzzf)
  {
    return new zzn(paramzzf);
  }
  
  protected zzan zze(zzf paramzzf)
  {
    return new zzan(paramzzf);
  }
  
  protected zzaf zzf(zzf paramzzf)
  {
    return new zzaf(paramzzf);
  }
  
  protected zzr zzg(zzf paramzzf)
  {
    return new zzr(paramzzf);
  }
  
  protected zzmn zzh(zzf paramzzf)
  {
    return zzmp.zzqt();
  }
  
  protected GoogleAnalytics zzi(zzf paramzzf)
  {
    return new GoogleAnalytics(paramzzf);
  }
  
  public Context zziG()
  {
    return this.zzMX;
  }
  
  zzl zzj(zzf paramzzf)
  {
    return new zzl(paramzzf, this);
  }
  
  zzag zzk(zzf paramzzf)
  {
    return new zzag(paramzzf);
  }
  
  protected zzb zzl(zzf paramzzf)
  {
    return new zzb(paramzzf, this);
  }
  
  public zzj zzm(zzf paramzzf)
  {
    return new zzj(paramzzf);
  }
  
  public zzah zzn(zzf paramzzf)
  {
    return new zzah(paramzzf);
  }
  
  public zzi zzo(zzf paramzzf)
  {
    return new zzi(paramzzf);
  }
  
  public zzv zzp(zzf paramzzf)
  {
    return new zzv(paramzzf);
  }
  
  public zzai zzq(zzf paramzzf)
  {
    return new zzai(paramzzf);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */