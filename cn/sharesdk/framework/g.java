package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

class g
  extends Thread
{
  g(f paramf, int paramInt, Object paramObject) {}
  
  public void run()
  {
    try
    {
      f.a(this.c);
      if (f.b(this.c).checkAuthorize(this.a, this.b)) {
        this.c.b(this.a, this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */