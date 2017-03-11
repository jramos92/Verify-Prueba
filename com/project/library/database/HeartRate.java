package com.project.library.database;

public class HeartRate
{
  private long date;
  private Long id;
  private int minute;
  private int rate;
  
  public HeartRate() {}
  
  public HeartRate(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public HeartRate(Long paramLong, long paramLong1, int paramInt1, int paramInt2)
  {
    this.id = paramLong;
    this.date = paramLong1;
    this.minute = paramInt1;
    this.rate = paramInt2;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public int getMinute()
  {
    return this.minute;
  }
  
  public int getRate()
  {
    return this.rate;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HeartRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */