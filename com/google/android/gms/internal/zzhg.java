package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@zzgr
public class zzhg
  extends com.google.android.gms.ads.internal.zzb
  implements zzhk
{
  private zzd zzGX;
  private String zzGY;
  private boolean zzGZ;
  private HashMap<String, zzhh> zzHa = new HashMap();
  
  public zzhg(Context paramContext, AdSizeParcel paramAdSizeParcel, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramzzem, paramVersionInfoParcel, null);
  }
  
  public void destroy()
  {
    zzx.zzci("destroy must be called on the main UI thread.");
    Iterator localIterator = this.zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)this.zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().destroy();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to destroy adapter: " + str);
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzx.zzci("isLoaded must be called on the main UI thread.");
    return (this.zzot.zzql == null) && (this.zzot.zzqm == null) && (this.zzot.zzqo != null) && (!this.zzGZ);
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (this.zzGX == null) {
      return;
    }
    try
    {
      this.zzGX.onRewardedVideoAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (this.zzGX == null) {
      return;
    }
    try
    {
      this.zzGX.onRewardedVideoAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(this.zzot.zzqo, false);
    if (this.zzGX == null) {
      return;
    }
    try
    {
      this.zzGX.onRewardedVideoAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", localRemoteException);
    }
  }
  
  public void onRewardedVideoStarted()
  {
    zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo, this.zzot.zzqh, false, this.zzot.zzqo.zzzu.zzyU);
    if (this.zzGX == null) {
      return;
    }
    try
    {
      this.zzGX.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
    Iterator localIterator = this.zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)this.zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().pause();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to pause adapter: " + str);
      }
    }
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
    Iterator localIterator = this.zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)this.zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().resume();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to resume adapter: " + str);
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    zzx.zzci("setUserId must be called on the main UI thread.");
    this.zzGY = paramString;
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    zzx.zzci("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(paramRewardedVideoAdRequestParcel.zzqh))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
      return;
    }
    this.zzGZ = false;
    this.zzot.zzqh = paramRewardedVideoAdRequestParcel.zzqh;
    super.zzb(paramRewardedVideoAdRequestParcel.zzEn);
  }
  
  public void zza(zzd paramzzd)
  {
    zzx.zzci("setRewardedVideoAdListener must be called on the main UI thread.");
    this.zzGX = paramzzd;
  }
  
  public void zza(RewardItemParcel paramRewardItemParcel)
  {
    zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo, this.zzot.zzqh, false, this.zzot.zzqo.zzzu.zzyV);
    if (this.zzGX == null) {
      return;
    }
    try
    {
      if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzHx != null) && (!TextUtils.isEmpty(this.zzot.zzqo.zzHx.zzzd)))
      {
        this.zzGX.zza(new zzhe(this.zzot.zzqo.zzHx.zzzd, this.zzot.zzqo.zzHx.zzze));
        return;
      }
    }
    catch (RemoteException paramRewardItemParcel)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", paramRewardItemParcel);
      return;
    }
    this.zzGX.zza(new zzhe(paramRewardItemParcel.type, paramRewardItemParcel.zzHv));
  }
  
  public void zza(final zzhs.zza paramzza, zzcg paramzzcg)
  {
    if (paramzza.errorCode != -2)
    {
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzhg.this.zzb(new zzhs(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    this.zzot.zzqH = 0;
    this.zzot.zzqm = new zzhn(this.zzot.context, this.zzGY, paramzza, this);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzot.zzqm.getClass().getName());
    this.zzot.zzqm.zzfu();
  }
  
  public boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (this.zzGX != null) {}
    try
    {
      this.zzGX.onRewardedVideoAdLoaded();
      return true;
    }
    catch (RemoteException paramzzhs1)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", paramzzhs1);
      }
    }
  }
  
  public zzhh zzau(String paramString)
  {
    localObject1 = (zzhh)this.zzHa.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = new zzhh(this.zzox.zzae(paramString), this);
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + paramString, localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        this.zzHa.put(paramString, localObject2);
        return (zzhh)localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject3 = localException2;
        }
      }
      localException1 = localException1;
    }
    return (zzhh)localObject1;
  }
  
  protected boolean zze(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load ad: " + paramInt);
    if (this.zzGX == null) {
      return false;
    }
    try
    {
      this.zzGX.onRewardedVideoAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  public void zzga()
  {
    zzx.zzci("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
    }
    zzhh localzzhh;
    do
    {
      return;
      this.zzGZ = true;
      localzzhh = zzau(this.zzot.zzqo.zzzw);
    } while ((localzzhh == null) || (localzzhh.zzgc() == null));
    try
    {
      localzzhh.zzgc().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzgb()
  {
    onAdClicked();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */