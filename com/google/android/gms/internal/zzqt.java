package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzqt
  implements SearchAuthApi
{
  public PendingResult<Status> clearToken(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramString));
  }
  
  public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.zza(new zzc(paramGoogleApiClient, paramString));
  }
  
  static abstract class zza
    extends zzqq.zza
  {
    public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      throw new UnsupportedOperationException();
    }
    
    public void zzbb(Status paramStatus)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static class zzb
    extends zzlb.zza<Status, zzqs>
  {
    private final GoogleApiClient zzVs;
    private final String zzaUN;
    private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);
    
    protected zzb(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.zzVs = paramGoogleApiClient;
      this.zzaUN = paramString;
    }
    
    protected void zza(zzqs paramzzqs)
      throws RemoteException
    {
      if (this.zzaUQ) {
        Log.d("SearchAuth", "ClearTokenImpl started");
      }
      String str = this.zzVs.getContext().getPackageName();
      zzqt.zza local1 = new zzqt.zza()
      {
        public void zzbb(Status paramAnonymousStatus)
        {
          if (zzqt.zzb.zza(zzqt.zzb.this)) {
            Log.d("SearchAuth", "ClearTokenImpl success");
          }
          zzqt.zzb.this.zzb(paramAnonymousStatus);
        }
      };
      ((zzqr)paramzzqs.zzpc()).zzb(local1, str, this.zzaUN);
    }
    
    protected Status zzd(Status paramStatus)
    {
      if (this.zzaUQ) {
        Log.d("SearchAuth", "ClearTokenImpl received failure: " + paramStatus.getStatusMessage());
      }
      return paramStatus;
    }
  }
  
  static class zzc
    extends zzlb.zza<SearchAuthApi.GoogleNowAuthResult, zzqs>
  {
    private final GoogleApiClient zzVs;
    private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);
    private final String zzaUS;
    
    protected zzc(GoogleApiClient paramGoogleApiClient, String paramString)
    {
      super(paramGoogleApiClient);
      this.zzVs = paramGoogleApiClient;
      this.zzaUS = paramString;
    }
    
    protected void zza(zzqs paramzzqs)
      throws RemoteException
    {
      if (this.zzaUQ) {
        Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
      }
      String str = this.zzVs.getContext().getPackageName();
      zzqt.zza local1 = new zzqt.zza()
      {
        public void zza(Status paramAnonymousStatus, GoogleNowAuthState paramAnonymousGoogleNowAuthState)
        {
          if (zzqt.zzc.zza(zzqt.zzc.this)) {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
          }
          zzqt.zzc.this.zzb(new zzqt.zzd(paramAnonymousStatus, paramAnonymousGoogleNowAuthState));
        }
      };
      ((zzqr)paramzzqs.zzpc()).zza(local1, str, this.zzaUS);
    }
    
    protected SearchAuthApi.GoogleNowAuthResult zzbc(Status paramStatus)
    {
      if (this.zzaUQ) {
        Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + paramStatus.getStatusMessage());
      }
      return new zzqt.zzd(paramStatus, null);
    }
  }
  
  static class zzd
    implements SearchAuthApi.GoogleNowAuthResult
  {
    private final Status zzSC;
    private final GoogleNowAuthState zzaUU;
    
    zzd(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    {
      this.zzSC = paramStatus;
      this.zzaUU = paramGoogleNowAuthState;
    }
    
    public GoogleNowAuthState getGoogleNowAuthState()
    {
      return this.zzaUU;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */