package com.google.android.gms.appinvite;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface AppInviteApi
{
  public abstract PendingResult<Status> convertInvitation(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Status> updateInvitationOnInstall(GoogleApiClient paramGoogleApiClient, String paramString);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appinvite\AppInviteApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */