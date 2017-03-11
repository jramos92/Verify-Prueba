package cn.sharesdk.wechat.favorite;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(WechatFavorite paramWechatFavorite) {}
  
  public void onCancel()
  {
    if (WechatFavorite.c(this.a) != null) {
      WechatFavorite.d(this.a).onCancel(this.a, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    WechatFavorite.a(this.a, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (WechatFavorite.a(this.a) != null) {
      WechatFavorite.b(this.a).onError(this.a, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\favorite\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */