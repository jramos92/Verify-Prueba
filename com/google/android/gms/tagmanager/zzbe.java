package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzmn;

class zzbe
  implements zzcd
{
  private final long zzPk;
  private final int zzPl;
  private double zzPm;
  private long zzPn;
  private final Object zzPo = new Object();
  private final String zzPp;
  private final long zzaXx;
  private final zzmn zzpW;
  
  public zzbe(int paramInt, long paramLong1, long paramLong2, String paramString, zzmn paramzzmn)
  {
    this.zzPl = paramInt;
    this.zzPm = this.zzPl;
    this.zzPk = paramLong1;
    this.zzaXx = paramLong2;
    this.zzPp = paramString;
    this.zzpW = paramzzmn;
  }
  
  public boolean zzkF()
  {
    synchronized (this.zzPo)
    {
      long l = this.zzpW.currentTimeMillis();
      if (l - this.zzPn < this.zzaXx)
      {
        zzbg.zzaH("Excessive " + this.zzPp + " detected; call ignored.");
        return false;
      }
      if (this.zzPm < this.zzPl)
      {
        double d = (l - this.zzPn) / this.zzPk;
        if (d > 0.0D) {
          this.zzPm = Math.min(this.zzPl, d + this.zzPm);
        }
      }
      this.zzPn = l;
      if (this.zzPm >= 1.0D)
      {
        this.zzPm -= 1.0D;
        return true;
      }
    }
    zzbg.zzaH("Excessive " + this.zzPp + " detected; call ignored.");
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */