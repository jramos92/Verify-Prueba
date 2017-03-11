package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<NearbyDeviceFilter>
{
  static void zza(NearbyDeviceFilter paramNearbyDeviceFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramNearbyDeviceFilter.zzaQB);
    zzb.zzc(paramParcel, 1000, paramNearbyDeviceFilter.mVersionCode);
    zzb.zza(paramParcel, 2, paramNearbyDeviceFilter.zzaQC, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NearbyDeviceFilter zzfQ(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    byte[] arrayOfByte = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NearbyDeviceFilter(i, j, arrayOfByte);
  }
  
  public NearbyDeviceFilter[] zziC(int paramInt)
  {
    return new NearbyDeviceFilter[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */