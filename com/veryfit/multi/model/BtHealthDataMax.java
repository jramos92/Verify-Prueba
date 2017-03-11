package com.veryfit.multi.model;

import java.io.Serializable;

public class BtHealthDataMax
  implements Serializable
{
  private Integer deviceId;
  private Integer sportMaxActiveTime;
  private Integer sportMaxCalory;
  private Integer sportMaxDistance;
  private Integer sportMaxStepCount;
  
  public Integer getDeviceId()
  {
    return this.deviceId;
  }
  
  public int getSportMaxActiveTime()
  {
    return this.sportMaxActiveTime.intValue();
  }
  
  public int getSportMaxCalory()
  {
    return this.sportMaxCalory.intValue();
  }
  
  public int getSportMaxDistance()
  {
    return this.sportMaxDistance.intValue();
  }
  
  public int getSportMaxStepCount()
  {
    return this.sportMaxStepCount.intValue();
  }
  
  public void setDeviceId(Integer paramInteger)
  {
    this.deviceId = paramInteger;
  }
  
  public void setSportMaxActiveTime(int paramInt)
  {
    this.sportMaxActiveTime = Integer.valueOf(paramInt);
  }
  
  public void setSportMaxCalory(int paramInt)
  {
    this.sportMaxCalory = Integer.valueOf(paramInt);
  }
  
  public void setSportMaxDistance(int paramInt)
  {
    this.sportMaxDistance = Integer.valueOf(paramInt);
  }
  
  public void setSportMaxStepCount(int paramInt)
  {
    this.sportMaxStepCount = Integer.valueOf(paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\model\BtHealthDataMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */