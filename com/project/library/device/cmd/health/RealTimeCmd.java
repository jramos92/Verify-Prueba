package com.project.library.device.cmd.health;

public class RealTimeCmd
  extends HealthDataCmd
{
  private static final byte[] VALUE = new byte[12];
  private static RealTimeCmd mInstance = null;
  private int heart_rate = 0;
  private int total_active_time = 0;
  private int total_calories = 0;
  private int total_distances = 0;
  private int total_step = 0;
  
  public static RealTimeCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new RealTimeCmd();
      }
      RealTimeCmd localRealTimeCmd = mInstance;
      return localRealTimeCmd;
    }
    finally {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\RealTimeCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */