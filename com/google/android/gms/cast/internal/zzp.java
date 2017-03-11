package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp
{
  private static final zzl zzVo = new zzl("RequestTracker");
  public static final Object zzZJ = new Object();
  private long zzYg;
  private long zzZG;
  private long zzZH;
  private zzo zzZI;
  
  public zzp(long paramLong)
  {
    this.zzZG = paramLong;
    this.zzYg = -1L;
    this.zzZH = 0L;
  }
  
  private void zznj()
  {
    this.zzYg = -1L;
    this.zzZI = null;
    this.zzZH = 0L;
  }
  
  public void clear()
  {
    synchronized (zzZJ)
    {
      if (this.zzYg != -1L) {
        zznj();
      }
      return;
    }
  }
  
  public boolean zzB(long paramLong)
  {
    for (;;)
    {
      synchronized (zzZJ)
      {
        if ((this.zzYg != -1L) && (this.zzYg == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zza(long paramLong, zzo paramzzo)
  {
    synchronized (zzZJ)
    {
      zzo localzzo = this.zzZI;
      long l = this.zzYg;
      this.zzYg = paramLong;
      this.zzZI = paramzzo;
      this.zzZH = SystemClock.elapsedRealtime();
      if (localzzo != null) {
        localzzo.zzy(l);
      }
      return;
    }
  }
  
  public boolean zzc(long paramLong, int paramInt)
  {
    return zzc(paramLong, paramInt, null);
  }
  
  public boolean zzc(long paramLong, int paramInt, Object paramObject)
  {
    boolean bool = true;
    zzo localzzo = null;
    for (;;)
    {
      synchronized (zzZJ)
      {
        if ((this.zzYg != -1L) && (this.zzYg == paramLong))
        {
          zzVo.zzb("request %d completed", new Object[] { Long.valueOf(this.zzYg) });
          localzzo = this.zzZI;
          zznj();
          if (localzzo != null) {
            localzzo.zza(paramLong, paramInt, paramObject);
          }
          return bool;
        }
      }
      bool = false;
    }
  }
  
  public boolean zzd(long paramLong, int paramInt)
  {
    boolean bool = true;
    long l = 0L;
    for (;;)
    {
      synchronized (zzZJ)
      {
        if ((this.zzYg != -1L) && (paramLong - this.zzZH >= this.zzZG))
        {
          zzVo.zzb("request %d timed out", new Object[] { Long.valueOf(this.zzYg) });
          paramLong = this.zzYg;
          zzo localzzo = this.zzZI;
          zznj();
          if (localzzo != null) {
            localzzo.zza(paramLong, paramInt, null);
          }
          return bool;
        }
      }
      bool = false;
      Object localObject2 = null;
      paramLong = l;
    }
  }
  
  public boolean zznk()
  {
    for (;;)
    {
      synchronized (zzZJ)
      {
        if (this.zzYg != -1L)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */