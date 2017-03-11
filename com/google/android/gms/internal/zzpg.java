package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzpg
  extends zze<zzpg>
{
  public boolean zzaLx;
  public String zzaqZ;
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void setDescription(String paramString)
  {
    this.zzaqZ = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", this.zzaqZ);
    localHashMap.put("fatal", Boolean.valueOf(this.zzaLx));
    return zzB(localHashMap);
  }
  
  public void zza(zzpg paramzzpg)
  {
    if (!TextUtils.isEmpty(this.zzaqZ)) {
      paramzzpg.setDescription(this.zzaqZ);
    }
    if (this.zzaLx) {
      paramzzpg.zzak(this.zzaLx);
    }
  }
  
  public void zzak(boolean paramBoolean)
  {
    this.zzaLx = paramBoolean;
  }
  
  public boolean zzyK()
  {
    return this.zzaLx;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */