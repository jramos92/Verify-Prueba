package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.analytics.internal.zzy.zza;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends zza
{
  private static List<Runnable> zzLz = new ArrayList();
  private boolean zzLA;
  private Set<zza> zzLB = new HashSet();
  private boolean zzLC;
  private boolean zzLD;
  private volatile boolean zzLE;
  private boolean zzLF;
  private boolean zzpA;
  
  public GoogleAnalytics(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzf.zzX(paramContext).zziI();
  }
  
  public static void zzhN()
  {
    try
    {
      if (zzLz != null)
      {
        Iterator localIterator = zzLz.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        zzLz = null;
      }
    }
    finally {}
  }
  
  private zzb zzhP()
  {
    return zzhF().zzhP();
  }
  
  private zzan zzhQ()
  {
    return zzhF().zzhQ();
  }
  
  public void dispatchLocalHits()
  {
    zzhP().zzil();
  }
  
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.zzLC))
    {
      paramApplication.registerActivityLifecycleCallbacks(new zzb());
      this.zzLC = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    return this.zzLE;
  }
  
  public String getClientId()
  {
    zzx.zzcj("getClientId can not be called from the main thread");
    return zzhF().zziL().zzjt();
  }
  
  @Deprecated
  public Logger getLogger()
  {
    return zzae.getLogger();
  }
  
  public boolean isDryRunEnabled()
  {
    return this.zzLD;
  }
  
  public boolean isInitialized()
  {
    return (this.zzpA) && (!this.zzLA);
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new Tracker(zzhF(), null, null);
      if (paramInt > 0)
      {
        zzal localzzal = (zzal)new zzak(zzhF()).zzad(paramInt);
        if (localzzal != null) {
          localTracker.zza(localzzal);
        }
      }
      localTracker.zza();
      return localTracker;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      paramString = new Tracker(zzhF(), paramString, null);
      paramString.zza();
      return paramString;
    }
    finally {}
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.zzLC) {
      zzl(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.zzLC) {
      zzm(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    this.zzLE = paramBoolean;
    if (this.zzLE) {
      zzhP().zzik();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.zzLD = paramBoolean;
  }
  
  public void setLocalDispatchPeriod(int paramInt)
  {
    zzhP().setLocalDispatchPeriod(paramInt);
  }
  
  @Deprecated
  public void setLogger(Logger paramLogger)
  {
    zzae.setLogger(paramLogger);
    if (!this.zzLF)
    {
      Log.i((String)zzy.zzOg.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + (String)zzy.zzOg.get() + " DEBUG");
      this.zzLF = true;
    }
  }
  
  public void zza()
  {
    zzhM();
    this.zzpA = true;
  }
  
  void zza(zza paramzza)
  {
    this.zzLB.add(paramzza);
    paramzza = zzhF().getContext();
    if ((paramzza instanceof Application)) {
      enableAutoActivityReports((Application)paramzza);
    }
  }
  
  void zzb(zza paramzza)
  {
    this.zzLB.remove(paramzza);
  }
  
  void zzhM()
  {
    zzan localzzan = zzhQ();
    if (localzzan.zzks()) {
      getLogger().setLogLevel(localzzan.getLogLevel());
    }
    if (localzzan.zzkw()) {
      setDryRun(localzzan.zzkx());
    }
    if (localzzan.zzks())
    {
      Logger localLogger = zzae.getLogger();
      if (localLogger != null) {
        localLogger.setLogLevel(localzzan.getLogLevel());
      }
    }
  }
  
  void zzhO()
  {
    zzhP().zzim();
  }
  
  void zzl(Activity paramActivity)
  {
    Iterator localIterator = this.zzLB.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzn(paramActivity);
    }
  }
  
  void zzm(Activity paramActivity)
  {
    Iterator localIterator = this.zzLB.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzo(paramActivity);
    }
  }
  
  static abstract interface zza
  {
    public abstract void zzn(Activity paramActivity);
    
    public abstract void zzo(Activity paramActivity);
  }
  
  class zzb
    implements Application.ActivityLifecycleCallbacks
  {
    zzb() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.this.zzl(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.this.zzm(paramActivity);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */