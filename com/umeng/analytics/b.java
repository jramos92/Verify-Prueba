package com.umeng.analytics;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import u.aly.br;

public class b
{
  private static final byte[] a = { 10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91 };
  
  public static int a(int paramInt, String paramString)
  {
    if (new Random().nextFloat() < 0.001D)
    {
      if (paramString == null) {
        br.b("--->", "null signature..");
      }
      paramInt = 0;
    }
    try
    {
      i = Integer.parseInt(paramString.substring(9, 11), 16);
      paramInt = i;
    }
    catch (Exception paramString)
    {
      int i;
      for (;;) {}
    }
    paramInt = (paramInt | 0x80) * 1000;
    do
    {
      do
      {
        return paramInt;
        i = new Random().nextInt(paramInt);
        paramInt = i;
      } while (i > 255000);
      paramInt = i;
    } while (i < 128000);
    return 127000;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(String.format("%02X", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    return localStringBuffer.toString().toLowerCase(Locale.US);
  }
  
  public static byte[] a(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {}
    int j;
    do
    {
      return (byte[])localObject;
      j = paramString.length();
    } while (j % 2 != 0);
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[(i / 2)] = ((byte)Integer.valueOf(paramString.substring(i, i + 2), 16).intValue());
      i += 2;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(1, new SecretKeySpec(paramArrayOfByte2, "AES"), new IvParameterSpec(a));
    return localCipher.doFinal(paramArrayOfByte1);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
    localCipher.init(2, new SecretKeySpec(paramArrayOfByte2, "AES"), new IvParameterSpec(a));
    return localCipher.doFinal(paramArrayOfByte1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\umeng\analytics\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */