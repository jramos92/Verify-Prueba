package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<StopProvidingContentRequest>
{
  static void zza(StopProvidingContentRequest paramStopProvidingContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStopProvidingContentRequest.versionCode);
    zzb.zza(paramParcel, 2, paramStopProvidingContentRequest.zzaRt);
    zzb.zza(paramParcel, 3, paramStopProvidingContentRequest.zzBd(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StopProvidingContentRequest zzgg(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    IBinder localIBinder = null;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StopProvidingContentRequest(i, l, localIBinder);
  }
  
  public StopProvidingContentRequest[] zziS(int paramInt)
  {
    return new StopProvidingContentRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */