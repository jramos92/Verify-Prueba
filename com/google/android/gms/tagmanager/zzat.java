package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat
  extends Thread
  implements zzas
{
  private static zzat zzaXf;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zzNZ = false;
  private final LinkedBlockingQueue<Runnable> zzaXe = new LinkedBlockingQueue();
  private volatile zzau zzaXg;
  
  private zzat(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static zzat zzaQ(Context paramContext)
  {
    if (zzaXf == null) {
      zzaXf = new zzat(paramContext);
    }
    return zzaXf;
  }
  
  private String zzd(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void run()
  {
    while (!this.mClosed) {
      try
      {
        Runnable localRunnable = (Runnable)this.zzaXe.take();
        if (!this.zzNZ) {
          localRunnable.run();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        zzbg.zzaG(localInterruptedException.toString());
      }
      catch (Throwable localThrowable)
      {
        zzbg.e("Error on Google TagManager Thread: " + zzd(localThrowable));
        zzbg.e("Google TagManager is shutting down.");
        this.zzNZ = true;
      }
    }
  }
  
  public void zzeR(String paramString)
  {
    zzj(paramString, System.currentTimeMillis());
  }
  
  void zzj(String paramString, final long paramLong)
  {
    zzk(new Runnable()
    {
      public void run()
      {
        if (zzat.zza(zzat.this) == null)
        {
          zzcu localzzcu = zzcu.zzDG();
          localzzcu.zza(zzat.zzb(zzat.this), jdField_this);
          zzat.zza(zzat.this, localzzcu.zzDJ());
        }
        zzat.zza(zzat.this).zzg(paramLong, this.zzyc);
      }
    });
  }
  
  public void zzk(Runnable paramRunnable)
  {
    this.zzaXe.add(paramRunnable);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */