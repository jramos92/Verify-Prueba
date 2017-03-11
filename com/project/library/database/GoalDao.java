package com.project.library.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

public class GoalDao
  extends AbstractDao<Goal, Long>
{
  public static final String TABLENAME = "GOAL";
  
  public GoalDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }
  
  public GoalDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'GOAL' (" + "'ID' INTEGER PRIMARY KEY ASC AUTOINCREMENT ," + "'DATE' INTEGER NOT NULL ," + "'GOAL' INTEGER NOT NULL ," + "'TYPE' INTEGER NOT NULL );");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'GOAL'");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, Goal paramGoal)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramGoal.getId();
    if (localLong != null) {
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    }
    paramSQLiteStatement.bindLong(2, paramGoal.getDate());
    paramSQLiteStatement.bindLong(3, paramGoal.getGoal());
    paramSQLiteStatement.bindLong(4, paramGoal.getType());
  }
  
  public Long getKey(Goal paramGoal)
  {
    if (paramGoal != null) {
      return paramGoal.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public Goal readEntity(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0))) {
      return new Goal(localLong, paramCursor.getLong(paramInt + 1), paramCursor.getInt(paramInt + 2), paramCursor.getInt(paramInt + 3));
    }
  }
  
  public void readEntity(Cursor paramCursor, Goal paramGoal, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {}
    for (Long localLong = null;; localLong = Long.valueOf(paramCursor.getLong(paramInt + 0)))
    {
      paramGoal.setId(localLong);
      paramGoal.setDate(paramCursor.getLong(paramInt + 1));
      paramGoal.setGoal(paramCursor.getInt(paramInt + 2));
      paramGoal.setType(paramCursor.getInt(paramInt + 3));
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
  
  protected Long updateKeyAfterInsert(Goal paramGoal, long paramLong)
  {
    paramGoal.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final Property Date = new Property(1, Long.TYPE, "date", false, "DATE");
    public static final Property Goal = new Property(2, Integer.TYPE, "goal", false, "GOAL");
    public static final Property Id = new Property(0, Long.class, "id", true, "ID");
    public static final Property Type = new Property(3, Integer.TYPE, "type", false, "TYPE");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\database\GoalDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */