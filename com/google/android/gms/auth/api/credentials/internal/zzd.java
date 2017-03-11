package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlb.zza;

abstract class zzd<R extends Result>
  extends zzlb.zza<R, zze>
{
  zzd(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.zzRF, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzh paramzzh)
    throws DeadObjectException, RemoteException;
  
  protected final void zza(zze paramzze)
    throws DeadObjectException, RemoteException
  {
    zza(paramzze.getContext(), (zzh)paramzze.zzpc());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */