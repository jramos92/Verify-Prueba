package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<DataType>
{
  static void zza(DataType paramDataType, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataType.getName(), false);
    zzb.zzc(paramParcel, 1000, paramDataType.getVersionCode());
    zzb.zzc(paramParcel, 2, paramDataType.getFields(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DataType zzcK(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
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
        str = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList = zza.zzc(paramParcel, k, Field.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataType(i, str, localArrayList);
  }
  
  public DataType[] zzeA(int paramInt)
  {
    return new DataType[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */