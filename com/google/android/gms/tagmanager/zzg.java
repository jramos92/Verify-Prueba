package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzg
  extends zzak
{
  private static final String ID = zzad.zzbi.toString();
  private final Context mContext;
  
  public zzg(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    try
    {
      paramMap = this.mContext.getPackageManager();
      paramMap = zzdf.zzQ(paramMap.getApplicationLabel(paramMap.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      zzbg.zzb("App name is not found.", paramMap);
    }
    return zzdf.zzDX();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */