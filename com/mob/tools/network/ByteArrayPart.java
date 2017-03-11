package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayPart
  extends HTTPPart
{
  private BufferedByteArrayOutputStream buffer;
  
  public ByteArrayPart append(byte[] paramArrayOfByte)
    throws Throwable
  {
    if (this.buffer == null) {
      this.buffer = new BufferedByteArrayOutputStream(paramArrayOfByte.length);
    }
    this.buffer.write(paramArrayOfByte);
    this.buffer.flush();
    return this;
  }
  
  protected InputStream getInputStream()
    throws Throwable
  {
    if (this.buffer == null) {
      return new ByteArrayInputStream(new byte[0]);
    }
    byte[] arrayOfByte = this.buffer.getBuffer();
    if ((arrayOfByte == null) || (this.buffer.size() <= 0)) {
      return new ByteArrayInputStream(new byte[0]);
    }
    return new ByteArrayInputStream(arrayOfByte, 0, this.buffer.size());
  }
  
  protected long length()
    throws Throwable
  {
    if (this.buffer == null) {
      return 0L;
    }
    return this.buffer.size();
  }
  
  public String toString()
  {
    if (this.buffer == null) {}
    byte[] arrayOfByte;
    do
    {
      return null;
      arrayOfByte = this.buffer.getBuffer();
    } while (arrayOfByte == null);
    return Data.byteToHex(arrayOfByte, 0, this.buffer.size());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\ByteArrayPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */