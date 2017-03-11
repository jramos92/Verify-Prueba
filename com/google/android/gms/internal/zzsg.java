package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzsg
{
  final int tag;
  final byte[] zzbiw;
  
  zzsg(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbiw = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzsg)) {
        return false;
      }
      paramObject = (zzsg)paramObject;
    } while ((this.tag == ((zzsg)paramObject).tag) && (Arrays.equals(this.zzbiw, ((zzsg)paramObject).zzbiw)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.zzbiw);
  }
  
  int zzB()
  {
    return 0 + zzrx.zzlO(this.tag) + this.zzbiw.length;
  }
  
  void zza(zzrx paramzzrx)
    throws IOException
  {
    paramzzrx.zzlN(this.tag);
    paramzzrx.zzF(this.zzbiw);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */