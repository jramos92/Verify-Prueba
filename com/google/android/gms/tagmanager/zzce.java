package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzce
  extends zzak
{
  private static final String ID = zzad.zzbR.toString();
  private static final String zzaYe = zzae.zzdz.toString();
  private static final String zzaYf = zzae.zzdA.toString();
  private static final String zzaYg = zzae.zzfr.toString();
  private static final String zzaYh = zzae.zzfl.toString();
  
  public zzce()
  {
    super(ID, new String[] { zzaYe, zzaYf });
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    Object localObject = (zzag.zza)paramMap.get(zzaYe);
    zzag.zza localzza = (zzag.zza)paramMap.get(zzaYf);
    if ((localObject == null) || (localObject == zzdf.zzDX()) || (localzza == null) || (localzza == zzdf.zzDX())) {
      return zzdf.zzDX();
    }
    int i = 64;
    if (zzdf.zzk((zzag.zza)paramMap.get(zzaYg)).booleanValue()) {
      i = 66;
    }
    paramMap = (zzag.zza)paramMap.get(zzaYh);
    int j;
    if (paramMap != null)
    {
      paramMap = zzdf.zzi(paramMap);
      if (paramMap == zzdf.zzDS()) {
        return zzdf.zzDX();
      }
      int k = paramMap.intValue();
      j = k;
      if (k < 0) {
        return zzdf.zzDX();
      }
    }
    else
    {
      j = 1;
    }
    try
    {
      paramMap = zzdf.zzg((zzag.zza)localObject);
      localObject = zzdf.zzg(localzza);
      localzza = null;
      localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
      paramMap = localzza;
      if (((Matcher)localObject).find())
      {
        paramMap = localzza;
        if (((Matcher)localObject).groupCount() >= j) {
          paramMap = ((Matcher)localObject).group(j);
        }
      }
      if (paramMap == null) {
        return zzdf.zzDX();
      }
      paramMap = zzdf.zzQ(paramMap);
      return paramMap;
    }
    catch (PatternSyntaxException paramMap) {}
    return zzdf.zzDX();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */