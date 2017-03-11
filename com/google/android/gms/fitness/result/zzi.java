package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi
  implements Parcelable.Creator<ReadRawResult>
{
  static void zza(ReadRawResult paramReadRawResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramReadRawResult.zzrh(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramReadRawResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramReadRawResult.zzts(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public ReadRawResult zzdI(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localArrayList = zza.zzc(paramParcel, k, DataHolder.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ReadRawResult(i, localDataHolder, localArrayList);
  }
  
  public ReadRawResult[] zzfA(int paramInt)
  {
    return new ReadRawResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */