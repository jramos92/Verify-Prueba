package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<TrustedDevicesRequest>
{
  static void zza(TrustedDevicesRequest paramTrustedDevicesRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramTrustedDevicesRequest.versionCode);
    zzb.zza(paramParcel, 2, paramTrustedDevicesRequest.zzaRw, false);
    zzb.zza(paramParcel, 3, paramTrustedDevicesRequest.zzaRx, false);
    zzb.zza(paramParcel, 4, paramTrustedDevicesRequest.zzBd(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TrustedDevicesRequest zzgh(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 4: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new TrustedDevicesRequest(i, str, arrayOfByte, localIBinder);
  }
  
  public TrustedDevicesRequest[] zziT(int paramInt)
  {
    return new TrustedDevicesRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */