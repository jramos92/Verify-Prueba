package com.veryfit.multi.photowall;

import android.content.Context;
import com.veryfit.multi.camera.GalleryEntity;
import com.veryfit.multi.camera.GalleryUtil;
import com.veryfit.multi.util.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Images
{
  public static List<String> mCameraImgs = null;
  public static List<String> mGalleryImgs;
  public static List<String> mImgs = null;
  
  static
  {
    mGalleryImgs = null;
  }
  
  public static List<String> getCameraImages(Context paramContext)
  {
    if (mCameraImgs != null)
    {
      mCameraImgs.clear();
      mCameraImgs = null;
    }
    mCameraImgs = new ArrayList();
    paramContext = GalleryUtil.queryGallery(paramContext).iterator();
    for (;;)
    {
      if (!paramContext.hasNext())
      {
        if ((mCameraImgs != null) && (mCameraImgs.size() > 0)) {
          Collections.sort(mCameraImgs, Collections.reverseOrder());
        }
        return mCameraImgs;
      }
      Object localObject = (GalleryEntity)paramContext.next();
      if (((GalleryEntity)localObject).getPath().contains("Camera"))
      {
        localObject = GalleryUtil.getAllImagePathsByFolder(GalleryUtil.getFolderByFileName(((GalleryEntity)localObject).getPath()));
        if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
          mCameraImgs.addAll((Collection)localObject);
        }
      }
    }
  }
  
  public static List<String> getGalleryImages(Context paramContext)
  {
    if (mGalleryImgs != null)
    {
      mGalleryImgs.clear();
      mGalleryImgs = null;
    }
    mGalleryImgs = new ArrayList();
    paramContext = GalleryUtil.queryGallery(paramContext).iterator();
    for (;;)
    {
      if (!paramContext.hasNext())
      {
        if ((mGalleryImgs != null) && (mGalleryImgs.size() > 0)) {
          Collections.sort(mGalleryImgs, Collections.reverseOrder());
        }
        return mGalleryImgs;
      }
      ArrayList localArrayList = GalleryUtil.getAllImagePathsByFolder(GalleryUtil.getFolderByFileName(((GalleryEntity)paramContext.next()).getPath()));
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        mGalleryImgs.addAll(localArrayList);
      }
    }
  }
  
  public static List<String> getImages()
  {
    if (mCameraImgs != null) {
      mCameraImgs = null;
    }
    File localFile = new File(Constant.imageDir);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    mCameraImgs = GalleryUtil.getAllImagePathsByFolder(Constant.imageDir);
    if ((mCameraImgs != null) && (mCameraImgs.size() > 0)) {
      Collections.sort(mCameraImgs, Collections.reverseOrder());
    }
    return mCameraImgs;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\photowall\Images.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */