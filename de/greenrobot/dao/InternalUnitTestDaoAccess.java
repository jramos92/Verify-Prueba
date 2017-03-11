package de.greenrobot.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.internal.DaoConfig;
import java.lang.reflect.Constructor;

public class InternalUnitTestDaoAccess<T, K>
{
  private final AbstractDao<T, K> dao;
  
  public InternalUnitTestDaoAccess(SQLiteDatabase paramSQLiteDatabase, Class<AbstractDao<T, K>> paramClass, IdentityScope<?, ?> paramIdentityScope)
    throws Exception
  {
    paramSQLiteDatabase = new DaoConfig(paramSQLiteDatabase, paramClass);
    paramSQLiteDatabase.setIdentityScope(paramIdentityScope);
    this.dao = ((AbstractDao)paramClass.getConstructor(new Class[] { DaoConfig.class }).newInstance(new Object[] { paramSQLiteDatabase }));
  }
  
  public AbstractDao<T, K> getDao()
  {
    return this.dao;
  }
  
  public K getKey(T paramT)
  {
    return (K)this.dao.getKey(paramT);
  }
  
  public Property[] getProperties()
  {
    return this.dao.getProperties();
  }
  
  public boolean isEntityUpdateable()
  {
    return this.dao.isEntityUpdateable();
  }
  
  public T readEntity(Cursor paramCursor, int paramInt)
  {
    return (T)this.dao.readEntity(paramCursor, paramInt);
  }
  
  public K readKey(Cursor paramCursor, int paramInt)
  {
    return (K)this.dao.readKey(paramCursor, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\InternalUnitTestDaoAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */