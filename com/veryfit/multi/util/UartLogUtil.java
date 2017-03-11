package com.veryfit.multi.util;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UartLogUtil
{
  private static FileWriter fw;
  
  public static void close()
  {
    if (fw != null) {}
    try
    {
      fw.close();
      fw = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private static void deleteOldFile()
  {
    Object localObject = new Date();
    ((Date)localObject).setTime(((Date)localObject).getTime() - 864000000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
    localObject = new File(Constant.LOG_PATH + "/dataLog_" + localSimpleDateFormat.format((Date)localObject) + ".txt");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  public static void open()
  {
    if (fw != null) {
      return;
    }
    Object localObject = new SimpleDateFormat("yyyyMMdd", Locale.CHINESE);
    localObject = new File(Environment.getExternalStorageDirectory() + "/log_" + ((SimpleDateFormat)localObject).format(new Date()) + ".txt");
    try
    {
      fw = new FileWriter((File)localObject, true);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  /* Error */
  public static void record(String paramString)
  {
    // Byte code:
    //   0: new 52	java/io/File
    //   3: dup
    //   4: getstatic 60	com/veryfit/multi/util/Constant:LOG_PATH	Ljava/lang/String;
    //   7: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 90	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 113	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: invokestatic 115	com/veryfit/multi/util/UartLogUtil:deleteOldFile	()V
    //   26: new 39	java/text/SimpleDateFormat
    //   29: dup
    //   30: ldc 41
    //   32: getstatic 47	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   35: invokespecial 50	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   38: astore_1
    //   39: new 52	java/io/File
    //   42: dup
    //   43: new 54	java/lang/StringBuilder
    //   46: dup
    //   47: getstatic 60	com/veryfit/multi/util/Constant:LOG_PATH	Ljava/lang/String;
    //   50: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: ldc 71
    //   58: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: new 26	java/util/Date
    //   65: dup
    //   66: invokespecial 27	java/util/Date:<init>	()V
    //   69: invokevirtual 79	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   72: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 81
    //   77: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_3
    //   91: new 18	java/io/FileWriter
    //   94: dup
    //   95: aload_2
    //   96: iconst_1
    //   97: invokespecial 109	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   100: astore_2
    //   101: aload_2
    //   102: aload_0
    //   103: invokevirtual 118	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   106: pop
    //   107: aload_2
    //   108: invokevirtual 121	java/io/FileWriter:flush	()V
    //   111: aload_2
    //   112: ifnull +56 -> 168
    //   115: aload_2
    //   116: invokevirtual 20	java/io/FileWriter:close	()V
    //   119: return
    //   120: astore_2
    //   121: aload_3
    //   122: astore_0
    //   123: aload_0
    //   124: astore_1
    //   125: aload_2
    //   126: invokevirtual 23	java/io/IOException:printStackTrace	()V
    //   129: aload_0
    //   130: ifnull -11 -> 119
    //   133: aload_0
    //   134: invokevirtual 20	java/io/FileWriter:close	()V
    //   137: return
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 23	java/io/IOException:printStackTrace	()V
    //   143: return
    //   144: astore_0
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 20	java/io/FileWriter:close	()V
    //   153: aload_0
    //   154: athrow
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 23	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 23	java/io/IOException:printStackTrace	()V
    //   168: return
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: goto -27 -> 145
    //   175: astore_1
    //   176: aload_2
    //   177: astore_0
    //   178: aload_1
    //   179: astore_2
    //   180: goto -57 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   10	140	1	localObject1	Object
    //   155	2	1	localIOException1	IOException
    //   171	1	1	localObject2	Object
    //   175	4	1	localIOException2	IOException
    //   86	30	2	localObject3	Object
    //   120	57	2	localIOException3	IOException
    //   179	1	2	localIOException4	IOException
    //   90	32	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   91	101	120	java/io/IOException
    //   133	137	138	java/io/IOException
    //   91	101	144	finally
    //   125	129	144	finally
    //   149	153	155	java/io/IOException
    //   115	119	163	java/io/IOException
    //   101	111	169	finally
    //   101	111	175	java/io/IOException
  }
  
  public static void write(String paramString)
  {
    if (fw != null) {}
    try
    {
      fw.append(paramString);
      fw.flush();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\UartLogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */