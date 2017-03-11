package com.mob.commons.logcollector;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class f
{
  /* Error */
  public static long a(Context paramContext, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_3
    //   4: invokestatic 12	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore 6
    //   9: iload 6
    //   11: ifeq +12 -> 23
    //   14: ldc2_w 13
    //   17: lstore_1
    //   18: ldc 2
    //   20: monitorexit
    //   21: lload_1
    //   22: lreturn
    //   23: aload_0
    //   24: invokestatic 19	com/mob/commons/logcollector/b:a	(Landroid/content/Context;)Lcom/mob/commons/logcollector/b;
    //   27: astore_0
    //   28: new 21	android/content/ContentValues
    //   31: dup
    //   32: invokespecial 25	android/content/ContentValues:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc 27
    //   41: lload_1
    //   42: invokestatic 33	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 37	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   48: aload 7
    //   50: ldc 39
    //   52: aload_3
    //   53: invokevirtual 45	java/lang/String:toString	()Ljava/lang/String;
    //   56: invokevirtual 48	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 7
    //   61: ldc 50
    //   63: iload 4
    //   65: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokevirtual 58	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   71: aload 7
    //   73: ldc 60
    //   75: aload 5
    //   77: invokevirtual 48	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: ldc 62
    //   83: aload 7
    //   85: invokevirtual 65	com/mob/commons/logcollector/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   88: lstore_1
    //   89: goto -71 -> 18
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramLong	long
    //   0	98	3	paramString1	String
    //   0	98	4	paramInt	int
    //   0	98	5	paramString2	String
    //   7	3	6	bool	boolean
    //   35	49	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   3	9	92	finally
    //   23	89	92	finally
  }
  
  public static long a(Context paramContext, ArrayList<String> paramArrayList)
  {
    long l;
    if (paramArrayList == null) {
      l = 0L;
    }
    for (;;)
    {
      return l;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < paramArrayList.size())
        {
          localStringBuilder.append("'");
          localStringBuilder.append((String)paramArrayList.get(i));
          localStringBuilder.append("'");
          localStringBuilder.append(",");
          i += 1;
        }
        paramArrayList = localStringBuilder.toString().substring(0, localStringBuilder.length() - 1);
        i = b.a(paramContext).a("table_exception", "exception_md5 in ( " + paramArrayList + " )", null);
        MobLog.getInstance().i("delete COUNT == %s", new Object[] { Integer.valueOf(i) });
        l = i;
      }
      finally {}
    }
  }
  
  private static ArrayList<e> a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      e locale = new e();
      b localb = b.a(paramContext);
      String str = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = str;
        if (paramArrayOfString != null)
        {
          paramContext = str;
          if (paramArrayOfString.length > 0) {
            paramContext = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + paramString + " group by exception_md5 having max(_id)";
          }
        }
      }
      paramString = localb.a(paramContext, paramArrayOfString);
      paramContext = locale;
      while ((paramString != null) && (paramString.moveToNext()))
      {
        paramContext.b.add(paramString.getString(0));
        paramArrayOfString = new HashMap();
        paramArrayOfString.put("type", Integer.valueOf(paramString.getInt(1)));
        paramArrayOfString.put("errat", Long.valueOf(paramString.getLong(2)));
        paramArrayOfString.put("msg", Base64.encodeToString(paramString.getString(3).getBytes(), 2));
        paramArrayOfString.put("times", Integer.valueOf(paramString.getInt(4)));
        paramContext.a.add(paramArrayOfString);
        if (paramContext.b.size() == 50)
        {
          localArrayList.add(paramContext);
          paramContext = new e();
        }
      }
      paramString.close();
    }
    finally {}
    if (paramContext.b.size() != 0) {
      localArrayList.add(paramContext);
    }
    return localArrayList;
  }
  
  public static ArrayList<e> a(Context paramContext, String[] paramArrayOfString)
  {
    String str = "exception_level = ?";
    if (paramArrayOfString != null) {}
    for (String[] arrayOfString = paramArrayOfString;; arrayOfString = null) {
      try
      {
        if (paramArrayOfString.length > 0)
        {
          if (b.a(paramContext).a("table_exception") > 0) {}
          for (paramContext = a(paramContext, str, arrayOfString);; paramContext = new ArrayList()) {
            return paramContext;
          }
        }
        str = null;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\commons\logcollector\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */