package cn.sharesdk.framework;

import cn.sharesdk.framework.statistics.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import java.util.HashMap;

class m
  extends Thread
{
  m(k paramk, a parama) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap1 = this.a.g(k.a(this.b));
      HashMap localHashMap2 = new HashMap();
      if (k.a(this.b, this.a, localHashMap1, localHashMap2)) {
        this.b.b(localHashMap2);
      }
      this.a.a(k.a(this.b), localHashMap1);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */