package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzle;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlm.zzb;
import com.google.android.gms.signin.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl
  extends zzj<IGamesService>
{
  EventIncrementManager zzavh = new EventIncrementManager()
  {
    public EventIncrementCache zzuU()
    {
      return new GamesClientImpl.GameClientEventIncrementCache(GamesClientImpl.this);
    }
  };
  private final String zzavi;
  private PlayerEntity zzavj;
  private GameEntity zzavk;
  private final PopupManager zzavl;
  private boolean zzavm = false;
  private final Binder zzavn;
  private final long zzavo;
  private final Games.GamesOptions zzavp;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, zzf paramzzf, Games.GamesOptions paramGamesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 1, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzavi = paramzzf.zzoN();
    this.zzavn = new Binder();
    this.zzavl = PopupManager.zza(this, paramzzf.zzoJ());
    zzn(paramzzf.zzoP());
    this.zzavo = hashCode();
    this.zzavp = paramGamesOptions;
  }
  
  private static Room zzX(DataHolder paramDataHolder)
  {
    RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localRoomBuffer.getCount() > 0) {
        paramDataHolder = (Room)((Room)localRoomBuffer.get(0)).freeze();
      }
      return paramDataHolder;
    }
    finally
    {
      localRoomBuffer.release();
    }
  }
  
  private void zzb(RemoteException paramRemoteException)
  {
    GamesLog.zzb("GamesClientImpl", "service died", paramRemoteException);
  }
  
  private void zzuv()
  {
    this.zzavj = null;
    this.zzavk = null;
  }
  
  public void disconnect()
  {
    this.zzavm = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)zzpc();
      localIGamesService.zzuT();
      this.zzavh.flush();
      localIGamesService.zzE(this.zzavo);
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.zzy("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    this.zzavm = false;
  }
  
  public int zza(zzlm<RealTimeMultiplayer.ReliableMessageSentCallback> paramzzlm, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((IGamesService)zzpc()).zza(new RealTimeReliableMessageBinderCallbacks(paramzzlm), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
    return -1;
  }
  
  public int zza(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    zzx.zzb(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((IGamesService)zzpc()).zzb(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return -1;
  }
  
  public Intent zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      paramArrayOfByte = ((IGamesService)zzpc()).zza(paramInt1, paramArrayOfByte, paramInt2, paramString);
      zzx.zzb(paramBitmap, "Must provide a non null icon");
      paramArrayOfByte.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return paramArrayOfByte;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return null;
  }
  
  public Intent zza(PlayerEntity paramPlayerEntity)
  {
    try
    {
      paramPlayerEntity = ((IGamesService)zzpc()).zza(paramPlayerEntity);
      return paramPlayerEntity;
    }
    catch (RemoteException paramPlayerEntity)
    {
      zzb(paramPlayerEntity);
    }
    return null;
  }
  
  public Intent zza(Room paramRoom, int paramInt)
  {
    try
    {
      paramRoom = ((IGamesService)zzpc()).zza((RoomEntity)paramRoom.freeze(), paramInt);
      return paramRoom;
    }
    catch (RemoteException paramRoom)
    {
      zzb(paramRoom);
    }
    return null;
  }
  
  public Intent zza(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      paramString = ((IGamesService)zzpc()).zza(paramString, paramBoolean1, paramBoolean2, paramInt);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null))
    {
      paramBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      this.zzavm = paramBundle.getBoolean("show_welcome_popup");
      this.zzavj = ((PlayerEntity)paramBundle.getParcelable("com.google.android.gms.games.current_player"));
      this.zzavk = ((GameEntity)paramBundle.getParcelable("com.google.android.gms.games.current_game"));
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)zzpc()).zza(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      zzb(paramIBinder);
    }
  }
  
  public void zza(GoogleApiClient.zza paramzza)
  {
    zzuv();
    super.zza(paramzza);
  }
  
  public void zza(Snapshot paramSnapshot)
  {
    paramSnapshot = paramSnapshot.getSnapshotContents();
    if (!paramSnapshot.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Snapshot already closed");
      Contents localContents = paramSnapshot.zzqO();
      paramSnapshot.close();
      try
      {
        ((IGamesService)zzpc()).zza(localContents);
        return;
      }
      catch (RemoteException paramSnapshot)
      {
        zzb(paramSnapshot);
      }
    }
  }
  
  public void zza(zzlb.zzb<Invitations.LoadInvitationsResult> paramzzb, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new InvitationsLoadedBinderCallback(paramzzb), paramInt);
  }
  
  public void zza(zzlb.zzb<Requests.LoadRequestsResult> paramzzb, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestsLoadedBinderCallbacks(paramzzb), paramInt1, paramInt2, paramInt3);
  }
  
  public void zza(zzlb.zzb<AppContents.LoadAppContentResult> paramzzb, int paramInt, String paramString, String[] paramArrayOfString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new AppContentLoadedBinderCallbacks(paramzzb), paramInt, paramString, paramArrayOfString, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb, int paramInt, int[] paramArrayOfInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(paramzzb), paramInt, paramArrayOfInt);
  }
  
  public void zza(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramLeaderboardScoreBuffer.zzvH().asBundle(), paramInt1, paramInt2);
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, TurnBasedMatchConfig paramTurnBasedMatchConfig)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.zzvN(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
  }
  
  public void zza(zzlb.zzb<Snapshots.CommitSnapshotResult> paramzzb, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
    throws RemoteException
  {
    SnapshotContents localSnapshotContents = paramSnapshot.getSnapshotContents();
    if (!localSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Snapshot already closed");
      Object localObject = paramSnapshotMetadataChange.zzvS();
      if (localObject != null) {
        ((BitmapTeleporter)localObject).zzc(getContext().getCacheDir());
      }
      localObject = localSnapshotContents.zzqO();
      localSnapshotContents.close();
      ((IGamesService)zzpc()).zza(new SnapshotCommittedBinderCallbacks(paramzzb), paramSnapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, (Contents)localObject);
      return;
    }
  }
  
  public void zza(zzlb.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzpc()).zza(paramzzb, paramString, this.zzavl.zzvh(), this.zzavl.zzvg());
      return;
    }
  }
  
  public void zza(zzlb.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzpc()).zza(paramzzb, paramString, paramInt, this.zzavl.zzvh(), this.zzavl.zzvg());
      return;
    }
  }
  
  public void zza(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString);
        if (paramString.equals("played_with")) {
          i = 0;
        }
        break;
      }
    }
    ((IGamesService)zzpc()).zzd(new PlayersLoadedBinderCallback(paramzzb), paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb, String paramString, int paramInt, int[] paramArrayOfInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new TurnBasedMatchesLoadedBinderCallbacks(paramzzb), paramString, paramInt, paramArrayOfInt);
  }
  
  public void zza(zzlb.zzb<Leaderboards.SubmitScoreResult> paramzzb, String paramString1, long paramLong, String paramString2)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new SubmitScoreBinderCallbacks(paramzzb))
    {
      ((IGamesService)zzpc()).zza(paramzzb, paramString1, paramLong, paramString2);
      return;
    }
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new TurnBasedMatchLeftBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zza(zzlb.zzb<Leaderboards.LoadPlayerScoreResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void zza(zzlb.zzb<Requests.LoadRequestsResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  public void zza(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString1);
        if (paramString1.equals("circled"))
        {
          i = 0;
          continue;
          if (paramString1.equals("played_with"))
          {
            i = 1;
            continue;
            if (paramString1.equals("nearby")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    ((IGamesService)zzpc()).zza(new PlayersLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zza(zzlb.zzb<Snapshots.OpenSnapshotResult> paramzzb, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, SnapshotContents paramSnapshotContents)
    throws RemoteException
  {
    if (!paramSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "SnapshotContents already closed");
      Object localObject = paramSnapshotMetadataChange.zzvS();
      if (localObject != null) {
        ((BitmapTeleporter)localObject).zzc(getContext().getCacheDir());
      }
      localObject = paramSnapshotContents.zzqO();
      paramSnapshotContents.close();
      ((IGamesService)zzpc()).zza(new SnapshotOpenedBinderCallbacks(paramzzb), paramString1, paramString2, (SnapshotMetadataChangeEntity)paramSnapshotMetadataChange, (Contents)localObject);
      return;
    }
  }
  
  public void zza(zzlb.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new LeaderboardsLoadedBinderCallback(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Quests.LoadQuestsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfString, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Quests.LoadQuestsResult> paramzzb, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Requests.UpdateRequestsResult> paramzzb, String paramString1, String paramString2, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestsUpdatedBinderCallbacks(paramzzb), paramString1, paramString2, paramArrayOfString);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzf(new PlayersLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Snapshots.OpenSnapshotResult> paramzzb, String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new SnapshotOpenedBinderCallbacks(paramzzb), paramString, paramBoolean, paramInt);
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(paramzzb), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
  }
  
  public void zza(zzlb.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new TurnBasedMatchUpdatedBinderCallbacks(paramzzb), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
  }
  
  public void zza(zzlb.zzb<Requests.SendRequestResult> paramzzb, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestSentBinderCallbacks(paramzzb), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zza(zzlb.zzb<Status> paramzzb, boolean paramBoolean, Bundle paramBundle)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new ContactSettingsUpdatedBinderCallback(paramzzb), paramBoolean, paramBundle);
  }
  
  public void zza(zzlb.zzb<Events.LoadEventsResult> paramzzb, boolean paramBoolean, String... paramVarArgs)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new EventsLoadedBinderCallback(paramzzb), paramBoolean, paramVarArgs);
  }
  
  public void zza(zzlb.zzb<Quests.LoadQuestsResult> paramzzb, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramArrayOfInt, paramInt, paramBoolean);
  }
  
  public void zza(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramArrayOfString);
  }
  
  public void zza(zzlm<OnInvitationReceivedListener> paramzzlm)
  {
    try
    {
      paramzzlm = new InvitationReceivedBinderCallback(paramzzlm);
      ((IGamesService)zzpc()).zza(paramzzlm, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public void zza(zzlm<RoomUpdateListener> paramzzlm, zzlm<RoomStatusUpdateListener> paramzzlm1, zzlm<RealTimeMessageReceivedListener> paramzzlm2, RoomConfig paramRoomConfig)
  {
    try
    {
      paramzzlm = new RoomBinderCallbacks(paramzzlm, paramzzlm1, paramzzlm2);
      ((IGamesService)zzpc()).zza(paramzzlm, this.zzavn, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), false, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public void zza(zzlm<RoomUpdateListener> paramzzlm, String paramString)
  {
    try
    {
      ((IGamesService)zzpc()).zzc(new RoomBinderCallbacks(paramzzlm), paramString);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public Intent zzb(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzb(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzb(int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt = ((IGamesService)zzpc()).zzb(paramArrayOfInt);
      return paramArrayOfInt;
    }
    catch (RemoteException paramArrayOfInt)
    {
      zzb(paramArrayOfInt);
    }
    return null;
  }
  
  protected Set<Scope> zzb(Set<Scope> paramSet)
  {
    Scope localScope1 = new Scope("https://www.googleapis.com/auth/games");
    Scope localScope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    boolean bool = false;
    Scope localScope3;
    if (localIterator.hasNext())
    {
      localScope3 = (Scope)localIterator.next();
      if (localScope3.equals(localScope1)) {
        bool = true;
      }
    }
    for (;;)
    {
      break;
      if (localScope3.equals(localScope2))
      {
        i = 1;
        continue;
        if (i != 0)
        {
          if (!bool) {}
          for (bool = true;; bool = false)
          {
            zzx.zza(bool, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
            return paramSet;
          }
        }
        zzx.zza(bool, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
        return paramSet;
      }
    }
  }
  
  public void zzb(zzlb.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlb.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzpc()).zzb(paramzzb, paramString, this.zzavl.zzvh(), this.zzavl.zzvg());
      return;
    }
  }
  
  public void zzb(zzlb.zzb<Achievements.UpdateAchievementResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    if (paramzzb == null) {}
    for (paramzzb = null;; paramzzb = new AchievementUpdatedBinderCallback(paramzzb))
    {
      ((IGamesService)zzpc()).zzb(paramzzb, paramString, paramInt, this.zzavl.zzvh(), this.zzavl.zzvg());
      return;
    }
  }
  
  public void zzb(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlb.zzb<Quests.ClaimMilestoneResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zzf(new QuestMilestoneClaimBinderCallbacks(paramzzb, paramString2), paramString1, paramString2);
  }
  
  public void zzb(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new LeaderboardScoresLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Players.LoadPlayersResult> paramzzb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new PlayersLoadedBinderCallback(paramzzb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzb(zzlb.zzb<Achievements.LoadAchievementsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new AchievementsLoadedBinderCallback(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new LeaderboardsLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new LeaderboardsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Quests.LoadQuestsResult> paramzzb, boolean paramBoolean, String[] paramArrayOfString)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new QuestsLoadedBinderCallbacks(paramzzb), paramArrayOfString, paramBoolean);
  }
  
  public void zzb(zzlb.zzb<Requests.UpdateRequestsResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestsUpdatedBinderCallbacks(paramzzb), paramArrayOfString);
  }
  
  public void zzb(zzlm<OnTurnBasedMatchUpdateReceivedListener> paramzzlm)
  {
    try
    {
      paramzzlm = new MatchUpdateReceivedBinderCallback(paramzzlm);
      ((IGamesService)zzpc()).zzb(paramzzlm, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public void zzb(zzlm<RoomUpdateListener> paramzzlm, zzlm<RoomStatusUpdateListener> paramzzlm1, zzlm<RealTimeMessageReceivedListener> paramzzlm2, RoomConfig paramRoomConfig)
  {
    try
    {
      paramzzlm = new RoomBinderCallbacks(paramzzlm, paramzzlm1, paramzzlm2);
      ((IGamesService)zzpc()).zza(paramzzlm, this.zzavn, paramRoomConfig.getInvitationId(), false, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  protected IGamesService zzbN(IBinder paramIBinder)
  {
    return IGamesService.Stub.zzbQ(paramIBinder);
  }
  
  public Intent zzc(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzc(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzc(zzlb.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzc(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzc(zzlb.zzb<Players.LoadXpStreamResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new PlayerXpStreamLoadedBinderCallback(paramzzb), paramString, paramInt);
  }
  
  public void zzc(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zzc(zzlb.zzb<Snapshots.LoadSnapshotsResult> paramzzb, String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new SnapshotsLoadedBinderCallbacks(paramzzb), paramString1, paramString2, paramBoolean);
  }
  
  public void zzc(zzlb.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzd(new LeaderboardsLoadedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzc(zzlb.zzb<Achievements.LoadAchievementsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new AchievementsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzc(zzlb.zzb<Requests.UpdateRequestsResult> paramzzb, String[] paramArrayOfString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new RequestsUpdatedBinderCallbacks(paramzzb), paramArrayOfString);
  }
  
  public void zzc(zzlm<QuestUpdateListener> paramzzlm)
  {
    try
    {
      paramzzlm = new QuestUpdateBinderCallback(paramzzlm);
      ((IGamesService)zzpc()).zzd(paramzzlm, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public void zzcW(String paramString)
  {
    try
    {
      ((IGamesService)zzpc()).zzde(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public Intent zzcX(String paramString)
  {
    try
    {
      paramString = ((IGamesService)zzpc()).zzcX(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  public void zzcY(String paramString)
  {
    try
    {
      ((IGamesService)zzpc()).zza(paramString, this.zzavl.zzvh(), this.zzavl.zzvg());
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public int zzd(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzb(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      zzb(paramArrayOfByte);
    }
    return -1;
  }
  
  public void zzd(zzlb.zzb<GamesMetadata.LoadGamesResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzd(new GamesLoadedBinderCallback(paramzzb));
  }
  
  public void zzd(zzlb.zzb<Players.LoadPlayersResult> paramzzb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zze(new PlayersLoadedBinderCallback(paramzzb), paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void zzd(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzd(zzlb.zzb<Players.LoadXpStreamResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzc(new PlayerXpStreamLoadedBinderCallback(paramzzb), paramString, paramInt);
  }
  
  public void zzd(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zze(new TurnBasedMatchInitiatedBinderCallbacks(paramzzb), paramString1, paramString2);
  }
  
  public void zzd(zzlb.zzb<Notifications.GameMuteStatusChangeResult> paramzzb, String paramString, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new GameMuteStatusChangedBinderCallback(paramzzb), paramString, paramBoolean);
  }
  
  public void zzd(zzlb.zzb<Events.LoadEventsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zzf(new EventsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzd(zzlm<OnRequestReceivedListener> paramzzlm)
  {
    try
    {
      paramzzlm = new RequestReceivedBinderCallback(paramzzlm);
      ((IGamesService)zzpc()).zzc(paramzzlm, this.zzavo);
      return;
    }
    catch (RemoteException paramzzlm)
    {
      zzb(paramzzlm);
    }
  }
  
  public void zze(zzlb.zzb<Status> paramzzb)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zza(new SignOutCompleteBinderCallbacks(paramzzb));
  }
  
  public void zze(zzlb.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzo(new TurnBasedMatchLeftBinderCallbacks(paramzzb), paramString);
  }
  
  public void zze(zzlb.zzb<Invitations.LoadInvitationsResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzb(new InvitationsLoadedBinderCallback(paramzzb), paramString, paramInt, false);
  }
  
  public void zze(zzlb.zzb<Stats.LoadPlayerStatsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzi(new PlayerStatsLoadedBinderCallbacks(paramzzb), paramBoolean);
  }
  
  public void zzf(zzlb.zzb<Acls.LoadAclResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzh(new NotifyAclLoadedBinderCallback(paramzzb));
  }
  
  public void zzf(zzlb.zzb<TurnBasedMultiplayer.CancelMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzn(new TurnBasedMatchCanceledBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzf(zzlb.zzb<Requests.LoadRequestSummariesResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zza(new RequestSummariesLoadedBinderCallbacks(paramzzb), paramString, paramInt);
  }
  
  public void zzf(zzlb.zzb<Snapshots.LoadSnapshotsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzd(new SnapshotsLoadedBinderCallbacks(paramzzb), paramBoolean);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void zzfV(int paramInt)
  {
    this.zzavl.setGravity(paramInt);
  }
  
  public void zzfW(int paramInt)
  {
    try
    {
      ((IGamesService)zzpc()).zzfW(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzg(zzlb.zzb<Notifications.InboxCountResult> paramzzb)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzt(new InboxCountsLoadedBinderCallback(paramzzb), null);
  }
  
  public void zzg(zzlb.zzb<TurnBasedMultiplayer.LoadMatchResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzp(new TurnBasedMatchLoadedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzg(zzlb.zzb<Players.LoadProfileSettingsResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzg(new ProfileSettingsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzh(zzlb.zzb<Quests.AcceptQuestResult> paramzzb, String paramString)
    throws RemoteException
  {
    this.zzavh.flush();
    ((IGamesService)zzpc()).zzu(new QuestAcceptedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzh(zzlb.zzb<Status> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzh(new ProfileSettingsUpdatedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzi(zzlb.zzb<Snapshots.DeleteSnapshotResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzr(new SnapshotDeletedBinderCallbacks(paramzzb), paramString);
  }
  
  public void zzi(zzlb.zzb<Notifications.ContactSettingLoadResult> paramzzb, boolean paramBoolean)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zze(new ContactSettingsLoadedBinderCallback(paramzzb), paramBoolean);
  }
  
  public void zzj(zzlb.zzb<GamesMetadata.LoadGameInstancesResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzf(new GameInstancesLoadedBinderCallback(paramzzb), paramString);
  }
  
  public void zzk(zzlb.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzq(new GameSearchSuggestionsLoadedBinderCallback(paramzzb), paramString);
  }
  
  public Intent zzl(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = ((IGamesService)zzpc()).zzm(paramString, paramInt1, paramInt2);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
    return null;
  }
  
  public void zzl(zzlb.zzb<Players.LoadXpForGameCategoriesResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(paramzzb), paramString);
  }
  
  public boolean zzlN()
  {
    return true;
  }
  
  protected Bundle zzly()
  {
    Object localObject = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = this.zzavp.zztD();
    localBundle.putString("com.google.android.gms.games.key.gamePackageName", this.zzavi);
    localBundle.putString("com.google.android.gms.games.key.desiredLocale", (String)localObject);
    localBundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzavl.zzvh()));
    localBundle.putInt("com.google.android.gms.games.key.API_VERSION", 1);
    localObject = zzpa();
    if (((zzf)localObject).zzoQ() != null) {
      localBundle.putBundle("com.google.android.gms.games.key.signInOptions", zzi.zza(((zzf)localObject).zzoQ(), ((zzf)localObject).zzoR(), Executors.newSingleThreadExecutor()));
    }
    return localBundle;
  }
  
  public void zzm(zzlb.zzb<Invitations.LoadInvitationsResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzk(new InvitationsLoadedBinderCallback(paramzzb), paramString);
  }
  
  public Bundle zzmS()
  {
    try
    {
      Bundle localBundle = ((IGamesService)zzpc()).zzmS();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzn(View paramView)
  {
    this.zzavl.zzo(paramView);
  }
  
  public void zzn(zzlb.zzb<Status> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzj(new NotifyAclUpdatedBinderCallback(paramzzb), paramString);
  }
  
  public void zzo(zzlb.zzb<Notifications.GameMuteStatusLoadResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((IGamesService)zzpc()).zzi(new GameMuteStatusLoadedBinderCallback(paramzzb), paramString);
  }
  
  public void zzoW()
  {
    super.zzoW();
    if (this.zzavm)
    {
      this.zzavl.zzvf();
      this.zzavm = false;
    }
    if (!this.zzavp.zzatS) {
      zzuw();
    }
  }
  
  public void zzp(String paramString, int paramInt)
  {
    this.zzavh.zzp(paramString, paramInt);
  }
  
  public void zzq(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)zzpc()).zzq(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  public void zzr(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)zzpc()).zzr(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      zzb(paramString);
    }
  }
  
  /* Error */
  public com.google.android.gms.games.Game zzuA()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1339	com/google/android/gms/games/internal/GamesClientImpl:zzpb	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 490	com/google/android/gms/games/internal/GamesClientImpl:zzavk	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1341	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 501	com/google/android/gms/games/internal/GamesClientImpl:zzpc	()Landroid/os/IInterface;
    //   23: checkcast 503	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1345 1 0
    //   31: invokespecial 1346	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1347	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1350	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1353 1 0
    //   53: checkcast 609	com/google/android/gms/games/GameEntity
    //   56: putfield 490	com/google/android/gms/games/internal/GamesClientImpl:zzavk	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 1354	com/google/android/gms/games/GameBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 490	com/google/android/gms/games/internal/GamesClientImpl:zzavk	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1354	com/google/android/gms/games/GameBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: aload_1
    //   80: invokespecial 476	com/google/android/gms/games/internal/GamesClientImpl:zzb	(Landroid/os/RemoteException;)V
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	3	1	localRemoteException	RemoteException
    //   86	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	86	finally
    //   15	35	86	finally
    //   59	63	86	finally
    //   63	65	86	finally
    //   71	77	86	finally
    //   78	83	86	finally
    //   87	89	86	finally
  }
  
  public Intent zzuB()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuB();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzuC()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuC();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzuD()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuD();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzuE()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuE();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public void zzuF()
  {
    try
    {
      ((IGamesService)zzpc()).zzF(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzuG()
  {
    try
    {
      ((IGamesService)zzpc()).zzG(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzuH()
  {
    try
    {
      ((IGamesService)zzpc()).zzI(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzuI()
  {
    try
    {
      ((IGamesService)zzpc()).zzH(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public Intent zzuJ()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuJ();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public Intent zzuK()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuK();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzuL()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuL();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return 4368;
  }
  
  public String zzuM()
  {
    try
    {
      String str = ((IGamesService)zzpc()).zzuM();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzuN()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuN();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public Intent zzuO()
  {
    try
    {
      Intent localIntent = ((IGamesService)zzpc()).zzuO();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public int zzuP()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuP();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzuQ()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuQ();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzuR()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuR();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public int zzuS()
  {
    try
    {
      int i = ((IGamesService)zzpc()).zzuS();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return -1;
  }
  
  public void zzuT()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)zzpc()).zzuT();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public void zzuw()
  {
    try
    {
      PopupLocationInfoBinderCallbacks localPopupLocationInfoBinderCallbacks = new PopupLocationInfoBinderCallbacks(this.zzavl);
      ((IGamesService)zzpc()).zza(localPopupLocationInfoBinderCallbacks, this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
  }
  
  public String zzux()
  {
    try
    {
      String str = ((IGamesService)zzpc()).zzux();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  public String zzuy()
  {
    if (this.zzavj != null) {
      return this.zzavj.getPlayerId();
    }
    try
    {
      String str = ((IGamesService)zzpc()).zzuy();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb(localRemoteException);
    }
    return null;
  }
  
  /* Error */
  public Player zzuz()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1339	com/google/android/gms/games/internal/GamesClientImpl:zzpb	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 488	com/google/android/gms/games/internal/GamesClientImpl:zzavj	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1432	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 501	com/google/android/gms/games/internal/GamesClientImpl:zzpc	()Landroid/os/IInterface;
    //   23: checkcast 503	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1435 1 0
    //   31: invokespecial 1436	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1437	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1440	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1443 1 0
    //   53: checkcast 605	com/google/android/gms/games/PlayerEntity
    //   56: putfield 488	com/google/android/gms/games/internal/GamesClientImpl:zzavj	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_1
    //   60: invokevirtual 1444	com/google/android/gms/games/PlayerBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 488	com/google/android/gms/games/internal/GamesClientImpl:zzavj	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1444	com/google/android/gms/games/PlayerBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: aload_1
    //   80: invokespecial 476	com/google/android/gms/games/internal/GamesClientImpl:zzb	(Landroid/os/RemoteException;)V
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	3	1	localRemoteException	RemoteException
    //   86	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	86	finally
    //   15	35	86	finally
    //   59	63	86	finally
    //   63	65	86	finally
    //   71	77	86	finally
    //   78	83	86	finally
    //   87	89	86	finally
  }
  
  private static abstract class AbstractPeerStatusNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    private final ArrayList<String> zzavr = new ArrayList();
    
    AbstractPeerStatusNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super();
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        this.zzavr.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      zza(paramRoomStatusUpdateListener, paramRoom, this.zzavr);
    }
    
    protected abstract void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  private static abstract class AbstractRoomNotifier
    extends zzld<RoomUpdateListener>
  {
    AbstractRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void zza(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      zza(paramRoomUpdateListener, GamesClientImpl.zzY(paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  private static abstract class AbstractRoomStatusNotifier
    extends zzld<RoomStatusUpdateListener>
  {
    AbstractRoomStatusNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      zza(paramRoomStatusUpdateListener, GamesClientImpl.zzY(paramDataHolder));
    }
    
    protected abstract void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  private static final class AcceptQuestResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.AcceptQuestResult
  {
    private final Quest zzavs;
    
    /* Error */
    AcceptQuestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/quest/QuestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   18: ifle +27 -> 45
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/quest/QuestEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   31: checkcast 30	com/google/android/gms/games/quest/Quest
      //   34: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   37: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:zzavs	Lcom/google/android/gms/games/quest/Quest;
      //   40: aload_1
      //   41: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:zzavs	Lcom/google/android/gms/games/quest/Quest;
      //   50: goto -10 -> 40
      //   53: astore_2
      //   54: aload_1
      //   55: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   58: aload_2
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	AcceptQuestResultImpl
      //   0	60	1	paramDataHolder	DataHolder
      //   53	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	40	53	finally
      //   45	50	53	finally
    }
    
    public Quest getQuest()
    {
      return this.zzavs;
    }
  }
  
  private static final class AchievementUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Achievements.UpdateAchievementResult> zzagy;
    
    AchievementUpdatedBinderCallback(zzlb.zzb<Achievements.UpdateAchievementResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzh(int paramInt, String paramString)
    {
      this.zzagy.zzp(new GamesClientImpl.UpdateAchievementResultImpl(paramInt, paramString));
    }
  }
  
  private static final class AchievementsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Achievements.LoadAchievementsResult> zzagy;
    
    AchievementsLoadedBinderCallback(zzlb.zzb<Achievements.LoadAchievementsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzh(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadAchievementsResultImpl(paramDataHolder));
    }
  }
  
  private static final class AppContentLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<AppContents.LoadAppContentResult> zzavt;
    
    public AppContentLoadedBinderCallbacks(zzlb.zzb<AppContents.LoadAppContentResult> paramzzb)
    {
      this.zzavt = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder[] paramArrayOfDataHolder)
    {
      this.zzavt.zzp(new GamesClientImpl.LoadAppContentsResultImpl(paramArrayOfDataHolder));
    }
  }
  
  private static final class CancelMatchResultImpl
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final Status zzSC;
    private final String zzavu;
    
    CancelMatchResultImpl(Status paramStatus, String paramString)
    {
      this.zzSC = paramStatus;
      this.zzavu = paramString;
    }
    
    public String getMatchId()
    {
      return this.zzavu;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class ClaimMilestoneResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.ClaimMilestoneResult
  {
    private final Quest zzavs;
    private final Milestone zzavv;
    
    /* Error */
    ClaimMilestoneResultImpl(DataHolder paramDataHolder, String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial 18	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   7: new 20	com/google/android/gms/games/quest/QuestBuffer
      //   10: dup
      //   11: aload_1
      //   12: invokespecial 21	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   15: astore_1
      //   16: aload_1
      //   17: invokevirtual 25	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   20: ifle +108 -> 128
      //   23: aload_0
      //   24: new 27	com/google/android/gms/games/quest/QuestEntity
      //   27: dup
      //   28: aload_1
      //   29: iconst_0
      //   30: invokevirtual 31	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   33: checkcast 33	com/google/android/gms/games/quest/Quest
      //   36: invokespecial 36	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavs	Lcom/google/android/gms/games/quest/Quest;
      //   42: aload_0
      //   43: getfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavs	Lcom/google/android/gms/games/quest/Quest;
      //   46: invokeinterface 42 1 0
      //   51: astore 5
      //   53: aload 5
      //   55: invokeinterface 47 1 0
      //   60: istore 4
      //   62: iload_3
      //   63: iload 4
      //   65: if_icmpge +53 -> 118
      //   68: aload 5
      //   70: iload_3
      //   71: invokeinterface 48 2 0
      //   76: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   79: invokeinterface 54 1 0
      //   84: aload_2
      //   85: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   88: ifeq +23 -> 111
      //   91: aload_0
      //   92: aload 5
      //   94: iload_3
      //   95: invokeinterface 48 2 0
      //   100: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   103: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavv	Lcom/google/android/gms/games/quest/Milestone;
      //   106: aload_1
      //   107: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   110: return
      //   111: iload_3
      //   112: iconst_1
      //   113: iadd
      //   114: istore_3
      //   115: goto -53 -> 62
      //   118: aload_0
      //   119: aconst_null
      //   120: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavv	Lcom/google/android/gms/games/quest/Milestone;
      //   123: aload_1
      //   124: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   127: return
      //   128: aload_0
      //   129: aconst_null
      //   130: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavv	Lcom/google/android/gms/games/quest/Milestone;
      //   133: aload_0
      //   134: aconst_null
      //   135: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:zzavs	Lcom/google/android/gms/games/quest/Quest;
      //   138: goto -15 -> 123
      //   141: astore_2
      //   142: aload_1
      //   143: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   146: aload_2
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	ClaimMilestoneResultImpl
      //   0	148	1	paramDataHolder	DataHolder
      //   0	148	2	paramString	String
      //   1	114	3	i	int
      //   60	6	4	j	int
      //   51	42	5	localList	List
      // Exception table:
      //   from	to	target	type
      //   16	62	141	finally
      //   68	106	141	finally
      //   118	123	141	finally
      //   128	138	141	finally
    }
    
    public Milestone getMilestone()
    {
      return this.zzavv;
    }
    
    public Quest getQuest()
    {
      return this.zzavs;
    }
  }
  
  private static final class CommitSnapshotResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.CommitSnapshotResult
  {
    private final SnapshotMetadata zzavw;
    
    /* Error */
    CommitSnapshotResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   31: invokespecial 31	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:zzavw	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   37: aload_1
      //   38: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:zzavw	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   47: goto -10 -> 37
      //   50: astore_2
      //   51: aload_1
      //   52: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	CommitSnapshotResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   50	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public SnapshotMetadata getSnapshotMetadata()
    {
      return this.zzavw;
    }
  }
  
  private static final class ConnectedToRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    ConnectedToRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  private static final class ContactSettingLoadResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Notifications.ContactSettingLoadResult
  {
    ContactSettingLoadResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class ContactSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Notifications.ContactSettingLoadResult> zzagy;
    
    ContactSettingsLoadedBinderCallback(zzlb.zzb<Notifications.ContactSettingLoadResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzI(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.ContactSettingLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class ContactSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Status> zzagy;
    
    ContactSettingsUpdatedBinderCallback(zzlb.zzb<Status> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzfS(int paramInt)
    {
      this.zzagy.zzp(GamesStatusCodes.zzfG(paramInt));
    }
  }
  
  private static final class DeleteSnapshotResultImpl
    implements Snapshots.DeleteSnapshotResult
  {
    private final Status zzSC;
    private final String zzavx;
    
    DeleteSnapshotResultImpl(int paramInt, String paramString)
    {
      this.zzSC = GamesStatusCodes.zzfG(paramInt);
      this.zzavx = paramString;
    }
    
    public String getSnapshotId()
    {
      return this.zzavx;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class DisconnectedFromRoomNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    DisconnectedFromRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  private static final class EventsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Events.LoadEventsResult> zzagy;
    
    EventsLoadedBinderCallback(zzlb.zzb<Events.LoadEventsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzi(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadEventResultImpl(paramDataHolder));
    }
  }
  
  private class GameClientEventIncrementCache
    extends EventIncrementCache
  {
    public GameClientEventIncrementCache()
    {
      super(1000);
    }
    
    protected void zzs(String paramString, int paramInt)
    {
      try
      {
        if (GamesClientImpl.this.isConnected())
        {
          ((IGamesService)GamesClientImpl.this.zzpc()).zzp(paramString, paramInt);
          return;
        }
        GamesLog.zzz("GamesClientImpl", "Unable to increment event " + paramString + " by " + paramInt + " because the games client is no longer connected");
        return;
      }
      catch (RemoteException paramString)
      {
        GamesClientImpl.zza(GamesClientImpl.this, paramString);
      }
    }
  }
  
  private static final class GameInstancesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<GamesMetadata.LoadGameInstancesResult> zzagy;
    
    GameInstancesLoadedBinderCallback(zzlb.zzb<GamesMetadata.LoadGameInstancesResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzp(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadGameInstancesResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameMuteStatusChangeResultImpl
    implements Notifications.GameMuteStatusChangeResult
  {
    private final Status zzSC;
    private final String zzavy;
    private final boolean zzavz;
    
    public GameMuteStatusChangeResultImpl(int paramInt, String paramString, boolean paramBoolean)
    {
      this.zzSC = GamesStatusCodes.zzfG(paramInt);
      this.zzavy = paramString;
      this.zzavz = paramBoolean;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class GameMuteStatusChangedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Notifications.GameMuteStatusChangeResult> zzagy;
    
    GameMuteStatusChangedBinderCallback(zzlb.zzb<Notifications.GameMuteStatusChangeResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(int paramInt, String paramString, boolean paramBoolean)
    {
      this.zzagy.zzp(new GamesClientImpl.GameMuteStatusChangeResultImpl(paramInt, paramString, paramBoolean));
    }
  }
  
  private static final class GameMuteStatusLoadResultImpl
    implements Notifications.GameMuteStatusLoadResult
  {
    private final Status zzSC;
    private final String zzavy;
    private final boolean zzavz;
    
    /* Error */
    public GameMuteStatusLoadResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 20	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: aload_1
      //   6: invokevirtual 26	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   9: invokestatic 32	com/google/android/gms/games/GamesStatusCodes:zzfG	(I)Lcom/google/android/gms/common/api/Status;
      //   12: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzSC	Lcom/google/android/gms/common/api/Status;
      //   15: aload_1
      //   16: invokevirtual 37	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   19: ifle +32 -> 51
      //   22: aload_0
      //   23: aload_1
      //   24: ldc 39
      //   26: iconst_0
      //   27: iconst_0
      //   28: invokevirtual 43	com/google/android/gms/common/data/DataHolder:zzd	(Ljava/lang/String;II)Ljava/lang/String;
      //   31: putfield 45	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzavy	Ljava/lang/String;
      //   34: aload_0
      //   35: aload_1
      //   36: ldc 47
      //   38: iconst_0
      //   39: iconst_0
      //   40: invokevirtual 51	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   43: putfield 53	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzavz	Z
      //   46: aload_1
      //   47: invokevirtual 56	com/google/android/gms/common/data/DataHolder:close	()V
      //   50: return
      //   51: aload_0
      //   52: aconst_null
      //   53: putfield 45	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzavy	Ljava/lang/String;
      //   56: aload_0
      //   57: iconst_0
      //   58: putfield 53	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:zzavz	Z
      //   61: goto -15 -> 46
      //   64: astore_2
      //   65: aload_1
      //   66: invokevirtual 56	com/google/android/gms/common/data/DataHolder:close	()V
      //   69: aload_2
      //   70: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	71	0	this	GameMuteStatusLoadResultImpl
      //   0	71	1	paramDataHolder	DataHolder
      //   64	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	46	64	finally
      //   51	61	64	finally
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class GameMuteStatusLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Notifications.GameMuteStatusLoadResult> zzagy;
    
    GameMuteStatusLoadedBinderCallback(zzlb.zzb<Notifications.GameMuteStatusLoadResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzG(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.GameMuteStatusLoadResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameSearchSuggestionsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzagy;
    
    GameSearchSuggestionsLoadedBinderCallback(zzlb.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzq(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class GamesDataHolderResult
    extends zzle
  {
    protected GamesDataHolderResult(DataHolder paramDataHolder)
    {
      super(GamesStatusCodes.zzfG(paramDataHolder.getStatusCode()));
    }
  }
  
  private static final class GamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<GamesMetadata.LoadGamesResult> zzagy;
    
    GamesLoadedBinderCallback(zzlb.zzb<GamesMetadata.LoadGamesResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzn(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadGamesResultImpl(paramDataHolder));
    }
  }
  
  private static final class InboxCountResultImpl
    implements Notifications.InboxCountResult
  {
    private final Status zzSC;
    private final Bundle zzavA;
    
    InboxCountResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzSC = paramStatus;
      this.zzavA = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class InboxCountsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Notifications.InboxCountResult> zzagy;
    
    InboxCountsLoadedBinderCallback(zzlb.zzb<Notifications.InboxCountResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzg(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfG(paramInt);
      this.zzagy.zzp(new GamesClientImpl.InboxCountResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class InitiateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    InitiateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class InvitationReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlm<OnInvitationReceivedListener> zzakZ;
    
    InvitationReceivedBinderCallback(zzlm<OnInvitationReceivedListener> paramzzlm)
    {
      this.zzakZ = paramzzlm;
    }
    
    public void onInvitationRemoved(String paramString)
    {
      this.zzakZ.zza(new GamesClientImpl.InvitationRemovedNotifier(paramString));
    }
    
    public void zzs(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localInvitationBuffer.getCount() > 0) {
          paramDataHolder = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.release();
        if (paramDataHolder != null) {
          this.zzakZ.zza(new GamesClientImpl.InvitationReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.release();
      }
    }
  }
  
  private static final class InvitationReceivedNotifier
    implements zzlm.zzb<OnInvitationReceivedListener>
  {
    private final Invitation zzavB;
    
    InvitationReceivedNotifier(Invitation paramInvitation)
    {
      this.zzavB = paramInvitation;
    }
    
    public void zza(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.zzavB);
    }
    
    public void zznN() {}
  }
  
  private static final class InvitationRemovedNotifier
    implements zzlm.zzb<OnInvitationReceivedListener>
  {
    private final String zzavC;
    
    InvitationRemovedNotifier(String paramString)
    {
      this.zzavC = paramString;
    }
    
    public void zza(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.zzavC);
    }
    
    public void zznN() {}
  }
  
  private static final class InvitationsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Invitations.LoadInvitationsResult> zzagy;
    
    InvitationsLoadedBinderCallback(zzlb.zzb<Invitations.LoadInvitationsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzr(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadInvitationsResultImpl(paramDataHolder));
    }
  }
  
  private static final class JoinedRoomNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public JoinedRoomNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  private static final class LeaderboardMetadataResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer zzavD;
    
    LeaderboardMetadataResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavD = new LeaderboardBuffer(paramDataHolder);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.zzavD;
    }
  }
  
  private static final class LeaderboardScoresLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Leaderboards.LoadScoresResult> zzagy;
    
    LeaderboardScoresLoadedBinderCallback(zzlb.zzb<Leaderboards.LoadScoresResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadScoresResultImpl(paramDataHolder1, paramDataHolder2));
    }
  }
  
  private static final class LeaderboardsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Leaderboards.LeaderboardMetadataResult> zzagy;
    
    LeaderboardsLoadedBinderCallback(zzlb.zzb<Leaderboards.LeaderboardMetadataResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzj(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LeaderboardMetadataResultImpl(paramDataHolder));
    }
  }
  
  private static final class LeaveMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    LeaveMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LeftRoomNotifier
    implements zzlm.zzb<RoomUpdateListener>
  {
    private final int zzYm;
    private final String zzavE;
    
    LeftRoomNotifier(int paramInt, String paramString)
    {
      this.zzYm = paramInt;
      this.zzavE = paramString;
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.zzYm, this.zzavE);
    }
    
    public void zznN() {}
  }
  
  private static final class LoadAchievementsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer zzavF;
    
    LoadAchievementsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavF = new AchievementBuffer(paramDataHolder);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.zzavF;
    }
  }
  
  private static final class LoadAclResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Acls.LoadAclResult
  {
    LoadAclResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadAppContentsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements AppContents.LoadAppContentResult
  {
    private final ArrayList<DataHolder> zzavG;
    
    LoadAppContentsResultImpl(DataHolder[] paramArrayOfDataHolder)
    {
      super();
      this.zzavG = new ArrayList(Arrays.asList(paramArrayOfDataHolder));
    }
  }
  
  private static final class LoadEventResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Events.LoadEventsResult
  {
    private final EventBuffer zzavH;
    
    LoadEventResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavH = new EventBuffer(paramDataHolder);
    }
    
    public EventBuffer getEvents()
    {
      return this.zzavH;
    }
  }
  
  private static final class LoadGameInstancesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGameInstancesResult
  {
    private final GameInstanceBuffer zzavI;
    
    LoadGameInstancesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavI = new GameInstanceBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameSearchSuggestionsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGameSearchSuggestionsResult
  {
    private final GameSearchSuggestionBuffer zzavJ;
    
    LoadGameSearchSuggestionsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavJ = new GameSearchSuggestionBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGamesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer zzavK;
    
    LoadGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavK = new GameBuffer(paramDataHolder);
    }
    
    public GameBuffer getGames()
    {
      return this.zzavK;
    }
  }
  
  private static final class LoadInvitationsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer zzavL;
    
    LoadInvitationsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavL = new InvitationBuffer(paramDataHolder);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.zzavL;
    }
  }
  
  private static final class LoadMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    LoadMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadMatchesResultImpl
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final Status zzSC;
    private final LoadMatchesResponse zzavM;
    
    LoadMatchesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzSC = paramStatus;
      this.zzavM = new LoadMatchesResponse(paramBundle);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.zzavM;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      this.zzavM.release();
    }
  }
  
  private static final class LoadPlayerScoreResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final LeaderboardScoreEntity zzavN;
    
    /* Error */
    LoadPlayerScoreResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   18: ifle +25 -> 43
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   27: invokeinterface 32 1 0
      //   32: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
      //   35: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:zzavN	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   38: aload_1
      //   39: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:zzavN	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   48: goto -10 -> 38
      //   51: astore_2
      //   52: aload_1
      //   53: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   56: aload_2
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	LoadPlayerScoreResultImpl
      //   0	58	1	paramDataHolder	DataHolder
      //   51	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	38	51	finally
      //   43	48	51	finally
    }
    
    public LeaderboardScore getScore()
    {
      return this.zzavN;
    }
  }
  
  private static final class LoadPlayerStatsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Stats.LoadPlayerStatsResult
  {
    private final PlayerStats zzavO;
    
    /* Error */
    LoadPlayerStatsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/stats/PlayerStatsBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/stats/PlayerStatsBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/stats/PlayerStatsBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/stats/PlayerStatsEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/stats/PlayerStatsBuffer:zzgy	(I)Lcom/google/android/gms/games/stats/PlayerStats;
      //   31: invokespecial 31	com/google/android/gms/games/stats/PlayerStatsEntity:<init>	(Lcom/google/android/gms/games/stats/PlayerStats;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerStatsResultImpl:zzavO	Lcom/google/android/gms/games/stats/PlayerStats;
      //   37: aload_1
      //   38: invokevirtual 37	com/google/android/gms/games/stats/PlayerStatsBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerStatsResultImpl:zzavO	Lcom/google/android/gms/games/stats/PlayerStats;
      //   47: goto -10 -> 37
      //   50: astore_2
      //   51: aload_1
      //   52: invokevirtual 37	com/google/android/gms/games/stats/PlayerStatsBuffer:release	()V
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	LoadPlayerStatsResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   50	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public PlayerStats getPlayerStats()
    {
      return this.zzavO;
    }
  }
  
  private static final class LoadPlayersResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer zzavP;
    
    LoadPlayersResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavP = new PlayerBuffer(paramDataHolder);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.zzavP;
    }
  }
  
  private static final class LoadProfileSettingsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadProfileSettingsResult
  {
    private final boolean zzavQ;
    private final boolean zzave;
    
    /* Error */
    LoadProfileSettingsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 16	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: aload_1
      //   6: invokevirtual 22	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   9: ifle +38 -> 47
      //   12: aload_1
      //   13: iconst_0
      //   14: invokevirtual 26	com/google/android/gms/common/data/DataHolder:zzbt	(I)I
      //   17: istore_2
      //   18: aload_0
      //   19: aload_1
      //   20: ldc 28
      //   22: iconst_0
      //   23: iload_2
      //   24: invokevirtual 32	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   27: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzave	Z
      //   30: aload_0
      //   31: aload_1
      //   32: ldc 36
      //   34: iconst_0
      //   35: iload_2
      //   36: invokevirtual 32	com/google/android/gms/common/data/DataHolder:zze	(Ljava/lang/String;II)Z
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzavQ	Z
      //   42: aload_1
      //   43: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   46: return
      //   47: aload_0
      //   48: iconst_1
      //   49: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzave	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:zzavQ	Z
      //   57: goto -15 -> 42
      //   60: astore_3
      //   61: aload_1
      //   62: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   65: aload_3
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	LoadProfileSettingsResultImpl
      //   0	67	1	paramDataHolder	DataHolder
      //   17	19	2	i	int
      //   60	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	42	60	finally
      //   47	57	60	finally
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class LoadQuestsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Quests.LoadQuestsResult
  {
    private final DataHolder zzabq;
    
    LoadQuestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzabq = paramDataHolder;
    }
    
    public QuestBuffer getQuests()
    {
      return new QuestBuffer(this.zzabq);
    }
  }
  
  private static final class LoadRequestSummariesResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.LoadRequestSummariesResult
  {
    LoadRequestSummariesResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadRequestsResultImpl
    implements Requests.LoadRequestsResult
  {
    private final Status zzSC;
    private final Bundle zzavR;
    
    LoadRequestsResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzSC = paramStatus;
      this.zzavR = paramBundle;
    }
    
    public GameRequestBuffer getRequests(int paramInt)
    {
      String str = RequestType.zzfZ(paramInt);
      if (!this.zzavR.containsKey(str)) {
        return null;
      }
      return new GameRequestBuffer((DataHolder)this.zzavR.get(str));
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public void release()
    {
      Iterator localIterator = this.zzavR.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (DataHolder)this.zzavR.getParcelable((String)localObject);
        if (localObject != null) {
          ((DataHolder)localObject).close();
        }
      }
    }
  }
  
  private static final class LoadScoresResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.LoadScoresResult
  {
    private final LeaderboardEntity zzavS;
    private final LeaderboardScoreBuffer zzavT;
    
    /* Error */
    LoadScoresResultImpl(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: invokespecial 18	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 20	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 21	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 25	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   18: ifle +40 -> 58
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 29	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 31	com/google/android/gms/games/leaderboard/Leaderboard
      //   30: invokeinterface 35 1 0
      //   35: checkcast 37	com/google/android/gms/games/leaderboard/LeaderboardEntity
      //   38: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzavS	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   41: aload_1
      //   42: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   45: aload_0
      //   46: new 45	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   49: dup
      //   50: aload_2
      //   51: invokespecial 46	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   54: putfield 48	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzavT	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   57: return
      //   58: aload_0
      //   59: aconst_null
      //   60: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:zzavS	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   63: goto -22 -> 41
      //   66: astore_2
      //   67: aload_1
      //   68: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   71: aload_2
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	LoadScoresResultImpl
      //   0	73	1	paramDataHolder1	DataHolder
      //   0	73	2	paramDataHolder2	DataHolder
      // Exception table:
      //   from	to	target	type
      //   14	41	66	finally
      //   58	63	66	finally
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.zzavS;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.zzavT;
    }
  }
  
  private static final class LoadSnapshotsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.LoadSnapshotsResult
  {
    LoadSnapshotsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
    
    public SnapshotMetadataBuffer getSnapshots()
    {
      return new SnapshotMetadataBuffer(this.zzabq);
    }
  }
  
  private static final class LoadXpForGameCategoriesResultImpl
    implements Players.LoadXpForGameCategoriesResult
  {
    private final Status zzSC;
    private final List<String> zzavU;
    private final Bundle zzavV;
    
    LoadXpForGameCategoriesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.zzSC = paramStatus;
      this.zzavU = paramBundle.getStringArrayList("game_category_list");
      this.zzavV = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class LoadXpStreamResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Players.LoadXpStreamResult
  {
    private final ExperienceEventBuffer zzavW;
    
    LoadXpStreamResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzavW = new ExperienceEventBuffer(paramDataHolder);
    }
  }
  
  private static final class MatchRemovedNotifier
    implements zzlm.zzb<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String zzavX;
    
    MatchRemovedNotifier(String paramString)
    {
      this.zzavX = paramString;
    }
    
    public void zza(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzavX);
    }
    
    public void zznN() {}
  }
  
  private static final class MatchUpdateReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlm<OnTurnBasedMatchUpdateReceivedListener> zzakZ;
    
    MatchUpdateReceivedBinderCallback(zzlm<OnTurnBasedMatchUpdateReceivedListener> paramzzlm)
    {
      this.zzakZ = paramzzlm;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      this.zzakZ.zza(new GamesClientImpl.MatchRemovedNotifier(paramString));
    }
    
    public void zzy(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localTurnBasedMatchBuffer.getCount() > 0) {
          paramDataHolder = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.release();
        if (paramDataHolder != null) {
          this.zzakZ.zza(new GamesClientImpl.MatchUpdateReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.release();
      }
    }
  }
  
  private static final class MatchUpdateReceivedNotifier
    implements zzlm.zzb<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch zzavY;
    
    MatchUpdateReceivedNotifier(TurnBasedMatch paramTurnBasedMatch)
    {
      this.zzavY = paramTurnBasedMatch;
    }
    
    public void zza(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzavY);
    }
    
    public void zznN() {}
  }
  
  private static final class MessageReceivedNotifier
    implements zzlm.zzb<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage zzavZ;
    
    MessageReceivedNotifier(RealTimeMessage paramRealTimeMessage)
    {
      this.zzavZ = paramRealTimeMessage;
    }
    
    public void zza(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzavZ);
    }
    
    public void zznN() {}
  }
  
  private static final class NearbyPlayerDetectedNotifier
    implements zzlm.zzb<OnNearbyPlayerDetectedListener>
  {
    private final Player zzawa;
    
    public void zza(OnNearbyPlayerDetectedListener paramOnNearbyPlayerDetectedListener)
    {
      paramOnNearbyPlayerDetectedListener.zza(this.zzawa);
    }
    
    public void zznN() {}
  }
  
  private static final class NotifyAclLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Acls.LoadAclResult> zzagy;
    
    NotifyAclLoadedBinderCallback(zzlb.zzb<Acls.LoadAclResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzH(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadAclResultImpl(paramDataHolder));
    }
  }
  
  private static final class NotifyAclUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Status> zzagy;
    
    NotifyAclUpdatedBinderCallback(zzlb.zzb<Status> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzfR(int paramInt)
    {
      this.zzagy.zzp(GamesStatusCodes.zzfG(paramInt));
    }
  }
  
  private static final class OpenSnapshotResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Snapshots.OpenSnapshotResult
  {
    private final Snapshot zzawb;
    private final String zzawc;
    private final Snapshot zzawd;
    private final Contents zzawe;
    private final SnapshotContents zzawf;
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, Contents paramContents)
    {
      this(paramDataHolder, null, paramContents, null, null);
    }
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      super();
      SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
      for (;;)
      {
        try
        {
          if (localSnapshotMetadataBuffer.getCount() == 0)
          {
            this.zzawb = null;
            this.zzawd = null;
            localSnapshotMetadataBuffer.release();
            this.zzawc = paramString;
            this.zzawe = paramContents3;
            this.zzawf = new SnapshotContentsEntity(paramContents3);
            return;
          }
          if (localSnapshotMetadataBuffer.getCount() != 1) {
            break label144;
          }
          if (paramDataHolder.getStatusCode() != 4004)
          {
            zzb.zzZ(bool);
            this.zzawb = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
            this.zzawd = null;
            continue;
          }
          bool = false;
        }
        finally
        {
          localSnapshotMetadataBuffer.release();
        }
        continue;
        label144:
        this.zzawb = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(paramContents1));
        this.zzawd = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(paramContents2));
      }
    }
    
    public String getConflictId()
    {
      return this.zzawc;
    }
    
    public Snapshot getConflictingSnapshot()
    {
      return this.zzawd;
    }
    
    public SnapshotContents getResolutionSnapshotContents()
    {
      return this.zzawf;
    }
    
    public Snapshot getSnapshot()
    {
      return this.zzawb;
    }
  }
  
  private static final class P2PConnectedNotifier
    implements zzlm.zzb<RoomStatusUpdateListener>
  {
    private final String zzawg;
    
    P2PConnectedNotifier(String paramString)
    {
      this.zzawg = paramString;
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PConnected(this.zzawg);
    }
    
    public void zznN() {}
  }
  
  private static final class P2PDisconnectedNotifier
    implements zzlm.zzb<RoomStatusUpdateListener>
  {
    private final String zzawg;
    
    P2PDisconnectedNotifier(String paramString)
    {
      this.zzawg = paramString;
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      paramRoomStatusUpdateListener.onP2PDisconnected(this.zzawg);
    }
    
    public void zznN() {}
  }
  
  private static final class PeerConnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerConnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDeclinedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDeclinedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerDisconnectedNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerDisconnectedNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerInvitedToRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerInvitedToRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerJoinedRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerJoinedRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  private static final class PeerLeftRoomNotifier
    extends GamesClientImpl.AbstractPeerStatusNotifier
  {
    PeerLeftRoomNotifier(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramArrayOfString);
    }
    
    protected void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  private static final class PlayerLeaderboardScoreLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Leaderboards.LoadPlayerScoreResult> zzagy;
    
    PlayerLeaderboardScoreLoadedBinderCallback(zzlb.zzb<Leaderboards.LoadPlayerScoreResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzJ(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadPlayerScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayerStatsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Stats.LoadPlayerStatsResult> zzagy;
    
    public PlayerStatsLoadedBinderCallbacks(zzlb.zzb<Stats.LoadPlayerStatsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzW(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadPlayerStatsResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayerXpForGameCategoriesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Players.LoadXpForGameCategoriesResult> zzagy;
    
    PlayerXpForGameCategoriesLoadedBinderCallback(zzlb.zzb<Players.LoadXpForGameCategoriesResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzf(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfG(paramInt);
      this.zzagy.zzp(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(localStatus, paramBundle));
    }
  }
  
  static final class PlayerXpStreamLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Players.LoadXpStreamResult> zzagy;
    
    PlayerXpStreamLoadedBinderCallback(zzlb.zzb<Players.LoadXpStreamResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzU(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadXpStreamResultImpl(paramDataHolder));
    }
  }
  
  private static final class PlayersLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Players.LoadPlayersResult> zzagy;
    
    PlayersLoadedBinderCallback(zzlb.zzb<Players.LoadPlayersResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzl(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
    
    public void zzm(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
  }
  
  private static final class PopupLocationInfoBinderCallbacks
    extends AbstractGamesClient
  {
    private final PopupManager zzavl;
    
    public PopupLocationInfoBinderCallbacks(PopupManager paramPopupManager)
    {
      this.zzavl = paramPopupManager;
    }
    
    public PopupLocationInfoParcelable zzus()
    {
      return new PopupLocationInfoParcelable(this.zzavl.zzvi());
    }
  }
  
  static final class ProfileSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Players.LoadProfileSettingsResult> zzagy;
    
    ProfileSettingsLoadedBinderCallback(zzlb.zzb<Players.LoadProfileSettingsResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzV(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.LoadProfileSettingsResultImpl(paramDataHolder));
    }
  }
  
  private static final class ProfileSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Status> zzagy;
    
    ProfileSettingsUpdatedBinderCallback(zzlb.zzb<Status> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzfT(int paramInt)
    {
      this.zzagy.zzp(GamesStatusCodes.zzfG(paramInt));
    }
  }
  
  private static final class QuestAcceptedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Quests.AcceptQuestResult> zzawh;
    
    public QuestAcceptedBinderCallbacks(zzlb.zzb<Quests.AcceptQuestResult> paramzzb)
    {
      this.zzawh = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzQ(DataHolder paramDataHolder)
    {
      this.zzawh.zzp(new GamesClientImpl.AcceptQuestResultImpl(paramDataHolder));
    }
  }
  
  private static final class QuestCompletedNotifier
    implements zzlm.zzb<QuestUpdateListener>
  {
    private final Quest zzavs;
    
    QuestCompletedNotifier(Quest paramQuest)
    {
      this.zzavs = paramQuest;
    }
    
    public void zza(QuestUpdateListener paramQuestUpdateListener)
    {
      paramQuestUpdateListener.onQuestCompleted(this.zzavs);
    }
    
    public void zznN() {}
  }
  
  private static final class QuestMilestoneClaimBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Quests.ClaimMilestoneResult> zzawi;
    private final String zzawj;
    
    public QuestMilestoneClaimBinderCallbacks(zzlb.zzb<Quests.ClaimMilestoneResult> paramzzb, String paramString)
    {
      this.zzawi = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
      this.zzawj = ((String)zzx.zzb(paramString, "MilestoneId must not be null"));
    }
    
    public void zzP(DataHolder paramDataHolder)
    {
      this.zzawi.zzp(new GamesClientImpl.ClaimMilestoneResultImpl(paramDataHolder, this.zzawj));
    }
  }
  
  private static final class QuestUpdateBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlm<QuestUpdateListener> zzakZ;
    
    QuestUpdateBinderCallback(zzlm<QuestUpdateListener> paramzzlm)
    {
      this.zzakZ = paramzzlm;
    }
    
    private Quest zzZ(DataHolder paramDataHolder)
    {
      QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localQuestBuffer.getCount() > 0) {
          paramDataHolder = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
        }
        return paramDataHolder;
      }
      finally
      {
        localQuestBuffer.release();
      }
    }
    
    public void zzR(DataHolder paramDataHolder)
    {
      paramDataHolder = zzZ(paramDataHolder);
      if (paramDataHolder != null) {
        this.zzakZ.zza(new GamesClientImpl.QuestCompletedNotifier(paramDataHolder));
      }
    }
  }
  
  private static final class QuestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Quests.LoadQuestsResult> zzawk;
    
    public QuestsLoadedBinderCallbacks(zzlb.zzb<Quests.LoadQuestsResult> paramzzb)
    {
      this.zzawk = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzT(DataHolder paramDataHolder)
    {
      this.zzawk.zzp(new GamesClientImpl.LoadQuestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RealTimeMessageSentNotifier
    implements zzlm.zzb<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int zzYm;
    private final String zzawl;
    private final int zzawm;
    
    RealTimeMessageSentNotifier(int paramInt1, int paramInt2, String paramString)
    {
      this.zzYm = paramInt1;
      this.zzawm = paramInt2;
      this.zzawl = paramString;
    }
    
    public void zza(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.zzYm, this.zzawm, this.zzawl);
      }
    }
    
    public void zznN() {}
  }
  
  private static final class RealTimeReliableMessageBinderCallbacks
    extends AbstractGamesCallbacks
  {
    final zzlm<RealTimeMultiplayer.ReliableMessageSentCallback> zzawn;
    
    public RealTimeReliableMessageBinderCallbacks(zzlm<RealTimeMultiplayer.ReliableMessageSentCallback> paramzzlm)
    {
      this.zzawn = paramzzlm;
    }
    
    public void zzb(int paramInt1, int paramInt2, String paramString)
    {
      if (this.zzawn != null) {
        this.zzawn.zza(new GamesClientImpl.RealTimeMessageSentNotifier(paramInt1, paramInt2, paramString));
      }
    }
  }
  
  private static final class RequestReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final zzlm<OnRequestReceivedListener> zzakZ;
    
    RequestReceivedBinderCallback(zzlm<OnRequestReceivedListener> paramzzlm)
    {
      this.zzakZ = paramzzlm;
    }
    
    public void onRequestRemoved(String paramString)
    {
      this.zzakZ.zza(new GamesClientImpl.RequestRemovedNotifier(paramString));
    }
    
    public void zzt(DataHolder paramDataHolder)
    {
      GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localGameRequestBuffer.getCount() > 0) {
          paramDataHolder = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
        }
        localGameRequestBuffer.release();
        if (paramDataHolder != null) {
          this.zzakZ.zza(new GamesClientImpl.RequestReceivedNotifier(paramDataHolder));
        }
        return;
      }
      finally
      {
        localGameRequestBuffer.release();
      }
    }
  }
  
  private static final class RequestReceivedNotifier
    implements zzlm.zzb<OnRequestReceivedListener>
  {
    private final GameRequest zzawo;
    
    RequestReceivedNotifier(GameRequest paramGameRequest)
    {
      this.zzawo = paramGameRequest;
    }
    
    public void zza(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestReceived(this.zzawo);
    }
    
    public void zznN() {}
  }
  
  private static final class RequestRemovedNotifier
    implements zzlm.zzb<OnRequestReceivedListener>
  {
    private final String zzBY;
    
    RequestRemovedNotifier(String paramString)
    {
      this.zzBY = paramString;
    }
    
    public void zza(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestRemoved(this.zzBY);
    }
    
    public void zznN() {}
  }
  
  private static final class RequestSentBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Requests.SendRequestResult> zzawp;
    
    public RequestSentBinderCallbacks(zzlb.zzb<Requests.SendRequestResult> paramzzb)
    {
      this.zzawp = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzL(DataHolder paramDataHolder)
    {
      this.zzawp.zzp(new GamesClientImpl.SendRequestResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestSummariesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Requests.LoadRequestSummariesResult> zzawq;
    
    public RequestSummariesLoadedBinderCallbacks(zzlb.zzb<Requests.LoadRequestSummariesResult> paramzzb)
    {
      this.zzawq = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzM(DataHolder paramDataHolder)
    {
      this.zzawq.zzp(new GamesClientImpl.LoadRequestSummariesResultImpl(paramDataHolder));
    }
  }
  
  private static final class RequestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Requests.LoadRequestsResult> zzawr;
    
    public RequestsLoadedBinderCallbacks(zzlb.zzb<Requests.LoadRequestsResult> paramzzb)
    {
      this.zzawr = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzd(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfG(paramInt);
      this.zzawr.zzp(new GamesClientImpl.LoadRequestsResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class RequestsUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Requests.UpdateRequestsResult> zzaws;
    
    public RequestsUpdatedBinderCallbacks(zzlb.zzb<Requests.UpdateRequestsResult> paramzzb)
    {
      this.zzaws = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzK(DataHolder paramDataHolder)
    {
      this.zzaws.zzp(new GamesClientImpl.UpdateRequestsResultImpl(paramDataHolder));
    }
  }
  
  private static final class RoomAutoMatchingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomAutoMatchingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  private static final class RoomBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlm<? extends RoomUpdateListener> zzawt;
    private final zzlm<? extends RoomStatusUpdateListener> zzawu;
    private final zzlm<RealTimeMessageReceivedListener> zzawv;
    
    public RoomBinderCallbacks(zzlm<RoomUpdateListener> paramzzlm)
    {
      this.zzawt = ((zzlm)zzx.zzb(paramzzlm, "Callbacks must not be null"));
      this.zzawu = null;
      this.zzawv = null;
    }
    
    public RoomBinderCallbacks(zzlm<? extends RoomUpdateListener> paramzzlm, zzlm<? extends RoomStatusUpdateListener> paramzzlm1, zzlm<RealTimeMessageReceivedListener> paramzzlm2)
    {
      this.zzawt = ((zzlm)zzx.zzb(paramzzlm, "Callbacks must not be null"));
      this.zzawu = paramzzlm1;
      this.zzawv = paramzzlm2;
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      this.zzawt.zza(new GamesClientImpl.LeftRoomNotifier(paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.P2PConnectedNotifier(paramString));
      }
    }
    
    public void onP2PDisconnected(String paramString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.P2PDisconnectedNotifier(paramString));
      }
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      if (this.zzawv != null) {
        this.zzawv.zza(new GamesClientImpl.MessageReceivedNotifier(paramRealTimeMessage));
      }
    }
    
    public void zzA(DataHolder paramDataHolder)
    {
      this.zzawt.zza(new GamesClientImpl.JoinedRoomNotifier(paramDataHolder));
    }
    
    public void zzB(DataHolder paramDataHolder)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.RoomConnectingNotifier(paramDataHolder));
      }
    }
    
    public void zzC(DataHolder paramDataHolder)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.RoomAutoMatchingNotifier(paramDataHolder));
      }
    }
    
    public void zzD(DataHolder paramDataHolder)
    {
      this.zzawt.zza(new GamesClientImpl.RoomConnectedNotifier(paramDataHolder));
    }
    
    public void zzE(DataHolder paramDataHolder)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.ConnectedToRoomNotifier(paramDataHolder));
      }
    }
    
    public void zzF(DataHolder paramDataHolder)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.DisconnectedFromRoomNotifier(paramDataHolder));
      }
    }
    
    public void zza(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerInvitedToRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzb(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerJoinedRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzc(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerLeftRoomNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzd(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerDeclinedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zze(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerConnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzf(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      if (this.zzawu != null) {
        this.zzawu.zza(new GamesClientImpl.PeerDisconnectedNotifier(paramDataHolder, paramArrayOfString));
      }
    }
    
    public void zzz(DataHolder paramDataHolder)
    {
      this.zzawt.zza(new GamesClientImpl.RoomCreatedNotifier(paramDataHolder));
    }
  }
  
  private static final class RoomConnectedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    RoomConnectedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  private static final class RoomConnectingNotifier
    extends GamesClientImpl.AbstractRoomStatusNotifier
  {
    RoomConnectingNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  private static final class RoomCreatedNotifier
    extends GamesClientImpl.AbstractRoomNotifier
  {
    public RoomCreatedNotifier(DataHolder paramDataHolder)
    {
      super();
    }
    
    public void zza(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  private static final class SendRequestResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.SendRequestResult
  {
    private final GameRequest zzawo;
    
    /* Error */
    SendRequestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/request/GameRequestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   30: invokeinterface 32 1 0
      //   35: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   38: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:zzawo	Lcom/google/android/gms/games/request/GameRequest;
      //   41: aload_1
      //   42: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:zzawo	Lcom/google/android/gms/games/request/GameRequest;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SendRequestResultImpl
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
  }
  
  private static final class SignOutCompleteBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Status> zzagy;
    
    public SignOutCompleteBinderCallbacks(zzlb.zzb<Status> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzur()
    {
      Status localStatus = GamesStatusCodes.zzfG(0);
      this.zzagy.zzp(localStatus);
    }
  }
  
  private static final class SnapshotCommittedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Snapshots.CommitSnapshotResult> zzaww;
    
    public SnapshotCommittedBinderCallbacks(zzlb.zzb<Snapshots.CommitSnapshotResult> paramzzb)
    {
      this.zzaww = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzO(DataHolder paramDataHolder)
    {
      this.zzaww.zzp(new GamesClientImpl.CommitSnapshotResultImpl(paramDataHolder));
    }
  }
  
  static final class SnapshotDeletedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Snapshots.DeleteSnapshotResult> zzagy;
    
    public SnapshotDeletedBinderCallbacks(zzlb.zzb<Snapshots.DeleteSnapshotResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzj(int paramInt, String paramString)
    {
      this.zzagy.zzp(new GamesClientImpl.DeleteSnapshotResultImpl(paramInt, paramString));
    }
  }
  
  private static final class SnapshotOpenedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Snapshots.OpenSnapshotResult> zzawx;
    
    public SnapshotOpenedBinderCallbacks(zzlb.zzb<Snapshots.OpenSnapshotResult> paramzzb)
    {
      this.zzawx = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zza(DataHolder paramDataHolder, Contents paramContents)
    {
      this.zzawx.zzp(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramContents));
    }
    
    public void zza(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      this.zzawx.zzp(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
    }
  }
  
  private static final class SnapshotsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Snapshots.LoadSnapshotsResult> zzawy;
    
    public SnapshotsLoadedBinderCallbacks(zzlb.zzb<Snapshots.LoadSnapshotsResult> paramzzb)
    {
      this.zzawy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzN(DataHolder paramDataHolder)
    {
      this.zzawy.zzp(new GamesClientImpl.LoadSnapshotsResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<Leaderboards.SubmitScoreResult> zzagy;
    
    public SubmitScoreBinderCallbacks(zzlb.zzb<Leaderboards.SubmitScoreResult> paramzzb)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzk(DataHolder paramDataHolder)
    {
      this.zzagy.zzp(new GamesClientImpl.SubmitScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData zzawz;
    
    public SubmitScoreResultImpl(DataHolder paramDataHolder)
    {
      super();
      try
      {
        this.zzawz = new ScoreSubmissionData(paramDataHolder);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.zzawz;
    }
  }
  
  private static final class TurnBasedMatchCanceledBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.CancelMatchResult> zzawA;
    
    public TurnBasedMatchCanceledBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.CancelMatchResult> paramzzb)
    {
      this.zzawA = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzi(int paramInt, String paramString)
    {
      Status localStatus = GamesStatusCodes.zzfG(paramInt);
      this.zzawA.zzp(new GamesClientImpl.CancelMatchResultImpl(localStatus, paramString));
    }
  }
  
  private static final class TurnBasedMatchInitiatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzawB;
    
    public TurnBasedMatchInitiatedBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.InitiateMatchResult> paramzzb)
    {
      this.zzawB = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzv(DataHolder paramDataHolder)
    {
      this.zzawB.zzp(new GamesClientImpl.InitiateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLeftBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzawC;
    
    public TurnBasedMatchLeftBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.LeaveMatchResult> paramzzb)
    {
      this.zzawC = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzx(DataHolder paramDataHolder)
    {
      this.zzawC.zzp(new GamesClientImpl.LeaveMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.LoadMatchResult> zzawD;
    
    public TurnBasedMatchLoadedBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.LoadMatchResult> paramzzb)
    {
      this.zzawD = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzu(DataHolder paramDataHolder)
    {
      this.zzawD.zzp(new GamesClientImpl.LoadMatchResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class TurnBasedMatchResult
    extends GamesClientImpl.GamesDataHolderResult
  {
    final TurnBasedMatch zzavY;
    
    /* Error */
    TurnBasedMatchResult(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/google/android/gms/games/internal/GamesClientImpl$GamesDataHolderResult:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 15	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 16	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 20	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 24	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   30: invokeinterface 30 1 0
      //   35: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   38: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:zzavY	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   41: aload_1
      //   42: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:zzavY	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	TurnBasedMatchResult
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.zzavY;
    }
  }
  
  private static final class TurnBasedMatchUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzawE;
    
    public TurnBasedMatchUpdatedBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.UpdateMatchResult> paramzzb)
    {
      this.zzawE = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzw(DataHolder paramDataHolder)
    {
      this.zzawE.zzp(new GamesClientImpl.UpdateMatchResultImpl(paramDataHolder));
    }
  }
  
  private static final class TurnBasedMatchesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final zzlb.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzawF;
    
    public TurnBasedMatchesLoadedBinderCallbacks(zzlb.zzb<TurnBasedMultiplayer.LoadMatchesResult> paramzzb)
    {
      this.zzawF = ((zzlb.zzb)zzx.zzb(paramzzb, "Holder must not be null"));
    }
    
    public void zzc(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = GamesStatusCodes.zzfG(paramInt);
      this.zzawF.zzp(new GamesClientImpl.LoadMatchesResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class UpdateAchievementResultImpl
    implements Achievements.UpdateAchievementResult
  {
    private final Status zzSC;
    private final String zzauq;
    
    UpdateAchievementResultImpl(int paramInt, String paramString)
    {
      this.zzSC = GamesStatusCodes.zzfG(paramInt);
      this.zzauq = paramString;
    }
    
    public String getAchievementId()
    {
      return this.zzauq;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class UpdateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    UpdateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class UpdateRequestsResultImpl
    extends GamesClientImpl.GamesDataHolderResult
    implements Requests.UpdateRequestsResult
  {
    private final RequestUpdateOutcomes zzawG;
    
    UpdateRequestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.zzawG = RequestUpdateOutcomes.zzaa(paramDataHolder);
    }
    
    public Set<String> getRequestIds()
    {
      return this.zzawG.getRequestIds();
    }
    
    public int getRequestOutcome(String paramString)
    {
      return this.zzawG.getRequestOutcome(paramString);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\GamesClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */