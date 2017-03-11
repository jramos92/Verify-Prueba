package com.project.library.device.cmd.appcontrol;

import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.util.UartLogUtil;

public class AppControlCmd
  extends DeviceBaseCommand
{
  private static final byte CONTROL_SUCCESS = 0;
  public static final byte KEY_CAMERA_CONTROL = 2;
  public static final byte KEY_MIC_CONTROL = 1;
  public static final byte KEY_SEARCH_WRISTBAND_CONTROL = 4;
  public static final byte KEY_SINGLE_SPORT_CONTROL = 3;
  private static AppControlCmd mInstance = null;
  
  public static AppControlCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new AppControlCmd();
      }
      AppControlCmd localAppControlCmd = mInstance;
      return localAppControlCmd;
    }
    finally {}
  }
  
  public byte[] getCameraCmd(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)2, new byte[] { paramByte });
    UartLogUtil.recordWrite("发送拍照命令", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getMicCmd(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)1, new byte[] { paramByte });
    UartLogUtil.recordWrite("音乐", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSearchWristbandCmd(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)4, new byte[] { paramByte });
    UartLogUtil.recordWrite("发送寻找手环命令 ", arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getSingleSportCmd(byte paramByte)
  {
    byte[] arrayOfByte = createCmd((byte)6, (byte)3, new byte[] { paramByte });
    UartLogUtil.recordWrite("发送单次运动", arrayOfByte);
    return arrayOfByte;
  }
  
  public boolean parse(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[2] == 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\appcontrol\AppControlCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */