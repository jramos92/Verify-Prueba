package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzek
  implements zzec
{
  private final Context mContext;
  private final zzcg zzoo;
  private final zzem zzox;
  private final Object zzpd = new Object();
  private final zzee zzzA;
  private final long zzzB;
  private final long zzzC;
  private boolean zzzD = false;
  private zzeh zzzE;
  private final boolean zzzn;
  private final AdRequestInfoParcel zzzz;
  
  public zzek(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzem paramzzem, zzee paramzzee, boolean paramBoolean, long paramLong1, long paramLong2, zzcg paramzzcg)
  {
    this.mContext = paramContext;
    this.zzzz = paramAdRequestInfoParcel;
    this.zzox = paramzzem;
    this.zzzA = paramzzee;
    this.zzzn = paramBoolean;
    this.zzzB = paramLong1;
    this.zzzC = paramLong2;
    this.zzoo = paramzzcg;
  }
  
  public void cancel()
  {
    synchronized (this.zzpd)
    {
      this.zzzD = true;
      if (this.zzzE != null) {
        this.zzzE.cancel();
      }
      return;
    }
  }
  
  public zzei zzc(List<zzed> arg1)
  {
    zzb.zzaF("Starting mediation.");
    Object localObject = new ArrayList();
    zzce localzzce1 = this.zzoo.zzdn();
    Iterator localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      zzed localzzed = (zzed)localIterator1.next();
      zzb.zzaG("Trying mediation network: " + localzzed.zzyN);
      Iterator localIterator2 = localzzed.zzyO.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        zzce localzzce2 = this.zzoo.zzdn();
        synchronized (this.zzpd)
        {
          if (this.zzzD)
          {
            localObject = new zzei(-1);
            return (zzei)localObject;
          }
          this.zzzE = new zzeh(this.mContext, str, this.zzox, this.zzzA, localzzed, this.zzzz.zzEn, this.zzzz.zzqn, this.zzzz.zzqj, this.zzzn, this.zzzz.zzqB, this.zzzz.zzqD);
          ??? = this.zzzE.zza(this.zzzB, this.zzzC);
          if (???.zzzt == 0)
          {
            zzb.zzaF("Adapter succeeded.");
            this.zzoo.zze("mediation_network_succeed", str);
            if (!((List)localObject).isEmpty()) {
              this.zzoo.zze("mediation_networks_fail", TextUtils.join(",", (Iterable)localObject));
            }
            this.zzoo.zza(localzzce2, new String[] { "mls" });
            this.zzoo.zza(localzzce1, new String[] { "ttm" });
            return (zzei)???;
          }
        }
        localIterable.add(str);
        this.zzoo.zza(localzzce2, new String[] { "mlf" });
        if (???.zzzv != null) {
          zzid.zzIE.post(new Runnable()
          {
            public void run()
            {
              try
              {
                paramList.zzzv.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    if (!localIterable.isEmpty()) {
      this.zzoo.zze("mediation_networks_fail", TextUtils.join(",", localIterable));
    }
    return new zzei(1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */