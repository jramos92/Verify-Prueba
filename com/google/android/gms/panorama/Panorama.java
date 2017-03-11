package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqa;

public final class Panorama
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Panorama.API", zzRl, zzRk);
  public static final PanoramaApi PanoramaApi = new zzpz();
  public static final Api.zzc<zzqa> zzRk = new Api.zzc();
  static final Api.zza<zzqa, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzqa zzq(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzqa(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\panorama\Panorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */