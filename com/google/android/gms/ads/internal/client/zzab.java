package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzel;

public class zzab
{
  private static final Object zzpy = new Object();
  private static zzab zztM;
  private zzw zztN;
  private RewardedVideoAd zztO;
  
  public static zzab zzcV()
  {
    synchronized (zzpy)
    {
      if (zztM == null) {
        zztM = new zzab();
      }
      zzab localzzab = zztM;
      return localzzab;
    }
  }
  
  public RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    synchronized (zzpy)
    {
      if (this.zztO != null)
      {
        paramContext = this.zztO;
        return paramContext;
      }
      zzel localzzel = new zzel();
      this.zztO = new zzi(paramContext, zzl.zzcK().zza(paramContext, localzzel));
      paramContext = this.zztO;
      return paramContext;
    }
  }
  
  public void initialize(Context paramContext)
  {
    synchronized (zzpy)
    {
      if (this.zztN != null) {
        return;
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("Context cannot be null.");
      }
    }
    try
    {
      this.zztN = zzl.zzcI().zzt(paramContext);
      this.zztN.zza();
      return;
    }
    catch (RemoteException paramContext)
    {
      for (;;)
      {
        zzb.zzaH("Fail to initialize mobile ads setting manager");
      }
    }
  }
  
  public void zza(Context paramContext, String paramString, zzac paramzzac)
  {
    initialize(paramContext);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */