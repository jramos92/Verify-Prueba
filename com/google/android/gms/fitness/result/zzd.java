package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd
  implements Parcelable.Creator<DataSourceStatsResult>
{
  static void zza(DataSourceStatsResult paramDataSourceStatsResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataSourceStatsResult.zzapM, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataSourceStatsResult.mVersionCode);
    zzb.zza(paramParcel, 2, paramDataSourceStatsResult.zzRr);
    zzb.zza(paramParcel, 3, paramDataSourceStatsResult.zzatg);
    zzb.zza(paramParcel, 4, paramDataSourceStatsResult.zzath);
    zzb.zza(paramParcel, 5, paramDataSourceStatsResult.zzati);
    zzb.zzI(paramParcel, i);
  }
  
  public DataSourceStatsResult zzdD(Parcel paramParcel)
  {
    boolean bool = false;
    long l1 = 0L;
    int j = zza.zzap(paramParcel);
    DataSource localDataSource = null;
    long l2 = 0L;
    long l3 = 0L;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localDataSource = (DataSource)zza.zza(paramParcel, k, DataSource.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        l3 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 4: 
        l2 = zza.zzi(paramParcel, k);
        break;
      case 5: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataSourceStatsResult(i, localDataSource, l3, bool, l2, l1);
  }
  
  public DataSourceStatsResult[] zzfv(int paramInt)
  {
    return new DataSourceStatsResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */