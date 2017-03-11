package com.project.library.device.datamanager;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Handler;
import android.os.HandlerThread;
import com.project.library.ble.BleGattAttributes;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.protocol.AppBleNotifyListener;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;

public abstract class BaseDataManager
{
  protected static final long RESEND_TIMEOUT_PERIOD = 1500L;
  protected static final int WRITE_ERROR_TOTAL = 5;
  protected boolean canWriteNext = true;
  protected BluetoothGatt gatt;
  protected boolean isDeviceConnectedWritten = false;
  protected AppBleNotifyListener mAppBleNotifyListener;
  protected byte[] mLastCommand = new byte[20];
  protected byte[] mLastReceive = new byte[20];
  protected Handler mReceiveHandler = new Handler();
  protected HandlerThread mReceiveHandlerThread = null;
  protected BluetoothGattCharacteristic mWriteBluetoothGattCharacteristic;
  protected int mWriteErrorCounter = 0;
  protected Handler mWriteHandler;
  protected HandlerThread mWriteHandlerThread;
  protected Runnable mWriteRunnable;
  
  private void write(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte)
  {
    if ((paramBluetoothGattCharacteristic != null) && ((paramBluetoothGattCharacteristic.getProperties() | 0x8) > 0))
    {
      DebugLog.e("write[" + ByteDataConvertUtil.bytesToHexString(paramArrayOfByte) + "]");
      DeviceBaseCommand.copy(paramArrayOfByte, this.mLastCommand);
      paramBluetoothGattCharacteristic.setValue(paramArrayOfByte);
      paramBluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic);
    }
  }
  
  public void clear() {}
  
  public void close()
  {
    this.mAppBleNotifyListener = null;
    this.canWriteNext = false;
    this.gatt = null;
    if (this.mWriteHandlerThread != null)
    {
      this.mWriteHandlerThread.quit();
      this.mWriteHandlerThread = null;
    }
    if (this.mReceiveHandlerThread != null)
    {
      this.mReceiveHandlerThread.quit();
      this.mReceiveHandlerThread = null;
    }
  }
  
  public BluetoothGatt getGatt()
  {
    return this.gatt;
  }
  
  public void init(AppBleNotifyListener paramAppBleNotifyListener)
  {
    this.mAppBleNotifyListener = paramAppBleNotifyListener;
    if (this.mWriteHandlerThread == null)
    {
      this.mWriteHandlerThread = new HandlerThread("mWriteHandlerThread" + getClass().getSimpleName());
      this.mWriteHandlerThread.start();
      this.mWriteHandler = new Handler(this.mWriteHandlerThread.getLooper());
    }
    if (this.mReceiveHandlerThread == null)
    {
      this.mReceiveHandlerThread = new HandlerThread("mReceiveHandlerThread" + getClass().getSimpleName());
      this.mReceiveHandlerThread.start();
      this.mReceiveHandler = new Handler(this.mReceiveHandlerThread.getLooper());
    }
  }
  
  public boolean isCanWriteNext()
  {
    return this.canWriteNext;
  }
  
  public boolean isDeviceConnectedWritten()
  {
    return this.isDeviceConnectedWritten;
  }
  
  public abstract boolean isNeedReply(byte[] paramArrayOfByte);
  
  public void onCommandWriteSuccess(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[20];
      DeviceBaseCommand.copy(this.mLastCommand, paramArrayOfByte);
    }
  }
  
  public abstract void receive(byte[] paramArrayOfByte, String paramString);
  
  public void setCanWriteNext(boolean paramBoolean)
  {
    this.canWriteNext = paramBoolean;
  }
  
  public void setDeviceConnectedWritten(boolean paramBoolean)
  {
    this.isDeviceConnectedWritten = paramBoolean;
  }
  
  public void setGatt(BluetoothGatt paramBluetoothGatt)
  {
    this.gatt = paramBluetoothGatt;
  }
  
  public void write(final byte[] paramArrayOfByte)
  {
    if (!this.isDeviceConnectedWritten) {}
    while (!this.canWriteNext) {
      return;
    }
    this.mWriteErrorCounter = 0;
    this.mWriteHandler.removeCallbacksAndMessages(null);
    this.mWriteRunnable = new Runnable()
    {
      public void run()
      {
        if (!BaseDataManager.this.isDeviceConnectedWritten) {
          DebugLog.e("device cann't write !");
        }
        do
        {
          return;
          if (BaseDataManager.this.mWriteErrorCounter < 5) {
            break;
          }
          BaseDataManager.this.canWriteNext = true;
        } while (BaseDataManager.this.mAppBleNotifyListener == null);
        UartLogUtil.recordWrite("发送超时", paramArrayOfByte);
        BaseDataManager.this.mAppBleNotifyListener.onDataSendTimeOut(paramArrayOfByte);
        return;
        BaseDataManager localBaseDataManager = BaseDataManager.this;
        localBaseDataManager.mWriteErrorCounter += 1;
        if (BaseDataManager.this.mWriteBluetoothGattCharacteristic == null) {
          if (!DeviceBaseCommand.isHealthCmd(paramArrayOfByte)) {
            break label192;
          }
        }
        label192:
        for (BaseDataManager.this.mWriteBluetoothGattCharacteristic = BleGattAttributes.getHealthWriteCharacteristic(BaseDataManager.this.gatt);; BaseDataManager.this.mWriteBluetoothGattCharacteristic = BleGattAttributes.getNormalWriteCharacteristic(BaseDataManager.this.gatt))
        {
          BaseDataManager.this.write(BaseDataManager.this.gatt, BaseDataManager.this.mWriteBluetoothGattCharacteristic, paramArrayOfByte);
          BaseDataManager.this.canWriteNext = false;
          if (!BaseDataManager.this.isNeedReply(paramArrayOfByte)) {
            break;
          }
          BaseDataManager.this.mWriteHandler.postDelayed(BaseDataManager.this.mWriteRunnable, 1500L);
          return;
        }
      }
    };
    this.mWriteHandler.postDelayed(this.mWriteRunnable, 150L);
  }
  
  public void writeForce(byte[] paramArrayOfByte)
  {
    if (this.isDeviceConnectedWritten)
    {
      this.canWriteNext = true;
      write(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\device\datamanager\BaseDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */