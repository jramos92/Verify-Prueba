package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzan
  extends zzd
{
  protected boolean zzLD;
  protected int zzNW;
  protected String zzOZ;
  protected boolean zzPQ;
  protected boolean zzPR;
  protected boolean zzPS;
  protected String zzPa;
  protected int zzPc;
  
  public zzan(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private static int zzbv(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ("verbose".equals(paramString)) {
      return 0;
    }
    if ("info".equals(paramString)) {
      return 1;
    }
    if ("warning".equals(paramString)) {
      return 2;
    }
    if ("error".equals(paramString)) {
      return 3;
    }
    return -1;
  }
  
  public int getLogLevel()
  {
    zziE();
    return this.zzNW;
  }
  
  void zza(zzaa paramzzaa)
  {
    zzba("Loading global XML config values");
    String str;
    if (paramzzaa.zzko())
    {
      str = paramzzaa.zzkp();
      this.zzOZ = str;
      zzb("XML config - app name", str);
    }
    if (paramzzaa.zzkq())
    {
      str = paramzzaa.zzkr();
      this.zzPa = str;
      zzb("XML config - app version", str);
    }
    int i;
    if (paramzzaa.zzks())
    {
      i = zzbv(paramzzaa.zzkt());
      if (i >= 0)
      {
        this.zzNW = i;
        zza("XML config - log level", Integer.valueOf(i));
      }
    }
    if (paramzzaa.zzku())
    {
      i = paramzzaa.zzkv();
      this.zzPc = i;
      this.zzPR = true;
      zzb("XML config - dispatch period (sec)", Integer.valueOf(i));
    }
    if (paramzzaa.zzkw())
    {
      boolean bool = paramzzaa.zzkx();
      this.zzLD = bool;
      this.zzPS = true;
      zzb("XML config - dry run", Boolean.valueOf(bool));
    }
  }
  
  protected void zzhR()
  {
    zzlm();
  }
  
  public String zzkp()
  {
    zziE();
    return this.zzOZ;
  }
  
  public String zzkr()
  {
    zziE();
    return this.zzPa;
  }
  
  public boolean zzks()
  {
    zziE();
    return this.zzPQ;
  }
  
  public boolean zzku()
  {
    zziE();
    return this.zzPR;
  }
  
  public boolean zzkw()
  {
    zziE();
    return this.zzPS;
  }
  
  public boolean zzkx()
  {
    zziE();
    return this.zzLD;
  }
  
  public int zzll()
  {
    zziE();
    return this.zzPc;
  }
  
  protected void zzlm()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
      if (localObject1 == null)
      {
        zzbd("Couldn't get ApplicationInfo to load global config");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Object localObject2;
      do
      {
        int i;
        do
        {
          do
          {
            for (;;)
            {
              zzd("PackageManager doesn't know about the app package", localNameNotFoundException);
              localObject2 = null;
            }
            localObject2 = ((ApplicationInfo)localObject2).metaData;
          } while (localObject2 == null);
          i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
        } while (i <= 0);
        localObject2 = (zzaa)new zzz(zziq()).zzad(i);
      } while (localObject2 == null);
      zza((zzaa)localObject2);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */