package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerStatsEntityCreator
  implements Parcelable.Creator<PlayerStatsEntity>
{
  static void zza(PlayerStatsEntity paramPlayerStatsEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlayerStatsEntity.getAverageSessionLength());
    zzb.zzc(paramParcel, 1000, paramPlayerStatsEntity.getVersionCode());
    zzb.zza(paramParcel, 2, paramPlayerStatsEntity.zzvT());
    zzb.zzc(paramParcel, 3, paramPlayerStatsEntity.getDaysSinceLastPlayed());
    zzb.zzc(paramParcel, 4, paramPlayerStatsEntity.getNumberOfPurchases());
    zzb.zzc(paramParcel, 5, paramPlayerStatsEntity.getNumberOfSessions());
    zzb.zza(paramParcel, 6, paramPlayerStatsEntity.getSessionPercentile());
    zzb.zza(paramParcel, 7, paramPlayerStatsEntity.getSpendPercentile());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlayerStatsEntity zzer(Parcel paramParcel)
  {
    int i = 0;
    float f1 = 0.0F;
    int n = zza.zzap(paramParcel);
    float f2 = 0.0F;
    int j = 0;
    int k = 0;
    float f3 = 0.0F;
    float f4 = 0.0F;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        f4 = zza.zzl(paramParcel, i1);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        f3 = zza.zzl(paramParcel, i1);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        f2 = zza.zzl(paramParcel, i1);
        break;
      case 7: 
        f1 = zza.zzl(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new PlayerStatsEntity(m, f4, f3, k, j, i, f2, f1);
  }
  
  public PlayerStatsEntity[] zzgz(int paramInt)
  {
    return new PlayerStatsEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\PlayerStatsEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */