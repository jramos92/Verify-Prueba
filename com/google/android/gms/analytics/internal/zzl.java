package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.measurement.zzc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzl
  extends zzd
{
  private boolean mStarted;
  private final zzaj zzNA;
  private long zzNB;
  private boolean zzNC;
  private final zzj zzNt;
  private final zzah zzNu;
  private final zzag zzNv;
  private final zzi zzNw;
  private long zzNx;
  private final zzt zzNy;
  private final zzt zzNz;
  
  protected zzl(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzx.zzw(paramzzg);
    this.zzNx = Long.MIN_VALUE;
    this.zzNv = paramzzg.zzk(paramzzf);
    this.zzNt = paramzzg.zzm(paramzzf);
    this.zzNu = paramzzg.zzn(paramzzf);
    this.zzNw = paramzzg.zzo(paramzzf);
    this.zzNA = new zzaj(zzit());
    this.zzNy = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zza(zzl.this);
      }
    };
    this.zzNz = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zzb(zzl.this);
      }
    };
  }
  
  private void zza(zzh paramzzh, zzpc paramzzpc)
  {
    zzx.zzw(paramzzh);
    zzx.zzw(paramzzpc);
    Object localObject1 = new zza(zziq());
    ((zza)localObject1).zzaP(paramzzh.zziN());
    ((zza)localObject1).enableAdvertisingIdCollection(paramzzh.zziO());
    localObject1 = ((zza)localObject1).zzhG();
    zzjo localzzjo = (zzjo)((zzc)localObject1).zze(zzjo.class);
    localzzjo.zzaU("data");
    localzzjo.zzH(true);
    ((zzc)localObject1).zzb(paramzzpc);
    zzjn localzzjn = (zzjn)((zzc)localObject1).zze(zzjn.class);
    zzpb localzzpb = (zzpb)((zzc)localObject1).zze(zzpb.class);
    Iterator localIterator = paramzzh.zzn().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        localzzpb.setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        localzzpb.setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        localzzpb.setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        localzzpb.setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localzzjo.setUserId((String)localObject2);
      } else {
        localzzjn.set(str, (String)localObject2);
      }
    }
    zzb("Sending installation campaign to", paramzzh.zziN(), paramzzpc);
    ((zzc)localObject1).zzL(zziy().zzkO());
    ((zzc)localObject1).zzyi();
  }
  
  private boolean zzbh(String paramString)
  {
    return getContext().checkCallingOrSelfPermission(paramString) == 0;
  }
  
  private void zzjc()
  {
    Context localContext = zziq().getContext();
    if (!AnalyticsReceiver.zzV(localContext)) {
      zzbd("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    }
    do
    {
      while (!CampaignTrackingReceiver.zzV(localContext))
      {
        zzbd("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        return;
        if (!AnalyticsService.zzW(localContext)) {
          zzbe("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    } while (CampaignTrackingService.zzW(localContext));
    zzbd("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
  }
  
  private void zzje()
  {
    zzb(new zzw()
    {
      public void zzc(Throwable paramAnonymousThrowable)
      {
        zzl.this.zzjk();
      }
    });
  }
  
  private void zzjf()
  {
    try
    {
      this.zzNt.zziW();
      zzjk();
      this.zzNz.zzt(zziv().zzkc());
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete stale hits", localSQLiteException);
      }
    }
  }
  
  private boolean zzjl()
  {
    if (this.zzNC) {}
    while (((zziv().zzjA()) && (!zziv().zzjB())) || (zzjr() <= 0L)) {
      return false;
    }
    return true;
  }
  
  private void zzjm()
  {
    zzv localzzv = zzix();
    if (!localzzv.zzkk()) {}
    long l;
    do
    {
      do
      {
        return;
      } while (localzzv.zzbp());
      l = zziX();
    } while ((l == 0L) || (Math.abs(zzit().currentTimeMillis() - l) > zziv().zzjK()));
    zza("Dispatch alarm scheduled (ms)", Long.valueOf(zziv().zzjJ()));
    localzzv.zzkl();
  }
  
  private void zzjn()
  {
    zzjm();
    long l2 = zzjr();
    long l1 = zziy().zzkQ();
    if (l1 != 0L)
    {
      l1 = l2 - Math.abs(zzit().currentTimeMillis() - l1);
      if (l1 <= 0L) {}
    }
    for (;;)
    {
      zza("Dispatch scheduled (ms)", Long.valueOf(l1));
      if (!this.zzNy.zzbp()) {
        break;
      }
      l1 = Math.max(1L, l1 + this.zzNy.zzkh());
      this.zzNy.zzu(l1);
      return;
      l1 = Math.min(zziv().zzjH(), l2);
      continue;
      l1 = Math.min(zziv().zzjH(), l2);
    }
    this.zzNy.zzt(l1);
  }
  
  private void zzjo()
  {
    zzjp();
    zzjq();
  }
  
  private void zzjp()
  {
    if (this.zzNy.zzbp()) {
      zzba("All hits dispatched or no network/service. Going to power save mode");
    }
    this.zzNy.cancel();
  }
  
  private void zzjq()
  {
    zzv localzzv = zzix();
    if (localzzv.zzbp()) {
      localzzv.cancel();
    }
  }
  
  protected void onServiceConnected()
  {
    zzis();
    if (!zziv().zzjA()) {
      zzjh();
    }
  }
  
  void start()
  {
    zziE();
    if (!this.mStarted) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Analytics backend already started");
      this.mStarted = true;
      if (!zziv().zzjA()) {
        zzjc();
      }
      zziw().zzg(new Runnable()
      {
        public void run()
        {
          zzl.this.zzjd();
        }
      });
      return;
    }
  }
  
  public void zzI(boolean paramBoolean)
  {
    zzjk();
  }
  
  public long zza(zzh paramzzh, boolean paramBoolean)
  {
    zzx.zzw(paramzzh);
    zziE();
    zzis();
    long l;
    for (;;)
    {
      try
      {
        this.zzNt.beginTransaction();
        this.zzNt.zza(paramzzh.zziM(), paramzzh.getClientId());
        l = this.zzNt.zza(paramzzh.zziM(), paramzzh.getClientId(), paramzzh.zziN());
        if (!paramBoolean)
        {
          paramzzh.zzn(l);
          this.zzNt.zzb(paramzzh);
          this.zzNt.setTransactionSuccessful();
        }
      }
      catch (SQLiteException paramzzh)
      {
        paramzzh = paramzzh;
        zze("Failed to update Analytics property", paramzzh);
        try
        {
          this.zzNt.endTransaction();
          return -1L;
        }
        catch (SQLiteException paramzzh)
        {
          zze("Failed to end transaction", paramzzh);
          return -1L;
        }
      }
      finally {}
      try
      {
        this.zzNt.endTransaction();
        return l;
      }
      catch (SQLiteException paramzzh)
      {
        zze("Failed to end transaction", paramzzh);
        return l;
      }
      paramzzh.zzn(1L + l);
    }
    try
    {
      this.zzNt.endTransaction();
      throw paramzzh;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zze("Failed to end transaction", localSQLiteException);
      }
    }
  }
  
  public void zza(zzab paramzzab)
  {
    zzx.zzw(paramzzab);
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    if (this.zzNC) {
      zzbb("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
    }
    for (;;)
    {
      paramzzab = zzf(paramzzab);
      zzjg();
      if (!this.zzNw.zzb(paramzzab)) {
        break;
      }
      zzbb("Hit sent to the device AnalyticsService for delivery");
      return;
      zza("Delivering hit", paramzzab);
    }
    if (zziv().zzjA())
    {
      zziu().zza(paramzzab, "Service unavailable on package side");
      return;
    }
    try
    {
      this.zzNt.zzc(paramzzab);
      zzjk();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Delivery failed to save hit to a database", localSQLiteException);
      zziu().zza(paramzzab, "deliver: failed to insert hit to database");
    }
  }
  
  public void zza(final zzw paramzzw, final long paramLong)
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    long l1 = -1L;
    long l2 = zziy().zzkQ();
    if (l2 != 0L) {
      l1 = Math.abs(zzit().currentTimeMillis() - l2);
    }
    zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    if (!zziv().zzjA()) {
      zzjg();
    }
    try
    {
      if (zzji())
      {
        zziw().zzg(new Runnable()
        {
          public void run()
          {
            zzl.this.zza(paramzzw, paramLong);
          }
        });
        return;
      }
      zziy().zzkR();
      zzjk();
      if (paramzzw != null) {
        paramzzw.zzc(null);
      }
      if (this.zzNB != paramLong)
      {
        this.zzNv.zzkJ();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      zze("Local dispatch failed", localThrowable);
      zziy().zzkR();
      zzjk();
      if (paramzzw != null) {
        paramzzw.zzc(localThrowable);
      }
    }
  }
  
  public void zzb(zzw paramzzw)
  {
    zza(paramzzw, this.zzNB);
  }
  
  public void zzbi(String paramString)
  {
    zzx.zzcr(paramString);
    zzis();
    zzir();
    zzpc localzzpc = zzam.zza(zziu(), paramString);
    if (localzzpc == null) {
      zzd("Parsing failed. Ignoring invalid campaign data", paramString);
    }
    for (;;)
    {
      return;
      String str = zziy().zzkS();
      if (paramString.equals(str))
      {
        zzbd("Ignoring duplicate install campaign");
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        zzd("Ignoring multiple install campaigns. original, new", str, paramString);
        return;
      }
      zziy().zzbm(paramString);
      if (zziy().zzkP().zzv(zziv().zzkf()))
      {
        zzd("Campaign received too late, ignoring", localzzpc);
        return;
      }
      zzb("Received installation campaign", localzzpc);
      paramString = this.zzNt.zzr(0L).iterator();
      while (paramString.hasNext()) {
        zza((zzh)paramString.next(), localzzpc);
      }
    }
  }
  
  protected void zzc(zzh paramzzh)
  {
    zzis();
    zzb("Sending first hit to property", paramzzh.zziN());
    if (zziy().zzkP().zzv(zziv().zzkf())) {}
    do
    {
      return;
      localObject = zziy().zzkS();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = zzam.zza(zziu(), (String)localObject);
    zzb("Found relevant installation campaign", localObject);
    zza(paramzzh, (zzpc)localObject);
  }
  
  zzab zzf(zzab paramzzab)
  {
    if (!TextUtils.isEmpty(paramzzab.zzkE())) {}
    do
    {
      return paramzzab;
      localObject2 = zziy().zzkT().zzkW();
    } while (localObject2 == null);
    Object localObject1 = (Long)((Pair)localObject2).second;
    Object localObject2 = (String)((Pair)localObject2).first;
    localObject1 = localObject1 + ":" + (String)localObject2;
    localObject2 = new HashMap(paramzzab.zzn());
    ((Map)localObject2).put("_m", localObject1);
    return zzab.zza(this, paramzzab, (Map)localObject2);
  }
  
  protected void zzhR()
  {
    this.zzNt.zza();
    this.zzNu.zza();
    this.zzNw.zza();
  }
  
  public long zziX()
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    try
    {
      long l = this.zzNt.zziX();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      zze("Failed to get min/max hit times from local store", localSQLiteException);
    }
    return 0L;
  }
  
  public void zzik()
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    if (!zziv().zzjA()) {
      zzba("Delete all hits from local store");
    }
    try
    {
      this.zzNt.zziU();
      this.zzNt.zziV();
      zzjk();
      zzjg();
      if (this.zzNw.zziQ()) {
        zzba("Device service unavailable. Can't clear hits stored on the device service.");
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete hits from store", localSQLiteException);
      }
    }
  }
  
  public void zzin()
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    zzba("Service disconnected");
  }
  
  void zzip()
  {
    zzis();
    this.zzNB = zzit().currentTimeMillis();
  }
  
  protected void zzjd()
  {
    zziE();
    zziy().zzkO();
    if (!zzbh("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzbe("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzjs();
    }
    if (!zzbh("android.permission.INTERNET"))
    {
      zzbe("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzjs();
    }
    if (AnalyticsService.zzW(getContext())) {
      zzba("AnalyticsService registered in the app manifest and enabled");
    }
    for (;;)
    {
      if ((!this.zzNC) && (!zziv().zzjA()) && (!this.zzNt.isEmpty())) {
        zzjg();
      }
      zzjk();
      return;
      if (zziv().zzjA()) {
        zzbe("Device AnalyticsService not registered! Hits will not be delivered reliably.");
      } else {
        zzbd("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  protected void zzjg()
  {
    if (this.zzNC) {}
    do
    {
      long l;
      do
      {
        do
        {
          return;
        } while ((!zziv().zzjC()) || (this.zzNw.isConnected()));
        l = zziv().zzjX();
      } while (!this.zzNA.zzv(l));
      this.zzNA.start();
      zzba("Connecting to service");
    } while (!this.zzNw.connect());
    zzba("Connected to service");
    this.zzNA.clear();
    onServiceConnected();
  }
  
  public void zzjh()
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    zzir();
    if (!zziv().zzjC()) {
      zzbd("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!this.zzNw.isConnected()) {
      zzba("Service not connected");
    }
    while (this.zzNt.isEmpty()) {
      return;
    }
    zzba("Dispatching local hits to device AnalyticsService");
    for (;;)
    {
      try
      {
        List localList = this.zzNt.zzp(zziv().zzjL());
        if (!localList.isEmpty()) {
          break label126;
        }
        zzjk();
        return;
      }
      catch (SQLiteException localSQLiteException1)
      {
        zze("Failed to read hits from store", localSQLiteException1);
        zzjo();
        return;
      }
      label107:
      Object localObject;
      localSQLiteException1.remove(localObject);
      try
      {
        this.zzNt.zzq(((zzab)localObject).zzkz());
        label126:
        if (!localSQLiteException1.isEmpty())
        {
          localObject = (zzab)localSQLiteException1.get(0);
          if (this.zzNw.zzb((zzab)localObject)) {
            break label107;
          }
          zzjk();
          return;
        }
      }
      catch (SQLiteException localSQLiteException2)
      {
        zze("Failed to remove hit that was send for delivery", localSQLiteException2);
        zzjo();
      }
    }
  }
  
  protected boolean zzji()
  {
    int j = 1;
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    zzba("Dispatching a batch of local hits");
    int i;
    if ((!this.zzNw.isConnected()) && (!zziv().zzjA()))
    {
      i = 1;
      if (this.zzNu.zzkK()) {
        break label70;
      }
    }
    for (;;)
    {
      if ((i == 0) || (j == 0)) {
        break label75;
      }
      zzba("No network or service available. Will retry later");
      return false;
      i = 0;
      break;
      label70:
      j = 0;
    }
    label75:
    long l3 = Math.max(zziv().zzjL(), zziv().zzjM());
    ArrayList localArrayList = new ArrayList();
    l1 = 0L;
    for (;;)
    {
      try
      {
        this.zzNt.beginTransaction();
        localArrayList.clear();
        try
        {
          localList = this.zzNt.zzp(l3);
          if (localList.isEmpty())
          {
            zzba("Store is empty, nothing to dispatch");
            zzjo();
            try
            {
              this.zzNt.setTransactionSuccessful();
              this.zzNt.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException1)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException1);
              zzjo();
              return false;
            }
          }
          zza("Hits loaded from store. count", Integer.valueOf(localList.size()));
          localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (((zzab)((Iterator)localObject2).next()).zzkz() != l1) {
              continue;
            }
            zzd("Database contains successfully uploaded hit", Long.valueOf(l1), Integer.valueOf(localList.size()));
            zzjo();
            try
            {
              this.zzNt.setTransactionSuccessful();
              this.zzNt.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException2)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException2);
              zzjo();
              return false;
            }
          }
          l2 = l1;
        }
        catch (SQLiteException localSQLiteException3)
        {
          zzd("Failed to read hits from persisted store", localSQLiteException3);
          zzjo();
          try
          {
            this.zzNt.setTransactionSuccessful();
            this.zzNt.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException4)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException4);
            zzjo();
            return false;
          }
          l2 = l1;
          if (!this.zzNw.isConnected()) {
            continue;
          }
        }
        if (zziv().zzjA()) {
          continue;
        }
        zzba("Service connected, sending hits to the service");
        l2 = l1;
        if (localList.isEmpty()) {
          continue;
        }
        localObject2 = (zzab)localList.get(0);
        if (this.zzNw.zzb((zzab)localObject2)) {
          continue;
        }
      }
      finally
      {
        long l2;
        try
        {
          List localList;
          Object localObject2;
          Iterator localIterator;
          this.zzNt.setTransactionSuccessful();
          this.zzNt.endTransaction();
          throw ((Throwable)localObject1);
        }
        catch (SQLiteException localSQLiteException11)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException11);
          zzjo();
          return false;
        }
        l1 = l2;
        continue;
      }
      l2 = l1;
      if (this.zzNu.zzkK())
      {
        localObject2 = this.zzNu.zzm(localList);
        localIterator = ((List)localObject2).iterator();
        if (localIterator.hasNext())
        {
          l1 = Math.max(l1, ((Long)localIterator.next()).longValue());
          continue;
          l1 = Math.max(l1, ((zzab)localObject2).zzkz());
          localList.remove(localObject2);
          zzb("Hit sent do device AnalyticsService for delivery", localObject2);
          try
          {
            this.zzNt.zzq(((zzab)localObject2).zzkz());
            localSQLiteException4.add(Long.valueOf(((zzab)localObject2).zzkz()));
          }
          catch (SQLiteException localSQLiteException5)
          {
            zze("Failed to remove hit that was send for delivery", localSQLiteException5);
            zzjo();
            try
            {
              this.zzNt.setTransactionSuccessful();
              this.zzNt.endTransaction();
              return false;
            }
            catch (SQLiteException localSQLiteException6)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException6);
              zzjo();
              return false;
            }
          }
        }
        localList.removeAll((Collection)localObject2);
      }
      try
      {
        this.zzNt.zzk((List)localObject2);
        localSQLiteException6.addAll((Collection)localObject2);
        l2 = l1;
        boolean bool = localSQLiteException6.isEmpty();
        if (bool) {
          try
          {
            this.zzNt.setTransactionSuccessful();
            this.zzNt.endTransaction();
            return false;
          }
          catch (SQLiteException localSQLiteException7)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException7);
            zzjo();
            return false;
          }
        }
      }
      catch (SQLiteException localSQLiteException8)
      {
        zze("Failed to remove successfully uploaded hits", localSQLiteException8);
        zzjo();
        try
        {
          this.zzNt.setTransactionSuccessful();
          this.zzNt.endTransaction();
          return false;
        }
        catch (SQLiteException localSQLiteException9)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException9);
          zzjo();
          return false;
        }
        try
        {
          this.zzNt.setTransactionSuccessful();
          this.zzNt.endTransaction();
          l1 = l2;
        }
        catch (SQLiteException localSQLiteException10)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException10);
          zzjo();
          return false;
        }
      }
    }
  }
  
  public void zzjj()
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    zzbb("Sync dispatching local hits");
    long l = this.zzNB;
    if (!zziv().zzjA()) {
      zzjg();
    }
    try
    {
      while (zzji()) {}
      zziy().zzkR();
      zzjk();
      if (this.zzNB != l) {
        this.zzNv.zzkJ();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      zze("Sync local dispatch failed", localThrowable);
      zzjk();
    }
  }
  
  public void zzjk()
  {
    zziq().zzis();
    zziE();
    if (!zzjl())
    {
      this.zzNv.unregister();
      zzjo();
      return;
    }
    if (this.zzNt.isEmpty())
    {
      this.zzNv.unregister();
      zzjo();
      return;
    }
    if (!((Boolean)zzy.zzON.get()).booleanValue()) {
      this.zzNv.zzkH();
    }
    for (boolean bool = this.zzNv.isConnected(); bool; bool = true)
    {
      zzjn();
      return;
    }
    zzjo();
    zzjm();
  }
  
  public long zzjr()
  {
    long l;
    if (this.zzNx != Long.MIN_VALUE) {
      l = this.zzNx;
    }
    do
    {
      return l;
      l = zziv().zzjI();
    } while (!zzhQ().zzku());
    return zzhQ().zzll() * 1000L;
  }
  
  public void zzjs()
  {
    zziE();
    zzis();
    this.zzNC = true;
    this.zzNw.disconnect();
    zzjk();
  }
  
  public void zzs(long paramLong)
  {
    com.google.android.gms.measurement.zzg.zzis();
    zziE();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.zzNx = l;
    zzjk();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */