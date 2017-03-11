package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void zza(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramNotifyTransactionStatusRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramNotifyTransactionStatusRequest.zzbcp, false);
    zzb.zzc(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
    zzb.zza(paramParcel, 4, paramNotifyTransactionStatusRequest.zzbdz, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NotifyTransactionStatusRequest zzhi(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NotifyTransactionStatusRequest(i, str1, j, str2);
  }
  
  public NotifyTransactionStatusRequest[] zzkl(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */