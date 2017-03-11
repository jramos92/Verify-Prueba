package cn.sharesdk.framework.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.LocalDB;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class NewAppReceiver
  extends BroadcastReceiver
  implements Handler.Callback
{
  private static final String[] a = { "android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED" };
  private static NewAppReceiver b;
  private Context c;
  private IntentFilter[] d;
  private Handler e;
  
  private NewAppReceiver(Context paramContext)
  {
    this.c = paramContext;
    this.d = new IntentFilter[] { new IntentFilter(), new IntentFilter() };
    this.d[0].addAction("cn.sharesdk.START_UP");
    paramContext = a;
    int j = paramContext.length;
    while (i < j)
    {
      String str = paramContext[i];
      this.d[1].addAction(str);
      i += 1;
    }
    this.d[1].addDataScheme("package");
    this.e = new Handler(this);
    this.e.sendEmptyMessage(1);
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +15 -> 23
    //   11: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   14: getfield 41	cn/sharesdk/framework/statistics/NewAppReceiver:c	Landroid/content/Context;
    //   17: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   20: invokevirtual 78	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: astore_0
    //   28: invokestatic 83	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
    //   31: aload_0
    //   32: invokevirtual 88	com/mob/tools/log/NLog:d	(Ljava/lang/Throwable;)I
    //   35: pop
    //   36: goto -13 -> 23
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localNewAppReceiver	NewAppReceiver
    //   27	5	0	localThrowable	Throwable
    //   39	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	23	27	java/lang/Throwable
    //   3	7	39	finally
    //   11	23	39	finally
    //   28	36	39	finally
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	cn/sharesdk/framework/statistics/NewAppReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 90	cn/sharesdk/framework/statistics/NewAppReceiver:<init>	(Landroid/content/Context;)V
    //   17: putstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   20: invokestatic 92	cn/sharesdk/framework/statistics/NewAppReceiver:a	()V
    //   23: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   26: getfield 46	cn/sharesdk/framework/statistics/NewAppReceiver:d	[Landroid/content/IntentFilter;
    //   29: astore_3
    //   30: aload_3
    //   31: arraylength
    //   32: istore_2
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: iload_2
    //   37: if_icmpge +34 -> 71
    //   40: aload_3
    //   41: iload_1
    //   42: aaload
    //   43: astore 4
    //   45: aload_0
    //   46: getstatic 72	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   49: aload 4
    //   51: invokevirtual 96	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   54: pop
    //   55: iload_1
    //   56: iconst_1
    //   57: iadd
    //   58: istore_1
    //   59: goto -24 -> 35
    //   62: astore_0
    //   63: invokestatic 83	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
    //   66: aload_0
    //   67: invokevirtual 99	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   70: pop
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: astore_0
    //   76: ldc 2
    //   78: monitorexit
    //   79: aload_0
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramContext	Context
    //   34	25	1	i	int
    //   32	6	2	j	int
    //   29	12	3	arrayOfIntentFilter	IntentFilter[]
    //   43	7	4	localIntentFilter	IntentFilter
    // Exception table:
    //   from	to	target	type
    //   23	33	62	java/lang/Throwable
    //   45	55	62	java/lang/Throwable
    //   3	20	75	finally
    //   20	23	75	finally
    //   23	33	75	finally
    //   45	55	75	finally
    //   63	71	75	finally
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b.a(this.c);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getAction();
    }
    int i;
    if ("cn.sharesdk.START_UP".equals(str))
    {
      paramContext = DeviceHelper.getInstance(paramContext).getPackageName();
      paramIntent = paramIntent.getStringExtra("packageName");
      if ((paramIntent == null) || (!paramIntent.equals(paramContext))) {
        break label122;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        d.a().d("========= receive broadcast: " + str, new Object[0]);
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 60000L);
      }
      return;
      if (a(str)) {
        i = 1;
      } else {
        label122:
        i = 0;
      }
    }
  }
  
  private static class a
  {
    private LocalDB a;
    
    public a(Context paramContext)
    {
      try
      {
        Object localObject = DeviceHelper.getInstance(paramContext);
        paramContext = R.getCachePath(paramContext, null);
        if (((DeviceHelper)localObject).getSdcardState())
        {
          localObject = new File(((DeviceHelper)localObject).getSdcardPath(), "ShareSDK");
          if (((File)localObject).exists())
          {
            this.a = new LocalDB();
            paramContext = new File((File)localObject, ".ba");
            this.a.open(paramContext.getAbsolutePath());
            return;
          }
        }
        this.a = new LocalDB();
        paramContext = new File(paramContext, ".ba");
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
        this.a.open(paramContext.getAbsolutePath());
        return;
      }
      catch (Exception paramContext)
      {
        d.a().w(paramContext);
        if (this.a == null) {
          this.a = new LocalDB();
        }
      }
    }
    
    public ArrayList<HashMap<String, String>> a()
    {
      Object localObject = this.a.getObject("buffered_apps");
      if (localObject == null) {
        return new ArrayList();
      }
      return (ArrayList)localObject;
    }
    
    public void a(long paramLong)
    {
      this.a.putLong("buffered_apps_time", Long.valueOf(paramLong));
    }
    
    public void a(ArrayList<HashMap<String, String>> paramArrayList)
    {
      this.a.putObject("buffered_apps", paramArrayList);
    }
    
    public long b()
    {
      return this.a.getLong("buffered_apps_time");
    }
  }
  
  private static class b
    extends Thread
  {
    private Context a;
    private NewAppReceiver.a b;
    
    private b(Context paramContext)
    {
      this.a = paramContext;
      this.b = new NewAppReceiver.a(paramContext);
    }
    
    private ArrayList<HashMap<String, String>> a(HashMap<String, HashMap<String, String>> paramHashMap)
    {
      ArrayList localArrayList = new ArrayList();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext()) {
        localArrayList.add(((Map.Entry)paramHashMap.next()).getValue());
      }
      return localArrayList;
    }
    
    private HashMap<String, HashMap<String, String>> a(ArrayList<HashMap<String, String>> paramArrayList)
    {
      HashMap localHashMap1 = new HashMap();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        HashMap localHashMap2 = (HashMap)paramArrayList.next();
        String str = (String)localHashMap2.get("pkg");
        if (!TextUtils.isEmpty(str)) {
          localHashMap1.put(str, localHashMap2);
        }
      }
      return localHashMap1;
    }
    
    public static void a(Context paramContext)
    {
      new b(paramContext).start();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   4: invokestatic 96	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
      //   7: astore_2
      //   8: aload_2
      //   9: iconst_0
      //   10: invokevirtual 100	com/mob/tools/utils/DeviceHelper:getInstalledApp	(Z)Ljava/util/ArrayList;
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   18: invokevirtual 103	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	()Ljava/util/ArrayList;
      //   21: astore 4
      //   23: aload_0
      //   24: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   27: aload_3
      //   28: invokevirtual 106	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	(Ljava/util/ArrayList;)V
      //   31: aload_0
      //   32: aload_3
      //   33: invokespecial 108	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   36: astore 6
      //   38: aload_0
      //   39: aload 4
      //   41: invokespecial 108	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   44: astore 5
      //   46: aload 4
      //   48: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   51: astore 7
      //   53: aload 7
      //   55: invokeinterface 46 1 0
      //   60: ifeq +42 -> 102
      //   63: aload 7
      //   65: invokeinterface 50 1 0
      //   70: checkcast 30	java/util/HashMap
      //   73: ldc 66
      //   75: invokevirtual 70	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   78: checkcast 72	java/lang/String
      //   81: astore 8
      //   83: aload 8
      //   85: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   88: ifne -35 -> 53
      //   91: aload 6
      //   93: aload 8
      //   95: invokevirtual 111	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   98: pop
      //   99: goto -46 -> 53
      //   102: aload_3
      //   103: invokevirtual 64	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   106: astore 7
      //   108: aload 7
      //   110: invokeinterface 46 1 0
      //   115: ifeq +42 -> 157
      //   118: aload 7
      //   120: invokeinterface 50 1 0
      //   125: checkcast 30	java/util/HashMap
      //   128: ldc 66
      //   130: invokevirtual 70	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   133: checkcast 72	java/lang/String
      //   136: astore 8
      //   138: aload 8
      //   140: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   143: ifne -35 -> 108
      //   146: aload 5
      //   148: aload 8
      //   150: invokevirtual 111	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   153: pop
      //   154: goto -46 -> 108
      //   157: aload_0
      //   158: aload 6
      //   160: invokespecial 113	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   163: astore 6
      //   165: aload_0
      //   166: aload 5
      //   168: invokespecial 113	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   171: astore 5
      //   173: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   176: aload_0
      //   177: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   180: invokevirtual 121	cn/sharesdk/framework/statistics/NewAppReceiver$a:b	()J
      //   183: lsub
      //   184: ldc2_w 122
      //   187: lcmp
      //   188: iflt +106 -> 294
      //   191: iconst_1
      //   192: istore_1
      //   193: iload_1
      //   194: ifne +11 -> 205
      //   197: aload 4
      //   199: invokevirtual 127	java/util/ArrayList:size	()I
      //   202: ifgt +109 -> 311
      //   205: aload_0
      //   206: getfield 23	cn/sharesdk/framework/statistics/NewAppReceiver$b:b	Lcn/sharesdk/framework/statistics/NewAppReceiver$a;
      //   209: invokestatic 119	java/lang/System:currentTimeMillis	()J
      //   212: invokevirtual 130	cn/sharesdk/framework/statistics/NewAppReceiver$a:a	(J)V
      //   215: aload_0
      //   216: aload_0
      //   217: aload_3
      //   218: invokespecial 108	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/ArrayList;)Ljava/util/HashMap;
      //   221: invokespecial 113	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	(Ljava/util/HashMap;)Ljava/util/ArrayList;
      //   224: astore_3
      //   225: aload_0
      //   226: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   229: invokestatic 135	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a;
      //   232: ldc -119
      //   234: aload_3
      //   235: invokevirtual 140	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   238: aload 5
      //   240: invokevirtual 127	java/util/ArrayList:size	()I
      //   243: ifle +50 -> 293
      //   246: invokestatic 145	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
      //   249: new 147	java/lang/StringBuilder
      //   252: dup
      //   253: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   256: ldc -106
      //   258: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   261: aload_2
      //   262: invokevirtual 158	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
      //   265: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   268: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   271: iconst_0
      //   272: anewarray 163	java/lang/Object
      //   275: invokevirtual 169	com/mob/tools/log/NLog:d	(Ljava/lang/Object;[Ljava/lang/Object;)I
      //   278: pop
      //   279: aload_0
      //   280: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   283: invokestatic 135	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a;
      //   286: ldc -85
      //   288: aload 5
      //   290: invokevirtual 140	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   293: return
      //   294: iconst_0
      //   295: istore_1
      //   296: goto -103 -> 193
      //   299: astore_3
      //   300: invokestatic 145	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
      //   303: aload_3
      //   304: invokevirtual 175	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
      //   307: pop
      //   308: goto -70 -> 238
      //   311: aload 6
      //   313: invokevirtual 127	java/util/ArrayList:size	()I
      //   316: ifle -78 -> 238
      //   319: invokestatic 145	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
      //   322: new 147	java/lang/StringBuilder
      //   325: dup
      //   326: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   329: ldc -79
      //   331: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   334: aload_2
      //   335: invokevirtual 158	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
      //   338: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   341: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   344: iconst_0
      //   345: anewarray 163	java/lang/Object
      //   348: invokevirtual 169	com/mob/tools/log/NLog:d	(Ljava/lang/Object;[Ljava/lang/Object;)I
      //   351: pop
      //   352: aload_0
      //   353: getfield 17	cn/sharesdk/framework/statistics/NewAppReceiver$b:a	Landroid/content/Context;
      //   356: invokestatic 135	cn/sharesdk/framework/statistics/a:a	(Landroid/content/Context;)Lcn/sharesdk/framework/statistics/a;
      //   359: ldc -77
      //   361: aload 6
      //   363: invokevirtual 140	cn/sharesdk/framework/statistics/a:a	(Ljava/lang/String;Ljava/util/ArrayList;)V
      //   366: goto -128 -> 238
      //   369: astore_3
      //   370: invokestatic 145	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
      //   373: aload_3
      //   374: invokevirtual 175	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
      //   377: pop
      //   378: goto -140 -> 238
      //   381: astore_2
      //   382: invokestatic 145	cn/sharesdk/framework/utils/d:a	()Lcom/mob/tools/log/NLog;
      //   385: aload_2
      //   386: invokevirtual 175	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
      //   389: pop
      //   390: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	391	0	this	b
      //   192	104	1	i	int
      //   7	328	2	localDeviceHelper	DeviceHelper
      //   381	5	2	localThrowable1	Throwable
      //   13	222	3	localArrayList1	ArrayList
      //   299	5	3	localThrowable2	Throwable
      //   369	5	3	localThrowable3	Throwable
      //   21	177	4	localArrayList2	ArrayList
      //   44	245	5	localObject1	Object
      //   36	326	6	localObject2	Object
      //   51	68	7	localIterator	Iterator
      //   81	68	8	str	String
      // Exception table:
      //   from	to	target	type
      //   215	238	299	java/lang/Throwable
      //   352	366	369	java/lang/Throwable
      //   279	293	381	java/lang/Throwable
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\NewAppReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */