package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

public final class zzc
{
  public static String zzP(int paramInt)
  {
    return zzc("&cd", paramInt);
  }
  
  public static String zzQ(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzR(int paramInt)
  {
    return zzc("&cm", paramInt);
  }
  
  public static String zzS(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  public static String zzT(int paramInt)
  {
    return zzc("&pr", paramInt);
  }
  
  public static String zzU(int paramInt)
  {
    return zzc("pr", paramInt);
  }
  
  public static String zzV(int paramInt)
  {
    return zzc("&promo", paramInt);
  }
  
  public static String zzW(int paramInt)
  {
    return zzc("promo", paramInt);
  }
  
  public static String zzX(int paramInt)
  {
    return zzc("pi", paramInt);
  }
  
  public static String zzY(int paramInt)
  {
    return zzc("&il", paramInt);
  }
  
  public static String zzZ(int paramInt)
  {
    return zzc("il", paramInt);
  }
  
  public static String zzaa(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzab(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  private static String zzc(String paramString, int paramInt)
  {
    if (paramInt < 1)
    {
      zzae.zzf("index out of range for prefix", paramString);
      return "";
    }
    return paramString + paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */