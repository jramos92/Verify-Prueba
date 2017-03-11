package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzb
  extends zzak
{
  private static final String ID = zzad.zzbf.toString();
  private final zza zzaVG;
  
  public zzb(Context paramContext)
  {
    this(zza.zzaN(paramContext));
  }
  
  zzb(zza paramzza)
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
    paramMap = this.zzaVG.zzCk();
    if (paramMap == null) {
      return zzdf.zzDX();
    }
    return zzdf.zzQ(paramMap);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */