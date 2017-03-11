package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;

abstract class AbstractQuery<T>
{
  protected final AbstractDao<T, ?> dao;
  protected final InternalQueryDaoAccess<T> daoAccess;
  protected final Thread ownerThread;
  protected final String[] parameters;
  protected final String sql;
  
  protected AbstractQuery(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.daoAccess = new InternalQueryDaoAccess(paramAbstractDao);
    this.sql = paramString;
    this.parameters = paramArrayOfString;
    this.ownerThread = Thread.currentThread();
  }
  
  protected static String[] toStringArray(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject != null) {
        arrayOfString[i] = localObject.toString();
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = null;
      }
    }
    return arrayOfString;
  }
  
  protected void checkThread()
  {
    if (Thread.currentThread() != this.ownerThread) {
      throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
    }
  }
  
  public void setParameter(int paramInt, Object paramObject)
  {
    checkThread();
    if (paramObject != null)
    {
      this.parameters[paramInt] = paramObject.toString();
      return;
    }
    this.parameters[paramInt] = null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\AbstractQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */