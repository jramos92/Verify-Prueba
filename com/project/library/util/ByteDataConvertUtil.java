package com.project.library.util;

import java.lang.reflect.Array;

public class ByteDataConvertUtil
{
  public static int BinToInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    paramInt2 -= 1;
    for (;;)
    {
      if (paramInt2 < 0) {
        return i;
      }
      i = i << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt2 -= 1;
      paramInt1 += 1;
    }
  }
  
  public static long BinToLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    paramInt2 -= 1;
    for (;;)
    {
      if (paramInt2 < 0) {
        return l;
      }
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt2 -= 1;
      paramInt1 += 1;
    }
  }
  
  public static void BinnCat(byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    paramByte = 0;
    for (;;)
    {
      if (i >= paramInt1 + paramInt2) {
        return;
      }
      int j = paramArrayOfByte[paramByte];
      i += 1;
      paramByte += 1;
    }
  }
  
  public static void BinnCat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramInt2) {
        return;
      }
      paramArrayOfByte2[i] = paramArrayOfByte1[paramInt1];
      i += 1;
      paramInt1 += 1;
    }
  }
  
  public static int Bit8Array2Int(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int j = 0;
    int i = k - 1;
    for (;;)
    {
      if (i < 0) {
        return j;
      }
      j += (paramArrayOfByte[i] << k - 1 - i);
      i -= 1;
    }
  }
  
  public static int Byte2Int(byte paramByte)
  {
    if (paramByte >= 0) {
      return paramByte;
    }
    return paramByte + 128 + 128;
  }
  
  public static byte[] Int2Bit8(int paramInt)
  {
    int i = (byte)paramInt;
    byte[] arrayOfByte = new byte[8];
    paramInt = 0;
    for (;;)
    {
      if (paramInt > 7) {
        return arrayOfByte;
      }
      arrayOfByte[paramInt] = ((byte)(i & 0x1));
      i = (byte)(i >> 1);
      paramInt += 1;
    }
  }
  
  public static byte Int2Byte(int paramInt)
  {
    return (byte)(paramInt & 0xFF);
  }
  
  public static byte[] IntToBin(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt2 - 1;
    paramInt2 = 0;
    for (;;)
    {
      if (i < 0) {
        return arrayOfByte;
      }
      arrayOfByte[paramInt2] = ((byte)(paramInt1 >> i * 8));
      i -= 1;
      paramInt2 += 1;
    }
  }
  
  public static byte[] IntToBin(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt3 -= 1;
    for (;;)
    {
      if (paramInt3 < 0) {
        return paramArrayOfByte;
      }
      paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> paramInt3 * 8));
      paramInt3 -= 1;
      paramInt2 += 1;
    }
  }
  
  public static void LongToBin(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      if (paramInt2 < 0) {
        return;
      }
      paramArrayOfByte[paramInt1] = ((byte)(int)(paramLong >> paramInt2 * 8));
      paramInt2 -= 1;
      paramInt1 += 1;
    }
  }
  
  public static byte[] LongToBin(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = paramInt - 1;
    paramInt = 0;
    for (;;)
    {
      if (i < 0) {
        return arrayOfByte;
      }
      arrayOfByte[paramInt] = ((byte)(int)(paramLong >> i * 8));
      i -= 1;
      paramInt += 1;
    }
  }
  
  public static byte[] byteMerger(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return localStringBuilder.toString();
      }
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      i += 1;
    }
  }
  
  public static String[] bytesToHexStrings(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      localObject = null;
      return (String[])localObject;
    }
    String[] arrayOfString = new String[paramArrayOfByte.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfString;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      localObject = str;
      if (str.length() == 1) {
        localObject = 0 + str;
      }
      arrayOfString[i] = localObject;
      i += 1;
    }
  }
  
  public static byte[] getMacBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[6];
    paramString = paramString.split(":");
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length) {
        return arrayOfByte;
      }
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString[i], 16));
      i += 1;
    }
  }
  
  public static String getStrBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramArrayOfByte.length < paramInt1 + paramInt2)
    {
      localObject = null;
      return (String)localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramInt2) {
        break;
      }
      str = str + String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[(paramInt1 + i)]) });
      i += 1;
    }
  }
  
  public static byte i2b(int paramInt)
  {
    return (byte)Integer.toHexString(paramInt).charAt(0);
  }
  
  public static <T> T invertArray(T paramT)
  {
    int j = Array.getLength(paramT);
    Object localObject = Array.newInstance(paramT.getClass().getComponentType(), j);
    System.arraycopy(paramT, 0, localObject, 0, j);
    int i = 0;
    for (;;)
    {
      if (i >= j / 2) {
        return (T)localObject;
      }
      paramT = Array.get(localObject, i);
      Array.set(localObject, i, Array.get(localObject, j - i - 1));
      Array.set(localObject, j - i - 1, paramT);
      i += 1;
    }
  }
  
  public static int toRevInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    paramInt1 = paramInt1 + paramInt2 - 1;
    for (;;)
    {
      if (i >= paramInt2) {
        return j;
      }
      j = j << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      i += 1;
      paramInt1 -= 1;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\project\library\util\ByteDataConvertUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */