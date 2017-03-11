package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc
  implements Parcelable.Creator<CustomProperty>
{
  static void zza(CustomProperty paramCustomProperty, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCustomProperty.mVersionCode);
    zzb.zza(paramParcel, 2, paramCustomProperty.zzamD, paramInt, false);
    zzb.zza(paramParcel, 3, paramCustomProperty.mValue, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CustomProperty zzbW(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    CustomPropertyKey localCustomPropertyKey = null;
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
        localCustomPropertyKey = (CustomPropertyKey)zza.zza(paramParcel, k, CustomPropertyKey.CREATOR);
        continue;
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CustomProperty(i, localCustomPropertyKey, str);
  }
  
  public CustomProperty[] zzdI(int paramInt)
  {
    return new CustomProperty[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */