package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
public final class zzy
{
  public static final String DEVICE_ID_EMULATOR = zzl.zzcF().zzaE("emulator");
  private final Date zzaT;
  private final Set<String> zzaV;
  private final Location zzaX;
  private final boolean zzoN;
  private final int zzsR;
  private final int zzsU;
  private final String zzsV;
  private final String zzsX;
  private final Bundle zzsZ;
  private final String zztb;
  private final Bundle zztu;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> zztv;
  private final SearchAdRequest zztw;
  private final Set<String> zztx;
  private final Set<String> zzty;
  
  public zzy(zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzy(zza paramzza, SearchAdRequest paramSearchAdRequest)
  {
    this.zzaT = zza.zza(paramzza);
    this.zzsX = zza.zzb(paramzza);
    this.zzsR = zza.zzc(paramzza);
    this.zzaV = Collections.unmodifiableSet(zza.zzd(paramzza));
    this.zzaX = zza.zze(paramzza);
    this.zzoN = zza.zzf(paramzza);
    this.zztu = zza.zzg(paramzza);
    this.zztv = Collections.unmodifiableMap(zza.zzh(paramzza));
    this.zzsV = zza.zzi(paramzza);
    this.zztb = zza.zzj(paramzza);
    this.zztw = paramSearchAdRequest;
    this.zzsU = zza.zzk(paramzza);
    this.zztx = Collections.unmodifiableSet(zza.zzl(paramzza));
    this.zzsZ = zza.zzm(paramzza);
    this.zzty = Collections.unmodifiableSet(zza.zzn(paramzza));
  }
  
  public static void updateCorrelator()
  {
    zzl.zzcH().zzcL();
  }
  
  public Date getBirthday()
  {
    return this.zzaT;
  }
  
  public String getContentUrl()
  {
    return this.zzsX;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = this.zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getClass().getName());
    }
    return null;
  }
  
  public Bundle getCustomTargeting()
  {
    return this.zzsZ;
  }
  
  public int getGender()
  {
    return this.zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaV;
  }
  
  public Location getLocation()
  {
    return this.zzaX;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.zzoN;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.zztv.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return this.zztu.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return this.zzsV;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.zztx.contains(zzl.zzcF().zzQ(paramContext));
  }
  
  public String zzcM()
  {
    return this.zztb;
  }
  
  public SearchAdRequest zzcN()
  {
    return this.zztw;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> zzcO()
  {
    return this.zztv;
  }
  
  public Bundle zzcP()
  {
    return this.zztu;
  }
  
  public int zzcQ()
  {
    return this.zzsU;
  }
  
  public Set<String> zzcR()
  {
    return this.zzty;
  }
  
  public static final class zza
  {
    private Date zzaT;
    private Location zzaX;
    private boolean zzoN = false;
    private int zzsR = -1;
    private int zzsU = -1;
    private String zzsV;
    private String zzsX;
    private final Bundle zzsZ = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zztA = new HashMap();
    private final HashSet<String> zztB = new HashSet();
    private final HashSet<String> zztC = new HashSet();
    private String zztb;
    private final Bundle zztu = new Bundle();
    private final HashSet<String> zztz = new HashSet();
    
    public void setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.zzoN = paramBoolean;
    }
    
    public void zzF(String paramString)
    {
      this.zztz.add(paramString);
    }
    
    public void zzG(String paramString)
    {
      this.zztB.add(paramString);
    }
    
    public void zzH(String paramString)
    {
      this.zztB.remove(paramString);
    }
    
    public void zzI(String paramString)
    {
      this.zzsX = paramString;
    }
    
    public void zzJ(String paramString)
    {
      this.zzsV = paramString;
    }
    
    public void zzK(String paramString)
    {
      this.zztb = paramString;
    }
    
    public void zzL(String paramString)
    {
      this.zztC.add(paramString);
    }
    
    @Deprecated
    public void zza(NetworkExtras paramNetworkExtras)
    {
      if ((paramNetworkExtras instanceof AdMobExtras))
      {
        zza(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
        return;
      }
      this.zztA.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void zza(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zztu.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zza(Date paramDate)
    {
      this.zzaT = paramDate;
    }
    
    public void zzb(Location paramLocation)
    {
      this.zzaX = paramLocation;
    }
    
    public void zzb(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      if (this.zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
        this.zztu.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
      }
      this.zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zzb(String paramString1, String paramString2)
    {
      this.zzsZ.putString(paramString1, paramString2);
    }
    
    public void zzj(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.zzsU = i;
        return;
      }
    }
    
    public void zzm(int paramInt)
    {
      this.zzsR = paramInt;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */