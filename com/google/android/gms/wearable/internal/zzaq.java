package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzaq
  implements Parcelable.Creator<GetConnectedNodesResponse>
{
  static void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetConnectedNodesResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetConnectedNodesResponse.statusCode);
    zzb.zzc(paramParcel, 3, paramGetConnectedNodesResponse.zzbgI, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetConnectedNodesResponse zzid(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, m, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetConnectedNodesResponse(i, j, localArrayList);
  }
  
  public GetConnectedNodesResponse[] zzlm(int paramInt)
  {
    return new GetConnectedNodesResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */