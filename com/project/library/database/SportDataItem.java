package com.project.library.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SportDataItem
  implements Parcelable
{
  public static final Parcelable.Creator<SportDataItem> CREATOR = new Parcelable.Creator()
  {
    public SportDataItem createFromParcel(Parcel paramAnonymousParcel)
    {
      SportDataItem localSportDataItem = new SportDataItem();
      localSportDataItem.id = Long.valueOf(paramAnonymousParcel.readLong());
      localSportDataItem.date = paramAnonymousParcel.readLong();
      localSportDataItem.hour = paramAnonymousParcel.readInt();
      localSportDataItem.minute = paramAnonymousParcel.readInt();
      localSportDataItem.mode = paramAnonymousParcel.readInt();
      localSportDataItem.stepCount = paramAnonymousParcel.readInt();
      localSportDataItem.activeTime = paramAnonymousParcel.readInt();
      localSportDataItem.calory = paramAnonymousParcel.readInt();
      localSportDataItem.distance = paramAnonymousParcel.readInt();
      return localSportDataItem;
    }
    
    public SportDataItem[] newArray(int paramAnonymousInt)
    {
      return new SportDataItem[paramAnonymousInt];
    }
  };
  private int activeTime;
  private int calory;
  private long date;
  private int distance;
  private int hour;
  private Long id;
  private int minute;
  private int mode;
  private int stepCount;
  
  public SportDataItem() {}
  
  public SportDataItem(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public SportDataItem(Long paramLong, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.id = paramLong;
    this.date = paramLong1;
    this.hour = paramInt1;
    this.minute = paramInt2;
    this.mode = paramInt3;
    this.stepCount = paramInt4;
    this.activeTime = paramInt5;
    this.calory = paramInt6;
    this.distance = paramInt7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getActiveTime()
  {
    return this.activeTime;
  }
  
  public int getCalory()
  {
    return this.calory;
  }
  
  public long getDate()
  {
    return this.date;
  }
  
  public int getDistance()
  {
    return this.distance;
  }
  
  public int getHour()
  {
    return this.hour;
  }
  
  public Long getId()
  {
    return this.id;
  }
  
  public int getMinute()
  {
    return this.minute;
  }
  
  public int getMode()
  {
    return this.mode;
  }
  
  public int getStepCount()
  {
    return this.stepCount;
  }
  
  public void setActiveTime(int paramInt)
  {
    this.activeTime = paramInt;
  }
  
  public void setCalory(int paramInt)
  {
    this.calory = paramInt;
  }
  
  public void setDate(long paramLong)
  {
    this.date = paramLong;
  }
  
  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }
  
  public void setHour(int paramInt)
  {
    this.hour = paramInt;
  }
  
  public void setId(Long paramLong)
  {
    this.id = paramLong;
  }
  
  public void setMinute(int paramInt)
  {
    this.minute = paramInt;
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setStepCount(int paramInt)
  {
    this.stepCount = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id.longValue());
    paramParcel.writeLong(this.date);
    paramParcel.writeInt(this.hour);
    paramParcel.writeInt(this.minute);
    paramParcel.writeInt(this.mode);
    paramParcel.writeInt(this.stepCount);
    paramParcel.writeInt(this.activeTime);
    paramParcel.writeInt(this.calory);
    paramParcel.writeInt(this.distance);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SportDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */