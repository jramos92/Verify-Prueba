package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzlz
  implements zzly
{
  public PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzma.zza(paramGoogleApiClient)
    {
      protected void zza(zzmb paramAnonymouszzmb)
        throws RemoteException
      {
        ((zzmd)paramAnonymouszzmb.zzpc()).zza(new zzlz.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzlw
  {
    private final zzlb.zzb<Status> zzagy;
    
    public zza(zzlb.zzb<Status> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zzbN(int paramInt)
      throws RemoteException
    {
      this.zzagy.zzp(new Status(paramInt));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */