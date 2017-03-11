package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import java.util.HashMap;

class l
  extends Thread
{
  l(k paramk) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if ((!this.a.f()) && (this.a.a(localHashMap))) {
        this.a.b(localHashMap);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */