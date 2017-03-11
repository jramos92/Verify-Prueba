package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzm
  implements Parcelable.Creator<RawBucket>
{
  static void zza(RawBucket paramRawBucket, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramRawBucket.zzNY);
    zzb.zzc(paramParcel, 1000, paramRawBucket.mVersionCode);
    zzb.zza(paramParcel, 2, paramRawBucket.zzapN);
    zzb.zza(paramParcel, 3, paramRawBucket.zzapP, paramInt, false);
    zzb.zzc(paramParcel, 4, paramRawBucket.zzaqT);
    zzb.zzc(paramParcel, 5, paramRawBucket.zzapY, false);
    zzb.zzc(paramParcel, 6, paramRawBucket.zzapZ);
    zzb.zza(paramParcel, 7, paramRawBucket.zzaqa);
    zzb.zzI(paramParcel, i);
  }
  
  public RawBucket zzcO(Parcel paramParcel)
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
        localArrayList = zza.zzc(paramParcel, n, RawDataSet.CREATOR);
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
    return new RawBucket(k, l2, l1, localSession, j, localArrayList, i, bool);
  }
  
  public RawBucket[] zzeE(int paramInt)
  {
    return new RawBucket[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */