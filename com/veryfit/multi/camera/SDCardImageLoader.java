package com.veryfit.multi.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SDCardImageLoader
{
  private static SDCardImageLoader imageLoader;
  private ExecutorService executorService = Executors.newFixedThreadPool(3);
  private Handler handler = new Handler();
  private LruCache<String, Bitmap> imageCache;
  private int screenH;
  private int screenW;
  
  private SDCardImageLoader(int paramInt1, int paramInt2)
  {
    this.screenW = paramInt1;
    this.screenH = paramInt2;
    this.imageCache = new LruCache((int)(Runtime.getRuntime().maxMemory() / 1024L) / 8)
    {
      protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
      }
    };
  }
  
  public static final int caculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int i = 1;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 1;
    }
    if ((k > paramInt2) || (j > paramInt1))
    {
      i = Math.round(k / paramInt2);
      paramInt1 = Math.round(j / paramInt1);
      if (i >= paramInt1) {
        break label63;
      }
    }
    for (;;)
    {
      return i;
      label63:
      i = paramInt1;
    }
  }
  
  public static final Bitmap compressBitmap(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = caculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
  
  public static SDCardImageLoader getInstance()
  {
    if (imageLoader == null) {
      imageLoader = new SDCardImageLoader(ScreenUtils.getScreenW(), ScreenUtils.getScreenH());
    }
    return imageLoader;
  }
  
  private Bitmap loadDrawable(final int paramInt, final String paramString, final ImageCallback paramImageCallback)
  {
    if (this.imageCache.get(paramString) != null) {
      return (Bitmap)this.imageCache.get(paramString);
    }
    this.executorService.submit(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          int j;
          try
          {
            final Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
            int i = ((BitmapFactory.Options)localObject).outWidth;
            j = ((BitmapFactory.Options)localObject).outHeight;
            if (i == 0) {
              break;
            }
            if (j == 0) {
              return;
            }
            ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
            if (i > j)
            {
              if (i > SDCardImageLoader.this.screenW) {
                ((BitmapFactory.Options)localObject).inSampleSize *= i / SDCardImageLoader.this.screenW;
              }
              ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
              localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
              SDCardImageLoader.this.imageCache.put(paramString, localObject);
              if (paramImageCallback == null) {
                break;
              }
              SDCardImageLoader.this.handler.post(new Runnable()
              {
                public void run()
                {
                  this.val$callback.imageLoaded(localObject);
                }
              });
              return;
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
          if (j > SDCardImageLoader.this.screenH) {
            localException.inSampleSize *= j / SDCardImageLoader.this.screenH;
          }
        }
      }
    });
    return null;
  }
  
  public void addBitmapToMemoryCache(String paramString, Bitmap paramBitmap)
  {
    if (getBitmapFromMemoryCache(paramString) == null) {
      this.imageCache.put(paramString, paramBitmap);
    }
  }
  
  public Bitmap compressBitmap(String paramString)
  {
    int n = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int j = localOptions.outWidth;
    int i = localOptions.outHeight;
    int i1 = j / ScreenUtils.getScreenW();
    int m = i / ScreenUtils.getScreenH();
    i = 1;
    if (i1 > m)
    {
      j = 1;
      if (m < 1) {
        break label134;
      }
      k = 1;
      label71:
      if ((k & j) != 0) {
        i = i1;
      }
      if (m <= i1) {
        break label140;
      }
      j = 1;
      label90:
      if (i1 < 1) {
        break label145;
      }
    }
    label134:
    label140:
    label145:
    for (int k = n;; k = 0)
    {
      if ((k & j) != 0) {
        i = m;
      }
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = i;
      return BitmapFactory.decodeFile(paramString, localOptions);
      j = 0;
      break;
      k = 0;
      break label71;
      j = 0;
      break label90;
    }
  }
  
  public Bitmap getBitmapFromMemoryCache(String paramString)
  {
    return (Bitmap)this.imageCache.get(paramString);
  }
  
  public void loadImage(int paramInt, final String paramString, final ImageView paramImageView)
  {
    Bitmap localBitmap = loadDrawable(paramInt, paramString, new ImageCallback()
    {
      public void imageLoaded(Bitmap paramAnonymousBitmap)
      {
        if (paramImageView.getTag().equals(paramString))
        {
          if (paramAnonymousBitmap != null) {
            paramImageView.setImageBitmap(paramAnonymousBitmap);
          }
        }
        else {
          return;
        }
        paramImageView.setImageResource(2130837559);
      }
    });
    if (localBitmap != null)
    {
      if (paramImageView.getTag().equals(paramString)) {
        paramImageView.setImageBitmap(localBitmap);
      }
      return;
    }
    paramImageView.setImageResource(2130837559);
  }
  
  public void removeBitmapFromMemoryCache(String paramString)
  {
    if (getBitmapFromMemoryCache(paramString) != null) {
      this.imageCache.remove(paramString);
    }
  }
  
  public static abstract interface ImageCallback
  {
    public abstract void imageLoaded(Bitmap paramBitmap);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\SDCardImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */