package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface ProxyApi
{
  public abstract PendingResult<ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest);
  
  public static abstract interface ProxyResult
    extends Result
  {
    public abstract ProxyResponse getResponse();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\proxy\ProxyApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */