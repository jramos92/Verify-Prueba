package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;

@zzgr
public class zzk
  extends zzc
  implements zzdo
{
  protected transient boolean zzpk = false;
  private boolean zzpl;
  private float zzpm;
  private String zzpn = "background" + hashCode() + "." + "png";
  
  public zzk(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, paramzzd);
  }
  
  private void zzb(Bundle paramBundle)
  {
    zzp.zzbv().zzb(this.zzot.context, this.zzot.zzqj.zzJu, "gmob-apps", paramBundle, false);
  }
  
  private void zzbm()
  {
    new zza(this.zzpn).zzgz();
    if (this.zzot.zzbN())
    {
      this.zzot.zzbK();
      this.zzot.zzqo = null;
      this.zzot.zzpt = false;
      this.zzpk = false;
    }
  }
  
  public void showInterstitial()
  {
    zzx.zzci("showInterstitial must be called on the main UI thread.");
    if (this.zzot.zzqo == null)
    {
      zzb.zzaH("The interstitial has not loaded.");
      return;
    }
    if (((Boolean)zzby.zzvo.get()).booleanValue()) {
      if (this.zzot.context.getApplicationContext() == null) {
        break label211;
      }
    }
    label211:
    for (String str = this.zzot.context.getApplicationContext().getPackageName();; localObject = this.zzot.context.getPackageName())
    {
      Bundle localBundle;
      if (!this.zzpk)
      {
        zzb.zzaH("It is not recommended to show an interstitial before onAdLoaded completes.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_before_load_finish");
        zzb(localBundle);
      }
      if (!zzp.zzbv().zzN(this.zzot.context))
      {
        zzb.zzaH("It is not recommended to show an interstitial when app is not in foreground.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_app_not_in_foreground");
        zzb(localBundle);
      }
      if (this.zzot.zzbO()) {
        break;
      }
      if (!this.zzot.zzqo.zzEK) {
        break label225;
      }
      try
      {
        this.zzot.zzqo.zzzv.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzd("Could not show interstitial.", localRemoteException);
        zzbm();
        return;
      }
    }
    label225:
    if (this.zzot.zzqo.zzBD == null)
    {
      zzb.zzaH("The interstitial failed to load.");
      return;
    }
    if (this.zzot.zzqo.zzBD.zzhi())
    {
      zzb.zzaH("The interstitial is already showing.");
      return;
    }
    this.zzot.zzqo.zzBD.zzC(true);
    if (this.zzot.zzqo.zzHw != null) {
      this.zzov.zza(this.zzot.zzqn, this.zzot.zzqo);
    }
    if (this.zzot.zzpt) {}
    for (Object localObject = zzp.zzbv().zzO(this.zzot.context); (((Boolean)zzby.zzvz.get()).booleanValue()) && (localObject != null); localObject = null)
    {
      new zzb((Bitmap)localObject, this.zzpn).zzgz();
      return;
    }
    localObject = new InterstitialAdParameterParcel(this.zzot.zzpt, zzbl(), null, false, 0.0F);
    int j = this.zzot.zzqo.zzBD.getRequestedOrientation();
    int i = j;
    if (j == -1) {
      i = this.zzot.zzqo.orientation;
    }
    localObject = new AdOverlayInfoParcel(this, this, this, this.zzot.zzqo.zzBD, i, this.zzot.zzqj, this.zzot.zzqo.zzEP, (InterstitialAdParameterParcel)localObject);
    zzp.zzbt().zza(this.zzot.context, (AdOverlayInfoParcel)localObject);
  }
  
  protected zziz zza(zzhs.zza paramzza, zze paramzze)
  {
    zziz localzziz = zzp.zzbw().zza(this.zzot.context, this.zzot.zzqn, false, false, this.zzot.zzqi, this.zzot.zzqj, this.zzoo, this.zzow);
    localzziz.zzhe().zzb(this, null, this, this, ((Boolean)zzby.zzvc.get()).booleanValue(), this, this, paramzze, null);
    localzziz.zzaJ(paramzza.zzHC.zzEC);
    return localzziz;
  }
  
  public void zza(boolean paramBoolean, float paramFloat)
  {
    this.zzpl = paramBoolean;
    this.zzpm = paramFloat;
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg)
  {
    if (this.zzot.zzqo != null)
    {
      zzb.zzaH("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.zza(paramAdRequestParcel, paramzzcg);
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzhs paramzzhs, boolean paramBoolean)
  {
    if ((this.zzot.zzbN()) && (paramzzhs.zzBD != null)) {
      zzp.zzbx().zza(paramzzhs.zzBD.getWebView());
    }
    return this.zzos.zzbp();
  }
  
  public boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (!super.zza(paramzzhs1, paramzzhs2)) {
      return false;
    }
    if ((!this.zzot.zzbN()) && (this.zzot.zzqG != null) && (paramzzhs2.zzHw != null)) {
      this.zzov.zza(this.zzot.zzqn, paramzzhs2, this.zzot.zzqG);
    }
    return true;
  }
  
  protected boolean zzaQ()
  {
    zzbm();
    return super.zzaQ();
  }
  
  protected boolean zzaT()
  {
    if (super.zzaT())
    {
      this.zzpk = true;
      return true;
    }
    return false;
  }
  
  public void zzaW()
  {
    recordImpression();
    super.zzaW();
  }
  
  protected boolean zzbl()
  {
    if (!(this.zzot.context instanceof Activity)) {}
    Window localWindow;
    do
    {
      return false;
      localWindow = ((Activity)this.zzot.context).getWindow();
    } while ((localWindow == null) || (localWindow.getDecorView() == null));
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    if ((localRect1.bottom != 0) && (localRect2.bottom != 0) && (localRect1.top == localRect2.top)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzd(boolean paramBoolean)
  {
    this.zzot.zzpt = paramBoolean;
  }
  
  @zzgr
  private class zza
    extends zzhz
  {
    private final String zzpo;
    
    public zza(String paramString)
    {
      this.zzpo = paramString;
    }
    
    public void onStop() {}
    
    public void zzbn()
    {
      zzp.zzbv().zzh(zzk.this.zzot.context, this.zzpo);
    }
  }
  
  @zzgr
  private class zzb
    extends zzhz
  {
    private final String zzpo;
    private final Bitmap zzpq;
    
    public zzb(Bitmap paramBitmap, String paramString)
    {
      this.zzpq = paramBitmap;
      this.zzpo = paramString;
    }
    
    public void onStop() {}
    
    public void zzbn()
    {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (zzk.this.zzot.zzpt)
      {
        bool1 = zzp.zzbv().zza(zzk.this.zzot.context, this.zzpq, this.zzpo);
        bool2 = zzk.this.zzot.zzpt;
        bool3 = zzk.this.zzbl();
        if (!bool1) {
          break label221;
        }
      }
      label221:
      for (final Object localObject = this.zzpo;; localObject = null)
      {
        localObject = new InterstitialAdParameterParcel(bool2, bool3, (String)localObject, zzk.zza(zzk.this), zzk.zzb(zzk.this));
        int j = zzk.this.zzot.zzqo.zzBD.getRequestedOrientation();
        int i = j;
        if (j == -1) {
          i = zzk.this.zzot.zzqo.orientation;
        }
        localObject = new AdOverlayInfoParcel(zzk.this, zzk.this, zzk.this, zzk.this.zzot.zzqo.zzBD, i, zzk.this.zzot.zzqj, zzk.this.zzot.zzqo.zzEP, (InterstitialAdParameterParcel)localObject);
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzp.zzbt().zza(zzk.this.zzot.context, localObject);
          }
        });
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */