package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public final class zzna
{
  public static String[] zza(Scope[] paramArrayOfScope)
  {
    zzx.zzb(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    int i = 0;
    while (i < paramArrayOfScope.length)
    {
      arrayOfString[i] = paramArrayOfScope[i].zznG();
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[] zzc(Set<Scope> paramSet)
  {
    zzx.zzb(paramSet, "scopes can't be null.");
    return zza((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */