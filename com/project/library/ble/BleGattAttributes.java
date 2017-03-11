package com.project.library.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.project.library.util.DebugLog;
import java.util.UUID;

public class BleGattAttributes
{
  public static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  public static final UUID NOTIFY_UUID_HEALTH;
  public static final UUID NOTIFY_UUID_NORMAL;
  public static final UUID SERVICE_UUID = UUID.fromString("00000aF0-0000-1000-8000-00805f9b34fb");
  public static final UUID[] SERVICE_UUIDS = { SERVICE_UUID };
  public static final UUID WRITE_UUID_HEALTH;
  public static final UUID WRITE_UUID_NORMAL = UUID.fromString("00000aF6-0000-1000-8000-00805f9b34fb");
  
  static
  {
    NOTIFY_UUID_NORMAL = UUID.fromString("00000aF7-0000-1000-8000-00805f9b34fb");
    WRITE_UUID_HEALTH = UUID.fromString("00000aF1-0000-1000-8000-00805f9b34fb");
    NOTIFY_UUID_HEALTH = UUID.fromString("00000aF2-0000-1000-8000-00805f9b34fb");
  }
  
  public static boolean enablePeerDeviceNotifyHealth(BluetoothGatt paramBluetoothGatt, boolean paramBoolean)
  {
    DebugLog.e("enablePeerDeviceNotifyHealth:" + paramBoolean);
    return enablePeerDeviceNotifyMe(paramBluetoothGatt, NOTIFY_UUID_HEALTH, paramBoolean);
  }
  
  private static boolean enablePeerDeviceNotifyMe(BluetoothGatt paramBluetoothGatt, UUID paramUUID, boolean paramBoolean)
  {
    Object localObject = getCharacteristic(paramBluetoothGatt, SERVICE_UUID, paramUUID);
    if ((localObject != null) && ((((BluetoothGattCharacteristic)localObject).getProperties() | 0x10) > 0))
    {
      paramBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, paramBoolean);
      if (paramUUID.equals(((BluetoothGattCharacteristic)localObject).getUuid()))
      {
        localObject = ((BluetoothGattCharacteristic)localObject).getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (paramBoolean) {}
        for (paramUUID = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;; paramUUID = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
        {
          ((BluetoothGattDescriptor)localObject).setValue(paramUUID);
          return paramBluetoothGatt.writeDescriptor((BluetoothGattDescriptor)localObject);
        }
      }
    }
    return false;
  }
  
  public static boolean enablePeerDeviceNotifyNormal(BluetoothGatt paramBluetoothGatt, boolean paramBoolean)
  {
    DebugLog.e("enablePeerDeviceNotifyNormal: " + paramBoolean);
    return enablePeerDeviceNotifyMe(paramBluetoothGatt, NOTIFY_UUID_NORMAL, paramBoolean);
  }
  
  private static BluetoothGattCharacteristic getCharacteristic(BluetoothGatt paramBluetoothGatt, UUID paramUUID1, UUID paramUUID2)
  {
    if (paramBluetoothGatt == null) {}
    do
    {
      return null;
      paramBluetoothGatt = paramBluetoothGatt.getService(paramUUID1);
    } while (paramBluetoothGatt == null);
    return paramBluetoothGatt.getCharacteristic(paramUUID2);
  }
  
  public static BluetoothGattCharacteristic getHealthWriteCharacteristic(BluetoothGatt paramBluetoothGatt)
  {
    return getCharacteristic(paramBluetoothGatt, SERVICE_UUID, WRITE_UUID_HEALTH);
  }
  
  public static BluetoothGattCharacteristic getNormalWriteCharacteristic(BluetoothGatt paramBluetoothGatt)
  {
    return getCharacteristic(paramBluetoothGatt, SERVICE_UUID, WRITE_UUID_NORMAL);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\ble\BleGattAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */