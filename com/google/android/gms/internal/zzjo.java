package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzjo
  extends zze<zzjo>
{
  private String zzGY;
  private String zzMi;
  private String zzMj;
  private String zzMk;
  private boolean zzMl;
  private String zzMm;
  private boolean zzMn;
  private double zzMo;
  
  public String getClientId()
  {
    return this.zzMj;
  }
  
  public String getUserId()
  {
    return this.zzGY;
  }
  
  public void setClientId(String paramString)
  {
    this.zzMj = paramString;
  }
  
  public void setSampleRate(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 100.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Sample rate must be between 0% and 100%");
      this.zzMo = paramDouble;
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    this.zzGY = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", this.zzMi);
    localHashMap.put("clientId", this.zzMj);
    localHashMap.put("userId", this.zzGY);
    localHashMap.put("androidAdId", this.zzMk);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzMl));
    localHashMap.put("sessionControl", this.zzMm);
    localHashMap.put("nonInteraction", Boolean.valueOf(this.zzMn));
    localHashMap.put("sampleRate", Double.valueOf(this.zzMo));
    return zzB(localHashMap);
  }
  
  public void zzG(boolean paramBoolean)
  {
    this.zzMl = paramBoolean;
  }
  
  public void zzH(boolean paramBoolean)
  {
    this.zzMn = paramBoolean;
  }
  
  public void zza(zzjo paramzzjo)
  {
    if (!TextUtils.isEmpty(this.zzMi)) {
      paramzzjo.zzaU(this.zzMi);
    }
    if (!TextUtils.isEmpty(this.zzMj)) {
      paramzzjo.setClientId(this.zzMj);
    }
    if (!TextUtils.isEmpty(this.zzGY)) {
      paramzzjo.setUserId(this.zzGY);
    }
    if (!TextUtils.isEmpty(this.zzMk)) {
      paramzzjo.zzaV(this.zzMk);
    }
    if (this.zzMl) {
      paramzzjo.zzG(true);
    }
    if (!TextUtils.isEmpty(this.zzMm)) {
      paramzzjo.zzaW(this.zzMm);
    }
    if (this.zzMn) {
      paramzzjo.zzH(this.zzMn);
    }
    if (this.zzMo != 0.0D) {
      paramzzjo.setSampleRate(this.zzMo);
    }
  }
  
  public void zzaU(String paramString)
  {
    this.zzMi = paramString;
  }
  
  public void zzaV(String paramString)
  {
    this.zzMk = paramString;
  }
  
  public void zzaW(String paramString)
  {
    this.zzMm = paramString;
  }
  
  public String zzia()
  {
    return this.zzMi;
  }
  
  public String zzib()
  {
    return this.zzMk;
  }
  
  public boolean zzic()
  {
    return this.zzMl;
  }
  
  public String zzid()
  {
    return this.zzMm;
  }
  
  public boolean zzie()
  {
    return this.zzMn;
  }
  
  public double zzif()
  {
    return this.zzMo;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */