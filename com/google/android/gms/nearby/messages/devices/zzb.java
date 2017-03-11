package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class zzb
{
  private final zzc zzaQx;
  
  public zzb(byte[] paramArrayOfByte)
  {
    this.zzaQx = new zzc(zzs(paramArrayOfByte));
  }
  
  private static byte[] zzs(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Bytes must be a namespace plus instance ID (16 bytes).");
      return paramArrayOfByte;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzb)) {
      return false;
    }
    paramObject = (zzb)paramObject;
    return zzw.equal(this.zzaQx, ((zzb)paramObject).zzaQx);
  }
  
  public String getId()
  {
    return this.zzaQx.zzAW();
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaQx });
  }
  
  public String toString()
  {
    return "EddystoneUid{id=" + getId() + '}';
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */