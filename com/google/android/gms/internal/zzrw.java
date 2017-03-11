package com.google.android.gms.internal;

import java.io.IOException;

public final class zzrw
{
  private final byte[] buffer;
  private int zzbia;
  private int zzbib;
  private int zzbic;
  private int zzbid;
  private int zzbie;
  private int zzbif = Integer.MAX_VALUE;
  private int zzbig;
  private int zzbih = 64;
  private int zzbii = 67108864;
  
  private zzrw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.zzbia = paramInt1;
    this.zzbib = (paramInt1 + paramInt2);
    this.zzbid = paramInt1;
  }
  
  public static zzrw zzB(byte[] paramArrayOfByte)
  {
    return zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void zzFz()
  {
    this.zzbib += this.zzbic;
    int i = this.zzbib;
    if (i > this.zzbif)
    {
      this.zzbic = (i - this.zzbif);
      this.zzbib -= this.zzbic;
      return;
    }
    this.zzbic = 0;
  }
  
  public static long zzX(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public static zzrw zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzrw(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zzlB(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public int getPosition()
  {
    return this.zzbid - this.zzbia;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = zzFv();
    if ((i <= this.zzbib - this.zzbid) && (i > 0))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.zzbid, arrayOfByte, 0, i);
      this.zzbid = (i + this.zzbid);
      return arrayOfByte;
    }
    if (i == 0) {
      return zzsh.zzbiE;
    }
    return zzlF(i);
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzFy());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzFx());
  }
  
  public String readString()
    throws IOException
  {
    int i = zzFv();
    if ((i <= this.zzbib - this.zzbid) && (i > 0))
    {
      String str = new String(this.buffer, this.zzbid, i, "UTF-8");
      this.zzbid = (i + this.zzbid);
      return str;
    }
    return new String(zzlF(i), "UTF-8");
  }
  
  public int zzFA()
  {
    if (this.zzbif == Integer.MAX_VALUE) {
      return -1;
    }
    int i = this.zzbid;
    return this.zzbif - i;
  }
  
  public boolean zzFB()
  {
    return this.zzbid == this.zzbib;
  }
  
  public byte zzFC()
    throws IOException
  {
    if (this.zzbid == this.zzbib) {
      throw zzsd.zzFJ();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.zzbid;
    this.zzbid = (i + 1);
    return arrayOfByte[i];
  }
  
  public int zzFo()
    throws IOException
  {
    if (zzFB())
    {
      this.zzbie = 0;
      return 0;
    }
    this.zzbie = zzFv();
    if (this.zzbie == 0) {
      throw zzsd.zzFM();
    }
    return this.zzbie;
  }
  
  public void zzFp()
    throws IOException
  {
    int i;
    do
    {
      i = zzFo();
    } while ((i != 0) && (zzlA(i)));
  }
  
  public long zzFq()
    throws IOException
  {
    return zzFw();
  }
  
  public int zzFr()
    throws IOException
  {
    return zzFv();
  }
  
  public boolean zzFs()
    throws IOException
  {
    return zzFv() != 0;
  }
  
  public int zzFt()
    throws IOException
  {
    return zzlB(zzFv());
  }
  
  public long zzFu()
    throws IOException
  {
    return zzX(zzFw());
  }
  
  public int zzFv()
    throws IOException
  {
    int i = zzFC();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzFC();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzFC();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzFC();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzFC();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzFC() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzsd.zzFL();
  }
  
  public long zzFw()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzFC();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzsd.zzFL();
  }
  
  public int zzFx()
    throws IOException
  {
    return zzFC() & 0xFF | (zzFC() & 0xFF) << 8 | (zzFC() & 0xFF) << 16 | (zzFC() & 0xFF) << 24;
  }
  
  public long zzFy()
    throws IOException
  {
    int i = zzFC();
    int j = zzFC();
    int k = zzFC();
    int m = zzFC();
    int n = zzFC();
    int i1 = zzFC();
    int i2 = zzFC();
    int i3 = zzFC();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public void zza(zzse paramzzse)
    throws IOException
  {
    int i = zzFv();
    if (this.zzbig >= this.zzbih) {
      throw zzsd.zzFP();
    }
    i = zzlC(i);
    this.zzbig += 1;
    paramzzse.zzb(this);
    zzlz(0);
    this.zzbig -= 1;
    zzlD(i);
  }
  
  public void zza(zzse paramzzse, int paramInt)
    throws IOException
  {
    if (this.zzbig >= this.zzbih) {
      throw zzsd.zzFP();
    }
    this.zzbig += 1;
    paramzzse.zzb(this);
    zzlz(zzsh.zzD(paramInt, 4));
    this.zzbig -= 1;
  }
  
  public boolean zzlA(int paramInt)
    throws IOException
  {
    switch (zzsh.zzlU(paramInt))
    {
    default: 
      throw zzsd.zzFO();
    case 0: 
      zzFr();
      return true;
    case 1: 
      zzFy();
      return true;
    case 2: 
      zzlG(zzFv());
      return true;
    case 3: 
      zzFp();
      zzlz(zzsh.zzD(zzsh.zzlV(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzFx();
    return true;
  }
  
  public int zzlC(int paramInt)
    throws zzsd
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    paramInt = this.zzbid + paramInt;
    int i = this.zzbif;
    if (paramInt > i) {
      throw zzsd.zzFJ();
    }
    this.zzbif = paramInt;
    zzFz();
    return i;
  }
  
  public void zzlD(int paramInt)
  {
    this.zzbif = paramInt;
    zzFz();
  }
  
  public void zzlE(int paramInt)
  {
    if (paramInt > this.zzbid - this.zzbia) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (this.zzbid - this.zzbia));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    this.zzbid = (this.zzbia + paramInt);
  }
  
  public byte[] zzlF(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    if (this.zzbid + paramInt > this.zzbif)
    {
      zzlG(this.zzbif - this.zzbid);
      throw zzsd.zzFJ();
    }
    if (paramInt <= this.zzbib - this.zzbid)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, this.zzbid, arrayOfByte, 0, paramInt);
      this.zzbid += paramInt;
      return arrayOfByte;
    }
    throw zzsd.zzFJ();
  }
  
  public void zzlG(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzsd.zzFK();
    }
    if (this.zzbid + paramInt > this.zzbif)
    {
      zzlG(this.zzbif - this.zzbid);
      throw zzsd.zzFJ();
    }
    if (paramInt <= this.zzbib - this.zzbid)
    {
      this.zzbid += paramInt;
      return;
    }
    throw zzsd.zzFJ();
  }
  
  public void zzlz(int paramInt)
    throws zzsd
  {
    if (this.zzbie != paramInt) {
      throw zzsd.zzFN();
    }
  }
  
  public byte[] zzx(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzsh.zzbiE;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzbia;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */