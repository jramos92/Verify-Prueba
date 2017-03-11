package u.aly;

import com.umeng.analytics.AnalyticsConfig;

public class n
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;
  private v b;
  
  public n()
  {
    if (Thread.getDefaultUncaughtExceptionHandler() == this) {
      return;
    }
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  private void a(Throwable paramThrowable)
  {
    if (AnalyticsConfig.CATCH_EXCEPTION)
    {
      this.b.a(paramThrowable);
      return;
    }
    this.b.a(null);
  }
  
  public void a(v paramv)
  {
    this.b = paramv;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if ((this.a != null) && (this.a != Thread.getDefaultUncaughtExceptionHandler())) {
      this.a.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */