package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class SportDataItemDao
  extends AbstractDao<SportDataItem, Long>
{
  public static final String TABLENAME = "SPORT_DATA_ITEM";
  
  public SportDataItemDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public SportDataItemDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'SPORT_DATA_ITEM' (" + "'_id' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'DATE' INTEGER NOT NULL ," + "'HOUR' INTEGER NOT NULL ," + "'MINUTE' INTEGER NOT NULL ," + "'MODE' INTEGER NOT NULL ," + "'STEP_COUNT' INTEGER NOT NULL ," + "'ACTIVE_TIME' INTEGER NOT NULL ," + "'CALORY' INTEGER NOT NULL ," + "'DISTANCE' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'SPORT_DATA_ITEM'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, SportDataItem paramSportDataItem)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramSportDataItem.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramSportDataItem.getDate());
    paramSQLiteStatement.bindLong(3, paramSportDataItem.getHour());
    paramSQLiteStatement.bindLong(4, paramSportDataItem.getMinute());
    paramSQLiteStatement.bindLong(5, paramSportDataItem.getMode());
    paramSQLiteStatement.bindLong(6, paramSportDataItem.getStepCount());
    paramSQLiteStatement.bindLong(7, paramSportDataItem.getActiveTime());
    paramSQLiteStatement.bindLong(8, paramSportDataItem.getCalory());
    paramSQLiteStatement.bindLong(9, paramSportDataItem.getDistance());
  }
  
  public Long getKey(SportDataItem paramSportDataItem)
  {
    if (paramSportDataItem != null) {
      return paramSportDataItem.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public SportDataItem readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new SportDataItem(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4), paramCursor.getInt(paramInt + 5), paramCursor.getInt(paramInt + 6), paramCursor.getInt(paramInt + 7), paramCursor.getInt(paramInt + 8));
    }
  }
  
  public void readEntity(Cursor paramCursor, SportDataItem paramSportDataItem, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramSportDataItem.setId(localLong);
      paramSportDataItem.setDate(paramCursor.getLong(paramInt + 1));
      paramSportDataItem.setHour(paramCursor.getInt(paramInt + 2));
      paramSportDataItem.setMinute(paramCursor.getInt(paramInt + 3));
      paramSportDataItem.setMode(paramCursor.getInt(paramInt + 4));
      paramSportDataItem.setStepCount(paramCursor.getInt(paramInt + 5));
      paramSportDataItem.setActiveTime(paramCursor.getInt(paramInt + 6));
      paramSportDataItem.setCalory(paramCursor.getInt(paramInt + 7));
      paramSportDataItem.setDistance(paramCursor.getInt(paramInt + 8));
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
  
  protected Long updateKeyAfterInsert(SportDataItem paramSportDataItem, long paramLong)
  {
    paramSportDataItem.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property ActiveTime = new Property(6, Integer.TYPE, "activeTime", false, "ACTIVE_TIME");
    public static final Property Calory = new Property(7, Integer.TYPE, "calory", false, "CALORY");
    public static final Property Date;
    public static final Property Distance = new Property(8, Integer.TYPE, "distance", false, "DISTANCE");
    public static final Property Hour;
    public static final Property Id = new Property(0, Long.class, "id", true, "_id");
    public static final Property Minute;
    public static final Property Mode;
    public static final Property StepCount;
    
    static
    {
      Date = new Property(1, Long.TYPE, "date", false, "DATE");
      Hour = new Property(2, Integer.TYPE, "hour", false, "HOUR");
      Minute = new Property(3, Integer.TYPE, "minute", false, "MINUTE");
      Mode = new Property(4, Integer.TYPE, "mode", false, "MODE");
      StepCount = new Property(5, Integer.TYPE, "stepCount", false, "STEP_COUNT");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SportDataItemDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */