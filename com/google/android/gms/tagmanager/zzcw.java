package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcw<K, V>
  implements zzl<K, V>
{
  private final Map<K, V> zzaZh = new HashMap();
  private final int zzaZi;
  private final zzm.zza<K, V> zzaZj;
  private int zzaZk;
  
  zzcw(int paramInt, zzm.zza<K, V> paramzza)
  {
    this.zzaZi = paramInt;
    this.zzaZj = paramzza;
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.zzaZh.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void zzf(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.zzaZk += this.zzaZj.sizeOf(paramK, paramV);
    if (this.zzaZk > this.zzaZi)
    {
      Iterator localIterator = this.zzaZh.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.zzaZk -= this.zzaZj.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.zzaZk > this.zzaZi);
    }
    this.zzaZh.put(paramK, paramV);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */