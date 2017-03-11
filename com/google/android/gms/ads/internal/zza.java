package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zza.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgg.zza;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.HashSet;

@zzgr
public abstract class zza
  extends zzs.zza
  implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzn, zza.zza, zzdg, zzgg.zza, zzhw
{
  protected zzcg zzoo;
  protected zzce zzop;
  protected zzce zzoq;
  boolean zzor = false;
  protected final zzo zzos;
  protected final zzq zzot;
  protected transient AdRequestParcel zzou;
  protected final zzay zzov;
  protected final zzd zzow;
  
  zza(zzq paramzzq, zzo paramzzo, zzd paramzzd)
  {
    this.zzot = paramzzq;
    if (paramzzo != null) {}
    for (;;)
    {
      this.zzos = paramzzo;
      this.zzow = paramzzd;
      zzp.zzbv().zzI(this.zzot.context);
      zzp.zzby().zzb(this.zzot.context, this.zzot.zzqj);
      this.zzov = zzp.zzby().zzgt();
      return;
      paramzzo = new zzo(this);
    }
  }
  
  private AdRequestParcel zza(AdRequestParcel paramAdRequestParcel)
  {
    AdRequestParcel localAdRequestParcel = paramAdRequestParcel;
    if (GooglePlayServicesUtil.zzag(this.zzot.context))
    {
      localAdRequestParcel = paramAdRequestParcel;
      if (paramAdRequestParcel.zzsJ != null) {
        localAdRequestParcel = new zzf(paramAdRequestParcel).zza(null).zzcA();
      }
    }
    return localAdRequestParcel;
  }
  
  private boolean zzaR()
  {
    zzb.zzaG("Ad leaving application.");
    if (this.zzot.zzqs == null) {
      return false;
    }
    try
    {
      this.zzot.zzqs.onAdLeftApplication();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
    return false;
  }
  
  public void destroy()
  {
    zzx.zzci("destroy must be called on the main UI thread.");
    this.zzos.cancel();
    this.zzov.zzf(this.zzot.zzqo);
    this.zzot.destroy();
  }
  
  public boolean isLoading()
  {
    return this.zzor;
  }
  
  public boolean isReady()
  {
    zzx.zzci("isLoaded must be called on the main UI thread.");
    return (this.zzot.zzql == null) && (this.zzot.zzqm == null) && (this.zzot.zzqo != null);
  }
  
  public void onAdClicked()
  {
    if (this.zzot.zzqo == null) {
      zzb.zzaH("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging click URLs.");
      this.zzot.zzqq.zzgg();
      if (this.zzot.zzqo.zzyY != null) {
        zzp.zzbv().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo.zzyY);
      }
    } while (this.zzot.zzqr == null);
    try
    {
      this.zzot.zzqr.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not notify onAdClicked event.", localRemoteException);
    }
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (this.zzot.zzqt != null) {}
    try
    {
      this.zzot.zzqt.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      zzb.zzd("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
  }
  
  protected void recordImpression()
  {
    zzc(this.zzot.zzqo);
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  public void stopLoading()
  {
    zzx.zzci("stopLoading must be called on the main UI thread.");
    this.zzor = false;
    this.zzot.zzf(true);
  }
  
  Bundle zza(zzbk paramzzbk)
  {
    if (paramzzbk == null) {}
    for (;;)
    {
      return null;
      if (paramzzbk.zzcx()) {
        paramzzbk.wakeup();
      }
      Object localObject = paramzzbk.zzcv();
      if (localObject != null)
      {
        paramzzbk = ((zzbh)localObject).zzcm();
        zzb.zzaF("In AdManger: loadAd, " + ((zzbh)localObject).toString());
      }
      while (paramzzbk != null)
      {
        localObject = new Bundle(1);
        ((Bundle)localObject).putString("fingerprint", paramzzbk);
        ((Bundle)localObject).putInt("v", 1);
        return (Bundle)localObject;
        paramzzbk = null;
      }
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzx.zzci("setAdSize must be called on the main UI thread.");
    this.zzot.zzqn = paramAdSizeParcel;
    if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzBD != null) && (this.zzot.zzqH == 0)) {
      this.zzot.zzqo.zzBD.zza(paramAdSizeParcel);
    }
    if (this.zzot.zzqk == null) {
      return;
    }
    if (this.zzot.zzqk.getChildCount() > 1) {
      this.zzot.zzqk.removeView(this.zzot.zzqk.getNextView());
    }
    this.zzot.zzqk.setMinimumWidth(paramAdSizeParcel.widthPixels);
    this.zzot.zzqk.setMinimumHeight(paramAdSizeParcel.heightPixels);
    this.zzot.zzqk.requestLayout();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzn paramzzn)
  {
    zzx.zzci("setAdListener must be called on the main UI thread.");
    this.zzot.zzqr = paramzzn;
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzo paramzzo)
  {
    zzx.zzci("setAdListener must be called on the main UI thread.");
    this.zzot.zzqs = paramzzo;
  }
  
  public void zza(zzu paramzzu)
  {
    zzx.zzci("setAppEventListener must be called on the main UI thread.");
    this.zzot.zzqt = paramzzu;
  }
  
  public void zza(zzv paramzzv)
  {
    zzx.zzci("setCorrelationIdProvider must be called on the main UI thread");
    this.zzot.zzqu = paramzzv;
  }
  
  public void zza(zzck paramzzck)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }
  
  public void zza(zzfs paramzzfs)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }
  
  public void zza(zzfw paramzzfw, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }
  
  public void zza(zzhs.zza paramzza)
  {
    if ((paramzza.zzHD.zzEO != -1L) && (!TextUtils.isEmpty(paramzza.zzHD.zzEY)))
    {
      long l = zzo(paramzza.zzHD.zzEY);
      if (l != -1L)
      {
        zzce localzzce = this.zzoo.zzb(l + paramzza.zzHD.zzEO);
        this.zzoo.zza(localzzce, new String[] { "stc" });
      }
    }
    this.zzoo.zzT(paramzza.zzHD.zzEY);
    this.zzoo.zza(this.zzop, new String[] { "arf" });
    this.zzoq = this.zzoo.zzdn();
    this.zzoo.zze("gqi", paramzza.zzHD.zzEZ);
    this.zzot.zzql = null;
    this.zzot.zzqp = paramzza;
    zza(paramzza, this.zzoo);
  }
  
  protected abstract void zza(zzhs.zza paramzza, zzcg paramzzcg);
  
  public void zza(HashSet<zzht> paramHashSet)
  {
    this.zzot.zza(paramHashSet);
  }
  
  protected abstract boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg);
  
  boolean zza(zzhs paramzzhs)
  {
    return false;
  }
  
  protected abstract boolean zza(zzhs paramzzhs1, zzhs paramzzhs2);
  
  void zzaL()
  {
    this.zzoo = new zzcg(((Boolean)zzby.zzuQ.get()).booleanValue(), "load_ad", this.zzot.zzqn.zzte);
    this.zzop = new zzce(-1L, null, null);
    this.zzoq = new zzce(-1L, null, null);
  }
  
  public com.google.android.gms.dynamic.zzd zzaM()
  {
    zzx.zzci("getAdFrame must be called on the main UI thread.");
    return zze.zzy(this.zzot.zzqk);
  }
  
  public AdSizeParcel zzaN()
  {
    zzx.zzci("getAdSize must be called on the main UI thread.");
    if (this.zzot.zzqn == null) {
      return null;
    }
    return new ThinAdSizeParcel(this.zzot.zzqn);
  }
  
  public void zzaO()
  {
    zzaR();
  }
  
  public void zzaP()
  {
    zzx.zzci("recordManualImpression must be called on the main UI thread.");
    if (this.zzot.zzqo == null) {
      zzb.zzaH("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging manual tracking URLs.");
    } while (this.zzot.zzqo.zzEM == null);
    zzp.zzbv().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo.zzEM);
  }
  
  protected boolean zzaQ()
  {
    zzb.v("Ad closing.");
    if (this.zzot.zzqs == null) {
      return false;
    }
    try
    {
      this.zzot.zzqs.onAdClosed();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdClosed().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaS()
  {
    zzb.zzaG("Ad opening.");
    if (this.zzot.zzqs == null) {
      return false;
    }
    try
    {
      this.zzot.zzqs.onAdOpened();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdOpened().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaT()
  {
    zzb.zzaG("Ad finished loading.");
    this.zzor = false;
    if (this.zzot.zzqs == null) {
      return false;
    }
    try
    {
      this.zzot.zzqs.onAdLoaded();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
    return false;
  }
  
  protected void zzb(View paramView)
  {
    this.zzot.zzqk.addView(paramView, zzp.zzbx().zzgJ());
  }
  
  public void zzb(zzhs paramzzhs)
  {
    this.zzoo.zza(this.zzoq, new String[] { "awr" });
    this.zzot.zzqm = null;
    if ((paramzzhs.errorCode != -2) && (paramzzhs.errorCode != 3)) {
      zzp.zzby().zzb(this.zzot.zzbJ());
    }
    if (paramzzhs.errorCode == -1) {
      this.zzor = false;
    }
    do
    {
      return;
      if (zza(paramzzhs)) {
        zzb.zzaF("Ad refresh scheduled.");
      }
      if (paramzzhs.errorCode != -2)
      {
        zze(paramzzhs.errorCode);
        return;
      }
      if (this.zzot.zzqF == null) {
        this.zzot.zzqF = new zzhx(this.zzot.zzqh);
      }
      this.zzov.zze(this.zzot.zzqo);
    } while (!zza(this.zzot.zzqo, paramzzhs));
    this.zzot.zzqo = paramzzhs;
    this.zzot.zzbS();
    zzcg localzzcg = this.zzoo;
    if (this.zzot.zzqo.zzbY())
    {
      paramzzhs = "1";
      label204:
      localzzcg.zze("is_mraid", paramzzhs);
      localzzcg = this.zzoo;
      if (!this.zzot.zzqo.zzEK) {
        break label379;
      }
      paramzzhs = "1";
      label234:
      localzzcg.zze("is_mediation", paramzzhs);
      if ((this.zzot.zzqo.zzBD != null) && (this.zzot.zzqo.zzBD.zzhe() != null))
      {
        localzzcg = this.zzoo;
        if (!this.zzot.zzqo.zzBD.zzhe().zzhr()) {
          break label386;
        }
      }
    }
    label379:
    label386:
    for (paramzzhs = "1";; paramzzhs = "0")
    {
      localzzcg.zze("is_video", paramzzhs);
      this.zzoo.zza(this.zzop, new String[] { "ttc" });
      if (zzp.zzby().zzgo() != null) {
        zzp.zzby().zzgo().zza(this.zzoo);
      }
      if (!this.zzot.zzbN()) {
        break;
      }
      zzaT();
      return;
      paramzzhs = "0";
      break label204;
      paramzzhs = "0";
      break label234;
    }
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    zzx.zzci("loadAd must be called on the main UI thread.");
    paramAdRequestParcel = zza(paramAdRequestParcel);
    if (this.zzor)
    {
      if (this.zzou != null) {
        zzb.zzaH("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      this.zzou = paramAdRequestParcel;
      return false;
    }
    zzb.zzaG("Starting ad request.");
    this.zzor = true;
    zzaL();
    this.zzop = this.zzoo.zzdn();
    if (!paramAdRequestParcel.zzsE) {
      zzb.zzaG("Use AdRequest.Builder.addTestDevice(\"" + zzl.zzcF().zzQ(this.zzot.context) + "\") to get test ads on this device.");
    }
    return zza(paramAdRequestParcel, this.zzoo);
  }
  
  protected void zzc(zzhs paramzzhs)
  {
    if (paramzzhs == null) {
      zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging Impression URLs.");
      this.zzot.zzqq.zzgf();
    } while (paramzzhs.zzyZ == null);
    zzp.zzbv().zza(this.zzot.context, this.zzot.zzqj.zzJu, paramzzhs.zzyZ);
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = this.zzot.zzqk.getParent();
    return ((paramAdRequestParcel instanceof View)) && (((View)paramAdRequestParcel).isShown()) && (zzp.zzbv().zzgB());
  }
  
  public void zzd(AdRequestParcel paramAdRequestParcel)
  {
    if (zzc(paramAdRequestParcel))
    {
      zzb(paramAdRequestParcel);
      return;
    }
    zzb.zzaG("Ad is not visible. Not refreshing ad.");
    this.zzos.zzg(paramAdRequestParcel);
  }
  
  protected boolean zze(int paramInt)
  {
    zzb.zzaH("Failed to load ad: " + paramInt);
    this.zzor = false;
    if (this.zzot.zzqs == null) {
      return false;
    }
    try
    {
      this.zzot.zzqs.onAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  long zzo(String paramString)
  {
    int k = paramString.indexOf("ufe");
    int j = paramString.indexOf(',', k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      long l = Long.parseLong(paramString.substring(k + 4, i));
      return l;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      zzb.zzaH("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        zzb.zzaH("Cannot find valid format of Url fetch time in CSI latency info.");
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */