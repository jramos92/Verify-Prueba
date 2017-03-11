package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzlk
{
  private static final ExecutorService zzacD = Executors.newFixedThreadPool(2, new zza(null));
  
  public static ExecutorService zzoj()
  {
    return zzacD;
  }
  
  private static final class zza
    implements ThreadFactory
  {
    private final ThreadFactory zzacE = Executors.defaultThreadFactory();
    private AtomicInteger zzacF = new AtomicInteger(0);
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = this.zzacE.newThread(paramRunnable);
      paramRunnable.setName("GAC_Executor[" + this.zzacF.getAndIncrement() + "]");
      return paramRunnable;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */