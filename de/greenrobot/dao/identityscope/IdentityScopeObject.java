package de.greenrobot.dao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class IdentityScopeObject<K, T>
  implements IdentityScope<K, T>
{
  private final ReentrantLock lock = new ReentrantLock();
  private final HashMap<K, Reference<T>> map = new HashMap();
  
  public void clear()
  {
    this.lock.lock();
    try
    {
      this.map.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean detach(K paramK, T paramT)
  {
    this.lock.lock();
    try
    {
      if ((get(paramK) == paramT) && (paramT != null))
      {
        remove(paramK);
        return true;
      }
      return false;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public T get(K paramK)
  {
    this.lock.lock();
    try
    {
      paramK = (Reference)this.map.get(paramK);
      this.lock.unlock();
      if (paramK != null) {
        return (T)paramK.get();
      }
    }
    finally
    {
      this.lock.unlock();
    }
    return null;
  }
  
  public T getNoLock(K paramK)
  {
    paramK = (Reference)this.map.get(paramK);
    if (paramK != null) {
      return (T)paramK.get();
    }
    return null;
  }
  
  public void lock()
  {
    this.lock.lock();
  }
  
  public void put(K paramK, T paramT)
  {
    this.lock.lock();
    try
    {
      this.map.put(paramK, new WeakReference(paramT));
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void putNoLock(K paramK, T paramT)
  {
    this.map.put(paramK, new WeakReference(paramT));
  }
  
  public void remove(Iterable<K> paramIterable)
  {
    this.lock.lock();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        this.map.remove(localObject);
      }
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void remove(K paramK)
  {
    this.lock.lock();
    try
    {
      this.map.remove(paramK);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void reserveRoom(int paramInt) {}
  
  public void unlock()
  {
    this.lock.unlock();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\identityscope\IdentityScopeObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */