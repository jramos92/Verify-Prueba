package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import java.util.List;

public abstract interface SafetyNetApi
{
  public abstract PendingResult<AttestationResult> attest(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte);
  
  public abstract PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient paramGoogleApiClient, List<Integer> paramList, String paramString);
  
  public static abstract interface AttestationResult
    extends Result
  {
    public abstract String getJwsResult();
  }
  
  public static abstract interface SafeBrowsingResult
    extends Result
  {
    public abstract String getMetadata();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\safetynet\SafetyNetApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */