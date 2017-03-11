package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlb.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze
  extends zzj<zzi>
{
  private static final zzl zzVo = new zzl("CastClientImpl");
  private static final Object zzYX = new Object();
  private static final Object zzYY = new Object();
  private final Cast.Listener zzUZ;
  private double zzWA;
  private boolean zzWB;
  private ApplicationMetadata zzYF;
  private final CastDevice zzYG;
  private final Map<String, Cast.MessageReceivedCallback> zzYH;
  private final long zzYI;
  private zzb zzYJ;
  private String zzYK;
  private boolean zzYL;
  private boolean zzYM;
  private boolean zzYN;
  private int zzYO;
  private int zzYP;
  private final AtomicLong zzYQ;
  private String zzYR;
  private String zzYS;
  private Bundle zzYT;
  private final Map<Long, zzlb.zzb<Status>> zzYU;
  private zzlb.zzb<Cast.ApplicationConnectionResult> zzYV;
  private zzlb.zzb<Status> zzYW;
  
  public zze(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 10, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzYG = paramCastDevice;
    this.zzUZ = paramListener;
    this.zzYI = paramLong;
    this.zzYH = new HashMap();
    this.zzYQ = new AtomicLong(0L);
    this.zzYU = new HashMap();
    zzmR();
  }
  
  private void zza(ApplicationStatus paramApplicationStatus)
  {
    paramApplicationStatus = paramApplicationStatus.zzmO();
    if (!zzf.zza(paramApplicationStatus, this.zzYK)) {
      this.zzYK = paramApplicationStatus;
    }
    for (boolean bool = true;; bool = false)
    {
      zzVo.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.zzYL) });
      if ((this.zzUZ != null) && ((bool) || (this.zzYL))) {
        this.zzUZ.onApplicationStatusChanged();
      }
      this.zzYL = false;
      return;
    }
  }
  
  private void zza(DeviceStatus paramDeviceStatus)
  {
    ApplicationMetadata localApplicationMetadata = paramDeviceStatus.getApplicationMetadata();
    if (!zzf.zza(localApplicationMetadata, this.zzYF))
    {
      this.zzYF = localApplicationMetadata;
      this.zzUZ.onApplicationMetadataChanged(this.zzYF);
    }
    double d = paramDeviceStatus.zzmU();
    if ((d != NaN.0D) && (Math.abs(d - this.zzWA) > 1.0E-7D)) {
      this.zzWA = d;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramDeviceStatus.zznd();
      if (bool2 != this.zzWB)
      {
        this.zzWB = bool2;
        bool1 = true;
      }
      zzVo.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzYM) });
      if ((this.zzUZ != null) && ((bool1) || (this.zzYM))) {
        this.zzUZ.onVolumeChanged();
      }
      int i = paramDeviceStatus.zzmV();
      if (i != this.zzYO) {
        this.zzYO = i;
      }
      for (bool1 = true;; bool1 = false)
      {
        zzVo.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzYM) });
        if ((this.zzUZ != null) && ((bool1) || (this.zzYM))) {
          this.zzUZ.onActiveInputStateChanged(this.zzYO);
        }
        i = paramDeviceStatus.zzmW();
        if (i != this.zzYP) {
          this.zzYP = i;
        }
        for (bool1 = true;; bool1 = false)
        {
          zzVo.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.zzYM) });
          if ((this.zzUZ != null) && ((bool1) || (this.zzYM))) {
            this.zzUZ.onStandbyStateChanged(this.zzYP);
          }
          this.zzYM = false;
          return;
        }
      }
    }
  }
  
  private void zza(zzlb.zzb<Cast.ApplicationConnectionResult> paramzzb)
  {
    synchronized (zzYX)
    {
      if (this.zzYV != null) {
        this.zzYV.zzp(new zza(new Status(2002)));
      }
      this.zzYV = paramzzb;
      return;
    }
  }
  
  private void zzc(zzlb.zzb<Status> paramzzb)
  {
    synchronized (zzYY)
    {
      if (this.zzYW != null)
      {
        paramzzb.zzp(new Status(2001));
        return;
      }
      this.zzYW = paramzzb;
      return;
    }
  }
  
  private void zzmR()
  {
    this.zzYN = false;
    this.zzYO = -1;
    this.zzYP = -1;
    this.zzYF = null;
    this.zzYK = null;
    this.zzWA = 0.0D;
    this.zzWB = false;
  }
  
  private void zzmX()
  {
    zzVo.zzb("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.zzYH)
    {
      this.zzYH.clear();
      return;
    }
  }
  
  private void zzmY()
    throws IllegalStateException
  {
    if ((!this.zzYN) || (this.zzYJ == null) || (this.zzYJ.isDisposed())) {
      throw new IllegalStateException("Not connected to a device");
    }
  }
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: getstatic 74	com/google/android/gms/cast/internal/zze:zzVo	Lcom/google/android/gms/cast/internal/zzl;
    //   3: ldc_w 283
    //   6: iconst_2
    //   7: anewarray 76	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 266	com/google/android/gms/cast/internal/zze:zzYJ	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: aload_0
    //   20: invokevirtual 286	com/google/android/gms/cast/internal/zze:isConnected	()Z
    //   23: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: aastore
    //   27: invokevirtual 146	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 266	com/google/android/gms/cast/internal/zze:zzYJ	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   34: astore_1
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 266	com/google/android/gms/cast/internal/zze:zzYJ	Lcom/google/android/gms/cast/internal/zze$zzb;
    //   40: aload_1
    //   41: ifnull +10 -> 51
    //   44: aload_1
    //   45: invokevirtual 290	com/google/android/gms/cast/internal/zze$zzb:zznc	()Lcom/google/android/gms/cast/internal/zze;
    //   48: ifnonnull +17 -> 65
    //   51: getstatic 74	com/google/android/gms/cast/internal/zze:zzVo	Lcom/google/android/gms/cast/internal/zzl;
    //   54: ldc_w 292
    //   57: iconst_0
    //   58: anewarray 76	java/lang/Object
    //   61: invokevirtual 146	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: return
    //   65: aload_0
    //   66: invokespecial 294	com/google/android/gms/cast/internal/zze:zzmX	()V
    //   69: aload_0
    //   70: invokevirtual 298	com/google/android/gms/cast/internal/zze:zzpc	()Landroid/os/IInterface;
    //   73: checkcast 300	com/google/android/gms/cast/internal/zzi
    //   76: invokeinterface 302 1 0
    //   81: aload_0
    //   82: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   85: return
    //   86: astore_1
    //   87: getstatic 74	com/google/android/gms/cast/internal/zze:zzVo	Lcom/google/android/gms/cast/internal/zzl;
    //   90: aload_1
    //   91: ldc_w 305
    //   94: iconst_1
    //   95: anewarray 76	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_1
    //   101: invokevirtual 310	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   104: aastore
    //   105: invokevirtual 313	com/google/android/gms/cast/internal/zzl:zzb	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: invokespecial 303	com/google/android/gms/common/internal/zzj:disconnect	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -34 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	zze
    //   34	11	1	localzzb	zzb
    //   86	15	1	localIllegalStateException	IllegalStateException
    //   113	6	1	localObject	Object
    //   120	1	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   69	81	86	java/lang/IllegalStateException
    //   69	81	113	finally
    //   87	108	113	finally
    //   69	81	120	android/os/RemoteException
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    zzmY();
    return this.zzYF;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    zzmY();
    return this.zzYK;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    zzmY();
    return this.zzWB;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    zzmX();
  }
  
  public void zzW(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((zzi)zzpc()).zza(paramBoolean, this.zzWA, this.zzWB);
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    zzVo.zzb("in onPostInitHandler; statusCode=%d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 0) || (paramInt1 == 1001))
    {
      this.zzYN = true;
      this.zzYL = true;
      this.zzYM = true;
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 1001)
      {
        this.zzYT = new Bundle();
        this.zzYT.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        i = 0;
      }
      super.zza(i, paramIBinder, paramBundle, paramInt2);
      return;
      this.zzYN = false;
    }
  }
  
  public void zza(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    zzf.zzbM(paramString);
    zzbL(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.zzYH)
    {
      this.zzYH.put(paramString, paramMessageReceivedCallback);
      ((zzi)zzpc()).zzbQ(paramString);
      return;
    }
  }
  
  public void zza(String paramString, LaunchOptions paramLaunchOptions, zzlb.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    ((zzi)zzpc()).zza(paramString, paramLaunchOptions);
  }
  
  public void zza(String paramString, zzlb.zzb<Status> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zzc(paramzzb);
    ((zzi)zzpc()).zzbP(paramString);
  }
  
  public void zza(String paramString1, String paramString2, JoinOptions paramJoinOptions, zzlb.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    paramzzb = paramJoinOptions;
    if (paramJoinOptions == null) {
      paramzzb = new JoinOptions();
    }
    ((zzi)zzpc()).zza(paramString1, paramString2, paramzzb);
  }
  
  public void zza(String paramString1, String paramString2, zzlb.zzb<Status> paramzzb)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    zzf.zzbM(paramString1);
    zzmY();
    long l = this.zzYQ.incrementAndGet();
    try
    {
      this.zzYU.put(Long.valueOf(l), paramzzb);
      ((zzi)zzpc()).zzb(paramString1, paramString2, l);
      return;
    }
    catch (Throwable paramString1)
    {
      this.zzYU.remove(Long.valueOf(l));
      throw paramString1;
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, zzlb.zzb<Cast.ApplicationConnectionResult> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zza(paramzzb);
    ((zzi)zzpc()).zzf(paramString, paramBoolean);
  }
  
  protected zzi zzaA(IBinder paramIBinder)
  {
    return zzi.zza.zzaB(paramIBinder);
  }
  
  public void zzb(zzlb.zzb<Status> paramzzb)
    throws IllegalStateException, RemoteException
  {
    zzc(paramzzb);
    ((zzi)zzpc()).zzne();
  }
  
  public void zzbL(String paramString)
    throws IllegalArgumentException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.zzYH)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.zzYH.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
  }
  
  public void zzf(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((zzi)zzpc()).zza(paramDouble, this.zzWA, this.zzWB);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  protected Bundle zzly()
  {
    Bundle localBundle = new Bundle();
    zzVo.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] { this.zzYR, this.zzYS });
    this.zzYG.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzYI);
    this.zzYJ = new zzb(this);
    localBundle.putParcelable("listener", new BinderWrapper(this.zzYJ.asBinder()));
    if (this.zzYR != null)
    {
      localBundle.putString("last_application_id", this.zzYR);
      if (this.zzYS != null) {
        localBundle.putString("last_session_id", this.zzYS);
      }
    }
    return localBundle;
  }
  
  public Bundle zzmS()
  {
    if (this.zzYT != null)
    {
      Bundle localBundle = this.zzYT;
      this.zzYT = null;
      return localBundle;
    }
    return super.zzmS();
  }
  
  public void zzmT()
    throws IllegalStateException, RemoteException
  {
    ((zzi)zzpc()).zzmT();
  }
  
  public double zzmU()
    throws IllegalStateException
  {
    zzmY();
    return this.zzWA;
  }
  
  public int zzmV()
    throws IllegalStateException
  {
    zzmY();
    return this.zzYO;
  }
  
  public int zzmW()
    throws IllegalStateException
  {
    zzmY();
    return this.zzYP;
  }
  
  private static final class zza
    implements Cast.ApplicationConnectionResult
  {
    private final String zzHP;
    private final Status zzSC;
    private final ApplicationMetadata zzYZ;
    private final String zzZa;
    private final boolean zzZb;
    
    public zza(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public zza(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.zzSC = paramStatus;
      this.zzYZ = paramApplicationMetadata;
      this.zzZa = paramString1;
      this.zzHP = paramString2;
      this.zzZb = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.zzYZ;
    }
    
    public String getApplicationStatus()
    {
      return this.zzZa;
    }
    
    public String getSessionId()
    {
      return this.zzHP;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
    
    public boolean getWasLaunched()
    {
      return this.zzZb;
    }
  }
  
  private static class zzb
    extends zzj.zza
  {
    private final Handler mHandler;
    private final AtomicReference<zze> zzZc;
    
    public zzb(zze paramzze)
    {
      this.zzZc = new AtomicReference(paramzze);
      this.mHandler = new Handler(paramzze.getLooper());
    }
    
    private void zza(zze paramzze, long paramLong, int paramInt)
    {
      synchronized (zze.zzg(paramzze))
      {
        paramzze = (zzlb.zzb)zze.zzg(paramzze).remove(Long.valueOf(paramLong));
        if (paramzze != null) {
          paramzze.zzp(new Status(paramInt));
        }
        return;
      }
    }
    
    private boolean zza(zze paramzze, int paramInt)
    {
      synchronized ()
      {
        if (zze.zzh(paramzze) != null)
        {
          zze.zzh(paramzze).zzp(new Status(paramInt));
          zze.zzb(paramzze, null);
          return true;
        }
        return false;
      }
    }
    
    public boolean isDisposed()
    {
      return this.zzZc.get() == null;
    }
    
    public void onApplicationDisconnected(final int paramInt)
    {
      final zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {}
      do
      {
        return;
        zze.zza(localzze, null);
        zze.zzb(localzze, null);
        zza(localzze, paramInt);
      } while (zze.zzd(localzze) == null);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (zze.zzd(localzze) != null) {
            zze.zzd(localzze).onApplicationDisconnected(paramInt);
          }
        }
      });
    }
    
    public void zza(ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zze.zza(localzze, paramApplicationMetadata);
      zze.zza(localzze, paramApplicationMetadata.getApplicationId());
      zze.zzb(localzze, paramString2);
      synchronized (zze.zzna())
      {
        if (zze.zzc(localzze) != null)
        {
          zze.zzc(localzze).zzp(new zze.zza(new Status(0), paramApplicationMetadata, paramString1, paramString2, paramBoolean));
          zze.zza(localzze, null);
        }
        return;
      }
    }
    
    public void zza(String paramString, double paramDouble, boolean paramBoolean)
    {
      zze.zzmZ().zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }
    
    public void zza(String paramString, long paramLong, int paramInt)
    {
      paramString = (zze)this.zzZc.get();
      if (paramString == null) {
        return;
      }
      zza(paramString, paramLong, paramInt);
    }
    
    public void zzb(final ApplicationStatus paramApplicationStatus)
    {
      final zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zze.zzmZ().zzb("onApplicationStatusChanged", new Object[0]);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          zze.zza(localzze, paramApplicationStatus);
        }
      });
    }
    
    public void zzb(final DeviceStatus paramDeviceStatus)
    {
      final zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zze.zzmZ().zzb("onDeviceStatusChanged", new Object[0]);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          zze.zza(localzze, paramDeviceStatus);
        }
      });
    }
    
    public void zzb(String paramString, byte[] paramArrayOfByte)
    {
      if ((zze)this.zzZc.get() == null) {
        return;
      }
      zze.zzmZ().zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] { paramString, Integer.valueOf(paramArrayOfByte.length) });
    }
    
    public void zzbb(int paramInt)
    {
      zze localzze = zznc();
      if (localzze == null) {}
      do
      {
        return;
        zze.zzmZ().zzb("ICastDeviceControllerListener.onDisconnected: %d", new Object[] { Integer.valueOf(paramInt) });
      } while (paramInt == 0);
      localzze.zzbE(2);
    }
    
    public void zzbc(int paramInt)
    {
      zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      synchronized (zze.zzna())
      {
        if (zze.zzc(localzze) != null)
        {
          zze.zzc(localzze).zzp(new zze.zza(new Status(paramInt)));
          zze.zza(localzze, null);
        }
        return;
      }
    }
    
    public void zzbd(int paramInt)
    {
      zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zza(localzze, paramInt);
    }
    
    public void zzbe(int paramInt)
    {
      zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zza(localzze, paramInt);
    }
    
    public void zzd(String paramString, long paramLong)
    {
      paramString = (zze)this.zzZc.get();
      if (paramString == null) {
        return;
      }
      zza(paramString, paramLong, 0);
    }
    
    public zze zznc()
    {
      zze localzze = (zze)this.zzZc.getAndSet(null);
      if (localzze == null) {
        return null;
      }
      zze.zzb(localzze);
      return localzze;
    }
    
    public void zzs(final String paramString1, final String paramString2)
    {
      final zze localzze = (zze)this.zzZc.get();
      if (localzze == null) {
        return;
      }
      zze.zzmZ().zzb("Receive (type=text, ns=%s) %s", new Object[] { paramString1, paramString2 });
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          synchronized (zze.zze(localzze))
          {
            Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)zze.zze(localzze).get(paramString1);
            if (localMessageReceivedCallback != null)
            {
              localMessageReceivedCallback.onMessageReceived(zze.zzf(localzze), paramString1, paramString2);
              return;
            }
          }
          zze.zzmZ().zzb("Discarded message for unknown namespace '%s'", new Object[] { paramString1 });
        }
      });
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */