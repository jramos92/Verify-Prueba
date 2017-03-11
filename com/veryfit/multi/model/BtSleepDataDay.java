package com.veryfit.multi.model;

import java.io.Serializable;

public class BtSleepDataDay
  implements Serializable
{
  private int awakeCount;
  private Long date;
  private int deepSleepCount;
  private int deepSleepMinutes;
  private Integer deviceId;
  private int endTimeHour;
  private int endTimeMinute;
  private int lightSleepCount;
  private int lightSleepMinutes;
  private int totalSleepMinutes;
  
  public int getAwakeCount()
  {
    return this.awakeCount;
  }
  
  public Long getDate()
  {
    return this.date;
  }
  
  public int getDeepSleepCount()
  {
    return this.deepSleepCount;
  }
  
  public int getDeepSleepMinutes()
  {
    return this.deepSleepMinutes;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getEndTimeHour()
  {
    return this.endTimeHour;
  }
  
  public int getEndTimeMinute()
  {
    return this.endTimeMinute;
  }
  
  public int getLightSleepCount()
  {
    return this.lightSleepCount;
  }
  
  public int getLightSleepMinutes()
  {
    return this.lightSleepMinutes;
  }
  
  public int getTotalSleepMinutes()
  {
    return this.totalSleepMinutes;
  }
  
  public void setAwakeCount(int paramInt)
  {
    this.awakeCount = paramInt;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeepSleepCount(int paramInt)
  {
    this.deepSleepCount = paramInt;
  }
  
  public void setDeepSleepMinutes(int paramInt)
  {
    this.deepSleepMinutes = paramInt;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setEndTimeHour(int paramInt)
  {
    this.endTimeHour = paramInt;
  }
  
  public void setEndTimeMinute(int paramInt)
  {
    this.endTimeMinute = paramInt;
  }
  
  public void setLightSleepCount(int paramInt)
  {
    this.lightSleepCount = paramInt;
  }
  
  public void setLightSleepMinutes(int paramInt)
  {
    this.lightSleepMinutes = paramInt;
  }
  
  public void setTotalSleepMinutes(int paramInt)
  {
    this.totalSleepMinutes = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtSleepDataDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */