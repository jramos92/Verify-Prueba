package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<TimeInterval>
{
  static void zza(TimeInterval paramTimeInterval, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramTimeInterval.getVersionCode());
    zzb.zza(paramParcel, 2, paramTimeInterval.zzbeN);
    zzb.zza(paramParcel, 3, paramTimeInterval.zzbeO);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TimeInterval zzhB(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new TimeInterval(i, l2, l1);
  }
  
  public TimeInterval[] zzkH(int paramInt)
  {
    return new TimeInterval[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */