package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> zzadk = new HashSet();
  
  public void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zzadk.add(paramDataBufferObserver);
  }
  
  public void clear()
  {
    this.zzadk.clear();
  }
  
  public boolean hasObservers()
  {
    return !this.zzadk.isEmpty();
  }
  
  public void onDataChanged()
  {
    Iterator localIterator = this.zzadk.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataChanged();
    }
  }
  
  public void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzadk.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzadk.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.zzadk.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzadk.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
    }
  }
  
  public void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.zzadk.remove(paramDataBufferObserver);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\data\DataBufferObserverSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */