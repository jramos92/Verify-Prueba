package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzlg
  implements zzlj
{
  private final Context mContext;
  private final GoogleApiAvailability zzaaP;
  private final Api.zza<? extends zzqw, zzqx> zzaaQ;
  private final Set<Api.zzc> zzabA = new HashSet();
  private zzqw zzabB;
  private int zzabC;
  private boolean zzabD;
  private boolean zzabE;
  private zzp zzabF;
  private boolean zzabG;
  private boolean zzabH;
  private final zzf zzabI;
  private final Map<Api<?>, Integer> zzabJ;
  private ArrayList<Future<?>> zzabK = new ArrayList();
  private final zzli zzabr;
  private final Lock zzabt;
  private ConnectionResult zzabu;
  private int zzabv;
  private int zzabw = 0;
  private boolean zzabx = false;
  private int zzaby;
  private final Bundle zzabz = new Bundle();
  
  public zzlg(zzli paramzzli, zzf paramzzf, Map<Api<?>, Integer> paramMap, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzqw, zzqx> paramzza, Lock paramLock, Context paramContext)
  {
    this.zzabr = paramzzli;
    this.zzabI = paramzzf;
    this.zzabJ = paramMap;
    this.zzaaP = paramGoogleApiAvailability;
    this.zzaaQ = paramzza;
    this.zzabt = paramLock;
    this.mContext = paramContext;
  }
  
  private void zzY(boolean paramBoolean)
  {
    if (this.zzabB != null)
    {
      if ((this.zzabB.isConnected()) && (paramBoolean)) {
        this.zzabB.zzCe();
      }
      this.zzabB.disconnect();
      this.zzabF = null;
    }
  }
  
  private void zza(ResolveAccountResponse paramResolveAccountResponse)
  {
    if (!zzbn(0)) {
      return;
    }
    ConnectionResult localConnectionResult = paramResolveAccountResponse.zzpr();
    if (localConnectionResult.isSuccess())
    {
      this.zzabF = paramResolveAccountResponse.zzpq();
      this.zzabE = true;
      this.zzabG = paramResolveAccountResponse.zzps();
      this.zzabH = paramResolveAccountResponse.zzpt();
      zznQ();
      return;
    }
    if (zze(localConnectionResult))
    {
      zznV();
      zznQ();
      return;
    }
    zzf(localConnectionResult);
  }
  
  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zzd(paramConnectionResult))) {}
    while ((this.zzabu != null) && (paramInt1 >= this.zzabv)) {
      return false;
    }
    return true;
  }
  
  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zznv().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        this.zzabu = paramConnectionResult;
        this.zzabv = i;
      }
    }
    this.zzabr.zzach.put(paramApi.zznx(), paramConnectionResult);
  }
  
  private boolean zzbn(int paramInt)
  {
    if (this.zzabw != paramInt)
    {
      Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbo(this.zzabw) + " but received callback for step " + zzbo(paramInt), new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  private String zzbo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_GETTING_SERVICE_BINDINGS";
    case 1: 
      return "STEP_VALIDATING_ACCOUNT";
    case 2: 
      return "STEP_AUTHENTICATING";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  private void zzc(ConnectionResult paramConnectionResult)
  {
    if (!zzbn(2)) {
      return;
    }
    if (paramConnectionResult.isSuccess())
    {
      zznT();
      return;
    }
    if (zze(paramConnectionResult))
    {
      zznV();
      zznT();
      return;
    }
    zzf(paramConnectionResult);
  }
  
  private boolean zzd(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {}
    while (this.zzaaP.zzbi(paramConnectionResult.getErrorCode()) != null) {
      return true;
    }
    return false;
  }
  
  private boolean zze(ConnectionResult paramConnectionResult)
  {
    return (this.zzabC == 2) || ((this.zzabC == 1) && (!paramConnectionResult.hasResolution()));
  }
  
  private void zzf(ConnectionResult paramConnectionResult)
  {
    zznW();
    if (!paramConnectionResult.hasResolution()) {}
    for (boolean bool = true;; bool = false)
    {
      zzY(bool);
      this.zzabr.zzach.clear();
      this.zzabr.zzg(paramConnectionResult);
      if (!this.zzaaP.zzd(this.mContext, paramConnectionResult.getErrorCode())) {
        this.zzabr.zzof();
      }
      if ((!this.zzabx) && (!this.zzabr.zzoc())) {
        this.zzabr.zzabZ.zzi(paramConnectionResult);
      }
      this.zzabx = false;
      this.zzabr.zzabZ.zzpk();
      return;
    }
  }
  
  private boolean zznP()
  {
    this.zzaby -= 1;
    if (this.zzaby > 0) {
      return false;
    }
    if (this.zzaby < 0)
    {
      Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    if (this.zzabu != null)
    {
      zzf(this.zzabu);
      return false;
    }
    return true;
  }
  
  private void zznQ()
  {
    if (this.zzaby != 0) {}
    do
    {
      return;
      if (!this.zzabD) {
        break;
      }
    } while (!this.zzabE);
    zznR();
    return;
    zznT();
  }
  
  private void zznR()
  {
    ArrayList localArrayList = new ArrayList();
    this.zzabw = 1;
    this.zzaby = this.zzabr.zzacg.size();
    Iterator localIterator = this.zzabr.zzacg.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zzabr.zzach.containsKey(localzzc))
      {
        if (zznP()) {
          zznS();
        }
      }
      else {
        localArrayList.add(this.zzabr.zzacg.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      this.zzabK.add(zzlk.zzoj().submit(new zzh(localArrayList)));
    }
  }
  
  private void zznS()
  {
    this.zzabw = 2;
    this.zzabr.zzaci = zznX();
    this.zzabK.add(zzlk.zzoj().submit(new zzc(null)));
  }
  
  private void zznT()
  {
    ArrayList localArrayList = new ArrayList();
    this.zzabw = 3;
    this.zzaby = this.zzabr.zzacg.size();
    Iterator localIterator = this.zzabr.zzacg.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zzabr.zzach.containsKey(localzzc))
      {
        if (zznP()) {
          zznU();
        }
      }
      else {
        localArrayList.add(this.zzabr.zzacg.get(localzzc));
      }
    }
    if (!localArrayList.isEmpty()) {
      this.zzabK.add(zzlk.zzoj().submit(new zzf(localArrayList)));
    }
  }
  
  private void zznU()
  {
    this.zzabr.zzob();
    zzlk.zzoj().execute(new Runnable()
    {
      public void run()
      {
        zzlg.zzb(zzlg.this).zzac(zzlg.zza(zzlg.this));
      }
    });
    if (this.zzabB != null)
    {
      if (this.zzabG) {
        this.zzabB.zza(this.zzabF, this.zzabH);
      }
      zzY(false);
    }
    Object localObject = this.zzabr.zzach.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localzzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zzb)this.zzabr.zzacg.get(localzzc)).disconnect();
    }
    if (this.zzabx)
    {
      this.zzabx = false;
      disconnect();
      return;
    }
    if (this.zzabz.isEmpty()) {}
    for (localObject = null;; localObject = this.zzabz)
    {
      this.zzabr.zzabZ.zzh((Bundle)localObject);
      return;
    }
  }
  
  private void zznV()
  {
    this.zzabD = false;
    this.zzabr.zzaci = Collections.emptySet();
    Iterator localIterator = this.zzabA.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (!this.zzabr.zzach.containsKey(localzzc)) {
        this.zzabr.zzach.put(localzzc, new ConnectionResult(17, null));
      }
    }
  }
  
  private void zznW()
  {
    Iterator localIterator = this.zzabK.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    this.zzabK.clear();
  }
  
  private Set<Scope> zznX()
  {
    HashSet localHashSet = new HashSet(this.zzabI.zzoK());
    Map localMap = this.zzabI.zzoM();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (!this.zzabr.zzach.containsKey(localApi.zznx())) {
        localHashSet.addAll(((zzf.zza)localMap.get(localApi)).zzTm);
      }
    }
    return localHashSet;
  }
  
  public void begin()
  {
    this.zzabr.zzabZ.zzpl();
    this.zzabr.zzach.clear();
    this.zzabx = false;
    this.zzabD = false;
    this.zzabu = null;
    this.zzabw = 0;
    this.zzabC = 2;
    this.zzabE = false;
    this.zzabG = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.zzabJ.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zzb localzzb = (Api.zzb)this.zzabr.zzacg.get(localApi.zznx());
      int k = ((Integer)this.zzabJ.get(localApi)).intValue();
      if (localApi.zznv().getPriority() == 1) {}
      for (int j = 1;; j = 0)
      {
        if (localzzb.zzlN())
        {
          this.zzabD = true;
          if (k < this.zzabC) {
            this.zzabC = k;
          }
          if (k != 0) {
            this.zzabA.add(localApi.zznx());
          }
        }
        localHashMap.put(localzzb, new zzd(this, localApi, k));
        i = j | i;
        break;
      }
    }
    if (i != 0) {
      this.zzabD = false;
    }
    if (this.zzabD)
    {
      this.zzabI.zza(Integer.valueOf(this.zzabr.getSessionId()));
      localObject = new zzg(null);
      this.zzabB = ((zzqw)this.zzaaQ.zza(this.mContext, this.zzabr.getLooper(), this.zzabI, this.zzabI.zzoQ(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    this.zzaby = this.zzabr.zzacg.size();
    this.zzabK.add(zzlk.zzoj().submit(new zze(localHashMap)));
  }
  
  public void connect()
  {
    this.zzabx = false;
  }
  
  public void disconnect()
  {
    Iterator localIterator = this.zzabr.zzaca.iterator();
    while (localIterator.hasNext())
    {
      zzli.zzf localzzf = (zzli.zzf)localIterator.next();
      if (localzzf.zznK() != 1)
      {
        localzzf.cancel();
        localIterator.remove();
      }
    }
    this.zzabr.zznY();
    if ((this.zzabu == null) && (!this.zzabr.zzaca.isEmpty()))
    {
      this.zzabx = true;
      return;
    }
    zznW();
    zzY(true);
    this.zzabr.zzach.clear();
    this.zzabr.zzg(null);
    this.zzabr.zzabZ.zzpk();
  }
  
  public String getName()
  {
    return "CONNECTING";
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (!zzbn(3)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.zzabz.putAll(paramBundle);
      }
    } while (!zznP());
    zznU();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzf(new ConnectionResult(8, null));
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T paramT)
  {
    this.zzabr.zzaca.add(paramT);
    return paramT;
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzbn(3)) {}
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    } while (!zznP());
    zznU();
  }
  
  public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  private static class zza
    extends zzb
  {
    private final WeakReference<zzlg> zzabM;
    
    zza(zzlg paramzzlg)
    {
      this.zzabM = new WeakReference(paramzzlg);
    }
    
    public void zza(final ConnectionResult paramConnectionResult, final AuthAccountResult paramAuthAccountResult)
    {
      paramAuthAccountResult = (zzlg)this.zzabM.get();
      if (paramAuthAccountResult == null) {
        return;
      }
      zzlg.zzd(paramAuthAccountResult).zza(new zzli.zzb(paramAuthAccountResult)
      {
        public void zznO()
        {
          zzlg.zzc(paramAuthAccountResult, paramConnectionResult);
        }
      });
    }
  }
  
  private static class zzb
    extends zzt.zza
  {
    private final WeakReference<zzlg> zzabM;
    
    zzb(zzlg paramzzlg)
    {
      this.zzabM = new WeakReference(paramzzlg);
    }
    
    public void zzb(final ResolveAccountResponse paramResolveAccountResponse)
    {
      final zzlg localzzlg = (zzlg)this.zzabM.get();
      if (localzzlg == null) {
        return;
      }
      zzlg.zzd(localzzlg).zza(new zzli.zzb(localzzlg)
      {
        public void zznO()
        {
          zzlg.zza(localzzlg, paramResolveAccountResponse);
        }
      });
    }
  }
  
  private class zzc
    extends zzlg.zzi
  {
    private zzc()
    {
      super(null);
    }
    
    public void zznO()
    {
      zzlg.zzf(zzlg.this).zza(zzlg.zzg(zzlg.this), zzlg.zzd(zzlg.this).zzaci, new zzlg.zza(zzlg.this));
    }
  }
  
  private static class zzd
    implements GoogleApiClient.zza
  {
    private final WeakReference<zzlg> zzabM;
    private final Api<?> zzabS;
    private final int zzabT;
    
    public zzd(zzlg paramzzlg, Api<?> paramApi, int paramInt)
    {
      this.zzabM = new WeakReference(paramzzlg);
      this.zzabS = paramApi;
      this.zzabT = paramInt;
    }
    
    public void zza(ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzlg localzzlg = (zzlg)this.zzabM.get();
      if (localzzlg == null) {
        return;
      }
      if (Looper.myLooper() == zzlg.zzd(localzzlg).getLooper()) {
        bool = true;
      }
      zzx.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzlg.zzc(localzzlg).lock();
      try
      {
        bool = zzlg.zza(localzzlg, 0);
        if (!bool) {
          return;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzlg.zza(localzzlg, paramConnectionResult, this.zzabS, this.zzabT);
        }
        if (zzlg.zzk(localzzlg)) {
          zzlg.zzl(localzzlg);
        }
        return;
      }
      finally
      {
        zzlg.zzc(localzzlg).unlock();
      }
    }
    
    public void zzb(ConnectionResult paramConnectionResult)
    {
      boolean bool = true;
      zzlg localzzlg = (zzlg)this.zzabM.get();
      if (localzzlg == null) {
        return;
      }
      if (Looper.myLooper() == zzlg.zzd(localzzlg).getLooper()) {}
      for (;;)
      {
        zzx.zza(bool, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
        zzlg.zzc(localzzlg).lock();
        try
        {
          bool = zzlg.zza(localzzlg, 1);
          if (!bool)
          {
            return;
            bool = false;
            continue;
          }
          if (!paramConnectionResult.isSuccess()) {
            zzlg.zza(localzzlg, paramConnectionResult, this.zzabS, this.zzabT);
          }
          if (zzlg.zzk(localzzlg)) {
            zzlg.zzm(localzzlg);
          }
          return;
        }
        finally
        {
          zzlg.zzc(localzzlg).unlock();
        }
      }
    }
  }
  
  private class zze
    extends zzlg.zzi
  {
    private final Map<Api.zzb, GoogleApiClient.zza> zzabU;
    
    public zze()
    {
      super(null);
      Map localMap;
      this.zzabU = localMap;
    }
    
    public void zznO()
    {
      int i = zzlg.zzb(zzlg.this).isGooglePlayServicesAvailable(zzlg.zza(zzlg.this));
      final Object localObject;
      if (i != 0)
      {
        localObject = new ConnectionResult(i, null);
        zzlg.zzd(zzlg.this).zza(new zzli.zzb(zzlg.this)
        {
          public void zznO()
          {
            zzlg.zza(zzlg.this, localObject);
          }
        });
      }
      for (;;)
      {
        return;
        if (zzlg.zze(zzlg.this)) {
          zzlg.zzf(zzlg.this).connect();
        }
        localObject = this.zzabU.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Api.zzb localzzb = (Api.zzb)((Iterator)localObject).next();
          localzzb.zza((GoogleApiClient.zza)this.zzabU.get(localzzb));
        }
      }
    }
  }
  
  private class zzf
    extends zzlg.zzi
  {
    private final ArrayList<Api.zzb> zzabX;
    
    public zzf()
    {
      super(null);
      ArrayList localArrayList;
      this.zzabX = localArrayList;
    }
    
    public void zznO()
    {
      Set localSet = zzlg.zzd(zzlg.this).zzaci;
      if (localSet.isEmpty()) {
        localSet = zzlg.zzh(zzlg.this);
      }
      for (;;)
      {
        Iterator localIterator = this.zzabX.iterator();
        while (localIterator.hasNext()) {
          ((Api.zzb)localIterator.next()).zza(zzlg.zzg(zzlg.this), localSet);
        }
        return;
      }
    }
  }
  
  private class zzg
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zzg() {}
    
    public void onConnected(Bundle paramBundle)
    {
      zzlg.zzf(zzlg.this).zza(new zzlg.zzb(zzlg.this));
    }
    
    /* Error */
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   4: invokestatic 45	com/google/android/gms/internal/zzlg:zzc	(Lcom/google/android/gms/internal/zzlg;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 50 1 0
      //   12: aload_0
      //   13: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   16: aload_1
      //   17: invokestatic 54	com/google/android/gms/internal/zzlg:zzb	(Lcom/google/android/gms/internal/zzlg;Lcom/google/android/gms/common/ConnectionResult;)Z
      //   20: ifeq +30 -> 50
      //   23: aload_0
      //   24: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   27: invokestatic 57	com/google/android/gms/internal/zzlg:zzi	(Lcom/google/android/gms/internal/zzlg;)V
      //   30: aload_0
      //   31: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   34: invokestatic 60	com/google/android/gms/internal/zzlg:zzj	(Lcom/google/android/gms/internal/zzlg;)V
      //   37: aload_0
      //   38: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   41: invokestatic 45	com/google/android/gms/internal/zzlg:zzc	(Lcom/google/android/gms/internal/zzlg;)Ljava/util/concurrent/locks/Lock;
      //   44: invokeinterface 63 1 0
      //   49: return
      //   50: aload_0
      //   51: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   54: aload_1
      //   55: invokestatic 66	com/google/android/gms/internal/zzlg:zza	(Lcom/google/android/gms/internal/zzlg;Lcom/google/android/gms/common/ConnectionResult;)V
      //   58: goto -21 -> 37
      //   61: astore_1
      //   62: aload_0
      //   63: getfield 17	com/google/android/gms/internal/zzlg$zzg:zzabL	Lcom/google/android/gms/internal/zzlg;
      //   66: invokestatic 45	com/google/android/gms/internal/zzlg:zzc	(Lcom/google/android/gms/internal/zzlg;)Ljava/util/concurrent/locks/Lock;
      //   69: invokeinterface 63 1 0
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zzg
      //   0	76	1	paramConnectionResult	ConnectionResult
      // Exception table:
      //   from	to	target	type
      //   12	37	61	finally
      //   50	58	61	finally
    }
    
    public void onConnectionSuspended(int paramInt) {}
  }
  
  private class zzh
    extends zzlg.zzi
  {
    private final ArrayList<Api.zzb> zzabX;
    
    public zzh()
    {
      super(null);
      ArrayList localArrayList;
      this.zzabX = localArrayList;
    }
    
    public void zznO()
    {
      Iterator localIterator = this.zzabX.iterator();
      while (localIterator.hasNext()) {
        ((Api.zzb)localIterator.next()).zza(zzlg.zzg(zzlg.this));
      }
    }
  }
  
  private abstract class zzi
    implements Runnable
  {
    private zzi() {}
    
    public void run()
    {
      zzlg.zzc(zzlg.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool) {
          return;
        }
        zznO();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzlg.zzd(zzlg.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzlg.zzc(zzlg.this).unlock();
      }
    }
    
    protected abstract void zznO();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */