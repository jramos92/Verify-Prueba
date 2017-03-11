package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

public class zzik
{
  private long zzJk;
  private long zzJl = Long.MIN_VALUE;
  private Object zzpd = new Object();
  
  public zzik(long paramLong)
  {
    this.zzJk = paramLong;
  }
  
  public boolean tryAcquire()
  {
    synchronized (this.zzpd)
    {
      long l = zzp.zzbz().elapsedRealtime();
      if (this.zzJl + this.zzJk > l) {
        return false;
      }
      this.zzJl = l;
      return true;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */