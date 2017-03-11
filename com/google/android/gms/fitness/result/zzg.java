package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzg
  implements Parcelable.Creator<DataTypeResult>
{
  static void zza(DataTypeResult paramDataTypeResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataTypeResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataTypeResult.getVersionCode());
    zzb.zza(paramParcel, 3, paramDataTypeResult.getDataType(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public DataTypeResult zzdG(Parcel paramParcel)
  {
    DataType localDataType = null;
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
        localDataType = (DataType)zza.zza(paramParcel, k, DataType.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataTypeResult(i, localStatus, localDataType);
  }
  
  public DataTypeResult[] zzfy(int paramInt)
  {
    return new DataTypeResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */