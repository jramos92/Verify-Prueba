package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelInfoCreator
  implements Parcelable.Creator<PlayerLevelInfo>
{
  static void zza(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlayerLevelInfo.getCurrentXpTotal());
    zzb.zzc(paramParcel, 1000, paramPlayerLevelInfo.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlayerLevelInfo.getLastLevelUpTimestamp());
    zzb.zza(paramParcel, 3, paramPlayerLevelInfo.getCurrentLevel(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPlayerLevelInfo.getNextLevel(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlayerLevelInfo zzdQ(Parcel paramParcel)
  {
    long l1 = 0L;
    PlayerLevel localPlayerLevel1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    PlayerLevel localPlayerLevel2 = null;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        l1 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        localPlayerLevel2 = (PlayerLevel)zza.zza(paramParcel, k, PlayerLevel.CREATOR);
        break;
      case 4: 
        localPlayerLevel1 = (PlayerLevel)zza.zza(paramParcel, k, PlayerLevel.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlayerLevelInfo(i, l2, l1, localPlayerLevel2, localPlayerLevel1);
  }
  
  public PlayerLevelInfo[] zzfJ(int paramInt)
  {
    return new PlayerLevelInfo[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerLevelInfoCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */