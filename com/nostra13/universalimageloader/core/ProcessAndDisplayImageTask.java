package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

class ProcessAndDisplayImageTask
  implements Runnable
{
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private final Bitmap bitmap;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  private final ImageLoadingInfo imageLoadingInfo;
  
  public ProcessAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, Bitmap paramBitmap, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.bitmap = paramBitmap;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
  }
  
  public void run()
  {
    if (this.engine.configuration.loggingEnabled) {
      L.i("PostProcess image before displaying [%s]", new Object[] { this.imageLoadingInfo.memoryCacheKey });
    }
    Bitmap localBitmap = this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap);
    if (localBitmap != this.bitmap) {
      this.bitmap.recycle();
    }
    this.handler.post(new DisplayBitmapTask(localBitmap, this.imageLoadingInfo, this.engine));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\ProcessAndDisplayImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */