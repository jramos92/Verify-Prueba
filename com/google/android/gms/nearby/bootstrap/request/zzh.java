package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<StopScanRequest>
{
  static void zza(StopScanRequest paramStopScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramStopScanRequest.zzsO(), false);
    zzb.zzc(paramParcel, 1000, paramStopScanRequest.versionCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StopScanRequest zzfJ(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
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
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StopScanRequest(i, localIBinder);
  }
  
  public StopScanRequest[] zzip(int paramInt)
  {
    return new StopScanRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */