package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoException;

public class SqlUtils
{
  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'').append(paramString).append('\'');
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1).append(".'").append(paramString2).append('\'');
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[i]);
      if (i < j - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append('\'').append(paramArrayOfString[i]).append('\'');
      if (i < j - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumnsEqValue(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      appendColumn(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
      i += 1;
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendPlaceholders(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    if (i < paramInt)
    {
      if (i < paramInt - 1) {
        paramStringBuilder.append("?,");
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append('?');
      }
    }
    return paramStringBuilder;
  }
  
  public static String createSqlDelete(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("DELETE FROM ");
    localStringBuilder.append(paramString);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      localStringBuilder.append(" WHERE ");
      appendColumnsEqValue(localStringBuilder, paramString, paramArrayOfString);
    }
    return localStringBuilder.toString();
  }
  
  public static String createSqlInsert(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    paramString1 = new StringBuilder(paramString1);
    paramString1.append(paramString2).append(" (");
    appendColumns(paramString1, paramArrayOfString);
    paramString1.append(") VALUES (");
    appendPlaceholders(paramString1, paramArrayOfString.length);
    paramString1.append(')');
    return paramString1.toString();
  }
  
  public static String createSqlSelect(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT ");
    if ((paramString2 == null) || (paramString2.length() < 0)) {
      throw new DaoException("Table alias required");
    }
    appendColumns(localStringBuilder, paramString2, paramArrayOfString).append(" FROM ");
    localStringBuilder.append(paramString1).append(' ').append(paramString2).append(' ');
    return localStringBuilder.toString();
  }
  
  public static String createSqlSelectCountStar(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    localStringBuilder.append(paramString1).append(' ');
    if (paramString2 != null) {
      localStringBuilder.append(paramString2).append(' ');
    }
    return localStringBuilder.toString();
  }
  
  public static String createSqlUpdate(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append(paramString).append(" SET ");
    appendColumnsEqualPlaceholders(localStringBuilder, paramArrayOfString1);
    localStringBuilder.append(" WHERE ");
    appendColumnsEqValue(localStringBuilder, paramString, paramArrayOfString2);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\internal\SqlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */