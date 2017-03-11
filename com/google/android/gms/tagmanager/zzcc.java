package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcc
  extends zzak
{
  private static final String ID = zzad.zzbB.toString();
  private static final String zzaYc = zzae.zzfP.toString();
  private static final String zzaYd = zzae.zzfN.toString();
  
  public zzcc()
  {
    super(ID, new String[0]);
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzaYc);
    paramMap = (zzag.zza)paramMap.get(zzaYd);
    double d2;
    double d1;
    if ((localObject != null) && (localObject != zzdf.zzDX()) && (paramMap != null) && (paramMap != zzdf.zzDX()))
    {
      localObject = zzdf.zzh((zzag.zza)localObject);
      paramMap = zzdf.zzh(paramMap);
      if ((localObject != zzdf.zzDV()) && (paramMap != zzdf.zzDV()))
      {
        d2 = ((zzde)localObject).doubleValue();
        d1 = paramMap.doubleValue();
        if (d2 > d1) {}
      }
    }
    for (;;)
    {
      return zzdf.zzQ(Long.valueOf(Math.round((d1 - d2) * Math.random() + d2)));
      d1 = 2.147483647E9D;
      d2 = 0.0D;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */