package com.project.library.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SportDataDay
  implements Parcelable
{
  public static final Parcelable.Creator<SportDataDay> CREATOR = new Parcelable.Creator()
  {
    public SportDataDay createFromParcel(Parcel paramAnonymousParcel)
    {
      SportDataDay localSportDataDay = new SportDataDay();
      localSportDataDay.date = Long.valueOf(paramAnonymousParcel.readLong());
      localSportDataDay.totalstepCount = paramAnonymousParcel.readInt();
      localSportDataDay.totalCalory = paramAnonymousParcel.readInt();
      localSportDataDay.totalDistance = paramAnonymousParcel.readInt();
      localSportDataDay.totalActiveTime = paramAnonymousParcel.readInt();
      return localSportDataDay;
    }
    
    public SportDataDay[] newArray(int paramAnonymousInt)
    {
      return new SportDataDay[paramAnonymousInt];
    }
  };
  private Long date;
  private int totalActiveTime;
  private int totalCalory;
  private int totalDistance;
  private int totalstepCount;
  
  public SportDataDay() {}
  
  public SportDataDay(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public SportDataDay(Long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.date = paramLong;
    this.totalstepCount = paramInt1;
    this.totalCalory = paramInt2;
    this.totalDistance = paramInt3;
    this.totalActiveTime = paramInt4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Long getDate()
  {
    return this.date;
  }
  
  public int getTotalActiveTime()
  {
    return this.totalActiveTime;
  }
  
  public int getTotalCalory()
  {
    return this.totalCalory;
  }
  
  public int getTotalDistance()
  {
    return this.totalDistance;
  }
  
  public int getTotalstepCount()
  {
    return this.totalstepCount;
  }
  
  public void setDate(Long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setTotalActiveTime(int paramInt)
  {
    this.totalActiveTime = paramInt;
  }
  
  public void setTotalCalory(int paramInt)
  {
    this.totalCalory = paramInt;
  }
  
  public void setTotalDistance(int paramInt)
  {
    this.totalDistance = paramInt;
  }
  
  public void setTotalstepCount(int paramInt)
  {
    this.totalstepCount = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.date.longValue());
    paramParcel.writeInt(this.totalstepCount);
    paramParcel.writeInt(this.totalCalory);
    paramParcel.writeInt(this.totalDistance);
    paramParcel.writeInt(this.totalActiveTime);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SportDataDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */