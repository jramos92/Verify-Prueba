package cn.sharesdk.wechat.moments;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(WechatMoments paramWechatMoments) {}
  
  public void onCancel()
  {
    if (WechatMoments.c(this.a) != null) {
      WechatMoments.d(this.a).onCancel(this.a, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    WechatMoments.a(this.a, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (WechatMoments.a(this.a) != null) {
      WechatMoments.b(this.a).onError(this.a, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\moments\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */