package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt
  implements Parcelable.Creator<SensorUnregistrationRequest>
{
  static void zza(SensorUnregistrationRequest paramSensorUnregistrationRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSensorUnregistrationRequest.zztf(), false);
    zzb.zzc(paramParcel, 1000, paramSensorUnregistrationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSensorUnregistrationRequest.zzta(), paramInt, false);
    zzb.zza(paramParcel, 3, paramSensorUnregistrationRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SensorUnregistrationRequest zzdo(Parcel paramParcel)
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
        localObject3 = zza.zzq(paramParcel, k);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
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
    return new SensorUnregistrationRequest(i, (IBinder)localObject1, (PendingIntent)localObject2, localIBinder);
  }
  
  public SensorUnregistrationRequest[] zzfg(int paramInt)
  {
    return new SensorUnregistrationRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */