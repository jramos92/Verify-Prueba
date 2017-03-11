package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import java.util.List;

@zzgr
public final class zzeh
  implements zzei.zza
{
  private final Context mContext;
  private final NativeAdOptionsParcel zzoY;
  private final List<String> zzoZ;
  private final zzem zzox;
  private final AdRequestParcel zzpH;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private final String zzzj;
  private final long zzzk;
  private final zzed zzzl;
  private final AdSizeParcel zzzm;
  private final boolean zzzn;
  private zzen zzzo;
  private int zzzp = -2;
  private zzep zzzq;
  
  public zzeh(Context paramContext, String paramString, zzem paramzzem, zzee paramzzee, zzed paramzzed, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, VersionInfoParcel paramVersionInfoParcel, boolean paramBoolean, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    this.mContext = paramContext;
    this.zzox = paramzzem;
    this.zzzl = paramzzed;
    if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(paramString))
    {
      this.zzzj = zzdT();
      if (paramzzee.zzyX == -1L) {
        break label124;
      }
    }
    label124:
    for (long l = paramzzee.zzyX;; l = 10000L)
    {
      this.zzzk = l;
      this.zzpH = paramAdRequestParcel;
      this.zzzm = paramAdSizeParcel;
      this.zzpb = paramVersionInfoParcel;
      this.zzzn = paramBoolean;
      this.zzoY = paramNativeAdOptionsParcel;
      this.zzoZ = paramList;
      return;
      this.zzzj = paramString;
      break;
    }
  }
  
  private void zza(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      if (this.zzzp != -2) {
        return;
      }
      zzb(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  private void zza(zzeg paramzzeg)
  {
    if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzzj))
    {
      Bundle localBundle2 = this.zzpH.zzsL.getBundle(this.zzzj);
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localBundle1.putString("sdk_less_network_id", this.zzzl.zzyN);
      this.zzpH.zzsL.putBundle(this.zzzj, localBundle1);
    }
    try
    {
      if (this.zzpb.zzJw < 4100000)
      {
        if (this.zzzm.zztf)
        {
          this.zzzo.zza(zze.zzy(this.mContext), this.zzpH, this.zzzl.zzyT, paramzzeg);
          return;
        }
        this.zzzo.zza(zze.zzy(this.mContext), this.zzzm, this.zzpH, this.zzzl.zzyT, paramzzeg);
        return;
      }
    }
    catch (RemoteException paramzzeg)
    {
      zzb.zzd("Could not request ad from mediation adapter.", paramzzeg);
      zzq(5);
      return;
    }
    if (this.zzzn)
    {
      this.zzzo.zza(zze.zzy(this.mContext), this.zzpH, this.zzzl.zzyT, this.zzzl.zzyM, paramzzeg, this.zzoY, this.zzoZ);
      return;
    }
    if (this.zzzm.zztf)
    {
      this.zzzo.zza(zze.zzy(this.mContext), this.zzpH, this.zzzl.zzyT, this.zzzl.zzyM, paramzzeg);
      return;
    }
    this.zzzo.zza(zze.zzy(this.mContext), this.zzzm, this.zzpH, this.zzzl.zzyT, this.zzzl.zzyM, paramzzeg);
  }
  
  private void zzb(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    long l = SystemClock.elapsedRealtime();
    paramLong1 = paramLong2 - (l - paramLong1);
    paramLong2 = paramLong4 - (l - paramLong3);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      zzb.zzaG("Timed out waiting for adapter.");
      this.zzzp = 3;
      return;
    }
    try
    {
      this.zzpd.wait(Math.min(paramLong1, paramLong2));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzzp = -1;
    }
  }
  
  private String zzdT()
  {
    try
    {
      if (!TextUtils.isEmpty(this.zzzl.zzyQ))
      {
        if (this.zzox.zzaf(this.zzzl.zzyQ)) {
          return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Fail to determine the custom event's version, assuming the old one.");
    }
    return "com.google.ads.mediation.customevent.CustomEventAdapter";
  }
  
  private zzen zzdU()
  {
    zzb.zzaG("Instantiating mediation adapter: " + this.zzzj);
    if (((Boolean)zzby.zzvu.get()).booleanValue())
    {
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzzj)) {
        return new zzet(new AdMobAdapter());
      }
      if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzzj)) {
        return new zzet(new AdUrlAdapter());
      }
    }
    try
    {
      zzen localzzen = this.zzox.zzae(this.zzzj);
      return localzzen;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zza("Could not instantiate mediation adapter: " + this.zzzj, localRemoteException);
    }
    return null;
  }
  
  public void cancel()
  {
    synchronized (this.zzpd)
    {
      try
      {
        if (this.zzzo != null) {
          this.zzzo.destroy();
        }
        this.zzzp = -1;
        this.zzpd.notify();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
        }
      }
    }
  }
  
  public zzei zza(long paramLong1, long paramLong2)
  {
    synchronized (this.zzpd)
    {
      long l = SystemClock.elapsedRealtime();
      final Object localObject2 = new zzeg();
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          synchronized (zzeh.zza(zzeh.this))
          {
            if (zzeh.zzb(zzeh.this) != -2) {
              return;
            }
            zzeh.zza(zzeh.this, zzeh.zzc(zzeh.this));
            if (zzeh.zzd(zzeh.this) == null)
            {
              zzeh.this.zzq(4);
              return;
            }
          }
          localObject2.zza(zzeh.this);
          zzeh.zza(zzeh.this, localObject2);
        }
      });
      zza(l, this.zzzk, paramLong1, paramLong2);
      localObject2 = new zzei(this.zzzl, this.zzzo, this.zzzj, (zzeg)localObject2, this.zzzp, this.zzzq);
      return (zzei)localObject2;
    }
  }
  
  public void zza(int paramInt, zzep paramzzep)
  {
    synchronized (this.zzpd)
    {
      this.zzzp = paramInt;
      this.zzzq = paramzzep;
      this.zzpd.notify();
      return;
    }
  }
  
  public void zzq(int paramInt)
  {
    synchronized (this.zzpd)
    {
      this.zzzp = paramInt;
      this.zzpd.notify();
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */