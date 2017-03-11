package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

abstract class zza
{
  private static final char[] zzaQv = "0123456789abcdef".toCharArray();
  private final byte[] zzaQw;
  
  protected zza(byte[] paramArrayOfByte)
  {
    this.zzaQw = paramArrayOfByte;
  }
  
  static String zzr(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(zzaQv[(k >> 4 & 0xF)]).append(zzaQv[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!paramObject.getClass().isAssignableFrom(getClass())) {
      return false;
    }
    paramObject = (zza)paramObject;
    return Arrays.equals(this.zzaQw, ((zza)paramObject).zzaQw);
  }
  
  byte[] getBytes()
  {
    return this.zzaQw;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.zzaQw);
  }
  
  public String toString()
  {
    return zzr(this.zzaQw);
  }
  
  String zzAW()
  {
    return zzr(this.zzaQw);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */