package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.internal.zzx;

public final class zzqx
  implements Api.ApiOptions.Optional
{
  public static final zzqx zzaUZ = new zza().zzCi();
  private final boolean zzTi;
  private final boolean zzTk;
  private final String zzTl;
  private final boolean zzaVa;
  private final GoogleApiClient.ServerAuthCodeCallbacks zzaVb;
  private final boolean zzaVc;
  
  private zzqx(boolean paramBoolean1, boolean paramBoolean2, String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.zzaVa = paramBoolean1;
    this.zzTi = paramBoolean2;
    this.zzTl = paramString;
    this.zzaVb = paramServerAuthCodeCallbacks;
    this.zzaVc = paramBoolean3;
    this.zzTk = paramBoolean4;
  }
  
  public boolean zzCf()
  {
    return this.zzaVa;
  }
  
  public GoogleApiClient.ServerAuthCodeCallbacks zzCg()
  {
    return this.zzaVb;
  }
  
  public boolean zzCh()
  {
    return this.zzaVc;
  }
  
  public boolean zzlY()
  {
    return this.zzTi;
  }
  
  public boolean zzma()
  {
    return this.zzTk;
  }
  
  public String zzmb()
  {
    return this.zzTl;
  }
  
  public static final class zza
  {
    private String zzaSe;
    private boolean zzaVd;
    private boolean zzaVe;
    private GoogleApiClient.ServerAuthCodeCallbacks zzaVf;
    private boolean zzaVg;
    private boolean zzaVh;
    
    private String zzet(String paramString)
    {
      zzx.zzw(paramString);
      if ((this.zzaSe == null) || (this.zzaSe.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public zzqx zzCi()
    {
      return new zzqx(this.zzaVd, this.zzaVe, this.zzaSe, this.zzaVf, this.zzaVg, this.zzaVh, null);
    }
    
    public zza zza(String paramString, GoogleApiClient.ServerAuthCodeCallbacks paramServerAuthCodeCallbacks)
    {
      this.zzaVd = true;
      this.zzaVe = true;
      this.zzaSe = zzet(paramString);
      this.zzaVf = ((GoogleApiClient.ServerAuthCodeCallbacks)zzx.zzw(paramServerAuthCodeCallbacks));
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */