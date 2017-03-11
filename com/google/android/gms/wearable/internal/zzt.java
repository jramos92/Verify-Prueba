package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;

public final class zzt
  extends zzau.zza
{
  private zzm zzbgj;
  private zzu zzbgn;
  private final Object zzpd = new Object();
  
  public void zza(zzu paramzzu)
  {
    synchronized (this.zzpd)
    {
      this.zzbgn = ((zzu)zzx.zzw(paramzzu));
      zzm localzzm = this.zzbgj;
      if (localzzm != null) {
        paramzzu.zzb(localzzm);
      }
      return;
    }
  }
  
  public void zzw(int paramInt1, int paramInt2)
  {
    synchronized (this.zzpd)
    {
      zzu localzzu = this.zzbgn;
      zzm localzzm = new zzm(paramInt1, paramInt2);
      this.zzbgj = localzzm;
      if (localzzu != null) {
        localzzu.zzb(localzzm);
      }
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */