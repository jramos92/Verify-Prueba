package com.google.android.gms.games.stats;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface Stats
{
  public abstract PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient paramGoogleApiClient, boolean paramBoolean);
  
  public static abstract interface LoadPlayerStatsResult
    extends Releasable, Result
  {
    public abstract PlayerStats getPlayerStats();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */