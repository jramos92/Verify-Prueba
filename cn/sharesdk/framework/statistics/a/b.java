package cn.sharesdk.framework.statistics.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

public class b
{
  private static b c = null;
  private Context a;
  private a b;
  
  private b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new a(this.a);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    Object localObject = null;
    String str = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    try
    {
      paramString = localSQLiteDatabase.rawQuery("select count(*) from " + paramString, null);
      str = paramString;
      localObject = paramString;
      if (paramString.moveToNext())
      {
        str = paramString;
        localObject = paramString;
        i = paramString.getInt(0);
      }
      paramString.close();
      return i;
    }
    catch (Exception paramString)
    {
      localObject = str;
      d.a().w(paramString);
      str.close();
      return 0;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    try
    {
      i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
    }
    catch (Exception paramString2)
    {
      try
      {
        d.a().d("Deleted %d rows from table: %s", new Object[] { Integer.valueOf(i), paramString1 });
        return i;
      }
      catch (Exception paramString2)
      {
        int i;
        for (;;) {}
      }
      paramString2 = paramString2;
      i = 0;
    }
    tmp61_58[0] = paramString1;
    d.a().w(paramString2, "when delete database occur error table:%s,", tmp61_58);
    return i;
  }
  
  public long a(String paramString, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    try
    {
      long l = localSQLiteDatabase.replace(paramString, null, paramContentValues);
      return l;
    }
    catch (Exception paramContentValues)
    {
      d.a().w(paramContentValues, "when insert database occur error table:%s,", new Object[] { paramString });
    }
    return -1L;
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    d.a().d("Query table: %s", new Object[] { paramString1 });
    try
    {
      paramArrayOfString1 = localSQLiteDatabase.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3);
      return paramArrayOfString1;
    }
    catch (Exception paramArrayOfString1)
    {
      d.a().w(paramArrayOfString1, "when query database occur error table:%s,", new Object[] { paramString1 });
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */