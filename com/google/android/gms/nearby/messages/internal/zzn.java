package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Strategy;

public class zzn
  implements Parcelable.Creator<PublishRequest>
{
  static void zza(PublishRequest paramPublishRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPublishRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramPublishRequest.zzaQY, paramInt, false);
    zzb.zza(paramParcel, 3, paramPublishRequest.zzaQZ, paramInt, false);
    zzb.zza(paramParcel, 4, paramPublishRequest.zzBd(), false);
    zzb.zza(paramParcel, 5, paramPublishRequest.zzaQe, false);
    zzb.zza(paramParcel, 6, paramPublishRequest.zzaRa, false);
    zzb.zza(paramParcel, 7, paramPublishRequest.zzaQf);
    zzb.zza(paramParcel, 8, paramPublishRequest.zzBe(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public PublishRequest zzfV(Parcel paramParcel)
  {
    boolean bool = false;
    IBinder localIBinder1 = null;
    int j = zza.zzap(paramParcel);
    String str1 = null;
    String str2 = null;
    IBinder localIBinder2 = null;
    Strategy localStrategy = null;
    MessageWrapper localMessageWrapper = null;
    int i = 0;
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
        localStrategy = (Strategy)zza.zza(paramParcel, k, Strategy.CREATOR);
        break;
      case 4: 
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 5: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 8: 
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PublishRequest(i, localMessageWrapper, localStrategy, localIBinder2, str2, str1, bool, localIBinder1);
  }
  
  public PublishRequest[] zziH(int paramInt)
  {
    return new PublishRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */