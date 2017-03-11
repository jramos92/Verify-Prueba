package com.google.android.gms.common.stats;

public abstract class zzf
{
  public static int zzahY = 0;
  public static int zzahZ = 1;
  
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    return getTimeMillis() + "\t" + getEventType() + "\t" + zzqd() + zzqg();
  }
  
  public abstract long zzqd();
  
  public abstract String zzqg();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\stats\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */