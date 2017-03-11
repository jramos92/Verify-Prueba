package com.mob.tools.virtualdisk;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class VirtualDisk
{
  protected static final int BLOCK_SIZE = 1024;
  protected static final int NODE_SIZE = 8;
  
  protected abstract void addFileToDirectory(int paramInt1, String paramString, int paramInt2)
    throws Throwable;
  
  /* Error */
  public boolean exists(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 24	com/mob/tools/virtualdisk/VirtualDisk:fixSlashes	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokevirtual 28	com/mob/tools/virtualdisk/VirtualDisk:pathToId	(Ljava/lang/String;)I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpeq +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	VirtualDisk
    //   0	33	1	paramString	String
    //   11	4	2	i	int
    //   18	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  protected String fixSlashes(String paramString)
  {
    int k = 0;
    char[] arrayOfChar = paramString.toCharArray();
    int i1 = arrayOfChar.length;
    int m = 0;
    int j = 0;
    int i;
    int n;
    if (m < i1)
    {
      i = arrayOfChar[m];
      if (i == 47)
      {
        if (k != 0) {
          break label129;
        }
        k = j + 1;
        arrayOfChar[j] = '/';
        n = 1;
        j = k;
        k = n;
      }
    }
    label129:
    for (;;)
    {
      m += 1;
      break;
      n = j + 1;
      arrayOfChar[j] = i;
      k = 0;
      j = n;
      continue;
      if ((k != 0) && (j > 1)) {
        j -= 1;
      }
      for (;;)
      {
        if (j != i1) {
          paramString = new String(arrayOfChar, 0, j);
        }
        return paramString;
      }
    }
  }
  
  public abstract void format()
    throws Throwable;
  
  public abstract InputStream getInputStream(String paramString)
    throws Throwable;
  
  public abstract OutputStream getOutputStream(String paramString)
    throws Throwable;
  
  public abstract boolean isFile(String paramString)
    throws Throwable;
  
  public abstract int length(String paramString)
    throws Throwable;
  
  public abstract String[] list(String paramString)
    throws Throwable;
  
  public abstract boolean mkdir(String paramString)
    throws Throwable;
  
  public abstract boolean mv(String paramString1, String paramString2)
    throws Throwable;
  
  protected int nameToId(int paramInt, String paramString)
    throws Throwable
  {
    int i = -1;
    Object localObject = readDirectoryData(paramInt);
    paramInt = i;
    int k;
    int j;
    if (localObject != null)
    {
      localObject = new DataInputStream(new ByteArrayInputStream((byte[])localObject));
      k = ((DataInputStream)localObject).readInt();
      j = 0;
    }
    for (;;)
    {
      paramInt = i;
      if (j < k)
      {
        if (((DataInputStream)localObject).readUTF().equals(paramString)) {
          paramInt = ((DataInputStream)localObject).readInt();
        }
      }
      else
      {
        ((DataInputStream)localObject).close();
        return paramInt;
      }
      ((DataInputStream)localObject).readInt();
      j += 1;
    }
  }
  
  public abstract boolean newFile(String paramString)
    throws Throwable;
  
  protected abstract int nextFreeId()
    throws Throwable;
  
  protected int pathToId(String paramString)
    throws Throwable
  {
    paramString = splitPath(paramString);
    int i = -1;
    int k = i;
    int j;
    Object localObject;
    if (paramString != null)
    {
      int m = paramString.length;
      j = 0;
      k = i;
      if (j < m)
      {
        localObject = paramString[j];
        if (!"/".equals(localObject)) {
          break label68;
        }
        if (readDirectoryData(0) != null) {
          break label59;
        }
        k = i;
      }
    }
    return k;
    label59:
    i = 0;
    label68:
    do
    {
      j += 1;
      break;
      k = nameToId(i, (String)localObject);
      i = k;
    } while (k != -1);
    return k;
  }
  
  protected abstract byte[] readDirectoryData(int paramInt)
    throws Throwable;
  
  protected abstract void removeFileFromDirectory(int paramInt1, int paramInt2)
    throws Throwable;
  
  public abstract void rm(String paramString)
    throws Throwable;
  
  protected String[] splitPath(String paramString)
  {
    Object localObject2 = null;
    if (paramString.length() == 0) {
      paramString = (String)localObject2;
    }
    ArrayList localArrayList;
    do
    {
      return paramString;
      int j = 0;
      i = 0;
      localArrayList = new ArrayList();
      while (j < paramString.length())
      {
        int k = i;
        if (paramString.charAt(j) == '/')
        {
          String str = paramString.substring(i, j);
          localObject1 = str;
          if (str.length() == 0)
          {
            if (j == 0) {
              localObject1 = "/";
            }
          }
          else
          {
            localArrayList.add(localObject1);
            k = j + 1;
          }
        }
        else
        {
          j += 1;
          i = k;
          continue;
        }
        i = j + 1;
      }
      if (i < j)
      {
        paramString = paramString.substring(i, j);
        if (paramString.length() != 0) {
          localArrayList.add(paramString);
        }
      }
      paramString = (String)localObject2;
    } while (localArrayList.size() <= 0);
    Object localObject1 = new String[localArrayList.size()];
    int i = 0;
    for (;;)
    {
      paramString = (String)localObject1;
      if (i >= localObject1.length) {
        break;
      }
      localObject1[i] = ((String)localArrayList.get(i));
      i += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\virtualdisk\VirtualDisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */