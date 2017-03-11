package com.project.library.device.cmd;

import android.os.Build.VERSION;
import com.project.library.util.UartLogUtil;

public class BindUnbindCmd
  extends DeviceBaseCommand
{
  private static final byte KEY_BIND = 1;
  private static final byte KEY_UNBIND = 2;
  public static final byte STATUS_BIND_FAILED = 19;
  public static final byte STATUS_BIND_SUCCESS = 18;
  private static final byte STATUS_SUCCESS = 0;
  public static final byte STATUS_UNBIND_FAILED = 21;
  public static final byte STATUS_UNBIND_SUCCESS = 20;
  private static final byte[] VALUE_BIND = { 2, (byte)Build.VERSION.SDK_INT, 85, -86 };
  private static final byte[] VALUE_UNBIND = { 85, -86, 85, -86 };
  private static BindUnbindCmd mInstance = null;
  
  public static BindUnbindCmd getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BindUnbindCmd();
      }
      BindUnbindCmd localBindUnbindCmd = mInstance;
      return localBindUnbindCmd;
    }
    finally {}
  }
  
  public byte[] getBindCmd()
  {
    UartLogUtil.recordWrite("发送绑定命令", createCmd((byte)4, (byte)1, VALUE_BIND));
    return createCmd((byte)4, (byte)1, VALUE_BIND);
  }
  
  public byte[] getUnbindCmd()
  {
    UartLogUtil.recordWrite("发送解绑命令", createCmd((byte)4, (byte)2, VALUE_UNBIND));
    return createCmd((byte)4, (byte)2, VALUE_UNBIND);
  }
  
  public byte parse(byte[] paramArrayOfByte)
  {
    int i = getCmdKey(paramArrayOfByte);
    int j = paramArrayOfByte[2];
    if (i == 1)
    {
      if (j == 0) {
        return 18;
      }
      return 19;
    }
    if (j == 0) {
      return 20;
    }
    return 21;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\cmd\BindUnbindCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */