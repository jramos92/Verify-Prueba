package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class zzu
  extends zzy
{
  private volatile boolean zzLA;
  private final zzc zzaND = new zzc("Measurement Worker");
  private final zzc zzaNE = new zzc("Measurement Network");
  private final zzt zzaNF;
  private volatile boolean zzaNG;
  
  zzu(zzv paramzzv)
  {
    super(paramzzv);
    this.zzaND.setUncaughtExceptionHandler(new zzb("Thread death: Uncaught exception on worker thread"));
    this.zzaNE.setUncaughtExceptionHandler(new zzb("Thread death: Uncaught exception on network thread"));
    paramzzv = new HashSet();
    paramzzv.add(Long.valueOf(this.zzaND.getId()));
    paramzzv.add(Long.valueOf(this.zzaNE.getId()));
    this.zzaNF = new zzt(paramzzv);
  }
  
  private void zza(Runnable paramRunnable, zzc paramzzc, String paramString)
    throws IllegalStateException
  {
    zziE();
    zzx.zzw(paramRunnable);
    paramzzc.zza(new zza(paramRunnable, paramString));
  }
  
  public void zzh(Runnable paramRunnable)
    throws IllegalStateException
  {
    zza(paramRunnable, this.zzaND, "Task exception on worker thread");
  }
  
  protected void zzhR()
  {
    this.zzaND.start();
    this.zzaNE.start();
  }
  
  public void zzi(Runnable paramRunnable)
    throws IllegalStateException
  {
    zza(paramRunnable, this.zzaNE, "Task exception on network thread");
  }
  
  public void zzis()
  {
    if (Thread.currentThread() != this.zzaND) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public void zzzn()
  {
    if (Thread.currentThread() != this.zzaNE) {
      throw new IllegalStateException("Call expected from network thread");
    }
  }
  
  private final class zza<V>
    extends FutureTask<V>
  {
    private final String zzaNH;
    
    zza(Runnable paramRunnable, String paramString)
    {
      super(null);
      zzx.zzw(paramString);
      this.zzaNH = paramString;
    }
    
    protected void setException(Throwable paramThrowable)
    {
      zzu.this.zzyd().zzzK().zzj(this.zzaNH, paramThrowable);
      super.setException(paramThrowable);
    }
  }
  
  private final class zzb
    implements Thread.UncaughtExceptionHandler
  {
    private final String zzaNH;
    
    public zzb(String paramString)
    {
      zzx.zzw(paramString);
      this.zzaNH = paramString;
    }
    
    public void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      try
      {
        zzu.this.zzyd().zzzK().zzj(this.zzaNH, paramThrowable);
        return;
      }
      finally
      {
        paramThread = finally;
        throw paramThread;
      }
    }
  }
  
  private final class zzc
    extends Thread
  {
    private final BlockingQueue<FutureTask<?>> zzaNJ;
    
    public zzc(String paramString)
    {
      zzx.zzw(paramString);
      this.zzaNJ = new LinkedBlockingQueue();
      setName(paramString);
    }
    
    private void zza(InterruptedException paramInterruptedException)
    {
      zzu.this.zzyd().zzzL().zzj(getName() + " was interrupted", paramInterruptedException);
    }
    
    public void run()
    {
      int i = 0;
      while ((!zzu.zzc(zzu.this)) || (i == 0)) {
        try
        {
          for (;;)
          {
            FutureTask localFutureTask = (FutureTask)this.zzaNJ.poll(0L, TimeUnit.MICROSECONDS);
            if (localFutureTask == null) {
              break;
            }
            localFutureTask.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          zza(localInterruptedException1);
          try
          {
            boolean bool = zzu.zzb(zzu.this).zzzY();
            i = bool;
          }
          catch (InterruptedException localInterruptedException2)
          {
            zza(localInterruptedException2);
          }
        }
      }
      zzu.this.zzyd().zzzP().zzec("Scheduler thread exiting");
    }
    
    public void zza(FutureTask<?> paramFutureTask)
      throws IllegalStateException
    {
      zzx.zzw(paramFutureTask);
      if (zzu.zza(zzu.this)) {
        throw new IllegalStateException("Cannot schedule task; thread was already shut down.");
      }
      try
      {
        this.zzaNJ.put(paramFutureTask);
        zzu.zzb(zzu.this).zzb(this);
        return;
      }
      catch (InterruptedException paramFutureTask)
      {
        zza(paramFutureTask);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */