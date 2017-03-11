package com.mob.tools.utils;

import com.mob.tools.gui.CachePool;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ReflectHelper
{
  private static CachePool<String, Constructor<?>> cachedConstr = new CachePool(5);
  private static CachePool<String, Method> cachedMethod;
  private static HashMap<String, Class<?>> classMap;
  private static HashSet<String> packageSet = new HashSet();
  
  static
  {
    packageSet.add("java.lang");
    packageSet.add("java.io");
    packageSet.add("java.net");
    packageSet.add("java.util");
    packageSet.add("com.mob.tools");
    packageSet.add("com.mob.tools.gui");
    packageSet.add("com.mob.tools.log");
    packageSet.add("com.mob.tools.network");
    packageSet.add("com.mob.tools.utils");
    classMap = new HashMap();
    cachedMethod = new CachePool(25);
  }
  
  /* Error */
  private static Class<?> getClass(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	com/mob/tools/utils/ReflectHelper:classMap	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 73	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 75	java/lang/Class
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: ifnonnull +76 -> 93
    //   20: getstatic 27	com/mob/tools/utils/ReflectHelper:packageSet	Ljava/util/HashSet;
    //   23: invokevirtual 79	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   26: astore_3
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 85 1 0
    //   35: ifeq +58 -> 93
    //   38: aload_3
    //   39: invokeinterface 89 1 0
    //   44: checkcast 91	java/lang/String
    //   47: astore_1
    //   48: new 93	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 100
    //   61: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 108	com/mob/tools/utils/ReflectHelper:importClass	(Ljava/lang/String;)V
    //   74: getstatic 54	com/mob/tools/utils/ReflectHelper:classMap	Ljava/util/HashMap;
    //   77: aload_0
    //   78: invokevirtual 73	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 75	java/lang/Class
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull -59 -> 29
    //   91: aload_2
    //   92: astore_1
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    //   104: astore_1
    //   105: goto -31 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   15	82	1	localObject	Object
    //   104	1	1	localThrowable	Throwable
    //   13	79	2	localClass	Class
    //   26	13	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   3	14	98	finally
    //   20	27	98	finally
    //   29	48	98	finally
    //   48	74	98	finally
    //   74	85	98	finally
    //   48	74	104	java/lang/Throwable
  }
  
  public static <T> T getInstanceField(Object paramObject, String paramString)
    throws Throwable
  {
    try
    {
      Object localObject = onGetInstanceField(paramObject, paramString);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", fieldName: " + paramString, localThrowable);
    }
  }
  
  public static <T> T getStaticField(String paramString1, String paramString2)
    throws Throwable
  {
    try
    {
      Object localObject = onGetStaticField(paramString1, paramString2);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2, localThrowable);
    }
  }
  
  private static Class<?>[] getTypes(Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null) {}
      for (Class localClass = null;; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  public static void importClass(String paramString)
    throws Throwable
  {
    importClass(null, paramString);
  }
  
  /* Error */
  public static void importClass(String paramString1, String paramString2)
    throws Throwable
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ldc -110
    //   6: invokevirtual 150	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   9: ifeq +25 -> 34
    //   12: getstatic 27	com/mob/tools/utils/ReflectHelper:packageSet	Ljava/util/HashSet;
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_1
    //   18: invokevirtual 154	java/lang/String:length	()I
    //   21: iconst_2
    //   22: isub
    //   23: invokevirtual 158	java/lang/String:substring	(II)Ljava/lang/String;
    //   26: invokevirtual 33	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   29: pop
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: aload_1
    //   35: invokestatic 161	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore_2
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: ifnonnull +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 164	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   49: astore_1
    //   50: getstatic 54	com/mob/tools/utils/ReflectHelper:classMap	Ljava/util/HashMap;
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 168	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -29 -> 30
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString1	String
    //   0	68	1	paramString2	String
    //   38	17	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   3	30	62	finally
    //   34	39	62	finally
    //   45	50	62	finally
    //   50	59	62	finally
  }
  
  public static <T> T invokeInstanceMethod(Object paramObject, String paramString, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = onInvokeInstanceMethod(paramObject, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", methodName: " + paramString, paramVarArgs);
    }
  }
  
  public static <T> T invokeStaticMethod(String paramString1, String paramString2, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = onInvokeStaticMethod(paramString1, paramString2, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramString1 + ", methodName: " + paramString2, paramVarArgs);
    }
  }
  
  private static boolean matchParams(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      boolean bool2 = true;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramArrayOfClass1.length)
        {
          if ((paramArrayOfClass2[i] != null) && (!primitiveEquals(paramArrayOfClass1[i], paramArrayOfClass2[i])) && (!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i]))) {
            bool1 = false;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static Object newInstance(String paramString, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      paramVarArgs = onNewInstance(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramString + ", methodName: <init>", paramVarArgs);
    }
  }
  
  public static <T> T onGetInstanceField(Object paramObject, String paramString)
    throws Throwable
  {
    Object localObject2 = new ArrayList();
    for (Object localObject1 = paramObject.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject2).add(localObject1);
    }
    Iterator localIterator = ((ArrayList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Class)localIterator.next();
      localObject1 = null;
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField(paramString);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
      {
        ((Field)localObject1).setAccessible(true);
        return (T)((Field)localObject1).get(paramObject);
      }
    }
    throw new NoSuchFieldException("className: " + paramObject.getClass() + ", fieldName: " + paramString);
  }
  
  private static <T> T onGetStaticField(String paramString1, String paramString2)
    throws Throwable
  {
    Object localObject2 = new ArrayList();
    for (Object localObject1 = getClass(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject2).add(localObject1);
    }
    Iterator localIterator = ((ArrayList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Class)localIterator.next();
      localObject1 = null;
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField(paramString2);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
      {
        ((Field)localObject1).setAccessible(true);
        return (T)((Field)localObject1).get(null);
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2);
  }
  
  private static <T> T onInvokeInstanceMethod(Object paramObject, String paramString, Object... paramVarArgs)
    throws Throwable
  {
    Object localObject1 = paramObject.getClass();
    String str = ((Class)localObject1).getName() + "#" + paramString + "#" + paramVarArgs.length;
    Object localObject2 = (Method)cachedMethod.get(str);
    Class[] arrayOfClass = getTypes(paramVarArgs);
    if ((localObject2 != null) && (!Modifier.isStatic(((Method)localObject2).getModifiers())) && (matchParams(((Method)localObject2).getParameterTypes(), arrayOfClass)))
    {
      ((Method)localObject2).setAccessible(true);
      if (((Method)localObject2).getReturnType() == Void.TYPE)
      {
        ((Method)localObject2).invoke(paramObject, paramVarArgs);
        return null;
      }
      return (T)((Method)localObject2).invoke(paramObject, paramVarArgs);
    }
    localObject2 = new ArrayList();
    while (localObject1 != null)
    {
      ((ArrayList)localObject2).add(localObject1);
      localObject1 = ((Class)localObject1).getSuperclass();
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Class)((Iterator)localObject1).next()).getDeclaredMethods();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((((Method)localObject3).getName().equals(paramString)) && (!Modifier.isStatic(((Method)localObject3).getModifiers())) && (matchParams(((Method)localObject3).getParameterTypes(), arrayOfClass)))
        {
          cachedMethod.put(str, localObject3);
          ((Method)localObject3).setAccessible(true);
          if (((Method)localObject3).getReturnType() == Void.TYPE)
          {
            ((Method)localObject3).invoke(paramObject, paramVarArgs);
            return null;
          }
          return (T)((Method)localObject3).invoke(paramObject, paramVarArgs);
        }
        i += 1;
      }
    }
    throw new NoSuchMethodException("className: " + paramObject.getClass() + ", methodName: " + paramString);
  }
  
  private static <T> T onInvokeStaticMethod(String paramString1, String paramString2, Object... paramVarArgs)
    throws Throwable
  {
    String str = paramString1 + "#" + paramString2 + "#" + paramVarArgs.length;
    Object localObject1 = (Method)cachedMethod.get(str);
    Class[] arrayOfClass = getTypes(paramVarArgs);
    if ((localObject1 != null) && (Modifier.isStatic(((Method)localObject1).getModifiers())) && (matchParams(((Method)localObject1).getParameterTypes(), arrayOfClass)))
    {
      ((Method)localObject1).setAccessible(true);
      if (((Method)localObject1).getReturnType() == Void.TYPE)
      {
        ((Method)localObject1).invoke(null, paramVarArgs);
        return null;
      }
      return (T)((Method)localObject1).invoke(null, paramVarArgs);
    }
    Object localObject2 = new ArrayList();
    for (localObject1 = getClass(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Class)((Iterator)localObject1).next()).getDeclaredMethods();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((((Method)localObject3).getName().equals(paramString2)) && (Modifier.isStatic(((Method)localObject3).getModifiers())) && (matchParams(((Method)localObject3).getParameterTypes(), arrayOfClass)))
        {
          cachedMethod.put(str, localObject3);
          ((Method)localObject3).setAccessible(true);
          if (((Method)localObject3).getReturnType() == Void.TYPE)
          {
            ((Method)localObject3).invoke(null, paramVarArgs);
            return null;
          }
          return (T)((Method)localObject3).invoke(null, paramVarArgs);
        }
        i += 1;
      }
    }
    throw new NoSuchMethodException("className: " + paramString1 + ", methodName: " + paramString2);
  }
  
  private static Object onNewInstance(String paramString, Object... paramVarArgs)
    throws Throwable
  {
    String str = paramString + "#" + paramVarArgs.length;
    Object localObject1 = (Constructor)cachedConstr.get(str);
    Class[] arrayOfClass = getTypes(paramVarArgs);
    if ((localObject1 != null) && (matchParams(((Constructor)localObject1).getParameterTypes(), arrayOfClass)))
    {
      ((Constructor)localObject1).setAccessible(true);
      return ((Constructor)localObject1).newInstance(paramVarArgs);
    }
    localObject1 = getClass(paramString).getDeclaredConstructors();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (matchParams(((Constructor)localObject2).getParameterTypes(), arrayOfClass))
      {
        cachedConstr.put(str, localObject2);
        ((Constructor)localObject2).setAccessible(true);
        return ((Constructor)localObject2).newInstance(paramVarArgs);
      }
      i += 1;
    }
    throw new NoSuchMethodException("className: " + paramString + ", methodName: <init>");
  }
  
  private static void onSetInstanceField(Object paramObject1, String paramString, Object paramObject2)
    throws Throwable
  {
    Object localObject2 = new ArrayList();
    for (Object localObject1 = paramObject1.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject2).add(localObject1);
    }
    Iterator localIterator = ((ArrayList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Class)localIterator.next();
      localObject1 = null;
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField(paramString);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
      {
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).set(paramObject1, paramObject2);
        return;
      }
    }
    throw new NoSuchFieldException("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2));
  }
  
  private static void onSetStaticField(String paramString1, String paramString2, Object paramObject)
    throws Throwable
  {
    Object localObject2 = new ArrayList();
    for (Object localObject1 = getClass(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject2).add(localObject1);
    }
    Iterator localIterator = ((ArrayList)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Class)localIterator.next();
      localObject1 = null;
      try
      {
        localObject2 = ((Class)localObject2).getDeclaredField(paramString2);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
      if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
      {
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).set(null, paramObject);
        return;
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject));
  }
  
  private static boolean primitiveEquals(Class<?> paramClass1, Class<?> paramClass2)
  {
    return ((paramClass1 == Byte.TYPE) && (paramClass2 == Byte.class)) || ((paramClass1 == Short.TYPE) && (paramClass2 == Short.class)) || ((paramClass1 == Character.TYPE) && (paramClass2 == Character.class)) || ((paramClass1 == Integer.TYPE) && (paramClass2 == Integer.class)) || ((paramClass1 == Long.TYPE) && (paramClass2 == Long.class)) || ((paramClass1 == Float.TYPE) && (paramClass2 == Float.class)) || ((paramClass1 == Double.TYPE) && (paramClass2 == Double.class)) || ((paramClass1 == Boolean.TYPE) && (paramClass2 == Boolean.class));
  }
  
  public static void setInstanceField(Object paramObject1, String paramString, Object paramObject2)
    throws Throwable
  {
    try
    {
      onSetInstanceField(paramObject1, paramString, paramObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2), localThrowable);
    }
  }
  
  public static void setStaticField(String paramString1, String paramString2, Object paramObject)
    throws Throwable
  {
    try
    {
      onSetStaticField(paramString1, paramString2, paramObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject), localThrowable);
    }
  }
  
  public static abstract interface ReflectRunnable
  {
    public abstract Object run(Object paramObject);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\ReflectHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */