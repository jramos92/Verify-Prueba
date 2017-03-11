package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb
  extends zzd
{
  private final zzl zzMw;
  
  public zzb(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzx.zzw(paramzzg);
    this.zzMw = paramzzg.zzj(paramzzf);
  }
  
  void onServiceConnected()
  {
    zzis();
    this.zzMw.onServiceConnected();
  }
  
  public void setLocalDispatchPeriod(final int paramInt)
  {
    zziE();
    zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzs(paramInt * 1000L);
      }
    });
  }
  
  public void start()
  {
    this.zzMw.start();
  }
  
  public void zzI(final boolean paramBoolean)
  {
    zza("Network connectivity status changed", Boolean.valueOf(paramBoolean));
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzI(paramBoolean);
      }
    });
  }
  
  public long zza(zzh paramzzh)
  {
    zziE();
    zzx.zzw(paramzzh);
    zzis();
    long l = this.zzMw.zza(paramzzh, true);
    if (l == 0L) {
      this.zzMw.zzc(paramzzh);
    }
    return l;
  }
  
  public void zza(final zzab paramzzab)
  {
    zzx.zzw(paramzzab);
    zziE();
    zzb("Hit delivery requested", paramzzab);
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zza(paramzzab);
      }
    });
  }
  
  public void zza(final zzw paramzzw)
  {
    zziE();
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzb(paramzzw);
      }
    });
  }
  
  public void zza(final String paramString, final Runnable paramRunnable)
  {
    zzx.zzh(paramString, "campaign param can't be empty");
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzbi(paramString);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
  }
  
  protected void zzhR()
  {
    this.zzMw.zza();
  }
  
  public void zzik()
  {
    zziE();
    zzir();
    zziw().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzik();
      }
    });
  }
  
  public void zzil()
  {
    zziE();
    Context localContext = getContext();
    if ((AnalyticsReceiver.zzV(localContext)) && (AnalyticsService.zzW(localContext)))
    {
      Intent localIntent = new Intent(localContext, AnalyticsService.class);
      localIntent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localContext.startService(localIntent);
      return;
    }
    zza(null);
  }
  
  public boolean zzim()
  {
    zziE();
    Future localFuture = zziw().zzb(new Callable()
    {
      public Void zzgA()
        throws Exception
      {
        zzb.zza(zzb.this).zzjj();
        return null;
      }
    });
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzd("syncDispatchLocalHits interrupted", localInterruptedException);
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      zze("syncDispatchLocalHits failed", localExecutionException);
      return false;
    }
    catch (TimeoutException localTimeoutException)
    {
      zzd("syncDispatchLocalHits timed out", localTimeoutException);
    }
    return false;
  }
  
  public void zzin()
  {
    zziE();
    com.google.android.gms.measurement.zzg.zzis();
    this.zzMw.zzin();
  }
  
  public void zzio()
  {
    zzba("Radio powered up");
    zzil();
  }
  
  void zzip()
  {
    zzis();
    this.zzMw.zzip();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */