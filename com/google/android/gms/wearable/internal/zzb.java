package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;

final class zzb<T>
  extends zzi<Status>
{
  private T mListener;
  private zzlm<T> zzaPH;
  private zza<T> zzbfy;
  
  private zzb(GoogleApiClient paramGoogleApiClient, T paramT, zzlm<T> paramzzlm, zza<T> paramzza)
  {
    super(paramGoogleApiClient);
    this.mListener = zzx.zzw(paramT);
    this.zzaPH = ((zzlm)zzx.zzw(paramzzlm));
    this.zzbfy = ((zza)zzx.zzw(paramzza));
  }
  
  static <T> PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zza<T> paramzza, T paramT)
  {
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramT, paramGoogleApiClient.zzo(paramT), paramzza));
  }
  
  protected void zza(zzbo paramzzbo)
    throws RemoteException
  {
    this.zzbfy.zza(paramzzbo, this, this.mListener, this.zzaPH);
    this.mListener = null;
    this.zzaPH = null;
  }
  
  protected Status zzd(Status paramStatus)
  {
    this.mListener = null;
    this.zzaPH = null;
    return paramStatus;
  }
  
  static abstract interface zza<T>
  {
    public abstract void zza(zzbo paramzzbo, zzlb.zzb<Status> paramzzb, T paramT, zzlm<T> paramzzlm)
      throws RemoteException;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */