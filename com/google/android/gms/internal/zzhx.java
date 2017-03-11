package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzhx
{
  private final String zzHG;
  private int zzIi;
  private int zzIj;
  private final zzhu zzpV;
  private final Object zzpd = new Object();
  
  zzhx(zzhu paramzzhu, String paramString)
  {
    this.zzpV = paramzzhu;
    this.zzHG = paramString;
  }
  
  public zzhx(String paramString)
  {
    this(zzp.zzby(), paramString);
  }
  
  public Bundle toBundle()
  {
    synchronized (this.zzpd)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", this.zzIi);
      localBundle.putInt("pmnll", this.zzIj);
      return localBundle;
    }
  }
  
  public void zzf(int paramInt1, int paramInt2)
  {
    synchronized (this.zzpd)
    {
      this.zzIi = paramInt1;
      this.zzIj = paramInt2;
      this.zzpV.zza(this.zzHG, this);
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */