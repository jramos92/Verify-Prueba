package com.google.android.gms.tagmanager;

import android.util.LruCache;

class zzba<K, V>
  implements zzl<K, V>
{
  private LruCache<K, V> zzaXu;
  
  zzba(int paramInt, final zzm.zza<K, V> paramzza)
  {
    this.zzaXu = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return paramzza.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V get(K paramK)
  {
    return (V)this.zzaXu.get(paramK);
  }
  
  public void zzf(K paramK, V paramV)
  {
    this.zzaXu.put(paramK, paramV);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */