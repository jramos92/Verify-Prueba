package cn.sharesdk.framework.statistics.b;

import android.content.Context;
import android.text.TextUtils;

public class e
  extends c
{
  private static int b;
  private static long c;
  public long a;
  
  protected String a()
  {
    return "[EXT]";
  }
  
  protected void a(long paramLong)
  {
    c = paramLong;
  }
  
  public boolean a(Context paramContext)
  {
    cn.sharesdk.framework.statistics.a.c localc = cn.sharesdk.framework.statistics.a.c.a(paramContext);
    b = localc.c("insertExitEventCount");
    c = localc.b("lastInsertExitEventTime");
    return super.a(paramContext);
  }
  
  protected int b()
  {
    return 5000;
  }
  
  public void b(Context paramContext)
  {
    super.b(paramContext);
    paramContext = cn.sharesdk.framework.statistics.a.c.a(paramContext);
    paramContext.a("lastInsertExitEventTime", Long.valueOf(c));
    paramContext.a("insertExitEventCount", b);
  }
  
  protected int c()
  {
    return 5;
  }
  
  protected long d()
  {
    return b;
  }
  
  protected long e()
  {
    return c;
  }
  
  protected void f()
  {
    b += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.m)) {
      localStringBuilder.append(this.m);
    }
    localStringBuilder.append('|').append(Math.round((float)this.a / 1000.0F));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */