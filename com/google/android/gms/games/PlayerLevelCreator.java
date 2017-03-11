package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelCreator
  implements Parcelable.Creator<PlayerLevel>
{
  static void zza(PlayerLevel paramPlayerLevel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPlayerLevel.getLevelNumber());
    zzb.zzc(paramParcel, 1000, paramPlayerLevel.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlayerLevel.getMinXp());
    zzb.zza(paramParcel, 3, paramPlayerLevel.getMaxXp());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlayerLevel zzdP(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int k = zza.zzap(paramParcel);
    long l2 = 0L;
    int j = 0;
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
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PlayerLevel(j, i, l2, l1);
  }
  
  public PlayerLevel[] zzfI(int paramInt)
  {
    return new PlayerLevel[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerLevelCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */