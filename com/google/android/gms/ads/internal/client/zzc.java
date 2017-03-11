package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzc
  extends zzo.zza
{
  private final AdListener zzsz;
  
  public zzc(AdListener paramAdListener)
  {
    this.zzsz = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.zzsz.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.zzsz.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.zzsz.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.zzsz.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.zzsz.onAdOpened();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */