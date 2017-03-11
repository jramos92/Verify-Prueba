package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;

public class HttpClientImageDownloader
  extends BaseImageDownloader
{
  private HttpClient httpClient;
  
  public HttpClientImageDownloader(Context paramContext, HttpClient paramHttpClient)
  {
    super(paramContext);
    this.httpClient = paramHttpClient;
  }
  
  protected InputStream getStreamFromNetwork(String paramString, Object paramObject)
    throws IOException
  {
    paramString = new HttpGet(paramString);
    return new BufferedHttpEntity(this.httpClient.execute(paramString).getEntity()).getContent();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\download\HttpClientImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */