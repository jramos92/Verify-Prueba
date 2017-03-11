package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.util.List;

@zzgr
public class zzn
  extends zzb
{
  public zzn(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, null);
  }
  
  private static zzd zza(zzeq paramzzeq)
    throws RemoteException
  {
    String str1 = paramzzeq.getHeadline();
    List localList = paramzzeq.getImages();
    String str2 = paramzzeq.getBody();
    if (paramzzeq.zzdw() != null) {}
    for (zzcm localzzcm = paramzzeq.zzdw();; localzzcm = null) {
      return new zzd(str1, localList, str2, localzzcm, paramzzeq.getCallToAction(), paramzzeq.getStarRating(), paramzzeq.getStore(), paramzzeq.getPrice(), null, paramzzeq.getExtras());
    }
  }
  
  private static zze zza(zzer paramzzer)
    throws RemoteException
  {
    String str1 = paramzzer.getHeadline();
    List localList = paramzzer.getImages();
    String str2 = paramzzer.getBody();
    if (paramzzer.zzdA() != null) {}
    for (zzcm localzzcm = paramzzer.zzdA();; localzzcm = null) {
      return new zze(str1, localList, str2, localzzcm, paramzzer.getCallToAction(), paramzzer.getAdvertiser(), null, paramzzer.getExtras());
    }
  }
  
  private void zza(final zzd paramzzd)
  {
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        try
        {
          zzn.this.zzot.zzqx.zza(paramzzd);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zze paramzze)
  {
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        try
        {
          zzn.this.zzot.zzqy.zza(paramzze);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  private void zza(final zzhs paramzzhs, final String paramString)
  {
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        try
        {
          ((zzcz)zzn.this.zzot.zzqA.get(paramString)).zza((zzf)paramzzhs.zzHB);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
        }
      }
    });
  }
  
  public void pause()
  {
    throw new IllegalStateException("Native Ad DOES NOT support pause().");
  }
  
  public void recordImpression()
  {
    zza(this.zzot.zzqo, false);
  }
  
  public void resume()
  {
    throw new IllegalStateException("Native Ad DOES NOT support resume().");
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
  }
  
  public void zza(zzck paramzzck)
  {
    throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
  }
  
  public void zza(zzfs paramzzfs)
  {
    throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
  }
  
  public void zza(final zzhs.zza paramzza, zzcg paramzzcg)
  {
    if (paramzza.zzqn != null) {
      this.zzot.zzqn = paramzza.zzqn;
    }
    if (paramzza.errorCode != -2)
    {
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzn.this.zzb(new zzhs(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    this.zzot.zzqH = 0;
    this.zzot.zzqm = zzp.zzbu().zza(this.zzot.context, this, paramzza, this.zzot.zzqi, null, this.zzox, this, paramzzcg);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzot.zzqm.getClass().getName());
  }
  
  public void zza(zzmi<String, zzcz> paramzzmi)
  {
    zzx.zzci("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    this.zzot.zzqA = paramzzmi;
  }
  
  public void zza(List<String> paramList)
  {
    zzx.zzci("setNativeTemplates must be called on the main UI thread.");
    this.zzot.zzqD = paramList;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzhs paramzzhs, boolean paramBoolean)
  {
    return this.zzos.zzbp();
  }
  
  protected boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    zza(null);
    if (!this.zzot.zzbN()) {
      throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }
    if (paramzzhs2.zzEK) {}
    for (;;)
    {
      try
      {
        localObject1 = paramzzhs2.zzzv.zzdV();
        localObject2 = paramzzhs2.zzzv.zzdW();
        if (localObject1 == null) {
          continue;
        }
        localObject2 = zza((zzeq)localObject1);
        ((zzd)localObject2).zza(new zzg(this.zzot.context, this, this.zzot.zzqi, (zzeq)localObject1));
        zza((zzd)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        Object localObject1;
        Object localObject2;
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get native ad mapper", localRemoteException);
        continue;
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching mapper for retrieved native ad template.");
        zze(0);
        return false;
      }
      return super.zza(paramzzhs1, paramzzhs2);
      if (localObject2 != null)
      {
        localObject1 = zza((zzer)localObject2);
        ((zze)localObject1).zza(new zzg(this.zzot.context, this, this.zzot.zzqi, (zzer)localObject2));
        zza((zze)localObject1);
      }
      else
      {
        zzh.zza localzza = paramzzhs2.zzHB;
        if (((localzza instanceof zze)) && (this.zzot.zzqy != null))
        {
          zza((zze)paramzzhs2.zzHB);
        }
        else if (((localzza instanceof zzd)) && (this.zzot.zzqx != null))
        {
          zza((zzd)paramzzhs2.zzHB);
        }
        else
        {
          if ((!(localzza instanceof zzf)) || (this.zzot.zzqA == null) || (this.zzot.zzqA.get(((zzf)localzza).getCustomTemplateId()) == null)) {
            break;
          }
          zza(paramzzhs2, ((zzf)localzza).getCustomTemplateId());
        }
      }
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("No matching listener for retrieved native ad template.");
    zze(0);
    return false;
  }
  
  public void zzb(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    zzx.zzci("setNativeAdOptions must be called on the main UI thread.");
    this.zzot.zzqB = paramNativeAdOptionsParcel;
  }
  
  public void zzb(zzcw paramzzcw)
  {
    zzx.zzci("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
    this.zzot.zzqx = paramzzcw;
  }
  
  public void zzb(zzcx paramzzcx)
  {
    zzx.zzci("setOnContentAdLoadedListener must be called on the main UI thread.");
    this.zzot.zzqy = paramzzcx;
  }
  
  public void zzb(zzmi<String, zzcy> paramzzmi)
  {
    zzx.zzci("setOnCustomClickListener must be called on the main UI thread.");
    this.zzot.zzqz = paramzzmi;
  }
  
  public zzmi<String, zzcz> zzbo()
  {
    zzx.zzci("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
    return this.zzot.zzqA;
  }
  
  public zzcy zzr(String paramString)
  {
    zzx.zzci("getOnCustomClickListener must be called on the main UI thread.");
    return (zzcy)this.zzot.zzqz.get(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */