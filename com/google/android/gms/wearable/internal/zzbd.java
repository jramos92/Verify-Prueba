package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd
  implements Parcelable.Creator<OpenChannelResponse>
{
  static void zza(OpenChannelResponse paramOpenChannelResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOpenChannelResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramOpenChannelResponse.statusCode);
    zzb.zza(paramParcel, 3, paramOpenChannelResponse.zzbga, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OpenChannelResponse zzij(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    ChannelImpl localChannelImpl = null;
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
        localChannelImpl = (ChannelImpl)zza.zza(paramParcel, m, ChannelImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new OpenChannelResponse(i, j, localChannelImpl);
  }
  
  public OpenChannelResponse[] zzls(int paramInt)
  {
    return new OpenChannelResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */