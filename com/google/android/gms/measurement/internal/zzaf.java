package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf
  implements Parcelable.Creator<UserAttributeParcel>
{
  static void zza(UserAttributeParcel paramUserAttributeParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramUserAttributeParcel.versionCode);
    zzb.zza(paramParcel, 2, paramUserAttributeParcel.name, false);
    zzb.zza(paramParcel, 3, paramUserAttributeParcel.zzaOz);
    zzb.zza(paramParcel, 4, paramUserAttributeParcel.zzaOA, false);
    zzb.zza(paramParcel, 5, paramUserAttributeParcel.zzaOB, false);
    zzb.zza(paramParcel, 6, paramUserAttributeParcel.zzagS, false);
    zzb.zza(paramParcel, 7, paramUserAttributeParcel.zzaMl, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public UserAttributeParcel zzfA(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    String str2 = null;
    Float localFloat = null;
    Long localLong = null;
    String str3 = null;
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
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        l = zza.zzi(paramParcel, k);
        break;
      case 4: 
        localLong = zza.zzj(paramParcel, k);
        break;
      case 5: 
        localFloat = zza.zzm(paramParcel, k);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UserAttributeParcel(i, str3, l, localLong, localFloat, str2, str1);
  }
  
  public UserAttributeParcel[] zzig(int paramInt)
  {
    return new UserAttributeParcel[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */