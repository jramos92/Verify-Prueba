package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<DataStatsResult>
{
  static void zza(DataStatsResult paramDataStatsResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataStatsResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataStatsResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramDataStatsResult.zztr(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public DataStatsResult zzdF(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Status localStatus = null;
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
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localArrayList = zza.zzc(paramParcel, k, DataSourceStatsResult.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataStatsResult(i, localStatus, localArrayList);
  }
  
  public DataStatsResult[] zzfx(int paramInt)
  {
    return new DataStatsResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */