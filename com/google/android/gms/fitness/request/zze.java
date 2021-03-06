package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zze
  implements Parcelable.Creator<DataInsertRequest>
{
  static void zza(DataInsertRequest paramDataInsertRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataInsertRequest.zzsA(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramDataInsertRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramDataInsertRequest.zzsO(), false);
    zzb.zza(paramParcel, 4, paramDataInsertRequest.zzsS());
    zzb.zzI(paramParcel, i);
  }
  
  public DataInsertRequest zzda(Parcel paramParcel)
  {
    Object localObject2 = null;
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    Object localObject1 = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      Object localObject3;
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = (DataSet)zza.zza(paramParcel, k, DataSet.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzq(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        bool = zza.zzc(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataInsertRequest(i, (DataSet)localObject1, (IBinder)localObject2, bool);
  }
  
  public DataInsertRequest[] zzeR(int paramInt)
  {
    return new DataInsertRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */