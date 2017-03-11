package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzgr
public final class zzic
{
  private static final ExecutorService zzIr = Executors.newFixedThreadPool(10, zzay("Default"));
  private static final ExecutorService zzIs = Executors.newFixedThreadPool(5, zzay("Loader"));
  
  public static zziq<Void> zza(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1) {
      zza(zzIs, new Callable()
      {
        public Void zzgA()
        {
          this.zzIt.run();
          return null;
        }
      });
    }
    zza(zzIr, new Callable()
    {
      public Void zzgA()
      {
        this.zzIt.run();
        return null;
      }
    });
  }
  
  public static zziq<Void> zza(Runnable paramRunnable)
  {
    return zza(0, paramRunnable);
  }
  
  public static <T> zziq<T> zza(Callable<T> paramCallable)
  {
    return zza(zzIr, paramCallable);
  }
  
  public static <T> zziq<T> zza(ExecutorService paramExecutorService, final Callable<T> paramCallable)
  {
    zzin localzzin = new zzin();
    try
    {
      localzzin.zzd(new Runnable()
      {
        public void run()
        {
          try
          {
            Process.setThreadPriority(10);
            this.zzrA.zzf(paramCallable.call());
            return;
          }
          catch (Exception localException)
          {
            zzp.zzby().zzc(localException, true);
            this.zzrA.cancel(true);
          }
        }
      }
      {
        public void run()
        {
          if (this.zzrA.isCancelled()) {
            this.zzIv.cancel(true);
          }
        }
      });
      return localzzin;
    }
    catch (RejectedExecutionException paramExecutorService)
    {
      zzb.zzd("Thread execution is rejected.", paramExecutorService);
      localzzin.cancel(true);
    }
    return localzzin;
  }
  
  private static ThreadFactory zzay(String paramString)
  {
    new ThreadFactory()
    {
      private final AtomicInteger zzIw = new AtomicInteger(1);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "AdWorker(" + this.zzIx + ") #" + this.zzIw.getAndIncrement());
      }
    };
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */