package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzl
{
  private static final Object zzpy = new Object();
  private static zzl zztl;
  private final zza zztm = new zza();
  private final zze zztn = new zze();
  private final zzm zzto = new zzm();
  private final zzad zztp = new zzad();
  private final zzda zztq = new zzda();
  private final zzf zztr = new zzf();
  
  static
  {
    zza(new zzl());
  }
  
  protected static void zza(zzl paramzzl)
  {
    synchronized (zzpy)
    {
      zztl = paramzzl;
      return;
    }
  }
  
  private static zzl zzcE()
  {
    synchronized (zzpy)
    {
      zzl localzzl = zztl;
      return localzzl;
    }
  }
  
  public static zza zzcF()
  {
    return zzcE().zztm;
  }
  
  public static zze zzcG()
  {
    return zzcE().zztn;
  }
  
  public static zzm zzcH()
  {
    return zzcE().zzto;
  }
  
  public static zzad zzcI()
  {
    return zzcE().zztp;
  }
  
  public static zzda zzcJ()
  {
    return zzcE().zztq;
  }
  
  public static zzf zzcK()
  {
    return zzcE().zztr;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */