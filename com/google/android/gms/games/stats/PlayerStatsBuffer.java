package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class PlayerStatsBuffer
  extends AbstractDataBuffer<PlayerStats>
{
  public PlayerStatsBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public PlayerStats zzgy(int paramInt)
  {
    return new PlayerStatsRef(this.zzabq, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\stats\PlayerStatsBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */