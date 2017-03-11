package cn.sharesdk.framework.authorize;

import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;

class j
  extends Thread
{
  j(g paramg) {}
  
  public void run()
  {
    try
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      if ("none".equals(DeviceHelper.getInstance(g.a(this.a)).getDetailNetworkTypeForStatic()))
      {
        localMessage.arg1 = 1;
        UIHandler.sendMessage(localMessage, this.a);
        return;
      }
      if (ShareSDK.isRemoveCookieOnAuthorize())
      {
        CookieSyncManager.createInstance(g.b(this.a));
        CookieManager.getInstance().removeAllCookie();
      }
      localMessage.obj = this.a.a.getAuthorizeUrl();
      UIHandler.sendMessage(localMessage, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */