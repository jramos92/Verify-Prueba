package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final MemoryCacheAware<K, V> cache;
  private final Map<K, Long> loadingDates = Collections.synchronizedMap(new HashMap());
  private final long maxAge;
  
  public LimitedAgeMemoryCache(MemoryCacheAware<K, V> paramMemoryCacheAware, long paramLong)
  {
    this.cache = paramMemoryCacheAware;
    this.maxAge = (1000L * paramLong);
  }
  
  public void clear()
  {
    this.cache.clear();
    this.loadingDates.clear();
  }
  
  public V get(K paramK)
  {
    Long localLong = (Long)this.loadingDates.get(paramK);
    if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() > this.maxAge))
    {
      this.cache.remove(paramK);
      this.loadingDates.remove(paramK);
    }
    return (V)this.cache.get(paramK);
  }
  
  public Collection<K> keys()
  {
    return this.cache.keys();
  }
  
  public boolean put(K paramK, V paramV)
  {
    boolean bool = this.cache.put(paramK, paramV);
    if (bool) {
      this.loadingDates.put(paramK, Long.valueOf(System.currentTimeMillis()));
    }
    return bool;
  }
  
  public void remove(K paramK)
  {
    this.cache.remove(paramK);
    this.loadingDates.remove(paramK);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\memory\impl\LimitedAgeMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */