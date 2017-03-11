package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzic;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzgr
class zzh
  implements zzaj, Runnable
{
  private final List<Object[]> zzoQ = new Vector();
  private final AtomicReference<zzaj> zzoR = new AtomicReference();
  CountDownLatch zzoS = new CountDownLatch(1);
  private zzq zzot;
  
  public zzh(zzq paramzzq)
  {
    this.zzot = paramzzq;
    if (zzl.zzcF().zzgT())
    {
      zzic.zza(this);
      return;
    }
    run();
  }
  
  private void zzbh()
  {
    if (this.zzoQ.isEmpty()) {
      return;
    }
    Iterator localIterator = this.zzoQ.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1) {
        ((zzaj)this.zzoR.get()).zza((MotionEvent)arrayOfObject[0]);
      } else if (arrayOfObject.length == 3) {
        ((zzaj)this.zzoR.get()).zza(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      }
    }
    this.zzoQ.clear();
  }
  
  private Context zzp(Context paramContext)
  {
    if (!((Boolean)zzby.zzuw.get()).booleanValue()) {}
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    } while (localContext == null);
    return localContext;
  }
  
  public void run()
  {
    label94:
    for (;;)
    {
      try
      {
        if (((Boolean)zzby.zzuI.get()).booleanValue()) {
          if (this.zzot.zzqj.zzJx)
          {
            break label94;
            zza(zzb(this.zzot.zzqj.zzJu, zzp(this.zzot.context), bool));
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally
      {
        this.zzoS.countDown();
        this.zzot = null;
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    zzaj localzzaj = (zzaj)this.zzoR.get();
    if (localzzaj != null)
    {
      zzbh();
      localzzaj.zza(paramInt1, paramInt2, paramInt3);
      return;
    }
    this.zzoQ.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzaj localzzaj = (zzaj)this.zzoR.get();
    if (localzzaj != null)
    {
      zzbh();
      localzzaj.zza(paramMotionEvent);
      return;
    }
    this.zzoQ.add(new Object[] { paramMotionEvent });
  }
  
  protected void zza(zzaj paramzzaj)
  {
    this.zzoR.set(paramzzaj);
  }
  
  protected zzaj zzb(String paramString, Context paramContext, boolean paramBoolean)
  {
    return zzam.zza(paramString, paramContext, paramBoolean);
  }
  
  public String zzb(Context paramContext)
  {
    if (zzbg())
    {
      zzaj localzzaj = (zzaj)this.zzoR.get();
      if (localzzaj != null)
      {
        zzbh();
        return localzzaj.zzb(zzp(paramContext));
      }
    }
    return "";
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    if (zzbg())
    {
      zzaj localzzaj = (zzaj)this.zzoR.get();
      if (localzzaj != null)
      {
        zzbh();
        return localzzaj.zzb(zzp(paramContext), paramString);
      }
    }
    return "";
  }
  
  protected boolean zzbg()
  {
    try
    {
      this.zzoS.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzb.zzd("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */