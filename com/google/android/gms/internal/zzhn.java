package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@zzgr
public class zzhn
  extends zzhz
  implements zzhm
{
  private final Context mContext;
  private final zzhs.zza zzDe;
  private final String zzGY;
  private final ArrayList<Future> zzHp = new ArrayList();
  private final ArrayList<String> zzHq = new ArrayList();
  private final HashSet<String> zzHr = new HashSet();
  private final zzhg zzHs;
  private final Object zzpd = new Object();
  
  public zzhn(Context paramContext, String paramString, zzhs.zza paramzza, zzhg paramzzhg)
  {
    this.mContext = paramContext;
    this.zzGY = paramString;
    this.zzDe = paramzza;
    this.zzHs = paramzzhg;
  }
  
  private void zzk(String paramString1, String paramString2)
  {
    synchronized (this.zzpd)
    {
      zzhh localzzhh = this.zzHs.zzau(paramString1);
      if ((localzzhh == null) || (localzzhh.zzgd() == null) || (localzzhh.zzgc() == null)) {
        return;
      }
      paramString2 = new zzhi(this.mContext, paramString1, this.zzGY, paramString2, this.zzDe, localzzhh, this);
      this.zzHp.add(paramString2.zzgz());
      this.zzHq.add(paramString1);
      return;
    }
  }
  
  public void onStop() {}
  
  public void zzav(String paramString)
  {
    synchronized (this.zzpd)
    {
      this.zzHr.add(paramString);
      return;
    }
  }
  
  public void zzb(String paramString, int paramInt) {}
  
  public void zzbn()
  {
    ??? = this.zzDe.zzHx.zzyW.iterator();
    final Object localObject2;
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (zzed)((Iterator)???).next();
      localObject2 = ((zzed)localObject4).zzyT;
      localObject4 = ((zzed)localObject4).zzyO.iterator();
      while (((Iterator)localObject4).hasNext()) {
        zzk((String)((Iterator)localObject4).next(), (String)localObject2);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < this.zzHp.size()) {}
      try
      {
        ((Future)this.zzHp.get(i)).get();
        synchronized (this.zzpd)
        {
          if (this.zzHr.contains(this.zzHq.get(i)))
          {
            localObject2 = (String)this.zzHq.get(i);
            localObject2 = new zzhs(this.zzDe.zzHC.zzEn, null, this.zzDe.zzHD.zzyY, -2, this.zzDe.zzHD.zzyZ, this.zzDe.zzHD.zzEM, this.zzDe.zzHD.orientation, this.zzDe.zzHD.zzzc, this.zzDe.zzHC.zzEq, this.zzDe.zzHD.zzEK, (zzed)this.zzDe.zzHx.zzyW.get(i), null, (String)localObject2, this.zzDe.zzHx, null, this.zzDe.zzHD.zzEL, this.zzDe.zzqn, this.zzDe.zzHD.zzEJ, this.zzDe.zzHz, this.zzDe.zzHD.zzEO, this.zzDe.zzHD.zzEP, this.zzDe.zzHw, null);
            zza.zzJt.post(new Runnable()
            {
              public void run()
              {
                zzhn.zza(zzhn.this).zzb(localObject2);
              }
            });
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        final zzhs localzzhs = new zzhs(this.zzDe.zzHC.zzEn, null, this.zzDe.zzHD.zzyY, 3, this.zzDe.zzHD.zzyZ, this.zzDe.zzHD.zzEM, this.zzDe.zzHD.orientation, this.zzDe.zzHD.zzzc, this.zzDe.zzHC.zzEq, this.zzDe.zzHD.zzEK, null, null, null, this.zzDe.zzHx, null, this.zzDe.zzHD.zzEL, this.zzDe.zzqn, this.zzDe.zzHD.zzEJ, this.zzDe.zzHz, this.zzDe.zzHD.zzEO, this.zzDe.zzHD.zzEP, this.zzDe.zzHw, null);
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            zzhn.zza(zzhn.this).zzb(localzzhs);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */