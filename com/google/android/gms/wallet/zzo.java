package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<PaymentMethodToken>
{
  static void zza(PaymentMethodToken paramPaymentMethodToken, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPaymentMethodToken.getVersionCode());
    zzb.zzc(paramParcel, 2, paramPaymentMethodToken.zzbdC);
    zzb.zza(paramParcel, 3, paramPaymentMethodToken.zzaPv, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PaymentMethodToken zzhk(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str = null;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PaymentMethodToken(i, j, str);
  }
  
  public PaymentMethodToken[] zzkn(int paramInt)
  {
    return new PaymentMethodToken[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */