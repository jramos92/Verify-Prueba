package com.veryfit.multi.model;

import java.io.Serializable;

public class BtSleepDataItem
  implements Serializable
{
  private Long date;
  private Integer deviceId;
  private int sleepMinutes;
  private int sleepStatus;
  
  public Long getDate()
  {
    return this.date;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getSleepMinutes()
  {
    return this.sleepMinutes;
  }
  
  public int getSleepStatus()
  {
    return this.sleepStatus;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setSleepMinutes(int paramInt)
  {
    this.sleepMinutes = paramInt;
  }
  
  public void setSleepStatus(int paramInt)
  {
    this.sleepStatus = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtSleepDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */