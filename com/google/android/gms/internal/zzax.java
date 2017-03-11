package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzgr
public final class zzax
{
  private final String zzqS;
  private final JSONObject zzqT;
  private final String zzqU;
  private final String zzqV;
  private final boolean zzqW;
  
  public zzax(String paramString1, VersionInfoParcel paramVersionInfoParcel, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.zzqV = paramVersionInfoParcel.zzJu;
    this.zzqT = paramJSONObject;
    this.zzqU = paramString1;
    this.zzqS = paramString2;
    this.zzqW = paramBoolean;
  }
  
  public String zzbU()
  {
    return this.zzqS;
  }
  
  public String zzbV()
  {
    return this.zzqV;
  }
  
  public JSONObject zzbW()
  {
    return this.zzqT;
  }
  
  public String zzbX()
  {
    return this.zzqU;
  }
  
  public boolean zzbY()
  {
    return this.zzqW;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */