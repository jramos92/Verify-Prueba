package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgr
public class zzja
  extends WebViewClient
{
  private static final String[] zzJU = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzJV = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private zzfi zzAl;
  private zza zzDn;
  private final HashMap<String, List<zzdk>> zzJW = new HashMap();
  private zzg zzJX;
  private zzb zzJY;
  private boolean zzJZ = false;
  private boolean zzKa;
  private zzn zzKb;
  private final zzfg zzKc;
  private boolean zzKd;
  private boolean zzKe;
  private boolean zzKf;
  private boolean zzKg;
  private int zzKh;
  protected zziz zzoM;
  private final Object zzpd = new Object();
  private boolean zzqW;
  private zza zzsy;
  private zzdo zzxO;
  private com.google.android.gms.ads.internal.zze zzxQ;
  private zzfc zzxR;
  private zzdm zzxT;
  private zzdg zzxn;
  
  public zzja(zziz paramzziz, boolean paramBoolean)
  {
    this(paramzziz, paramBoolean, new zzfg(paramzziz, paramzziz.zzha(), new zzbq(paramzziz.getContext())), null);
  }
  
  zzja(zziz paramzziz, boolean paramBoolean, zzfg paramzzfg, zzfc paramzzfc)
  {
    this.zzoM = paramzziz;
    this.zzqW = paramBoolean;
    this.zzKc = paramzzfg;
    this.zzxR = paramzzfc;
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!((Boolean)zzby.zzvp.get()).booleanValue()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("host", zzaK(paramString3));
    zzp.zzbv().zza(paramContext, this.zzoM.zzhh().zzJu, "gmob-apps", localBundle, true);
  }
  
  private String zzaK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    if (paramString.getHost() != null) {
      return paramString.getHost();
    }
    return "";
  }
  
  private static boolean zzg(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void zzht()
  {
    synchronized (this.zzpd)
    {
      this.zzKa = true;
      this.zzKh += 1;
      zzhw();
      return;
    }
  }
  
  private void zzhu()
  {
    this.zzKh -= 1;
    zzhw();
  }
  
  private void zzhv()
  {
    this.zzKg = true;
    zzhw();
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.v("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      zzh(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (this.zzpd)
    {
      if ((this.zzKe) && ("about:blank".equals(paramString)))
      {
        zzb.v("Blank page loaded, 1...");
        this.zzoM.zzhj();
        return;
      }
      this.zzKf = true;
      zzhw();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzJU.length)) {}
    for (String str = zzJU[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zza(this.zzoM.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzJV.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzJV[i];; str = String.valueOf(i))
    {
      zza(this.zzoM.getContext(), "ssl_err", str, zzp.zzbx().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public final void reset()
  {
    synchronized (this.zzpd)
    {
      this.zzJW.clear();
      this.zzsy = null;
      this.zzJX = null;
      this.zzDn = null;
      this.zzxn = null;
      this.zzJZ = false;
      this.zzqW = false;
      this.zzKa = false;
      this.zzxT = null;
      this.zzKb = null;
      this.zzJY = null;
      if (this.zzxR != null)
      {
        this.zzxR.zzn(true);
        this.zzxR = null;
      }
      this.zzKd = false;
      return;
    }
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.v("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      zzh(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.zzJZ) && (paramWebView == this.zzoM.getWebView()) && (zzg(localUri)))
      {
        if (!this.zzKd)
        {
          this.zzKd = true;
          if ((this.zzsy != null) && (((Boolean)zzby.zzvd.get()).booleanValue())) {
            this.zzsy.onAdClicked();
          }
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.zzoM.getWebView().willNotDraw())
      {
        try
        {
          zzan localzzan = this.zzoM.zzhg();
          paramWebView = localUri;
          if (localzzan != null)
          {
            paramWebView = localUri;
            if (localzzan.zzb(localUri)) {
              paramWebView = localzzan.zza(localUri, this.zzoM.getContext());
            }
          }
        }
        catch (zzao paramWebView)
        {
          for (;;)
          {
            zzb.zzaH("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
          this.zzxQ.zzp(paramString);
        }
        if ((this.zzxQ == null) || (this.zzxQ.zzbe())) {
          zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
        }
      }
      else
      {
        zzb.zzaH("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public void zzF(boolean paramBoolean)
  {
    this.zzJZ = paramBoolean;
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.zzKc.zze(paramInt1, paramInt2);
    if (this.zzxR != null) {
      this.zzxR.zza(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    zzg localzzg = null;
    boolean bool = this.zzoM.zzhi();
    zza localzza;
    if ((bool) && (!this.zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, localzza, localzzg, this.zzKb, this.zzoM.zzhh()));
      return;
      localzza = this.zzsy;
      break;
      label75:
      localzzg = this.zzJX;
    }
  }
  
  public void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (this.zzxR != null) {}
    for (boolean bool1 = this.zzxR.zzef();; bool1 = false)
    {
      com.google.android.gms.ads.internal.overlay.zze localzze = zzp.zzbt();
      Context localContext = this.zzoM.getContext();
      if (!bool1) {
        bool2 = true;
      }
      localzze.zza(localContext, paramAdOverlayInfoParcel, bool2);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    this.zzDn = paramzza;
  }
  
  public void zza(zzb paramzzb)
  {
    this.zzJY = paramzzb;
  }
  
  public final void zza(String paramString, zzdk paramzzdk)
  {
    synchronized (this.zzpd)
    {
      List localList = (List)this.zzJW.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.zzJW.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramzzdk);
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((this.zzoM.zzhi()) && (!this.zzoM.zzaN().zztf)) {}
    for (zza localzza = null;; localzza = this.zzsy)
    {
      zza(new AdOverlayInfoParcel(localzza, this.zzJX, this.zzKb, this.zzoM, paramBoolean, paramInt, this.zzoM.zzhh()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = this.zzoM.zzhi();
    zza localzza;
    if ((bool) && (!this.zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, this.zzxn, this.zzKb, this.zzoM, paramBoolean, paramInt, paramString, this.zzoM.zzhh(), this.zzxT));
      return;
      localzza = this.zzsy;
      break;
      label95:
      localObject = new zzc(this.zzoM, this.zzJX);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.zzoM.zzhi();
    zza localzza;
    if ((bool) && (!this.zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzc(this.zzoM, this.zzJX))
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, this.zzxn, this.zzKb, this.zzoM, paramBoolean, paramInt, paramString1, paramString2, this.zzoM.zzhh(), this.zzxT));
      return;
      localzza = this.zzsy;
      break;
    }
  }
  
  public void zzb(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, boolean paramBoolean, zzdm paramzzdm, zzdo paramzzdo, com.google.android.gms.ads.internal.zze paramzze, zzfi paramzzfi)
  {
    com.google.android.gms.ads.internal.zze localzze = paramzze;
    if (paramzze == null) {
      localzze = new com.google.android.gms.ads.internal.zze(false);
    }
    this.zzxR = new zzfc(this.zzoM, paramzzfi);
    zza("/appEvent", new zzdf(paramzzdg));
    zza("/backButton", zzdj.zzxx);
    zza("/canOpenURLs", zzdj.zzxp);
    zza("/canOpenIntents", zzdj.zzxq);
    zza("/click", zzdj.zzxr);
    zza("/close", zzdj.zzxs);
    zza("/customClose", zzdj.zzxt);
    zza("/instrument", zzdj.zzxA);
    zza("/delayPageLoaded", new zzd(null));
    zza("/httpTrack", zzdj.zzxu);
    zza("/log", zzdj.zzxv);
    zza("/mraid", new zzdq(localzze, this.zzxR));
    zza("/mraidLoaded", this.zzKc);
    zza("/open", new zzdr(paramzzdm, localzze, this.zzxR));
    zza("/precache", zzdj.zzxz);
    zza("/touch", zzdj.zzxw);
    zza("/video", zzdj.zzxy);
    if (paramzzdo != null) {
      zza("/setInterstitialProperties", new zzdn(paramzzdo));
    }
    this.zzsy = paramzza;
    this.zzJX = paramzzg;
    this.zzxn = paramzzdg;
    this.zzxT = paramzzdm;
    this.zzKb = paramzzn;
    this.zzxQ = localzze;
    this.zzAl = paramzzfi;
    this.zzxO = paramzzdo;
    zzF(paramBoolean);
    this.zzKd = false;
  }
  
  public final void zzb(String paramString, zzdk paramzzdk)
  {
    synchronized (this.zzpd)
    {
      paramString = (List)this.zzJW.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(paramzzdk);
      return;
    }
  }
  
  public boolean zzbY()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzqW;
      return bool;
    }
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    if (this.zzxR != null) {
      this.zzxR.zzd(paramInt1, paramInt2);
    }
  }
  
  public void zze(zziz paramzziz)
  {
    this.zzoM = paramzziz;
  }
  
  public final void zzeG()
  {
    synchronized (this.zzpd)
    {
      this.zzJZ = false;
      this.zzqW = true;
      zzid.runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzja.this.zzoM.zzho();
          zzd localzzd = zzja.this.zzoM.zzhc();
          if (localzzd != null) {
            localzzd.zzeG();
          }
          if (zzja.zzd(zzja.this) != null)
          {
            zzja.zzd(zzja.this).zzbf();
            zzja.zza(zzja.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzh(Uri paramUri)
  {
    Object localObject2 = paramUri.getPath();
    Object localObject1 = (List)this.zzJW.get(localObject2);
    if (localObject1 != null)
    {
      paramUri = zzp.zzbv().zze(paramUri);
      if (zzb.zzN(2))
      {
        zzb.v("Received GMSG: " + (String)localObject2);
        localObject2 = paramUri.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          zzb.v("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((zzdk)((Iterator)localObject1).next()).zza(this.zzoM, paramUri);
      }
    }
    zzb.v("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public com.google.android.gms.ads.internal.zze zzhq()
  {
    return this.zzxQ;
  }
  
  public boolean zzhr()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzKa;
      return bool;
    }
  }
  
  public void zzhs()
  {
    synchronized (this.zzpd)
    {
      zzb.v("Loading blank page in WebView, 2...");
      this.zzKe = true;
      this.zzoM.zzaI("about:blank");
      return;
    }
  }
  
  public final void zzhw()
  {
    zza localzza;
    zziz localzziz;
    if ((this.zzDn != null) && (((this.zzKf) && (this.zzKh <= 0)) || (this.zzKg)))
    {
      localzza = this.zzDn;
      localzziz = this.zzoM;
      if (this.zzKg) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localzza.zza(localzziz, bool);
      this.zzDn = null;
      this.zzoM.zzhp();
      return;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zziz paramzziz, boolean paramBoolean);
  }
  
  public static abstract interface zzb
  {
    public abstract void zzbf();
  }
  
  private static class zzc
    implements zzg
  {
    private zzg zzJX;
    private zziz zzKj;
    
    public zzc(zziz paramzziz, zzg paramzzg)
    {
      this.zzKj = paramzziz;
      this.zzJX = paramzzg;
    }
    
    public void zzaV()
    {
      this.zzJX.zzaV();
      this.zzKj.zzgY();
    }
    
    public void zzaW()
    {
      this.zzJX.zzaW();
      this.zzKj.zzeJ();
    }
  }
  
  private class zzd
    implements zzdk
  {
    private zzd() {}
    
    public void zza(zziz paramzziz, Map<String, String> paramMap)
    {
      if (paramMap.keySet().contains("start")) {
        zzja.zza(zzja.this);
      }
      do
      {
        return;
        if (paramMap.keySet().contains("stop"))
        {
          zzja.zzb(zzja.this);
          return;
        }
      } while (!paramMap.keySet().contains("cancel"));
      zzja.zzc(zzja.this);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzja.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */