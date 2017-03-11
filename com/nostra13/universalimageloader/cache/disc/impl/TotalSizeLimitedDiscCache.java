package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.LimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;

public class TotalSizeLimitedDiscCache
  extends LimitedDiscCache
{
  private static final int MIN_NORMAL_CACHE_SIZE = 2097152;
  private static final int MIN_NORMAL_CACHE_SIZE_IN_MB = 2;
  
  public TotalSizeLimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }
  
  public TotalSizeLimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator, paramInt);
    if (paramInt < 2097152) {
      L.w("You set too small disc cache size (less than %1$d Mb)", new Object[] { Integer.valueOf(2) });
    }
  }
  
  protected int getSize(File paramFile)
  {
    return (int)paramFile.length();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\disc\impl\TotalSizeLimitedDiscCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */