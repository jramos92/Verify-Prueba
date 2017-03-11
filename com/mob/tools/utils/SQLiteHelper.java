package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class SQLiteHelper
{
  public static void close(SingleTableDB paramSingleTableDB)
  {
    paramSingleTableDB.close();
  }
  
  public static int delete(SingleTableDB paramSingleTableDB, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.getWritableDatabase().delete(paramSingleTableDB.getName(), paramString, paramArrayOfString);
  }
  
  public static void execSQL(SingleTableDB paramSingleTableDB, String paramString)
    throws Throwable
  {
    paramSingleTableDB.open();
    paramSingleTableDB = paramSingleTableDB.getWritableDatabase();
    paramSingleTableDB.beginTransaction();
    try
    {
      paramSingleTableDB.execSQL(paramString);
      paramSingleTableDB.setTransactionSuccessful();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
    finally
    {
      paramSingleTableDB.endTransaction();
    }
  }
  
  public static SingleTableDB getDatabase(Context paramContext, String paramString, int paramInt)
  {
    return new SingleTableDB(paramContext, paramString, paramInt, null);
  }
  
  public static int getSize(SingleTableDB paramSingleTableDB)
    throws Throwable
  {
    paramSingleTableDB.open();
    SQLiteDatabase localSQLiteDatabase = paramSingleTableDB.getReadableDatabase();
    int i = 0;
    Object localObject = null;
    SingleTableDB localSingleTableDB = null;
    try
    {
      paramSingleTableDB = localSQLiteDatabase.rawQuery("select count(*) from " + paramSingleTableDB.getName(), null);
      localSingleTableDB = paramSingleTableDB;
      localObject = paramSingleTableDB;
      if (paramSingleTableDB.moveToNext())
      {
        localSingleTableDB = paramSingleTableDB;
        localObject = paramSingleTableDB;
        i = paramSingleTableDB.getInt(0);
      }
      paramSingleTableDB.close();
      return i;
    }
    catch (Throwable paramSingleTableDB)
    {
      localObject = localSingleTableDB;
      throw paramSingleTableDB;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public static long insert(SingleTableDB paramSingleTableDB, ContentValues paramContentValues)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.getWritableDatabase().replace(paramSingleTableDB.getName(), null, paramContentValues);
  }
  
  public static Cursor query(SingleTableDB paramSingleTableDB, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.getReadableDatabase().query(paramSingleTableDB.getName(), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
  }
  
  public static Cursor rawQuery(SingleTableDB paramSingleTableDB, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.getWritableDatabase().rawQuery(paramString, paramArrayOfString);
  }
  
  public static int update(SingleTableDB paramSingleTableDB, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    throws Throwable
  {
    paramSingleTableDB.open();
    return paramSingleTableDB.getWritableDatabase().update(paramSingleTableDB.getName(), paramContentValues, paramString, paramArrayOfString);
  }
  
  public static class SingleTableDB
  {
    private Context context;
    private HashMap<String, Boolean> fieldLimits;
    private LinkedHashMap<String, String> fieldTypes;
    private String name;
    private String primary;
    private boolean primaryAutoincrement;
    private SQLiteOpenHelper sqlite;
    private int version;
    
    private SingleTableDB(Context paramContext, String paramString, int paramInt)
    {
      this.context = paramContext;
      this.name = paramString;
      this.version = paramInt;
      this.fieldTypes = new LinkedHashMap();
      this.fieldLimits = new HashMap();
    }
    
    private void close()
    {
      if (this.sqlite != null)
      {
        this.sqlite.close();
        this.sqlite = null;
      }
    }
    
    private String getName()
    {
      return this.name;
    }
    
    private SQLiteDatabase getReadableDatabase()
    {
      return this.sqlite.getReadableDatabase();
    }
    
    private SQLiteDatabase getWritableDatabase()
    {
      return this.sqlite.getWritableDatabase();
    }
    
    private void open()
    {
      if (this.sqlite == null) {
        this.sqlite = new SQLiteOpenHelper(this.context.getApplicationContext(), this.name, null, this.version)
        {
          public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("create table  ").append(SQLiteHelper.SingleTableDB.this.name).append("(");
            Iterator localIterator = SQLiteHelper.SingleTableDB.this.fieldTypes.entrySet().iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (Map.Entry)localIterator.next();
              String str = (String)((Map.Entry)localObject).getKey();
              localObject = (String)((Map.Entry)localObject).getValue();
              boolean bool2 = ((Boolean)SQLiteHelper.SingleTableDB.this.fieldLimits.get(str)).booleanValue();
              boolean bool3 = str.equals(SQLiteHelper.SingleTableDB.this.primary);
              boolean bool1;
              if (bool3)
              {
                bool1 = SQLiteHelper.SingleTableDB.this.primaryAutoincrement;
                label141:
                localStringBuilder.append(str).append(" ").append((String)localObject);
                if (!bool2) {
                  break label216;
                }
                str = " not null";
                label167:
                localStringBuilder.append(str);
                if (!bool3) {
                  break label223;
                }
                str = " primary key";
                label184:
                localStringBuilder.append(str);
                if (!bool1) {
                  break label230;
                }
              }
              label216:
              label223:
              label230:
              for (str = " autoincrement,";; str = ",")
              {
                localStringBuilder.append(str);
                break;
                bool1 = false;
                break label141;
                str = "";
                break label167;
                str = "";
                break label184;
              }
            }
            localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), ");");
            paramAnonymousSQLiteDatabase.execSQL(localStringBuilder.toString());
          }
          
          public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2) {}
        };
      }
    }
    
    public void addField(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (this.sqlite == null)
      {
        this.fieldTypes.put(paramString1, paramString2);
        this.fieldLimits.put(paramString1, Boolean.valueOf(paramBoolean));
      }
    }
    
    public void setPrimary(String paramString, boolean paramBoolean)
    {
      this.primary = paramString;
      this.primaryAutoincrement = paramBoolean;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\SQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */