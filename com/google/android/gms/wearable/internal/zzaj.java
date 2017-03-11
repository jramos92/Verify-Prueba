package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaj
  implements Parcelable.Creator<GetChannelInputStreamResponse>
{
  static void zza(GetChannelInputStreamResponse paramGetChannelInputStreamResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetChannelInputStreamResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetChannelInputStreamResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetChannelInputStreamResponse.zzbgC, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetChannelInputStreamResponse zzhW(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetChannelInputStreamResponse(i, j, localParcelFileDescriptor);
  }
  
  public GetChannelInputStreamResponse[] zzlf(int paramInt)
  {
    return new GetChannelInputStreamResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */