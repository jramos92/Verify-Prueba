package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ChannelReceiveFileResponse>
{
  static void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramChannelReceiveFileResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramChannelReceiveFileResponse.statusCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ChannelReceiveFileResponse zzhO(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ChannelReceiveFileResponse(i, j);
  }
  
  public ChannelReceiveFileResponse[] zzkX(int paramInt)
  {
    return new ChannelReceiveFileResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */