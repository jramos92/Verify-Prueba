package com.veryfit.multi.photowall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.LruCache;

public class ImageLoader
{
  private static ImageLoader mImageLoader;
  private static LruCache<String, Bitmap> mMemoryCache;
  
  private ImageLoader()
  {
    mMemoryCache = new LruCache((int)Runtime.getRuntime().maxMemory() / 8)
    {
      protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap.getByteCount();
      }
    };
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt)
  {
    int j = paramOptions.outWidth;
    int i = 1;
    if (j > paramInt) {
      i = Math.round(j / paramInt);
    }
    return i;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static ImageLoader getInstance()
  {
    if (mImageLoader == null) {
      mImageLoader = new ImageLoader();
    }
    return mImageLoader;
  }
  
  public void addBitmapToMemoryCache(String paramString, Bitmap paramBitmap)
  {
    if (getBitmapFromMemoryCache(paramString) == null) {
      mMemoryCache.put(paramString, paramBitmap);
    }
  }
  
  public Bitmap getBitmapFromMemoryCache(String paramString)
  {
    return (Bitmap)mMemoryCache.get(paramString);
  }
  
  public void removeBitmapFromMemoryCache(String paramString)
  {
    if (getBitmapFromMemoryCache(paramString) == null) {
      mMemoryCache.remove(paramString);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\photowall\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */