package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<WalletFragmentStyle>
{
  static void zza(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramWalletFragmentStyle.mVersionCode);
    zzb.zza(paramParcel, 2, paramWalletFragmentStyle.zzbes, false);
    zzb.zzc(paramParcel, 3, paramWalletFragmentStyle.zzbet);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public WalletFragmentStyle zzhu(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    Bundle localBundle = null;
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
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new WalletFragmentStyle(i, localBundle, j);
  }
  
  public WalletFragmentStyle[] zzky(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\fragment\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */