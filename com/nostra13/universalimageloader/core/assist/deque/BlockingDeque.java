package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract interface BlockingDeque<E>
  extends BlockingQueue<E>, Deque<E>
{
  public abstract boolean add(E paramE);
  
  public abstract void addFirst(E paramE);
  
  public abstract void addLast(E paramE);
  
  public abstract boolean contains(Object paramObject);
  
  public abstract E element();
  
  public abstract Iterator<E> iterator();
  
  public abstract boolean offer(E paramE);
  
  public abstract boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract boolean offerFirst(E paramE);
  
  public abstract boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract boolean offerLast(E paramE);
  
  public abstract boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract E peek();
  
  public abstract E poll();
  
  public abstract E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract E pollFirst(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract E pollLast(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException;
  
  public abstract void push(E paramE);
  
  public abstract void put(E paramE)
    throws InterruptedException;
  
  public abstract void putFirst(E paramE)
    throws InterruptedException;
  
  public abstract void putLast(E paramE)
    throws InterruptedException;
  
  public abstract E remove();
  
  public abstract boolean remove(Object paramObject);
  
  public abstract boolean removeFirstOccurrence(Object paramObject);
  
  public abstract boolean removeLastOccurrence(Object paramObject);
  
  public abstract int size();
  
  public abstract E take()
    throws InterruptedException;
  
  public abstract E takeFirst()
    throws InterruptedException;
  
  public abstract E takeLast()
    throws InterruptedException;
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\assist\deque\BlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */