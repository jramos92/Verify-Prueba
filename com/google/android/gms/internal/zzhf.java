package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzhf
  extends zzb.zza
{
  private final Context mContext;
  private final zzhg zzGW;
  private final VersionInfoParcel zzpb;
  private final Object zzpd;
  
  public zzhf(Context paramContext, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpb = paramVersionInfoParcel;
    this.zzGW = new zzhg(paramContext, AdSizeParcel.zzcC(), paramzzem, paramVersionInfoParcel);
    this.zzpd = new Object();
  }
  
  public void destroy()
  {
    synchronized (this.zzpd)
    {
      this.zzGW.destroy();
      return;
    }
  }
  
  public boolean isLoaded()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzGW.isLoaded();
      return bool;
    }
  }
  
  public void pause()
  {
    synchronized (this.zzpd)
    {
      this.zzGW.pause();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (this.zzpd)
    {
      this.zzGW.resume();
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (this.zzpd)
    {
      this.zzGW.setUserId(paramString);
      return;
    }
  }
  
  public void show()
  {
    synchronized (this.zzpd)
    {
      this.zzGW.zzga();
      return;
    }
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    synchronized (this.zzpd)
    {
      this.zzGW.zza(paramRewardedVideoAdRequestParcel);
      return;
    }
  }
  
  public void zza(zzd paramzzd)
  {
    synchronized (this.zzpd)
    {
      this.zzGW.zza(paramzzd);
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */