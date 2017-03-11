package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<DataSet>
{
  static void zza(DataSet paramDataSet, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataSet.getDataSource(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataSet.getVersionCode());
    zzb.zza(paramParcel, 2, paramDataSet.getDataType(), paramInt, false);
    zzb.zzd(paramParcel, 3, paramDataSet.zzsp(), false);
    zzb.zzc(paramParcel, 4, paramDataSet.zzsq(), false);
    zzb.zza(paramParcel, 5, paramDataSet.zzsh());
    zzb.zzI(paramParcel, i);
  }
  
  public DataSet zzcI(Parcel paramParcel)
  {
    boolean bool = false;
    ArrayList localArrayList1 = null;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList2 = new ArrayList();
    DataType localDataType = null;
    DataSource localDataSource = null;
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
        localDataType = (DataType)zza.zza(paramParcel, k, DataType.CREATOR);
        break;
      case 3: 
        zza.zza(paramParcel, k, localArrayList2, getClass().getClassLoader());
        break;
      case 4: 
        localArrayList1 = zza.zzc(paramParcel, k, DataSource.CREATOR);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataSet(i, localDataSource, localDataType, localArrayList2, localArrayList1, bool);
  }
  
  public DataSet[] zzey(int paramInt)
  {
    return new DataSet[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */