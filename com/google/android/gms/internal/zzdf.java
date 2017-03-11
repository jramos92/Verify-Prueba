package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzgr
public final class zzdf
  implements zzdk
{
  private final zzdg zzxn;
  
  public zzdf(zzdg paramzzdg)
  {
    this.zzxn = paramzzdg;
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramzziz = (String)paramMap.get("name");
    if (paramzziz == null)
    {
      zzb.zzaH("App event with no name parameter.");
      return;
    }
    this.zzxn.onAppEvent(paramzziz, (String)paramMap.get("info"));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */