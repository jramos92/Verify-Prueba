package u.aly;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class bw
{
  private static final String a = bw.class.getName();
  private Map<String, String> b;
  
  private static String a(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        str = localBufferedReader.readLine();
        if (str != null) {}
      }
      catch (IOException localIOException)
      {
        String str;
        br.b(a, "Caught IOException in convertStreamToString()", localIOException);
        try
        {
          paramInputStream.close();
          return null;
        }
        catch (IOException paramInputStream)
        {
          br.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
          return null;
        }
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw ((Throwable)localObject);
        }
        catch (IOException paramInputStream)
        {
          br.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
          return null;
        }
      }
      try
      {
        paramInputStream.close();
        return localStringBuilder.toString();
      }
      catch (IOException paramInputStream)
      {
        br.b(a, "Caught IOException in convertStreamToString()", paramInputStream);
      }
      localStringBuilder.append(str + "\n");
    }
    return null;
  }
  
  private JSONObject a(String paramString)
  {
    int i = new Random().nextInt(1000);
    label472:
    label522:
    label524:
    for (;;)
    {
      Object localObject2;
      try
      {
        str1 = System.getProperty("line.separator");
        if (paramString.length() <= 1)
        {
          br.b(a, i + ":\tInvalid baseUrl.");
          return null;
        }
        br.a(a, i + ":\tget: " + paramString);
        localObject1 = new HttpGet(paramString);
        if ((this.b != null) && (this.b.size() > 0))
        {
          localObject2 = this.b.keySet().iterator();
          if (((Iterator)localObject2).hasNext()) {
            continue;
          }
        }
        localObject2 = new DefaultHttpClient(b()).execute((HttpUriRequest)localObject1);
        if (((HttpResponse)localObject2).getStatusLine().getStatusCode() != 200) {
          break label472;
        }
        localObject1 = ((HttpResponse)localObject2).getEntity();
        if (localObject1 == null) {
          break label522;
        }
        localObject1 = ((HttpEntity)localObject1).getContent();
        localObject2 = ((HttpResponse)localObject2).getFirstHeader("Content-Encoding");
        if ((localObject2 == null) || (!((Header)localObject2).getValue().equalsIgnoreCase("gzip"))) {
          continue;
        }
        br.a(a, i + "  Use GZIPInputStream get data....");
        localObject1 = new GZIPInputStream((InputStream)localObject1);
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        String str1;
        Object localObject1;
        String str2;
        br.c(a, i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        if ((localObject2 == null) || (!((Header)localObject2).getValue().equalsIgnoreCase("deflate"))) {
          break label524;
        }
        br.a(a, i + "  Use InflaterInputStream get data....");
        InflaterInputStream localInflaterInputStream = new InflaterInputStream(localClientProtocolException);
        continue;
      }
      catch (Exception localException)
      {
        br.c(a, i + ":\tIOException,Failed to send message." + paramString, localException);
        return null;
      }
      localObject1 = a((InputStream)localObject1);
      br.a(a, i + ":\tresponse: " + str1 + (String)localObject1);
      if (localObject1 == null)
      {
        return null;
        str2 = (String)((Iterator)localObject2).next();
        ((HttpGet)localObject1).addHeader(str2, (String)this.b.get(str2));
      }
      else
      {
        return new JSONObject(localException);
        br.c(a, i + ":\tFailed to send message. StatusCode = " + ((HttpResponse)localObject2).getStatusLine().getStatusCode() + cd.a + paramString);
        return null;
      }
    }
  }
  
  private JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    int i = 1;
    Object localObject2 = paramJSONObject.toString();
    int j = new Random().nextInt(1000);
    br.c(a, j + ":\trequest: " + paramString + cd.a + (String)localObject2);
    paramJSONObject = new HttpPost(paramString);
    Object localObject1 = new DefaultHttpClient(b());
    try
    {
      if (!a()) {
        break label301;
      }
      localObject2 = cc.a((String)localObject2, Charset.defaultCharset().name());
      paramJSONObject.addHeader("Content-Encoding", "deflate");
      paramJSONObject.setEntity(new InputStreamEntity(new ByteArrayInputStream((byte[])localObject2), localObject2.length));
      localObject1 = ((HttpClient)localObject1).execute(paramJSONObject);
      paramJSONObject = ((HttpResponse)localObject1).getFirstHeader("Content-Type");
      if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200) {
        break label384;
      }
    }
    catch (ClientProtocolException paramJSONObject)
    {
      for (;;)
      {
        boolean bool;
        br.c(a, j + ":\tClientProtocolException,Failed to send message." + paramString, paramJSONObject);
        return null;
        i = 0;
      }
      return new JSONObject(paramJSONObject);
      br.c(a, j + ":\tFailed to send message. StatusCode = " + ((HttpResponse)localObject1).getStatusLine().getStatusCode() + cd.a + paramString);
      return null;
    }
    catch (IOException paramJSONObject)
    {
      br.c(a, j + ":\tIOException,Failed to send message." + paramString, paramJSONObject);
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      br.c(a, j + ":\tIOException,Failed to send message." + paramString, paramJSONObject);
      return null;
    }
    bool = cd.a(paramJSONObject, "application/json");
    if ((i != 0) && (bool))
    {
      paramJSONObject = ((HttpResponse)localObject1).getEntity();
      if (paramJSONObject == null) {
        break label522;
      }
      paramJSONObject = paramJSONObject.getContent();
      localObject1 = ((HttpResponse)localObject1).getFirstHeader("Content-Encoding");
      if ((localObject1 == null) || (!((Header)localObject1).getValue().equalsIgnoreCase("deflate"))) {
        break label519;
      }
      paramJSONObject = new InflaterInputStream(paramJSONObject);
    }
    label301:
    label384:
    label519:
    for (;;)
    {
      paramJSONObject = a(paramJSONObject);
      br.a(a, j + ":\tresponse: " + cd.a + paramJSONObject);
      if (paramJSONObject == null)
      {
        return null;
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(new BasicNameValuePair("content", (String)localObject2));
        paramJSONObject.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        break;
      }
    }
    label522:
    return null;
  }
  
  private HttpParams b()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, System.getProperty("http.agent"));
    return localBasicHttpParams;
  }
  
  private void b(String paramString)
  {
    if ((cd.d(paramString)) || (!(bx.c.equals(paramString.trim()) ^ bx.b.equals(paramString.trim())))) {
      throw new RuntimeException("验证请求方式失败[" + paramString + "]");
    }
  }
  
  public bw a(Map<String, String> paramMap)
  {
    this.b = paramMap;
    return this;
  }
  
  public <T extends by> T a(bx parambx, Class<T> paramClass)
  {
    String str = parambx.c().trim();
    b(str);
    if (bx.c.equals(str)) {
      parambx = a(parambx.b());
    }
    for (;;)
    {
      if (parambx == null)
      {
        return null;
        if (bx.b.equals(str)) {
          parambx = a(parambx.d, parambx.a());
        }
      }
      else
      {
        try
        {
          parambx = (by)paramClass.getConstructor(new Class[] { JSONObject.class }).newInstance(new Object[] { parambx });
          return parambx;
        }
        catch (SecurityException parambx)
        {
          br.b(a, "SecurityException", parambx);
          return null;
        }
        catch (NoSuchMethodException parambx)
        {
          for (;;)
          {
            br.b(a, "NoSuchMethodException", parambx);
          }
        }
        catch (IllegalArgumentException parambx)
        {
          for (;;)
          {
            br.b(a, "IllegalArgumentException", parambx);
          }
        }
        catch (InstantiationException parambx)
        {
          for (;;)
          {
            br.b(a, "InstantiationException", parambx);
          }
        }
        catch (IllegalAccessException parambx)
        {
          for (;;)
          {
            br.b(a, "IllegalAccessException", parambx);
          }
        }
        catch (InvocationTargetException parambx)
        {
          for (;;)
          {
            br.b(a, "InvocationTargetException", parambx);
          }
        }
      }
      parambx = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */