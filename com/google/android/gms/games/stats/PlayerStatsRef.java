package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public class PlayerStatsRef
  extends zzc
  implements PlayerStats
{
  PlayerStatsRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerStatsEntity.zza(this, paramObject);
  }
  
  public float getAverageSessionLength()
  {
    return getFloat("ave_session_length_minutes");
  }
  
  public int getDaysSinceLastPlayed()
  {
    return getInteger("days_since_last_played");
  }
  
  public int getNumberOfPurchases()
  {
    return getInteger("num_purchases");
  }
  
  public int getNumberOfSessions()
  {
    return getInteger("num_sessions");
  }
  
  public float getSessionPercentile()
  {
    return getFloat("num_sessions_percentile");
  }
  
  public float getSpendPercentile()
  {
    return getFloat("spend_percentile");
  }
  
  public int hashCode()
  {
    return PlayerStatsEntity.zza(this);
  }
  
  public String toString()
  {
    return PlayerStatsEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerStatsEntity)zzvU()).writeToParcel(paramParcel, paramInt);
  }
  
  public float zzvT()
  {
    return getFloat("churn_probability");
  }
  
  public PlayerStats zzvU()
  {
    return new PlayerStatsEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\PlayerStatsRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */