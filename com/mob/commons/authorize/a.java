package com.mob.commons.authorize;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.HashMap;

public final class a
{
  /* Error */
  private final String a(Context paramContext, MobProduct paramMobProduct, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 19	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   4: astore 6
    //   6: aload 6
    //   8: invokevirtual 23	com/mob/tools/utils/DeviceHelper:getCarrier	()Ljava/lang/String;
    //   11: invokestatic 29	com/mob/tools/utils/R:parseInt	(Ljava/lang/String;)I
    //   14: istore 5
    //   16: new 31	java/util/HashMap
    //   19: dup
    //   20: invokespecial 32	java/util/HashMap:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 34
    //   27: aload 6
    //   29: invokevirtual 37	com/mob/tools/utils/DeviceHelper:getAdvertisingID	()Ljava/lang/String;
    //   32: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: aload_2
    //   37: ldc 43
    //   39: aload 6
    //   41: invokevirtual 46	com/mob/tools/utils/DeviceHelper:getIMEI	()Ljava/lang/String;
    //   44: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload_2
    //   49: ldc 48
    //   51: aload 6
    //   53: invokevirtual 51	com/mob/tools/utils/DeviceHelper:getSerialno	()Ljava/lang/String;
    //   56: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload_2
    //   61: ldc 53
    //   63: aload 6
    //   65: invokevirtual 56	com/mob/tools/utils/DeviceHelper:getAndroidID	()Ljava/lang/String;
    //   68: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_2
    //   73: ldc 58
    //   75: aload 6
    //   77: invokevirtual 61	com/mob/tools/utils/DeviceHelper:getMacAddress	()Ljava/lang/String;
    //   80: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_2
    //   85: ldc 63
    //   87: aload 6
    //   89: invokevirtual 66	com/mob/tools/utils/DeviceHelper:getModel	()Ljava/lang/String;
    //   92: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_2
    //   97: ldc 68
    //   99: aload 6
    //   101: invokevirtual 71	com/mob/tools/utils/DeviceHelper:getManufacturer	()Ljava/lang/String;
    //   104: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_2
    //   109: ldc 73
    //   111: iload 5
    //   113: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_2
    //   121: ldc 81
    //   123: aload 6
    //   125: invokevirtual 84	com/mob/tools/utils/DeviceHelper:getScreenSize	()Ljava/lang/String;
    //   128: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: pop
    //   132: aload_2
    //   133: ldc 86
    //   135: aload 6
    //   137: invokevirtual 89	com/mob/tools/utils/DeviceHelper:getOSVersionName	()Ljava/lang/String;
    //   140: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: aload_2
    //   145: ldc 91
    //   147: iconst_1
    //   148: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: new 93	com/mob/tools/utils/Hashon
    //   158: dup
    //   159: invokespecial 94	com/mob/tools/utils/Hashon:<init>	()V
    //   162: astore 6
    //   164: ldc 96
    //   166: aload 6
    //   168: aload_2
    //   169: invokevirtual 100	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   172: invokestatic 106	com/mob/tools/utils/Data:AES128Encode	(Ljava/lang/String;Ljava/lang/String;)[B
    //   175: iconst_2
    //   176: invokestatic 112	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   179: astore 7
    //   181: new 114	java/util/ArrayList
    //   184: dup
    //   185: invokespecial 115	java/util/ArrayList:<init>	()V
    //   188: astore 8
    //   190: aload 8
    //   192: new 117	com/mob/tools/network/KVPair
    //   195: dup
    //   196: ldc 119
    //   198: aload 7
    //   200: invokespecial 122	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   203: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   206: pop
    //   207: aload 6
    //   209: new 128	com/mob/tools/network/NetworkHelper
    //   212: dup
    //   213: invokespecial 129	com/mob/tools/network/NetworkHelper:<init>	()V
    //   216: ldc -125
    //   218: aload 8
    //   220: aconst_null
    //   221: aconst_null
    //   222: aconst_null
    //   223: invokevirtual 135	com/mob/tools/network/NetworkHelper:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/network/KVPair;Ljava/util/ArrayList;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/lang/String;
    //   226: invokevirtual 139	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   229: astore 6
    //   231: aload 6
    //   233: ifnonnull +5 -> 238
    //   236: aconst_null
    //   237: areturn
    //   238: aload 6
    //   240: ldc -115
    //   242: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 147	java/lang/String
    //   248: astore 6
    //   250: aload 6
    //   252: ifnull +184 -> 436
    //   255: aload 6
    //   257: invokevirtual 151	java/lang/String:length	()I
    //   260: ifgt +6 -> 266
    //   263: goto +173 -> 436
    //   266: aload_3
    //   267: ldc -115
    //   269: aload 6
    //   271: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: aload_2
    //   276: ldc 73
    //   278: iload 5
    //   280: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   283: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload_3
    //   288: ldc -100
    //   290: aload_2
    //   291: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: iload 4
    //   297: ifeq +129 -> 426
    //   300: new 158	java/io/ObjectOutputStream
    //   303: dup
    //   304: new 160	java/io/FileOutputStream
    //   307: dup
    //   308: new 162	java/io/File
    //   311: dup
    //   312: aload_1
    //   313: invokestatic 166	com/mob/tools/utils/R:getCacheRoot	(Landroid/content/Context;)Ljava/lang/String;
    //   316: ldc -88
    //   318: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   324: invokespecial 177	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   327: astore_2
    //   328: aload_2
    //   329: astore_1
    //   330: aload_2
    //   331: aload_3
    //   332: invokevirtual 181	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   335: aload_2
    //   336: ifnull +90 -> 426
    //   339: aload_2
    //   340: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   343: aload_2
    //   344: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   347: aload 6
    //   349: areturn
    //   350: astore_1
    //   351: aload 6
    //   353: areturn
    //   354: astore_3
    //   355: aconst_null
    //   356: astore_2
    //   357: aload_2
    //   358: astore_1
    //   359: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   362: aload_3
    //   363: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   366: pop
    //   367: aload_2
    //   368: ifnull +58 -> 426
    //   371: aload_2
    //   372: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   375: aload_2
    //   376: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   379: aload 6
    //   381: areturn
    //   382: astore_1
    //   383: aload 6
    //   385: areturn
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_1
    //   389: aload_1
    //   390: ifnull +11 -> 401
    //   393: aload_1
    //   394: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   397: aload_1
    //   398: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   401: aload_2
    //   402: athrow
    //   403: astore_1
    //   404: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   407: aload_1
    //   408: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   411: pop
    //   412: aconst_null
    //   413: areturn
    //   414: astore_1
    //   415: goto -14 -> 401
    //   418: astore_2
    //   419: goto -30 -> 389
    //   422: astore_3
    //   423: goto -66 -> 357
    //   426: aload 6
    //   428: areturn
    //   429: astore_2
    //   430: iconst_m1
    //   431: istore 5
    //   433: goto -417 -> 16
    //   436: aconst_null
    //   437: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	a
    //   0	438	1	paramContext	Context
    //   0	438	2	paramMobProduct	MobProduct
    //   0	438	3	paramHashMap	HashMap<String, Object>
    //   0	438	4	paramBoolean	boolean
    //   14	418	5	i	int
    //   4	423	6	localObject	Object
    //   179	20	7	str	String
    //   188	31	8	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   339	347	350	java/lang/Throwable
    //   300	328	354	java/lang/Throwable
    //   371	379	382	java/lang/Throwable
    //   300	328	386	finally
    //   0	6	403	java/lang/Throwable
    //   16	231	403	java/lang/Throwable
    //   238	250	403	java/lang/Throwable
    //   255	263	403	java/lang/Throwable
    //   266	295	403	java/lang/Throwable
    //   401	403	403	java/lang/Throwable
    //   393	401	414	java/lang/Throwable
    //   330	335	418	finally
    //   359	367	418	finally
    //   330	335	422	java/lang/Throwable
    //   6	16	429	java/lang/Throwable
  }
  
  /* Error */
  private final void a(Context paramContext, MobProduct paramMobProduct, HashMap<String, Object> paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_3
    //   4: ldc -115
    //   6: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: checkcast 147	java/lang/String
    //   12: astore 5
    //   14: new 114	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 115	java/util/ArrayList:<init>	()V
    //   21: astore 6
    //   23: aload 6
    //   25: new 117	com/mob/tools/network/KVPair
    //   28: dup
    //   29: ldc -53
    //   31: aload_2
    //   32: invokeinterface 208 1 0
    //   37: invokespecial 122	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   40: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   43: pop
    //   44: aload 6
    //   46: new 117	com/mob/tools/network/KVPair
    //   49: dup
    //   50: ldc -46
    //   52: aload_2
    //   53: invokeinterface 213 1 0
    //   58: invokespecial 122	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   61: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload 6
    //   67: new 117	com/mob/tools/network/KVPair
    //   70: dup
    //   71: ldc -115
    //   73: aload 5
    //   75: invokespecial 122	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   78: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: new 128	com/mob/tools/network/NetworkHelper
    //   85: dup
    //   86: invokespecial 129	com/mob/tools/network/NetworkHelper:<init>	()V
    //   89: ldc -41
    //   91: aload 6
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: invokevirtual 135	com/mob/tools/network/NetworkHelper:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/network/KVPair;Ljava/util/ArrayList;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/lang/String;
    //   99: astore 5
    //   101: new 93	com/mob/tools/utils/Hashon
    //   104: dup
    //   105: invokespecial 94	com/mob/tools/utils/Hashon:<init>	()V
    //   108: aload 5
    //   110: invokevirtual 139	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   113: astore 5
    //   115: ldc -39
    //   117: aload 5
    //   119: ldc -37
    //   121: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +14 -> 144
    //   133: aload_0
    //   134: aload_1
    //   135: aload_2
    //   136: aload_3
    //   137: iconst_0
    //   138: invokespecial 227	com/mob/commons/authorize/a:a	(Landroid/content/Context;Lcom/mob/commons/authorize/MobProduct;Ljava/util/HashMap;Z)Ljava/lang/String;
    //   141: ifnull +3 -> 144
    //   144: ldc -27
    //   146: aload 5
    //   148: ldc -25
    //   150: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +88 -> 247
    //   162: aload_3
    //   163: ldc -23
    //   165: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 31	java/util/HashMap
    //   171: aload_1
    //   172: invokestatic 19	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   175: invokevirtual 236	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
    //   178: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 31	java/util/HashMap
    //   184: aload_2
    //   185: invokeinterface 208 1 0
    //   190: aload_2
    //   191: invokeinterface 213 1 0
    //   196: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: new 158	java/io/ObjectOutputStream
    //   203: dup
    //   204: new 160	java/io/FileOutputStream
    //   207: dup
    //   208: new 162	java/io/File
    //   211: dup
    //   212: aload_1
    //   213: invokestatic 166	com/mob/tools/utils/R:getCacheRoot	(Landroid/content/Context;)Ljava/lang/String;
    //   216: ldc -88
    //   218: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 177	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   227: astore_2
    //   228: aload_2
    //   229: astore_1
    //   230: aload_2
    //   231: aload_3
    //   232: invokevirtual 181	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   235: aload_2
    //   236: ifnull +11 -> 247
    //   239: aload_2
    //   240: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   243: aload_2
    //   244: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   247: return
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: astore_1
    //   253: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   256: aload_3
    //   257: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   260: pop
    //   261: aload_2
    //   262: ifnull -15 -> 247
    //   265: aload_2
    //   266: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   269: aload_2
    //   270: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   273: return
    //   274: astore_1
    //   275: return
    //   276: astore_1
    //   277: aload 4
    //   279: astore_2
    //   280: aload_2
    //   281: ifnull +11 -> 292
    //   284: aload_2
    //   285: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   288: aload_2
    //   289: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   292: aload_1
    //   293: athrow
    //   294: astore_1
    //   295: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   298: aload_1
    //   299: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   302: pop
    //   303: return
    //   304: astore_2
    //   305: goto -13 -> 292
    //   308: astore_3
    //   309: aload_1
    //   310: astore_2
    //   311: aload_3
    //   312: astore_1
    //   313: goto -33 -> 280
    //   316: astore_3
    //   317: goto -66 -> 251
    //   320: astore_1
    //   321: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	a
    //   0	322	1	paramContext	Context
    //   0	322	2	paramMobProduct	MobProduct
    //   0	322	3	paramHashMap	HashMap<String, Object>
    //   1	277	4	localObject1	Object
    //   12	135	5	localObject2	Object
    //   21	71	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   200	228	248	java/lang/Throwable
    //   265	273	274	java/lang/Throwable
    //   200	228	276	finally
    //   3	144	294	java/lang/Throwable
    //   144	200	294	java/lang/Throwable
    //   292	294	294	java/lang/Throwable
    //   284	292	304	java/lang/Throwable
    //   230	235	308	finally
    //   253	261	308	finally
    //   230	235	316	java/lang/Throwable
    //   239	247	320	java/lang/Throwable
  }
  
  private final boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  Object localObject2;
                  do
                  {
                    return true;
                    paramContext = DeviceHelper.getInstance(paramContext);
                    localObject1 = paramContext.getAdvertisingID();
                    localObject2 = paramHashMap.get("adsid");
                  } while ((localObject2 != localObject1) || ((localObject1 != null) && (!((String)localObject1).equals(localObject2))));
                  localObject1 = paramHashMap.get("imei");
                } while ((localObject1 == null) || (!localObject1.equals(paramContext.getIMEI())));
                localObject1 = paramHashMap.get("serialno");
              } while ((localObject1 == null) || (!localObject1.equals(paramContext.getSerialno())));
              localObject1 = paramHashMap.get("mac");
            } while ((localObject1 == null) || (!localObject1.equals(paramContext.getMacAddress())));
            localObject1 = paramHashMap.get("model");
          } while ((localObject1 == null) || (!localObject1.equals(paramContext.getModel())));
          localObject1 = paramHashMap.get("factory");
        } while ((localObject1 == null) || (!localObject1.equals(paramContext.getManufacturer())));
        localObject1 = paramHashMap.get("androidid");
      } while ((localObject1 == null) || (!localObject1.equals(paramContext.getAndroidID())));
      paramHashMap = paramHashMap.get("sysver");
    } while ((paramHashMap == null) || (!paramHashMap.equals(paramContext.getOSVersionName())));
    return false;
  }
  
  /* Error */
  private final String b(Context paramContext, MobProduct paramMobProduct)
  {
    // Byte code:
    //   0: new 162	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokestatic 166	com/mob/tools/utils/R:getCacheRoot	(Landroid/content/Context;)Ljava/lang/String;
    //   8: ldc -88
    //   10: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 246	java/io/File:exists	()Z
    //   20: ifeq +346 -> 366
    //   23: aload 4
    //   25: invokevirtual 249	java/io/File:isFile	()Z
    //   28: istore_3
    //   29: iload_3
    //   30: ifeq +336 -> 366
    //   33: new 251	java/io/ObjectInputStream
    //   36: dup
    //   37: new 253	java/io/FileInputStream
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 257	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore 5
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: invokevirtual 261	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   60: checkcast 31	java/util/HashMap
    //   63: astore 6
    //   65: aload 6
    //   67: astore 4
    //   69: aload 5
    //   71: ifnull +12 -> 83
    //   74: aload 5
    //   76: invokevirtual 262	java/io/ObjectInputStream:close	()V
    //   79: aload 6
    //   81: astore 4
    //   83: aload 4
    //   85: ifnonnull +335 -> 420
    //   88: aload_0
    //   89: aload_1
    //   90: aload_2
    //   91: invokespecial 266	com/mob/commons/authorize/a:c	(Landroid/content/Context;Lcom/mob/commons/authorize/MobProduct;)Ljava/util/HashMap;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +320 -> 418
    //   101: aload 5
    //   103: ldc -115
    //   105: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: checkcast 147	java/lang/String
    //   111: astore 4
    //   113: aload 4
    //   115: astore 6
    //   117: aload 4
    //   119: ifnull +173 -> 292
    //   122: aload_0
    //   123: aload_1
    //   124: aload 5
    //   126: ldc -100
    //   128: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 31	java/util/HashMap
    //   134: invokespecial 268	com/mob/commons/authorize/a:a	(Landroid/content/Context;Ljava/util/HashMap;)Z
    //   137: ifeq +278 -> 415
    //   140: aload_0
    //   141: aload_1
    //   142: aload_2
    //   143: aload 5
    //   145: iconst_1
    //   146: invokespecial 227	com/mob/commons/authorize/a:a	(Landroid/content/Context;Lcom/mob/commons/authorize/MobProduct;Ljava/util/HashMap;Z)Ljava/lang/String;
    //   149: astore 6
    //   151: aload 6
    //   153: ifnull +262 -> 415
    //   156: aload 6
    //   158: astore 4
    //   160: aload 5
    //   162: ldc -23
    //   164: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   167: checkcast 31	java/util/HashMap
    //   170: astore 6
    //   172: aload 6
    //   174: ifnonnull +238 -> 412
    //   177: new 31	java/util/HashMap
    //   180: dup
    //   181: invokespecial 32	java/util/HashMap:<init>	()V
    //   184: astore 6
    //   186: aload 5
    //   188: ldc -23
    //   190: aload 6
    //   192: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: aload_1
    //   197: invokestatic 19	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   200: invokevirtual 236	com/mob/tools/utils/DeviceHelper:getPackageName	()Ljava/lang/String;
    //   203: astore 9
    //   205: aload 6
    //   207: aload 9
    //   209: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   212: checkcast 31	java/util/HashMap
    //   215: astore 8
    //   217: aload 8
    //   219: astore 7
    //   221: aload 8
    //   223: ifnonnull +22 -> 245
    //   226: new 31	java/util/HashMap
    //   229: dup
    //   230: invokespecial 32	java/util/HashMap:<init>	()V
    //   233: astore 7
    //   235: aload 6
    //   237: aload 9
    //   239: aload 7
    //   241: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: aload 7
    //   247: aload_2
    //   248: invokeinterface 208 1 0
    //   253: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   256: checkcast 147	java/lang/String
    //   259: astore 6
    //   261: aload 6
    //   263: ifnull +17 -> 280
    //   266: aload 6
    //   268: aload_2
    //   269: invokeinterface 213 1 0
    //   274: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifne +11 -> 288
    //   280: aload_0
    //   281: aload_1
    //   282: aload_2
    //   283: aload 5
    //   285: invokespecial 270	com/mob/commons/authorize/a:a	(Landroid/content/Context;Lcom/mob/commons/authorize/MobProduct;Ljava/util/HashMap;)V
    //   288: aload 4
    //   290: astore 6
    //   292: aload 6
    //   294: areturn
    //   295: astore 6
    //   297: aconst_null
    //   298: astore 5
    //   300: aload 5
    //   302: astore 4
    //   304: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   307: aload 6
    //   309: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   312: pop
    //   313: aload 5
    //   315: ifnull +51 -> 366
    //   318: aload 5
    //   320: invokevirtual 262	java/io/ObjectInputStream:close	()V
    //   323: aconst_null
    //   324: astore 4
    //   326: goto -243 -> 83
    //   329: astore 4
    //   331: aconst_null
    //   332: astore 4
    //   334: goto -251 -> 83
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 4
    //   342: aload 4
    //   344: ifnull +8 -> 352
    //   347: aload 4
    //   349: invokevirtual 262	java/io/ObjectInputStream:close	()V
    //   352: aload 5
    //   354: athrow
    //   355: astore 4
    //   357: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   360: aload 4
    //   362: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   365: pop
    //   366: aconst_null
    //   367: astore 4
    //   369: goto -286 -> 83
    //   372: astore_1
    //   373: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   376: aload_1
    //   377: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   380: pop
    //   381: aload 4
    //   383: areturn
    //   384: astore 4
    //   386: aload 6
    //   388: astore 4
    //   390: goto -307 -> 83
    //   393: astore 4
    //   395: goto -43 -> 352
    //   398: astore_1
    //   399: goto -26 -> 373
    //   402: astore 5
    //   404: goto -62 -> 342
    //   407: astore 6
    //   409: goto -109 -> 300
    //   412: goto -216 -> 196
    //   415: goto -255 -> 160
    //   418: aconst_null
    //   419: areturn
    //   420: aload 4
    //   422: astore 5
    //   424: goto -328 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	a
    //   0	427	1	paramContext	Context
    //   0	427	2	paramMobProduct	MobProduct
    //   28	2	3	bool	boolean
    //   13	312	4	localObject1	Object
    //   329	1	4	localThrowable1	Throwable
    //   332	16	4	localObject2	Object
    //   355	6	4	localThrowable2	Throwable
    //   367	15	4	str1	String
    //   384	1	4	localThrowable3	Throwable
    //   388	1	4	localObject3	Object
    //   393	28	4	localThrowable4	Throwable
    //   49	270	5	localObject4	Object
    //   337	16	5	localObject5	Object
    //   402	1	5	localObject6	Object
    //   422	1	5	localThrowable5	Throwable
    //   63	230	6	localObject7	Object
    //   295	92	6	localThrowable6	Throwable
    //   407	1	6	localThrowable7	Throwable
    //   219	27	7	localHashMap1	HashMap
    //   215	7	8	localHashMap2	HashMap
    //   203	35	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   33	51	295	java/lang/Throwable
    //   318	323	329	java/lang/Throwable
    //   33	51	337	finally
    //   0	29	355	java/lang/Throwable
    //   352	355	355	java/lang/Throwable
    //   122	151	372	java/lang/Throwable
    //   74	79	384	java/lang/Throwable
    //   347	352	393	java/lang/Throwable
    //   160	172	398	java/lang/Throwable
    //   177	196	398	java/lang/Throwable
    //   196	217	398	java/lang/Throwable
    //   226	245	398	java/lang/Throwable
    //   245	261	398	java/lang/Throwable
    //   266	280	398	java/lang/Throwable
    //   280	288	398	java/lang/Throwable
    //   55	65	402	finally
    //   304	313	402	finally
    //   55	65	407	java/lang/Throwable
  }
  
  /* Error */
  private final HashMap<String, Object> c(Context paramContext, MobProduct paramMobProduct)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 19	com/mob/tools/utils/DeviceHelper:getInstance	(Landroid/content/Context;)Lcom/mob/tools/utils/DeviceHelper;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 23	com/mob/tools/utils/DeviceHelper:getCarrier	()Ljava/lang/String;
    //   9: invokestatic 29	com/mob/tools/utils/R:parseInt	(Ljava/lang/String;)I
    //   12: istore_3
    //   13: new 31	java/util/HashMap
    //   16: dup
    //   17: invokespecial 32	java/util/HashMap:<init>	()V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc 34
    //   26: aload_2
    //   27: invokevirtual 37	com/mob/tools/utils/DeviceHelper:getAdvertisingID	()Ljava/lang/String;
    //   30: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: aload 6
    //   36: ldc 43
    //   38: aload_2
    //   39: invokevirtual 46	com/mob/tools/utils/DeviceHelper:getIMEI	()Ljava/lang/String;
    //   42: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: aload 6
    //   48: ldc 48
    //   50: aload_2
    //   51: invokevirtual 51	com/mob/tools/utils/DeviceHelper:getSerialno	()Ljava/lang/String;
    //   54: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: aload 6
    //   60: ldc 53
    //   62: aload_2
    //   63: invokevirtual 56	com/mob/tools/utils/DeviceHelper:getAndroidID	()Ljava/lang/String;
    //   66: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload 6
    //   72: ldc 58
    //   74: aload_2
    //   75: invokevirtual 61	com/mob/tools/utils/DeviceHelper:getMacAddress	()Ljava/lang/String;
    //   78: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: aload 6
    //   84: ldc 63
    //   86: aload_2
    //   87: invokevirtual 66	com/mob/tools/utils/DeviceHelper:getModel	()Ljava/lang/String;
    //   90: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload 6
    //   96: ldc 68
    //   98: aload_2
    //   99: invokevirtual 71	com/mob/tools/utils/DeviceHelper:getManufacturer	()Ljava/lang/String;
    //   102: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload 6
    //   108: ldc 73
    //   110: iload_3
    //   111: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 6
    //   120: ldc 81
    //   122: aload_2
    //   123: invokevirtual 84	com/mob/tools/utils/DeviceHelper:getScreenSize	()Ljava/lang/String;
    //   126: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: aload 6
    //   132: ldc 86
    //   134: aload_2
    //   135: invokevirtual 89	com/mob/tools/utils/DeviceHelper:getOSVersionName	()Ljava/lang/String;
    //   138: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: pop
    //   142: aload 6
    //   144: ldc 91
    //   146: iconst_1
    //   147: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: new 93	com/mob/tools/utils/Hashon
    //   157: dup
    //   158: invokespecial 94	com/mob/tools/utils/Hashon:<init>	()V
    //   161: astore_2
    //   162: ldc 96
    //   164: aload_2
    //   165: aload 6
    //   167: invokevirtual 100	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   170: invokestatic 106	com/mob/tools/utils/Data:AES128Encode	(Ljava/lang/String;Ljava/lang/String;)[B
    //   173: iconst_2
    //   174: invokestatic 112	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   177: astore 5
    //   179: new 114	java/util/ArrayList
    //   182: dup
    //   183: invokespecial 115	java/util/ArrayList:<init>	()V
    //   186: astore 7
    //   188: aload 7
    //   190: new 117	com/mob/tools/network/KVPair
    //   193: dup
    //   194: ldc 119
    //   196: aload 5
    //   198: invokespecial 122	com/mob/tools/network/KVPair:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
    //   201: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   204: pop
    //   205: aload_2
    //   206: new 128	com/mob/tools/network/NetworkHelper
    //   209: dup
    //   210: invokespecial 129	com/mob/tools/network/NetworkHelper:<init>	()V
    //   213: ldc -125
    //   215: aload 7
    //   217: aconst_null
    //   218: aconst_null
    //   219: aconst_null
    //   220: invokevirtual 135	com/mob/tools/network/NetworkHelper:httpPost	(Ljava/lang/String;Ljava/util/ArrayList;Lcom/mob/tools/network/KVPair;Ljava/util/ArrayList;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/lang/String;
    //   223: invokevirtual 139	com/mob/tools/utils/Hashon:fromJson	(Ljava/lang/String;)Ljava/util/HashMap;
    //   226: astore 5
    //   228: aload 5
    //   230: ifnonnull +5 -> 235
    //   233: aconst_null
    //   234: areturn
    //   235: aload 5
    //   237: ldc -115
    //   239: invokevirtual 145	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: checkcast 147	java/lang/String
    //   245: astore 7
    //   247: aload 7
    //   249: ifnull +15 -> 264
    //   252: aload 7
    //   254: invokevirtual 151	java/lang/String:length	()I
    //   257: istore 4
    //   259: iload 4
    //   261: ifgt +5 -> 266
    //   264: aconst_null
    //   265: areturn
    //   266: new 31	java/util/HashMap
    //   269: dup
    //   270: invokespecial 32	java/util/HashMap:<init>	()V
    //   273: astore_2
    //   274: aload_2
    //   275: ldc -115
    //   277: aload 7
    //   279: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 6
    //   285: ldc 73
    //   287: iload_3
    //   288: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: pop
    //   295: aload_2
    //   296: ldc -100
    //   298: aload 6
    //   300: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: new 158	java/io/ObjectOutputStream
    //   307: dup
    //   308: new 160	java/io/FileOutputStream
    //   311: dup
    //   312: new 162	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: invokestatic 166	com/mob/tools/utils/R:getCacheRoot	(Landroid/content/Context;)Ljava/lang/String;
    //   320: ldc -88
    //   322: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   328: invokespecial 177	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   331: astore 7
    //   333: aload 7
    //   335: astore 5
    //   337: aload 7
    //   339: aload_2
    //   340: invokevirtual 181	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   343: aload 7
    //   345: ifnull +120 -> 465
    //   348: aload 7
    //   350: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   353: aload 7
    //   355: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   358: aload_2
    //   359: areturn
    //   360: astore_1
    //   361: aload_2
    //   362: areturn
    //   363: astore 6
    //   365: aload 5
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: aload_2
    //   371: astore 5
    //   373: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   376: aload 6
    //   378: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   381: pop
    //   382: aload_1
    //   383: astore 5
    //   385: aload_2
    //   386: ifnull +82 -> 468
    //   389: aload_2
    //   390: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   393: aload_2
    //   394: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   397: aload_1
    //   398: areturn
    //   399: astore_2
    //   400: aload_1
    //   401: areturn
    //   402: astore_1
    //   403: aconst_null
    //   404: astore 5
    //   406: aload 5
    //   408: ifnull +13 -> 421
    //   411: aload 5
    //   413: invokevirtual 184	java/io/ObjectOutputStream:flush	()V
    //   416: aload 5
    //   418: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   421: aload_1
    //   422: athrow
    //   423: astore_1
    //   424: invokestatic 192	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   427: aload_1
    //   428: invokevirtual 198	com/mob/tools/log/NLog:w	(Ljava/lang/Throwable;)I
    //   431: pop
    //   432: aconst_null
    //   433: areturn
    //   434: astore_2
    //   435: goto -14 -> 421
    //   438: astore_1
    //   439: goto -33 -> 406
    //   442: astore 6
    //   444: aconst_null
    //   445: astore 5
    //   447: aload_2
    //   448: astore_1
    //   449: aload 5
    //   451: astore_2
    //   452: goto -82 -> 370
    //   455: astore 6
    //   457: aload_2
    //   458: astore_1
    //   459: aload 7
    //   461: astore_2
    //   462: goto -92 -> 370
    //   465: aload_2
    //   466: astore 5
    //   468: aload 5
    //   470: areturn
    //   471: astore 5
    //   473: iconst_m1
    //   474: istore_3
    //   475: goto -462 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	a
    //   0	478	1	paramContext	Context
    //   0	478	2	paramMobProduct	MobProduct
    //   12	463	3	i	int
    //   257	3	4	j	int
    //   177	292	5	localObject1	Object
    //   471	1	5	localThrowable1	Throwable
    //   20	279	6	localHashMap	HashMap
    //   363	14	6	localThrowable2	Throwable
    //   442	1	6	localThrowable3	Throwable
    //   455	1	6	localThrowable4	Throwable
    //   186	274	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   348	358	360	java/lang/Throwable
    //   266	274	363	java/lang/Throwable
    //   389	397	399	java/lang/Throwable
    //   266	274	402	finally
    //   274	333	402	finally
    //   0	5	423	java/lang/Throwable
    //   13	228	423	java/lang/Throwable
    //   235	247	423	java/lang/Throwable
    //   252	259	423	java/lang/Throwable
    //   421	423	423	java/lang/Throwable
    //   411	421	434	java/lang/Throwable
    //   337	343	438	finally
    //   373	382	438	finally
    //   274	333	442	java/lang/Throwable
    //   337	343	455	java/lang/Throwable
    //   5	13	471	java/lang/Throwable
  }
  
  public final String a(Context paramContext, MobProduct paramMobProduct)
  {
    try
    {
      File localFile = new File(R.getCacheRoot(paramContext), ".globalLock");
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      FileLocker localFileLocker = new FileLocker();
      localFileLocker.setLockFile(localFile.getAbsolutePath());
      if (!localFileLocker.lock(true)) {
        break label81;
      }
      paramContext = b(paramContext, paramMobProduct);
      localFileLocker.release();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        MobLog.getInstance().w(paramContext);
        label81:
        paramContext = null;
      }
    }
    finally {}
    return paramContext;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\commons\authorize\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */