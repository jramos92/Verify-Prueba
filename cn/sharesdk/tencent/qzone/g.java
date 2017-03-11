package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;

class g
  implements SSOListener
{
  g(f paramf, AuthorizeListener paramAuthorizeListener) {}
  
  public void onCancel()
  {
    this.a.onCancel();
  }
  
  public void onComplete(Bundle paramBundle)
  {
    this.a.onComplete(paramBundle);
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    f.a(this.b, this.a);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */