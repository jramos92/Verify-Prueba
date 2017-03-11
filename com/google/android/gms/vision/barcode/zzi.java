package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<Barcode.PersonName>
{
  static void zza(Barcode.PersonName paramPersonName, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPersonName.versionCode);
    zzb.zza(paramParcel, 2, paramPersonName.formattedName, false);
    zzb.zza(paramParcel, 3, paramPersonName.pronunciation, false);
    zzb.zza(paramParcel, 4, paramPersonName.prefix, false);
    zzb.zza(paramParcel, 5, paramPersonName.first, false);
    zzb.zza(paramParcel, 6, paramPersonName.middle, false);
    zzb.zza(paramParcel, 7, paramPersonName.last, false);
    zzb.zza(paramParcel, 8, paramPersonName.suffix, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Barcode.PersonName zzgM(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
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
        str7 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str6 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Barcode.PersonName(i, str7, str6, str5, str4, str3, str2, str1);
  }
  
  public Barcode.PersonName[] zzjO(int paramInt)
  {
    return new Barcode.PersonName[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\barcode\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */