package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.utils.R;

public class b
  extends cn.sharesdk.framework.authorize.b
{
  private boolean d;
  
  public b(g paramg)
  {
    super(paramg);
  }
  
  public void a(String paramString)
  {
    if (this.d) {}
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          return;
          this.d = true;
          paramString = e.a(this.a.a().getPlatform()).a(paramString);
          if ((paramString != null) && (paramString.length() > 0)) {
            break;
          }
        } while (this.c == null);
        this.c.onError(new Throwable());
        return;
        paramString = paramString.split("&");
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
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.b != null) && (paramString.startsWith(this.b)))
    {
      paramWebView.stopLoading();
      this.a.finish();
      new d(this, String.valueOf(R.urlToBundle(paramString).get("oauth_verifier"))).start();
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b != null) && (paramString.startsWith(this.b)))
    {
      paramWebView.stopLoading();
      this.a.finish();
      new c(this, String.valueOf(R.urlToBundle(paramString).get("oauth_verifier"))).start();
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\twitter\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */