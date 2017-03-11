package com.project.library.database;

public class SleepDataItem
{
  private long date;
  private Long id;
  private int sleepMinutes;
  private int sleepStatus;
  
  public SleepDataItem() {}
  
  public SleepDataItem(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public SleepDataItem(Long paramLong, long paramLong1, int paramInt1, int paramInt2)
  {
    this.id = paramLong;
    this.date = paramLong1;
    this.sleepStatus = paramInt1;
    this.sleepMinutes = paramInt2;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public int getSleepMinutes()
  {
    return this.sleepMinutes;
  }
  
  public int getSleepStatus()
  {
    return this.sleepStatus;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SleepDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */