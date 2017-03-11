package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzjs
  extends zzj<zzjp>
{
  public zzjs(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 19, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzjp zzai(IBinder paramIBinder)
  {
    return zzjp.zza.zzag(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }
  
  public zzjp zzlw()
    throws DeadObjectException
  {
    return (zzjp)zzpc();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */