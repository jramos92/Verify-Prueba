package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjw;

public final class AppInvite
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("AppInvite.API", zzRl, zzRk);
  public static final AppInviteApi AppInviteApi = new zzjv();
  public static final Api.zzc<zzjw> zzRk = new Api.zzc();
  private static final Api.zza<zzjw, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzjw zzb(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzjw(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appinvite\AppInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */