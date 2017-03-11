package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.measurement.AppMeasurementService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzab
  extends zzy
{
  private final zza zzaOl;
  private zzm zzaOm;
  private Boolean zzaOn;
  private final zze zzaOo;
  private final zzac zzaOp;
  private final List<Runnable> zzaOq = new ArrayList();
  private final zze zzaOr;
  
  protected zzab(zzv paramzzv)
  {
    super(paramzzv);
    this.zzaOp = new zzac(paramzzv.zzit());
    this.zzaOl = new zza();
    this.zzaOo = new zze(paramzzv)
    {
      public void run()
      {
        zzab.zzb(zzab.this);
      }
    };
    this.zzaOr = new zze(paramzzv)
    {
      public void run()
      {
        zzab.this.zzyd().zzzL().zzec("Tasks have been queued for a long time");
      }
    };
  }
  
  private void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzis();
    if (this.zzaOm != null)
    {
      this.zzaOm = null;
      zzyd().zzzQ().zzj("Disconnected from device MeasurementService", paramComponentName);
      zzAu();
    }
  }
  
  private boolean zzAs()
  {
    List localList = getContext().getPackageManager().queryIntentServices(new Intent(getContext(), AppMeasurementService.class), 65536);
    return (localList != null) && (localList.size() > 0);
  }
  
  private boolean zzAt()
  {
    zzis();
    zziE();
    if (zzzt().zzjA()) {
      return true;
    }
    Intent localIntent = new Intent("com.google.android.gms.measurement.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.measurement.service.MeasurementBrokerService"));
    zzb localzzb = zzb.zzqh();
    zzyd().zzzQ().zzec("Checking service availability");
    if (localzzb.zza(getContext(), localIntent, new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {}
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    }, 0))
    {
      zzyd().zzzQ().zzec("Service available");
      return true;
    }
    return false;
  }
  
  private void zzAu()
  {
    zzis();
    zzjg();
  }
  
  private void zzAv()
  {
    zzis();
    zzyd().zzzQ().zzj("Flushing task queue", Integer.valueOf(this.zzaOq.size()));
    Iterator localIterator = this.zzaOq.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      zzzr().zzh(localRunnable);
    }
    this.zzaOq.clear();
    this.zzaOr.cancel();
  }
  
  private void zza(zzm paramzzm)
  {
    zzis();
    zzx.zzw(paramzzm);
    this.zzaOm = paramzzm;
    zziR();
    zzAv();
  }
  
  private void zziR()
  {
    zzis();
    this.zzaOp.start();
    this.zzaOo.zzt(zzzt().zzjV());
  }
  
  private void zziS()
  {
    zzis();
    if (!isConnected()) {
      return;
    }
    zzyd().zzzQ().zzec("Inactivity, disconnecting from AppMeasurementService");
    disconnect();
  }
  
  private void zzj(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzis();
    if (isConnected())
    {
      paramRunnable.run();
      return;
    }
    if (this.zzaOq.size() >= zzzt().zzze())
    {
      zzyd().zzzK().zzec("Discarding data. Max runnable queue size reached");
      return;
    }
    this.zzaOq.add(paramRunnable);
    this.zzaOr.zzt(60000L);
    zzjg();
  }
  
  private void zzjg()
  {
    zzis();
    zziE();
    if (isConnected()) {
      return;
    }
    if (this.zzaOn == null)
    {
      this.zzaOn = zzzs().zzzW();
      if (this.zzaOn == null)
      {
        zzyd().zzzQ().zzec("State of service unknown");
        this.zzaOn = Boolean.valueOf(zzAt());
        zzzs().zzan(this.zzaOn.booleanValue());
      }
    }
    if (this.zzaOn.booleanValue())
    {
      zzyd().zzzQ().zzec("Using measurement service");
      this.zzaOl.zzAw();
      return;
    }
    if (zzAs())
    {
      zzyd().zzzQ().zzec("Using local app measurement service");
      Intent localIntent = new Intent("com.google.android.gms.measurement.START");
      localIntent.setComponent(new ComponentName(getContext(), AppMeasurementService.class));
      this.zzaOl.zzu(localIntent);
      return;
    }
    if (zzzt().zzjB())
    {
      zzyd().zzzQ().zzec("Using direct local measurement implementation");
      zza(new zzw(this.zzaKG, true));
      return;
    }
    zzyd().zzzK().zzec("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
  }
  
  public void disconnect()
  {
    zzis();
    zziE();
    try
    {
      zzb.zzqh().zza(getContext(), this.zzaOl);
      if (this.zzaOm != null) {
        this.zzaOm = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public boolean isConnected()
  {
    zzis();
    zziE();
    return this.zzaOm != null;
  }
  
  protected void zzAr()
  {
    zzis();
    zziE();
    zzj(new Runnable()
    {
      public void run()
      {
        zzm localzzm = zzab.zzc(zzab.this);
        if (localzzm == null)
        {
          zzab.this.zzyd().zzzK().zzec("Discarding data. Failed to send app launch");
          return;
        }
        try
        {
          localzzm.zza(zzab.this.zzzo().zzzG());
          zzab.zzd(zzab.this);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          zzab.this.zzyd().zzzK().zzj("Failed to send app launch to AppMeasurementService", localRemoteException);
        }
      }
    });
  }
  
  protected void zzhR() {}
  
  protected class zza
    implements ServiceConnection, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private volatile boolean zzaOt;
    private volatile zzo zzaOu;
    
    protected zza() {}
    
    public void onConnected(final Bundle paramBundle)
    {
      zzx.zzci("MeasurementServiceConnection.onConnected");
      for (;;)
      {
        try
        {
          this.zzaOt = false;
        }
        finally {}
        try
        {
          paramBundle = (zzm)this.zzaOu.zzpc();
          this.zzaOu = null;
          zzab.this.zzzr().zzh(new Runnable()
          {
            public void run()
            {
              if (!zzab.this.isConnected())
              {
                zzab.this.zzyd().zzzP().zzec("Connected to remote service");
                zzab.zza(zzab.this, paramBundle);
              }
            }
          });
          return;
        }
        catch (IllegalStateException paramBundle)
        {
          continue;
        }
        catch (DeadObjectException paramBundle)
        {
          continue;
        }
        this.zzaOu = null;
      }
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzx.zzci("MeasurementServiceConnection.onConnectionFailed");
      try
      {
        this.zzaOu = null;
        return;
      }
      finally {}
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzx.zzci("MeasurementServiceConnection.onConnectionSuspended");
      zzab.this.zzzr().zzh(new Runnable()
      {
        public void run()
        {
          zzab.zza(zzab.this, new ComponentName(zzab.this.getContext(), AppMeasurementService.class));
        }
      });
    }
    
    /* Error */
    public void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
    {
      // Byte code:
      //   0: ldc 93
      //   2: invokestatic 49	com/google/android/gms/common/internal/zzx:zzci	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: iconst_0
      //   9: putfield 51	com/google/android/gms/measurement/internal/zzab$zza:zzaOt	Z
      //   12: aload_2
      //   13: ifnonnull +21 -> 34
      //   16: aload_0
      //   17: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   20: invokevirtual 97	com/google/android/gms/measurement/internal/zzab:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   23: invokevirtual 103	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   26: ldc 105
      //   28: invokevirtual 110	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: aconst_null
      //   35: astore 4
      //   37: aconst_null
      //   38: astore_3
      //   39: aload 4
      //   41: astore_1
      //   42: aload_2
      //   43: invokeinterface 116 1 0
      //   48: astore 5
      //   50: aload 4
      //   52: astore_1
      //   53: ldc 118
      //   55: aload 5
      //   57: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   60: ifeq +62 -> 122
      //   63: aload 4
      //   65: astore_1
      //   66: aload_2
      //   67: invokestatic 130	com/google/android/gms/measurement/internal/zzm$zza:zzcZ	(Landroid/os/IBinder;)Lcom/google/android/gms/measurement/internal/zzm;
      //   70: astore_2
      //   71: aload_2
      //   72: astore_1
      //   73: aload_0
      //   74: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   77: invokevirtual 97	com/google/android/gms/measurement/internal/zzab:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   80: invokevirtual 133	com/google/android/gms/measurement/internal/zzp:zzzQ	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   83: ldc -121
      //   85: invokevirtual 110	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
      //   88: aload_2
      //   89: astore_1
      //   90: aload_1
      //   91: ifnonnull +75 -> 166
      //   94: invokestatic 141	com/google/android/gms/common/stats/zzb:zzqh	()Lcom/google/android/gms/common/stats/zzb;
      //   97: aload_0
      //   98: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   101: invokevirtual 145	com/google/android/gms/measurement/internal/zzab:getContext	()Landroid/content/Context;
      //   104: aload_0
      //   105: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   108: invokestatic 148	com/google/android/gms/measurement/internal/zzab:zza	(Lcom/google/android/gms/measurement/internal/zzab;)Lcom/google/android/gms/measurement/internal/zzab$zza;
      //   111: invokevirtual 151	com/google/android/gms/common/stats/zzb:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
      //   114: aload_0
      //   115: monitorexit
      //   116: return
      //   117: astore_1
      //   118: aload_0
      //   119: monitorexit
      //   120: aload_1
      //   121: athrow
      //   122: aload 4
      //   124: astore_1
      //   125: aload_0
      //   126: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   129: invokevirtual 97	com/google/android/gms/measurement/internal/zzab:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   132: invokevirtual 103	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   135: ldc -103
      //   137: aload 5
      //   139: invokevirtual 157	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
      //   142: aload_3
      //   143: astore_1
      //   144: goto -54 -> 90
      //   147: astore_2
      //   148: aload_0
      //   149: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   152: invokevirtual 97	com/google/android/gms/measurement/internal/zzab:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
      //   155: invokevirtual 103	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
      //   158: ldc -97
      //   160: invokevirtual 110	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
      //   163: goto -73 -> 90
      //   166: aload_0
      //   167: getfield 31	com/google/android/gms/measurement/internal/zzab$zza:zzaOs	Lcom/google/android/gms/measurement/internal/zzab;
      //   170: invokevirtual 65	com/google/android/gms/measurement/internal/zzab:zzzr	()Lcom/google/android/gms/measurement/internal/zzu;
      //   173: new 15	com/google/android/gms/measurement/internal/zzab$zza$1
      //   176: dup
      //   177: aload_0
      //   178: aload_1
      //   179: invokespecial 160	com/google/android/gms/measurement/internal/zzab$zza$1:<init>	(Lcom/google/android/gms/measurement/internal/zzab$zza;Lcom/google/android/gms/measurement/internal/zzm;)V
      //   182: invokevirtual 74	com/google/android/gms/measurement/internal/zzu:zzh	(Ljava/lang/Runnable;)V
      //   185: goto -71 -> 114
      //   188: astore_1
      //   189: goto -75 -> 114
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	192	0	this	zza
      //   0	192	1	paramComponentName	ComponentName
      //   0	192	2	paramIBinder	IBinder
      //   38	105	3	localObject1	Object
      //   35	88	4	localObject2	Object
      //   48	90	5	str	String
      // Exception table:
      //   from	to	target	type
      //   7	12	117	finally
      //   16	33	117	finally
      //   42	50	117	finally
      //   53	63	117	finally
      //   66	71	117	finally
      //   73	88	117	finally
      //   94	114	117	finally
      //   114	116	117	finally
      //   118	120	117	finally
      //   125	142	117	finally
      //   148	163	117	finally
      //   166	185	117	finally
      //   42	50	147	android/os/RemoteException
      //   53	63	147	android/os/RemoteException
      //   66	71	147	android/os/RemoteException
      //   73	88	147	android/os/RemoteException
      //   125	142	147	android/os/RemoteException
      //   94	114	188	java/lang/IllegalArgumentException
    }
    
    public void onServiceDisconnected(final ComponentName paramComponentName)
    {
      zzx.zzci("MeasurementServiceConnection.onServiceDisconnected");
      zzab.this.zzzr().zzh(new Runnable()
      {
        public void run()
        {
          zzab.zza(zzab.this, paramComponentName);
        }
      });
    }
    
    public void zzAw()
    {
      zzab.this.zzis();
      Context localContext1 = zzab.this.getContext();
      try
      {
        if (this.zzaOt)
        {
          zzab.this.zzyd().zzzQ().zzec("Connection attempt already in progress");
          return;
        }
        if (this.zzaOu != null)
        {
          zzab.this.zzyd().zzzQ().zzec("Already awaiting connection attempt");
          return;
        }
      }
      finally {}
      this.zzaOu = new zzo(localContext2, Looper.getMainLooper(), zzf.zzak(localContext2), this, this);
      zzab.this.zzyd().zzzQ().zzec("Connecting to remote service");
      this.zzaOt = true;
      this.zzaOu.zzoZ();
    }
    
    public void zzu(Intent paramIntent)
    {
      zzab.this.zzis();
      Context localContext = zzab.this.getContext();
      zzb localzzb = zzb.zzqh();
      try
      {
        if (this.zzaOt)
        {
          zzab.this.zzyd().zzzQ().zzec("Connection attempt already in progress");
          return;
        }
        this.zzaOt = true;
        localzzb.zza(localContext, paramIntent, zzab.zza(zzab.this), 129);
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */