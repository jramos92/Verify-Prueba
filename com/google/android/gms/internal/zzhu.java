package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

@zzgr
public class zzhu
  implements zzib.zzb
{
  private Context mContext;
  private boolean zzGg = true;
  private boolean zzGh = true;
  private final String zzHP;
  private final zzhv zzHQ;
  private BigInteger zzHR = BigInteger.ONE;
  private final HashSet<zzht> zzHS = new HashSet();
  private final HashMap<String, zzhx> zzHT = new HashMap();
  private boolean zzHU = false;
  private int zzHV = 0;
  private zzca zzHW = null;
  private zzbk zzHX = null;
  private final LinkedList<Thread> zzHY = new LinkedList();
  private Boolean zzHZ = null;
  private String zzIa;
  private boolean zzIb = false;
  private boolean zzIc = false;
  private zzay zzov;
  private boolean zzpA = false;
  private VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private zzbj zzsa = null;
  private zzbi zzsb = null;
  private final zzgq zzsc = null;
  
  public zzhu(zzid paramzzid)
  {
    this.zzHP = paramzzid.zzgD();
    this.zzHQ = new zzhv(this.zzHP);
  }
  
  public String getSessionId()
  {
    return this.zzHP;
  }
  
  public void zzA(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzGh = paramBoolean;
      return;
    }
  }
  
  public void zzB(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzIb = paramBoolean;
      return;
    }
  }
  
  public zzbk zzE(Context paramContext)
  {
    if ((!((Boolean)zzby.zzuT.get()).booleanValue()) || (!zzmx.zzqx()) || (zzgl())) {
      return null;
    }
    synchronized (this.zzpd)
    {
      if (this.zzsa == null)
      {
        if (!(paramContext instanceof Activity)) {
          return null;
        }
        this.zzsa = new zzbj((Application)paramContext.getApplicationContext(), (Activity)paramContext);
      }
      if (this.zzsb == null) {
        this.zzsb = new zzbi();
      }
      if (this.zzHX == null) {
        this.zzHX = new zzbk(this.zzsa, this.zzsb, new zzgq(this.mContext, this.zzpb, null, null));
      }
      this.zzHX.zzct();
      paramContext = this.zzHX;
      return paramContext;
    }
  }
  
  public Bundle zza(Context paramContext, zzhw paramzzhw, String paramString)
  {
    Bundle localBundle;
    synchronized (this.zzpd)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", this.zzHQ.zze(paramContext, paramString));
      paramContext = new Bundle();
      paramString = this.zzHT.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((zzhx)this.zzHT.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = this.zzHS.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((zzht)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramzzhw.zza(this.zzHS);
    this.zzHS.clear();
    return localBundle;
  }
  
  public Future zza(Context paramContext, boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      if (paramBoolean != this.zzGg)
      {
        this.zzGg = paramBoolean;
        paramContext = zzib.zza(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public void zza(zzht paramzzht)
  {
    synchronized (this.zzpd)
    {
      this.zzHS.add(paramzzht);
      return;
    }
  }
  
  public void zza(String paramString, zzhx paramzzhx)
  {
    synchronized (this.zzpd)
    {
      this.zzHT.put(paramString, paramzzhx);
      return;
    }
  }
  
  public void zza(Thread paramThread)
  {
    zzgq.zza(this.mContext, paramThread, this.zzpb);
  }
  
  public void zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (this.zzpd)
    {
      if (!this.zzpA)
      {
        this.mContext = paramContext.getApplicationContext();
        this.zzpb = paramVersionInfoParcel;
        zzib.zza(paramContext, this);
        zzib.zzb(paramContext, this);
        zza(Thread.currentThread());
        this.zzIa = zzp.zzbv().zzf(paramContext, paramVersionInfoParcel.zzJu);
        if ((zzmx.zzqE()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
          this.zzIc = true;
        }
        this.zzov = new zzay(paramContext.getApplicationContext(), this.zzpb, new zzdz(paramContext.getApplicationContext(), this.zzpb, (String)zzby.zzul.get()));
        zzgw();
        zzp.zzbF().zzx(this.mContext);
        this.zzpA = true;
      }
      return;
    }
  }
  
  public void zzb(Boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      this.zzHZ = paramBoolean;
      return;
    }
  }
  
  public void zzb(HashSet<zzht> paramHashSet)
  {
    synchronized (this.zzpd)
    {
      this.zzHS.addAll(paramHashSet);
      return;
    }
  }
  
  public void zzc(Throwable paramThrowable, boolean paramBoolean)
  {
    new zzgq(this.mContext, this.zzpb, null, null).zza(paramThrowable, paramBoolean);
  }
  
  public String zzd(int paramInt, String paramString)
  {
    if (this.zzpb.zzJx) {}
    for (Resources localResources = this.mContext.getResources(); localResources == null; localResources = GooglePlayServicesUtil.getRemoteResource(this.mContext)) {
      return paramString;
    }
    return localResources.getString(paramInt);
  }
  
  public void zzd(Bundle paramBundle)
  {
    synchronized (this.zzpd)
    {
      if (paramBundle.containsKey("use_https")) {}
      for (boolean bool = paramBundle.getBoolean("use_https");; bool = this.zzGg)
      {
        this.zzGg = bool;
        if (!paramBundle.containsKey("webview_cache_version")) {
          break;
        }
        i = paramBundle.getInt("webview_cache_version");
        this.zzHV = i;
        return;
      }
      int i = this.zzHV;
    }
  }
  
  public boolean zzgl()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzGh;
      return bool;
    }
  }
  
  public String zzgm()
  {
    synchronized (this.zzpd)
    {
      String str = this.zzHR.toString();
      this.zzHR = this.zzHR.add(BigInteger.ONE);
      return str;
    }
  }
  
  public zzhv zzgn()
  {
    synchronized (this.zzpd)
    {
      zzhv localzzhv = this.zzHQ;
      return localzzhv;
    }
  }
  
  public zzca zzgo()
  {
    synchronized (this.zzpd)
    {
      zzca localzzca = this.zzHW;
      return localzzca;
    }
  }
  
  public boolean zzgp()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzHU;
      this.zzHU = true;
      return bool;
    }
  }
  
  public boolean zzgq()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (!this.zzGg)
        {
          if (!this.zzIc) {
            break label38;
          }
          break label33;
          return bool;
        }
      }
      label33:
      boolean bool = true;
      continue;
      label38:
      bool = false;
    }
  }
  
  public String zzgr()
  {
    synchronized (this.zzpd)
    {
      String str = this.zzIa;
      return str;
    }
  }
  
  public Boolean zzgs()
  {
    synchronized (this.zzpd)
    {
      Boolean localBoolean = this.zzHZ;
      return localBoolean;
    }
  }
  
  public zzay zzgt()
  {
    return this.zzov;
  }
  
  public boolean zzgu()
  {
    synchronized (this.zzpd)
    {
      if (this.zzHV < ((Integer)zzby.zzvh.get()).intValue())
      {
        this.zzHV = ((Integer)zzby.zzvh.get()).intValue();
        zzib.zza(this.mContext, this.zzHV);
        return true;
      }
      return false;
    }
  }
  
  public boolean zzgv()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzIb;
      return bool;
    }
  }
  
  void zzgw()
  {
    zzbz localzzbz = new zzbz(this.mContext, this.zzpb.zzJu);
    try
    {
      this.zzHW = zzp.zzbA().zza(localzzbz);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzb.zzd("Cannot initialize CSI reporter.", localIllegalArgumentException);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */