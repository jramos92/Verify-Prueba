package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzb
  extends zzj<zze>
{
  private final GoogleSignInConfig zzTn;
  
  public zzb(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleSignInConfig paramGoogleSignInConfig, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInConfig != null) {}
    for (;;)
    {
      this.zzTn = paramGoogleSignInConfig;
      return;
      paramGoogleSignInConfig = GoogleSignInConfig.zzTh;
    }
  }
  
  protected zze zzax(IBinder paramIBinder)
  {
    return zze.zza.zzaz(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */