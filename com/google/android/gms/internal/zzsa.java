package com.google.android.gms.internal;

public final class zzsa
  implements Cloneable
{
  private static final zzsb zzbin = new zzsb();
  private int mSize;
  private boolean zzbio = false;
  private int[] zzbip;
  private zzsb[] zzbiq;
  
  zzsa()
  {
    this(10);
  }
  
  zzsa(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.zzbip = new int[paramInt];
    this.zzbiq = new zzsb[paramInt];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.zzbip;
    zzsb[] arrayOfzzsb = this.zzbiq;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      zzsb localzzsb = arrayOfzzsb[i];
      k = j;
      if (localzzsb != zzbin)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfzzsb[j] = localzzsb;
          arrayOfzzsb[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.zzbio = false;
    this.mSize = j;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzsb[] paramArrayOfzzsb1, zzsb[] paramArrayOfzzsb2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzsb1[i].equals(paramArrayOfzzsb2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzlT(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.zzbip[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzsa)) {
        return false;
      }
      paramObject = (zzsa)paramObject;
      if (size() != ((zzsa)paramObject).size()) {
        return false;
      }
    } while ((zza(this.zzbip, ((zzsa)paramObject).zzbip, this.mSize)) && (zza(this.zzbiq, ((zzsa)paramObject).zzbiq, this.mSize)));
    return false;
  }
  
  public int hashCode()
  {
    if (this.zzbio) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.zzbip[i]) * 31 + this.zzbiq[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    if (this.zzbio) {
      gc();
    }
    return this.mSize;
  }
  
  public final zzsa zzFH()
  {
    int i = 0;
    int j = size();
    zzsa localzzsa = new zzsa(j);
    System.arraycopy(this.zzbip, 0, localzzsa.zzbip, 0, j);
    while (i < j)
    {
      if (this.zzbiq[i] != null) {
        localzzsa.zzbiq[i] = this.zzbiq[i].zzFI();
      }
      i += 1;
    }
    localzzsa.mSize = j;
    return localzzsa;
  }
  
  void zza(int paramInt, zzsb paramzzsb)
  {
    int i = zzlT(paramInt);
    if (i >= 0)
    {
      this.zzbiq[i] = paramzzsb;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zzbiq[j] == zzbin))
    {
      this.zzbip[j] = paramInt;
      this.zzbiq[j] = paramzzsb;
      return;
    }
    i = j;
    if (this.zzbio)
    {
      i = j;
      if (this.mSize >= this.zzbip.length)
      {
        gc();
        i = zzlT(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.zzbip.length)
    {
      j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      zzsb[] arrayOfzzsb = new zzsb[j];
      System.arraycopy(this.zzbip, 0, arrayOfInt, 0, this.zzbip.length);
      System.arraycopy(this.zzbiq, 0, arrayOfzzsb, 0, this.zzbiq.length);
      this.zzbip = arrayOfInt;
      this.zzbiq = arrayOfzzsb;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.zzbip, i, this.zzbip, i + 1, this.mSize - i);
      System.arraycopy(this.zzbiq, i, this.zzbiq, i + 1, this.mSize - i);
    }
    this.zzbip[i] = paramInt;
    this.zzbiq[i] = paramzzsb;
    this.mSize += 1;
  }
  
  zzsb zzlR(int paramInt)
  {
    paramInt = zzlT(paramInt);
    if ((paramInt < 0) || (this.zzbiq[paramInt] == zzbin)) {
      return null;
    }
    return this.zzbiq[paramInt];
  }
  
  zzsb zzlS(int paramInt)
  {
    if (this.zzbio) {
      gc();
    }
    return this.zzbiq[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */