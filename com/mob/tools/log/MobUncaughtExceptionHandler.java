package com.mob.tools.log;

import android.util.Log;
import com.mob.tools.MobLog;

public class MobUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private static boolean disable;
  private static boolean isDebug = true;
  private static Thread.UncaughtExceptionHandler oriHandler;
  
  public static void closeLog()
  {
    isDebug = false;
  }
  
  public static void disable()
  {
    disable = true;
  }
  
  public static void openLog()
  {
    isDebug = true;
  }
  
  public static void register()
  {
    if (!disable)
    {
      oriHandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(new MobUncaughtExceptionHandler());
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (isDebug) {
      Log.wtf("MobUncaughtExceptionHandler", paramThrowable);
    }
    MobLog.getInstance().crash(paramThrowable);
    if (oriHandler != null) {
      oriHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\log\MobUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */