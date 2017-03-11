package com.veryfit.multi.vo.json;

import java.util.Iterator;
import java.util.List;

public class DeviceUpdateList
{
  public List<DeviceUpdateInfo> firmwareInfo;
  
  public DeviceUpdateInfo getMyDevice(int paramInt)
  {
    Iterator localIterator = this.firmwareInfo.iterator();
    DeviceUpdateInfo localDeviceUpdateInfo;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localDeviceUpdateInfo = (DeviceUpdateInfo)localIterator.next();
    } while (localDeviceUpdateInfo.device_id != paramInt);
    return localDeviceUpdateInfo;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\json\DeviceUpdateList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */