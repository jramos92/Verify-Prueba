package cn.sharesdk.wechat.utils;

import android.text.TextUtils;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import java.util.ArrayList;

class h
  extends Thread
{
  h(g paramg, String paramString, AuthorizeListener paramAuthorizeListener) {}
  
  public void run()
  {
    try
    {
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new KVPair("appid", g.d(this.c)));
      ((ArrayList)localObject).add(new KVPair("secret", g.e(this.c)));
      ((ArrayList)localObject).add(new KVPair("code", this.a));
      ((ArrayList)localObject).add(new KVPair("grant_type", "authorization_code"));
      try
      {
        localObject = g.c(this.c).a("https://api.weixin.qq.com/sns/oauth2/access_token", (ArrayList)localObject, "/sns/oauth2/access_token", g.b(this.c));
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          this.b.onError(new Throwable("Authorize token is empty"));
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        this.b.onError(localThrowable1);
        return;
      }
      if (!localThrowable2.contains("errcode")) {
        break label189;
      }
    }
    catch (Throwable localThrowable2)
    {
      d.a().w(localThrowable2);
      return;
    }
    if (this.b != null)
    {
      this.b.onError(new Throwable(localThrowable2));
      return;
      label189:
      g.a(this.c, localThrowable2);
      this.b.onComplete(null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */