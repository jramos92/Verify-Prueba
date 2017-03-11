package com.project.library.device.cmd.health;

import com.project.library.util.UartLogUtil;

public class HealthSyncRequest
  extends HealthDataCmd
{
  private static HealthSyncRequest mInstance = null;
  
  public static HealthSyncRequest getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new HealthSyncRequest();
      }
      HealthSyncRequest localHealthSyncRequest = mInstance;
      return localHealthSyncRequest;
    }
    finally {}
  }
  
  public byte[] getHealthSyncRequestCmd(byte paramByte1, byte paramByte2)
  {
    byte[] arrayOfByte = createCmd((byte)1, new byte[] { paramByte1, paramByte2 });
    UartLogUtil.recordWrite("开始同步", arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\health\HealthSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */