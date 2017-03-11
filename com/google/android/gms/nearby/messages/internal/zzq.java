package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<UnpublishRequest>
{
  static void zza(UnpublishRequest paramUnpublishRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramUnpublishRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramUnpublishRequest.zzaQY, paramInt, false);
    zzb.zza(paramParcel, 3, paramUnpublishRequest.zzBd(), false);
    zzb.zza(paramParcel, 4, paramUnpublishRequest.zzaQe, false);
    zzb.zza(paramParcel, 5, paramUnpublishRequest.zzaRa, false);
    zzb.zzI(paramParcel, i);
  }
  
  public UnpublishRequest zzfY(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    IBinder localIBinder = null;
    MessageWrapper localMessageWrapper = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localMessageWrapper = (MessageWrapper)zza.zza(paramParcel, k, MessageWrapper.CREATOR);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UnpublishRequest(i, localMessageWrapper, localIBinder, str2, str1);
  }
  
  public UnpublishRequest[] zziK(int paramInt)
  {
    return new UnpublishRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */