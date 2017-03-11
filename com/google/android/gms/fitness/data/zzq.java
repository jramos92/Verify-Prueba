package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<SessionDataSet>
{
  static void zza(SessionDataSet paramSessionDataSet, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionDataSet.getSession(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionDataSet.mVersionCode);
    zzb.zza(paramParcel, 2, paramSessionDataSet.zzsA(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionDataSet zzcS(Parcel paramParcel)
  {
    DataSet localDataSet = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Session localSession = null;
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
        localSession = (Session)zza.zza(paramParcel, k, Session.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localDataSet = (DataSet)zza.zza(paramParcel, k, DataSet.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionDataSet(i, localSession, localDataSet);
  }
  
  public SessionDataSet[] zzeJ(int paramInt)
  {
    return new SessionDataSet[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */