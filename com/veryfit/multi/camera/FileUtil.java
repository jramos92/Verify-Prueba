package com.veryfit.multi.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.veryfit.multi.util.Constant;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil
{
  public static String getLatestImagePath(Context paramContext, Uri paramUri)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    int i = paramContext.getColumnIndexOrThrow("_data");
    paramContext.moveToFirst();
    paramUri = paramContext.getString(i);
    if ((paramContext != null) && (!paramContext.isClosed())) {
      paramContext.close();
    }
    return paramUri;
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = new File(Constant.imageDir);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date(System.currentTimeMillis()));
    localObject = Constant.imageDir + File.separator + (String)localObject + ".jpg";
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((String)localObject));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + (String)localObject)));
      return (String)localObject;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String saveBitmap2Gallery(Context paramContext, Bitmap paramBitmap)
  {
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      localObject = new File(Constant.imageDir);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    String str2 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date(System.currentTimeMillis()));
    String str1 = Constant.imageDir + File.separator + str2 + ".jpg";
    for (;;)
    {
      try
      {
        localObject = new BufferedOutputStream(new FileOutputStream(str1));
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
        ((BufferedOutputStream)localObject).flush();
        ((BufferedOutputStream)localObject).close();
        localObject = null;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      try
      {
        str2 = MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), str1, str2 + ".jpg", null);
        paramBitmap = (Bitmap)localObject;
        if (str2 != null) {
          paramBitmap = getLatestImagePath(paramContext, Uri.parse(str2));
        }
      }
      catch (FileNotFoundException paramBitmap)
      {
        paramBitmap.printStackTrace();
        paramBitmap = (Bitmap)localObject;
      }
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str1)));
    paramContext = new File(str1);
    if ((paramContext != null) && (paramContext.exists()) && (paramContext.length() > 0L)) {
      paramContext.delete();
    }
    return paramBitmap;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */