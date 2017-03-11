package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpb
  extends zze<zzpb>
{
  private String zzOZ;
  private String zzPa;
  private String zzaLl;
  private String zzaLm;
  
  public void setAppId(String paramString)
  {
    this.zzaLl = paramString;
  }
  
  public void setAppInstallerId(String paramString)
  {
    this.zzaLm = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.zzOZ = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.zzPa = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", this.zzOZ);
    localHashMap.put("appVersion", this.zzPa);
    localHashMap.put("appId", this.zzaLl);
    localHashMap.put("appInstallerId", this.zzaLm);
    return zzB(localHashMap);
  }
  
  public void zza(zzpb paramzzpb)
  {
    if (!TextUtils.isEmpty(this.zzOZ)) {
      paramzzpb.setAppName(this.zzOZ);
    }
    if (!TextUtils.isEmpty(this.zzPa)) {
      paramzzpb.setAppVersion(this.zzPa);
    }
    if (!TextUtils.isEmpty(this.zzaLl)) {
      paramzzpb.setAppId(this.zzaLl);
    }
    if (!TextUtils.isEmpty(this.zzaLm)) {
      paramzzpb.setAppInstallerId(this.zzaLm);
    }
  }
  
  public String zzkp()
  {
    return this.zzOZ;
  }
  
  public String zzkr()
  {
    return this.zzPa;
  }
  
  public String zzuM()
  {
    return this.zzaLl;
  }
  
  public String zzyt()
  {
    return this.zzaLm;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */