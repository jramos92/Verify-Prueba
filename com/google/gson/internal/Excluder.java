package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
  implements TypeAdapterFactory, Cloneable
{
  public static final Excluder DEFAULT = new Excluder();
  private static final double IGNORE_VERSIONS = -1.0D;
  private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
  private int modifiers = 136;
  private boolean requireExpose;
  private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
  private boolean serializeInnerClasses = true;
  private double version = -1.0D;
  
  private boolean isAnonymousOrLocal(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean isInnerClass(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!isStatic(paramClass));
  }
  
  private boolean isStatic(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  private boolean isValidSince(Since paramSince)
  {
    return (paramSince == null) || (paramSince.value() <= this.version);
  }
  
  private boolean isValidUntil(Until paramUntil)
  {
    return (paramUntil == null) || (paramUntil.value() > this.version);
  }
  
  private boolean isValidVersion(Since paramSince, Until paramUntil)
  {
    return (isValidSince(paramSince)) && (isValidUntil(paramUntil));
  }
  
  protected Excluder clone()
  {
    try
    {
      Excluder localExcluder = (Excluder)super.clone();
      return localExcluder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public <T> TypeAdapter<T> create(final Gson paramGson, final TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    final boolean bool1 = excludeClass(localClass, true);
    final boolean bool2 = excludeClass(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    new TypeAdapter()
    {
      private TypeAdapter<T> delegate;
      
      private TypeAdapter<T> delegate()
      {
        TypeAdapter localTypeAdapter = this.delegate;
        if (localTypeAdapter != null) {
          return localTypeAdapter;
        }
        localTypeAdapter = paramGson.getDelegateAdapter(Excluder.this, paramTypeToken);
        this.delegate = localTypeAdapter;
        return localTypeAdapter;
      }
      
      public T read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (bool2)
        {
          paramAnonymousJsonReader.skipValue();
          return null;
        }
        return (T)delegate().read(paramAnonymousJsonReader);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, T paramAnonymousT)
        throws IOException
      {
        if (bool1)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        delegate().write(paramAnonymousJsonWriter, paramAnonymousT);
      }
    };
  }
  
  public Excluder disableInnerClassSerialization()
  {
    Excluder localExcluder = clone();
    localExcluder.serializeInnerClasses = false;
    return localExcluder;
  }
  
  public boolean excludeClass(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.version != -1.0D) && (!isValidVersion((Since)paramClass.getAnnotation(Since.class), (Until)paramClass.getAnnotation(Until.class)))) {
      return true;
    }
    if ((!this.serializeInnerClasses) && (isInnerClass(paramClass))) {
      return true;
    }
    if (isAnonymousOrLocal(paramClass)) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.serializationStrategies;; localObject = this.deserializationStrategies)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ExclusionStrategy)((Iterator)localObject).next()).shouldSkipClass(paramClass));
      return true;
    }
    return false;
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    if ((this.modifiers & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.version != -1.0D) && (!isValidVersion((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    if (this.requireExpose)
    {
      localObject = (Expose)paramField.getAnnotation(Expose.class);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label97;
        }
        if (((Expose)localObject).serialize()) {
          break label106;
        }
      }
      label97:
      while (!((Expose)localObject).deserialize()) {
        return true;
      }
    }
    label106:
    if ((!this.serializeInnerClasses) && (isInnerClass(paramField.getType()))) {
      return true;
    }
    if (isAnonymousOrLocal(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = this.serializationStrategies; !((List)localObject).isEmpty(); localObject = this.deserializationStrategies)
    {
      paramField = new FieldAttributes(paramField);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ExclusionStrategy)((Iterator)localObject).next()).shouldSkipField(paramField));
      return true;
    }
    return false;
  }
  
  public Excluder excludeFieldsWithoutExposeAnnotation()
  {
    Excluder localExcluder = clone();
    localExcluder.requireExpose = true;
    return localExcluder;
  }
  
  public Excluder withExclusionStrategy(ExclusionStrategy paramExclusionStrategy, boolean paramBoolean1, boolean paramBoolean2)
  {
    Excluder localExcluder = clone();
    if (paramBoolean1)
    {
      localExcluder.serializationStrategies = new ArrayList(this.serializationStrategies);
      localExcluder.serializationStrategies.add(paramExclusionStrategy);
    }
    if (paramBoolean2)
    {
      localExcluder.deserializationStrategies = new ArrayList(this.deserializationStrategies);
      localExcluder.deserializationStrategies.add(paramExclusionStrategy);
    }
    return localExcluder;
  }
  
  public Excluder withModifiers(int... paramVarArgs)
  {
    Excluder localExcluder = clone();
    localExcluder.modifiers = 0;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      localExcluder.modifiers |= k;
      i += 1;
    }
    return localExcluder;
  }
  
  public Excluder withVersion(double paramDouble)
  {
    Excluder localExcluder = clone();
    localExcluder.version = paramDouble;
    return localExcluder;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\gson\internal\Excluder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */