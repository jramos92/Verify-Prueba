package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

public class zzig
{
  private final String[] zzIO;
  private final double[] zzIP;
  private final double[] zzIQ;
  private final int[] zzIR;
  private int zzIS;
  
  private zzig(zzb paramzzb)
  {
    int i = zzb.zza(paramzzb).size();
    this.zzIO = ((String[])zzb.zzb(paramzzb).toArray(new String[i]));
    this.zzIP = zzg(zzb.zza(paramzzb));
    this.zzIQ = zzg(zzb.zzc(paramzzb));
    this.zzIR = new int[i];
    this.zzIS = 0;
  }
  
  private double[] zzg(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(this.zzIO.length);
    int i = 0;
    while (i < this.zzIO.length)
    {
      localArrayList.add(new zza(this.zzIO[i], this.zzIQ[i], this.zzIP[i], this.zzIR[i] / this.zzIS, this.zzIR[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    this.zzIS += 1;
    int i = 0;
    for (;;)
    {
      if (i < this.zzIQ.length)
      {
        if ((this.zzIQ[i] <= paramDouble) && (paramDouble < this.zzIP[i]))
        {
          int[] arrayOfInt = this.zzIR;
          arrayOfInt[i] += 1;
        }
        if (paramDouble >= this.zzIQ[i]) {}
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzIT;
    public final double zzIU;
    public final double zzIV;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
    {
      this.name = paramString;
      this.zzIU = paramDouble1;
      this.zzIT = paramDouble2;
      this.zzIV = paramDouble3;
      this.count = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      do
      {
        return false;
        paramObject = (zza)paramObject;
      } while ((!zzw.equal(this.name, ((zza)paramObject).name)) || (this.zzIT != ((zza)paramObject).zzIT) || (this.zzIU != ((zza)paramObject).zzIU) || (this.count != ((zza)paramObject).count) || (Double.compare(this.zzIV, ((zza)paramObject).zzIV) != 0));
      return true;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { this.name, Double.valueOf(this.zzIT), Double.valueOf(this.zzIU), Double.valueOf(this.zzIV), Integer.valueOf(this.count) });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzIU)).zzg("maxBound", Double.valueOf(this.zzIT)).zzg("percent", Double.valueOf(this.zzIV)).zzg("count", Integer.valueOf(this.count)).toString();
    }
  }
  
  public static class zzb
  {
    private final List<String> zzIW = new ArrayList();
    private final List<Double> zzIX = new ArrayList();
    private final List<Double> zzIY = new ArrayList();
    
    public zzb zza(String paramString, double paramDouble1, double paramDouble2)
    {
      int i = 0;
      for (;;)
      {
        double d1;
        double d2;
        if (i < this.zzIW.size())
        {
          d1 = ((Double)this.zzIY.get(i)).doubleValue();
          d2 = ((Double)this.zzIX.get(i)).doubleValue();
          if (paramDouble1 >= d1) {
            break label107;
          }
        }
        label107:
        while ((d1 == paramDouble1) && (paramDouble2 < d2))
        {
          this.zzIW.add(i, paramString);
          this.zzIY.add(i, Double.valueOf(paramDouble1));
          this.zzIX.add(i, Double.valueOf(paramDouble2));
          return this;
        }
        i += 1;
      }
    }
    
    public zzig zzgK()
    {
      return new zzig(this, null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */