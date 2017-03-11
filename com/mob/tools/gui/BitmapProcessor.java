package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class BitmapProcessor
{
  private static final int CAPACITY = 3;
  private static final int MAX_CACHE_SIZE = 50;
  private static final int MAX_CACHE_TIME = 60000;
  private static final int MAX_REQ_TIME = 200;
  private static final int MAX_SIZE = 100;
  private static final int OVERFLOW_SIZE = 120;
  private static BitmapProcessor instance;
  private File cacheDir;
  private CachePool<String, Bitmap> cachePool;
  private ManagerThread manager;
  private int maxReqCount;
  private Vector<ImageReq> netReqTPS;
  private int overflowReqCount;
  private Vector<ImageReq> reqList;
  private int reqTimeout;
  private boolean work;
  private WorkerThread[] workerList;
  
  private BitmapProcessor(Context paramContext, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.reqTimeout = paramInt2;
      if (paramInt3 <= 0) {
        break label133;
      }
      paramInt2 = paramInt3;
      label21:
      this.maxReqCount = paramInt2;
      if (paramFloat <= 1.0F) {
        break label139;
      }
      paramInt2 = (int)(paramInt3 * paramFloat);
      label41:
      this.overflowReqCount = paramInt2;
      this.reqList = new Vector();
      this.netReqTPS = new Vector();
      if (paramInt1 <= 0) {
        break label145;
      }
      label72:
      this.workerList = new WorkerThread[paramInt1];
      if (paramInt4 <= 0) {
        break label150;
      }
    }
    for (;;)
    {
      this.cachePool = new CachePool(paramInt4);
      this.cacheDir = new File(R.getImageCachePath(paramContext));
      this.manager = new ManagerThread(this);
      return;
      paramInt2 = 200;
      break;
      label133:
      paramInt2 = 100;
      break label21;
      label139:
      paramInt2 = 120;
      break label41;
      label145:
      paramInt1 = 3;
      break label72;
      label150:
      paramInt4 = 50;
    }
  }
  
  public static Bitmap getBitmapFromCache(String paramString)
  {
    if (instance == null) {
      return null;
    }
    return (Bitmap)instance.cachePool.get(paramString);
  }
  
  public static void prepare(Context paramContext)
  {
    try
    {
      prepare(paramContext, 0, 0, 0, 0.0F, 0);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void prepare(Context paramContext, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    try
    {
      if (instance == null) {
        instance = new BitmapProcessor(paramContext.getApplicationContext(), paramInt1, paramInt2, paramInt3, paramFloat, paramInt4);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void process(String paramString, BitmapCallback paramBitmapCallback)
  {
    if ((instance == null) || (paramString == null)) {
      return;
    }
    ImageReq localImageReq = new ImageReq();
    ImageReq.access$002(localImageReq, paramString);
    ImageReq.access$102(localImageReq, paramBitmapCallback);
    instance.reqList.add(localImageReq);
    if (instance.reqList.size() > instance.overflowReqCount) {
      while (instance.reqList.size() > instance.maxReqCount) {
        instance.reqList.remove(0);
      }
    }
    start();
  }
  
  public static void start()
  {
    if (instance == null) {
      throw new RuntimeException("Call BitmapProcessor.prepare(String) before start");
    }
    instance.work = true;
  }
  
  public static void stop()
  {
    if (instance != null)
    {
      instance.work = false;
      instance.reqList.clear();
      instance.manager.cancel();
      int i = 0;
      while (i < instance.workerList.length)
      {
        if (instance.workerList[i] != null) {
          instance.workerList[i].interrupt();
        }
        i += 1;
      }
      instance = null;
    }
  }
  
  public static abstract interface BitmapCallback
  {
    public abstract void onImageGot(String paramString, Bitmap paramBitmap);
  }
  
  public static class ImageReq
  {
    private BitmapProcessor.BitmapCallback callback;
    private Bitmap image;
    private long reqTime = System.currentTimeMillis();
    private String url;
    private BitmapProcessor.WorkerThread worker;
    
    private void throwComplete(Bitmap paramBitmap)
    {
      this.image = paramBitmap;
      if (this.callback != null) {
        this.callback.onImageGot(this.url, this.image);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url=").append(this.url);
      localStringBuilder.append("time=").append(this.reqTime);
      localStringBuilder.append("worker=").append(this.worker.getName()).append(" (").append(this.worker.getId()).append("");
      return localStringBuilder.toString();
    }
  }
  
  private static class ManagerThread
    extends Timer
  {
    private BitmapProcessor processor;
    
    public ManagerThread(BitmapProcessor paramBitmapProcessor)
    {
      this.processor = paramBitmapProcessor;
      schedule(new TimerTask()
      {
        private int counter;
        
        public void run()
        {
          if (BitmapProcessor.this.work)
          {
            this.counter -= 1;
            if (this.counter <= 0)
            {
              this.counter = 100;
              BitmapProcessor.ManagerThread.this.scan();
            }
          }
        }
      }, 0L, this.processor.reqTimeout);
    }
    
    private void scan()
    {
      if (this.processor.cachePool != null) {
        this.processor.cachePool.trimBeforeTime(System.currentTimeMillis() - 60000L);
      }
      if (this.processor.cachePool == null)
      {
        i = 0;
        MobLog.getInstance().d(">>>> BitmapProcessor.cachePool: " + i, new Object[0]);
        if (this.processor.reqList != null) {
          break label136;
        }
      }
      label136:
      for (int i = 0;; i = this.processor.reqList.size())
      {
        MobLog.getInstance().d(">>>> BitmapProcessor.reqList: " + i, new Object[0]);
        if (this.processor.work) {
          break label150;
        }
        return;
        i = this.processor.cachePool.size();
        break;
      }
      label150:
      long l = System.currentTimeMillis();
      i = 0;
      label156:
      boolean bool;
      if (i < this.processor.workerList.length)
      {
        if (this.processor.workerList[i] != null) {
          break label282;
        }
        this.processor.workerList[i] = new BitmapProcessor.WorkerThread(this.processor);
        this.processor.workerList[i].setName("worker " + i);
        BitmapProcessor.WorkerThread localWorkerThread = this.processor.workerList[i];
        if (i != 0) {
          break label276;
        }
        bool = true;
        label249:
        BitmapProcessor.WorkerThread.access$902(localWorkerThread, bool);
        this.processor.workerList[i].start();
      }
      for (;;)
      {
        i += 1;
        break label156;
        break;
        label276:
        bool = false;
        break label249;
        label282:
        if (l - BitmapProcessor.WorkerThread.access$1000(this.processor.workerList[i]) > this.processor.reqTimeout * 100)
        {
          this.processor.workerList[i].interrupt();
          bool = BitmapProcessor.WorkerThread.access$900(this.processor.workerList[i]);
          this.processor.workerList[i] = new BitmapProcessor.WorkerThread(this.processor);
          this.processor.workerList[i].setName("worker " + i);
          BitmapProcessor.WorkerThread.access$902(this.processor.workerList[i], bool);
          this.processor.workerList[i].start();
        }
      }
    }
  }
  
  private static class PatchInputStream
    extends FilterInputStream
  {
    InputStream in;
    
    protected PatchInputStream(InputStream paramInputStream)
    {
      super();
      this.in = paramInputStream;
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 += l2) {
        if (l1 < paramLong)
        {
          l2 = this.in.skip(paramLong - l1);
          if (l2 != 0L) {}
        }
        else
        {
          return l1;
        }
      }
    }
  }
  
  private static class WorkerThread
    extends Thread
  {
    private BitmapProcessor.ImageReq curReq;
    private long lastReport;
    private boolean localType;
    private BitmapProcessor processor;
    
    public WorkerThread(BitmapProcessor paramBitmapProcessor)
    {
      this.processor = paramBitmapProcessor;
      this.lastReport = System.currentTimeMillis();
    }
    
    private void doLocalTask()
      throws Throwable
    {
      BitmapProcessor.ImageReq localImageReq = null;
      if (this.processor.reqList.size() > 0) {
        localImageReq = (BitmapProcessor.ImageReq)this.processor.reqList.remove(0);
      }
      if (localImageReq != null)
      {
        Bitmap localBitmap = (Bitmap)this.processor.cachePool.get(localImageReq.url);
        if (localBitmap != null)
        {
          this.curReq = localImageReq;
          BitmapProcessor.ImageReq.access$1102(this.curReq, this);
          localImageReq.throwComplete(localBitmap);
        }
        for (;;)
        {
          this.lastReport = System.currentTimeMillis();
          return;
          if (new File(this.processor.cacheDir, Data.MD5(localImageReq.url)).exists())
          {
            doTask(localImageReq);
            this.lastReport = System.currentTimeMillis();
            return;
          }
          if (this.processor.netReqTPS.size() > this.processor.maxReqCount)
          {
            while (this.processor.reqList.size() > 0) {
              this.processor.reqList.remove(0);
            }
            this.processor.netReqTPS.remove(0);
          }
          this.processor.netReqTPS.add(localImageReq);
        }
      }
      this.lastReport = System.currentTimeMillis();
      try
      {
        Thread.sleep(30L);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    private void doNetworkTask()
      throws Throwable
    {
      Object localObject1 = null;
      if (this.processor.netReqTPS.size() > 0) {
        localObject1 = (BitmapProcessor.ImageReq)this.processor.netReqTPS.remove(0);
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.processor.reqList.size() > 0) {
          localObject2 = (BitmapProcessor.ImageReq)this.processor.reqList.remove(0);
        }
      }
      if (localObject2 != null)
      {
        localObject1 = (Bitmap)this.processor.cachePool.get(((BitmapProcessor.ImageReq)localObject2).url);
        if (localObject1 != null)
        {
          this.curReq = ((BitmapProcessor.ImageReq)localObject2);
          BitmapProcessor.ImageReq.access$1102(this.curReq, this);
          ((BitmapProcessor.ImageReq)localObject2).throwComplete((Bitmap)localObject1);
        }
        for (;;)
        {
          this.lastReport = System.currentTimeMillis();
          return;
          doTask((BitmapProcessor.ImageReq)localObject2);
        }
      }
      this.lastReport = System.currentTimeMillis();
      try
      {
        Thread.sleep(30L);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    private void doTask(final BitmapProcessor.ImageReq paramImageReq)
      throws Throwable
    {
      this.curReq = paramImageReq;
      BitmapProcessor.ImageReq.access$1102(this.curReq, this);
      Bitmap localBitmap = null;
      final boolean bool;
      final File localFile;
      if ((paramImageReq.url.toLowerCase().endsWith("png")) || (paramImageReq.url.toLowerCase().endsWith("gif")))
      {
        bool = true;
        localFile = new File(this.processor.cacheDir, Data.MD5(paramImageReq.url));
        if (!localFile.exists()) {
          break label154;
        }
        localBitmap = BitmapHelper.getBitmap(localFile.getAbsolutePath());
        if (localBitmap != null)
        {
          this.processor.cachePool.put(paramImageReq.url, localBitmap);
          paramImageReq.throwComplete(localBitmap);
        }
        this.curReq = null;
      }
      for (;;)
      {
        if (localBitmap != null)
        {
          this.processor.cachePool.put(paramImageReq.url, localBitmap);
          paramImageReq.throwComplete(localBitmap);
        }
        this.curReq = null;
        return;
        bool = false;
        break;
        label154:
        new NetworkHelper().rawGet(paramImageReq.url, new RawNetworkCallback()
        {
          public void onResponse(InputStream paramAnonymousInputStream)
            throws Throwable
          {
            paramAnonymousInputStream = BitmapHelper.getBitmap(new BitmapProcessor.PatchInputStream(paramAnonymousInputStream), 1);
            if ((paramAnonymousInputStream == null) || (paramAnonymousInputStream.isRecycled()))
            {
              BitmapProcessor.WorkerThread.access$1602(BitmapProcessor.WorkerThread.this, null);
              return;
            }
            BitmapProcessor.WorkerThread.this.saveFile(paramAnonymousInputStream, localFile, bool);
            if (paramAnonymousInputStream != null)
            {
              BitmapProcessor.this.cachePool.put(paramImageReq.url, paramAnonymousInputStream);
              paramImageReq.throwComplete(paramAnonymousInputStream);
            }
            BitmapProcessor.WorkerThread.access$1602(BitmapProcessor.WorkerThread.this, null);
          }
        }, null);
      }
    }
    
    private void saveFile(Bitmap paramBitmap, File paramFile, boolean paramBoolean)
    {
      try
      {
        if (paramFile.exists()) {
          paramFile.delete();
        }
        if (!paramFile.getParentFile().exists()) {
          paramFile.getParentFile().mkdirs();
        }
        paramFile.createNewFile();
        if (paramBoolean) {}
        for (Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;; localCompressFormat = Bitmap.CompressFormat.JPEG)
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
          paramBitmap.compress(localCompressFormat, 100, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return;
        }
        return;
      }
      catch (Throwable paramBitmap)
      {
        if (paramFile.exists()) {
          paramFile.delete();
        }
      }
    }
    
    public void interrupt()
    {
      try
      {
        super.interrupt();
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    public void run()
    {
      while (this.processor.work)
      {
        try
        {
          if (!this.localType) {
            break label36;
          }
          doLocalTask();
        }
        catch (Throwable localThrowable)
        {
          MobLog.getInstance().w(localThrowable);
        }
        continue;
        label36:
        doNetworkTask();
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\BitmapProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */