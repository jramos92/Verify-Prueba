package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class HeartRateDao
  extends AbstractDao<HeartRate, Long>
{
  public static final String TABLENAME = "HEART_RATE";
  
  public HeartRateDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public HeartRateDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'HEART_RATE' (" + "'_id' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'DATE' INTEGER NOT NULL ," + "'MINUTE' INTEGER NOT NULL ," + "'RATE' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'HEART_RATE'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, HeartRate paramHeartRate)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramHeartRate.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramHeartRate.getDate());
    paramSQLiteStatement.bindLong(3, paramHeartRate.getMinute());
    paramSQLiteStatement.bindLong(4, paramHeartRate.getRate());
  }
  
  public Long getKey(HeartRate paramHeartRate)
  {
    if (paramHeartRate != null) {
      return paramHeartRate.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public HeartRate readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new HeartRate(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3));
    }
  }
  
  public void readEntity(Cursor paramCursor, HeartRate paramHeartRate, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramHeartRate.setId(localLong);
      paramHeartRate.setDate(paramCursor.getLong(paramInt + 1));
      paramHeartRate.setMinute(paramCursor.getInt(paramInt + 2));
      paramHeartRate.setRate(paramCursor.getInt(paramInt + 3));
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
  
  protected Long updateKeyAfterInsert(HeartRate paramHeartRate, long paramLong)
  {
    paramHeartRate.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property Date = new Property(1, Long.TYPE, "date", false, "DATE");
    public static final Property Id = new Property(0, Long.class, "id", true, "_id");
    public static final Property Minute = new Property(2, Integer.TYPE, "minute", false, "MINUTE");
    public static final Property Rate = new Property(3, Integer.TYPE, "rate", false, "RATE");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HeartRateDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */