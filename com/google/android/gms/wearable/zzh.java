package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<PutDataRequest>
{
  static void zza(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPutDataRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPutDataRequest.zzEM(), false);
    zzb.zza(paramParcel, 5, paramPutDataRequest.getData(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public PutDataRequest zzhG(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
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
      case 3: 
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
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzr(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        arrayOfByte = zza.zzs(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PutDataRequest(i, (Uri)localObject1, (Bundle)localObject2, arrayOfByte);
  }
  
  public PutDataRequest[] zzkM(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */