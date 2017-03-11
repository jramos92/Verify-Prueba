package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<Barcode.Address>
{
  static void zza(Barcode.Address paramAddress, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAddress.versionCode);
    zzb.zzc(paramParcel, 2, paramAddress.type);
    zzb.zza(paramParcel, 3, paramAddress.addressLines, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.Address zzgE(Parcel paramParcel)
  {
    int j = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    String[] arrayOfString = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 3: 
        arrayOfString = com.google.android.gms.common.internal.safeparcel.zza.zzB(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Barcode.Address(i, j, arrayOfString);
  }
  
  public Barcode.Address[] zzjG(int paramInt)
  {
    return new Barcode.Address[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */