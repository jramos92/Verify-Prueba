package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzsb
  implements Cloneable
{
  private zzrz<?, ?> zzbir;
  private Object zzbis;
  private List<zzsg> zzbit = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzB()];
    zza(zzrx.zzC(arrayOfByte));
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzsb));
      paramObject = (zzsb)paramObject;
      if ((this.zzbis == null) || (((zzsb)paramObject).zzbis == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzbir != ((zzsb)paramObject).zzbir);
    if (!this.zzbir.zzbil.isArray()) {
      return this.zzbis.equals(((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof byte[])) {
      return Arrays.equals((byte[])this.zzbis, (byte[])((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof int[])) {
      return Arrays.equals((int[])this.zzbis, (int[])((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof long[])) {
      return Arrays.equals((long[])this.zzbis, (long[])((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof float[])) {
      return Arrays.equals((float[])this.zzbis, (float[])((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof double[])) {
      return Arrays.equals((double[])this.zzbis, (double[])((zzsb)paramObject).zzbis);
    }
    if ((this.zzbis instanceof boolean[])) {
      return Arrays.equals((boolean[])this.zzbis, (boolean[])((zzsb)paramObject).zzbis);
    }
    return Arrays.deepEquals((Object[])this.zzbis, (Object[])((zzsb)paramObject).zzbis);
    if ((this.zzbit != null) && (((zzsb)paramObject).zzbit != null)) {
      return this.zzbit.equals(((zzsb)paramObject).zzbit);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzsb)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  int zzB()
  {
    int j;
    if (this.zzbis != null)
    {
      j = this.zzbir.zzX(this.zzbis);
      return j;
    }
    Iterator localIterator = this.zzbit.iterator();
    for (int i = 0;; i = ((zzsg)localIterator.next()).zzB() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public final zzsb zzFI()
  {
    int i = 0;
    zzsb localzzsb = new zzsb();
    try
    {
      localzzsb.zzbir = this.zzbir;
      if (this.zzbit == null) {
        localzzsb.zzbit = null;
      }
      while (this.zzbis == null)
      {
        return localzzsb;
        localzzsb.zzbit.addAll(this.zzbit);
      }
      if (!(this.zzbis instanceof zzse)) {
        break label92;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.zzbis = ((zzse)this.zzbis).zzFG();
    return localCloneNotSupportedException;
    label92:
    if ((this.zzbis instanceof byte[]))
    {
      localCloneNotSupportedException.zzbis = ((byte[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    if ((this.zzbis instanceof byte[][]))
    {
      localObject1 = (byte[][])this.zzbis;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.zzbis = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.zzbis instanceof boolean[]))
    {
      localCloneNotSupportedException.zzbis = ((boolean[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbis instanceof int[]))
    {
      localCloneNotSupportedException.zzbis = ((int[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbis instanceof long[]))
    {
      localCloneNotSupportedException.zzbis = ((long[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbis instanceof float[]))
    {
      localCloneNotSupportedException.zzbis = ((float[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbis instanceof double[]))
    {
      localCloneNotSupportedException.zzbis = ((double[])this.zzbis).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbis instanceof zzse[]))
    {
      localObject1 = (zzse[])this.zzbis;
      localObject2 = new zzse[localObject1.length];
      localCloneNotSupportedException.zzbis = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].zzFG();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  void zza(zzrx paramzzrx)
    throws IOException
  {
    if (this.zzbis != null) {
      this.zzbir.zza(this.zzbis, paramzzrx);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.zzbit.iterator();
      while (localIterator.hasNext()) {
        ((zzsg)localIterator.next()).zza(paramzzrx);
      }
    }
  }
  
  void zza(zzsg paramzzsg)
  {
    this.zzbit.add(paramzzsg);
  }
  
  <T> T zzb(zzrz<?, T> paramzzrz)
  {
    if (this.zzbis != null)
    {
      if (this.zzbir != paramzzrz) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      this.zzbir = paramzzrz;
      this.zzbis = paramzzrz.zzE(this.zzbit);
      this.zzbit = null;
    }
    return (T)this.zzbis;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */