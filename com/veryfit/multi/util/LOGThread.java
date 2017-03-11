package com.veryfit.multi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LOGThread
  extends Thread
{
  private String cmds = "";
  private String fileName = "/LogCat.txt";
  private FileWriter mFileWriter = null;
  private String mPid = "";
  
  public LOGThread(String paramString)
  {
    this.mPid = paramString;
    this.cmds = ("logcat -b main -v time | grep \"(" + this.mPid + ")\"");
    try
    {
      paramString = new File(Constant.LOG_PATH);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      paramString = new File(Constant.LOG_PATH + this.fileName);
      if (paramString.exists()) {
        paramString.deleteOnExit();
      }
      paramString.createNewFile();
      this.mFileWriter = new FileWriter(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void run()
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.cmds).getInputStream()));
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          return;
        }
        if ((str.length() != 0) && (str.contains(this.mPid)) && (this.mFileWriter != null))
        {
          this.mFileWriter.write(str + "\n");
          this.mFileWriter.flush();
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\LOGThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */