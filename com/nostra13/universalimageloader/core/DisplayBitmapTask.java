package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.utils.L;

final class DisplayBitmapTask
  implements Runnable
{
  private static final String LOG_DISPLAY_IMAGE_IN_IMAGEVIEW = "Display image in ImageView [%s]";
  private static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
  private final Bitmap bitmap;
  private final BitmapDisplayer displayer;
  private final ImageLoaderEngine engine;
  private final String imageUri;
  private final ImageView imageView;
  private final ImageLoadingListener listener;
  private boolean loggingEnabled;
  private final String memoryCacheKey;
  
  public DisplayBitmapTask(Bitmap paramBitmap, ImageLoadingInfo paramImageLoadingInfo, ImageLoaderEngine paramImageLoaderEngine)
  {
    this.bitmap = paramBitmap;
    this.imageUri = paramImageLoadingInfo.uri;
    this.imageView = paramImageLoadingInfo.imageView;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.displayer = paramImageLoadingInfo.options.getDisplayer();
    this.listener = paramImageLoadingInfo.listener;
    this.engine = paramImageLoaderEngine;
  }
  
  private boolean isViewWasReused()
  {
    String str = this.engine.getLoadingUriForView(this.imageView);
    return !this.memoryCacheKey.equals(str);
  }
  
  public void run()
  {
    if (isViewWasReused())
    {
      if (this.loggingEnabled) {
        L.i("ImageView is reused for another image. Task is cancelled. [%s]", new Object[] { this.memoryCacheKey });
      }
      this.listener.onLoadingCancelled(this.imageUri, this.imageView);
      return;
    }
    if (this.loggingEnabled) {
      L.i("Display image in ImageView [%s]", new Object[] { this.memoryCacheKey });
    }
    Bitmap localBitmap = this.displayer.display(this.bitmap, this.imageView);
    this.listener.onLoadingComplete(this.imageUri, this.imageView, localBitmap);
    this.engine.cancelDisplayTaskFor(this.imageView);
  }
  
  void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\DisplayBitmapTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */