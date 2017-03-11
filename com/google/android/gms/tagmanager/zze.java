package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zze
  extends zzak
{
  private static final String ID = zzad.zzbJ.toString();
  private static final String zzaVH = zzae.zzeb.toString();
  private static final String zzaVI = zzae.zzee.toString();
  private final Context context;
  
  public zze(Context paramContext)
  {
    super(ID, new String[] { zzaVI });
    this.context = paramContext;
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzaVI);
    if (localObject == null) {
      return zzdf.zzDX();
    }
    localObject = zzdf.zzg((zzag.zza)localObject);
    paramMap = (zzag.zza)paramMap.get(zzaVH);
    if (paramMap != null) {}
    for (paramMap = zzdf.zzg(paramMap);; paramMap = null)
    {
      paramMap = zzax.zzf(this.context, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdf.zzQ(paramMap);
    }
    return zzdf.zzDX();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */