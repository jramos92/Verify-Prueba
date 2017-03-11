package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzrb
{
  private static zzag.zza zza(int paramInt, zzaf.zzf paramzzf, zzag.zza[] paramArrayOfzza, Set<Integer> paramSet)
    throws zzrb.zzg
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      zzfn("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    zzag.zza localzza1 = (zzag.zza)zza(paramzzf.zzif, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null) {
      return paramArrayOfzza[paramInt];
    }
    Object localObject = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localzza1.type)
    {
    }
    for (;;)
    {
      if (localObject == null) {
        zzfn("Invalid value: " + localzza1);
      }
      paramArrayOfzza[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (zzag.zza)localObject;
      localObject = zzp(localzza1);
      zzag.zza localzza2 = zzo(localzza1);
      localzza2.zziV = new zzag.zza[((zzaf.zzh)localObject).zziG.length];
      int[] arrayOfInt = ((zzaf.zzh)localObject).zziG;
      k = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zziV[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localzza2 = zzo(localzza1);
      localObject = zzp(localzza1);
      if (((zzaf.zzh)localObject).zziH.length != ((zzaf.zzh)localObject).zziI.length) {
        zzfn("Uneven map keys (" + ((zzaf.zzh)localObject).zziH.length + ") and map values (" + ((zzaf.zzh)localObject).zziI.length + ")");
      }
      localzza2.zziW = new zzag.zza[((zzaf.zzh)localObject).zziH.length];
      localzza2.zziX = new zzag.zza[((zzaf.zzh)localObject).zziH.length];
      arrayOfInt = ((zzaf.zzh)localObject).zziH;
      m = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        localzza2.zziW[i] = zza(n, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((zzaf.zzh)localObject).zziI;
      m = arrayOfInt.length;
      i = 0;
      j = k;
      for (;;)
      {
        localObject = localzza2;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        localzza2.zziX[i] = zza(k, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = zzo(localzza1);
      ((zzag.zza)localObject).zziY = zzdf.zzg(zza(zzp(localzza1).zziL, paramzzf, paramArrayOfzza, paramSet));
      continue;
      localzza2 = zzo(localzza1);
      localObject = zzp(localzza1);
      localzza2.zzjc = new zzag.zza[((zzaf.zzh)localObject).zziK.length];
      arrayOfInt = ((zzaf.zzh)localObject).zziK;
      k = arrayOfInt.length;
      i = 0;
      j = m;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzjc[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = localzza1;
    }
  }
  
  private static zza zza(zzaf.zzb paramzzb, zzaf.zzf paramzzf, zzag.zza[] paramArrayOfzza, int paramInt)
    throws zzrb.zzg
  {
    zzb localzzb = zza.zzDZ();
    paramzzb = paramzzb.zzhQ;
    int i = paramzzb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramzzb[paramInt];
      Object localObject = (zzaf.zze)zza(paramzzf.zzig, Integer.valueOf(j).intValue(), "properties");
      String str = (String)zza(paramzzf.zzie, ((zzaf.zze)localObject).key, "keys");
      localObject = (zzag.zza)zza(paramArrayOfzza, ((zzaf.zze)localObject).value, "values");
      if (zzae.zzgv.toString().equals(str)) {
        localzzb.zzq((zzag.zza)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localzzb.zzb(str, (zzag.zza)localObject);
      }
    }
    return localzzb.zzEb();
  }
  
  private static zze zza(zzaf.zzg paramzzg, List<zza> paramList1, List<zza> paramList2, List<zza> paramList3, zzaf.zzf paramzzf)
  {
    zzf localzzf = zze.zzEg();
    int[] arrayOfInt = paramzzg.zziu;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localzzf.zzd((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramzzg.zziv;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localzzf.zze((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zziw;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzf((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zziy;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localzzf.zzfp(paramzzf.zzif[Integer.valueOf(k).intValue()].zziU);
      i += 1;
    }
    paramList3 = paramzzg.zzix;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzg((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zziz;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzfq(paramzzf.zzif[Integer.valueOf(k).intValue()].zziU);
      i += 1;
    }
    paramList1 = paramzzg.zziA;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzh((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zziC;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzfr(paramzzf.zzif[Integer.valueOf(k).intValue()].zziU);
      i += 1;
    }
    paramList1 = paramzzg.zziB;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzi((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramzzg = paramzzg.zziD;
    j = paramzzg.length;
    i = 0;
    while (i < j)
    {
      k = paramzzg[i];
      localzzf.zzfs(paramzzf.zzif[Integer.valueOf(k).intValue()].zziU);
      i += 1;
    }
    return localzzf.zzEr();
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
    throws zzrb.zzg
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzfn("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static zzc zzb(zzaf.zzf paramzzf)
    throws zzrb.zzg
  {
    int j = 0;
    Object localObject = new zzag.zza[paramzzf.zzif.length];
    int i = 0;
    while (i < paramzzf.zzif.length)
    {
      zza(i, paramzzf, (zzag.zza[])localObject, new HashSet(0));
      i += 1;
    }
    zzd localzzd = zzc.zzEc();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzii.length)
    {
      localArrayList1.add(zza(paramzzf.zzii[i], paramzzf, (zzag.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzij.length)
    {
      localArrayList2.add(zza(paramzzf.zzij[i], paramzzf, (zzag.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzih.length)
    {
      zza localzza = zza(paramzzf.zzih[i], paramzzf, (zzag.zza[])localObject, i);
      localzzd.zzc(localzza);
      localArrayList3.add(localzza);
      i += 1;
    }
    localObject = paramzzf.zzik;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      localzzd.zzb(zza(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramzzf));
      i += 1;
    }
    localzzd.zzfo(paramzzf.version);
    localzzd.zzjC(paramzzf.zzis);
    return localzzd.zzEf();
  }
  
  public static void zzb(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void zzfn(String paramString)
    throws zzrb.zzg
  {
    zzbg.e(paramString);
    throw new zzg(paramString);
  }
  
  public static zzag.zza zzo(zzag.zza paramzza)
  {
    zzag.zza localzza = new zzag.zza();
    localzza.type = paramzza.type;
    localzza.zzjd = ((int[])paramzza.zzjd.clone());
    if (paramzza.zzje) {
      localzza.zzje = paramzza.zzje;
    }
    return localzza;
  }
  
  private static zzaf.zzh zzp(zzag.zza paramzza)
    throws zzrb.zzg
  {
    if ((zzaf.zzh)paramzza.zza(zzaf.zzh.zziE) == null) {
      zzfn("Expected a ServingValue and didn't get one. Value is: " + paramzza);
    }
    return (zzaf.zzh)paramzza.zza(zzaf.zzh.zziE);
  }
  
  public static class zza
  {
    private final zzag.zza zzaYM;
    private final Map<String, zzag.zza> zzban;
    
    private zza(Map<String, zzag.zza> paramMap, zzag.zza paramzza)
    {
      this.zzban = paramMap;
      this.zzaYM = paramzza;
    }
    
    public static zzrb.zzb zzDZ()
    {
      return new zzrb.zzb(null);
    }
    
    public String toString()
    {
      return "Properties: " + zzEa() + " pushAfterEvaluate: " + this.zzaYM;
    }
    
    public zzag.zza zzDz()
    {
      return this.zzaYM;
    }
    
    public Map<String, zzag.zza> zzEa()
    {
      return Collections.unmodifiableMap(this.zzban);
    }
    
    public void zza(String paramString, zzag.zza paramzza)
    {
      this.zzban.put(paramString, paramzza);
    }
  }
  
  public static class zzb
  {
    private zzag.zza zzaYM;
    private final Map<String, zzag.zza> zzban = new HashMap();
    
    public zzrb.zza zzEb()
    {
      return new zzrb.zza(this.zzban, this.zzaYM, null);
    }
    
    public zzb zzb(String paramString, zzag.zza paramzza)
    {
      this.zzban.put(paramString, paramzza);
      return this;
    }
    
    public zzb zzq(zzag.zza paramzza)
    {
      this.zzaYM = paramzza;
      return this;
    }
  }
  
  public static class zzc
  {
    private final String zzYk;
    private final List<zzrb.zze> zzbao;
    private final Map<String, List<zzrb.zza>> zzbap;
    private final int zzbaq;
    
    private zzc(List<zzrb.zze> paramList, Map<String, List<zzrb.zza>> paramMap, String paramString, int paramInt)
    {
      this.zzbao = Collections.unmodifiableList(paramList);
      this.zzbap = Collections.unmodifiableMap(paramMap);
      this.zzYk = paramString;
      this.zzbaq = paramInt;
    }
    
    public static zzrb.zzd zzEc()
    {
      return new zzrb.zzd(null);
    }
    
    public String getVersion()
    {
      return this.zzYk;
    }
    
    public String toString()
    {
      return "Rules: " + zzEd() + "  Macros: " + this.zzbap;
    }
    
    public List<zzrb.zze> zzEd()
    {
      return this.zzbao;
    }
    
    public Map<String, List<zzrb.zza>> zzEe()
    {
      return this.zzbap;
    }
  }
  
  public static class zzd
  {
    private String zzYk = "";
    private final List<zzrb.zze> zzbao = new ArrayList();
    private final Map<String, List<zzrb.zza>> zzbap = new HashMap();
    private int zzbaq = 0;
    
    public zzrb.zzc zzEf()
    {
      return new zzrb.zzc(this.zzbao, this.zzbap, this.zzYk, this.zzbaq, null);
    }
    
    public zzd zzb(zzrb.zze paramzze)
    {
      this.zzbao.add(paramzze);
      return this;
    }
    
    public zzd zzc(zzrb.zza paramzza)
    {
      String str = zzdf.zzg((zzag.zza)paramzza.zzEa().get(zzae.zzfu.toString()));
      List localList = (List)this.zzbap.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzbap.put(str, localObject);
      }
      ((List)localObject).add(paramzza);
      return this;
    }
    
    public zzd zzfo(String paramString)
    {
      this.zzYk = paramString;
      return this;
    }
    
    public zzd zzjC(int paramInt)
    {
      this.zzbaq = paramInt;
      return this;
    }
  }
  
  public static class zze
  {
    private final List<String> zzbaA;
    private final List<zzrb.zza> zzbar;
    private final List<zzrb.zza> zzbas;
    private final List<zzrb.zza> zzbat;
    private final List<zzrb.zza> zzbau;
    private final List<zzrb.zza> zzbav;
    private final List<zzrb.zza> zzbaw;
    private final List<String> zzbax;
    private final List<String> zzbay;
    private final List<String> zzbaz;
    
    private zze(List<zzrb.zza> paramList1, List<zzrb.zza> paramList2, List<zzrb.zza> paramList3, List<zzrb.zza> paramList4, List<zzrb.zza> paramList5, List<zzrb.zza> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.zzbar = Collections.unmodifiableList(paramList1);
      this.zzbas = Collections.unmodifiableList(paramList2);
      this.zzbat = Collections.unmodifiableList(paramList3);
      this.zzbau = Collections.unmodifiableList(paramList4);
      this.zzbav = Collections.unmodifiableList(paramList5);
      this.zzbaw = Collections.unmodifiableList(paramList6);
      this.zzbax = Collections.unmodifiableList(paramList7);
      this.zzbay = Collections.unmodifiableList(paramList8);
      this.zzbaz = Collections.unmodifiableList(paramList9);
      this.zzbaA = Collections.unmodifiableList(paramList10);
    }
    
    public static zzrb.zzf zzEg()
    {
      return new zzrb.zzf(null);
    }
    
    public String toString()
    {
      return "Positive predicates: " + zzEh() + "  Negative predicates: " + zzEi() + "  Add tags: " + zzEj() + "  Remove tags: " + zzEk() + "  Add macros: " + zzEl() + "  Remove macros: " + zzEq();
    }
    
    public List<zzrb.zza> zzEh()
    {
      return this.zzbar;
    }
    
    public List<zzrb.zza> zzEi()
    {
      return this.zzbas;
    }
    
    public List<zzrb.zza> zzEj()
    {
      return this.zzbat;
    }
    
    public List<zzrb.zza> zzEk()
    {
      return this.zzbau;
    }
    
    public List<zzrb.zza> zzEl()
    {
      return this.zzbav;
    }
    
    public List<String> zzEm()
    {
      return this.zzbax;
    }
    
    public List<String> zzEn()
    {
      return this.zzbay;
    }
    
    public List<String> zzEo()
    {
      return this.zzbaz;
    }
    
    public List<String> zzEp()
    {
      return this.zzbaA;
    }
    
    public List<zzrb.zza> zzEq()
    {
      return this.zzbaw;
    }
  }
  
  public static class zzf
  {
    private final List<String> zzbaA = new ArrayList();
    private final List<zzrb.zza> zzbar = new ArrayList();
    private final List<zzrb.zza> zzbas = new ArrayList();
    private final List<zzrb.zza> zzbat = new ArrayList();
    private final List<zzrb.zza> zzbau = new ArrayList();
    private final List<zzrb.zza> zzbav = new ArrayList();
    private final List<zzrb.zza> zzbaw = new ArrayList();
    private final List<String> zzbax = new ArrayList();
    private final List<String> zzbay = new ArrayList();
    private final List<String> zzbaz = new ArrayList();
    
    public zzrb.zze zzEr()
    {
      return new zzrb.zze(this.zzbar, this.zzbas, this.zzbat, this.zzbau, this.zzbav, this.zzbaw, this.zzbax, this.zzbay, this.zzbaz, this.zzbaA, null);
    }
    
    public zzf zzd(zzrb.zza paramzza)
    {
      this.zzbar.add(paramzza);
      return this;
    }
    
    public zzf zze(zzrb.zza paramzza)
    {
      this.zzbas.add(paramzza);
      return this;
    }
    
    public zzf zzf(zzrb.zza paramzza)
    {
      this.zzbat.add(paramzza);
      return this;
    }
    
    public zzf zzfp(String paramString)
    {
      this.zzbaz.add(paramString);
      return this;
    }
    
    public zzf zzfq(String paramString)
    {
      this.zzbaA.add(paramString);
      return this;
    }
    
    public zzf zzfr(String paramString)
    {
      this.zzbax.add(paramString);
      return this;
    }
    
    public zzf zzfs(String paramString)
    {
      this.zzbay.add(paramString);
      return this;
    }
    
    public zzf zzg(zzrb.zza paramzza)
    {
      this.zzbau.add(paramzza);
      return this;
    }
    
    public zzf zzh(zzrb.zza paramzza)
    {
      this.zzbav.add(paramzza);
      return this;
    }
    
    public zzf zzi(zzrb.zza paramzza)
    {
      this.zzbaw.add(paramzza);
      return this;
    }
  }
  
  public static class zzg
    extends Exception
  {
    public zzg(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */