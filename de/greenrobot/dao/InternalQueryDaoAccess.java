package de.greenrobot.dao;

import android.database.Cursor;
import de.greenrobot.dao.internal.TableStatements;
import java.util.List;

public final class InternalQueryDaoAccess<T>
{
  private final AbstractDao<T, ?> dao;
  
  public InternalQueryDaoAccess(AbstractDao<T, ?> paramAbstractDao)
  {
    this.dao = paramAbstractDao;
  }
  
  public static <T2> TableStatements getStatements(AbstractDao<T2, ?> paramAbstractDao)
  {
    return paramAbstractDao.getStatements();
  }
  
  public TableStatements getStatements()
  {
    return this.dao.getStatements();
  }
  
  public List<T> loadAllAndCloseCursor(Cursor paramCursor)
  {
    return this.dao.loadAllAndCloseCursor(paramCursor);
  }
  
  public T loadCurrent(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    return (T)this.dao.loadCurrent(paramCursor, paramInt, paramBoolean);
  }
  
  public T loadUniqueAndCloseCursor(Cursor paramCursor)
  {
    return (T)this.dao.loadUniqueAndCloseCursor(paramCursor);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\InternalQueryDaoAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */