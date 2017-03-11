package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zzae
{
  private static volatile Logger zzPq;
  
  static
  {
    setLogger(new zzs());
  }
  
  public static Logger getLogger()
  {
    return zzPq;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    zzPq = paramLogger;
  }
  
  public static void v(String paramString)
  {
    Object localObject = zzaf.zzkG();
    if (localObject != null) {
      ((zzaf)localObject).zzba(paramString);
    }
    for (;;)
    {
      localObject = zzPq;
      if (localObject != null) {
        ((Logger)localObject).verbose(paramString);
      }
      return;
      if (zzN(0)) {
        Log.v((String)zzy.zzOg.get(), paramString);
      }
    }
  }
  
  public static boolean zzN(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() <= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void zzaG(String paramString)
  {
    Object localObject = zzaf.zzkG();
    if (localObject != null) {
      ((zzaf)localObject).zzbc(paramString);
    }
    for (;;)
    {
      localObject = zzPq;
      if (localObject != null) {
        ((Logger)localObject).info(paramString);
      }
      return;
      if (zzN(1)) {
        Log.i((String)zzy.zzOg.get(), paramString);
      }
    }
  }
  
  public static void zzaH(String paramString)
  {
    Object localObject = zzaf.zzkG();
    if (localObject != null) {
      ((zzaf)localObject).zzbd(paramString);
    }
    for (;;)
    {
      localObject = zzPq;
      if (localObject != null) {
        ((Logger)localObject).warn(paramString);
      }
      return;
      if (zzN(2)) {
        Log.w((String)zzy.zzOg.get(), paramString);
      }
    }
  }
  
  public static void zzf(String paramString, Object paramObject)
  {
    zzaf localzzaf = zzaf.zzkG();
    if (localzzaf != null) {
      localzzaf.zze(paramString, paramObject);
    }
    while (!zzN(3))
    {
      paramObject = zzPq;
      if (paramObject != null) {
        ((Logger)paramObject).error(paramString);
      }
      return;
    }
    if (paramObject != null) {}
    for (paramObject = paramString + ":" + paramObject;; paramObject = paramString)
    {
      Log.e((String)zzy.zzOg.get(), (String)paramObject);
      break;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */