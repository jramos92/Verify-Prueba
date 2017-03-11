package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class zzt
{
  private int zzaNA;
  private int zzaNB;
  private boolean zzaNC;
  private final int zzaNv;
  private final int zzaNw;
  private final List<Long> zzaNx;
  private final ReentrantLock zzaNy;
  private final Condition zzaNz;
  
  public zzt(Set<Long> paramSet)
  {
    zzx.zzw(paramSet);
    if (!paramSet.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      this.zzaNy = new ReentrantLock();
      this.zzaNz = this.zzaNy.newCondition();
      this.zzaNw = paramSet.size();
      if (this.zzaNw <= 10) {
        break;
      }
      throw new IllegalArgumentException("PrimingBarrier does not support more than 10 specified threads");
    }
    this.zzaNv = ((1 << this.zzaNw + 1) - 1);
    this.zzaNx = new ArrayList(paramSet);
  }
  
  private int zzP(long paramLong)
  {
    int j = this.zzaNx.indexOf(Long.valueOf(paramLong));
    int i = j;
    if (j < 0) {
      i = this.zzaNw;
    }
    return 1 << i;
  }
  
  private boolean zzc(Thread paramThread)
  {
    if (zzd(paramThread)) {
      return true;
    }
    this.zzaNA |= zzP(paramThread.getId());
    return false;
  }
  
  private boolean zzd(Thread paramThread)
  {
    return (this.zzaNA & zzP(paramThread.getId())) != 0;
  }
  
  private boolean zze(Thread paramThread)
  {
    if ((this.zzaNB & zzP(paramThread.getId())) != 0) {
      return true;
    }
    this.zzaNB |= zzP(paramThread.getId());
    return false;
  }
  
  private boolean zzzZ()
  {
    return this.zzaNB == this.zzaNv;
  }
  
  public void zzb(Thread paramThread)
  {
    zzx.zzw(paramThread);
    this.zzaNy.lock();
    try
    {
      int i = zzP(paramThread.getId());
      this.zzaNA &= (i ^ 0xFFFFFFFF);
      this.zzaNB = ((i ^ 0xFFFFFFFF) & this.zzaNB);
      this.zzaNz.signalAll();
      return;
    }
    finally
    {
      this.zzaNy.unlock();
    }
  }
  
  public boolean zzzY()
    throws InterruptedException
  {
    this.zzaNy.lock();
    try
    {
      if (this.zzaNC) {
        throw new IllegalStateException("Tried to await a barrier that has already passed.");
      }
    }
    finally
    {
      this.zzaNy.unlock();
    }
    if (Thread.interrupted())
    {
      zzb(Thread.currentThread());
      throw new InterruptedException();
    }
    if (zzc(Thread.currentThread()))
    {
      if (zze(Thread.currentThread()))
      {
        if (this.zzaNx.indexOf(Long.valueOf(Thread.currentThread().getId())) >= 0) {
          throw new IllegalStateException("PrimingBarrier thinks current thread is already awaiting.");
        }
        throw new IllegalStateException("Multiple threads called shutdown on the Scheduler.");
      }
      while (!zzzZ())
      {
        boolean bool = zzd(Thread.currentThread());
        if (!bool)
        {
          this.zzaNy.unlock();
          return false;
        }
        try
        {
          this.zzaNz.await();
          if (Thread.interrupted())
          {
            zzb(Thread.currentThread());
            throw new InterruptedException();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          zzb(Thread.currentThread());
          throw localInterruptedException;
        }
      }
      if (!this.zzaNC)
      {
        this.zzaNC = true;
        this.zzaNz.signalAll();
      }
      this.zzaNy.unlock();
      return true;
    }
    this.zzaNy.unlock();
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */