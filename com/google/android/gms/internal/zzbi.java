package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgr
public class zzbi
{
  private final Object zzpd = new Object();
  private int zzrX;
  private List<zzbh> zzrY = new LinkedList();
  
  public boolean zza(zzbh paramzzbh)
  {
    synchronized (this.zzpd)
    {
      return this.zzrY.contains(paramzzbh);
    }
  }
  
  public boolean zzb(zzbh paramzzbh)
  {
    synchronized (this.zzpd)
    {
      Iterator localIterator = this.zzrY.iterator();
      while (localIterator.hasNext())
      {
        zzbh localzzbh = (zzbh)localIterator.next();
        if ((paramzzbh != localzzbh) && (localzzbh.zzcm().equals(paramzzbh.zzcm())))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }
  
  public void zzc(zzbh paramzzbh)
  {
    synchronized (this.zzpd)
    {
      if (this.zzrY.size() >= 10)
      {
        zzb.zzaF("Queue is full, current size = " + this.zzrY.size());
        this.zzrY.remove(0);
      }
      int i = this.zzrX;
      this.zzrX = (i + 1);
      paramzzbh.zzg(i);
      this.zzrY.add(paramzzbh);
      return;
    }
  }
  
  public zzbh zzcs()
  {
    Object localObject1 = null;
    label146:
    label149:
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzrY.size() == 0)
        {
          zzb.zzaF("Queue empty");
          return null;
        }
        if (this.zzrY.size() >= 2)
        {
          int i = Integer.MIN_VALUE;
          Iterator localIterator = this.zzrY.iterator();
          if (localIterator.hasNext())
          {
            zzbh localzzbh2 = (zzbh)localIterator.next();
            int j = localzzbh2.getScore();
            if (j <= i) {
              break label146;
            }
            localObject1 = localzzbh2;
            i = j;
            break label149;
          }
          this.zzrY.remove(localObject1);
          return (zzbh)localObject1;
        }
      }
      zzbh localzzbh1 = (zzbh)this.zzrY.get(0);
      localzzbh1.zzcn();
      return localzzbh1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */