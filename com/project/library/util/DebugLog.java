package com.project.library.util;

import android.util.Log;

public class DebugLog
{
  static String className;
  static int lineNumber;
  static String methodName;
  
  private static String createLog(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[");
    localStringBuffer.append(methodName);
    localStringBuffer.append(":");
    localStringBuffer.append(lineNumber);
    localStringBuffer.append("]");
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  public static void d(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.d(className, createLog(paramString));
  }
  
  public static void e(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.e(className, createLog(paramString));
  }
  
  private static void getMethodNames(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    className = paramArrayOfStackTraceElement[1].getFileName();
    methodName = paramArrayOfStackTraceElement[1].getMethodName();
    lineNumber = paramArrayOfStackTraceElement[1].getLineNumber();
  }
  
  public static void i(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.i(className, createLog(paramString));
  }
  
  public static boolean isDebuggable()
  {
    return true;
  }
  
  public static void v(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.v(className, createLog(paramString));
  }
  
  public static void w(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.w(className, createLog(paramString));
  }
  
  public static void wtf(String paramString)
  {
    if (!isDebuggable()) {
      return;
    }
    getMethodNames(new Throwable().getStackTrace());
    Log.wtf(className, createLog(paramString));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\DebugLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */