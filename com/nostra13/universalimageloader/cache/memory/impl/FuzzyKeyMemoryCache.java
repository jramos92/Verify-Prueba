package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache<K, V>
  implements MemoryCacheAware<K, V>
{
  private final MemoryCacheAware<K, V> cache;
  private final Comparator<K> keyComparator;
  
  public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> paramMemoryCacheAware, Comparator<K> paramComparator)
  {
    this.cache = paramMemoryCacheAware;
    this.keyComparator = paramComparator;
  }
  
  public void clear()
  {
    this.cache.clear();
  }
  
  public V get(K paramK)
  {
    return (V)this.cache.get(paramK);
  }
  
  public Collection<K> keys()
  {
    return this.cache.keys();
  }
  
  public boolean put(K paramK, V paramV)
  {
    MemoryCacheAware localMemoryCacheAware = this.cache;
    Object localObject2 = null;
    try
    {
      Iterator localIterator = this.cache.keys().iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localIterator.next();
      } while (this.keyComparator.compare(paramK, localObject1) != 0);
      if (localObject1 != null) {
        this.cache.remove(localObject1);
      }
      return this.cache.put(paramK, paramV);
    }
    finally {}
  }
  
  public void remove(K paramK)
  {
    this.cache.remove(paramK);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\memory\impl\FuzzyKeyMemoryCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */