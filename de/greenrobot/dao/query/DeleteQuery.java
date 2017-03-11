package de.greenrobot.dao.query;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;

public class DeleteQuery<T>
  extends AbstractQuery<T>
{
  private final QueryData<T> queryData;
  
  private DeleteQuery(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }
  
  static <T2> DeleteQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (DeleteQuery)new QueryData(paramAbstractDao, paramString, toStringArray(paramArrayOfObject), null).forCurrentThread();
  }
  
  public void executeDeleteWithoutDetachingEntities()
  {
    checkThread();
    SQLiteDatabase localSQLiteDatabase = this.dao.getDatabase();
    if (localSQLiteDatabase.isDbLockedByCurrentThread())
    {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
      return;
    }
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.dao.getDatabase().execSQL(this.sql, this.parameters);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public DeleteQuery<T> forCurrentThread()
  {
    return (DeleteQuery)this.queryData.forCurrentThread(this);
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, DeleteQuery<T2>>
  {
    private QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }
    
    protected DeleteQuery<T2> createQuery()
    {
      return new DeleteQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\DeleteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */