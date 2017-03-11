package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgr
public final class zzch
  extends zzcj.zza
{
  private final zzg zzvW;
  private final String zzvX;
  private final String zzvY;
  
  public zzch(zzg paramzzg, String paramString1, String paramString2)
  {
    this.zzvW = paramzzg;
    this.zzvX = paramString1;
    this.zzvY = paramString2;
  }
  
  public String getContent()
  {
    return this.zzvY;
  }
  
  public void recordClick()
  {
    this.zzvW.recordClick();
  }
  
  public void recordImpression()
  {
    this.zzvW.recordImpression();
  }
  
  public void zza(zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    this.zzvW.zzc((View)zze.zzp(paramzzd));
  }
  
  public String zzdr()
  {
    return this.zzvX;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */