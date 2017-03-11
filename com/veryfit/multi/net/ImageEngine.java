package com.veryfit.multi.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;

public class ImageEngine
{
  private static final String PATH_CACHE = "veryfit/cache/image";
  private static final String TAG = "ImageEngine";
  private static ImageEngine mInstance = null;
  private ImageLoader mImageLoader;
  
  private ImageEngine() {}
  
  private ImageEngine(Context paramContext)
  {
    File localFile = StorageUtils.getOwnCacheDirectory(paramContext, "veryfit/cache/image");
    paramContext = new ImageLoaderConfiguration.Builder(paramContext).threadPriority(3).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).memoryCache(new UsingFreqLimitedMemoryCache(10485760)).discCache(new UnlimitedDiscCache(localFile)).build();
    ImageLoader.getInstance().init(paramContext);
    this.mImageLoader = ImageLoader.getInstance();
  }
  
  public static ImageEngine getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new ImageEngine(paramContext.getApplicationContext());
    }
    return mInstance;
  }
  
  public ImageBuilder createImageBuilder()
  {
    return new ImageBuilder(new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().build(), this);
  }
  
  public ImageBuilder createImageBuilder(int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig)
  {
    DisplayImageOptions.Builder localBuilder = new DisplayImageOptions.Builder().showStubImage(paramInt1).showImageForEmptyUri(paramInt2).showImageOnFail(paramInt3).cacheInMemory().cacheOnDisc();
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.RGB_565;
    }
    return new ImageBuilder(localBuilder.bitmapConfig(localConfig).build(), this);
  }
  
  public ImageBuilder createImageBuilder(int paramInt1, int paramInt2, int paramInt3, Bitmap.Config paramConfig, int paramInt4)
  {
    DisplayImageOptions.Builder localBuilder = new DisplayImageOptions.Builder().showStubImage(paramInt1).showImageForEmptyUri(paramInt2).showImageOnFail(paramInt3).cacheInMemory().cacheOnDisc();
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.RGB_565;
    }
    return new ImageBuilder(localBuilder.bitmapConfig(localConfig).displayer(new RoundedBitmapDisplayer(paramInt4)).build(), this);
  }
  
  public boolean displayImage(String paramString, ImageView paramImageView, ImageBuilder paramImageBuilder)
  {
    if (paramImageBuilder == null) {
      return false;
    }
    this.mImageLoader.displayImage(paramString, paramImageView, paramImageBuilder.getOption(), new ImageLoadingListener()
    {
      public void onLoadingCancelled(String paramAnonymousString, View paramAnonymousView) {}
      
      public void onLoadingComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap) {}
      
      public void onLoadingFailed(String paramAnonymousString, View paramAnonymousView, FailReason paramAnonymousFailReason)
      {
        Log.e("ImageEngine", "loading file " + paramAnonymousString + " failed　");
        paramAnonymousView = ImageEngine.this.mImageLoader.getDiscCache().get(paramAnonymousString);
        if (paramAnonymousView.exists())
        {
          Log.e("ImageEngine", "delete wrong  file " + paramAnonymousString);
          paramAnonymousView.delete();
        }
      }
      
      public void onLoadingStarted(String paramAnonymousString, View paramAnonymousView) {}
    });
    return true;
  }
  
  ImageLoader getImageLoager()
  {
    return this.mImageLoader;
  }
  
  public void releaseMemory()
  {
    this.mImageLoader.clearMemoryCache();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\ImageEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */