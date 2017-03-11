package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<LineItem>
{
  static void zza(LineItem paramLineItem, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLineItem.getVersionCode());
    zzb.zza(paramParcel, 2, paramLineItem.description, false);
    zzb.zza(paramParcel, 3, paramLineItem.zzbcL, false);
    zzb.zza(paramParcel, 4, paramLineItem.zzbcM, false);
    zzb.zza(paramParcel, 5, paramLineItem.zzbci, false);
    zzb.zzc(paramParcel, 6, paramLineItem.zzbcN);
    zzb.zza(paramParcel, 7, paramLineItem.zzbcj, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LineItem zzhe(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = zza.zzap(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 5: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 6: 
        i = zza.zzg(paramParcel, m);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new LineItem(j, str5, str4, str3, str2, i, str1);
  }
  
  public LineItem[] zzkh(int paramInt)
  {
    return new LineItem[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */