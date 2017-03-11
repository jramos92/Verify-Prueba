package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;

public class zzbt
  extends zzd
{
  private final zzlb.zzb<Status> zzagy;
  
  public zzbt(zzlb.zzb<Status> paramzzb)
  {
    this.zzagy = paramzzb;
  }
  
  public void onSuccess()
    throws RemoteException
  {
    this.zzagy.zzp(Status.zzabb);
  }
  
  public void zzy(Status paramStatus)
    throws RemoteException
  {
    this.zzagy.zzp(paramStatus);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */