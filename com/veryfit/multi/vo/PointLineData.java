package com.veryfit.multi.vo;

import com.veryfit.multi.util.Util;
import java.util.Calendar;

public class PointLineData
{
  public int data;
  public Calendar date;
  
  public boolean isSameDay(Calendar paramCalendar)
  {
    return Util.isSameDay(this.date, paramCalendar);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vo\PointLineData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */