package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.NetworkDeniedImageDownloader;
import com.nostra13.universalimageloader.core.download.SlowNetworkImageDownloader;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration
{
  final Context context;
  final boolean customExecutor;
  final boolean customExecutorForCachedImages;
  final ImageDecoder decoder;
  final DisplayImageOptions defaultDisplayImageOptions;
  final DiscCacheAware discCache;
  final ImageDownloader downloader;
  final Bitmap.CompressFormat imageCompressFormatForDiscCache;
  final int imageQualityForDiscCache;
  final boolean loggingEnabled;
  final int maxImageHeightForDiscCache;
  final int maxImageHeightForMemoryCache;
  final int maxImageWidthForDiscCache;
  final int maxImageWidthForMemoryCache;
  final MemoryCacheAware<String, Bitmap> memoryCache;
  final ImageDownloader networkDeniedDownloader;
  final DiscCacheAware reserveDiscCache;
  final ImageDownloader slowNetworkDownloader;
  final Executor taskExecutor;
  final Executor taskExecutorForCachedImages;
  final QueueProcessingType tasksProcessingType;
  final int threadPoolSize;
  final int threadPriority;
  
  private ImageLoaderConfiguration(Builder paramBuilder)
  {
    this.context = paramBuilder.context;
    this.maxImageWidthForMemoryCache = paramBuilder.maxImageWidthForMemoryCache;
    this.maxImageHeightForMemoryCache = paramBuilder.maxImageHeightForMemoryCache;
    this.maxImageWidthForDiscCache = paramBuilder.maxImageWidthForDiscCache;
    this.maxImageHeightForDiscCache = paramBuilder.maxImageHeightForDiscCache;
    this.imageCompressFormatForDiscCache = paramBuilder.imageCompressFormatForDiscCache;
    this.imageQualityForDiscCache = paramBuilder.imageQualityForDiscCache;
    this.taskExecutor = paramBuilder.taskExecutor;
    this.taskExecutorForCachedImages = paramBuilder.taskExecutorForCachedImages;
    this.threadPoolSize = paramBuilder.threadPoolSize;
    this.threadPriority = paramBuilder.threadPriority;
    this.tasksProcessingType = paramBuilder.tasksProcessingType;
    this.discCache = paramBuilder.discCache;
    this.memoryCache = paramBuilder.memoryCache;
    this.defaultDisplayImageOptions = paramBuilder.defaultDisplayImageOptions;
    this.loggingEnabled = paramBuilder.loggingEnabled;
    this.downloader = paramBuilder.downloader;
    this.decoder = paramBuilder.decoder;
    this.customExecutor = paramBuilder.customExecutor;
    this.customExecutorForCachedImages = paramBuilder.customExecutorForCachedImages;
    this.networkDeniedDownloader = new NetworkDeniedImageDownloader(this.downloader);
    this.slowNetworkDownloader = new SlowNetworkImageDownloader(this.downloader);
    this.reserveDiscCache = DefaultConfigurationFactory.createReserveDiscCache(this.context);
  }
  
  public static ImageLoaderConfiguration createDefault(Context paramContext)
  {
    return new Builder(paramContext).build();
  }
  
  public static class Builder
  {
    public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
    public static final int DEFAULT_THREAD_POOL_SIZE = 3;
    public static final int DEFAULT_THREAD_PRIORITY = 4;
    private static final String WARNING_OVERLAP_DISC_CACHE_NAME_GENERATOR = "discCache() and discCacheFileNameGenerator() calls overlap each other";
    private static final String WARNING_OVERLAP_DISC_CACHE_PARAMS = "discCache(), discCacheSize() and discCacheFileCount calls overlap each other";
    private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
    private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
    private Context context;
    private boolean customExecutor = false;
    private boolean customExecutorForCachedImages = false;
    private ImageDecoder decoder;
    private DisplayImageOptions defaultDisplayImageOptions = null;
    private boolean denyCacheImageMultipleSizesInMemory = false;
    private DiscCacheAware discCache = null;
    private int discCacheFileCount = 0;
    private FileNameGenerator discCacheFileNameGenerator = null;
    private int discCacheSize = 0;
    private ImageDownloader downloader = null;
    private Bitmap.CompressFormat imageCompressFormatForDiscCache = null;
    private int imageQualityForDiscCache = 0;
    private boolean loggingEnabled = false;
    private int maxImageHeightForDiscCache = 0;
    private int maxImageHeightForMemoryCache = 0;
    private int maxImageWidthForDiscCache = 0;
    private int maxImageWidthForMemoryCache = 0;
    private MemoryCacheAware<String, Bitmap> memoryCache = null;
    private int memoryCacheSize = 0;
    private Executor taskExecutor = null;
    private Executor taskExecutorForCachedImages = null;
    private QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
    private int threadPoolSize = 3;
    private int threadPriority = 4;
    
    public Builder(Context paramContext)
    {
      this.context = paramContext.getApplicationContext();
    }
    
    private void initEmptyFiledsWithDefaultValues()
    {
      if (this.taskExecutor == null)
      {
        this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
        if (this.taskExecutorForCachedImages != null) {
          break label198;
        }
        this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
      }
      for (;;)
      {
        if (this.discCache == null)
        {
          if (this.discCacheFileNameGenerator == null) {
            this.discCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
          }
          this.discCache = DefaultConfigurationFactory.createDiscCache(this.context, this.discCacheFileNameGenerator, this.discCacheSize, this.discCacheFileCount);
        }
        if (this.memoryCache == null) {
          this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.memoryCacheSize);
        }
        if (this.denyCacheImageMultipleSizesInMemory) {
          this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtil.createFuzzyKeyComparator());
        }
        if (this.downloader == null) {
          this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
        }
        if (this.decoder == null) {
          this.decoder = DefaultConfigurationFactory.createImageDecoder(this.loggingEnabled);
        }
        if (this.defaultDisplayImageOptions == null) {
          this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
        }
        return;
        this.customExecutor = true;
        break;
        label198:
        this.customExecutorForCachedImages = true;
      }
    }
    
    public ImageLoaderConfiguration build()
    {
      initEmptyFiledsWithDefaultValues();
      return new ImageLoaderConfiguration(this, null);
    }
    
    public Builder defaultDisplayImageOptions(DisplayImageOptions paramDisplayImageOptions)
    {
      this.defaultDisplayImageOptions = paramDisplayImageOptions;
      return this;
    }
    
    public Builder denyCacheImageMultipleSizesInMemory()
    {
      this.denyCacheImageMultipleSizesInMemory = true;
      return this;
    }
    
    public Builder discCache(DiscCacheAware paramDiscCacheAware)
    {
      if ((this.discCacheSize > 0) || (this.discCacheFileCount > 0)) {
        L.w("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
      }
      if (this.discCacheFileNameGenerator != null) {
        L.w("discCache() and discCacheFileNameGenerator() calls overlap each other", new Object[0]);
      }
      this.discCache = paramDiscCacheAware;
      return this;
    }
    
    public Builder discCacheExtraOptions(int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3)
    {
      this.maxImageWidthForDiscCache = paramInt1;
      this.maxImageHeightForDiscCache = paramInt2;
      this.imageCompressFormatForDiscCache = paramCompressFormat;
      this.imageQualityForDiscCache = paramInt3;
      return this;
    }
    
    public Builder discCacheFileCount(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("maxFileCount must be a positive number");
      }
      if ((this.discCache != null) || (this.discCacheSize > 0)) {
        L.w("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
      }
      this.discCacheSize = 0;
      this.discCacheFileCount = paramInt;
      return this;
    }
    
    public Builder discCacheFileNameGenerator(FileNameGenerator paramFileNameGenerator)
    {
      if (this.discCache != null) {
        L.w("discCache() and discCacheFileNameGenerator() calls overlap each other", new Object[0]);
      }
      this.discCacheFileNameGenerator = paramFileNameGenerator;
      return this;
    }
    
    public Builder discCacheSize(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("maxCacheSize must be a positive number");
      }
      if ((this.discCache != null) || (this.discCacheFileCount > 0)) {
        L.w("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
      }
      this.discCacheSize = paramInt;
      return this;
    }
    
    public Builder enableLogging()
    {
      this.loggingEnabled = true;
      return this;
    }
    
    public Builder imageDecoder(ImageDecoder paramImageDecoder)
    {
      this.decoder = paramImageDecoder;
      return this;
    }
    
    public Builder imageDownloader(ImageDownloader paramImageDownloader)
    {
      this.downloader = paramImageDownloader;
      return this;
    }
    
    public Builder memoryCache(MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
    {
      if (this.memoryCacheSize != 0) {
        L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      this.memoryCache = paramMemoryCacheAware;
      return this;
    }
    
    public Builder memoryCacheExtraOptions(int paramInt1, int paramInt2)
    {
      this.maxImageWidthForMemoryCache = paramInt1;
      this.maxImageHeightForMemoryCache = paramInt2;
      return this;
    }
    
    public Builder memoryCacheSize(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("memoryCacheSize must be a positive number");
      }
      if (this.memoryCache != null) {
        L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      this.memoryCacheSize = paramInt;
      return this;
    }
    
    public Builder taskExecutor(Executor paramExecutor)
    {
      if ((this.threadPoolSize != 3) || (this.threadPriority != 4) || (this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)) {
        L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.taskExecutor = paramExecutor;
      return this;
    }
    
    public Builder taskExecutorForCachedImages(Executor paramExecutor)
    {
      if ((this.threadPoolSize != 3) || (this.threadPriority != 4) || (this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)) {
        L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.taskExecutorForCachedImages = paramExecutor;
      return this;
    }
    
    public Builder tasksProcessingOrder(QueueProcessingType paramQueueProcessingType)
    {
      if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
        L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.tasksProcessingType = paramQueueProcessingType;
      return this;
    }
    
    public Builder threadPoolSize(int paramInt)
    {
      if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
        L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.threadPoolSize = paramInt;
      return this;
    }
    
    public Builder threadPriority(int paramInt)
    {
      if ((this.taskExecutor != null) || (this.taskExecutorForCachedImages != null)) {
        L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      if (paramInt < 1)
      {
        this.threadPriority = 1;
        return this;
      }
      if (paramInt > 10) {
        return this;
      }
      this.threadPriority = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\ImageLoaderConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */