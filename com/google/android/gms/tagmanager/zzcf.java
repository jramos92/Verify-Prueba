package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcf
  extends zzcz
{
  private static final String ID = zzad.zzce.toString();
  private static final String zzaYg = zzae.zzfr.toString();
  
  public zzcf()
  {
    super(ID);
  }
  
  protected boolean zza(String paramString1, String paramString2, Map<String, zzag.zza> paramMap)
  {
    if (zzdf.zzk((zzag.zza)paramMap.get(zzaYg)).booleanValue()) {}
    for (int i = 66;; i = 64) {
      try
      {
        boolean bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
        return bool;
      }
      catch (PatternSyntaxException paramString1)
      {
        return false;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */