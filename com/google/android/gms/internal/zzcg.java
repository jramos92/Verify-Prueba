package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class zzcg
{
  private final Object zzpd = new Object();
  boolean zzvA;
  private final List<zzce> zzvR = new LinkedList();
  private final Map<String, String> zzvS = new LinkedHashMap();
  private String zzvT;
  private zzce zzvU;
  private zzcg zzvV;
  
  public zzcg(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.zzvA = paramBoolean;
    this.zzvS.put("action", paramString1);
    this.zzvS.put("ad_format", paramString2);
  }
  
  public void zzT(String paramString)
  {
    if (!this.zzvA) {
      return;
    }
    synchronized (this.zzpd)
    {
      this.zzvT = paramString;
      return;
    }
  }
  
  public boolean zza(zzce paramzzce, long paramLong, String... paramVarArgs)
  {
    synchronized (this.zzpd)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        zzce localzzce = new zzce(paramLong, paramVarArgs[i], paramzzce);
        this.zzvR.add(localzzce);
        i += 1;
      }
      return true;
    }
  }
  
  public boolean zza(zzce paramzzce, String... paramVarArgs)
  {
    if ((!this.zzvA) || (paramzzce == null)) {
      return false;
    }
    return zza(paramzzce, zzp.zzbz().elapsedRealtime(), paramVarArgs);
  }
  
  public zzce zzb(long paramLong)
  {
    if (!this.zzvA) {
      return null;
    }
    return new zzce(paramLong, null, null);
  }
  
  public void zzc(zzcg paramzzcg)
  {
    synchronized (this.zzpd)
    {
      this.zzvV = paramzzcg;
      return;
    }
  }
  
  public zzce zzdn()
  {
    return zzb(zzp.zzbz().elapsedRealtime());
  }
  
  public void zzdo()
  {
    synchronized (this.zzpd)
    {
      this.zzvU = zzdn();
      return;
    }
  }
  
  public String zzdp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (this.zzpd)
    {
      Iterator localIterator = this.zzvR.iterator();
      while (localIterator.hasNext())
      {
        zzce localzzce = (zzce)localIterator.next();
        long l1 = localzzce.getTime();
        String str2 = localzzce.zzdk();
        localzzce = localzzce.zzdl();
        if ((localzzce != null) && (l1 > 0L))
        {
          long l2 = localzzce.getTime();
          localStringBuilder.append(str2).append('.').append(l1 - l2).append(',');
        }
      }
    }
    this.zzvR.clear();
    if (!TextUtils.isEmpty(this.zzvT)) {
      ((StringBuilder)localObject2).append(this.zzvT);
    }
    for (;;)
    {
      String str1 = ((StringBuilder)localObject2).toString();
      return str1;
      if (str1.length() > 0) {
        str1.setLength(str1.length() - 1);
      }
    }
  }
  
  public zzce zzdq()
  {
    synchronized (this.zzpd)
    {
      zzce localzzce = this.zzvU;
      return localzzce;
    }
  }
  
  public void zze(String paramString1, String paramString2)
  {
    if ((!this.zzvA) || (TextUtils.isEmpty(paramString2))) {}
    zzca localzzca;
    do
    {
      return;
      localzzca = zzp.zzby().zzgo();
    } while (localzzca == null);
    synchronized (this.zzpd)
    {
      localzzca.zzR(paramString1).zza(this.zzvS, paramString1, paramString2);
      return;
    }
  }
  
  Map<String, String> zzn()
  {
    synchronized (this.zzpd)
    {
      Object localObject2 = zzp.zzby().zzgo();
      if ((localObject2 == null) || (this.zzvV == null))
      {
        localObject2 = this.zzvS;
        return (Map<String, String>)localObject2;
      }
      localObject2 = ((zzca)localObject2).zza(this.zzvS, this.zzvV.zzn());
      return (Map<String, String>)localObject2;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */