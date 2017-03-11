package com.nostra13.universalimageloader.core.assist;

import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;

public final class DiscCacheUtil
{
  public static File findInCache(String paramString, DiscCacheAware paramDiscCacheAware)
  {
    paramString = paramDiscCacheAware.get(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  public static boolean removeFromCache(String paramString, DiscCacheAware paramDiscCacheAware)
  {
    return paramDiscCacheAware.get(paramString).delete();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\assist\DiscCacheUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */