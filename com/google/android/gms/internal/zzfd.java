package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfd
{
  private final boolean zzAq;
  private final String zzAr;
  private final zziz zzoM;
  
  public zzfd(zziz paramzziz, Map<String, String> paramMap)
  {
    this.zzoM = paramzziz;
    this.zzAr = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      this.zzAq = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    this.zzAq = true;
  }
  
  public void execute()
  {
    if (this.zzoM == null)
    {
      zzb.zzaH("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(this.zzAr)) {
      i = zzp.zzbx().zzgH();
    }
    for (;;)
    {
      this.zzoM.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(this.zzAr)) {
        i = zzp.zzbx().zzgG();
      } else if (this.zzAq) {
        i = -1;
      } else {
        i = zzp.zzbx().zzgI();
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */