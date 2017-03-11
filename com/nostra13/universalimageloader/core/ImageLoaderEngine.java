package com.nostra13.universalimageloader.core;

import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class ImageLoaderEngine
{
  private final Map<Integer, String> cacheKeysForImageViews = Collections.synchronizedMap(new HashMap());
  final ImageLoaderConfiguration configuration;
  private final AtomicBoolean networkDenied = new AtomicBoolean(false);
  private final AtomicBoolean paused = new AtomicBoolean(false);
  private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
  private ExecutorService taskDistributor;
  private Executor taskExecutor;
  private Executor taskExecutorForCachedImages;
  private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();
  
  ImageLoaderEngine(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    this.configuration = paramImageLoaderConfiguration;
    this.taskExecutor = paramImageLoaderConfiguration.taskExecutor;
    this.taskExecutorForCachedImages = paramImageLoaderConfiguration.taskExecutorForCachedImages;
    this.taskDistributor = Executors.newCachedThreadPool();
  }
  
  private Executor createTaskExecutor()
  {
    return DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
  }
  
  private void initExecutorsIfNeed()
  {
    if (this.taskExecutor == null) {
      this.taskExecutor = createTaskExecutor();
    }
    if (this.taskExecutorForCachedImages == null) {
      this.taskExecutorForCachedImages = createTaskExecutor();
    }
  }
  
  void cancelDisplayTaskFor(ImageView paramImageView)
  {
    this.cacheKeysForImageViews.remove(Integer.valueOf(paramImageView.hashCode()));
  }
  
  void denyNetworkDownloads(boolean paramBoolean)
  {
    this.networkDenied.set(paramBoolean);
  }
  
  String getLoadingUriForView(ImageView paramImageView)
  {
    return (String)this.cacheKeysForImageViews.get(Integer.valueOf(paramImageView.hashCode()));
  }
  
  ReentrantLock getLockForUri(String paramString)
  {
    ReentrantLock localReentrantLock2 = (ReentrantLock)this.uriLocks.get(paramString);
    ReentrantLock localReentrantLock1 = localReentrantLock2;
    if (localReentrantLock2 == null)
    {
      localReentrantLock1 = new ReentrantLock();
      this.uriLocks.put(paramString, localReentrantLock1);
    }
    return localReentrantLock1;
  }
  
  AtomicBoolean getPause()
  {
    return this.paused;
  }
  
  void handleSlowNetwork(boolean paramBoolean)
  {
    this.slowNetwork.set(paramBoolean);
  }
  
  boolean isNetworkDenied()
  {
    return this.networkDenied.get();
  }
  
  boolean isSlowNetwork()
  {
    return this.slowNetwork.get();
  }
  
  void pause()
  {
    this.paused.set(true);
  }
  
  void prepareDisplayTaskFor(ImageView paramImageView, String paramString)
  {
    this.cacheKeysForImageViews.put(Integer.valueOf(paramImageView.hashCode()), paramString);
  }
  
  void resume()
  {
    synchronized (this.paused)
    {
      this.paused.set(false);
      this.paused.notifyAll();
      return;
    }
  }
  
  void stop()
  {
    if (!this.configuration.customExecutor) {
      this.taskExecutor = null;
    }
    if (!this.configuration.customExecutorForCachedImages) {
      this.taskExecutorForCachedImages = null;
    }
    this.cacheKeysForImageViews.clear();
    this.uriLocks.clear();
  }
  
  void submit(final LoadAndDisplayImageTask paramLoadAndDisplayImageTask)
  {
    this.taskDistributor.execute(new Runnable()
    {
      public void run()
      {
        boolean bool = ImageLoaderEngine.this.configuration.discCache.get(paramLoadAndDisplayImageTask.getLoadingUri()).exists();
        ImageLoaderEngine.this.initExecutorsIfNeed();
        if (bool)
        {
          ImageLoaderEngine.this.taskExecutorForCachedImages.execute(paramLoadAndDisplayImageTask);
          return;
        }
        ImageLoaderEngine.this.taskExecutor.execute(paramLoadAndDisplayImageTask);
      }
    });
  }
  
  void submit(ProcessAndDisplayImageTask paramProcessAndDisplayImageTask)
  {
    initExecutorsIfNeed();
    this.taskExecutorForCachedImages.execute(paramProcessAndDisplayImageTask);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\ImageLoaderEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */