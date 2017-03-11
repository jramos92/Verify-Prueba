package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
class zzjd
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zziz
{
  private int zzAD = -1;
  private int zzAE = -1;
  private int zzAG = -1;
  private int zzAH = -1;
  private String zzBY = "";
  private Boolean zzHZ;
  private Map<String, zzdv> zzKA;
  private final zza zzKm;
  private zzja zzKn;
  private com.google.android.gms.ads.internal.overlay.zzd zzKo;
  private boolean zzKp;
  private boolean zzKq;
  private boolean zzKr;
  private boolean zzKs;
  private int zzKt;
  private boolean zzKu = true;
  private zzce zzKv;
  private zzce zzKw;
  private zzce zzKx;
  private zzcf zzKy;
  private com.google.android.gms.ads.internal.overlay.zzd zzKz;
  private final com.google.android.gms.ads.internal.zzd zzow;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private zzim zzqR;
  private final WindowManager zzri;
  private final zzan zzwL;
  private AdSizeParcel zzzm;
  
  protected zzjd(zza paramzza, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzcg paramzzcg, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    super(paramzza);
    this.zzKm = paramzza;
    this.zzzm = paramAdSizeParcel;
    this.zzKr = paramBoolean1;
    this.zzKt = -1;
    this.zzwL = paramzzan;
    this.zzpb = paramVersionInfoParcel;
    this.zzow = paramzzd;
    this.zzri = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramAdSizeParcel = getSettings();
    paramAdSizeParcel.setJavaScriptEnabled(true);
    paramAdSizeParcel.setSavePassword(false);
    paramAdSizeParcel.setSupportMultipleWindows(true);
    paramAdSizeParcel.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAdSizeParcel.setMixedContentMode(0);
    }
    zzp.zzbv().zza(paramzza, paramVersionInfoParcel.zzJu, paramAdSizeParcel);
    zzp.zzbx().zza(getContext(), paramAdSizeParcel);
    setDownloadListener(this);
    zzhz();
    if (zzmx.zzqz()) {
      addJavascriptInterface(new zzje(this), "googleAdsJsInterface");
    }
    this.zzqR = new zzim(this.zzKm.zzgZ(), this, null);
    zzd(paramzzcg);
  }
  
  static zzjd zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzcg paramzzcg, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    return new zzjd(new zza(paramContext), paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzcg, paramzzd);
  }
  
  private void zzd(zzcg paramzzcg)
  {
    zzhD();
    this.zzKy = new zzcf(new zzcg(true, "make_wv", this.zzzm.zzte));
    this.zzKy.zzdm().zzc(paramzzcg);
    this.zzKw = zzcc.zzb(this.zzKy.zzdm());
    this.zzKy.zza("native:view_create", this.zzKw);
    this.zzKx = null;
    this.zzKv = null;
  }
  
  private void zzhA()
  {
    synchronized (this.zzpd)
    {
      if (!this.zzKs) {
        zzp.zzbx().zzm(this);
      }
      this.zzKs = true;
      return;
    }
  }
  
  private void zzhB()
  {
    synchronized (this.zzpd)
    {
      if (this.zzKs) {
        zzp.zzbx().zzl(this);
      }
      this.zzKs = false;
      return;
    }
  }
  
  private void zzhC()
  {
    synchronized (this.zzpd)
    {
      if (this.zzKA != null)
      {
        Iterator localIterator = this.zzKA.values().iterator();
        if (localIterator.hasNext()) {
          ((zzdv)localIterator.next()).release();
        }
      }
    }
  }
  
  private void zzhD()
  {
    if (this.zzKy == null) {}
    zzcg localzzcg;
    do
    {
      return;
      localzzcg = this.zzKy.zzdm();
    } while ((localzzcg == null) || (zzp.zzby().zzgo() == null));
    zzp.zzby().zzgo().zza(localzzcg);
  }
  
  private void zzhy()
  {
    synchronized (this.zzpd)
    {
      this.zzHZ = zzp.zzby().zzgs();
      Boolean localBoolean = this.zzHZ;
      if (localBoolean == null) {}
      try
      {
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzb(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void zzhz()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if ((this.zzKr) || (this.zzzm.zztf))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzb.zzaF("Disabling hardware acceleration on an overlay.");
            zzhA();
            return;
          }
          zzb.zzaF("Enabling hardware acceleration on an overlay.");
          zzhB();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzb.zzaF("Disabling hardware acceleration on an AdView.");
        zzhA();
      }
      else
      {
        zzb.zzaF("Enabling hardware acceleration on an AdView.");
        zzhB();
      }
    }
  }
  
  public void destroy()
  {
    synchronized (this.zzpd)
    {
      zzhD();
      this.zzqR.zzgP();
      if (this.zzKo != null)
      {
        this.zzKo.close();
        this.zzKo.onDestroy();
        this.zzKo = null;
      }
      this.zzKn.reset();
      if (this.zzKq) {
        return;
      }
      zzp.zzbI().zza(this);
      zzhC();
      this.zzKq = true;
      zzb.v("Initiating WebView self destruct sequence in 3...");
      this.zzKn.zzhs();
      return;
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.zzpd)
    {
      if (isDestroyed())
      {
        zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public String getRequestId()
  {
    synchronized (this.zzpd)
    {
      String str = this.zzBY;
      return str;
    }
  }
  
  public int getRequestedOrientation()
  {
    synchronized (this.zzpd)
    {
      int i = this.zzKt;
      return i;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this;
  }
  
  public boolean isDestroyed()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzKq;
      return bool;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.zzpd)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (this.zzpd)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable paramString)
          {
            zzb.zzaH("Could not call loadUrl. " + paramString);
            continue;
          }
        }
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void onAttachedToWindow()
  {
    synchronized (this.zzpd)
    {
      super.onAttachedToWindow();
      if (!isDestroyed()) {
        this.zzqR.onAttachedToWindow();
      }
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (this.zzpd)
    {
      if (!isDestroyed()) {
        this.zzqR.onDetachedFromWindow();
      }
      super.onDetachedFromWindow();
      return;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      zzp.zzbv().zzb(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      zzb.zzaF("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow())) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onGlobalLayout()
  {
    boolean bool = zzhx();
    com.google.android.gms.ads.internal.overlay.zzd localzzd = zzhc();
    if ((localzzd != null) && (bool)) {
      localzzd.zzeI();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    synchronized (this.zzpd)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (this.zzKr) || (this.zzzm.zzth) || (this.zzzm.zzti))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    if (this.zzzm.zztf)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.zzri.getDefaultDisplay().getMetrics(localDisplayMetrics);
      setMeasuredDimension(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      return;
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (n != Integer.MIN_VALUE) {
      if (n == 1073741824) {
        break label368;
      }
    }
    for (;;)
    {
      if ((this.zzzm.widthPixels > paramInt1) || (this.zzzm.heightPixels > paramInt2))
      {
        float f = this.zzKm.getResources().getDisplayMetrics().density;
        zzb.zzaH("Not enough space to show ad. Needs " + (int)(this.zzzm.widthPixels / f) + "x" + (int)(this.zzzm.heightPixels / f) + " dp, but only has " + (int)(i / f) + "x" + (int)(k / f) + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(this.zzzm.widthPixels, this.zzzm.heightPixels);
      }
      paramInt1 = Integer.MAX_VALUE;
      break label371;
      label368:
      paramInt1 = i;
      label371:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = j;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = k;
      }
    }
  }
  
  public void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzmx.zzqu())
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzmx.zzqu())
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.zzwL != null) {
      this.zzwL.zza(paramMotionEvent);
    }
    if (isDestroyed()) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    this.zzKm.setBaseContext(paramContext);
    this.zzqR.zzk(this.zzKm.zzgZ());
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    synchronized (this.zzpd)
    {
      this.zzKt = paramInt;
      if (this.zzKo != null) {
        this.zzKo.setRequestedOrientation(this.zzKt);
      }
      return;
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzja)) {
      this.zzKn = ((zzja)paramWebViewClient);
    }
  }
  
  public void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzb.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public void zzC(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzKr = paramBoolean;
      zzhz();
      return;
    }
  }
  
  public void zzD(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      if (this.zzKo != null)
      {
        this.zzKo.zza(this.zzKn.zzbY(), paramBoolean);
        return;
      }
      this.zzKp = paramBoolean;
    }
  }
  
  public void zzE(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzKu = paramBoolean;
      return;
    }
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzcg paramzzcg)
  {
    synchronized (this.zzpd)
    {
      this.zzqR.zzgP();
      setContext(paramContext);
      this.zzKo = null;
      this.zzzm = paramAdSizeParcel;
      this.zzKr = false;
      this.zzKp = false;
      this.zzBY = "";
      this.zzKt = -1;
      zzp.zzbx().zzb(this);
      loadUrl("about:blank");
      this.zzKn.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      this.zzKu = true;
      zzd(paramzzcg);
      return;
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    synchronized (this.zzpd)
    {
      this.zzzm = paramAdSizeParcel;
      requestLayout();
      return;
    }
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramzzaz = "1";; paramzzaz = "0")
    {
      localHashMap.put("isVisible", paramzzaz);
      zzb("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  protected void zza(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.zzpd)
    {
      if (!isDestroyed()) {
        evaluateJavascript(paramString, paramValueCallback);
      }
      do
      {
        return;
        zzb.zzaH("The webview is destroyed. Ignoring action.");
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue(null);
    }
  }
  
  public void zza(String paramString1, String paramString2)
  {
    zzaM(paramString1 + "(" + paramString2 + ");");
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    zza(paramString, localJSONObject.toString());
  }
  
  public void zzaI(String paramString)
  {
    synchronized (this.zzpd)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          zzb.zzaH("Could not call loadUrl. " + paramString);
        }
      }
    }
  }
  
  public void zzaJ(String paramString)
  {
    Object localObject = this.zzpd;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      this.zzBY = str;
      return;
    }
    finally {}
  }
  
  protected void zzaL(String paramString)
  {
    synchronized (this.zzpd)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void zzaM(String paramString)
  {
    if (zzmx.zzqB())
    {
      if (zzgs() == null) {
        zzhy();
      }
      if (zzgs().booleanValue())
      {
        zza(paramString, null);
        return;
      }
      zzaL("javascript:" + paramString);
      return;
    }
    zzaL("javascript:" + paramString);
  }
  
  public AdSizeParcel zzaN()
  {
    synchronized (this.zzpd)
    {
      AdSizeParcel localAdSizeParcel = this.zzzm;
      return localAdSizeParcel;
    }
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (this.zzpd)
    {
      this.zzKo = paramzzd;
      return;
    }
  }
  
  void zzb(Boolean paramBoolean)
  {
    this.zzHZ = paramBoolean;
    zzp.zzby().zzb(paramBoolean);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = zzp.zzbv().zzz(paramMap);
      zzb(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzaH("Could not convert parameters to JSON.");
    }
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = ((JSONObject)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AFMA_ReceiveMessage('");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("'");
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(");");
    zzb.v("Dispatching AFMA event: " + ((StringBuilder)localObject).toString());
    zzaM(((StringBuilder)localObject).toString());
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (this.zzpd)
    {
      this.zzKz = paramzzd;
      return;
    }
  }
  
  public void zzeJ()
  {
    if (this.zzKv != null)
    {
      zzcc.zza(this.zzKy.zzdm(), this.zzKx, new String[] { "aes" });
      this.zzKv = zzcc.zzb(this.zzKy.zzdm());
      this.zzKy.zza("native:view_show", this.zzKx);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzpb.zzJu);
    zzb("onshow", localHashMap);
  }
  
  public void zzgY()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzpb.zzJu);
    zzb("onhide", localHashMap);
  }
  
  public Activity zzgZ()
  {
    return this.zzKm.zzgZ();
  }
  
  Boolean zzgs()
  {
    synchronized (this.zzpd)
    {
      Boolean localBoolean = this.zzHZ;
      return localBoolean;
    }
  }
  
  public Context zzha()
  {
    return this.zzKm.zzha();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhb()
  {
    return this.zzow;
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhc()
  {
    synchronized (this.zzpd)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = this.zzKo;
      return localzzd;
    }
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhd()
  {
    synchronized (this.zzpd)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = this.zzKz;
      return localzzd;
    }
  }
  
  public zzja zzhe()
  {
    return this.zzKn;
  }
  
  public boolean zzhf()
  {
    return this.zzKp;
  }
  
  public zzan zzhg()
  {
    return this.zzwL;
  }
  
  public VersionInfoParcel zzhh()
  {
    return this.zzpb;
  }
  
  public boolean zzhi()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzKr;
      return bool;
    }
  }
  
  public void zzhj()
  {
    synchronized (this.zzpd)
    {
      zzb.v("Destroying WebView!");
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzjd.zza(zzjd.this);
        }
      });
      return;
    }
  }
  
  public boolean zzhk()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzKu;
      return bool;
    }
  }
  
  public zziy zzhl()
  {
    return null;
  }
  
  public zzce zzhm()
  {
    return this.zzKx;
  }
  
  public zzcf zzhn()
  {
    return this.zzKy;
  }
  
  public void zzho()
  {
    this.zzqR.zzgO();
  }
  
  public void zzhp()
  {
    if ((this.zzKx == null) && (!"about:blank".equals(getUrl())))
    {
      this.zzKx = zzcc.zzb(this.zzKy.zzdm());
      this.zzKy.zza("native:view_load", this.zzKx);
    }
  }
  
  public boolean zzhx()
  {
    if (!zzhe().zzbY()) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = zzp.zzbv().zza(this.zzri);
    int k = zzl.zzcF().zzb(localDisplayMetrics, localDisplayMetrics.widthPixels);
    int m = zzl.zzcF().zzb(localDisplayMetrics, localDisplayMetrics.heightPixels);
    Object localObject = zzgZ();
    int j;
    int i;
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      j = m;
      i = k;
      label77:
      if ((this.zzAD == k) && (this.zzAE == m) && (this.zzAG == i) && (this.zzAH == j)) {
        break label224;
      }
      if ((this.zzAD == k) && (this.zzAE == m)) {
        break label226;
      }
    }
    label224:
    label226:
    for (boolean bool = true;; bool = false)
    {
      this.zzAD = k;
      this.zzAE = m;
      this.zzAG = i;
      this.zzAH = j;
      new zzfh(this).zza(k, m, i, j, localDisplayMetrics.density, this.zzri.getDefaultDisplay().getRotation());
      return bool;
      localObject = zzp.zzbv().zzg((Activity)localObject);
      i = zzl.zzcF().zzb(localDisplayMetrics, localObject[0]);
      j = zzl.zzcF().zzb(localDisplayMetrics, localObject[1]);
      break label77;
      break;
    }
  }
  
  public void zzv(int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", this.zzpb.zzJu);
    zzb("onhide", localHashMap);
  }
  
  @zzgr
  public static class zza
    extends MutableContextWrapper
  {
    private Activity zzJn;
    private Context zzKC;
    private Context zzqZ;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Object getSystemService(String paramString)
    {
      return this.zzKC.getSystemService(paramString);
    }
    
    public void setBaseContext(Context paramContext)
    {
      this.zzqZ = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        this.zzJn = localActivity;
        this.zzKC = paramContext;
        super.setBaseContext(this.zzqZ);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if ((this.zzJn != null) && (!zzmx.isAtLeastL()))
      {
        this.zzJn.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.zzqZ.startActivity(paramIntent);
    }
    
    public Activity zzgZ()
    {
      return this.zzJn;
    }
    
    public Context zzha()
    {
      return this.zzKC;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */