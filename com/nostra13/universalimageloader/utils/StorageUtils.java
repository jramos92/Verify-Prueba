package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class StorageUtils
{
  private static final String INDIVIDUAL_DIR_NAME = "uil-images";
  
  public static File getCacheDirectory(Context paramContext)
  {
    File localFile1 = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile1 = getExternalCacheDir(paramContext);
    }
    File localFile2 = localFile1;
    if (localFile1 == null) {
      localFile2 = paramContext.getCacheDir();
    }
    return localFile2;
  }
  
  private static File getExternalCacheDir(Context paramContext)
  {
    File localFile = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), paramContext.getPackageName()), "cache");
    paramContext = localFile;
    if (!localFile.exists())
    {
      if (!localFile.mkdirs())
      {
        L.w("Unable to create external cache directory", new Object[0]);
        paramContext = null;
      }
    }
    else {
      return paramContext;
    }
    try
    {
      new File(localFile, ".nomedia").createNewFile();
      return localFile;
    }
    catch (IOException paramContext)
    {
      L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
    }
    return localFile;
  }
  
  public static File getIndividualCacheDirectory(Context paramContext)
  {
    File localFile1 = getCacheDirectory(paramContext);
    File localFile2 = new File(localFile1, "uil-images");
    paramContext = localFile2;
    if (!localFile2.exists())
    {
      paramContext = localFile2;
      if (!localFile2.mkdir()) {
        paramContext = localFile1;
      }
    }
    return paramContext;
  }
  
  public static File getOwnCacheDirectory(Context paramContext, String paramString)
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = new File(Environment.getExternalStorageDirectory(), paramString);
    }
    if (localFile != null)
    {
      paramString = localFile;
      if (!localFile.exists())
      {
        paramString = localFile;
        if (localFile.mkdirs()) {}
      }
    }
    else
    {
      paramString = paramContext.getCacheDir();
    }
    return paramString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\utils\StorageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */