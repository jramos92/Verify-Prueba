package com.veryfit.multi.model;

import java.io.Serializable;

public class BtHeartRateThreshold
  implements Serializable
{
  private int aerobicMins;
  private int aerobicThreshold;
  private int burnFatMins;
  private int burnFatThreshold;
  private Long date;
  private Integer deviceId;
  private int limitMins;
  private int limitThreshold;
  private int maxThreshold;
  private int minThreshold;
  private int silentHeartRate;
  
  public int getAerobicMins()
  {
    return this.aerobicMins;
  }
  
  public int getAerobicThreshold()
  {
    return this.aerobicThreshold;
  }
  
  public int getBurnFatMins()
  {
    return this.burnFatMins;
  }
  
  public int getBurnFatThreshold()
  {
    return this.burnFatThreshold;
  }
  
  public Long getDate()
  {
    return this.date;
  }
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getLimitMins()
  {
    return this.limitMins;
  }
  
  public int getLimitThreshold()
  {
    return this.limitThreshold;
  }
  
  public int getMaxThreshold()
  {
    return this.maxThreshold;
  }
  
  public int getMinThreshold()
  {
    return this.minThreshold;
  }
  
  public int getSilentHeartRate()
  {
    return this.silentHeartRate;
  }
  
  public void setAerobicMins(int paramInt)
  {
    this.aerobicMins = paramInt;
  }
  
  public void setAerobicThreshold(int paramInt)
  {
    this.aerobicThreshold = paramInt;
  }
  
  public void setBurnFatMins(int paramInt)
  {
    this.burnFatMins = paramInt;
  }
  
  public void setBurnFatThreshold(int paramInt)
  {
    this.burnFatThreshold = paramInt;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setLimitMins(int paramInt)
  {
    this.limitMins = paramInt;
  }
  
  public void setLimitThreshold(int paramInt)
  {
    this.limitThreshold = paramInt;
  }
  
  public void setMaxThreshold(int paramInt)
  {
    this.maxThreshold = paramInt;
  }
  
  public void setMinThreshold(int paramInt)
  {
    this.minThreshold = paramInt;
  }
  
  public void setSilentHeartRate(int paramInt)
  {
    this.silentHeartRate = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtHeartRateThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */