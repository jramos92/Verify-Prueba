package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb
  implements Parcelable.Creator<StreetViewPanoramaOptions>
{
  static void zza(StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramStreetViewPanoramaOptions.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramStreetViewPanoramaOptions.getStreetViewPanoramaCamera(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramStreetViewPanoramaOptions.getPanoramaId(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramStreetViewPanoramaOptions.getPosition(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramStreetViewPanoramaOptions.getRadius(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramStreetViewPanoramaOptions.zzxP());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramStreetViewPanoramaOptions.zzxE());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, paramStreetViewPanoramaOptions.zzxQ());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, paramStreetViewPanoramaOptions.zzxR());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, paramStreetViewPanoramaOptions.zzxA());
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public StreetViewPanoramaOptions zzfg(Parcel paramParcel)
  {
    Integer localInteger = null;
    byte b1 = 0;
    int j = zza.zzap(paramParcel);
    byte b2 = 0;
    byte b3 = 0;
    byte b4 = 0;
    byte b5 = 0;
    LatLng localLatLng = null;
    String str = null;
    StreetViewPanoramaCamera localStreetViewPanoramaCamera = null;
    int i = 0;
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
        localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)zza.zza(paramParcel, k, StreetViewPanoramaCamera.CREATOR);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localLatLng = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 5: 
        localInteger = zza.zzh(paramParcel, k);
        break;
      case 6: 
        b5 = zza.zze(paramParcel, k);
        break;
      case 7: 
        b4 = zza.zze(paramParcel, k);
        break;
      case 8: 
        b3 = zza.zze(paramParcel, k);
        break;
      case 9: 
        b2 = zza.zze(paramParcel, k);
        break;
      case 10: 
        b1 = zza.zze(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StreetViewPanoramaOptions(i, localStreetViewPanoramaCamera, str, localLatLng, localInteger, b5, b4, b3, b2, b1);
  }
  
  public StreetViewPanoramaOptions[] zzhE(int paramInt)
  {
    return new StreetViewPanoramaOptions[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */