package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

class zzs
  extends zzy
{
  static final Pair<String, Long> zzaNg = new Pair("", Long.valueOf(0L));
  private SharedPreferences zzPC;
  public final zzb zzaNh = new zzb("health_monitor", zzzt().zzkg(), null);
  public final zza zzaNi = new zza("last_upload", 0L);
  public final zza zzaNj = new zza("last_upload_attempt", 0L);
  public final zza zzaNk = new zza("backoff", 0L);
  public final zza zzaNl = new zza("last_delete_stale", 0L);
  private String zzaNm;
  private boolean zzaNn;
  private long zzaNo;
  
  zzs(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  static MessageDigest zzbs(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  private SharedPreferences zzzV()
  {
    zzis();
    zziE();
    return this.zzPC;
  }
  
  void zzan(boolean paramBoolean)
  {
    zzis();
    zzyd().zzzQ().zzj("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzzV().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }
  
  protected void zzhR()
  {
    this.zzPC = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
  }
  
  Pair<String, Boolean> zzzS()
  {
    zzis();
    long l = zzit().elapsedRealtime();
    if ((this.zzaNm != null) && (l < this.zzaNo)) {
      return new Pair(this.zzaNm, Boolean.valueOf(this.zzaNn));
    }
    this.zzaNo = (l + zzzt().zzza());
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      this.zzaNm = localInfo.getId();
      this.zzaNn = localInfo.isLimitAdTrackingEnabled();
      AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
      return new Pair(this.zzaNm, Boolean.valueOf(this.zzaNn));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        zzyd().zzzP().zzj("Unable to get advertising id", localThrowable);
        this.zzaNm = "";
      }
    }
  }
  
  String zzzT()
  {
    String str = (String)zzzS().first;
    MessageDigest localMessageDigest = zzbs("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(str.getBytes())) });
  }
  
  String zzzU()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  Boolean zzzW()
  {
    zzis();
    if (!zzzV().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzzV().getBoolean("use_service", false));
  }
  
  public final class zza
  {
    private final long zzaNp;
    private boolean zzaNq;
    private long zzavc;
    private final String zzue;
    
    public zza(String paramString, long paramLong)
    {
      zzx.zzcr(paramString);
      this.zzue = paramString;
      this.zzaNp = paramLong;
    }
    
    private void zzzX()
    {
      if (this.zzaNq) {
        return;
      }
      this.zzaNq = true;
      this.zzavc = zzs.zza(zzs.this).getLong(this.zzue, this.zzaNp);
    }
    
    public long get()
    {
      zzzX();
      return this.zzavc;
    }
    
    public void set(long paramLong)
    {
      SharedPreferences.Editor localEditor = zzs.zza(zzs.this).edit();
      localEditor.putLong(this.zzue, paramLong);
      localEditor.apply();
      this.zzavc = paramLong;
    }
  }
  
  public final class zzb
  {
    private final long zzPG;
    final String zzaNs;
    private final String zzaNt;
    private final String zzaNu;
    
    private zzb(String paramString, long paramLong)
    {
      zzx.zzcr(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzaa(bool);
        this.zzaNs = (paramString + ":start");
        this.zzaNt = (paramString + ":count");
        this.zzaNu = (paramString + ":value");
        this.zzPG = paramLong;
        return;
      }
    }
    
    private void zzkU()
    {
      zzs.this.zzis();
      long l = zzs.this.zzit().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzs.zza(zzs.this).edit();
      localEditor.remove(this.zzaNt);
      localEditor.remove(this.zzaNu);
      localEditor.putLong(this.zzaNs, l);
      localEditor.apply();
    }
    
    private long zzkV()
    {
      zzs.this.zzis();
      long l = zzkX();
      if (l == 0L)
      {
        zzkU();
        return 0L;
      }
      return Math.abs(l - zzs.this.zzit().currentTimeMillis());
    }
    
    private long zzkX()
    {
      return zzs.zzb(zzs.this).getLong(this.zzaNs, 0L);
    }
    
    public void zzbn(String paramString)
    {
      zzs.this.zzis();
      if (zzkX() == 0L) {
        zzkU();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      long l = zzs.zza(zzs.this).getLong(this.zzaNt, 0L);
      if (l <= 0L)
      {
        paramString = zzs.zza(zzs.this).edit();
        paramString.putString(this.zzaNu, str);
        paramString.putLong(this.zzaNt, 1L);
        paramString.apply();
        return;
      }
      if ((UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + 1L)) {}
      for (int i = 1;; i = 0)
      {
        paramString = zzs.zza(zzs.this).edit();
        if (i != 0) {
          paramString.putString(this.zzaNu, str);
        }
        paramString.putLong(this.zzaNt, l + 1L);
        paramString.apply();
        return;
      }
    }
    
    public Pair<String, Long> zzkW()
    {
      zzs.this.zzis();
      long l = zzkV();
      if (l < this.zzPG) {
        return null;
      }
      if (l > this.zzPG * 2L)
      {
        zzkU();
        return null;
      }
      String str = zzs.zzb(zzs.this).getString(this.zzaNu, null);
      l = zzs.zzb(zzs.this).getLong(this.zzaNt, 0L);
      zzkU();
      if ((str == null) || (l <= 0L)) {
        return zzs.zzaNg;
      }
      return new Pair(str, Long.valueOf(l));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */