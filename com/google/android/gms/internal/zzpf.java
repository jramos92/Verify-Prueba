package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpf
  extends zze<zzpf>
{
  private String mCategory;
  private String zzPp;
  private String zzaLw;
  private long zzavc;
  
  public String getAction()
  {
    return this.zzPp;
  }
  
  public String getLabel()
  {
    return this.zzaLw;
  }
  
  public long getValue()
  {
    return this.zzavc;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", this.mCategory);
    localHashMap.put("action", this.zzPp);
    localHashMap.put("label", this.zzaLw);
    localHashMap.put("value", Long.valueOf(this.zzavc));
    return zzB(localHashMap);
  }
  
  public void zzM(long paramLong)
  {
    this.zzavc = paramLong;
  }
  
  public void zza(zzpf paramzzpf)
  {
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzpf.zzdQ(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzPp)) {
      paramzzpf.zzdR(this.zzPp);
    }
    if (!TextUtils.isEmpty(this.zzaLw)) {
      paramzzpf.zzdS(this.zzaLw);
    }
    if (this.zzavc != 0L) {
      paramzzpf.zzM(this.zzavc);
    }
  }
  
  public void zzdQ(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzdR(String paramString)
  {
    this.zzPp = paramString;
  }
  
  public void zzdS(String paramString)
  {
    this.zzaLw = paramString;
  }
  
  public String zzyJ()
  {
    return this.mCategory;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */