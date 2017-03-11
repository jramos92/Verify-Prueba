package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzgr
public final class zzgw
{
  private int mOrientation = -1;
  private List<String> zzDJ;
  private String zzFU;
  private String zzFV;
  private List<String> zzFW;
  private String zzFX;
  private String zzFY;
  private List<String> zzFZ;
  private long zzGa = -1L;
  private boolean zzGb = false;
  private final long zzGc = -1L;
  private long zzGd = -1L;
  private boolean zzGe = false;
  private boolean zzGf = false;
  private boolean zzGg = false;
  private boolean zzGh = true;
  private int zzGi = 0;
  private String zzGj = "";
  private boolean zzGk = false;
  private String zzwq;
  private final AdRequestInfoParcel zzzz;
  
  public zzgw(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    this.zzzz = paramAdRequestInfoParcel;
  }
  
  static String zzd(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  static long zze(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f = Float.parseFloat(paramMap);
        return (f * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        zzb.zzaH("Could not parse float from " + paramString + " header: " + paramMap);
      }
    }
    return -1L;
  }
  
  static List<String> zzf(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private boolean zzg(Map<String, List<String>> paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    return (paramMap != null) && (!paramMap.isEmpty()) && (Boolean.valueOf((String)paramMap.get(0)).booleanValue());
  }
  
  private void zzi(Map<String, List<String>> paramMap)
  {
    this.zzFU = zzd(paramMap, "X-Afma-Ad-Size");
  }
  
  private void zzj(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Click-Tracking-Urls");
    if (paramMap != null) {
      this.zzFW = paramMap;
    }
  }
  
  private void zzk(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Debug-Dialog");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzFX = ((String)paramMap.get(0));
    }
  }
  
  private void zzl(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Tracking-Urls");
    if (paramMap != null) {
      this.zzFZ = paramMap;
    }
  }
  
  private void zzm(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Interstitial-Timeout");
    if (l != -1L) {
      this.zzGa = l;
    }
  }
  
  private void zzn(Map<String, List<String>> paramMap)
  {
    this.zzFY = zzd(paramMap, "X-Afma-ActiveView");
  }
  
  private void zzo(Map<String, List<String>> paramMap)
  {
    this.zzGf = "native".equals(zzd(paramMap, "X-Afma-Ad-Format"));
  }
  
  private void zzp(Map<String, List<String>> paramMap)
  {
    this.zzGe |= zzg(paramMap, "X-Afma-Custom-Rendering-Allowed");
  }
  
  private void zzq(Map<String, List<String>> paramMap)
  {
    this.zzGb |= zzg(paramMap, "X-Afma-Mediation");
  }
  
  private void zzr(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-Manual-Tracking-Urls");
    if (paramMap != null) {
      this.zzDJ = paramMap;
    }
  }
  
  private void zzs(Map<String, List<String>> paramMap)
  {
    long l = zze(paramMap, "X-Afma-Refresh-Rate");
    if (l != -1L) {
      this.zzGd = l;
    }
  }
  
  private void zzt(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Orientation");
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (!"portrait".equalsIgnoreCase(paramMap)) {
        break label56;
      }
      this.mOrientation = zzp.zzbx().zzgH();
    }
    label56:
    while (!"landscape".equalsIgnoreCase(paramMap)) {
      return;
    }
    this.mOrientation = zzp.zzbx().zzgG();
  }
  
  private void zzu(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Use-HTTPS");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzGg = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzv(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzGh = Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
  }
  
  private void zzw(Map<String, List<String>> paramMap)
  {
    paramMap = zzf(paramMap, "X-Afma-OAuth-Token-Status");
    this.zzGi = 0;
    if (paramMap == null) {}
    String str;
    do
    {
      return;
      while (!paramMap.hasNext()) {
        paramMap = paramMap.iterator();
      }
      str = (String)paramMap.next();
      if ("Clear".equalsIgnoreCase(str))
      {
        this.zzGi = 1;
        return;
      }
    } while (!"No-Op".equalsIgnoreCase(str));
    this.zzGi = 0;
  }
  
  private void zzx(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("X-Afma-Gws-Query-Id");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      this.zzGj = ((String)paramMap.get(0));
    }
  }
  
  private void zzy(Map<String, List<String>> paramMap)
  {
    paramMap = zzd(paramMap, "X-Afma-Fluid");
    if ((paramMap != null) && (paramMap.equals("height"))) {
      this.zzGk = true;
    }
  }
  
  public void zzb(String paramString1, Map<String, List<String>> paramMap, String paramString2)
  {
    this.zzFV = paramString1;
    this.zzwq = paramString2;
    zzh(paramMap);
  }
  
  public void zzh(Map<String, List<String>> paramMap)
  {
    zzi(paramMap);
    zzj(paramMap);
    zzk(paramMap);
    zzl(paramMap);
    zzm(paramMap);
    zzq(paramMap);
    zzr(paramMap);
    zzs(paramMap);
    zzt(paramMap);
    zzn(paramMap);
    zzu(paramMap);
    zzp(paramMap);
    zzo(paramMap);
    zzv(paramMap);
    zzw(paramMap);
    zzx(paramMap);
    zzy(paramMap);
  }
  
  public AdResponseParcel zzj(long paramLong)
  {
    return new AdResponseParcel(this.zzzz, this.zzFV, this.zzwq, this.zzFW, this.zzFZ, this.zzGa, this.zzGb, -1L, this.zzDJ, this.zzGd, this.mOrientation, this.zzFU, paramLong, this.zzFX, this.zzFY, this.zzGe, this.zzGf, this.zzGg, this.zzGh, false, this.zzGi, this.zzGj, this.zzGk);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */