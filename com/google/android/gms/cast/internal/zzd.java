package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class zzd
{
  protected final zzl zzYC;
  private final String zzYD;
  private zzn zzYE;
  
  protected zzd(String paramString1, String paramString2, String paramString3)
  {
    zzf.zzbM(paramString1);
    this.zzYD = paramString1;
    this.zzYC = new zzl(paramString2);
    setSessionLabel(paramString3);
  }
  
  public final String getNamespace()
  {
    return this.zzYD;
  }
  
  public void setSessionLabel(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.zzYC.zzbS(paramString);
    }
  }
  
  public final void zza(zzn paramzzn)
  {
    this.zzYE = paramzzn;
    if (this.zzYE == null) {
      zzmP();
    }
  }
  
  protected final void zza(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.zzYC.zza("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.zzYE.zza(this.zzYD, paramString1, paramLong, paramString2);
  }
  
  public void zzb(long paramLong, int paramInt) {}
  
  public void zzbK(String paramString) {}
  
  public void zzmP() {}
  
  protected final long zzmQ()
  {
    return this.zzYE.zzmA();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */