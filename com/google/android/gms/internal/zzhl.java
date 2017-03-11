package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzhl
  extends zza.zza
{
  private zzhm zzHh;
  private zzhj zzHn;
  private zzhk zzHo;
  
  public zzhl(zzhk paramzzhk)
  {
    this.zzHo = paramzzhk;
  }
  
  public void zza(zzd paramzzd, RewardItemParcel paramRewardItemParcel)
  {
    if (this.zzHo != null) {
      this.zzHo.zza(paramRewardItemParcel);
    }
  }
  
  public void zza(zzhj paramzzhj)
  {
    this.zzHn = paramzzhj;
  }
  
  public void zza(zzhm paramzzhm)
  {
    this.zzHh = paramzzhm;
  }
  
  public void zzb(zzd paramzzd, int paramInt)
  {
    if (this.zzHn != null) {
      this.zzHn.zzK(paramInt);
    }
  }
  
  public void zzc(zzd paramzzd, int paramInt)
  {
    if (this.zzHh != null) {
      this.zzHh.zzb(zze.zzp(paramzzd).getClass().getName(), paramInt);
    }
  }
  
  public void zzg(zzd paramzzd)
  {
    if (this.zzHn != null) {
      this.zzHn.zzge();
    }
  }
  
  public void zzh(zzd paramzzd)
  {
    if (this.zzHh != null) {
      this.zzHh.zzav(zze.zzp(paramzzd).getClass().getName());
    }
  }
  
  public void zzi(zzd paramzzd)
  {
    if (this.zzHo != null) {
      this.zzHo.onRewardedVideoAdOpened();
    }
  }
  
  public void zzj(zzd paramzzd)
  {
    if (this.zzHo != null) {
      this.zzHo.onRewardedVideoStarted();
    }
  }
  
  public void zzk(zzd paramzzd)
  {
    if (this.zzHo != null) {
      this.zzHo.onRewardedVideoAdClosed();
    }
  }
  
  public void zzl(zzd paramzzd)
  {
    if (this.zzHo != null) {
      this.zzHo.zzgb();
    }
  }
  
  public void zzm(zzd paramzzd)
  {
    if (this.zzHo != null) {
      this.zzHo.onRewardedVideoAdLeftApplication();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */