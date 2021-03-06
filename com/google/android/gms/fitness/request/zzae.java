package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class zzae
  implements Parcelable.Creator<UnsubscribeRequest>
{
  static void zza(UnsubscribeRequest paramUnsubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramUnsubscribeRequest.getDataType(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramUnsubscribeRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramUnsubscribeRequest.getDataSource(), paramInt, false);
    zzb.zza(paramParcel, 3, paramUnsubscribeRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public UnsubscribeRequest zzdz(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
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
        localObject3 = (DataType)zza.zza(paramParcel, k, DataType.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (DataSource)zza.zza(paramParcel, k, DataSource.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localIBinder = zza.zzq(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UnsubscribeRequest(i, (DataType)localObject1, (DataSource)localObject2, localIBinder);
  }
  
  public UnsubscribeRequest[] zzfr(int paramInt)
  {
    return new UnsubscribeRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */