package com.project.library.device.datamanager;

import android.os.Handler;
import com.project.library.device.cmd.BindUnbindCmd;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.cmd.DeviceRestartCmd;
import com.project.library.device.cmd.WareUpdateCmd;
import com.project.library.device.cmd.appcontrol.AppControlCmd;
import com.project.library.device.cmd.blecontrol.BleControlCmd;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.protocol.AppBleNotifyListener;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import java.io.PrintStream;

public class NormalDataManager
  extends BaseDataManager
{
  protected byte[] mDeviceCtrolLastReceive = new byte[20];
  private NormalDataCallback mNormalDataCallback = null;
  
  private void dealNormal(final byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      this.mReceiveHandler.post(new Runnable()
      {
        public void run()
        {
          String str = ByteDataConvertUtil.bytesToHexString(paramArrayOfByte);
          DebugLog.e("收到普通数据\n" + str);
          if (DeviceBaseCommand.isDeciveCtrol(paramArrayOfByte)) {
            switch (DeviceBaseCommand.getCmdId(paramArrayOfByte))
            {
            }
          }
          for (;;)
          {
            DeviceBaseCommand.copy(paramArrayOfByte, NormalDataManager.this.mLastReceive);
            return;
            System.out.println("XXXXXXXXXXXXID_CMD_BLE_CONTROL");
            NormalDataManager.this.canWriteNext = true;
            NormalDataManager.this.write(paramArrayOfByte);
            DeviceBaseCommand.copy(paramArrayOfByte, NormalDataManager.this.mDeviceCtrolLastReceive);
            if (DeviceBaseCommand.getCmdKey(paramArrayOfByte) == 2)
            {
              NormalDataManager.this.reviceOtherData(paramArrayOfByte);
            }
            else
            {
              NormalDataManager.this.receivedBleCtrol(paramArrayOfByte);
              continue;
              if (DeviceBaseCommand.isNeedReply(NormalDataManager.this.mLastCommand))
              {
                int i = DeviceBaseCommand.getCmdId(paramArrayOfByte);
                if (DeviceBaseCommand.getCmdId(NormalDataManager.this.mLastCommand) == i) {
                  NormalDataManager.this.mWriteHandler.removeCallbacks(NormalDataManager.this.mWriteRunnable);
                }
                switch (i)
                {
                default: 
                  NormalDataManager.this.reviceOtherData(paramArrayOfByte);
                  break;
                case 1: 
                  NormalDataManager.this.receivedWareUpdateData(paramArrayOfByte);
                  break;
                case 2: 
                  NormalDataManager.this.receivedGetInfoData(paramArrayOfByte);
                  break;
                case 3: 
                  NormalDataManager.this.receivedSettingsData(paramArrayOfByte);
                  break;
                case 4: 
                  NormalDataManager.this.receivedBindUnbindData(paramArrayOfByte);
                  break;
                case 5: 
                  NormalDataManager.this.receivedNotifyData(paramArrayOfByte);
                  break;
                case -16: 
                  NormalDataManager.this.receivedRestartData(paramArrayOfByte);
                  break;
                case 6: 
                  NormalDataManager.this.receivedAppControlData(paramArrayOfByte);
                  break;
                }
              }
              else
              {
                DebugLog.e("other command/value");
              }
            }
          }
        }
      });
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  private void receivedAppControlData(byte[] paramArrayOfByte)
  {
    DebugLog.e("收到控制指令的返回");
    this.canWriteNext = true;
    AppControlCmd localAppControlCmd = AppControlCmd.getInstance();
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onAppControlSuccess(DeviceBaseCommand.getCmdKey(paramArrayOfByte), localAppControlCmd.parse(paramArrayOfByte));
    }
  }
  
  private void receivedBindUnbindData(byte[] paramArrayOfByte)
  {
    byte b = BindUnbindCmd.getInstance().parse(paramArrayOfByte);
    this.canWriteNext = true;
    if (b == 20) {
      if (this.mNormalDataCallback != null) {
        this.mNormalDataCallback.onUnbinded();
      }
    }
    while (this.mAppBleNotifyListener == null) {
      return;
    }
    this.mAppBleNotifyListener.onBindUnbind(b);
  }
  
  private void receivedBleCtrol(byte[] paramArrayOfByte)
  {
    DebugLog.e("收到拍照指令");
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onBleControlReceive(DeviceBaseCommand.getCmdKey(paramArrayOfByte), BleControlCmd.getInstance().parse(paramArrayOfByte));
    }
  }
  
  private void receivedGetInfoData(byte[] paramArrayOfByte)
  {
    GetInfoCmd.getInstance().parse(paramArrayOfByte);
    this.canWriteNext = true;
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onGetInfo(DeviceBaseCommand.getCmdKey(paramArrayOfByte));
    }
  }
  
  private void receivedNotifyData(byte[] paramArrayOfByte)
  {
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onOtherDataReceive(paramArrayOfByte);
    }
  }
  
  private void receivedRestartData(byte[] paramArrayOfByte)
  {
    int i = DeviceRestartCmd.getInstance().parse(paramArrayOfByte);
    this.canWriteNext = true;
    if (i == 0)
    {
      DebugLog.d("设备马上重启。");
      return;
    }
    DebugLog.d("设备重启不了哦。");
  }
  
  private void receivedSettingsData(byte[] paramArrayOfByte)
  {
    this.canWriteNext = true;
    SettingsCmd localSettingsCmd = SettingsCmd.getInstance();
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onSettingsSuccess(DeviceBaseCommand.getCmdKey(paramArrayOfByte), localSettingsCmd.parse(paramArrayOfByte));
    }
  }
  
  private void receivedWareUpdateData(byte[] paramArrayOfByte)
  {
    DebugLog.e("收到升级指令的返回");
    byte b = WareUpdateCmd.getInstance().parse(paramArrayOfByte);
    if (this.mNormalDataCallback != null) {
      this.mNormalDataCallback.onWareUpdate(b);
    }
  }
  
  public void init(AppBleNotifyListener paramAppBleNotifyListener, NormalDataCallback paramNormalDataCallback)
  {
    super.init(paramAppBleNotifyListener);
    this.mNormalDataCallback = paramNormalDataCallback;
  }
  
  public boolean isNeedReply(byte[] paramArrayOfByte)
  {
    return DeviceBaseCommand.isNeedReply(paramArrayOfByte);
  }
  
  public void onCommandWriteSuccess(byte[] paramArrayOfByte)
  {
    super.onCommandWriteSuccess(paramArrayOfByte);
    if (DeviceBaseCommand.isDeciveCtrol(paramArrayOfByte))
    {
      this.mWriteHandler.removeCallbacks(this.mWriteRunnable);
      this.canWriteNext = true;
    }
  }
  
  public void receive(byte[] paramArrayOfByte, String paramString)
  {
    dealNormal(paramArrayOfByte, paramString);
  }
  
  protected void reviceOtherData(byte[] paramArrayOfByte)
  {
    DebugLog.e("收到不明指令，前端自己解析");
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onOtherDataReceive(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\datamanager\NormalDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */