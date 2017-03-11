package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
  private final int mVersionCode;
  private final long zzauk;
  private final long zzaul;
  private final PlayerLevel zzaum;
  private final PlayerLevel zzaun;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      zzx.zzw(paramPlayerLevel1);
      zzx.zzw(paramPlayerLevel2);
      this.mVersionCode = paramInt;
      this.zzauk = paramLong1;
      this.zzaul = paramLong2;
      this.zzaum = paramPlayerLevel1;
      this.zzaun = paramPlayerLevel2;
      return;
    }
  }
  
  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerLevelInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (PlayerLevelInfo)paramObject;
      if ((!zzw.equal(Long.valueOf(this.zzauk), Long.valueOf(((PlayerLevelInfo)paramObject).zzauk))) || (!zzw.equal(Long.valueOf(this.zzaul), Long.valueOf(((PlayerLevelInfo)paramObject).zzaul))) || (!zzw.equal(this.zzaum, ((PlayerLevelInfo)paramObject).zzaum))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(this.zzaun, ((PlayerLevelInfo)paramObject).zzaun));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.zzaum;
  }
  
  public long getCurrentXpTotal()
  {
    return this.zzauk;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.zzaul;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.zzaun;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzauk), Long.valueOf(this.zzaul), this.zzaum, this.zzaun });
  }
  
  public boolean isMaxLevel()
  {
    return this.zzaum.equals(this.zzaun);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */