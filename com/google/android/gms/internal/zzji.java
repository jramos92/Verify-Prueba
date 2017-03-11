package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzgr
public class zzji
  extends WebViewClient
{
  private final zzgd zzDt;
  private final String zzKH = zzaO(paramString);
  private boolean zzKI = false;
  private final zziz zzoM;
  
  public zzji(zzgd paramzzgd, zziz paramzziz, String paramString)
  {
    this.zzoM = paramzziz;
    this.zzDt = paramzzgd;
  }
  
  private String zzaO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, paramString.length() - 1);
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        zzb.e(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!zzaN(paramString)) {
      this.zzoM.zzhe().onLoadResource(this.zzoM.getWebView(), paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.zzKI)
    {
      this.zzDt.zzfv();
      this.zzKI = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.zzaF("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (zzaN(paramString))
    {
      zzb.zzaF("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.zzoM.zzhe().shouldOverrideUrlLoading(this.zzoM.getWebView(), paramString);
  }
  
  protected boolean zzaN(String paramString)
  {
    paramString = zzaO(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject1 = new URI(paramString);
        if ("passback".equals(((URI)localObject1).getScheme()))
        {
          zzb.zzaF("Passback received");
          this.zzDt.zzfw();
          return true;
        }
        if (!TextUtils.isEmpty(this.zzKH))
        {
          Object localObject2 = new URI(this.zzKH);
          paramString = ((URI)localObject2).getHost();
          String str = ((URI)localObject1).getHost();
          localObject2 = ((URI)localObject2).getPath();
          localObject1 = ((URI)localObject1).getPath();
          if ((zzw.equal(paramString, str)) && (zzw.equal(localObject2, localObject1)))
          {
            zzb.zzaF("Passback received");
            this.zzDt.zzfw();
            return true;
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        zzb.e(paramString.getMessage());
      }
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */