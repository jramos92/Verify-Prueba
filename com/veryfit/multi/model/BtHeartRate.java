package com.veryfit.multi.model;

import java.io.Serializable;

public class BtHeartRate
  implements Serializable
{
  private Long date;
  private Integer deviceId;
  private int minute;
  private int rate;
  
  public Long getDate()
  {
    return this.date;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getMinute()
  {
    return this.minute;
  }
  
  public int getRate()
  {
    return this.rate;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setMinute(int paramInt)
  {
    this.minute = paramInt;
  }
  
  public void setRate(int paramInt)
  {
    this.rate = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtHeartRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */