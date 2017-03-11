package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza
{
  private static int zzbbn = 0;
  private static final Object zzpy = new Object();
  private SparseArray<Integer> zzbbo = new SparseArray();
  private SparseArray<Integer> zzbbp = new SparseArray();
  
  public int zzjE(int paramInt)
  {
    synchronized (zzpy)
    {
      Integer localInteger = (Integer)this.zzbbo.get(paramInt);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        return paramInt;
      }
      int i = zzbbn;
      zzbbn += 1;
      this.zzbbo.append(paramInt, Integer.valueOf(i));
      this.zzbbp.append(i, Integer.valueOf(paramInt));
      return i;
    }
  }
  
  public int zzjF(int paramInt)
  {
    synchronized (zzpy)
    {
      paramInt = ((Integer)this.zzbbp.get(paramInt)).intValue();
      return paramInt;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */