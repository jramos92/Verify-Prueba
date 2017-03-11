package com.project.library.util;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UartLogUtil
{
  private static final int BUFFER = 1;
  private static final int BUFFER_SIZE = 0;
  private static final String LOG_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/veryfit2" + "/log/dataLog";
  private static final String REAL_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/veryfit2" + "/log/realLog";
  private static StringBuffer buffer;
  private static FileWriter fw;
  private static StringBuffer realffer;
  private static StringBuffer sbffer;
  
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
    Object localObject = new File(LOG_PATH);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 10))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j - 10)
        {
          localObject[i].delete();
          i += 1;
        }
      }
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
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 128	com/project/library/share/LibSharedPreferences:getInstance	()Lcom/project/library/share/LibSharedPreferences;
    //   6: invokevirtual 131	com/project/library/share/LibSharedPreferences:getDebug	()Z
    //   9: ifeq +173 -> 182
    //   12: new 30	java/io/File
    //   15: dup
    //   16: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   19: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 82	java/io/File:exists	()Z
    //   27: ifne +8 -> 35
    //   30: aload_1
    //   31: invokevirtual 134	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: invokestatic 136	com/project/library/util/UartLogUtil:deleteOldFile	()V
    //   38: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   41: ifnonnull +14 -> 55
    //   44: new 140	java/lang/StringBuffer
    //   47: dup
    //   48: iconst_0
    //   49: invokespecial 143	java/lang/StringBuffer:<init>	(I)V
    //   52: putstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   55: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   58: invokevirtual 147	java/lang/StringBuffer:length	()I
    //   61: aload_0
    //   62: invokevirtual 148	java/lang/String:length	()I
    //   65: iadd
    //   66: ifle +183 -> 249
    //   69: new 92	java/text/SimpleDateFormat
    //   72: dup
    //   73: ldc 94
    //   75: getstatic 100	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   78: invokespecial 103	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   81: astore_1
    //   82: new 30	java/io/File
    //   85: dup
    //   86: new 22	java/lang/StringBuilder
    //   89: dup
    //   90: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   93: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: ldc -106
    //   101: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: new 111	java/util/Date
    //   108: dup
    //   109: invokespecial 112	java/util/Date:<init>	()V
    //   112: invokevirtual 116	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   115: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 118
    //   120: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_3
    //   134: new 71	java/io/FileWriter
    //   137: dup
    //   138: aload_2
    //   139: iconst_1
    //   140: invokespecial 121	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   143: astore_2
    //   144: aload_2
    //   145: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   148: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   151: invokevirtual 154	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   154: pop
    //   155: aload_2
    //   156: invokevirtual 157	java/io/FileWriter:flush	()V
    //   159: aload_2
    //   160: ifnull +110 -> 270
    //   163: aload_2
    //   164: invokevirtual 73	java/io/FileWriter:close	()V
    //   167: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   170: iconst_0
    //   171: invokevirtual 160	java/lang/StringBuffer:setLength	(I)V
    //   174: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   177: aload_0
    //   178: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   181: pop
    //   182: ldc 2
    //   184: monitorexit
    //   185: return
    //   186: astore_1
    //   187: aload_3
    //   188: astore_2
    //   189: aload_1
    //   190: astore_3
    //   191: aload_2
    //   192: astore_1
    //   193: aload_3
    //   194: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   197: aload_2
    //   198: ifnull -31 -> 167
    //   201: aload_2
    //   202: invokevirtual 73	java/io/FileWriter:close	()V
    //   205: goto -38 -> 167
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   213: goto -46 -> 167
    //   216: astore_0
    //   217: ldc 2
    //   219: monitorexit
    //   220: aload_0
    //   221: athrow
    //   222: astore_0
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 73	java/io/FileWriter:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   238: goto -7 -> 231
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   246: goto +24 -> 270
    //   249: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   252: aload_0
    //   253: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   256: pop
    //   257: goto -75 -> 182
    //   260: astore_0
    //   261: aload_2
    //   262: astore_1
    //   263: goto -40 -> 223
    //   266: astore_3
    //   267: goto -76 -> 191
    //   270: goto -103 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramString	String
    //   22	110	1	localObject1	Object
    //   186	4	1	localIOException1	IOException
    //   192	1	1	localObject2	Object
    //   208	20	1	localIOException2	IOException
    //   233	2	1	localIOException3	IOException
    //   241	2	1	localIOException4	IOException
    //   262	1	1	localObject3	Object
    //   129	133	2	localObject4	Object
    //   133	61	3	localIOException5	IOException
    //   266	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   134	144	186	java/io/IOException
    //   201	205	208	java/io/IOException
    //   3	35	216	finally
    //   35	55	216	finally
    //   55	130	216	finally
    //   163	167	216	finally
    //   167	182	216	finally
    //   201	205	216	finally
    //   209	213	216	finally
    //   227	231	216	finally
    //   231	233	216	finally
    //   234	238	216	finally
    //   242	246	216	finally
    //   249	257	216	finally
    //   134	144	222	finally
    //   193	197	222	finally
    //   227	231	233	java/io/IOException
    //   163	167	241	java/io/IOException
    //   144	159	260	finally
    //   144	159	266	java/io/IOException
  }
  
  public static void recordRealTime(String paramString) {}
  
  /* Error */
  public static void recordRecieve(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 128	com/project/library/share/LibSharedPreferences:getInstance	()Lcom/project/library/share/LibSharedPreferences;
    //   6: invokevirtual 131	com/project/library/share/LibSharedPreferences:getDebug	()Z
    //   9: ifeq +256 -> 265
    //   12: new 92	java/text/SimpleDateFormat
    //   15: dup
    //   16: ldc -88
    //   18: getstatic 100	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   21: invokespecial 103	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   24: astore_2
    //   25: new 22	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_2
    //   35: new 111	java/util/Date
    //   38: dup
    //   39: invokespecial 112	java/util/Date:<init>	()V
    //   42: invokevirtual 116	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -86
    //   54: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: new 22	java/lang/StringBuilder
    //   60: dup
    //   61: ldc -84
    //   63: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokestatic 178	com/project/library/util/ByteDataConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   70: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc -76
    //   75: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc -74
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: new 30	java/io/File
    //   98: dup
    //   99: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   102: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 82	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_0
    //   114: invokevirtual 134	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: invokestatic 136	com/project/library/util/UartLogUtil:deleteOldFile	()V
    //   121: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   124: ifnonnull +14 -> 138
    //   127: new 140	java/lang/StringBuffer
    //   130: dup
    //   131: iconst_0
    //   132: invokespecial 143	java/lang/StringBuffer:<init>	(I)V
    //   135: putstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   138: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   141: invokevirtual 147	java/lang/StringBuffer:length	()I
    //   144: aload_3
    //   145: invokevirtual 148	java/lang/String:length	()I
    //   148: iadd
    //   149: ifle +183 -> 332
    //   152: new 92	java/text/SimpleDateFormat
    //   155: dup
    //   156: ldc 94
    //   158: getstatic 100	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   161: invokespecial 103	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   164: astore_0
    //   165: new 30	java/io/File
    //   168: dup
    //   169: new 22	java/lang/StringBuilder
    //   172: dup
    //   173: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   176: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   179: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: ldc -106
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: new 111	java/util/Date
    //   191: dup
    //   192: invokespecial 112	java/util/Date:<init>	()V
    //   195: invokevirtual 116	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   198: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 118
    //   203: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_2
    //   217: new 71	java/io/FileWriter
    //   220: dup
    //   221: aload_1
    //   222: iconst_1
    //   223: invokespecial 121	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   226: astore_1
    //   227: aload_1
    //   228: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   231: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   234: invokevirtual 154	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   237: pop
    //   238: aload_1
    //   239: invokevirtual 157	java/io/FileWriter:flush	()V
    //   242: aload_1
    //   243: ifnull +112 -> 355
    //   246: aload_1
    //   247: invokevirtual 73	java/io/FileWriter:close	()V
    //   250: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   253: iconst_0
    //   254: invokevirtual 160	java/lang/StringBuffer:setLength	(I)V
    //   257: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   260: aload_3
    //   261: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   264: pop
    //   265: ldc 2
    //   267: monitorexit
    //   268: return
    //   269: astore_0
    //   270: aload_2
    //   271: astore_1
    //   272: aload_0
    //   273: astore_2
    //   274: aload_1
    //   275: astore_0
    //   276: aload_2
    //   277: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   280: aload_1
    //   281: ifnull -31 -> 250
    //   284: aload_1
    //   285: invokevirtual 73	java/io/FileWriter:close	()V
    //   288: goto -38 -> 250
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   296: goto -46 -> 250
    //   299: astore_0
    //   300: ldc 2
    //   302: monitorexit
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 73	java/io/FileWriter:close	()V
    //   314: aload_1
    //   315: athrow
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   321: goto -7 -> 314
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   329: goto +26 -> 355
    //   332: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   335: aload_3
    //   336: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: goto -75 -> 265
    //   343: astore_2
    //   344: aload_1
    //   345: astore_0
    //   346: aload_2
    //   347: astore_1
    //   348: goto -42 -> 306
    //   351: astore_2
    //   352: goto -78 -> 274
    //   355: goto -105 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramString	String
    //   0	358	1	paramArrayOfByte	byte[]
    //   24	253	2	localObject1	Object
    //   343	4	2	localObject2	Object
    //   351	1	2	localIOException	IOException
    //   32	304	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   217	227	269	java/io/IOException
    //   284	288	291	java/io/IOException
    //   3	118	299	finally
    //   118	138	299	finally
    //   138	213	299	finally
    //   246	250	299	finally
    //   250	265	299	finally
    //   284	288	299	finally
    //   292	296	299	finally
    //   310	314	299	finally
    //   314	316	299	finally
    //   317	321	299	finally
    //   325	329	299	finally
    //   332	340	299	finally
    //   217	227	305	finally
    //   276	280	305	finally
    //   310	314	316	java/io/IOException
    //   246	250	324	java/io/IOException
    //   227	242	343	finally
    //   227	242	351	java/io/IOException
  }
  
  /* Error */
  public static void recordWrite(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 128	com/project/library/share/LibSharedPreferences:getInstance	()Lcom/project/library/share/LibSharedPreferences;
    //   6: invokevirtual 131	com/project/library/share/LibSharedPreferences:getDebug	()Z
    //   9: ifeq +256 -> 265
    //   12: new 92	java/text/SimpleDateFormat
    //   15: dup
    //   16: ldc -88
    //   18: getstatic 100	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   21: invokespecial 103	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   24: astore_2
    //   25: new 22	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_2
    //   35: new 111	java/util/Date
    //   38: dup
    //   39: invokespecial 112	java/util/Date:<init>	()V
    //   42: invokevirtual 116	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   45: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -71
    //   54: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: new 22	java/lang/StringBuilder
    //   60: dup
    //   61: ldc -84
    //   63: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokestatic 178	com/project/library/util/ByteDataConvertUtil:bytesToHexString	([B)Ljava/lang/String;
    //   70: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc -76
    //   75: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc -74
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_3
    //   95: new 30	java/io/File
    //   98: dup
    //   99: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   102: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 82	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_0
    //   114: invokevirtual 134	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: invokestatic 136	com/project/library/util/UartLogUtil:deleteOldFile	()V
    //   121: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   124: ifnonnull +14 -> 138
    //   127: new 140	java/lang/StringBuffer
    //   130: dup
    //   131: iconst_0
    //   132: invokespecial 143	java/lang/StringBuffer:<init>	(I)V
    //   135: putstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   138: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   141: invokevirtual 147	java/lang/StringBuffer:length	()I
    //   144: aload_3
    //   145: invokevirtual 148	java/lang/String:length	()I
    //   148: iadd
    //   149: ifle +183 -> 332
    //   152: new 92	java/text/SimpleDateFormat
    //   155: dup
    //   156: ldc 94
    //   158: getstatic 100	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   161: invokespecial 103	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   164: astore_0
    //   165: new 30	java/io/File
    //   168: dup
    //   169: new 22	java/lang/StringBuilder
    //   172: dup
    //   173: getstatic 57	com/project/library/util/UartLogUtil:LOG_PATH	Ljava/lang/String;
    //   176: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   179: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: ldc -106
    //   184: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: new 111	java/util/Date
    //   191: dup
    //   192: invokespecial 112	java/util/Date:<init>	()V
    //   195: invokevirtual 116	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   198: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 118
    //   203: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 78	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_2
    //   217: new 71	java/io/FileWriter
    //   220: dup
    //   221: aload_1
    //   222: iconst_1
    //   223: invokespecial 121	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   226: astore_1
    //   227: aload_1
    //   228: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   231: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   234: invokevirtual 154	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   237: pop
    //   238: aload_1
    //   239: invokevirtual 157	java/io/FileWriter:flush	()V
    //   242: aload_1
    //   243: ifnull +112 -> 355
    //   246: aload_1
    //   247: invokevirtual 73	java/io/FileWriter:close	()V
    //   250: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   253: iconst_0
    //   254: invokevirtual 160	java/lang/StringBuffer:setLength	(I)V
    //   257: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   260: aload_3
    //   261: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   264: pop
    //   265: ldc 2
    //   267: monitorexit
    //   268: return
    //   269: astore_0
    //   270: aload_2
    //   271: astore_1
    //   272: aload_0
    //   273: astore_2
    //   274: aload_1
    //   275: astore_0
    //   276: aload_2
    //   277: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   280: aload_1
    //   281: ifnull -31 -> 250
    //   284: aload_1
    //   285: invokevirtual 73	java/io/FileWriter:close	()V
    //   288: goto -38 -> 250
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   296: goto -46 -> 250
    //   299: astore_0
    //   300: ldc 2
    //   302: monitorexit
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_0
    //   307: ifnull +7 -> 314
    //   310: aload_0
    //   311: invokevirtual 73	java/io/FileWriter:close	()V
    //   314: aload_1
    //   315: athrow
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   321: goto -7 -> 314
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual 76	java/io/IOException:printStackTrace	()V
    //   329: goto +26 -> 355
    //   332: getstatic 138	com/project/library/util/UartLogUtil:buffer	Ljava/lang/StringBuffer;
    //   335: aload_3
    //   336: invokevirtual 163	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: goto -75 -> 265
    //   343: astore_2
    //   344: aload_1
    //   345: astore_0
    //   346: aload_2
    //   347: astore_1
    //   348: goto -42 -> 306
    //   351: astore_2
    //   352: goto -78 -> 274
    //   355: goto -105 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramString	String
    //   0	358	1	paramArrayOfByte	byte[]
    //   24	253	2	localObject1	Object
    //   343	4	2	localObject2	Object
    //   351	1	2	localIOException	IOException
    //   32	304	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   217	227	269	java/io/IOException
    //   284	288	291	java/io/IOException
    //   3	118	299	finally
    //   118	138	299	finally
    //   138	213	299	finally
    //   246	250	299	finally
    //   250	265	299	finally
    //   284	288	299	finally
    //   292	296	299	finally
    //   310	314	299	finally
    //   314	316	299	finally
    //   317	321	299	finally
    //   325	329	299	finally
    //   332	340	299	finally
    //   217	227	305	finally
    //   276	280	305	finally
    //   310	314	316	java/io/IOException
    //   246	250	324	java/io/IOException
    //   227	242	343	finally
    //   227	242	351	java/io/IOException
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\UartLogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */