package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class zzq
  extends zzy
{
  public zzq(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  private byte[] zzc(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    byte[] arrayOfByte = null;
    Object localObject = arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = arrayOfByte;
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = paramHttpURLConnection;
      arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = paramHttpURLConnection.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
    }
    finally
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    return arrayOfByte;
  }
  
  public void zza(URL paramURL, byte[] paramArrayOfByte, zza paramzza)
  {
    zzis();
    zziE();
    zzx.zzw(paramURL);
    zzx.zzw(paramArrayOfByte);
    zzx.zzw(paramzza);
    zzzr().zzi(new zzc(paramURL, paramArrayOfByte, paramzza));
  }
  
  protected HttpURLConnection zzc(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection)) {
      throw new IOException("Failed to obtain HTTP connection");
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout((int)zzzt().zzyY());
    paramURL.setReadTimeout((int)zzzt().zzyZ());
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setDoInput(true);
    return paramURL;
  }
  
  protected void zzhR() {}
  
  public boolean zzkK()
  {
    zziE();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected())) {
        return true;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return false;
  }
  
  static abstract interface zza
  {
    public abstract void zza(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte);
  }
  
  private static class zzb
    implements Runnable
  {
    private final zzq.zza zzaMY;
    private final Throwable zzaMZ;
    private final byte[] zzaNa;
    private final int zzys;
    
    private zzb(zzq.zza paramzza, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
    {
      this.zzaMY = paramzza;
      this.zzys = paramInt;
      this.zzaMZ = paramThrowable;
      this.zzaNa = paramArrayOfByte;
    }
    
    public void run()
    {
      this.zzaMY.zza(this.zzys, this.zzaMZ, this.zzaNa);
    }
  }
  
  private class zzc
    implements Runnable
  {
    private final byte[] zzaNb;
    private final zzq.zza zzaNc;
    private final URL zzxG;
    
    public zzc(URL paramURL, byte[] paramArrayOfByte, zzq.zza paramzza)
    {
      this.zzxG = paramURL;
      this.zzaNb = paramArrayOfByte;
      this.zzaNc = paramzza;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   4: invokevirtual 37	com/google/android/gms/measurement/internal/zzq:zzzn	()V
      //   7: iconst_0
      //   8: istore_3
      //   9: iconst_0
      //   10: istore 4
      //   12: iconst_0
      //   13: istore 5
      //   15: aload_0
      //   16: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   19: invokevirtual 41	com/google/android/gms/measurement/internal/zzq:zzzq	()Lcom/google/android/gms/measurement/internal/zzag;
      //   22: aload_0
      //   23: getfield 28	com/google/android/gms/measurement/internal/zzq$zzc:zzaNb	[B
      //   26: invokevirtual 47	com/google/android/gms/measurement/internal/zzag:zzg	([B)[B
      //   29: astore 8
      //   31: aload_0
      //   32: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   35: aload_0
      //   36: getfield 26	com/google/android/gms/measurement/internal/zzq$zzc:zzxG	Ljava/net/URL;
      //   39: invokevirtual 50	com/google/android/gms/measurement/internal/zzq:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
      //   42: astore 6
      //   44: iload_3
      //   45: istore_1
      //   46: iload 4
      //   48: istore_2
      //   49: aload 6
      //   51: iconst_1
      //   52: invokevirtual 56	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   55: iload_3
      //   56: istore_1
      //   57: iload 4
      //   59: istore_2
      //   60: aload 6
      //   62: ldc 58
      //   64: ldc 60
      //   66: invokevirtual 64	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   69: iload_3
      //   70: istore_1
      //   71: iload 4
      //   73: istore_2
      //   74: aload 6
      //   76: aload 8
      //   78: arraylength
      //   79: invokevirtual 68	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
      //   82: iload_3
      //   83: istore_1
      //   84: iload 4
      //   86: istore_2
      //   87: aload 6
      //   89: invokevirtual 71	java/net/HttpURLConnection:connect	()V
      //   92: iload_3
      //   93: istore_1
      //   94: iload 4
      //   96: istore_2
      //   97: aload 6
      //   99: invokevirtual 75	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   102: astore 7
      //   104: aload 7
      //   106: aload 8
      //   108: invokevirtual 81	java/io/OutputStream:write	([B)V
      //   111: aload 7
      //   113: invokevirtual 84	java/io/OutputStream:close	()V
      //   116: iload_3
      //   117: istore_1
      //   118: iload 4
      //   120: istore_2
      //   121: aload 6
      //   123: invokevirtual 88	java/net/HttpURLConnection:getResponseCode	()I
      //   126: istore_3
      //   127: iload_3
      //   128: istore_1
      //   129: iload_3
      //   130: istore_2
      //   131: aload_0
      //   132: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   135: aload 6
      //   137: invokestatic 92	com/google/android/gms/measurement/internal/zzq:zza	(Lcom/google/android/gms/measurement/internal/zzq;Ljava/net/HttpURLConnection;)[B
      //   140: astore 8
      //   142: iconst_0
      //   143: ifeq +11 -> 154
      //   146: new 94	java/lang/NullPointerException
      //   149: dup
      //   150: invokespecial 95	java/lang/NullPointerException:<init>	()V
      //   153: athrow
      //   154: aload 6
      //   156: ifnull +8 -> 164
      //   159: aload 6
      //   161: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   164: aload_0
      //   165: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   168: invokevirtual 102	com/google/android/gms/measurement/internal/zzq:zzzr	()Lcom/google/android/gms/measurement/internal/zzu;
      //   171: new 104	com/google/android/gms/measurement/internal/zzq$zzb
      //   174: dup
      //   175: aload_0
      //   176: getfield 30	com/google/android/gms/measurement/internal/zzq$zzc:zzaNc	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   179: iload_3
      //   180: aconst_null
      //   181: aload 8
      //   183: aconst_null
      //   184: invokespecial 107	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzq$1;)V
      //   187: invokevirtual 113	com/google/android/gms/measurement/internal/zzu:zzh	(Ljava/lang/Runnable;)V
      //   190: return
      //   191: astore 7
      //   193: aload_0
      //   194: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   197: invokevirtual 117	com/google/android/gms/measurement/internal/zzq:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   200: invokevirtual 123	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   203: ldc 125
      //   205: aload 7
      //   207: invokevirtual 131	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   210: goto -56 -> 154
      //   213: astore 6
      //   215: iconst_0
      //   216: istore_1
      //   217: aconst_null
      //   218: astore 7
      //   220: aconst_null
      //   221: astore 8
      //   223: aload 7
      //   225: ifnull +8 -> 233
      //   228: aload 7
      //   230: invokevirtual 84	java/io/OutputStream:close	()V
      //   233: aload 8
      //   235: ifnull +8 -> 243
      //   238: aload 8
      //   240: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   243: aload_0
      //   244: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   247: invokevirtual 102	com/google/android/gms/measurement/internal/zzq:zzzr	()Lcom/google/android/gms/measurement/internal/zzu;
      //   250: new 104	com/google/android/gms/measurement/internal/zzq$zzb
      //   253: dup
      //   254: aload_0
      //   255: getfield 30	com/google/android/gms/measurement/internal/zzq$zzc:zzaNc	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   258: iload_1
      //   259: aload 6
      //   261: aconst_null
      //   262: aconst_null
      //   263: invokespecial 107	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzq$1;)V
      //   266: invokevirtual 113	com/google/android/gms/measurement/internal/zzu:zzh	(Ljava/lang/Runnable;)V
      //   269: return
      //   270: astore 7
      //   272: aload_0
      //   273: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   276: invokevirtual 117	com/google/android/gms/measurement/internal/zzq:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   279: invokevirtual 123	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   282: ldc 125
      //   284: aload 7
      //   286: invokevirtual 131	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   289: goto -56 -> 233
      //   292: astore 6
      //   294: aconst_null
      //   295: astore 8
      //   297: aconst_null
      //   298: astore 7
      //   300: iload 5
      //   302: istore_1
      //   303: aload 7
      //   305: ifnull +8 -> 313
      //   308: aload 7
      //   310: invokevirtual 84	java/io/OutputStream:close	()V
      //   313: aload 8
      //   315: ifnull +8 -> 323
      //   318: aload 8
      //   320: invokevirtual 98	java/net/HttpURLConnection:disconnect	()V
      //   323: aload_0
      //   324: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   327: invokevirtual 102	com/google/android/gms/measurement/internal/zzq:zzzr	()Lcom/google/android/gms/measurement/internal/zzu;
      //   330: new 104	com/google/android/gms/measurement/internal/zzq$zzb
      //   333: dup
      //   334: aload_0
      //   335: getfield 30	com/google/android/gms/measurement/internal/zzq$zzc:zzaNc	Lcom/google/android/gms/measurement/internal/zzq$zza;
      //   338: iload_1
      //   339: aconst_null
      //   340: aconst_null
      //   341: aconst_null
      //   342: invokespecial 107	com/google/android/gms/measurement/internal/zzq$zzb:<init>	(Lcom/google/android/gms/measurement/internal/zzq$zza;ILjava/lang/Throwable;[BLcom/google/android/gms/measurement/internal/zzq$1;)V
      //   345: invokevirtual 113	com/google/android/gms/measurement/internal/zzu:zzh	(Ljava/lang/Runnable;)V
      //   348: aload 6
      //   350: athrow
      //   351: astore 7
      //   353: aload_0
      //   354: getfield 21	com/google/android/gms/measurement/internal/zzq$zzc:zzaNd	Lcom/google/android/gms/measurement/internal/zzq;
      //   357: invokevirtual 117	com/google/android/gms/measurement/internal/zzq:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   360: invokevirtual 123	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   363: ldc 125
      //   365: aload 7
      //   367: invokevirtual 131	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   370: goto -57 -> 313
      //   373: astore 9
      //   375: aconst_null
      //   376: astore 7
      //   378: aload 6
      //   380: astore 8
      //   382: aload 9
      //   384: astore 6
      //   386: goto -83 -> 303
      //   389: astore 9
      //   391: aload 6
      //   393: astore 8
      //   395: iload 5
      //   397: istore_1
      //   398: aload 9
      //   400: astore 6
      //   402: goto -99 -> 303
      //   405: astore 9
      //   407: iload_2
      //   408: istore_1
      //   409: aconst_null
      //   410: astore 7
      //   412: aload 6
      //   414: astore 8
      //   416: aload 9
      //   418: astore 6
      //   420: goto -197 -> 223
      //   423: astore 9
      //   425: iconst_0
      //   426: istore_1
      //   427: aload 6
      //   429: astore 8
      //   431: aload 9
      //   433: astore 6
      //   435: goto -212 -> 223
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	438	0	this	zzc
      //   45	382	1	i	int
      //   48	360	2	j	int
      //   8	172	3	k	int
      //   10	109	4	m	int
      //   13	383	5	n	int
      //   42	118	6	localHttpURLConnection	HttpURLConnection
      //   213	47	6	localIOException1	IOException
      //   292	87	6	localObject1	Object
      //   384	50	6	localObject2	Object
      //   102	10	7	localOutputStream	java.io.OutputStream
      //   191	15	7	localIOException2	IOException
      //   218	11	7	localObject3	Object
      //   270	15	7	localIOException3	IOException
      //   298	11	7	localObject4	Object
      //   351	15	7	localIOException4	IOException
      //   376	35	7	localObject5	Object
      //   29	401	8	localObject6	Object
      //   373	10	9	localObject7	Object
      //   389	10	9	localObject8	Object
      //   405	12	9	localIOException5	IOException
      //   423	9	9	localIOException6	IOException
      // Exception table:
      //   from	to	target	type
      //   146	154	191	java/io/IOException
      //   15	44	213	java/io/IOException
      //   228	233	270	java/io/IOException
      //   15	44	292	finally
      //   308	313	351	java/io/IOException
      //   49	55	373	finally
      //   60	69	373	finally
      //   74	82	373	finally
      //   87	92	373	finally
      //   97	104	373	finally
      //   121	127	373	finally
      //   131	142	373	finally
      //   104	116	389	finally
      //   49	55	405	java/io/IOException
      //   60	69	405	java/io/IOException
      //   74	82	405	java/io/IOException
      //   87	92	405	java/io/IOException
      //   97	104	405	java/io/IOException
      //   121	127	405	java/io/IOException
      //   131	142	405	java/io/IOException
      //   104	116	423	java/io/IOException
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */