package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzgr
public class zzdb
  extends zzcw.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzxj;
  
  public zzdb(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    this.zzxj = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzcq paramzzcq)
  {
    this.zzxj.onAppInstallAdLoaded(zzb(paramzzcq));
  }
  
  zzcr zzb(zzcq paramzzcq)
  {
    return new zzcr(paramzzcq);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */