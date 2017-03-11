package com.google.android.gms.common.images;

public final class Size
{
  private final int zznQ;
  private final int zznR;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zznQ = paramInt1;
    this.zznR = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string must not be null");
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0) {
      throw zzch(paramString);
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw zzch(paramString);
    }
  }
  
  private static NumberFormatException zzch(String paramString)
  {
    throw new NumberFormatException("Invalid Size: \"" + paramString + "\"");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof Size));
    paramObject = (Size)paramObject;
    if ((this.zznQ == ((Size)paramObject).zznQ) && (this.zznR == ((Size)paramObject).zznR)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getHeight()
  {
    return this.zznR;
  }
  
  public int getWidth()
  {
    return this.zznQ;
  }
  
  public int hashCode()
  {
    return this.zznR ^ (this.zznQ << 16 | this.zznQ >>> 16);
  }
  
  public String toString()
  {
    return this.zznQ + "x" + this.zznR;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\images\Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */