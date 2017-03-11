package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

class h
  extends Thread
{
  h(f paramf, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      f.a(this.b);
      f.b(this.b).doAuthorize(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */