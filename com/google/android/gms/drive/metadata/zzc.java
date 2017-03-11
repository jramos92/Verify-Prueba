package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<CustomPropertyKey>
{
  static void zza(CustomPropertyKey paramCustomPropertyKey, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCustomPropertyKey.mVersionCode);
    zzb.zza(paramParcel, 2, paramCustomPropertyKey.zzue, false);
    zzb.zzc(paramParcel, 3, paramCustomPropertyKey.mVisibility);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CustomPropertyKey zzbU(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str = zza.zzp(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CustomPropertyKey(i, str, j);
  }
  
  public CustomPropertyKey[] zzdG(int paramInt)
  {
    return new CustomPropertyKey[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */