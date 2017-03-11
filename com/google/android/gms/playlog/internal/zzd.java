package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzqd.zza;

public class zzd
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzf zzaRE;
  private final zzqd.zza zzaRP;
  private boolean zzaRQ;
  
  public zzd(zzqd.zza paramzza)
  {
    this.zzaRP = paramzza;
    this.zzaRE = null;
    this.zzaRQ = true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    this.zzaRE.zzap(false);
    if ((this.zzaRQ) && (this.zzaRP != null)) {
      this.zzaRP.zzBr();
    }
    this.zzaRQ = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzaRE.zzap(true);
    if ((this.zzaRQ) && (this.zzaRP != null))
    {
      if (!paramConnectionResult.hasResolution()) {
        break label48;
      }
      this.zzaRP.zzf(paramConnectionResult.getResolution());
    }
    for (;;)
    {
      this.zzaRQ = false;
      return;
      label48:
      this.zzaRP.zzBs();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zzaRE.zzap(true);
  }
  
  public void zza(zzf paramzzf)
  {
    this.zzaRE = paramzzf;
  }
  
  public void zzao(boolean paramBoolean)
  {
    this.zzaRQ = paramBoolean;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\playlog\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */