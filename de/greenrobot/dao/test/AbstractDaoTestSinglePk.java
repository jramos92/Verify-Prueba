package de.greenrobot.dao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.InternalUnitTestDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K>
  extends AbstractDaoTest<D, T, K>
{
  private Property pkColumn;
  protected Set<K> usedPks = new HashSet();
  
  public AbstractDaoTestSinglePk(Class<D> paramClass)
  {
    super(paramClass);
  }
  
  protected abstract T createEntity(K paramK);
  
  protected T createEntityWithRandomPk()
  {
    return (T)createEntity(nextPk());
  }
  
  protected abstract K createRandomPk();
  
  protected K nextPk()
  {
    int i = 0;
    while (i < 100000)
    {
      Object localObject = createRandomPk();
      if (this.usedPks.add(localObject)) {
        return (K)localObject;
      }
      i += 1;
    }
    throw new IllegalStateException("Could not find a new PK");
  }
  
  protected Cursor queryWithDummyColumnsInFront(int paramInt, String paramString, K paramK)
  {
    localObject = new StringBuilder("SELECT ");
    int i = 0;
    while (i < paramInt)
    {
      ((StringBuilder)localObject).append(paramString).append(",");
      i += 1;
    }
    SqlUtils.appendColumns((StringBuilder)localObject, "T", this.dao.getAllColumns()).append(" FROM ");
    ((StringBuilder)localObject).append(this.dao.getTablename()).append(" T");
    if (paramK != null)
    {
      ((StringBuilder)localObject).append(" WHERE ");
      assertEquals(1, this.dao.getPkColumns().length);
      ((StringBuilder)localObject).append(this.dao.getPkColumns()[0]).append("=");
      DatabaseUtils.appendValueToSql((StringBuilder)localObject, paramK);
    }
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.db.rawQuery((String)localObject, null);
    assertTrue(((Cursor)localObject).moveToFirst());
    i = 0;
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        assertEquals(paramString, ((Cursor)localObject).getString(i));
        i += 1;
      }
      catch (RuntimeException paramString)
      {
        ((Cursor)localObject).close();
        throw paramString;
      }
    }
    if (paramK != null) {
      assertEquals(1, ((Cursor)localObject).getCount());
    }
    return (Cursor)localObject;
  }
  
  protected void runLoadPkTest(int paramInt)
  {
    Object localObject1 = nextPk();
    Object localObject3 = createEntity(localObject1);
    this.dao.insert(localObject3);
    localObject3 = queryWithDummyColumnsInFront(paramInt, "42", localObject1);
    try
    {
      assertEquals(localObject1, this.daoAccess.readKey((Cursor)localObject3, paramInt));
      return;
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
  }
  
  protected void setUp()
    throws Exception
  {
    super.setUp();
    Property[] arrayOfProperty = this.daoAccess.getProperties();
    int j = arrayOfProperty.length;
    int i = 0;
    while (i < j)
    {
      Property localProperty = arrayOfProperty[i];
      if (localProperty.primaryKey)
      {
        if (this.pkColumn != null) {
          throw new RuntimeException("Test does not work with multiple PK columns");
        }
        this.pkColumn = localProperty;
      }
      i += 1;
    }
    if (this.pkColumn == null) {
      throw new RuntimeException("Test does not work without a PK column");
    }
  }
  
  public void testCount()
  {
    this.dao.deleteAll();
    assertEquals(0L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    assertEquals(1L, this.dao.count());
    this.dao.insert(createEntityWithRandomPk());
    assertEquals(2L, this.dao.count());
  }
  
  public void testDelete()
  {
    Object localObject1 = nextPk();
    this.dao.deleteByKey(localObject1);
    Object localObject2 = createEntity(localObject1);
    this.dao.insert(localObject2);
    assertNotNull(this.dao.load(localObject1));
    this.dao.deleteByKey(localObject1);
    assertNull(this.dao.load(localObject1));
  }
  
  public void testDeleteAll()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      ((List)localObject1).add(createEntityWithRandomPk());
      i += 1;
    }
    this.dao.insertInTx((Iterable)localObject1);
    this.dao.deleteAll();
    assertEquals(0L, this.dao.count());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      localObject2 = this.daoAccess.getKey(localObject2);
      assertNotNull(localObject2);
      assertNull(this.dao.load(localObject2));
    }
  }
  
  public void testDeleteByKeyInTx()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      ((List)localObject1).add(createEntityWithRandomPk());
      i += 1;
    }
    this.dao.insertInTx((Iterable)localObject1);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(0)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(3)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(4)));
    ((List)localObject2).add(this.daoAccess.getKey(((List)localObject1).get(8)));
    this.dao.deleteByKeyInTx((Iterable)localObject2);
    assertEquals(((List)localObject1).size() - ((List)localObject2).size(), this.dao.count());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      assertNotNull(localObject2);
      assertNull(this.dao.load(localObject2));
    }
  }
  
  public void testDeleteInTx()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      ((List)localObject1).add(createEntityWithRandomPk());
      i += 1;
    }
    this.dao.insertInTx((Iterable)localObject1);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(((List)localObject1).get(0));
    ((List)localObject2).add(((List)localObject1).get(3));
    ((List)localObject2).add(((List)localObject1).get(4));
    ((List)localObject2).add(((List)localObject1).get(8));
    this.dao.deleteInTx((Iterable)localObject2);
    assertEquals(((List)localObject1).size() - ((List)localObject2).size(), this.dao.count());
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject2 = this.daoAccess.getKey(localObject2);
      assertNotNull(localObject2);
      assertNull(this.dao.load(localObject2));
    }
  }
  
  public void testInsertAndLoad()
  {
    Object localObject2 = nextPk();
    Object localObject1 = createEntity(localObject2);
    this.dao.insert(localObject1);
    assertEquals(localObject2, this.daoAccess.getKey(localObject1));
    localObject2 = this.dao.load(localObject2);
    assertNotNull(localObject2);
    assertEquals(this.daoAccess.getKey(localObject1), this.daoAccess.getKey(localObject2));
  }
  
  public void testInsertInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 20)
    {
      localArrayList.add(createEntityWithRandomPk());
      i += 1;
    }
    this.dao.insertInTx(localArrayList);
    assertEquals(localArrayList.size(), this.dao.count());
  }
  
  public void testInsertOrReplaceInTx()
  {
    this.dao.deleteAll();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < 20)
    {
      Object localObject = createEntityWithRandomPk();
      if (i % 2 == 0) {
        localArrayList1.add(localObject);
      }
      localArrayList2.add(localObject);
      i += 1;
    }
    this.dao.insertOrReplaceInTx(localArrayList1);
    this.dao.insertOrReplaceInTx(localArrayList2);
    assertEquals(localArrayList2.size(), this.dao.count());
  }
  
  public void testInsertOrReplaceTwice()
  {
    Object localObject = createEntityWithRandomPk();
    long l1 = this.dao.insert(localObject);
    long l2 = this.dao.insertOrReplace(localObject);
    if (this.dao.getPkProperty().type == Long.class) {
      assertEquals(l1, l2);
    }
  }
  
  public void testInsertTwice()
  {
    Object localObject = createEntity(nextPk());
    this.dao.insert(localObject);
    try
    {
      this.dao.insert(localObject);
      fail("Inserting twice should not work");
      return;
    }
    catch (SQLException localSQLException) {}
  }
  
  public void testLoadAll()
  {
    this.dao.deleteAll();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 15)
    {
      localArrayList.add(createEntity(nextPk()));
      i += 1;
    }
    this.dao.insertInTx(localArrayList);
    List localList = this.dao.loadAll();
    assertEquals(localArrayList.size(), localList.size());
  }
  
  public void testLoadPk()
  {
    runLoadPkTest(0);
  }
  
  public void testLoadPkWithOffset()
  {
    runLoadPkTest(10);
  }
  
  public void testQuery()
  {
    this.dao.insert(createEntityWithRandomPk());
    Object localObject1 = nextPk();
    this.dao.insert(createEntity(localObject1));
    this.dao.insert(createEntityWithRandomPk());
    Object localObject2 = "WHERE " + this.dao.getPkColumns()[0] + "=?";
    localObject2 = this.dao.queryRaw((String)localObject2, new String[] { localObject1.toString() });
    assertEquals(1, ((List)localObject2).size());
    assertEquals(localObject1, this.daoAccess.getKey(((List)localObject2).get(0)));
  }
  
  public void testReadWithOffset()
  {
    Object localObject1 = nextPk();
    Object localObject3 = createEntity(localObject1);
    this.dao.insert(localObject3);
    localObject3 = queryWithDummyColumnsInFront(5, "42", localObject1);
    try
    {
      Object localObject4 = this.daoAccess.readEntity((Cursor)localObject3, 5);
      assertEquals(localObject1, this.daoAccess.getKey(localObject4));
      return;
    }
    finally
    {
      ((Cursor)localObject3).close();
    }
  }
  
  public void testRowId()
  {
    Object localObject1 = createEntityWithRandomPk();
    Object localObject2 = createEntityWithRandomPk();
    if (this.dao.insert(localObject1) != this.dao.insert(localObject2)) {}
    for (boolean bool = true;; bool = false)
    {
      assertTrue(bool);
      return;
    }
  }
  
  public void testUpdate()
  {
    this.dao.deleteAll();
    Object localObject = createEntityWithRandomPk();
    this.dao.insert(localObject);
    this.dao.update(localObject);
    assertEquals(1L, this.dao.count());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\test\AbstractDaoTestSinglePk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */