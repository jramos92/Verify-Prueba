package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzjv
  implements AppInviteApi
{
  public PendingResult<Status> convertInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramString));
  }
  
  public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramString));
  }
  
  static abstract class zza<R extends Result>
    extends zzlb.zza<R, zzjw>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  final class zzb
    extends zzjv.zza<Status>
  {
    private final String zzRm;
    
    public zzb(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super();
      this.zzRm = paramString;
    }
    
    protected void zza(zzjw paramzzjw)
      throws RemoteException
    {
      paramzzjw.zzb(new zzjx.zza()
      {
        public void zze(Status paramAnonymousStatus)
          throws RemoteException
        {
          zzjv.zzb.this.zzb(paramAnonymousStatus);
        }
      }, this.zzRm);
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  final class zzc
    extends zzjv.zza<Status>
  {
    private final String zzRm;
    
    public zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super();
      this.zzRm = paramString;
    }
    
    protected void zza(zzjw paramzzjw)
      throws RemoteException
    {
      paramzzjw.zza(new zzjx.zza()
      {
        public void zze(Status paramAnonymousStatus)
          throws RemoteException
        {
          zzjv.zzc.this.zzb(paramAnonymousStatus);
        }
      }, this.zzRm);
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */