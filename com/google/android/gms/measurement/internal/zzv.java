package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpk.zza;
import com.google.android.gms.internal.zzpk.zzb;
import com.google.android.gms.internal.zzpk.zzc;
import com.google.android.gms.internal.zzpk.zzd;
import com.google.android.gms.internal.zzpk.zze;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzv
{
  private static zzz zzaNK;
  private static volatile zzv zzaNL;
  private final Context mContext;
  private final boolean zzMF;
  private final zzc zzaNM;
  private final zzs zzaNN;
  private final zzp zzaNO;
  private final zzu zzaNP;
  private final com.google.android.gms.measurement.zza zzaNQ;
  private final zzag zzaNR;
  private final zzd zzaNS;
  private final zzq zzaNT;
  private final zzab zzaNU;
  private final zzf zzaNV;
  private final zzaa zzaNW;
  private final zzn zzaNX;
  private final zzr zzaNY;
  private final zzad zzaNZ;
  private Boolean zzaOa;
  private List<Long> zzaOb;
  private int zzaOc;
  private int zzaOd;
  private final zzmn zzpW;
  
  zzv(zzz paramzzz)
  {
    com.google.android.gms.common.internal.zzx.zzw(paramzzz);
    this.mContext = paramzzz.mContext;
    this.zzpW = paramzzz.zzj(this);
    this.zzaNM = paramzzz.zza(this);
    Object localObject = paramzzz.zzb(this);
    ((zzs)localObject).zza();
    this.zzaNN = ((zzs)localObject);
    localObject = paramzzz.zzc(this);
    ((zzp)localObject).zza();
    this.zzaNO = ((zzp)localObject);
    this.zzaNR = paramzzz.zzg(this);
    localObject = paramzzz.zzl(this);
    ((zzf)localObject).zza();
    this.zzaNV = ((zzf)localObject);
    localObject = paramzzz.zzm(this);
    ((zzn)localObject).zza();
    this.zzaNX = ((zzn)localObject);
    localObject = paramzzz.zzh(this);
    ((zzd)localObject).zza();
    this.zzaNS = ((zzd)localObject);
    localObject = paramzzz.zzi(this);
    ((zzq)localObject).zza();
    this.zzaNT = ((zzq)localObject);
    localObject = paramzzz.zzk(this);
    ((zzab)localObject).zza();
    this.zzaNU = ((zzab)localObject);
    localObject = paramzzz.zzf(this);
    ((zzaa)localObject).zza();
    this.zzaNW = ((zzaa)localObject);
    localObject = paramzzz.zzo(this);
    ((zzad)localObject).zza();
    this.zzaNZ = ((zzad)localObject);
    this.zzaNY = paramzzz.zzn(this);
    this.zzaNQ = paramzzz.zze(this);
    paramzzz = paramzzz.zzd(this);
    paramzzz.zza();
    this.zzaNP = paramzzz;
    if (this.zzaOc != this.zzaOd) {
      zzyd().zzzK().zze("Not all components initialized", Integer.valueOf(this.zzaOc), Integer.valueOf(this.zzaOd));
    }
    this.zzMF = true;
    this.zzaNP.zzh(new Runnable()
    {
      public void run()
      {
        zzv.this.start();
      }
    });
  }
  
  private boolean zzAj()
  {
    zzis();
    return this.zzaOb != null;
  }
  
  private boolean zzAl()
  {
    return !TextUtils.isEmpty(zzAd().zzzu());
  }
  
  private void zzAm()
  {
    zzis();
    zziE();
    if ((!zzAa()) || (!zzAl()))
    {
      zzAg().unregister();
      zzAh().cancel();
      return;
    }
    long l2 = zzAn();
    if (l2 == 0L)
    {
      zzAg().unregister();
      zzAh().cancel();
      return;
    }
    if (!zzAe().zzkK())
    {
      zzAg().zzkH();
      zzAh().cancel();
      return;
    }
    long l3 = zzzs().zzaNk.get();
    long l4 = zzzt().zzzi();
    long l1 = l2;
    if (!zzzq().zzc(l3, l4)) {
      l1 = Math.max(l2, l3 + l4);
    }
    zzAg().unregister();
    l1 -= zzit().currentTimeMillis();
    if (l1 <= 0L)
    {
      zzAh().zzt(1L);
      return;
    }
    zzyd().zzzQ().zzj("Upload scheduled in approximately ms", Long.valueOf(l1));
    zzAh().zzt(l1);
  }
  
  private long zzAn()
  {
    long l5 = zzit().currentTimeMillis();
    long l1 = zzzt().zzzk();
    long l2 = zzzt().zzzj();
    long l4 = zzzs().zzaNi.get();
    long l3 = zzzs().zzaNj.get();
    long l6 = zzAd().zzzx();
    if (l6 == 0L) {
      l2 = 0L;
    }
    do
    {
      do
      {
        return l2;
        l5 -= Math.abs(l6 - l5);
        l1 += l5;
        if (!zzzq().zzc(l4, l2)) {
          l1 = l4 + l2;
        }
        l2 = l1;
      } while (l3 == 0L);
      l2 = l1;
    } while (l3 < l5);
    int i = 0;
    for (;;)
    {
      if (i >= zzzt().zzzm()) {
        break label178;
      }
      l1 += (1 << i) * zzzt().zzzl();
      l2 = l1;
      if (l1 > l3) {
        break;
      }
      i += 1;
    }
    label178:
    return 0L;
  }
  
  private void zza(zzx paramzzx)
  {
    if (paramzzx == null) {
      throw new IllegalStateException("Component not created");
    }
  }
  
  private void zza(zzy paramzzy)
  {
    if (paramzzy == null) {
      throw new IllegalStateException("Component not created");
    }
    if (!paramzzy.isInitialized()) {
      throw new IllegalStateException("Component not initialized");
    }
  }
  
  /* Error */
  public static zzv zzaL(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 65	com/google/android/gms/common/internal/zzx:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 403	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   9: invokestatic 65	com/google/android/gms/common/internal/zzx:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: getstatic 405	com/google/android/gms/measurement/internal/zzv:zzaNL	Lcom/google/android/gms/measurement/internal/zzv;
    //   16: ifnonnull +32 -> 48
    //   19: ldc 2
    //   21: monitorenter
    //   22: getstatic 405	com/google/android/gms/measurement/internal/zzv:zzaNL	Lcom/google/android/gms/measurement/internal/zzv;
    //   25: ifnonnull +20 -> 45
    //   28: getstatic 407	com/google/android/gms/measurement/internal/zzv:zzaNK	Lcom/google/android/gms/measurement/internal/zzz;
    //   31: ifnull +21 -> 52
    //   34: getstatic 407	com/google/android/gms/measurement/internal/zzv:zzaNK	Lcom/google/android/gms/measurement/internal/zzz;
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 411	com/google/android/gms/measurement/internal/zzz:zzAq	()Lcom/google/android/gms/measurement/internal/zzv;
    //   42: putstatic 405	com/google/android/gms/measurement/internal/zzv:zzaNL	Lcom/google/android/gms/measurement/internal/zzv;
    //   45: ldc 2
    //   47: monitorexit
    //   48: getstatic 405	com/google/android/gms/measurement/internal/zzv:zzaNL	Lcom/google/android/gms/measurement/internal/zzv;
    //   51: areturn
    //   52: new 67	com/google/android/gms/measurement/internal/zzz
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 414	com/google/android/gms/measurement/internal/zzz:<init>	(Landroid/content/Context;)V
    //   60: astore_0
    //   61: goto -23 -> 38
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   22	38	64	finally
    //   38	45	64	finally
    //   45	48	64	finally
    //   52	61	64	finally
    //   65	68	64	finally
  }
  
  private void zzb(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    int i = 0;
    zzis();
    zziE();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    paramArrayOfByte = this.zzaOb;
    this.zzaOb = null;
    if (((paramInt == 200) || (paramInt == 204)) && (paramThrowable == null))
    {
      zzzs().zzaNi.set(zzit().currentTimeMillis());
      zzzs().zzaNj.set(0L);
      zzAm();
      zzyd().zzzQ().zze("Successful upload. Got network response. code, size", Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length));
      zzAd().beginTransaction();
      try
      {
        paramThrowable = paramArrayOfByte.iterator();
        while (paramThrowable.hasNext())
        {
          paramArrayOfByte = (Long)paramThrowable.next();
          zzAd().zzN(paramArrayOfByte.longValue());
        }
      }
      finally
      {
        zzAd().endTransaction();
      }
      zzAd().endTransaction();
      if ((zzAe().zzkK()) && (zzAl()))
      {
        zzAk();
        return;
      }
      zzAm();
      return;
    }
    zzyd().zzzQ().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(paramInt), paramThrowable);
    zzzs().zzaNj.set(zzit().currentTimeMillis());
    if (paramInt == 503) {
      i = 1;
    }
    if (i != 0) {
      zzzs().zzaNk.set(zzit().currentTimeMillis());
    }
    zzAm();
  }
  
  private void zzc(AppMetadata paramAppMetadata)
  {
    zzis();
    zziE();
    com.google.android.gms.common.internal.zzx.zzw(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzcr(paramAppMetadata.packageName);
    Object localObject2 = zzAd().zzea(paramAppMetadata.packageName);
    String str = zzzs().zzzT();
    int i = 0;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new zza(paramAppMetadata.packageName, zzzs().zzzU(), paramAppMetadata.zzaLP, str, 0L, 0L);
      i = 1;
    }
    for (;;)
    {
      int j = i;
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramAppMetadata.zzaLP))
      {
        j = i;
        localObject2 = localObject1;
        if (!paramAppMetadata.zzaLP.equals(((zza)localObject1).zzaLL))
        {
          localObject2 = ((zza)localObject1).zzdY(paramAppMetadata.zzaLP);
          j = 1;
        }
      }
      if (j != 0) {
        zzAd().zza((zza)localObject2);
      }
      return;
      localObject1 = localObject2;
      if (!str.equals(((zza)localObject2).zzaLM))
      {
        localObject1 = ((zza)localObject2).zzG(zzzs().zzzU(), str);
        i = 1;
      }
    }
  }
  
  private void zzv(List<Long> paramList)
  {
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzx.zzaa(bool);
      if (this.zzaOb == null) {
        break;
      }
      zzyd().zzzK().zzec("Set uploading progress before finishing the previous upload");
      return;
    }
    this.zzaOb = new ArrayList(paramList);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  protected void start()
  {
    zzis();
    zzyd().zzzO().zzec("App measurement is starting up");
    zzyd().zzzP().zzec("Debug logging enabled");
    if (!zzAa())
    {
      if (!zzzq().zzbh("android.permission.INTERNET")) {
        zzyd().zzzK().zzec("App is missing INTERNET permission");
      }
      if (!zzzq().zzbh("android.permission.ACCESS_NETWORK_STATE")) {
        zzyd().zzzK().zzec("App is missing ACCESS_NETWORK_STATE permission");
      }
      if (!AppMeasurementReceiver.zzV(getContext())) {
        zzyd().zzzK().zzec("AppMeasurementReceiver not registered/enabled");
      }
      if (!AppMeasurementService.zzW(getContext())) {
        zzyd().zzzK().zzec("AppMeasurementService not registered/enabled");
      }
      zzyd().zzzK().zzec("Uploading is not possible. App measurement disabled");
    }
    for (;;)
    {
      zzAm();
      return;
      if ((!zzzt().zzjA()) && (!TextUtils.isEmpty(zzzo().zzzH()))) {
        zzAc().zzAr();
      }
    }
  }
  
  protected boolean zzAa()
  {
    boolean bool2 = true;
    zziE();
    zzis();
    if (this.zzaOa == null)
    {
      if ((!zzzq().zzbh("android.permission.INTERNET")) || (!zzzq().zzbh("android.permission.ACCESS_NETWORK_STATE")) || (!AppMeasurementReceiver.zzV(getContext())) || (!AppMeasurementService.zzW(getContext()))) {
        break label124;
      }
      bool1 = true;
      this.zzaOa = Boolean.valueOf(bool1);
      if ((this.zzaOa.booleanValue()) && (!zzzt().zzjA())) {
        if (TextUtils.isEmpty(zzzo().zzzH())) {
          break label129;
        }
      }
    }
    label124:
    label129:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.zzaOa = Boolean.valueOf(bool1);
      return this.zzaOa.booleanValue();
      bool1 = false;
      break;
    }
  }
  
  zzu zzAb()
  {
    return this.zzaNP;
  }
  
  public zzaa zzAc()
  {
    zza(this.zzaNW);
    return this.zzaNW;
  }
  
  public zzd zzAd()
  {
    zza(this.zzaNS);
    return this.zzaNS;
  }
  
  public zzq zzAe()
  {
    zza(this.zzaNT);
    return this.zzaNT;
  }
  
  public zzf zzAf()
  {
    zza(this.zzaNV);
    return this.zzaNV;
  }
  
  public zzr zzAg()
  {
    if (this.zzaNY == null) {
      throw new IllegalStateException("Network broadcast receiver not created");
    }
    return this.zzaNY;
  }
  
  public zzad zzAh()
  {
    zza(this.zzaNZ);
    return this.zzaNZ;
  }
  
  protected boolean zzAi()
  {
    return false;
  }
  
  public void zzAk()
  {
    int j = 0;
    zzis();
    zziE();
    if (!zzzt().zzjA())
    {
      localObject1 = zzzs().zzzW();
      if (localObject1 == null) {
        zzyd().zzzL().zzec("Upload data called on the client side before use of service was decided");
      }
    }
    long l;
    int i;
    Object localObject2;
    do
    {
      do
      {
        return;
        if (((Boolean)localObject1).booleanValue())
        {
          zzyd().zzzK().zzec("Upload called in the client side when service should be used");
          return;
        }
        if (zzAj())
        {
          zzyd().zzzL().zzec("Uploading requested multiple times");
          return;
        }
        if (!zzAe().zzkK())
        {
          zzyd().zzzL().zzec("Network not connected, ignoring upload request");
          zzAm();
          return;
        }
        l = zzzs().zzaNi.get();
        if (l != 0L)
        {
          l = Math.abs(zzit().currentTimeMillis() - l);
          zzyd().zzzP().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(l));
        }
        localObject1 = zzAd().zzzu();
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      i = zzzt().zzzf();
      int k = zzzt().zzzg();
      localObject2 = zzAd().zzn((String)localObject1, i, k);
    } while (((List)localObject2).isEmpty());
    Object localObject1 = ((List)localObject2).iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = (zzpk.zzd)((Pair)((Iterator)localObject1).next()).first;
    } while (TextUtils.isEmpty(((zzpk.zzd)localObject3).zzaPa));
    for (localObject1 = ((zzpk.zzd)localObject3).zzaPa;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        i = 0;
        if (i < ((List)localObject2).size())
        {
          localObject3 = (zzpk.zzd)((Pair)((List)localObject2).get(i)).first;
          if (TextUtils.isEmpty(((zzpk.zzd)localObject3).zzaPa)) {}
          while (((zzpk.zzd)localObject3).zzaPa.equals(localObject1))
          {
            i += 1;
            break;
          }
        }
      }
      for (localObject1 = ((List)localObject2).subList(0, i);; localObject1 = localMalformedURLException)
      {
        localObject3 = new zzpk.zzc();
        ((zzpk.zzc)localObject3).zzaOI = new zzpk.zzd[((List)localObject1).size()];
        localObject2 = new ArrayList(((List)localObject1).size());
        l = zzit().currentTimeMillis();
        i = j;
        while (i < ((zzpk.zzc)localObject3).zzaOI.length)
        {
          ((zzpk.zzc)localObject3).zzaOI[i] = ((zzpk.zzd)((Pair)((List)localObject1).get(i)).first);
          ((List)localObject2).add(((Pair)((List)localObject1).get(i)).second);
          localObject3.zzaOI[i].zzaOZ = Long.valueOf(zzzt().zzzb());
          localObject3.zzaOI[i].zzaON = Long.valueOf(l);
          localObject3.zzaOI[i].zzaPg = Boolean.valueOf(zzzt().zzjA());
          i += 1;
        }
        localObject3 = zzzq().zza((zzpk.zzc)localObject3);
        localObject1 = zzzt().zzzh();
        try
        {
          URL localURL = new URL((String)localObject1);
          zzv((List)localObject2);
          zzzs().zzaNj.set(zzit().currentTimeMillis());
          zzAe().zza(localURL, (byte[])localObject3, new zzq.zza()
          {
            public void zza(int paramAnonymousInt, Throwable paramAnonymousThrowable, byte[] paramAnonymousArrayOfByte)
            {
              zzv.zza(zzv.this, paramAnonymousInt, paramAnonymousThrowable, paramAnonymousArrayOfByte);
            }
          });
          return;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          zzyd().zzzK().zzj("Failed to parse upload URL. Not uploading", localObject1);
          return;
        }
      }
    }
  }
  
  void zzAo()
  {
    this.zzaOd += 1;
  }
  
  public void zzI(boolean paramBoolean)
  {
    zzAm();
  }
  
  zzpk.zzd zza(zzg[] paramArrayOfzzg, AppMetadata paramAppMetadata)
  {
    zzpk.zzb localzzb = null;
    com.google.android.gms.common.internal.zzx.zzw(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzw(paramArrayOfzzg);
    zzis();
    zzpk.zzd localzzd = new zzpk.zzd();
    localzzd.zzaOK = Integer.valueOf(1);
    localzzd.zzaOS = "android";
    localzzd.zzaOX = paramAppMetadata.packageName;
    localzzd.zzaLQ = paramAppMetadata.zzaLQ;
    localzzd.zzaDC = paramAppMetadata.zzaDC;
    localzzd.zzaOY = Long.valueOf(paramAppMetadata.zzaLR);
    localzzd.zzaLP = paramAppMetadata.zzaLP;
    if (paramAppMetadata.zzaLS == 0L) {}
    for (Object localObject1 = null;; localObject1 = Long.valueOf(paramAppMetadata.zzaLS))
    {
      localzzd.zzaPd = ((Long)localObject1);
      localObject1 = zzzs().zzzS();
      if ((localObject1 != null) && (((Pair)localObject1).first != null) && (((Pair)localObject1).second != null))
      {
        localzzd.zzaPa = ((String)((Pair)localObject1).first);
        localzzd.zzaPb = ((Boolean)((Pair)localObject1).second);
      }
      localzzd.zzaOU = zzAf().zzgE();
      localzzd.zzaOT = zzAf().zzzy();
      localzzd.zzaOW = Integer.valueOf((int)zzAf().zzzz());
      localzzd.zzaOV = zzAf().zzzA();
      localzzd.zzaOZ = null;
      localzzd.zzaON = null;
      localzzd.zzaOO = Long.valueOf(paramArrayOfzzg[0].zzZH);
      localzzd.zzaOP = Long.valueOf(paramArrayOfzzg[0].zzZH);
      i = 1;
      while (i < paramArrayOfzzg.length)
      {
        localzzd.zzaOO = Long.valueOf(Math.min(localzzd.zzaOO.longValue(), paramArrayOfzzg[i].zzZH));
        localzzd.zzaOP = Long.valueOf(Math.max(localzzd.zzaOP.longValue(), paramArrayOfzzg[i].zzZH));
        i += 1;
      }
    }
    Object localObject2 = zzAd().zzea(paramAppMetadata.packageName);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new zza(paramAppMetadata.packageName, zzzs().zzzU(), paramAppMetadata.zzaLP, zzzs().zzzT(), 0L, 0L);
    }
    localObject2 = ((zza)localObject1).zza(zzyd(), localzzd.zzaOP.longValue());
    zzAd().zza((zza)localObject2);
    localzzd.zzaPc = ((zza)localObject2).zzaLK;
    localzzd.zzaPe = Integer.valueOf((int)((zza)localObject2).zzaLN);
    if (((zza)localObject1).zzaLO == 0L) {}
    for (localObject1 = localzzb;; localObject1 = Long.valueOf(((zza)localObject1).zzaLO))
    {
      localzzd.zzaOR = ((Long)localObject1);
      localzzd.zzaOQ = localzzd.zzaOR;
      paramAppMetadata = zzAd().zzdZ(paramAppMetadata.packageName);
      localzzd.zzaOM = new zzpk.zze[paramAppMetadata.size()];
      i = 0;
      while (i < paramAppMetadata.size())
      {
        localObject1 = new zzpk.zze();
        localzzd.zzaOM[i] = localObject1;
        ((zzpk.zze)localObject1).name = ((zzae)paramAppMetadata.get(i)).mName;
        ((zzpk.zze)localObject1).zzaPi = Long.valueOf(((zzae)paramAppMetadata.get(i)).zzaOy);
        zzzq().zza((zzpk.zze)localObject1, ((zzae)paramAppMetadata.get(i)).zzJy);
        i += 1;
      }
    }
    localzzd.zzaOL = new zzpk.zza[paramArrayOfzzg.length];
    int i = 0;
    while (i < paramArrayOfzzg.length)
    {
      paramAppMetadata = new zzpk.zza();
      localzzd.zzaOL[i] = paramAppMetadata;
      paramAppMetadata.name = paramArrayOfzzg[i].mName;
      paramAppMetadata.zzaOE = Long.valueOf(paramArrayOfzzg[i].zzZH);
      paramAppMetadata.zzaOD = new zzpk.zzb[paramArrayOfzzg[i].zzaMd.size()];
      localObject1 = paramArrayOfzzg[i].zzaMd.iterator();
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localzzb = new zzpk.zzb();
        paramAppMetadata.zzaOD[j] = localzzb;
        localzzb.name = ((String)localObject2);
        localObject2 = paramArrayOfzzg[i].zzaMd.get((String)localObject2);
        zzzq().zza(localzzb, localObject2);
        j += 1;
      }
      i += 1;
    }
    localzzd.zzaPf = zzyd().zzzR();
    return localzzd;
  }
  
  public void zzb(AppMetadata paramAppMetadata)
  {
    zzis();
    zziE();
    com.google.android.gms.common.internal.zzx.zzw(paramAppMetadata);
    com.google.android.gms.common.internal.zzx.zzcr(paramAppMetadata.packageName);
    if (TextUtils.isEmpty(paramAppMetadata.zzaLP)) {}
    do
    {
      return;
      zzc(paramAppMetadata);
    } while (zzAd().zzH(paramAppMetadata.packageName, "_f") != null);
    long l = zzit().currentTimeMillis();
    zzb(new UserAttributeParcel("_fot", l, Long.valueOf(3600000L * (l / 3600000L + 1L)), "auto"), paramAppMetadata);
    Bundle localBundle = new Bundle();
    localBundle.putLong("_c", 1L);
    zzb(new EventParcel("_f", new EventParams(localBundle), "auto", l), paramAppMetadata);
    zzAm();
  }
  
  /* Error */
  void zzb(EventParcel paramEventParcel, AppMetadata paramAppMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 230	com/google/android/gms/measurement/internal/zzv:zzis	()V
    //   4: aload_0
    //   5: invokevirtual 251	com/google/android/gms/measurement/internal/zzv:zziE	()V
    //   8: aload_2
    //   9: getfield 463	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   12: invokestatic 467	com/google/android/gms/common/internal/zzx:zzcr	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload_2
    //   17: getfield 482	com/google/android/gms/measurement/internal/AppMetadata:zzaLP	Ljava/lang/String;
    //   20: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +4 -> 27
    //   26: return
    //   27: aload_0
    //   28: invokevirtual 199	com/google/android/gms/measurement/internal/zzv:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   31: invokevirtual 339	com/google/android/gms/measurement/internal/zzp:zzzQ	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   34: ldc_w 927
    //   37: aload_1
    //   38: invokevirtual 349	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   41: new 776	com/google/android/gms/measurement/internal/zzg
    //   44: dup
    //   45: aload_0
    //   46: aload_1
    //   47: getfield 930	com/google/android/gms/measurement/internal/EventParcel:zzaMl	Ljava/lang/String;
    //   50: aload_2
    //   51: getfield 463	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   54: aload_1
    //   55: getfield 931	com/google/android/gms/measurement/internal/EventParcel:name	Ljava/lang/String;
    //   58: aload_1
    //   59: getfield 934	com/google/android/gms/measurement/internal/EventParcel:zzaMm	J
    //   62: lconst_0
    //   63: aload_1
    //   64: getfield 937	com/google/android/gms/measurement/internal/EventParcel:zzaMk	Lcom/google/android/gms/measurement/internal/EventParams;
    //   67: invokevirtual 941	com/google/android/gms/measurement/internal/EventParams:zzzB	()Landroid/os/Bundle;
    //   70: invokespecial 944	com/google/android/gms/measurement/internal/zzg:<init>	(Lcom/google/android/gms/measurement/internal/zzv;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLandroid/os/Bundle;)V
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   78: invokevirtual 424	com/google/android/gms/measurement/internal/zzd:beginTransaction	()V
    //   81: aload_0
    //   82: aload_2
    //   83: invokespecial 885	com/google/android/gms/measurement/internal/zzv:zzc	(Lcom/google/android/gms/measurement/internal/AppMetadata;)V
    //   86: aload_0
    //   87: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   90: aload_2
    //   91: getfield 463	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   94: aload_1
    //   95: getfield 851	com/google/android/gms/measurement/internal/zzg:mName	Ljava/lang/String;
    //   98: invokevirtual 891	com/google/android/gms/measurement/internal/zzd:zzH	(Ljava/lang/String;Ljava/lang/String;)Lcom/google/android/gms/measurement/internal/zzh;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +88 -> 191
    //   106: new 946	com/google/android/gms/measurement/internal/zzh
    //   109: dup
    //   110: aload_2
    //   111: getfield 463	com/google/android/gms/measurement/internal/AppMetadata:packageName	Ljava/lang/String;
    //   114: aload_1
    //   115: getfield 851	com/google/android/gms/measurement/internal/zzg:mName	Ljava/lang/String;
    //   118: lconst_1
    //   119: lconst_1
    //   120: aload_1
    //   121: getfield 779	com/google/android/gms/measurement/internal/zzg:zzZH	J
    //   124: invokespecial 949	com/google/android/gms/measurement/internal/zzh:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   127: astore_3
    //   128: aload_0
    //   129: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   132: aload_3
    //   133: invokevirtual 952	com/google/android/gms/measurement/internal/zzd:zza	(Lcom/google/android/gms/measurement/internal/zzh;)V
    //   136: aload_0
    //   137: iconst_1
    //   138: anewarray 776	com/google/android/gms/measurement/internal/zzg
    //   141: dup
    //   142: iconst_0
    //   143: aload_1
    //   144: aastore
    //   145: aload_2
    //   146: invokevirtual 954	com/google/android/gms/measurement/internal/zzv:zza	([Lcom/google/android/gms/measurement/internal/zzg;Lcom/google/android/gms/measurement/internal/AppMetadata;)Lcom/google/android/gms/internal/zzpk$zzd;
    //   149: astore_2
    //   150: aload_0
    //   151: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   154: aload_2
    //   155: invokevirtual 957	com/google/android/gms/measurement/internal/zzd:zza	(Lcom/google/android/gms/internal/zzpk$zzd;)V
    //   158: aload_0
    //   159: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   162: invokevirtual 451	com/google/android/gms/measurement/internal/zzd:setTransactionSuccessful	()V
    //   165: aload_0
    //   166: invokevirtual 199	com/google/android/gms/measurement/internal/zzv:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   169: invokevirtual 537	com/google/android/gms/measurement/internal/zzp:zzzP	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   172: ldc_w 959
    //   175: aload_1
    //   176: invokevirtual 349	com/google/android/gms/measurement/internal/zzp$zza:zzj	(Ljava/lang/String;Ljava/lang/Object;)V
    //   179: aload_0
    //   180: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   183: invokevirtual 448	com/google/android/gms/measurement/internal/zzd:endTransaction	()V
    //   186: aload_0
    //   187: invokespecial 419	com/google/android/gms/measurement/internal/zzv:zzAm	()V
    //   190: return
    //   191: aload_1
    //   192: aload_0
    //   193: aload_3
    //   194: getfield 962	com/google/android/gms/measurement/internal/zzh:zzaMg	J
    //   197: invokevirtual 965	com/google/android/gms/measurement/internal/zzg:zza	(Lcom/google/android/gms/measurement/internal/zzv;J)Lcom/google/android/gms/measurement/internal/zzg;
    //   200: astore_1
    //   201: aload_3
    //   202: aload_1
    //   203: getfield 779	com/google/android/gms/measurement/internal/zzg:zzZH	J
    //   206: invokevirtual 969	com/google/android/gms/measurement/internal/zzh:zzO	(J)Lcom/google/android/gms/measurement/internal/zzh;
    //   209: astore_3
    //   210: goto -82 -> 128
    //   213: astore_1
    //   214: aload_0
    //   215: invokevirtual 237	com/google/android/gms/measurement/internal/zzv:zzAd	()Lcom/google/android/gms/measurement/internal/zzd;
    //   218: invokevirtual 448	com/google/android/gms/measurement/internal/zzd:endTransaction	()V
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	zzv
    //   0	223	1	paramEventParcel	EventParcel
    //   0	223	2	paramAppMetadata	AppMetadata
    //   101	109	3	localzzh	zzh
    // Exception table:
    //   from	to	target	type
    //   81	102	213	finally
    //   106	128	213	finally
    //   128	179	213	finally
    //   191	210	213	finally
  }
  
  void zzb(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    zzis();
    zziE();
    if (TextUtils.isEmpty(paramAppMetadata.zzaLP)) {}
    Object localObject;
    do
    {
      return;
      zzzq().zzef(paramUserAttributeParcel.name);
      localObject = zzzq().zzD(paramUserAttributeParcel.getValue());
    } while (localObject == null);
    paramUserAttributeParcel = new zzae(paramAppMetadata.packageName, paramUserAttributeParcel.name, paramUserAttributeParcel.zzaOz, localObject);
    zzyd().zzzP().zze("Setting user attribute", paramUserAttributeParcel.mName, localObject);
    zzAd().beginTransaction();
    try
    {
      zzc(paramAppMetadata);
      zzAd().zza(paramUserAttributeParcel);
      zzAd().setTransactionSuccessful();
      zzyd().zzzP().zze("User attribute set", paramUserAttributeParcel.mName, paramUserAttributeParcel.zzJy);
      return;
    }
    finally
    {
      zzAd().endTransaction();
    }
  }
  
  void zzb(zzy paramzzy)
  {
    this.zzaOc += 1;
  }
  
  void zzc(UserAttributeParcel paramUserAttributeParcel, AppMetadata paramAppMetadata)
  {
    zzis();
    zziE();
    if (TextUtils.isEmpty(paramAppMetadata.zzaLP)) {
      return;
    }
    zzyd().zzzP().zzj("Removing user attribute", paramUserAttributeParcel.name);
    zzAd().beginTransaction();
    try
    {
      zzc(paramAppMetadata);
      zzAd().zzI(paramAppMetadata.packageName, paramUserAttributeParcel.name);
      zzAd().setTransactionSuccessful();
      zzyd().zzzP().zzj("User attribute removed", paramUserAttributeParcel.name);
      return;
    }
    finally
    {
      zzAd().endTransaction();
    }
  }
  
  void zziE()
  {
    if (!this.zzMF) {
      throw new IllegalStateException("AppMeasurement is not initialized");
    }
  }
  
  void zzir()
  {
    if (zzzt().zzjA()) {
      throw new IllegalStateException("Unexpected call on package side");
    }
  }
  
  public void zzis()
  {
    zzzr().zzis();
  }
  
  public zzmn zzit()
  {
    return this.zzpW;
  }
  
  public zzp zzyd()
  {
    zza(this.zzaNO);
    return this.zzaNO;
  }
  
  public zzn zzzo()
  {
    zza(this.zzaNX);
    return this.zzaNX;
  }
  
  public zzab zzzp()
  {
    zza(this.zzaNU);
    return this.zzaNU;
  }
  
  public zzag zzzq()
  {
    zza(this.zzaNR);
    return this.zzaNR;
  }
  
  public zzu zzzr()
  {
    zza(this.zzaNP);
    return this.zzaNP;
  }
  
  public zzs zzzs()
  {
    zza(this.zzaNN);
    return this.zzaNN;
  }
  
  public zzc zzzt()
  {
    return this.zzaNM;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */