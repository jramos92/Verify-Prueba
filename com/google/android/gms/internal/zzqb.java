package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzqb
  implements PanoramaApi.PanoramaResult
{
  private final Status zzSC;
  private final Intent zzaRB;
  
  public zzqb(Status paramStatus, Intent paramIntent)
  {
    this.zzSC = ((Status)zzx.zzw(paramStatus));
    this.zzaRB = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  public Intent getViewerIntent()
  {
    return this.zzaRB;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */