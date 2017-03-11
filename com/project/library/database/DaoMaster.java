package com.project.library.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

public class DaoMaster
  extends AbstractDaoMaster
{
  public static final int SCHEMA_VERSION = 1004;
  
  public DaoMaster(SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramSQLiteDatabase, 1004);
    registerDaoClass(SportDataDayDao.class);
    registerDaoClass(SportDataItemDao.class);
    registerDaoClass(SleepDataDayDao.class);
    registerDaoClass(SleepDataItemDao.class);
    registerDaoClass(AlarmNotifyDao.class);
    registerDaoClass(HealthDataMaxDao.class);
    registerDaoClass(GoalDao.class);
    registerDaoClass(StatisticalDataDao.class);
    registerDaoClass(HeartRateDao.class);
    registerDaoClass(HeartRateTresholdDao.class);
  }
  
  public static void createAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    SportDataDayDao.createTable(paramSQLiteDatabase, paramBoolean);
    SportDataItemDao.createTable(paramSQLiteDatabase, paramBoolean);
    SleepDataDayDao.createTable(paramSQLiteDatabase, paramBoolean);
    SleepDataItemDao.createTable(paramSQLiteDatabase, paramBoolean);
    AlarmNotifyDao.createTable(paramSQLiteDatabase, paramBoolean);
    HealthDataMaxDao.createTable(paramSQLiteDatabase, paramBoolean);
    GoalDao.createTable(paramSQLiteDatabase, paramBoolean);
    StatisticalDataDao.createTable(paramSQLiteDatabase, paramBoolean);
    HeartRateDao.createTable(paramSQLiteDatabase, paramBoolean);
    HeartRateTresholdDao.createTable(paramSQLiteDatabase, paramBoolean);
  }
  
  public static void dropAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    SportDataDayDao.dropTable(paramSQLiteDatabase, paramBoolean);
    SportDataItemDao.dropTable(paramSQLiteDatabase, paramBoolean);
    SleepDataDayDao.dropTable(paramSQLiteDatabase, paramBoolean);
    SleepDataItemDao.dropTable(paramSQLiteDatabase, paramBoolean);
    AlarmNotifyDao.dropTable(paramSQLiteDatabase, paramBoolean);
    HealthDataMaxDao.dropTable(paramSQLiteDatabase, paramBoolean);
    GoalDao.dropTable(paramSQLiteDatabase, paramBoolean);
    StatisticalDataDao.dropTable(paramSQLiteDatabase, paramBoolean);
    HeartRateDao.dropTable(paramSQLiteDatabase, paramBoolean);
    HeartRateTresholdDao.dropTable(paramSQLiteDatabase, paramBoolean);
  }
  
  public DaoSession newSession()
  {
    return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
  }
  
  public DaoSession newSession(IdentityScopeType paramIdentityScopeType)
  {
    return new DaoSession(this.db, paramIdentityScopeType, this.daoConfigMap);
  }
  
  public static class DevOpenHelper
    extends DaoMaster.OpenHelper
  {
    public DevOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("greenDAO", "Upgrading schema from version " + paramInt1 + " to " + paramInt2 + " by dropping all tables");
      DaoMaster.dropAllTables(paramSQLiteDatabase, true);
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public static abstract class OpenHelper
    extends SQLiteOpenHelper
  {
    public OpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory, 1004);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.i("greenDAO", "Creating tables for schema version 1004");
      DaoMaster.createAllTables(paramSQLiteDatabase, false);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\DaoMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */