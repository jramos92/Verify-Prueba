package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.lang.ref.WeakReference;

@zzgr
public class zzo
{
  private final zza zzpG;
  private AdRequestParcel zzpH;
  private boolean zzpI = false;
  private boolean zzpJ = false;
  private long zzpK = 0L;
  private final Runnable zzx;
  
  public zzo(zza paramzza)
  {
    this(paramzza, new zza(zzid.zzIE));
  }
  
  zzo(zza paramzza, zza paramzza1)
  {
    this.zzpG = paramzza1;
    this.zzx = new Runnable()
    {
      public void run()
      {
        zzo.zza(zzo.this, false);
        zza localzza = (zza)this.zzpL.get();
        if (localzza != null) {
          localzza.zzd(zzo.zza(zzo.this));
        }
      }
    };
  }
  
  public void cancel()
  {
    this.zzpI = false;
    this.zzpG.removeCallbacks(this.zzx);
  }
  
  public void pause()
  {
    this.zzpJ = true;
    if (this.zzpI) {
      this.zzpG.removeCallbacks(this.zzx);
    }
  }
  
  public void resume()
  {
    this.zzpJ = false;
    if (this.zzpI)
    {
      this.zzpI = false;
      zza(this.zzpH, this.zzpK);
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    if (this.zzpI) {
      zzb.zzaH("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      this.zzpH = paramAdRequestParcel;
      this.zzpI = true;
      this.zzpK = paramLong;
    } while (this.zzpJ);
    zzb.zzaG("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    this.zzpG.postDelayed(this.zzx, paramLong);
  }
  
  public boolean zzbp()
  {
    return this.zzpI;
  }
  
  public void zzg(AdRequestParcel paramAdRequestParcel)
  {
    zza(paramAdRequestParcel, 60000L);
  }
  
  public static class zza
  {
    private final Handler mHandler;
    
    public zza(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return this.mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      this.mHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */