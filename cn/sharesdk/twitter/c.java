package cn.sharesdk.twitter;

import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

class c
  extends Thread
{
  c(b paramb, String paramString) {}
  
  public void run()
  {
    try
    {
      this.b.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\twitter\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */