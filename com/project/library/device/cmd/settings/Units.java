package com.project.library.device.cmd.settings;

public class Units
{
  public static final int BRITISH = 2;
  public static final int LANGUAGE_EN = 2;
  public static final int LANGUAGE_ZH = 1;
  public static final int METRIC = 1;
  public static final int TIME_MODE_12 = 2;
  public static final int TIME_MODE_24 = 1;
  public static final int UNIT_DIST_KM = 1;
  public static final int UNIT_DIST_MI = 2;
  public static final int UNIT_ERROR = 0;
  public static final int UNIT_STRIDE_CM = 1;
  public static final int UNIT_STRIDE_CMXX = 2;
  public static final int UNIT_TEMP_C = 1;
  public static final int UNIT_TEMP_F = 2;
  public static final int UNIT_WEIGHT_KG = 1;
  public static final int UNIT_WEIGHT_LB = 2;
  public int dist;
  public int language;
  public int stride;
  public int temp;
  public int timeMode;
  public int weight;
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.dist = 1;
      this.weight = 1;
      this.temp = 1;
    }
    while (paramInt != 2) {
      return;
    }
    this.dist = 2;
    this.weight = 2;
    this.temp = 2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\settings\Units.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */