package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf
  implements Parcelable.Creator<SendDataRequest>
{
  static void zza(SendDataRequest paramSendDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSendDataRequest.zzAI(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSendDataRequest.versionCode);
    zzb.zza(paramParcel, 2, paramSendDataRequest.getData(), false);
    zzb.zza(paramParcel, 3, paramSendDataRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SendDataRequest zzfH(Parcel paramParcel)
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
        localObject3 = (Device)zza.zza(paramParcel, k, Device.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzs(paramParcel, k);
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
    return new SendDataRequest(i, (Device)localObject1, (byte[])localObject2, localIBinder);
  }
  
  public SendDataRequest[] zzin(int paramInt)
  {
    return new SendDataRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */