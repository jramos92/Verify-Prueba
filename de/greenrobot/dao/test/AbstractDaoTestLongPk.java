package de.greenrobot.dao.test;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import java.util.Random;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T>
  extends AbstractDaoTestSinglePk<D, T, Long>
{
  public AbstractDaoTestLongPk(Class<D> paramClass)
  {
    super(paramClass);
  }
  
  protected Long createRandomPk()
  {
    return Long.valueOf(this.random.nextLong());
  }
  
  public void testAssignPk()
  {
    if (this.daoAccess.isEntityUpdateable())
    {
      Object localObject2 = createEntity(null);
      if (localObject2 != null)
      {
        Object localObject1 = createEntity(null);
        this.dao.insert(localObject2);
        this.dao.insert(localObject1);
        localObject2 = (Long)this.daoAccess.getKey(localObject2);
        assertNotNull(localObject2);
        localObject1 = (Long)this.daoAccess.getKey(localObject1);
        assertNotNull(localObject1);
        assertFalse(((Long)localObject2).equals(localObject1));
        assertNotNull(this.dao.load(localObject2));
        assertNotNull(this.dao.load(localObject1));
        return;
      }
      DaoLog.d("Skipping testAssignPk for " + this.daoClass + " (createEntity returned null for null key)");
      return;
    }
    DaoLog.d("Skipping testAssignPk for not updateable " + this.daoClass);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\test\AbstractDaoTestLongPk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */