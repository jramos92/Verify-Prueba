package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

public final class zzkt
  implements PlayerInfo
{
  private final int zzWw;
  private final String zzYf;
  private final JSONObject zzYv;
  private final boolean zzYw;
  
  public zzkt(String paramString, int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.zzYf = paramString;
    this.zzWw = paramInt;
    this.zzYv = paramJSONObject;
    this.zzYw = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PlayerInfo))) {}
    do
    {
      return false;
      paramObject = (PlayerInfo)paramObject;
    } while ((this.zzYw != ((PlayerInfo)paramObject).isControllable()) || (this.zzWw != ((PlayerInfo)paramObject).getPlayerState()) || (!zzf.zza(this.zzYf, ((PlayerInfo)paramObject).getPlayerId())) || (!zzmu.zzd(this.zzYv, ((PlayerInfo)paramObject).getPlayerData())));
    return true;
  }
  
  public JSONObject getPlayerData()
  {
    return this.zzYv;
  }
  
  public String getPlayerId()
  {
    return this.zzYf;
  }
  
  public int getPlayerState()
  {
    return this.zzWw;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzYf, Integer.valueOf(this.zzWw), this.zzYv, Boolean.valueOf(this.zzYw) });
  }
  
  public boolean isConnected()
  {
    switch (this.zzWw)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isControllable()
  {
    return this.zzYw;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */