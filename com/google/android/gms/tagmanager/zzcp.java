package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrb.zza;
import com.google.android.gms.internal.zzrb.zzc;
import com.google.android.gms.internal.zzrb.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcp
{
  private static final zzbw<zzag.zza> zzaYu = new zzbw(zzdf.zzDX(), true);
  private final DataLayer zzaVR;
  private final zzl<zzrb.zza, zzbw<zzag.zza>> zzaYA;
  private final zzl<String, zzb> zzaYB;
  private final Set<zzrb.zze> zzaYC;
  private final Map<String, zzc> zzaYD;
  private volatile String zzaYE;
  private int zzaYF;
  private final zzrb.zzc zzaYv;
  private final zzah zzaYw;
  private final Map<String, zzak> zzaYx;
  private final Map<String, zzak> zzaYy;
  private final Map<String, zzak> zzaYz;
  
  public zzcp(Context paramContext, zzrb.zzc paramzzc, DataLayer paramDataLayer, zzt.zza paramzza1, zzt.zza paramzza2, zzah paramzzah)
  {
    if (paramzzc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.zzaYv = paramzzc;
    this.zzaYC = new HashSet(paramzzc.zzEd());
    this.zzaVR = paramDataLayer;
    this.zzaYw = paramzzah;
    paramzzc = new zzm.zza()
    {
      public int zza(zzrb.zza paramAnonymouszza, zzbw<zzag.zza> paramAnonymouszzbw)
      {
        return ((zzag.zza)paramAnonymouszzbw.getObject()).zzFQ();
      }
    };
    this.zzaYA = new zzm().zza(1048576, paramzzc);
    paramzzc = new zzm.zza()
    {
      public int zza(String paramAnonymousString, zzcp.zzb paramAnonymouszzb)
      {
        return paramAnonymousString.length() + paramAnonymouszzb.getSize();
      }
    };
    this.zzaYB = new zzm().zza(1048576, paramzzc);
    this.zzaYx = new HashMap();
    zzb(new zzj(paramContext));
    zzb(new zzt(paramzza2));
    zzb(new zzx(paramDataLayer));
    zzb(new zzdg(paramContext, paramDataLayer));
    zzb(new zzdb(paramContext, paramDataLayer));
    this.zzaYy = new HashMap();
    zzc(new zzr());
    zzc(new zzae());
    zzc(new zzaf());
    zzc(new zzam());
    zzc(new zzan());
    zzc(new zzbc());
    zzc(new zzbd());
    zzc(new zzcf());
    zzc(new zzcy());
    this.zzaYz = new HashMap();
    zza(new zzb(paramContext));
    zza(new zzc(paramContext));
    zza(new zze(paramContext));
    zza(new zzf(paramContext));
    zza(new zzg(paramContext));
    zza(new zzh(paramContext));
    zza(new zzi(paramContext));
    zza(new zzn());
    zza(new zzq(this.zzaYv.getVersion()));
    zza(new zzt(paramzza1));
    zza(new zzv(paramDataLayer));
    zza(new zzaa(paramContext));
    zza(new zzab());
    zza(new zzad());
    zza(new zzai(this));
    zza(new zzao());
    zza(new zzap());
    zza(new zzaw(paramContext));
    zza(new zzay());
    zza(new zzbb());
    zza(new zzbi());
    zza(new zzbk(paramContext));
    zza(new zzbx());
    zza(new zzbz());
    zza(new zzcc());
    zza(new zzce());
    zza(new zzcg(paramContext));
    zza(new zzcq());
    zza(new zzcr());
    zza(new zzda());
    zza(new zzdh());
    this.zzaYD = new HashMap();
    paramDataLayer = this.zzaYC.iterator();
    while (paramDataLayer.hasNext())
    {
      paramzza1 = (zzrb.zze)paramDataLayer.next();
      if (paramzzah.zzCS())
      {
        zza(paramzza1.zzEl(), paramzza1.zzEm(), "add macro");
        zza(paramzza1.zzEq(), paramzza1.zzEn(), "remove macro");
        zza(paramzza1.zzEj(), paramzza1.zzEo(), "add tag");
        zza(paramzza1.zzEk(), paramzza1.zzEp(), "remove tag");
      }
      int i = 0;
      while (i < paramzza1.zzEl().size())
      {
        paramzza2 = (zzrb.zza)paramzza1.zzEl().get(i);
        paramzzc = "Unknown";
        paramContext = paramzzc;
        if (paramzzah.zzCS())
        {
          paramContext = paramzzc;
          if (i < paramzza1.zzEm().size()) {
            paramContext = (String)paramzza1.zzEm().get(i);
          }
        }
        paramzzc = zzi(this.zzaYD, zza(paramzza2));
        paramzzc.zza(paramzza1);
        paramzzc.zza(paramzza1, paramzza2);
        paramzzc.zza(paramzza1, paramContext);
        i += 1;
      }
      i = 0;
      while (i < paramzza1.zzEq().size())
      {
        paramzza2 = (zzrb.zza)paramzza1.zzEq().get(i);
        paramzzc = "Unknown";
        paramContext = paramzzc;
        if (paramzzah.zzCS())
        {
          paramContext = paramzzc;
          if (i < paramzza1.zzEn().size()) {
            paramContext = (String)paramzza1.zzEn().get(i);
          }
        }
        paramzzc = zzi(this.zzaYD, zza(paramzza2));
        paramzzc.zza(paramzza1);
        paramzzc.zzb(paramzza1, paramzza2);
        paramzzc.zzb(paramzza1, paramContext);
        i += 1;
      }
    }
    paramContext = this.zzaYv.zzEe().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramzzc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramzza1 = (zzrb.zza)paramDataLayer.next();
        if (!zzdf.zzk((zzag.zza)paramzza1.zzEa().get(com.google.android.gms.internal.zzae.zzfW.toString())).booleanValue()) {
          zzi(this.zzaYD, (String)paramzzc.getKey()).zzb(paramzza1);
        }
      }
    }
  }
  
  private String zzDx()
  {
    if (this.zzaYF <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.zzaYF));
    int i = 2;
    while (i < this.zzaYF)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  private zzbw<zzag.zza> zza(zzag.zza paramzza, Set<String> paramSet, zzdi paramzzdi)
  {
    if (!paramzza.zzje) {
      return new zzbw(paramzza, true);
    }
    zzbw localzzbw1;
    switch (paramzza.type)
    {
    case 5: 
    case 6: 
    default: 
      zzbg.e("Unknown type: " + paramzza.type);
      return zzaYu;
    case 2: 
      localzza = zzrb.zzo(paramzza);
      localzza.zziV = new zzag.zza[paramzza.zziV.length];
      i = 0;
      while (i < paramzza.zziV.length)
      {
        localzzbw1 = zza(paramzza.zziV[i], paramSet, paramzzdi.zzjv(i));
        if (localzzbw1 == zzaYu) {
          return zzaYu;
        }
        localzza.zziV[i] = ((zzag.zza)localzzbw1.getObject());
        i += 1;
      }
      return new zzbw(localzza, false);
    case 3: 
      localzza = zzrb.zzo(paramzza);
      if (paramzza.zziW.length != paramzza.zziX.length)
      {
        zzbg.e("Invalid serving value: " + paramzza.toString());
        return zzaYu;
      }
      localzza.zziW = new zzag.zza[paramzza.zziW.length];
      localzza.zziX = new zzag.zza[paramzza.zziW.length];
      i = 0;
      while (i < paramzza.zziW.length)
      {
        localzzbw1 = zza(paramzza.zziW[i], paramSet, paramzzdi.zzjw(i));
        zzbw localzzbw2 = zza(paramzza.zziX[i], paramSet, paramzzdi.zzjx(i));
        if ((localzzbw1 == zzaYu) || (localzzbw2 == zzaYu)) {
          return zzaYu;
        }
        localzza.zziW[i] = ((zzag.zza)localzzbw1.getObject());
        localzza.zziX[i] = ((zzag.zza)localzzbw2.getObject());
        i += 1;
      }
      return new zzbw(localzza, false);
    case 4: 
      if (paramSet.contains(paramzza.zziY))
      {
        zzbg.e("Macro cycle detected.  Current macro reference: " + paramzza.zziY + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return zzaYu;
      }
      paramSet.add(paramzza.zziY);
      paramzzdi = zzdj.zza(zza(paramzza.zziY, paramSet, paramzzdi.zzDg()), paramzza.zzjd);
      paramSet.remove(paramzza.zziY);
      return paramzzdi;
    }
    zzag.zza localzza = zzrb.zzo(paramzza);
    localzza.zzjc = new zzag.zza[paramzza.zzjc.length];
    int i = 0;
    while (i < paramzza.zzjc.length)
    {
      localzzbw1 = zza(paramzza.zzjc[i], paramSet, paramzzdi.zzjy(i));
      if (localzzbw1 == zzaYu) {
        return zzaYu;
      }
      localzza.zzjc[i] = ((zzag.zza)localzzbw1.getObject());
      i += 1;
    }
    return new zzbw(localzza, false);
  }
  
  private zzbw<zzag.zza> zza(String paramString, Set<String> paramSet, zzbj paramzzbj)
  {
    this.zzaYF += 1;
    Object localObject = (zzb)this.zzaYB.get(paramString);
    if ((localObject != null) && (!this.zzaYw.zzCS()))
    {
      zza(((zzb)localObject).zzDz(), paramSet);
      this.zzaYF -= 1;
      return ((zzb)localObject).zzDy();
    }
    localObject = (zzc)this.zzaYD.get(paramString);
    if (localObject == null)
    {
      zzbg.e(zzDx() + "Invalid macro: " + paramString);
      this.zzaYF -= 1;
      return zzaYu;
    }
    zzbw localzzbw = zza(paramString, ((zzc)localObject).zzDA(), ((zzc)localObject).zzDB(), ((zzc)localObject).zzDC(), ((zzc)localObject).zzDE(), ((zzc)localObject).zzDD(), paramSet, paramzzbj.zzCI());
    if (((Set)localzzbw.getObject()).isEmpty()) {}
    for (localObject = ((zzc)localObject).zzDF(); localObject == null; localObject = (zzrb.zza)((Set)localzzbw.getObject()).iterator().next())
    {
      this.zzaYF -= 1;
      return zzaYu;
      if (((Set)localzzbw.getObject()).size() > 1) {
        zzbg.zzaH(zzDx() + "Multiple macros active for macroName " + paramString);
      }
    }
    paramzzbj = zza(this.zzaYz, (zzrb.zza)localObject, paramSet, paramzzbj.zzCY());
    boolean bool;
    if ((localzzbw.zzDh()) && (paramzzbj.zzDh()))
    {
      bool = true;
      if (paramzzbj != zzaYu) {
        break label392;
      }
    }
    label392:
    for (paramzzbj = zzaYu;; paramzzbj = new zzbw(paramzzbj.getObject(), bool))
    {
      localObject = ((zzrb.zza)localObject).zzDz();
      if (paramzzbj.zzDh()) {
        this.zzaYB.zzf(paramString, new zzb(paramzzbj, (zzag.zza)localObject));
      }
      zza((zzag.zza)localObject, paramSet);
      this.zzaYF -= 1;
      return paramzzbj;
      bool = false;
      break;
    }
  }
  
  private zzbw<zzag.zza> zza(Map<String, zzak> paramMap, zzrb.zza paramzza, Set<String> paramSet, zzch paramzzch)
  {
    boolean bool = true;
    Object localObject1 = (zzag.zza)paramzza.zzEa().get(com.google.android.gms.internal.zzae.zzfj.toString());
    if (localObject1 == null)
    {
      zzbg.e("No function id in properties");
      paramMap = zzaYu;
    }
    zzak localzzak;
    do
    {
      return paramMap;
      localObject1 = ((zzag.zza)localObject1).zziZ;
      localzzak = (zzak)paramMap.get(localObject1);
      if (localzzak == null)
      {
        zzbg.e((String)localObject1 + " has no backing implementation.");
        return zzaYu;
      }
      paramMap = (zzbw)this.zzaYA.get(paramzza);
    } while ((paramMap != null) && (!this.zzaYw.zzCS()));
    paramMap = new HashMap();
    Iterator localIterator = paramzza.zzEa().entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramzzch.zzeU((String)localEntry.getKey());
      localObject2 = zza((zzag.zza)localEntry.getValue(), paramSet, ((zzcj)localObject2).zze((zzag.zza)localEntry.getValue()));
      if (localObject2 == zzaYu) {
        return zzaYu;
      }
      if (((zzbw)localObject2).zzDh()) {
        paramzza.zza((String)localEntry.getKey(), (zzag.zza)((zzbw)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((zzbw)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localzzak.zzf(paramMap.keySet()))
    {
      zzbg.e("Incorrect keys for function " + (String)localObject1 + " required " + localzzak.zzCU() + " had " + paramMap.keySet());
      return zzaYu;
    }
    if ((i != 0) && (localzzak.zzCo())) {}
    for (;;)
    {
      paramMap = new zzbw(localzzak.zzI(paramMap), bool);
      if (bool) {
        this.zzaYA.zzf(paramzza, paramMap);
      }
      paramzzch.zzd((zzag.zza)paramMap.getObject());
      return paramMap;
      bool = false;
    }
  }
  
  private zzbw<Set<zzrb.zza>> zza(Set<zzrb.zze> paramSet, Set<String> paramSet1, zza paramzza, zzco paramzzco)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      zzrb.zze localzze = (zzrb.zze)paramSet.next();
      zzck localzzck = paramzzco.zzDf();
      zzbw localzzbw = zza(localzze, paramSet1, localzzck);
      if (((Boolean)localzzbw.getObject()).booleanValue()) {
        paramzza.zza(localzze, localHashSet1, localHashSet2, localzzck);
      }
      if ((bool) && (localzzbw.zzDh())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramzzco.zzg(localHashSet1);
    return new zzbw(localHashSet1, bool);
  }
  
  private static String zza(zzrb.zza paramzza)
  {
    return zzdf.zzg((zzag.zza)paramzza.zzEa().get(com.google.android.gms.internal.zzae.zzfu.toString()));
  }
  
  private void zza(zzag.zza paramzza, Set<String> paramSet)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      paramzza = zza(paramzza, paramSet, new zzbu());
      if (paramzza != zzaYu)
      {
        paramzza = zzdf.zzl((zzag.zza)paramzza.getObject());
        if ((paramzza instanceof Map))
        {
          paramzza = (Map)paramzza;
          this.zzaVR.push(paramzza);
          return;
        }
        if (!(paramzza instanceof List)) {
          break;
        }
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          paramSet = paramzza.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.zzaVR.push(paramSet);
          }
          else
          {
            zzbg.zzaH("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    zzbg.zzaH("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void zza(List<zzrb.zza> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      zzbg.zzaG("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void zza(Map<String, zzak> paramMap, zzak paramzzak)
  {
    if (paramMap.containsKey(paramzzak.zzCT())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramzzak.zzCT());
    }
    paramMap.put(paramzzak.zzCT(), paramzzak);
  }
  
  private static zzc zzi(Map<String, zzc> paramMap, String paramString)
  {
    zzc localzzc2 = (zzc)paramMap.get(paramString);
    zzc localzzc1 = localzzc2;
    if (localzzc2 == null)
    {
      localzzc1 = new zzc();
      paramMap.put(paramString, localzzc1);
    }
    return localzzc1;
  }
  
  public void zzA(List<zzaf.zzi> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        zzaf.zzi localzzi = (zzaf.zzi)paramList.next();
        if ((localzzi.name == null) || (!localzzi.name.startsWith("gaExperiment:"))) {
          zzbg.v("Ignored supplemental: " + localzzi);
        } else {
          zzaj.zza(this.zzaVR, localzzi);
        }
      }
      finally {}
    }
  }
  
  String zzDw()
  {
    try
    {
      String str = this.zzaYE;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  zzbw<Boolean> zza(zzrb.zza paramzza, Set<String> paramSet, zzch paramzzch)
  {
    paramzza = zza(this.zzaYy, paramzza, paramSet, paramzzch);
    paramSet = zzdf.zzk((zzag.zza)paramzza.getObject());
    paramzzch.zzd(zzdf.zzQ(paramSet));
    return new zzbw(paramSet, paramzza.zzDh());
  }
  
  zzbw<Boolean> zza(zzrb.zze paramzze, Set<String> paramSet, zzck paramzzck)
  {
    Object localObject = paramzze.zzEi().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      zzbw localzzbw = zza((zzrb.zza)((Iterator)localObject).next(), paramSet, paramzzck.zzCZ());
      if (((Boolean)localzzbw.getObject()).booleanValue())
      {
        paramzzck.zzf(zzdf.zzQ(Boolean.valueOf(false)));
        return new zzbw(Boolean.valueOf(false), localzzbw.zzDh());
      }
      if ((bool) && (localzzbw.zzDh())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramzze = paramzze.zzEh().iterator();
    while (paramzze.hasNext())
    {
      localObject = zza((zzrb.zza)paramzze.next(), paramSet, paramzzck.zzDa());
      if (!((Boolean)((zzbw)localObject).getObject()).booleanValue())
      {
        paramzzck.zzf(zzdf.zzQ(Boolean.valueOf(false)));
        return new zzbw(Boolean.valueOf(false), ((zzbw)localObject).zzDh());
      }
      if ((bool) && (((zzbw)localObject).zzDh())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramzzck.zzf(zzdf.zzQ(Boolean.valueOf(true)));
    return new zzbw(Boolean.valueOf(true), bool);
  }
  
  zzbw<Set<zzrb.zza>> zza(String paramString, Set<zzrb.zze> paramSet, final Map<zzrb.zze, List<zzrb.zza>> paramMap1, final Map<zzrb.zze, List<String>> paramMap2, final Map<zzrb.zze, List<zzrb.zza>> paramMap3, final Map<zzrb.zze, List<String>> paramMap4, Set<String> paramSet1, zzco paramzzco)
  {
    zza(paramSet, paramSet1, new zza()
    {
      public void zza(zzrb.zze paramAnonymouszze, Set<zzrb.zza> paramAnonymousSet1, Set<zzrb.zza> paramAnonymousSet2, zzck paramAnonymouszzck)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouszze);
        List localList2 = (List)paramMap2.get(paramAnonymouszze);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouszzck.zzDb().zzc(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouszze);
        paramAnonymouszze = (List)paramMap4.get(paramAnonymouszze);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouszzck.zzDc().zzc(paramAnonymousSet1, paramAnonymouszze);
        }
      }
    }, paramzzco);
  }
  
  zzbw<Set<zzrb.zza>> zza(Set<zzrb.zze> paramSet, zzco paramzzco)
  {
    zza(paramSet, new HashSet(), new zza()
    {
      public void zza(zzrb.zze paramAnonymouszze, Set<zzrb.zza> paramAnonymousSet1, Set<zzrb.zza> paramAnonymousSet2, zzck paramAnonymouszzck)
      {
        paramAnonymousSet1.addAll(paramAnonymouszze.zzEj());
        paramAnonymousSet2.addAll(paramAnonymouszze.zzEk());
        paramAnonymouszzck.zzDd().zzc(paramAnonymouszze.zzEj(), paramAnonymouszze.zzEo());
        paramAnonymouszzck.zzDe().zzc(paramAnonymouszze.zzEk(), paramAnonymouszze.zzEp());
      }
    }, paramzzco);
  }
  
  void zza(zzak paramzzak)
  {
    zza(this.zzaYz, paramzzak);
  }
  
  void zzb(zzak paramzzak)
  {
    zza(this.zzaYx, paramzzak);
  }
  
  void zzc(zzak paramzzak)
  {
    zza(this.zzaYy, paramzzak);
  }
  
  public void zzeC(String paramString)
  {
    try
    {
      zzeZ(paramString);
      paramString = this.zzaYw.zzeP(paramString);
      zzu localzzu = paramString.zzCQ();
      Iterator localIterator = ((Set)zza(this.zzaYC, localzzu.zzCI()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        zzrb.zza localzza = (zzrb.zza)localIterator.next();
        zza(this.zzaYx, localzza, new HashSet(), localzzu.zzCH());
      }
      paramString.zzCR();
    }
    finally {}
    zzeZ(null);
  }
  
  public zzbw<zzag.zza> zzeY(String paramString)
  {
    this.zzaYF = 0;
    zzag localzzag = this.zzaYw.zzeO(paramString);
    paramString = zza(paramString, new HashSet(), localzzag.zzCP());
    localzzag.zzCR();
    return paramString;
  }
  
  void zzeZ(String paramString)
  {
    try
    {
      this.zzaYE = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zza(zzrb.zze paramzze, Set<zzrb.zza> paramSet1, Set<zzrb.zza> paramSet2, zzck paramzzck);
  }
  
  private static class zzb
  {
    private zzbw<zzag.zza> zzaYL;
    private zzag.zza zzaYM;
    
    public zzb(zzbw<zzag.zza> paramzzbw, zzag.zza paramzza)
    {
      this.zzaYL = paramzzbw;
      this.zzaYM = paramzza;
    }
    
    public int getSize()
    {
      int j = ((zzag.zza)this.zzaYL.getObject()).zzFQ();
      if (this.zzaYM == null) {}
      for (int i = 0;; i = this.zzaYM.zzFQ()) {
        return i + j;
      }
    }
    
    public zzbw<zzag.zza> zzDy()
    {
      return this.zzaYL;
    }
    
    public zzag.zza zzDz()
    {
      return this.zzaYM;
    }
  }
  
  private static class zzc
  {
    private final Set<zzrb.zze> zzaYC = new HashSet();
    private final Map<zzrb.zze, List<zzrb.zza>> zzaYN = new HashMap();
    private final Map<zzrb.zze, List<zzrb.zza>> zzaYO = new HashMap();
    private final Map<zzrb.zze, List<String>> zzaYP = new HashMap();
    private final Map<zzrb.zze, List<String>> zzaYQ = new HashMap();
    private zzrb.zza zzaYR;
    
    public Set<zzrb.zze> zzDA()
    {
      return this.zzaYC;
    }
    
    public Map<zzrb.zze, List<zzrb.zza>> zzDB()
    {
      return this.zzaYN;
    }
    
    public Map<zzrb.zze, List<String>> zzDC()
    {
      return this.zzaYP;
    }
    
    public Map<zzrb.zze, List<String>> zzDD()
    {
      return this.zzaYQ;
    }
    
    public Map<zzrb.zze, List<zzrb.zza>> zzDE()
    {
      return this.zzaYO;
    }
    
    public zzrb.zza zzDF()
    {
      return this.zzaYR;
    }
    
    public void zza(zzrb.zze paramzze)
    {
      this.zzaYC.add(paramzze);
    }
    
    public void zza(zzrb.zze paramzze, zzrb.zza paramzza)
    {
      List localList = (List)this.zzaYN.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzaYN.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zza(zzrb.zze paramzze, String paramString)
    {
      List localList = (List)this.zzaYP.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzaYP.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void zzb(zzrb.zza paramzza)
    {
      this.zzaYR = paramzza;
    }
    
    public void zzb(zzrb.zze paramzze, zzrb.zza paramzza)
    {
      List localList = (List)this.zzaYO.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzaYO.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zzb(zzrb.zze paramzze, String paramString)
    {
      List localList = (List)this.zzaYQ.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzaYQ.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */