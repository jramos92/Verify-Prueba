package cn.sharesdk.linkedin;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;

class d
  extends Thread
{
  d(c paramc, String paramString) {}
  
  public void run()
  {
    Object localObject2;
    try
    {
      Object localObject1 = R.urlToBundle(this.a);
      if (localObject1 == null)
      {
        if (c.a(this.b) == null) {
          return;
        }
        c.b(this.b).onError(new Throwable());
        return;
      }
      if (((Bundle)localObject1).containsKey("error"))
      {
        if (c.c(this.b) == null) {
          return;
        }
        localObject2 = ((Bundle)localObject1).getString("error");
        localObject1 = ((Bundle)localObject1).getString("error_description");
        localObject1 = (String)localObject2 + ": " + (String)localObject1;
        c.d(this.b).onError(new Throwable((String)localObject1));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      return;
    }
    if (!localThrowable.containsKey("state"))
    {
      if (c.e(this.b) != null) {
        c.f(this.b).onError(new Throwable("The state does not match, the request may be a result of CSRF and has be rejected"));
      }
    }
    else
    {
      localObject2 = b.a(c.g(this.b).a().getPlatform());
      if (!((b)localObject2).a().equals(localThrowable.getString("state")))
      {
        if (c.h(this.b) != null) {
          c.i(this.b).onError(new Throwable("The state does not match, the request may be a result of CSRF and has be rejected"));
        }
      }
      else if (!localThrowable.containsKey("code"))
      {
        if (c.j(this.b) != null) {
          c.k(this.b).onError(new Throwable());
        }
      }
      else
      {
        String str = localThrowable.getString("code");
        c.a(this.b, str, (b)localObject2);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\linkedin\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */