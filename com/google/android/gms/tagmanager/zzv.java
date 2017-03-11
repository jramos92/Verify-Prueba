package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzv
  extends zzak
{
  private static final String ID = zzad.zzbn.toString();
  private static final String NAME = zzae.zzfR.toString();
  private static final String zzaWE = zzae.zzeC.toString();
  private final DataLayer zzaVR;
  
  public zzv(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.zzaVR = paramDataLayer;
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = this.zzaVR.get(zzdf.zzg((zzag.zza)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzag.zza)paramMap.get(zzaWE);
      if (paramMap != null) {
        return paramMap;
      }
      return zzdf.zzDX();
    }
    return zzdf.zzQ(localObject);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */