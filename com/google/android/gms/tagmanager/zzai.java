package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzai
  extends zzak
{
  private static final String ID = zzad.zzbv.toString();
  private final zzcp zzaVS;
  
  public zzai(zzcp paramzzcp)
  {
    super(ID, new String[0]);
    this.zzaVS = paramzzcp;
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    paramMap = this.zzaVS.zzDw();
    if (paramMap == null) {
      return zzdf.zzDX();
    }
    return zzdf.zzQ(paramMap);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */