package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzp
  implements Parcelable.Creator<ListSubscriptionsRequest>
{
  static void zza(ListSubscriptionsRequest paramListSubscriptionsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramListSubscriptionsRequest.getDataType(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramListSubscriptionsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramListSubscriptionsRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public ListSubscriptionsRequest zzdk(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    DataType localDataType = null;
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
        localDataType = (DataType)zza.zza(paramParcel, k, DataType.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ListSubscriptionsRequest(i, localDataType, localIBinder);
  }
  
  public ListSubscriptionsRequest[] zzfb(int paramInt)
  {
    return new ListSubscriptionsRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */