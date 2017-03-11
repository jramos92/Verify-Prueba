package com.nostra13.universalimageloader.cache.memory;

import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedMemoryCache<K, V>
  extends BaseMemoryCache<K, V>
{
  private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
  private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
  private final AtomicInteger cacheSize;
  private final List<V> hardCache = Collections.synchronizedList(new LinkedList());
  private final int sizeLimit;
  
  public LimitedMemoryCache(int paramInt)
  {
    this.sizeLimit = paramInt;
    this.cacheSize = new AtomicInteger();
    if (paramInt > 16777216) {
      L.w("You set too large memory cache size (more than %1$d Mb)", new Object[] { Integer.valueOf(16) });
    }
  }
  
  public void clear()
  {
    this.hardCache.clear();
    this.cacheSize.set(0);
    super.clear();
  }
  
  protected abstract int getSize(V paramV);
  
  protected int getSizeLimit()
  {
    return this.sizeLimit;
  }
  
  public boolean put(K paramK, V paramV)
  {
    boolean bool = false;
    int j = getSize(paramV);
    int k = getSizeLimit();
    int i = this.cacheSize.get();
    if (j < k)
    {
      while (i + j > k)
      {
        Object localObject = removeNext();
        if (this.hardCache.remove(localObject)) {
          i = this.cacheSize.addAndGet(-getSize(localObject));
        }
      }
      this.hardCache.add(paramV);
      this.cacheSize.addAndGet(j);
      bool = true;
    }
    super.put(paramK, paramV);
    return bool;
  }
  
  public void remove(K paramK)
  {
    Object localObject = super.get(paramK);
    if ((localObject != null) && (this.hardCache.remove(localObject))) {
      this.cacheSize.addAndGet(-getSize(localObject));
    }
    super.remove(paramK);
  }
  
  protected abstract V removeNext();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\memory\LimitedMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */