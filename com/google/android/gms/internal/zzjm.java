package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzjm
  extends zze<zzjm>
{
  private Map<Integer, Double> zzMh = new HashMap(4);
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zzMh.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put("metric" + localEntry.getKey(), localEntry.getValue());
    }
    return zzB(localHashMap);
  }
  
  public void zza(zzjm paramzzjm)
  {
    paramzzjm.zzMh.putAll(this.zzMh);
  }
  
  public Map<Integer, Double> zzhY()
  {
    return Collections.unmodifiableMap(this.zzMh);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */