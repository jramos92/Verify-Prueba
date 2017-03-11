package com.veryfit.multi.camera;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class CameraUtil
{
  public static final int MEDIA_TYPE_IMAGE = 1;
  public static final int MEDIA_TYPE_VIDEO = 2;
  private static final String TAG = CameraUtil.class.getSimpleName();
  private static MediaScannerConnection sMediaScannerConnection;
  
  public static void captureImage(Activity paramActivity, Uri paramUri, int paramInt)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.putExtra("output", paramUri);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void cropImage(Activity paramActivity, Uri paramUri1, Uri paramUri2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramUri1 == null) {
      return;
    }
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramUri1, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", paramInt2);
    localIntent.putExtra("aspectY", paramInt3);
    localIntent.putExtra("outputX", paramInt4);
    localIntent.putExtra("outputY", paramInt5);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("scaleUpIfNeeded", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", paramUri2);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", false);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  public static String getImagePathFromUri(Context paramContext, Uri paramUri)
  {
    return getImagePathFromUriSimple(paramContext, paramUri);
  }
  
  private static String getImagePathFromUriSimple(Context paramContext, Uri paramUri)
  {
    paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
    int i = paramContext.getColumnIndexOrThrow("_data");
    paramContext.moveToFirst();
    return paramContext.getString(i);
  }
  
  private static File getOutputMediaFile(Context paramContext, int paramInt)
  {
    paramContext = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), paramContext.getPackageName());
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      Log.e(TAG, "failed to create directory");
    }
    String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    if (paramInt == 1) {
      return new File(paramContext.getPath() + File.separator + "IMG_" + str + ".jpg");
    }
    if (paramInt == 2) {
      return new File(paramContext.getPath() + File.separator + "VID_" + str + ".mp4");
    }
    return null;
  }
  
  public static Uri getOutputMediaFileUri(Context paramContext, int paramInt)
  {
    paramContext = getOutputMediaFile(paramContext, paramInt);
    if (paramContext == null) {
      return null;
    }
    return Uri.fromFile(paramContext);
  }
  
  public static Uri isImageFileInMedia(Context paramContext, String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    paramString = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_display_name='" + paramString.getName() + "'", null, null);
    paramContext = null;
    if (paramString != null)
    {
      int i = paramString.getCount();
      paramContext = null;
      if (i > 0)
      {
        paramString.moveToLast();
        long l = paramString.getLong(0);
        paramContext = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, l);
      }
    }
    return paramContext;
  }
  
  @Deprecated
  public static void pickImageCrop(Activity paramActivity, Uri paramUri, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", paramInt2);
    localIntent.putExtra("aspectY", paramInt3);
    localIntent.putExtra("outputX", paramInt4);
    localIntent.putExtra("outputY", paramInt5);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("scaleUpIfNeeded", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", paramUri);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", false);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  public static void pickImageSimple(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), paramInt);
  }
  
  public static abstract interface ScannerResult
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\CameraUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */