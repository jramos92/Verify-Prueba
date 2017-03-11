package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

public final class CustomEventAdapter
  implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters>
{
  private View zzaY;
  CustomEventBanner zzaZ;
  CustomEventInterstitial zzba;
  
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
  
  public void destroy()
  {
    if (this.zzaZ != null) {
      this.zzaZ.destroy();
    }
    if (this.zzba != null) {
      this.zzba.destroy();
    }
  }
  
  public Class<CustomEventExtras> getAdditionalParametersType()
  {
    return CustomEventExtras.class;
  }
  
  public View getBannerView()
  {
    return this.zzaY;
  }
  
  public Class<CustomEventServerParameters> getServerParametersType()
  {
    return CustomEventServerParameters.class;
  }
  
  public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.zzaZ = ((CustomEventBanner)zzj(paramCustomEventServerParameters.className));
    if (this.zzaZ == null)
    {
      paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.zzaZ.requestBannerAd(new zza(this, paramMediationBannerListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramAdSize, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, CustomEventExtras paramCustomEventExtras)
  {
    this.zzba = ((CustomEventInterstitial)zzj(paramCustomEventServerParameters.className));
    if (this.zzba == null)
    {
      paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
      return;
    }
    if (paramCustomEventExtras == null) {}
    for (paramCustomEventExtras = null;; paramCustomEventExtras = paramCustomEventExtras.getExtra(paramCustomEventServerParameters.label))
    {
      this.zzba.requestInterstitialAd(zza(paramMediationInterstitialListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramMediationAdRequest, paramCustomEventExtras);
      return;
    }
  }
  
  public void showInterstitial()
  {
    this.zzba.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzbb;
    private final MediationBannerListener zzbc;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzbb = paramCustomEventAdapter;
      this.zzbc = paramMediationBannerListener;
    }
    
    public void onClick()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbc.onClick(this.zzbb);
    }
    
    public void onDismissScreen()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbc.onDismissScreen(this.zzbb);
    }
    
    public void onFailedToReceiveAd()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbc.onFailedToReceiveAd(this.zzbb, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbc.onLeaveApplication(this.zzbb);
    }
    
    public void onPresentScreen()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbc.onPresentScreen(this.zzbb);
    }
    
    public void onReceivedAd(View paramView)
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      CustomEventAdapter.zza(this.zzbb, paramView);
      this.zzbc.onReceivedAd(this.zzbb);
    }
  }
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzbb;
    private final MediationInterstitialListener zzbd;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzbb = paramCustomEventAdapter;
      this.zzbd = paramMediationInterstitialListener;
    }
    
    public void onDismissScreen()
    {
      zzb.zzaF("Custom event adapter called onDismissScreen.");
      this.zzbd.onDismissScreen(this.zzbb);
    }
    
    public void onFailedToReceiveAd()
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      this.zzbd.onFailedToReceiveAd(this.zzbb, AdRequest.ErrorCode.NO_FILL);
    }
    
    public void onLeaveApplication()
    {
      zzb.zzaF("Custom event adapter called onLeaveApplication.");
      this.zzbd.onLeaveApplication(this.zzbb);
    }
    
    public void onPresentScreen()
    {
      zzb.zzaF("Custom event adapter called onPresentScreen.");
      this.zzbd.onPresentScreen(this.zzbb);
    }
    
    public void onReceivedAd()
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      this.zzbd.onReceivedAd(CustomEventAdapter.this);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\ads\mediation\customevent\CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */