package com.veryfit.multi.model;

import java.io.Serializable;

public class BtSportDataDay
  implements Serializable
{
  private Long date;
  private Integer deviceId;
  private int totalActiveTime;
  private int totalCalory;
  private int totalDistance;
  private int totalstepCount;
  
  public Long getDate()
  {
    return this.date;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getTotalActiveTime()
  {
    return this.totalActiveTime;
  }
  
  public int getTotalCalory()
  {
    return this.totalCalory;
  }
  
  public int getTotalDistance()
  {
    return this.totalDistance;
  }
  
  public int getTotalstepCount()
  {
    return this.totalstepCount;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setTotalActiveTime(int paramInt)
  {
    this.totalActiveTime = paramInt;
  }
  
  public void setTotalCalory(int paramInt)
  {
    this.totalCalory = paramInt;
  }
  
  public void setTotalDistance(int paramInt)
  {
    this.totalDistance = paramInt;
  }
  
  public void setTotalstepCount(int paramInt)
  {
    this.totalstepCount = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtSportDataDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */