package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpConnectionImpl23
  implements HttpConnection
{
  private HttpURLConnection conn;
  
  public HttpConnectionImpl23(HttpURLConnection paramHttpURLConnection)
  {
    this.conn = paramHttpURLConnection;
  }
  
  public InputStream getErrorStream()
    throws IOException
  {
    return this.conn.getErrorStream();
  }
  
  public Map<String, List<String>> getHeaderFields()
    throws IOException
  {
    return this.conn.getHeaderFields();
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.conn.getInputStream();
  }
  
  public int getResponseCode()
    throws IOException
  {
    return this.conn.getResponseCode();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\HttpConnectionImpl23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */