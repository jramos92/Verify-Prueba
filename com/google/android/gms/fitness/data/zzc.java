package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<Bucket>
{
  static void zza(Bucket paramBucket, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramBucket.zzkX());
    zzb.zzc(paramParcel, 1000, paramBucket.getVersionCode());
    zzb.zza(paramParcel, 2, paramBucket.zzsi());
    zzb.zza(paramParcel, 3, paramBucket.getSession(), paramInt, false);
    zzb.zzc(paramParcel, 4, paramBucket.zzsg());
    zzb.zzc(paramParcel, 5, paramBucket.getDataSets(), false);
    zzb.zzc(paramParcel, 6, paramBucket.getBucketType());
    zzb.zza(paramParcel, 7, paramBucket.zzsh());
    zzb.zzI(paramParcel, i);
  }
  
  public Bucket zzcG(Parcel paramParcel)
  {
    long l1 = 0L;
    ArrayList localArrayList = null;
    boolean bool = false;
    int m = zza.zzap(paramParcel);
    int i = 0;
    int j = 0;
    Session localSession = null;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l1 = zza.zzi(paramParcel, n);
        break;
      case 3: 
        localSession = (Session)zza.zza(paramParcel, n, Session.CREATOR);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList = zza.zzc(paramParcel, n, DataSet.CREATOR);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
        break;
      case 7: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new Bucket(k, l2, l1, localSession, j, localArrayList, i, bool);
  }
  
  public Bucket[] zzev(int paramInt)
  {
    return new Bucket[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */