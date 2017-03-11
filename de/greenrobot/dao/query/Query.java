package de.greenrobot.dao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;
import java.util.List;

public class Query<T>
  extends AbstractQuery<T>
{
  private final int limitPosition;
  private final int offsetPosition;
  private final QueryData<T> queryData;
  
  private Query(QueryData<T> paramQueryData, AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(paramAbstractDao, paramString, paramArrayOfString);
    this.queryData = paramQueryData;
    this.limitPosition = paramInt1;
    this.offsetPosition = paramInt2;
  }
  
  static <T2> Query<T2> create(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (Query)new QueryData(paramAbstractDao, paramString, toStringArray(paramArrayOfObject), paramInt1, paramInt2).forCurrentThread();
  }
  
  public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao, String paramString, Object[] paramArrayOfObject)
  {
    return create(paramAbstractDao, paramString, paramArrayOfObject, -1, -1);
  }
  
  public Query<T> forCurrentThread()
  {
    return (Query)this.queryData.forCurrentThread(this);
  }
  
  public List<T> list()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return this.daoAccess.loadAllAndCloseCursor(localCursor);
  }
  
  public CloseableListIterator<T> listIterator()
  {
    return listLazyUncached().listIteratorAutoClose();
  }
  
  public LazyList<T> listLazy()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return new LazyList(this.daoAccess, localCursor, true);
  }
  
  public LazyList<T> listLazyUncached()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return new LazyList(this.daoAccess, localCursor, false);
  }
  
  public void setLimit(int paramInt)
  {
    checkThread();
    if (this.limitPosition == -1) {
      throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }
    this.parameters[this.limitPosition] = Integer.toString(paramInt);
  }
  
  public void setOffset(int paramInt)
  {
    checkThread();
    if (this.offsetPosition == -1) {
      throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }
    this.parameters[this.offsetPosition] = Integer.toString(paramInt);
  }
  
  public void setParameter(int paramInt, Object paramObject)
  {
    if ((paramInt >= 0) && ((paramInt == this.limitPosition) || (paramInt == this.offsetPosition))) {
      throw new IllegalArgumentException("Illegal parameter index: " + paramInt);
    }
    super.setParameter(paramInt, paramObject);
  }
  
  public T unique()
  {
    checkThread();
    Cursor localCursor = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    return (T)this.daoAccess.loadUniqueAndCloseCursor(localCursor);
  }
  
  public T uniqueOrThrow()
  {
    Object localObject = unique();
    if (localObject == null) {
      throw new DaoException("No entity found for query");
    }
    return (T)localObject;
  }
  
  private static final class QueryData<T2>
    extends AbstractQueryData<T2, Query<T2>>
  {
    private final int limitPosition;
    private final int offsetPosition;
    
    QueryData(AbstractDao<T2, ?> paramAbstractDao, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
    {
      super(paramString, paramArrayOfString);
      this.limitPosition = paramInt1;
      this.offsetPosition = paramInt2;
    }
    
    protected Query<T2> createQuery()
    {
      return new Query(this, this.dao, this.sql, (String[])this.initialValues.clone(), this.limitPosition, this.offsetPosition, null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */