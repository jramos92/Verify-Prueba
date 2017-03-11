package com.project.library.device.cmd.blecontrol;

import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.util.UartLogUtil;

public class BleControlCmd
  extends DeviceBaseCommand
{
  public static final byte[] EVENT_TYPE = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  public static final byte KEY_CALL_CONTROL = 3;
  public static final byte KEY_EVENT_CONTROL = 1;
  public static final byte KEY_SEARCH_PHONE_CONTROL = 2;
  private static BleControlCmd mInstance = null;
  
  public static BleControlCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BleControlCmd();
      }
      BleControlCmd localBleControlCmd = mInstance;
      return localBleControlCmd;
    }
    finally {}
  }
  
  public byte[] getFoundPhone(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)7, (byte)2, new byte[] { paramByte });
    UartLogUtil.recordWrite("音乐", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte parse(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[2];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\blecontrol\BleControlCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */