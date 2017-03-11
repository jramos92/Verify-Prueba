package com.google.android.gms.analytics.internal;

public enum zzm
{
  private zzm() {}
  
  public static zzm zzbj(String paramString)
  {
    if ("BATCH_BY_SESSION".equalsIgnoreCase(paramString)) {
      return zzNG;
    }
    if ("BATCH_BY_TIME".equalsIgnoreCase(paramString)) {
      return zzNH;
    }
    if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(paramString)) {
      return zzNI;
    }
    if ("BATCH_BY_COUNT".equalsIgnoreCase(paramString)) {
      return zzNJ;
    }
    if ("BATCH_BY_SIZE".equalsIgnoreCase(paramString)) {
      return zzNK;
    }
    return zzNF;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */