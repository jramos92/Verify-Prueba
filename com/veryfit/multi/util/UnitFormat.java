package com.veryfit.multi.util;

public class UnitFormat
{
  public static int[] cm2inch(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[1] = cm2inchs(paramInt);
    arrayOfInt[0] = (arrayOfInt[1] / 12);
    arrayOfInt[1] %= 12;
    return arrayOfInt;
  }
  
  public static int cm2inchs(int paramInt)
  {
    return Math.round(paramInt / 2.54F);
  }
  
  public static int inch2cm(int[] paramArrayOfInt)
  {
    paramArrayOfInt[1] = (paramArrayOfInt[0] * 12 + paramArrayOfInt[1]);
    return Math.round(paramArrayOfInt[1] * 2.54F);
  }
  
  public static int inchs2cm(int paramInt)
  {
    return Math.round(paramInt * 2.54F);
  }
  
  public static int kg2lb(int paramInt)
  {
    return Math.round(2.2046225F * paramInt);
  }
  
  public static float km2mile(float paramFloat)
  {
    String str = String.format("%.3f", new Object[] { Float.valueOf(0.62137F * paramFloat) }).replace(',', '.');
    return Float.parseFloat(str.substring(0, str.length() - 1));
  }
  
  public static int lb2kg(int paramInt)
  {
    return Math.round(paramInt / 2.2046225F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\UnitFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */