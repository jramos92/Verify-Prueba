package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public abstract class BaseDiscCache
  implements DiscCacheAware
{
  protected File cacheDir;
  private FileNameGenerator fileNameGenerator;
  
  public BaseDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }
  
  public BaseDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    this.cacheDir = paramFile;
    this.fileNameGenerator = paramFileNameGenerator;
  }
  
  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public File get(String paramString)
  {
    paramString = this.fileNameGenerator.generate(paramString);
    return new File(this.cacheDir, paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\disc\BaseDiscCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */