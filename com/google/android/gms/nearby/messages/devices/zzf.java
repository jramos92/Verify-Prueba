package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<NearbyDevice>
{
  static void zza(NearbyDevice paramNearbyDevice, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramNearbyDevice.zzBc(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramNearbyDevice.mVersionCode);
    zzb.zzI(paramParcel, i);
  }
  
  public NearbyDevice zzfP(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    NearbyDeviceId localNearbyDeviceId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localNearbyDeviceId = (NearbyDeviceId)zza.zza(paramParcel, k, NearbyDeviceId.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new NearbyDevice(i, localNearbyDeviceId);
  }
  
  public NearbyDevice[] zziB(int paramInt)
  {
    return new NearbyDevice[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */