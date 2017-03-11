package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<ProxyCard>
{
  static void zza(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramProxyCard.getVersionCode());
    zzb.zza(paramParcel, 2, paramProxyCard.zzbdF, false);
    zzb.zza(paramParcel, 3, paramProxyCard.zzbdG, false);
    zzb.zzc(paramParcel, 4, paramProxyCard.zzbdH);
    zzb.zzc(paramParcel, 5, paramProxyCard.zzbdI);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ProxyCard zzhm(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zza.zzap(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ProxyCard(k, str2, str1, j, i);
  }
  
  public ProxyCard[] zzkp(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */