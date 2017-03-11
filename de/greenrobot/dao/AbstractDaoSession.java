package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.async.AsyncSession;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class AbstractDaoSession
{
  private final SQLiteDatabase db;
  private final Map<Class<?>, AbstractDao<?, ?>> entityToDao;
  
  public AbstractDaoSession(SQLiteDatabase paramSQLiteDatabase)
  {
    this.db = paramSQLiteDatabase;
    this.entityToDao = new HashMap();
  }
  
  public <V> V callInTx(Callable<V> paramCallable)
    throws Exception
  {
    this.db.beginTransaction();
    try
    {
      paramCallable = paramCallable.call();
      this.db.setTransactionSuccessful();
      return paramCallable;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public <V> V callInTxNoException(Callable<V> paramCallable)
  {
    this.db.beginTransaction();
    try
    {
      paramCallable = paramCallable.call();
      this.db.setTransactionSuccessful();
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      throw new DaoException("Callable failed", paramCallable);
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public <T> void delete(T paramT)
  {
    getDao(paramT.getClass()).delete(paramT);
  }
  
  public <T> void deleteAll(Class<T> paramClass)
  {
    getDao(paramClass).deleteAll();
  }
  
  public AbstractDao<?, ?> getDao(Class<? extends Object> paramClass)
  {
    AbstractDao localAbstractDao = (AbstractDao)this.entityToDao.get(paramClass);
    if (localAbstractDao == null) {
      throw new DaoException("No DAO registered for " + paramClass);
    }
    return localAbstractDao;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }
  
  public <T> long insert(T paramT)
  {
    return getDao(paramT.getClass()).insert(paramT);
  }
  
  public <T> long insertOrReplace(T paramT)
  {
    return getDao(paramT.getClass()).insertOrReplace(paramT);
  }
  
  public <T, K> T load(Class<T> paramClass, K paramK)
  {
    return (T)getDao(paramClass).load(paramK);
  }
  
  public <T, K> List<T> loadAll(Class<T> paramClass)
  {
    return getDao(paramClass).loadAll();
  }
  
  public <T> QueryBuilder<T> queryBuilder(Class<T> paramClass)
  {
    return getDao(paramClass).queryBuilder();
  }
  
  public <T, K> List<T> queryRaw(Class<T> paramClass, String paramString, String... paramVarArgs)
  {
    return getDao(paramClass).queryRaw(paramString, paramVarArgs);
  }
  
  public <T> void refresh(T paramT)
  {
    getDao(paramT.getClass()).refresh(paramT);
  }
  
  protected <T> void registerDao(Class<T> paramClass, AbstractDao<T, ?> paramAbstractDao)
  {
    this.entityToDao.put(paramClass, paramAbstractDao);
  }
  
  public void runInTx(Runnable paramRunnable)
  {
    this.db.beginTransaction();
    try
    {
      paramRunnable.run();
      this.db.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public AsyncSession startAsyncSession()
  {
    return new AsyncSession(this);
  }
  
  public <T> void update(T paramT)
  {
    getDao(paramT.getClass()).update(paramT);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\AbstractDaoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */