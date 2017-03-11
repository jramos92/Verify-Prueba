package de.greenrobot.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DbUtils
{
  public static int copyAllBytes(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        return i;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
  }
  
  public static int executeSqlScript(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString)
    throws IOException
  {
    return executeSqlScript(paramContext, paramSQLiteDatabase, paramString, true);
  }
  
  public static int executeSqlScript(Context paramContext, SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
    throws IOException
  {
    paramContext = new String(readAsset(paramContext, paramString), "UTF-8").split(";(\\s)*[\n\r]");
    if (paramBoolean) {}
    for (int i = executeSqlStatementsInTx(paramSQLiteDatabase, paramContext);; i = executeSqlStatements(paramSQLiteDatabase, paramContext))
    {
      DaoLog.i("Executed " + i + " statements from SQL script '" + paramString + "'");
      return i;
    }
  }
  
  public static int executeSqlStatements(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    int j = 0;
    int m = paramArrayOfString.length;
    int i = 0;
    while (i < m)
    {
      String str = paramArrayOfString[i].trim();
      int k = j;
      if (str.length() > 0)
      {
        paramSQLiteDatabase.execSQL(str);
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static int executeSqlStatementsInTx(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString)
  {
    paramSQLiteDatabase.beginTransaction();
    try
    {
      int i = executeSqlStatements(paramSQLiteDatabase, paramArrayOfString);
      paramSQLiteDatabase.setTransactionSuccessful();
      return i;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public static void logTableDump(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query(paramString, null, null, null, null, null, null);
    try
    {
      DaoLog.d(DatabaseUtils.dumpCursorToString(paramSQLiteDatabase));
      return;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static byte[] readAllBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyAllBytes(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] readAsset(Context paramContext, String paramString)
    throws IOException
  {
    paramContext = paramContext.getResources().getAssets().open(paramString);
    try
    {
      paramString = readAllBytes(paramContext);
      return paramString;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static void vacuum(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("VACUUM");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\DbUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */