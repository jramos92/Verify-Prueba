package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<Feature>
{
  static void zza(Feature paramFeature, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFeature.id);
    zzb.zzc(paramParcel, 1000, paramFeature.mVersionCode);
    zzb.zza(paramParcel, 2, paramFeature.zzQn, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Feature[] zzah(int paramInt)
  {
    return new Feature[paramInt];
  }
  
  public Feature zzu(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    Bundle localBundle = null;
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
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Feature(i, j, localBundle);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */