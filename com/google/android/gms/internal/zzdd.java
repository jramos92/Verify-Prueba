package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzgr
public class zzdd
  extends zzcy.zza
{
  private final NativeCustomTemplateAd.OnCustomClickListener zzxl;
  
  public zzdd(NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    this.zzxl = paramOnCustomClickListener;
  }
  
  public void zza(zzcu paramzzcu, String paramString)
  {
    this.zzxl.onCustomClick(new zzcv(paramzzcu), paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzdd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */