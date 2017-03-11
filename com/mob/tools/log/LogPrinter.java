package com.mob.tools.log;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

public class LogPrinter
{
  private HashMap<String, LogCollector> collectors = new HashMap();
  private String packageName = "";
  private String scope = "";
  
  private String getScope(Thread paramThread)
  {
    paramThread = paramThread.getStackTrace();
    if ((paramThread != null) && (paramThread.length > 0))
    {
      String str2 = paramThread[(paramThread.length - 1)];
      paramThread = str2.getFileName();
      if ((paramThread == null) || (paramThread.length() <= 0)) {}
      for (String str1 = str2.getClassName();; str1 = this.scope + "/" + paramThread)
      {
        int i = str2.getLineNumber();
        paramThread = String.valueOf(i);
        if (i < 0)
        {
          str2 = str2.getMethodName();
          if (str2 != null)
          {
            paramThread = str2;
            if (str2.length() > 0) {}
          }
          else
          {
            paramThread = "Unknown Source";
          }
        }
        return str1 + "(" + paramThread + ")";
      }
    }
    return this.scope;
  }
  
  private String processMessage(Thread paramThread, String paramString)
  {
    return String.format("%s %s", new Object[] { paramThread.getName(), paramString });
  }
  
  public void nativeCrashLog(String paramString1, String paramString2)
  {
    LogCollector localLogCollector = (LogCollector)this.collectors.get(paramString1);
    if (localLogCollector != null) {
      localLogCollector.log(paramString1, 6, 2, this.scope, paramString2);
    }
  }
  
  public int println(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject = Thread.currentThread();
    paramString2 = processMessage((Thread)localObject, paramString2);
    localObject = getScope((Thread)localObject);
    LogCollector localLogCollector = (LogCollector)this.collectors.get(paramString1);
    if (localLogCollector != null) {
      localLogCollector.log(paramString1, paramInt1, paramInt2, (String)localObject, paramString2);
    }
    return 0;
  }
  
  public void setCollector(String paramString, LogCollector paramLogCollector)
  {
    this.collectors.put(paramString, paramLogCollector);
  }
  
  public void setContext(Context paramContext)
  {
    this.packageName = paramContext.getPackageName();
    if (TextUtils.isEmpty(this.packageName))
    {
      this.packageName = "";
      return;
    }
    this.scope = this.packageName;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\log\LogPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */