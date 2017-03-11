package com.project.library.entity;

import java.io.Serializable;

public class BleDevice
  implements Serializable, Comparable<BleDevice>
{
  private static final long serialVersionUID = -5217710157640312976L;
  public String mDeviceAddress;
  public int mDeviceId;
  public String mDeviceName;
  public int mId;
  public int mIs;
  public int mLen;
  public int mRssi;
  
  public int compareTo(BleDevice paramBleDevice)
  {
    if (this.mRssi > paramBleDevice.mRssi) {
      return -1;
    }
    if (this.mRssi < paramBleDevice.mRssi) {
      return 1;
    }
    return 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\entity\BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */