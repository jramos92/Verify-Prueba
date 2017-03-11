package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  CustomEventBanner zzKL;
  CustomEventInterstitial zzKM;
  CustomEventNative zzKN;
  private View zzaY;
  
  private void zza(View paramView)
  {
    this.zzaY = paramView;
  }
  
  private static <T> T zzj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  public View getBannerView()
  {
    return this.zzaY;
  }
  
  public void onDestroy()
  {
    if (this.zzKL != null) {
      this.zzKL.onDestroy();
    }
    if (this.zzKM != null) {
      this.zzKM.onDestroy();
    }
    if (this.zzKN != null) {
      this.zzKN.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.zzKL != null) {
      this.zzKL.onPause();
    }
    if (this.zzKM != null) {
      this.zzKM.onPause();
    }
    if (this.zzKN != null) {
      this.zzKN.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.zzKL != null) {
      this.zzKL.onResume();
    }
    if (this.zzKM != null) {
      this.zzKM.onResume();
    }
    if (this.zzKN != null) {
      this.zzKN.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzKL = ((CustomEventBanner)zzj(paramBundle1.getString("class_name")));
    if (this.zzKL == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzKL.requestBannerAd(paramContext, new zza(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzKM = ((CustomEventInterstitial)zzj(paramBundle1.getString("class_name")));
    if (this.zzKM == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzKM.requestInterstitialAd(paramContext, zza(paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    this.zzKN = ((CustomEventNative)zzj(paramBundle1.getString("class_name")));
    if (this.zzKN == null)
    {
      paramMediationNativeListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      this.zzKN.requestNativeAd(paramContext, new zzc(this, paramMediationNativeListener), paramBundle1.getString("parameter"), paramNativeMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.zzKM.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationBannerListener zzaQ;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzKO = paramCustomEventAdapter;
      this.zzaQ = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaQ.onAdClicked(this.zzKO);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaQ.onAdClosed(this.zzKO);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
      this.zzaQ.onAdFailedToLoad(this.zzKO, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaQ.onAdLeftApplication(this.zzKO);
    }
    
    public void onAdLoaded(View paramView)
    {
      zzb.zzaF("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.zza(this.zzKO, paramView);
      this.zzaQ.onAdLoaded(this.zzKO);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaQ.onAdOpened(this.zzKO);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationInterstitialListener zzaR;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzKO = paramCustomEventAdapter;
      this.zzaR = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaR.onAdClicked(this.zzKO);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaR.onAdClosed(this.zzKO);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzaR.onAdFailedToLoad(this.zzKO, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaR.onAdLeftApplication(this.zzKO);
    }
    
    public void onAdLoaded()
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      this.zzaR.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaR.onAdOpened(this.zzKO);
    }
  }
  
  static class zzc
    implements CustomEventNativeListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationNativeListener zzaS;
    
    public zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.zzKO = paramCustomEventAdapter;
      this.zzaS = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      this.zzaS.onAdClicked(this.zzKO);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      this.zzaS.onAdClosed(this.zzKO);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
      this.zzaS.onAdFailedToLoad(this.zzKO, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      this.zzaS.onAdLeftApplication(this.zzKO);
    }
    
    public void onAdLoaded(NativeAdMapper paramNativeAdMapper)
    {
      zzb.zzaF("Custom event adapter called onAdLoaded.");
      this.zzaS.onAdLoaded(this.zzKO, paramNativeAdMapper);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      this.zzaS.onAdOpened(this.zzKO);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\mediation\customevent\CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */