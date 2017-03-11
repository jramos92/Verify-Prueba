package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef
  extends zzc
  implements LeaderboardScore
{
  private final PlayerRef zzaAk;
  
  LeaderboardScoreRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.zzaAk = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardScoreEntity.zza(this, paramObject);
  }
  
  public String getDisplayRank()
  {
    return getString("display_rank");
  }
  
  public void getDisplayRank(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("display_rank", paramCharArrayBuffer);
  }
  
  public String getDisplayScore()
  {
    return getString("display_score");
  }
  
  public void getDisplayScore(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("display_score", paramCharArrayBuffer);
  }
  
  public long getRank()
  {
    return getLong("rank");
  }
  
  public long getRawScore()
  {
    return getLong("raw_score");
  }
  
  public Player getScoreHolder()
  {
    if (zzcg("external_player_id")) {
      return null;
    }
    return this.zzaAk;
  }
  
  public String getScoreHolderDisplayName()
  {
    if (zzcg("external_player_id")) {
      return getString("default_display_name");
    }
    return this.zzaAk.getDisplayName();
  }
  
  public void getScoreHolderDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (zzcg("external_player_id"))
    {
      zza("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.zzaAk.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getScoreHolderHiResImageUri()
  {
    if (zzcg("external_player_id")) {
      return null;
    }
    return this.zzaAk.getHiResImageUri();
  }
  
  public String getScoreHolderHiResImageUrl()
  {
    if (zzcg("external_player_id")) {
      return null;
    }
    return this.zzaAk.getHiResImageUrl();
  }
  
  public Uri getScoreHolderIconImageUri()
  {
    if (zzcg("external_player_id")) {
      return zzcf("default_display_image_uri");
    }
    return this.zzaAk.getIconImageUri();
  }
  
  public String getScoreHolderIconImageUrl()
  {
    if (zzcg("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.zzaAk.getIconImageUrl();
  }
  
  public String getScoreTag()
  {
    return getString("score_tag");
  }
  
  public long getTimestampMillis()
  {
    return getLong("achieved_timestamp");
  }
  
  public int hashCode()
  {
    return LeaderboardScoreEntity.zza(this);
  }
  
  public String toString()
  {
    return LeaderboardScoreEntity.zzb(this);
  }
  
  public LeaderboardScore zzvI()
  {
    return new LeaderboardScoreEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardScoreRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */