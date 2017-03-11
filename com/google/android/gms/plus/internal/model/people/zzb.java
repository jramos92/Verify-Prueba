package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.HashSet;
import java.util.Set;

public class zzb
  implements Parcelable.Creator<PersonEntity.AgeRangeEntity>
{
  static void zza(PersonEntity.AgeRangeEntity paramAgeRangeEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    Set localSet = paramAgeRangeEntity.zzaST;
    if (localSet.contains(Integer.valueOf(1))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAgeRangeEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramAgeRangeEntity.zzaUk);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramAgeRangeEntity.zzaUl);
    }
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.AgeRangeEntity zzgp(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new PersonEntity.AgeRangeEntity(localHashSet, i, j, k);
  }
  
  public PersonEntity.AgeRangeEntity[] zzjc(int paramInt)
  {
    return new PersonEntity.AgeRangeEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\people\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */