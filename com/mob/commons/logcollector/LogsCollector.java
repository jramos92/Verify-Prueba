package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;

public abstract class LogsCollector
  implements LogCollector
{
  private c a;
  
  public LogsCollector(Context paramContext)
  {
    this.a = c.a(paramContext);
    this.a.a(getSDKVersion(), getSDKTag(), getAppkey());
  }
  
  final int a(int paramInt, String paramString)
  {
    if (this.a.a() != null) {}
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("cn.sharesdk.log");
      localIntent.putExtra("package", this.a.a().getPackageName());
      localIntent.putExtra("priority", paramInt);
      localIntent.putExtra("msg", paramString);
      this.a.a().sendBroadcast(localIntent);
      return 0;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramString);
      }
    }
  }
  
  protected abstract String getAppkey();
  
  protected abstract String getSDKTag();
  
  protected abstract int getSDKVersion();
  
  public final void log(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    a(paramInt1, paramString3);
    if ((paramString1 == null) || (!paramString1.equals(getSDKTag()))) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        this.a.b(getSDKVersion(), paramInt2, paramString1, getAppkey(), paramString3);
        return;
      }
      if (paramInt2 == 2)
      {
        this.a.a(getSDKVersion(), paramInt2, paramString1, getAppkey(), paramString3);
        return;
      }
    } while (paramInt1 != 5);
    this.a.a(getSDKVersion(), paramInt2, paramString1, getAppkey(), paramString3);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\commons\logcollector\LogsCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */