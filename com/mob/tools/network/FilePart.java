package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FilePart
  extends HTTPPart
{
  private File file;
  
  protected InputStream getInputStream()
    throws Throwable
  {
    return new FileInputStream(this.file);
  }
  
  protected long length()
    throws Throwable
  {
    return this.file.length();
  }
  
  public void setFile(File paramFile)
  {
    this.file = paramFile;
  }
  
  public void setFile(String paramString)
  {
    this.file = new File(paramString);
  }
  
  public String toString()
  {
    return this.file.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\network\FilePart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */