package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzpf;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzph;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzb
  extends com.google.android.gms.analytics.internal.zzc
  implements zzi
{
  private static DecimalFormat zzLp;
  private final zzf zzLf;
  private final String zzLq;
  private final Uri zzLr;
  private final boolean zzLs;
  private final boolean zzLt;
  
  public zzb(zzf paramzzf, String paramString)
  {
    this(paramzzf, paramString, true, false);
  }
  
  public zzb(zzf paramzzf, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzf);
    zzx.zzcr(paramString);
    this.zzLf = paramzzf;
    this.zzLq = paramString;
    this.zzLs = paramBoolean1;
    this.zzLt = paramBoolean2;
    this.zzLr = zzaR(this.zzLq);
  }
  
  private static String zzA(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, zzb(paramDouble));
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramMap.put(paramString, paramInt1 + "x" + paramInt2);
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  static Uri zzaR(String paramString)
  {
    zzx.zzcr(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  static String zzb(double paramDouble)
  {
    if (zzLp == null) {
      zzLp = new DecimalFormat("0.######");
    }
    return zzLp.format(paramDouble);
  }
  
  private static void zzb(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static Map<String, String> zzc(com.google.android.gms.measurement.zzc paramzzc)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (zzjn)paramzzc.zzd(zzjn.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((zzjn)localObject1).zzhZ().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzh(((Map.Entry)localObject2).getValue());
        if (localObject3 != null) {
          localHashMap.put(((Map.Entry)localObject2).getKey(), localObject3);
        }
      }
    }
    localObject1 = (zzjo)paramzzc.zzd(zzjo.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "t", ((zzjo)localObject1).zzia());
      zzb(localHashMap, "cid", ((zzjo)localObject1).getClientId());
      zzb(localHashMap, "uid", ((zzjo)localObject1).getUserId());
      zzb(localHashMap, "sc", ((zzjo)localObject1).zzid());
      zza(localHashMap, "sf", ((zzjo)localObject1).zzif());
      zza(localHashMap, "ni", ((zzjo)localObject1).zzie());
      zzb(localHashMap, "adid", ((zzjo)localObject1).zzib());
      zza(localHashMap, "ate", ((zzjo)localObject1).zzic());
    }
    localObject1 = (zzph)paramzzc.zzd(zzph.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cd", ((zzph)localObject1).zzyM());
      zza(localHashMap, "a", ((zzph)localObject1).zzyN());
      zzb(localHashMap, "dr", ((zzph)localObject1).zzyO());
    }
    localObject1 = (zzpf)paramzzc.zzd(zzpf.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ec", ((zzpf)localObject1).zzyJ());
      zzb(localHashMap, "ea", ((zzpf)localObject1).getAction());
      zzb(localHashMap, "el", ((zzpf)localObject1).getLabel());
      zza(localHashMap, "ev", ((zzpf)localObject1).getValue());
    }
    localObject1 = (zzpc)paramzzc.zzd(zzpc.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cn", ((zzpc)localObject1).getName());
      zzb(localHashMap, "cs", ((zzpc)localObject1).getSource());
      zzb(localHashMap, "cm", ((zzpc)localObject1).zzyu());
      zzb(localHashMap, "ck", ((zzpc)localObject1).zzyv());
      zzb(localHashMap, "cc", ((zzpc)localObject1).getContent());
      zzb(localHashMap, "ci", ((zzpc)localObject1).getId());
      zzb(localHashMap, "anid", ((zzpc)localObject1).zzyw());
      zzb(localHashMap, "gclid", ((zzpc)localObject1).zzyx());
      zzb(localHashMap, "dclid", ((zzpc)localObject1).zzyy());
      zzb(localHashMap, "aclid", ((zzpc)localObject1).zzyz());
    }
    localObject1 = (zzpg)paramzzc.zzd(zzpg.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "exd", ((zzpg)localObject1).getDescription());
      zza(localHashMap, "exf", ((zzpg)localObject1).zzyK());
    }
    localObject1 = (zzpi)paramzzc.zzd(zzpi.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "sn", ((zzpi)localObject1).zzyQ());
      zzb(localHashMap, "sa", ((zzpi)localObject1).getAction());
      zzb(localHashMap, "st", ((zzpi)localObject1).getTarget());
    }
    localObject1 = (zzpj)paramzzc.zzd(zzpj.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "utv", ((zzpj)localObject1).zzyR());
      zza(localHashMap, "utt", ((zzpj)localObject1).getTimeInMillis());
      zzb(localHashMap, "utc", ((zzpj)localObject1).zzyJ());
      zzb(localHashMap, "utl", ((zzpj)localObject1).getLabel());
    }
    localObject1 = (zzjl)paramzzc.zzd(zzjl.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzjl)localObject1).zzhX().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzQ(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, ((Map.Entry)localObject2).getValue());
        }
      }
    }
    localObject1 = (zzjm)paramzzc.zzd(zzjm.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzjm)localObject1).zzhY().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = zzc.zzS(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, zzb(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    localObject1 = (zzpe)paramzzc.zzd(zzpe.class);
    if (localObject1 != null)
    {
      localObject2 = ((zzpe)localObject1).zzyF();
      if (localObject2 != null)
      {
        localObject2 = ((ProductAction)localObject2).build().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((String)((Map.Entry)localObject3).getKey()).startsWith("&")) {
            localHashMap.put(((String)((Map.Entry)localObject3).getKey()).substring(1), ((Map.Entry)localObject3).getValue());
          } else {
            localHashMap.put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          }
        }
      }
      localObject2 = ((zzpe)localObject1).zzyI().iterator();
      int i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject2).next()).zzaX(zzc.zzW(i)));
        i += 1;
      }
      localObject2 = ((zzpe)localObject1).zzyG().iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject2).next()).zzaX(zzc.zzU(i)));
        i += 1;
      }
      localObject1 = ((zzpe)localObject1).zzyH().entrySet().iterator();
      i = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        Object localObject4 = (List)((Map.Entry)localObject2).getValue();
        localObject3 = zzc.zzZ(i);
        localObject4 = ((List)localObject4).iterator();
        int j = 1;
        while (((Iterator)localObject4).hasNext())
        {
          localHashMap.putAll(((Product)((Iterator)localObject4).next()).zzaX((String)localObject3 + zzc.zzX(j)));
          j += 1;
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getKey())) {
          localHashMap.put((String)localObject3 + "nm", ((Map.Entry)localObject2).getKey());
        }
        i += 1;
      }
    }
    localObject1 = (zzpd)paramzzc.zzd(zzpd.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ul", ((zzpd)localObject1).getLanguage());
      zza(localHashMap, "sd", ((zzpd)localObject1).zzyA());
      zza(localHashMap, "sr", ((zzpd)localObject1).zzyB(), ((zzpd)localObject1).zzyC());
      zza(localHashMap, "vp", ((zzpd)localObject1).zzyD(), ((zzpd)localObject1).zzyE());
    }
    paramzzc = (zzpb)paramzzc.zzd(zzpb.class);
    if (paramzzc != null)
    {
      zzb(localHashMap, "an", paramzzc.zzkp());
      zzb(localHashMap, "aid", paramzzc.zzuM());
      zzb(localHashMap, "aiid", paramzzc.zzyt());
      zzb(localHashMap, "av", paramzzc.zzkr());
    }
    return localHashMap;
  }
  
  private static String zzh(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
      str = (String)paramObject;
      paramObject = str;
    } while (!TextUtils.isEmpty(str));
    return null;
    if ((paramObject instanceof Double))
    {
      paramObject = (Double)paramObject;
      if (((Double)paramObject).doubleValue() != 0.0D) {
        return zzb(((Double)paramObject).doubleValue());
      }
      return null;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject != Boolean.FALSE) {
        return "1";
      }
      return null;
    }
    return String.valueOf(paramObject);
  }
  
  public void zzb(com.google.android.gms.measurement.zzc paramzzc)
  {
    zzx.zzw(paramzzc);
    zzx.zzb(paramzzc.zzyj(), "Can't deliver not submitted measurement");
    zzx.zzcj("deliver should be called on worker thread");
    Object localObject2 = paramzzc.zzye();
    Object localObject1 = (zzjo)((com.google.android.gms.measurement.zzc)localObject2).zze(zzjo.class);
    if (TextUtils.isEmpty(((zzjo)localObject1).zzia())) {
      zziu().zzh(zzc((com.google.android.gms.measurement.zzc)localObject2), "Ignoring measurement without type");
    }
    do
    {
      return;
      if (TextUtils.isEmpty(((zzjo)localObject1).getClientId()))
      {
        zziu().zzh(zzc((com.google.android.gms.measurement.zzc)localObject2), "Ignoring measurement without client id");
        return;
      }
    } while (this.zzLf.zziI().getAppOptOut());
    double d = ((zzjo)localObject1).zzif();
    if (zzam.zza(d, ((zzjo)localObject1).getClientId()))
    {
      zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
      return;
    }
    localObject2 = zzc((com.google.android.gms.measurement.zzc)localObject2);
    ((Map)localObject2).put("v", "1");
    ((Map)localObject2).put("_v", zze.zzMH);
    ((Map)localObject2).put("tid", this.zzLq);
    if (this.zzLf.zziI().isDryRunEnabled())
    {
      zzc("Dry run is enabled. GoogleAnalytics would have sent", zzA((Map)localObject2));
      return;
    }
    HashMap localHashMap = new HashMap();
    zzam.zzc(localHashMap, "uid", ((zzjo)localObject1).getUserId());
    Object localObject3 = (zzpb)paramzzc.zzd(zzpb.class);
    if (localObject3 != null)
    {
      zzam.zzc(localHashMap, "an", ((zzpb)localObject3).zzkp());
      zzam.zzc(localHashMap, "aid", ((zzpb)localObject3).zzuM());
      zzam.zzc(localHashMap, "av", ((zzpb)localObject3).zzkr());
      zzam.zzc(localHashMap, "aiid", ((zzpb)localObject3).zzyt());
    }
    localObject3 = ((zzjo)localObject1).getClientId();
    String str = this.zzLq;
    if (!TextUtils.isEmpty(((zzjo)localObject1).zzib())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new zzh(0L, (String)localObject3, str, bool, 0L, localHashMap);
      ((Map)localObject2).put("_s", String.valueOf(zzhP().zza((zzh)localObject1)));
      paramzzc = new zzab(zziu(), (Map)localObject2, paramzzc.zzyh(), true);
      zzhP().zza(paramzzc);
      return;
    }
  }
  
  public Uri zzhI()
  {
    return this.zzLr;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */