package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.measurement.zzg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Tracker
  extends zzd
{
  private boolean zzLN;
  private final Map<String, String> zzLO = new HashMap();
  private final zzad zzLP;
  private final zza zzLQ;
  private ExceptionReporter zzLR;
  private zzal zzLS;
  private final Map<String, String> zzvS = new HashMap();
  
  Tracker(zzf paramzzf, String paramString, zzad paramzzad)
  {
    super(paramzzf);
    if (paramString != null) {
      this.zzvS.put("&tid", paramString);
    }
    this.zzvS.put("useSecure", "1");
    this.zzvS.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    if (paramzzad == null) {}
    for (this.zzLP = new zzad("tracking");; this.zzLP = paramzzad)
    {
      this.zzLQ = new zza(paramzzf);
      return;
    }
  }
  
  private static boolean zza(Map.Entry<String, String> paramEntry)
  {
    String str = (String)paramEntry.getKey();
    paramEntry = (String)paramEntry.getValue();
    return (str.startsWith("&")) && (str.length() >= 2);
  }
  
  private static String zzb(Map.Entry<String, String> paramEntry)
  {
    if (!zza(paramEntry)) {
      return null;
    }
    return ((String)paramEntry.getKey()).substring(1);
  }
  
  private static void zzb(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzx.zzw(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if (str != null) {
          paramMap2.put(str, localEntry.getValue());
        }
      }
    }
  }
  
  private static void zzc(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzx.zzw(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if ((str != null) && (!paramMap2.containsKey(str))) {
          paramMap2.put(str, localEntry.getValue());
        }
      }
    }
  }
  
  private boolean zzhS()
  {
    return this.zzLR != null;
  }
  
  static String zzp(Activity paramActivity)
  {
    zzx.zzw(paramActivity);
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {}
    do
    {
      return null;
      paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    } while (TextUtils.isEmpty(paramActivity));
    return paramActivity;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzLN = paramBoolean;
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.zzLQ.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (zzhS() == paramBoolean) {
          return;
        }
        if (paramBoolean)
        {
          Context localContext = getContext();
          this.zzLR = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), localContext);
          Thread.setDefaultUncaughtExceptionHandler(this.zzLR);
          zzba("Uncaught exceptions will be reported to Google Analytics");
          return;
        }
      }
      finally {}
      Thread.setDefaultUncaughtExceptionHandler(this.zzLR.zzhL());
      zzba("Uncaught exceptions will not be reported to Google Analytics");
    }
  }
  
  public String get(String paramString)
  {
    zziE();
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.zzvS.containsKey(paramString)) {
        return (String)this.zzvS.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return zzam.zza(Locale.getDefault());
      }
      if (paramString.equals("&cid")) {
        return zziz().zzjt();
      }
      if (paramString.equals("&sr")) {
        return zziC().zzkj();
      }
      if (paramString.equals("&aid")) {
        return zziB().zzjb().zzuM();
      }
      if (paramString.equals("&an")) {
        return zziB().zzjb().zzkp();
      }
      if (paramString.equals("&av")) {
        return zziB().zzjb().zzkr();
      }
    } while (!paramString.equals("&aiid"));
    return zziB().zzjb().zzyt();
  }
  
  public void send(final Map<String, String> paramMap)
  {
    final long l = zzit().currentTimeMillis();
    if (zzhK().getAppOptOut())
    {
      zzbb("AppOptOut is set to true. Not sending Google Analytics hit");
      return;
    }
    boolean bool1 = zzhK().isDryRunEnabled();
    final HashMap localHashMap = new HashMap();
    zzb(this.zzvS, localHashMap);
    zzb(paramMap, localHashMap);
    final boolean bool2 = zzam.zze((String)this.zzvS.get("useSecure"), true);
    zzc(this.zzLO, localHashMap);
    this.zzLO.clear();
    paramMap = (String)localHashMap.get("t");
    if (TextUtils.isEmpty(paramMap))
    {
      zziu().zzh(localHashMap, "Missing hit type parameter");
      return;
    }
    final String str = (String)localHashMap.get("tid");
    if (TextUtils.isEmpty(str))
    {
      zziu().zzh(localHashMap, "Missing tracking id parameter");
      return;
    }
    final boolean bool3 = zzhT();
    try
    {
      if (("screenview".equalsIgnoreCase(paramMap)) || ("pageview".equalsIgnoreCase(paramMap)) || ("appview".equalsIgnoreCase(paramMap)) || (TextUtils.isEmpty(paramMap)))
      {
        int j = Integer.parseInt((String)this.zzvS.get("&a")) + 1;
        int i = j;
        if (j >= Integer.MAX_VALUE) {
          i = 1;
        }
        this.zzvS.put("&a", Integer.toString(i));
      }
      zziw().zzg(new Runnable()
      {
        public void run()
        {
          boolean bool = true;
          if (Tracker.zza(Tracker.this).zzhU()) {
            localHashMap.put("sc", "start");
          }
          zzam.zzd(localHashMap, "cid", Tracker.this.zzhK().getClientId());
          Object localObject = (String)localHashMap.get("sf");
          if (localObject != null)
          {
            double d = zzam.zza((String)localObject, 100.0D);
            if (zzam.zza(d, (String)localHashMap.get("cid")))
            {
              Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
              return;
            }
          }
          localObject = Tracker.zzb(Tracker.this);
          if (bool3)
          {
            zzam.zzb(localHashMap, "ate", ((zza)localObject).zzic());
            zzam.zzc(localHashMap, "adid", ((zza)localObject).zzig());
            localObject = Tracker.zzc(Tracker.this).zzjb();
            zzam.zzc(localHashMap, "an", ((zzpb)localObject).zzkp());
            zzam.zzc(localHashMap, "av", ((zzpb)localObject).zzkr());
            zzam.zzc(localHashMap, "aid", ((zzpb)localObject).zzuM());
            zzam.zzc(localHashMap, "aiid", ((zzpb)localObject).zzyt());
            localHashMap.put("v", "1");
            localHashMap.put("_v", zze.zzMH);
            zzam.zzc(localHashMap, "ul", Tracker.zzd(Tracker.this).zzki().getLanguage());
            zzam.zzc(localHashMap, "sr", Tracker.zze(Tracker.this).zzkj());
            if ((!paramMap.equals("transaction")) && (!paramMap.equals("item"))) {
              break label383;
            }
          }
          label383:
          for (int i = 1;; i = 0)
          {
            if ((i != 0) || (Tracker.zzf(Tracker.this).zzkF())) {
              break label388;
            }
            Tracker.zzg(Tracker.this).zzh(localHashMap, "Too many hits sent too quickly, rate limiting invoked");
            return;
            localHashMap.remove("ate");
            localHashMap.remove("adid");
            break;
          }
          label388:
          long l2 = zzam.zzbq((String)localHashMap.get("ht"));
          long l1 = l2;
          if (l2 == 0L) {
            l1 = l;
          }
          if (bool2)
          {
            localObject = new zzab(Tracker.this, localHashMap, l1, str);
            Tracker.zzh(Tracker.this).zzc("Dry run enabled. Would have sent hit", localObject);
            return;
          }
          localObject = (String)localHashMap.get("cid");
          HashMap localHashMap = new HashMap();
          zzam.zza(localHashMap, "uid", localHashMap);
          zzam.zza(localHashMap, "an", localHashMap);
          zzam.zza(localHashMap, "aid", localHashMap);
          zzam.zza(localHashMap, "av", localHashMap);
          zzam.zza(localHashMap, "aiid", localHashMap);
          String str = this.zzLZ;
          if (!TextUtils.isEmpty((CharSequence)localHashMap.get("adid"))) {}
          for (;;)
          {
            localObject = new zzh(0L, (String)localObject, str, bool, 0L, localHashMap);
            l2 = Tracker.zzi(Tracker.this).zza((zzh)localObject);
            localHashMap.put("_s", String.valueOf(l2));
            localObject = new zzab(Tracker.this, localHashMap, l1, str);
            Tracker.zzj(Tracker.this).zza((zzab)localObject);
            return;
            bool = false;
          }
        }
      });
      return;
    }
    finally {}
  }
  
  public void set(String paramString1, String paramString2)
  {
    zzx.zzb(paramString1, "Key should be non-null");
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.zzvS.put(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", zzam.zzJ(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.isOpaque())) {}
    do
    {
      do
      {
        return;
        paramUri = paramUri.getQueryParameter("referrer");
      } while (TextUtils.isEmpty(paramUri));
      paramUri = Uri.parse("http://hostname/?" + paramUri);
      String str = paramUri.getQueryParameter("utm_id");
      if (str != null) {
        this.zzLO.put("&ci", str);
      }
      str = paramUri.getQueryParameter("anid");
      if (str != null) {
        this.zzLO.put("&anid", str);
      }
      str = paramUri.getQueryParameter("utm_campaign");
      if (str != null) {
        this.zzLO.put("&cn", str);
      }
      str = paramUri.getQueryParameter("utm_content");
      if (str != null) {
        this.zzLO.put("&cc", str);
      }
      str = paramUri.getQueryParameter("utm_medium");
      if (str != null) {
        this.zzLO.put("&cm", str);
      }
      str = paramUri.getQueryParameter("utm_source");
      if (str != null) {
        this.zzLO.put("&cs", str);
      }
      str = paramUri.getQueryParameter("utm_term");
      if (str != null) {
        this.zzLO.put("&ck", str);
      }
      str = paramUri.getQueryParameter("dclid");
      if (str != null) {
        this.zzLO.put("&dclid", str);
      }
      str = paramUri.getQueryParameter("gclid");
      if (str != null) {
        this.zzLO.put("&gclid", str);
      }
      paramUri = paramUri.getQueryParameter("aclid");
    } while (paramUri == null);
    this.zzLO.put("&aclid", paramUri);
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      zzbd("Invalid width or height. The values should be non-negative.");
      return;
    }
    set("&sr", paramInt1 + "x" + paramInt2);
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.zzLQ.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", zzam.zzJ(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  void zza(zzal paramzzal)
  {
    zzba("Loading Tracker config values");
    this.zzLS = paramzzal;
    if (this.zzLS.zzlc())
    {
      paramzzal = this.zzLS.getTrackingId();
      set("&tid", paramzzal);
      zza("trackingId loaded", paramzzal);
    }
    if (this.zzLS.zzld())
    {
      paramzzal = Double.toString(this.zzLS.zzle());
      set("&sf", paramzzal);
      zza("Sample frequency loaded", paramzzal);
    }
    if (this.zzLS.zzlf())
    {
      int i = this.zzLS.getSessionTimeout();
      setSessionTimeout(i);
      zza("Session timeout loaded", Integer.valueOf(i));
    }
    boolean bool;
    if (this.zzLS.zzlg())
    {
      bool = this.zzLS.zzlh();
      enableAutoActivityTracking(bool);
      zza("Auto activity tracking loaded", Boolean.valueOf(bool));
    }
    if (this.zzLS.zzli())
    {
      bool = this.zzLS.zzlj();
      if (bool) {
        set("&aip", "1");
      }
      zza("Anonymize ip loaded", Boolean.valueOf(bool));
    }
    enableExceptionReporting(this.zzLS.zzlk());
  }
  
  protected void zzhR()
  {
    this.zzLQ.zza();
    String str = zzhQ().zzkp();
    if (str != null) {
      set("&an", str);
    }
    str = zzhQ().zzkr();
    if (str != null) {
      set("&av", str);
    }
  }
  
  boolean zzhT()
  {
    return this.zzLN;
  }
  
  private class zza
    extends zzd
    implements GoogleAnalytics.zza
  {
    private boolean zzMb;
    private int zzMc;
    private long zzMd = -1L;
    private boolean zzMe;
    private long zzMf;
    
    protected zza(zzf paramzzf)
    {
      super();
    }
    
    private void zzhV()
    {
      if ((this.zzMd >= 0L) || (this.zzMb))
      {
        zzhK().zza(Tracker.zza(Tracker.this));
        return;
      }
      zzhK().zzb(Tracker.zza(Tracker.this));
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.zzMb = paramBoolean;
      zzhV();
    }
    
    public void setSessionTimeout(long paramLong)
    {
      this.zzMd = paramLong;
      zzhV();
    }
    
    protected void zzhR() {}
    
    public boolean zzhU()
    {
      try
      {
        boolean bool = this.zzMe;
        this.zzMe = false;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean zzhW()
    {
      return zzit().elapsedRealtime() >= this.zzMf + Math.max(1000L, this.zzMd);
    }
    
    public void zzn(Activity paramActivity)
    {
      if ((this.zzMc == 0) && (zzhW())) {
        this.zzMe = true;
      }
      this.zzMc += 1;
      HashMap localHashMap;
      Tracker localTracker;
      if (this.zzMb)
      {
        localObject = paramActivity.getIntent();
        if (localObject != null) {
          Tracker.this.setCampaignParamsOnNextHit(((Intent)localObject).getData());
        }
        localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        localTracker = Tracker.this;
        if (Tracker.zzk(Tracker.this) == null) {
          break label159;
        }
      }
      label159:
      for (Object localObject = Tracker.zzk(Tracker.this).zzq(paramActivity);; localObject = paramActivity.getClass().getCanonicalName())
      {
        localTracker.set("&cd", (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&dr")))
        {
          paramActivity = Tracker.zzp(paramActivity);
          if (!TextUtils.isEmpty(paramActivity)) {
            localHashMap.put("&dr", paramActivity);
          }
        }
        Tracker.this.send(localHashMap);
        return;
      }
    }
    
    public void zzo(Activity paramActivity)
    {
      this.zzMc -= 1;
      this.zzMc = Math.max(0, this.zzMc);
      if (this.zzMc == 0) {
        this.zzMf = zzit().elapsedRealtime();
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */