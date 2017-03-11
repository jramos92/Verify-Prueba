package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzg
{
  private static volatile zzg zzaLc;
  private final Context mContext;
  private volatile zzpb zzNs;
  private final List<zzh> zzaLd;
  private final zzb zzaLe;
  private final zza zzaLf;
  private Thread.UncaughtExceptionHandler zzaLg;
  
  zzg(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzx.zzw(paramContext);
    this.mContext = paramContext;
    this.zzaLf = new zza();
    this.zzaLd = new CopyOnWriteArrayList();
    this.zzaLe = new zzb();
  }
  
  public static zzg zzaJ(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzaLc == null) {}
    try
    {
      if (zzaLc == null) {
        zzaLc = new zzg(paramContext);
      }
      return zzaLc;
    }
    finally {}
  }
  
  private void zzb(zzc paramzzc)
  {
    zzx.zzcj("deliver should be called from worker thread");
    zzx.zzb(paramzzc.zzyj(), "Measurement must be submitted");
    Object localObject = paramzzc.zzyg();
    if (((List)localObject).isEmpty()) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzi localzzi = (zzi)((Iterator)localObject).next();
        Uri localUri = localzzi.zzhI();
        if (!localHashSet.contains(localUri))
        {
          localHashSet.add(localUri);
          localzzi.zzb(paramzzc);
        }
      }
    }
  }
  
  public static void zzis()
  {
    if (!(Thread.currentThread() instanceof zzc)) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void zza(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.zzaLg = paramUncaughtExceptionHandler;
  }
  
  public <V> Future<V> zzb(Callable<V> paramCallable)
  {
    zzx.zzw(paramCallable);
    if ((Thread.currentThread() instanceof zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
      return paramCallable;
    }
    return this.zzaLf.submit(paramCallable);
  }
  
  void zze(final zzc paramzzc)
  {
    if (paramzzc.zzyn()) {
      throw new IllegalStateException("Measurement prototype can't be submitted");
    }
    if (paramzzc.zzyj()) {
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    paramzzc = paramzzc.zzye();
    paramzzc.zzyk();
    this.zzaLf.execute(new Runnable()
    {
      public void run()
      {
        paramzzc.zzyl().zza(paramzzc);
        Iterator localIterator = zzg.zza(zzg.this).iterator();
        while (localIterator.hasNext()) {
          ((zzh)localIterator.next()).zza(paramzzc);
        }
        zzg.zza(zzg.this, paramzzc);
      }
    });
  }
  
  public void zzg(Runnable paramRunnable)
  {
    zzx.zzw(paramRunnable);
    this.zzaLf.submit(paramRunnable);
  }
  
  public zzpb zzyr()
  {
    if (this.zzNs == null) {}
    Object localObject5;
    Object localObject3;
    try
    {
      zzpb localzzpb;
      PackageManager localPackageManager;
      String str2;
      if (this.zzNs == null)
      {
        localzzpb = new zzpb();
        localPackageManager = this.mContext.getPackageManager();
        str2 = this.mContext.getPackageName();
        localzzpb.setAppId(str2);
        localzzpb.setAppInstallerId(localPackageManager.getInstallerPackageName(str2));
        localObject5 = null;
        localObject3 = str2;
      }
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
        localObject4 = localObject5;
        str1 = str2;
        if (localPackageInfo != null)
        {
          localObject3 = str2;
          localObject4 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
          str1 = str2;
          localObject3 = str2;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject3 = str2;
            str1 = ((CharSequence)localObject4).toString();
          }
          localObject3 = str1;
          localObject4 = localPackageInfo.versionName;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          String str1;
          Log.e("GAv4", "Error retrieving package info: appName set to " + (String)localObject3);
          Object localObject4 = localObject5;
          Object localObject1 = localObject3;
        }
      }
      localzzpb.setAppName(str1);
      localzzpb.setAppVersion((String)localObject4);
      this.zzNs = localzzpb;
      return this.zzNs;
    }
    finally {}
  }
  
  public zzpd zzys()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    zzpd localzzpd = new zzpd();
    localzzpd.setLanguage(zzam.zza(Locale.getDefault()));
    localzzpd.zzhX(localDisplayMetrics.widthPixels);
    localzzpd.zzhY(localDisplayMetrics.heightPixels);
    return localzzpd;
  }
  
  private class zza
    extends ThreadPoolExecutor
  {
    public zza()
    {
      super(1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      setThreadFactory(new zzg.zzb(null));
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      new FutureTask(paramRunnable, paramT)
      {
        protected void setException(Throwable paramAnonymousThrowable)
        {
          Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = zzg.zzb(zzg.this);
          if (localUncaughtExceptionHandler != null) {
            localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), paramAnonymousThrowable);
          }
          for (;;)
          {
            super.setException(paramAnonymousThrowable);
            return;
            if (Log.isLoggable("GAv4", 6)) {
              Log.e("GAv4", "MeasurementExecutor: job failed with " + paramAnonymousThrowable);
            }
          }
        }
      };
    }
  }
  
  private static class zzb
    implements ThreadFactory
  {
    private static final AtomicInteger zzaLk = new AtomicInteger();
    
    public Thread newThread(Runnable paramRunnable)
    {
      return new zzg.zzc(paramRunnable, "measurement-" + zzaLk.incrementAndGet());
    }
  }
  
  private static class zzc
    extends Thread
  {
    zzc(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */