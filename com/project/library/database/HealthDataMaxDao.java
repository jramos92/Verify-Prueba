package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class HealthDataMaxDao
  extends AbstractDao<HealthDataMax, Long>
{
  public static final String TABLENAME = "HEALTH_DATA_MAX";
  
  public HealthDataMaxDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public HealthDataMaxDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'HEALTH_DATA_MAX' (" + "'_id' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'SPORT_MAX_STEP_COUNT' INTEGER NOT NULL ," + "'SPORT_MAX_CALORY' INTEGER NOT NULL ," + "'SPORT_MAX_DISTANCE' INTEGER NOT NULL ," + "'SPORT_MAX_ACTIVE_TIME' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'HEALTH_DATA_MAX'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, HealthDataMax paramHealthDataMax)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramHealthDataMax.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramHealthDataMax.getSportMaxStepCount());
    paramSQLiteStatement.bindLong(3, paramHealthDataMax.getSportMaxCalory());
    paramSQLiteStatement.bindLong(4, paramHealthDataMax.getSportMaxDistance());
    paramSQLiteStatement.bindLong(5, paramHealthDataMax.getSportMaxActiveTime());
  }
  
  public Long getKey(HealthDataMax paramHealthDataMax)
  {
    if (paramHealthDataMax != null) {
      return paramHealthDataMax.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public HealthDataMax readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new HealthDataMax(localLong, paramCursor.getInt(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4));
    }
  }
  
  public void readEntity(Cursor paramCursor, HealthDataMax paramHealthDataMax, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramHealthDataMax.setId(localLong);
      paramHealthDataMax.setSportMaxStepCount(paramCursor.getInt(paramInt + 1));
      paramHealthDataMax.setSportMaxCalory(paramCursor.getInt(paramInt + 2));
      paramHealthDataMax.setSportMaxDistance(paramCursor.getInt(paramInt + 3));
      paramHealthDataMax.setSportMaxActiveTime(paramCursor.getInt(paramInt + 4));
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
  
  protected Long updateKeyAfterInsert(HealthDataMax paramHealthDataMax, long paramLong)
  {
    paramHealthDataMax.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property Id = new Property(0, Long.class, "id", true, "_id");
    public static final Property SportMaxActiveTime = new Property(4, Integer.TYPE, "sportMaxActiveTime", false, "SPORT_MAX_ACTIVE_TIME");
    public static final Property SportMaxCalory;
    public static final Property SportMaxDistance;
    public static final Property SportMaxStepCount = new Property(1, Integer.TYPE, "sportMaxStepCount", false, "SPORT_MAX_STEP_COUNT");
    
    static
    {
      SportMaxCalory = new Property(2, Integer.TYPE, "sportMaxCalory", false, "SPORT_MAX_CALORY");
      SportMaxDistance = new Property(3, Integer.TYPE, "sportMaxDistance", false, "SPORT_MAX_DISTANCE");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HealthDataMaxDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */