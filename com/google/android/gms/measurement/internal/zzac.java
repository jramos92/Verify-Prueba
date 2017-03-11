package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

class zzac
{
  private final zzmn zzpW;
  private long zzzB;
  
  public zzac(zzmn paramzzmn)
  {
    zzx.zzw(paramzzmn);
    this.zzpW = paramzzmn;
  }
  
  public void clear()
  {
    this.zzzB = 0L;
  }
  
  public void start()
  {
    this.zzzB = this.zzpW.elapsedRealtime();
  }
  
  public boolean zzv(long paramLong)
  {
    if (this.zzzB == 0L) {}
    while (this.zzpW.elapsedRealtime() - this.zzzB >= paramLong) {
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */