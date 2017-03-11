package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqt;

public class SearchAuth
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("SearchAuth.API", zzaUP, zzRk);
  public static final SearchAuthApi SearchAuthApi = new zzqt();
  public static final Api.zzc<zzqs> zzRk;
  private static final Api.zza<zzqs, Api.ApiOptions.NoOptions> zzaUP = new Api.zza()
  {
    public zzqs zzs(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzqs(paramAnonymousContext, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
    }
  };
  
  static
  {
    zzRk = new Api.zzc();
  }
  
  public static class StatusCodes
  {
    public static final int AUTH_DISABLED = 10000;
    public static final int AUTH_THROTTLED = 10001;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int SUCCESS = 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\search\SearchAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */