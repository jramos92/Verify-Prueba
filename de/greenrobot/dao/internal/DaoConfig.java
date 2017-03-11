package de.greenrobot.dao.internal;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeLong;
import de.greenrobot.dao.identityscope.IdentityScopeObject;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class DaoConfig
  implements Cloneable
{
  public final String[] allColumns;
  public final SQLiteDatabase db;
  private IdentityScope<?, ?> identityScope;
  public final boolean keyIsNumeric;
  public final String[] nonPkColumns;
  public final String[] pkColumns;
  public final Property pkProperty;
  public final Property[] properties;
  public final TableStatements statements;
  public final String tablename;
  
  public DaoConfig(SQLiteDatabase paramSQLiteDatabase, Class<? extends AbstractDao<?, ?>> paramClass)
  {
    this.db = paramSQLiteDatabase;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    try
    {
      this.tablename = ((String)paramClass.getField("TABLENAME").get(null));
      Property[] arrayOfProperty = reflectProperties(paramClass);
      this.properties = arrayOfProperty;
      this.allColumns = new String[arrayOfProperty.length];
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramClass = null;
      i = 0;
      if (i < arrayOfProperty.length)
      {
        Property localProperty = arrayOfProperty[i];
        String str = localProperty.columnName;
        this.allColumns[i] = str;
        if (localProperty.primaryKey)
        {
          localArrayList1.add(str);
          paramClass = localProperty;
        }
        else
        {
          localArrayList2.add(str);
        }
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      throw new DaoException("Could not init DAOConfig", paramSQLiteDatabase);
    }
    this.nonPkColumns = ((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
    this.pkColumns = ((String[])localArrayList1.toArray(new String[localArrayList1.size()]));
    if (this.pkColumns.length == 1)
    {
      label204:
      this.pkProperty = paramClass;
      this.statements = new TableStatements(paramSQLiteDatabase, this.tablename, this.allColumns, this.pkColumns);
      if (this.pkProperty != null)
      {
        paramSQLiteDatabase = this.pkProperty.type;
        if ((paramSQLiteDatabase.equals(Long.TYPE)) || (paramSQLiteDatabase.equals(Long.class)) || (paramSQLiteDatabase.equals(Integer.TYPE)) || (paramSQLiteDatabase.equals(Integer.class)) || (paramSQLiteDatabase.equals(Short.TYPE)) || (paramSQLiteDatabase.equals(Short.class)) || (paramSQLiteDatabase.equals(Byte.TYPE))) {
          break label347;
        }
        if (!paramSQLiteDatabase.equals(Byte.class)) {
          break label358;
        }
      }
    }
    for (;;)
    {
      this.keyIsNumeric = bool;
      return;
      this.keyIsNumeric = false;
      return;
      i += 1;
      break;
      label347:
      boolean bool = true;
      continue;
      paramClass = null;
      break label204;
      label358:
      bool = false;
    }
  }
  
  public DaoConfig(DaoConfig paramDaoConfig)
  {
    this.db = paramDaoConfig.db;
    this.tablename = paramDaoConfig.tablename;
    this.properties = paramDaoConfig.properties;
    this.allColumns = paramDaoConfig.allColumns;
    this.pkColumns = paramDaoConfig.pkColumns;
    this.nonPkColumns = paramDaoConfig.nonPkColumns;
    this.pkProperty = paramDaoConfig.pkProperty;
    this.statements = paramDaoConfig.statements;
    this.keyIsNumeric = paramDaoConfig.keyIsNumeric;
  }
  
  private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> paramClass)
    throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException
  {
    Object localObject1 = Class.forName(paramClass.getName() + "$Properties").getDeclaredFields();
    paramClass = new ArrayList();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if ((((Field)localObject2).getModifiers() & 0x9) == 9)
      {
        localObject2 = ((Field)localObject2).get(null);
        if ((localObject2 instanceof Property)) {
          paramClass.add((Property)localObject2);
        }
      }
      i += 1;
    }
    localObject1 = new Property[paramClass.size()];
    paramClass = paramClass.iterator();
    while (paramClass.hasNext())
    {
      localObject2 = (Property)paramClass.next();
      if (localObject1[localObject2.ordinal] != null) {
        throw new DaoException("Duplicate property ordinals");
      }
      localObject1[localObject2.ordinal] = localObject2;
    }
    return (Property[])localObject1;
  }
  
  public DaoConfig clone()
  {
    return new DaoConfig(this);
  }
  
  public IdentityScope<?, ?> getIdentityScope()
  {
    return this.identityScope;
  }
  
  public void initIdentityScope(IdentityScopeType paramIdentityScopeType)
  {
    if (paramIdentityScopeType == IdentityScopeType.None)
    {
      this.identityScope = null;
      return;
    }
    if (paramIdentityScopeType == IdentityScopeType.Session)
    {
      if (this.keyIsNumeric)
      {
        this.identityScope = new IdentityScopeLong();
        return;
      }
      this.identityScope = new IdentityScopeObject();
      return;
    }
    throw new IllegalArgumentException("Unsupported type: " + paramIdentityScopeType);
  }
  
  public void setIdentityScope(IdentityScope<?, ?> paramIdentityScope)
  {
    this.identityScope = paramIdentityScope;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\internal\DaoConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */