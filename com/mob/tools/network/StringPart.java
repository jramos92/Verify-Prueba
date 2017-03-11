package com.mob.tools.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringPart
  extends HTTPPart
{
  private StringBuilder sb = new StringBuilder();
  
  public StringPart append(String paramString)
  {
    this.sb.append(paramString);
    return this;
  }
  
  protected InputStream getInputStream()
    throws Throwable
  {
    return new ByteArrayInputStream(this.sb.toString().getBytes("utf-8"));
  }
  
  protected long length()
    throws Throwable
  {
    return this.sb.toString().getBytes("utf-8").length;
  }
  
  public String toString()
  {
    return this.sb.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\StringPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */