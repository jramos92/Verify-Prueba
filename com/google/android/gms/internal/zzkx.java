package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzkx
  extends zzj<zzkz>
  implements IBinder.DeathRecipient
{
  private static final zzl zzVo = new zzl("CastRemoteDisplayClientImpl");
  private CastDevice zzUY;
  private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzZT;
  
  public zzkx(Context paramContext, Looper paramLooper, zzf paramzzf, CastDevice paramCastDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks paramCastRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 83, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzVo.zzb("instance created", new Object[0]);
    this.zzZT = paramCastRemoteDisplaySessionCallbacks;
    this.zzUY = paramCastDevice;
  }
  
  public void binderDied() {}
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: getstatic 27	com/google/android/gms/internal/zzkx:zzVo	Lcom/google/android/gms/cast/internal/zzl;
    //   3: ldc 54
    //   5: iconst_0
    //   6: anewarray 36	java/lang/Object
    //   9: invokevirtual 40	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 42	com/google/android/gms/internal/zzkx:zzZT	Lcom/google/android/gms/cast/CastRemoteDisplay$CastRemoteDisplaySessionCallbacks;
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 44	com/google/android/gms/internal/zzkx:zzUY	Lcom/google/android/gms/cast/CastDevice;
    //   22: aload_0
    //   23: invokevirtual 58	com/google/android/gms/internal/zzkx:zzpc	()Landroid/os/IInterface;
    //   26: checkcast 60	com/google/android/gms/internal/zzkz
    //   29: invokeinterface 62 1 0
    //   34: aload_0
    //   35: invokespecial 63	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: invokespecial 63	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 63	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: goto -13 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	zzkx
    //   39	1	1	localIllegalStateException	IllegalStateException
    //   45	6	1	localObject	Object
    //   52	1	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   22	34	39	java/lang/IllegalStateException
    //   22	34	45	finally
    //   22	34	52	android/os/RemoteException
  }
  
  public void zza(zzky paramzzky)
    throws RemoteException
  {
    zzVo.zzb("stopRemoteDisplay", new Object[0]);
    ((zzkz)zzpc()).zza(paramzzky);
  }
  
  public void zza(zzky paramzzky, int paramInt)
    throws RemoteException
  {
    ((zzkz)zzpc()).zza(paramzzky, paramInt);
  }
  
  public void zza(zzky paramzzky, final zzla paramzzla, String paramString)
    throws RemoteException
  {
    zzVo.zzb("startRemoteDisplay", new Object[0]);
    paramzzla = new zzla.zza()
    {
      public void zzbg(int paramAnonymousInt)
        throws RemoteException
      {
        zzkx.zznm().zzb("onRemoteDisplayEnded", new Object[0]);
        if (paramzzla != null) {
          paramzzla.zzbg(paramAnonymousInt);
        }
        if (zzkx.zzb(zzkx.this) != null) {
          zzkx.zzb(zzkx.this).onRemoteDisplayEnded(new Status(paramAnonymousInt));
        }
      }
    };
    ((zzkz)zzpc()).zza(paramzzky, paramzzla, this.zzUY.getDeviceId(), paramString);
  }
  
  public zzkz zzaC(IBinder paramIBinder)
  {
    return zzkz.zza.zzaE(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.cast.remote_display.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */