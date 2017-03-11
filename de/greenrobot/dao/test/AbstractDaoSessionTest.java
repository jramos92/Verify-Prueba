package de.greenrobot.dao.test;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession>
  extends DbTest
{
  protected T daoMaster;
  private final Class<T> daoMasterClass;
  protected S daoSession;
  
  public AbstractDaoSessionTest(Class<T> paramClass)
  {
    this(paramClass, true);
  }
  
  public AbstractDaoSessionTest(Class<T> paramClass, boolean paramBoolean)
  {
    super(paramBoolean);
    this.daoMasterClass = paramClass;
  }
  
  protected void setUp()
    throws Exception
  {
    super.setUp();
    try
    {
      this.daoMaster = ((AbstractDaoMaster)this.daoMasterClass.getConstructor(new Class[] { SQLiteDatabase.class }).newInstance(new Object[] { this.db }));
      this.daoMasterClass.getMethod("createAllTables", new Class[] { SQLiteDatabase.class, Boolean.TYPE }).invoke(null, new Object[] { this.db, Boolean.valueOf(false) });
      this.daoSession = this.daoMaster.newSession();
      return;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Could not prepare DAO session test", localException);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\test\AbstractDaoSessionTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */