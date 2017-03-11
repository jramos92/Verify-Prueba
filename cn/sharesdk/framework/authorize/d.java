package cn.sharesdk.framework.authorize;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class d
  extends WebChromeClient
{
  d(RegisterView paramRegisterView, int paramInt) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    paramWebView = (LinearLayout.LayoutParams)RegisterView.a(this.b).getLayoutParams();
    paramWebView.width = (this.a * paramInt / 100);
    RegisterView.a(this.b).setLayoutParams(paramWebView);
    if ((paramInt > 0) && (paramInt < 100))
    {
      RegisterView.a(this.b).setVisibility(0);
      return;
    }
    RegisterView.a(this.b).setVisibility(8);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */