package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import java.nio.ByteBuffer;
import java.util.UUID;

class zze
  extends zza
{
  public zze(byte[] paramArrayOfByte)
  {
    super(zzs(paramArrayOfByte));
  }
  
  private static byte[] zzs(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte.length == 16) || (paramArrayOfByte.length == 18) || (paramArrayOfByte.length == 20)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
      return paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    return "IBeaconIdPrefix{proximityUuid=" + zzAX() + ", major=" + zzBa() + ", minor=" + zzBb() + '}';
  }
  
  public UUID zzAX()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(getBytes());
    return new UUID(localByteBuffer.getLong(), localByteBuffer.getLong());
  }
  
  public Short zzBa()
  {
    byte[] arrayOfByte = getBytes();
    if (arrayOfByte.length >= 18) {
      return Short.valueOf(ByteBuffer.wrap(arrayOfByte).getShort(16));
    }
    return null;
  }
  
  public Short zzBb()
  {
    byte[] arrayOfByte = getBytes();
    if (arrayOfByte.length == 20) {
      return Short.valueOf(ByteBuffer.wrap(arrayOfByte).getShort(18));
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */