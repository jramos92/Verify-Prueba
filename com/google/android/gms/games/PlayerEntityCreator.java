package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator
  implements Parcelable.Creator<PlayerEntity>
{
  static void zza(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlayerEntity.getPlayerId(), false);
    zzb.zza(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
    zzb.zza(paramParcel, 3, paramPlayerEntity.getIconImageUri(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPlayerEntity.getHiResImageUri(), paramInt, false);
    zzb.zza(paramParcel, 5, paramPlayerEntity.getRetrievedTimestamp());
    zzb.zzc(paramParcel, 6, paramPlayerEntity.zztG());
    zzb.zza(paramParcel, 7, paramPlayerEntity.getLastPlayedWithTimestamp());
    zzb.zza(paramParcel, 8, paramPlayerEntity.getIconImageUrl(), false);
    zzb.zza(paramParcel, 9, paramPlayerEntity.getHiResImageUrl(), false);
    zzb.zza(paramParcel, 14, paramPlayerEntity.getTitle(), false);
    zzb.zza(paramParcel, 15, paramPlayerEntity.zztI(), paramInt, false);
    zzb.zza(paramParcel, 16, paramPlayerEntity.getLevelInfo(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramPlayerEntity.getVersionCode());
    zzb.zza(paramParcel, 19, paramPlayerEntity.zztF());
    zzb.zza(paramParcel, 18, paramPlayerEntity.zztH());
    zzb.zza(paramParcel, 21, paramPlayerEntity.getName(), false);
    zzb.zza(paramParcel, 20, paramPlayerEntity.zztE(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlayerEntity zzdO(Parcel paramParcel)
  {
    int k = zza.zzap(paramParcel);
    int j = 0;
    String str7 = null;
    String str6 = null;
    Uri localUri2 = null;
    Uri localUri1 = null;
    long l2 = 0L;
    int i = 0;
    long l1 = 0L;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    MostRecentGameInfoEntity localMostRecentGameInfoEntity = null;
    PlayerLevelInfo localPlayerLevelInfo = null;
    boolean bool2 = false;
    boolean bool1 = false;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str7 = zza.zzp(paramParcel, m);
        break;
      case 2: 
        str6 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        localUri2 = (Uri)zza.zza(paramParcel, m, Uri.CREATOR);
        break;
      case 4: 
        localUri1 = (Uri)zza.zza(paramParcel, m, Uri.CREATOR);
        break;
      case 5: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 6: 
        i = zza.zzg(paramParcel, m);
        break;
      case 7: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 8: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 9: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 14: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 15: 
        localMostRecentGameInfoEntity = (MostRecentGameInfoEntity)zza.zza(paramParcel, m, MostRecentGameInfoEntity.CREATOR);
        break;
      case 16: 
        localPlayerLevelInfo = (PlayerLevelInfo)zza.zza(paramParcel, m, PlayerLevelInfo.CREATOR);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 19: 
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 18: 
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 21: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 20: 
        str2 = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PlayerEntity(j, str7, str6, localUri2, localUri1, l2, i, l1, str5, str4, str3, localMostRecentGameInfoEntity, localPlayerLevelInfo, bool2, bool1, str2, str1);
  }
  
  public PlayerEntity[] zzfH(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */