package com.google.android.gms.internal;

public class zzom
{
  private static final ThreadLocal<String> zzark = new ThreadLocal();
  
  public static String zzB(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    byte[] arrayOfByte = new byte[paramString1.length() + paramString2.length()];
    System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, 0, paramString1.length());
    System.arraycopy(paramString2.getBytes(), 0, arrayOfByte, paramString1.length(), paramString2.length());
    return Integer.toHexString(zzmw.zza(arrayOfByte, 0, arrayOfByte.length, 0));
  }
  
  public static String zzcU(String paramString)
  {
    if (zzsK()) {
      return paramString;
    }
    return zzB(paramString, (String)zzark.get());
  }
  
  public static boolean zzsK()
  {
    String str = (String)zzark.get();
    return (str == null) || (str.startsWith("com.google"));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */