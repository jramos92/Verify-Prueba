package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzqa
  extends zzj<zzpy>
{
  public zzqa(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 3, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public zzpy zzdy(IBinder paramIBinder)
  {
    return zzpy.zza.zzdx(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */