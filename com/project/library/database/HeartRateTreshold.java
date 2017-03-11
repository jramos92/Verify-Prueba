package com.project.library.database;

public class HeartRateTreshold
{
  private int aerobicMins;
  private int aerobicThreshold;
  private int burnFatMins;
  private int burnFatThreshold;
  private long date;
  private Long id;
  private int limitMins;
  private int limitThreshold;
  private int maxThreshold;
  private int minThreshold;
  private int silentHeartRate;
  
  public HeartRateTreshold() {}
  
  public HeartRateTreshold(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public HeartRateTreshold(Long paramLong, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.id = paramLong;
    this.date = paramLong1;
    this.minThreshold = paramInt1;
    this.burnFatThreshold = paramInt2;
    this.aerobicThreshold = paramInt3;
    this.limitThreshold = paramInt4;
    this.maxThreshold = paramInt5;
    this.silentHeartRate = paramInt6;
    this.burnFatMins = paramInt7;
    this.aerobicMins = paramInt8;
    this.limitMins = paramInt9;
  }
  
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
  
  public long getDate()
  {
    return this.date;
  }
  
  public Long getId()
  {
    return this.id;
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
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HeartRateTreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */