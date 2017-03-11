package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzrz<M extends zzry<M>, T>
{
  public final int tag;
  protected final int type;
  protected final Class<T> zzbil;
  protected final boolean zzbim;
  
  private zzrz(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.zzbil = paramClass;
    this.tag = paramInt2;
    this.zzbim = paramBoolean;
  }
  
  private T zzF(List<zzsg> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (zzsg)paramList.get(i);
      if (((zzsg)localObject).zzbiw.length != 0) {
        zza((zzsg)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.zzbil.cast(Array.newInstance(this.zzbil.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<zzsg>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T zzG(List<zzsg> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (zzsg)paramList.get(paramList.size() - 1);
    return (T)this.zzbil.cast(zzF(zzrw.zzB(paramList.zzbiw)));
  }
  
  public static <M extends zzry<M>, T extends zzse> zzrz<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzrz(paramInt, paramClass, (int)paramLong, false);
  }
  
  final T zzE(List<zzsg> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.zzbim) {
      return (T)zzF(paramList);
    }
    return (T)zzG(paramList);
  }
  
  protected Object zzF(zzrw paramzzrw)
  {
    Class localClass;
    if (this.zzbim) {
      localClass = this.zzbil.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (InstantiationException paramzzrw)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramzzrw);
        localClass = this.zzbil;
        continue;
        zzse localzzse = (zzse)localClass.newInstance();
        paramzzrw.zza(localzzse, zzsh.zzlV(this.tag));
        return localzzse;
        localzzse = (zzse)localClass.newInstance();
        paramzzrw.zza(localzzse);
        return localzzse;
      }
      catch (IllegalAccessException paramzzrw)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramzzrw);
      }
      catch (IOException paramzzrw)
      {
        throw new IllegalArgumentException("Error reading extension field", paramzzrw);
      }
    }
  }
  
  int zzX(Object paramObject)
  {
    if (this.zzbim) {
      return zzY(paramObject);
    }
    return zzZ(paramObject);
  }
  
  protected int zzY(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzZ(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int zzZ(Object paramObject)
  {
    int i = zzsh.zzlV(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      return zzrx.zzb(i, (zzse)paramObject);
    }
    return zzrx.zzc(i, (zzse)paramObject);
  }
  
  protected void zza(zzsg paramzzsg, List<Object> paramList)
  {
    paramList.add(zzF(zzrw.zzB(paramzzsg.zzbiw)));
  }
  
  void zza(Object paramObject, zzrx paramzzrx)
    throws IOException
  {
    if (this.zzbim)
    {
      zzc(paramObject, paramzzrx);
      return;
    }
    zzb(paramObject, paramzzrx);
  }
  
  protected void zzb(Object paramObject, zzrx paramzzrx)
  {
    for (;;)
    {
      try
      {
        paramzzrx.zzlN(this.tag);
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (zzse)paramObject;
      int i = zzsh.zzlV(this.tag);
      paramzzrx.zzb((zzse)paramObject);
      paramzzrx.zzC(i, 4);
      return;
      paramzzrx.zzc((zzse)paramObject);
      return;
    }
  }
  
  protected void zzc(Object paramObject, zzrx paramzzrx)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzzrx);
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */