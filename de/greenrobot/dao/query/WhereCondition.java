package de.greenrobot.dao.query;

import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.Property;
import java.util.Date;
import java.util.List;

public abstract interface WhereCondition
{
  public abstract void appendTo(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void appendValuesTo(List<Object> paramList);
  
  public static abstract class AbstractCondition
    implements WhereCondition
  {
    protected final boolean hasSingleValue;
    protected final Object value;
    protected final Object[] values;
    
    public AbstractCondition()
    {
      this.hasSingleValue = false;
      this.value = null;
      this.values = null;
    }
    
    public AbstractCondition(Object paramObject)
    {
      this.value = paramObject;
      this.hasSingleValue = true;
      this.values = null;
    }
    
    public AbstractCondition(Object[] paramArrayOfObject)
    {
      this.value = null;
      this.hasSingleValue = false;
      this.values = paramArrayOfObject;
    }
    
    public void appendValuesTo(List<Object> paramList)
    {
      if (this.hasSingleValue) {
        paramList.add(this.value);
      }
      if (this.values != null)
      {
        Object[] arrayOfObject = this.values;
        int j = arrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          paramList.add(arrayOfObject[i]);
          i += 1;
        }
      }
    }
  }
  
  public static class PropertyCondition
    extends WhereCondition.AbstractCondition
  {
    public final String op;
    public final Property property;
    
    public PropertyCondition(Property paramProperty, String paramString)
    {
      this.property = paramProperty;
      this.op = paramString;
    }
    
    public PropertyCondition(Property paramProperty, String paramString, Object paramObject)
    {
      super();
      this.property = paramProperty;
      this.op = paramString;
    }
    
    public PropertyCondition(Property paramProperty, String paramString, Object[] paramArrayOfObject)
    {
      super();
      this.property = paramProperty;
      this.op = paramString;
    }
    
    private static Object checkValueForType(Property paramProperty, Object paramObject)
    {
      int i = 0;
      if ((paramObject != null) && (paramObject.getClass().isArray())) {
        throw new DaoException("Illegal value: found array, but simple object required");
      }
      Object localObject;
      if (paramProperty.type == Date.class) {
        if ((paramObject instanceof Date)) {
          localObject = Long.valueOf(((Date)paramObject).getTime());
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject;
                localObject = paramObject;
              } while ((paramObject instanceof Long));
              throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + paramObject);
              if (paramProperty.type == Boolean.TYPE) {
                break;
              }
              localObject = paramObject;
            } while (paramProperty.type != Boolean.class);
            if ((paramObject instanceof Boolean))
            {
              if (((Boolean)paramObject).booleanValue()) {
                i = 1;
              }
              return Integer.valueOf(i);
            }
            if (!(paramObject instanceof Number)) {
              break;
            }
            i = ((Number)paramObject).intValue();
            localObject = paramObject;
          } while (i == 0);
          localObject = paramObject;
        } while (i == 1);
        throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + paramObject);
        localObject = paramObject;
      } while (!(paramObject instanceof String));
      paramProperty = (String)paramObject;
      if ("TRUE".equalsIgnoreCase(paramProperty)) {
        return Integer.valueOf(1);
      }
      if ("FALSE".equalsIgnoreCase(paramProperty)) {
        return Integer.valueOf(0);
      }
      throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was " + paramObject);
    }
    
    private static Object[] checkValuesForType(Property paramProperty, Object[] paramArrayOfObject)
    {
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        paramArrayOfObject[i] = checkValueForType(paramProperty, paramArrayOfObject[i]);
        i += 1;
      }
      return paramArrayOfObject;
    }
    
    public void appendTo(StringBuilder paramStringBuilder, String paramString)
    {
      if (paramString != null) {
        paramStringBuilder.append(paramString).append('.');
      }
      paramStringBuilder.append('\'').append(this.property.columnName).append('\'').append(this.op);
    }
  }
  
  public static class StringCondition
    extends WhereCondition.AbstractCondition
  {
    protected final String string;
    
    public StringCondition(String paramString)
    {
      this.string = paramString;
    }
    
    public StringCondition(String paramString, Object paramObject)
    {
      super();
      this.string = paramString;
    }
    
    public StringCondition(String paramString, Object... paramVarArgs)
    {
      super();
      this.string = paramString;
    }
    
    public void appendTo(StringBuilder paramStringBuilder, String paramString)
    {
      paramStringBuilder.append(this.string);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\query\WhereCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */