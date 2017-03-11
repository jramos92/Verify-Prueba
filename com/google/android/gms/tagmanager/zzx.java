package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzx
  extends zzdd
{
  private static final String ID = zzad.zzbS.toString();
  private static final String VALUE = zzae.zzhF.toString();
  private static final String zzaWP = zzae.zzdW.toString();
  private final DataLayer zzaVR;
  
  public zzx(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.zzaVR = paramDataLayer;
  }
  
  private void zza(zzag.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdf.zzDR())) {}
    do
    {
      return;
      paramzza = zzdf.zzg(paramzza);
    } while (paramzza == zzdf.zzDW());
    this.zzaVR.zzeI(paramzza);
  }
  
  private void zzb(zzag.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdf.zzDR())) {}
    for (;;)
    {
      return;
      paramzza = zzdf.zzl(paramzza);
      if ((paramzza instanceof List))
      {
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          Object localObject = paramzza.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.zzaVR.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void zzK(Map<String, zzag.zza> paramMap)
  {
    zzb((zzag.zza)paramMap.get(VALUE));
    zza((zzag.zza)paramMap.get(zzaWP));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */