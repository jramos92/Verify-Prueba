package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<TextModuleData>
{
  static void zza(TextModuleData paramTextModuleData, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramTextModuleData.getVersionCode());
    zzb.zza(paramParcel, 2, paramTextModuleData.zzbeM, false);
    zzb.zza(paramParcel, 3, paramTextModuleData.body, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TextModuleData zzhA(Parcel paramParcel)
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
    return new TextModuleData(i, str1, str2);
  }
  
  public TextModuleData[] zzkG(int paramInt)
  {
    return new TextModuleData[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */