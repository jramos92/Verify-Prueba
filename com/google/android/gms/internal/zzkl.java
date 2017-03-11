package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

abstract class zzkl
  extends zzlb.zza<ProxyApi.ProxyResult, zzki>
{
  public zzkl(GoogleApiClient paramGoogleApiClient)
  {
    super(Auth.zzRE, paramGoogleApiClient);
  }
  
  protected abstract void zza(Context paramContext, zzkk paramzzkk)
    throws RemoteException;
  
  protected final void zza(zzki paramzzki)
    throws RemoteException
  {
    zza(paramzzki.getContext(), (zzkk)paramzzki.zzpc());
  }
  
  protected ProxyApi.ProxyResult zzj(Status paramStatus)
  {
    return new zzkn(paramStatus);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */