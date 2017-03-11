package cn.sharesdk.framework.authorize;

import android.app.Instrumentation;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

class i
  extends Thread
{
  i(h paramh) {}
  
  public void run()
  {
    try
    {
      new Instrumentation().sendKeyDownUpSync(4);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
      AuthorizeListener localAuthorizeListener = this.a.a.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onCancel();
      }
      this.a.a.finish();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */