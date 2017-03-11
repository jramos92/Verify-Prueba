package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzo
  extends zzj<zzm>
{
  public zzo(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 93, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public zzm zzda(IBinder paramIBinder)
  {
    return zzm.zza.zzcZ(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.measurement.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */