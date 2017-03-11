package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;

public class QQWebShareAdapter
{
  private Activity activity;
  private boolean noTitle;
  private RelativeLayout rlBody;
  private TitleLayout title;
  private WebView webview;
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public RelativeLayout getBodyView()
  {
    return this.rlBody;
  }
  
  public TitleLayout getTitleLayout()
  {
    return this.title;
  }
  
  public WebView getWebBody()
  {
    return this.webview;
  }
  
  boolean isNotitle()
  {
    return this.noTitle;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public boolean onFinish()
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onRestart() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  void setBodyView(RelativeLayout paramRelativeLayout)
  {
    this.rlBody = paramRelativeLayout;
  }
  
  void setNotitle(boolean paramBoolean)
  {
    this.noTitle = paramBoolean;
  }
  
  void setTitleView(TitleLayout paramTitleLayout)
  {
    this.title = paramTitleLayout;
  }
  
  void setWebView(WebView paramWebView)
  {
    this.webview = paramWebView;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\QQWebShareAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */