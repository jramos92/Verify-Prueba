package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface CastRemoteDisplayApi
{
  public abstract PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient paramGoogleApiClient);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\CastRemoteDisplayApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */