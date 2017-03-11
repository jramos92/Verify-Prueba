package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzhi
  extends zzhz
  implements zzhj, zzhm
{
  private final Context mContext;
  private final zzhs.zza zzDe;
  private int zzDv = 3;
  private final String zzGY;
  private final zzhh zzHg;
  private final zzhm zzHh;
  private final String zzHi;
  private int zzHj = 0;
  private final Object zzpd;
  private final String zzzj;
  
  public zzhi(Context paramContext, String paramString1, String paramString2, String paramString3, zzhs.zza paramzza, zzhh paramzzhh, zzhm paramzzhm)
  {
    this.mContext = paramContext;
    this.zzzj = paramString1;
    this.zzGY = paramString2;
    this.zzHi = paramString3;
    this.zzDe = paramzza;
    this.zzHg = paramzzhh;
    this.zzpd = new Object();
    this.zzHh = paramzzhm;
  }
  
  private void zzk(long paramLong)
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHj != 0) {
          return;
        }
        if (!zzf(paramLong)) {
          return;
        }
      }
    }
  }
  
  public void onStop() {}
  
  public void zzK(int paramInt)
  {
    zzb(this.zzzj, 0);
  }
  
  public void zzav(String arg1)
  {
    synchronized (this.zzpd)
    {
      this.zzHj = 1;
      this.zzpd.notify();
      return;
    }
  }
  
  public void zzb(String arg1, int paramInt)
  {
    synchronized (this.zzpd)
    {
      this.zzHj = 2;
      this.zzDv = paramInt;
      this.zzpd.notify();
      return;
    }
  }
  
  public void zzbn()
  {
    if ((this.zzHg == null) || (this.zzHg.zzgd() == null) || (this.zzHg.zzgc() == null)) {
      return;
    }
    final zzhl localzzhl = this.zzHg.zzgd();
    localzzhl.zza(this);
    localzzhl.zza(this);
    final AdRequestParcel localAdRequestParcel = this.zzDe.zzHC.zzEn;
    final zzen localzzen = this.zzHg.zzgc();
    try
    {
      if (localzzen.isInitialized()) {
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzen.zza(localAdRequestParcel, zzhi.zza(zzhi.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to load ad from adapter.", localRemoteException);
              zzhi.this.zzb(zzhi.zzb(zzhi.this), 0);
            }
          }
        });
      }
      for (;;)
      {
        zzk(zzp.zzbz().elapsedRealtime());
        localzzhl.zza(null);
        localzzhl.zza(null);
        if (this.zzHj != 1) {
          break;
        }
        this.zzHh.zzav(this.zzzj);
        return;
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzen.zza(zze.zzy(zzhi.zzc(zzhi.this)), localAdRequestParcel, zzhi.zzd(zzhi.this), localzzhl, zzhi.zza(zzhi.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              zzb.zzd("Fail to initialize adapter " + zzhi.zzb(zzhi.this), localRemoteException);
              zzhi.this.zzb(zzhi.zzb(zzhi.this), 0);
            }
          }
        });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Fail to check if adapter is initialized.", localRemoteException);
        zzb(this.zzzj, 0);
      }
      this.zzHh.zzb(this.zzzj, this.zzDv);
    }
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = 20000L - (zzp.zzbz().elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.zzpd.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public void zzge()
  {
    this.zzHg.zzgd();
    AdRequestParcel localAdRequestParcel = this.zzDe.zzHC.zzEn;
    zzen localzzen = this.zzHg.zzgc();
    try
    {
      localzzen.zza(localAdRequestParcel, this.zzHi);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Fail to load ad from adapter.", localRemoteException);
      zzb(this.zzzj, 0);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */