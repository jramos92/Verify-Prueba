package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzk.zza;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzli
  extends GoogleApiClient
{
  private final Context mContext;
  private final int zzaaM;
  private final Looper zzaaO;
  private final GoogleApiAvailability zzaaP;
  final Api.zza<? extends zzqw, zzqx> zzaaQ;
  final zzf zzabI;
  final Map<Api<?>, Integer> zzabJ;
  private final Condition zzabY;
  final zzk zzabZ;
  private final Lock zzabt = new ReentrantLock();
  final Queue<zzf<?>> zzaca = new LinkedList();
  private volatile boolean zzacb;
  private long zzacc = 120000L;
  private long zzacd = 5000L;
  private final zza zzace;
  zzd zzacf;
  final Map<Api.zzc<?>, Api.zzb> zzacg = new HashMap();
  final Map<Api.zzc<?>, ConnectionResult> zzach = new HashMap();
  Set<Scope> zzaci = new HashSet();
  private volatile zzlj zzacj;
  private ConnectionResult zzack = null;
  private final Set<zzlm<?>> zzacl = Collections.newSetFromMap(new WeakHashMap());
  final Set<zzf<?>> zzacm = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  private zza zzacn;
  private final zze zzaco = new zze()
  {
    public void zzc(zzli.zzf<?> paramAnonymouszzf)
    {
      zzli.this.zzacm.remove(paramAnonymouszzf);
      if ((paramAnonymouszzf.zznF() != null) && (zzli.zza(zzli.this) != null)) {
        zzli.zza(zzli.this).remove(paramAnonymouszzf.zznF().intValue());
      }
    }
  };
  private final GoogleApiClient.ConnectionCallbacks zzacp = new GoogleApiClient.ConnectionCallbacks()
  {
    public void onConnected(Bundle paramAnonymousBundle)
    {
      zzli.zzb(zzli.this).lock();
      try
      {
        zzli.zzc(zzli.this).onConnected(paramAnonymousBundle);
        return;
      }
      finally
      {
        zzli.zzb(zzli.this).unlock();
      }
    }
    
    public void onConnectionSuspended(int paramAnonymousInt)
    {
      zzli.zzb(zzli.this).lock();
      try
      {
        zzli.zzc(zzli.this).onConnectionSuspended(paramAnonymousInt);
        return;
      }
      finally
      {
        zzli.zzb(zzli.this).unlock();
      }
    }
  };
  private final zzk.zza zzacq = new zzk.zza()
  {
    public boolean isConnected()
    {
      return zzli.this.isConnected();
    }
    
    public Bundle zzmS()
    {
      return null;
    }
  };
  
  public zzli(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzqw, zzqx> paramzza, Map<Api<?>, Api.ApiOptions> paramMap, ArrayList<GoogleApiClient.ConnectionCallbacks> paramArrayList, ArrayList<GoogleApiClient.OnConnectionFailedListener> paramArrayList1, int paramInt)
  {
    this.mContext = paramContext;
    this.zzabZ = new zzk(paramLooper, this.zzacq);
    this.zzaaO = paramLooper;
    this.zzace = new zza(paramLooper);
    this.zzaaP = paramGoogleApiAvailability;
    this.zzaaM = paramInt;
    this.zzabJ = new HashMap();
    this.zzabY = this.zzabt.newCondition();
    this.zzacj = new zzlh(this);
    paramGoogleApiAvailability = paramArrayList.iterator();
    while (paramGoogleApiAvailability.hasNext())
    {
      paramArrayList = (GoogleApiClient.ConnectionCallbacks)paramGoogleApiAvailability.next();
      this.zzabZ.registerConnectionCallbacks(paramArrayList);
    }
    paramGoogleApiAvailability = paramArrayList1.iterator();
    while (paramGoogleApiAvailability.hasNext())
    {
      paramArrayList = (GoogleApiClient.OnConnectionFailedListener)paramGoogleApiAvailability.next();
      this.zzabZ.registerConnectionFailedListener(paramArrayList);
    }
    paramArrayList = paramzzf.zzoM();
    paramArrayList1 = paramMap.keySet().iterator();
    Api localApi;
    if (paramArrayList1.hasNext())
    {
      localApi = (Api)paramArrayList1.next();
      paramGoogleApiAvailability = paramMap.get(localApi);
      if (paramArrayList.get(localApi) == null) {
        break label522;
      }
      if (((zzf.zza)paramArrayList.get(localApi)).zzafk) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      label402:
      this.zzabJ.put(localApi, Integer.valueOf(paramInt));
      if (localApi.zzny()) {}
      for (paramGoogleApiAvailability = zza(localApi.zznw(), paramGoogleApiAvailability, paramContext, paramLooper, paramzzf, this.zzacp, zza(localApi, paramInt));; paramGoogleApiAvailability = zza(localApi.zznv(), paramGoogleApiAvailability, paramContext, paramLooper, paramzzf, this.zzacp, zza(localApi, paramInt)))
      {
        this.zzacg.put(localApi.zznx(), paramGoogleApiAvailability);
        break;
        paramInt = 2;
        break label402;
      }
      this.zzabI = paramzzf;
      this.zzaaQ = paramzza;
      return;
      label522:
      paramInt = 0;
    }
  }
  
  private void resume()
  {
    this.zzabt.lock();
    try
    {
      if (zzoc()) {
        connect();
      }
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  private static <C extends Api.zzb, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return paramzza.zza(paramContext, paramLooper, paramzzf, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private GoogleApiClient.OnConnectionFailedListener zza(final Api<?> paramApi, final int paramInt)
  {
    new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        zzli.zzb(zzli.this).lock();
        try
        {
          zzli.zzc(zzli.this).zza(paramAnonymousConnectionResult, paramApi, paramInt);
          return;
        }
        finally
        {
          zzli.zzb(zzli.this).unlock();
        }
      }
    };
  }
  
  private static <C extends Api.zzd, O> zzac zza(Api.zze<C, O> paramzze, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzac(paramContext, paramLooper, paramzze.zznA(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf, paramzze.zzn(paramObject));
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzlo paramzzlo, final boolean paramBoolean)
  {
    zzlx.zzagw.zzb(paramGoogleApiClient).setResultCallback(new ResultCallback()
    {
      public void zzo(Status paramAnonymousStatus)
      {
        if ((paramAnonymousStatus.isSuccess()) && (zzli.this.isConnected())) {
          zzli.this.reconnect();
        }
        paramzzlo.zzb(paramAnonymousStatus);
        if (paramBoolean) {
          paramGoogleApiClient.disconnect();
        }
      }
    });
  }
  
  private static void zza(zzf<?> paramzzf, zza paramzza, IBinder paramIBinder)
  {
    if (paramzzf.isReady())
    {
      paramzzf.zza(new zzc(paramzzf, paramzza, paramIBinder, null));
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()))
    {
      zzc localzzc = new zzc(paramzzf, paramzza, paramIBinder, null);
      paramzzf.zza(localzzc);
      try
      {
        paramIBinder.linkToDeath(localzzc, 0);
        return;
      }
      catch (RemoteException paramIBinder)
      {
        paramzzf.cancel();
        paramzza.remove(paramzzf.zznF().intValue());
        return;
      }
    }
    paramzzf.zza(null);
    paramzzf.cancel();
    paramzza.remove(paramzzf.zznF().intValue());
  }
  
  private void zzod()
  {
    this.zzabt.lock();
    try
    {
      if (zzof()) {
        connect();
      }
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      zzx.zza(bool, "blockingConnect must not be called on the UI thread");
      this.zzabt.lock();
      try
      {
        connect();
        for (;;)
        {
          bool = isConnecting();
          if (!bool) {
            break label86;
          }
          try
          {
            this.zzabY.await();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            localConnectionResult = new ConnectionResult(15, null);
            return localConnectionResult;
          }
        }
        bool = false;
        continue;
        label86:
        if (isConnected())
        {
          localConnectionResult = ConnectionResult.zzZY;
          return localConnectionResult;
        }
        if (this.zzack != null)
        {
          localConnectionResult = this.zzack;
          return localConnectionResult;
        }
        ConnectionResult localConnectionResult = new ConnectionResult(13, null);
        return localConnectionResult;
      }
      finally
      {
        this.zzabt.unlock();
      }
    }
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      zzx.zza(bool, "blockingConnect must not be called on the UI thread");
      zzx.zzb(paramTimeUnit, "TimeUnit must not be null");
      this.zzabt.lock();
      try
      {
        connect();
        paramLong = paramTimeUnit.toNanos(paramLong);
        for (;;)
        {
          bool = isConnecting();
          if (!bool) {
            break;
          }
          try
          {
            long l = this.zzabY.awaitNanos(paramLong);
            paramLong = l;
            if (l <= 0L)
            {
              paramTimeUnit = new ConnectionResult(14, null);
              return paramTimeUnit;
            }
          }
          catch (InterruptedException paramTimeUnit)
          {
            Thread.currentThread().interrupt();
            paramTimeUnit = new ConnectionResult(15, null);
            return paramTimeUnit;
          }
        }
        bool = false;
        continue;
        if (isConnected())
        {
          paramTimeUnit = ConnectionResult.zzZY;
          return paramTimeUnit;
        }
        if (this.zzack != null)
        {
          paramTimeUnit = this.zzack;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        this.zzabt.unlock();
      }
    }
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
    final zzlo localzzlo = new zzlo(this);
    if (this.zzacg.containsKey(zzlx.zzRk))
    {
      zza(this, localzzlo, false);
      return localzzlo;
    }
    final AtomicReference localAtomicReference = new AtomicReference();
    Object localObject = new GoogleApiClient.ConnectionCallbacks()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        zzli.zza(zzli.this, (GoogleApiClient)localAtomicReference.get(), localzzlo, true);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt) {}
    };
    GoogleApiClient.OnConnectionFailedListener local6 = new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        localzzlo.zzb(new Status(8));
      }
    };
    localObject = new GoogleApiClient.Builder(this.mContext).addApi(zzlx.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject).addOnConnectionFailedListener(local6).setHandler(this.zzace).build();
    localAtomicReference.set(localObject);
    ((GoogleApiClient)localObject).connect();
    return localzzlo;
  }
  
  public void connect()
  {
    this.zzabt.lock();
    try
    {
      this.zzacj.connect();
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  public void disconnect()
  {
    this.zzabt.lock();
    try
    {
      zzof();
      this.zzacj.disconnect();
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mState=").append(this.zzacj.getName());
    paramPrintWriter.append(" mResuming=").print(this.zzacb);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.zzaca.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(this.zzacm.size());
    String str = paramString + "  ";
    Iterator localIterator = this.zzabJ.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zzb)this.zzacg.get(localApi.zznx())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    Api.zzc localzzc = paramApi.zznx();
    this.zzabt.lock();
    try
    {
      if ((!isConnected()) && (!zzoc())) {
        throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
      }
    }
    finally
    {
      this.zzabt.unlock();
    }
    if (this.zzacg.containsKey(localzzc))
    {
      if (((Api.zzb)this.zzacg.get(localzzc)).isConnected())
      {
        paramApi = ConnectionResult.zzZY;
        this.zzabt.unlock();
        return paramApi;
      }
      if (this.zzach.containsKey(localzzc))
      {
        paramApi = (ConnectionResult)this.zzach.get(localzzc);
        this.zzabt.unlock();
        return paramApi;
      }
      Log.i("GoogleApiClientImpl", zzog());
      Log.wtf("GoogleApiClientImpl", paramApi.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed connections map", new Exception());
      paramApi = new ConnectionResult(8, null);
      this.zzabt.unlock();
      return paramApi;
    }
    this.zzabt.unlock();
    throw new IllegalArgumentException(paramApi.getName() + " was never registered with GoogleApiClient");
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public Looper getLooper()
  {
    return this.zzaaO;
  }
  
  public int getSessionId()
  {
    return System.identityHashCode(this);
  }
  
  public boolean hasConnectedApi(Api<?> paramApi)
  {
    paramApi = (Api.zzb)this.zzacg.get(paramApi.zznx());
    return (paramApi != null) && (paramApi.isConnected());
  }
  
  public boolean isConnected()
  {
    return this.zzacj instanceof zzlf;
  }
  
  public boolean isConnecting()
  {
    return this.zzacj instanceof zzlg;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zzabZ.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zzabZ.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzabZ.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzabZ.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(final FragmentActivity paramFragmentActivity)
  {
    if (this.zzaaM >= 0)
    {
      zzlp localzzlp = zzlp.zza(paramFragmentActivity);
      if (localzzlp == null)
      {
        new Handler(this.mContext.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            if ((paramFragmentActivity.isFinishing()) || (paramFragmentActivity.getSupportFragmentManager().isDestroyed())) {
              return;
            }
            zzlp.zzb(paramFragmentActivity).zzbp(zzli.zzf(zzli.this));
          }
        });
        return;
      }
      localzzlp.zzbp(this.zzaaM);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zzabZ.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zzabZ.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public <C extends Api.zzb> C zza(Api.zzc<C> paramzzc)
  {
    paramzzc = (Api.zzb)this.zzacg.get(paramzzc);
    zzx.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T paramT)
  {
    if (paramT.zznx() != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      zzx.zzb(this.zzacg.containsKey(paramT.zznx()), "GoogleApiClient is not configured to use the API required for this call.");
      this.zzabt.lock();
      try
      {
        paramT = this.zzacj.zza(paramT);
        return paramT;
      }
      finally
      {
        this.zzabt.unlock();
      }
    }
  }
  
  void zza(zzb paramzzb)
  {
    paramzzb = this.zzace.obtainMessage(3, paramzzb);
    this.zzace.sendMessage(paramzzb);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.zzace.obtainMessage(4, paramRuntimeException);
    this.zzace.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(Api<?> paramApi)
  {
    return this.zzacg.containsKey(paramApi.zznx());
  }
  
  public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T paramT)
  {
    boolean bool;
    if (paramT.zznx() != null) {
      bool = true;
    }
    for (;;)
    {
      zzx.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      this.zzabt.lock();
      try
      {
        if (!zzoc()) {
          break label113;
        }
        this.zzaca.add(paramT);
        while (!this.zzaca.isEmpty())
        {
          zzf localzzf = (zzf)this.zzaca.remove();
          zzb(localzzf);
          localzzf.zzv(Status.zzabd);
        }
        bool = false;
      }
      finally
      {
        this.zzabt.unlock();
      }
    }
    this.zzabt.unlock();
    return paramT;
    label113:
    paramT = this.zzacj.zzb(paramT);
    this.zzabt.unlock();
    return paramT;
  }
  
  <A extends Api.zzb> void zzb(zzf<A> paramzzf)
  {
    this.zzacm.add(paramzzf);
    paramzzf.zza(this.zzaco);
  }
  
  void zzg(ConnectionResult paramConnectionResult)
  {
    this.zzabt.lock();
    try
    {
      this.zzack = paramConnectionResult;
      this.zzacj = new zzlh(this);
      this.zzacj.begin();
      this.zzabY.signalAll();
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  void zznY()
  {
    Iterator localIterator = this.zzacm.iterator();
    while (localIterator.hasNext())
    {
      zzf localzzf = (zzf)localIterator.next();
      localzzf.zza(null);
      if (localzzf.zznF() == null)
      {
        localzzf.cancel();
      }
      else
      {
        localzzf.zznJ();
        IBinder localIBinder = zza(localzzf.zznx()).zznz();
        zza(localzzf, this.zzacn, localIBinder);
      }
    }
    this.zzacm.clear();
    localIterator = this.zzacl.iterator();
    while (localIterator.hasNext()) {
      ((zzlm)localIterator.next()).clear();
    }
    this.zzacl.clear();
  }
  
  void zznZ()
  {
    Iterator localIterator = this.zzacg.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zzb)localIterator.next()).disconnect();
    }
  }
  
  public <L> zzlm<L> zzo(L paramL)
  {
    zzx.zzb(paramL, "Listener must not be null");
    this.zzabt.lock();
    try
    {
      paramL = new zzlm(this.zzaaO, paramL);
      this.zzacl.add(paramL);
      return paramL;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  void zzoa()
  {
    this.zzabt.lock();
    try
    {
      this.zzacj = new zzlg(this, this.zzabI, this.zzabJ, this.zzaaP, this.zzaaQ, this.zzabt, this.mContext);
      this.zzacj.begin();
      this.zzabY.signalAll();
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  void zzob()
  {
    this.zzabt.lock();
    try
    {
      zzof();
      this.zzacj = new zzlf(this);
      this.zzacj.begin();
      this.zzabY.signalAll();
      return;
    }
    finally
    {
      this.zzabt.unlock();
    }
  }
  
  boolean zzoc()
  {
    return this.zzacb;
  }
  
  void zzoe()
  {
    if (zzoc()) {
      return;
    }
    this.zzacb = true;
    if (this.zzacf == null) {
      this.zzacf = ((zzd)zzll.zza(this.mContext.getApplicationContext(), new zzd(this), this.zzaaP));
    }
    this.zzace.sendMessageDelayed(this.zzace.obtainMessage(1), this.zzacc);
    this.zzace.sendMessageDelayed(this.zzace.obtainMessage(2), this.zzacd);
  }
  
  boolean zzof()
  {
    if (!zzoc()) {
      return false;
    }
    this.zzacb = false;
    this.zzace.removeMessages(2);
    this.zzace.removeMessages(1);
    if (this.zzacf != null)
    {
      this.zzacf.unregister();
      this.zzacf = null;
    }
    return true;
  }
  
  String zzog()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.w("GoogleApiClientImpl", "Unknown message id: " + paramMessage.what);
        return;
      case 1: 
        zzli.zze(zzli.this);
        return;
      case 2: 
        zzli.zzd(zzli.this);
        return;
      case 3: 
        ((zzli.zzb)paramMessage.obj).zzg(zzli.this);
        return;
      }
      throw ((RuntimeException)paramMessage.obj);
    }
  }
  
  static abstract class zzb
  {
    private final zzlj zzacy;
    
    protected zzb(zzlj paramzzlj)
    {
      this.zzacy = paramzzlj;
    }
    
    public final void zzg(zzli paramzzli)
    {
      zzli.zzb(paramzzli).lock();
      try
      {
        zzlj localzzlj1 = zzli.zzc(paramzzli);
        zzlj localzzlj2 = this.zzacy;
        if (localzzlj1 != localzzlj2) {
          return;
        }
        zznO();
        return;
      }
      finally
      {
        zzli.zzb(paramzzli).unlock();
      }
    }
    
    protected abstract void zznO();
  }
  
  private static class zzc
    implements IBinder.DeathRecipient, zzli.zze
  {
    private final WeakReference<zza> zzacA;
    private final WeakReference<IBinder> zzacB;
    private final WeakReference<zzli.zzf<?>> zzacz;
    
    private zzc(zzli.zzf paramzzf, zza paramzza, IBinder paramIBinder)
    {
      this.zzacA = new WeakReference(paramzza);
      this.zzacz = new WeakReference(paramzzf);
      this.zzacB = new WeakReference(paramIBinder);
    }
    
    private void zzoh()
    {
      Object localObject = (zzli.zzf)this.zzacz.get();
      zza localzza = (zza)this.zzacA.get();
      if ((localzza != null) && (localObject != null)) {
        localzza.remove(((zzli.zzf)localObject).zznF().intValue());
      }
      localObject = (IBinder)this.zzacB.get();
      if (this.zzacB != null) {
        ((IBinder)localObject).unlinkToDeath(this, 0);
      }
    }
    
    public void binderDied()
    {
      zzoh();
    }
    
    public void zzc(zzli.zzf<?> paramzzf)
    {
      zzoh();
    }
  }
  
  static class zzd
    extends zzll
  {
    private WeakReference<zzli> zzacC;
    
    zzd(zzli paramzzli)
    {
      this.zzacC = new WeakReference(paramzzli);
    }
    
    public void zzoi()
    {
      zzli localzzli = (zzli)this.zzacC.get();
      if (localzzli == null) {
        return;
      }
      zzli.zzd(localzzli);
    }
  }
  
  static abstract interface zze
  {
    public abstract void zzc(zzli.zzf<?> paramzzf);
  }
  
  static abstract interface zzf<A extends Api.zzb>
  {
    public abstract void cancel();
    
    public abstract boolean isReady();
    
    public abstract void zza(zzli.zze paramzze);
    
    public abstract void zzb(A paramA)
      throws DeadObjectException;
    
    public abstract Integer zznF();
    
    public abstract void zznJ();
    
    public abstract int zznK();
    
    public abstract Api.zzc<A> zznx();
    
    public abstract void zzv(Status paramStatus);
    
    public abstract void zzw(Status paramStatus);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */