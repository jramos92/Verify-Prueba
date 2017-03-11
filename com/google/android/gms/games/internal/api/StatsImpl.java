package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

public final class StatsImpl
  implements Stats
{
  public PendingResult<Stats.LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadsImpl(paramGoogleApiClient, paramBoolean)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zze(this, paramBoolean);
      }
    });
  }
  
  private static abstract class LoadsImpl
    extends Games.BaseGamesApiMethodImpl<Stats.LoadPlayerStatsResult>
  {
    private LoadsImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Stats.LoadPlayerStatsResult zzaD(final Status paramStatus)
    {
      new Stats.LoadPlayerStatsResult()
      {
        public PlayerStats getPlayerStats()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\api\StatsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */