package com.project.library.util;

import java.util.Calendar;

public class LongDateUtil
{
  public static long DATE_MILLS = 86400000L;
  
  public static long Calendar2LongDate(Calendar paramCalendar)
  {
    return getLongDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public static Calendar LongDate2Calendar(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, getYear(paramLong));
    localCalendar.set(2, getMonth(paramLong) - 1);
    localCalendar.set(5, getDay(paramLong));
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar;
  }
  
  public static long add(long paramLong, int paramInt)
  {
    if (paramInt < 0) {
      return sub(paramLong, -paramInt);
    }
    int i = getYear(paramLong);
    int m = getMonth(paramLong);
    int k = getDay(paramLong) + paramInt;
    paramInt = getMonthDay(i, m);
    for (;;)
    {
      if (k <= paramInt) {
        return getLongDate(i, m, k);
      }
      m += 1;
      k -= paramInt;
      paramInt = m;
      int j = i;
      if (m > 12)
      {
        j = i + 1;
        paramInt = 1;
      }
      i = getMonthDay(j, paramInt);
      m = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public static int getDay(long paramLong)
  {
    return (int)(paramLong % 100L);
  }
  
  public static long getFirstDayOfMonth(int paramInt)
  {
    long l = Calendar2LongDate(Calendar.getInstance());
    int j = getYear(l);
    int k = getMonth(l) - paramInt;
    int i = k;
    paramInt = j;
    if (k <= 0)
    {
      i = 12;
      paramInt = j - 1;
    }
    return getLongDate(paramInt, i, 1);
  }
  
  public static long getFirstDayOfMonth(long paramLong)
  {
    return getLongDate(getYear(paramLong), getMonth(paramLong), 1);
  }
  
  public static Calendar getFirstDayOfMonth(Calendar paramCalendar)
  {
    return LongDate2Calendar(getFirstDayOfMonth(Calendar2LongDate(paramCalendar)));
  }
  
  public static long getFirstDayOfWeek(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setFirstDayOfWeek(1);
    int j = localCalendar.get(7);
    int i = j;
    if (j < 1) {
      i = 7;
    }
    return sub(sub(Calendar2LongDate(localCalendar), i - 1), paramInt * 7);
  }
  
  public static long getFirstDayOfWeek(long paramLong)
  {
    Calendar localCalendar = LongDate2Calendar(paramLong);
    localCalendar.setFirstDayOfWeek(1);
    int j = localCalendar.get(7);
    int i = j;
    if (j < 1) {
      i = 7;
    }
    return sub(paramLong, i - 1);
  }
  
  public static Calendar getFirstDayOfWeek(Calendar paramCalendar)
  {
    return LongDate2Calendar(getFirstDayOfWeek(Calendar2LongDate(paramCalendar)));
  }
  
  public static long getFirstDayOfYear(int paramInt)
  {
    return getLongDate(getYear(Calendar2LongDate(Calendar.getInstance())) - paramInt, 1, 1);
  }
  
  public static long getFirstDayOfYear(long paramLong)
  {
    return getLongDate(getYear(paramLong), 1, 1);
  }
  
  public static Calendar getFirstDayOfYear(Calendar paramCalendar)
  {
    return LongDate2Calendar(getFirstDayOfYear(Calendar2LongDate(paramCalendar)));
  }
  
  public static long getLongDate(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 * 10000 + paramInt2 * 100 + paramInt3;
  }
  
  public static int getMonth(long paramLong)
  {
    return (int)(paramLong / 100L % 100L);
  }
  
  public static int getMonthDay(int paramInt1, int paramInt2)
  {
    int i = 0;
    switch (paramInt2)
    {
    default: 
      paramInt2 = i;
    }
    do
    {
      do
      {
        return paramInt2;
        return 31;
        return 30;
        i = 28;
        if (paramInt1 % 400 == 0) {
          break;
        }
        paramInt2 = i;
      } while (paramInt1 % 4 != 0);
      paramInt2 = i;
    } while (paramInt1 % 100 == 0);
    return 29;
  }
  
  public static int getMonthsBetweenDates(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return getMonthsBetweenDates(paramLong2, paramLong1);
    }
    int n = getYear(paramLong1);
    int k = getYear(paramLong2);
    int i1 = getMonth(paramLong1);
    int m = getMonth(paramLong2);
    int j = m;
    int i = k;
    if (m < i1)
    {
      j = m + 12;
      i = k - 1;
    }
    return (i - n) * 12 + (j - i1) + 1;
  }
  
  public static int getWeeksBetweenDates(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return getWeeksBetweenDates(paramLong2, paramLong1);
    }
    Calendar localCalendar = LongDate2Calendar(paramLong1);
    return (int)((LongDate2Calendar(paramLong2).getTimeInMillis() - localCalendar.getTimeInMillis()) / DATE_MILLS) / 7 + 1;
  }
  
  public static int getYear(long paramLong)
  {
    return (int)(paramLong / 10000L);
  }
  
  public static int getYearsBetweenDates(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2) {
      return getYearsBetweenDates(paramLong2, paramLong1);
    }
    int i = getYear(paramLong1);
    return getYear(paramLong2) - i + 1;
  }
  
  public static long sub(long paramLong, int paramInt)
  {
    if (paramInt < 0) {
      return add(paramLong, -paramInt);
    }
    int j = getYear(paramLong);
    int i = getMonth(paramLong);
    int k = getDay(paramLong) - paramInt;
    paramInt = i;
    i = k;
    for (;;)
    {
      if (i > 0) {
        return getLongDate(j, paramInt, i);
      }
      int m = paramInt - 1;
      paramInt = m;
      k = j;
      if (m <= 0)
      {
        k = j - 1;
        paramInt = 12;
      }
      i += getMonthDay(k, paramInt);
      j = k;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\LongDateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */