package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<StreetViewPanoramaOrientation>
{
  static void zza(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStreetViewPanoramaOrientation.getVersionCode());
    zzb.zza(paramParcel, 2, paramStreetViewPanoramaOrientation.tilt);
    zzb.zza(paramParcel, 3, paramStreetViewPanoramaOrientation.bearing);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOrientation zzft(Parcel paramParcel)
  {
    float f2 = 0.0F;
    int j = zza.zzap(paramParcel);
    int i = 0;
    float f1 = 0.0F;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        f1 = zza.zzl(paramParcel, k);
        break;
      case 3: 
        f2 = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StreetViewPanoramaOrientation(i, f1, f2);
  }
  
  public StreetViewPanoramaOrientation[] zzhR(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */