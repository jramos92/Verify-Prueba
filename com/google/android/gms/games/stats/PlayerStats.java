package com.google.android.gms.games.stats;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface PlayerStats
  extends Parcelable, Freezable<PlayerStats>
{
  public static final float UNSET_VALUE = -1.0F;
  
  public abstract float getAverageSessionLength();
  
  public abstract int getDaysSinceLastPlayed();
  
  public abstract int getNumberOfPurchases();
  
  public abstract int getNumberOfSessions();
  
  public abstract float getSessionPercentile();
  
  public abstract float getSpendPercentile();
  
  public abstract float zzvT();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\PlayerStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */