package com.project.library.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AlarmNotify
  implements Parcelable, Comparable<AlarmNotify>
{
  public static final Parcelable.Creator<AlarmNotify> CREATOR = new Parcelable.Creator()
  {
    public AlarmNotify createFromParcel(Parcel paramAnonymousParcel)
    {
      AlarmNotify localAlarmNotify = new AlarmNotify();
      localAlarmNotify.alarmId = paramAnonymousParcel.readLong();
      localAlarmNotify.alarmStatus = paramAnonymousParcel.readInt();
      localAlarmNotify.alarmType = paramAnonymousParcel.readInt();
      localAlarmNotify.alarmHour = paramAnonymousParcel.readInt();
      localAlarmNotify.alarmMinute = paramAnonymousParcel.readInt();
      localAlarmNotify.alarmRepetitions = paramAnonymousParcel.readInt();
      localAlarmNotify.alarmSnoozeDuration = paramAnonymousParcel.readInt();
      return localAlarmNotify;
    }
    
    public AlarmNotify[] newArray(int paramAnonymousInt)
    {
      return new AlarmNotify[paramAnonymousInt];
    }
  };
  public static final int MAX = 5;
  public static final int MAX_ALARM_COUNT = 10;
  public static final int STATUS_ADD_MODIFY = 85;
  public static final int STATUS_DELETE = 170;
  public static final int TYPE_ALARM_CUSTOM = 7;
  public static final int TYPE_ALARM_DATING = 4;
  public static final int TYPE_ALARM_MEDICINE = 3;
  public static final int TYPE_ALARM_METTING = 6;
  public static final int TYPE_ALARM_PARTY = 5;
  public static final int TYPE_ALARM_SLEEP = 1;
  public static final int TYPE_ALARM_SPORT = 2;
  public static final int TYPE_ALARM_WAKEUP = 0;
  private int alarmHour;
  private long alarmId;
  private int alarmMinute;
  private int alarmRepetitions;
  private int alarmSnoozeDuration;
  private int alarmStatus;
  private int alarmType;
  public boolean hasModify = false;
  
  public AlarmNotify() {}
  
  public AlarmNotify(long paramLong)
  {
    this.alarmId = paramLong;
  }
  
  public AlarmNotify(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.alarmId = paramLong;
    this.alarmStatus = paramInt1;
    this.alarmType = paramInt2;
    this.alarmHour = paramInt3;
    this.alarmMinute = paramInt4;
    this.alarmRepetitions = paramInt5;
    this.alarmSnoozeDuration = paramInt6;
  }
  
  public static void copy(AlarmNotify paramAlarmNotify1, AlarmNotify paramAlarmNotify2)
  {
    paramAlarmNotify2.alarmType = paramAlarmNotify1.alarmType;
    paramAlarmNotify2.alarmHour = paramAlarmNotify1.alarmHour;
    paramAlarmNotify2.alarmMinute = paramAlarmNotify1.alarmMinute;
    paramAlarmNotify2.alarmRepetitions = paramAlarmNotify1.alarmRepetitions;
    paramAlarmNotify2.alarmSnoozeDuration = paramAlarmNotify1.alarmSnoozeDuration;
    paramAlarmNotify2.alarmStatus = 85;
  }
  
  public static String getRepeat(String[] paramArrayOfString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i >= 7) {
      if (localStringBuffer.length() <= 0) {
        break label125;
      }
    }
    label97:
    label125:
    for (paramInt = localStringBuffer.length() - 1;; paramInt = 0)
    {
      return localStringBuffer.substring(0, paramInt);
      int j = 1 << i + 1;
      if ((paramInt & j) == j) {
        if (i <= 5) {
          break label97;
        }
      }
      for (String str = paramArrayOfString[0] + ",";; str = paramArrayOfString[(i + 1)] + ",")
      {
        localStringBuffer.append(str);
        i += 1;
        break;
      }
    }
  }
  
  public static String getRepeat1(String[] paramArrayOfString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i >= 7) {
      if (localStringBuffer.length() <= 0) {
        break label88;
      }
    }
    label88:
    for (paramInt = localStringBuffer.length() - 1;; paramInt = 0)
    {
      return localStringBuffer.substring(0, paramInt);
      int j = 1 << i + 1;
      if ((paramInt & j) == j) {
        localStringBuffer.append(paramArrayOfString[i] + ",");
      }
      i += 1;
      break;
    }
  }
  
  public static int updateRepeat(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 | 1 << paramInt2;
    }
    return paramInt1 & (1 << paramInt2 ^ 0xFFFFFFFF);
  }
  
  public int compareTo(AlarmNotify paramAlarmNotify)
  {
    return (int)(this.alarmId - paramAlarmNotify.getAlarmId());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof AlarmNotify))
    {
      bool1 = bool2;
      if (((AlarmNotify)paramObject).alarmId == this.alarmId) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int getAlarmHour()
  {
    return this.alarmHour;
  }
  
  public long getAlarmId()
  {
    return this.alarmId;
  }
  
  public int getAlarmMinute()
  {
    return this.alarmMinute;
  }
  
  public int getAlarmRepetitions()
  {
    return this.alarmRepetitions;
  }
  
  public int getAlarmSnoozeDuration()
  {
    return this.alarmSnoozeDuration;
  }
  
  public int getAlarmStatus()
  {
    return this.alarmStatus;
  }
  
  public int getAlarmType()
  {
    return this.alarmType;
  }
  
  public String getRepeat(String[] paramArrayOfString)
  {
    return getRepeat(paramArrayOfString, this.alarmRepetitions);
  }
  
  public boolean isOpen()
  {
    return (this.alarmRepetitions & 0x1) == 1;
  }
  
  public void setAlarmHour(int paramInt)
  {
    this.alarmHour = paramInt;
  }
  
  public void setAlarmId(long paramLong)
  {
    this.alarmId = paramLong;
  }
  
  public void setAlarmMinute(int paramInt)
  {
    this.alarmMinute = paramInt;
  }
  
  public void setAlarmRepetitions(int paramInt)
  {
    this.alarmRepetitions = paramInt;
  }
  
  public void setAlarmSnoozeDuration(int paramInt)
  {
    this.alarmSnoozeDuration = paramInt;
  }
  
  public void setAlarmStatus(int paramInt)
  {
    this.alarmStatus = paramInt;
  }
  
  public void setAlarmType(int paramInt)
  {
    this.alarmType = paramInt;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    if (this.hasModify) {}
    for (boolean bool = false;; bool = true)
    {
      this.hasModify = bool;
      if (!paramBoolean) {
        break;
      }
      this.alarmRepetitions |= 0x1;
      return;
    }
    this.alarmRepetitions &= 0xFFFFFFFE;
  }
  
  public String toString()
  {
    return " alarm : {id:" + this.alarmId + ",status:" + this.alarmStatus + ",time:" + this.alarmHour + ":" + this.alarmMinute + ",repeat:" + this.alarmRepetitions + ",type:" + this.alarmType + ",hasModify:" + this.hasModify + "}";
  }
  
  public void updateRepeat(int paramInt, boolean paramBoolean)
  {
    this.alarmRepetitions = updateRepeat(this.alarmRepetitions, paramInt, paramBoolean);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.alarmId);
    paramParcel.writeInt(this.alarmStatus);
    paramParcel.writeInt(this.alarmType);
    paramParcel.writeInt(this.alarmHour);
    paramParcel.writeInt(this.alarmMinute);
    paramParcel.writeInt(this.alarmRepetitions);
    paramParcel.writeInt(this.alarmSnoozeDuration);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\AlarmNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */