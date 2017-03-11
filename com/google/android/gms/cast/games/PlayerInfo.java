package com.google.android.gms.cast.games;

import org.json.JSONObject;

public abstract interface PlayerInfo
{
  public abstract JSONObject getPlayerData();
  
  public abstract String getPlayerId();
  
  public abstract int getPlayerState();
  
  public abstract boolean isConnected();
  
  public abstract boolean isControllable();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\games\PlayerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */