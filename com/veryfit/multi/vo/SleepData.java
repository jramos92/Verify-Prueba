package com.veryfit.multi.vo;

import com.veryfit.multi.util.Util;
import java.util.Calendar;
import java.util.List;

public class SleepData
{
  public int awakeTotal;
  public Calendar date;
  public int deepTotal;
  public int[] duration;
  public int durationMins;
  public int[] endTime;
  private List<SleepItem> items;
  public int lightTotal;
  public int[] startTime;
  private int startTimeMins = -1;
  
  public int[] getDuration()
  {
    if (this.duration == null)
    {
      this.duration = new int[2];
      this.duration = Util.getHourAndMin(this.durationMins, true);
    }
    return this.duration;
  }
  
  public int getDurationMins()
  {
    this.durationMins = (getEndTimeMins() - getStartTimeMins());
    if (this.durationMins < 0) {
      return this.durationMins + 1440;
    }
    return this.durationMins;
  }
  
  public int getEndTimeMins()
  {
    return this.endTime[0] * 60 + this.endTime[1];
  }
  
  public List<SleepItem> getItems()
  {
    return this.items;
  }
  
  public int[] getStartTime()
  {
    if (this.startTime == null)
    {
      this.startTime = new int[2];
      this.startTime = Util.getHourAndMin(getStartTimeMins(), true);
    }
    return this.startTime;
  }
  
  public int getStartTimeMins()
  {
    if (this.startTimeMins == -1) {}
    for (this.startTimeMins = (this.endTime[0] * 60 + this.endTime[1] - this.durationMins);; this.startTimeMins += 1440) {
      if (this.startTimeMins >= 0) {
        return this.startTimeMins;
      }
    }
  }
  
  public void setItems(List<SleepItem> paramList)
  {
    this.items = paramList;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\SleepData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */