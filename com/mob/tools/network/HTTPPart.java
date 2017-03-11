package com.mob.tools.network;

import com.mob.tools.utils.ReflectHelper;
import java.io.InputStream;

public abstract class HTTPPart
{
  private OnReadListener listener;
  private long offset;
  
  protected abstract InputStream getInputStream()
    throws Throwable;
  
  public Object getInputStreamEntity()
    throws Throwable
  {
    InputStream localInputStream = toInputStream();
    long l1 = length();
    long l2 = this.offset;
    ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
    return ReflectHelper.newInstance("InputStreamEntity", new Object[] { localInputStream, Long.valueOf(l1 - l2) });
  }
  
  protected abstract long length()
    throws Throwable;
  
  public void setOffset(long paramLong)
  {
    this.offset = paramLong;
  }
  
  public void setOnReadListener(OnReadListener paramOnReadListener)
  {
    this.listener = paramOnReadListener;
  }
  
  public InputStream toInputStream()
    throws Throwable
  {
    ByteCounterInputStream localByteCounterInputStream = new ByteCounterInputStream(getInputStream());
    localByteCounterInputStream.setOnInputStreamReadListener(this.listener);
    if (this.offset > 0L) {
      localByteCounterInputStream.skip(this.offset);
    }
    return localByteCounterInputStream;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\HTTPPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */