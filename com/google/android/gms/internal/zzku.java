package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzku
{
  private final int zzWw;
  private final String zzYf;
  private final JSONObject zzYv;
  
  public zzku(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    this.zzYf = paramString;
    this.zzWw = paramInt;
    this.zzYv = paramJSONObject;
  }
  
  public zzku(JSONObject paramJSONObject)
    throws JSONException
  {
    this(paramJSONObject.optString("playerId"), paramJSONObject.optInt("playerState"), paramJSONObject.optJSONObject("playerData"));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zzku))) {}
    do
    {
      return false;
      paramObject = (zzku)paramObject;
    } while ((this.zzWw != ((zzku)paramObject).getPlayerState()) || (!zzf.zza(this.zzYf, ((zzku)paramObject).getPlayerId())) || (!zzmu.zzd(this.zzYv, ((zzku)paramObject).getPlayerData())));
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
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */