package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer
  extends zzf<Leaderboard>
{
  public LeaderboardBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected Leaderboard zzn(int paramInt1, int paramInt2)
  {
    return new LeaderboardRef(this.zzabq, paramInt1, paramInt2);
  }
  
  protected String zzoy()
  {
    return "external_leaderboard_id";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */