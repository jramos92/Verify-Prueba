package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;

@zzgr
public class zzbx
{
  private boolean zzpA = false;
  private final Object zzpd = new Object();
  private SharedPreferences zzuj = null;
  
  public void initialize(Context paramContext)
  {
    synchronized (this.zzpd)
    {
      if (this.zzpA) {
        return;
      }
      paramContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (paramContext == null) {
        return;
      }
    }
    this.zzuj = zzp.zzbC().zzv(paramContext);
    this.zzpA = true;
  }
  
  public <T> T zzd(zzbu<T> paramzzbu)
  {
    synchronized (this.zzpd)
    {
      if (!this.zzpA)
      {
        paramzzbu = paramzzbu.zzde();
        return paramzzbu;
      }
      return (T)paramzzbu.zza(this.zzuj);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */