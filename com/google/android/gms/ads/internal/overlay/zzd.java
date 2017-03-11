package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzfk.zza;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zza;
import com.google.android.gms.internal.zzjb;
import java.util.Collections;

@zzgr
public class zzd
  extends zzfk.zza
  implements zzo
{
  static final int zzBh = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  RelativeLayout zzAn;
  AdOverlayInfoParcel zzBi;
  zzc zzBj;
  zzm zzBk;
  boolean zzBl = false;
  FrameLayout zzBm;
  WebChromeClient.CustomViewCallback zzBn;
  boolean zzBo = false;
  boolean zzBp = false;
  boolean zzBq = false;
  int zzBr = 0;
  private boolean zzBs;
  private boolean zzBt = false;
  private boolean zzBu = true;
  zziz zzoM;
  
  public zzd(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void close()
  {
    this.zzBr = 2;
    this.mActivity.finish();
  }
  
  public void onBackPressed()
  {
    this.zzBr = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.zzBo = bool;
    try
    {
      this.zzBi = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
      if (this.zzBi != null) {
        break label71;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzb.zzaH(paramBundle.getMessage());
      this.zzBr = 3;
      this.mActivity.finish();
    }
    return;
    label71:
    if (this.zzBi.zzqj.zzJw > 7500000) {
      this.zzBr = 3;
    }
    if (this.mActivity.getIntent() != null) {
      this.zzBu = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    if (this.zzBi.zzBM != null)
    {
      this.zzBp = this.zzBi.zzBM.zzpt;
      label142:
      if ((((Boolean)zzby.zzvz.get()).booleanValue()) && (this.zzBp) && (this.zzBi.zzBM.zzpv != null)) {
        new zzd(null).zzgz();
      }
      if (paramBundle == null)
      {
        if ((this.zzBi.zzBC != null) && (this.zzBu)) {
          this.zzBi.zzBC.zzaW();
        }
        if ((this.zzBi.zzBJ != 1) && (this.zzBi.zzBB != null)) {
          this.zzBi.zzBB.onAdClicked();
        }
      }
      this.zzAn = new zzb(this.mActivity, this.zzBi.zzBL);
      switch (this.zzBi.zzBJ)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      this.zzBp = false;
      break label142;
      zzv(false);
      return;
      this.zzBj = new zzc(this.zzBi.zzBD);
      zzv(false);
      return;
      zzv(true);
      return;
      if (this.zzBo)
      {
        this.zzBr = 3;
        this.mActivity.finish();
        return;
      }
      if (zzp.zzbs().zza(this.mActivity, this.zzBi.zzBA, this.zzBi.zzBI)) {
        break;
      }
      this.zzBr = 3;
      this.mActivity.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.zzoM != null) {
      this.zzAn.removeView(this.zzoM.getView());
    }
    zzeH();
  }
  
  public void onPause()
  {
    zzeD();
    if ((this.zzoM != null) && ((!this.mActivity.isFinishing()) || (this.zzBj == null))) {
      zzp.zzbx().zza(this.zzoM.getWebView());
    }
    zzeH();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.zzBi != null) && (this.zzBi.zzBJ == 4))
    {
      if (!this.zzBo) {
        break label73;
      }
      this.zzBr = 3;
      this.mActivity.finish();
    }
    while ((this.zzoM != null) && (!this.zzoM.isDestroyed()))
    {
      zzp.zzbx().zzb(this.zzoM.getWebView());
      return;
      label73:
      this.zzBo = true;
    }
    zzb.zzaH("The webview does not exit. Ignoring action.");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzBo);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    zzeH();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.mActivity.setRequestedOrientation(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.zzBm = new FrameLayout(this.mActivity);
    this.zzBm.setBackgroundColor(-16777216);
    this.zzBm.addView(paramView, -1, -1);
    this.mActivity.setContentView(this.zzBm);
    zzaE();
    this.zzBn = paramCustomViewCallback;
    this.zzBl = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.zzBk != null) {
      this.zzBk.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public void zzaE()
  {
    this.zzBs = true;
  }
  
  public void zzeD()
  {
    if ((this.zzBi != null) && (this.zzBl)) {
      setRequestedOrientation(this.zzBi.orientation);
    }
    if (this.zzBm != null)
    {
      this.mActivity.setContentView(this.zzAn);
      zzaE();
      this.zzBm.removeAllViews();
      this.zzBm = null;
    }
    if (this.zzBn != null)
    {
      this.zzBn.onCustomViewHidden();
      this.zzBn = null;
    }
    this.zzBl = false;
  }
  
  public void zzeE()
  {
    this.zzBr = 1;
    this.mActivity.finish();
  }
  
  public boolean zzeF()
  {
    this.zzBr = 0;
    boolean bool1;
    if (this.zzoM == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.zzoM.zzhk();
      bool1 = bool2;
    } while (bool2);
    this.zzoM.zzb("onbackblocked", Collections.emptyMap());
    return bool2;
  }
  
  public void zzeG()
  {
    this.zzAn.removeView(this.zzBk);
    zzu(true);
  }
  
  protected void zzeH()
  {
    if ((!this.mActivity.isFinishing()) || (this.zzBt)) {}
    do
    {
      return;
      this.zzBt = true;
      if (this.zzoM != null)
      {
        zzv(this.zzBr);
        this.zzAn.removeView(this.zzoM.getView());
        if (this.zzBj != null)
        {
          this.zzoM.setContext(this.zzBj.context);
          this.zzoM.zzC(false);
          this.zzBj.zzBx.addView(this.zzoM.getView(), this.zzBj.index, this.zzBj.zzBw);
          this.zzBj = null;
        }
        this.zzoM = null;
      }
    } while ((this.zzBi == null) || (this.zzBi.zzBC == null));
    this.zzBi.zzBC.zzaV();
  }
  
  public void zzeI()
  {
    if (this.zzBq)
    {
      this.zzBq = false;
      zzeJ();
    }
  }
  
  protected void zzeJ()
  {
    this.zzoM.zzeJ();
  }
  
  public void zzu(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.zzBk = new zzm(this.mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      this.zzBk.zza(paramBoolean, this.zzBi.zzBG);
      this.zzAn.addView(this.zzBk, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  protected void zzv(int paramInt)
  {
    this.zzoM.zzv(paramInt);
  }
  
  protected void zzv(boolean paramBoolean)
    throws zzd.zza
  {
    if (!this.zzBs) {
      this.mActivity.requestWindowFeature(1);
    }
    Object localObject = this.mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!this.zzBp) || ((this.zzBi.zzBM != null) && (this.zzBi.zzBM.zzpu))) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    boolean bool2 = this.zzBi.zzBD.zzhe().zzbY();
    this.zzBq = false;
    boolean bool1;
    if (bool2)
    {
      if (this.zzBi.orientation != zzp.zzbx().zzgG()) {
        break label527;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 1)
      {
        bool1 = true;
        this.zzBq = bool1;
      }
    }
    else
    {
      label147:
      zzb.zzaF("Delay onShow to next orientation change: " + this.zzBq);
      setRequestedOrientation(this.zzBi.orientation);
      if (zzp.zzbx().zza((Window)localObject)) {
        zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
      }
      if (this.zzBp) {
        break label575;
      }
      this.zzAn.setBackgroundColor(-16777216);
      label218:
      this.mActivity.setContentView(this.zzAn);
      zzaE();
      if (!paramBoolean) {
        break label642;
      }
      this.zzoM = zzp.zzbw().zza(this.mActivity, this.zzBi.zzBD.zzaN(), true, bool2, null, this.zzBi.zzqj);
      this.zzoM.zzhe().zzb(null, null, this.zzBi.zzBE, this.zzBi.zzBI, true, this.zzBi.zzBK, null, this.zzBi.zzBD.zzhe().zzhq(), null);
      this.zzoM.zzhe().zza(new zzja.zza()
      {
        public void zza(zziz paramAnonymouszziz, boolean paramAnonymousBoolean)
        {
          paramAnonymouszziz.zzeJ();
        }
      });
      if (this.zzBi.url == null) {
        break label588;
      }
      this.zzoM.loadUrl(this.zzBi.url);
      label372:
      if (this.zzBi.zzBD != null) {
        this.zzBi.zzBD.zzc(this);
      }
    }
    for (;;)
    {
      this.zzoM.zzb(this);
      localObject = this.zzoM.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.zzoM.getView());
      }
      if (this.zzBp) {
        this.zzoM.setBackgroundColor(zzBh);
      }
      this.zzAn.addView(this.zzoM.getView(), -1, -1);
      if ((!paramBoolean) && (!this.zzBq)) {
        zzeJ();
      }
      zzu(bool2);
      if (this.zzoM.zzhf()) {
        zza(bool2, true);
      }
      return;
      bool1 = false;
      break;
      label527:
      if (this.zzBi.orientation != zzp.zzbx().zzgH()) {
        break label147;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zzBq = bool1;
        break;
      }
      label575:
      this.zzAn.setBackgroundColor(zzBh);
      break label218;
      label588:
      if (this.zzBi.zzBH != null)
      {
        this.zzoM.loadDataWithBaseURL(this.zzBi.zzBF, this.zzBi.zzBH, "text/html", "UTF-8", null);
        break label372;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      label642:
      this.zzoM = this.zzBi.zzBD;
      this.zzoM.setContext(this.mActivity);
    }
  }
  
  @zzgr
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzgr
  static final class zzb
    extends RelativeLayout
  {
    zzif zzqQ;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      this.zzqQ = new zzif(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.zzqQ.zze(paramMotionEvent);
      return false;
    }
  }
  
  @zzgr
  public static class zzc
  {
    public final Context context;
    public final int index;
    public final ViewGroup.LayoutParams zzBw;
    public final ViewGroup zzBx;
    
    public zzc(zziz paramzziz)
      throws zzd.zza
    {
      this.zzBw = paramzziz.getLayoutParams();
      ViewParent localViewParent = paramzziz.getParent();
      this.context = paramzziz.zzha();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        this.zzBx = ((ViewGroup)localViewParent);
        this.index = this.zzBx.indexOfChild(paramzziz.getView());
        this.zzBx.removeView(paramzziz.getView());
        paramzziz.zzC(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzgr
  private class zzd
    extends zzhz
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzbn()
    {
      final Object localObject = zzp.zzbv().zzg(zzd.zza(zzd.this), zzd.this.zzBi.zzBM.zzpv);
      if (localObject != null)
      {
        localObject = zzp.zzbx().zza(zzd.zza(zzd.this), (Bitmap)localObject, zzd.this.zzBi.zzBM.zzpw, zzd.this.zzBi.zzBM.zzpx);
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localObject);
          }
        });
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */