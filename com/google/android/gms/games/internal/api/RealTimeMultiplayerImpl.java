package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.zzlm;
import java.util.List;

public final class RealTimeMultiplayerImpl
  implements RealTimeMultiplayer
{
  private static <L> zzlm<L> zza(GoogleApiClient paramGoogleApiClient, L paramL)
  {
    if (paramL == null) {
      return null;
    }
    return paramGoogleApiClient.zzo(paramL);
  }
  
  public void create(GoogleApiClient paramGoogleApiClient, RoomConfig paramRoomConfig)
  {
    GamesClientImpl localGamesClientImpl = Games.zzb(paramGoogleApiClient, false);
    if (localGamesClientImpl == null) {
      return;
    }
    localGamesClientImpl.zza(paramGoogleApiClient.zzo(paramRoomConfig.getRoomUpdateListener()), zza(paramGoogleApiClient, paramRoomConfig.getRoomStatusUpdateListener()), zza(paramGoogleApiClient, paramRoomConfig.getMessageReceivedListener()), paramRoomConfig);
  }
  
  public void declineInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzr(paramString, 0);
    }
  }
  
  public void dismissInvitation(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    paramGoogleApiClient = Games.zzb(paramGoogleApiClient, false);
    if (paramGoogleApiClient != null) {
      paramGoogleApiClient.zzq(paramString, 0);
    }
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return Games.zzc(paramGoogleApiClient).zzc(paramInt1, paramInt2, true);
  }
  
  public Intent getSelectOpponentsIntent(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return Games.zzc(paramGoogleApiClient).zzc(paramInt1, paramInt2, paramBoolean);
  }
  
  public Intent getWaitingRoomIntent(GoogleApiClient paramGoogleApiClient, Room paramRoom, int paramInt)
  {
    return Games.zzc(paramGoogleApiClient).zza(paramRoom, paramInt);
  }
  
  public void join(GoogleApiClient paramGoogleApiClient, RoomConfig paramRoomConfig)
  {
    GamesClientImpl localGamesClientImpl = Games.zzb(paramGoogleApiClient, false);
    if (localGamesClientImpl == null) {
      return;
    }
    localGamesClientImpl.zzb(paramGoogleApiClient.zzo(paramRoomConfig.getRoomUpdateListener()), zza(paramGoogleApiClient, paramRoomConfig.getRoomStatusUpdateListener()), zza(paramGoogleApiClient, paramRoomConfig.getMessageReceivedListener()), paramRoomConfig);
  }
  
  public void leave(GoogleApiClient paramGoogleApiClient, RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    GamesClientImpl localGamesClientImpl = Games.zzb(paramGoogleApiClient, false);
    if (localGamesClientImpl != null) {
      localGamesClientImpl.zza(paramGoogleApiClient.zzo(paramRoomUpdateListener), paramString);
    }
  }
  
  public int sendReliableMessage(GoogleApiClient paramGoogleApiClient, RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramReliableMessageSentCallback = zza(paramGoogleApiClient, paramReliableMessageSentCallback);
    return Games.zzc(paramGoogleApiClient).zza(paramReliableMessageSentCallback, paramArrayOfByte, paramString1, paramString2);
  }
  
  public int sendUnreliableMessage(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    return Games.zzc(paramGoogleApiClient).zza(paramArrayOfByte, paramString1, new String[] { paramString2 });
  }
  
  public int sendUnreliableMessage(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString, List<String> paramList)
  {
    paramList = (String[])paramList.toArray(new String[paramList.size()]);
    return Games.zzc(paramGoogleApiClient).zza(paramArrayOfByte, paramString, paramList);
  }
  
  public int sendUnreliableMessageToOthers(GoogleApiClient paramGoogleApiClient, byte[] paramArrayOfByte, String paramString)
  {
    return Games.zzc(paramGoogleApiClient).zzd(paramArrayOfByte, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\api\RealTimeMultiplayerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */