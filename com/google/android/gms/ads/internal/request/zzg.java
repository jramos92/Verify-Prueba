package com.google.android.gms.ads.internal.request;

import java.lang.ref.WeakReference;

public final class zzg
  extends zzk.zza
{
  private final WeakReference<zzc.zza> zzEI;
  
  public zzg(zzc.zza paramzza)
  {
    this.zzEI = new WeakReference(paramzza);
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    zzc.zza localzza = (zzc.zza)this.zzEI.get();
    if (localzza != null) {
      localzza.zzb(paramAdResponseParcel);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */