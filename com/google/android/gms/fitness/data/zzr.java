package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<Subscription>
{
  static void zza(Subscription paramSubscription, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSubscription.getDataSource(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSubscription.getVersionCode());
    zzb.zza(paramParcel, 2, paramSubscription.getDataType(), paramInt, false);
    zzb.zza(paramParcel, 3, paramSubscription.zzsB());
    zzb.zzc(paramParcel, 4, paramSubscription.getAccuracyMode());
    zzb.zzI(paramParcel, i);
  }
  
  public Subscription zzcT(Parcel paramParcel)
  {
    DataType localDataType = null;
    int i = 0;
    int k = zza.zzap(paramParcel);
    long l = 0L;
    DataSource localDataSource = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        localDataSource = (DataSource)zza.zza(paramParcel, m, DataSource.CREATOR);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        localDataType = (DataType)zza.zza(paramParcel, m, DataType.CREATOR);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Subscription(j, localDataSource, localDataType, l, i);
  }
  
  public Subscription[] zzeK(int paramInt)
  {
    return new Subscription[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */