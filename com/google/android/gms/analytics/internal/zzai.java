package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.UUID;

public class zzai
  extends zzd
{
  private SharedPreferences zzPC;
  private long zzPD;
  private long zzPE = -1L;
  private final zza zzPF = new zza("monitoring", zziv().zzkg(), null);
  
  protected zzai(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void zzbm(String paramString)
  {
    zzis();
    zziE();
    SharedPreferences.Editor localEditor = this.zzPC.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    }
    for (;;)
    {
      if (!localEditor.commit()) {
        zzbd("Failed to commit campaign data");
      }
      return;
      localEditor.putString("installation_campaign", paramString);
    }
  }
  
  protected void zzhR()
  {
    this.zzPC = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public long zzkO()
  {
    zzis();
    zziE();
    long l;
    if (this.zzPD == 0L)
    {
      l = this.zzPC.getLong("first_run", 0L);
      if (l == 0L) {
        break label46;
      }
    }
    for (this.zzPD = l;; this.zzPD = l)
    {
      return this.zzPD;
      label46:
      l = zzit().currentTimeMillis();
      SharedPreferences.Editor localEditor = this.zzPC.edit();
      localEditor.putLong("first_run", l);
      if (!localEditor.commit()) {
        zzbd("Failed to commit first run time");
      }
    }
  }
  
  public zzaj zzkP()
  {
    return new zzaj(zzit(), zzkO());
  }
  
  public long zzkQ()
  {
    zzis();
    zziE();
    if (this.zzPE == -1L) {
      this.zzPE = this.zzPC.getLong("last_dispatch", 0L);
    }
    return this.zzPE;
  }
  
  public void zzkR()
  {
    zzis();
    zziE();
    long l = zzit().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zzPC.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    this.zzPE = l;
  }
  
  public String zzkS()
  {
    zzis();
    zziE();
    String str = this.zzPC.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str;
  }
  
  public zza zzkT()
  {
    return this.zzPF;
  }
  
  public final class zza
  {
    private final String mName;
    private final long zzPG;
    
    private zza(String paramString, long paramLong)
    {
      zzx.zzcr(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzaa(bool);
        this.mName = paramString;
        this.zzPG = paramLong;
        return;
      }
    }
    
    private void zzkU()
    {
      long l = zzai.this.zzit().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzai.zza(zzai.this).edit();
      localEditor.remove(zzkZ());
      localEditor.remove(zzla());
      localEditor.putLong(zzkY(), l);
      localEditor.commit();
    }
    
    private long zzkV()
    {
      long l = zzkX();
      if (l == 0L) {
        return 0L;
      }
      return Math.abs(l - zzai.this.zzit().currentTimeMillis());
    }
    
    private long zzkX()
    {
      return zzai.zza(zzai.this).getLong(zzkY(), 0L);
    }
    
    private String zzkY()
    {
      return this.mName + ":start";
    }
    
    private String zzkZ()
    {
      return this.mName + ":count";
    }
    
    public void zzbn(String paramString)
    {
      if (zzkX() == 0L) {
        zzkU();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      for (;;)
      {
        try
        {
          long l = zzai.zza(zzai.this).getLong(zzkZ(), 0L);
          if (l <= 0L)
          {
            paramString = zzai.zza(zzai.this).edit();
            paramString.putString(zzla(), str);
            paramString.putLong(zzkZ(), 1L);
            paramString.apply();
            return;
          }
          if ((UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + 1L))
          {
            i = 1;
            paramString = zzai.zza(zzai.this).edit();
            if (i != 0) {
              paramString.putString(zzla(), str);
            }
            paramString.putLong(zzkZ(), l + 1L);
            paramString.apply();
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public Pair<String, Long> zzkW()
    {
      long l = zzkV();
      if (l < this.zzPG) {}
      String str;
      do
      {
        return null;
        if (l > this.zzPG * 2L)
        {
          zzkU();
          return null;
        }
        str = zzai.zza(zzai.this).getString(zzla(), null);
        l = zzai.zza(zzai.this).getLong(zzkZ(), 0L);
        zzkU();
      } while ((str == null) || (l <= 0L));
      return new Pair(str, Long.valueOf(l));
    }
    
    protected String zzla()
    {
      return this.mName + ":value";
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */