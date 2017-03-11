package com.veryfit.multi.model;

import java.io.Serializable;

public class BtSportDataItem
  implements Serializable
{
  private int activeTime;
  private int calory;
  private long date;
  private Integer deviceId;
  private int distance;
  private int hour;
  private int minute;
  private int mode;
  private int stepCount;
  
  public int getActiveTime()
  {
    return this.activeTime;
  }
  
  public int getCalory()
  {
    return this.calory;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public int getHour()
  {
    return this.hour;
  }
  
  public int getMinute()
  {
    return this.minute;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getStepCount()
  {
    return this.stepCount;
  }
  
  public void setActiveTime(int paramInt)
  {
    this.activeTime = paramInt;
  }
  
  public void setCalory(int paramInt)
  {
    this.calory = paramInt;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }
  
  public void setHour(int paramInt)
  {
    this.hour = paramInt;
  }
  
  public void setMinute(int paramInt)
  {
    this.minute = paramInt;
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setStepCount(int paramInt)
  {
    this.stepCount = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtSportDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */