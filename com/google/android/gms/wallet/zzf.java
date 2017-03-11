package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<FullWalletRequest>
{
  static void zza(FullWalletRequest paramFullWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFullWalletRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramFullWalletRequest.zzbcp, false);
    zzb.zza(paramParcel, 3, paramFullWalletRequest.zzbcq, false);
    zzb.zza(paramParcel, 4, paramFullWalletRequest.zzbcA, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public FullWalletRequest zzhb(Parcel paramParcel)
  {
    Cart localCart = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
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
        break;
      case 4: 
        localCart = (Cart)zza.zza(paramParcel, k, Cart.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FullWalletRequest(i, str1, str2, localCart);
  }
  
  public FullWalletRequest[] zzke(int paramInt)
  {
    return new FullWalletRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */