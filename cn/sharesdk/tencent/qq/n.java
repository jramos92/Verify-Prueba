package cn.sharesdk.tencent.qq;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.widget.Toast;
import com.mob.tools.SSDKWebViewClient;
import com.mob.tools.utils.R;

class n
  extends SSDKWebViewClient
{
  n(k paramk) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.startsWith("wtloginmqq://")))
    {
      int i = R.getStringRes(k.e(this.a), "ssdk_use_login_button");
      if (i > 0) {
        Toast.makeText(k.f(this.a), i, 0).show();
      }
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if ((paramString != null) && (paramString.startsWith(k.b(this.a))))
    {
      k.a(this.a, paramString);
      bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    int i;
    do
    {
      return bool;
      if ((paramString != null) && (paramString.startsWith("http://www.myapp.com/down/")))
      {
        k.a(this.a, true);
        break;
      }
      if ((paramString == null) || (!paramString.startsWith("wtloginmqq://"))) {
        break;
      }
      i = R.getStringRes(k.c(this.a), "ssdk_use_login_button");
    } while (i <= 0);
    Toast.makeText(k.d(this.a), i, 0).show();
    return true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */