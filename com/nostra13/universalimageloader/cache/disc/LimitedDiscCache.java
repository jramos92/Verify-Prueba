package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedDiscCache
  extends BaseDiscCache
{
  private final AtomicInteger cacheSize;
  private final Map<File, Long> lastUsageDates = Collections.synchronizedMap(new HashMap());
  private final int sizeLimit;
  
  public LimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }
  
  public LimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator);
    this.sizeLimit = paramInt;
    this.cacheSize = new AtomicInteger();
    calculateCacheSizeAndFillUsageMap();
  }
  
  private void calculateCacheSizeAndFillUsageMap()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        int j = 0;
        File[] arrayOfFile = LimitedDiscCache.this.cacheDir.listFiles();
        if (arrayOfFile != null)
        {
          int k = arrayOfFile.length;
          int i = 0;
          while (i < k)
          {
            File localFile = arrayOfFile[i];
            j += LimitedDiscCache.this.getSize(localFile);
            LimitedDiscCache.this.lastUsageDates.put(localFile, Long.valueOf(localFile.lastModified()));
            i += 1;
          }
          LimitedDiscCache.this.cacheSize.set(j);
        }
      }
    }).start();
  }
  
  private int removeNext()
  {
    int i;
    if (this.lastUsageDates.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      return i;
      Object localObject2 = null;
      File localFile = null;
      Object localObject3 = this.lastUsageDates.entrySet();
      synchronized (this.lastUsageDates)
      {
        Iterator localIterator = ((Set)localObject3).iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localFile == null)
          {
            localFile = (File)localEntry.getKey();
            localObject2 = (Long)localEntry.getValue();
          }
          else
          {
            localObject3 = (Long)localEntry.getValue();
            if (((Long)localObject3).longValue() < ((Long)localObject2).longValue())
            {
              localObject2 = localObject3;
              localFile = (File)localEntry.getKey();
            }
          }
        }
        int j = getSize(localFile);
        i = j;
        if (!localFile.delete()) {
          continue;
        }
        this.lastUsageDates.remove(localFile);
        return j;
      }
    }
  }
  
  public void clear()
  {
    this.lastUsageDates.clear();
    this.cacheSize.set(0);
    super.clear();
  }
  
  public File get(String paramString)
  {
    paramString = super.get(paramString);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    paramString.setLastModified(localLong.longValue());
    this.lastUsageDates.put(paramString, localLong);
    return paramString;
  }
  
  protected abstract int getSize(File paramFile);
  
  public void put(String paramString, File paramFile)
  {
    int j = getSize(paramFile);
    for (int i = this.cacheSize.get();; i = this.cacheSize.addAndGet(-i)) {
      if (i + j > this.sizeLimit)
      {
        i = removeNext();
        if (i != 0) {}
      }
      else
      {
        this.cacheSize.addAndGet(j);
        paramString = Long.valueOf(System.currentTimeMillis());
        paramFile.setLastModified(paramString.longValue());
        this.lastUsageDates.put(paramFile, paramString);
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\disc\LimitedDiscCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */