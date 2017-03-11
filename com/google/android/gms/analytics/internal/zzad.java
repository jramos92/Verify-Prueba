package com.google.android.gms.analytics.internal;

public class zzad
{
  private final long zzPk;
  private final int zzPl;
  private double zzPm;
  private long zzPn;
  private final Object zzPo = new Object();
  private final String zzPp;
  
  public zzad(int paramInt, long paramLong, String paramString)
  {
    this.zzPl = paramInt;
    this.zzPm = this.zzPl;
    this.zzPk = paramLong;
    this.zzPp = paramString;
  }
  
  public zzad(String paramString)
  {
    this(60, 2000L, paramString);
  }
  
  public boolean zzkF()
  {
    synchronized (this.zzPo)
    {
      long l = System.currentTimeMillis();
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
      zzae.zzaH("Excessive " + this.zzPp + " detected; call ignored.");
      return false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */