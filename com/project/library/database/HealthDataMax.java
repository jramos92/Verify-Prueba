package com.project.library.database;

public class HealthDataMax
{
  private Long id;
  private int sportMaxActiveTime;
  private int sportMaxCalory;
  private int sportMaxDistance;
  private int sportMaxStepCount;
  
  public HealthDataMax() {}
  
  public HealthDataMax(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public HealthDataMax(Long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.id = paramLong;
    this.sportMaxStepCount = paramInt1;
    this.sportMaxCalory = paramInt2;
    this.sportMaxDistance = paramInt3;
    this.sportMaxActiveTime = paramInt4;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public int getSportMaxActiveTime()
  {
    return this.sportMaxActiveTime;
  }
  
  public int getSportMaxCalory()
  {
    return this.sportMaxCalory;
  }
  
  public int getSportMaxDistance()
  {
    return this.sportMaxDistance;
  }
  
  public int getSportMaxStepCount()
  {
    return this.sportMaxStepCount;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setSportMaxActiveTime(int paramInt)
  {
    this.sportMaxActiveTime = paramInt;
  }
  
  public void setSportMaxCalory(int paramInt)
  {
    this.sportMaxCalory = paramInt;
  }
  
  public void setSportMaxDistance(int paramInt)
  {
    this.sportMaxDistance = paramInt;
  }
  
  public void setSportMaxStepCount(int paramInt)
  {
    this.sportMaxStepCount = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HealthDataMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */