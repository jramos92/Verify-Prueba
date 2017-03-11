package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzz
{
  private final zzh zznL;
  private boolean zzoN;
  private String zzpa;
  private zza zzsy;
  private AdListener zzsz;
  private final zzel zztD = new zzel();
  private final AtomicBoolean zztE;
  private zzs zztF;
  private String zztG;
  private ViewGroup zztH;
  private InAppPurchaseListener zztI;
  private PlayStorePurchaseListener zztJ;
  private OnCustomRenderedAdLoadedListener zztK;
  private AppEventListener zztj;
  private AdSize[] zztk;
  
  public zzz(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzh.zzcB());
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzh.zzcB());
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzh paramzzh)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramzzh, null);
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzh paramzzh, zzs paramzzs)
  {
    this.zztH = paramViewGroup;
    this.zznL = paramzzh;
    this.zztF = paramzzs;
    this.zztE = new AtomicBoolean(false);
    if (paramAttributeSet != null) {
      paramzzh = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new zzk(paramzzh, paramAttributeSet);
      this.zztk = paramAttributeSet.zzi(paramBoolean);
      this.zzpa = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzl.zzcF().zza(paramViewGroup, new AdSizeParcel(paramzzh, this.zztk[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      zzl.zzcF().zza(paramViewGroup, new AdSizeParcel(paramzzh, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void zzcS()
  {
    try
    {
      zzd localzzd = this.zztF.zzaM();
      if (localzzd == null) {
        return;
      }
      this.zztH.addView((View)com.google.android.gms.dynamic.zze.zzp(localzzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.zztF != null) {
        this.zztF.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return this.zzsz;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.zztF != null)
      {
        Object localObject = this.zztF.zzaN();
        if (localObject != null)
        {
          localObject = ((AdSizeParcel)localObject).zzcD();
          return (AdSize)localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (this.zztk != null) {
        return this.zztk[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.zztk;
  }
  
  public String getAdUnitId()
  {
    return this.zzpa;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.zztj;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zztI;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (this.zztF != null)
      {
        String str = this.zztF.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return this.zztK;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (this.zztF != null)
      {
        boolean bool = this.zztF.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void pause()
  {
    try
    {
      if (this.zztF != null) {
        this.zztF.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    if (this.zztE.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        if (this.zztF != null)
        {
          this.zztF.zzaP();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.zztF != null) {
        this.zztF.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.zzsz = paramAdListener;
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new zzc(paramAdListener);; paramAdListener = null)
      {
        localzzs.zza(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.zztk != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.zzpa != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    this.zzpa = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.zztj = paramAppEventListener;
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzj(paramAppEventListener);; paramAppEventListener = null)
      {
        localzzs.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.zztJ != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.zztI = paramInAppPurchaseListener;
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramInAppPurchaseListener == null) {
          break label56;
        }
      }
      label56:
      for (paramInAppPurchaseListener = new zzfx(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localzzs.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    this.zzoN = paramBoolean;
    try
    {
      if (this.zztF != null) {
        this.zztF.setManualImpressionsEnabled(this.zzoN);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    this.zztK = paramOnCustomRenderedAdLoadedListener;
    try
    {
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzcl(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localzzs.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (this.zztI != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.zztJ = paramPlayStorePurchaseListener;
      this.zztG = paramString;
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramPlayStorePurchaseListener == null) {
          break label62;
        }
      }
      label62:
      for (paramPlayStorePurchaseListener = new zzgb(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localzzs.zza(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      this.zzsy = paramzza;
      zzs localzzs;
      if (this.zztF != null)
      {
        localzzs = this.zztF;
        if (paramzza == null) {
          break label38;
        }
      }
      label38:
      for (paramzza = new zzb(paramzza);; paramzza = null)
      {
        localzzs.zza(paramzza);
        return;
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public void zza(zzy paramzzy)
  {
    try
    {
      if (this.zztF == null) {
        zzcT();
      }
      if (this.zztF.zzb(this.zznL.zza(this.zztH.getContext(), paramzzy))) {
        this.zztD.zze(paramzzy.zzcO());
      }
      return;
    }
    catch (RemoteException paramzzy)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzy);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    this.zztk = paramVarArgs;
    try
    {
      if (this.zztF != null) {
        this.zztF.zza(new AdSizeParcel(this.zztH.getContext(), this.zztk));
      }
      this.zztH.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  void zzcT()
    throws RemoteException
  {
    if (((this.zztk == null) || (this.zzpa == null)) && (this.zztF == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    this.zztF = zzcU();
    if (this.zzsz != null) {
      this.zztF.zza(new zzc(this.zzsz));
    }
    if (this.zzsy != null) {
      this.zztF.zza(new zzb(this.zzsy));
    }
    if (this.zztj != null) {
      this.zztF.zza(new zzj(this.zztj));
    }
    if (this.zztI != null) {
      this.zztF.zza(new zzfx(this.zztI));
    }
    if (this.zztJ != null) {
      this.zztF.zza(new zzgb(this.zztJ), this.zztG);
    }
    if (this.zztK != null) {
      this.zztF.zza(new zzcl(this.zztK));
    }
    this.zztF.zza(zzl.zzcH());
    this.zztF.setManualImpressionsEnabled(this.zzoN);
    zzcS();
  }
  
  protected zzs zzcU()
    throws RemoteException
  {
    Context localContext = this.zztH.getContext();
    return zzl.zzcG().zza(localContext, new AdSizeParcel(localContext, this.zztk), this.zzpa, this.zztD);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */