package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzg
  extends zzd.zza
{
  private final RewardedVideoAdListener zzHd;
  
  public zzg(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    this.zzHd = paramRewardedVideoAdListener;
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoAdClosed();
    }
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoAdFailedToLoad(paramInt);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoAdLeftApplication();
    }
  }
  
  public void onRewardedVideoAdLoaded()
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoAdLoaded();
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoAdOpened();
    }
  }
  
  public void onRewardedVideoStarted()
  {
    if (this.zzHd != null) {
      this.zzHd.onRewardedVideoStarted();
    }
  }
  
  public void zza(zza paramzza)
  {
    if (this.zzHd != null) {
      this.zzHd.onRewarded(new zze(paramzza));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\reward\client\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */