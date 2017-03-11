package com.project.library.database;

import com.project.library.util.LongDateUtil;
import java.util.Calendar;

public class Goal
{
  public static final int TYPE_SLEEP = 1;
  public static final int TYPE_SPORT = 0;
  private long date;
  private int goal;
  private Long id;
  private int type;
  
  public Goal() {}
  
  public Goal(int paramInt1, int paramInt2)
  {
    this.date = LongDateUtil.Calendar2LongDate(Calendar.getInstance());
    this.goal = paramInt1;
    this.type = paramInt2;
  }
  
  public Goal(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public Goal(Long paramLong, long paramLong1, int paramInt1, int paramInt2)
  {
    this.id = paramLong;
    this.date = paramLong1;
    this.goal = paramInt1;
    this.type = paramInt2;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public int getGoal()
  {
    return this.goal;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setGoal(int paramInt)
  {
    this.goal = paramInt;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\Goal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */