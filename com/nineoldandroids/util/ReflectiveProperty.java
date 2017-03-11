package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V>
  extends Property<T, V>
{
  private static final String PREFIX_GET = "get";
  private static final String PREFIX_IS = "is";
  private static final String PREFIX_SET = "set";
  private Field mField;
  private Method mGetter;
  private Method mSetter;
  
  public ReflectiveProperty(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    super(paramClass1, paramString);
    char c = Character.toUpperCase(paramString.charAt(0));
    String str1 = paramString.substring(1);
    str1 = c + str1;
    String str2 = "get" + str1;
    try
    {
      this.mGetter = paramClass.getMethod(str2, (Class[])null);
      paramString = this.mGetter.getReturnType();
      if (!typesMatch(paramClass1, paramString)) {
        throw new NoSuchPropertyException("Underlying type (" + paramString + ") " + "does not match Property type (" + paramClass1 + ")");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      try
      {
        this.mGetter = paramClass.getDeclaredMethod(str2, (Class[])null);
        this.mGetter.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          String str3 = "is" + str1;
          try
          {
            this.mGetter = paramClass.getMethod(str3, (Class[])null);
          }
          catch (NoSuchMethodException localNoSuchMethodException4)
          {
            try
            {
              this.mGetter = paramClass.getDeclaredMethod(str3, (Class[])null);
              this.mGetter.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              try
              {
                this.mField = paramClass.getField(paramString);
                paramClass = this.mField.getType();
                if (typesMatch(paramClass1, paramClass)) {
                  break label387;
                }
                throw new NoSuchPropertyException("Underlying type (" + paramClass + ") " + "does not match Property type (" + paramClass1 + ")");
              }
              catch (NoSuchFieldException paramClass)
              {
                throw new NoSuchPropertyException("No accessor method or field found for property with name " + paramString);
              }
            }
          }
        }
      }
      paramClass1 = "set" + localNoSuchMethodException1;
      try
      {
        this.mSetter = paramClass.getDeclaredMethod(paramClass1, new Class[] { paramString });
        this.mSetter.setAccessible(true);
        label387:
        return;
      }
      catch (NoSuchMethodException paramClass) {}
    }
  }
  
  private boolean typesMatch(Class<V> paramClass, Class paramClass1)
  {
    boolean bool2 = false;
    if (paramClass1 != paramClass)
    {
      boolean bool1 = bool2;
      if (paramClass1.isPrimitive()) {
        if (((paramClass1 != Float.TYPE) || (paramClass != Float.class)) && ((paramClass1 != Integer.TYPE) || (paramClass != Integer.class)) && ((paramClass1 != Boolean.TYPE) || (paramClass != Boolean.class)) && ((paramClass1 != Long.TYPE) || (paramClass != Long.class)) && ((paramClass1 != Double.TYPE) || (paramClass != Double.class)) && ((paramClass1 != Short.TYPE) || (paramClass != Short.class)) && ((paramClass1 != Byte.TYPE) || (paramClass != Byte.class)))
        {
          bool1 = bool2;
          if (paramClass1 == Character.TYPE)
          {
            bool1 = bool2;
            if (paramClass != Character.class) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public V get(T paramT)
  {
    if (this.mGetter != null) {
      try
      {
        paramT = this.mGetter.invoke(paramT, (Object[])null);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.mField != null) {
      try
      {
        paramT = this.mField.get(paramT);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new AssertionError();
  }
  
  public boolean isReadOnly()
  {
    return (this.mSetter == null) && (this.mField == null);
  }
  
  public void set(T paramT, V paramV)
  {
    if (this.mSetter != null) {
      try
      {
        this.mSetter.invoke(paramT, new Object[] { paramV });
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
      catch (InvocationTargetException paramT)
      {
        throw new RuntimeException(paramT.getCause());
      }
    }
    if (this.mField != null) {
      try
      {
        this.mField.set(paramT, paramV);
        return;
      }
      catch (IllegalAccessException paramT)
      {
        throw new AssertionError();
      }
    }
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nineoldandroids\util\ReflectiveProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */