package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.Platform;

public class e
  extends a
{
  protected SSOListener b;
  private f c;
  
  public void a(SSOListener paramSSOListener)
  {
    this.b = paramSSOListener;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.c.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate()
  {
    this.c = this.a.getSSOProcessor(this);
    if (this.c == null)
    {
      finish();
      AuthorizeListener localAuthorizeListener = this.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onError(new Throwable("Failed to start SSO for " + this.a.getPlatform().getName()));
      }
      return;
    }
    this.c.a(32973);
    this.c.a();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.c.a(paramIntent);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */