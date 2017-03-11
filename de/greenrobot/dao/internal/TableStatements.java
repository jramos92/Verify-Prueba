package de.greenrobot.dao.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class TableStatements
{
  private final String[] allColumns;
  private final SQLiteDatabase db;
  private SQLiteStatement deleteStatement;
  private SQLiteStatement insertOrReplaceStatement;
  private SQLiteStatement insertStatement;
  private final String[] pkColumns;
  private volatile String selectAll;
  private volatile String selectByKey;
  private volatile String selectByRowId;
  private volatile String selectKeys;
  private final String tablename;
  private SQLiteStatement updateStatement;
  
  public TableStatements(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.db = paramSQLiteDatabase;
    this.tablename = paramString;
    this.allColumns = paramArrayOfString1;
    this.pkColumns = paramArrayOfString2;
  }
  
  public SQLiteStatement getDeleteStatement()
  {
    if (this.deleteStatement == null)
    {
      String str = SqlUtils.createSqlDelete(this.tablename, this.pkColumns);
      this.deleteStatement = this.db.compileStatement(str);
    }
    return this.deleteStatement;
  }
  
  public SQLiteStatement getInsertOrReplaceStatement()
  {
    if (this.insertOrReplaceStatement == null)
    {
      String str = SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", this.tablename, this.allColumns);
      this.insertOrReplaceStatement = this.db.compileStatement(str);
    }
    return this.insertOrReplaceStatement;
  }
  
  public SQLiteStatement getInsertStatement()
  {
    if (this.insertStatement == null)
    {
      String str = SqlUtils.createSqlInsert("INSERT INTO ", this.tablename, this.allColumns);
      this.insertStatement = this.db.compileStatement(str);
    }
    return this.insertStatement;
  }
  
  public String getSelectAll()
  {
    if (this.selectAll == null) {
      this.selectAll = SqlUtils.createSqlSelect(this.tablename, "T", this.allColumns);
    }
    return this.selectAll;
  }
  
  public String getSelectByKey()
  {
    if (this.selectByKey == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(getSelectAll());
      localStringBuilder.append("WHERE ");
      SqlUtils.appendColumnsEqValue(localStringBuilder, "T", this.pkColumns);
      this.selectByKey = localStringBuilder.toString();
    }
    return this.selectByKey;
  }
  
  public String getSelectByRowId()
  {
    if (this.selectByRowId == null) {
      this.selectByRowId = (getSelectAll() + "WHERE ROWID=?");
    }
    return this.selectByRowId;
  }
  
  public String getSelectKeys()
  {
    if (this.selectKeys == null) {
      this.selectKeys = SqlUtils.createSqlSelect(this.tablename, "T", this.pkColumns);
    }
    return this.selectKeys;
  }
  
  public SQLiteStatement getUpdateStatement()
  {
    if (this.updateStatement == null)
    {
      String str = SqlUtils.createSqlUpdate(this.tablename, this.allColumns, this.pkColumns);
      this.updateStatement = this.db.compileStatement(str);
    }
    return this.updateStatement;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\internal\TableStatements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */