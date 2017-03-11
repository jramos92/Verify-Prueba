package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgr
public class zzit<T>
  implements zzis<T>
{
  protected final BlockingQueue<zzit<T>.zza> zzJM = new LinkedBlockingQueue();
  protected T zzJN;
  private final Object zzpd = new Object();
  protected int zzys = 0;
  
  public int getStatus()
  {
    return this.zzys;
  }
  
  public void reject()
  {
    synchronized (this.zzpd)
    {
      if (this.zzys != 0) {
        throw new UnsupportedOperationException();
      }
    }
    this.zzys = -1;
    Iterator localIterator = this.zzJM.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzJP.run();
    }
    this.zzJM.clear();
  }
  
  public void zza(zzis.zzc<T> paramzzc, zzis.zza paramzza)
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzys == 1)
        {
          paramzzc.zzc(this.zzJN);
          return;
        }
        if (this.zzys == -1) {
          paramzza.run();
        }
      }
      if (this.zzys == 0) {
        this.zzJM.add(new zza(paramzzc, paramzza));
      }
    }
  }
  
  public void zzg(T paramT)
  {
    synchronized (this.zzpd)
    {
      if (this.zzys != 0) {
        throw new UnsupportedOperationException();
      }
    }
    this.zzJN = paramT;
    this.zzys = 1;
    Iterator localIterator = this.zzJM.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzJO.zzc(paramT);
    }
    this.zzJM.clear();
  }
  
  class zza
  {
    public final zzis.zzc<T> zzJO;
    public final zzis.zza zzJP;
    
    public zza(zzis.zza paramzza)
    {
      this.zzJO = paramzza;
      zzis.zza localzza;
      this.zzJP = localzza;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */