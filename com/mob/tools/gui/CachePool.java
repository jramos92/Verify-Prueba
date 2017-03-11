package com.mob.tools.gui;

public class CachePool<K, V>
{
  private int capacity;
  private Node<K, V> head;
  private int size;
  private Node<K, V> tail;
  
  public CachePool(int paramInt)
  {
    this.capacity = paramInt;
  }
  
  public void clear()
  {
    try
    {
      this.tail = null;
      this.head = null;
      this.size = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public V get(K paramK)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +14 -> 24
    //   13: aload_2
    //   14: getfield 38	com/mob/tools/gui/CachePool$Node:key	Ljava/lang/Object;
    //   17: aload_1
    //   18: invokevirtual 42	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +77 -> 98
    //   24: aload_3
    //   25: astore_1
    //   26: aload_2
    //   27: ifnull +67 -> 94
    //   30: aload_2
    //   31: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   34: ifnull +55 -> 89
    //   37: aload_2
    //   38: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   41: ifnonnull +65 -> 106
    //   44: aload_2
    //   45: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   48: aconst_null
    //   49: putfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 28	com/mob/tools/gui/CachePool:tail	Lcom/mob/tools/gui/CachePool$Node;
    //   57: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   60: putfield 28	com/mob/tools/gui/CachePool:tail	Lcom/mob/tools/gui/CachePool$Node;
    //   63: aload_2
    //   64: aconst_null
    //   65: putfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   73: putfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   76: aload_0
    //   77: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   80: aload_2
    //   81: putfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   84: aload_0
    //   85: aload_2
    //   86: putfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   89: aload_2
    //   90: getfield 51	com/mob/tools/gui/CachePool$Node:value	Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: aload_2
    //   99: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   102: astore_2
    //   103: goto -94 -> 9
    //   106: aload_2
    //   107: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   110: aload_2
    //   111: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   114: putfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   117: aload_2
    //   118: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   121: aload_2
    //   122: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   125: putfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   128: goto -65 -> 63
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	CachePool
    //   0	136	1	paramK	K
    //   8	114	2	localNode	Node
    //   1	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	131	finally
    //   13	24	131	finally
    //   30	63	131	finally
    //   63	89	131	finally
    //   89	94	131	finally
    //   98	103	131	finally
    //   106	128	131	finally
  }
  
  public boolean put(K paramK, V paramV)
  {
    if (paramK != null) {}
    boolean bool;
    Node localNode1;
    try
    {
      int i = this.capacity;
      if (i <= 0)
      {
        bool = false;
        return bool;
      }
      localNode1 = null;
      while (this.size >= this.capacity)
      {
        localNode1 = this.tail;
        this.tail = this.tail.previous;
        this.tail.next = null;
        this.size -= 1;
      }
      localNode2 = localNode1;
    }
    finally {}
    Node localNode2;
    if (localNode1 == null) {
      localNode2 = new Node(null);
    }
    Node.access$102(localNode2, System.currentTimeMillis());
    localNode2.key = paramK;
    localNode2.value = paramV;
    localNode2.previous = null;
    localNode2.next = this.head;
    if (this.size == 0) {
      this.tail = localNode2;
    }
    for (;;)
    {
      this.head = localNode2;
      this.size += 1;
      bool = true;
      break;
      this.head.previous = localNode2;
    }
  }
  
  public int size()
  {
    return this.size;
  }
  
  /* Error */
  public void trimBeforeTime(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/mob/tools/gui/CachePool:capacity	I
    //   6: istore_3
    //   7: iload_3
    //   8: ifgt +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull -11 -> 11
    //   25: aload 4
    //   27: invokestatic 76	com/mob/tools/gui/CachePool$Node:access$100	(Lcom/mob/tools/gui/CachePool$Node;)J
    //   30: lload_1
    //   31: lcmp
    //   32: ifge +78 -> 110
    //   35: aload 4
    //   37: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   40: ifnull +16 -> 56
    //   43: aload 4
    //   45: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   48: aload 4
    //   50: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   53: putfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   56: aload 4
    //   58: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   61: ifnull +16 -> 77
    //   64: aload 4
    //   66: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   69: aload 4
    //   71: getfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   74: putfield 45	com/mob/tools/gui/CachePool$Node:previous	Lcom/mob/tools/gui/CachePool$Node;
    //   77: aload 4
    //   79: aload_0
    //   80: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   83: invokevirtual 42	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +14 -> 100
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   94: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   97: putfield 30	com/mob/tools/gui/CachePool:head	Lcom/mob/tools/gui/CachePool$Node;
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 32	com/mob/tools/gui/CachePool:size	I
    //   105: iconst_1
    //   106: isub
    //   107: putfield 32	com/mob/tools/gui/CachePool:size	I
    //   110: aload 4
    //   112: getfield 48	com/mob/tools/gui/CachePool$Node:next	Lcom/mob/tools/gui/CachePool$Node;
    //   115: astore 4
    //   117: goto -97 -> 20
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	CachePool
    //   0	127	1	paramLong	long
    //   6	2	3	i	int
    //   18	98	4	localNode	Node
    //   120	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	120	finally
    //   14	20	120	finally
    //   25	56	120	finally
    //   56	77	120	finally
    //   77	100	120	finally
    //   100	110	120	finally
    //   110	117	120	finally
  }
  
  private static class Node<K, V>
  {
    private long cacheTime;
    public K key;
    public Node<K, V> next;
    public Node<K, V> previous;
    public V value;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\CachePool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */