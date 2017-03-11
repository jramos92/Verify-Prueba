package com.mob.tools.network;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class HttpPatch
  extends HttpEntityEnclosingRequestBase
{
  public static final String METHOD_NAME = "PATCH";
  
  public HttpPatch() {}
  
  public HttpPatch(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpPatch(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\HttpPatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */