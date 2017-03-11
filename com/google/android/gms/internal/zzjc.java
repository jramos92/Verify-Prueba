package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzgr
class zzjc
  extends FrameLayout
  implements zziz
{
  private final zziz zzKk;
  private final zziy zzKl;
  
  public zzjc(zziz paramzziz)
  {
    super(paramzziz.zzha());
    this.zzKk = paramzziz;
    this.zzKl = new zziy(paramzziz.zzha(), this, this);
    paramzziz = this.zzKk.zzhe();
    if (paramzziz != null) {
      paramzziz.zze(this);
    }
    addView(this.zzKk.getView());
  }
  
  public void clearCache(boolean paramBoolean)
  {
    this.zzKk.clearCache(paramBoolean);
  }
  
  public void destroy()
  {
    this.zzKk.destroy();
  }
  
  public String getRequestId()
  {
    return this.zzKk.getRequestId();
  }
  
  public int getRequestedOrientation()
  {
    return this.zzKk.getRequestedOrientation();
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this.zzKk.getWebView();
  }
  
  public boolean isDestroyed()
  {
    return this.zzKk.isDestroyed();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.zzKk.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.zzKk.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    this.zzKk.loadUrl(paramString);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.zzKk.setBackgroundColor(paramInt);
  }
  
  public void setContext(Context paramContext)
  {
    this.zzKk.setContext(paramContext);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zzKk.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zzKk.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.zzKk.setRequestedOrientation(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.zzKk.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    this.zzKk.setWebViewClient(paramWebViewClient);
  }
  
  public void stopLoading()
  {
    this.zzKk.stopLoading();
  }
  
  public void zzC(boolean paramBoolean)
  {
    this.zzKk.zzC(paramBoolean);
  }
  
  public void zzD(boolean paramBoolean)
  {
    this.zzKk.zzD(paramBoolean);
  }
  
  public void zzE(boolean paramBoolean)
  {
    this.zzKk.zzE(paramBoolean);
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzcg paramzzcg)
  {
    this.zzKk.zza(paramContext, paramAdSizeParcel, paramzzcg);
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    this.zzKk.zza(paramAdSizeParcel);
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    this.zzKk.zza(paramzzaz, paramBoolean);
  }
  
  public void zza(String paramString1, String paramString2)
  {
    this.zzKk.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    this.zzKk.zza(paramString, paramJSONObject);
  }
  
  public void zzaI(String paramString)
  {
    this.zzKk.zzaI(paramString);
  }
  
  public void zzaJ(String paramString)
  {
    this.zzKk.zzaJ(paramString);
  }
  
  public AdSizeParcel zzaN()
  {
    return this.zzKk.zzaN();
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    this.zzKk.zzb(paramzzd);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    this.zzKk.zzb(paramString, paramMap);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzKk.zzb(paramString, paramJSONObject);
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    this.zzKk.zzc(paramzzd);
  }
  
  public void zzeJ()
  {
    this.zzKk.zzeJ();
  }
  
  public void zzgY()
  {
    this.zzKk.zzgY();
  }
  
  public Activity zzgZ()
  {
    return this.zzKk.zzgZ();
  }
  
  public Context zzha()
  {
    return this.zzKk.zzha();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhb()
  {
    return this.zzKk.zzhb();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhc()
  {
    return this.zzKk.zzhc();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhd()
  {
    return this.zzKk.zzhd();
  }
  
  public zzja zzhe()
  {
    return this.zzKk.zzhe();
  }
  
  public boolean zzhf()
  {
    return this.zzKk.zzhf();
  }
  
  public zzan zzhg()
  {
    return this.zzKk.zzhg();
  }
  
  public VersionInfoParcel zzhh()
  {
    return this.zzKk.zzhh();
  }
  
  public boolean zzhi()
  {
    return this.zzKk.zzhi();
  }
  
  public void zzhj()
  {
    this.zzKl.onDestroy();
    this.zzKk.zzhj();
  }
  
  public boolean zzhk()
  {
    return this.zzKk.zzhk();
  }
  
  public zziy zzhl()
  {
    return this.zzKl;
  }
  
  public zzce zzhm()
  {
    return this.zzKk.zzhm();
  }
  
  public zzcf zzhn()
  {
    return this.zzKk.zzhn();
  }
  
  public void zzho()
  {
    this.zzKk.zzho();
  }
  
  public void zzhp()
  {
    this.zzKk.zzhp();
  }
  
  public void zzv(int paramInt)
  {
    this.zzKk.zzv(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */