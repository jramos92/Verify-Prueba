package com.project.library.device.cmd.health;

import com.project.library.util.UartLogUtil;

public class HealthSyncSuccess
  extends HealthDataCmd
{
  private static HealthSyncSuccess mInstance = null;
  
  public static HealthSyncSuccess getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new HealthSyncSuccess();
      }
      HealthSyncSuccess localHealthSyncSuccess = mInstance;
      return localHealthSyncSuccess;
    }
    finally {}
  }
  
  public byte[] getHealthSyncSuccessCmd(byte paramByte1, byte paramByte2)
  {
    byte[] arrayOfByte = createCmd((byte)2, new byte[] { paramByte1, paramByte2 });
    UartLogUtil.recordWrite("结束同步", arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthSyncSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */