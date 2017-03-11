package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Data
{
  private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public static String AES128Decode(String paramString, byte[] paramArrayOfByte)
    throws Throwable
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    return new String(AES128Decode(paramString.getBytes("UTF-8"), paramArrayOfByte), "UTF-8");
  }
  
  public static byte[] AES128Decode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Throwable
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    Object localObject = new byte[16];
    System.arraycopy(paramArrayOfByte1, 0, localObject, 0, Math.min(paramArrayOfByte1.length, 16));
    localObject = new SecretKeySpec((byte[])localObject, "AES");
    paramArrayOfByte1 = Cipher.getInstance("AES/ECB/NoPadding", "BC");
    paramArrayOfByte1.init(2, (Key)localObject);
    localObject = new byte[paramArrayOfByte1.getOutputSize(paramArrayOfByte2.length)];
    int i = paramArrayOfByte1.update(paramArrayOfByte2, 0, paramArrayOfByte2.length, (byte[])localObject, 0);
    paramArrayOfByte1.doFinal((byte[])localObject, i);
    return (byte[])localObject;
  }
  
  public static byte[] AES128Encode(String paramString1, String paramString2)
    throws Throwable
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramString1 = paramString1.getBytes("UTF-8");
    Object localObject = new byte[16];
    System.arraycopy(paramString1, 0, localObject, 0, Math.min(paramString1.length, 16));
    paramString1 = paramString2.getBytes("UTF-8");
    localObject = new SecretKeySpec((byte[])localObject, "AES");
    paramString2 = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    paramString2.init(1, (Key)localObject);
    localObject = new byte[paramString2.getOutputSize(paramString1.length)];
    paramString2.doFinal((byte[])localObject, paramString2.update(paramString1, 0, paramString1.length, (byte[])localObject, 0));
    return (byte[])localObject;
  }
  
  public static byte[] AES128Encode(byte[] paramArrayOfByte, String paramString)
    throws Throwable
  {
    if ((paramArrayOfByte == null) || (paramString == null)) {
      return null;
    }
    paramString = paramString.getBytes("UTF-8");
    Object localObject = new SecretKeySpec(paramArrayOfByte, "AES");
    paramArrayOfByte = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
    paramArrayOfByte.init(1, (Key)localObject);
    localObject = new byte[paramArrayOfByte.getOutputSize(paramString.length)];
    paramArrayOfByte.doFinal((byte[])localObject, paramArrayOfByte.update(paramString, 0, paramString.length, (byte[])localObject, 0));
    return (byte[])localObject;
  }
  
  public static String Base64AES(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    String str;
    for (;;)
    {
      return paramString1;
      str = null;
      try
      {
        paramString2 = Base64.encodeToString(AES128Encode(paramString2, paramString1), 0);
        paramString1 = paramString2;
        str = paramString2;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString2;
          str = paramString2;
          if (paramString2.contains("\n"))
          {
            str = paramString2;
            paramString1 = paramString2.replace("\n", "");
            return paramString1;
          }
        }
      }
      catch (Throwable paramString1)
      {
        MobLog.getInstance().w(paramString1);
      }
    }
    return str;
  }
  
  public static String CRC32(byte[] paramArrayOfByte)
    throws Throwable
  {
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(paramArrayOfByte);
    long l = localCRC32.getValue();
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 56) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 48) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 40) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 32) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 24) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 16) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)(l >>> 8) & 0xFF) }));
    paramArrayOfByte.append(String.format("%02x", new Object[] { Integer.valueOf((byte)(int)l & 0xFF) }));
    while (paramArrayOfByte.charAt(0) == '0') {
      paramArrayOfByte = paramArrayOfByte.deleteCharAt(0);
    }
    return paramArrayOfByte.toString().toLowerCase();
  }
  
  public static String MD5(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return null;
      try
      {
        paramFile = new FileInputStream(paramFile);
        byte[] arrayOfByte = rawMD5(paramFile);
        paramFile.close();
        if (arrayOfByte != null) {
          return HEX.toHex(arrayOfByte);
        }
      }
      catch (Throwable paramFile)
      {
        MobLog.getInstance().w(paramFile);
      }
    }
    return null;
  }
  
  public static String MD5(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = rawMD5(paramString);
    } while (paramString == null);
    return HEX.toHex(paramString);
  }
  
  public static String MD5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfByte = rawMD5(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    return HEX.toHex(paramArrayOfByte);
  }
  
  public static byte[] SHA1(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      localObject1 = localObject2;
      paramFile = SHA1(localFileInputStream);
      localObject1 = paramFile;
      localFileInputStream.close();
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      MobLog.getInstance().w(paramFile);
    }
    return (byte[])localObject1;
  }
  
  public static byte[] SHA1(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      MobLog.getInstance().w(paramInputStream);
    }
    return null;
  }
  
  public static byte[] SHA1(String paramString)
    throws Throwable
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return SHA1(paramString.getBytes("utf-8"));
  }
  
  public static byte[] SHA1(byte[] paramArrayOfByte)
    throws Throwable
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static String base62(long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      str = "0";
    }
    while (paramLong > 0L)
    {
      int i = (int)(paramLong % 62L);
      paramLong /= 62L;
      str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i) + str;
      continue;
      str = "";
    }
    return str;
  }
  
  public static String byteToHex(byte[] paramArrayOfByte)
  {
    return byteToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String byteToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return localStringBuffer.toString();
    }
    while (paramInt1 < paramInt2)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[paramInt1]) }));
      paramInt1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static byte[] rawMD5(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      MobLog.getInstance().w(paramInputStream);
    }
    return null;
  }
  
  public static byte[] rawMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = rawMD5(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public static byte[] rawMD5(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      byte[] arrayOfByte = rawMD5(paramArrayOfByte);
      paramArrayOfByte.close();
      return arrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      MobLog.getInstance().w(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] rawRSADecode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    throws Throwable
  {
    KeyFactory.getInstance("RSA");
    paramArrayOfByte2 = new PKCS8EncodedKeySpec(paramArrayOfByte2);
    Object localObject = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte2);
    paramArrayOfByte2 = Cipher.getInstance("RSA/None/PKCS1Padding");
    paramArrayOfByte2.init(2, (Key)localObject);
    int i = 0;
    int j = paramInt / 8;
    localObject = new BufferedByteArrayOutputStream();
    paramInt = i;
    while (paramArrayOfByte1.length - paramInt > 0)
    {
      byte[] arrayOfByte = paramArrayOfByte2.doFinal(paramArrayOfByte1, paramInt, Math.min(paramArrayOfByte1.length - paramInt, j));
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      paramInt += j;
    }
    ((ByteArrayOutputStream)localObject).close();
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public static byte[] rawRSAEncode(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    throws Throwable
  {
    int i = paramInt / 8 - 11;
    paramArrayOfByte2 = new X509EncodedKeySpec(paramArrayOfByte2);
    Object localObject = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte2);
    paramArrayOfByte2 = Cipher.getInstance("RSA/None/PKCS1Padding");
    paramArrayOfByte2.init(1, (Key)localObject);
    localObject = new ByteArrayOutputStream();
    paramInt = 0;
    while (paramArrayOfByte1.length - paramInt > 0)
    {
      byte[] arrayOfByte = paramArrayOfByte2.doFinal(paramArrayOfByte1, paramInt, Math.min(paramArrayOfByte1.length - paramInt, i));
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, arrayOfByte.length);
      paramInt += i;
    }
    ((ByteArrayOutputStream)localObject).close();
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public static String urlEncode(String paramString)
  {
    try
    {
      paramString = urlEncode(paramString, "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return null;
  }
  
  public static String urlEncode(String paramString1, String paramString2)
    throws Throwable
  {
    paramString1 = URLEncoder.encode(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return paramString1.replace("+", "%20");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */