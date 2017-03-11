package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.InternalQueryDaoAccess;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.TableStatements;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class QueryBuilder<T>
{
  public static boolean LOG_SQL;
  public static boolean LOG_VALUES;
  private final AbstractDao<T, ?> dao;
  private StringBuilder joinBuilder;
  private Integer limit;
  private Integer offset;
  private StringBuilder orderBuilder;
  private final String tablePrefix;
  private final List<Object> values;
  private final List<WhereCondition> whereConditions;
  
  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao)
  {
    this(paramAbstractDao, "T");
  }
  
  protected QueryBuilder(AbstractDao<T, ?> paramAbstractDao, String paramString)
  {
    this.dao = paramAbstractDao;
    this.tablePrefix = paramString;
    this.values = new ArrayList();
    this.whereConditions = new ArrayList();
  }
  
  private void appendWhereClause(StringBuilder paramStringBuilder, String paramString)
  {
    this.values.clear();
    if (!this.whereConditions.isEmpty())
    {
      paramStringBuilder.append(" WHERE ");
      ListIterator localListIterator = this.whereConditions.listIterator();
      while (localListIterator.hasNext())
      {
        if (localListIterator.hasPrevious()) {
          paramStringBuilder.append(" AND ");
        }
        WhereCondition localWhereCondition = (WhereCondition)localListIterator.next();
        localWhereCondition.appendTo(paramStringBuilder, paramString);
        localWhereCondition.appendValuesTo(this.values);
      }
    }
  }
  
  private void checkOrderBuilder()
  {
    if (this.orderBuilder == null) {
      this.orderBuilder = new StringBuilder();
    }
    while (this.orderBuilder.length() <= 0) {
      return;
    }
    this.orderBuilder.append(",");
  }
  
  public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> paramAbstractDao)
  {
    return new QueryBuilder(paramAbstractDao);
  }
  
  private void orderAscOrDesc(String paramString, Property... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Property localProperty = paramVarArgs[i];
      checkOrderBuilder();
      append(this.orderBuilder, localProperty);
      if (String.class.equals(localProperty.type)) {
        this.orderBuilder.append(" COLLATE LOCALIZED");
      }
      this.orderBuilder.append(paramString);
      i += 1;
    }
  }
  
  protected void addCondition(StringBuilder paramStringBuilder, List<Object> paramList, WhereCondition paramWhereCondition)
  {
    checkCondition(paramWhereCondition);
    paramWhereCondition.appendTo(paramStringBuilder, this.tablePrefix);
    paramWhereCondition.appendValuesTo(paramList);
  }
  
  public WhereCondition and(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    return combineWhereConditions(" AND ", paramWhereCondition1, paramWhereCondition2, paramVarArgs);
  }
  
  protected StringBuilder append(StringBuilder paramStringBuilder, Property paramProperty)
  {
    checkProperty(paramProperty);
    paramStringBuilder.append(this.tablePrefix).append('.').append('\'').append(paramProperty.columnName).append('\'');
    return paramStringBuilder;
  }
  
  public Query<T> build()
  {
    if ((this.joinBuilder == null) || (this.joinBuilder.length() == 0)) {}
    int i;
    for (Object localObject = InternalQueryDaoAccess.getStatements(this.dao).getSelectAll();; localObject = SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns()))
    {
      localObject = new StringBuilder((String)localObject);
      appendWhereClause((StringBuilder)localObject, this.tablePrefix);
      if ((this.orderBuilder != null) && (this.orderBuilder.length() > 0)) {
        ((StringBuilder)localObject).append(" ORDER BY ").append(this.orderBuilder);
      }
      i = -1;
      if (this.limit != null)
      {
        ((StringBuilder)localObject).append(" LIMIT ?");
        this.values.add(this.limit);
        i = this.values.size() - 1;
      }
      j = -1;
      if (this.offset == null) {
        break label203;
      }
      if (this.limit != null) {
        break;
      }
      throw new IllegalStateException("Offset cannot be set without limit");
    }
    ((StringBuilder)localObject).append(" OFFSET ?");
    this.values.add(this.offset);
    int j = this.values.size() - 1;
    label203:
    localObject = ((StringBuilder)localObject).toString();
    if (LOG_SQL) {
      DaoLog.d("Built SQL for query: " + (String)localObject);
    }
    if (LOG_VALUES) {
      DaoLog.d("Values for query: " + this.values);
    }
    return Query.create(this.dao, (String)localObject, this.values.toArray(), i, j);
  }
  
  public CountQuery<T> buildCount()
  {
    Object localObject = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.dao.getTablename(), this.tablePrefix));
    appendWhereClause((StringBuilder)localObject, this.tablePrefix);
    localObject = ((StringBuilder)localObject).toString();
    if (LOG_SQL) {
      DaoLog.d("Built SQL for count query: " + (String)localObject);
    }
    if (LOG_VALUES) {
      DaoLog.d("Values for count query: " + this.values);
    }
    return CountQuery.create(this.dao, (String)localObject, this.values.toArray());
  }
  
  public DeleteQuery<T> buildDelete()
  {
    String str = this.dao.getTablename();
    StringBuilder localStringBuilder = new StringBuilder(SqlUtils.createSqlDelete(str, null));
    appendWhereClause(localStringBuilder, this.tablePrefix);
    str = localStringBuilder.toString().replace(this.tablePrefix + ".'", str + ".'");
    if (LOG_SQL) {
      DaoLog.d("Built SQL for delete query: " + str);
    }
    if (LOG_VALUES) {
      DaoLog.d("Values for delete query: " + this.values);
    }
    return DeleteQuery.create(this.dao, str, this.values.toArray());
  }
  
  protected void checkCondition(WhereCondition paramWhereCondition)
  {
    if ((paramWhereCondition instanceof WhereCondition.PropertyCondition)) {
      checkProperty(((WhereCondition.PropertyCondition)paramWhereCondition).property);
    }
  }
  
  protected void checkProperty(Property paramProperty)
  {
    if (this.dao != null)
    {
      Property[] arrayOfProperty = this.dao.getProperties();
      int k = 0;
      int m = arrayOfProperty.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          if (paramProperty == arrayOfProperty[i]) {
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            break;
          }
          throw new DaoException("Property '" + paramProperty.name + "' is not part of " + this.dao);
        }
        i += 1;
      }
    }
  }
  
  protected WhereCondition combineWhereConditions(String paramString, WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    ArrayList localArrayList = new ArrayList();
    addCondition(localStringBuilder, localArrayList, paramWhereCondition1);
    localStringBuilder.append(paramString);
    addCondition(localStringBuilder, localArrayList, paramWhereCondition2);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramWhereCondition1 = paramVarArgs[i];
      localStringBuilder.append(paramString);
      addCondition(localStringBuilder, localArrayList, paramWhereCondition1);
      i += 1;
    }
    localStringBuilder.append(')');
    return new WhereCondition.StringCondition(localStringBuilder.toString(), localArrayList.toArray());
  }
  
  public long count()
  {
    return buildCount().count();
  }
  
  public <J> QueryBuilder<J> join(Class<J> paramClass, Property paramProperty)
  {
    throw new UnsupportedOperationException();
  }
  
  public <J> QueryBuilder<J> joinToMany(Class<J> paramClass, Property paramProperty)
  {
    throw new UnsupportedOperationException();
  }
  
  public QueryBuilder<T> limit(int paramInt)
  {
    this.limit = Integer.valueOf(paramInt);
    return this;
  }
  
  public List<T> list()
  {
    return build().list();
  }
  
  public CloseableListIterator<T> listIterator()
  {
    return build().listIterator();
  }
  
  public LazyList<T> listLazy()
  {
    return build().listLazy();
  }
  
  public LazyList<T> listLazyUncached()
  {
    return build().listLazyUncached();
  }
  
  public QueryBuilder<T> offset(int paramInt)
  {
    this.offset = Integer.valueOf(paramInt);
    return this;
  }
  
  public WhereCondition or(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    return combineWhereConditions(" OR ", paramWhereCondition1, paramWhereCondition2, paramVarArgs);
  }
  
  public QueryBuilder<T> orderAsc(Property... paramVarArgs)
  {
    orderAscOrDesc(" ASC", paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> orderCustom(Property paramProperty, String paramString)
  {
    checkOrderBuilder();
    append(this.orderBuilder, paramProperty).append(' ');
    this.orderBuilder.append(paramString);
    return this;
  }
  
  public QueryBuilder<T> orderDesc(Property... paramVarArgs)
  {
    orderAscOrDesc(" DESC", paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> orderRaw(String paramString)
  {
    checkOrderBuilder();
    this.orderBuilder.append(paramString);
    return this;
  }
  
  public T unique()
  {
    return (T)build().unique();
  }
  
  public T uniqueOrThrow()
  {
    return (T)build().uniqueOrThrow();
  }
  
  public QueryBuilder<T> where(WhereCondition paramWhereCondition, WhereCondition... paramVarArgs)
  {
    this.whereConditions.add(paramWhereCondition);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramWhereCondition = paramVarArgs[i];
      checkCondition(paramWhereCondition);
      this.whereConditions.add(paramWhereCondition);
      i += 1;
    }
    return this;
  }
  
  public QueryBuilder<T> whereOr(WhereCondition paramWhereCondition1, WhereCondition paramWhereCondition2, WhereCondition... paramVarArgs)
  {
    this.whereConditions.add(or(paramWhereCondition1, paramWhereCondition2, paramVarArgs));
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */