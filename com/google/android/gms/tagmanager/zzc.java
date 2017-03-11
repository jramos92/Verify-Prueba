package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzc
  extends zzak
{
  private static final String ID = zzad.zzbg.toString();
  private final zza zzaVG;
  
  public zzc(Context paramContext)
  {
    this(zza.zzaN(paramContext));
  }
  
  zzc(zza paramzza)
  {
    super(ID, new String[0]);
    this.zzaVG = paramzza;
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    if (!this.zzaVG.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return zzdf.zzQ(Boolean.valueOf(bool));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */