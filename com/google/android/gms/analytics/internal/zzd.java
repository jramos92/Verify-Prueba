package com.google.android.gms.analytics.internal;

public abstract class zzd
  extends zzc
{
  private boolean zzMF;
  private boolean zzMG;
  
  protected zzd(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public boolean isInitialized()
  {
    return (this.zzMF) && (!this.zzMG);
  }
  
  public void zza()
  {
    zzhR();
    this.zzMF = true;
  }
  
  protected abstract void zzhR();
  
  protected void zziE()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */