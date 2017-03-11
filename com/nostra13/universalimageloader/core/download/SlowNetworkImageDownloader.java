package com.nostra13.universalimageloader.core.download;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SlowNetworkImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;
  
  public SlowNetworkImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    paramObject = this.wrappedDownloader.getStream(paramString, paramObject);
    switch (ImageDownloader.Scheme.ofUri(paramString))
    {
    default: 
      return (InputStream)paramObject;
    }
    return new FlushedInputStream((InputStream)paramObject);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\download\SlowNetworkImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */