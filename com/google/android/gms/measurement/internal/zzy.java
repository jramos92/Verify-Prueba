package com.google.android.gms.measurement.internal;

abstract class zzy
  extends zzx
{
  private boolean zzMF;
  private boolean zzMG;
  private boolean zzaOk;
  
  zzy(zzv paramzzv)
  {
    super(paramzzv);
    this.zzaKG.zzb(this);
  }
  
  boolean isInitialized()
  {
    return (this.zzMF) && (!this.zzMG);
  }
  
  boolean zzAp()
  {
    return this.zzaOk;
  }
  
  public final void zza()
  {
    if (this.zzMF) {
      throw new IllegalStateException("Can't initialize twice");
    }
    zzhR();
    this.zzaKG.zzAo();
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */