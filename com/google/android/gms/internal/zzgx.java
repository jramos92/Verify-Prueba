package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgr
class zzgx
{
  private final String zzBY;
  private int zzDv;
  private String zzF;
  private final List<String> zzGl;
  private final List<String> zzGm;
  private final String zzGn;
  private final String zzGo;
  private final String zzGp;
  private final String zzGq;
  private final boolean zzGr;
  
  public zzgx(int paramInt, Map<String, String> paramMap)
  {
    this.zzF = ((String)paramMap.get("url"));
    this.zzGo = ((String)paramMap.get("base_uri"));
    this.zzGp = ((String)paramMap.get("post_parameters"));
    this.zzGr = parseBoolean((String)paramMap.get("drt_include"));
    this.zzGn = ((String)paramMap.get("activation_overlay_url"));
    this.zzGm = zzat((String)paramMap.get("check_packages"));
    this.zzBY = ((String)paramMap.get("request_id"));
    this.zzGq = ((String)paramMap.get("type"));
    this.zzGl = zzat((String)paramMap.get("errors"));
    this.zzDv = paramInt;
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> zzat(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public int getErrorCode()
  {
    return this.zzDv;
  }
  
  public String getRequestId()
  {
    return this.zzBY;
  }
  
  public String getType()
  {
    return this.zzGq;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public void setUrl(String paramString)
  {
    this.zzF = paramString;
  }
  
  public List<String> zzfU()
  {
    return this.zzGl;
  }
  
  public String zzfV()
  {
    return this.zzGp;
  }
  
  public boolean zzfW()
  {
    return this.zzGr;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */