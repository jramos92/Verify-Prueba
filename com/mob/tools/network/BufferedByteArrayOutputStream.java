package com.mob.tools.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BufferedByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public BufferedByteArrayOutputStream() {}
  
  public BufferedByteArrayOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  public byte[] getBuffer()
  {
    return this.buf;
  }
  
  public int getBufferSize()
  {
    return this.buf.length;
  }
  
  public boolean switchBuffer(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != this.buf.length)) {
      return false;
    }
    byte[] arrayOfByte = this.buf;
    this.buf = paramArrayOfByte;
    paramArrayOfByte = (byte[])arrayOfByte;
    return true;
  }
  
  public void write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    write(paramByteBuffer, paramByteBuffer.limit());
  }
  
  public void write(ByteBuffer paramByteBuffer, int paramInt)
    throws IOException
  {
    if (this.buf.length - this.count >= paramInt)
    {
      paramByteBuffer.get(this.buf, this.count, paramInt);
      this.count += paramInt;
      return;
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    write(arrayOfByte);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\BufferedByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */