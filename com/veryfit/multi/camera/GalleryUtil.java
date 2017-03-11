package com.veryfit.multi.camera;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GalleryUtil
{
  public static boolean deleteImage(Context paramContext, String paramString)
  {
    Cursor localCursor = MediaStore.Images.Media.query(paramContext.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { paramString }, null);
    if (localCursor.moveToFirst())
    {
      long l = localCursor.getLong(0);
      paramString = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, l);
      return paramContext.getContentResolver().delete(paramString, null, null) == 1;
    }
    return new File(paramString).delete();
  }
  
  public static ArrayList<String> getAllImagePathsByFolder(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ((File)localObject).list();
    ArrayList localArrayList = new ArrayList();
    int i;
    if ((localObject != null) && (localObject.length > 0)) {
      i = localObject.length - 1;
    }
    for (;;)
    {
      if (i < 0) {
        return localArrayList;
      }
      if (isImage(localObject[i])) {
        localArrayList.add(paramString + File.separator + localObject[i]);
      }
      i -= 1;
    }
  }
  
  public static String getFolderByFileName(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.contains("/"));
    return paramString.substring(0, paramString.lastIndexOf(File.separator));
  }
  
  public static boolean isImage(String paramString)
  {
    return (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"));
  }
  
  public static List<GalleryEntity> queryGallery(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "bucket_id", "bucket_display_name", "COUNT(1) AS count" }, "0==0) GROUP BY (bucket_id", null, "date_added");
    if (paramContext.moveToFirst())
    {
      int i = paramContext.getColumnIndex("_id");
      int j = paramContext.getColumnIndex("_data");
      int k = paramContext.getColumnIndex("bucket_id");
      int m = paramContext.getColumnIndex("bucket_display_name");
      int n = paramContext.getColumnIndex("count");
      do
      {
        int i1 = paramContext.getInt(i);
        String str1 = paramContext.getString(j);
        int i2 = paramContext.getInt(k);
        String str2 = paramContext.getString(m);
        int i3 = paramContext.getInt(n);
        GalleryEntity localGalleryEntity = new GalleryEntity();
        localGalleryEntity.setId(i1);
        localGalleryEntity.setPath(str1);
        localGalleryEntity.setGallery_id(i2);
        localGalleryEntity.setGallery_name(str2);
        localGalleryEntity.setCount(i3);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.contains("Camera")) && (str2.equals("Camera"))) {
          localArrayList.add(localGalleryEntity);
        }
      } while (paramContext.moveToNext());
    }
    if ((paramContext != null) && (!paramContext.isClosed())) {
      paramContext.close();
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\GalleryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */