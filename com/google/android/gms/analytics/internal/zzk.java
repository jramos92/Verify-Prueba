package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzpb;
import com.google.android.gms.measurement.zzg;

public class zzk
  extends zzd
{
  private final zzpb zzNs = new zzpb();
  
  zzk(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void zzhM()
  {
    Object localObject = zzhQ();
    String str = ((zzan)localObject).zzkp();
    if (str != null) {
      this.zzNs.setAppName(str);
    }
    localObject = ((zzan)localObject).zzkr();
    if (localObject != null) {
      this.zzNs.setAppVersion((String)localObject);
    }
  }
  
  protected void zzhR()
  {
    zziw().zzyr().zza(this.zzNs);
    zzhM();
  }
  
  public zzpb zzjb()
  {
    zziE();
    return this.zzNs;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */