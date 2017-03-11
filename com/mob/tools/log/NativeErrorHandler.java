package com.mob.tools.log;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class NativeErrorHandler
{
  private static final int MAX_LOG_SIZE = 100;
  private static final boolean enable;
  
  static
  {
    boolean bool = false;
    try
    {
      System.loadLibrary("neh");
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    enable = bool;
  }
  
  private static String getCachePath(Context paramContext)
  {
    paramContext = new File(R.getCacheRoot(paramContext), "NativeCrashLogs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  private static native void nativePrepare(String paramString);
  
  private static ArrayList<NativeCrashInfo> parseIndex(String paramString)
    throws Throwable
  {
    paramString = new File(paramString, ".ncl");
    if (!paramString.exists()) {
      return new ArrayList();
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)));
    ArrayList localArrayList = new ArrayList();
    paramString = localBufferedReader.readLine();
    while (paramString != null)
    {
      String[] arrayOfString = paramString.split(",");
      if (arrayOfString.length >= 2)
      {
        paramString = new NativeCrashInfo(null);
        paramString.time = R.parseLong(arrayOfString[0]);
        paramString.signal = R.parseInt(arrayOfString[1]);
        localArrayList.add(paramString);
        paramString = localBufferedReader.readLine();
      }
    }
    localBufferedReader.close();
    return localArrayList;
  }
  
  private static String parseLog(String paramString, NativeCrashInfo paramNativeCrashInfo)
    throws Throwable
  {
    paramString = new File(paramString, "." + paramNativeCrashInfo.time);
    if (!paramString.exists()) {
      return "";
    }
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)));
    paramNativeCrashInfo = new LinkedList();
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      paramNativeCrashInfo.add(paramString);
      if (paramNativeCrashInfo.size() > 100) {
        paramNativeCrashInfo.remove(0);
      }
    }
    localBufferedReader.close();
    paramString = new StringBuffer();
    paramNativeCrashInfo = paramNativeCrashInfo.iterator();
    while (paramNativeCrashInfo.hasNext()) {
      paramString.append((String)paramNativeCrashInfo.next()).append('\n');
    }
    if (paramString.length() > 0) {
      return paramString.substring(0, paramString.length() - 1);
    }
    return "";
  }
  
  public static boolean prepare(Context paramContext)
  {
    paramContext = getCachePath(paramContext);
    if (enable)
    {
      uploadCreashLog(paramContext);
      nativePrepare(paramContext);
    }
    return enable;
  }
  
  private static void uploadCreashLog(String paramString)
  {
    try
    {
      Iterator localIterator = parseIndex(paramString).iterator();
      while (localIterator.hasNext())
      {
        String str = parseLog(paramString, (NativeCrashInfo)localIterator.next());
        MobLog.getInstance().nativeCrashLog(str);
      }
      R.deleteFileAndFolder(new File(paramString));
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
      return;
    }
  }
  
  private static class NativeCrashInfo
  {
    public int signal;
    public long time;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\log\NativeErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */