package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class zzmh<K, V>
{
  zzmh<K, V>.zzb zzagI;
  zzmh<K, V>.zzc zzagJ;
  zzmh<K, V>.zze zzagK;
  
  public static <K, V> boolean containsAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!paramMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static <T> boolean equalsSetHelper(Set<T> paramSet, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramSet == paramObject) {
      bool1 = true;
    }
    while (!(paramObject instanceof Set)) {
      return bool1;
    }
    paramObject = (Set)paramObject;
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        bool1 = paramSet.containsAll((Collection)paramObject);
        if (!bool1) {}
      }
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (ClassCastException paramSet)
    {
      return false;
    }
    catch (NullPointerException paramSet) {}
  }
  
  public static <K, V> boolean removeAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramMap.remove(paramCollection.next());
    }
    return i != paramMap.size();
  }
  
  public static <K, V> boolean retainAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  protected abstract void colClear();
  
  protected abstract Object colGetEntry(int paramInt1, int paramInt2);
  
  protected abstract Map<K, V> colGetMap();
  
  protected abstract int colGetSize();
  
  protected abstract int colIndexOfKey(Object paramObject);
  
  protected abstract int colIndexOfValue(Object paramObject);
  
  protected abstract void colPut(K paramK, V paramV);
  
  protected abstract void colRemoveAt(int paramInt);
  
  protected abstract V colSetValue(int paramInt, V paramV);
  
  public Set<Map.Entry<K, V>> getEntrySet()
  {
    if (this.zzagI == null) {
      this.zzagI = new zzb();
    }
    return this.zzagI;
  }
  
  public Set<K> getKeySet()
  {
    if (this.zzagJ == null) {
      this.zzagJ = new zzc();
    }
    return this.zzagJ;
  }
  
  public Collection<V> getValues()
  {
    if (this.zzagK == null) {
      this.zzagK = new zze();
    }
    return this.zzagK;
  }
  
  public Object[] toArrayHelper(int paramInt)
  {
    int j = colGetSize();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = colGetEntry(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public <T> T[] toArrayHelper(T[] paramArrayOfT, int paramInt)
  {
    int j = colGetSize();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < j) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    int i = 0;
    while (i < j)
    {
      localObject[i] = colGetEntry(i, paramInt);
      i += 1;
    }
    if (localObject.length > j) {
      localObject[j] = null;
    }
    return (T[])localObject;
  }
  
  final class zza<T>
    implements Iterator<T>
  {
    boolean mCanRemove = false;
    int mIndex;
    final int mOffset;
    int mSize;
    
    zza(int paramInt)
    {
      this.mOffset = paramInt;
      this.mSize = zzmh.this.colGetSize();
    }
    
    public boolean hasNext()
    {
      return this.mIndex < this.mSize;
    }
    
    public T next()
    {
      Object localObject = zzmh.this.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex += 1;
      this.mCanRemove = true;
      return (T)localObject;
    }
    
    public void remove()
    {
      if (!this.mCanRemove) {
        throw new IllegalStateException();
      }
      this.mIndex -= 1;
      this.mSize -= 1;
      this.mCanRemove = false;
      zzmh.this.colRemoveAt(this.mIndex);
    }
  }
  
  final class zzb
    implements Set<Map.Entry<K, V>>
  {
    zzb() {}
    
    public boolean add(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = zzmh.this.colGetSize();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCollection.next();
        zzmh.this.colPut(localEntry.getKey(), localEntry.getValue());
      }
      return i != zzmh.this.colGetSize();
    }
    
    public void clear()
    {
      zzmh.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      int i;
      do
      {
        return false;
        paramObject = (Map.Entry)paramObject;
        i = zzmh.this.colIndexOfKey(((Map.Entry)paramObject).getKey());
      } while (i < 0);
      return zzmf.equal(zzmh.this.colGetEntry(i, 1), ((Map.Entry)paramObject).getValue());
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      return zzmh.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int j = zzmh.this.colGetSize() - 1;
      int i = 0;
      if (j >= 0)
      {
        Object localObject1 = zzmh.this.colGetEntry(j, 0);
        Object localObject2 = zzmh.this.colGetEntry(j, 1);
        int k;
        if (localObject1 == null)
        {
          k = 0;
          label45:
          if (localObject2 != null) {
            break label76;
          }
        }
        label76:
        for (int m = 0;; m = localObject2.hashCode())
        {
          j -= 1;
          i += (m ^ k);
          break;
          k = localObject1.hashCode();
          break label45;
        }
      }
      return i;
    }
    
    public boolean isEmpty()
    {
      return zzmh.this.colGetSize() == 0;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new zzmh.zzd(zzmh.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return zzmh.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class zzc
    implements Set<K>
  {
    zzc() {}
    
    public boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      zzmh.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      return zzmh.this.colIndexOfKey(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return zzmh.containsAllHelper(zzmh.this.colGetMap(), paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return zzmh.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int i = zzmh.this.colGetSize() - 1;
      int j = 0;
      if (i >= 0)
      {
        Object localObject = zzmh.this.colGetEntry(i, 0);
        if (localObject == null) {}
        for (int k = 0;; k = localObject.hashCode())
        {
          j += k;
          i -= 1;
          break;
        }
      }
      return j;
    }
    
    public boolean isEmpty()
    {
      return zzmh.this.colGetSize() == 0;
    }
    
    public Iterator<K> iterator()
    {
      return new zzmh.zza(zzmh.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = zzmh.this.colIndexOfKey(paramObject);
      if (i >= 0)
      {
        zzmh.this.colRemoveAt(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return zzmh.removeAllHelper(zzmh.this.colGetMap(), paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return zzmh.retainAllHelper(zzmh.this.colGetMap(), paramCollection);
    }
    
    public int size()
    {
      return zzmh.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      return zzmh.this.toArrayHelper(0);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return zzmh.this.toArrayHelper(paramArrayOfT, 0);
    }
  }
  
  final class zzd
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int mEnd = zzmh.this.colGetSize() - 1;
    boolean mEntryValid = false;
    int mIndex = -1;
    
    zzd() {}
    
    public final boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (!this.mEntryValid) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      if (!(paramObject instanceof Map.Entry)) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      if ((zzmf.equal(((Map.Entry)paramObject).getKey(), zzmh.this.colGetEntry(this.mIndex, 0))) && (zzmf.equal(((Map.Entry)paramObject).getValue(), zzmh.this.colGetEntry(this.mIndex, 1)))) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    
    public K getKey()
    {
      if (!this.mEntryValid) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (K)zzmh.this.colGetEntry(this.mIndex, 0);
    }
    
    public V getValue()
    {
      if (!this.mEntryValid) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (V)zzmh.this.colGetEntry(this.mIndex, 1);
    }
    
    public boolean hasNext()
    {
      return this.mIndex < this.mEnd;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (!this.mEntryValid) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      Object localObject1 = zzmh.this.colGetEntry(this.mIndex, 0);
      Object localObject2 = zzmh.this.colGetEntry(this.mIndex, 1);
      int i;
      if (localObject1 == null)
      {
        i = 0;
        if (localObject2 != null) {
          break label69;
        }
      }
      for (;;)
      {
        return j ^ i;
        i = localObject1.hashCode();
        break;
        label69:
        j = localObject2.hashCode();
      }
    }
    
    public Map.Entry<K, V> next()
    {
      this.mIndex += 1;
      this.mEntryValid = true;
      return this;
    }
    
    public void remove()
    {
      if (!this.mEntryValid) {
        throw new IllegalStateException();
      }
      zzmh.this.colRemoveAt(this.mIndex);
      this.mIndex -= 1;
      this.mEnd -= 1;
      this.mEntryValid = false;
    }
    
    public V setValue(V paramV)
    {
      if (!this.mEntryValid) {
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
      }
      return (V)zzmh.this.colSetValue(this.mIndex, paramV);
    }
    
    public final String toString()
    {
      return getKey() + "=" + getValue();
    }
  }
  
  final class zze
    implements Collection<V>
  {
    zze() {}
    
    public boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      zzmh.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      return zzmh.this.colIndexOfValue(paramObject) >= 0;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean isEmpty()
    {
      return zzmh.this.colGetSize() == 0;
    }
    
    public Iterator<V> iterator()
    {
      return new zzmh.zza(zzmh.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = zzmh.this.colIndexOfValue(paramObject);
      if (i >= 0)
      {
        zzmh.this.colRemoveAt(i);
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      int i = 0;
      int j = zzmh.this.colGetSize();
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (paramCollection.contains(zzmh.this.colGetEntry(i, 1)))
        {
          zzmh.this.colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      int i = 0;
      int j = zzmh.this.colGetSize();
      boolean bool = false;
      while (i < j)
      {
        int m = i;
        int k = j;
        if (!paramCollection.contains(zzmh.this.colGetEntry(i, 1)))
        {
          zzmh.this.colRemoveAt(i);
          m = i - 1;
          k = j - 1;
          bool = true;
        }
        i = m + 1;
        j = k;
      }
      return bool;
    }
    
    public int size()
    {
      return zzmh.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      return zzmh.this.toArrayHelper(1);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return zzmh.this.toArrayHelper(paramArrayOfT, 1);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */