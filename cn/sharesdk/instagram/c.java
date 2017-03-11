package cn.sharesdk.instagram;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.utils.R;

public class c
  extends b
{
  private boolean d;
  
  public c(g paramg)
  {
    super(paramg);
  }
  
  protected void a(String paramString)
  {
    if (this.d) {}
    do
    {
      return;
      this.d = true;
      paramString = R.urlToBundle(paramString);
      if (paramString.containsKey("code")) {
        break;
      }
    } while (this.c == null);
    this.c.onError(new Throwable("code is null"));
    return;
    new d(this, paramString.getString("code")).start();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.setVisibility(4);
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.setVisibility(4);
      paramWebView.stopLoading();
      this.a.finish();
      a(paramString);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */