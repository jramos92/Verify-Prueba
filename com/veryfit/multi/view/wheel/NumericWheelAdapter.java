package com.veryfit.multi.view.wheel;

public class NumericWheelAdapter
  implements WheelAdapter
{
  public static final int DEFAULT_MAX_VALUE = 9;
  private static final int DEFAULT_MIN_VALUE = 0;
  private String format;
  private int maxValue;
  private int minValue;
  
  public NumericWheelAdapter()
  {
    this(0, 9);
  }
  
  public NumericWheelAdapter(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public NumericWheelAdapter(int paramInt1, int paramInt2, String paramString)
  {
    this.minValue = paramInt1;
    this.maxValue = paramInt2;
    this.format = paramString;
  }
  
  public String getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      paramInt = this.minValue + paramInt;
      if (this.format != null) {
        return String.format(this.format, new Object[] { Integer.valueOf(paramInt) });
      }
      return Integer.toString(paramInt);
    }
    return null;
  }
  
  public int getItemsCount()
  {
    return this.maxValue - this.minValue + 1;
  }
  
  public int getMaximumLength()
  {
    int j = Integer.toString(Math.max(Math.abs(this.maxValue), Math.abs(this.minValue))).length();
    int i = j;
    if (this.minValue < 0) {
      i = j + 1;
    }
    return i;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\wheel\NumericWheelAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */