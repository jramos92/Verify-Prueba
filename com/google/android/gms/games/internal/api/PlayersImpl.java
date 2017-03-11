package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
  implements Players
{
  public Intent getCompareProfileIntent(GoogleApiClient paramGoogleApiClient, Player paramPlayer)
  {
    return Games.zzc(paramGoogleApiClient).zza(new PlayerEntity(paramPlayer));
  }
  
  public Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient)
  {
    return Games.zzc(paramGoogleApiClient).zzuz();
  }
  
  public String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient)
  {
    return Games.zzc(paramGoogleApiClient).zzuy();
  }
  
  public Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient)
  {
    return Games.zzc(paramGoogleApiClient).zzuJ();
  }
  
  public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramBoolean)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramInt, false, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, "played_with", paramInt, true, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramString, false);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramString)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramString, paramBoolean);
      }
    });
  }
  
  public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadPlayersImpl(paramGoogleApiClient, paramInt)
    {
      protected void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, "played_with", paramInt, false, paramBoolean);
      }
    });
  }
  
  private static abstract class LoadPlayersImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult>
  {
    private LoadPlayersImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Players.LoadPlayersResult zzao(final Status paramStatus)
    {
      new Players.LoadPlayersResult()
      {
        public PlayerBuffer getPlayers()
        {
          return new PlayerBuffer(DataHolder.zzbu(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class LoadProfileSettingsResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult>
  {
    protected Players.LoadProfileSettingsResult zzap(final Status paramStatus)
    {
      new Players.LoadProfileSettingsResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadXpForGameCategoriesResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult>
  {
    public Players.LoadXpForGameCategoriesResult zzaq(final Status paramStatus)
    {
      new Players.LoadXpForGameCategoriesResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class LoadXpStreamResultImpl
    extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult>
  {
    public Players.LoadXpStreamResult zzar(final Status paramStatus)
    {
      new Players.LoadXpStreamResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static abstract class UpdateProfileSettingsResultImpl
    extends Games.BaseGamesApiMethodImpl<Status>
  {
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\api\PlayersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */