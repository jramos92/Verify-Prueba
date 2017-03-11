package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@zzgr
public final class zzet
  extends zzen.zza
{
  private final MediationAdapter zzzJ;
  private zzeu zzzK;
  
  public zzet(MediationAdapter paramMediationAdapter)
  {
    this.zzzJ = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Server parameters: " + paramString1);
    Bundle localBundle;
    try
    {
      localBundle = new Bundle();
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        localBundle = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, paramString1.getString(str));
        }
      }
      if (!(this.zzzJ instanceof AdMobAdapter)) {
        break label138;
      }
    }
    catch (Throwable paramString1)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label138:
    return localBundle;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.zzzJ.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzy(((MediationBannerAdapter)this.zzzJ).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)this.zzzJ).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.zzzJ.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.zzzJ.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzzJ).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)this.zzzJ).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, String paramString)
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzzJ;
        if (paramAdRequestParcel.zzsD == null) {
          break label204;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzsD);
        Object localObject2;
        if (paramAdRequestParcel.zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, paramAdRequestParcel.zzsC, (Set)localObject1, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsF);
          if (paramAdRequestParcel.zzsL != null)
          {
            localObject1 = paramAdRequestParcel.zzsL.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd((MediationAdRequest)localObject2, zza(paramString, paramAdRequestParcel.zzsF, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramAdRequestParcel)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", paramAdRequestParcel);
        throw new RemoteException();
      }
      continue;
      label204:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.zza paramzza, String paramString2)
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzzJ;
        if (paramAdRequestParcel.zzsD == null) {
          break label228;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzsD);
        Object localObject2;
        if (paramAdRequestParcel.zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, paramAdRequestParcel.zzsC, (Set)localObject1, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsF);
          if (paramAdRequestParcel.zzsL != null)
          {
            localObject1 = paramAdRequestParcel.zzsL.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzp(paramzzd), (MediationAdRequest)localObject2, paramString1, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(paramzza), zza(paramString2, paramAdRequestParcel.zzsF, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label228:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzeo paramzzeo)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzeo);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo)
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)this.zzzJ;
        if (paramAdRequestParcel.zzsD == null) {
          break label228;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzsD);
        Object localObject2;
        if (paramAdRequestParcel.zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, paramAdRequestParcel.zzsC, (Set)localObject1, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsF);
          if (paramAdRequestParcel.zzsL != null)
          {
            localObject1 = paramAdRequestParcel.zzsL.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzp(paramzzd), new zzeu(paramzzeo), zza(paramString1, paramAdRequestParcel.zzsF, paramString2), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label228:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationNativeAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationNativeAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)this.zzzJ;
        if (paramAdRequestParcel.zzsD == null) {
          break label235;
        }
        localHashSet = new HashSet(paramAdRequestParcel.zzsD);
        Date localDate;
        if (paramAdRequestParcel.zzsB == -1L)
        {
          localDate = null;
          paramList = new zzex(localDate, paramAdRequestParcel.zzsC, localHashSet, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsF, paramNativeAdOptionsParcel, paramList);
          if (paramAdRequestParcel.zzsL != null)
          {
            paramNativeAdOptionsParcel = paramAdRequestParcel.zzsL.getBundle(localMediationNativeAdapter.getClass().getName());
            this.zzzK = new zzeu(paramzzeo);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzp(paramzzd), this.zzzK, zza(paramString1, paramAdRequestParcel.zzsF, paramString2), paramList, paramNativeAdOptionsParcel);
          }
        }
        else
        {
          localDate = new Date(paramAdRequestParcel.zzsB);
          continue;
        }
        paramNativeAdOptionsParcel = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label235:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzeo paramzzeo)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzeo);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo)
    throws RemoteException
  {
    if (!(this.zzzJ instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.zzzJ;
        if (paramAdRequestParcel.zzsD == null) {
          break label244;
        }
        localObject1 = new HashSet(paramAdRequestParcel.zzsD);
        Object localObject2;
        if (paramAdRequestParcel.zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, paramAdRequestParcel.zzsC, (Set)localObject1, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsF);
          if (paramAdRequestParcel.zzsL != null)
          {
            localObject1 = paramAdRequestParcel.zzsL.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzp(paramzzd), new zzeu(paramzzeo), zza(paramString1, paramAdRequestParcel.zzsF, paramString2), com.google.android.gms.ads.zza.zza(paramAdSizeParcel.width, paramAdSizeParcel.height, paramAdSizeParcel.zzte), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(paramAdRequestParcel.zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label244:
      Object localObject1 = null;
    }
  }
  
  public zzeq zzdV()
  {
    NativeAdMapper localNativeAdMapper = this.zzzK.zzeb();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzev((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzer zzdW()
  {
    NativeAdMapper localNativeAdMapper = this.zzzK.zzeb();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzew((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzdX()
  {
    if (!(this.zzzJ instanceof zzjj))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzzJ.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjj)this.zzzJ).zzdX();
  }
  
  public Bundle zzdY()
  {
    if (!(this.zzzJ instanceof zzjk))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzzJ.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjk)this.zzzJ).zzdY();
  }
  
  public Bundle zzdZ()
  {
    return new Bundle();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */