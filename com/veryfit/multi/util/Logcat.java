package com.veryfit.multi.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logcat
{
  public static final String TAG = "Util/Logcat";
  
  public static String getLogcat()
    throws IOException
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(new String[] { "logcat", "-v", "time", "-d", "-t", "500" }).getInputStream());
    BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
      {
        localBufferedReader.close();
        localInputStreamReader.close();
        return localStringBuilder.toString();
      }
      localStringBuilder.append(str + "\n");
    }
  }
  
  public static void writeLogcat(String paramString)
    throws IOException
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(new String[] { "logcat", "-v", "time", "-d" }).getInputStream());
    paramString = new OutputStreamWriter(new FileOutputStream(paramString));
    BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
    BufferedWriter localBufferedWriter = new BufferedWriter(paramString);
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
      {
        localBufferedWriter.close();
        paramString.close();
        localBufferedReader.close();
        localInputStreamReader.close();
        return;
      }
      localBufferedWriter.write(str);
      localBufferedWriter.newLine();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\Logcat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */