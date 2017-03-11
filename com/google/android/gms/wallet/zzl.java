package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzl
  implements Parcelable.Creator<MaskedWalletRequest>
{
  static void zza(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramMaskedWalletRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramMaskedWalletRequest.zzbcq, false);
    zzb.zza(paramParcel, 3, paramMaskedWalletRequest.zzbdl);
    zzb.zza(paramParcel, 4, paramMaskedWalletRequest.zzbdm);
    zzb.zza(paramParcel, 5, paramMaskedWalletRequest.zzbdn);
    zzb.zza(paramParcel, 6, paramMaskedWalletRequest.zzbdo, false);
    zzb.zza(paramParcel, 7, paramMaskedWalletRequest.zzbcj, false);
    zzb.zza(paramParcel, 8, paramMaskedWalletRequest.zzbdp, false);
    zzb.zza(paramParcel, 9, paramMaskedWalletRequest.zzbcA, paramInt, false);
    zzb.zza(paramParcel, 10, paramMaskedWalletRequest.zzbdq);
    zzb.zza(paramParcel, 11, paramMaskedWalletRequest.zzbdr);
    zzb.zza(paramParcel, 12, paramMaskedWalletRequest.zzbds, paramInt, false);
    zzb.zza(paramParcel, 13, paramMaskedWalletRequest.zzbdt);
    zzb.zza(paramParcel, 14, paramMaskedWalletRequest.zzbdu);
    zzb.zzc(paramParcel, 15, paramMaskedWalletRequest.zzbdv, false);
    zzb.zza(paramParcel, 17, paramMaskedWalletRequest.zzbdx, false);
    zzb.zza(paramParcel, 16, paramMaskedWalletRequest.zzbdw, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public MaskedWalletRequest zzhh(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str4 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    Cart localCart = null;
    boolean bool4 = false;
    boolean bool3 = false;
    CountrySpecification[] arrayOfCountrySpecification = null;
    boolean bool2 = true;
    boolean bool1 = true;
    ArrayList localArrayList2 = null;
    PaymentMethodTokenizationParameters localPaymentMethodTokenizationParameters = null;
    ArrayList localArrayList1 = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        bool7 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool6 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        localCart = (Cart)zza.zza(paramParcel, k, Cart.CREATOR);
        break;
      case 10: 
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 11: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 12: 
        arrayOfCountrySpecification = (CountrySpecification[])zza.zzb(paramParcel, k, CountrySpecification.CREATOR);
        break;
      case 13: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 14: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 15: 
        localArrayList2 = zza.zzc(paramParcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
        break;
      case 17: 
        localArrayList1 = zza.zzC(paramParcel, k);
        break;
      case 16: 
        localPaymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters)zza.zza(paramParcel, k, PaymentMethodTokenizationParameters.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new MaskedWalletRequest(i, str4, bool7, bool6, bool5, str3, str2, str1, localCart, bool4, bool3, arrayOfCountrySpecification, bool2, bool1, localArrayList2, localPaymentMethodTokenizationParameters, localArrayList1);
  }
  
  public MaskedWalletRequest[] zzkk(int paramInt)
  {
    return new MaskedWalletRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */