package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzpl
  extends zzj<zzpq>
{
  public zzpl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 69, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzpq zzdb(IBinder paramIBinder)
  {
    return zzpq.zza.zzdf(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */