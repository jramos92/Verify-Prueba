package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaw
  extends zzak
{
  private static final String ID = zzad.zzbO.toString();
  private static final String zzaVH = zzae.zzeb.toString();
  private final Context context;
  
  public zzaw(Context paramContext)
  {
    super(ID, new String[0]);
    this.context = paramContext;
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    if ((zzag.zza)paramMap.get(zzaVH) != null) {}
    for (paramMap = zzdf.zzg((zzag.zza)paramMap.get(zzaVH));; paramMap = null)
    {
      paramMap = zzax.zzn(this.context, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdf.zzQ(paramMap);
    }
    return zzdf.zzDX();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */