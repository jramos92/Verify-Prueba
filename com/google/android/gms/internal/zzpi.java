package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpi
  extends zze<zzpi>
{
  public String zzPp;
  public String zzaLG;
  public String zzaLH;
  
  public String getAction()
  {
    return this.zzPp;
  }
  
  public String getTarget()
  {
    return this.zzaLH;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", this.zzaLG);
    localHashMap.put("action", this.zzPp);
    localHashMap.put("target", this.zzaLH);
    return zzB(localHashMap);
  }
  
  public void zza(zzpi paramzzpi)
  {
    if (!TextUtils.isEmpty(this.zzaLG)) {
      paramzzpi.zzdV(this.zzaLG);
    }
    if (!TextUtils.isEmpty(this.zzPp)) {
      paramzzpi.zzdR(this.zzPp);
    }
    if (!TextUtils.isEmpty(this.zzaLH)) {
      paramzzpi.zzdW(this.zzaLH);
    }
  }
  
  public void zzdR(String paramString)
  {
    this.zzPp = paramString;
  }
  
  public void zzdV(String paramString)
  {
    this.zzaLG = paramString;
  }
  
  public void zzdW(String paramString)
  {
    this.zzaLH = paramString;
  }
  
  public String zzyQ()
  {
    return this.zzaLG;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */