package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlayerStatsEntity
  implements SafeParcelable, PlayerStats
{
  public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
  private final int mVersionCode;
  private final float zzaBX;
  private final float zzaBY;
  private final int zzaBZ;
  private final int zzaCa;
  private final int zzaCb;
  private final float zzaCc;
  private final float zzaCd;
  
  PlayerStatsEntity(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, int paramInt4, float paramFloat3, float paramFloat4)
  {
    this.mVersionCode = paramInt1;
    this.zzaBX = paramFloat1;
    this.zzaBY = paramFloat2;
    this.zzaBZ = paramInt2;
    this.zzaCa = paramInt3;
    this.zzaCb = paramInt4;
    this.zzaCc = paramFloat3;
    this.zzaCd = paramFloat4;
  }
  
  public PlayerStatsEntity(PlayerStats paramPlayerStats)
  {
    this.mVersionCode = 1;
    this.zzaBX = paramPlayerStats.getAverageSessionLength();
    this.zzaBY = paramPlayerStats.zzvT();
    this.zzaBZ = paramPlayerStats.getDaysSinceLastPlayed();
    this.zzaCa = paramPlayerStats.getNumberOfPurchases();
    this.zzaCb = paramPlayerStats.getNumberOfSessions();
    this.zzaCc = paramPlayerStats.getSessionPercentile();
    this.zzaCd = paramPlayerStats.getSpendPercentile();
  }
  
  static int zza(PlayerStats paramPlayerStats)
  {
    return zzw.hashCode(new Object[] { Float.valueOf(paramPlayerStats.getAverageSessionLength()), Float.valueOf(paramPlayerStats.zzvT()), Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed()), Integer.valueOf(paramPlayerStats.getNumberOfPurchases()), Integer.valueOf(paramPlayerStats.getNumberOfSessions()), Float.valueOf(paramPlayerStats.getSessionPercentile()), Float.valueOf(paramPlayerStats.getSpendPercentile()) });
  }
  
  static boolean zza(PlayerStats paramPlayerStats, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerStats)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayerStats == paramObject);
      paramObject = (PlayerStats)paramObject;
      if ((!zzw.equal(Float.valueOf(((PlayerStats)paramObject).getAverageSessionLength()), Float.valueOf(paramPlayerStats.getAverageSessionLength()))) || (!zzw.equal(Float.valueOf(((PlayerStats)paramObject).zzvT()), Float.valueOf(paramPlayerStats.zzvT()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getDaysSinceLastPlayed()), Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getNumberOfPurchases()), Integer.valueOf(paramPlayerStats.getNumberOfPurchases()))) || (!zzw.equal(Integer.valueOf(((PlayerStats)paramObject).getNumberOfSessions()), Integer.valueOf(paramPlayerStats.getNumberOfSessions()))) || (!zzw.equal(Float.valueOf(((PlayerStats)paramObject).getSessionPercentile()), Float.valueOf(paramPlayerStats.getSessionPercentile())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Float.valueOf(((PlayerStats)paramObject).getSpendPercentile()), Float.valueOf(paramPlayerStats.getSpendPercentile())));
    return false;
  }
  
  static String zzb(PlayerStats paramPlayerStats)
  {
    return zzw.zzv(paramPlayerStats).zzg("AverageSessionLength", Float.valueOf(paramPlayerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(paramPlayerStats.zzvT())).zzg("DaysSinceLastPlayed", Integer.valueOf(paramPlayerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(paramPlayerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(paramPlayerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(paramPlayerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(paramPlayerStats.getSpendPercentile())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public float getAverageSessionLength()
  {
    return this.zzaBX;
  }
  
  public int getDaysSinceLastPlayed()
  {
    return this.zzaBZ;
  }
  
  public int getNumberOfPurchases()
  {
    return this.zzaCa;
  }
  
  public int getNumberOfSessions()
  {
    return this.zzaCb;
  }
  
  public float getSessionPercentile()
  {
    return this.zzaCc;
  }
  
  public float getSpendPercentile()
  {
    return this.zzaCd;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerStatsEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public float zzvT()
  {
    return this.zzaBY;
  }
  
  public PlayerStats zzvU()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\PlayerStatsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */