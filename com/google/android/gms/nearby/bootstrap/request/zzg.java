package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<StartScanRequest>
{
  static void zza(StartScanRequest paramStartScanRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramStartScanRequest.zzAN(), false);
    zzb.zzc(paramParcel, 1000, paramStartScanRequest.versionCode);
    zzb.zza(paramParcel, 2, paramStartScanRequest.zzsO(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StartScanRequest zzfI(Parcel paramParcel)
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
    return new StartScanRequest(i, localIBinder1, localIBinder2);
  }
  
  public StartScanRequest[] zzio(int paramInt)
  {
    return new StartScanRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */