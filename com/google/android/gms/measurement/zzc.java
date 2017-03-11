package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzc
{
  private final zzf zzaKP;
  private boolean zzaKQ;
  private long zzaKR;
  private long zzaKS;
  private long zzaKT;
  private long zzaKU;
  private long zzaKV;
  private boolean zzaKW;
  private final Map<Class<? extends zze>, zze> zzaKX;
  private final List<zzi> zzaKY;
  private final zzmn zzpW;
  
  zzc(zzc paramzzc)
  {
    this.zzaKP = paramzzc.zzaKP;
    this.zzpW = paramzzc.zzpW;
    this.zzaKR = paramzzc.zzaKR;
    this.zzaKS = paramzzc.zzaKS;
    this.zzaKT = paramzzc.zzaKT;
    this.zzaKU = paramzzc.zzaKU;
    this.zzaKV = paramzzc.zzaKV;
    this.zzaKY = new ArrayList(paramzzc.zzaKY);
    this.zzaKX = new HashMap(paramzzc.zzaKX.size());
    paramzzc = paramzzc.zzaKX.entrySet().iterator();
    while (paramzzc.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzzc.next();
      zze localzze = zzf((Class)localEntry.getKey());
      ((zze)localEntry.getValue()).zza(localzze);
      this.zzaKX.put(localEntry.getKey(), localzze);
    }
  }
  
  zzc(zzf paramzzf, zzmn paramzzmn)
  {
    zzx.zzw(paramzzf);
    zzx.zzw(paramzzmn);
    this.zzaKP = paramzzf;
    this.zzpW = paramzzmn;
    this.zzaKU = 1800000L;
    this.zzaKV = 3024000000L;
    this.zzaKX = new HashMap();
    this.zzaKY = new ArrayList();
  }
  
  private static <T extends zze> T zzf(Class<T> paramClass)
  {
    try
    {
      paramClass = (zze)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
    }
  }
  
  public void zzL(long paramLong)
  {
    this.zzaKS = paramLong;
  }
  
  public void zzb(zze paramzze)
  {
    zzx.zzw(paramzze);
    Class localClass = paramzze.getClass();
    if (localClass.getSuperclass() != zze.class) {
      throw new IllegalArgumentException();
    }
    paramzze.zza(zze(localClass));
  }
  
  public <T extends zze> T zzd(Class<T> paramClass)
  {
    return (zze)this.zzaKX.get(paramClass);
  }
  
  public <T extends zze> T zze(Class<T> paramClass)
  {
    zze localzze2 = (zze)this.zzaKX.get(paramClass);
    zze localzze1 = localzze2;
    if (localzze2 == null)
    {
      localzze1 = zzf(paramClass);
      this.zzaKX.put(paramClass, localzze1);
    }
    return localzze1;
  }
  
  public zzc zzye()
  {
    return new zzc(this);
  }
  
  public Collection<zze> zzyf()
  {
    return this.zzaKX.values();
  }
  
  public List<zzi> zzyg()
  {
    return this.zzaKY;
  }
  
  public long zzyh()
  {
    return this.zzaKR;
  }
  
  public void zzyi()
  {
    zzym().zze(this);
  }
  
  public boolean zzyj()
  {
    return this.zzaKQ;
  }
  
  void zzyk()
  {
    this.zzaKT = this.zzpW.elapsedRealtime();
    if (this.zzaKS != 0L) {}
    for (this.zzaKR = this.zzaKS;; this.zzaKR = this.zzpW.currentTimeMillis())
    {
      this.zzaKQ = true;
      return;
    }
  }
  
  zzf zzyl()
  {
    return this.zzaKP;
  }
  
  zzg zzym()
  {
    return this.zzaKP.zzym();
  }
  
  boolean zzyn()
  {
    return this.zzaKW;
  }
  
  void zzyo()
  {
    this.zzaKW = true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */