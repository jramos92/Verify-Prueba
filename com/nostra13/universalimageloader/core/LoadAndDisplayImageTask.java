package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class LoadAndDisplayImageTask
  implements Runnable
{
  private static final int BUFFER_SIZE = 8192;
  private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
  private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
  private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
  private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
  private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
  private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
  private static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
  private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
  private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
  private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
  private static final String WARNING_POST_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private static final String WARNING_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private final ImageLoaderConfiguration configuration;
  private final ImageDecoder decoder;
  private final ImageDownloader downloader;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  private final ImageLoadingInfo imageLoadingInfo;
  final ImageView imageView;
  final ImageLoadingListener listener;
  private final boolean loggingEnabled;
  private final String memoryCacheKey;
  private final ImageDownloader networkDeniedDownloader;
  final DisplayImageOptions options;
  private final ImageDownloader slowNetworkDownloader;
  private final ImageSize targetSize;
  final String uri;
  
  public LoadAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
    this.configuration = paramImageLoaderEngine.configuration;
    this.downloader = this.configuration.downloader;
    this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
    this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
    this.decoder = this.configuration.decoder;
    this.loggingEnabled = this.configuration.loggingEnabled;
    this.uri = paramImageLoadingInfo.uri;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.imageView = paramImageLoadingInfo.imageView;
    this.targetSize = paramImageLoadingInfo.targetSize;
    this.options = paramImageLoadingInfo.options;
    this.listener = paramImageLoadingInfo.listener;
  }
  
  private boolean checkTaskIsInterrupted()
  {
    boolean bool = Thread.interrupted();
    if (bool) {
      log("Task was interrupted [%s]");
    }
    return bool;
  }
  
  private boolean checkTaskIsNotActual()
  {
    String str = this.engine.getLoadingUriForView(this.imageView);
    if (!this.memoryCacheKey.equals(str)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        this.handler.post(new Runnable()
        {
          public void run()
          {
            LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView);
          }
        });
      }
      if (bool) {
        log("ImageView is reused for another image. Task is cancelled. [%s]");
      }
      return bool;
    }
  }
  
  private Bitmap decodeImage(String paramString)
    throws IOException
  {
    ViewScaleType localViewScaleType = ViewScaleType.fromImageView(this.imageView);
    paramString = new ImageDecodingInfo(this.memoryCacheKey, paramString, this.targetSize, localViewScaleType, getDownloader(), this.options);
    return this.decoder.decode(paramString);
  }
  
  private boolean delayIfNeed()
  {
    if (this.options.shouldDelayBeforeLoading())
    {
      log("Delay %d ms before loading...  [%s]", new Object[] { Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey });
      try
      {
        Thread.sleep(this.options.getDelayBeforeLoading());
        return checkTaskIsNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        L.e("Task was interrupted [%s]", new Object[] { this.memoryCacheKey });
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private void downloadImage(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 187	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:getDownloader	()Lcom/nostra13/universalimageloader/core/download/ImageDownloader;
    //   4: aload_0
    //   5: getfield 124	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:uri	Ljava/lang/String;
    //   8: aload_0
    //   9: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   12: invokevirtual 235	com/nostra13/universalimageloader/core/DisplayImageOptions:getExtraForDownloader	()Ljava/lang/Object;
    //   15: invokeinterface 241 3 0
    //   20: astore_2
    //   21: new 243	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 245	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 247	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: sipush 8192
    //   36: invokespecial 250	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   39: astore_1
    //   40: aload_2
    //   41: aload_1
    //   42: invokestatic 256	com/nostra13/universalimageloader/utils/IoUtils:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   45: aload_1
    //   46: invokestatic 260	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   49: aload_2
    //   50: invokestatic 260	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   53: return
    //   54: astore_3
    //   55: aload_1
    //   56: invokestatic 260	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   59: aload_3
    //   60: athrow
    //   61: astore_1
    //   62: aload_2
    //   63: invokestatic 260	com/nostra13/universalimageloader/utils/IoUtils:closeSilently	(Ljava/io/Closeable;)V
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	LoadAndDisplayImageTask
    //   0	68	1	paramFile	File
    //   20	43	2	localInputStream	java.io.InputStream
    //   54	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	54	finally
    //   21	40	61	finally
    //   45	49	61	finally
    //   55	61	61	finally
  }
  
  private boolean downloadSizedImage(File paramFile, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = new ImageSize(paramInt1, paramInt2);
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
    localObject1 = new ImageDecodingInfo(this.memoryCacheKey, this.uri, (ImageSize)localObject1, ViewScaleType.FIT_INSIDE, getDownloader(), localDisplayImageOptions);
    localObject1 = this.decoder.decode((ImageDecodingInfo)localObject1);
    boolean bool2 = false;
    if (localObject1 != null) {
      paramFile = new BufferedOutputStream(new FileOutputStream(paramFile), 8192);
    }
    try
    {
      boolean bool1 = ((Bitmap)localObject1).compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, paramFile);
      IoUtils.closeSilently(paramFile);
      bool2 = bool1;
      if (bool1)
      {
        ((Bitmap)localObject1).recycle();
        bool2 = bool1;
      }
      return bool2;
    }
    finally
    {
      IoUtils.closeSilently(paramFile);
    }
  }
  
  private void fireImageLoadingFailedEvent(final FailReason.FailType paramFailType, final Throwable paramThrowable)
  {
    if (!Thread.interrupted()) {
      this.handler.post(new Runnable()
      {
        public void run()
        {
          if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
            LoadAndDisplayImageTask.this.imageView.setImageResource(LoadAndDisplayImageTask.this.options.getImageOnFail());
          }
          LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView, new FailReason(paramFailType, paramThrowable));
        }
      });
    }
  }
  
  private ImageDownloader getDownloader()
  {
    if (this.engine.isNetworkDenied()) {
      return this.networkDeniedDownloader;
    }
    if (this.engine.isSlowNetwork()) {
      return this.slowNetworkDownloader;
    }
    return this.downloader;
  }
  
  private File getImageFileInDiscCache()
  {
    File localFile2 = this.configuration.discCache.get(this.uri);
    File localFile3 = localFile2.getParentFile();
    File localFile1;
    if (localFile3 != null)
    {
      localFile1 = localFile2;
      if (!localFile3.exists())
      {
        localFile1 = localFile2;
        if (localFile3.mkdirs()) {}
      }
    }
    else
    {
      localFile2 = this.configuration.reserveDiscCache.get(this.uri);
      localFile3 = localFile2.getParentFile();
      if (localFile3 != null)
      {
        localFile1 = localFile2;
        if (localFile3.exists()) {}
      }
      else
      {
        localFile3.mkdirs();
        localFile1 = localFile2;
      }
    }
    return localFile1;
  }
  
  private void log(String paramString)
  {
    if (this.loggingEnabled) {
      L.i(paramString, new Object[] { this.memoryCacheKey });
    }
  }
  
  private void log(String paramString, Object... paramVarArgs)
  {
    if (this.loggingEnabled) {
      L.i(paramString, paramVarArgs);
    }
  }
  
  private String tryCacheImageOnDisc(File paramFile)
  {
    log("Cache image on disc [%s]");
    try
    {
      int i = this.configuration.maxImageWidthForDiscCache;
      int j = this.configuration.maxImageHeightForDiscCache;
      boolean bool = false;
      if ((i > 0) || (j > 0)) {
        bool = downloadSizedImage(paramFile, i, j);
      }
      if (!bool) {
        downloadImage(paramFile);
      }
      this.configuration.discCache.put(this.uri, paramFile);
      paramFile = ImageDownloader.Scheme.FILE.wrap(paramFile.getAbsolutePath());
      return paramFile;
    }
    catch (IOException paramFile)
    {
      L.e(paramFile);
    }
    return this.uri;
  }
  
  private Bitmap tryLoadBitmap()
  {
    File localFile = getImageFileInDiscCache();
    String str = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Bitmap localBitmap = null;
    Object localObject3 = str;
    Object localObject1 = localObject5;
    Object localObject4 = localObject6;
    localObject2 = localObject7;
    try
    {
      if (localFile.exists())
      {
        localObject3 = str;
        localObject1 = localObject5;
        localObject4 = localObject6;
        localObject2 = localObject7;
        log("Load image from disc cache [%s]");
        localObject3 = str;
        localObject1 = localObject5;
        localObject4 = localObject6;
        localObject2 = localObject7;
        localBitmap = decodeImage(ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath()));
      }
      localObject2 = localBitmap;
      if (localBitmap == null)
      {
        localObject3 = localBitmap;
        localObject1 = localBitmap;
        localObject4 = localBitmap;
        localObject2 = localBitmap;
        log("Load image from network [%s]");
        localObject3 = localBitmap;
        localObject1 = localBitmap;
        localObject4 = localBitmap;
        localObject2 = localBitmap;
        if (this.options.isCacheOnDisc())
        {
          localObject3 = localBitmap;
          localObject1 = localBitmap;
          localObject4 = localBitmap;
          localObject2 = localBitmap;
        }
        for (str = tryCacheImageOnDisc(localFile);; str = this.uri)
        {
          localObject3 = localBitmap;
          localObject1 = localBitmap;
          localObject4 = localBitmap;
          localObject2 = localBitmap;
          localBitmap = decodeImage(str);
          localObject2 = localBitmap;
          if (localBitmap != null) {
            break;
          }
          localObject3 = localBitmap;
          localObject1 = localBitmap;
          localObject4 = localBitmap;
          localObject2 = localBitmap;
          fireImageLoadingFailedEvent(FailReason.FailType.DECODING_ERROR, null);
          return localBitmap;
          localObject3 = localBitmap;
          localObject1 = localBitmap;
          localObject4 = localBitmap;
          localObject2 = localBitmap;
        }
      }
      return (Bitmap)localObject2;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      fireImageLoadingFailedEvent(FailReason.FailType.NETWORK_DENIED, null);
      return (Bitmap)localObject3;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
      fireImageLoadingFailedEvent(FailReason.FailType.IO_ERROR, localIOException);
      localObject2 = localObject1;
      if (localFile.exists())
      {
        localFile.delete();
        return (Bitmap)localObject1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      L.e(localOutOfMemoryError);
      fireImageLoadingFailedEvent(FailReason.FailType.OUT_OF_MEMORY, localOutOfMemoryError);
      return (Bitmap)localObject4;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
      fireImageLoadingFailedEvent(FailReason.FailType.UNKNOWN, localThrowable);
    }
  }
  
  /* Error */
  private boolean waitIfPaused()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 93	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   4: invokevirtual 426	com/nostra13/universalimageloader/core/ImageLoaderEngine:getPause	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 430	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: ifeq +23 -> 35
    //   15: aload_1
    //   16: monitorenter
    //   17: aload_0
    //   18: ldc 56
    //   20: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 433	java/lang/Object:wait	()V
    //   27: aload_0
    //   28: ldc 41
    //   30: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_0
    //   36: invokespecial 224	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsNotActual	()Z
    //   39: ireturn
    //   40: astore_2
    //   41: ldc 50
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 127	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   53: aastore
    //   54: invokestatic 229	com/nostra13/universalimageloader/utils/L:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_1
    //   58: monitorexit
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_1
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	LoadAndDisplayImageTask
    //   7	56	1	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   40	1	2	localInterruptedException	InterruptedException
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	27	40	java/lang/InterruptedException
    //   17	23	61	finally
    //   23	27	61	finally
    //   27	35	61	finally
    //   41	59	61	finally
    //   62	64	61	finally
  }
  
  String getLoadingUri()
  {
    return this.uri;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 437	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:waitIfPaused	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokespecial 439	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:delayIfNeed	()Z
    //   12: ifne -5 -> 7
    //   15: aload_0
    //   16: getfield 95	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   19: getfield 443	com/nostra13/universalimageloader/core/ImageLoadingInfo:loadFromUriLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   22: astore 4
    //   24: aload_0
    //   25: ldc 44
    //   27: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: invokevirtual 448	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   35: ifeq +9 -> 44
    //   38: aload_0
    //   39: ldc 53
    //   41: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   44: aload 4
    //   46: invokevirtual 451	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   49: aload_0
    //   50: invokespecial 224	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsNotActual	()Z
    //   53: istore_1
    //   54: iload_1
    //   55: ifeq +9 -> 64
    //   58: aload 4
    //   60: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   63: return
    //   64: aload_0
    //   65: getfield 102	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   68: getfield 458	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    //   71: aload_0
    //   72: getfield 127	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   75: invokeinterface 463 2 0
    //   80: checkcast 301	android/graphics/Bitmap
    //   83: astore_3
    //   84: aload_3
    //   85: ifnonnull +249 -> 334
    //   88: aload_0
    //   89: invokespecial 465	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:tryLoadBitmap	()Landroid/graphics/Bitmap;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnonnull +9 -> 103
    //   97: aload 4
    //   99: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: return
    //   103: aload_0
    //   104: invokespecial 224	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsNotActual	()Z
    //   107: ifne +12 -> 119
    //   110: aload_0
    //   111: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsInterrupted	()Z
    //   114: istore_1
    //   115: iload_1
    //   116: ifeq +9 -> 125
    //   119: aload 4
    //   121: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   124: return
    //   125: aload_3
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   131: invokevirtual 470	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPreProcess	()Z
    //   134: ifeq +40 -> 174
    //   137: aload_0
    //   138: ldc 38
    //   140: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   147: invokevirtual 474	com/nostra13/universalimageloader/core/DisplayImageOptions:getPreProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   150: aload_3
    //   151: invokeinterface 480 2 0
    //   156: astore_3
    //   157: aload_3
    //   158: astore_2
    //   159: aload_3
    //   160: ifnonnull +14 -> 174
    //   163: ldc 59
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 483	com/nostra13/universalimageloader/utils/L:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: astore_2
    //   174: aload_2
    //   175: astore_3
    //   176: aload_2
    //   177: ifnull +41 -> 218
    //   180: aload_2
    //   181: astore_3
    //   182: aload_0
    //   183: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   186: invokevirtual 486	com/nostra13/universalimageloader/core/DisplayImageOptions:isCacheInMemory	()Z
    //   189: ifeq +29 -> 218
    //   192: aload_0
    //   193: ldc 17
    //   195: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   198: aload_0
    //   199: getfield 102	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:configuration	Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;
    //   202: getfield 458	com/nostra13/universalimageloader/core/ImageLoaderConfiguration:memoryCache	Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;
    //   205: aload_0
    //   206: getfield 127	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   209: aload_2
    //   210: invokeinterface 489 3 0
    //   215: pop
    //   216: aload_2
    //   217: astore_3
    //   218: aload_3
    //   219: astore_2
    //   220: aload_3
    //   221: ifnull +59 -> 280
    //   224: aload_3
    //   225: astore_2
    //   226: aload_0
    //   227: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   230: invokevirtual 492	com/nostra13/universalimageloader/core/DisplayImageOptions:shouldPostProcess	()Z
    //   233: ifeq +47 -> 280
    //   236: aload_0
    //   237: ldc 35
    //   239: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   242: aload_0
    //   243: getfield 136	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:options	Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    //   246: invokevirtual 495	com/nostra13/universalimageloader/core/DisplayImageOptions:getPostProcessor	()Lcom/nostra13/universalimageloader/core/process/BitmapProcessor;
    //   249: aload_3
    //   250: invokeinterface 480 2 0
    //   255: astore_3
    //   256: aload_3
    //   257: astore_2
    //   258: aload_3
    //   259: ifnonnull +21 -> 280
    //   262: ldc 59
    //   264: iconst_1
    //   265: anewarray 4	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: aload_0
    //   271: getfield 127	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:memoryCacheKey	Ljava/lang/String;
    //   274: aastore
    //   275: invokestatic 483	com/nostra13/universalimageloader/utils/L:w	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_3
    //   279: astore_2
    //   280: aload 4
    //   282: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: aload_0
    //   286: invokespecial 224	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsNotActual	()Z
    //   289: ifne -282 -> 7
    //   292: aload_0
    //   293: invokespecial 467	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:checkTaskIsInterrupted	()Z
    //   296: ifne -289 -> 7
    //   299: new 497	com/nostra13/universalimageloader/core/DisplayBitmapTask
    //   302: dup
    //   303: aload_2
    //   304: aload_0
    //   305: getfield 95	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:imageLoadingInfo	Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;
    //   308: aload_0
    //   309: getfield 93	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:engine	Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;
    //   312: invokespecial 500	com/nostra13/universalimageloader/core/DisplayBitmapTask:<init>	(Landroid/graphics/Bitmap;Lcom/nostra13/universalimageloader/core/ImageLoadingInfo;Lcom/nostra13/universalimageloader/core/ImageLoaderEngine;)V
    //   315: astore_2
    //   316: aload_2
    //   317: aload_0
    //   318: getfield 119	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:loggingEnabled	Z
    //   321: invokevirtual 504	com/nostra13/universalimageloader/core/DisplayBitmapTask:setLoggingEnabled	(Z)V
    //   324: aload_0
    //   325: getfield 97	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:handler	Landroid/os/Handler;
    //   328: aload_2
    //   329: invokevirtual 171	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   332: pop
    //   333: return
    //   334: aload_0
    //   335: ldc 26
    //   337: invokespecial 151	com/nostra13/universalimageloader/core/LoadAndDisplayImageTask:log	(Ljava/lang/String;)V
    //   340: goto -122 -> 218
    //   343: astore_2
    //   344: aload 4
    //   346: invokevirtual 454	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   349: aload_2
    //   350: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	LoadAndDisplayImageTask
    //   53	63	1	bool	boolean
    //   126	203	2	localObject1	Object
    //   343	7	2	localObject2	Object
    //   83	196	3	localObject3	Object
    //   22	323	4	localReentrantLock	java.util.concurrent.locks.ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   49	54	343	finally
    //   64	84	343	finally
    //   88	93	343	finally
    //   103	115	343	finally
    //   127	157	343	finally
    //   163	172	343	finally
    //   182	216	343	finally
    //   226	256	343	finally
    //   262	278	343	finally
    //   334	340	343	finally
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\LoadAndDisplayImageTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */