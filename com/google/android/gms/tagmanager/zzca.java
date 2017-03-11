package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzca
  extends zzak
{
  private static final String zzaWU = zzae.zzdz.toString();
  private static final String zzaXS = zzae.zzdA.toString();
  
  public zzca(String paramString)
  {
    super(paramString, new String[] { zzaWU, zzaXS });
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((zzag.zza)((Iterator)localObject).next() == zzdf.zzDX()) {
        return zzdf.zzQ(Boolean.valueOf(false));
      }
    }
    localObject = (zzag.zza)paramMap.get(zzaWU);
    zzag.zza localzza = (zzag.zza)paramMap.get(zzaXS);
    if ((localObject == null) || (localzza == null)) {}
    for (boolean bool = false;; bool = zza((zzag.zza)localObject, localzza, paramMap)) {
      return zzdf.zzQ(Boolean.valueOf(bool));
    }
  }
  
  protected abstract boolean zza(zzag.zza paramzza1, zzag.zza paramzza2, Map<String, zzag.zza> paramMap);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */