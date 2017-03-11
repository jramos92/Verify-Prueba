package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@zzgr
public class zzc
  extends zzhz
  implements ServiceConnection
{
  private Context mContext;
  private boolean zzCB = false;
  private zzfw zzCC;
  private zzb zzCD;
  private zzh zzCE;
  private List<zzf> zzCF = null;
  private zzk zzCG;
  private final Object zzpd = new Object();
  
  public zzc(Context paramContext, zzfw paramzzfw, zzk paramzzk)
  {
    this(paramContext, paramzzfw, paramzzk, new zzb(paramContext), zzh.zzw(paramContext.getApplicationContext()));
  }
  
  zzc(Context paramContext, zzfw paramzzfw, zzk paramzzk, zzb paramzzb, zzh paramzzh)
  {
    this.mContext = paramContext;
    this.zzCC = paramzzfw;
    this.zzCG = paramzzk;
    this.zzCD = paramzzb;
    this.zzCE = paramzzh;
    this.zzCF = this.zzCE.zzg(10L);
  }
  
  private void zze(long paramLong)
  {
    do
    {
      if (!zzf(paramLong)) {
        com.google.android.gms.ads.internal.util.client.zzb.v("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.zzCB);
  }
  
  private boolean zzf(long paramLong)
  {
    paramLong = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      this.zzpd.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("waitWithTimeout_lock interrupted");
      }
    }
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    synchronized (this.zzpd)
    {
      this.zzCD.zzN(paramIBinder);
      zzfm();
      this.zzCB = true;
      this.zzpd.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
    this.zzCD.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.zzpd)
    {
      com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, this);
      this.zzCD.destroy();
      return;
    }
  }
  
  protected void zza(final zzf paramzzf, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    zzp.zzbF();
    localIntent.putExtra("RESPONSE_CODE", 0);
    zzp.zzbF();
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    zzp.zzbF();
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (zzc.zza(zzc.this).zza(paramzzf.zzCR, -1, localIntent))
          {
            zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzf.zzCS, true, -1, localIntent, paramzzf));
            return;
          }
          zzc.zzc(zzc.this).zza(new zzg(zzc.zzb(zzc.this), paramzzf.zzCS, false, -1, localIntent, paramzzf));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  public void zzbn()
  {
    synchronized (this.zzpd)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, localIntent, this, 1);
      zze(SystemClock.elapsedRealtime());
      com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, this);
      this.zzCD.destroy();
      return;
    }
  }
  
  protected void zzfm()
  {
    if (this.zzCF.isEmpty()) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.zzCF.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzf)((Iterator)localObject1).next();
      localHashMap.put(((zzf)localObject2).zzCS, localObject2);
    }
    localObject1 = null;
    for (;;)
    {
      localObject1 = this.zzCD.zzj(this.mContext.getPackageName(), (String)localObject1);
      if (localObject1 == null) {}
      do
      {
        do
        {
          localObject1 = localHashMap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            this.zzCE.zza((zzf)localHashMap.get(localObject2));
          }
          break;
        } while (zzp.zzbF().zzc((Bundle)localObject1) != 0);
        localObject2 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList1 = ((Bundle)localObject1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList2 = ((Bundle)localObject1).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        localObject1 = ((Bundle)localObject1).getString("INAPP_CONTINUATION_TOKEN");
        int i = 0;
        while (i < ((ArrayList)localObject2).size())
        {
          if (localHashMap.containsKey(((ArrayList)localObject2).get(i)))
          {
            String str1 = (String)((ArrayList)localObject2).get(i);
            String str2 = (String)localArrayList1.get(i);
            String str3 = (String)localArrayList2.get(i);
            zzf localzzf = (zzf)localHashMap.get(str1);
            String str4 = zzp.zzbF().zzao(str2);
            if (localzzf.zzCR.equals(str4))
            {
              zza(localzzf, str2, str3);
              localHashMap.remove(str1);
            }
          }
          i += 1;
        }
      } while ((localObject1 == null) || (localHashMap.isEmpty()));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */