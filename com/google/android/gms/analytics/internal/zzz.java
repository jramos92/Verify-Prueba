package com.google.android.gms.analytics.internal;

public class zzz
  extends zzq<zzaa>
{
  public zzz(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    implements zzq.zza<zzaa>
  {
    private final zzf zzME;
    private final zzaa zzOY;
    
    public zza(zzf paramzzf)
    {
      this.zzME = paramzzf;
      this.zzOY = new zzaa();
    }
    
    public void zzc(String paramString, boolean paramBoolean)
    {
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.zzOY;
        if (paramBoolean) {}
        for (int i = 1;; i = 0)
        {
          paramString.zzPd = i;
          return;
        }
      }
      this.zzME.zziu().zzd("Bool xml configuration name not recognized", paramString);
    }
    
    public void zzd(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString))
      {
        this.zzOY.zzPc = paramInt;
        return;
      }
      this.zzME.zziu().zzd("Int xml configuration name not recognized", paramString);
    }
    
    public zzaa zzkn()
    {
      return this.zzOY;
    }
    
    public void zzl(String paramString1, String paramString2) {}
    
    public void zzm(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1))
      {
        this.zzOY.zzOZ = paramString2;
        return;
      }
      if ("ga_appVersion".equals(paramString1))
      {
        this.zzOY.zzPa = paramString2;
        return;
      }
      if ("ga_logLevel".equals(paramString1))
      {
        this.zzOY.zzPb = paramString2;
        return;
      }
      this.zzME.zziu().zzd("String xml configuration name not recognized", paramString1);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */