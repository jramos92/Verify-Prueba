package cn.sharesdk.flickr;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;
import java.net.URLDecoder;

public class c
  extends cn.sharesdk.framework.authorize.b
{
  private int d;
  private boolean e;
  
  public c(g paramg)
  {
    super(paramg);
  }
  
  private void b(String paramString)
  {
    if (this.e) {}
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          this.e = true;
          paramString = b.a(this.a.a().getPlatform()).a(paramString);
          if ((paramString != null) && (paramString.length() > 0)) {
            break;
          }
        } while (this.c == null);
        this.c.onError(new Throwable());
        return;
        paramString = URLDecoder.decode(paramString).split("&");
        localBundle = new Bundle();
        int j = paramString.length;
        int i = 0;
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          if (arrayOfString == null) {}
          for (;;)
          {
            i += 1;
            break;
            arrayOfString = arrayOfString.split("=");
            if (arrayOfString.length >= 2) {
              localBundle.putString(arrayOfString[0], arrayOfString[1]);
            }
          }
        }
        if ((localBundle != null) && (localBundle.size() > 0)) {
          break;
        }
      } while (this.c == null);
      this.c.onError(new Throwable());
      return;
    } while (this.c == null);
    this.c.onComplete(localBundle);
  }
  
  protected void a(String paramString)
  {
    new d(this, String.valueOf(R.urlToBundle(paramString).get("oauth_verifier"))).start();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.d += 1;
    if (this.d < 5)
    {
      paramString1 = paramString1 + " (" + paramInt + "): " + paramString2;
      cn.sharesdk.framework.utils.d.a().w(new Throwable(paramString1));
      cn.sharesdk.framework.utils.d.a().w("Retrying, count = " + this.d, new Object[0]);
      paramWebView.loadUrl(paramString2);
      return;
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\flickr\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */