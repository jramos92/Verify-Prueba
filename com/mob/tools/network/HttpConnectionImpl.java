package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class HttpConnectionImpl
  implements HttpConnection
{
  private HttpResponse response;
  
  public HttpConnectionImpl(HttpResponse paramHttpResponse)
  {
    this.response = paramHttpResponse;
  }
  
  public InputStream getErrorStream()
    throws IOException
  {
    return this.response.getEntity().getContent();
  }
  
  public Map<String, List<String>> getHeaderFields()
    throws IOException
  {
    Object localObject1 = null;
    Header[] arrayOfHeader = this.response.getAllHeaders();
    if (arrayOfHeader != null)
    {
      HashMap localHashMap = new HashMap();
      int k = arrayOfHeader.length;
      int i = 0;
      for (;;)
      {
        localObject1 = localHashMap;
        if (i >= k) {
          break;
        }
        Object localObject2 = arrayOfHeader[i];
        localObject1 = new ArrayList();
        localHashMap.put(((Header)localObject2).getName(), localObject1);
        localObject2 = ((Header)localObject2).getValue().split(",");
        if (localObject2 != null)
        {
          int m = localObject2.length;
          int j = 0;
          while (j < m)
          {
            ((List)localObject1).add(localObject2[j].trim());
            j += 1;
          }
        }
        i += 1;
      }
    }
    return (Map<String, List<String>>)localObject1;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.response.getEntity().getContent();
  }
  
  public int getResponseCode()
    throws IOException
  {
    return this.response.getStatusLine().getStatusCode();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\HttpConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */