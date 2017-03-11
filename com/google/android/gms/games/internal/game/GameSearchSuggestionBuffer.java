package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer
  extends AbstractDataBuffer<GameSearchSuggestion>
{
  public GameSearchSuggestionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public GameSearchSuggestion zzge(int paramInt)
  {
    return new GameSearchSuggestionRef(this.zzabq, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\game\GameSearchSuggestionBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */