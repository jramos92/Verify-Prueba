package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader
{
  private final Bundle zzRj;
  
  public LeaderboardScoreBufferHeader(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzRj = localBundle;
  }
  
  public Bundle asBundle()
  {
    return this.zzRj;
  }
  
  public static final class Builder {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardScoreBufferHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */