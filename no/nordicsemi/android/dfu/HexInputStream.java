package no.nordicsemi.android.dfu;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.exception.HexFileValidationException;

public class HexInputStream
  extends FilterInputStream
{
  private final int LINE_LENGTH = 128;
  private final int MBRSize;
  private int available;
  private int bytesRead;
  private int lastAddress = 0;
  private final byte[] localBuf = new byte[''];
  private int localPos = 128;
  private int pos;
  private int size = this.localBuf.length;
  
  protected HexInputStream(InputStream paramInputStream, int paramInt)
    throws HexFileValidationException, IOException
  {
    super(new BufferedInputStream(paramInputStream));
    this.MBRSize = paramInt;
    this.available = calculateBinSize(paramInt);
  }
  
  protected HexInputStream(byte[] paramArrayOfByte, int paramInt)
    throws HexFileValidationException, IOException
  {
    super(new ByteArrayInputStream(paramArrayOfByte));
    this.MBRSize = paramInt;
    this.available = calculateBinSize(paramInt);
  }
  
  private int asciiToInt(int paramInt)
  {
    if (paramInt >= 65) {
      return paramInt - 55;
    }
    if (paramInt >= 48) {
      return paramInt - 48;
    }
    return -1;
  }
  
  private int calculateBinSize(int paramInt)
    throws IOException
  {
    int i = 0;
    InputStream localInputStream = this.in;
    localInputStream.mark(localInputStream.available());
    int j = 0;
    for (;;)
    {
      int m;
      int n;
      try
      {
        k = localInputStream.read();
        checkComma(k);
        m = readByte(localInputStream);
        n = readAddress(localInputStream);
        k = i;
        switch (readByte(localInputStream))
        {
        case 3: 
          localInputStream.skip(m * 2 + 2);
          i = k;
          k = localInputStream.read();
          if ((k == 10) || (k == 13)) {
            continue;
          }
          break;
        case 1: 
          return i;
        }
      }
      finally
      {
        localInputStream.reset();
      }
      int k = readAddress(localInputStream);
      if ((i > 0) && (k != (j >> 16) + 1))
      {
        localInputStream.reset();
        return i;
      }
      j = k << 16;
      localInputStream.skip(2L);
      continue;
      k = readAddress(localInputStream);
      k <<= 4;
      if ((i > 0) && (k >> 16 != (j >> 16) + 1))
      {
        localInputStream.reset();
        return i;
      }
      j = k;
      localInputStream.skip(2L);
      continue;
      k = i;
      if (j + n >= paramInt)
      {
        k = i + m;
        continue;
        k = i;
      }
    }
  }
  
  private void checkComma(int paramInt)
    throws HexFileValidationException
  {
    if (paramInt != 58) {
      throw new HexFileValidationException("Not a HEX file");
    }
  }
  
  private int readAddress(InputStream paramInputStream)
    throws IOException
  {
    return readByte(paramInputStream) << 8 | readByte(paramInputStream);
  }
  
  private int readByte(InputStream paramInputStream)
    throws IOException
  {
    return asciiToInt(paramInputStream.read()) << 4 | asciiToInt(paramInputStream.read());
  }
  
  private int readLine()
    throws IOException
  {
    if (this.pos == -1) {
      return 0;
    }
    InputStream localInputStream = this.in;
    int j;
    int k;
    do
    {
      do
      {
        i = localInputStream.read();
        this.pos += 1;
      } while ((i == 10) || (i == 13));
      checkComma(i);
      j = readByte(localInputStream);
      this.pos += 2;
      k = readAddress(localInputStream);
      this.pos += 4;
      i = readByte(localInputStream);
      this.pos += 2;
      switch (i)
      {
      case 3: 
      default: 
        this.pos = ((int)(this.pos + localInputStream.skip(j * 2 + 2)));
      }
    } while (i != 0);
    int i = 0;
    for (;;)
    {
      if ((i >= this.localBuf.length) || (i >= j))
      {
        this.pos = ((int)(this.pos + localInputStream.skip(2L)));
        this.localPos = 0;
        return j;
        if (this.lastAddress + k >= this.MBRSize) {
          break;
        }
        i = -1;
        this.pos = ((int)(this.pos + localInputStream.skip(j * 2 + 2)));
        break;
        this.pos = -1;
        return 0;
        k = readAddress(localInputStream) << 4;
        this.pos += 4;
        if ((this.bytesRead > 0) && (k >> 16 != (this.lastAddress >> 16) + 1)) {
          return 0;
        }
        this.lastAddress = k;
        this.pos = ((int)(this.pos + localInputStream.skip(2L)));
        break;
        k = readAddress(localInputStream);
        this.pos += 4;
        if ((this.bytesRead > 0) && (k != (this.lastAddress >> 16) + 1)) {
          return 0;
        }
        this.lastAddress = (k << 16);
        this.pos = ((int)(this.pos + localInputStream.skip(2L)));
        break;
      }
      k = readByte(localInputStream);
      this.pos += 2;
      this.localBuf[i] = ((byte)k);
      i += 1;
    }
  }
  
  public int available()
  {
    return this.available - this.bytesRead;
  }
  
  public int read()
    throws IOException
  {
    throw new UnsupportedOperationException("Please, use readPacket() method instead");
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return readPacket(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new UnsupportedOperationException("Please, use readPacket() method instead");
  }
  
  public int readPacket(byte[] paramArrayOfByte)
    throws HexFileValidationException, IOException
  {
    int i = 0;
    do
    {
      for (;;)
      {
        if (i >= paramArrayOfByte.length) {
          return i;
        }
        if (this.localPos >= this.size) {
          break;
        }
        byte[] arrayOfByte = this.localBuf;
        j = this.localPos;
        this.localPos = (j + 1);
        paramArrayOfByte[i] = arrayOfByte[j];
        i += 1;
      }
      int j = this.bytesRead;
      int k = readLine();
      this.size = k;
      this.bytesRead = (j + k);
    } while (this.size != 0);
    return i;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      super.reset();
      this.pos = 0;
      this.bytesRead = 0;
      this.localPos = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int sizeInBytes()
  {
    return this.available;
  }
  
  public int sizeInPackets(int paramInt)
    throws IOException
  {
    int j = sizeInBytes();
    int i = j / paramInt;
    if (j % paramInt > 0) {}
    for (paramInt = 1;; paramInt = 0) {
      return paramInt + i;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\no\nordicsemi\android\dfu\HexInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */