package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zznj
{
  private static final List<TimeUnit> zzapR = Arrays.asList(new TimeUnit[] { TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS });
  
  public static long zza(long paramLong, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return paramTimeUnit1.convert(paramTimeUnit2.convert(paramLong, paramTimeUnit1), paramTimeUnit2);
  }
  
  public static boolean zza(TimeUnit paramTimeUnit)
  {
    return zza(paramTimeUnit, TimeUnit.MILLISECONDS);
  }
  
  private static boolean zza(TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
  {
    return zzapR.indexOf(paramTimeUnit1) < zzapR.indexOf(paramTimeUnit2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zznj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */