package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpc
  extends zze<zzpc>
{
  private String mName;
  private String zzaGu;
  private String zzaLn;
  private String zzaLo;
  private String zzaLp;
  private String zzaLq;
  private String zzaLr;
  private String zzaLs;
  private String zzvY;
  private String zzwN;
  
  public String getContent()
  {
    return this.zzvY;
  }
  
  public String getId()
  {
    return this.zzwN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSource()
  {
    return this.zzaGu;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", this.mName);
    localHashMap.put("source", this.zzaGu);
    localHashMap.put("medium", this.zzaLn);
    localHashMap.put("keyword", this.zzaLo);
    localHashMap.put("content", this.zzvY);
    localHashMap.put("id", this.zzwN);
    localHashMap.put("adNetworkId", this.zzaLp);
    localHashMap.put("gclid", this.zzaLq);
    localHashMap.put("dclid", this.zzaLr);
    localHashMap.put("aclid", this.zzaLs);
    return zzB(localHashMap);
  }
  
  public void zza(zzpc paramzzpc)
  {
    if (!TextUtils.isEmpty(this.mName)) {
      paramzzpc.setName(this.mName);
    }
    if (!TextUtils.isEmpty(this.zzaGu)) {
      paramzzpc.zzdH(this.zzaGu);
    }
    if (!TextUtils.isEmpty(this.zzaLn)) {
      paramzzpc.zzdI(this.zzaLn);
    }
    if (!TextUtils.isEmpty(this.zzaLo)) {
      paramzzpc.zzdJ(this.zzaLo);
    }
    if (!TextUtils.isEmpty(this.zzvY)) {
      paramzzpc.zzdK(this.zzvY);
    }
    if (!TextUtils.isEmpty(this.zzwN)) {
      paramzzpc.zzdL(this.zzwN);
    }
    if (!TextUtils.isEmpty(this.zzaLp)) {
      paramzzpc.zzdM(this.zzaLp);
    }
    if (!TextUtils.isEmpty(this.zzaLq)) {
      paramzzpc.zzdN(this.zzaLq);
    }
    if (!TextUtils.isEmpty(this.zzaLr)) {
      paramzzpc.zzdO(this.zzaLr);
    }
    if (!TextUtils.isEmpty(this.zzaLs)) {
      paramzzpc.zzdP(this.zzaLs);
    }
  }
  
  public void zzdH(String paramString)
  {
    this.zzaGu = paramString;
  }
  
  public void zzdI(String paramString)
  {
    this.zzaLn = paramString;
  }
  
  public void zzdJ(String paramString)
  {
    this.zzaLo = paramString;
  }
  
  public void zzdK(String paramString)
  {
    this.zzvY = paramString;
  }
  
  public void zzdL(String paramString)
  {
    this.zzwN = paramString;
  }
  
  public void zzdM(String paramString)
  {
    this.zzaLp = paramString;
  }
  
  public void zzdN(String paramString)
  {
    this.zzaLq = paramString;
  }
  
  public void zzdO(String paramString)
  {
    this.zzaLr = paramString;
  }
  
  public void zzdP(String paramString)
  {
    this.zzaLs = paramString;
  }
  
  public String zzyu()
  {
    return this.zzaLn;
  }
  
  public String zzyv()
  {
    return this.zzaLo;
  }
  
  public String zzyw()
  {
    return this.zzaLp;
  }
  
  public String zzyx()
  {
    return this.zzaLq;
  }
  
  public String zzyy()
  {
    return this.zzaLr;
  }
  
  public String zzyz()
  {
    return this.zzaLs;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */