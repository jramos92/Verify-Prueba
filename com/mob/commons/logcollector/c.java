package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper.NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

public class c
  extends SSDKHandlerThread
{
  private static c a;
  private static String b = "http://api.exc.mob.com:80";
  private HashMap<String, Integer> c;
  private Context d;
  private DeviceHelper e;
  private NetworkHelper f;
  private d g;
  private File h;
  private FileLocker i;
  
  private c(Context paramContext)
  {
    super("MOB_LOGGER");
    this.d = paramContext.getApplicationContext();
    this.f = new NetworkHelper();
    this.e = DeviceHelper.getInstance(paramContext);
    this.g = d.a(paramContext);
    this.c = new HashMap();
    this.i = new FileLocker();
    this.h = new File(paramContext.getFilesDir(), ".lock");
    if (!this.h.exists()) {}
    try
    {
      this.h.createNewFile();
      NLog.setContext(paramContext);
      startThread();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MobLog.getInstance().w(localException);
      }
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int j = paramString.read(arrayOfByte, 0, 1024);
      if (j == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, j);
    }
    ((GZIPOutputStream)localObject).flush();
    ((GZIPOutputStream)localObject).close();
    localObject = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramString.close();
    return Base64.encodeToString((byte[])localObject, 2);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      if (!this.g.b()) {
        return;
      }
      if ("none".equals(this.e.getDetailNetworkTypeForStatic())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString1)
    {
      MobLog.getInstance().w(paramString1);
      return;
    }
    paramArrayOfString = f.a(this.d, paramArrayOfString);
    int j = 0;
    while (j < paramArrayOfString.size())
    {
      e locale = (e)paramArrayOfString.get(j);
      HashMap localHashMap = c(paramInt, paramString1, paramString2);
      localHashMap.put("errmsg", locale.a);
      if (a(a(new Hashon().fromHashMap(localHashMap)), true)) {
        f.a(this.d, locale.b);
      }
      j += 1;
    }
  }
  
  private void a(Message paramMessage)
  {
    this.handler.sendMessageDelayed(paramMessage, 1000L);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ("none".equals(this.e.getDetailNetworkTypeForStatic())) {
        throw new IllegalStateException("network is disconnected!");
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("m", paramString));
    paramString = new NetworkHelper.NetworkTimeOut();
    paramString.readTimout = 10000;
    paramString.connectionTimeout = 10000;
    this.f.httpPost(c(), localArrayList, null, null, paramString);
    return true;
  }
  
  private String b()
  {
    return b + "/errconf";
  }
  
  /* Error */
  private void b(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 193	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 246	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: new 248	com/mob/tools/network/KVPair
    //   14: dup
    //   15: ldc_w 287
    //   18: aload_3
    //   19: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   22: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: aload 9
    //   28: new 248	com/mob/tools/network/KVPair
    //   31: dup
    //   32: ldc_w 289
    //   35: aload_2
    //   36: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   39: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload 9
    //   45: new 248	com/mob/tools/network/KVPair
    //   48: dup
    //   49: ldc_w 291
    //   52: aload_0
    //   53: getfield 61	com/mob/commons/logcollector/c:e	Lcom/mob/tools/utils/DeviceHelper;
    //   56: invokevirtual 294	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
    //   59: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 9
    //   68: new 248	com/mob/tools/network/KVPair
    //   71: dup
    //   72: ldc_w 296
    //   75: aload_0
    //   76: getfield 61	com/mob/commons/logcollector/c:e	Lcom/mob/tools/utils/DeviceHelper;
    //   79: invokevirtual 299	com/mob/tools/utils/DeviceHelper:getAppVersion	()I
    //   82: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload 9
    //   94: new 248	com/mob/tools/network/KVPair
    //   97: dup
    //   98: ldc_w 305
    //   101: iload_1
    //   102: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   108: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   111: pop
    //   112: aload 9
    //   114: new 248	com/mob/tools/network/KVPair
    //   117: dup
    //   118: ldc_w 307
    //   121: aload_0
    //   122: getfield 61	com/mob/commons/logcollector/c:e	Lcom/mob/tools/utils/DeviceHelper;
    //   125: invokevirtual 310	com/mob/tools/utils/DeviceHelper:getPlatformCode	()I
    //   128: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   131: invokespecial 253	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   134: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: new 258	com/mob/tools/network/NetworkHelper$NetworkTimeOut
    //   141: dup
    //   142: invokespecial 259	com/mob/tools/network/NetworkHelper$NetworkTimeOut:<init>	()V
    //   145: astore_2
    //   146: aload_2
    //   147: sipush 10000
    //   150: putfield 263	com/mob/tools/network/NetworkHelper$NetworkTimeOut:readTimout	I
    //   153: aload_2
    //   154: sipush 10000
    //   157: putfield 266	com/mob/tools/network/NetworkHelper$NetworkTimeOut:connectionTimeout	I
    //   160: aload_0
    //   161: getfield 53	com/mob/commons/logcollector/c:f	Lcom/mob/tools/network/NetworkHelper;
    //   164: aload_0
    //   165: invokespecial 312	com/mob/commons/logcollector/c:b	()Ljava/lang/String;
    //   168: aload 9
    //   170: aconst_null
    //   171: aconst_null
    //   172: aload_2
    //   173: invokevirtual 272	com/mob/tools/network/NetworkHelper:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/network/KVPair;Ljava/util/ArrayList;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/lang/String;
    //   176: astore_2
    //   177: invokestatic 111	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   180: ldc_w 314
    //   183: iconst_1
    //   184: anewarray 316	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: aastore
    //   191: invokevirtual 319	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   194: pop
    //   195: new 217	com/mob/tools/utils/Hashon
    //   198: dup
    //   199: invokespecial 218	com/mob/tools/utils/Hashon:<init>	()V
    //   202: aload_2
    //   203: invokevirtual 323	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   206: astore_2
    //   207: ldc_w 325
    //   210: aload_2
    //   211: ldc_w 327
    //   214: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   220: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +18 -> 241
    //   226: invokestatic 111	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   229: ldc_w 335
    //   232: iconst_0
    //   233: anewarray 316	java/lang/Object
    //   236: invokevirtual 319	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   239: pop
    //   240: return
    //   241: aload_2
    //   242: ldc_w 337
    //   245: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: astore_2
    //   249: aload_2
    //   250: ifnull +387 -> 637
    //   253: aload_2
    //   254: instanceof 70
    //   257: ifeq +380 -> 637
    //   260: aload_2
    //   261: checkcast 70	java/util/HashMap
    //   264: astore_2
    //   265: aload_2
    //   266: ldc_w 339
    //   269: invokevirtual 342	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   272: istore 4
    //   274: iload 4
    //   276: ifeq +35 -> 311
    //   279: aload_2
    //   280: ldc_w 339
    //   283: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   289: invokestatic 348	com/mob/tools/utils/R:parseLong	(Ljava/lang/String;)J
    //   292: lstore 5
    //   294: invokestatic 354	java/lang/System:currentTimeMillis	()J
    //   297: lstore 7
    //   299: aload_0
    //   300: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   303: lload 7
    //   305: lload 5
    //   307: lsub
    //   308: invokevirtual 357	com/mob/commons/logcollector/d:a	(J)V
    //   311: ldc_w 359
    //   314: aload_2
    //   315: ldc_w 361
    //   318: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   321: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   324: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +299 -> 626
    //   330: aload_0
    //   331: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   334: iconst_1
    //   335: invokevirtual 364	com/mob/commons/logcollector/d:a	(Z)V
    //   338: aload_2
    //   339: ldc_w 366
    //   342: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   345: astore_3
    //   346: aload_3
    //   347: ifnull +98 -> 445
    //   350: aload_3
    //   351: instanceof 70
    //   354: ifeq +91 -> 445
    //   357: aload_3
    //   358: checkcast 70	java/util/HashMap
    //   361: astore 10
    //   363: aload 10
    //   365: ldc_w 368
    //   368: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   374: astore_3
    //   375: aload 10
    //   377: ldc_w 370
    //   380: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   386: astore 9
    //   388: aload 10
    //   390: ldc_w 372
    //   393: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   396: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   399: astore 10
    //   401: aload_0
    //   402: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   405: ldc_w 359
    //   408: aload_3
    //   409: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   412: invokevirtual 374	com/mob/commons/logcollector/d:b	(Z)V
    //   415: aload_0
    //   416: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   419: ldc_w 359
    //   422: aload 9
    //   424: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: invokevirtual 376	com/mob/commons/logcollector/d:c	(Z)V
    //   430: aload_0
    //   431: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   434: ldc_w 359
    //   437: aload 10
    //   439: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: invokevirtual 378	com/mob/commons/logcollector/d:d	(Z)V
    //   445: aload_2
    //   446: ldc_w 380
    //   449: invokevirtual 342	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   452: ifeq +85 -> 537
    //   455: aload_2
    //   456: ldc_w 382
    //   459: invokevirtual 342	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   462: ifeq +75 -> 537
    //   465: aload_2
    //   466: ldc_w 380
    //   469: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   475: astore_3
    //   476: aload_2
    //   477: ldc_w 382
    //   480: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   483: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   486: astore 9
    //   488: aload_3
    //   489: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   492: ifne +45 -> 537
    //   495: aload 9
    //   497: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   500: ifne +37 -> 537
    //   503: new 274	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 390
    //   513: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 392
    //   523: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload 9
    //   528: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: putstatic 29	com/mob/commons/logcollector/c:b	Ljava/lang/String;
    //   537: aload_2
    //   538: ldc_w 394
    //   541: invokevirtual 330	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   544: astore_2
    //   545: aload_2
    //   546: ifnull +91 -> 637
    //   549: aload_2
    //   550: instanceof 193
    //   553: ifeq +84 -> 637
    //   556: aload_2
    //   557: checkcast 193	java/util/ArrayList
    //   560: astore_2
    //   561: aload_2
    //   562: invokevirtual 197	java/util/ArrayList:size	()I
    //   565: ifle +72 -> 637
    //   568: new 70	java/util/HashMap
    //   571: dup
    //   572: invokespecial 71	java/util/HashMap:<init>	()V
    //   575: astore_3
    //   576: aload_3
    //   577: ldc_w 396
    //   580: aload_2
    //   581: invokevirtual 215	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   584: pop
    //   585: aload_0
    //   586: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   589: new 217	com/mob/tools/utils/Hashon
    //   592: dup
    //   593: invokespecial 218	com/mob/tools/utils/Hashon:<init>	()V
    //   596: aload_3
    //   597: invokevirtual 222	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   600: invokevirtual 398	com/mob/commons/logcollector/d:a	(Ljava/lang/String;)V
    //   603: return
    //   604: astore_2
    //   605: invokestatic 111	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   608: aload_2
    //   609: invokevirtual 115	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   612: pop
    //   613: return
    //   614: astore_3
    //   615: invokestatic 111	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   618: aload_3
    //   619: invokevirtual 115	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   622: pop
    //   623: goto -312 -> 311
    //   626: aload_0
    //   627: getfield 68	com/mob/commons/logcollector/c:g	Lcom/mob/commons/logcollector/d;
    //   630: iconst_0
    //   631: invokevirtual 364	com/mob/commons/logcollector/d:a	(Z)V
    //   634: goto -296 -> 338
    //   637: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	c
    //   0	638	1	paramInt	int
    //   0	638	2	paramString1	String
    //   0	638	3	paramString2	String
    //   272	3	4	bool	boolean
    //   292	14	5	l1	long
    //   297	7	7	l2	long
    //   7	520	9	localObject1	Object
    //   361	77	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   138	240	604	java/lang/Throwable
    //   241	249	604	java/lang/Throwable
    //   253	274	604	java/lang/Throwable
    //   311	338	604	java/lang/Throwable
    //   338	346	604	java/lang/Throwable
    //   350	445	604	java/lang/Throwable
    //   445	537	604	java/lang/Throwable
    //   537	545	604	java/lang/Throwable
    //   549	603	604	java/lang/Throwable
    //   615	623	604	java/lang/Throwable
    //   626	634	604	java/lang/Throwable
    //   279	311	614	java/lang/Throwable
  }
  
  private void b(Message paramMessage)
  {
    try
    {
      int j = paramMessage.arg1;
      Object localObject = (Object[])paramMessage.obj;
      paramMessage = (String)localObject[0];
      localObject = (String)localObject[1];
      b(j, paramMessage, (String)localObject);
      a(j, paramMessage, (String)localObject, null);
      return;
    }
    catch (Throwable paramMessage)
    {
      MobLog.getInstance().w(paramMessage);
    }
  }
  
  private String c()
  {
    return b + "/errlog";
  }
  
  private HashMap<String, Object> c(int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key", paramString2);
    localHashMap.put("plat", Integer.valueOf(this.e.getPlatformCode()));
    localHashMap.put("sdk", paramString1);
    localHashMap.put("sdkver", Integer.valueOf(paramInt));
    localHashMap.put("appname", this.e.getAppName());
    localHashMap.put("apppkg", this.e.getPackageName());
    localHashMap.put("appver", String.valueOf(this.e.getAppVersion()));
    localHashMap.put("deviceid", this.e.getDeviceKey());
    localHashMap.put("model", this.e.getModel());
    localHashMap.put("mac", this.e.getMacAddress());
    localHashMap.put("udid", this.e.getDeviceId());
    localHashMap.put("sysver", String.valueOf(this.e.getOSVersionInt()));
    localHashMap.put("networktype", this.e.getDetailNetworkTypeForStatic());
    return localHashMap;
  }
  
  private void c(Message paramMessage)
  {
    int k;
    String str2;
    int j;
    Object localObject2;
    try
    {
      k = paramMessage.arg1;
      Object localObject1 = (Object[])paramMessage.obj;
      String str1 = (String)localObject1[0];
      str2 = (String)localObject1[1];
      localObject1 = (String)localObject1[2];
      if (paramMessage.arg2 == 0) {}
      for (j = 2;; j = 1)
      {
        localObject2 = this.g.f();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject2 = (ArrayList)new Hashon().fromJson((String)localObject2).get("fakelist");
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        String str3;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str3 = (String)((Iterator)localObject2).next();
        } while ((TextUtils.isEmpty(str3)) || (!((String)localObject1).contains(str3)));
        return;
        if (paramMessage.arg2 != 2) {
          break label445;
        }
      }
      localObject2 = Data.MD5((String)localObject1);
      long l1;
      long l2;
      j = ((Integer)this.c.get(localObject2)).intValue();
    }
    catch (Throwable paramMessage)
    {
      try
      {
        this.i.setLockFile(this.h.getAbsolutePath());
        if (this.i.lock(false))
        {
          l1 = System.currentTimeMillis();
          l2 = this.g.a();
          f.a(this.d, l1 - l2, (String)localObject1, j, (String)localObject2);
        }
        this.i.release();
        this.c.remove(localObject2);
        if ((3 != j) || (!this.g.e())) {
          break label363;
        }
        a(k, str1, str2, new String[] { String.valueOf(3) });
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!this.c.containsKey(localObject2)) {
          break label451;
        }
      }
      paramMessage = paramMessage;
      MobLog.getInstance().w(paramMessage);
      return;
    }
    for (;;)
    {
      j += 1;
      this.c.put(localObject2, Integer.valueOf(j));
      if (j < 3)
      {
        a(paramMessage);
        return;
      }
      MobLog.getInstance().w(localThrowable);
      return;
      label363:
      if ((1 == j) && (this.g.c()))
      {
        a(k, localThrowable, str2, new String[] { String.valueOf(1) });
        Process.killProcess(Process.myPid());
        System.exit(0);
        return;
      }
      if ((2 == j) && (this.g.d()))
      {
        a(k, localThrowable, str2, new String[] { String.valueOf(2) });
        return;
        label445:
        j = 1;
        break;
      }
      return;
      label451:
      j = 0;
    }
  }
  
  public Context a()
  {
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = new Object[] { paramString1, paramString2, paramString3 };
    this.handler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 100;
    localMessage.arg1 = paramInt;
    localMessage.obj = new Object[] { paramString1, paramString2 };
    this.handler.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    try
    {
      this.handler.wait();
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  protected void onMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      b(paramMessage);
      return;
    }
    c(paramMessage);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\commons\logcollector\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */