package cn.sharesdk.framework.statistics.a;

import android.content.Context;
import android.database.Cursor;
import com.mob.tools.log.NLog;
import java.util.ArrayList;

public class e
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  
  /* Error */
  public static long a(Context paramContext, String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull +16 -> 20
    //   7: aload_1
    //   8: invokevirtual 24	java/lang/String:trim	()Ljava/lang/String;
    //   11: astore 4
    //   13: aload 4
    //   15: ldc 26
    //   17: if_acmpne +12 -> 29
    //   20: ldc2_w 27
    //   23: lstore_2
    //   24: ldc 2
    //   26: monitorexit
    //   27: lload_2
    //   28: lreturn
    //   29: aload_0
    //   30: invokestatic 33	cn/sharesdk/framework/statistics/a/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a/b;
    //   33: astore_0
    //   34: new 35	android/content/ContentValues
    //   37: dup
    //   38: invokespecial 38	android/content/ContentValues:<init>	()V
    //   41: astore 4
    //   43: aload 4
    //   45: ldc 40
    //   47: lload_2
    //   48: invokestatic 46	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: invokevirtual 50	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   54: aload 4
    //   56: ldc 52
    //   58: aload_1
    //   59: invokevirtual 55	java/lang/String:toString	()Ljava/lang/String;
    //   62: invokevirtual 58	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: ldc 60
    //   68: aload 4
    //   70: invokevirtual 63	cn/sharesdk/framework/statistics/a/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)J
    //   73: lstore_2
    //   74: goto -50 -> 24
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    //   0	83	1	paramString	String
    //   0	83	2	paramLong	long
    //   11	58	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	13	77	finally
    //   29	74	77	finally
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
        i = b.a(paramContext).a("message", "_id in ( " + paramArrayList + " )", null);
        cn.sharesdk.framework.utils.d.a().i("delete COUNT == %s", new Object[] { Integer.valueOf(i) });
        l = i;
      }
      finally {}
    }
  }
  
  /* Error */
  public static ArrayList<d> a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 33	cn/sharesdk/framework/statistics/a/b:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a/b;
    //   7: ldc 60
    //   9: invokevirtual 124	cn/sharesdk/framework/statistics/a/b:a	(Ljava/lang/String;)I
    //   12: ifle +15 -> 27
    //   15: aload_0
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokestatic 127	cn/sharesdk/framework/statistics/a/e:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: new 69	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 128	java/util/ArrayList:<init>	()V
    //   34: astore_0
    //   35: goto -13 -> 22
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	22	38	finally
    //   27	35	38	finally
  }
  
  private static ArrayList<d> a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        d locald = new d();
        StringBuilder localStringBuilder = new StringBuilder();
        paramArrayOfString = b.a(paramContext).a("message", new String[] { "_id", "post_time", "message_data" }, paramString, paramArrayOfString, null);
        paramContext = localStringBuilder;
        paramString = locald;
        if ((paramArrayOfString == null) || (!paramArrayOfString.moveToNext())) {
          break;
        }
        paramString.b.add(paramArrayOfString.getString(0));
        if (paramString.b.size() == 100)
        {
          paramContext.append(paramArrayOfString.getString(2));
          paramString.a = paramContext.toString();
          localArrayList.add(paramString);
          paramString = new d();
          paramContext = new StringBuilder();
        }
        else
        {
          paramContext.append(paramArrayOfString.getString(2) + "\n");
        }
      }
      finally {}
    }
    paramArrayOfString.close();
    if (paramString.b.size() != 0)
    {
      paramString.a = paramContext.toString().substring(0, paramContext.length() - 1);
      localArrayList.add(paramString);
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */