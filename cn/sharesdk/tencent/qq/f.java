package cn.sharesdk.tencent.qq;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;

class f
  implements SSOListener
{
  f(e parame, AuthorizeListener paramAuthorizeListener) {}
  
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
    e.a(this.b, this.a);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */