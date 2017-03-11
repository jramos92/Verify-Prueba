package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzf
  extends zzy
{
  private long zzaLZ;
  private String zzaMa;
  
  zzf(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  public String zzgE()
  {
    zziE();
    return Build.MODEL;
  }
  
  protected void zzhR()
  {
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = TimeUnit.MINUTES;
    int i = ((Calendar)localObject1).get(15);
    this.zzaLZ = ((TimeUnit)localObject2).convert(((Calendar)localObject1).get(16) + i, TimeUnit.MILLISECONDS);
    localObject1 = Locale.getDefault();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Locale)localObject1).getLanguage().toLowerCase(Locale.ENGLISH));
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append(((Locale)localObject1).getCountry().toLowerCase(Locale.ENGLISH));
    this.zzaMa = ((StringBuilder)localObject2).toString();
  }
  
  public String zzzA()
  {
    zziE();
    return this.zzaMa;
  }
  
  public String zzzy()
  {
    zziE();
    return Build.VERSION.RELEASE;
  }
  
  public long zzzz()
  {
    zziE();
    return this.zzaLZ;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */