package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl
  implements Events
{
  public void increment(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    GamesClientImpl localGamesClientImpl = Games.zzc(paramGoogleApiClient, false);
    if (localGamesClientImpl == null) {
      return;
    }
    if (localGamesClientImpl.isConnected())
    {
      localGamesClientImpl.zzp(paramString, paramInt);
      return;
    }
    paramGoogleApiClient.zzb(new UpdateImpl(paramGoogleApiClient, paramString)
    {
      public void zza(GamesClientImpl paramAnonymousGamesClientImpl)
      {
        paramAnonymousGamesClientImpl.zzp(paramString, paramInt);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> load(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zza(new LoadImpl(paramGoogleApiClient, paramBoolean)
    {
      public void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zzd(this, paramBoolean);
      }
    });
  }
  
  public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final String... paramVarArgs)
  {
    paramGoogleApiClient.zza(new LoadImpl(paramGoogleApiClient, paramBoolean)
    {
      public void zza(GamesClientImpl paramAnonymousGamesClientImpl)
        throws RemoteException
      {
        paramAnonymousGamesClientImpl.zza(this, paramBoolean, paramVarArgs);
      }
    });
  }
  
  private static abstract class LoadImpl
    extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult>
  {
    private LoadImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Events.LoadEventsResult zzab(final Status paramStatus)
    {
      new Events.LoadEventsResult()
      {
        public EventBuffer getEvents()
        {
          return new EventBuffer(DataHolder.zzbu(14));
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
  
  private static abstract class UpdateImpl
    extends Games.BaseGamesApiMethodImpl<Result>
  {
    private UpdateImpl(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Result zzb(final Status paramStatus)
    {
      new Result()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\api\EventsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */