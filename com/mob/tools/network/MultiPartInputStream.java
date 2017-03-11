package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPartInputStream
  extends InputStream
{
  private int curIs;
  private ArrayList<InputStream> isList = new ArrayList();
  
  private boolean isEmpty()
  {
    return (this.isList == null) || (this.isList.size() <= 0);
  }
  
  public void addInputStream(InputStream paramInputStream)
    throws Throwable
  {
    this.isList.add(paramInputStream);
  }
  
  public int available()
    throws IOException
  {
    if (isEmpty()) {
      return 0;
    }
    return ((InputStream)this.isList.get(this.curIs)).available();
  }
  
  public void close()
    throws IOException
  {
    Iterator localIterator = this.isList.iterator();
    while (localIterator.hasNext()) {
      ((InputStream)localIterator.next()).close();
    }
  }
  
  public int read()
    throws IOException
  {
    int j;
    if (isEmpty())
    {
      j = -1;
      return j;
    }
    for (int i = ((InputStream)this.isList.get(this.curIs)).read();; i = ((InputStream)this.isList.get(this.curIs)).read())
    {
      j = i;
      if (i >= 0) {
        break;
      }
      this.curIs += 1;
      j = i;
      if (this.curIs >= this.isList.size()) {
        break;
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j;
    if (isEmpty())
    {
      j = -1;
      return j;
    }
    for (int i = ((InputStream)this.isList.get(this.curIs)).read(paramArrayOfByte, paramInt1, paramInt2);; i = ((InputStream)this.isList.get(this.curIs)).read(paramArrayOfByte, paramInt1, paramInt2))
    {
      j = i;
      if (i >= 0) {
        break;
      }
      this.curIs += 1;
      j = i;
      if (this.curIs >= this.isList.size()) {
        break;
      }
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    throw new IOException();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\MultiPartInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */