package com.nostra13.universalimageloader.cache.memory;

import java.util.Collection;

public abstract interface MemoryCacheAware<K, V>
{
  public abstract void clear();
  
  public abstract V get(K paramK);
  
  public abstract Collection<K> keys();
  
  public abstract boolean put(K paramK, V paramV);
  
  public abstract void remove(K paramK);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\cache\memory\MemoryCacheAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */