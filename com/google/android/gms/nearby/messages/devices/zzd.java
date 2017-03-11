package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

public class zzd
{
  private final zze zzaQy;
  
  public zzd(byte[] paramArrayOfByte)
  {
    this.zzaQy = new zze(zzs(paramArrayOfByte));
  }
  
  private static byte[] zzs(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 20) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
      return paramArrayOfByte;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzd)) {
      return false;
    }
    paramObject = (zzd)paramObject;
    return zzw.equal(this.zzaQy, ((zzd)paramObject).zzaQy);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaQy });
  }
  
  public String toString()
  {
    return "IBeaconId{proximityUuid=" + zzAX() + ", major=" + zzAY() + ", minor=" + zzAZ() + '}';
  }
  
  public UUID zzAX()
  {
    return this.zzaQy.zzAX();
  }
  
  public short zzAY()
  {
    return this.zzaQy.zzBa().shortValue();
  }
  
  public short zzAZ()
  {
    return this.zzaQy.zzBb().shortValue();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */