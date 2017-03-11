package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpd
  extends zze<zzpd>
{
  public int zzAD;
  public int zzAE;
  private String zzVT;
  public int zzaLt;
  public int zzaLu;
  public int zzaLv;
  
  public String getLanguage()
  {
    return this.zzVT;
  }
  
  public void setLanguage(String paramString)
  {
    this.zzVT = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", this.zzVT);
    localHashMap.put("screenColors", Integer.valueOf(this.zzaLt));
    localHashMap.put("screenWidth", Integer.valueOf(this.zzAD));
    localHashMap.put("screenHeight", Integer.valueOf(this.zzAE));
    localHashMap.put("viewportWidth", Integer.valueOf(this.zzaLu));
    localHashMap.put("viewportHeight", Integer.valueOf(this.zzaLv));
    return zzB(localHashMap);
  }
  
  public void zza(zzpd paramzzpd)
  {
    if (this.zzaLt != 0) {
      paramzzpd.zzhW(this.zzaLt);
    }
    if (this.zzAD != 0) {
      paramzzpd.zzhX(this.zzAD);
    }
    if (this.zzAE != 0) {
      paramzzpd.zzhY(this.zzAE);
    }
    if (this.zzaLu != 0) {
      paramzzpd.zzhZ(this.zzaLu);
    }
    if (this.zzaLv != 0) {
      paramzzpd.zzia(this.zzaLv);
    }
    if (!TextUtils.isEmpty(this.zzVT)) {
      paramzzpd.setLanguage(this.zzVT);
    }
  }
  
  public void zzhW(int paramInt)
  {
    this.zzaLt = paramInt;
  }
  
  public void zzhX(int paramInt)
  {
    this.zzAD = paramInt;
  }
  
  public void zzhY(int paramInt)
  {
    this.zzAE = paramInt;
  }
  
  public void zzhZ(int paramInt)
  {
    this.zzaLu = paramInt;
  }
  
  public void zzia(int paramInt)
  {
    this.zzaLv = paramInt;
  }
  
  public int zzyA()
  {
    return this.zzaLt;
  }
  
  public int zzyB()
  {
    return this.zzAD;
  }
  
  public int zzyC()
  {
    return this.zzAE;
  }
  
  public int zzyD()
  {
    return this.zzaLu;
  }
  
  public int zzyE()
  {
    return this.zzaLv;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */