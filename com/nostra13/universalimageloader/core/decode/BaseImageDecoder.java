package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder
  implements ImageDecoder
{
  protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
  protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
  protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
  protected static final String LOG_SABSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
  protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
  protected boolean loggingEnabled;
  
  public BaseImageDecoder() {}
  
  public BaseImageDecoder(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
  
  protected Bitmap considerExactScaleAndOrientaiton(Bitmap paramBitmap, ImageDecodingInfo paramImageDecodingInfo, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize1;
    ImageSize localImageSize2;
    ViewScaleType localViewScaleType;
    if ((localImageScaleType == ImageScaleType.EXACTLY) || (localImageScaleType == ImageScaleType.EXACTLY_STRETCHED))
    {
      localImageSize1 = new ImageSize(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      localImageSize2 = paramImageDecodingInfo.getTargetSize();
      localViewScaleType = paramImageDecodingInfo.getViewScaleType();
      if (localImageScaleType != ImageScaleType.EXACTLY_STRETCHED) {
        break label257;
      }
    }
    label257:
    for (boolean bool = true;; bool = false)
    {
      float f = ImageSizeUtils.computeImageScale(localImageSize1, localImageSize2, localViewScaleType, bool);
      if (Float.compare(f, 1.0F) != 0)
      {
        localMatrix.setScale(f, f);
        if (this.loggingEnabled) {
          L.i("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] { localImageSize1, localImageSize1.scale(f), Float.valueOf(f), paramImageDecodingInfo.getImageKey() });
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.loggingEnabled) {
          L.i("Flip image horizontally [%s]", new Object[] { paramImageDecodingInfo.getImageKey() });
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.loggingEnabled) {
          L.i("Rotate image on %1$d° [%2$s]", new Object[] { Integer.valueOf(paramInt), paramImageDecodingInfo.getImageKey() });
        }
      }
      paramImageDecodingInfo = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (paramImageDecodingInfo != paramBitmap) {
        paramBitmap.recycle();
      }
      return paramImageDecodingInfo;
    }
  }
  
  public Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException
  {
    ImageFileInfo localImageFileInfo = defineImageSizeAndRotation(getImageStream(paramImageDecodingInfo), paramImageDecodingInfo.getImageUri());
    Object localObject = prepareDecodingOptions(localImageFileInfo.imageSize, paramImageDecodingInfo);
    localObject = decodeStream(getImageStream(paramImageDecodingInfo), (BitmapFactory.Options)localObject);
    if (localObject == null)
    {
      L.e("Image can't be decoded [%s]", new Object[] { paramImageDecodingInfo.getImageKey() });
      return (Bitmap)localObject;
    }
    return considerExactScaleAndOrientaiton((Bitmap)localObject, paramImageDecodingInfo, localImageFileInfo.exif.rotation, localImageFileInfo.exif.flipHorizontal);
  }
  
  protected Bitmap decodeStream(InputStream paramInputStream, BitmapFactory.Options paramOptions)
    throws IOException
  {
    try
    {
      paramOptions = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      return paramOptions;
    }
    finally
    {
      IoUtils.closeSilently(paramInputStream);
    }
  }
  
  protected ExifInfo defineExifOrientation(String paramString1, String paramString2)
  {
    j = 0;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    bool5 = false;
    bool1 = bool5;
    i = j;
    if ("image/jpeg".equalsIgnoreCase(paramString2))
    {
      bool1 = bool5;
      i = j;
      if (ImageDownloader.Scheme.ofUri(paramString1) != ImageDownloader.Scheme.FILE) {}
    }
    for (;;)
    {
      try
      {
        i = new ExifInterface(ImageDownloader.Scheme.FILE.crop(paramString1)).getAttributeInt("Orientation", 1);
        bool1 = bool6;
        switch (i)
        {
        default: 
          i = j;
          bool1 = bool5;
        }
      }
      catch (IOException paramString2)
      {
        L.w("Can't read EXIF tags from file [%s]", new Object[] { paramString1 });
        bool1 = bool5;
        i = j;
        continue;
      }
      return new ExifInfo(i, bool1);
      bool1 = true;
      i = 0;
      continue;
      bool2 = true;
      i = 90;
      bool1 = bool2;
      continue;
      bool3 = true;
      i = 180;
      bool1 = bool3;
      continue;
      bool4 = true;
      i = 270;
      bool1 = bool4;
    }
  }
  
  protected ImageFileInfo defineImageSizeAndRotation(InputStream paramInputStream, String paramString)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    for (;;)
    {
      try
      {
        BitmapFactory.decodeStream(paramInputStream, null, localOptions);
        IoUtils.closeSilently(paramInputStream);
        if (Build.VERSION.SDK_INT >= 5)
        {
          paramInputStream = defineExifOrientation(paramString, localOptions.outMimeType);
          return new ImageFileInfo(new ImageSize(localOptions.outWidth, localOptions.outHeight, paramInputStream.rotation), paramInputStream);
        }
      }
      finally
      {
        IoUtils.closeSilently(paramInputStream);
      }
      paramInputStream = new ExifInfo();
    }
  }
  
  protected InputStream getImageStream(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException
  {
    return paramImageDecodingInfo.getDownloader().getStream(paramImageDecodingInfo.getImageUri(), paramImageDecodingInfo.getExtraForDownloader());
  }
  
  protected BitmapFactory.Options prepareDecodingOptions(ImageSize paramImageSize, ImageDecodingInfo paramImageDecodingInfo)
  {
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize = paramImageDecodingInfo.getTargetSize();
    int i = 1;
    if (localImageScaleType != ImageScaleType.NONE) {
      if (localImageScaleType != ImageScaleType.IN_SAMPLE_POWER_OF_2) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      int j = ImageSizeUtils.computeImageSampleSize(paramImageSize, localImageSize, paramImageDecodingInfo.getViewScaleType(), bool);
      i = j;
      if (this.loggingEnabled)
      {
        L.i("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] { paramImageSize, paramImageSize.scaleDown(j), Integer.valueOf(j), paramImageDecodingInfo.getImageKey() });
        i = j;
      }
      paramImageSize = paramImageDecodingInfo.getDecodingOptions();
      paramImageSize.inSampleSize = i;
      return paramImageSize;
    }
  }
  
  public void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
  
  protected static class ExifInfo
  {
    final boolean flipHorizontal;
    final int rotation;
    
    ExifInfo()
    {
      this.rotation = 0;
      this.flipHorizontal = false;
    }
    
    ExifInfo(int paramInt, boolean paramBoolean)
    {
      this.rotation = paramInt;
      this.flipHorizontal = paramBoolean;
    }
  }
  
  protected static class ImageFileInfo
  {
    final BaseImageDecoder.ExifInfo exif;
    final ImageSize imageSize;
    
    ImageFileInfo(ImageSize paramImageSize, BaseImageDecoder.ExifInfo paramExifInfo)
    {
      this.imageSize = paramImageSize;
      this.exif = paramExifInfo;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\nostra13\universalimageloader\core\decode\BaseImageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */