package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean zzadD = false;
  private ArrayList<Integer> zzadE;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzoz()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.zzadD) {
          break label193;
        }
        int j = this.zzabq.getCount();
        this.zzadE = new ArrayList();
        if (j <= 0) {
          break label188;
        }
        this.zzadE.add(Integer.valueOf(0));
        String str3 = zzoy();
        i = this.zzabq.zzbt(0);
        String str1 = this.zzabq.zzd(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label188;
        }
        int k = this.zzabq.zzbt(i);
        str2 = this.zzabq.zzd(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException("Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.zzadE.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label196;
        label188:
        this.zzadD = true;
        label193:
        return;
      }
      label196:
      i += 1;
    }
  }
  
  public final T get(int paramInt)
  {
    zzoz();
    return (T)zzj(zzbw(paramInt), zzbx(paramInt));
  }
  
  public int getCount()
  {
    zzoz();
    return this.zzadE.size();
  }
  
  int zzbw(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.zzadE.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.zzadE.get(paramInt)).intValue();
  }
  
  protected int zzbx(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.zzadE.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.zzadE.size() - 1) {}
    for (int i = this.zzabq.getCount() - ((Integer)this.zzadE.get(paramInt)).intValue();; i = ((Integer)this.zzadE.get(paramInt + 1)).intValue() - ((Integer)this.zzadE.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = zzbw(paramInt);
      int k = this.zzabq.zzbt(paramInt);
      String str = zzoA();
      j = i;
      if (str == null) {
        break;
      }
      j = i;
      if (this.zzabq.zzd(str, paramInt, k) != null) {
        break;
      }
      return 0;
    }
  }
  
  protected abstract T zzj(int paramInt1, int paramInt2);
  
  protected String zzoA()
  {
    return null;
  }
  
  protected abstract String zzoy();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\data\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */