package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<FitnessDataSourcesRequest>
{
  static void zza(FitnessDataSourcesRequest paramFitnessDataSourcesRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFitnessDataSourcesRequest.getDataTypes(), false);
    zzb.zzc(paramParcel, 1000, paramFitnessDataSourcesRequest.getVersionCode());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public FitnessDataSourcesRequest zzcV(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k, DataType.CREATOR);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FitnessDataSourcesRequest(i, localArrayList);
  }
  
  public FitnessDataSourcesRequest[] zzeM(int paramInt)
  {
    return new FitnessDataSourcesRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\internal\service\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */