package com.project.library.protocol;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import com.project.library.ble.BleGattAttributes;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.device.datamanager.HealthDataManager;
import com.project.library.device.datamanager.NormalDataCallback;
import com.project.library.device.datamanager.NormalDataManager;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@SuppressLint({"HandlerLeak"})
public class BleProxy
{
  private static final long CONNECT_DELAY_PEROID = 2000L;
  private static final long CONNECT_TIMEOUT_PEROID = 10000L;
  public static final UUID DFU_SERVICE_UUID = UUID.fromString("00001530-1212-efde-1523-785feabcd123");
  private static final String TAG = "BleProxy";
  private static int mConnectionState = 2;
  private boolean bluetoothON = true;
  private boolean isFirstConnect = true;
  private boolean isHandlerDisconnect = false;
  private boolean isInit = false;
  private boolean isNeedSetTimeOut = true;
  private boolean isScaning = false;
  private boolean isUnbind = false;
  private boolean isWareUpdate = false;
  private AppBleNotifyListener mAppBleNotifyListener;
  private String mBleAddress;
  private BleScanTool mBleScanTool = BleScanTool.getInstance();
  private BluetoothAdapter mBluetoothAdapter;
  private BluetoothGatt mBluetoothGatt;
  private Handler mConnectingHandler = new Handler();
  private Context mContext;
  private Handler mErrorHandler = new Handler();
  private GattCallback mGattCallback = new GattCallback(null);
  private HealthDataManager mHealthDataManager = null;
  private final NormalDataCallback mNormalDataCallback = new NormalDataCallback()
  {
    public void onUnbinded()
    {
      BleProxy.this.isUnbind = true;
      BleProxy.this.mNormalDataManager.setCanWriteNext(false);
      BleProxy.this.isHandlerDisconnect = true;
      BleProxy.this.closeDevice(BleProxy.this.isHandlerDisconnect);
    }
    
    public void onWareUpdate(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 0)
      {
        BleProxy.this.isWareUpdate = true;
        BleProxy.this.isHandlerDisconnect = true;
      }
      while (BleProxy.this.mAppBleNotifyListener == null) {
        return;
      }
      BleProxy.this.mAppBleNotifyListener.onWareUpdate(paramAnonymousByte);
      BleProxy.this.isWareUpdate = false;
      BleProxy.this.mNormalDataManager.setCanWriteNext(true);
    }
  };
  private NormalDataManager mNormalDataManager = null;
  private Handler mTempHandler;
  private SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss|SSS", Locale.CHINESE);
  
  public BleProxy(Context paramContext, AppBleNotifyListener paramAppBleNotifyListener)
  {
    this.mContext = paramContext;
    this.mAppBleNotifyListener = paramAppBleNotifyListener;
    this.mBluetoothAdapter = this.mBleScanTool.getBluetoothAdapter();
  }
  
  private void SetOrCancelTimeOut(boolean paramBoolean)
  {
    this.mErrorHandler.removeCallbacksAndMessages(null);
    if (paramBoolean) {
      this.mErrorHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          BleProxy.this.closeDevice(false);
        }
      }, 10000L);
    }
  }
  
  private void cleanDataManager()
  {
    if (this.mHealthDataManager != null)
    {
      this.mHealthDataManager.clear();
      this.mHealthDataManager.close();
      this.mHealthDataManager.setDeviceConnectedWritten(false);
      this.mHealthDataManager = null;
    }
    if (this.mNormalDataManager != null)
    {
      this.mNormalDataManager.setDeviceConnectedWritten(false);
      this.mNormalDataManager.close();
      this.mNormalDataManager = null;
    }
  }
  
  private void closeDevice(boolean paramBoolean)
  {
    if (!isDeviceDisconnected())
    {
      this.isInit = false;
      cleanDataManager();
      mConnectionState = 2;
      SetOrCancelTimeOut(false);
      this.isHandlerDisconnect = paramBoolean;
      if (this.mBluetoothGatt != null)
      {
        refreshDeviceCache(this.mBluetoothGatt);
        this.mBluetoothGatt.close();
        this.mBluetoothGatt = null;
      }
      if (!this.isHandlerDisconnect) {
        break label160;
      }
      if (!this.isWareUpdate) {
        break label99;
      }
      if (this.mAppBleNotifyListener != null) {
        this.mAppBleNotifyListener.onWareUpdate((byte)0);
      }
      this.isWareUpdate = false;
    }
    for (;;)
    {
      this.isHandlerDisconnect = false;
      return;
      label99:
      if (this.isUnbind)
      {
        if (this.mAppBleNotifyListener != null) {
          this.mAppBleNotifyListener.onBindUnbind((byte)20);
        }
        this.isUnbind = false;
      }
      else
      {
        if (this.mAppBleNotifyListener != null) {
          this.mAppBleNotifyListener.onBLEDisConnected(this.mBleAddress);
        }
        this.mBleAddress = null;
        continue;
        label160:
        if (this.mAppBleNotifyListener != null) {
          this.mAppBleNotifyListener.onBLEDisConnected(this.mBleAddress);
        }
        if (this.bluetoothON) {
          delayConnect();
        }
      }
    }
  }
  
  private boolean connect()
  {
    BluetoothDevice localBluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(this.mBleAddress);
    if (localBluetoothDevice == null) {
      return false;
    }
    if (this.mAppBleNotifyListener != null) {
      this.mAppBleNotifyListener.onBLEConnecting();
    }
    mConnectionState = 1;
    String str = Build.MANUFACTURER;
    if (((str.equalsIgnoreCase("ZTE")) || (str.equalsIgnoreCase("samsung"))) && (this.mBluetoothGatt != null))
    {
      Log.e("BleProxy", "connect<samsung>connect>>>>>" + this.mBleAddress);
      this.mBluetoothGatt.connect();
      setGatt();
    }
    while (this.isNeedSetTimeOut)
    {
      SetOrCancelTimeOut(true);
      return true;
      Log.e("BleProxy", "connectGatt" + this.mBleAddress);
      connectGatt(localBluetoothDevice);
    }
    this.isNeedSetTimeOut = true;
    return true;
  }
  
  private void connectGatt(BluetoothDevice paramBluetoothDevice)
  {
    if (this.mBluetoothGatt != null) {
      this.mBluetoothGatt.close();
    }
    DebugLog.e("connect<!samsung or nullgatt>connectGatt>>>>>" + this.mBleAddress);
    this.mBluetoothGatt = paramBluetoothDevice.connectGatt(this.mContext, false, this.mGattCallback);
    setGatt();
  }
  
  private boolean isBlueOpen()
  {
    if (!this.mBleScanTool.isBluetoothOpen())
    {
      if (this.mAppBleNotifyListener != null) {
        this.mAppBleNotifyListener.onBlueToothError(-88);
      }
      return false;
    }
    return true;
  }
  
  private boolean isBluetoothAvailable()
  {
    if (!this.mBleScanTool.isSupportBLE()) {
      if (this.mAppBleNotifyListener != null) {
        this.mAppBleNotifyListener.onBlueToothError(-99);
      }
    }
    do
    {
      return false;
      if (this.mBleScanTool.isBluetoothOpen()) {
        break;
      }
    } while (this.mAppBleNotifyListener == null);
    this.mAppBleNotifyListener.onBlueToothError(-88);
    return false;
    return true;
  }
  
  private void refreshDeviceCache(BluetoothGatt paramBluetoothGatt)
  {
    try
    {
      Method localMethod = paramBluetoothGatt.getClass().getMethod("refresh", new Class[0]);
      if (localMethod != null) {
        localMethod.invoke(paramBluetoothGatt, new Object[0]);
      }
      return;
    }
    catch (Exception paramBluetoothGatt)
    {
      DebugLog.e(paramBluetoothGatt.getMessage());
    }
  }
  
  private void setGatt()
  {
    if (this.mHealthDataManager != null) {
      this.mHealthDataManager.setGatt(this.mBluetoothGatt);
    }
    if (this.mNormalDataManager != null) {
      this.mNormalDataManager.setGatt(this.mBluetoothGatt);
    }
  }
  
  public boolean canWriteNext(byte[] paramArrayOfByte)
  {
    if (DeviceBaseCommand.isHealthCmd(paramArrayOfByte)) {
      return this.mHealthDataManager.isCanWriteNext();
    }
    return this.mNormalDataManager.isCanWriteNext();
  }
  
  public void close()
  {
    this.isInit = false;
    this.isWareUpdate = false;
    this.isUnbind = false;
    this.mBleAddress = null;
    closeDevice(true);
  }
  
  public boolean connect(String paramString)
  {
    if (!this.isInit)
    {
      Log.e("BleProxy", "proxy not init yet !");
      UartLogUtil.recordWrite("proxy not init yet !", new byte[1]);
      initBLE((byte)0);
    }
    if (!isDeviceDisconnected())
    {
      UartLogUtil.recordWrite("device connected or connecting..", new byte[1]);
      DebugLog.e("device connected or connecting..");
      return false;
    }
    if (!isBluetoothAvailable())
    {
      Log.e("BleProxy", "!isBluetoothAvailable()");
      UartLogUtil.recordWrite("!isBluetoothAvailable()", new byte[1]);
      return false;
    }
    if ((!isBlueOpen()) && (!this.mBluetoothAdapter.isEnabled())) {
      this.mBluetoothAdapter.enable();
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("BleProxy", "address is null");
      UartLogUtil.recordWrite("address is null", new byte[1]);
      return false;
    }
    this.mBleAddress = paramString;
    boolean bool = BleScanTool.getInstance().isNeedScanDevice();
    if ((this.isFirstConnect) && (bool))
    {
      this.isFirstConnect = false;
      scanAndAutoConnect();
      Log.e("BleProxy", "needScanBeforeConnect");
      return true;
    }
    this.isFirstConnect = false;
    return connect();
  }
  
  public void delayConnect()
  {
    if ((this.mBleAddress == null) || (!isBluetoothAvailable()) || (this.mBleScanTool.isScanning())) {
      return;
    }
    this.mConnectingHandler.removeCallbacksAndMessages(null);
    this.mConnectingHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        if (BleProxy.this.mBleAddress != null) {
          BleProxy.this.connect(BleProxy.this.mBleAddress);
        }
      }
    }, 2000L);
  }
  
  public boolean initBLE(byte paramByte)
  {
    if (!isBluetoothAvailable()) {
      return false;
    }
    if (this.mHealthDataManager == null) {
      this.mHealthDataManager = new HealthDataManager();
    }
    this.mHealthDataManager.init(this.mAppBleNotifyListener);
    if (this.mNormalDataManager == null) {
      this.mNormalDataManager = new NormalDataManager();
    }
    this.mNormalDataManager.init(this.mAppBleNotifyListener, this.mNormalDataCallback);
    this.isInit = true;
    return this.isInit;
  }
  
  public boolean isDeviceConnected()
  {
    return mConnectionState == 0;
  }
  
  public boolean isDeviceConnectedWritten(byte[] paramArrayOfByte)
  {
    if (CoreServiceProxy.getInstance().isDeviceConnected())
    {
      if (DeviceBaseCommand.isHealthCmd(paramArrayOfByte)) {
        return this.mHealthDataManager.isDeviceConnectedWritten();
      }
      return this.mNormalDataManager.isDeviceConnectedWritten();
    }
    return false;
  }
  
  public boolean isDeviceDisconnected()
  {
    return mConnectionState == 2;
  }
  
  public void notifyBluetoothStateChanged(boolean paramBoolean)
  {
    this.bluetoothON = paramBoolean;
  }
  
  public void scanAndAutoConnect()
  {
    if ((this.mBleAddress == null) || (!isBluetoothAvailable()) || (this.mBleScanTool.isScanning())) {
      return;
    }
    final BluetoothAdapter.LeScanCallback local4 = new BluetoothAdapter.LeScanCallback()
    {
      public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte) {}
    };
    if (this.mTempHandler == null) {
      this.mTempHandler = new Handler();
    }
    this.mTempHandler.removeCallbacksAndMessages(null);
    this.mTempHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        BleProxy.this.mBluetoothAdapter.stopLeScan(local4);
        BleProxy.this.isScaning = false;
        BleProxy.this.delayConnect();
      }
    }, 2000L);
    if (this.isScaning) {
      this.mBluetoothAdapter.stopLeScan(local4);
    }
    this.isScaning = true;
    this.mBluetoothAdapter.startLeScan(local4);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    if (isDeviceConnectedWritten(paramArrayOfByte))
    {
      if (!DeviceBaseCommand.isHealthCmd(paramArrayOfByte)) {
        break label34;
      }
      if (this.mHealthDataManager.isCanWriteNext()) {
        this.mHealthDataManager.write(paramArrayOfByte);
      }
    }
    label34:
    while (!this.mNormalDataManager.isCanWriteNext()) {
      return;
    }
    this.mNormalDataManager.write(paramArrayOfByte);
  }
  
  public void writeForce(byte[] paramArrayOfByte)
  {
    if (isDeviceConnectedWritten(paramArrayOfByte))
    {
      if (!DeviceBaseCommand.isHealthCmd(paramArrayOfByte)) {
        break label29;
      }
      this.mHealthDataManager.setCanWriteNext(true);
    }
    for (;;)
    {
      write(paramArrayOfByte);
      return;
      label29:
      this.mNormalDataManager.setCanWriteNext(true);
    }
  }
  
  private class GattCallback
    extends BluetoothGattCallback
  {
    private GattCallback() {}
    
    public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
    {
      UUID localUUID = paramBluetoothGattCharacteristic.getUuid();
      byte[] arrayOfByte = new byte[20];
      DeviceBaseCommand.copy(paramBluetoothGattCharacteristic.getValue(), arrayOfByte);
      paramBluetoothGattCharacteristic = new StringBuilder();
      if (!ByteDataConvertUtil.bytesToHexString(arrayOfByte).startsWith("02 a0"))
      {
        paramBluetoothGattCharacteristic.append(BleProxy.this.sdf3.format(new Date())).append("接收").append(" : receive > ").append("[" + ByteDataConvertUtil.bytesToHexString(arrayOfByte) + "]").append("\r\n\r\n");
        UartLogUtil.recordWrite("接收", arrayOfByte);
        DebugLog.e(paramBluetoothGattCharacteristic.toString());
      }
      if (localUUID.equals(BleGattAttributes.NOTIFY_UUID_HEALTH)) {
        BleProxy.this.mHealthDataManager.receive(arrayOfByte, paramBluetoothGatt.getDevice().getAddress());
      }
      while (!localUUID.equals(BleGattAttributes.NOTIFY_UUID_NORMAL)) {
        return;
      }
      BleProxy.this.mNormalDataManager.receive(arrayOfByte, paramBluetoothGatt.getDevice().getAddress());
    }
    
    public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
    {
      byte[] arrayOfByte;
      if (paramInt == 0)
      {
        arrayOfByte = paramBluetoothGattCharacteristic.getValue();
        if (arrayOfByte == null) {
          break label191;
        }
        DebugLog.e("onCharacteristicWrite:" + paramBluetoothGatt.getDevice().getAddress() + "[" + ByteDataConvertUtil.bytesToHexString(arrayOfByte) + "]");
        paramBluetoothGatt = new StringBuilder();
        if (!ByteDataConvertUtil.bytesToHexString(arrayOfByte).startsWith("02 a0")) {
          paramBluetoothGatt.append(BleProxy.this.sdf3.format(new Date())).append(" : write > ").append("[" + ByteDataConvertUtil.bytesToHexString(arrayOfByte) + "]").append("\r\n");
        }
        if (!BleGattAttributes.WRITE_UUID_HEALTH.equals(paramBluetoothGattCharacteristic.getUuid())) {
          break label165;
        }
        BleProxy.this.mHealthDataManager.onCommandWriteSuccess(arrayOfByte);
      }
      label165:
      while (!BleGattAttributes.WRITE_UUID_NORMAL.equals(paramBluetoothGattCharacteristic.getUuid())) {
        return;
      }
      BleProxy.this.mNormalDataManager.onCommandWriteSuccess(arrayOfByte);
      return;
      label191:
      DebugLog.e("onCharacteristicWrite error, value == null");
    }
    
    public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
    {
      DebugLog.e("onConnectionStateChange[" + paramInt1 + "->" + paramInt2 + "]");
      UartLogUtil.recordWrite("蓝牙状态", new byte[] { (byte)paramInt1, (byte)paramInt2 });
      if ((paramInt1 == 133) || (paramInt1 == 129))
      {
        BleGattAttributes.enablePeerDeviceNotifyNormal(paramBluetoothGatt, false);
        BleGattAttributes.enablePeerDeviceNotifyHealth(paramBluetoothGatt, false);
        BleProxy.this.closeDevice(false);
      }
      do
      {
        return;
        if ((paramInt1 == 141) && (BleProxy.this.mBluetoothAdapter != null) && (BleProxy.this.mBluetoothAdapter.isEnabled())) {
          BleProxy.this.mBluetoothAdapter.enable();
        }
        if (paramInt2 == 0)
        {
          BleGattAttributes.enablePeerDeviceNotifyNormal(paramBluetoothGatt, false);
          BleGattAttributes.enablePeerDeviceNotifyHealth(paramBluetoothGatt, false);
          if (BleProxy.this.isHandlerDisconnect)
          {
            BleProxy.this.closeDevice(true);
            return;
          }
          BleProxy.this.closeDevice(false);
          return;
        }
      } while (paramInt2 != 2);
      BleProxy.this.SetOrCancelTimeOut(false);
      if (paramBluetoothGatt.discoverServices())
      {
        BleProxy.this.SetOrCancelTimeOut(true);
        return;
      }
      BleProxy.this.closeDevice(false);
    }
    
    public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
    {
      if (paramInt == 0)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label216;
        }
        if (BleGattAttributes.CLIENT_CHARACTERISTIC_CONFIG_UUID.equals(paramBluetoothGattDescriptor.getUuid()))
        {
          if (paramBluetoothGattDescriptor.getValue()[0] != 1) {
            break label166;
          }
          paramInt = 1;
          label35:
          if (!BleGattAttributes.NOTIFY_UUID_HEALTH.equals(paramBluetoothGattDescriptor.getCharacteristic().getUuid())) {
            break label171;
          }
          if (paramInt != 0)
          {
            BleProxy.this.mHealthDataManager.clear();
            BleProxy.this.mHealthDataManager.setDeviceConnectedWritten(true);
            BleProxy.this.mNormalDataManager.setDeviceConnectedWritten(true);
            BleProxy.this.mHealthDataManager.setCanWriteNext(true);
            BleProxy.this.mNormalDataManager.setCanWriteNext(true);
            DebugLog.e("onDescriptorWrite:" + paramBluetoothGatt.getDevice().getAddress());
            if (BleProxy.this.mAppBleNotifyListener != null) {
              BleProxy.this.mAppBleNotifyListener.onBLEConnected();
            }
            BleProxy.mConnectionState = 0;
          }
        }
      }
      label166:
      label171:
      do
      {
        do
        {
          return;
          paramInt = 0;
          break;
          paramInt = 0;
          break label35;
        } while ((!BleGattAttributes.NOTIFY_UUID_NORMAL.equals(paramBluetoothGattDescriptor.getCharacteristic().getUuid())) || (paramInt == 0));
        BleProxy.this.SetOrCancelTimeOut(false);
      } while (BleGattAttributes.enablePeerDeviceNotifyHealth(paramBluetoothGatt, true));
      BleProxy.this.closeDevice(false);
      return;
      label216:
      BleProxy.this.closeDevice(false);
    }
    
    public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
    {
      Object localObject = new StringBuilder("onServicesDiscovered : ");
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        DebugLog.e(bool);
        if (paramInt == 0) {
          if (LibSharedPreferences.getInstance().isFirwareUpgrade()) {
            localObject = paramBluetoothGatt.getServices().iterator();
          }
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          if (!BleGattAttributes.enablePeerDeviceNotifyNormal(paramBluetoothGatt, true)) {
            BleProxy.this.closeDevice(false);
          }
          return;
          bool = false;
          break;
        }
        if (((BluetoothGattService)((Iterator)localObject).next()).getUuid().equals(BleProxy.DFU_SERVICE_UUID))
        {
          BleProxy.this.isHandlerDisconnect = true;
          BleProxy.this.isScaning = true;
          BleProxy.this.closeDevice(true);
          Intent localIntent = new Intent("com.veryfit.multi.ACTION_SINGLE_BANK_WARE_UPDATE");
          LocalBroadcastManager.getInstance(BleProxy.this.mContext).sendBroadcast(localIntent);
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\protocol\BleProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */