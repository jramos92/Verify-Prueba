package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeDiscCache
  extends BaseDiscCache
{
  private final Map<File, Long> loadingDates = Collections.synchronizedMap(new HashMap());
  private final long maxFileAge;
  
  public LimitedAgeDiscCache(File paramFile, long paramLong)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramLong);
  }
  
  public LimitedAgeDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, long paramLong)
  {
    super(paramFile, paramFileNameGenerator);
    this.maxFileAge = (1000L * paramLong);
  }
  
  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    int i;
    if (localFile.exists())
    {
      paramString = (Long)this.loadingDates.get(localFile);
      if (paramString != null) {
        break label75;
      }
      i = 0;
      paramString = Long.valueOf(localFile.lastModified());
      if (System.currentTimeMillis() - paramString.longValue() <= this.maxFileAge) {
        break label80;
      }
      localFile.delete();
      this.loadingDates.remove(localFile);
    }
    label75:
    label80:
    while (i != 0)
    {
      return localFile;
      i = 1;
      break;
    }
    this.loadingDates.put(localFile, paramString);
    return localFile;
  }
  
  public void put(String paramString, File paramFile)
  {
    long l = System.currentTimeMillis();
    paramFile.setLastModified(l);
    this.loadingDates.put(paramFile, Long.valueOf(l));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\disc\impl\LimitedAgeDiscCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */