package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader
  implements ImageDownloader
{
  protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
  protected static final int BUFFER_SIZE = 8192;
  public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
  public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
  private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
  private static final int MAX_REDIRECT_COUNT = 5;
  protected final int connectTimeout;
  protected final Context context;
  protected final int readTimeout;
  
  public BaseImageDownloader(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = 5000;
    this.readTimeout = 20000;
  }
  
  public BaseImageDownloader(Context paramContext, int paramInt1, int paramInt2)
  {
    this.context = paramContext.getApplicationContext();
    this.connectTimeout = paramInt1;
    this.readTimeout = paramInt2;
  }
  
  private HttpURLConnection connectTo(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
    paramString.setConnectTimeout(this.connectTimeout);
    paramString.setReadTimeout(this.readTimeout);
    paramString.connect();
    return paramString;
  }
  
  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    switch (ImageDownloader.Scheme.ofUri(paramString))
    {
    default: 
      return getStreamFromOtherSource(paramString, paramObject);
    case ???: 
    case ???: 
      return getStreamFromNetwork(paramString, paramObject);
    case ???: 
      return getStreamFromFile(paramString, paramObject);
    case ???: 
      return getStreamFromContent(paramString, paramObject);
    case ???: 
      return getStreamFromAssets(paramString, paramObject);
    }
    return getStreamFromDrawable(paramString, paramObject);
  }
  
  protected InputStream getStreamFromAssets(String paramString, Object paramObject)
    throws IOException
  {
    paramString = ImageDownloader.Scheme.ASSETS.crop(paramString);
    return this.context.getAssets().open(paramString);
  }
  
  protected InputStream getStreamFromContent(String paramString, Object paramObject)
    throws FileNotFoundException
  {
    return this.context.getContentResolver().openInputStream(Uri.parse(paramString));
  }
  
  protected InputStream getStreamFromDrawable(String paramString, Object paramObject)
  {
    int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(paramString));
    paramString = ((BitmapDrawable)this.context.getResources().getDrawable(i)).getBitmap();
    paramObject = new ByteArrayOutputStream();
    paramString.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)paramObject);
    return new ByteArrayInputStream(((ByteArrayOutputStream)paramObject).toByteArray());
  }
  
  protected InputStream getStreamFromFile(String paramString, Object paramObject)
    throws IOException
  {
    return new BufferedInputStream(new FileInputStream(ImageDownloader.Scheme.FILE.crop(paramString)), 8192);
  }
  
  protected InputStream getStreamFromNetwork(String paramString, Object paramObject)
    throws IOException
  {
    paramString = connectTo(paramString);
    int i = 0;
    while ((paramString.getResponseCode() / 100 == 3) && (i < 5))
    {
      paramString = connectTo(paramString.getHeaderField("Location"));
      i += 1;
    }
    return new BufferedInputStream(paramString.getInputStream(), 8192);
  }
  
  protected InputStream getStreamFromOtherSource(String paramString, Object paramObject)
    throws IOException
  {
    throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] { paramString }));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\download\BaseImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */