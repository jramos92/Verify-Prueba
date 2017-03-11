package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class LocalDB
{
  private File dbFile;
  private HashMap<String, Object> map;
  
  private void commit()
  {
    if (this.map == null) {}
    while (this.dbFile == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.dbFile.getParentFile().exists()) {
          this.dbFile.getParentFile().mkdirs();
        }
        synchronized (this.map)
        {
          Object localObject1 = new FileOutputStream(this.dbFile);
          if (((FileOutputStream)localObject1).getChannel().tryLock() != null)
          {
            localObject1 = new ObjectOutputStream((OutputStream)localObject1);
            ((ObjectOutputStream)localObject1).writeObject(this.map);
            ((ObjectOutputStream)localObject1).flush();
            ((ObjectOutputStream)localObject1).close();
            return;
          }
        }
        ((FileOutputStream)localObject2).close();
      }
      catch (Throwable localThrowable)
      {
        MobLog.getInstance().w(localThrowable);
        return;
      }
    }
  }
  
  private Object get(String paramString)
  {
    if (this.map == null) {
      return null;
    }
    return this.map.get(paramString);
  }
  
  private void put(String paramString, Object paramObject)
  {
    if (this.map == null) {
      this.map = new HashMap();
    }
    this.map.put(paramString, paramObject);
  }
  
  public boolean getBoolean(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    while (!(paramString instanceof Boolean)) {
      return false;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public float getFloat(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    while (!(paramString instanceof Integer)) {
      return 0.0F;
    }
    return ((Float)paramString).floatValue();
  }
  
  public int getInt(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    while (!(paramString instanceof Integer)) {
      return 0;
    }
    return ((Integer)paramString).intValue();
  }
  
  public long getLong(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    while (!(paramString instanceof Long)) {
      return 0L;
    }
    return ((Long)paramString).longValue();
  }
  
  public Object getObject(String paramString)
  {
    try
    {
      paramString = getString(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString, 2)));
      Object localObject = paramString.readObject();
      paramString.close();
      return localObject;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return null;
    }
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return String.valueOf(paramString);
  }
  
  public void open(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.dbFile = new File(paramString);
      if (this.dbFile.exists())
      {
        paramString = new ObjectInputStream(new FileInputStream(this.dbFile));
        this.map = ((HashMap)paramString.readObject());
        paramString.close();
        return;
      }
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
  }
  
  public void putBoolean(String paramString, Boolean paramBoolean)
  {
    put(paramString, paramBoolean);
    commit();
  }
  
  public void putFloat(String paramString, Float paramFloat)
  {
    put(paramString, paramFloat);
    commit();
  }
  
  public void putInt(String paramString, Integer paramInteger)
  {
    put(paramString, paramInteger);
    commit();
  }
  
  public void putLong(String paramString, Long paramLong)
  {
    put(paramString, paramLong);
    commit();
  }
  
  public void putObject(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      putString(paramString, Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
      return;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
  }
  
  public void putString(String paramString1, String paramString2)
  {
    put(paramString1, paramString2);
    commit();
  }
  
  public void remove(String paramString)
  {
    if (this.map == null) {
      this.map = new HashMap();
    }
    this.map.remove(paramString);
    commit();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\LocalDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */