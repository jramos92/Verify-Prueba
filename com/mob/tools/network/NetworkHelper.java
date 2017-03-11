package com.mob.tools.network;

import android.content.Context;
import android.os.Build.VERSION;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import com.mob.tools.utils.ReflectHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class NetworkHelper
{
  public static int connectionTimeout;
  public static int readTimout;
  
  private HttpURLConnection getConnection(String paramString, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localObject1 = "methodTokens";
    i = 0;
    paramString = null;
    if (0 != 0) {}
    try
    {
      localObject2 = ReflectHelper.getStaticField("HttpURLConnection", "methodTokens");
      paramString = (String)localObject2;
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        Object localObject2;
      }
    }
    if (paramString == null)
    {
      localObject1 = "PERMITTED_USER_METHODS";
      i = 1;
      if (1 != 0) {}
      for (;;)
      {
        try
        {
          localObject2 = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
          paramString = (String)localObject2;
        }
        catch (Throwable localThrowable1)
        {
          SecureRandom localSecureRandom;
          continue;
          ReflectHelper.setInstanceField(localHttpURLConnection, (String)localObject1, localThrowable1);
          continue;
          i = paramNetworkTimeOut.connectionTimeout;
          continue;
          i = paramNetworkTimeOut.readTimout;
          continue;
        }
        if (paramString != null)
        {
          paramString = (String[])paramString;
          localObject2 = new String[paramString.length + 1];
          System.arraycopy(paramString, 0, localObject2, 0, paramString.length);
          localObject2[paramString.length] = "PATCH";
          if (i == 0) {
            continue;
          }
          ReflectHelper.setStaticField("HttpURLConnection", (String)localObject1, localObject2);
        }
        if (Build.VERSION.SDK_INT < 8) {
          System.setProperty("http.keepAlive", "false");
        }
        if ((localHttpURLConnection instanceof HttpsURLConnection))
        {
          paramString = (HttpsURLConnection)localHttpURLConnection;
          localObject1 = SSLContext.getInstance("TLS");
          localObject2 = new X509TrustManager()
          {
            public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
              throws CertificateException
            {}
            
            public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
              throws CertificateException
            {}
            
            public X509Certificate[] getAcceptedIssuers()
            {
              return new X509Certificate[0];
            }
          };
          localSecureRandom = new SecureRandom();
          ((SSLContext)localObject1).init(null, new X509TrustManager[] { localObject2 }, localSecureRandom);
          HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
          paramString.setHostnameVerifier(new HostnameVerifier()
          {
            public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
            {
              return true;
            }
          });
        }
        if (paramNetworkTimeOut != null) {
          continue;
        }
        i = connectionTimeout;
        if (i > 0) {
          localHttpURLConnection.setConnectTimeout(i);
        }
        if (paramNetworkTimeOut != null) {
          continue;
        }
        i = readTimout;
        if (i > 0) {
          localHttpURLConnection.setReadTimeout(i);
        }
        return localHttpURLConnection;
        localObject2 = ReflectHelper.getInstanceField(localHttpURLConnection, "methodTokens");
        paramString = (String)localObject2;
        break;
        localObject2 = ReflectHelper.getInstanceField(localHttpURLConnection, "PERMITTED_USER_METHODS");
        paramString = (String)localObject2;
      }
    }
  }
  
  private HTTPPart getFilePostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2)
    throws Throwable
  {
    String str = UUID.randomUUID().toString();
    paramHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str);
    MultiPart localMultiPart = new MultiPart();
    paramHttpURLConnection = new StringPart();
    if (paramArrayList1 != null)
    {
      paramString = paramArrayList1.iterator();
      while (paramString.hasNext())
      {
        paramArrayList1 = (KVPair)paramString.next();
        paramHttpURLConnection.append("--").append(str).append("\r\n");
        paramHttpURLConnection.append("Content-Disposition: form-data; name=\"").append(paramArrayList1.name).append("\"\r\n\r\n");
        paramHttpURLConnection.append((String)paramArrayList1.value).append("\r\n");
      }
    }
    localMultiPart.append(paramHttpURLConnection);
    paramArrayList1 = paramArrayList2.iterator();
    if (paramArrayList1.hasNext())
    {
      paramArrayList2 = (KVPair)paramArrayList1.next();
      StringPart localStringPart = new StringPart();
      paramHttpURLConnection = new File((String)paramArrayList2.value);
      localStringPart.append("--").append(str).append("\r\n");
      localStringPart.append("Content-Disposition: form-data; name=\"").append(paramArrayList2.name).append("\"; filename=\"").append(paramHttpURLConnection.getName()).append("\"\r\n");
      paramString = URLConnection.getFileNameMap().getContentTypeFor((String)paramArrayList2.value);
      if (paramString != null)
      {
        paramHttpURLConnection = paramString;
        if (paramString.length() > 0) {}
      }
      else
      {
        if ((!((String)paramArrayList2.value).toLowerCase().endsWith("jpg")) && (!((String)paramArrayList2.value).toLowerCase().endsWith("jpeg"))) {
          break label392;
        }
        paramHttpURLConnection = "image/jpeg";
      }
      for (;;)
      {
        localStringPart.append("Content-Type: ").append(paramHttpURLConnection).append("\r\n\r\n");
        localMultiPart.append(localStringPart);
        paramHttpURLConnection = new FilePart();
        paramHttpURLConnection.setFile((String)paramArrayList2.value);
        localMultiPart.append(paramHttpURLConnection);
        paramHttpURLConnection = new StringPart();
        paramHttpURLConnection.append("\r\n");
        localMultiPart.append(paramHttpURLConnection);
        break;
        label392:
        if (((String)paramArrayList2.value).toLowerCase().endsWith("png"))
        {
          paramHttpURLConnection = "image/png";
        }
        else if (((String)paramArrayList2.value).toLowerCase().endsWith("gif"))
        {
          paramHttpURLConnection = "image/gif";
        }
        else
        {
          paramHttpURLConnection = new FileInputStream((String)paramArrayList2.value);
          paramString = URLConnection.guessContentTypeFromStream(paramHttpURLConnection);
          paramHttpURLConnection.close();
          if (paramString != null)
          {
            paramHttpURLConnection = paramString;
            if (paramString.length() > 0) {}
          }
          else
          {
            paramHttpURLConnection = "application/octet-stream";
          }
        }
      }
    }
    paramHttpURLConnection = new StringPart();
    paramHttpURLConnection.append("--").append(str).append("--\r\n");
    localMultiPart.append(paramHttpURLConnection);
    return localMultiPart;
  }
  
  private HTTPPart getTextPostHTTPPart(HttpURLConnection paramHttpURLConnection, String paramString, ArrayList<KVPair<String>> paramArrayList)
    throws Throwable
  {
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    paramHttpURLConnection = new StringPart();
    if (paramArrayList != null) {
      paramHttpURLConnection.append(kvPairsToUrl(paramArrayList));
    }
    return paramHttpURLConnection;
  }
  
  private void httpPatchImpl(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPatch: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = new HttpPatch(str);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramArrayList1.setHeader(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramString = new FilePart();
    paramString.setOnReadListener(paramOnReadListener);
    paramString.setFile((String)paramKVPair.value);
    paramString.setOffset(paramLong);
    paramString = new InputStreamEntity(paramString.toInputStream(), paramString.length() - paramLong);
    paramString.setContentEncoding("application/offset+octet-stream");
    paramArrayList1.setEntity(paramString);
    paramString = new BasicHttpParams();
    int i;
    if (paramNetworkTimeOut == null)
    {
      i = connectionTimeout;
      if (i > 0) {
        HttpConnectionParams.setConnectionTimeout(paramString, i);
      }
      if (paramNetworkTimeOut != null) {
        break label477;
      }
      i = readTimout;
      label247:
      if (i > 0) {
        HttpConnectionParams.setSoTimeout(paramString, i);
      }
      paramArrayList1.setParams(paramString);
      if (!str.startsWith("https://")) {
        break label487;
      }
      paramString = KeyStore.getInstance(KeyStore.getDefaultType());
      paramString.load(null, null);
      paramString = new SSLSocketFactoryEx(paramString);
      paramString.allowAllHostnameVerifier();
      paramKVPair = new BasicHttpParams();
      HttpProtocolParams.setVersion(paramKVPair, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(paramKVPair, "UTF-8");
      paramArrayList2 = new SchemeRegistry();
      paramArrayList2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      paramArrayList2.register(new Scheme("https", paramString, 443));
      paramString = new DefaultHttpClient(new ThreadSafeClientConnManager(paramKVPair, paramArrayList2), paramKVPair);
      label391:
      paramArrayList1 = paramString.execute(paramArrayList1);
      if (paramHttpResponseCallback == null) {
        break label515;
      }
    }
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl(paramArrayList1));
        paramString.getConnectionManager().shutdown();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        label477:
        label487:
        throw paramArrayList1;
      }
      finally
      {
        paramString.getConnectionManager().shutdown();
      }
      i = paramNetworkTimeOut.connectionTimeout;
      break;
      i = paramNetworkTimeOut.readTimout;
      break label247;
      paramString = new DefaultHttpClient();
      break label391;
      label515:
      paramString.getConnectionManager().shutdown();
    }
  }
  
  private String kvPairsToUrl(ArrayList<KVPair<String>> paramArrayList)
    throws Throwable
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (KVPair)localIterator.next();
      String str = Data.urlEncode(paramArrayList.name, "utf-8");
      if (paramArrayList.value != null) {}
      for (paramArrayList = Data.urlEncode((String)paramArrayList.value, "utf-8");; paramArrayList = "")
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append('&');
        }
        localStringBuilder.append(str).append('=').append(paramArrayList);
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public String downloadCache(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("downloading: " + paramString1, new Object[0]);
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = new File(R.getCachePath(paramContext, paramString2), Data.MD5(paramString1));
      if ((paramBoolean) && (((File)localObject1).exists()))
      {
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return ((File)localObject1).getAbsolutePath();
      }
    }
    HttpURLConnection localHttpURLConnection = getConnection(paramString1, paramNetworkTimeOut);
    localHttpURLConnection.connect();
    int i = localHttpURLConnection.getResponseCode();
    if (i == 200)
    {
      Object localObject2 = null;
      paramNetworkTimeOut = null;
      Map localMap = localHttpURLConnection.getHeaderFields();
      localObject1 = localObject2;
      if (localMap != null)
      {
        List localList = (List)localMap.get("Content-Disposition");
        localObject1 = localObject2;
        if (localList != null)
        {
          localObject1 = localObject2;
          if (localList.size() > 0)
          {
            localObject2 = ((String)localList.get(0)).split(";");
            int j = localObject2.length;
            i = 0;
            for (;;)
            {
              localObject1 = paramNetworkTimeOut;
              if (i >= j) {
                break;
              }
              localObject1 = localObject2[i];
              if (((String)localObject1).trim().startsWith("filename"))
              {
                localObject1 = localObject1.split("=")[1];
                paramNetworkTimeOut = (NetworkTimeOut)localObject1;
                if (((String)localObject1).startsWith("\""))
                {
                  paramNetworkTimeOut = (NetworkTimeOut)localObject1;
                  if (((String)localObject1).endsWith("\"")) {
                    paramNetworkTimeOut = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
                  }
                }
              }
              i += 1;
            }
          }
        }
      }
      paramNetworkTimeOut = (NetworkTimeOut)localObject1;
      if (localObject1 == null)
      {
        localObject2 = Data.MD5(paramString1);
        paramNetworkTimeOut = (NetworkTimeOut)localObject2;
        if (localMap != null)
        {
          localObject1 = (List)localMap.get("Content-Type");
          paramNetworkTimeOut = (NetworkTimeOut)localObject2;
          if (localObject1 != null)
          {
            paramNetworkTimeOut = (NetworkTimeOut)localObject2;
            if (((List)localObject1).size() > 0)
            {
              paramNetworkTimeOut = (String)((List)localObject1).get(0);
              if (paramNetworkTimeOut != null) {
                break label556;
              }
              paramNetworkTimeOut = "";
              if (!paramNetworkTimeOut.startsWith("image/")) {
                break label566;
              }
              paramNetworkTimeOut = paramNetworkTimeOut.substring("image/".length());
              localObject1 = new StringBuilder().append((String)localObject2).append(".");
              paramString1 = paramNetworkTimeOut;
              if ("jpeg".equals(paramNetworkTimeOut)) {
                paramString1 = "jpg";
              }
              paramNetworkTimeOut = paramString1;
            }
          }
        }
      }
      for (;;)
      {
        paramContext = new File(R.getCachePath(paramContext, paramString2), paramNetworkTimeOut);
        if ((!paramBoolean) || (!paramContext.exists())) {
          break label678;
        }
        localHttpURLConnection.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return paramContext.getAbsolutePath();
        label556:
        paramNetworkTimeOut = paramNetworkTimeOut.trim();
        break;
        label566:
        i = paramString1.lastIndexOf('/');
        localObject1 = null;
        if (i > 0) {
          localObject1 = paramString1.substring(i + 1);
        }
        paramNetworkTimeOut = (NetworkTimeOut)localObject2;
        if (localObject1 != null)
        {
          paramNetworkTimeOut = (NetworkTimeOut)localObject2;
          if (((String)localObject1).length() > 0)
          {
            i = ((String)localObject1).lastIndexOf('.');
            paramNetworkTimeOut = (NetworkTimeOut)localObject2;
            if (i > 0)
            {
              paramNetworkTimeOut = (NetworkTimeOut)localObject2;
              if (((String)localObject1).length() - i < 10) {
                paramNetworkTimeOut = (String)localObject2 + ((String)localObject1).substring(i);
              }
            }
          }
        }
      }
      label678:
      if (!paramContext.getParentFile().exists()) {
        paramContext.getParentFile().mkdirs();
      }
      if (paramContext.exists()) {
        paramContext.delete();
      }
      try
      {
        paramString1 = localHttpURLConnection.getInputStream();
        paramString2 = new FileOutputStream(paramContext);
        paramNetworkTimeOut = new byte['Ѐ'];
        for (i = paramString1.read(paramNetworkTimeOut); i > 0; i = paramString1.read(paramNetworkTimeOut)) {
          paramString2.write(paramNetworkTimeOut, 0, i);
        }
        paramString2.flush();
        paramString1.close();
        paramString2.close();
        localHttpURLConnection.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return paramContext.getAbsolutePath();
      }
      catch (Throwable paramString1)
      {
        if (paramContext.exists()) {
          paramContext.delete();
        }
        throw paramString1;
      }
    }
    paramString1 = new StringBuilder();
    paramString2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getErrorStream(), Charset.forName("utf-8")));
    for (paramContext = paramString2.readLine(); paramContext != null; paramContext = paramString2.readLine())
    {
      if (paramString1.length() > 0) {
        paramString1.append('\n');
      }
      paramString1.append(paramContext);
    }
    paramString2.close();
    localHttpURLConnection.disconnect();
    paramContext = new HashMap();
    paramContext.put("error", paramString1.toString());
    paramContext.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramContext));
  }
  
  public void getHttpPostResponse(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    paramNetworkTimeOut.setChunkedStreamingMode(0);
    ArrayList localArrayList;
    if ((paramKVPair != null) && (paramKVPair.value != null) && (new File((String)paramKVPair.value).exists()))
    {
      localArrayList = new ArrayList();
      localArrayList.add(paramKVPair);
    }
    for (paramString = getFilePostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1, localArrayList); paramArrayList2 != null; paramString = getTextPostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1))
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramKVPair = (KVPair)paramArrayList1.next();
        paramNetworkTimeOut.setRequestProperty(paramKVPair.name, (String)paramKVPair.value);
      }
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramKVPair = new byte[65536];
    for (int i = paramString.read(paramKVPair); i > 0; i = paramString.read(paramKVPair)) {
      paramArrayList1.write(paramKVPair, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramNetworkTimeOut));
        paramNetworkTimeOut.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        paramNetworkTimeOut.disconnect();
      }
      paramNetworkTimeOut.disconnect();
    }
  }
  
  public String httpGet(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpGet: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, paramNetworkTimeOut);
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramArrayList1.connect();
    int i = paramArrayList1.getResponseCode();
    if (i == 200)
    {
      paramArrayList2 = new StringBuilder();
      paramNetworkTimeOut = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramNetworkTimeOut.readLine(); paramString != null; paramString = paramNetworkTimeOut.readLine())
      {
        if (paramArrayList2.length() > 0) {
          paramArrayList2.append('\n');
        }
        paramArrayList2.append(paramString);
      }
      paramNetworkTimeOut.close();
      paramArrayList1.disconnect();
      paramString = paramArrayList2.toString();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramArrayList2 = new StringBuilder();
    paramNetworkTimeOut = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramNetworkTimeOut.readLine(); paramString != null; paramString = paramNetworkTimeOut.readLine())
    {
      if (paramArrayList2.length() > 0) {
        paramArrayList2.append('\n');
      }
      paramArrayList2.append(paramString);
    }
    paramNetworkTimeOut.close();
    paramArrayList1.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList2.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public ArrayList<KVPair<String[]>> httpHead(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpHead: " + paramString, new Object[0]);
    paramKVPair = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      paramKVPair = paramString;
      if (paramArrayList1.length() > 0) {
        paramKVPair = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(paramKVPair, paramNetworkTimeOut);
    paramString.setRequestMethod("HEAD");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramKVPair = (KVPair)paramArrayList1.next();
        paramString.setRequestProperty(paramKVPair.name, (String)paramKVPair.value);
      }
    }
    paramString.connect();
    paramKVPair = paramString.getHeaderFields();
    paramArrayList1 = new ArrayList();
    if (paramKVPair != null)
    {
      paramKVPair = paramKVPair.entrySet().iterator();
      while (paramKVPair.hasNext())
      {
        paramArrayList2 = (Map.Entry)paramKVPair.next();
        paramNetworkTimeOut = (List)paramArrayList2.getValue();
        if (paramNetworkTimeOut == null)
        {
          paramArrayList1.add(new KVPair((String)paramArrayList2.getKey(), new String[0]));
        }
        else
        {
          String[] arrayOfString = new String[paramNetworkTimeOut.size()];
          int i = 0;
          while (i < arrayOfString.length)
          {
            arrayOfString[i] = ((String)paramNetworkTimeOut.get(i));
            i += 1;
          }
          paramArrayList1.add(new KVPair((String)paramArrayList2.getKey(), arrayOfString));
        }
      }
    }
    paramString.disconnect();
    MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return paramArrayList1;
  }
  
  public void httpPatch(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      httpPatchImpl23(paramString, paramArrayList1, paramKVPair, paramLong, paramArrayList2, paramOnReadListener, paramHttpResponseCallback, paramNetworkTimeOut);
      return;
    }
    httpPatchImpl(paramString, paramArrayList1, paramKVPair, paramLong, paramArrayList2, paramOnReadListener, paramHttpResponseCallback, paramNetworkTimeOut);
  }
  
  public void httpPatchImpl23(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, long paramLong, ArrayList<KVPair<String>> paramArrayList2, OnReadListener paramOnReadListener, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPatch: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramString = getConnection(str, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    paramString.setRequestMethod("PATCH");
    paramString.setRequestProperty("Content-Type", "application/offset+octet-stream");
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (KVPair)paramArrayList1.next();
        paramString.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramString.connect();
    paramArrayList1 = paramString.getOutputStream();
    paramArrayList2 = new FilePart();
    paramArrayList2.setOnReadListener(paramOnReadListener);
    paramArrayList2.setFile((String)paramKVPair.value);
    paramArrayList2.setOffset(paramLong);
    paramKVPair = paramArrayList2.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramKVPair.read(paramArrayList2); i > 0; i = paramKVPair.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramKVPair.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList1)
      {
        throw paramArrayList1;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  public String httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramKVPair != null) && (paramKVPair.value != null) && (new File((String)paramKVPair.value).exists())) {
      localArrayList.add(paramKVPair);
    }
    return httpPostFiles(paramString, paramArrayList1, localArrayList, paramArrayList2, paramNetworkTimeOut);
  }
  
  public void httpPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramString = getFilePostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1, paramArrayList2);
      paramNetworkTimeOut.setChunkedStreamingMode(0);
    }
    while (paramArrayList3 != null)
    {
      paramArrayList1 = paramArrayList3.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (KVPair)paramArrayList1.next();
        paramNetworkTimeOut.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
      paramString = getTextPostHTTPPart(paramNetworkTimeOut, paramString, paramArrayList1);
      paramNetworkTimeOut.setFixedLengthStreamingMode((int)paramString.length());
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramString.read(paramArrayList2); i > 0; i = paramString.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramNetworkTimeOut));
        paramNetworkTimeOut.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
      finally
      {
        paramNetworkTimeOut.disconnect();
      }
      paramNetworkTimeOut.disconnect();
    }
  }
  
  public String httpPostFiles(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, ArrayList<KVPair<String>> paramArrayList3, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    final HashMap localHashMap = new HashMap();
    httpPost(paramString, paramArrayList1, paramArrayList2, paramArrayList3, new HttpResponseCallback()
    {
      public void onResponse(HttpConnection paramAnonymousHttpConnection)
        throws Throwable
      {
        int i = paramAnonymousHttpConnection.getResponseCode();
        if ((i == 200) || (i == 201))
        {
          localStringBuilder = new StringBuilder();
          localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getInputStream(), Charset.forName("utf-8")));
          for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append('\n');
            }
            localStringBuilder.append(paramAnonymousHttpConnection);
          }
          localBufferedReader.close();
          localHashMap.put("resp", localStringBuilder.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramAnonymousHttpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (paramAnonymousHttpConnection = localBufferedReader.readLine(); paramAnonymousHttpConnection != null; paramAnonymousHttpConnection = localBufferedReader.readLine())
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('\n');
          }
          localStringBuilder.append(paramAnonymousHttpConnection);
        }
        localBufferedReader.close();
        paramAnonymousHttpConnection = new HashMap();
        paramAnonymousHttpConnection.put("error", localStringBuilder.toString());
        paramAnonymousHttpConnection.put("status", Integer.valueOf(i));
        throw new Throwable(new Hashon().fromHashMap(paramAnonymousHttpConnection));
      }
    }, paramNetworkTimeOut);
    return (String)localHashMap.get("resp");
  }
  
  public String httpPut(String paramString, ArrayList<KVPair<String>> paramArrayList1, KVPair<String> paramKVPair, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("httpPut: " + paramString, new Object[0]);
    String str = paramString;
    if (paramArrayList1 != null)
    {
      paramArrayList1 = kvPairsToUrl(paramArrayList1);
      str = paramString;
      if (paramArrayList1.length() > 0) {
        str = paramString + "?" + paramArrayList1;
      }
    }
    paramArrayList1 = getConnection(str, paramNetworkTimeOut);
    paramArrayList1.setDoOutput(true);
    paramArrayList1.setChunkedStreamingMode(0);
    paramArrayList1.setRequestMethod("PUT");
    paramArrayList1.setRequestProperty("Content-Type", "application/octet-stream");
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramArrayList1.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramArrayList1.connect();
    paramString = paramArrayList1.getOutputStream();
    paramArrayList2 = new FilePart();
    paramArrayList2.setFile((String)paramKVPair.value);
    paramKVPair = paramArrayList2.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramKVPair.read(paramArrayList2); i > 0; i = paramKVPair.read(paramArrayList2)) {
      paramString.write(paramArrayList2, 0, i);
    }
    paramString.flush();
    paramKVPair.close();
    paramString.close();
    i = paramArrayList1.getResponseCode();
    if ((i == 200) || (i == 201))
    {
      paramKVPair = new StringBuilder();
      paramArrayList2 = new BufferedReader(new InputStreamReader(paramArrayList1.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
      {
        if (paramKVPair.length() > 0) {
          paramKVPair.append('\n');
        }
        paramKVPair.append(paramString);
      }
      paramArrayList2.close();
      paramArrayList1.disconnect();
      paramString = paramKVPair.toString();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramKVPair = new StringBuilder();
    paramArrayList1 = new BufferedReader(new InputStreamReader(paramArrayList1.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramArrayList1.readLine(); paramString != null; paramString = paramArrayList1.readLine())
    {
      if (paramKVPair.length() > 0) {
        paramKVPair.append('\n');
      }
      paramKVPair.append(paramString);
    }
    paramArrayList1.close();
    paramString = new HashMap();
    paramString.put("error", paramKVPair.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public String jsonPost(String paramString, ArrayList<KVPair<String>> paramArrayList1, ArrayList<KVPair<String>> paramArrayList2, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("jsonPost: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.setDoOutput(true);
    paramNetworkTimeOut.setChunkedStreamingMode(0);
    paramNetworkTimeOut.setRequestProperty("content-type", "application/json");
    if (paramArrayList2 != null)
    {
      paramString = paramArrayList2.iterator();
      while (paramString.hasNext())
      {
        paramArrayList2 = (KVPair)paramString.next();
        paramNetworkTimeOut.setRequestProperty(paramArrayList2.name, (String)paramArrayList2.value);
      }
    }
    paramString = new StringPart();
    if (paramArrayList1 != null)
    {
      paramArrayList2 = new HashMap();
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        KVPair localKVPair = (KVPair)paramArrayList1.next();
        paramArrayList2.put(localKVPair.name, localKVPair.value);
      }
      paramString.append(new Hashon().fromHashMap(paramArrayList2));
    }
    paramNetworkTimeOut.connect();
    paramArrayList1 = paramNetworkTimeOut.getOutputStream();
    paramString = paramString.toInputStream();
    paramArrayList2 = new byte[65536];
    for (int i = paramString.read(paramArrayList2); i > 0; i = paramString.read(paramArrayList2)) {
      paramArrayList1.write(paramArrayList2, 0, i);
    }
    paramArrayList1.flush();
    paramString.close();
    paramArrayList1.close();
    i = paramNetworkTimeOut.getResponseCode();
    if ((i == 200) || (i == 201))
    {
      paramArrayList1 = new StringBuilder();
      paramArrayList2 = new BufferedReader(new InputStreamReader(paramNetworkTimeOut.getInputStream(), Charset.forName("utf-8")));
      for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
      {
        if (paramArrayList1.length() > 0) {
          paramArrayList1.append('\n');
        }
        paramArrayList1.append(paramString);
      }
      paramArrayList2.close();
      paramNetworkTimeOut.disconnect();
      paramString = paramArrayList1.toString();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramArrayList1 = new StringBuilder();
    paramArrayList2 = new BufferedReader(new InputStreamReader(paramNetworkTimeOut.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = paramArrayList2.readLine(); paramString != null; paramString = paramArrayList2.readLine())
    {
      if (paramArrayList1.length() > 0) {
        paramArrayList1.append('\n');
      }
      paramArrayList1.append(paramString);
    }
    paramArrayList2.close();
    paramNetworkTimeOut.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramArrayList1.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public void rawGet(String paramString, RawNetworkCallback paramRawNetworkCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("rawGet: " + paramString, new Object[0]);
    paramNetworkTimeOut = getConnection(paramString, paramNetworkTimeOut);
    paramNetworkTimeOut.connect();
    int i = paramNetworkTimeOut.getResponseCode();
    if (i == 200)
    {
      if (paramRawNetworkCallback != null) {
        paramRawNetworkCallback.onResponse(paramNetworkTimeOut.getInputStream());
      }
      paramNetworkTimeOut.disconnect();
      MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return;
    }
    paramRawNetworkCallback = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramNetworkTimeOut.getErrorStream(), Charset.forName("utf-8")));
    for (paramString = localBufferedReader.readLine(); paramString != null; paramString = localBufferedReader.readLine())
    {
      if (paramRawNetworkCallback.length() > 0) {
        paramRawNetworkCallback.append('\n');
      }
      paramRawNetworkCallback.append(paramString);
    }
    localBufferedReader.close();
    paramNetworkTimeOut.disconnect();
    paramString = new HashMap();
    paramString.put("error", paramRawNetworkCallback.toString());
    paramString.put("status", Integer.valueOf(i));
    throw new Throwable(new Hashon().fromHashMap(paramString));
  }
  
  public void rawPost(String paramString, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, HttpResponseCallback paramHttpResponseCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    long l = System.currentTimeMillis();
    MobLog.getInstance().i("rawpost: " + paramString, new Object[0]);
    paramString = getConnection(paramString, paramNetworkTimeOut);
    paramString.setDoOutput(true);
    paramString.setChunkedStreamingMode(0);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramNetworkTimeOut = (KVPair)paramArrayList.next();
        paramString.setRequestProperty(paramNetworkTimeOut.name, (String)paramNetworkTimeOut.value);
      }
    }
    paramString.connect();
    paramArrayList = paramString.getOutputStream();
    paramHTTPPart = paramHTTPPart.toInputStream();
    paramNetworkTimeOut = new byte[65536];
    for (int i = paramHTTPPart.read(paramNetworkTimeOut); i > 0; i = paramHTTPPart.read(paramNetworkTimeOut)) {
      paramArrayList.write(paramNetworkTimeOut, 0, i);
    }
    paramArrayList.flush();
    paramHTTPPart.close();
    paramArrayList.close();
    if (paramHttpResponseCallback != null) {}
    for (;;)
    {
      try
      {
        paramHttpResponseCallback.onResponse(new HttpConnectionImpl23(paramString));
        paramString.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - l), new Object[0]);
        return;
      }
      catch (Throwable paramArrayList)
      {
        throw paramArrayList;
      }
      finally
      {
        paramString.disconnect();
      }
      paramString.disconnect();
    }
  }
  
  /* Error */
  public void rawPost(String paramString, ArrayList<KVPair<String>> paramArrayList, HTTPPart paramHTTPPart, RawNetworkCallback paramRawNetworkCallback, NetworkTimeOut paramNetworkTimeOut)
    throws Throwable
  {
    // Byte code:
    //   0: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   3: lstore 7
    //   5: invokestatic 301	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   8: new 150	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 775
    //   18: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokevirtual 309	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   35: pop
    //   36: aload_0
    //   37: aload_1
    //   38: aload 5
    //   40: invokespecial 505	com/mob/tools/network/NetworkHelper:getConnection	(Ljava/lang/String;Lcom/mob/tools/network/NetworkHelper$NetworkTimeOut;)Ljava/net/HttpURLConnection;
    //   43: astore 5
    //   45: aload 5
    //   47: iconst_1
    //   48: invokevirtual 657	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload 5
    //   53: iconst_0
    //   54: invokevirtual 660	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   57: aload_2
    //   58: ifnull +46 -> 104
    //   61: aload_2
    //   62: invokevirtual 174	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   65: astore_1
    //   66: aload_1
    //   67: invokeinterface 180 1 0
    //   72: ifeq +32 -> 104
    //   75: aload_1
    //   76: invokeinterface 184 1 0
    //   81: checkcast 186	com/mob/tools/network/KVPair
    //   84: astore_2
    //   85: aload 5
    //   87: aload_2
    //   88: getfield 199	com/mob/tools/network/KVPair:name	Ljava/lang/String;
    //   91: aload_2
    //   92: getfield 205	com/mob/tools/network/KVPair:value	Ljava/lang/Object;
    //   95: checkcast 52	java/lang/String
    //   98: invokevirtual 162	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -35 -> 66
    //   104: aload 5
    //   106: invokevirtual 508	java/net/HttpURLConnection:connect	()V
    //   109: aload 5
    //   111: invokevirtual 672	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   114: astore_1
    //   115: aload_3
    //   116: invokevirtual 675	com/mob/tools/network/HTTPPart:toInputStream	()Ljava/io/InputStream;
    //   119: astore_2
    //   120: ldc_w 676
    //   123: newarray <illegal type>
    //   125: astore_3
    //   126: aload_2
    //   127: aload_3
    //   128: invokevirtual 592	java/io/InputStream:read	([B)I
    //   131: istore 6
    //   133: iload 6
    //   135: ifle +21 -> 156
    //   138: aload_1
    //   139: aload_3
    //   140: iconst_0
    //   141: iload 6
    //   143: invokevirtual 679	java/io/OutputStream:write	([BII)V
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 592	java/io/InputStream:read	([B)I
    //   151: istore 6
    //   153: goto -20 -> 133
    //   156: aload_1
    //   157: invokevirtual 680	java/io/OutputStream:flush	()V
    //   160: aload_2
    //   161: invokevirtual 600	java/io/InputStream:close	()V
    //   164: aload_1
    //   165: invokevirtual 681	java/io/OutputStream:close	()V
    //   168: aload 5
    //   170: invokevirtual 511	java/net/HttpURLConnection:getResponseCode	()I
    //   173: istore 6
    //   175: iload 6
    //   177: sipush 200
    //   180: if_icmpne +99 -> 279
    //   183: aload 4
    //   185: ifnull +86 -> 271
    //   188: aload 5
    //   190: invokevirtual 581	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   193: astore_1
    //   194: aload 4
    //   196: aload_1
    //   197: invokeinterface 771 2 0
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 600	java/io/InputStream:close	()V
    //   210: aload 5
    //   212: invokevirtual 564	java/net/HttpURLConnection:disconnect	()V
    //   215: invokestatic 301	com/mob/tools/MobLog:getInstance	()Lcom/mob/tools/log/NLog;
    //   218: new 150	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 463
    //   228: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   234: lload 7
    //   236: lsub
    //   237: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokevirtual 309	com/mob/tools/log/NLog:i	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   250: pop
    //   251: return
    //   252: astore_2
    //   253: aload_2
    //   254: athrow
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 600	java/io/InputStream:close	()V
    //   264: aload 5
    //   266: invokevirtual 564	java/net/HttpURLConnection:disconnect	()V
    //   269: aload_2
    //   270: athrow
    //   271: aload 5
    //   273: invokevirtual 564	java/net/HttpURLConnection:disconnect	()V
    //   276: goto -61 -> 215
    //   279: new 150	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   286: astore_2
    //   287: new 603	java/io/BufferedReader
    //   290: dup
    //   291: new 605	java/io/InputStreamReader
    //   294: dup
    //   295: aload 5
    //   297: invokevirtual 608	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   300: ldc_w 470
    //   303: invokestatic 614	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   306: invokespecial 617	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   309: invokespecial 620	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 623	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +31 -> 350
    //   322: aload_2
    //   323: invokevirtual 476	java/lang/StringBuilder:length	()I
    //   326: ifle +10 -> 336
    //   329: aload_2
    //   330: bipush 10
    //   332: invokevirtual 479	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_2
    //   337: aload_1
    //   338: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual 623	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -29 -> 318
    //   350: aload_3
    //   351: invokevirtual 624	java/io/BufferedReader:close	()V
    //   354: aload 5
    //   356: invokevirtual 564	java/net/HttpURLConnection:disconnect	()V
    //   359: new 626	java/util/HashMap
    //   362: dup
    //   363: invokespecial 627	java/util/HashMap:<init>	()V
    //   366: astore_1
    //   367: aload_1
    //   368: ldc_w 629
    //   371: aload_2
    //   372: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 633	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   378: pop
    //   379: aload_1
    //   380: ldc_w 635
    //   383: iload 6
    //   385: invokestatic 641	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: invokevirtual 633	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: new 25	java/lang/Throwable
    //   395: dup
    //   396: new 643	com/mob/tools/utils/Hashon
    //   399: dup
    //   400: invokespecial 644	com/mob/tools/utils/Hashon:<init>	()V
    //   403: aload_1
    //   404: invokevirtual 648	com/mob/tools/utils/Hashon:fromHashMap	(Ljava/util/HashMap;)Ljava/lang/String;
    //   407: invokespecial 649	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   410: athrow
    //   411: astore_1
    //   412: goto -202 -> 210
    //   415: astore_1
    //   416: goto -152 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	NetworkHelper
    //   0	419	1	paramString	String
    //   0	419	2	paramArrayList	ArrayList<KVPair<String>>
    //   0	419	3	paramHTTPPart	HTTPPart
    //   0	419	4	paramRawNetworkCallback	RawNetworkCallback
    //   0	419	5	paramNetworkTimeOut	NetworkTimeOut
    //   131	253	6	i	int
    //   3	232	7	l	long
    // Exception table:
    //   from	to	target	type
    //   194	202	252	java/lang/Throwable
    //   194	202	255	finally
    //   253	255	255	finally
    //   206	210	411	java/lang/Throwable
    //   260	264	415	java/lang/Throwable
  }
  
  public static class NetworkTimeOut
  {
    public int connectionTimeout;
    public int readTimout;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */