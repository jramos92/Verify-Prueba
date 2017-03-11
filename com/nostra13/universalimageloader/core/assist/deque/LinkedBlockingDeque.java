package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E>
  extends AbstractQueue<E>
  implements BlockingDeque<E>, Serializable
{
  private static final long serialVersionUID = -387911632671998426L;
  private final int capacity;
  private transient int count;
  transient Node<E> first;
  transient Node<E> last;
  final ReentrantLock lock = new ReentrantLock();
  private final Condition notEmpty = this.lock.newCondition();
  private final Condition notFull = this.lock.newCondition();
  
  public LinkedBlockingDeque()
  {
    this(Integer.MAX_VALUE);
  }
  
  public LinkedBlockingDeque(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
  }
  
  public LinkedBlockingDeque(Collection<? extends E> paramCollection)
  {
    this(Integer.MAX_VALUE);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject;
    do
    {
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject = paramCollection.next();
        if (localObject == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
    } while (linkLast(new Node(localObject)));
    throw new IllegalStateException("Deque full");
    localReentrantLock.unlock();
  }
  
  private boolean linkFirst(Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    Node localNode = this.first;
    paramNode.next = localNode;
    this.first = paramNode;
    if (this.last == null) {
      this.last = paramNode;
    }
    for (;;)
    {
      this.count += 1;
      this.notEmpty.signal();
      return true;
      localNode.prev = paramNode;
    }
  }
  
  private boolean linkLast(Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    Node localNode = this.last;
    paramNode.prev = localNode;
    this.last = paramNode;
    if (this.first == null) {
      this.first = paramNode;
    }
    for (;;)
    {
      this.count += 1;
      this.notEmpty.signal();
      return true;
      localNode.next = paramNode;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.count = 0;
    this.first = null;
    this.last = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private E unlinkFirst()
  {
    Node localNode1 = this.first;
    if (localNode1 == null) {
      return null;
    }
    Node localNode2 = localNode1.next;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.next = localNode1;
    this.first = localNode2;
    if (localNode2 == null) {
      this.last = null;
    }
    for (;;)
    {
      this.count -= 1;
      this.notFull.signal();
      return (E)localObject;
      localNode2.prev = null;
    }
  }
  
  private E unlinkLast()
  {
    Node localNode1 = this.last;
    if (localNode1 == null) {
      return null;
    }
    Node localNode2 = localNode1.prev;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.prev = localNode1;
    this.last = localNode2;
    if (localNode2 == null) {
      this.first = null;
    }
    for (;;)
    {
      this.count -= 1;
      this.notFull.signal();
      return (E)localObject;
      localNode2.next = null;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (Node localNode = this.first; localNode != null; localNode = localNode.next) {
        paramObjectOutputStream.writeObject(localNode.item);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public void addFirst(E paramE)
  {
    if (!offerFirst(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void addLast(E paramE)
  {
    if (!offerLast(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Node localNode;
      for (Object localObject1 = this.first; localObject1 != null; localObject1 = localNode)
      {
        ((Node)localObject1).item = null;
        localNode = ((Node)localObject1).next;
        ((Node)localObject1).prev = null;
        ((Node)localObject1).next = null;
      }
      this.last = null;
      this.first = null;
      this.count = 0;
      this.notFull.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.first; localNode != null; localNode = localNode.next)
      {
        boolean bool = paramObject.equals(localNode.item);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Iterator<E> descendingIterator()
  {
    return new DescendingItr(null);
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, Integer.MAX_VALUE);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.count);
      paramInt = 0;
      while (paramInt < i)
      {
        paramCollection.add(this.first.item);
        unlinkFirst();
        paramInt += 1;
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E element()
  {
    return (E)getFirst();
  }
  
  public E getFirst()
  {
    Object localObject = peekFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public E getLast()
  {
    Object localObject = peekLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public Iterator<E> iterator()
  {
    return new Itr(null);
  }
  
  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return offerLast(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      boolean bool = linkFirst(localNode);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new Node(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkFirst(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public boolean offerLast(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    Node localNode = new Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      boolean bool = linkLast(localNode);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new Node(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkLast(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E peek()
  {
    return (E)peekFirst();
  }
  
  /* Error */
  public E peekFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 112	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 112	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   30: getfield 148	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  /* Error */
  public E peekLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 116	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 116	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   30: getfield 148	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public E poll()
  {
    return (E)pollFirst();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return (E)pollFirst(paramLong, paramTimeUnit);
  }
  
  public E pollFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = unlinkFirst();
      return (E)localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkFirst();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return (E)localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E pollLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = unlinkLast();
      return (E)localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkLast();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return (E)localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E pop()
  {
    return (E)removeFirst();
  }
  
  public void push(E paramE)
  {
    addFirst(paramE);
  }
  
  public void put(E paramE)
    throws InterruptedException
  {
    putLast(paramE);
  }
  
  /* Error */
  public void putFirst(E paramE)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 87	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 88	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 22	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 94	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 53	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 226	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:linkFirst	(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 61	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:notFull	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 265 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	LinkedBlockingDeque
    //   0	62	1	paramE	E
    //   20	12	2	localNode	Node
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  /* Error */
  public void putLast(E paramE)
    throws InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 87	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 88	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 22	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 94	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 53	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 98	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:linkLast	(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 61	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:notFull	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 265 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	LinkedBlockingDeque
    //   0	62	1	paramE	E
    //   20	12	2	localNode	Node
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.capacity;
      int j = this.count;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E remove()
  {
    return (E)removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public E removeFirst()
  {
    Object localObject = pollFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.first; localNode != null; localNode = localNode.next) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E removeLast()
  {
    Object localObject = pollLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (Node localNode = this.last; localNode != null; localNode = localNode.prev) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E take()
    throws InterruptedException
  {
    return (E)takeFirst();
  }
  
  public E takeFirst()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = unlinkFirst();
        if (localObject != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  public E takeLast()
    throws InterruptedException
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = unlinkLast();
        if (localObject != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.count];
      Node localNode = this.first;
      int i = 0;
      while (localNode != null)
      {
        arrayOfObject[i] = localNode.item;
        localNode = localNode.next;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject = paramArrayOfT;
    try
    {
      if (paramArrayOfT.length < this.count) {
        localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.count);
      }
      paramArrayOfT = this.first;
      int i = 0;
      while (paramArrayOfT != null)
      {
        localObject[i] = paramArrayOfT.item;
        paramArrayOfT = paramArrayOfT.next;
        i += 1;
      }
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return (T[])localObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 69	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 112	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: aload 4
    //   22: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc_w 310
    //   28: areturn
    //   29: new 312	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 313	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: bipush 91
    //   42: invokevirtual 317	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: getfield 148	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: aload_0
    //   55: if_acmpne +7 -> 62
    //   58: ldc_w 319
    //   61: astore_2
    //   62: aload 5
    //   64: aload_2
    //   65: invokevirtual 322	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: getfield 114	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnonnull +21 -> 96
    //   78: aload 5
    //   80: bipush 93
    //   82: invokevirtual 317	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: areturn
    //   96: aload 5
    //   98: bipush 44
    //   100: invokevirtual 317	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: bipush 32
    //   105: invokevirtual 317	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -63 -> 46
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 91	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	LinkedBlockingDeque
    //   15	80	1	localObject1	Object
    //   112	7	1	localObject2	Object
    //   52	13	2	localObject3	Object
    //   50	4	3	localObject4	Object
    //   4	110	4	localReentrantLock	ReentrantLock
    //   36	61	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	112	finally
    //   29	46	112	finally
    //   46	51	112	finally
    //   62	74	112	finally
    //   78	89	112	finally
    //   96	109	112	finally
  }
  
  void unlink(Node<E> paramNode)
  {
    Node localNode1 = paramNode.prev;
    Node localNode2 = paramNode.next;
    if (localNode1 == null)
    {
      unlinkFirst();
      return;
    }
    if (localNode2 == null)
    {
      unlinkLast();
      return;
    }
    localNode1.next = localNode2;
    localNode2.prev = localNode1;
    paramNode.item = null;
    this.count -= 1;
    this.notFull.signal();
  }
  
  private abstract class AbstractItr
    implements Iterator<E>
  {
    private LinkedBlockingDeque.Node<E> lastRet;
    LinkedBlockingDeque.Node<E> next;
    E nextItem;
    
    /* Error */
    AbstractItr()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 23	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
      //   5: aload_0
      //   6: invokespecial 26	java/lang/Object:<init>	()V
      //   9: aload_1
      //   10: getfield 30	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: aload_0
      //   20: invokevirtual 38	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:firstNode	()Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   23: putfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   26: aload_0
      //   27: getfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   30: ifnonnull +15 -> 45
      //   33: aconst_null
      //   34: astore_1
      //   35: aload_0
      //   36: aload_1
      //   37: putfield 42	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
      //   40: aload_2
      //   41: invokevirtual 45	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   44: return
      //   45: aload_0
      //   46: getfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   49: getfield 50	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
      //   52: astore_1
      //   53: goto -18 -> 35
      //   56: astore_1
      //   57: aload_2
      //   58: invokevirtual 45	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	AbstractItr
      //   0	63	1	this$1	LinkedBlockingDeque
      //   13	45	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   18	33	56	finally
      //   35	40	56	finally
      //   45	53	56	finally
    }
    
    private LinkedBlockingDeque.Node<E> succ(LinkedBlockingDeque.Node<E> paramNode)
    {
      for (;;)
      {
        LinkedBlockingDeque.Node localNode = nextNode(paramNode);
        Object localObject;
        if (localNode == null) {
          localObject = null;
        }
        do
        {
          return (LinkedBlockingDeque.Node<E>)localObject;
          localObject = localNode;
        } while (localNode.item != null);
        if (localNode == paramNode) {
          return firstNode();
        }
        paramNode = localNode;
      }
    }
    
    /* Error */
    void advance()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 23	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:this$0	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque;
      //   4: getfield 30	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
      //   7: astore_2
      //   8: aload_2
      //   9: invokevirtual 34	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   18: invokespecial 61	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:succ	(Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;)Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   21: putfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   24: aload_0
      //   25: getfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   28: ifnonnull +15 -> 43
      //   31: aconst_null
      //   32: astore_1
      //   33: aload_0
      //   34: aload_1
      //   35: putfield 42	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:nextItem	Ljava/lang/Object;
      //   38: aload_2
      //   39: invokevirtual 45	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   42: return
      //   43: aload_0
      //   44: getfield 40	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
      //   47: getfield 50	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
      //   50: astore_1
      //   51: goto -18 -> 33
      //   54: astore_1
      //   55: aload_2
      //   56: invokevirtual 45	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	AbstractItr
      //   32	19	1	localObject1	Object
      //   54	6	1	localObject2	Object
      //   7	49	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   12	31	54	finally
      //   33	38	54	finally
      //   43	51	54	finally
    }
    
    abstract LinkedBlockingDeque.Node<E> firstNode();
    
    public boolean hasNext()
    {
      return this.next != null;
    }
    
    public E next()
    {
      if (this.next == null) {
        throw new NoSuchElementException();
      }
      this.lastRet = this.next;
      Object localObject = this.nextItem;
      advance();
      return (E)localObject;
    }
    
    abstract LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode);
    
    public void remove()
    {
      LinkedBlockingDeque.Node localNode = this.lastRet;
      if (localNode == null) {
        throw new IllegalStateException();
      }
      this.lastRet = null;
      ReentrantLock localReentrantLock = LinkedBlockingDeque.this.lock;
      localReentrantLock.lock();
      try
      {
        if (localNode.item != null) {
          LinkedBlockingDeque.this.unlink(localNode);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private class DescendingItr
    extends LinkedBlockingDeque.AbstractItr
  {
    private DescendingItr()
    {
      super();
    }
    
    LinkedBlockingDeque.Node<E> firstNode()
    {
      return LinkedBlockingDeque.this.last;
    }
    
    LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
    {
      return paramNode.prev;
    }
  }
  
  private class Itr
    extends LinkedBlockingDeque.AbstractItr
  {
    private Itr()
    {
      super();
    }
    
    LinkedBlockingDeque.Node<E> firstNode()
    {
      return LinkedBlockingDeque.this.first;
    }
    
    LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> paramNode)
    {
      return paramNode.next;
    }
  }
  
  static final class Node<E>
  {
    E item;
    Node<E> next;
    Node<E> prev;
    
    Node(E paramE)
    {
      this.item = paramE;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\assist\deque\LinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */