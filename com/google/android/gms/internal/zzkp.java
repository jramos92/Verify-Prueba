package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzkp
{
  private final String zzYi;
  private final int zzYj;
  private final String zzYk;
  
  public zzkp(String paramString1, int paramInt, String paramString2)
  {
    this.zzYi = paramString1;
    this.zzYj = paramInt;
    this.zzYk = paramString2;
  }
  
  public zzkp(JSONObject paramJSONObject)
    throws JSONException
  {
    this(paramJSONObject.optString("applicationName"), paramJSONObject.optInt("maxPlayers"), paramJSONObject.optString("version"));
  }
  
  public final int getMaxPlayers()
  {
    return this.zzYj;
  }
  
  public final String getVersion()
  {
    return this.zzYk;
  }
  
  public final String zzmH()
  {
    return this.zzYi;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */