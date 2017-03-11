package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzg
  implements Parcelable.Creator<DataSourceQueryParams>
{
  static void zza(DataSourceQueryParams paramDataSourceQueryParams, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataSourceQueryParams.zzapM, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataSourceQueryParams.mVersionCode);
    zzb.zza(paramParcel, 2, paramDataSourceQueryParams.zzRr);
    zzb.zza(paramParcel, 3, paramDataSourceQueryParams.zzaqc);
    zzb.zza(paramParcel, 4, paramDataSourceQueryParams.zzasr);
    zzb.zzc(paramParcel, 5, paramDataSourceQueryParams.zzasm);
    zzb.zzc(paramParcel, 6, paramDataSourceQueryParams.zzass);
    zzb.zzI(paramParcel, i);
  }
  
  public DataSourceQueryParams zzdc(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int m = zza.zzap(paramParcel);
    DataSource localDataSource = null;
    int j = 0;
    long l2 = 0L;
    long l3 = 0L;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        localDataSource = (DataSource)zza.zza(paramParcel, n, DataSource.CREATOR);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l3 = zza.zzi(paramParcel, n);
        break;
      case 3: 
        l2 = zza.zzi(paramParcel, n);
        break;
      case 4: 
        l1 = zza.zzi(paramParcel, n);
        break;
      case 5: 
        j = zza.zzg(paramParcel, n);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new DataSourceQueryParams(k, localDataSource, l3, l2, l1, j, i);
  }
  
  public DataSourceQueryParams[] zzeT(int paramInt)
  {
    return new DataSourceQueryParams[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */