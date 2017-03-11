package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public class zzbg
  implements zzbf
{
  private final zzbe zzrL;
  private final HashSet<AbstractMap.SimpleEntry<String, zzdk>> zzrM;
  
  public zzbg(zzbe paramzzbe)
  {
    this.zzrL = paramzzbe;
    this.zzrM = new HashSet();
  }
  
  public void zza(String paramString, zzdk paramzzdk)
  {
    this.zzrL.zza(paramString, paramzzdk);
    this.zzrM.add(new AbstractMap.SimpleEntry(paramString, paramzzdk));
  }
  
  public void zza(String paramString1, String paramString2)
  {
    this.zzrL.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    this.zzrL.zza(paramString, paramJSONObject);
  }
  
  public void zzb(String paramString, zzdk paramzzdk)
  {
    this.zzrL.zzb(paramString, paramzzdk);
    this.zzrM.remove(new AbstractMap.SimpleEntry(paramString, paramzzdk));
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzrL.zzb(paramString, paramJSONObject);
  }
  
  public void zzck()
  {
    Iterator localIterator = this.zzrM.iterator();
    while (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      zzb.v("Unregistering eventhandler: " + ((zzdk)localSimpleEntry.getValue()).toString());
      this.zzrL.zzb((String)localSimpleEntry.getKey(), (zzdk)localSimpleEntry.getValue());
    }
    this.zzrM.clear();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */