package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class LeaderboardScoreEntity
  implements LeaderboardScore
{
  private final String zzaAa;
  private final long zzaAb;
  private final long zzaAc;
  private final String zzaAd;
  private final Uri zzaAe;
  private final Uri zzaAf;
  private final PlayerEntity zzaAg;
  private final String zzaAh;
  private final String zzaAi;
  private final String zzaAj;
  private final long zzazY;
  private final String zzazZ;
  
  public LeaderboardScoreEntity(LeaderboardScore paramLeaderboardScore)
  {
    this.zzazY = paramLeaderboardScore.getRank();
    this.zzazZ = ((String)zzx.zzw(paramLeaderboardScore.getDisplayRank()));
    this.zzaAa = ((String)zzx.zzw(paramLeaderboardScore.getDisplayScore()));
    this.zzaAb = paramLeaderboardScore.getRawScore();
    this.zzaAc = paramLeaderboardScore.getTimestampMillis();
    this.zzaAd = paramLeaderboardScore.getScoreHolderDisplayName();
    this.zzaAe = paramLeaderboardScore.getScoreHolderIconImageUri();
    this.zzaAf = paramLeaderboardScore.getScoreHolderHiResImageUri();
    Object localObject = paramLeaderboardScore.getScoreHolder();
    if (localObject == null) {}
    for (localObject = null;; localObject = (PlayerEntity)((Player)localObject).freeze())
    {
      this.zzaAg = ((PlayerEntity)localObject);
      this.zzaAh = paramLeaderboardScore.getScoreTag();
      this.zzaAi = paramLeaderboardScore.getScoreHolderIconImageUrl();
      this.zzaAj = paramLeaderboardScore.getScoreHolderHiResImageUrl();
      return;
    }
  }
  
  static int zza(LeaderboardScore paramLeaderboardScore)
  {
    return zzw.hashCode(new Object[] { Long.valueOf(paramLeaderboardScore.getRank()), paramLeaderboardScore.getDisplayRank(), Long.valueOf(paramLeaderboardScore.getRawScore()), paramLeaderboardScore.getDisplayScore(), Long.valueOf(paramLeaderboardScore.getTimestampMillis()), paramLeaderboardScore.getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolder() });
  }
  
  static boolean zza(LeaderboardScore paramLeaderboardScore, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardScore)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardScore == paramObject);
      paramObject = (LeaderboardScore)paramObject;
      if ((!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getRank()), Long.valueOf(paramLeaderboardScore.getRank()))) || (!zzw.equal(((LeaderboardScore)paramObject).getDisplayRank(), paramLeaderboardScore.getDisplayRank())) || (!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getRawScore()), Long.valueOf(paramLeaderboardScore.getRawScore()))) || (!zzw.equal(((LeaderboardScore)paramObject).getDisplayScore(), paramLeaderboardScore.getDisplayScore())) || (!zzw.equal(Long.valueOf(((LeaderboardScore)paramObject).getTimestampMillis()), Long.valueOf(paramLeaderboardScore.getTimestampMillis()))) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderDisplayName(), paramLeaderboardScore.getScoreHolderDisplayName())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderIconImageUri(), paramLeaderboardScore.getScoreHolderIconImageUri())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolderHiResImageUri(), paramLeaderboardScore.getScoreHolderHiResImageUri())) || (!zzw.equal(((LeaderboardScore)paramObject).getScoreHolder(), paramLeaderboardScore.getScoreHolder()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((LeaderboardScore)paramObject).getScoreTag(), paramLeaderboardScore.getScoreTag()));
    return false;
  }
  
  static String zzb(LeaderboardScore paramLeaderboardScore)
  {
    zzw.zza localzza = zzw.zzv(paramLeaderboardScore).zzg("Rank", Long.valueOf(paramLeaderboardScore.getRank())).zzg("DisplayRank", paramLeaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(paramLeaderboardScore.getRawScore())).zzg("DisplayScore", paramLeaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(paramLeaderboardScore.getTimestampMillis())).zzg("DisplayName", paramLeaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", paramLeaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", paramLeaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", paramLeaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", paramLeaderboardScore.getScoreHolderHiResImageUrl());
    if (paramLeaderboardScore.getScoreHolder() == null) {}
    for (Object localObject = null;; localObject = paramLeaderboardScore.getScoreHolder()) {
      return localzza.zzg("Player", localObject).zzg("ScoreTag", paramLeaderboardScore.getScoreTag()).toString();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return this.zzazZ;
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzazZ, paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return this.zzaAa;
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaAa, paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return this.zzazY;
  }
  
  public long getRawScore()
  {
    return this.zzaAb;
  }
  
  public Player getScoreHolder()
  {
    return this.zzaAg;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (this.zzaAg == null) {
      return this.zzaAd;
    }
    return this.zzaAg.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.zzaAg == null)
    {
      zzmo.zzb(this.zzaAd, paramCharArrayBuffer);
      return;
    }
    this.zzaAg.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (this.zzaAg == null) {
      return this.zzaAf;
    }
    return this.zzaAg.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (this.zzaAg == null) {
      return this.zzaAj;
    }
    return this.zzaAg.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (this.zzaAg == null) {
      return this.zzaAe;
    }
    return this.zzaAg.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (this.zzaAg == null) {
      return this.zzaAi;
    }
    return this.zzaAg.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return this.zzaAh;
  }
  
  public long getTimestampMillis()
  {
    return this.zzaAc;
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
  
  public LeaderboardScore zzvI()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardScoreEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */