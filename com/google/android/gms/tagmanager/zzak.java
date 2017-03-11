package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzak
{
  private final Set<String> zzaWY;
  private final String zzaWZ;
  
  public zzak(String paramString, String... paramVarArgs)
  {
    this.zzaWZ = paramString;
    this.zzaWY = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.zzaWY.add(paramString);
      i += 1;
    }
  }
  
  public String zzCT()
  {
    return this.zzaWZ;
  }
  
  public Set<String> zzCU()
  {
    return this.zzaWY;
  }
  
  public abstract boolean zzCo();
  
  public abstract zzag.zza zzI(Map<String, zzag.zza> paramMap);
  
  boolean zzf(Set<String> paramSet)
  {
    return paramSet.containsAll(this.zzaWY);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */