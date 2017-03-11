package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class HEX
{
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static byte[] decodeHex(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    Object localObject;
    if ((k & 0x1) != 0)
    {
      MobLog.getInstance().w(new RuntimeException("Odd number of characters."));
      localObject = null;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[k >> 1];
    int i = 0;
    int j = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (j >= k) {
        break;
      }
      int m = toDigit(paramArrayOfChar[j], j);
      j += 1;
      int n = toDigit(paramArrayOfChar[j], j);
      j += 1;
      arrayOfByte[i] = ((byte)((m << 4 | n) & 0xFF));
      i += 1;
    }
  }
  
  public static byte[] decodeHexString(String paramString)
  {
    return decodeHex(paramString.toCharArray());
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = DIGITS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte));
  }
  
  public static byte[] toByte(String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return (byte[])localObject;
    }
    int i = paramString.length();
    if (i % 2 == 1) {
      return null;
    }
    int j = i / 2;
    byte[] arrayOfByte = new byte[j];
    i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      try
      {
        arrayOfByte[i] = ((byte)R.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
        i += 1;
      }
      catch (Throwable paramString)
      {
        MobLog.getInstance().w(paramString);
      }
    }
    return null;
  }
  
  protected static int toDigit(char paramChar, int paramInt)
  {
    int i = Character.digit(paramChar, 16);
    if (i == -1) {
      throw new RuntimeException("Illegal hexadecimal charcter " + paramChar + " at index " + paramInt);
    }
    return i;
  }
  
  public static String toHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public byte[] decode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 59
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 59	java/lang/String
    //   11: invokevirtual 63	java/lang/String:toCharArray	()[C
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 65	com/mob/tools/utils/HEX:decodeHex	([C)[B
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 142	[C
    //   24: checkcast 142	[C
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: new 40	java/lang/RuntimeException
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 145	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   40: invokespecial 45	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	HEX
    //   0	44	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/ClassCastException
    //   15	20	31	java/lang/ClassCastException
    //   20	28	31	java/lang/ClassCastException
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return decodeHex(new String(paramArrayOfByte).toCharArray());
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return new String(encodeHex(paramArrayOfByte)).getBytes();
  }
  
  /* Error */
  public char[] encode(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 59
    //   4: ifeq +16 -> 20
    //   7: aload_1
    //   8: checkcast 59	java/lang/String
    //   11: invokevirtual 154	java/lang/String:getBytes	()[B
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 71	com/mob/tools/utils/HEX:encodeHex	([B)[C
    //   19: areturn
    //   20: aload_1
    //   21: checkcast 157	[B
    //   24: checkcast 157	[B
    //   27: astore_1
    //   28: goto -13 -> 15
    //   31: astore_1
    //   32: new 40	java/lang/RuntimeException
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 145	java/lang/ClassCastException:getMessage	()Ljava/lang/String;
    //   40: invokespecial 45	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	HEX
    //   0	44	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	31	java/lang/ClassCastException
    //   15	20	31	java/lang/ClassCastException
    //   20	28	31	java/lang/ClassCastException
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\HEX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */