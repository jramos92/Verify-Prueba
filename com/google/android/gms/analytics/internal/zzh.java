package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private final long zzMY;
  private final String zzMZ;
  private final String zzMj;
  private final boolean zzNa;
  private long zzNb;
  private final Map<String, String> zzvS;
  
  public zzh(long paramLong1, String paramString1, String paramString2, boolean paramBoolean, long paramLong2, Map<String, String> paramMap)
  {
    zzx.zzcr(paramString1);
    zzx.zzcr(paramString2);
    this.zzMY = paramLong1;
    this.zzMj = paramString1;
    this.zzMZ = paramString2;
    this.zzNa = paramBoolean;
    this.zzNb = paramLong2;
    if (paramMap != null)
    {
      this.zzvS = new HashMap(paramMap);
      return;
    }
    this.zzvS = Collections.emptyMap();
  }
  
  public String getClientId()
  {
    return this.zzMj;
  }
  
  public long zziM()
  {
    return this.zzMY;
  }
  
  public String zziN()
  {
    return this.zzMZ;
  }
  
  public boolean zziO()
  {
    return this.zzNa;
  }
  
  public long zziP()
  {
    return this.zzNb;
  }
  
  public Map<String, String> zzn()
  {
    return this.zzvS;
  }
  
  public void zzn(long paramLong)
  {
    this.zzNb = paramLong;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */