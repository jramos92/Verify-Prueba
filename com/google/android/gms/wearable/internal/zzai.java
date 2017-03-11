package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai
  implements Parcelable.Creator<GetCapabilityResponse>
{
  static void zza(GetCapabilityResponse paramGetCapabilityResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetCapabilityResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetCapabilityResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetCapabilityResponse.zzbgB, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetCapabilityResponse zzhV(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    CapabilityInfoParcelable localCapabilityInfoParcelable = null;
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
        localCapabilityInfoParcelable = (CapabilityInfoParcelable)zza.zza(paramParcel, m, CapabilityInfoParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetCapabilityResponse(i, j, localCapabilityInfoParcelable);
  }
  
  public GetCapabilityResponse[] zzle(int paramInt)
  {
    return new GetCapabilityResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */