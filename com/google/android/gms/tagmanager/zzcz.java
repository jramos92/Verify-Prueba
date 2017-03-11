package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

abstract class zzcz
  extends zzca
{
  public zzcz(String paramString)
  {
    super(paramString);
  }
  
  protected boolean zza(zzag.zza paramzza1, zzag.zza paramzza2, Map<String, zzag.zza> paramMap)
  {
    paramzza1 = zzdf.zzg(paramzza1);
    paramzza2 = zzdf.zzg(paramzza2);
    if ((paramzza1 == zzdf.zzDW()) || (paramzza2 == zzdf.zzDW())) {
      return false;
    }
    return zza(paramzza1, paramzza2, paramMap);
  }
  
  protected abstract boolean zza(String paramString1, String paramString2, Map<String, zzag.zza> paramMap);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */