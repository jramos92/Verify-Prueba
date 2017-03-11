package cn.sharesdk.instagram;

import android.os.Bundle;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

class d
  extends Thread
{
  d(c paramc, String paramString) {}
  
  public void run()
  {
    Object localObject1 = e.a(c.a(this.b).a().getPlatform());
    try
    {
      localObject1 = ((e)localObject1).a(this.a);
      if (localObject1 == null)
      {
        c.c(this.b).onError(new Throwable("Authorize token is empty"));
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2;
      for (;;)
      {
        c.b(this.b).onError(localThrowable1);
        localObject2 = null;
      }
      try
      {
        HashMap localHashMap = new Hashon().fromJson((String)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("access_token", String.valueOf(localHashMap.get("access_token")));
        localHashMap = (HashMap)localHashMap.get("user");
        ((Bundle)localObject2).putString("username", String.valueOf(localHashMap.get("username")));
        ((Bundle)localObject2).putString("bio", String.valueOf(localHashMap.get("bio")));
        ((Bundle)localObject2).putString("website", String.valueOf(localHashMap.get("website")));
        ((Bundle)localObject2).putString("profile_picture", String.valueOf(localHashMap.get("profile_picture")));
        ((Bundle)localObject2).putString("full_name", String.valueOf(localHashMap.get("full_name")));
        ((Bundle)localObject2).putString("id", String.valueOf(localHashMap.get("id")));
        c.d(this.b).onComplete((Bundle)localObject2);
        return;
      }
      catch (Throwable localThrowable2)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable2);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */