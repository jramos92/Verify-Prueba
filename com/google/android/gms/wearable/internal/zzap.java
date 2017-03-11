package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzap
  implements Parcelable.Creator<GetConfigsResponse>
{
  static void zza(GetConfigsResponse paramGetConfigsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetConfigsResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetConfigsResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetConfigsResponse.zzbgH, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetConfigsResponse zzic(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    ConnectionConfiguration[] arrayOfConnectionConfiguration = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        arrayOfConnectionConfiguration = (ConnectionConfiguration[])zza.zzb(paramParcel, m, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetConfigsResponse(i, j, arrayOfConnectionConfiguration);
  }
  
  public GetConfigsResponse[] zzll(int paramInt)
  {
    return new GetConfigsResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */