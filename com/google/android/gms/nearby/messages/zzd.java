package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<Strategy>
{
  static void zza(Strategy paramStrategy, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStrategy.zzaQj);
    zzb.zzc(paramParcel, 1000, paramStrategy.mVersionCode);
    zzb.zzc(paramParcel, 2, paramStrategy.zzaQk);
    zzb.zzc(paramParcel, 3, paramStrategy.zzaQl);
    zzb.zza(paramParcel, 4, paramStrategy.zzaQm);
    zzb.zzc(paramParcel, 5, paramStrategy.zzaQn);
    zzb.zzc(paramParcel, 6, paramStrategy.zzaQo);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Strategy zzfO(Parcel paramParcel)
  {
    int i = 0;
    int i2 = zza.zzap(paramParcel);
    int j = 0;
    boolean bool = false;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (paramParcel.dataPosition() < i2)
    {
      int i3 = zza.zzao(paramParcel);
      switch (zza.zzbM(i3))
      {
      default: 
        zza.zzb(paramParcel, i3);
        break;
      case 1: 
        n = zza.zzg(paramParcel, i3);
        break;
      case 1000: 
        i1 = zza.zzg(paramParcel, i3);
        break;
      case 2: 
        m = zza.zzg(paramParcel, i3);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i3);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, i3);
        break;
      case 5: 
        j = zza.zzg(paramParcel, i3);
        break;
      case 6: 
        i = zza.zzg(paramParcel, i3);
      }
    }
    if (paramParcel.dataPosition() != i2) {
      throw new zza.zza("Overread allowed size end=" + i2, paramParcel);
    }
    return new Strategy(i1, n, m, k, bool, j, i);
  }
  
  public Strategy[] zziA(int paramInt)
  {
    return new Strategy[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */