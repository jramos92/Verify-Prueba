package cn.sharesdk.tencent.qzone;

import android.webkit.WebView;
import com.mob.tools.SSDKWebViewClient;

class l
  extends SSDKWebViewClient
{
  l(i parami) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (paramString.startsWith(i.b(this.a)))) {
      i.a(this.a, paramString);
    }
    for (;;)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
      if ((paramString != null) && (paramString.startsWith("mqzone://"))) {
        i.b(this.a, paramString);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */