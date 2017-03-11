package com.project.library.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SleepDataDay
  implements Parcelable
{
  public static final Parcelable.Creator<SleepDataDay> CREATOR = new Parcelable.Creator()
  {
    public SleepDataDay createFromParcel(Parcel paramAnonymousParcel)
    {
      SleepDataDay localSleepDataDay = new SleepDataDay();
      localSleepDataDay.date = Long.valueOf(paramAnonymousParcel.readLong());
      localSleepDataDay.endTimeHour = paramAnonymousParcel.readInt();
      localSleepDataDay.endTimeMinute = paramAnonymousParcel.readInt();
      localSleepDataDay.totalSleepMinutes = paramAnonymousParcel.readInt();
      localSleepDataDay.lightSleepCount = paramAnonymousParcel.readInt();
      localSleepDataDay.deepSleepCount = paramAnonymousParcel.readInt();
      localSleepDataDay.awakeCount = paramAnonymousParcel.readInt();
      localSleepDataDay.lightSleepMinutes = paramAnonymousParcel.readInt();
      localSleepDataDay.deepSleepMinutes = paramAnonymousParcel.readInt();
      return localSleepDataDay;
    }
    
    public SleepDataDay[] newArray(int paramAnonymousInt)
    {
      return new SleepDataDay[paramAnonymousInt];
    }
  };
  private int awakeCount;
  private Long date;
  private int deepSleepCount;
  private int deepSleepMinutes;
  private int endTimeHour;
  private int endTimeMinute;
  private int lightSleepCount;
  private int lightSleepMinutes;
  private int totalSleepMinutes;
  
  public SleepDataDay() {}
  
  public SleepDataDay(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public SleepDataDay(Long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.date = paramLong;
    this.endTimeHour = paramInt1;
    this.endTimeMinute = paramInt2;
    this.totalSleepMinutes = paramInt3;
    this.lightSleepCount = paramInt4;
    this.deepSleepCount = paramInt5;
    this.awakeCount = paramInt6;
    this.lightSleepMinutes = paramInt7;
    this.deepSleepMinutes = paramInt8;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getAwakeCount()
  {
    return this.awakeCount;
  }
  
  public Long getDate()
  {
    return this.date;
  }
  
  public int getDeepSleepCount()
  {
    return this.deepSleepCount;
  }
  
  public int getDeepSleepMinutes()
  {
    return this.deepSleepMinutes;
  }
  
  public int getEndTimeHour()
  {
    return this.endTimeHour;
  }
  
  public int getEndTimeMinute()
  {
    return this.endTimeMinute;
  }
  
  public int getLightSleepCount()
  {
    return this.lightSleepCount;
  }
  
  public int getLightSleepMinutes()
  {
    return this.lightSleepMinutes;
  }
  
  public int getTotalSleepMinutes()
  {
    return this.totalSleepMinutes;
  }
  
  public void setAwakeCount(int paramInt)
  {
    this.awakeCount = paramInt;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDeepSleepCount(int paramInt)
  {
    this.deepSleepCount = paramInt;
  }
  
  public void setDeepSleepMinutes(int paramInt)
  {
    this.deepSleepMinutes = paramInt;
  }
  
  public void setEndTimeHour(int paramInt)
  {
    this.endTimeHour = paramInt;
  }
  
  public void setEndTimeMinute(int paramInt)
  {
    this.endTimeMinute = paramInt;
  }
  
  public void setLightSleepCount(int paramInt)
  {
    this.lightSleepCount = paramInt;
  }
  
  public void setLightSleepMinutes(int paramInt)
  {
    this.lightSleepMinutes = paramInt;
  }
  
  public void setTotalSleepMinutes(int paramInt)
  {
    this.totalSleepMinutes = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.date.longValue());
    paramParcel.writeInt(this.endTimeHour);
    paramParcel.writeInt(this.endTimeMinute);
    paramParcel.writeInt(this.totalSleepMinutes);
    paramParcel.writeInt(this.lightSleepCount);
    paramParcel.writeInt(this.deepSleepCount);
    paramParcel.writeInt(this.awakeCount);
    paramParcel.writeInt(this.lightSleepMinutes);
    paramParcel.writeInt(this.deepSleepMinutes);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SleepDataDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */