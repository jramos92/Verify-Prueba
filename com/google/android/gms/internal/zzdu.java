package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgr
public class zzdu
  implements Iterable<zzdt>
{
  private final List<zzdt> zzyb = new LinkedList();
  
  private zzdt zzc(zziz paramzziz)
  {
    Iterator localIterator = zzp.zzbI().iterator();
    while (localIterator.hasNext())
    {
      zzdt localzzdt = (zzdt)localIterator.next();
      if (localzzdt.zzoM == paramzziz) {
        return localzzdt;
      }
    }
    return null;
  }
  
  public Iterator<zzdt> iterator()
  {
    return this.zzyb.iterator();
  }
  
  public void zza(zzdt paramzzdt)
  {
    this.zzyb.add(paramzzdt);
  }
  
  public boolean zza(zziz paramzziz)
  {
    paramzziz = zzc(paramzziz);
    if (paramzziz != null)
    {
      paramzziz.zzxY.abort();
      return true;
    }
    return false;
  }
  
  public void zzb(zzdt paramzzdt)
  {
    this.zzyb.remove(paramzzdt);
  }
  
  public boolean zzb(zziz paramzziz)
  {
    return zzc(paramzziz) != null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */