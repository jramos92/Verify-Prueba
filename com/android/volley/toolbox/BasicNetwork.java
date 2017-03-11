package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork
  implements Network
{
  protected static final boolean DEBUG = VolleyLog.DEBUG;
  private static int DEFAULT_POOL_SIZE = 4096;
  private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
  protected final HttpStack mHttpStack;
  protected final ByteArrayPool mPool;
  
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
  }
  
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    this.mHttpStack = paramHttpStack;
    this.mPool = paramByteArrayPool;
  }
  
  private void addCacheHeaders(Map<String, String> paramMap, Cache.Entry paramEntry)
  {
    if (paramEntry == null) {}
    do
    {
      return;
      if (paramEntry.etag != null) {
        paramMap.put("If-None-Match", paramEntry.etag);
      }
    } while (paramEntry.lastModified <= 0L);
    paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramEntry.lastModified)));
  }
  
  private static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
    throws VolleyError
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError paramVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramVolleyError;
    }
  }
  
  protected static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfHeader.length) {
        return localTreeMap;
      }
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
  }
  
  private byte[] entityToBytes(HttpEntity paramHttpEntity)
    throws IOException, ServerError
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new ServerError();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.mPool.returnBuf((byte[])localObject1);
      localPoolingByteArrayOutputStream.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.mPool.getBuf(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1)
        {
          localObject1 = arrayOfByte;
          localObject4 = localPoolingByteArrayOutputStream.toByteArray();
        }
        try
        {
          paramHttpEntity.consumeContent();
          this.mPool.returnBuf(arrayOfByte);
          localPoolingByteArrayOutputStream.close();
          return (byte[])localObject4;
          localObject1 = arrayOfByte;
          localPoolingByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        catch (IOException paramHttpEntity)
        {
          for (;;)
          {
            VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
          }
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > SLOW_REQUEST_THRESHOLD_MS)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
      return;
    }
  }
  
  protected void logError(String paramString1, String paramString2, long paramLong)
  {
    VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[] { paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2 });
  }
  
  /* Error */
  public com.android.volley.NetworkResponse performRequest(Request<?> paramRequest)
    throws VolleyError
  {
    // Byte code:
    //   0: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 7
    //   7: invokestatic 243	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 8
    //   12: aload 8
    //   14: astore 5
    //   16: aload 7
    //   18: astore 6
    //   20: new 245	java/util/HashMap
    //   23: dup
    //   24: invokespecial 246	java/util/HashMap:<init>	()V
    //   27: astore 9
    //   29: aload 8
    //   31: astore 5
    //   33: aload 7
    //   35: astore 6
    //   37: aload_0
    //   38: aload 9
    //   40: aload_1
    //   41: invokevirtual 250	com/android/volley/Request:getCacheEntry	()Lcom/android/volley/Cache$Entry;
    //   44: invokespecial 252	com/android/volley/toolbox/BasicNetwork:addCacheHeaders	(Ljava/util/Map;Lcom/android/volley/Cache$Entry;)V
    //   47: aload 8
    //   49: astore 5
    //   51: aload 7
    //   53: astore 6
    //   55: aload_0
    //   56: getfield 41	com/android/volley/toolbox/BasicNetwork:mHttpStack	Lcom/android/volley/toolbox/HttpStack;
    //   59: aload_1
    //   60: aload 9
    //   62: invokeinterface 257 3 0
    //   67: astore 7
    //   69: aload 8
    //   71: astore 5
    //   73: aload 7
    //   75: astore 6
    //   77: aload 7
    //   79: invokeinterface 263 1 0
    //   84: astore 10
    //   86: aload 8
    //   88: astore 5
    //   90: aload 7
    //   92: astore 6
    //   94: aload 10
    //   96: invokeinterface 211 1 0
    //   101: istore_2
    //   102: aload 8
    //   104: astore 5
    //   106: aload 7
    //   108: astore 6
    //   110: aload 7
    //   112: invokeinterface 267 1 0
    //   117: invokestatic 269	com/android/volley/toolbox/BasicNetwork:convertHeaders	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   120: astore 8
    //   122: iload_2
    //   123: sipush 304
    //   126: if_icmpne +567 -> 693
    //   129: aload 8
    //   131: astore 5
    //   133: aload 7
    //   135: astore 6
    //   137: aload_1
    //   138: invokevirtual 250	com/android/volley/Request:getCacheEntry	()Lcom/android/volley/Cache$Entry;
    //   141: astore 9
    //   143: aload 9
    //   145: ifnonnull +31 -> 176
    //   148: aload 8
    //   150: astore 5
    //   152: aload 7
    //   154: astore 6
    //   156: new 271	com/android/volley/NetworkResponse
    //   159: dup
    //   160: sipush 304
    //   163: aconst_null
    //   164: aload 8
    //   166: iconst_1
    //   167: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   170: lload_3
    //   171: lsub
    //   172: invokespecial 274	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   175: areturn
    //   176: aload 8
    //   178: astore 5
    //   180: aload 7
    //   182: astore 6
    //   184: aload 9
    //   186: getfield 278	com/android/volley/Cache$Entry:responseHeaders	Ljava/util/Map;
    //   189: aload 8
    //   191: invokeinterface 282 2 0
    //   196: aload 8
    //   198: astore 5
    //   200: aload 7
    //   202: astore 6
    //   204: new 271	com/android/volley/NetworkResponse
    //   207: dup
    //   208: sipush 304
    //   211: aload 9
    //   213: getfield 286	com/android/volley/Cache$Entry:data	[B
    //   216: aload 9
    //   218: getfield 278	com/android/volley/Cache$Entry:responseHeaders	Ljava/util/Map;
    //   221: iconst_1
    //   222: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   225: lload_3
    //   226: lsub
    //   227: invokespecial 274	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   230: areturn
    //   231: aload 8
    //   233: astore 5
    //   235: aload 7
    //   237: astore 6
    //   239: aload_1
    //   240: aload 8
    //   242: ldc_w 288
    //   245: invokeinterface 292 2 0
    //   250: checkcast 108	java/lang/String
    //   253: invokevirtual 295	com/android/volley/Request:setRedirectUrl	(Ljava/lang/String;)V
    //   256: aload 8
    //   258: astore 5
    //   260: aload 7
    //   262: astore 6
    //   264: aload 7
    //   266: invokeinterface 299 1 0
    //   271: ifnull +83 -> 354
    //   274: aload 8
    //   276: astore 5
    //   278: aload 7
    //   280: astore 6
    //   282: aload_0
    //   283: aload 7
    //   285: invokeinterface 299 1 0
    //   290: invokespecial 301	com/android/volley/toolbox/BasicNetwork:entityToBytes	(Lorg/apache/http/HttpEntity;)[B
    //   293: astore 9
    //   295: aload 9
    //   297: astore 5
    //   299: aload_0
    //   300: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   303: lload_3
    //   304: lsub
    //   305: aload_1
    //   306: aload 5
    //   308: aload 10
    //   310: invokespecial 303	com/android/volley/toolbox/BasicNetwork:logSlowRequests	(JLcom/android/volley/Request;[BLorg/apache/http/StatusLine;)V
    //   313: iload_2
    //   314: sipush 200
    //   317: if_icmplt +10 -> 327
    //   320: iload_2
    //   321: sipush 299
    //   324: if_icmple +50 -> 374
    //   327: new 145	java/io/IOException
    //   330: dup
    //   331: invokespecial 304	java/io/IOException:<init>	()V
    //   334: athrow
    //   335: astore 5
    //   337: ldc_w 306
    //   340: aload_1
    //   341: new 308	com/android/volley/TimeoutError
    //   344: dup
    //   345: invokespecial 309	com/android/volley/TimeoutError:<init>	()V
    //   348: invokestatic 311	com/android/volley/toolbox/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   351: goto -347 -> 4
    //   354: aload 8
    //   356: astore 5
    //   358: aload 7
    //   360: astore 6
    //   362: iconst_0
    //   363: newarray <illegal type>
    //   365: astore 9
    //   367: aload 9
    //   369: astore 5
    //   371: goto -72 -> 299
    //   374: new 271	com/android/volley/NetworkResponse
    //   377: dup
    //   378: iload_2
    //   379: aload 5
    //   381: aload 8
    //   383: iconst_0
    //   384: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   387: lload_3
    //   388: lsub
    //   389: invokespecial 274	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   392: astore 6
    //   394: aload 6
    //   396: areturn
    //   397: astore 5
    //   399: ldc_w 313
    //   402: aload_1
    //   403: new 308	com/android/volley/TimeoutError
    //   406: dup
    //   407: invokespecial 309	com/android/volley/TimeoutError:<init>	()V
    //   410: invokestatic 311	com/android/volley/toolbox/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   413: goto -409 -> 4
    //   416: astore 5
    //   418: new 315	java/lang/RuntimeException
    //   421: dup
    //   422: new 317	java/lang/StringBuilder
    //   425: dup
    //   426: ldc_w 319
    //   429: invokespecial 321	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   432: aload_1
    //   433: invokevirtual 324	com/android/volley/Request:getUrl	()Ljava/lang/String;
    //   436: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aload 5
    //   444: invokespecial 334	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   447: athrow
    //   448: astore 10
    //   450: aconst_null
    //   451: astore 9
    //   453: aload 6
    //   455: astore 7
    //   457: aload 5
    //   459: astore 8
    //   461: aload 10
    //   463: astore 6
    //   465: aload 7
    //   467: ifnull +112 -> 579
    //   470: aload 7
    //   472: invokeinterface 263 1 0
    //   477: invokeinterface 211 1 0
    //   482: istore_2
    //   483: iload_2
    //   484: sipush 301
    //   487: if_icmpeq +10 -> 497
    //   490: iload_2
    //   491: sipush 302
    //   494: if_icmpne +95 -> 589
    //   497: ldc_w 336
    //   500: iconst_2
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: aload_1
    //   507: invokevirtual 339	com/android/volley/Request:getOriginUrl	()Ljava/lang/String;
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload_1
    //   514: invokevirtual 324	com/android/volley/Request:getUrl	()Ljava/lang/String;
    //   517: aastore
    //   518: invokestatic 342	com/android/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload 9
    //   523: ifnull +136 -> 659
    //   526: new 271	com/android/volley/NetworkResponse
    //   529: dup
    //   530: iload_2
    //   531: aload 9
    //   533: aload 8
    //   535: iconst_0
    //   536: invokestatic 229	android/os/SystemClock:elapsedRealtime	()J
    //   539: lload_3
    //   540: lsub
    //   541: invokespecial 274	com/android/volley/NetworkResponse:<init>	(I[BLjava/util/Map;ZJ)V
    //   544: astore 5
    //   546: iload_2
    //   547: sipush 401
    //   550: if_icmpeq +10 -> 560
    //   553: iload_2
    //   554: sipush 403
    //   557: if_icmpne +59 -> 616
    //   560: ldc_w 344
    //   563: aload_1
    //   564: new 346	com/android/volley/AuthFailureError
    //   567: dup
    //   568: aload 5
    //   570: invokespecial 349	com/android/volley/AuthFailureError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   573: invokestatic 311	com/android/volley/toolbox/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   576: goto -572 -> 4
    //   579: new 351	com/android/volley/NoConnectionError
    //   582: dup
    //   583: aload 6
    //   585: invokespecial 354	com/android/volley/NoConnectionError:<init>	(Ljava/lang/Throwable;)V
    //   588: athrow
    //   589: ldc_w 356
    //   592: iconst_2
    //   593: anewarray 4	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: iload_2
    //   599: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: aload_1
    //   606: invokevirtual 324	com/android/volley/Request:getUrl	()Ljava/lang/String;
    //   609: aastore
    //   610: invokestatic 342	com/android/volley/VolleyLog:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   613: goto -92 -> 521
    //   616: iload_2
    //   617: sipush 301
    //   620: if_icmpeq +10 -> 630
    //   623: iload_2
    //   624: sipush 302
    //   627: if_icmpne +22 -> 649
    //   630: ldc_w 358
    //   633: aload_1
    //   634: new 360	com/android/volley/RedirectError
    //   637: dup
    //   638: aload 5
    //   640: invokespecial 361	com/android/volley/RedirectError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   643: invokestatic 311	com/android/volley/toolbox/BasicNetwork:attemptRetryOnException	(Ljava/lang/String;Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   646: goto -642 -> 4
    //   649: new 147	com/android/volley/ServerError
    //   652: dup
    //   653: aload 5
    //   655: invokespecial 362	com/android/volley/ServerError:<init>	(Lcom/android/volley/NetworkResponse;)V
    //   658: athrow
    //   659: new 364	com/android/volley/NetworkError
    //   662: dup
    //   663: aload 6
    //   665: invokespecial 365	com/android/volley/NetworkError:<init>	(Ljava/lang/Throwable;)V
    //   668: athrow
    //   669: astore 6
    //   671: aload 5
    //   673: astore 9
    //   675: goto -210 -> 465
    //   678: astore 5
    //   680: goto -262 -> 418
    //   683: astore 5
    //   685: goto -286 -> 399
    //   688: astore 5
    //   690: goto -353 -> 337
    //   693: iload_2
    //   694: sipush 301
    //   697: if_icmpeq -466 -> 231
    //   700: iload_2
    //   701: sipush 302
    //   704: if_icmpne -448 -> 256
    //   707: goto -476 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	BasicNetwork
    //   0	710	1	paramRequest	Request<?>
    //   101	604	2	i	int
    //   3	537	3	l	long
    //   14	293	5	localObject1	Object
    //   335	1	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   356	24	5	localObject2	Object
    //   397	1	5	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   416	42	5	localMalformedURLException1	java.net.MalformedURLException
    //   544	128	5	localNetworkResponse	com.android.volley.NetworkResponse
    //   678	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   683	1	5	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   688	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   18	646	6	localObject3	Object
    //   669	1	6	localIOException1	IOException
    //   5	466	7	localObject4	Object
    //   10	524	8	localObject5	Object
    //   27	647	9	localObject6	Object
    //   84	225	10	localStatusLine	StatusLine
    //   448	14	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   299	313	335	java/net/SocketTimeoutException
    //   327	335	335	java/net/SocketTimeoutException
    //   374	394	335	java/net/SocketTimeoutException
    //   20	29	397	org/apache/http/conn/ConnectTimeoutException
    //   37	47	397	org/apache/http/conn/ConnectTimeoutException
    //   55	69	397	org/apache/http/conn/ConnectTimeoutException
    //   77	86	397	org/apache/http/conn/ConnectTimeoutException
    //   94	102	397	org/apache/http/conn/ConnectTimeoutException
    //   110	122	397	org/apache/http/conn/ConnectTimeoutException
    //   137	143	397	org/apache/http/conn/ConnectTimeoutException
    //   156	176	397	org/apache/http/conn/ConnectTimeoutException
    //   184	196	397	org/apache/http/conn/ConnectTimeoutException
    //   204	231	397	org/apache/http/conn/ConnectTimeoutException
    //   239	256	397	org/apache/http/conn/ConnectTimeoutException
    //   264	274	397	org/apache/http/conn/ConnectTimeoutException
    //   282	295	397	org/apache/http/conn/ConnectTimeoutException
    //   362	367	397	org/apache/http/conn/ConnectTimeoutException
    //   20	29	416	java/net/MalformedURLException
    //   37	47	416	java/net/MalformedURLException
    //   55	69	416	java/net/MalformedURLException
    //   77	86	416	java/net/MalformedURLException
    //   94	102	416	java/net/MalformedURLException
    //   110	122	416	java/net/MalformedURLException
    //   137	143	416	java/net/MalformedURLException
    //   156	176	416	java/net/MalformedURLException
    //   184	196	416	java/net/MalformedURLException
    //   204	231	416	java/net/MalformedURLException
    //   239	256	416	java/net/MalformedURLException
    //   264	274	416	java/net/MalformedURLException
    //   282	295	416	java/net/MalformedURLException
    //   362	367	416	java/net/MalformedURLException
    //   20	29	448	java/io/IOException
    //   37	47	448	java/io/IOException
    //   55	69	448	java/io/IOException
    //   77	86	448	java/io/IOException
    //   94	102	448	java/io/IOException
    //   110	122	448	java/io/IOException
    //   137	143	448	java/io/IOException
    //   156	176	448	java/io/IOException
    //   184	196	448	java/io/IOException
    //   204	231	448	java/io/IOException
    //   239	256	448	java/io/IOException
    //   264	274	448	java/io/IOException
    //   282	295	448	java/io/IOException
    //   362	367	448	java/io/IOException
    //   299	313	669	java/io/IOException
    //   327	335	669	java/io/IOException
    //   374	394	669	java/io/IOException
    //   299	313	678	java/net/MalformedURLException
    //   327	335	678	java/net/MalformedURLException
    //   374	394	678	java/net/MalformedURLException
    //   299	313	683	org/apache/http/conn/ConnectTimeoutException
    //   327	335	683	org/apache/http/conn/ConnectTimeoutException
    //   374	394	683	org/apache/http/conn/ConnectTimeoutException
    //   20	29	688	java/net/SocketTimeoutException
    //   37	47	688	java/net/SocketTimeoutException
    //   55	69	688	java/net/SocketTimeoutException
    //   77	86	688	java/net/SocketTimeoutException
    //   94	102	688	java/net/SocketTimeoutException
    //   110	122	688	java/net/SocketTimeoutException
    //   137	143	688	java/net/SocketTimeoutException
    //   156	176	688	java/net/SocketTimeoutException
    //   184	196	688	java/net/SocketTimeoutException
    //   204	231	688	java/net/SocketTimeoutException
    //   239	256	688	java/net/SocketTimeoutException
    //   264	274	688	java/net/SocketTimeoutException
    //   282	295	688	java/net/SocketTimeoutException
    //   362	367	688	java/net/SocketTimeoutException
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\android\volley\toolbox\BasicNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */