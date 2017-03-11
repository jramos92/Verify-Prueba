package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzf
  implements Parcelable.Creator<PersonEntity.ImageEntity>
{
  static void zza(PersonEntity.ImageEntity paramImageEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    Set localSet = paramImageEntity.zzaST;
    if (localSet.contains(Integer.valueOf(1))) {
      zzb.zzc(paramParcel, 1, paramImageEntity.mVersionCode);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzb.zza(paramParcel, 2, paramImageEntity.zzF, true);
    }
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PersonEntity.ImageEntity zzgt(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PersonEntity.ImageEntity(localHashSet, i, str);
  }
  
  public PersonEntity.ImageEntity[] zzjg(int paramInt)
  {
    return new PersonEntity.ImageEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\model\people\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */