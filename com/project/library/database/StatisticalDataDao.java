package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class StatisticalDataDao
  extends AbstractDao<StatisticalData, Long>
{
  public static final String TABLENAME = "STATISTICAL_DATA";
  
  public StatisticalDataDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public StatisticalDataDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'STATISTICAL_DATA' (" + "'ID' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'START_TIME' INTEGER NOT NULL ," + "'STOP_TIME' INTEGER NOT NULL ," + "'TYPE' INTEGER NOT NULL ," + "'DAY_COUNT' INTEGER NOT NULL ," + "'HEALTH_TYPE' INTEGER NOT NULL ," + "'TOTAL_DISTANCE' REAL NOT NULL ," + "'TOTAL_STEP' INTEGER NOT NULL ," + "'TOTAL_CALORY' INTEGER NOT NULL ," + "'TOTAL_SLEEP' INTEGER NOT NULL ," + "'TOTAL_DEEP_SLEEP' INTEGER NOT NULL ," + "'TOTAL_LIGHT_SLEEP' INTEGER NOT NULL ," + "'TOTAL_FALL_SLEEP' INTEGER NOT NULL ," + "'TOTAL_AWAKE_TIME' INTEGER NOT NULL ," + "'TOTAL_AWAKE_DURATION' INTEGER NOT NULL ," + "'TOTAL_BURN_FAT' INTEGER NOT NULL ," + "'TOTAL_AEROBIC' INTEGER NOT NULL ," + "'TOTAL_LIMIT' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'STATISTICAL_DATA'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, StatisticalData paramStatisticalData)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramStatisticalData.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramStatisticalData.getStartTime());
    paramSQLiteStatement.bindLong(3, paramStatisticalData.getStopTime());
    paramSQLiteStatement.bindLong(4, paramStatisticalData.getType());
    paramSQLiteStatement.bindLong(5, paramStatisticalData.getDayCount());
    paramSQLiteStatement.bindLong(6, paramStatisticalData.getHealthType());
    paramSQLiteStatement.bindDouble(7, paramStatisticalData.getTotalDistance());
    paramSQLiteStatement.bindLong(8, paramStatisticalData.getTotalStep());
    paramSQLiteStatement.bindLong(9, paramStatisticalData.getTotalCalory());
    paramSQLiteStatement.bindLong(10, paramStatisticalData.getTotalSleep());
    paramSQLiteStatement.bindLong(11, paramStatisticalData.getTotalDeepSleep());
    paramSQLiteStatement.bindLong(12, paramStatisticalData.getTotalLightSleep());
    paramSQLiteStatement.bindLong(13, paramStatisticalData.getTotalFallSleep());
    paramSQLiteStatement.bindLong(14, paramStatisticalData.getTotalAwakeTime());
    paramSQLiteStatement.bindLong(15, paramStatisticalData.getTotalAwakeDuration());
    paramSQLiteStatement.bindLong(16, paramStatisticalData.getTotalBurnFat());
    paramSQLiteStatement.bindLong(17, paramStatisticalData.getTotalAerobic());
    paramSQLiteStatement.bindLong(18, paramStatisticalData.getTotalLimit());
  }
  
  public Long getKey(StatisticalData paramStatisticalData)
  {
    if (paramStatisticalData != null) {
      return paramStatisticalData.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public StatisticalData readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new StatisticalData(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getLong(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4), paramCursor.getInt(paramInt + 5), paramCursor.getFloat(paramInt + 6), paramCursor.getLong(paramInt + 7), paramCursor.getLong(paramInt + 8), paramCursor.getLong(paramInt + 9), paramCursor.getLong(paramInt + 10), paramCursor.getLong(paramInt + 11), paramCursor.getLong(paramInt + 12), paramCursor.getLong(paramInt + 13), paramCursor.getLong(paramInt + 14), paramCursor.getLong(paramInt + 15), paramCursor.getLong(paramInt + 16), paramCursor.getLong(paramInt + 17));
    }
  }
  
  public void readEntity(Cursor paramCursor, StatisticalData paramStatisticalData, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramStatisticalData.setId(localLong);
      paramStatisticalData.setStartTime(paramCursor.getLong(paramInt + 1));
      paramStatisticalData.setStopTime(paramCursor.getLong(paramInt + 2));
      paramStatisticalData.setType(paramCursor.getInt(paramInt + 3));
      paramStatisticalData.setDayCount(paramCursor.getInt(paramInt + 4));
      paramStatisticalData.setHealthType(paramCursor.getInt(paramInt + 5));
      paramStatisticalData.setTotalDistance(paramCursor.getFloat(paramInt + 6));
      paramStatisticalData.setTotalStep(paramCursor.getLong(paramInt + 7));
      paramStatisticalData.setTotalCalory(paramCursor.getLong(paramInt + 8));
      paramStatisticalData.setTotalSleep(paramCursor.getLong(paramInt + 9));
      paramStatisticalData.setTotalDeepSleep(paramCursor.getLong(paramInt + 10));
      paramStatisticalData.setTotalLightSleep(paramCursor.getLong(paramInt + 11));
      paramStatisticalData.setTotalFallSleep(paramCursor.getLong(paramInt + 12));
      paramStatisticalData.setTotalAwakeTime(paramCursor.getLong(paramInt + 13));
      paramStatisticalData.setTotalAwakeDuration(paramCursor.getLong(paramInt + 14));
      paramStatisticalData.setTotalBurnFat(paramCursor.getLong(paramInt + 15));
      paramStatisticalData.setTotalAerobic(paramCursor.getLong(paramInt + 16));
      paramStatisticalData.setTotalLimit(paramCursor.getLong(paramInt + 17));
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
  
  protected Long updateKeyAfterInsert(StatisticalData paramStatisticalData, long paramLong)
  {
    paramStatisticalData.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property DayCount;
    public static final Property HealthType;
    public static final Property Id = new Property(0, Long.class, "id", true, "ID");
    public static final Property StartTime = new Property(1, Long.TYPE, "startTime", false, "START_TIME");
    public static final Property StopTime = new Property(2, Long.TYPE, "stopTime", false, "STOP_TIME");
    public static final Property TotalAerobic = new Property(16, Long.TYPE, "totalAerobic", false, "TOTAL_AEROBIC");
    public static final Property TotalAwakeDuration;
    public static final Property TotalAwakeTime;
    public static final Property TotalBurnFat;
    public static final Property TotalCalory;
    public static final Property TotalDeepSleep;
    public static final Property TotalDistance;
    public static final Property TotalFallSleep;
    public static final Property TotalLightSleep;
    public static final Property TotalLimit = new Property(17, Long.TYPE, "totalLimit", false, "TOTAL_LIMIT");
    public static final Property TotalSleep;
    public static final Property TotalStep;
    public static final Property Type = new Property(3, Integer.TYPE, "type", false, "TYPE");
    
    static
    {
      DayCount = new Property(4, Integer.TYPE, "dayCount", false, "DAY_COUNT");
      HealthType = new Property(5, Integer.TYPE, "healthType", false, "HEALTH_TYPE");
      TotalDistance = new Property(6, Float.TYPE, "totalDistance", false, "TOTAL_DISTANCE");
      TotalStep = new Property(7, Long.TYPE, "totalStep", false, "TOTAL_STEP");
      TotalCalory = new Property(8, Long.TYPE, "totalCalory", false, "TOTAL_CALORY");
      TotalSleep = new Property(9, Long.TYPE, "totalSleep", false, "TOTAL_SLEEP");
      TotalDeepSleep = new Property(10, Long.TYPE, "totalDeepSleep", false, "TOTAL_DEEP_SLEEP");
      TotalLightSleep = new Property(11, Long.TYPE, "totalLightSleep", false, "TOTAL_LIGHT_SLEEP");
      TotalFallSleep = new Property(12, Long.TYPE, "totalFallSleep", false, "TOTAL_FALL_SLEEP");
      TotalAwakeTime = new Property(13, Long.TYPE, "totalAwakeTime", false, "TOTAL_AWAKE_TIME");
      TotalAwakeDuration = new Property(14, Long.TYPE, "totalAwakeDuration", false, "TOTAL_AWAKE_DURATION");
      TotalBurnFat = new Property(15, Long.TYPE, "totalBurnFat", false, "TOTAL_BURN_FAT");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\StatisticalDataDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */