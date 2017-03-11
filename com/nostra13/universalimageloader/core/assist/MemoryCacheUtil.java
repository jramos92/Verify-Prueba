package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class MemoryCacheUtil
{
  private static final String URI_AND_SIZE_SEPARATOR = "_";
  private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";
  
  public static Comparator<String> createFuzzyKeyComparator()
  {
    new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString1.substring(0, paramAnonymousString1.lastIndexOf("_")).compareTo(paramAnonymousString2.substring(0, paramAnonymousString2.lastIndexOf("_")));
      }
    };
  }
  
  public static List<String> findCacheKeysForImageUri(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    paramMemoryCacheAware = paramMemoryCacheAware.keys().iterator();
    while (paramMemoryCacheAware.hasNext())
    {
      String str = (String)paramMemoryCacheAware.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public static List<Bitmap> findCachedBitmapsForImageUri(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCacheAware.keys().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(paramMemoryCacheAware.get(str));
      }
    }
    return localArrayList;
  }
  
  public static String generateKey(String paramString, ImageSize paramImageSize)
  {
    return paramString + "_" + paramImageSize.getWidth() + "x" + paramImageSize.getHeight();
  }
  
  public static void removeFromCache(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCacheAware.keys().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString)) {
        localArrayList.add(str);
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext()) {
      paramMemoryCacheAware.remove((String)paramString.next());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\assist\MemoryCacheUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */