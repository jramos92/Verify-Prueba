package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkq
{
  private static final zzl zzVo = new zzl("GameManagerMessage");
  protected final zzkp zzXM;
  protected final String zzYf;
  protected final long zzYg;
  protected final JSONObject zzYh;
  protected final int zzYl;
  protected final int zzYm;
  protected final String zzYn;
  protected final int zzYo;
  protected final int zzYp;
  protected final List<zzku> zzYq;
  protected final JSONObject zzYr;
  protected final String zzYs;
  protected final String zzYt;
  
  public zzkq(int paramInt1, int paramInt2, String paramString1, JSONObject paramJSONObject1, int paramInt3, int paramInt4, List<zzku> paramList, JSONObject paramJSONObject2, String paramString2, String paramString3, long paramLong, String paramString4, zzkp paramzzkp)
  {
    this.zzYl = paramInt1;
    this.zzYm = paramInt2;
    this.zzYn = paramString1;
    this.zzYh = paramJSONObject1;
    this.zzYo = paramInt3;
    this.zzYp = paramInt4;
    this.zzYq = paramList;
    this.zzYr = paramJSONObject2;
    this.zzYs = paramString2;
    this.zzYf = paramString3;
    this.zzYg = paramLong;
    this.zzYt = paramString4;
    this.zzXM = paramzzkp;
  }
  
  private static List<zzku> zza(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        Object localObject1 = paramJSONArray.optJSONObject(i);
        if (localObject1 != null) {}
        try
        {
          localObject1 = new zzku((JSONObject)localObject1);
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            zzVo.zzc(localJSONException, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", new Object[] { Integer.valueOf(i) });
            Object localObject2 = null;
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected static zzkq zzh(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("type", -1);
    switch (i)
    {
    }
    try
    {
      zzVo.zzf("Unrecognized Game Message type %d", new Object[] { Integer.valueOf(i) });
    }
    catch (JSONException paramJSONObject)
    {
      zzVo.zzc(paramJSONObject, "Exception while parsing GameManagerMessage from json", new Object[0]);
      break label247;
      zzkp localzzkp = null;
      JSONObject localJSONObject = paramJSONObject.optJSONObject("gameManagerConfig");
      if (localJSONObject == null) {
        break label166;
      }
      localzzkp = new zzkp(localJSONObject);
      label166:
      paramJSONObject = new zzkq(i, paramJSONObject.optInt("statusCode"), paramJSONObject.optString("errorDescription"), paramJSONObject.optJSONObject("extraMessageData"), paramJSONObject.optInt("gameplayState"), paramJSONObject.optInt("lobbyState"), zza(paramJSONObject.optJSONArray("players")), paramJSONObject.optJSONObject("gameData"), paramJSONObject.optString("gameStatusText"), paramJSONObject.optString("playerId"), paramJSONObject.optLong("requestId"), paramJSONObject.optString("playerToken"), localzzkp);
      return paramJSONObject;
    }
    paramJSONObject = new zzkq(i, paramJSONObject.optInt("statusCode"), paramJSONObject.optString("errorDescription"), paramJSONObject.optJSONObject("extraMessageData"), paramJSONObject.optInt("gameplayState"), paramJSONObject.optInt("lobbyState"), zza(paramJSONObject.optJSONArray("players")), paramJSONObject.optJSONObject("gameData"), paramJSONObject.optString("gameStatusText"), paramJSONObject.optString("playerId"), -1L, null, null);
    return paramJSONObject;
    label247:
    return null;
  }
  
  public final JSONObject getExtraMessageData()
  {
    return this.zzYh;
  }
  
  public final JSONObject getGameData()
  {
    return this.zzYr;
  }
  
  public final int getGameplayState()
  {
    return this.zzYo;
  }
  
  public final int getLobbyState()
  {
    return this.zzYp;
  }
  
  public final String getPlayerId()
  {
    return this.zzYf;
  }
  
  public final long getRequestId()
  {
    return this.zzYg;
  }
  
  public final int getStatusCode()
  {
    return this.zzYm;
  }
  
  public final int zzmI()
  {
    return this.zzYl;
  }
  
  public final String zzmJ()
  {
    return this.zzYn;
  }
  
  public final List<zzku> zzmK()
  {
    return this.zzYq;
  }
  
  public final String zzmL()
  {
    return this.zzYs;
  }
  
  public final String zzmM()
  {
    return this.zzYt;
  }
  
  public final zzkp zzmN()
  {
    return this.zzXM;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */