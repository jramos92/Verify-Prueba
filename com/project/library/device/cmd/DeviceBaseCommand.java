package com.project.library.device.cmd;

import com.project.library.util.ArrayUtils;

public abstract class DeviceBaseCommand
{
  public static final int BYTE_LEN_DATA = 18;
  public static final int BYTE_LEN_TOTAL = 20;
  private static final byte[] DEVICE_CTROLS = { 7 };
  private static final byte ERROR = -1;
  public static final byte ID_CMD_APP_CONTROL = 6;
  public static final byte ID_CMD_BIND_UNBIND = 4;
  public static final byte ID_CMD_BLE_CONTROL = 7;
  public static final byte ID_CMD_DEVICE_RESTART = -16;
  public static final byte ID_CMD_DUMP_STACK = 32;
  public static final byte ID_CMD_FACTORY = -86;
  public static final byte ID_CMD_GET_INFO = 2;
  public static final byte ID_CMD_HEALTH_DATA = 8;
  public static final byte ID_CMD_LOG = 33;
  public static final byte ID_CMD_NOTIFY = 5;
  public static final byte ID_CMD_SETTINGS = 3;
  public static final byte ID_CMD_WARE_UPDATE = 1;
  protected static final int INDEX_COMMAND_ID = 0;
  protected static final int INDEX_KEY = 1;
  private static final byte[] REPLYS = { 1, 2, 3, 4, 5, 6, 8, 32, 33, -86, -16 };
  
  public static void copy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return;
    }
    int i = paramArrayOfByte1.length;
    int j = paramArrayOfByte2.length;
    if (i < j) {}
    for (;;)
    {
      j = 0;
      while (j < i)
      {
        paramArrayOfByte2[j] = paramArrayOfByte1[j];
        j += 1;
      }
      break;
      i = j;
    }
  }
  
  private byte[] createNullCmd()
  {
    byte[] arrayOfByte = new byte[20];
    int i = 0;
    for (;;)
    {
      if (i >= 20) {
        return arrayOfByte;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  public static byte getCmdId(byte[] paramArrayOfByte)
  {
    byte b2 = -1;
    byte b1 = b2;
    if (paramArrayOfByte != null)
    {
      b1 = b2;
      if (paramArrayOfByte.length == 20) {
        b1 = paramArrayOfByte[0];
      }
    }
    return b1;
  }
  
  public static byte getCmdKey(byte[] paramArrayOfByte)
  {
    byte b2 = -1;
    byte b1 = b2;
    if (paramArrayOfByte != null)
    {
      b1 = b2;
      if (paramArrayOfByte.length == 20) {
        b1 = paramArrayOfByte[1];
      }
    }
    return b1;
  }
  
  public static boolean isCmdEquals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= 20) {
        return true;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
  }
  
  public static boolean isDeciveCtrol(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (ArrayUtils.contains(DEVICE_CTROLS, getCmdId(paramArrayOfByte))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isHealthCmd(byte[] paramArrayOfByte)
  {
    return getCmdId(paramArrayOfByte) == 8;
  }
  
  public static boolean isNeedReply(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte != null)
    {
      bool1 = bool2;
      if (ArrayUtils.contains(REPLYS, getCmdId(paramArrayOfByte))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected byte[] createCmd(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    byte[] arrayOfByte = createNullCmd();
    arrayOfByte[0] = paramByte1;
    arrayOfByte[1] = paramByte2;
    arrayOfByte[2] = paramByte3;
    return arrayOfByte;
  }
  
  protected byte[] createCmd(byte paramByte1, byte paramByte2, byte[] paramArrayOfByte)
  {
    int j = 0;
    byte[] arrayOfByte = createNullCmd();
    arrayOfByte[0] = paramByte1;
    arrayOfByte[1] = paramByte2;
    int m = paramArrayOfByte.length;
    int k;
    for (int i = 2;; i = k)
    {
      if (j >= m) {}
      do
      {
        return arrayOfByte;
        paramByte1 = paramArrayOfByte[j];
        k = i + 1;
        arrayOfByte[i] = paramByte1;
      } while (k >= 20);
      j += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\DeviceBaseCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */