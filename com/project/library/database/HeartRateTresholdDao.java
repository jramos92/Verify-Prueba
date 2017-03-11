package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class HeartRateTresholdDao
  extends AbstractDao<HeartRateTreshold, Long>
{
  public static final String TABLENAME = "HEART_RATE_TRESHOLD";
  
  public HeartRateTresholdDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public HeartRateTresholdDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'HEART_RATE_TRESHOLD' (" + "'_id' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'DATE' INTEGER NOT NULL ," + "'MIN_THRESHOLD' INTEGER NOT NULL ," + "'BURN_FAT_THRESHOLD' INTEGER NOT NULL ," + "'AEROBIC_THRESHOLD' INTEGER NOT NULL ," + "'LIMIT_THRESHOLD' INTEGER NOT NULL ," + "'MAX_THRESHOLD' INTEGER NOT NULL ," + "'SILENT_HEART_RATE' INTEGER NOT NULL ," + "'BURN_FAT_MINS' INTEGER NOT NULL ," + "'AEROBIC_MINS' INTEGER NOT NULL ," + "'LIMIT_MINS' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'HEART_RATE_TRESHOLD'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, HeartRateTreshold paramHeartRateTreshold)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramHeartRateTreshold.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramHeartRateTreshold.getDate());
    paramSQLiteStatement.bindLong(3, paramHeartRateTreshold.getMinThreshold());
    paramSQLiteStatement.bindLong(4, paramHeartRateTreshold.getBurnFatThreshold());
    paramSQLiteStatement.bindLong(5, paramHeartRateTreshold.getAerobicThreshold());
    paramSQLiteStatement.bindLong(6, paramHeartRateTreshold.getLimitThreshold());
    paramSQLiteStatement.bindLong(7, paramHeartRateTreshold.getMaxThreshold());
    paramSQLiteStatement.bindLong(8, paramHeartRateTreshold.getSilentHeartRate());
    paramSQLiteStatement.bindLong(9, paramHeartRateTreshold.getBurnFatMins());
    paramSQLiteStatement.bindLong(10, paramHeartRateTreshold.getAerobicMins());
    paramSQLiteStatement.bindLong(11, paramHeartRateTreshold.getLimitMins());
  }
  
  public Long getKey(HeartRateTreshold paramHeartRateTreshold)
  {
    if (paramHeartRateTreshold != null) {
      return paramHeartRateTreshold.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public HeartRateTreshold readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new HeartRateTreshold(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4), paramCursor.getInt(paramInt + 5), paramCursor.getInt(paramInt + 6), paramCursor.getInt(paramInt + 7), paramCursor.getInt(paramInt + 8), paramCursor.getInt(paramInt + 9), paramCursor.getInt(paramInt + 10));
    }
  }
  
  public void readEntity(Cursor paramCursor, HeartRateTreshold paramHeartRateTreshold, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramHeartRateTreshold.setId(localLong);
      paramHeartRateTreshold.setDate(paramCursor.getLong(paramInt + 1));
      paramHeartRateTreshold.setMinThreshold(paramCursor.getInt(paramInt + 2));
      paramHeartRateTreshold.setBurnFatThreshold(paramCursor.getInt(paramInt + 3));
      paramHeartRateTreshold.setAerobicThreshold(paramCursor.getInt(paramInt + 4));
      paramHeartRateTreshold.setLimitThreshold(paramCursor.getInt(paramInt + 5));
      paramHeartRateTreshold.setMaxThreshold(paramCursor.getInt(paramInt + 6));
      paramHeartRateTreshold.setSilentHeartRate(paramCursor.getInt(paramInt + 7));
      paramHeartRateTreshold.setBurnFatMins(paramCursor.getInt(paramInt + 8));
      paramHeartRateTreshold.setAerobicMins(paramCursor.getInt(paramInt + 9));
      paramHeartRateTreshold.setLimitMins(paramCursor.getInt(paramInt + 10));
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
  
  protected Long updateKeyAfterInsert(HeartRateTreshold paramHeartRateTreshold, long paramLong)
  {
    paramHeartRateTreshold.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property AerobicMins = new Property(9, Integer.TYPE, "aerobicMins", false, "AEROBIC_MINS");
    public static final Property AerobicThreshold;
    public static final Property BurnFatMins;
    public static final Property BurnFatThreshold;
    public static final Property Date;
    public static final Property Id = new Property(0, Long.class, "id", true, "_id");
    public static final Property LimitMins = new Property(10, Integer.TYPE, "limitMins", false, "LIMIT_MINS");
    public static final Property LimitThreshold;
    public static final Property MaxThreshold;
    public static final Property MinThreshold;
    public static final Property SilentHeartRate;
    
    static
    {
      Date = new Property(1, Long.TYPE, "date", false, "DATE");
      MinThreshold = new Property(2, Integer.TYPE, "minThreshold", false, "MIN_THRESHOLD");
      BurnFatThreshold = new Property(3, Integer.TYPE, "burnFatThreshold", false, "BURN_FAT_THRESHOLD");
      AerobicThreshold = new Property(4, Integer.TYPE, "aerobicThreshold", false, "AEROBIC_THRESHOLD");
      LimitThreshold = new Property(5, Integer.TYPE, "limitThreshold", false, "LIMIT_THRESHOLD");
      MaxThreshold = new Property(6, Integer.TYPE, "maxThreshold", false, "MAX_THRESHOLD");
      SilentHeartRate = new Property(7, Integer.TYPE, "silentHeartRate", false, "SILENT_HEART_RATE");
      BurnFatMins = new Property(8, Integer.TYPE, "burnFatMins", false, "BURN_FAT_MINS");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\HeartRateTresholdDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */