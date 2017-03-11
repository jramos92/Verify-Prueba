package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;
import java.util.ArrayList;
import java.util.Iterator;

public class zzf
  extends zzj<zza>
{
  private final String zzQe;
  private final zzd zzaRZ;
  private final zzb zzaSa;
  private boolean zzaSb;
  private final Object zzpd;
  
  public zzf(Context paramContext, Looper paramLooper, zzd paramzzd, com.google.android.gms.common.internal.zzf paramzzf)
  {
    super(paramContext, paramLooper, 24, paramzzf, paramzzd, paramzzd);
    this.zzQe = paramContext.getPackageName();
    this.zzaRZ = ((zzd)zzx.zzw(paramzzd));
    this.zzaRZ.zza(this);
    this.zzaSa = new zzb();
    this.zzpd = new Object();
    this.zzaSb = true;
  }
  
  private void zzBv()
  {
    boolean bool;
    if (!this.zzaSb)
    {
      bool = true;
      com.google.android.gms.common.internal.zzb.zzZ(bool);
      if (!this.zzaSa.isEmpty()) {
        Object localObject = null;
      }
    }
    label122:
    label195:
    label228:
    for (;;)
    {
      ArrayList localArrayList;
      zzb.zza localzza;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.zzaSa.zzBt().iterator();
        if (!localIterator.hasNext()) {
          break label195;
        }
        localzza = (zzb.zza)localIterator.next();
        if (localzza.zzaRO == null) {
          break label122;
        }
        ((zza)zzpc()).zza(this.zzQe, localzza.zzaRM, zzse.zzf(localzza.zzaRO));
        continue;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
      }
      bool = false;
      break;
      if (localzza.zzaRM.equals(localRemoteException))
      {
        localArrayList.add(localzza.zzaRN);
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          ((zza)zzpc()).zza(this.zzQe, localRemoteException, localArrayList);
          localArrayList.clear();
        }
        PlayLoggerContext localPlayLoggerContext = localzza.zzaRM;
        localArrayList.add(localzza.zzaRN);
        break label228;
        if (!localArrayList.isEmpty()) {
          ((zza)zzpc()).zza(this.zzQe, localPlayLoggerContext, localArrayList);
        }
        this.zzaSa.clear();
        return;
      }
    }
  }
  
  private void zzc(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    this.zzaSa.zza(paramPlayLoggerContext, paramLogEvent);
  }
  
  private void zzd(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    try
    {
      zzBv();
      ((zza)zzpc()).zza(this.zzQe, paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
      zzc(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  public void start()
  {
    synchronized (this.zzpd)
    {
      if ((isConnecting()) || (isConnected())) {
        return;
      }
      this.zzaRZ.zzao(true);
      zzoZ();
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.zzpd)
    {
      this.zzaRZ.zzao(false);
      disconnect();
      return;
    }
  }
  
  void zzap(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzaSb;
      this.zzaSb = paramBoolean;
      if ((bool) && (!this.zzaSb)) {
        zzBv();
      }
      return;
    }
  }
  
  public void zzb(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    synchronized (this.zzpd)
    {
      if (this.zzaSb)
      {
        zzc(paramPlayLoggerContext, paramLogEvent);
        return;
      }
      zzd(paramPlayLoggerContext, paramLogEvent);
    }
  }
  
  protected zza zzdA(IBinder paramIBinder)
  {
    return zza.zza.zzdz(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.playlog.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.playlog.internal.IPlayLogService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\playlog\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */