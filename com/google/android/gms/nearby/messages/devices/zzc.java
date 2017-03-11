package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;

class zzc
  extends zza
{
  public zzc(byte[] paramArrayOfByte)
  {
    super(zzs(paramArrayOfByte));
  }
  
  private static byte[] zzs(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length == 10) || (paramArrayOfByte.length == 16)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Bytes must be a namespace (10 bytes), or a namespace plus instance ID (16 bytes).");
      return paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    return "EddystoneUidPrefix{bytes=" + zzAW() + '}';
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */