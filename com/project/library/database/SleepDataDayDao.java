package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class SleepDataDayDao
  extends AbstractDao<SleepDataDay, Long>
{
  public static final String TABLENAME = "SLEEP_DATA_DAY";
  
  public SleepDataDayDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public SleepDataDayDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'SLEEP_DATA_DAY' (" + "'DATE' INTEGER PRIMARY KEY ASC ," + "'END_TIME_HOUR' INTEGER NOT NULL ," + "'END_TIME_MINUTE' INTEGER NOT NULL ," + "'TOTAL_SLEEP_MINUTES' INTEGER NOT NULL ," + "'LIGHT_SLEEP_COUNT' INTEGER NOT NULL ," + "'DEEP_SLEEP_COUNT' INTEGER NOT NULL ," + "'AWAKE_COUNT' INTEGER NOT NULL ," + "'LIGHT_SLEEP_MINUTES' INTEGER NOT NULL ," + "'DEEP_SLEEP_MINUTES' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'SLEEP_DATA_DAY'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, SleepDataDay paramSleepDataDay)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramSleepDataDay.getDate();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramSleepDataDay.getEndTimeHour());
    paramSQLiteStatement.bindLong(3, paramSleepDataDay.getEndTimeMinute());
    paramSQLiteStatement.bindLong(4, paramSleepDataDay.getTotalSleepMinutes());
    paramSQLiteStatement.bindLong(5, paramSleepDataDay.getLightSleepCount());
    paramSQLiteStatement.bindLong(6, paramSleepDataDay.getDeepSleepCount());
    paramSQLiteStatement.bindLong(7, paramSleepDataDay.getAwakeCount());
    paramSQLiteStatement.bindLong(8, paramSleepDataDay.getLightSleepMinutes());
    paramSQLiteStatement.bindLong(9, paramSleepDataDay.getDeepSleepMinutes());
  }
  
  public Long getKey(SleepDataDay paramSleepDataDay)
  {
    if (paramSleepDataDay != null) {
      return paramSleepDataDay.getDate();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public SleepDataDay readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new SleepDataDay(localLong, paramCursor.getInt(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4), paramCursor.getInt(paramInt + 5), paramCursor.getInt(paramInt + 6), paramCursor.getInt(paramInt + 7), paramCursor.getInt(paramInt + 8));
    }
  }
  
  public void readEntity(Cursor paramCursor, SleepDataDay paramSleepDataDay, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramSleepDataDay.setDate(localLong);
      paramSleepDataDay.setEndTimeHour(paramCursor.getInt(paramInt + 1));
      paramSleepDataDay.setEndTimeMinute(paramCursor.getInt(paramInt + 2));
      paramSleepDataDay.setTotalSleepMinutes(paramCursor.getInt(paramInt + 3));
      paramSleepDataDay.setLightSleepCount(paramCursor.getInt(paramInt + 4));
      paramSleepDataDay.setDeepSleepCount(paramCursor.getInt(paramInt + 5));
      paramSleepDataDay.setAwakeCount(paramCursor.getInt(paramInt + 6));
      paramSleepDataDay.setLightSleepMinutes(paramCursor.getInt(paramInt + 7));
      paramSleepDataDay.setDeepSleepMinutes(paramCursor.getInt(paramInt + 8));
      return;
    }
  }
  
  public Long readKey(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {
      return null;
    }
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }
  
  protected Long updateKeyAfterInsert(SleepDataDay paramSleepDataDay, long paramLong)
  {
    paramSleepDataDay.setDate(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property AwakeCount;
    public static final Property Date = new Property(0, Long.class, "date", true, "DATE");
    public static final Property DeepSleepCount;
    public static final Property DeepSleepMinutes = new Property(8, Integer.TYPE, "deepSleepMinutes", false, "DEEP_SLEEP_MINUTES");
    public static final Property EndTimeHour = new Property(1, Integer.TYPE, "endTimeHour", false, "END_TIME_HOUR");
    public static final Property EndTimeMinute = new Property(2, Integer.TYPE, "endTimeMinute", false, "END_TIME_MINUTE");
    public static final Property LightSleepCount;
    public static final Property LightSleepMinutes;
    public static final Property TotalSleepMinutes = new Property(3, Integer.TYPE, "totalSleepMinutes", false, "TOTAL_SLEEP_MINUTES");
    
    static
    {
      LightSleepCount = new Property(4, Integer.TYPE, "lightSleepCount", false, "LIGHT_SLEEP_COUNT");
      DeepSleepCount = new Property(5, Integer.TYPE, "deepSleepCount", false, "DEEP_SLEEP_COUNT");
      AwakeCount = new Property(6, Integer.TYPE, "awakeCount", false, "AWAKE_COUNT");
      LightSleepMinutes = new Property(7, Integer.TYPE, "lightSleepMinutes", false, "LIGHT_SLEEP_MINUTES");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SleepDataDayDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */