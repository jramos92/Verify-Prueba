package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<Barcode.WiFi>
{
  static void zza(Barcode.WiFi paramWiFi, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramWiFi.versionCode);
    zzb.zza(paramParcel, 2, paramWiFi.ssid, false);
    zzb.zza(paramParcel, 3, paramWiFi.password, false);
    zzb.zzc(paramParcel, 4, paramWiFi.encryptionType);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.WiFi zzgQ(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Barcode.WiFi(i, str1, str2, j);
  }
  
  public Barcode.WiFi[] zzjS(int paramInt)
  {
    return new Barcode.WiFi[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */