package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzqn
  implements SafetyNetApi
{
  public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient paramGoogleApiClient, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.zza(new zzb(paramGoogleApiClient)
    {
      protected void zza(zzqo paramAnonymouszzqo)
        throws RemoteException
      {
        paramAnonymouszzqo.zza(this.zzaUI, paramArrayOfByte);
      }
    });
  }
  
  public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient paramGoogleApiClient, final List<Integer> paramList, final String paramString)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("Null threatTypes in lookupUri");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Null or empty uri in lookupUri");
    }
    paramGoogleApiClient.zza(new zzc(paramGoogleApiClient)
    {
      protected void zza(zzqo paramAnonymouszzqo)
        throws RemoteException
      {
        paramAnonymouszzqo.zza(this.zzaUI, paramList, 1, paramString);
      }
    });
  }
  
  static class zza
    implements SafetyNetApi.AttestationResult
  {
    private final Status zzSC;
    private final AttestationData zzaUH;
    
    public zza(Status paramStatus, AttestationData paramAttestationData)
    {
      this.zzSC = paramStatus;
      this.zzaUH = paramAttestationData;
    }
    
    public String getJwsResult()
    {
      if (this.zzaUH == null) {
        return null;
      }
      return this.zzaUH.getJwsResult();
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  static abstract class zzb
    extends zzqk<SafetyNetApi.AttestationResult>
  {
    protected zzql zzaUI = new zzqj()
    {
      public void zza(Status paramAnonymousStatus, AttestationData paramAnonymousAttestationData)
      {
        zzqn.zzb.this.zzb(new zzqn.zza(paramAnonymousStatus, paramAnonymousAttestationData));
      }
    };
    
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected SafetyNetApi.AttestationResult zzaZ(Status paramStatus)
    {
      return new zzqn.zza(paramStatus, null);
    }
  }
  
  static abstract class zzc
    extends zzqk<SafetyNetApi.SafeBrowsingResult>
  {
    protected zzql zzaUI = new zzqj()
    {
      public void zza(Status paramAnonymousStatus, SafeBrowsingData paramAnonymousSafeBrowsingData)
      {
        zzqn.zzc.this.zzb(new zzqn.zzd(paramAnonymousStatus, paramAnonymousSafeBrowsingData));
      }
    };
    
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected SafetyNetApi.SafeBrowsingResult zzba(Status paramStatus)
    {
      return new zzqn.zzd(paramStatus, null);
    }
  }
  
  static class zzd
    implements SafetyNetApi.SafeBrowsingResult
  {
    private Status zzSC;
    private String zzaUB;
    private final SafeBrowsingData zzaUL;
    
    public zzd(Status paramStatus, SafeBrowsingData paramSafeBrowsingData)
    {
      this.zzSC = paramStatus;
      this.zzaUL = paramSafeBrowsingData;
      this.zzaUB = null;
      if (this.zzaUL != null) {
        this.zzaUB = this.zzaUL.getMetadata();
      }
      while (!this.zzSC.isSuccess()) {
        return;
      }
      this.zzSC = new Status(8);
    }
    
    public String getMetadata()
    {
      return this.zzaUB;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */