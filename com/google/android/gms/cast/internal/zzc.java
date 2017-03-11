package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc
  extends zzd
{
  protected final Handler mHandler = new Handler(Looper.getMainLooper());
  protected boolean zzYA;
  protected final long zzYy;
  protected final Runnable zzYz = new zza(null);
  
  public zzc(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, 1000L);
  }
  
  public zzc(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    super(paramString1, paramString2, paramString3);
    this.zzYy = paramLong;
    zzV(false);
  }
  
  protected final void zzV(boolean paramBoolean)
  {
    if (this.zzYA != paramBoolean)
    {
      this.zzYA = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.zzYz, this.zzYy);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.zzYz);
  }
  
  public void zzmP()
  {
    zzV(false);
  }
  
  protected abstract boolean zzz(long paramLong);
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    public void run()
    {
      zzc.this.zzYA = false;
      long l = SystemClock.elapsedRealtime();
      boolean bool = zzc.this.zzz(l);
      zzc.this.zzV(bool);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */