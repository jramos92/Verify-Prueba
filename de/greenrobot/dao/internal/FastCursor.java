package de.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor
  implements Cursor
{
  private final int count;
  private int position;
  private final CursorWindow window;
  
  public FastCursor(CursorWindow paramCursorWindow)
  {
    this.window = paramCursorWindow;
    this.count = paramCursorWindow.getNumRows();
  }
  
  public void close()
  {
    throw new UnsupportedOperationException();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.window.getBlob(this.position, paramInt);
  }
  
  public int getColumnCount()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnIndex(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnIndexOrThrow(String paramString)
    throws IllegalArgumentException
  {
    throw new UnsupportedOperationException();
  }
  
  public String getColumnName(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getCount()
  {
    return this.window.getNumRows();
  }
  
  public double getDouble(int paramInt)
  {
    return this.window.getDouble(this.position, paramInt);
  }
  
  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }
  
  public float getFloat(int paramInt)
  {
    return this.window.getFloat(this.position, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return this.window.getInt(this.position, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.window.getLong(this.position, paramInt);
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public short getShort(int paramInt)
  {
    return this.window.getShort(this.position, paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.window.getString(this.position, paramInt);
  }
  
  public int getType(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isClosed()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isFirst()
  {
    return this.position == 0;
  }
  
  public boolean isLast()
  {
    return this.position == this.count - 1;
  }
  
  public boolean isNull(int paramInt)
  {
    return this.window.isNull(this.position, paramInt);
  }
  
  public boolean move(int paramInt)
  {
    return moveToPosition(this.position + paramInt);
  }
  
  public boolean moveToFirst()
  {
    boolean bool = false;
    this.position = 0;
    if (this.count > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean moveToLast()
  {
    if (this.count > 0)
    {
      this.position = (this.count - 1);
      return true;
    }
    return false;
  }
  
  public boolean moveToNext()
  {
    if (this.position < this.count - 1)
    {
      this.position += 1;
      return true;
    }
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.count))
    {
      this.position = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    if (this.position > 0)
    {
      this.position -= 1;
      return true;
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean requery()
  {
    throw new UnsupportedOperationException();
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\de\greenrobot\dao\internal\FastCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */