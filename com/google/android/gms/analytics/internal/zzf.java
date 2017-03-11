package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

public class zzf
{
  private static zzf zzMI;
  private final Context mContext;
  private final Context zzMJ;
  private final zzr zzMK;
  private final zzaf zzML;
  private final com.google.android.gms.measurement.zzg zzMM;
  private final zzb zzMN;
  private final zzv zzMO;
  private final zzan zzMP;
  private final zzai zzMQ;
  private final GoogleAnalytics zzMR;
  private final zzn zzMS;
  private final zza zzMT;
  private final zzk zzMU;
  private final zzu zzMV;
  private final zzmn zzpW;
  
  protected zzf(zzg paramzzg)
  {
    Object localObject1 = paramzzg.getApplicationContext();
    zzx.zzb(localObject1, "Application context can't be null");
    zzx.zzb(localObject1 instanceof Application, "getApplicationContext didn't return the application");
    Object localObject2 = paramzzg.zziG();
    zzx.zzw(localObject2);
    this.mContext = ((Context)localObject1);
    this.zzMJ = ((Context)localObject2);
    this.zzpW = paramzzg.zzh(this);
    this.zzMK = paramzzg.zzg(this);
    localObject2 = paramzzg.zzf(this);
    ((zzaf)localObject2).zza();
    this.zzML = ((zzaf)localObject2);
    if (zziv().zzjA()) {
      zziu().zzbc("Google Analytics " + zze.VERSION + " is starting up.");
    }
    for (;;)
    {
      localObject2 = paramzzg.zzq(this);
      ((zzai)localObject2).zza();
      this.zzMQ = ((zzai)localObject2);
      localObject2 = paramzzg.zze(this);
      ((zzan)localObject2).zza();
      this.zzMP = ((zzan)localObject2);
      localObject2 = paramzzg.zzl(this);
      zzn localzzn = paramzzg.zzd(this);
      zza localzza = paramzzg.zzc(this);
      zzk localzzk = paramzzg.zzb(this);
      zzu localzzu = paramzzg.zza(this);
      localObject1 = paramzzg.zzY((Context)localObject1);
      ((com.google.android.gms.measurement.zzg)localObject1).zza(zziF());
      this.zzMM = ((com.google.android.gms.measurement.zzg)localObject1);
      localObject1 = paramzzg.zzi(this);
      localzzn.zza();
      this.zzMS = localzzn;
      localzza.zza();
      this.zzMT = localzza;
      localzzk.zza();
      this.zzMU = localzzk;
      localzzu.zza();
      this.zzMV = localzzu;
      paramzzg = paramzzg.zzp(this);
      paramzzg.zza();
      this.zzMO = paramzzg;
      ((zzb)localObject2).zza();
      this.zzMN = ((zzb)localObject2);
      if (zziv().zzjA()) {
        zziu().zzb("Device AnalyticsService version", zze.VERSION);
      }
      ((GoogleAnalytics)localObject1).zza();
      this.zzMR = ((GoogleAnalytics)localObject1);
      ((zzb)localObject2).start();
      return;
      zziu().zzbc("Google Analytics " + zze.VERSION + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
    }
  }
  
  public static zzf zzX(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzMI == null) {}
    try
    {
      if (zzMI == null)
      {
        zzmn localzzmn = zzmp.zzqt();
        long l1 = localzzmn.elapsedRealtime();
        paramContext = new zzf(new zzg(paramContext.getApplicationContext()));
        zzMI = paramContext;
        GoogleAnalytics.zzhN();
        l1 = localzzmn.elapsedRealtime() - l1;
        long l2 = ((Long)zzy.zzOU.get()).longValue();
        if (l1 > l2) {
          paramContext.zziu().zzc("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
        }
      }
      return zzMI;
    }
    finally {}
  }
  
  private void zza(zzd paramzzd)
  {
    zzx.zzb(paramzzd, "Analytics service not created/initialized");
    zzx.zzb(paramzzd.isInitialized(), "Analytics service not initialized");
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public zzb zzhP()
  {
    zza(this.zzMN);
    return this.zzMN;
  }
  
  public zzan zzhQ()
  {
    zza(this.zzMP);
    return this.zzMP;
  }
  
  public zzk zziB()
  {
    zza(this.zzMU);
    return this.zzMU;
  }
  
  public zzu zziC()
  {
    return this.zzMV;
  }
  
  protected Thread.UncaughtExceptionHandler zziF()
  {
    new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        paramAnonymousThread = zzf.this.zziH();
        if (paramAnonymousThread != null) {
          paramAnonymousThread.zze("Job execution failed", paramAnonymousThrowable);
        }
      }
    };
  }
  
  public Context zziG()
  {
    return this.zzMJ;
  }
  
  public zzaf zziH()
  {
    return this.zzML;
  }
  
  public GoogleAnalytics zziI()
  {
    zzx.zzw(this.zzMR);
    zzx.zzb(this.zzMR.isInitialized(), "Analytics instance not initialized");
    return this.zzMR;
  }
  
  public zzai zziJ()
  {
    if ((this.zzMQ == null) || (!this.zzMQ.isInitialized())) {
      return null;
    }
    return this.zzMQ;
  }
  
  public zza zziK()
  {
    zza(this.zzMT);
    return this.zzMT;
  }
  
  public zzn zziL()
  {
    zza(this.zzMS);
    return this.zzMS;
  }
  
  public void zzis() {}
  
  public zzmn zzit()
  {
    return this.zzpW;
  }
  
  public zzaf zziu()
  {
    zza(this.zzML);
    return this.zzML;
  }
  
  public zzr zziv()
  {
    return this.zzMK;
  }
  
  public com.google.android.gms.measurement.zzg zziw()
  {
    zzx.zzw(this.zzMM);
    return this.zzMM;
  }
  
  public zzv zzix()
  {
    zza(this.zzMO);
    return this.zzMO;
  }
  
  public zzai zziy()
  {
    zza(this.zzMQ);
    return this.zzMQ;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */