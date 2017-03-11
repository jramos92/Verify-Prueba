package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{
  final Object zzazb = new Object();
  private Handler zzazc;
  private boolean zzazd;
  private HashMap<String, AtomicInteger> zzaze;
  private int zzazf;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.zzazc = new Handler(paramLooper);
    this.zzaze = new HashMap();
    this.zzazf = paramInt;
  }
  
  private void zzvj()
  {
    synchronized (this.zzazb)
    {
      this.zzazd = false;
      flush();
      return;
    }
  }
  
  public void flush()
  {
    synchronized (this.zzazb)
    {
      Iterator localIterator = this.zzaze.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        zzs((String)localEntry.getKey(), ((AtomicInteger)localEntry.getValue()).get());
      }
    }
    this.zzaze.clear();
  }
  
  protected abstract void zzs(String paramString, int paramInt);
  
  public void zzw(String paramString, int paramInt)
  {
    synchronized (this.zzazb)
    {
      if (!this.zzazd)
      {
        this.zzazd = true;
        this.zzazc.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.zza(EventIncrementCache.this);
          }
        }, this.zzazf);
      }
      AtomicInteger localAtomicInteger2 = (AtomicInteger)this.zzaze.get(paramString);
      AtomicInteger localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger1 = new AtomicInteger();
        this.zzaze.put(paramString, localAtomicInteger1);
      }
      localAtomicInteger1.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\events\EventIncrementCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */