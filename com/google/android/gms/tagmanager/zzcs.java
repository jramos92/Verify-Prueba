package com.google.android.gms.tagmanager;

class zzcs
  implements zzcd
{
  private final long zzPk;
  private final int zzPl;
  private double zzPm;
  private final Object zzPo = new Object();
  private long zzaYS;
  
  public zzcs()
  {
    this(60, 2000L);
  }
  
  public zzcs(int paramInt, long paramLong)
  {
    this.zzPl = paramInt;
    this.zzPm = this.zzPl;
    this.zzPk = paramLong;
  }
  
  public boolean zzkF()
  {
    synchronized (this.zzPo)
    {
      long l = System.currentTimeMillis();
      if (this.zzPm < this.zzPl)
      {
        double d = (l - this.zzaYS) / this.zzPk;
        if (d > 0.0D) {
          this.zzPm = Math.min(this.zzPl, d + this.zzPm);
        }
      }
      this.zzaYS = l;
      if (this.zzPm >= 1.0D)
      {
        this.zzPm -= 1.0D;
        return true;
      }
      zzbg.zzaH("No more tokens available.");
      return false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */