package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab
  implements Parcelable.Creator<StopBleScanRequest>
{
  static void zza(StopBleScanRequest paramStopBleScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramStopBleScanRequest.zztk(), false);
    zzb.zzc(paramParcel, 1000, paramStopBleScanRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramStopBleScanRequest.zzsO(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StopBleScanRequest zzdw(Parcel paramParcel)
  {
    IBinder localIBinder2 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    IBinder localIBinder1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localIBinder2 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StopBleScanRequest(i, localIBinder1, localIBinder2);
  }
  
  public StopBleScanRequest[] zzfo(int paramInt)
  {
    return new StopBleScanRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */