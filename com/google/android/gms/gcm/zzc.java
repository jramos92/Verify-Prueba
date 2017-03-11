package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzc
{
  public static final zzc zzaCI = new zzc(0, 30, 3600);
  public static final zzc zzaCJ = new zzc(1, 30, 3600);
  private final int zzaCK;
  private final int zzaCL;
  private final int zzaCM;
  
  private zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzaCK = paramInt1;
    this.zzaCL = paramInt2;
    this.zzaCM = paramInt3;
  }
  
  public int zzvZ()
  {
    return this.zzaCK;
  }
  
  public int zzwa()
  {
    return this.zzaCL;
  }
  
  public int zzwb()
  {
    return this.zzaCM;
  }
  
  public Bundle zzz(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", this.zzaCK);
    paramBundle.putInt("initial_backoff_seconds", this.zzaCL);
    paramBundle.putInt("maximum_backoff_seconds", this.zzaCM);
    return paramBundle;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\gcm\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */