package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<GetRecentContextCall.Request>
{
  static void zza(GetRecentContextCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramRequest.zzQq, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRequest.zzQr);
    zzb.zza(paramParcel, 3, paramRequest.zzQs);
    zzb.zza(paramParcel, 4, paramRequest.zzQt);
    zzb.zza(paramParcel, 5, paramRequest.zzQu, false);
    zzb.zzI(paramParcel, i);
  }
  
  public GetRecentContextCall.Request[] zzai(int paramInt)
  {
    return new GetRecentContextCall.Request[paramInt];
  }
  
  public GetRecentContextCall.Request zzv(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int j = zza.zzap(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetRecentContextCall.Request(i, localAccount, bool3, bool2, bool1, str);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */