package com.project.library.device.cmd;

import com.project.library.util.UartLogUtil;

public class DeviceRestartCmd
  extends DeviceBaseCommand
{
  private static final byte[] BYTES_CMD;
  public static final byte KEY = 1;
  public static final byte STATUS_FAIL = 2;
  private static final int STATUS_INDEX = 2;
  public static final byte STATUS_NOT_SUPPORT = 3;
  public static final byte STATUS_SUCCESS = 0;
  public static final byte[] VALUE = { 85, 85, -86, -86, 85, 85, -86, -86, 85, 85, -86, -86 };
  private static DeviceRestartCmd mInstance = null;
  
  static
  {
    byte[] arrayOfByte = new byte[20];
    arrayOfByte[0] = -16;
    arrayOfByte[1] = 1;
    arrayOfByte[2] = 85;
    arrayOfByte[3] = 85;
    arrayOfByte[4] = -86;
    arrayOfByte[5] = -86;
    arrayOfByte[6] = 85;
    arrayOfByte[7] = 85;
    arrayOfByte[8] = -86;
    arrayOfByte[9] = -86;
    arrayOfByte[10] = 85;
    arrayOfByte[11] = 85;
    arrayOfByte[12] = -86;
    arrayOfByte[13] = -86;
    BYTES_CMD = arrayOfByte;
  }
  
  public static DeviceRestartCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DeviceRestartCmd();
      }
      DeviceRestartCmd localDeviceRestartCmd = mInstance;
      return localDeviceRestartCmd;
    }
    finally {}
  }
  
  public byte[] getDeviceRestartCmd()
  {
    UartLogUtil.recordWrite("发送设备重启命令", BYTES_CMD);
    return BYTES_CMD;
  }
  
  public byte parse(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[2];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\DeviceRestartCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */