package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzt
  extends zzak
{
  private static final String ID = zzad.zzbw.toString();
  private static final String zzaVJ = zzae.zzdn.toString();
  private static final String zzaWt = zzae.zzfk.toString();
  private final zza zzaWu;
  
  public zzt(zza paramzza)
  {
    super(ID, new String[] { zzaWt });
    this.zzaWu = paramzza;
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    String str = zzdf.zzg((zzag.zza)paramMap.get(zzaWt));
    HashMap localHashMap = new HashMap();
    paramMap = (zzag.zza)paramMap.get(zzaVJ);
    if (paramMap != null)
    {
      paramMap = zzdf.zzl(paramMap);
      if (!(paramMap instanceof Map))
      {
        zzbg.zzaH("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        return zzdf.zzDX();
      }
      paramMap = ((Map)paramMap).entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localHashMap.put(localEntry.getKey().toString(), localEntry.getValue());
      }
    }
    try
    {
      paramMap = zzdf.zzQ(this.zzaWu.zzc(str, localHashMap));
      return paramMap;
    }
    catch (Exception paramMap)
    {
      zzbg.zzaH("Custom macro/tag " + str + " threw exception " + paramMap.getMessage());
    }
    return zzdf.zzDX();
  }
  
  public static abstract interface zza
  {
    public abstract Object zzc(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */