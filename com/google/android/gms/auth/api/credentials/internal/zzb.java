package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzb
  implements CredentialRequestResult
{
  private final Status zzSC;
  private final Credential zzSD;
  
  public zzb(Status paramStatus, Credential paramCredential)
  {
    this.zzSC = paramStatus;
    this.zzSD = paramCredential;
  }
  
  public static zzb zzh(Status paramStatus)
  {
    return new zzb(paramStatus, null);
  }
  
  public Credential getCredential()
  {
    return this.zzSD;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */