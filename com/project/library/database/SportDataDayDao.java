package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class SportDataDayDao
  extends AbstractDao<SportDataDay, Long>
{
  public static final String TABLENAME = "SPORT_DATA_DAY";
  
  public SportDataDayDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public SportDataDayDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'SPORT_DATA_DAY' (" + "'DATE' INTEGER PRIMARY KEY ASC ," + "'TOTALSTEP_COUNT' INTEGER NOT NULL ," + "'TOTAL_CALORY' INTEGER NOT NULL ," + "'TOTAL_DISTANCE' INTEGER NOT NULL ," + "'TOTAL_ACTIVE_TIME' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'SPORT_DATA_DAY'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, SportDataDay paramSportDataDay)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramSportDataDay.getDate();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramSportDataDay.getTotalstepCount());
    paramSQLiteStatement.bindLong(3, paramSportDataDay.getTotalCalory());
    paramSQLiteStatement.bindLong(4, paramSportDataDay.getTotalDistance());
    paramSQLiteStatement.bindLong(5, paramSportDataDay.getTotalActiveTime());
  }
  
  public Long getKey(SportDataDay paramSportDataDay)
  {
    if (paramSportDataDay != null) {
      return paramSportDataDay.getDate();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public SportDataDay readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new SportDataDay(localLong, paramCursor.getInt(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4));
    }
  }
  
  public void readEntity(Cursor paramCursor, SportDataDay paramSportDataDay, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramSportDataDay.setDate(localLong);
      paramSportDataDay.setTotalstepCount(paramCursor.getInt(paramInt + 1));
      paramSportDataDay.setTotalCalory(paramCursor.getInt(paramInt + 2));
      paramSportDataDay.setTotalDistance(paramCursor.getInt(paramInt + 3));
      paramSportDataDay.setTotalActiveTime(paramCursor.getInt(paramInt + 4));
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
  
  protected Long updateKeyAfterInsert(SportDataDay paramSportDataDay, long paramLong)
  {
    paramSportDataDay.setDate(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property Date = new Property(0, Long.class, "date", true, "DATE");
    public static final Property TotalActiveTime = new Property(4, Integer.TYPE, "totalActiveTime", false, "TOTAL_ACTIVE_TIME");
    public static final Property TotalCalory;
    public static final Property TotalDistance;
    public static final Property TotalstepCount = new Property(1, Integer.TYPE, "totalstepCount", false, "TOTALSTEP_COUNT");
    
    static
    {
      TotalCalory = new Property(2, Integer.TYPE, "totalCalory", false, "TOTAL_CALORY");
      TotalDistance = new Property(3, Integer.TYPE, "totalDistance", false, "TOTAL_DISTANCE");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SportDataDayDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */