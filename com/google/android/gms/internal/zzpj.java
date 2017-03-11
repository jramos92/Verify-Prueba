package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpj
  extends zze<zzpj>
{
  public String mCategory;
  public String zzaLI;
  public long zzaLJ;
  public String zzaLw;
  
  public String getLabel()
  {
    return this.zzaLw;
  }
  
  public long getTimeInMillis()
  {
    return this.zzaLJ;
  }
  
  public void setTimeInMillis(long paramLong)
  {
    this.zzaLJ = paramLong;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", this.zzaLI);
    localHashMap.put("timeInMillis", Long.valueOf(this.zzaLJ));
    localHashMap.put("category", this.mCategory);
    localHashMap.put("label", this.zzaLw);
    return zzB(localHashMap);
  }
  
  public void zza(zzpj paramzzpj)
  {
    if (!TextUtils.isEmpty(this.zzaLI)) {
      paramzzpj.zzdX(this.zzaLI);
    }
    if (this.zzaLJ != 0L) {
      paramzzpj.setTimeInMillis(this.zzaLJ);
    }
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzpj.zzdQ(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.zzaLw)) {
      paramzzpj.zzdS(this.zzaLw);
    }
  }
  
  public void zzdQ(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzdS(String paramString)
  {
    this.zzaLw = paramString;
  }
  
  public void zzdX(String paramString)
  {
    this.zzaLI = paramString;
  }
  
  public String zzyJ()
  {
    return this.mCategory;
  }
  
  public String zzyR()
  {
    return this.zzaLI;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */