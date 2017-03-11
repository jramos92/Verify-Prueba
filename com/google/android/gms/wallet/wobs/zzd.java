package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<LoyaltyPointsBalance>
{
  static void zza(LoyaltyPointsBalance paramLoyaltyPointsBalance, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLoyaltyPointsBalance.getVersionCode());
    zzb.zzc(paramParcel, 2, paramLoyaltyPointsBalance.zzbeH);
    zzb.zza(paramParcel, 3, paramLoyaltyPointsBalance.zzbeI, false);
    zzb.zza(paramParcel, 4, paramLoyaltyPointsBalance.zzbeJ);
    zzb.zza(paramParcel, 5, paramLoyaltyPointsBalance.zzbcG, false);
    zzb.zza(paramParcel, 6, paramLoyaltyPointsBalance.zzbeK);
    zzb.zzc(paramParcel, 7, paramLoyaltyPointsBalance.zzbeL);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LoyaltyPointsBalance zzhy(Parcel paramParcel)
  {
    String str1 = null;
    int j = 0;
    int m = zza.zzap(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int i = -1;
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
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 4: 
        d = zza.zzn(paramParcel, n);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 6: 
        l = zza.zzi(paramParcel, n);
        break;
      case 7: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new LoyaltyPointsBalance(k, j, str2, d, str1, l, i);
  }
  
  public LoyaltyPointsBalance[] zzkE(int paramInt)
  {
    return new LoyaltyPointsBalance[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */