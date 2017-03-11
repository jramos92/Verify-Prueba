package com.project.library.database;

import com.project.library.util.LongDateUtil;
import java.util.Calendar;

public class StatisticalData
{
  public static final int HEALTH_TYPE_SLEEP = 1;
  public static final int HEALTH_TYPE_SPORT = 0;
  public static final int TYPE_MONTH = 1;
  public static final int TYPE_WEEK = 0;
  public static final int TYPE_YEAR = 2;
  private int dayCount;
  private int healthType;
  private Long id;
  private long startTime;
  private long stopTime;
  private long totalAerobic;
  private long totalAwakeDuration;
  private long totalAwakeTime;
  private long totalBurnFat;
  private long totalCalory;
  private long totalDeepSleep;
  private float totalDistance;
  private long totalFallSleep;
  private long totalLightSleep;
  private long totalLimit;
  private long totalSleep;
  private long totalStep;
  private int type;
  
  public StatisticalData() {}
  
  public StatisticalData(float paramFloat, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8)
  {
    this.dayCount += 1;
    this.totalDistance += paramFloat;
    this.totalStep += paramLong1;
    this.totalCalory += paramLong2;
    this.totalSleep += paramLong3;
    this.totalDeepSleep += paramLong4;
    this.totalLightSleep += paramLong5;
    this.totalFallSleep += paramLong6;
    this.totalAwakeTime += paramLong7;
    this.totalAwakeDuration += paramLong8;
  }
  
  public StatisticalData(long paramLong1, long paramLong2, int paramInt)
  {
    this.startTime = paramLong1;
    this.stopTime = paramLong2;
    this.type = paramInt;
  }
  
  public StatisticalData(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public StatisticalData(Long paramLong, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float paramFloat, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13)
  {
    this.id = paramLong;
    this.startTime = paramLong1;
    this.stopTime = paramLong2;
    this.type = paramInt1;
    this.dayCount = paramInt2;
    this.healthType = paramInt3;
    this.totalDistance = paramFloat;
    this.totalStep = paramLong3;
    this.totalCalory = paramLong4;
    this.totalSleep = paramLong5;
    this.totalDeepSleep = paramLong6;
    this.totalLightSleep = paramLong7;
    this.totalFallSleep = paramLong8;
    this.totalAwakeTime = paramLong9;
    this.totalAwakeDuration = paramLong10;
    this.totalBurnFat = paramLong11;
    this.totalAerobic = paramLong12;
    this.totalLimit = paramLong13;
  }
  
  private int[] getDate(long paramLong)
  {
    Calendar localCalendar = LongDateUtil.LongDate2Calendar(paramLong);
    return new int[] { localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5) };
  }
  
  private String[] getSleepShowDatas()
  {
    return new String[] { String.format("%.2f", new Object[] { Float.valueOf((float)this.totalSleep * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalDeepSleep * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalLightSleep * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalFallSleep * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalAwakeTime * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalAwakeDuration * 1.0F / Math.max(this.dayCount, 1)) }) };
  }
  
  private String[] getSportShowDatas()
  {
    return new String[] { String.format("%.2f", new Object[] { Float.valueOf(this.totalDistance / 1000.0F) }), this.totalStep, this.totalCalory, String.format("%.2f", new Object[] { Float.valueOf(this.totalDistance / 1000.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalStep * 1.0F / Math.max(this.dayCount, 1)) }), String.format("%.2f", new Object[] { Float.valueOf((float)this.totalCalory * 1.0F / Math.max(this.dayCount, 1)) }) };
  }
  
  public int getDayCount()
  {
    return this.dayCount;
  }
  
  public int getHealthType()
  {
    return this.healthType;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public String[] getPageType(int paramInt)
  {
    if (paramInt == 0) {
      return getSportShowDatas();
    }
    return getSleepShowDatas();
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public long getStopTime()
  {
    return this.stopTime;
  }
  
  public String getTitleString()
  {
    int[] arrayOfInt1 = getDate(this.startTime);
    int[] arrayOfInt2 = getDate(this.stopTime);
    switch (this.type)
    {
    default: 
      return "";
    case 0: 
    case 1: 
      return arrayOfInt1[1] + "/" + arrayOfInt1[2] + "-" + arrayOfInt2[1] + "/" + arrayOfInt2[2];
    }
    return arrayOfInt1[0] + "/" + arrayOfInt1[1] + "-" + arrayOfInt2[0] + "/" + arrayOfInt2[1];
  }
  
  public long getTotalAerobic()
  {
    return this.totalAerobic;
  }
  
  public long getTotalAwakeDuration()
  {
    return this.totalAwakeDuration;
  }
  
  public long getTotalAwakeTime()
  {
    return this.totalAwakeTime;
  }
  
  public long getTotalBurnFat()
  {
    return this.totalBurnFat;
  }
  
  public long getTotalCalory()
  {
    return this.totalCalory;
  }
  
  public long getTotalDeepSleep()
  {
    return this.totalDeepSleep;
  }
  
  public float getTotalDistance()
  {
    return this.totalDistance;
  }
  
  public long getTotalFallSleep()
  {
    return this.totalFallSleep;
  }
  
  public long getTotalLightSleep()
  {
    return this.totalLightSleep;
  }
  
  public long getTotalLimit()
  {
    return this.totalLimit;
  }
  
  public long getTotalSleep()
  {
    return this.totalSleep;
  }
  
  public long getTotalStep()
  {
    return this.totalStep;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setDayCount(int paramInt)
  {
    this.dayCount = paramInt;
  }
  
  public void setHealthType(int paramInt)
  {
    this.healthType = paramInt;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setStopTime(long paramLong)
  {
    this.stopTime = paramLong;
  }
  
  public void setTotalAerobic(long paramLong)
  {
    this.totalAerobic = paramLong;
  }
  
  public void setTotalAwakeDuration(long paramLong)
  {
    this.totalAwakeDuration = paramLong;
  }
  
  public void setTotalAwakeTime(long paramLong)
  {
    this.totalAwakeTime = paramLong;
  }
  
  public void setTotalBurnFat(long paramLong)
  {
    this.totalBurnFat = paramLong;
  }
  
  public void setTotalCalory(long paramLong)
  {
    this.totalCalory = paramLong;
  }
  
  public void setTotalDeepSleep(long paramLong)
  {
    this.totalDeepSleep = paramLong;
  }
  
  public void setTotalDistance(float paramFloat)
  {
    this.totalDistance = paramFloat;
  }
  
  public void setTotalFallSleep(long paramLong)
  {
    this.totalFallSleep = paramLong;
  }
  
  public void setTotalLightSleep(long paramLong)
  {
    this.totalLightSleep = paramLong;
  }
  
  public void setTotalLimit(long paramLong)
  {
    this.totalLimit = paramLong;
  }
  
  public void setTotalSleep(long paramLong)
  {
    this.totalSleep = paramLong;
  }
  
  public void setTotalStep(long paramLong)
  {
    this.totalStep = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void update(boolean paramBoolean, StatisticalData paramStatisticalData)
  {
    if (!paramBoolean) {
      this.dayCount += 1;
    }
    this.totalDistance += paramStatisticalData.totalDistance;
    this.totalStep += paramStatisticalData.totalStep;
    this.totalCalory += paramStatisticalData.totalCalory;
    this.totalSleep += paramStatisticalData.totalSleep;
    this.totalDeepSleep += paramStatisticalData.totalDeepSleep;
    this.totalLightSleep += paramStatisticalData.totalLightSleep;
    this.totalFallSleep += paramStatisticalData.totalFallSleep;
    this.totalAwakeTime += paramStatisticalData.totalAwakeTime;
    this.totalAwakeDuration += paramStatisticalData.totalAwakeDuration;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\StatisticalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */