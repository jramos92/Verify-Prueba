package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzo
  implements Parcelable.Creator<RawDataSet>
{
  static void zza(RawDataSet paramRawDataSet, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramRawDataSet.zzaqU);
    zzb.zzc(paramParcel, 1000, paramRawDataSet.mVersionCode);
    zzb.zzc(paramParcel, 2, paramRawDataSet.zzaqW);
    zzb.zzc(paramParcel, 3, paramRawDataSet.zzaqX, false);
    zzb.zza(paramParcel, 4, paramRawDataSet.zzaqa);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RawDataSet zzcQ(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    int j = 0;
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
        j = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        i = zza.zzg(paramParcel, n);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, n, RawDataPoint.CREATOR);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new RawDataSet(k, j, i, localArrayList, bool);
  }
  
  public RawDataSet[] zzeG(int paramInt)
  {
    return new RawDataSet[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */