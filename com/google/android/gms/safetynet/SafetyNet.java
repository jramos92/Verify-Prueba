package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;

public final class SafetyNet
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("SafetyNet.API", zzRl, zzRk);
  public static final SafetyNetApi SafetyNetApi = new zzqn();
  public static final Api.zzc<zzqo> zzRk = new Api.zzc();
  public static final Api.zza<zzqo, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzqo zzr(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzqo(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzc zzaUC = new zzqp();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\safetynet\SafetyNet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */