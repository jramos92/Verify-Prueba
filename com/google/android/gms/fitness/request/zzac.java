package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;

public class zzac
  implements Parcelable.Creator<SubscribeRequest>
{
  static void zza(SubscribeRequest paramSubscribeRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSubscribeRequest.zztl(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSubscribeRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSubscribeRequest.zztm());
    zzb.zza(paramParcel, 3, paramSubscribeRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SubscribeRequest zzdx(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    Subscription localSubscription = null;
    int i = 0;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localSubscription = (Subscription)zza.zza(paramParcel, k, Subscription.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        bool = zza.zzc(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SubscribeRequest(i, localSubscription, bool, localIBinder);
  }
  
  public SubscribeRequest[] zzfp(int paramInt)
  {
    return new SubscribeRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */