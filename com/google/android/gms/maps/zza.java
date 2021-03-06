package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;

public class zza
  implements Parcelable.Creator<GoogleMapOptions>
{
  static void zza(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGoogleMapOptions.getVersionCode());
    zzb.zza(paramParcel, 2, paramGoogleMapOptions.zzxz());
    zzb.zza(paramParcel, 3, paramGoogleMapOptions.zzxA());
    zzb.zzc(paramParcel, 4, paramGoogleMapOptions.getMapType());
    zzb.zza(paramParcel, 5, paramGoogleMapOptions.getCamera(), paramInt, false);
    zzb.zza(paramParcel, 6, paramGoogleMapOptions.zzxB());
    zzb.zza(paramParcel, 7, paramGoogleMapOptions.zzxC());
    zzb.zza(paramParcel, 8, paramGoogleMapOptions.zzxD());
    zzb.zza(paramParcel, 9, paramGoogleMapOptions.zzxE());
    zzb.zza(paramParcel, 10, paramGoogleMapOptions.zzxF());
    zzb.zza(paramParcel, 11, paramGoogleMapOptions.zzxG());
    zzb.zza(paramParcel, 12, paramGoogleMapOptions.zzxH());
    zzb.zza(paramParcel, 14, paramGoogleMapOptions.zzxI());
    zzb.zza(paramParcel, 15, paramGoogleMapOptions.zzxJ());
    zzb.zzI(paramParcel, i);
  }
  
  public GoogleMapOptions zzff(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int j = 0;
    byte b11 = -1;
    byte b10 = -1;
    int i = 0;
    CameraPosition localCameraPosition = null;
    byte b9 = -1;
    byte b8 = -1;
    byte b7 = -1;
    byte b6 = -1;
    byte b5 = -1;
    byte b4 = -1;
    byte b3 = -1;
    byte b2 = -1;
    byte b1 = -1;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(m))
      {
      case 13: 
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        b11 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 3: 
        b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 4: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 5: 
        localCameraPosition = (CameraPosition)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, CameraPosition.CREATOR);
        break;
      case 6: 
        b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 7: 
        b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 8: 
        b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 9: 
        b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 10: 
        b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 11: 
        b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 12: 
        b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 14: 
        b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
        break;
      case 15: 
        b1 = com.google.android.gms.common.internal.safeparcel.zza.zze(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GoogleMapOptions(j, b11, b10, i, localCameraPosition, b9, b8, b7, b6, b5, b4, b3, b2, b1);
  }
  
  public GoogleMapOptions[] zzhD(int paramInt)
  {
    return new GoogleMapOptions[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */