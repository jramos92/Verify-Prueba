package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@zzgr
public abstract class AbstractAdViewAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  public static final String AD_UNIT_ID_PARAMETER = "pubid";
  protected AdView zzaK;
  protected InterstitialAd zzaL;
  private AdLoader zzaM;
  
  public String getAdUnitId(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }
  
  public View getBannerView()
  {
    return this.zzaK;
  }
  
  public void onDestroy()
  {
    if (this.zzaK != null)
    {
      this.zzaK.destroy();
      this.zzaK = null;
    }
    if (this.zzaL != null) {
      this.zzaL = null;
    }
    if (this.zzaM != null) {
      this.zzaM = null;
    }
  }
  
  public void onPause()
  {
    if (this.zzaK != null) {
      this.zzaK.pause();
    }
  }
  
  public void onResume()
  {
    if (this.zzaK != null) {
      this.zzaK.resume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzaK = new AdView(paramContext);
    this.zzaK.setAdSize(new AdSize(paramAdSize.getWidth(), paramAdSize.getHeight()));
    this.zzaK.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzaK.setAdListener(new zzc(this, paramMediationBannerListener));
    this.zzaK.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.zzaL = new InterstitialAd(paramContext);
    this.zzaL.setAdUnitId(getAdUnitId(paramBundle1));
    this.zzaL.setAdListener(new zzd(this, paramMediationInterstitialListener));
    this.zzaL.loadAd(zza(paramContext, paramMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    paramMediationNativeListener = new zze(this, paramMediationNativeListener);
    AdLoader.Builder localBuilder = zza(paramContext, paramBundle1.getString("pubid")).withAdListener(paramMediationNativeListener);
    NativeAdOptions localNativeAdOptions = paramNativeMediationAdRequest.getNativeAdOptions();
    if (localNativeAdOptions != null) {
      localBuilder.withNativeAdOptions(localNativeAdOptions);
    }
    if (paramNativeMediationAdRequest.isAppInstallAdRequested()) {
      localBuilder.forAppInstallAd(paramMediationNativeListener);
    }
    if (paramNativeMediationAdRequest.isContentAdRequested()) {
      localBuilder.forContentAd(paramMediationNativeListener);
    }
    this.zzaM = localBuilder.build();
    this.zzaM.loadAd(zza(paramContext, paramNativeMediationAdRequest, paramBundle2, paramBundle1));
  }
  
  public void showInterstitial()
  {
    this.zzaL.show();
  }
  
  protected abstract Bundle zza(Bundle paramBundle1, Bundle paramBundle2);
  
  AdLoader.Builder zza(Context paramContext, String paramString)
  {
    return new AdLoader.Builder(paramContext, paramString);
  }
  
  AdRequest zza(Context paramContext, MediationAdRequest paramMediationAdRequest, Bundle paramBundle1, Bundle paramBundle2)
  {
    AdRequest.Builder localBuilder = new AdRequest.Builder();
    Object localObject = paramMediationAdRequest.getBirthday();
    if (localObject != null) {
      localBuilder.setBirthday((Date)localObject);
    }
    int i = paramMediationAdRequest.getGender();
    if (i != 0) {
      localBuilder.setGender(i);
    }
    localObject = paramMediationAdRequest.getKeywords();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localBuilder.addKeyword((String)((Iterator)localObject).next());
      }
    }
    localObject = paramMediationAdRequest.getLocation();
    if (localObject != null) {
      localBuilder.setLocation((Location)localObject);
    }
    if (paramMediationAdRequest.isTesting()) {
      localBuilder.addTestDevice(zzl.zzcF().zzQ(paramContext));
    }
    if (paramMediationAdRequest.taggedForChildDirectedTreatment() != -1) {
      if (paramMediationAdRequest.taggedForChildDirectedTreatment() != 1) {
        break label198;
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      localBuilder.tagForChildDirectedTreatment(bool);
      localBuilder.addNetworkExtrasBundle(AdMobAdapter.class, zza(paramBundle1, paramBundle2));
      return localBuilder.build();
    }
  }
  
  static class zza
    extends NativeAppInstallAdMapper
  {
    private final NativeAppInstallAd zzaN;
    
    public zza(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.zzaN = paramNativeAppInstallAd;
      setHeadline(paramNativeAppInstallAd.getHeadline().toString());
      setImages(paramNativeAppInstallAd.getImages());
      setBody(paramNativeAppInstallAd.getBody().toString());
      setIcon(paramNativeAppInstallAd.getIcon());
      setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
      setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
      setStore(paramNativeAppInstallAd.getStore().toString());
      setPrice(paramNativeAppInstallAd.getPrice().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(this.zzaN);
      }
    }
  }
  
  static class zzb
    extends NativeContentAdMapper
  {
    private final NativeContentAd zzaO;
    
    public zzb(NativeContentAd paramNativeContentAd)
    {
      this.zzaO = paramNativeContentAd;
      setHeadline(paramNativeContentAd.getHeadline().toString());
      setImages(paramNativeContentAd.getImages());
      setBody(paramNativeContentAd.getBody().toString());
      setLogo(paramNativeContentAd.getLogo());
      setCallToAction(paramNativeContentAd.getCallToAction().toString());
      setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
      setOverrideImpressionRecording(true);
      setOverrideClickHandling(true);
    }
    
    public void trackView(View paramView)
    {
      if ((paramView instanceof NativeAdView)) {
        ((NativeAdView)paramView).setNativeAd(this.zzaO);
      }
    }
  }
  
  static final class zzc
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaP;
    final MediationBannerListener zzaQ;
    
    public zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.zzaP = paramAbstractAdViewAdapter;
      this.zzaQ = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      this.zzaQ.onAdClicked(this.zzaP);
    }
    
    public void onAdClosed()
    {
      this.zzaQ.onAdClosed(this.zzaP);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaQ.onAdFailedToLoad(this.zzaP, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaQ.onAdLeftApplication(this.zzaP);
    }
    
    public void onAdLoaded()
    {
      this.zzaQ.onAdLoaded(this.zzaP);
    }
    
    public void onAdOpened()
    {
      this.zzaQ.onAdOpened(this.zzaP);
    }
  }
  
  static final class zzd
    extends AdListener
    implements com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaP;
    final MediationInterstitialListener zzaR;
    
    public zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.zzaP = paramAbstractAdViewAdapter;
      this.zzaR = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      this.zzaR.onAdClicked(this.zzaP);
    }
    
    public void onAdClosed()
    {
      this.zzaR.onAdClosed(this.zzaP);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaR.onAdFailedToLoad(this.zzaP, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaR.onAdLeftApplication(this.zzaP);
    }
    
    public void onAdLoaded()
    {
      this.zzaR.onAdLoaded(this.zzaP);
    }
    
    public void onAdOpened()
    {
      this.zzaR.onAdOpened(this.zzaP);
    }
  }
  
  static final class zze
    extends AdListener
    implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza
  {
    final AbstractAdViewAdapter zzaP;
    final MediationNativeListener zzaS;
    
    public zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
    {
      this.zzaP = paramAbstractAdViewAdapter;
      this.zzaS = paramMediationNativeListener;
    }
    
    public void onAdClicked()
    {
      this.zzaS.onAdClicked(this.zzaP);
    }
    
    public void onAdClosed()
    {
      this.zzaS.onAdClosed(this.zzaP);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      this.zzaS.onAdFailedToLoad(this.zzaP, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      this.zzaS.onAdLeftApplication(this.zzaP);
    }
    
    public void onAdLoaded() {}
    
    public void onAdOpened()
    {
      this.zzaS.onAdOpened(this.zzaP);
    }
    
    public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
    {
      this.zzaS.onAdLoaded(this.zzaP, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
    }
    
    public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
    {
      this.zzaS.onAdLoaded(this.zzaP, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\ads\mediation\AbstractAdViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */