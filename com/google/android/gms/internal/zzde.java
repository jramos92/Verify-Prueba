package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzgr
public class zzde
  extends zzcz.zza
{
  private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzxm;
  
  public zzde(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener)
  {
    this.zzxm = paramOnCustomTemplateAdLoadedListener;
  }
  
  public void zza(zzcu paramzzcu)
  {
    this.zzxm.onCustomTemplateAdLoaded(new zzcv(paramzzcu));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */