package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl
  implements Parcelable.Creator<Barcode.UrlBookmark>
{
  static void zza(Barcode.UrlBookmark paramUrlBookmark, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramUrlBookmark.versionCode);
    zzb.zza(paramParcel, 2, paramUrlBookmark.title, false);
    zzb.zza(paramParcel, 3, paramUrlBookmark.url, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.UrlBookmark zzgP(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Barcode.UrlBookmark(i, str1, str2);
  }
  
  public Barcode.UrlBookmark[] zzjR(int paramInt)
  {
    return new Barcode.UrlBookmark[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */