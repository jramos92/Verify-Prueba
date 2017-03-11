package com.veryfit.multi.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class XZip
{
  private Zip zip;
  
  public static List<File> GetFileList(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws Exception
  {
    Log.v("XZip", "GetFileList(String)");
    ArrayList localArrayList = new ArrayList();
    paramString = new ZipInputStream(new FileInputStream(paramString));
    for (;;)
    {
      Object localObject = paramString.getNextEntry();
      if (localObject == null)
      {
        paramString.close();
        return localArrayList;
      }
      String str = ((ZipEntry)localObject).getName();
      if (((ZipEntry)localObject).isDirectory())
      {
        localObject = new File(str.substring(0, str.length() - 1));
        if (paramBoolean1) {
          localArrayList.add(localObject);
        }
      }
      else
      {
        localObject = new File(str);
        if (paramBoolean2) {
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  public static void UnZipFolder(String paramString1, String paramString2)
    throws Exception
  {
    Log.v("XZip", "UnZipFolder(String, String)");
    paramString1 = new ZipInputStream(new FileInputStream(paramString1));
    for (;;)
    {
      localObject1 = paramString1.getNextEntry();
      if (localObject1 == null)
      {
        paramString1.close();
        return;
      }
      localObject2 = ((ZipEntry)localObject1).getName();
      if (!((ZipEntry)localObject1).isDirectory()) {
        break;
      }
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      new File(paramString2 + File.separator + (String)localObject1).mkdirs();
    }
    Object localObject1 = new File(paramString2 + File.separator + (String)localObject2);
    ((File)localObject1).createNewFile();
    localObject1 = new FileOutputStream((File)localObject1);
    Object localObject2 = new byte['Ѐ'];
    for (;;)
    {
      int i = paramString1.read((byte[])localObject2);
      if (i == -1)
      {
        ((FileOutputStream)localObject1).close();
        break;
      }
      ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
      ((FileOutputStream)localObject1).flush();
    }
  }
  
  public static InputStream UpZip(String paramString1, String paramString2)
    throws Exception
  {
    Log.v("XZip", "UpZip(String, String)");
    paramString1 = new ZipFile(paramString1);
    return paramString1.getInputStream(paramString1.getEntry(paramString2));
  }
  
  private static void ZipFiles(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream)
    throws Exception
  {
    Log.v("XZip", "ZipFiles(String, String, ZipOutputStream)");
    if (paramZipOutputStream == null) {}
    for (;;)
    {
      return;
      Object localObject = new File(paramString1 + paramString2);
      if (((File)localObject).isFile())
      {
        paramString1 = new ZipEntry(paramString2);
        paramString2 = new FileInputStream((File)localObject);
        paramZipOutputStream.putNextEntry(paramString1);
        paramString1 = new byte['က'];
        for (;;)
        {
          i = paramString2.read(paramString1);
          if (i == -1)
          {
            paramZipOutputStream.closeEntry();
            return;
          }
          paramZipOutputStream.write(paramString1, 0, i);
        }
      }
      localObject = ((File)localObject).list();
      if (localObject.length <= 0)
      {
        paramZipOutputStream.putNextEntry(new ZipEntry(paramString2 + File.separator));
        paramZipOutputStream.closeEntry();
      }
      int i = 0;
      while (i < localObject.length)
      {
        ZipFiles(paramString1, paramString2 + File.separator + localObject[i], paramZipOutputStream);
        i += 1;
      }
    }
  }
  
  public void OnZip(Zip paramZip)
  {
    this.zip = paramZip;
  }
  
  public void ZipFolder(String paramString1, String paramString2)
    throws Exception
  {
    Log.v("XZip", "ZipFolder(String, String)");
    paramString2 = new ZipOutputStream(new FileOutputStream(paramString2));
    paramString1 = new File(paramString1);
    ZipFiles(paramString1.getParent() + File.separator, paramString1.getName(), paramString2);
    paramString2.finish();
    paramString2.close();
    this.zip.onFinish();
  }
  
  public void finalize()
    throws Throwable
  {}
  
  public static abstract interface Zip
  {
    public abstract void onFinish();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\XZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */