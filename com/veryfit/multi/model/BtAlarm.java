package com.veryfit.multi.model;

import java.io.Serializable;

public class BtAlarm
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer alarmStatus;
  private Integer alarmType;
  private Integer deviceId;
  private Integer hour;
  private Integer min;
  private Integer repetitions;
  private Integer snoozeDuration;
  
  public Integer getAlarmStatus()
  {
    return this.alarmStatus;
  }
  
  public Integer getAlarmType()
  {
    return this.alarmType;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public Integer getHour()
  {
    return this.hour;
  }
  
  public Integer getMin()
  {
    return this.min;
  }
  
  public Integer getRepetitions()
  {
    return this.repetitions;
  }
  
  public Integer getSnoozeDuration()
  {
    return this.snoozeDuration;
  }
  
  public void setAlarmStatus(Integer paramInteger)
  {
    this.alarmStatus = paramInteger;
  }
  
  public void setAlarmType(Integer paramInteger)
  {
    this.alarmType = paramInteger;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setHour(Integer paramInteger)
  {
    this.hour = paramInteger;
  }
  
  public void setMin(Integer paramInteger)
  {
    this.min = paramInteger;
  }
  
  public void setRepetitions(Integer paramInteger)
  {
    this.repetitions = paramInteger;
  }
  
  public void setSnoozeDuration(Integer paramInteger)
  {
    this.snoozeDuration = paramInteger;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtAlarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */