package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public class UnlimitedDiscCache
  extends BaseDiscCache
{
  public UnlimitedDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }
  
  public UnlimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    super(paramFile, paramFileNameGenerator);
  }
  
  public void put(String paramString, File paramFile) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\disc\impl\UnlimitedDiscCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */