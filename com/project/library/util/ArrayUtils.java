package com.project.library.util;

import java.util.concurrent.CopyOnWriteArrayList;

public final class ArrayUtils
{
  public static boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return false;
      }
      if (paramArrayOfByte[i] == paramByte) {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        return false;
      }
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean containsForNum(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramCopyOnWriteArrayList.size()) {
        return false;
      }
      if (((String)paramCopyOnWriteArrayList.get(i)).contains("Rego")) {
        return true;
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */