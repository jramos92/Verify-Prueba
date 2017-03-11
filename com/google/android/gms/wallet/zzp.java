package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<PaymentMethodTokenizationParameters>
{
  static void zza(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPaymentMethodTokenizationParameters.getVersionCode());
    zzb.zzc(paramParcel, 2, paramPaymentMethodTokenizationParameters.zzbdC);
    zzb.zza(paramParcel, 3, paramPaymentMethodTokenizationParameters.zzbdD, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PaymentMethodTokenizationParameters zzhl(Parcel paramParcel)
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
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PaymentMethodTokenizationParameters(i, j, localBundle);
  }
  
  public PaymentMethodTokenizationParameters[] zzko(int paramInt)
  {
    return new PaymentMethodTokenizationParameters[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */