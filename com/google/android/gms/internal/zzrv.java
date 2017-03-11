package com.google.android.gms.internal;

public class zzrv
{
  private final byte[] zzbhX = new byte['Ā'];
  private int zzbhY;
  private int zzbhZ;
  
  public zzrv(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.zzbhX[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.zzbhX[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.zzbhX[j];
      this.zzbhX[j] = this.zzbhX[k];
      this.zzbhX[k] = i;
      j += 1;
    }
    this.zzbhY = 0;
    this.zzbhZ = 0;
  }
  
  public void zzA(byte[] paramArrayOfByte)
  {
    int m = this.zzbhY;
    int k = this.zzbhZ;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.zzbhX[m] & 0xFF;
      int i = this.zzbhX[m];
      this.zzbhX[m] = this.zzbhX[k];
      this.zzbhX[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.zzbhX[(this.zzbhX[m] + this.zzbhX[k] & 0xFF)]));
      j += 1;
    }
    this.zzbhY = m;
    this.zzbhZ = k;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */