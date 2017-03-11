package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzgr
public abstract class zzb
  extends zza
  implements com.google.android.gms.ads.internal.overlay.zzg, zzj, zzdm, zzef
{
  private final Messenger mMessenger;
  protected final zzem zzox;
  protected transient boolean zzoy;
  
  public zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this(new zzq(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramzzem, null, paramzzd);
  }
  
  zzb(zzq paramzzq, zzem paramzzem, zzo paramzzo, zzd paramzzd)
  {
    super(paramzzq, paramzzo, paramzzd);
    this.zzox = paramzzem;
    this.mMessenger = new Messenger(new zzfp(this.zzot.context));
    this.zzoy = false;
  }
  
  private AdRequestInfoParcel.zza zza(AdRequestParcel paramAdRequestParcel, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.zzot.context.getApplicationInfo();
    DisplayMetrics localDisplayMetrics;
    String str1;
    Object localObject;
    String str2;
    long l1;
    Bundle localBundle;
    ArrayList localArrayList;
    PackageInfo localPackageInfo2;
    try
    {
      PackageInfo localPackageInfo1 = this.zzot.context.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localDisplayMetrics = this.zzot.context.getResources().getDisplayMetrics();
      str1 = null;
      localObject = str1;
      if (this.zzot.zzqk != null)
      {
        localObject = str1;
        if (this.zzot.zzqk.getParent() != null)
        {
          localObject = new int[2];
          this.zzot.zzqk.getLocationOnScreen((int[])localObject);
          int k = localObject[0];
          int m = localObject[1];
          int n = this.zzot.zzqk.getWidth();
          int i1 = this.zzot.zzqk.getHeight();
          int j = 0;
          i = j;
          if (this.zzot.zzqk.isShown())
          {
            i = j;
            if (k + n > 0)
            {
              i = j;
              if (m + i1 > 0)
              {
                i = j;
                if (k <= localDisplayMetrics.widthPixels)
                {
                  i = j;
                  if (m <= localDisplayMetrics.heightPixels) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject = new Bundle(5);
          ((Bundle)localObject).putInt("x", k);
          ((Bundle)localObject).putInt("y", m);
          ((Bundle)localObject).putInt("width", n);
          ((Bundle)localObject).putInt("height", i1);
          ((Bundle)localObject).putInt("visible", i);
        }
      }
      str1 = zzp.zzby().zzgm();
      this.zzot.zzqq = new zzht(str1, this.zzot.zzqh);
      this.zzot.zzqq.zzi(paramAdRequestParcel);
      str2 = zzp.zzbv().zza(this.zzot.context, this.zzot.zzqk, this.zzot.zzqn);
      l2 = 0L;
      l1 = l2;
      if (this.zzot.zzqu == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        l1 = this.zzot.zzqu.getValue();
        String str3 = UUID.randomUUID().toString();
        localBundle = zzp.zzby().zza(this.zzot.context, this, str1);
        localArrayList = new ArrayList();
        int i = 0;
        while (i < this.zzot.zzqA.size())
        {
          localArrayList.add(this.zzot.zzqA.keyAt(i));
          i += 1;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo2 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          long l2;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if (this.zzot.zzqv != null)
    {
      bool1 = true;
      if ((this.zzot.zzqw == null) || (!zzp.zzby().zzgv())) {
        break label622;
      }
    }
    label622:
    for (boolean bool2 = true;; bool2 = false)
    {
      return new AdRequestInfoParcel.zza((Bundle)localObject, paramAdRequestParcel, this.zzot.zzqn, this.zzot.zzqh, localApplicationInfo, localPackageInfo2, str1, zzp.zzby().getSessionId(), this.zzot.zzqj, localBundle, this.zzot.zzqD, localArrayList, paramBundle, zzp.zzby().zzgq(), this.mMessenger, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels, localDisplayMetrics.density, str2, l1, localRemoteException, zzby.zzdf(), this.zzot.zzqg, this.zzot.zzqB, new CapabilityParcel(bool1, bool2), this.zzot.zzbR());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (this.zzot.zzqo == null) {
      return null;
    }
    return this.zzot.zzqo.zzzw;
  }
  
  public void onAdClicked()
  {
    if (this.zzot.zzqo == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((this.zzot.zzqo.zzHx != null) && (this.zzot.zzqo.zzHx.zzyY != null)) {
      zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo, this.zzot.zzqh, false, this.zzot.zzqo.zzHx.zzyY);
    }
    if ((this.zzot.zzqo.zzzu != null) && (this.zzot.zzqo.zzzu.zzyR != null)) {
      zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, this.zzot.zzqo, this.zzot.zzqh, false, this.zzot.zzqo.zzzu.zzyR);
    }
    super.onAdClicked();
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
    if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzBD != null) && (this.zzot.zzbN())) {
      zzp.zzbx().zza(this.zzot.zzqo.zzBD.getWebView());
    }
    if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzzv != null)) {}
    try
    {
      this.zzot.zzqo.zzzv.pause();
      this.zzov.zzg(this.zzot.zzqo);
      this.zzos.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
    if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzBD != null) && (this.zzot.zzbN())) {
      zzp.zzbx().zzb(this.zzot.zzqo.zzBD.getWebView());
    }
    if ((this.zzot.zzqo != null) && (this.zzot.zzqo.zzzv != null)) {}
    try
    {
      this.zzot.zzqo.zzzv.resume();
      this.zzos.resume();
      this.zzov.zzh(this.zzot.zzqo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzfs paramzzfs)
  {
    zzx.zzci("setInAppPurchaseListener must be called on the main UI thread.");
    this.zzot.zzqv = paramzzfs;
  }
  
  public void zza(zzfw paramzzfw, String paramString)
  {
    zzx.zzci("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.zzot.zzqE = new zzk(paramString);
    this.zzot.zzqw = paramzzfw;
    if ((!zzp.zzby().zzgp()) && (paramzzfw != null)) {
      new zzc(this.zzot.context, this.zzot.zzqw, this.zzot.zzqE).zzgz();
    }
  }
  
  protected void zza(zzhs paramzzhs, boolean paramBoolean)
  {
    if (paramzzhs == null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramzzhs);
      if ((paramzzhs.zzHx != null) && (paramzzhs.zzHx.zzyZ != null)) {
        zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, paramzzhs, this.zzot.zzqh, paramBoolean, paramzzhs.zzHx.zzyZ);
      }
    } while ((paramzzhs.zzzu == null) || (paramzzhs.zzzu.zzyS == null));
    zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, paramzzhs, this.zzot.zzqh, paramBoolean, paramzzhs.zzzu.zzyS);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, this.zzot.context, this.zzot.zzqj.zzJu);
    if (this.zzot.zzqv == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!zzl.zzcF().zzR(this.zzot.context))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (this.zzot.zzqw == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
        return;
      }
      if (this.zzot.zzqE == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (this.zzot.zzqI)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
        return;
      }
      this.zzot.zzqI = true;
      try
      {
        if (!this.zzot.zzqw.isValidPurchase(paramString))
        {
          this.zzot.zzqI = false;
          return;
        }
      }
      catch (RemoteException paramString)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        this.zzot.zzqI = false;
        return;
      }
      zzp.zzbF().zza(this.zzot.context, this.zzot.zzqj.zzJx, new GInAppPurchaseManagerInfoParcel(this.zzot.context, this.zzot.zzqE, paramArrayList, this));
      return;
    }
    try
    {
      this.zzot.zzqv.zza(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramzzf)
  {
    try
    {
      if (this.zzot.zzqw != null) {
        this.zzot.zzqw.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzot.context, paramString, paramBoolean, paramInt, paramIntent, paramzzf));
      }
      zzid.zzIE.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzp.zzbF().zzd(paramIntent);
          zzp.zzbF();
          if ((i == 0) && (zzb.this.zzot.zzqo != null) && (zzb.this.zzot.zzqo.zzBD != null) && (zzb.this.zzot.zzqo.zzBD.zzhc() != null)) {
            zzb.this.zzot.zzqo.zzBD.zzhc().close();
          }
          zzb.this.zzot.zzqI = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg)
  {
    if (!zzaU()) {
      return false;
    }
    Bundle localBundle = zza(zzp.zzby().zzE(this.zzot.context));
    this.zzos.cancel();
    this.zzot.zzqH = 0;
    paramAdRequestParcel = zza(paramAdRequestParcel, localBundle);
    paramzzcg.zze("seq_num", paramAdRequestParcel.zzEq);
    paramzzcg.zze("request_id", paramAdRequestParcel.zzEC);
    paramzzcg.zze("session_id", paramAdRequestParcel.zzEr);
    if (paramAdRequestParcel.zzEo != null) {
      paramzzcg.zze("app_version", String.valueOf(paramAdRequestParcel.zzEo.versionCode));
    }
    this.zzot.zzql = zzp.zzbr().zza(this.zzot.context, paramAdRequestParcel, this.zzot.zzqi, this);
    return true;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzhs paramzzhs, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.zzot.zzbN()))
    {
      if (paramzzhs.zzzc <= 0L) {
        break label43;
      }
      this.zzos.zza(paramAdRequestParcel, paramzzhs.zzzc);
    }
    for (;;)
    {
      return this.zzos.zzbp();
      label43:
      if ((paramzzhs.zzHx != null) && (paramzzhs.zzHx.zzzc > 0L)) {
        this.zzos.zza(paramAdRequestParcel, paramzzhs.zzHx.zzzc);
      } else if ((!paramzzhs.zzEK) && (paramzzhs.errorCode == 2)) {
        this.zzos.zzg(paramAdRequestParcel);
      }
    }
  }
  
  boolean zza(zzhs paramzzhs)
  {
    boolean bool = false;
    Object localObject;
    if (this.zzou != null)
    {
      localObject = this.zzou;
      this.zzou = null;
    }
    for (;;)
    {
      return zza((AdRequestParcel)localObject, paramzzhs, bool);
      AdRequestParcel localAdRequestParcel = paramzzhs.zzEn;
      localObject = localAdRequestParcel;
      if (localAdRequestParcel.extras != null)
      {
        bool = localAdRequestParcel.extras.getBoolean("_noRefresh", false);
        localObject = localAdRequestParcel;
      }
    }
  }
  
  protected boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    int i = 0;
    if ((paramzzhs1 != null) && (paramzzhs1.zzzx != null)) {
      paramzzhs1.zzzx.zza(null);
    }
    if (paramzzhs2.zzzx != null) {
      paramzzhs2.zzzx.zza(this);
    }
    int j;
    if (paramzzhs2.zzHx != null)
    {
      j = paramzzhs2.zzHx.zzzf;
      i = paramzzhs2.zzHx.zzzg;
    }
    for (;;)
    {
      this.zzot.zzqF.zzf(j, i);
      return true;
      j = 0;
    }
  }
  
  protected boolean zzaU()
  {
    boolean bool = true;
    if ((!zzp.zzbv().zza(this.zzot.context.getPackageManager(), this.zzot.context.getPackageName(), "android.permission.INTERNET")) || (!zzp.zzbv().zzH(this.zzot.context))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzaV()
  {
    this.zzov.zze(this.zzot.zzqo);
    this.zzoy = false;
    zzaQ();
    this.zzot.zzqq.zzgh();
  }
  
  public void zzaW()
  {
    this.zzoy = true;
    zzaS();
  }
  
  public void zzaX()
  {
    onAdClicked();
  }
  
  public void zzaY()
  {
    zzaV();
  }
  
  public void zzaZ()
  {
    zzaO();
  }
  
  public void zzb(zzhs paramzzhs)
  {
    super.zzb(paramzzhs);
    if ((paramzzhs.errorCode == 3) && (paramzzhs.zzHx != null) && (paramzzhs.zzHx.zzza != null))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
      zzp.zzbH().zza(this.zzot.context, this.zzot.zzqj.zzJu, paramzzhs, this.zzot.zzqh, false, paramzzhs.zzHx.zzza);
    }
  }
  
  public void zzba()
  {
    zzaW();
  }
  
  public void zzbb()
  {
    if (this.zzot.zzqo != null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Mediation adapter " + this.zzot.zzqo.zzzw + " refreshed, but mediation adapters should never refresh.");
    }
    zza(this.zzot.zzqo, true);
    zzaT();
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    return (super.zzc(paramAdRequestParcel)) && (!this.zzoy);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */