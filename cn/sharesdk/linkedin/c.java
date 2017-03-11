package cn.sharesdk.linkedin;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class c
  extends cn.sharesdk.framework.authorize.b
{
  private boolean d;
  
  public c(g paramg)
  {
    super(paramg);
  }
  
  private void a(String paramString, b paramb)
  {
    try
    {
      paramString = paramb.b(paramString);
      if ((paramString == null) || (paramString.length() <= 0))
      {
        if (this.c != null) {
          this.c.onError(new Throwable());
        }
      }
      else
      {
        paramString = new Hashon().fromJson(paramString);
        if (paramString == null)
        {
          if (this.c == null) {
            return;
          }
          this.c.onError(new Throwable());
        }
      }
    }
    catch (Throwable paramString)
    {
      if (this.c != null)
      {
        this.c.onError(paramString);
        return;
        if (!paramString.containsKey("access_token"))
        {
          if (this.c != null) {
            this.c.onError(new Throwable());
          }
        }
        else
        {
          paramb = new Bundle();
          paramb.putString("access_token", String.valueOf(paramString.get("access_token")));
          paramb.putString("expires_in", String.valueOf(paramString.get("expires_in")));
          if (this.c != null) {
            this.c.onComplete(paramb);
          }
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    new d(this, paramString).start();
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\linkedin\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */