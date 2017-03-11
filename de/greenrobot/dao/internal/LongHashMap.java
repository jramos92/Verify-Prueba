package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoLog;
import java.util.Arrays;

public final class LongHashMap<T>
{
  private int capacity;
  private int size;
  private Entry<T>[] table;
  private int threshold;
  
  public LongHashMap()
  {
    this(16);
  }
  
  public LongHashMap(int paramInt)
  {
    this.capacity = paramInt;
    this.threshold = (paramInt * 4 / 3);
    this.table = new Entry[paramInt];
  }
  
  public void clear()
  {
    this.size = 0;
    Arrays.fill(this.table, null);
  }
  
  public boolean containsKey(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = this.capacity;
    for (Entry localEntry = this.table[(((i ^ j) & 0x7FFFFFFF) % k)]; localEntry != null; localEntry = localEntry.next) {
      if (localEntry.key == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public T get(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = this.capacity;
    for (Entry localEntry = this.table[(((i ^ j) & 0x7FFFFFFF) % k)]; localEntry != null; localEntry = localEntry.next) {
      if (localEntry.key == paramLong) {
        return (T)localEntry.value;
      }
    }
    return null;
  }
  
  public void logStats()
  {
    int j = 0;
    Entry[] arrayOfEntry = this.table;
    int k = arrayOfEntry.length;
    int i = 0;
    while (i < k)
    {
      for (Entry localEntry = arrayOfEntry[i]; (localEntry != null) && (localEntry.next != null); localEntry = localEntry.next) {
        j += 1;
      }
      i += 1;
    }
    DaoLog.d("load: " + this.size / this.capacity + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + j + ", collision ratio: " + j / this.size);
  }
  
  public T put(long paramLong, T paramT)
  {
    int i = (((int)(paramLong >>> 32) ^ (int)paramLong) & 0x7FFFFFFF) % this.capacity;
    Object localObject2 = this.table[i];
    for (Object localObject1 = localObject2; localObject1 != null; localObject1 = ((Entry)localObject1).next) {
      if (((Entry)localObject1).key == paramLong)
      {
        localObject2 = ((Entry)localObject1).value;
        ((Entry)localObject1).value = paramT;
        return (T)localObject2;
      }
    }
    this.table[i] = new Entry(paramLong, paramT, (Entry)localObject2);
    this.size += 1;
    if (this.size > this.threshold) {
      setCapacity(this.capacity * 2);
    }
    return null;
  }
  
  public T remove(long paramLong)
  {
    int i = (((int)(paramLong >>> 32) ^ (int)paramLong) & 0x7FFFFFFF) % this.capacity;
    Object localObject2 = null;
    Entry localEntry;
    for (Object localObject1 = this.table[i]; localObject1 != null; localObject1 = localEntry)
    {
      localEntry = ((Entry)localObject1).next;
      if (((Entry)localObject1).key == paramLong)
      {
        if (localObject2 == null) {
          this.table[i] = localEntry;
        }
        for (;;)
        {
          this.size -= 1;
          return (T)((Entry)localObject1).value;
          ((Entry)localObject2).next = localEntry;
        }
      }
      localObject2 = localObject1;
    }
    return null;
  }
  
  public void reserveRoom(int paramInt)
  {
    setCapacity(paramInt * 5 / 3);
  }
  
  public void setCapacity(int paramInt)
  {
    Entry[] arrayOfEntry = new Entry[paramInt];
    int j = this.table.length;
    int i = 0;
    while (i < j)
    {
      Entry localEntry;
      for (Object localObject = this.table[i]; localObject != null; localObject = localEntry)
      {
        long l = ((Entry)localObject).key;
        int k = (((int)(l >>> 32) ^ (int)l) & 0x7FFFFFFF) % paramInt;
        localEntry = ((Entry)localObject).next;
        ((Entry)localObject).next = arrayOfEntry[k];
        arrayOfEntry[k] = localObject;
      }
      i += 1;
    }
    this.table = arrayOfEntry;
    this.capacity = paramInt;
    this.threshold = (paramInt * 4 / 3);
  }
  
  public int size()
  {
    return this.size;
  }
  
  static final class Entry<T>
  {
    final long key;
    Entry<T> next;
    T value;
    
    Entry(long paramLong, T paramT, Entry<T> paramEntry)
    {
      this.key = paramLong;
      this.value = paramT;
      this.next = paramEntry;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\internal\LongHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */