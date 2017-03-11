package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<LatLngBounds>
{
  static void zza(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLatLngBounds.getVersionCode());
    zzb.zza(paramParcel, 2, paramLatLngBounds.southwest, paramInt, false);
    zzb.zza(paramParcel, 3, paramLatLngBounds.northeast, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LatLngBounds zzfk(Parcel paramParcel)
  {
    LatLng localLatLng1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    LatLng localLatLng2 = null;
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
        i = zza.zzg(paramParcel, k);
        continue;
        localLatLng2 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        continue;
        localLatLng1 = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LatLngBounds(i, localLatLng2, localLatLng1);
  }
  
  public LatLngBounds[] zzhI(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */