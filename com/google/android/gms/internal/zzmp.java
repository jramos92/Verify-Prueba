package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzmp
  implements zzmn
{
  private static zzmp zzaik;
  
  public static zzmn zzqt()
  {
    try
    {
      if (zzaik == null) {
        zzaik = new zzmp();
      }
      zzmp localzzmp = zzaik;
      return localzzmp;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */