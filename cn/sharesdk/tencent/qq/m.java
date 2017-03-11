package cn.sharesdk.tencent.qq;

import android.app.Instrumentation;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

class m
  extends Thread
{
  m(l paraml) {}
  
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
      this.a.a.finish();
      k.a(this.a.a).onCancel(null, 0);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */