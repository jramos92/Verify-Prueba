package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

class zze
  extends zzj<zzd>
{
  public zze(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 49, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzd zzdv(IBinder paramIBinder)
  {
    return zzd.zza.zzdu(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */