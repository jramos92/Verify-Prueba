package com.veryfit.multi.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;
import com.project.library.core.CoreServiceProxy;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CrashHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String TAG = "CrashHandler";
  private Context mCtx;
  
  public static CrashHandler getInstance()
  {
    return CrashHandlerFactory.instance;
  }
  
  private void writeLog(String paramString1, String paramString2)
  {
    Object localObject = DateFormat.format("yyyyMMdd_kkmmss", System.currentTimeMillis());
    paramString2 = paramString2 + "_" + localObject + ".log";
    try
    {
      paramString2 = new OutputStreamWriter(new FileOutputStream(paramString2));
      localObject = new BufferedWriter(paramString2);
      ((BufferedWriter)localObject).write(paramString1);
      ((BufferedWriter)localObject).newLine();
      ((BufferedWriter)localObject).close();
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void writeLogcat(String paramString)
  {
    CharSequence localCharSequence = DateFormat.format("yyyyMMdd_kkmmss", System.currentTimeMillis());
    paramString = paramString + "_" + localCharSequence + ".log";
    try
    {
      Logcat.writeLogcat(paramString);
      return;
    }
    catch (IOException paramString)
    {
      Log.e("CrashHandler", "Cannot write logcat to disk");
    }
  }
  
  public CrashHandler init(Context paramContext)
  {
    this.mCtx = paramContext;
    return this;
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 8	com/veryfit/multi/util/CrashHandler$1
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 124	com/veryfit/multi/util/CrashHandler$1:<init>	(Lcom/veryfit/multi/util/CrashHandler;)V
    //   10: invokevirtual 127	com/veryfit/multi/util/CrashHandler$1:start	()V
    //   13: new 129	java/io/StringWriter
    //   16: dup
    //   17: invokespecial 130	java/io/StringWriter:<init>	()V
    //   20: astore_3
    //   21: new 132	java/io/PrintWriter
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 133	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 139	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   34: astore 4
    //   36: aload 4
    //   38: arraylength
    //   39: iconst_3
    //   40: iadd
    //   41: anewarray 141	java/lang/StackTraceElement
    //   44: astore 5
    //   46: aload 4
    //   48: iconst_0
    //   49: aload 5
    //   51: iconst_0
    //   52: aload 4
    //   54: arraylength
    //   55: invokestatic 145	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   58: aload 5
    //   60: aload 4
    //   62: arraylength
    //   63: iconst_0
    //   64: iadd
    //   65: new 141	java/lang/StackTraceElement
    //   68: dup
    //   69: ldc -109
    //   71: ldc -107
    //   73: getstatic 153	android/os/Build:MODEL	Ljava/lang/String;
    //   76: iconst_m1
    //   77: invokespecial 156	java/lang/StackTraceElement:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   80: aastore
    //   81: aload 5
    //   83: aload 4
    //   85: arraylength
    //   86: iconst_1
    //   87: iadd
    //   88: new 141	java/lang/StackTraceElement
    //   91: dup
    //   92: ldc -109
    //   94: ldc -98
    //   96: getstatic 163	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   99: iconst_m1
    //   100: invokespecial 156	java/lang/StackTraceElement:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   103: aastore
    //   104: aload 5
    //   106: aload 4
    //   108: arraylength
    //   109: iconst_2
    //   110: iadd
    //   111: new 141	java/lang/StackTraceElement
    //   114: dup
    //   115: ldc -109
    //   117: ldc -91
    //   119: getstatic 167	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   122: iconst_m1
    //   123: invokespecial 156	java/lang/StackTraceElement:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   126: aastore
    //   127: aload_2
    //   128: aload 5
    //   130: invokevirtual 171	java/lang/Throwable:setStackTrace	([Ljava/lang/StackTraceElement;)V
    //   133: aload_2
    //   134: aload_1
    //   135: invokevirtual 174	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   138: aload_3
    //   139: invokevirtual 175	java/lang/Object:toString	()Ljava/lang/String;
    //   142: astore_2
    //   143: aload_1
    //   144: invokevirtual 176	java/io/PrintWriter:close	()V
    //   147: ldc 15
    //   149: aload_2
    //   150: invokestatic 116	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: pop
    //   154: invokestatic 181	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   157: ldc -73
    //   159: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +75 -> 237
    //   165: getstatic 192	com/veryfit/multi/util/Constant:LOG_PATH	Ljava/lang/String;
    //   168: astore_1
    //   169: new 194	java/io/File
    //   172: dup
    //   173: aload_1
    //   174: invokespecial 195	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore_3
    //   178: aload_3
    //   179: invokevirtual 199	java/io/File:exists	()Z
    //   182: ifne +8 -> 190
    //   185: aload_3
    //   186: invokevirtual 202	java/io/File:mkdirs	()Z
    //   189: pop
    //   190: aload_0
    //   191: aload_2
    //   192: new 53	java/lang/StringBuilder
    //   195: dup
    //   196: aload_1
    //   197: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   200: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: ldc -52
    //   205: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokespecial 206	com/veryfit/multi/util/CrashHandler:writeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: new 53	java/lang/StringBuilder
    //   218: dup
    //   219: aload_1
    //   220: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: ldc -48
    //   228: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokespecial 209	com/veryfit/multi/util/CrashHandler:writeLogcat	(Ljava/lang/String;)V
    //   237: ldc2_w 210
    //   240: invokestatic 217	java/lang/Thread:sleep	(J)V
    //   243: invokestatic 223	android/os/Process:myPid	()I
    //   246: invokestatic 227	android/os/Process:killProcess	(I)V
    //   249: iconst_m1
    //   250: invokestatic 230	java/lang/System:exit	(I)V
    //   253: aload_0
    //   254: monitorexit
    //   255: return
    //   256: astore_1
    //   257: goto -14 -> 243
    //   260: astore_1
    //   261: aload_0
    //   262: monitorexit
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	CrashHandler
    //   0	265	1	paramThread	Thread
    //   0	265	2	paramThrowable	Throwable
    //   20	166	3	localObject	Object
    //   34	73	4	arrayOfStackTraceElement1	StackTraceElement[]
    //   44	85	5	arrayOfStackTraceElement2	StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   237	243	256	java/lang/InterruptedException
    //   2	190	260	finally
    //   190	237	260	finally
    //   237	243	260	finally
    //   243	253	260	finally
  }
  
  private static class CrashHandlerFactory
  {
    private static CrashHandler instance = new CrashHandler(null);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\CrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */