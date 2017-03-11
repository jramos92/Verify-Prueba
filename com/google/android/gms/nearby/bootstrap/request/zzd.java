package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd
  implements Parcelable.Creator<DisconnectRequest>
{
  static void zza(DisconnectRequest paramDisconnectRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDisconnectRequest.zzAI(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDisconnectRequest.versionCode);
    zzb.zza(paramParcel, 2, paramDisconnectRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public DisconnectRequest zzfF(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Device localDevice = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localDevice = (Device)zza.zza(paramParcel, k, Device.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DisconnectRequest(i, localDevice, localIBinder);
  }
  
  public DisconnectRequest[] zzil(int paramInt)
  {
    return new DisconnectRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */