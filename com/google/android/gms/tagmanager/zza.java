package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import java.io.IOException;

public class zza
{
  private static Object zzaVD = new Object();
  private static zza zzaVE;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final Thread zzIl;
  private volatile AdvertisingIdClient.Info zzMr;
  private volatile long zzaVA = 30000L;
  private volatile long zzaVB;
  private zza zzaVC = new zza()
  {
    public AdvertisingIdClient.Info zzCn()
    {
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza.zza(zza.this));
        return localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        zzbg.zzaH("IllegalStateException getting Advertising Id Info");
        return null;
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        zzbg.zzaH("GooglePlayServicesRepairableException getting Advertising Id Info");
        return null;
      }
      catch (IOException localIOException)
      {
        zzbg.zzaH("IOException getting Ad Id Info");
        return null;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        zzbg.zzaH("GooglePlayServicesNotAvailableException getting Advertising Id Info");
        return null;
      }
      catch (Exception localException)
      {
        zzbg.zzaH("Unknown exception. Could not get the Advertising Id Info.");
      }
      return null;
    }
  };
  private volatile long zzaVz = 900000L;
  private final zzmn zzpW;
  
  private zza(Context paramContext)
  {
    this(paramContext, null, zzmp.zzqt());
  }
  
  public zza(Context paramContext, zza paramzza, zzmn paramzzmn)
  {
    this.zzpW = paramzzmn;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (paramzza != null) {
        this.zzaVC = paramzza;
      }
      this.zzIl = new Thread(new Runnable()
      {
        public void run()
        {
          zza.zzb(zza.this);
        }
      });
      return;
    }
  }
  
  private void zzCl()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed) {
      try
      {
        this.zzMr = this.zzaVC.zzCn();
        Thread.sleep(this.zzaVz);
      }
      catch (InterruptedException localInterruptedException)
      {
        zzbg.zzaG("sleep interrupted in AdvertiserDataPoller thread; continuing");
      }
    }
  }
  
  private void zzCm()
  {
    if (this.zzpW.currentTimeMillis() - this.zzaVB < this.zzaVA) {
      return;
    }
    interrupt();
    this.zzaVB = this.zzpW.currentTimeMillis();
  }
  
  public static zza zzaN(Context paramContext)
  {
    if (zzaVE == null) {}
    synchronized (zzaVD)
    {
      if (zzaVE == null)
      {
        zzaVE = new zza(paramContext);
        zzaVE.start();
      }
      return zzaVE;
    }
  }
  
  public void interrupt()
  {
    this.zzIl.interrupt();
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    zzCm();
    if (this.zzMr == null) {
      return true;
    }
    return this.zzMr.isLimitAdTrackingEnabled();
  }
  
  public void start()
  {
    this.zzIl.start();
  }
  
  public String zzCk()
  {
    zzCm();
    if (this.zzMr == null) {
      return null;
    }
    return this.zzMr.getId();
  }
  
  public static abstract interface zza
  {
    public abstract AdvertisingIdClient.Info zzCn();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */