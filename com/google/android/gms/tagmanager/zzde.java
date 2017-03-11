package com.google.android.gms.tagmanager;

class zzde
  extends Number
  implements Comparable<zzde>
{
  private double zzaZG;
  private long zzaZH;
  private boolean zzaZI;
  
  private zzde(double paramDouble)
  {
    this.zzaZG = paramDouble;
    this.zzaZI = false;
  }
  
  private zzde(long paramLong)
  {
    this.zzaZH = paramLong;
    this.zzaZI = true;
  }
  
  public static zzde zzW(long paramLong)
  {
    return new zzde(paramLong);
  }
  
  public static zzde zza(Double paramDouble)
  {
    return new zzde(paramDouble.doubleValue());
  }
  
  public static zzde zzfd(String paramString)
    throws NumberFormatException
  {
    try
    {
      zzde localzzde1 = new zzde(Long.parseLong(paramString));
      return localzzde1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        zzde localzzde2 = new zzde(Double.parseDouble(paramString));
        return localzzde2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(paramString + " is not a valid TypedNumber");
      }
    }
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (zzDN()) {
      return this.zzaZH;
    }
    return this.zzaZG;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzde)) && (zza((zzde)paramObject) == 0);
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return zzDP();
  }
  
  public long longValue()
  {
    return zzDO();
  }
  
  public short shortValue()
  {
    return zzDQ();
  }
  
  public String toString()
  {
    if (zzDN()) {
      return Long.toString(this.zzaZH);
    }
    return Double.toString(this.zzaZG);
  }
  
  public boolean zzDM()
  {
    return !zzDN();
  }
  
  public boolean zzDN()
  {
    return this.zzaZI;
  }
  
  public long zzDO()
  {
    if (zzDN()) {
      return this.zzaZH;
    }
    return this.zzaZG;
  }
  
  public int zzDP()
  {
    return (int)longValue();
  }
  
  public short zzDQ()
  {
    return (short)(int)longValue();
  }
  
  public int zza(zzde paramzzde)
  {
    if ((zzDN()) && (paramzzde.zzDN())) {
      return new Long(this.zzaZH).compareTo(Long.valueOf(paramzzde.zzaZH));
    }
    return Double.compare(doubleValue(), paramzzde.doubleValue());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */