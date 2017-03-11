package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zza;

public abstract class zzb<R extends Result>
  extends zzlb.zza<R, zze>
{
  public zzb(GoogleApiClient paramGoogleApiClient)
  {
    super(zzk.zzRk, paramGoogleApiClient);
  }
  
  public void zzba(int paramInt)
  {
    zzb(zzb(new Status(paramInt)));
  }
  
  public void zze(int paramInt, String paramString)
  {
    zzb(zzb(new Status(paramInt, paramString, null)));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */