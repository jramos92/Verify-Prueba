package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class SleepDataItemDao
  extends AbstractDao<SleepDataItem, Long>
{
  public static final String TABLENAME = "SLEEP_DATA_ITEM";
  
  public SleepDataItemDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public SleepDataItemDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'SLEEP_DATA_ITEM' (" + "'_id' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'DATE' INTEGER NOT NULL ," + "'SLEEP_STATUS' INTEGER NOT NULL ," + "'SLEEP_MINUTES' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'SLEEP_DATA_ITEM'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, SleepDataItem paramSleepDataItem)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramSleepDataItem.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramSleepDataItem.getDate());
    paramSQLiteStatement.bindLong(3, paramSleepDataItem.getSleepStatus());
    paramSQLiteStatement.bindLong(4, paramSleepDataItem.getSleepMinutes());
  }
  
  public Long getKey(SleepDataItem paramSleepDataItem)
  {
    if (paramSleepDataItem != null) {
      return paramSleepDataItem.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public SleepDataItem readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new SleepDataItem(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3));
    }
  }
  
  public void readEntity(Cursor paramCursor, SleepDataItem paramSleepDataItem, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramSleepDataItem.setId(localLong);
      paramSleepDataItem.setDate(paramCursor.getLong(paramInt + 1));
      paramSleepDataItem.setSleepStatus(paramCursor.getInt(paramInt + 2));
      paramSleepDataItem.setSleepMinutes(paramCursor.getInt(paramInt + 3));
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
  
  protected Long updateKeyAfterInsert(SleepDataItem paramSleepDataItem, long paramLong)
  {
    paramSleepDataItem.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property Date;
    public static final Property Id = new Property(0, Long.class, "id", true, "_id");
    public static final Property SleepMinutes = new Property(3, Integer.TYPE, "sleepMinutes", false, "SLEEP_MINUTES");
    public static final Property SleepStatus;
    
    static
    {
      Date = new Property(1, Long.TYPE, "date", false, "DATE");
      SleepStatus = new Property(2, Integer.TYPE, "sleepStatus", false, "SLEEP_STATUS");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\SleepDataItemDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */