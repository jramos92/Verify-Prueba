package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjn
  extends zze<zzjn>
{
  private final Map<String, Object> zzvS = new HashMap();
  
  private String zzaT(String paramString)
  {
    zzx.zzcr(paramString);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("&")) {
        str = paramString.substring(1);
      }
    }
    zzx.zzh(str, "Name can not be empty or \"&\"");
    return str;
  }
  
  public void set(String paramString1, String paramString2)
  {
    paramString1 = zzaT(paramString1);
    this.zzvS.put(paramString1, paramString2);
  }
  
  public String toString()
  {
    return zzB(this.zzvS);
  }
  
  public void zza(zzjn paramzzjn)
  {
    zzx.zzw(paramzzjn);
    paramzzjn.zzvS.putAll(this.zzvS);
  }
  
  public Map<String, Object> zzhZ()
  {
    return Collections.unmodifiableMap(this.zzvS);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */