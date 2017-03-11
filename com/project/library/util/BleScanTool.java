package com.project.library.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.project.library.entity.BleDevice;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BleScanTool
{
  public static final UUID RX_UPDATE_UUID = UUID.fromString("00001530-1212-efde-1523-785feabcd123");
  private static final long SCAN_PERIOD = 8000L;
  private static BleScanTool instance = null;
  private boolean filterByService;
  private boolean isScaning = false;
  private ConcurrentHashMap<String, BleDevice> mBleDeviceMap = new ConcurrentHashMap();
  private BluetoothAdapter mBluetoothAdapter;
  private BluetoothManager mBluetoothManager;
  private Context mCtx;
  private DFUServiceParser mDFUServiceParser = DFUServiceParser.getDFUParser();
  private CopyOnWriteArrayList<String> mFilterNameList = new CopyOnWriteArrayList();
  private Handler mHandler = new Handler();
  private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback()
  {
    public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
    {
      String str2;
      try
      {
        BleScanTool.this.mDFUServiceParser.decodeDFUAdvData(paramAnonymousArrayOfByte);
        if (BleScanTool.this.mDFUServiceParser.isValidDFUSensor())
        {
          byte[] arrayOfByte = ScannerServiceParser.decodeManufacturer(paramAnonymousArrayOfByte);
          if (arrayOfByte == null) {
            return;
          }
          Log.e("BleScanTool", ByteDataConvertUtil.bytesToHexString(arrayOfByte));
          BleDevice localBleDevice = new BleDevice();
          localBleDevice.mLen = 0;
          localBleDevice.mId = 0;
          localBleDevice.mIs = 0;
          if (arrayOfByte.length == 13)
          {
            Log.e("BleScanTool", "设备ID---------：" + (arrayOfByte[10] & 0xFF));
            Log.e("BleScanTool", "设备IS---------：" + (arrayOfByte[11] & 0xFF));
            Log.e("BleScanTool", "设备ID--IS---------：" + String.format("%x", new Object[] { Byte.valueOf(arrayOfByte[10]) }) + "--" + String.format("%x", new Object[] { Byte.valueOf(arrayOfByte[11]) }));
            int i = arrayOfByte[10] & 0xFF;
            int j = arrayOfByte[11] & 0xFF;
            if ((i == 10) && (j == 240))
            {
              localBleDevice.mId = i;
              localBleDevice.mIs = j;
              localBleDevice.mLen = arrayOfByte.length;
            }
          }
          str2 = paramAnonymousBluetoothDevice.getName();
          str1 = str2;
          if (TextUtils.isEmpty(str2))
          {
            str1 = ScannerServiceParser.decodeDeviceName(paramAnonymousArrayOfByte);
            if (TextUtils.isEmpty(str1)) {
              return;
            }
          }
          if (!ScannerServiceParser.decodeDeviceAdvData(paramAnonymousArrayOfByte, BleScanTool.RX_UPDATE_UUID)) {
            return;
          }
          paramAnonymousBluetoothDevice = paramAnonymousBluetoothDevice.getAddress();
          Log.e("BleScanTool", "address:" + paramAnonymousBluetoothDevice);
          if (BleScanTool.this.mBleDeviceMap.containsKey(paramAnonymousBluetoothDevice)) {
            return;
          }
          localBleDevice.mDeviceName = str1;
          localBleDevice.mDeviceAddress = paramAnonymousBluetoothDevice;
          localBleDevice.mRssi = paramAnonymousInt;
          localBleDevice.mDeviceId = (arrayOfByte[0] & 0xFF | arrayOfByte[1] << 8);
          BleScanTool.this.mBleDeviceMap.put(paramAnonymousBluetoothDevice, localBleDevice);
          paramAnonymousBluetoothDevice = BleScanTool.this.mScanDeviceListenerList.iterator();
          while (paramAnonymousBluetoothDevice.hasNext()) {
            ((BleScanTool.ScanDeviceListener)paramAnonymousBluetoothDevice.next()).onFind(localBleDevice);
          }
        }
        str2 = paramAnonymousBluetoothDevice.getName();
      }
      catch (Exception paramAnonymousBluetoothDevice)
      {
        Log.e("BleScanTool", "Invalid data in Advertisement packet " + paramAnonymousBluetoothDevice.toString());
        return;
      }
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = ScannerServiceParser.decodeDeviceName(paramAnonymousArrayOfByte);
        if (TextUtils.isEmpty(str1)) {}
      }
      else
      {
        boolean bool1;
        if (BleScanTool.this.filterByService) {
          bool1 = ScannerServiceParser.decodeDeviceAdvData(paramAnonymousArrayOfByte, BleScanTool.this.requiredUUID);
        }
        for (;;)
        {
          paramAnonymousArrayOfByte = new byte[20];
          if (!bool1) {
            break;
          }
          paramAnonymousArrayOfByte = paramAnonymousBluetoothDevice.getAddress();
          if (BleScanTool.this.mBleDeviceMap.containsKey(paramAnonymousArrayOfByte)) {
            break;
          }
          paramAnonymousBluetoothDevice = new BleDevice();
          paramAnonymousBluetoothDevice.mDeviceName = str1;
          paramAnonymousBluetoothDevice.mDeviceAddress = paramAnonymousArrayOfByte;
          paramAnonymousBluetoothDevice.mRssi = paramAnonymousInt;
          BleScanTool.this.mBleDeviceMap.put(paramAnonymousArrayOfByte, paramAnonymousBluetoothDevice);
          paramAnonymousArrayOfByte = BleScanTool.this.mScanDeviceListenerList.iterator();
          while (paramAnonymousArrayOfByte.hasNext()) {
            ((BleScanTool.ScanDeviceListener)paramAnonymousArrayOfByte.next()).onFind(paramAnonymousBluetoothDevice);
          }
          boolean bool2 = BleScanTool.this.mFilterNameList.isEmpty();
          paramAnonymousArrayOfByte = BleScanTool.this.mFilterNameList.iterator();
          do
          {
            bool1 = bool2;
            if (!paramAnonymousArrayOfByte.hasNext()) {
              break;
            }
            str2 = (String)paramAnonymousArrayOfByte.next();
            bool1 = str1.toUpperCase(Locale.US).contains(str2.toUpperCase(Locale.US));
          } while (!bool1);
          bool1 = true;
        }
      }
    }
  };
  private BluetoothAdapter.LeScanCallback mLeScanCallbackDFU = new BluetoothAdapter.LeScanCallback()
  {
    public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
    {
      try
      {
        BleScanTool.this.mDFUServiceParser.decodeDFUAdvData(paramAnonymousArrayOfByte);
        if (BleScanTool.this.mDFUServiceParser.isValidDFUSensor())
        {
          byte[] arrayOfByte = ScannerServiceParser.decodeManufacturer(paramAnonymousArrayOfByte);
          if (arrayOfByte == null) {
            return;
          }
          Log.e("BleScanTool", ByteDataConvertUtil.bytesToHexString(arrayOfByte));
          BleDevice localBleDevice = new BleDevice();
          localBleDevice.mLen = 0;
          localBleDevice.mId = 0;
          localBleDevice.mIs = 0;
          if (arrayOfByte.length == 13)
          {
            Log.e("BleScanTool", "设备ID---------：" + (arrayOfByte[10] & 0xFF));
            Log.e("BleScanTool", "设备IS---------：" + (arrayOfByte[11] & 0xFF));
            Log.e("BleScanTool", "设备ID--IS---------：" + String.format("%x", new Object[] { Byte.valueOf(arrayOfByte[10]) }) + "--" + String.format("%x", new Object[] { Byte.valueOf(arrayOfByte[11]) }));
            int i = arrayOfByte[10] & 0xFF;
            int j = arrayOfByte[11] & 0xFF;
            if ((i == 10) && (j == 240))
            {
              localBleDevice.mId = i;
              localBleDevice.mIs = j;
              localBleDevice.mLen = arrayOfByte.length;
            }
          }
          if (ScannerServiceParser.decodeDeviceAdvData(paramAnonymousArrayOfByte, BleScanTool.RX_UPDATE_UUID))
          {
            paramAnonymousArrayOfByte = paramAnonymousBluetoothDevice.getAddress();
            Log.e("BleScanTool", "address:" + paramAnonymousArrayOfByte);
            if (!BleScanTool.this.mBleDeviceMap.containsKey(paramAnonymousArrayOfByte))
            {
              localBleDevice.mDeviceName = paramAnonymousBluetoothDevice.getName();
              localBleDevice.mDeviceAddress = paramAnonymousArrayOfByte;
              localBleDevice.mRssi = paramAnonymousInt;
              localBleDevice.mDeviceId = (arrayOfByte[0] | arrayOfByte[1] << 8);
              BleScanTool.this.mBleDeviceMap.put(paramAnonymousArrayOfByte, localBleDevice);
              paramAnonymousBluetoothDevice = BleScanTool.this.mScanDeviceListenerList.iterator();
              while (paramAnonymousBluetoothDevice.hasNext()) {
                ((BleScanTool.ScanDeviceListener)paramAnonymousBluetoothDevice.next()).onFind(localBleDevice);
              }
            }
          }
        }
        return;
      }
      catch (Exception paramAnonymousBluetoothDevice)
      {
        Log.e("BleScanTool", "Invalid data in Advertisement packet " + paramAnonymousBluetoothDevice.toString());
      }
    }
  };
  private CopyOnWriteArrayList<ScanDeviceListener> mScanDeviceListenerList = new CopyOnWriteArrayList();
  private UUID requiredUUID;
  
  public static BleScanTool getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BleScanTool();
      }
      BleScanTool localBleScanTool = instance;
      return localBleScanTool;
    }
    finally {}
  }
  
  public void addFilterName(String paramString)
  {
    if ((paramString != null) && (!this.mFilterNameList.contains(paramString))) {
      this.mFilterNameList.add(paramString);
    }
  }
  
  public void addFilterNameForNum(String paramString)
  {
    if ((paramString != null) && (!ArrayUtils.containsForNum(this.mFilterNameList))) {
      this.mFilterNameList.add(paramString);
    }
  }
  
  public void addScanDeviceListener(ScanDeviceListener paramScanDeviceListener)
  {
    if ((paramScanDeviceListener != null) && (!this.mScanDeviceListenerList.contains(paramScanDeviceListener))) {
      this.mScanDeviceListenerList.add(paramScanDeviceListener);
    }
  }
  
  public void clearFilterName()
  {
    Iterator localIterator = this.mFilterNameList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      this.mFilterNameList.remove(str);
    }
  }
  
  public void clearScanDeviceListener()
  {
    Iterator localIterator = this.mScanDeviceListenerList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ScanDeviceListener localScanDeviceListener = (ScanDeviceListener)localIterator.next();
      this.mScanDeviceListenerList.remove(localScanDeviceListener);
    }
  }
  
  public BluetoothAdapter getBluetoothAdapter()
  {
    return this.mBluetoothAdapter;
  }
  
  public void init(Context paramContext)
  {
    DebugLog.e("BleScanUtil init !");
    this.mCtx = paramContext;
    this.mBluetoothManager = ((BluetoothManager)paramContext.getSystemService("bluetooth"));
    if ((this.mBluetoothManager != null) && (this.mBluetoothAdapter == null)) {
      this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
    }
  }
  
  public boolean isBluetoothOpen()
  {
    return (this.mBluetoothAdapter != null) && (this.mBluetoothAdapter.isEnabled());
  }
  
  public boolean isNeedScanDevice()
  {
    String str = Build.MANUFACTURER;
    boolean bool = false;
    DebugLog.e("phone_type" + str);
    if ((str.equalsIgnoreCase("xiaomi")) || (str.equalsIgnoreCase("huawei")) || (str.equals("samsung"))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isScanning()
  {
    return this.isScaning;
  }
  
  public boolean isSupportBLE()
  {
    return this.mCtx.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
  
  public void removeFilterName(String paramString)
  {
    if ((paramString != null) && (!this.mFilterNameList.isEmpty())) {
      this.mFilterNameList.remove(paramString);
    }
  }
  
  public void removeScanDeviceListener(ScanDeviceListener paramScanDeviceListener)
  {
    if ((paramScanDeviceListener != null) && (!this.mScanDeviceListenerList.isEmpty())) {
      this.mScanDeviceListenerList.remove(paramScanDeviceListener);
    }
  }
  
  public void scanLeDevice(boolean paramBoolean)
  {
    if ((this.mBluetoothAdapter == null) || (!this.mBluetoothAdapter.isEnabled())) {}
    do
    {
      return;
      if (paramBoolean)
      {
        if (this.isScaning) {
          this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
        }
        this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            BleScanTool.this.mBluetoothAdapter.stopLeScan(BleScanTool.this.mLeScanCallback);
            BleScanTool.this.filterByService = false;
            BleScanTool.this.isScaning = false;
            Iterator localIterator = BleScanTool.this.mScanDeviceListenerList.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                return;
              }
              ((BleScanTool.ScanDeviceListener)localIterator.next()).onFinish();
            }
          }
        }, 8000L);
        this.isScaning = true;
        this.mBleDeviceMap.clear();
        this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
        return;
      }
    } while (!this.isScaning);
    this.mHandler.removeCallbacksAndMessages(null);
    this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
    this.isScaning = false;
  }
  
  public void scanLeDeviceByService(boolean paramBoolean, UUID paramUUID)
  {
    this.requiredUUID = paramUUID;
    this.filterByService = paramBoolean;
    scanLeDevice(paramBoolean);
  }
  
  public void scanLeDeviceDFU(boolean paramBoolean)
  {
    if ((this.mBluetoothAdapter == null) || (!this.mBluetoothAdapter.isEnabled())) {}
    do
    {
      return;
      if (paramBoolean)
      {
        if (this.isScaning) {
          this.mBluetoothAdapter.stopLeScan(this.mLeScanCallbackDFU);
        }
        this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            BleScanTool.this.mBluetoothAdapter.stopLeScan(BleScanTool.this.mLeScanCallbackDFU);
            BleScanTool.this.filterByService = false;
            BleScanTool.this.isScaning = false;
            Iterator localIterator = BleScanTool.this.mScanDeviceListenerList.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                return;
              }
              ((BleScanTool.ScanDeviceListener)localIterator.next()).onFinish();
            }
          }
        }, 8000L);
        this.isScaning = true;
        this.mBleDeviceMap.clear();
        this.mBluetoothAdapter.startLeScan(this.mLeScanCallbackDFU);
        return;
      }
    } while (!this.isScaning);
    this.mHandler.removeCallbacksAndMessages(null);
    this.mBluetoothAdapter.stopLeScan(this.mLeScanCallbackDFU);
    this.isScaning = false;
  }
  
  public static abstract interface ScanDeviceListener
  {
    public abstract void onFind(BleDevice paramBleDevice);
    
    public abstract void onFinish();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\BleScanTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */