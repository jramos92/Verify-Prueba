package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultConfigurationFactory
{
  public static BitmapDisplayer createBitmapDisplayer()
  {
    return new SimpleBitmapDisplayer();
  }
  
  public static DiscCacheAware createDiscCache(Context paramContext, FileNameGenerator paramFileNameGenerator, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      return new TotalSizeLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(paramContext), paramFileNameGenerator, paramInt1);
    }
    if (paramInt2 > 0) {
      return new FileCountLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(paramContext), paramFileNameGenerator, paramInt2);
    }
    return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(paramContext), paramFileNameGenerator);
  }
  
  public static Executor createExecutor(int paramInt1, int paramInt2, QueueProcessingType paramQueueProcessingType)
  {
    int i;
    if (paramQueueProcessingType == QueueProcessingType.LIFO)
    {
      i = 1;
      if (i == 0) {
        break label50;
      }
    }
    label50:
    for (paramQueueProcessingType = new LIFOLinkedBlockingDeque();; paramQueueProcessingType = new LinkedBlockingQueue())
    {
      paramQueueProcessingType = (BlockingQueue)paramQueueProcessingType;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, paramQueueProcessingType, createThreadFactory(paramInt2));
      i = 0;
      break;
    }
  }
  
  public static FileNameGenerator createFileNameGenerator()
  {
    return new HashCodeFileNameGenerator();
  }
  
  public static ImageDecoder createImageDecoder(boolean paramBoolean)
  {
    return new BaseImageDecoder(paramBoolean);
  }
  
  public static ImageDownloader createImageDownloader(Context paramContext)
  {
    return new BaseImageDownloader(paramContext);
  }
  
  public static MemoryCacheAware<String, Bitmap> createMemoryCache(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = (int)(Runtime.getRuntime().maxMemory() / 8L);
    }
    if (Build.VERSION.SDK_INT >= 9) {
      return new LruMemoryCache(i);
    }
    return new LRULimitedMemoryCache(i);
  }
  
  public static DiscCacheAware createReserveDiscCache(Context paramContext)
  {
    paramContext = paramContext.getCacheDir();
    File localFile = new File(paramContext, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir())) {
      paramContext = localFile;
    }
    return new TotalSizeLimitedDiscCache(paramContext, 2097152);
  }
  
  private static ThreadFactory createThreadFactory(int paramInt)
  {
    return new DefaultThreadFactory(paramInt);
  }
  
  private static class DefaultThreadFactory
    implements ThreadFactory
  {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final int threadPriority;
    
    DefaultThreadFactory(int paramInt)
    {
      this.threadPriority = paramInt;
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.group = ((ThreadGroup)localObject);
        this.namePrefix = ("pool-" + poolNumber.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      paramRunnable.setPriority(this.threadPriority);
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\DefaultConfigurationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */