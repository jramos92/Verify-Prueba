package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPart
  extends HTTPPart
{
  private ArrayList<HTTPPart> parts = new ArrayList();
  
  public MultiPart append(HTTPPart paramHTTPPart)
    throws Throwable
  {
    this.parts.add(paramHTTPPart);
    return this;
  }
  
  protected InputStream getInputStream()
    throws Throwable
  {
    MultiPartInputStream localMultiPartInputStream = new MultiPartInputStream();
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext()) {
      localMultiPartInputStream.addInputStream(((HTTPPart)localIterator.next()).getInputStream());
    }
    return localMultiPartInputStream;
  }
  
  protected long length()
    throws Throwable
  {
    long l = 0L;
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext()) {
      l += ((HTTPPart)localIterator.next()).length();
    }
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((HTTPPart)localIterator.next()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\MultiPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */