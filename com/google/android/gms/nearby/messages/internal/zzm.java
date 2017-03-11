package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;

final class zzm
  extends zzc.zza
{
  private final zzlb.zzb<Status> zzaQX;
  
  private zzm(zzlb.zzb<Status> paramzzb)
  {
    this.zzaQX = paramzzb;
  }
  
  static zzm zzi(zzlb.zzb<Status> paramzzb)
  {
    return new zzm(paramzzb);
  }
  
  public void zzaT(Status paramStatus)
    throws RemoteException
  {
    this.zzaQX.zzp(paramStatus);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */