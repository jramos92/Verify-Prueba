package u.aly;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class cc
{
  public static int a;
  
  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException, DataFormatException
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return new String(paramArrayOfByte, paramString);
    }
    return null;
  }
  
  public static byte[] a(String paramString1, String paramString2)
    throws IOException
  {
    if (cd.d(paramString1)) {
      return null;
    }
    return a(paramString1.getBytes(paramString2));
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    paramArrayOfByte = new byte[' '];
    a = 0;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        for (;;)
        {
          if (localDeflater.finished())
          {
            localDeflater.end();
            if (localByteArrayOutputStream != null) {
              localByteArrayOutputStream.close();
            }
            return localByteArrayOutputStream.toByteArray();
          }
          int i = localDeflater.deflate(paramArrayOfByte);
          a += i;
          localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
        }
        if (localByteArrayOutputStream == null) {
          break label103;
        }
      }
      finally {}
    }
    finally
    {
      label103:
      ByteArrayOutputStream localByteArrayOutputStream = null;
    }
    localByteArrayOutputStream.close();
    throw paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException, DataFormatException
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Inflater localInflater = new Inflater();
    localInflater.setInput(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      if (localInflater.needsInput())
      {
        localInflater.end();
        return paramArrayOfByte.toByteArray();
      }
      int j = localInflater.inflate(arrayOfByte);
      paramArrayOfByte.write(arrayOfByte, i, j);
      i += j;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */