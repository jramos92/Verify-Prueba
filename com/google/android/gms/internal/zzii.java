package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

public class zzii
{
  private Handler mHandler = null;
  private HandlerThread zzJh = null;
  private int zzJi = 0;
  private final Object zzpd = new Object();
  
  public Looper zzgM()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzJi == 0)
        {
          if (this.zzJh == null)
          {
            zzb.v("Starting the looper thread.");
            this.zzJh = new HandlerThread("LooperProvider");
            this.zzJh.start();
            this.mHandler = new Handler(this.zzJh.getLooper());
            zzb.v("Looper thread started.");
            this.zzJi += 1;
            Looper localLooper = this.zzJh.getLooper();
            return localLooper;
          }
          zzb.v("Resuming the looper thread");
          this.zzpd.notifyAll();
        }
      }
      zzx.zzb(this.zzJh, "Invalid state: mHandlerThread should already been initialized.");
    }
  }
  
  public void zzgN()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzJi > 0)
        {
          bool = true;
          zzx.zzb(bool, "Invalid state: release() called more times than expected.");
          int i = this.zzJi - 1;
          this.zzJi = i;
          if (i == 0) {
            this.mHandler.post(new Runnable()
            {
              public void run()
              {
                synchronized (zzii.zza(zzii.this))
                {
                  zzb.v("Suspending the looper thread");
                  for (;;)
                  {
                    int i = zzii.zzb(zzii.this);
                    if (i == 0) {
                      try
                      {
                        zzii.zza(zzii.this).wait();
                        zzb.v("Looper thread resumed");
                      }
                      catch (InterruptedException localInterruptedException)
                      {
                        zzb.v("Looper thread interrupted.");
                      }
                    }
                  }
                }
              }
            });
          }
          return;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzii.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */