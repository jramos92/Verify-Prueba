package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

public class NetworkDeniedImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public NetworkDeniedImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    switch (ImageDownloader.Scheme.ofUri(paramString))
    {
    default: 
      return this.wrappedDownloader.getStream(paramString, paramObject);
    }
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\download\NetworkDeniedImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */