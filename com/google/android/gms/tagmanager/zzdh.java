package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzdh
  extends zzak
{
  private static final String ID = zzad.zzbU.toString();
  private static final String zzaWU = zzae.zzdz.toString();
  
  public zzdh()
  {
    super(ID, new String[] { zzaWU });
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    return zzdf.zzQ(zzdf.zzg((zzag.zza)paramMap.get(zzaWU)).toUpperCase());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */