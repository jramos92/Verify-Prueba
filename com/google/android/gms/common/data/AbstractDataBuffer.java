package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zzabq;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.zzabq = paramDataHolder;
    if (this.zzabq != null) {
      this.zzabq.zzr(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.zzabq == null) {
      return 0;
    }
    return this.zzabq.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (this.zzabq == null) || (this.zzabq.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (this.zzabq != null) {
      this.zzabq.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzor()
  {
    return this.zzabq.zzor();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\data\AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */