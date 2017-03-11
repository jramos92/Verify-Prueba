package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.sharesdk.framework.statistics.b.e;
import cn.sharesdk.framework.statistics.b.g;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import java.io.PrintStream;
import java.util.Calendar;

public class d
  extends SSDKHandlerThread
{
  private static d a;
  private Context b;
  private DeviceHelper c;
  private a d;
  private String e;
  private Handler f;
  private boolean g;
  private int h;
  private boolean i;
  private long j;
  private boolean k;
  
  private d(Context paramContext)
  {
    super("Thread-" + Math.abs(51968));
    this.b = paramContext;
    this.c = DeviceHelper.getInstance(paramContext);
    this.d = a.a(paramContext);
  }
  
  /* Error */
  public static d a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 74	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +28 -> 36
    //   11: aload_0
    //   12: ifnonnull +10 -> 22
    //   15: aconst_null
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: new 2	cn/sharesdk/framework/statistics/d
    //   25: dup
    //   26: aload_0
    //   27: invokevirtual 80	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   30: invokespecial 82	cn/sharesdk/framework/statistics/d:<init>	(Landroid/content/Context;)V
    //   33: putstatic 74	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   36: getstatic 74	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   39: astore_0
    //   40: goto -23 -> 17
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   6	2	1	locald	d
    // Exception table:
    //   from	to	target	type
    //   3	7	43	finally
    //   22	36	43	finally
    //   36	40	43	finally
  }
  
  private void a()
  {
    boolean bool = b();
    if (bool) {
      if ((!this.k) && (this.c.isMainProcess(this.b, 0)))
      {
        this.k = bool;
        this.j = System.currentTimeMillis();
        a(new g());
      }
    }
    while ((!this.k) || (!this.c.isMainProcess(this.b, 0))) {
      return;
    }
    this.k = bool;
    long l1 = System.currentTimeMillis();
    long l2 = this.j;
    e locale = new e();
    locale.a = (l1 - l2);
    a(locale);
  }
  
  private void b(cn.sharesdk.framework.statistics.b.c paramc)
  {
    paramc.f = this.c.getDeviceKey();
    paramc.g = this.e;
    paramc.h = this.c.getPackageName();
    paramc.i = this.c.getAppVersion();
    paramc.j = String.valueOf(60000 + this.h);
    paramc.k = this.c.getPlatformCode();
    paramc.l = this.c.getDetailNetworkTypeForStatic();
    if ((!"cn.sharesdk.demo".equals(paramc.h)) && (("api20".equals(this.e)) || ("androidv1101".equals(this.e)))) {
      System.err.println("Your application is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
    }
    paramc.m = this.c.getDeviceData();
  }
  
  private boolean b()
  {
    Object localObject = DeviceHelper.getInstance(this.b);
    String str = ((DeviceHelper)localObject).getTopTaskPackageName();
    localObject = ((DeviceHelper)localObject).getPackageName();
    return (localObject != null) && (((String)localObject).equals(str));
  }
  
  private void c()
  {
    try
    {
      if (this.c.isMainProcess(this.b, 0)) {
        a.a(this.b).a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
  
  private void c(cn.sharesdk.framework.statistics.b.c paramc)
  {
    try
    {
      this.d.a(paramc);
      paramc.b(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      cn.sharesdk.framework.utils.d.a().w(paramc.toString(), new Object[0]);
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(Handler paramHandler)
  {
    this.f = paramHandler;
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    Message localMessage;
    if (this.i)
    {
      b(paramc);
      if (paramc.a(this.b))
      {
        localMessage = new Message();
        localMessage.what = 3;
        localMessage.obj = paramc;
      }
    }
    else
    {
      try
      {
        this.handler.sendMessage(localMessage);
        return;
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.d.a().w(paramc);
        return;
      }
    }
    cn.sharesdk.framework.utils.d.a().d("Drop event: " + paramc.toString(), new Object[0]);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected void onMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
      do
      {
        return;
      } while (paramMessage.obj == null);
      c((cn.sharesdk.framework.statistics.b.c)paramMessage.obj);
      return;
    case 1: 
      a();
      try
      {
        this.handler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        cn.sharesdk.framework.utils.d.a().w(paramMessage);
        return;
      }
    case 2: 
      c();
      try
      {
        this.handler.sendEmptyMessageDelayed(2, 10000L);
        return;
      }
      catch (Throwable paramMessage)
      {
        cn.sharesdk.framework.utils.d.a().w(paramMessage);
        return;
      }
    }
    long l = cn.sharesdk.framework.statistics.a.c.a(this.b).h().longValue();
    paramMessage = Calendar.getInstance();
    paramMessage.setTimeInMillis(l);
    int m = paramMessage.get(1);
    int n = paramMessage.get(2);
    int i1 = paramMessage.get(5);
    paramMessage.setTimeInMillis(System.currentTimeMillis());
    int i2 = paramMessage.get(1);
    int i3 = paramMessage.get(2);
    int i4 = paramMessage.get(5);
    if ((m != i2) || (n != i3) || (i1 != i4)) {
      this.d.b(this.e);
    }
    for (;;)
    {
      this.handler.sendEmptyMessageDelayed(4, 3600000L);
      return;
      this.d.c(this.e);
    }
  }
  
  protected void onStart(Message paramMessage)
  {
    if (!this.i)
    {
      this.i = true;
      this.d.a(this.e);
      this.d.b(this.e);
      this.d.c(this.e);
      this.d.d(this.e);
      this.handler.sendEmptyMessageDelayed(4, 3600000L);
      this.d.a(this.g);
      this.handler.sendEmptyMessage(1);
      this.handler.sendEmptyMessage(2);
      NewAppReceiver.a(this.b);
    }
  }
  
  protected void onStop(Message paramMessage)
  {
    if (this.i)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.j;
      paramMessage = new e();
      paramMessage.a = (l1 - l2);
      a(paramMessage);
      this.i = false;
    }
    try
    {
      this.f.sendEmptyMessage(1);
      a = null;
      this.handler.getLooper().quit();
      return;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(paramMessage);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */