package de.greenrobot.dao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

public class CountQuery<T>
  extends AbstractQuery<T>
{
  private final QueryData<T> queryData;
  
  private CountQuery(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
  }
  
  static <T2> CountQuery<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return (CountQuery)new QueryData(paramAbstractDao, paramString, toStringArray(paramArrayOfObject), null).forCurrentThread();
  }
  
  public long count()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    try
    {
      if (!localCursor.moveToNext()) {
        throw new DaoException("No result for count");
      }
    }
    finally
    {
      localCursor.close();
    }
    if (!localCursor.isLast()) {
      throw new DaoException("Unexpected row count: " + localCursor.getCount());
    }
    if (localCursor.getColumnCount() != 1) {
      throw new DaoException("Unexpected column count: " + localCursor.getColumnCount());
    }
    long l = localCursor.getLong(0);
    localCursor.close();
    return l;
  }
  
  public CountQuery<T> forCurrentThread()
  {
    return (CountQuery)this.queryData.forCurrentThread(this);
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, CountQuery<T2>>
  {
    private QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }
    
    protected CountQuery<T2> createQuery()
    {
      return new CountQuery(this, this.dao, this.sql, (String[])this.initialValues.clone(), null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\CountQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */