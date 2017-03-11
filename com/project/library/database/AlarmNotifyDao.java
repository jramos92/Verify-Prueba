package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class AlarmNotifyDao
  extends AbstractDao<AlarmNotify, Long>
{
  public static final String TABLENAME = "ALARM_NOTIFY";
  
  public AlarmNotifyDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public AlarmNotifyDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'ALARM_NOTIFY' (" + "'ALARM_ID' INTEGER PRIMARY KEY ASC NOT NULL ," + "'ALARM_STATUS' INTEGER NOT NULL ," + "'ALARM_TYPE' INTEGER NOT NULL ," + "'ALARM_HOUR' INTEGER NOT NULL ," + "'ALARM_MINUTE' INTEGER NOT NULL ," + "'ALARM_REPETITIONS' INTEGER NOT NULL ," + "'ALARM_SNOOZE_DURATION' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'ALARM_NOTIFY'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, AlarmNotify paramAlarmNotify)
  {
    paramSQLiteStatement.clearBindings();
    paramSQLiteStatement.bindLong(1, paramAlarmNotify.getAlarmId());
    paramSQLiteStatement.bindLong(2, paramAlarmNotify.getAlarmStatus());
    paramSQLiteStatement.bindLong(3, paramAlarmNotify.getAlarmType());
    paramSQLiteStatement.bindLong(4, paramAlarmNotify.getAlarmHour());
    paramSQLiteStatement.bindLong(5, paramAlarmNotify.getAlarmMinute());
    paramSQLiteStatement.bindLong(6, paramAlarmNotify.getAlarmRepetitions());
    paramSQLiteStatement.bindLong(7, paramAlarmNotify.getAlarmSnoozeDuration());
  }
  
  public Long getKey(AlarmNotify paramAlarmNotify)
  {
    if (paramAlarmNotify != null) {
      return Long.valueOf(paramAlarmNotify.getAlarmId());
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public AlarmNotify readEntity(Cursor paramCursor, int paramInt)
  {
    return new AlarmNotify(paramCursor.getLong(paramInt + 0), paramCursor.getInt(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3), paramCursor.getInt(paramInt + 4), paramCursor.getInt(paramInt + 5), paramCursor.getInt(paramInt + 6));
  }
  
  public void readEntity(Cursor paramCursor, AlarmNotify paramAlarmNotify, int paramInt)
  {
    paramAlarmNotify.setAlarmId(paramCursor.getLong(paramInt + 0));
    paramAlarmNotify.setAlarmStatus(paramCursor.getInt(paramInt + 1));
    paramAlarmNotify.setAlarmType(paramCursor.getInt(paramInt + 2));
    paramAlarmNotify.setAlarmHour(paramCursor.getInt(paramInt + 3));
    paramAlarmNotify.setAlarmMinute(paramCursor.getInt(paramInt + 4));
    paramAlarmNotify.setAlarmRepetitions(paramCursor.getInt(paramInt + 5));
    paramAlarmNotify.setAlarmSnoozeDuration(paramCursor.getInt(paramInt + 6));
  }
  
  public Long readKey(Cursor paramCursor, int paramInt)
  {
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }
  
  protected Long updateKeyAfterInsert(AlarmNotify paramAlarmNotify, long paramLong)
  {
    paramAlarmNotify.setAlarmId(paramLong);
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property AlarmHour = new Property(3, Integer.TYPE, "alarmHour", false, "ALARM_HOUR");
    public static final Property AlarmId = new Property(0, Long.TYPE, "alarmId", true, "ALARM_ID");
    public static final Property AlarmMinute = new Property(4, Integer.TYPE, "alarmMinute", false, "ALARM_MINUTE");
    public static final Property AlarmRepetitions = new Property(5, Integer.TYPE, "alarmRepetitions", false, "ALARM_REPETITIONS");
    public static final Property AlarmSnoozeDuration = new Property(6, Integer.TYPE, "alarmSnoozeDuration", false, "ALARM_SNOOZE_DURATION");
    public static final Property AlarmStatus = new Property(1, Integer.TYPE, "alarmStatus", false, "ALARM_STATUS");
    public static final Property AlarmType = new Property(2, Integer.TYPE, "alarmType", false, "ALARM_TYPE");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\AlarmNotifyDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */